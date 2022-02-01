package com.tencent.mm.danmaku.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class f
{
  com.tencent.mm.danmaku.c.a jxO;
  final SparseArray<BlockingQueue<com.tencent.mm.danmaku.b.a>> jyK;
  private final BlockingQueue<com.tencent.mm.danmaku.b.a> jyL;
  
  public f(com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(266100);
    this.jyK = new SparseArray();
    this.jyL = new LinkedBlockingQueue();
    this.jxO = parama;
    AppMethodBeat.o(266100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.f
 * JD-Core Version:    0.7.0.1
 */