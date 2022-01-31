package com.tencent.mm.plugin.appbrand.t;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.k;

final class h$b
  extends k
{
  private h$b(h paramh) {}
  
  public final void enter()
  {
    AppMethodBeat.i(73198);
    super.enter();
    h.a(this.iXJ);
    AppMethodBeat.o(73198);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(73200);
    String str = this.iXJ.iXH + "|StateIdle";
    AppMethodBeat.o(73200);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(73199);
    if ((1 == paramMessage.what) || (2 == paramMessage.what))
    {
      h.a(this.iXJ);
      AppMethodBeat.o(73199);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(73199);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.h.b
 * JD-Core Version:    0.7.0.1
 */