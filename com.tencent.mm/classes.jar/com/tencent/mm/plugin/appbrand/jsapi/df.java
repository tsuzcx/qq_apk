package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.fwg;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class df
  extends c<y>
{
  @Deprecated
  public static final int CTRL_INDEX = 313;
  @Deprecated
  public static final String NAME = "verifyPlugin";
  private static final a rBs;
  
  static
  {
    AppMethodBeat.i(147901);
    rBs = new a((byte)0);
    AppMethodBeat.o(147901);
  }
  
  private static final void a(String paramString, y paramy, int paramInt, df paramdf, fwg paramfwg)
  {
    AppMethodBeat.i(325494);
    s.u(paramString, "$commLogStr");
    s.u(paramy, "$service");
    s.u(paramdf, "this$0");
    if (paramfwg == null)
    {
      Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", s.X(paramString, " null response"));
      paramy.callback(paramInt, paramdf.ZP("fail:internal error"));
      AppMethodBeat.o(325494);
      return;
    }
    if (paramfwg.BaseResponse.Idd != 0)
    {
      Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", s.X(paramString, " cgi failed, errCode = %d, errMsg = %s"), new Object[] { Integer.valueOf(paramfwg.BaseResponse.Idd), paramfwg.BaseResponse.akjO });
      paramy.callback(paramInt, paramdf.ZP(s.X("fail cgi fail Ret=", Integer.valueOf(paramfwg.BaseResponse.Idd))));
      AppMethodBeat.o(325494);
      return;
    }
    HashMap localHashMap = new HashMap();
    try
    {
      Log.i("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", paramString + " cgi ok, dataSize[" + paramfwg.ZJq.length() + ']');
      ((Map)localHashMap).put("data", new JSONObject(paramfwg.ZJq));
      paramy.callback(paramInt, paramdf.m("ok", (Map)localHashMap));
      AppMethodBeat.o(325494);
      return;
    }
    catch (Exception paramfwg)
    {
      Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", paramString + " cgi ok but get exception[" + paramfwg + ']');
      paramy.callback(paramInt, paramdf.ZP(s.X("fail:internal error ", paramfwg)));
      AppMethodBeat.o(325494);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.df
 * JD-Core Version:    0.7.0.1
 */