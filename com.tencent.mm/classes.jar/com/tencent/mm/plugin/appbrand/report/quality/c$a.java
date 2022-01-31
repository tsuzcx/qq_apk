package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;

final class c$a
  implements Runnable
{
  long hab = 0L;
  
  private c$a(c paramc) {}
  
  public final void run()
  {
    if (this.hac.gZZ == null) {
      return;
    }
    this.hac.wn();
    this.hac.handler.postDelayed(this.hac.gZY, this.hab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c.a
 * JD-Core Version:    0.7.0.1
 */