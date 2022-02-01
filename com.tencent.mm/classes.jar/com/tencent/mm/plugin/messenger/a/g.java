package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  public static d zpo;
  
  public static d eir()
  {
    AppMethodBeat.i(94806);
    if (zpo == null) {
      zpo = new b();
    }
    if ((zpo instanceof b)) {
      Log.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    d locald = zpo;
    AppMethodBeat.o(94806);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */