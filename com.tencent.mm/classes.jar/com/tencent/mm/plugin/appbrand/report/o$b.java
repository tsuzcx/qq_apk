package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bo;

final class o$b
  extends k
{
  private long iGn;
  
  private o$b(o paramo) {}
  
  public final void enter()
  {
    AppMethodBeat.i(114401);
    super.enter();
    this.iGn = bo.aoy();
    AppMethodBeat.o(114401);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(114402);
    super.exit();
    this.iGm.iGg = (bo.aoy() - this.iGn);
    AppMethodBeat.o(114402);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(114399);
    String str = this.iGm.mName + "|Foreground";
    AppMethodBeat.o(114399);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(114400);
    if (1 == paramMessage.what)
    {
      this.iGm.b(this.iGm.iGj);
      AppMethodBeat.o(114400);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(114400);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o.b
 * JD-Core Version:    0.7.0.1
 */