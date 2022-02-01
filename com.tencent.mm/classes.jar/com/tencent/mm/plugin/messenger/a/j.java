package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
{
  public static e uGj;
  
  public static e dck()
  {
    AppMethodBeat.i(94806);
    if (uGj == null) {
      uGj = new b();
    }
    if ((uGj instanceof b)) {
      ac.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    e locale = uGj;
    AppMethodBeat.o(94806);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.j
 * JD-Core Version:    0.7.0.1
 */