package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.efv;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bc
  extends a
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147138);
    paramJSONObject = new efv();
    paramJSONObject.appId = paramc.getAppId();
    ((b)paramc.K(b.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, efw.class).c(new com.tencent.mm.vending.c.a()
    {
      private Object a(efw paramAnonymousefw)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousefw == null)
        {
          ad.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramc.h(paramInt, bc.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousefw.BaseResponse.Ret != 0)
        {
          ad.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousefw.BaseResponse.Ret), paramAnonymousefw.BaseResponse.ErrMsg });
          paramc.h(paramInt, bc.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousefw.HQV;
          paramAnonymousefw = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            gw localgw = (gw)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localgw.scope);
              localJSONObject.put("state", localgw.state);
              localJSONObject.put("desc", localgw.FyO);
              paramAnonymousefw.put(localJSONObject);
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramc.h(paramInt, bc.this.e("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousefw) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousefw.toString();
          ad.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousefw });
          paramAnonymousefw = new JSONObject();
          try
          {
            paramAnonymousefw.put("errMsg", "getSetting:ok");
            paramAnonymousefw.put("authSetting", new JSONArray(bt.nullAsNil((String)localObject)));
            paramc.h(paramInt, paramAnonymousefw.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousefw)
          {
            ad.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousefw, "set json error!", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(147138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */