package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhe
  extends zzgm<MessageApi.SendMessageResult>
{
  public zzhe(BaseImplementation.ResultHolder<MessageApi.SendMessageResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzga paramzzga)
  {
    AppMethodBeat.i(101376);
    zza(new zzey(zzgd.zzb(paramzzga.statusCode), paramzzga.zzeh));
    AppMethodBeat.o(101376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhe
 * JD-Core Version:    0.7.0.1
 */