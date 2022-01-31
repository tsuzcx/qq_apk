package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  extends com.tencent.mm.sdk.b.c<kl>
{
  c$3(c paramc, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
  {
    AppMethodBeat.i(131033);
    this.__eventId = kl.class.getName().hashCode();
    AppMethodBeat.o(131033);
  }
  
  private boolean a(kl paramkl)
  {
    AppMethodBeat.i(131034);
    int i = paramkl.cAi.errCode;
    HashMap localHashMap;
    if (i < 0)
    {
      localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(i));
      if (i == d.hLH.errCode)
      {
        paramkl = d.hLH.errMsg;
        ab.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram fail, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(i), paramkl });
        this.hLy.h(this.bAX, this.hLz.j(paramkl, localHashMap));
      }
    }
    for (;;)
    {
      dead();
      AppMethodBeat.o(131034);
      return false;
      if (i == d.hLI.errCode)
      {
        paramkl = d.hLI.errMsg;
        break;
      }
      if (i == d.hLJ.errCode)
      {
        paramkl = d.hLJ.errMsg;
        break;
      }
      paramkl = d.hLG.errMsg;
      break;
      localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(i));
      paramkl = bo.bf(paramkl.cAi.cAh, "{}");
      try
      {
        paramkl = new JSONObject(paramkl);
        localHashMap.put("extraData", paramkl);
        ab.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram success");
        this.hLy.h(this.bAX, this.hLz.j(d.hLF.errMsg, localHashMap));
      }
      catch (JSONException paramkl)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram, parse extraData fail", new Object[] { paramkl });
          paramkl = new JSONObject();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.3
 * JD-Core Version:    0.7.0.1
 */