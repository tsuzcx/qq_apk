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
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
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

public class zzcx
  extends zzl<zzbw>
{
  private final zzbx<Object> zzbUX = new zzbx();
  private final zzbx<Object> zzbUY = new zzbx();
  private final zzbx<ChannelApi.ChannelListener> zzbUZ = new zzbx();
  private final zzbx<DataApi.DataListener> zzbVa = new zzbx();
  private final zzbx<MessageApi.MessageListener> zzbVb = new zzbx();
  private final zzbx<NodeApi.NodeListener> zzbVc = new zzbx();
  private final zzbx<Object> zzbVd = new zzbx();
  private final zzbx<CapabilityApi.CapabilityListener> zzbVe = new zzbx();
  private final zzcz zzbVf;
  private final ExecutorService zzbtM;
  
  public zzcx(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg, Executors.newCachedThreadPool(), zzcz.zzck(paramContext));
  }
  
  zzcx(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg, ExecutorService paramExecutorService, zzcz paramzzcz)
  {
    super(paramContext, paramLooper, 14, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzbtM = ((ExecutorService)com.google.android.gms.common.internal.zzac.zzw(paramExecutorService));
    this.zzbVf = paramzzcz;
  }
  
  private FutureTask<Boolean> zza(ParcelFileDescriptor paramParcelFileDescriptor, byte[] paramArrayOfByte)
  {
    return new FutureTask(new zzcx.1(this, paramParcelFileDescriptor, paramArrayOfByte));
  }
  
  private Runnable zzb(zzaad.zzb<Status> paramzzb, String paramString, Uri paramUri, long paramLong1, long paramLong2)
  {
    com.google.android.gms.common.internal.zzac.zzw(paramzzb);
    com.google.android.gms.common.internal.zzac.zzw(paramString);
    com.google.android.gms.common.internal.zzac.zzw(paramUri);
    if (paramLong1 >= 0L)
    {
      bool = true;
      com.google.android.gms.common.internal.zzac.zzb(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 < -1L) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzac.zzb(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      return new zzcx.3(this, paramUri, paramzzb, paramString, paramLong1, paramLong2);
      bool = false;
      break;
    }
  }
  
  private Runnable zzb(zzaad.zzb<Status> paramzzb, String paramString, Uri paramUri, boolean paramBoolean)
  {
    com.google.android.gms.common.internal.zzac.zzw(paramzzb);
    com.google.android.gms.common.internal.zzac.zzw(paramString);
    com.google.android.gms.common.internal.zzac.zzw(paramUri);
    return new zzcx.2(this, paramUri, paramzzb, paramBoolean, paramString);
  }
  
  public static Intent zzcj(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
    if (paramContext.getPackageManager().resolveActivity(localIntent, 65536) != null) {
      return localIntent;
    }
    return new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      new StringBuilder(41).append("onPostInitHandler: statusCode ").append(paramInt1);
    }
    if (paramInt1 == 0)
    {
      this.zzbUX.zzfE(paramIBinder);
      this.zzbUY.zzfE(paramIBinder);
      this.zzbUZ.zzfE(paramIBinder);
      this.zzbVa.zzfE(paramIBinder);
      this.zzbVb.zzfE(paramIBinder);
      this.zzbVc.zzfE(paramIBinder);
      this.zzbVd.zzfE(paramIBinder);
      this.zzbVe.zzfE(paramIBinder);
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(zzf.zzf paramzzf)
  {
    int i = 0;
    if (!zzvh()) {
      try
      {
        Bundle localBundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        if (localBundle != null) {
          i = localBundle.getInt("com.google.android.wearable.api.version", 0);
        }
        if (i < zze.GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
          int j = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
          new StringBuilder(80).append("Android Wear out of date. Requires API version ").append(j).append(" but found ").append(i);
          zza(paramzzf, 6, PendingIntent.getActivity(getContext(), 0, zzcj(getContext()), 0));
          return;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        zza(paramzzf, 16, null);
        return;
      }
    }
    super.zza(paramzzf);
  }
  
  public void zza(zzaad.zzb<DataApi.DataItemResult> paramzzb, Uri paramUri)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzk(paramzzb), paramUri);
  }
  
  public void zza(zzaad.zzb<DataItemBuffer> paramzzb, Uri paramUri, int paramInt)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzl(paramzzb), paramUri, paramInt);
  }
  
  public void zza(zzaad.zzb<DataApi.GetFdForAssetResult> paramzzb, Asset paramAsset)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzm(paramzzb), paramAsset);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    this.zzbVe.zza(this, paramzzb, paramCapabilityListener);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, CapabilityApi.CapabilityListener paramCapabilityListener, zzabh<CapabilityApi.CapabilityListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.zzbVe.zza(this, paramzzb, paramCapabilityListener, zzcy.zze(paramzzabh, paramArrayOfIntentFilter));
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, ChannelApi.ChannelListener paramChannelListener, zzabh<ChannelApi.ChannelListener> paramzzabh, String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    if (paramString == null)
    {
      this.zzbUZ.zza(this, paramzzb, paramChannelListener, zzcy.zzd(paramzzabh, paramArrayOfIntentFilter));
      return;
    }
    paramChannelListener = new zzcq(paramString, paramChannelListener);
    this.zzbUZ.zza(this, paramzzb, paramChannelListener, zzcy.zza(paramzzabh, paramString, paramArrayOfIntentFilter));
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, ChannelApi.ChannelListener paramChannelListener, String paramString)
  {
    if (paramString == null)
    {
      this.zzbUZ.zza(this, paramzzb, paramChannelListener);
      return;
    }
    paramChannelListener = new zzcq(paramString, paramChannelListener);
    this.zzbUZ.zza(this, paramzzb, paramChannelListener);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, DataApi.DataListener paramDataListener)
  {
    this.zzbVa.zza(this, paramzzb, paramDataListener);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, DataApi.DataListener paramDataListener, zzabh<DataApi.DataListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.zzbVa.zza(this, paramzzb, paramDataListener, zzcy.zza(paramzzabh, paramArrayOfIntentFilter));
  }
  
  public void zza(zzaad.zzb<DataApi.GetFdForAssetResult> paramzzb, DataItemAsset paramDataItemAsset)
  {
    zza(paramzzb, Asset.createFromRef(paramDataItemAsset.getId()));
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, MessageApi.MessageListener paramMessageListener)
  {
    this.zzbVb.zza(this, paramzzb, paramMessageListener);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, MessageApi.MessageListener paramMessageListener, zzabh<MessageApi.MessageListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.zzbVb.zza(this, paramzzb, paramMessageListener, zzcy.zzb(paramzzabh, paramArrayOfIntentFilter));
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, NodeApi.NodeListener paramNodeListener)
  {
    this.zzbVc.zza(this, paramzzb, paramNodeListener);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, NodeApi.NodeListener paramNodeListener, zzabh<NodeApi.NodeListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.zzbVc.zza(this, paramzzb, paramNodeListener, zzcy.zzc(paramzzabh, paramArrayOfIntentFilter));
  }
  
  public void zza(zzaad.zzb<DataApi.DataItemResult> paramzzb, PutDataRequest paramPutDataRequest)
  {
    Object localObject2 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Asset)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if ((((Asset)localObject1).getData() == null) && (((Asset)localObject1).getDigest() == null) && (((Asset)localObject1).getFd() == null) && (((Asset)localObject1).getUri() == null))
      {
        paramzzb = String.valueOf(paramPutDataRequest.getUri());
        paramPutDataRequest = String.valueOf(localObject1);
        throw new IllegalArgumentException(String.valueOf(paramzzb).length() + 33 + String.valueOf(paramPutDataRequest).length() + "Put for " + paramzzb + " contains invalid asset: " + paramPutDataRequest);
      }
    }
    localObject2 = PutDataRequest.zzy(paramPutDataRequest.getUri());
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
          localObject3 = zza(localObject4[1], ((Asset)localObject3).getData());
          ((List)localObject1).add(localObject3);
          this.zzbtM.submit((Runnable)localObject3);
        }
        catch (IOException paramzzb)
        {
          paramPutDataRequest = String.valueOf(paramPutDataRequest);
          throw new IllegalStateException(String.valueOf(paramPutDataRequest).length() + 60 + "Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, paramzzb);
        }
      } else if (((Asset)localObject3).getUri() != null) {
        try
        {
          localObject4 = Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(((Asset)localObject3).getUri(), "r"));
          ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject4);
        }
        catch (FileNotFoundException paramPutDataRequest)
        {
          new zzcw.zzq(paramzzb, (List)localObject1).zza(new zzci(4005, null));
          paramzzb = String.valueOf(((Asset)localObject3).getUri());
          new StringBuilder(String.valueOf(paramzzb).length() + 28).append("Couldn't resolve asset URI: ").append(paramzzb);
          return;
        }
      } else {
        ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject3);
      }
    }
    ((zzbw)zzxD()).zza(new zzcw.zzq(paramzzb, (List)localObject1), (PutDataRequest)localObject2);
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, String paramString, Uri paramUri, long paramLong1, long paramLong2)
  {
    try
    {
      this.zzbtM.execute(zzb(paramzzb, paramString, paramUri, paramLong1, paramLong2));
      return;
    }
    catch (RuntimeException paramString)
    {
      paramzzb.zzB(new Status(8));
      throw paramString;
    }
  }
  
  public void zza(zzaad.zzb<Status> paramzzb, String paramString, Uri paramUri, boolean paramBoolean)
  {
    try
    {
      this.zzbtM.execute(zzb(paramzzb, paramString, paramUri, paramBoolean));
      return;
    }
    catch (RuntimeException paramString)
    {
      paramzzb.zzB(new Status(8));
      throw paramString;
    }
  }
  
  public void zza(zzaad.zzb<MessageApi.SendMessageResult> paramzzb, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzt(paramzzb), paramString1, paramString2, paramArrayOfByte);
  }
  
  public void zzb(zzaad.zzb<DataApi.DeleteDataItemsResult> paramzzb, Uri paramUri, int paramInt)
  {
    ((zzbw)zzxD()).zzb(new zzcw.zze(paramzzb), paramUri, paramInt);
  }
  
  public void zzd(zzaad.zzb<CapabilityApi.GetAllCapabilitiesResult> paramzzb, int paramInt)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzf(paramzzb), paramInt);
  }
  
  public void zze(zzaad.zzb<ChannelApi.OpenChannelResult> paramzzb, String paramString1, String paramString2)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzp(paramzzb), paramString1, paramString2);
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  protected String zzez()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected zzbw zzfF(IBinder paramIBinder)
  {
    return zzbw.zza.zzfD(paramIBinder);
  }
  
  public void zzh(zzaad.zzb<CapabilityApi.GetCapabilityResult> paramzzb, String paramString, int paramInt)
  {
    ((zzbw)zzxD()).zza(new zzcw.zzg(paramzzb), paramString, paramInt);
  }
  
  public void zzi(zzaad.zzb<Status> paramzzb, String paramString, int paramInt)
  {
    ((zzbw)zzxD()).zzb(new zzcw.zzd(paramzzb), paramString, paramInt);
  }
  
  public void zzv(zzaad.zzb<CapabilityApi.AddLocalCapabilityResult> paramzzb, String paramString)
  {
    ((zzbw)zzxD()).zzd(new zzcw.zza(paramzzb), paramString);
  }
  
  public boolean zzvh()
  {
    return !this.zzbVf.zziq("com.google.android.wearable.app.cn");
  }
  
  public void zzw(zzaad.zzb<DataItemBuffer> paramzzb)
  {
    ((zzbw)zzxD()).zzb(new zzcw.zzl(paramzzb));
  }
  
  public void zzw(zzaad.zzb<CapabilityApi.RemoveLocalCapabilityResult> paramzzb, String paramString)
  {
    ((zzbw)zzxD()).zze(new zzcw.zzs(paramzzb), paramString);
  }
  
  public void zzx(zzaad.zzb<NodeApi.GetLocalNodeResult> paramzzb)
  {
    ((zzbw)zzxD()).zzc(new zzcw.zzn(paramzzb));
  }
  
  public void zzx(zzaad.zzb<Status> paramzzb, String paramString)
  {
    ((zzbw)zzxD()).zzf(new zzcw.zzc(paramzzb), paramString);
  }
  
  protected String zzxv()
  {
    if (this.zzbVf.zziq("com.google.android.wearable.app.cn")) {
      return "com.google.android.wearable.app.cn";
    }
    return "com.google.android.gms";
  }
  
  public void zzy(zzaad.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
  {
    ((zzbw)zzxD()).zzd(new zzcw.zzj(paramzzb));
  }
  
  public void zzy(zzaad.zzb<Channel.GetInputStreamResult> paramzzb, String paramString)
  {
    zzac localzzac = new zzac();
    ((zzbw)zzxD()).zza(new zzcw.zzh(paramzzb, localzzac), localzzac, paramString);
  }
  
  public void zzz(zzaad.zzb<Channel.GetOutputStreamResult> paramzzb, String paramString)
  {
    zzac localzzac = new zzac();
    ((zzbw)zzxD()).zzb(new zzcw.zzi(paramzzb, localzzac), localzzac, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcx
 * JD-Core Version:    0.7.0.1
 */