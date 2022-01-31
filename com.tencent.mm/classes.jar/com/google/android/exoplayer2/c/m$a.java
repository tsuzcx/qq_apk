package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class m$a
{
  public final int aAF;
  public final int aAG;
  public final int aBK;
  public final byte[] aBL;
  
  public m$a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.aBK = paramInt1;
    this.aBL = paramArrayOfByte;
    this.aAF = paramInt2;
    this.aAG = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95066);
    if (this == paramObject)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95066);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.aBK == paramObject.aBK) && (this.aAF == paramObject.aAF) && (this.aAG == paramObject.aAG) && (Arrays.equals(this.aBL, paramObject.aBL)))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95067);
    int i = this.aBK;
    int j = Arrays.hashCode(this.aBL);
    int k = this.aAF;
    int m = this.aAG;
    AppMethodBeat.o(95067);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.m.a
 * JD-Core Version:    0.7.0.1
 */