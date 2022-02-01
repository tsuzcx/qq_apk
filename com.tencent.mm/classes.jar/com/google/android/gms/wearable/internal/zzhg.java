package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public final class zzhg
  extends GmsClient<zzep>
{
  private final ExecutorService zzew;
  private final zzer<Object> zzex;
  private final zzer<Object> zzey;
  private final zzer<ChannelApi.ChannelListener> zzez;
  private final zzer<DataApi.DataListener> zzfa;
  private final zzer<MessageApi.MessageListener> zzfb;
  private final zzer<Object> zzfc;
  private final zzer<Object> zzfd;
  private final zzer<CapabilityApi.CapabilityListener> zzfe;
  private final zzhp zzff;
  
  public zzhg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings, Executors.newCachedThreadPool(), zzhp.zza(paramContext));
    AppMethodBeat.i(101378);
    AppMethodBeat.o(101378);
  }
  
  @VisibleForTesting
  private zzhg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, ExecutorService paramExecutorService, zzhp paramzzhp)
  {
    super(paramContext, paramLooper, 14, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    AppMethodBeat.i(101379);
    this.zzex = new zzer();
    this.zzey = new zzer();
    this.zzez = new zzer();
    this.zzfa = new zzer();
    this.zzfb = new zzer();
    this.zzfc = new zzer();
    this.zzfd = new zzer();
    this.zzfe = new zzer();
    this.zzew = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    this.zzff = paramzzhp;
    AppMethodBeat.o(101379);
  }
  
  public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    int i = 0;
    AppMethodBeat.i(101383);
    if (!requiresGooglePlayServices()) {
      try
      {
        Object localObject = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("com.google.android.wearable.api.version", 0);
        }
        if (i < GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
          int j = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
          new StringBuilder(86).append("The Wear OS app is out of date. Requires API version ").append(j).append(" but found ").append(i);
          Context localContext1 = getContext();
          Context localContext2 = getContext();
          localObject = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
          if (localContext2.getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {}
          for (;;)
          {
            triggerNotAvailable(paramConnectionProgressReportCallbacks, 6, PendingIntent.getActivity(localContext1, 0, (Intent)localObject, 0));
            AppMethodBeat.o(101383);
            return;
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
          }
        }
        super.connect(paramConnectionProgressReportCallbacks);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        triggerNotAvailable(paramConnectionProgressReportCallbacks, 16, null);
        AppMethodBeat.o(101383);
        return;
      }
    }
    AppMethodBeat.o(101383);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  public final String getStartServicePackage()
  {
    AppMethodBeat.i(101380);
    if (this.zzff.zze("com.google.android.wearable.app.cn"))
    {
      AppMethodBeat.o(101380);
      return "com.google.android.wearable.app.cn";
    }
    AppMethodBeat.o(101380);
    return "com.google.android.gms";
  }
  
  public final void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(101382);
    if (Log.isLoggable("WearableClient", 2)) {
      new StringBuilder(41).append("onPostInitHandler: statusCode ").append(paramInt1);
    }
    if (paramInt1 == 0)
    {
      this.zzex.zza(paramIBinder);
      this.zzey.zza(paramIBinder);
      this.zzez.zza(paramIBinder);
      this.zzfa.zza(paramIBinder);
      this.zzfb.zza(paramIBinder);
      this.zzfc.zza(paramIBinder);
      this.zzfd.zza(paramIBinder);
      this.zzfe.zza(paramIBinder);
    }
    super.onPostInitHandler(paramInt1, paramIBinder, paramBundle, paramInt2);
    AppMethodBeat.o(101382);
  }
  
  public final boolean requiresGooglePlayServices()
  {
    AppMethodBeat.i(101381);
    if (!this.zzff.zze("com.google.android.wearable.app.cn"))
    {
      AppMethodBeat.o(101381);
      return true;
    }
    AppMethodBeat.o(101381);
    return false;
  }
  
  public final void zza(BaseImplementation.ResultHolder<DataApi.GetFdForAssetResult> paramResultHolder, Asset paramAsset)
  {
    AppMethodBeat.i(101385);
    ((zzep)getService()).zza(new zzgx(paramResultHolder), paramAsset);
    AppMethodBeat.o(101385);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    AppMethodBeat.i(101394);
    this.zzfe.zza(this, paramResultHolder, paramCapabilityListener);
    AppMethodBeat.o(101394);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, CapabilityApi.CapabilityListener paramCapabilityListener, ListenerHolder<CapabilityApi.CapabilityListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101390);
    this.zzfe.zza(this, paramResultHolder, paramCapabilityListener, zzhk.zzd(paramListenerHolder, paramArrayOfIntentFilter));
    AppMethodBeat.o(101390);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, ChannelApi.ChannelListener paramChannelListener, ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, @Nullable String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101391);
    if (paramString == null)
    {
      this.zzez.zza(this, paramResultHolder, paramChannelListener, zzhk.zzc(paramListenerHolder, paramArrayOfIntentFilter));
      AppMethodBeat.o(101391);
      return;
    }
    paramChannelListener = new zzgc(paramString, paramChannelListener);
    this.zzez.zza(this, paramResultHolder, paramChannelListener, zzhk.zza(paramListenerHolder, paramString, paramArrayOfIntentFilter));
    AppMethodBeat.o(101391);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, ChannelApi.ChannelListener paramChannelListener, String paramString)
  {
    AppMethodBeat.i(101395);
    if (paramString == null)
    {
      this.zzez.zza(this, paramResultHolder, paramChannelListener);
      AppMethodBeat.o(101395);
      return;
    }
    paramChannelListener = new zzgc(paramString, paramChannelListener);
    this.zzez.zza(this, paramResultHolder, paramChannelListener);
    AppMethodBeat.o(101395);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, DataApi.DataListener paramDataListener)
  {
    AppMethodBeat.i(101392);
    this.zzfa.zza(this, paramResultHolder, paramDataListener);
    AppMethodBeat.o(101392);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, DataApi.DataListener paramDataListener, ListenerHolder<DataApi.DataListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101388);
    this.zzfa.zza(this, paramResultHolder, paramDataListener, zzhk.zza(paramListenerHolder, paramArrayOfIntentFilter));
    AppMethodBeat.o(101388);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, MessageApi.MessageListener paramMessageListener)
  {
    AppMethodBeat.i(101393);
    this.zzfb.zza(this, paramResultHolder, paramMessageListener);
    AppMethodBeat.o(101393);
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, MessageApi.MessageListener paramMessageListener, ListenerHolder<MessageApi.MessageListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101389);
    this.zzfb.zza(this, paramResultHolder, paramMessageListener, zzhk.zzb(paramListenerHolder, paramArrayOfIntentFilter));
    AppMethodBeat.o(101389);
  }
  
  public final void zza(BaseImplementation.ResultHolder<DataApi.DataItemResult> paramResultHolder, PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(101384);
    Object localObject2 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Asset)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if ((((Asset)localObject1).getData() == null) && (((Asset)localObject1).getDigest() == null) && (((Asset)localObject1).getFd() == null) && (((Asset)localObject1).getUri() == null))
      {
        paramResultHolder = String.valueOf(paramPutDataRequest.getUri());
        paramPutDataRequest = String.valueOf(localObject1);
        paramResultHolder = new IllegalArgumentException(String.valueOf(paramResultHolder).length() + 33 + String.valueOf(paramPutDataRequest).length() + "Put for " + paramResultHolder + " contains invalid asset: " + paramPutDataRequest);
        AppMethodBeat.o(101384);
        throw paramResultHolder;
      }
    }
    localObject2 = PutDataRequest.zza(paramPutDataRequest.getUri());
    ((PutDataRequest)localObject2).setData(paramPutDataRequest.getData());
    if (paramPutDataRequest.isUrgent()) {
      ((PutDataRequest)localObject2).setUrgent();
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject3 = (Asset)localEntry.getValue();
      Object localObject4;
      if (((Asset)localObject3).getData() != null) {
        try
        {
          localObject4 = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3))
          {
            String str1 = String.valueOf(localObject3);
            String str2 = String.valueOf(localObject4[0]);
            String str3 = String.valueOf(localObject4[1]);
            new StringBuilder(String.valueOf(str1).length() + 61 + String.valueOf(str2).length() + String.valueOf(str3).length()).append("processAssets: replacing data with FD in asset: ").append(str1).append(" read:").append(str2).append(" write:").append(str3);
          }
          ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), Asset.createFromFd(localObject4[0]));
          localObject3 = new FutureTask(new zzhh(this, localObject4[1], ((Asset)localObject3).getData()));
          ((List)localObject1).add(localObject3);
          this.zzew.submit((Runnable)localObject3);
        }
        catch (IOException paramResultHolder)
        {
          paramPutDataRequest = String.valueOf(paramPutDataRequest);
          paramResultHolder = new IllegalStateException(String.valueOf(paramPutDataRequest).length() + 60 + "Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, paramResultHolder);
          AppMethodBeat.o(101384);
          throw paramResultHolder;
        }
      } else if (((Asset)localObject3).getUri() != null) {
        try
        {
          localObject4 = Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(((Asset)localObject3).getUri(), "r"));
          ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject4);
        }
        catch (FileNotFoundException paramPutDataRequest)
        {
          new zzhb(paramResultHolder, (List)localObject1).zza(new zzfu(4005, null));
          paramResultHolder = String.valueOf(((Asset)localObject3).getUri());
          new StringBuilder(String.valueOf(paramResultHolder).length() + 28).append("Couldn't resolve asset URI: ").append(paramResultHolder);
          AppMethodBeat.o(101384);
          return;
        }
      } else {
        ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject3);
      }
    }
    ((zzep)getService()).zza(new zzhb(paramResultHolder, (List)localObject1), (PutDataRequest)localObject2);
    AppMethodBeat.o(101384);
  }
  
  /* Error */
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, String paramString, Uri paramUri, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 510
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 87	com/google/android/gms/wearable/internal/zzhg:zzew	Ljava/util/concurrent/ExecutorService;
    //   10: astore 9
    //   12: aload_1
    //   13: invokestatic 83	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_2
    //   18: invokestatic 83	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_3
    //   23: invokestatic 83	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: lload 4
    //   29: lconst_0
    //   30: lcmp
    //   31: iflt +87 -> 118
    //   34: iconst_1
    //   35: istore 8
    //   37: iload 8
    //   39: ldc_w 512
    //   42: iconst_1
    //   43: anewarray 514	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: lload 4
    //   50: invokestatic 519	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aastore
    //   54: invokestatic 523	com/google/android/gms/common/internal/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   57: lload 6
    //   59: ldc2_w 524
    //   62: lcmp
    //   63: iflt +61 -> 124
    //   66: iconst_1
    //   67: istore 8
    //   69: iload 8
    //   71: ldc_w 527
    //   74: iconst_1
    //   75: anewarray 514	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: lload 6
    //   82: invokestatic 519	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 523	com/google/android/gms/common/internal/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   89: aload 9
    //   91: new 529	com/google/android/gms/wearable/internal/zzhj
    //   94: dup
    //   95: aload_0
    //   96: aload_3
    //   97: aload_1
    //   98: aload_2
    //   99: lload 4
    //   101: lload 6
    //   103: invokespecial 532	com/google/android/gms/wearable/internal/zzhj:<init>	(Lcom/google/android/gms/wearable/internal/zzhg;Landroid/net/Uri;Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;Ljava/lang/String;JJ)V
    //   106: invokeinterface 536 2 0
    //   111: ldc_w 510
    //   114: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: iconst_0
    //   119: istore 8
    //   121: goto -84 -> 37
    //   124: iconst_0
    //   125: istore 8
    //   127: goto -58 -> 69
    //   130: astore_2
    //   131: aload_1
    //   132: new 538	com/google/android/gms/common/api/Status
    //   135: dup
    //   136: bipush 8
    //   138: invokespecial 539	com/google/android/gms/common/api/Status:<init>	(I)V
    //   141: invokeinterface 545 2 0
    //   146: ldc_w 510
    //   149: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	zzhg
    //   0	154	1	paramResultHolder	BaseImplementation.ResultHolder<Status>
    //   0	154	2	paramString	String
    //   0	154	3	paramUri	Uri
    //   0	154	4	paramLong1	long
    //   0	154	6	paramLong2	long
    //   35	91	8	bool	boolean
    //   10	80	9	localExecutorService	ExecutorService
    // Exception table:
    //   from	to	target	type
    //   6	27	130	java/lang/RuntimeException
    //   37	57	130	java/lang/RuntimeException
    //   69	111	130	java/lang/RuntimeException
  }
  
  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, String paramString, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(101386);
    try
    {
      ExecutorService localExecutorService = this.zzew;
      Preconditions.checkNotNull(paramResultHolder);
      Preconditions.checkNotNull(paramString);
      Preconditions.checkNotNull(paramUri);
      localExecutorService.execute(new zzhi(this, paramUri, paramResultHolder, paramBoolean, paramString));
      AppMethodBeat.o(101386);
      return;
    }
    catch (RuntimeException paramString)
    {
      paramResultHolder.setFailedResult(new Status(8));
      AppMethodBeat.o(101386);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhg
 * JD-Core Version:    0.7.0.1
 */