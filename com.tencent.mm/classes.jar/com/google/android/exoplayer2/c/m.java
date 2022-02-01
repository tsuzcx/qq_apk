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
    public final int aVY;
    public final int aVZ;
    public final int aXc;
    public final byte[] aXd;
    
    public a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      this.aXc = paramInt1;
      this.aXd = paramArrayOfByte;
      this.aVY = paramInt2;
      this.aVZ = paramInt3;
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
      if ((this.aXc == paramObject.aXc) && (this.aVY == paramObject.aVY) && (this.aVZ == paramObject.aVZ) && (Arrays.equals(this.aXd, paramObject.aXd)))
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
      int i = this.aXc;
      int j = Arrays.hashCode(this.aXd);
      int k = this.aVY;
      int m = this.aVZ;
      AppMethodBeat.o(92189);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.m
 * JD-Core Version:    0.7.0.1
 */