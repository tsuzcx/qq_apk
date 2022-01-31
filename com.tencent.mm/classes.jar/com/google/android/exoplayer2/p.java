package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static final p axk;
  public final int axl;
  public final float pitch;
  public final float speed;
  
  static
  {
    AppMethodBeat.i(95390);
    axk = new p(1.0F, 1.0F);
    AppMethodBeat.o(95390);
  }
  
  public p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(95387);
    this.speed = paramFloat1;
    this.pitch = paramFloat2;
    this.axl = Math.round(1000.0F * paramFloat1);
    AppMethodBeat.o(95387);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95388);
    if (this == paramObject)
    {
      AppMethodBeat.o(95388);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95388);
      return false;
    }
    paramObject = (p)paramObject;
    if ((this.speed == paramObject.speed) && (this.pitch == paramObject.pitch))
    {
      AppMethodBeat.o(95388);
      return true;
    }
    AppMethodBeat.o(95388);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95389);
    int i = Float.floatToRawIntBits(this.speed);
    int j = Float.floatToRawIntBits(this.pitch);
    AppMethodBeat.o(95389);
    return (i + 527) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.p
 * JD-Core Version:    0.7.0.1
 */