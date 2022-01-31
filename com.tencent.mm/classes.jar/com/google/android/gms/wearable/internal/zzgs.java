package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgs
  extends zzgm<Channel.GetInputStreamResult>
{
  private final zzbr zzeu;
  
  public zzgs(BaseImplementation.ResultHolder<Channel.GetInputStreamResult> paramResultHolder, zzbr paramzzbr)
  {
    super(paramResultHolder);
    AppMethodBeat.i(71380);
    this.zzeu = ((zzbr)Preconditions.checkNotNull(paramzzbr));
    AppMethodBeat.o(71380);
  }
  
  public final void zza(zzdm paramzzdm)
  {
    AppMethodBeat.i(71381);
    zzbj localzzbj = null;
    if (paramzzdm.zzdr != null)
    {
      localzzbj = new zzbj(new ParcelFileDescriptor.AutoCloseInputStream(paramzzdm.zzdr));
      this.zzeu.zza(new zzbk(localzzbj));
    }
    zza(new zzbg(new Status(paramzzdm.statusCode), localzzbj));
    AppMethodBeat.o(71381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgs
 * JD-Core Version:    0.7.0.1
 */