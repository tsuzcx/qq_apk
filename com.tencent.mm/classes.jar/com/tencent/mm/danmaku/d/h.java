package com.tencent.mm.danmaku.d;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public final int gQF;
  public float gQG = 0.0F;
  public float gQH = 0.0F;
  public final Point mPoint;
  public final long mTime;
  
  public h(long paramLong, Point paramPoint, int paramInt)
  {
    this.mTime = paramLong;
    this.mPoint = paramPoint;
    this.gQF = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241754);
    String str = "TouchPoint{mTime=" + this.mTime + ", mPoint=" + this.mPoint + ", mDistanceOfError=" + this.gQF + '}';
    AppMethodBeat.o(241754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.h
 * JD-Core Version:    0.7.0.1
 */