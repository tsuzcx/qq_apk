package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fnf;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bk
  extends c
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147138);
    paramJSONObject = new fnf();
    paramJSONObject.appId = parame.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.c)parame.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, fng.class).c(new a()
    {
      private Object a(fng paramAnonymousfng)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousfng == null)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          parame.j(paramInt, bk.this.h("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousfng.BaseResponse.CqV != 0)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousfng.BaseResponse.CqV), paramAnonymousfng.BaseResponse.Tef });
          parame.j(paramInt, bk.this.h("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousfng.ULH;
          paramAnonymousfng = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            gz localgz = (gz)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localgz.scope);
              localJSONObject.put("state", localgz.state);
              localJSONObject.put("desc", localgz.RLP);
              paramAnonymousfng.put(localJSONObject);
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            parame.j(paramInt, bk.this.h("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousfng) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousfng.toString();
          Log.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousfng });
          paramAnonymousfng = new JSONObject();
          try
          {
            paramAnonymousfng.put("errMsg", "getSetting:ok");
            paramAnonymousfng.put("authSetting", new JSONArray(Util.nullAsNil((String)localObject)));
            parame.j(paramInt, paramAnonymousfng.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousfng)
          {
            Log.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousfng, "set json error!", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(147138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bk
 * JD-Core Version:    0.7.0.1
 */