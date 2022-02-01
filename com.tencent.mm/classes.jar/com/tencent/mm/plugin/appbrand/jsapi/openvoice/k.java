package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.p
{
  public static final int CTRL_INDEX = 520;
  public static final String NAME = "onVoIPChatInterrupted";
  
  public k()
  {
    AppMethodBeat.i(180259);
    c.Qk("onVoIPChatInterrupted");
    AppMethodBeat.o(180259);
  }
  
  private a b(p.a parama)
  {
    AppMethodBeat.i(186737);
    switch (1.kEX[parama.ordinal()])
    {
    default: 
      parama = new a("unknown reason", -1000);
      AppMethodBeat.o(186737);
      return parama;
    case 1: 
      parama = new a("call interrupted due to native reason", -1000);
      AppMethodBeat.o(186737);
      return parama;
    case 2: 
      parama = new a("user manually exit the call", -1000);
      AppMethodBeat.o(186737);
      return parama;
    case 3: 
      parama = new a("device start failed", -1000);
      AppMethodBeat.o(186737);
      return parama;
    case 4: 
      parama = new a("in comming call", -2);
      AppMethodBeat.o(186737);
      return parama;
    case 5: 
      parama = new a("session update failed", -1000);
      AppMethodBeat.o(186737);
      return parama;
    case 6: 
      parama = new a("current mini app entered background", -1);
      AppMethodBeat.o(186737);
      return parama;
    }
    parama = new a("call interrupted due to close passive float ball", -3);
    AppMethodBeat.o(186737);
    return parama;
  }
  
  public final void a(p.a parama)
  {
    AppMethodBeat.i(186736);
    ac.i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", new Object[] { parama });
    HashMap localHashMap = new HashMap(2);
    parama = b(parama);
    localHashMap.put("errMsg", parama.cvQ + ", room id: " + com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouE);
    localHashMap.put("errCode", Integer.valueOf(parama.errCode));
    localHashMap.put("reason", parama.cvQ);
    A(localHashMap).beN();
    AppMethodBeat.o(186736);
  }
  
  final class a
  {
    String cvQ;
    int errCode;
    
    public a(String paramString, int paramInt)
    {
      this.cvQ = paramString;
      this.errCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.k
 * JD-Core Version:    0.7.0.1
 */