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
    AppMethodBeat.i(101365);
    this.zzeu = ((zzbr)Preconditions.checkNotNull(paramzzbr));
    AppMethodBeat.o(101365);
  }
  
  public final void zza(zzdo paramzzdo)
  {
    AppMethodBeat.i(101366);
    zzbl localzzbl = null;
    if (paramzzdo.zzdr != null)
    {
      localzzbl = new zzbl(new ParcelFileDescriptor.AutoCloseOutputStream(paramzzdo.zzdr));
      this.zzeu.zza(new zzbm(localzzbl));
    }
    zza(new zzbh(new Status(paramzzdo.statusCode), localzzbl));
    AppMethodBeat.o(101366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgt
 * JD-Core Version:    0.7.0.1
 */