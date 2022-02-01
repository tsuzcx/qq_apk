package com.tencent.h.a.a;

import com.tencent.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private c ZSp;
  
  public e(c paramc, String paramString)
  {
    super(paramString, (byte)0);
    AppMethodBeat.i(208560);
    this.ZSp = paramc;
    if (this.ZSp != null) {
      this.ZSp.ZSt = this;
    }
    AppMethodBeat.o(208560);
  }
  
  public final void q(Throwable paramThrowable)
  {
    AppMethodBeat.i(208562);
    if ((this.ZSp != null) && (this.ZSp.ZSs != null)) {
      this.ZSp.ZSs.b(paramThrowable, "turing async worker");
    }
    AppMethodBeat.o(208562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.a.e
 * JD-Core Version:    0.7.0.1
 */