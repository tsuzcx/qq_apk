package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  public static d KPJ;
  
  public static d gaI()
  {
    AppMethodBeat.i(94806);
    if (KPJ == null) {
      KPJ = new b();
    }
    if ((KPJ instanceof b)) {
      Log.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    d locald = KPJ;
    AppMethodBeat.o(94806);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */