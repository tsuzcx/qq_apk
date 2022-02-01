package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzyz
  extends zzzc
{
  private final int zzbra;
  private final int zzbrb;
  
  zzyz(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    AppMethodBeat.i(40342);
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzbra = paramInt1;
    this.zzbrb = paramInt2;
    AppMethodBeat.o(40342);
  }
  
  public final int size()
  {
    return this.zzbrb;
  }
  
  public final byte zzae(int paramInt)
  {
    AppMethodBeat.i(40343);
    int i = size();
    if ((i - (paramInt + 1) | paramInt) < 0)
    {
      if (paramInt < 0)
      {
        localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(22 + "Index < 0: " + paramInt);
        AppMethodBeat.o(40343);
        throw localArrayIndexOutOfBoundsException;
      }
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(40 + "Index > length: " + paramInt + ", " + i);
      AppMethodBeat.o(40343);
      throw localArrayIndexOutOfBoundsException;
    }
    byte b = this.zzbrc[(this.zzbra + paramInt)];
    AppMethodBeat.o(40343);
    return b;
  }
  
  protected final int zzsy()
  {
    return this.zzbra;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyz
 * JD-Core Version:    0.7.0.1
 */