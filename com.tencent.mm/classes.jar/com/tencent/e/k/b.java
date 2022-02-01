package com.tencent.e.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/threadpool/stub/ThreadPoolImpl;", "", "()V", "implementation", "Lcom/tencent/threadpool/stub/IThreadPoolStub;", "implementation$annotations", "getImplementation", "()Lcom/tencent/threadpool/stub/IThreadPoolStub;", "setImplementation", "(Lcom/tencent/threadpool/stub/IThreadPoolStub;)V", "threadpool-stub_release"})
public final class b
{
  private static volatile a ZxJ;
  public static final b ZxK;
  
  static
  {
    AppMethodBeat.i(255062);
    ZxK = new b();
    ZxJ = (a)c.ZxO;
    AppMethodBeat.o(255062);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(255059);
    p.k(parama, "<set-?>");
    ZxJ = parama;
    AppMethodBeat.o(255059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.k.b
 * JD-Core Version:    0.7.0.1
 */