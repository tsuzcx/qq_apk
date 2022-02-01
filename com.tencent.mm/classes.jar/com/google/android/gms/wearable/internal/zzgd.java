package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgd
{
  public static Status zzb(int paramInt)
  {
    AppMethodBeat.i(101344);
    Status localStatus = new Status(paramInt, WearableStatusCodes.getStatusCodeString(paramInt));
    AppMethodBeat.o(101344);
    return localStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgd
 * JD-Core Version:    0.7.0.1
 */