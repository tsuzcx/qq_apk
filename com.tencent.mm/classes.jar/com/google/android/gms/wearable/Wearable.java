package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.wearable.internal.zzag;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzby;
import com.google.android.gms.wearable.internal.zzcb;
import com.google.android.gms.wearable.internal.zzcu;
import com.google.android.gms.wearable.internal.zzcx;
import com.google.android.gms.wearable.internal.zzda;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzn;
import com.google.android.gms.wearable.internal.zzq;

public class Wearable
{
  public static final Api<Wearable.WearableOptions> API = new Api("Wearable.API", zzaie, zzaid);
  public static final CapabilityApi CapabilityApi;
  public static final ChannelApi ChannelApi;
  public static final DataApi DataApi = new zzah();
  public static final MessageApi MessageApi;
  public static final NodeApi NodeApi;
  public static final Api.zzf<zzcx> zzaid;
  private static final Api.zza<zzcx, Wearable.WearableOptions> zzaie;
  public static final zzc zzbTd;
  public static final zza zzbTe;
  public static final zzf zzbTf;
  public static final zzi zzbTg;
  public static final zzj zzbTh;
  
  static
  {
    CapabilityApi = new zzn();
    MessageApi = new zzby();
    NodeApi = new zzcb();
    ChannelApi = new zzq();
    zzbTd = new com.google.android.gms.wearable.internal.zzj();
    zzbTe = new zzg();
    zzbTf = new zzag();
    zzbTg = new zzcu();
    zzbTh = new zzda();
    zzaid = new Api.zzf();
    zzaie = new Wearable.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable
 * JD-Core Version:    0.7.0.1
 */