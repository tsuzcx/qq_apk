package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static final long gdk = 100000000L;
  private static final long gdl = 16666666L;
  public long gdm = 16666666L;
  private long gdn = -1L;
  private boolean gdo = false;
  
  public static long lc(int paramInt)
  {
    return 1000000000L / paramInt;
  }
  
  public final void aho()
  {
    if (this.gdn == -1L) {
      this.gdn = System.nanoTime();
    }
  }
  
  public final void cV(boolean paramBoolean)
  {
    long l;
    if ((this.gdm > gdl) || (!paramBoolean) || (this.gdo))
    {
      this.gdo = true;
      if (this.gdn != -1L)
      {
        l = System.nanoTime() - this.gdn;
        if (l < this.gdm) {
          l = this.gdm - l;
        }
      }
    }
    try
    {
      Thread.sleep(l / 1000000L, (int)(l % 1000000L));
      this.gdn = System.nanoTime();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        y.e("MicroMsg.WAGameFrameRateController", "Sleep unsuccessfully.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */