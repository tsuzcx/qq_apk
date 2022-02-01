package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l
  extends r
{
  public static final int CTRL_INDEX = 520;
  public static final String NAME = "onVoIPChatInterrupted";
  
  public l()
  {
    AppMethodBeat.i(180259);
    c.amg("onVoIPChatInterrupted");
    AppMethodBeat.o(180259);
  }
  
  private a b(q.a parama)
  {
    AppMethodBeat.i(270306);
    switch (1.pip[parama.ordinal()])
    {
    default: 
      parama = new a("unknown reason", -1000);
      AppMethodBeat.o(270306);
      return parama;
    case 1: 
      parama = new a("call interrupted due to native reason", -1000);
      AppMethodBeat.o(270306);
      return parama;
    case 2: 
      parama = new a("user manually exit the call", -1000);
      AppMethodBeat.o(270306);
      return parama;
    case 3: 
      parama = new a("device start failed", -1000);
      AppMethodBeat.o(270306);
      return parama;
    case 4: 
      parama = new a("in comming call", -2);
      AppMethodBeat.o(270306);
      return parama;
    case 5: 
      parama = new a("session update failed", -1000);
      AppMethodBeat.o(270306);
      return parama;
    case 6: 
      parama = new a("current mini app entered background", -1);
      AppMethodBeat.o(270306);
      return parama;
    }
    parama = new a("call interrupted due to close passive float ball", -3);
    AppMethodBeat.o(270306);
    return parama;
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(270303);
    Log.i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", new Object[] { parama });
    HashMap localHashMap = new HashMap(2);
    parama = b(parama);
    localHashMap.put("errMsg", parama.dbT + ", room id: " + q.tRM.tSr);
    localHashMap.put("errCode", Integer.valueOf(parama.errCode));
    localHashMap.put("reason", parama.dbT);
    D(localHashMap).bPO();
    AppMethodBeat.o(270303);
  }
  
  final class a
  {
    String dbT;
    int errCode;
    
    public a(String paramString, int paramInt)
    {
      this.dbT = paramString;
      this.errCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.l
 * JD-Core Version:    0.7.0.1
 */