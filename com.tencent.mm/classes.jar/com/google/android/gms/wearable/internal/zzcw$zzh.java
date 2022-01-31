package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;

final class zzcw$zzh
  extends zzcw.zzb<Channel.GetInputStreamResult>
{
  private final zzac zzbUW;
  
  public zzcw$zzh(zzaad.zzb<Channel.GetInputStreamResult> paramzzb, zzac paramzzac)
  {
    super(paramzzb);
    this.zzbUW = ((zzac)com.google.android.gms.common.internal.zzac.zzw(paramzzac));
  }
  
  public final void zza(zzax paramzzax)
  {
    zzw localzzw = null;
    if (paramzzax.zzbUz != null)
    {
      localzzw = new zzw(new ParcelFileDescriptor.AutoCloseInputStream(paramzzax.zzbUz));
      this.zzbUW.zza(localzzw.zzUt());
    }
    zzaa(new zzu.zza(new Status(paramzzax.statusCode), localzzw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw.zzh
 * JD-Core Version:    0.7.0.1
 */