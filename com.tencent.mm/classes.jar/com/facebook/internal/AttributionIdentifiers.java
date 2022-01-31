package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

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
    AppMethodBeat.i(72243);
    TAG = AttributionIdentifiers.class.getCanonicalName();
    AppMethodBeat.o(72243);
  }
  
  private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers paramAttributionIdentifiers)
  {
    AppMethodBeat.i(72241);
    paramAttributionIdentifiers.fetchTime = System.currentTimeMillis();
    recentlyFetchedIdentifiers = paramAttributionIdentifiers;
    AppMethodBeat.o(72241);
    return paramAttributionIdentifiers;
  }
  
  private static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AppMethodBeat.i(72237);
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
    AppMethodBeat.o(72237);
    return localObject;
  }
  
  private static AttributionIdentifiers getAndroidIdViaReflection(Context paramContext)
  {
    AppMethodBeat.i(72238);
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        paramContext = new FacebookException("getAndroidId cannot be called on the main thread.");
        AppMethodBeat.o(72238);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Utility.logd("android_id", paramContext);
      AppMethodBeat.o(72238);
      return null;
    }
    Object localObject = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
    if (localObject == null)
    {
      AppMethodBeat.o(72238);
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
      AppMethodBeat.o(72238);
      return null;
    }
    localObject = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
    if (localObject == null)
    {
      AppMethodBeat.o(72238);
      return null;
    }
    paramContext = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(72238);
      return null;
    }
    localObject = Utility.getMethodQuietly(paramContext.getClass(), "getId", new Class[0]);
    Method localMethod = Utility.getMethodQuietly(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
    if ((localObject == null) || (localMethod == null))
    {
      AppMethodBeat.o(72238);
      return null;
    }
    AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
    localAttributionIdentifiers.androidAdvertiserId = ((String)Utility.invokeMethodQuietly(paramContext, (Method)localObject, new Object[0]));
    localAttributionIdentifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0])).booleanValue();
    AppMethodBeat.o(72238);
    return localAttributionIdentifiers;
  }
  
  private static AttributionIdentifiers getAndroidIdViaService(Context paramContext)
  {
    AppMethodBeat.i(72239);
    AttributionIdentifiers.GoogleAdServiceConnection localGoogleAdServiceConnection = new AttributionIdentifiers.GoogleAdServiceConnection(null);
    Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
    ((Intent)localObject1).setPackage("com.google.android.gms");
    if (paramContext.bindService((Intent)localObject1, localGoogleAdServiceConnection, 1)) {}
    try
    {
      localObject1 = new AttributionIdentifiers.GoogleAdInfo(localGoogleAdServiceConnection.getBinder());
      AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
      localAttributionIdentifiers.androidAdvertiserId = ((AttributionIdentifiers.GoogleAdInfo)localObject1).getAdvertiserId();
      localAttributionIdentifiers.limitTracking = ((AttributionIdentifiers.GoogleAdInfo)localObject1).isTrackingLimited();
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
      AppMethodBeat.o(72239);
    }
  }
  
  /* Error */
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 96	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: pop
    //   9: invokestatic 99	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   12: pop
    //   13: getstatic 77	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   16: ifnull +31 -> 47
    //   19: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   22: getstatic 77	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   25: getfield 75	com/facebook/internal/AttributionIdentifiers:fetchTime	J
    //   28: lsub
    //   29: ldc2_w 27
    //   32: lcmp
    //   33: ifge +14 -> 47
    //   36: getstatic 77	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   39: astore_0
    //   40: ldc 199
    //   42: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: areturn
    //   47: aload_0
    //   48: invokestatic 201	com/facebook/internal/AttributionIdentifiers:getAndroidId	(Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
    //   51: astore 5
    //   53: aload_0
    //   54: invokevirtual 205	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   57: ldc 18
    //   59: iconst_0
    //   60: invokevirtual 211	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   63: ifnull +46 -> 109
    //   66: ldc 213
    //   68: invokestatic 219	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   71: astore 4
    //   73: aload_0
    //   74: invokestatic 223	com/facebook/internal/AttributionIdentifiers:getInstallerPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +10 -> 91
    //   84: aload 5
    //   86: aload 6
    //   88: putfield 225	com/facebook/internal/AttributionIdentifiers:androidInstallerPackage	Ljava/lang/String;
    //   91: aload 4
    //   93: ifnonnull +39 -> 132
    //   96: aload 5
    //   98: invokestatic 227	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   101: astore_0
    //   102: ldc 199
    //   104: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: aload_0
    //   110: invokevirtual 205	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   113: ldc 21
    //   115: iconst_0
    //   116: invokevirtual 211	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   119: ifnull +314 -> 433
    //   122: ldc 229
    //   124: invokestatic 219	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   127: astore 4
    //   129: goto -56 -> 73
    //   132: aload_0
    //   133: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   136: aload 4
    //   138: iconst_3
    //   139: anewarray 151	java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: ldc 15
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: ldc 12
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: ldc 31
    //   156: aastore
    //   157: aconst_null
    //   158: aconst_null
    //   159: aconst_null
    //   160: invokevirtual 239	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   163: astore 4
    //   165: aload 4
    //   167: ifnull +16 -> 183
    //   170: aload 4
    //   172: astore_0
    //   173: aload 4
    //   175: invokeinterface 244 1 0
    //   180: ifne +33 -> 213
    //   183: aload 4
    //   185: astore_0
    //   186: aload 5
    //   188: invokestatic 227	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   191: astore 5
    //   193: aload 4
    //   195: ifnull +10 -> 205
    //   198: aload 4
    //   200: invokeinterface 247 1 0
    //   205: ldc 199
    //   207: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload 5
    //   212: areturn
    //   213: aload 4
    //   215: astore_0
    //   216: aload 4
    //   218: ldc 15
    //   220: invokeinterface 251 2 0
    //   225: istore_1
    //   226: aload 4
    //   228: astore_0
    //   229: aload 4
    //   231: ldc 12
    //   233: invokeinterface 251 2 0
    //   238: istore_2
    //   239: aload 4
    //   241: astore_0
    //   242: aload 4
    //   244: ldc 31
    //   246: invokeinterface 251 2 0
    //   251: istore_3
    //   252: aload 4
    //   254: astore_0
    //   255: aload 5
    //   257: aload 4
    //   259: iload_1
    //   260: invokeinterface 255 2 0
    //   265: putfield 257	com/facebook/internal/AttributionIdentifiers:attributionId	Ljava/lang/String;
    //   268: iload_2
    //   269: ifle +53 -> 322
    //   272: iload_3
    //   273: ifle +49 -> 322
    //   276: aload 4
    //   278: astore_0
    //   279: aload 5
    //   281: invokevirtual 260	com/facebook/internal/AttributionIdentifiers:getAndroidAdvertiserId	()Ljava/lang/String;
    //   284: ifnonnull +38 -> 322
    //   287: aload 4
    //   289: astore_0
    //   290: aload 5
    //   292: aload 4
    //   294: iload_2
    //   295: invokeinterface 255 2 0
    //   300: putfield 153	com/facebook/internal/AttributionIdentifiers:androidAdvertiserId	Ljava/lang/String;
    //   303: aload 4
    //   305: astore_0
    //   306: aload 5
    //   308: aload 4
    //   310: iload_3
    //   311: invokeinterface 255 2 0
    //   316: invokestatic 264	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   319: putfield 161	com/facebook/internal/AttributionIdentifiers:limitTracking	Z
    //   322: aload 4
    //   324: ifnull +10 -> 334
    //   327: aload 4
    //   329: invokeinterface 247 1 0
    //   334: aload 5
    //   336: invokestatic 227	com/facebook/internal/AttributionIdentifiers:cacheAndReturnIdentifiers	(Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
    //   339: astore_0
    //   340: ldc 199
    //   342: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_0
    //   346: areturn
    //   347: astore 5
    //   349: aconst_null
    //   350: astore 4
    //   352: aload 4
    //   354: astore_0
    //   355: getstatic 57	com/facebook/internal/AttributionIdentifiers:TAG	Ljava/lang/String;
    //   358: new 266	java/lang/StringBuilder
    //   361: dup
    //   362: ldc_w 268
    //   365: invokespecial 269	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload 5
    //   370: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   373: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 280	com/facebook/internal/Utility:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload 4
    //   384: ifnull +10 -> 394
    //   387: aload 4
    //   389: invokeinterface 247 1 0
    //   394: ldc 199
    //   396: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aconst_null
    //   400: areturn
    //   401: astore 4
    //   403: aconst_null
    //   404: astore_0
    //   405: aload_0
    //   406: ifnull +9 -> 415
    //   409: aload_0
    //   410: invokeinterface 247 1 0
    //   415: ldc 199
    //   417: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aload 4
    //   422: athrow
    //   423: astore 4
    //   425: goto -20 -> 405
    //   428: astore 5
    //   430: goto -78 -> 352
    //   433: aconst_null
    //   434: astore 4
    //   436: goto -363 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramContext	Context
    //   225	35	1	i	int
    //   238	57	2	j	int
    //   251	60	3	k	int
    //   71	317	4	localObject1	Object
    //   401	20	4	localObject2	Object
    //   423	1	4	localObject3	Object
    //   434	1	4	localObject4	Object
    //   51	284	5	localAttributionIdentifiers	AttributionIdentifiers
    //   347	22	5	localException1	Exception
    //   428	1	5	localException2	Exception
    //   77	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   53	73	347	java/lang/Exception
    //   73	79	347	java/lang/Exception
    //   84	91	347	java/lang/Exception
    //   96	102	347	java/lang/Exception
    //   109	129	347	java/lang/Exception
    //   132	165	347	java/lang/Exception
    //   53	73	401	finally
    //   73	79	401	finally
    //   84	91	401	finally
    //   96	102	401	finally
    //   109	129	401	finally
    //   132	165	401	finally
    //   173	183	423	finally
    //   186	193	423	finally
    //   216	226	423	finally
    //   229	239	423	finally
    //   242	252	423	finally
    //   255	268	423	finally
    //   279	287	423	finally
    //   290	303	423	finally
    //   306	322	423	finally
    //   355	382	423	finally
    //   173	183	428	java/lang/Exception
    //   186	193	428	java/lang/Exception
    //   216	226	428	java/lang/Exception
    //   229	239	428	java/lang/Exception
    //   242	252	428	java/lang/Exception
    //   255	268	428	java/lang/Exception
    //   279	287	428	java/lang/Exception
    //   290	303	428	java/lang/Exception
    //   306	322	428	java/lang/Exception
  }
  
  private static String getInstallerPackageName(Context paramContext)
  {
    AppMethodBeat.i(72242);
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null)
    {
      paramContext = localPackageManager.getInstallerPackageName(paramContext.getPackageName());
      AppMethodBeat.o(72242);
      return paramContext;
    }
    AppMethodBeat.o(72242);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers
 * JD-Core Version:    0.7.0.1
 */