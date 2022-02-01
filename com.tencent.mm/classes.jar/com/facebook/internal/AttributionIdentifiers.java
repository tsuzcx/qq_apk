package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers
{
  private static final String ANDROID_ID_COLUMN_NAME = "androidid";
  private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
  private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
  private static final int CONNECTION_RESULT_SUCCESS = 0;
  private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
  private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
  private static final String TAG;
  private static AttributionIdentifiers recentlyFetchedIdentifiers;
  private String androidAdvertiserId;
  private String androidInstallerPackage;
  private String attributionId;
  private long fetchTime;
  private boolean limitTracking;
  
  static
  {
    AppMethodBeat.i(17679);
    TAG = AttributionIdentifiers.class.getCanonicalName();
    AppMethodBeat.o(17679);
  }
  
  private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers paramAttributionIdentifiers)
  {
    AppMethodBeat.i(17677);
    paramAttributionIdentifiers.fetchTime = System.currentTimeMillis();
    recentlyFetchedIdentifiers = paramAttributionIdentifiers;
    AppMethodBeat.o(17677);
    return paramAttributionIdentifiers;
  }
  
  private static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AppMethodBeat.i(17673);
    AttributionIdentifiers localAttributionIdentifiers = getAndroidIdViaReflection(paramContext);
    Object localObject = localAttributionIdentifiers;
    if (localAttributionIdentifiers == null)
    {
      paramContext = getAndroidIdViaService(paramContext);
      localObject = paramContext;
      if (paramContext == null) {
        localObject = new AttributionIdentifiers();
      }
    }
    AppMethodBeat.o(17673);
    return localObject;
  }
  
  private static AttributionIdentifiers getAndroidIdViaReflection(Context paramContext)
  {
    AppMethodBeat.i(17674);
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        paramContext = new FacebookException("getAndroidId cannot be called on the main thread.");
        AppMethodBeat.o(17674);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Utility.logd("android_id", paramContext);
      AppMethodBeat.o(17674);
      return null;
    }
    Object localObject = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
    if (localObject == null)
    {
      AppMethodBeat.o(17674);
      return null;
    }
    localObject = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
    if ((localObject instanceof Integer))
    {
      int i = ((Integer)localObject).intValue();
      if (i == 0) {}
    }
    else
    {
      AppMethodBeat.o(17674);
      return null;
    }
    localObject = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
    if (localObject == null)
    {
      AppMethodBeat.o(17674);
      return null;
    }
    paramContext = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(17674);
      return null;
    }
    localObject = Utility.getMethodQuietly(paramContext.getClass(), "getId", new Class[0]);
    Method localMethod = Utility.getMethodQuietly(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
    if ((localObject == null) || (localMethod == null))
    {
      AppMethodBeat.o(17674);
      return null;
    }
    AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
    localAttributionIdentifiers.androidAdvertiserId = ((String)Utility.invokeMethodQuietly(paramContext, (Method)localObject, new Object[0]));
    localAttributionIdentifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0])).booleanValue();
    AppMethodBeat.o(17674);
    return localAttributionIdentifiers;
  }
  
  private static AttributionIdentifiers getAndroidIdViaService(Context paramContext)
  {
    AppMethodBeat.i(17675);
    GoogleAdServiceConnection localGoogleAdServiceConnection = new GoogleAdServiceConnection(null);
    Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
    ((Intent)localObject1).setPackage("com.google.android.gms");
    if (paramContext.bindService((Intent)localObject1, localGoogleAdServiceConnection, 1)) {}
    try
    {
      localObject1 = new GoogleAdInfo(localGoogleAdServiceConnection.getBinder());
      AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
      localAttributionIdentifiers.androidAdvertiserId = ((GoogleAdInfo)localObject1).getAdvertiserId();
      localAttributionIdentifiers.limitTracking = ((GoogleAdInfo)localObject1).isTrackingLimited();
      return localAttributionIdentifiers;
    }
    catch (Exception localException)
    {
      Utility.logd("android_id", localException);
      return null;
    }
    finally
    {
      paramContext.unbindService(localGoogleAdServiceConnection);
      AppMethodBeat.o(17675);
    }
  }
  
  /* Error */
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    // Byte code:
    //   0: sipush 17676
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 96	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   9: pop
    //   10: invokestatic 99	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   13: pop
    //   14: getstatic 79	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   17: ifnull +32 -> 49
    //   20: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   23: getstatic 79	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   26: getfield 77	com/facebook/internal/AttributionIdentifiers:fetchTime	J
    //   29: lsub
    //   30: ldc2_w 31
    //   33: lcmp
    //   34: ifge +15 -> 49
    //   37: getstatic 79	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   40: astore_0
    //   41: sipush 17676
    //   44: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: aload_0
    //   50: invokestatic 199	com/facebook/internal/AttributionIdentifiers:getAndroidId	(Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
    //   53: astore 5
    //   55: aload_0
    //   56: invokevirtual 203	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   59: ldc 22
    //   61: iconst_0
    //   62: invokevirtual 209	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   65: ifnull +47 -> 112
    //   68: ldc 211
    //   70: invokestatic 217	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   73: astore 4
    //   75: aload_0
    //   76: invokestatic 221	com/facebook/internal/AttributionIdentifiers:getInstallerPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: aload 6
    //   90: putfield 223	com/facebook/internal/AttributionIdentifiers:androidInstallerPackage	Ljava/lang/String;
    //   93: aload 4
    //   95: ifnonnull +40 -> 135
    //   98: aload 5
    //   100: invokestatic 225	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   103: astore_0
    //   104: sipush 17676
    //   107: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: aload_0
    //   113: invokevirtual 203	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   116: ldc 25
    //   118: iconst_0
    //   119: invokevirtual 209	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   122: ifnull +318 -> 440
    //   125: ldc 227
    //   127: invokestatic 217	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   130: astore 4
    //   132: goto -57 -> 75
    //   135: aload_0
    //   136: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   139: aload 4
    //   141: iconst_3
    //   142: anewarray 151	java/lang/String
    //   145: dup
    //   146: iconst_0
    //   147: ldc 19
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: ldc 16
    //   154: aastore
    //   155: dup
    //   156: iconst_2
    //   157: ldc 35
    //   159: aastore
    //   160: aconst_null
    //   161: aconst_null
    //   162: aconst_null
    //   163: invokevirtual 237	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 4
    //   168: aload 4
    //   170: ifnull +16 -> 186
    //   173: aload 4
    //   175: astore_0
    //   176: aload 4
    //   178: invokeinterface 242 1 0
    //   183: ifne +34 -> 217
    //   186: aload 4
    //   188: astore_0
    //   189: aload 5
    //   191: invokestatic 225	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   194: astore 5
    //   196: aload 4
    //   198: ifnull +10 -> 208
    //   201: aload 4
    //   203: invokeinterface 245 1 0
    //   208: sipush 17676
    //   211: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 5
    //   216: areturn
    //   217: aload 4
    //   219: astore_0
    //   220: aload 4
    //   222: ldc 19
    //   224: invokeinterface 249 2 0
    //   229: istore_1
    //   230: aload 4
    //   232: astore_0
    //   233: aload 4
    //   235: ldc 16
    //   237: invokeinterface 249 2 0
    //   242: istore_2
    //   243: aload 4
    //   245: astore_0
    //   246: aload 4
    //   248: ldc 35
    //   250: invokeinterface 249 2 0
    //   255: istore_3
    //   256: aload 4
    //   258: astore_0
    //   259: aload 5
    //   261: aload 4
    //   263: iload_1
    //   264: invokeinterface 253 2 0
    //   269: putfield 255	com/facebook/internal/AttributionIdentifiers:attributionId	Ljava/lang/String;
    //   272: iload_2
    //   273: ifle +53 -> 326
    //   276: iload_3
    //   277: ifle +49 -> 326
    //   280: aload 4
    //   282: astore_0
    //   283: aload 5
    //   285: invokevirtual 258	com/facebook/internal/AttributionIdentifiers:getAndroidAdvertiserId	()Ljava/lang/String;
    //   288: ifnonnull +38 -> 326
    //   291: aload 4
    //   293: astore_0
    //   294: aload 5
    //   296: aload 4
    //   298: iload_2
    //   299: invokeinterface 253 2 0
    //   304: putfield 153	com/facebook/internal/AttributionIdentifiers:androidAdvertiserId	Ljava/lang/String;
    //   307: aload 4
    //   309: astore_0
    //   310: aload 5
    //   312: aload 4
    //   314: iload_3
    //   315: invokeinterface 253 2 0
    //   320: invokestatic 262	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   323: putfield 161	com/facebook/internal/AttributionIdentifiers:limitTracking	Z
    //   326: aload 4
    //   328: ifnull +10 -> 338
    //   331: aload 4
    //   333: invokeinterface 245 1 0
    //   338: aload 5
    //   340: invokestatic 225	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   343: astore_0
    //   344: sipush 17676
    //   347: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_0
    //   351: areturn
    //   352: astore 5
    //   354: aconst_null
    //   355: astore 4
    //   357: aload 4
    //   359: astore_0
    //   360: getstatic 60	com/facebook/internal/AttributionIdentifiers:TAG	Ljava/lang/String;
    //   363: new 264	java/lang/StringBuilder
    //   366: dup
    //   367: ldc_w 266
    //   370: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: aload 5
    //   375: invokevirtual 270	java/lang/Exception:toString	()Ljava/lang/String;
    //   378: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 278	com/facebook/internal/Utility:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload 4
    //   389: ifnull +10 -> 399
    //   392: aload 4
    //   394: invokeinterface 245 1 0
    //   399: sipush 17676
    //   402: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aconst_null
    //   406: areturn
    //   407: astore 4
    //   409: aconst_null
    //   410: astore_0
    //   411: aload_0
    //   412: ifnull +9 -> 421
    //   415: aload_0
    //   416: invokeinterface 245 1 0
    //   421: sipush 17676
    //   424: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload 4
    //   429: athrow
    //   430: astore 4
    //   432: goto -21 -> 411
    //   435: astore 5
    //   437: goto -80 -> 357
    //   440: aconst_null
    //   441: astore 4
    //   443: goto -368 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramContext	Context
    //   229	35	1	i	int
    //   242	57	2	j	int
    //   255	60	3	k	int
    //   73	320	4	localObject1	Object
    //   407	21	4	localObject2	Object
    //   430	1	4	localObject3	Object
    //   441	1	4	localObject4	Object
    //   53	286	5	localAttributionIdentifiers	AttributionIdentifiers
    //   352	22	5	localException1	Exception
    //   435	1	5	localException2	Exception
    //   79	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   55	75	352	java/lang/Exception
    //   75	81	352	java/lang/Exception
    //   86	93	352	java/lang/Exception
    //   98	104	352	java/lang/Exception
    //   112	132	352	java/lang/Exception
    //   135	168	352	java/lang/Exception
    //   55	75	407	finally
    //   75	81	407	finally
    //   86	93	407	finally
    //   98	104	407	finally
    //   112	132	407	finally
    //   135	168	407	finally
    //   176	186	430	finally
    //   189	196	430	finally
    //   220	230	430	finally
    //   233	243	430	finally
    //   246	256	430	finally
    //   259	272	430	finally
    //   283	291	430	finally
    //   294	307	430	finally
    //   310	326	430	finally
    //   360	387	430	finally
    //   176	186	435	java/lang/Exception
    //   189	196	435	java/lang/Exception
    //   220	230	435	java/lang/Exception
    //   233	243	435	java/lang/Exception
    //   246	256	435	java/lang/Exception
    //   259	272	435	java/lang/Exception
    //   283	291	435	java/lang/Exception
    //   294	307	435	java/lang/Exception
    //   310	326	435	java/lang/Exception
  }
  
  private static String getInstallerPackageName(Context paramContext)
  {
    AppMethodBeat.i(17678);
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null)
    {
      paramContext = localPackageManager.getInstallerPackageName(paramContext.getPackageName());
      AppMethodBeat.o(17678);
      return paramContext;
    }
    AppMethodBeat.o(17678);
    return null;
  }
  
  public String getAndroidAdvertiserId()
  {
    return this.androidAdvertiserId;
  }
  
  public String getAndroidInstallerPackage()
  {
    return this.androidInstallerPackage;
  }
  
  public String getAttributionId()
  {
    return this.attributionId;
  }
  
  public boolean isTrackingLimited()
  {
    return this.limitTracking;
  }
  
  static final class GoogleAdInfo
    implements IInterface
  {
    private static final int FIRST_TRANSACTION_CODE = 1;
    private static final int SECOND_TRANSACTION_CODE = 2;
    private IBinder binder;
    
    GoogleAdInfo(IBinder paramIBinder)
    {
      this.binder = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return this.binder;
    }
    
    public final String getAdvertiserId()
    {
      AppMethodBeat.i(17668);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.binder.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(17668);
      }
    }
    
    /* Error */
    public final boolean isTrackingLimited()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: sipush 17669
      //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 40	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore_3
      //   12: invokestatic 40	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   15: astore 4
      //   17: aload_3
      //   18: ldc 42
      //   20: invokevirtual 46	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   23: aload_3
      //   24: iconst_1
      //   25: invokevirtual 69	android/os/Parcel:writeInt	(I)V
      //   28: aload_0
      //   29: getfield 23	com/facebook/internal/AttributionIdentifiers$GoogleAdInfo:binder	Landroid/os/IBinder;
      //   32: iconst_2
      //   33: aload_3
      //   34: aload 4
      //   36: iconst_0
      //   37: invokeinterface 52 5 0
      //   42: pop
      //   43: aload 4
      //   45: invokevirtual 55	android/os/Parcel:readException	()V
      //   48: aload 4
      //   50: invokevirtual 73	android/os/Parcel:readInt	()I
      //   53: istore_1
      //   54: iload_1
      //   55: ifeq +20 -> 75
      //   58: aload 4
      //   60: invokevirtual 61	android/os/Parcel:recycle	()V
      //   63: aload_3
      //   64: invokevirtual 61	android/os/Parcel:recycle	()V
      //   67: sipush 17669
      //   70: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   73: iload_2
      //   74: ireturn
      //   75: iconst_0
      //   76: istore_2
      //   77: goto -19 -> 58
      //   80: astore 5
      //   82: aload 4
      //   84: invokevirtual 61	android/os/Parcel:recycle	()V
      //   87: aload_3
      //   88: invokevirtual 61	android/os/Parcel:recycle	()V
      //   91: sipush 17669
      //   94: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aload 5
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	GoogleAdInfo
      //   53	2	1	i	int
      //   1	76	2	bool	boolean
      //   11	77	3	localParcel1	Parcel
      //   15	68	4	localParcel2	Parcel
      //   80	18	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   17	54	80	finally
    }
  }
  
  static final class GoogleAdServiceConnection
    implements ServiceConnection
  {
    private AtomicBoolean consumed;
    private final BlockingQueue<IBinder> queue;
    
    private GoogleAdServiceConnection()
    {
      AppMethodBeat.i(17670);
      this.consumed = new AtomicBoolean(false);
      this.queue = new LinkedBlockingDeque();
      AppMethodBeat.o(17670);
    }
    
    public final IBinder getBinder()
    {
      AppMethodBeat.i(17672);
      if (this.consumed.compareAndSet(true, true))
      {
        localObject = new IllegalStateException("Binder already consumed");
        AppMethodBeat.o(17672);
        throw ((Throwable)localObject);
      }
      Object localObject = (IBinder)this.queue.take();
      AppMethodBeat.o(17672);
      return localObject;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(17671);
      if (paramIBinder != null) {}
      try
      {
        this.queue.put(paramIBinder);
        AppMethodBeat.o(17671);
        return;
      }
      catch (InterruptedException paramComponentName)
      {
        AppMethodBeat.o(17671);
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers
 * JD-Core Version:    0.7.0.1
 */