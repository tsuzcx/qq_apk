package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bo;

final class o$a
  extends k
{
  private long iGl;
  
  private o$a(o paramo) {}
  
  public final void enter()
  {
    AppMethodBeat.i(114397);
    super.enter();
    this.iGl = bo.aoy();
    AppMethodBeat.o(114397);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(114398);
    super.exit();
    this.iGm.iGf = (bo.aoy() - this.iGl);
    AppMethodBeat.o(114398);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(114395);
    String str = this.iGm.mName + "|Background";
    AppMethodBeat.o(114395);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(114396);
    if (2 == paramMessage.what)
    {
      this.iGm.b(this.iGm.iGi);
      AppMethodBeat.o(114396);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(114396);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o.a
 * JD-Core Version:    0.7.0.1
 */