package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
{
  public static d oCX;
  
  public static d bPJ()
  {
    AppMethodBeat.i(111118);
    if (oCX == null) {
      oCX = new b();
    }
    if ((oCX instanceof b)) {
      ab.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    d locald = oCX;
    AppMethodBeat.o(111118);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */