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
    public final int aWL;
    public final int aWM;
    public final int aXO;
    public final byte[] aXP;
    
    public a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      this.aXO = paramInt1;
      this.aXP = paramArrayOfByte;
      this.aWL = paramInt2;
      this.aWM = paramInt3;
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
      if ((this.aXO == paramObject.aXO) && (this.aWL == paramObject.aWL) && (this.aWM == paramObject.aWM) && (Arrays.equals(this.aXP, paramObject.aXP)))
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
      int i = this.aXO;
      int j = Arrays.hashCode(this.aXP);
      int k = this.aWL;
      int m = this.aWM;
      AppMethodBeat.o(92189);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.m
 * JD-Core Version:    0.7.0.1
 */