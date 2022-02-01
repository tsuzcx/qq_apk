package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
{
  public static e txL;
  
  public static e cOB()
  {
    AppMethodBeat.i(94806);
    if (txL == null) {
      txL = new b();
    }
    if ((txL instanceof b)) {
      ad.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    e locale = txL;
    AppMethodBeat.o(94806);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.j
 * JD-Core Version:    0.7.0.1
 */