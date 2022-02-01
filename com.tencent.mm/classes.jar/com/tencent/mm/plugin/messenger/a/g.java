package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
{
  public static d vVj;
  
  public static d doC()
  {
    AppMethodBeat.i(94806);
    if (vVj == null) {
      vVj = new b();
    }
    if ((vVj instanceof b)) {
      ae.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    d locald = vVj;
    AppMethodBeat.o(94806);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */