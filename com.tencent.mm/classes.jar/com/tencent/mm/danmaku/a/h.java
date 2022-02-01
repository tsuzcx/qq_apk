package com.tencent.mm.danmaku.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.plugin.finder.megavideo.bullet.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  com.tencent.mm.danmaku.c.a jxO;
  HandlerThread jyN;
  private Handler jyO;
  Boolean jyP = Boolean.FALSE;
  
  public h(com.tencent.mm.danmaku.c.a parama)
  {
    this.jxO = parama;
  }
  
  public static void a(com.tencent.mm.danmaku.c.a parama, com.tencent.mm.danmaku.b.a parama1)
  {
    AppMethodBeat.i(281851);
    if (parama1.azl())
    {
      AppMethodBeat.o(281851);
      return;
    }
    parama = parama.d(parama1).f(parama1);
    parama1.aj(parama.jzv + com.tencent.mm.danmaku.c.a.azC().jAc * 2);
    parama1.ak(parama.jzw + com.tencent.mm.danmaku.c.a.azC().jAb * 2);
    parama1.azm();
    AppMethodBeat.o(281851);
  }
  
  final Handler azc()
  {
    AppMethodBeat.i(281853);
    if ((this.jyN == null) || (!this.jyN.isAlive())) {}
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.zvH;
        localObject = b.a.dJA().zvE;
        if ((localObject == null) || (!((HandlerThread)localObject).isAlive())) {
          continue;
        }
        this.jyN = ((HandlerThread)localObject);
        this.jyP = Boolean.TRUE;
        this.jyO = new Handler(this.jyN.getLooper());
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        e.e("DanmakuMeasureManager", new Object[] { localThrowable });
        continue;
      }
      localObject = this.jyO;
      AppMethodBeat.o(281853);
      return localObject;
      this.jyN = new HandlerThread("DanmakuMeasureThread");
      this.jyN.start();
      this.jyN.setUncaughtExceptionHandler(new com.tencent.mm.danmaku.e.b());
      this.jyP = Boolean.FALSE;
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(com.tencent.mm.danmaku.b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.h
 * JD-Core Version:    0.7.0.1
 */