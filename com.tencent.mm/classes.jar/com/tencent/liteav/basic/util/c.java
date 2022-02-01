package com.tencent.liteav.basic.util;

import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class c
{
  private final String a;
  private final int b;
  private int c;
  private int d;
  private long e;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(240083);
    this.a = paramString;
    this.b = ((int)Math.max(paramInt, TimeUnit.SECONDS.toMillis(1L)));
    b();
    AppMethodBeat.o(240083);
  }
  
  public void a()
  {
    AppMethodBeat.i(240086);
    this.c += 1;
    long l = SystemClock.elapsedRealtime();
    if (this.e == 0L)
    {
      this.e = SystemClock.elapsedRealtime();
      AppMethodBeat.o(240086);
      return;
    }
    if (l - this.e >= this.b)
    {
      float f = (this.c - this.d) * 1000.0F / (float)(l - this.e);
      TXCLog.i("FPSMeter", "meter name: %s fps: %.2f", new Object[] { this.a, Float.valueOf(f) });
      this.e = l;
      this.d = this.c;
    }
    AppMethodBeat.o(240086);
  }
  
  public void b()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.c
 * JD-Core Version:    0.7.0.1
 */