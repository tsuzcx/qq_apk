package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public abstract interface m
{
  public abstract int a(f paramf, int paramInt, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, a parama);
  
  public abstract void a(com.google.android.exoplayer2.i.m paramm, int paramInt);
  
  public abstract void f(Format paramFormat);
  
  public static final class a
  {
    public final int aQH;
    public final int aQI;
    public final int aRK;
    public final byte[] aRL;
    
    public a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      this.aRK = paramInt1;
      this.aRL = paramArrayOfByte;
      this.aQH = paramInt2;
      this.aQI = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(92188);
      if (this == paramObject)
      {
        AppMethodBeat.o(92188);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(92188);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.aRK == paramObject.aRK) && (this.aQH == paramObject.aQH) && (this.aQI == paramObject.aQI) && (Arrays.equals(this.aRL, paramObject.aRL)))
      {
        AppMethodBeat.o(92188);
        return true;
      }
      AppMethodBeat.o(92188);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(92189);
      int i = this.aRK;
      int j = Arrays.hashCode(this.aRL);
      int k = this.aQH;
      int m = this.aQI;
      AppMethodBeat.o(92189);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.m
 * JD-Core Version:    0.7.0.1
 */