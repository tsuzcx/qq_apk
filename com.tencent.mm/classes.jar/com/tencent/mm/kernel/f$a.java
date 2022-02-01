package com.tencent.mm.kernel;

import com.tencent.e.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;

public final class f$a
  implements e, Runnable
{
  public Future fuk;
  
  private f$a(f paramf) {}
  
  public final void a(Future paramFuture)
  {
    this.fuk = paramFuture;
  }
  
  public final void run()
  {
    AppMethodBeat.i(132070);
    this.kcV.aHr();
    AppMethodBeat.o(132070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.f.a
 * JD-Core Version:    0.7.0.1
 */