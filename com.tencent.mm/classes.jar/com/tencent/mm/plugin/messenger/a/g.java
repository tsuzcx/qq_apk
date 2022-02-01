package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
{
  public static d vJf;
  
  public static d dlD()
  {
    AppMethodBeat.i(94806);
    if (vJf == null) {
      vJf = new b();
    }
    if ((vJf instanceof b)) {
      ad.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    d locald = vJf;
    AppMethodBeat.o(94806);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */