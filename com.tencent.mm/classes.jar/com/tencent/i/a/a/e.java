package com.tencent.i.a.a;

import com.tencent.h.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private c SqM;
  
  public e(c paramc, String paramString)
  {
    super(paramString, (byte)0);
    AppMethodBeat.i(214684);
    this.SqM = paramc;
    if (this.SqM != null) {
      this.SqM.SqQ = this;
    }
    AppMethodBeat.o(214684);
  }
  
  public final void q(Throwable paramThrowable)
  {
    AppMethodBeat.i(214685);
    if ((this.SqM != null) && (this.SqM.SqP != null)) {
      this.SqM.SqP.b(paramThrowable, "turing async worker");
    }
    AppMethodBeat.o(214685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.a.e
 * JD-Core Version:    0.7.0.1
 */