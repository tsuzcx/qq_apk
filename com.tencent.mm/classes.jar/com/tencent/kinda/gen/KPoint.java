package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KPoint
{
  public float mX;
  public float mY;
  
  public KPoint() {}
  
  public KPoint(float paramFloat1, float paramFloat2)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }
  
  public final float getX()
  {
    return this.mX;
  }
  
  public final float getY()
  {
    return this.mY;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135866);
    String str = "KPoint{mX=" + this.mX + ",mY=" + this.mY + "}";
    AppMethodBeat.o(135866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KPoint
 * JD-Core Version:    0.7.0.1
 */