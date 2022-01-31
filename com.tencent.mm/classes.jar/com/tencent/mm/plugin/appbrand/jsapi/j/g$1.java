package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class g$1
  implements com.tencent.mm.plugin.appbrand.m.g.a
{
  private JSONObject hTK;
  private JSONArray hTL;
  
  g$1(g paramg, c paramc, String paramString1, String paramString2) {}
  
  public final void CE(String paramString)
  {
    AppMethodBeat.i(108052);
    if (g.j(this.hxW, this.hUa))
    {
      AppMethodBeat.o(108052);
      return;
    }
    g.a(this.hxW, this.hUa, paramString);
    AppMethodBeat.o(108052);
  }
  
  public final void h(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108054);
    Object localObject = new HashMap();
    ((Map)localObject).put("uploadTaskId", this.hUa);
    ((Map)localObject).put("state", "progressUpdate");
    ((Map)localObject).put("progress", Integer.valueOf(paramInt));
    ((Map)localObject).put("totalBytesSent", Long.valueOf(paramLong1));
    ((Map)localObject).put("totalBytesExpectedToSend", Long.valueOf(paramLong2));
    localObject = new JSONObject((Map)localObject).toString();
    new g.a().j(this.hxW).BN((String)localObject).aBz();
    AppMethodBeat.o(108054);
  }
  
  public final void h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(108053);
    if (paramInt1 == 0)
    {
      ab.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", new Object[] { this.val$filePath, paramString, Integer.valueOf(paramInt1) });
      HashMap localHashMap = new HashMap();
      localHashMap.put("data", paramString);
      localHashMap.put("statusCode", Integer.valueOf(paramInt2));
      localHashMap.put("uploadTaskId", this.hUa);
      localHashMap.put("state", "success");
      if (this.hTK != null) {
        localHashMap.put("header", this.hTK);
      }
      if (this.hTL != null) {
        localHashMap.put("cookies", this.hTL);
      }
      paramString = new JSONObject(localHashMap).toString();
      new g.a().j(this.hxW).BN(paramString).aBz();
      AppMethodBeat.o(108053);
      return;
    }
    if (g.j(this.hxW, this.hUa))
    {
      AppMethodBeat.o(108053);
      return;
    }
    ab.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", new Object[] { this.val$filePath, paramString, Integer.valueOf(paramInt1) });
    g.a(this.hxW, this.hUa, paramString);
    AppMethodBeat.o(108053);
  }
  
  public final void v(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108055);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(108055);
      return;
    }
    if (paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
    {
      if (!((com.tencent.mm.plugin.appbrand.m.a)this.hxW.U(com.tencent.mm.plugin.appbrand.m.a.class)).bCW)
      {
        AppMethodBeat.o(108055);
        return;
      }
      paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
      m localm = new m();
      localm.cmz.cmA = "upload";
      localm.cmz.cmC = paramJSONObject;
      localm.cmz.cmB = this.hUa;
      com.tencent.mm.sdk.b.a.ymk.l(localm);
      AppMethodBeat.o(108055);
      return;
    }
    this.hTK = paramJSONObject;
    this.hTL = this.hTK.optJSONArray("cookies");
    paramJSONObject = new HashMap();
    paramJSONObject.put("uploadTaskId", this.hUa);
    paramJSONObject.put("state", "headersReceived");
    paramJSONObject.put("header", this.hTK);
    if (this.hTL != null) {
      paramJSONObject.put("cookies", this.hTL);
    }
    paramJSONObject = new JSONObject(paramJSONObject).toString();
    new g.a().j(this.hxW).BN(paramJSONObject).aBz();
    AppMethodBeat.o(108055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.g.1
 * JD-Core Version:    0.7.0.1
 */