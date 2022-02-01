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
  final f gNv;
  final List<a> gOk;
  final g<a> gOl;
  private final AtomicBoolean gOm;
  volatile long gOn;
  
  public e(f paramf, g.a parama)
  {
    AppMethodBeat.i(241637);
    this.gOn = -1L;
    this.gNv = paramf;
    this.gOl = new g(parama, new g.b() {});
    this.gOk = new LinkedList();
    this.gOm = new AtomicBoolean(false);
    AppMethodBeat.o(241637);
  }
  
  final void aa(List<a> paramList)
  {
    AppMethodBeat.i(241638);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if (locala.getTime() <= this.gOn) {
        locala.asu();
      }
      i -= 1;
    }
    AppMethodBeat.o(241638);
  }
  
  public final a asl()
  {
    AppMethodBeat.i(241639);
    a locala = (a)this.gOl.peekFirst();
    AppMethodBeat.o(241639);
    return locala;
  }
  
  final void asm()
  {
    AppMethodBeat.i(241641);
    while (!this.gOm.compareAndSet(false, true))
    {
      com.tencent.mm.danmaku.e.e.d("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
    AppMethodBeat.o(241641);
  }
  
  final void asn()
  {
    AppMethodBeat.i(241642);
    while (!this.gOm.compareAndSet(true, false))
    {
      com.tencent.mm.danmaku.e.e.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
    AppMethodBeat.o(241642);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(241640);
    com.tencent.mm.danmaku.e.e.v("DanmakuDataSource", "clear danmaku queue");
    asm();
    this.gOl.clear();
    asn();
    AppMethodBeat.o(241640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.e
 * JD-Core Version:    0.7.0.1
 */