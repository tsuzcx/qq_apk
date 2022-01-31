package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  extends g.b
{
  a$2(a parama) {}
  
  public final void a(g.c paramc)
  {
    y.i("MicroMsg.MBNiReporter", "hy: onPause");
    paramc = this.gdb;
    if (paramc.bCk)
    {
      y.i("MicroMsg.MBNiReporter", "hy: hasReported!");
      return;
    }
    com.tencent.mm.cg.a.post(new a.4(paramc));
  }
  
  public final void onCreate()
  {
    y.i("MicroMsg.MBNiReporter", "hy: onCreate");
    a.b(this.gdb);
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.MBNiReporter", "hy: onDestroy");
    a locala = this.gdb;
    y.i("MicroMsg.MBNiReporter", "hy: release!");
    g.b(a.appId, locala.gda);
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.MBNiReporter", "hy: onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.2
 * JD-Core Version:    0.7.0.1
 */