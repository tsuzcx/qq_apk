package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DynamicColor
{
  public long mDarkmodeColor;
  public long mNormalColor;
  
  public DynamicColor() {}
  
  public DynamicColor(long paramLong1, long paramLong2)
  {
    this.mNormalColor = paramLong1;
    this.mDarkmodeColor = paramLong2;
  }
  
  public final long getDarkmodeColor()
  {
    return this.mDarkmodeColor;
  }
  
  public final long getNormalColor()
  {
    return this.mNormalColor;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135666);
    String str = "DynamicColor{mNormalColor=" + this.mNormalColor + ",mDarkmodeColor=" + this.mDarkmodeColor + "}";
    AppMethodBeat.o(135666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.DynamicColor
 * JD-Core Version:    0.7.0.1
 */