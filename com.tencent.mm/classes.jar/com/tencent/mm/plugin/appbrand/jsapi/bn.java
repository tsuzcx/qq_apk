package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.protocal.protobuf.fcf;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn
  extends d
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147138);
    paramJSONObject = new fce();
    paramJSONObject.appId = paramf.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.c)paramf.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, fcf.class).c(new a()
    {
      private Object a(fcf paramAnonymousfcf)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousfcf == null)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramf.i(paramInt, bn.this.h("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousfcf.BaseResponse.Ret != 0)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousfcf.BaseResponse.Ret), paramAnonymousfcf.BaseResponse.ErrMsg });
          paramf.i(paramInt, bn.this.h("fail:cgi fail", null));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousfcf.Nye;
          paramAnonymousfcf = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            hj localhj = (hj)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localhj.scope);
              localJSONObject.put("state", localhj.state);
              localJSONObject.put("desc", localhj.KKT);
              paramAnonymousfcf.put(localJSONObject);
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramf.i(paramInt, bn.this.h("fail:resp invalid", null));
          }
        }
        catch (Exception paramAnonymousfcf) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousfcf.toString();
          Log.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousfcf });
          paramAnonymousfcf = new JSONObject();
          try
          {
            paramAnonymousfcf.put("errMsg", "getSetting:ok");
            paramAnonymousfcf.put("authSetting", new JSONArray(Util.nullAsNil((String)localObject)));
            paramf.i(paramInt, paramAnonymousfcf.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousfcf)
          {
            Log.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousfcf, "set json error!", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(147138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bn
 * JD-Core Version:    0.7.0.1
 */