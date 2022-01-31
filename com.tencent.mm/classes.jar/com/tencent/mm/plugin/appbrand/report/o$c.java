package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;

final class o$c
  extends k
{
  private o$c(o paramo) {}
  
  public final String getName()
  {
    AppMethodBeat.i(114403);
    String str = this.iGm.mName + "|Init";
    AppMethodBeat.o(114403);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(114404);
    if (2 == paramMessage.what)
    {
      this.iGm.b(this.iGm.iGi);
      AppMethodBeat.o(114404);
      return true;
    }
    if (1 == paramMessage.what)
    {
      this.iGm.b(this.iGm.iGj);
      AppMethodBeat.o(114404);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(114404);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o.c
 * JD-Core Version:    0.7.0.1
 */