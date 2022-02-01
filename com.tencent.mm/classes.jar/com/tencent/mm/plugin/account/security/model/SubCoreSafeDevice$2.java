package com.tencent.mm.plugin.account.security.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.autogen.a.abs.a;
import com.tencent.mm.sdk.event.IListener;

class SubCoreSafeDevice$2
  extends IListener<abs>
{
  SubCoreSafeDevice$2(g paramg, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(304849);
    this.__eventId = abs.class.getName().hashCode();
    AppMethodBeat.o(304849);
  }
  
  private static boolean a(abs paramabs)
  {
    AppMethodBeat.i(125530);
    f.y(paramabs.ifi.hAJ, paramabs.ifi.ifj);
    AppMethodBeat.o(125530);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.SubCoreSafeDevice.2
 * JD-Core Version:    0.7.0.1
 */