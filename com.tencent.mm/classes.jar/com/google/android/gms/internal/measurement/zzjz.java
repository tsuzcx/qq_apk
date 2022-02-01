package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjz
{
  final String name;
  final String origin;
  final Object value;
  final long zzaqz;
  final String zzti;
  
  zzjz(String paramString1, String paramString2, String paramString3, long paramLong, Object paramObject)
  {
    AppMethodBeat.i(2020);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramObject);
    this.zzti = paramString1;
    this.origin = paramString2;
    this.name = paramString3;
    this.zzaqz = paramLong;
    this.value = paramObject;
    AppMethodBeat.o(2020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjz
 * JD-Core Version:    0.7.0.1
 */