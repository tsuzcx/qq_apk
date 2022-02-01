package com.tencent.mm.danmaku.d;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public final int jAY;
  public float jAZ = 0.0F;
  public float jBa = 0.0F;
  public final Point mPoint;
  public final long mTime;
  
  public h(long paramLong, Point paramPoint, int paramInt)
  {
    this.mTime = paramLong;
    this.mPoint = paramPoint;
    this.jAY = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(264803);
    String str = "TouchPoint{mTime=" + this.mTime + ", mPoint=" + this.mPoint + ", mDistanceOfError=" + this.jAY + '}';
    AppMethodBeat.o(264803);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.h
 * JD-Core Version:    0.7.0.1
 */