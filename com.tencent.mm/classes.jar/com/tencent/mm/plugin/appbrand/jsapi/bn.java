package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gjy;
import com.tencent.mm.protocal.protobuf.gjz;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn
  extends c
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147138);
    paramJSONObject = new gjy();
    paramJSONObject.appId = paramf.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.c)paramf.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, gjz.class).c(new a()
    {
      private Object a(gjz paramAnonymousgjz)
      {
        AppMethodBeat.i(147136);
        if (paramAnonymousgjz == null)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
          paramf.callback(paramInt, bn.this.ZP("fail:cgi fail"));
          AppMethodBeat.o(147136);
          return null;
        }
        if (paramAnonymousgjz.BaseResponse.Idd != 0)
        {
          Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousgjz.BaseResponse.Idd), paramAnonymousgjz.BaseResponse.akjO });
          paramf.callback(paramInt, bn.this.ZP("fail:cgi fail"));
          AppMethodBeat.o(147136);
          return null;
        }
        Object localObject;
        try
        {
          localObject = paramAnonymousgjz.acfU;
          paramAnonymousgjz = new JSONArray();
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            hu localhu = (hu)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("scope", localhu.scope);
              localJSONObject.put("state", localhu.state);
              localJSONObject.put("desc", localhu.YJc);
              paramAnonymousgjz.put(localJSONObject);
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
            }
            continue;
            paramf.callback(paramInt, bn.this.ZP("fail:resp invalid"));
          }
        }
        catch (Exception paramAnonymousgjz) {}
        for (;;)
        {
          AppMethodBeat.o(147136);
          return null;
          localObject = paramAnonymousgjz.toString();
          Log.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousgjz });
          paramAnonymousgjz = new JSONObject();
          try
          {
            paramAnonymousgjz.put("errMsg", "getSetting:ok");
            paramAnonymousgjz.put("authSetting", new JSONArray(Util.nullAsNil((String)localObject)));
            paramf.callback(paramInt, paramAnonymousgjz.toString());
            AppMethodBeat.o(147136);
            return null;
          }
          catch (JSONException paramAnonymousgjz)
          {
            Log.printErrStackTrace("MicroMsg.JsApiGetSetting", paramAnonymousgjz, "set json error!", new Object[0]);
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