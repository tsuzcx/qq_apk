package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.sdk.platformtools.ai;
import java.util.TimerTask;

public final class b$a
  extends TimerTask
{
  private int progress = 50;
  
  public b$a(b paramb) {}
  
  public final void run()
  {
    if (this.progress >= 100)
    {
      cancel();
      return;
    }
    this.progress += 1;
    ai.d(new b.a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a
 * JD-Core Version:    0.7.0.1
 */