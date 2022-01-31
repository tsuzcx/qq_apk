package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.tencent.matrix.trace.core.AppMethodBeat;

class r$c
  extends r.b
  implements Runnable
{
  final long cco;
  final boolean ccp;
  final V8Array ccq;
  
  r$c(r paramr, l paraml, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
  {
    super(paramr, paraml, paramInt, paramV8Function);
    this.cco = paramLong;
    this.ccp = paramBoolean;
    this.ccq = paramV8Array;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(113881);
    super.cleanup();
    this.ccq.release();
    AppMethodBeat.o(113881);
  }
  
  public void run()
  {
    AppMethodBeat.i(113880);
    if (!isValid())
    {
      AppMethodBeat.o(113880);
      return;
    }
    a(this.ccq);
    if (!isValid())
    {
      AppMethodBeat.o(113880);
      return;
    }
    if (this.ccp)
    {
      schedule();
      AppMethodBeat.o(113880);
      return;
    }
    cleanup();
    AppMethodBeat.o(113880);
  }
  
  void schedule()
  {
    AppMethodBeat.i(113879);
    this.ccm.cbC.f(this, this.cco);
    AppMethodBeat.o(113879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.r.c
 * JD-Core Version:    0.7.0.1
 */