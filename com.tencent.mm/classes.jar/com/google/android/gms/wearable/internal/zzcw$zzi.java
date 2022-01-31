package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;

final class zzcw$zzi
  extends zzcw.zzb<Channel.GetOutputStreamResult>
{
  private final zzac zzbUW;
  
  public zzcw$zzi(zzaad.zzb<Channel.GetOutputStreamResult> paramzzb, zzac paramzzac)
  {
    super(paramzzb);
    this.zzbUW = ((zzac)com.google.android.gms.common.internal.zzac.zzw(paramzzac));
  }
  
  public final void zza(zzaz paramzzaz)
  {
    zzx localzzx = null;
    if (paramzzaz.zzbUz != null)
    {
      localzzx = new zzx(new ParcelFileDescriptor.AutoCloseOutputStream(paramzzaz.zzbUz));
      this.zzbUW.zza(localzzx.zzUt());
    }
    zzaa(new zzu.zzb(new Status(paramzzaz.statusCode), localzzx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw.zzi
 * JD-Core Version:    0.7.0.1
 */