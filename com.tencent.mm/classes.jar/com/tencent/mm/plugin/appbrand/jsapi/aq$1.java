package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class aq$1
  implements a<Object, czl>
{
  aq$1(aq paramaq, c paramc, int paramInt) {}
  
  private Object a(czl paramczl)
  {
    AppMethodBeat.i(101944);
    if (paramczl == null)
    {
      ab.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
      this.hxW.h(this.bAX, this.hxX.j("fail:cgi fail", null));
      AppMethodBeat.o(101944);
      return null;
    }
    if (paramczl.BaseResponse.Ret != 0)
    {
      ab.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramczl.BaseResponse.Ret), paramczl.BaseResponse.ErrMsg });
      this.hxW.h(this.bAX, this.hxX.j("fail:cgi fail", null));
      AppMethodBeat.o(101944);
      return null;
    }
    Object localObject;
    try
    {
      localObject = paramczl.ygk;
      paramczl = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        fs localfs = (fs)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("scope", localfs.scope);
          localJSONObject.put("state", localfs.state);
          localJSONObject.put("desc", localfs.wrI);
          paramczl.put(localJSONObject);
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
        }
        continue;
        this.hxW.h(this.bAX, this.hxX.j("fail:resp invalid", null));
      }
    }
    catch (Exception paramczl) {}
    for (;;)
    {
      AppMethodBeat.o(101944);
      return null;
      localObject = paramczl.toString();
      ab.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramczl });
      paramczl = new JSONObject();
      try
      {
        paramczl.put("errMsg", "getSetting:ok");
        paramczl.put("authSetting", new JSONArray(bo.nullAsNil((String)localObject)));
        this.hxW.h(this.bAX, paramczl.toString());
        AppMethodBeat.o(101944);
        return null;
      }
      catch (JSONException paramczl)
      {
        ab.printErrStackTrace("MicroMsg.JsApiGetSetting", paramczl, "set json error!", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aq.1
 * JD-Core Version:    0.7.0.1
 */