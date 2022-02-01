package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KSize
{
  public float mHeight;
  public float mWidth;
  
  public KSize() {}
  
  public KSize(float paramFloat1, float paramFloat2)
  {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135899);
    String str = "KSize{mWidth=" + this.mWidth + ",mHeight=" + this.mHeight + "}";
    AppMethodBeat.o(135899);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KSize
 * JD-Core Version:    0.7.0.1
 */