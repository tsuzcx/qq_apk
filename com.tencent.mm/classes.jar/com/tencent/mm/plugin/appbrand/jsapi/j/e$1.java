package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.d.a;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class e$1
  implements d.a
{
  e$1(e parame, long paramLong, c paramc, String paramString) {}
  
  public final void CC(String paramString)
  {
    AppMethodBeat.i(108030);
    long l1 = System.currentTimeMillis();
    long l2 = this.hTO;
    if (paramString == null) {}
    for (int i = 0;; i = paramString.length())
    {
      ab.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i) });
      d locald = f.aIk().DS(this.hxW.getAppId());
      if ((locald == null) || (!locald.DN(this.hTP))) {
        break;
      }
      ab.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", new Object[] { this.hTP });
      AppMethodBeat.o(108030);
      return;
    }
    e.a(this.hxW, this.hTP, paramString);
    ((o)com.tencent.luggage.a.e.r(o.class)).AW(this.hxW.getAppId());
    AppMethodBeat.o(108030);
  }
  
  public final void a(String paramString, Object paramObject, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108031);
    int i;
    if ((paramObject != null) && ((paramObject instanceof ByteBuffer))) {
      i = ((ByteBuffer)paramObject).array().length;
    }
    for (;;)
    {
      ab.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.hTO), Integer.valueOf(i), Integer.valueOf(paramInt), this.hTP });
      HashMap localHashMap = new HashMap();
      localHashMap.put("requestTaskId", this.hTP);
      if (paramString.equalsIgnoreCase("ok"))
      {
        localHashMap.put("state", "success");
        localHashMap.put("data", paramObject);
      }
      for (;;)
      {
        localHashMap.put("statusCode", Integer.valueOf(paramInt));
        if (paramJSONObject != null) {
          localHashMap.put("header", paramJSONObject);
        }
        paramString = paramJSONObject.optJSONArray("cookies");
        if (paramString != null) {
          localHashMap.put("cookies", paramString);
        }
        paramString = new e.a();
        paramJSONObject = q.a(this.hxW.aAO(), localHashMap, (q.a)this.hxW.U(q.a.class));
        if (((paramObject == null) || (!(paramObject instanceof String))) && (paramJSONObject != q.b.iXY)) {
          break label311;
        }
        paramObject = new JSONObject(localHashMap).toString();
        paramString.j(this.hxW).BN(paramObject).aBz();
        AppMethodBeat.o(108031);
        return;
        if ((paramObject == null) || (!(paramObject instanceof String))) {
          break label334;
        }
        i = ((String)paramObject).length();
        break;
        localHashMap.put("state", "fail");
      }
      label311:
      if (paramJSONObject == q.b.iXZ) {
        q.l(this.hxW, "onRequestTaskStateChange");
      }
      AppMethodBeat.o(108031);
      return;
      label334:
      i = 0;
    }
  }
  
  public final void v(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108032);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(108032);
      return;
    }
    if (paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
    {
      if (!((com.tencent.mm.plugin.appbrand.m.a)this.hxW.U(com.tencent.mm.plugin.appbrand.m.a.class)).bCW)
      {
        AppMethodBeat.o(108032);
        return;
      }
      paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
      localObject = new m();
      ((m)localObject).cmz.cmA = "request";
      ((m)localObject).cmz.cmC = paramJSONObject;
      ((m)localObject).cmz.cmB = this.hTP;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      AppMethodBeat.o(108032);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestTaskId", this.hTP);
    ((Map)localObject).put("state", "headersReceived");
    ((Map)localObject).put("header", paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("cookies");
    if (paramJSONObject != null) {
      ((Map)localObject).put("cookies", paramJSONObject);
    }
    paramJSONObject = new e.a();
    localObject = new JSONObject((Map)localObject).toString();
    paramJSONObject.j(this.hxW).BN((String)localObject).aBz();
    AppMethodBeat.o(108032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.e.1
 * JD-Core Version:    0.7.0.1
 */