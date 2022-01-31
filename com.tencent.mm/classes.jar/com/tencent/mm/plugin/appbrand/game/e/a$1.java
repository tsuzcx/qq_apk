package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    a.a(this.gdb, a.a(this.gdb).size());
    y.i("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", new Object[] { Integer.valueOf(a.e(this.gdb)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.1
 * JD-Core Version:    0.7.0.1
 */