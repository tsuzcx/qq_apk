package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.internal.zzabh.zzc;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public class zzcy<T>
  extends zzbv.zza
{
  private final IntentFilter[] zzbUN;
  private zzabh<Object> zzbVj;
  private zzabh<Object> zzbVk;
  private zzabh<DataApi.DataListener> zzbVl;
  private zzabh<MessageApi.MessageListener> zzbVm;
  private zzabh<NodeApi.NodeListener> zzbVn;
  private zzabh<Object> zzbVo;
  private zzabh<ChannelApi.ChannelListener> zzbVp;
  private zzabh<CapabilityApi.CapabilityListener> zzbVq;
  private final String zzbVr;
  
  private zzcy(IntentFilter[] paramArrayOfIntentFilter, String paramString)
  {
    this.zzbUN = ((IntentFilter[])zzac.zzw(paramArrayOfIntentFilter));
    this.zzbVr = paramString;
  }
  
  public static zzcy<ChannelApi.ChannelListener> zza(zzabh<ChannelApi.ChannelListener> paramzzabh, String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramString = new zzcy(paramArrayOfIntentFilter, (String)zzac.zzw(paramString));
    paramString.zzbVp = ((zzabh)zzac.zzw(paramzzabh));
    return paramString;
  }
  
  public static zzcy<DataApi.DataListener> zza(zzabh<DataApi.DataListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcy(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbVl = ((zzabh)zzac.zzw(paramzzabh));
    return paramArrayOfIntentFilter;
  }
  
  private static zzabh.zzc<DataApi.DataListener> zzas(DataHolder paramDataHolder)
  {
    return new zzcy.1(paramDataHolder);
  }
  
  private static zzabh.zzc<MessageApi.MessageListener> zzb(zzbz paramzzbz)
  {
    return new zzcy.2(paramzzbz);
  }
  
  private static zzabh.zzc<CapabilityApi.CapabilityListener> zzb(zzo paramzzo)
  {
    return new zzcy.6(paramzzo);
  }
  
  private static zzabh.zzc<ChannelApi.ChannelListener> zzb(zzs paramzzs)
  {
    return new zzcy.5(paramzzs);
  }
  
  public static zzcy<MessageApi.MessageListener> zzb(zzabh<MessageApi.MessageListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcy(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbVm = ((zzabh)zzac.zzw(paramzzabh));
    return paramArrayOfIntentFilter;
  }
  
  private static zzabh.zzc<NodeApi.NodeListener> zzc(zzcc paramzzcc)
  {
    return new zzcy.3(paramzzcc);
  }
  
  public static zzcy<NodeApi.NodeListener> zzc(zzabh<NodeApi.NodeListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcy(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbVn = ((zzabh)zzac.zzw(paramzzabh));
    return paramArrayOfIntentFilter;
  }
  
  private static zzabh.zzc<NodeApi.NodeListener> zzd(zzcc paramzzcc)
  {
    return new zzcy.4(paramzzcc);
  }
  
  public static zzcy<ChannelApi.ChannelListener> zzd(zzabh<ChannelApi.ChannelListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcy(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbVp = ((zzabh)zzac.zzw(paramzzabh));
    return paramArrayOfIntentFilter;
  }
  
  public static zzcy<CapabilityApi.CapabilityListener> zze(zzabh<CapabilityApi.CapabilityListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcy(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbVq = ((zzabh)zzac.zzw(paramzzabh));
    return paramArrayOfIntentFilter;
  }
  
  private static void zzl(zzabh<?> paramzzabh)
  {
    if (paramzzabh != null) {
      paramzzabh.clear();
    }
  }
  
  public void clear()
  {
    zzl(null);
    this.zzbVj = null;
    zzl(null);
    this.zzbVk = null;
    zzl(this.zzbVl);
    this.zzbVl = null;
    zzl(this.zzbVm);
    this.zzbVm = null;
    zzl(this.zzbVn);
    this.zzbVn = null;
    zzl(null);
    this.zzbVo = null;
    zzl(this.zzbVp);
    this.zzbVp = null;
    zzl(this.zzbVq);
    this.zzbVq = null;
  }
  
  public void onConnectedNodes(List<zzcc> paramList) {}
  
  public IntentFilter[] zzUy()
  {
    return this.zzbUN;
  }
  
  public String zzUz()
  {
    return this.zzbVr;
  }
  
  public void zza(zzbz paramzzbz)
  {
    if (this.zzbVm != null) {
      this.zzbVm.zza(zzb(paramzzbz));
    }
  }
  
  public void zza(zzcc paramzzcc)
  {
    if (this.zzbVn != null) {
      this.zzbVn.zza(zzc(paramzzcc));
    }
  }
  
  public void zza(zzh paramzzh) {}
  
  public void zza(zzk paramzzk) {}
  
  public void zza(zzo paramzzo)
  {
    if (this.zzbVq != null) {
      this.zzbVq.zza(zzb(paramzzo));
    }
  }
  
  public void zza(zzs paramzzs)
  {
    if (this.zzbVp != null) {
      this.zzbVp.zza(zzb(paramzzs));
    }
  }
  
  public void zzaq(DataHolder paramDataHolder)
  {
    if (this.zzbVl != null)
    {
      this.zzbVl.zza(zzas(paramDataHolder));
      return;
    }
    paramDataHolder.close();
  }
  
  public void zzb(zzcc paramzzcc)
  {
    if (this.zzbVn != null) {
      this.zzbVn.zza(zzd(paramzzcc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcy
 * JD-Core Version:    0.7.0.1
 */