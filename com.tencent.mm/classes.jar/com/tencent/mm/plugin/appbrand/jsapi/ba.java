package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    paramJSONObject = new dua();
    paramJSONObject.appId = paramc.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.a)paramc.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, dub.class).c(new com.tencent.mm.vending.c.a()
    {
      private Object a(dub paramAnonymousdub)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousdub == null)
        {
          ad.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramc.h(paramInt, ba.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousdub.BaseResponse.Ret != 0)
        {
          ad.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousdub.BaseResponse.Ret), paramAnonymousdub.BaseResponse.ErrMsg });
          paramc.h(paramInt, ba.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousdub.EIA;
          paramAnonymousdub = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            gl localgl = (gl)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localgl.scope);
              localJSONObject.put("state", localgl.state);
              localJSONObject.put("desc", localgl.CAX);
              paramAnonymousdub.put(localJSONObject);
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramc.h(paramInt, ba.this.e("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousdub) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousdub.toString();
          ad.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousdub });
          paramAnonymousdub = new JSONObject();
          try
          {
            paramAnonymousdub.put("errMsg", "getSetting:ok");
            paramAnonymousdub.put("authSetting", new JSONArray(bt.nullAsNil((String)localObject)));
            paramc.h(paramInt, paramAnonymousdub.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousdub)
          {
            ad.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousdub, "set json error!", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(147138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */