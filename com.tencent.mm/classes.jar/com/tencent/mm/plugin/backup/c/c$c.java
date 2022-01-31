package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import java.util.concurrent.LinkedBlockingQueue;

final class c$c
{
  LinkedBlockingQueue<Object> hGJ = new LinkedBlockingQueue();
  af hGK = new af();
  c.b hGL = null;
  private Runnable hGM = new c.c.1(this);
  c.a hGp = new c.a(this.hGk, (byte)0);
  
  public c$c(c paramc)
  {
    e.b(this.hGM, "tagRunnable").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.c
 * JD-Core Version:    0.7.0.1
 */