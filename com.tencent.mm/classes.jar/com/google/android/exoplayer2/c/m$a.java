package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class m$a
{
  public final int cKD;
  public final int cKE;
  public final int cLG;
  public final byte[] cLH;
  
  public m$a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.cLG = paramInt1;
    this.cLH = paramArrayOfByte;
    this.cKD = paramInt2;
    this.cKE = paramInt3;
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
    if ((this.cLG == paramObject.cLG) && (this.cKD == paramObject.cKD) && (this.cKE == paramObject.cKE) && (Arrays.equals(this.cLH, paramObject.cLH)))
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
    int i = this.cLG;
    int j = Arrays.hashCode(this.cLH);
    int k = this.cKD;
    int m = this.cKE;
    AppMethodBeat.o(92189);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.c.m.a
 * JD-Core Version:    0.7.0.1
 */