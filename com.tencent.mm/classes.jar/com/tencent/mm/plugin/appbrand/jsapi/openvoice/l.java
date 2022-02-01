package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l
  extends s
{
  public static final int CTRL_INDEX = 520;
  public static final String NAME = "onVoIPChatInterrupted";
  
  public l()
  {
    AppMethodBeat.i(180259);
    c.afo("onVoIPChatInterrupted");
    AppMethodBeat.o(180259);
  }
  
  private a b(q.a parama)
  {
    AppMethodBeat.i(326332);
    switch (1.snH[parama.ordinal()])
    {
    default: 
      parama = new a("unknown reason", -1000);
      AppMethodBeat.o(326332);
      return parama;
    case 1: 
      parama = new a("call interrupted due to native reason", -1000);
      AppMethodBeat.o(326332);
      return parama;
    case 2: 
      parama = new a("user manually exit the call", -1000);
      AppMethodBeat.o(326332);
      return parama;
    case 3: 
      parama = new a("device start failed", -1000);
      AppMethodBeat.o(326332);
      return parama;
    case 4: 
      parama = new a("in comming call", -2);
      AppMethodBeat.o(326332);
      return parama;
    case 5: 
      parama = new a("session update failed", -1000);
      AppMethodBeat.o(326332);
      return parama;
    case 6: 
      parama = new a("current mini app entered background", -1);
      AppMethodBeat.o(326332);
      return parama;
    }
    parama = new a("call interrupted due to close passive float ball", -3);
    AppMethodBeat.o(326332);
    return parama;
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(326335);
    Log.i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", new Object[] { parama });
    HashMap localHashMap = new HashMap(2);
    parama = b(parama);
    localHashMap.put("errMsg", parama.fas + ", room id: " + q.wVc.wVI);
    localHashMap.put("errCode", Integer.valueOf(parama.errCode));
    localHashMap.put("reason", parama.fas);
    K(localHashMap).cpV();
    AppMethodBeat.o(326335);
  }
  
  final class a
  {
    int errCode;
    String fas;
    
    public a(String paramString, int paramInt)
    {
      this.fas = paramString;
      this.errCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.l
 * JD-Core Version:    0.7.0.1
 */