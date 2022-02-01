package com.tencent.mm.danmaku.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class f
{
  com.tencent.mm.danmaku.c.a gNt;
  final SparseArray<BlockingQueue<com.tencent.mm.danmaku.b.a>> gOp;
  private final BlockingQueue<com.tencent.mm.danmaku.b.a> gOq;
  
  public f(com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(241643);
    this.gOp = new SparseArray();
    this.gOq = new LinkedBlockingQueue();
    this.gNt = parama;
    AppMethodBeat.o(241643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.f
 * JD-Core Version:    0.7.0.1
 */