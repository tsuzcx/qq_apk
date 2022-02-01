package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pa;
import com.tencent.mm.autogen.a.pa.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOpenBusinessView$3
  extends IListener<pa>
{
  JsApiOpenBusinessView$3(d paramd, q paramq, g paramg, int paramInt)
  {
    super(paramq);
    AppMethodBeat.i(326564);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(326564);
  }
  
  private boolean a(pa parampa)
  {
    AppMethodBeat.i(46289);
    int i = parampa.hRS.errCode;
    HashMap localHashMap;
    if (i < 0)
    {
      localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(i));
      if (i == f.rWS.errCode)
      {
        parampa = f.rWS.errMsg;
        Log.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram fail, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(i), parampa });
        this.rzm.callback(this.elZ, this.rWJ.m(parampa, localHashMap));
      }
    }
    for (;;)
    {
      dead();
      AppMethodBeat.o(46289);
      return false;
      if (i == f.rWT.errCode)
      {
        parampa = f.rWT.errMsg;
        break;
      }
      if (i == f.rWU.errCode)
      {
        parampa = f.rWU.errMsg;
        break;
      }
      parampa = f.rWR.errMsg;
      break;
      localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(i));
      parampa = Util.nullAs(parampa.hRS.hRR, "{}");
      try
      {
        parampa = new JSONObject(parampa);
        localHashMap.put("extraData", parampa);
        Log.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram success");
        this.rzm.callback(this.elZ, this.rWJ.m(f.rWQ.errMsg, localHashMap));
      }
      catch (JSONException parampa)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram, parse extraData fail", new Object[] { parampa });
          parampa = new JSONObject();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiOpenBusinessView.3
 * JD-Core Version:    0.7.0.1
 */