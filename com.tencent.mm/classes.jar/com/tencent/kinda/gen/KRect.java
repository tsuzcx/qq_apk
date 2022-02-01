package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KRect
{
  public KPoint mOrigin;
  public KSize mSize;
  
  public KRect() {}
  
  public KRect(KPoint paramKPoint, KSize paramKSize)
  {
    this.mOrigin = paramKPoint;
    this.mSize = paramKSize;
  }
  
  public final KPoint getOrigin()
  {
    return this.mOrigin;
  }
  
  public final KSize getSize()
  {
    return this.mSize;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135882);
    String str = "KRect{mOrigin=" + this.mOrigin + ",mSize=" + this.mSize + "}";
    AppMethodBeat.o(135882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KRect
 * JD-Core Version:    0.7.0.1
 */