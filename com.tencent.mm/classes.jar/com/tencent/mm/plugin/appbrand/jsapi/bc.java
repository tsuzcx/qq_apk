package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ehm;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    paramJSONObject = new ehm();
    paramJSONObject.appId = paramc.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.c)paramc.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, ehn.class).c(new com.tencent.mm.vending.c.a()
    {
      private Object a(ehn paramAnonymousehn)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousehn == null)
        {
          ae.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramc.h(paramInt, bc.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousehn.BaseResponse.Ret != 0)
        {
          ae.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousehn.BaseResponse.Ret), paramAnonymousehn.BaseResponse.ErrMsg });
          paramc.h(paramInt, bc.this.e("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousehn.Ilc;
          paramAnonymousehn = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            gw localgw = (gw)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localgw.scope);
              localJSONObject.put("state", localgw.state);
              localJSONObject.put("desc", localgw.FRm);
              paramAnonymousehn.put(localJSONObject);
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramc.h(paramInt, bc.this.e("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousehn) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousehn.toString();
          ae.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousehn });
          paramAnonymousehn = new JSONObject();
          try
          {
            paramAnonymousehn.put("errMsg", "getSetting:ok");
            paramAnonymousehn.put("authSetting", new JSONArray(bu.nullAsNil((String)localObject)));
            paramc.h(paramInt, paramAnonymousehn.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousehn)
          {
            ae.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousehn, "set json error!", new Object[0]);
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