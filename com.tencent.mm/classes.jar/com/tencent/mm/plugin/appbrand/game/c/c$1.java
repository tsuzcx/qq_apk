package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.am.a;

final class c$1
  implements am.a
{
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    f localf = f.ty(c.a(this.gbh));
    if (localf != null)
    {
      c localc = this.gbh;
      double d1 = localf.gbN;
      double d2 = localf.gbO;
      double d3 = localf.gbV;
      localc.aPG.setLength(0);
      localc.aPG.append("MinFPS[").append(Math.round(d2)).append("] RT-FPS[").append(Math.round(d1)).append("] EX-FPS[").append(Math.round(d3)).append("]");
      localc.setText(localc.aPG);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c.1
 * JD-Core Version:    0.7.0.1
 */