package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba
  extends a
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147138);
    paramJSONObject = new dzr();
    paramJSONObject.appId = paramc.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.a)paramc.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, dzs.class).c(new com.tencent.mm.vending.c.a()
    {
      private Object a(dzs paramAnonymousdzs)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousdzs == null)
        {
          ac.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramc.h(paramInt, ba.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousdzs.BaseResponse.Ret != 0)
        {
          ac.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousdzs.BaseResponse.Ret), paramAnonymousdzs.BaseResponse.ErrMsg });
          paramc.h(paramInt, ba.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousdzs.GfM;
          paramAnonymousdzs = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            gp localgp = (gp)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localgp.scope);
              localJSONObject.put("state", localgp.state);
              localJSONObject.put("desc", localgp.DTv);
              paramAnonymousdzs.put(localJSONObject);
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramc.h(paramInt, ba.this.e("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousdzs) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousdzs.toString();
          ac.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousdzs });
          paramAnonymousdzs = new JSONObject();
          try
          {
            paramAnonymousdzs.put("errMsg", "getSetting:ok");
            paramAnonymousdzs.put("authSetting", new JSONArray(bs.nullAsNil((String)localObject)));
            paramc.h(paramInt, paramAnonymousdzs.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousdzs)
          {
            ac.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousdzs, "set json error!", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(147138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */