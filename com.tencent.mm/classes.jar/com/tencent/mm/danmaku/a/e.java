package com.tencent.mm.danmaku.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.a;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.d.g;
import com.tencent.mm.danmaku.d.g.b;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
{
  final f jxQ;
  final List<a> jyF;
  final g<a> jyG;
  private final AtomicBoolean jyH;
  volatile long jyI;
  
  public e(f paramf, g.a parama)
  {
    AppMethodBeat.i(272044);
    this.jyI = -1L;
    this.jxQ = paramf;
    this.jyG = new g(parama, new g.b() {});
    this.jyF = new LinkedList();
    this.jyH = new AtomicBoolean(false);
    AppMethodBeat.o(272044);
  }
  
  final void X(List<a> paramList)
  {
    AppMethodBeat.i(272045);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if (locala.getTime() <= this.jyI) {
        locala.azi();
      }
      i -= 1;
    }
    AppMethodBeat.o(272045);
  }
  
  public final a ayY()
  {
    AppMethodBeat.i(272046);
    a locala = (a)this.jyG.aAb();
    AppMethodBeat.o(272046);
    return locala;
  }
  
  final void ayZ()
  {
    AppMethodBeat.i(272048);
    while (!this.jyH.compareAndSet(false, true))
    {
      com.tencent.mm.danmaku.e.e.d("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
    AppMethodBeat.o(272048);
  }
  
  final void aza()
  {
    AppMethodBeat.i(272049);
    while (!this.jyH.compareAndSet(true, false))
    {
      com.tencent.mm.danmaku.e.e.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
    AppMethodBeat.o(272049);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(272047);
    com.tencent.mm.danmaku.e.e.v("DanmakuDataSource", "clear danmaku queue");
    ayZ();
    this.jyG.clear();
    aza();
    AppMethodBeat.o(272047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.e
 * JD-Core Version:    0.7.0.1
 */