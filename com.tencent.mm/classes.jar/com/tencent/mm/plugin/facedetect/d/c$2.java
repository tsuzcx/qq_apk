package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.TimerTask;

final class c$2
  extends TimerTask
{
  c$2(c paramc) {}
  
  public final void run()
  {
    synchronized (c.b(this.jPn))
    {
      if (!c.c(this.jPn))
      {
        y.w(c.access$300(), "hy: already stopped");
        cancel();
      }
      ai.d(new c.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c.2
 * JD-Core Version:    0.7.0.1
 */