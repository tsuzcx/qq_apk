package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static final p bdP;
  public final float bdQ;
  public final int bdR;
  public final float pitch;
  
  static
  {
    AppMethodBeat.i(92512);
    bdP = new p(1.0F, 1.0F);
    AppMethodBeat.o(92512);
  }
  
  public p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(92509);
    this.bdQ = paramFloat1;
    this.pitch = paramFloat2;
    this.bdR = Math.round(1000.0F * paramFloat1);
    AppMethodBeat.o(92509);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92510);
    if (this == paramObject)
    {
      AppMethodBeat.o(92510);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92510);
      return false;
    }
    paramObject = (p)paramObject;
    if ((this.bdQ == paramObject.bdQ) && (this.pitch == paramObject.pitch))
    {
      AppMethodBeat.o(92510);
      return true;
    }
    AppMethodBeat.o(92510);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92511);
    int i = Float.floatToRawIntBits(this.bdQ);
    int j = Float.floatToRawIntBits(this.pitch);
    AppMethodBeat.o(92511);
    return (i + 527) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.p
 * JD-Core Version:    0.7.0.1
 */