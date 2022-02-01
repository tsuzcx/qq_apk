package com.tencent.matrix.trace.core;

public final class b$2
  extends com.tencent.matrix.trace.e.c
{
  public b$2(b paramb) {}
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "focusedActivity[%s] frame cost:%sms isVsyncFrame=%s intendedFrameTimeNs=%s [%s|%s|%s]ns", new Object[] { paramString, Long.valueOf((paramLong2 - paramLong1) / 1000000L), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b.2
 * JD-Core Version:    0.7.0.1
 */