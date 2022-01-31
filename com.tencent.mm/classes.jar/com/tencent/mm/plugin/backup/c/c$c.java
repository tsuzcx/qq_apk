package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.LinkedBlockingQueue;

final class c$c
{
  LinkedBlockingQueue<Object> jAf;
  ai jAg;
  c.b jAh;
  private Runnable jAi;
  c.a jzL;
  
  public c$c(c paramc)
  {
    AppMethodBeat.i(17192);
    this.jAf = new LinkedBlockingQueue();
    this.jzL = new c.a(this.jzG, (byte)0);
    this.jAg = new ai();
    this.jAh = null;
    this.jAi = new c.c.1(this);
    d.h(this.jAi, "tagRunnable").start();
    AppMethodBeat.o(17192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.c
 * JD-Core Version:    0.7.0.1
 */