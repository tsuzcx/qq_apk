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
import kotlin.f;

public final class h
{
  com.tencent.mm.danmaku.c.a gNt;
  HandlerThread gOs;
  private Handler gOt;
  Boolean gOu = Boolean.FALSE;
  
  public h(com.tencent.mm.danmaku.c.a parama)
  {
    this.gNt = parama;
  }
  
  public static void a(com.tencent.mm.danmaku.c.a parama, com.tencent.mm.danmaku.b.a parama1)
  {
    AppMethodBeat.i(241659);
    if (parama1.asx())
    {
      AppMethodBeat.o(241659);
      return;
    }
    parama = parama.e(parama1).g(parama1);
    parama1.ak(parama.gPb + com.tencent.mm.danmaku.c.a.asO().gPJ * 2);
    parama1.al(parama.gPc + com.tencent.mm.danmaku.c.a.asO().gPI * 2);
    parama1.asy();
    AppMethodBeat.o(241659);
  }
  
  final Handler aso()
  {
    AppMethodBeat.i(241660);
    if ((this.gOs == null) || (!this.gOs.isAlive())) {}
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.uJZ;
        localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.dkf();
        b.a locala = com.tencent.mm.plugin.finder.megavideo.bullet.b.uJZ;
        localObject = ((com.tencent.mm.plugin.finder.megavideo.bullet.b)((f)localObject).getValue()).uJW;
        if ((localObject == null) || (!((HandlerThread)localObject).isAlive())) {
          continue;
        }
        this.gOs = ((HandlerThread)localObject);
        this.gOu = Boolean.TRUE;
        this.gOt = new Handler(this.gOs.getLooper());
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        e.e("DanmakuMeasureManager", new Object[] { localThrowable });
        continue;
      }
      localObject = this.gOt;
      AppMethodBeat.o(241660);
      return localObject;
      this.gOs = new HandlerThread("DanmakuMeasureThread");
      this.gOs.start();
      this.gOs.setUncaughtExceptionHandler(new com.tencent.mm.danmaku.e.b());
      this.gOu = Boolean.FALSE;
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