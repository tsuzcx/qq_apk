package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgt
  extends zzgm<Channel.GetOutputStreamResult>
{
  private final zzbr zzeu;
  
  public zzgt(BaseImplementation.ResultHolder<Channel.GetOutputStreamResult> paramResultHolder, zzbr paramzzbr)
  {
    super(paramResultHolder);
    AppMethodBeat.i(71382);
    this.zzeu = ((zzbr)Preconditions.checkNotNull(paramzzbr));
    AppMethodBeat.o(71382);
  }
  
  public final void zza(zzdo paramzzdo)
  {
    AppMethodBeat.i(71383);
    zzbl localzzbl = null;
    if (paramzzdo.zzdr != null)
    {
      localzzbl = new zzbl(new ParcelFileDescriptor.AutoCloseOutputStream(paramzzdo.zzdr));
      this.zzeu.zza(new zzbm(localzzbl));
    }
    zza(new zzbh(new Status(paramzzdo.statusCode), localzzbl));
    AppMethodBeat.o(71383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgt
 * JD-Core Version:    0.7.0.1
 */