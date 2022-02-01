package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class zzv
{
  final int tag;
  final byte[] zzhm;
  
  zzv(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzhm = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100765);
    if (paramObject == this)
    {
      AppMethodBeat.o(100765);
      return true;
    }
    if (!(paramObject instanceof zzv))
    {
      AppMethodBeat.o(100765);
      return false;
    }
    paramObject = (zzv)paramObject;
    if ((this.tag == paramObject.tag) && (Arrays.equals(this.zzhm, paramObject.zzhm)))
    {
      AppMethodBeat.o(100765);
      return true;
    }
    AppMethodBeat.o(100765);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(100766);
    int i = this.tag;
    int j = Arrays.hashCode(this.zzhm);
    AppMethodBeat.o(100766);
    return (i + 527) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzv
 * JD-Core Version:    0.7.0.1
 */