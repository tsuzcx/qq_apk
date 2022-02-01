package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class zzacg
{
  final int tag;
  final byte[] zzbrc;
  
  zzacg(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbrc = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40309);
    if (paramObject == this)
    {
      AppMethodBeat.o(40309);
      return true;
    }
    if (!(paramObject instanceof zzacg))
    {
      AppMethodBeat.o(40309);
      return false;
    }
    paramObject = (zzacg)paramObject;
    if ((this.tag == paramObject.tag) && (Arrays.equals(this.zzbrc, paramObject.zzbrc)))
    {
      AppMethodBeat.o(40309);
      return true;
    }
    AppMethodBeat.o(40309);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(40310);
    int i = this.tag;
    int j = Arrays.hashCode(this.zzbrc);
    AppMethodBeat.o(40310);
    return (i + 527) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacg
 * JD-Core Version:    0.7.0.1
 */