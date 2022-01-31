package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  boolean hKA;
  private String hKu;
  String hKv;
  String hKw;
  String hKx;
  boolean hKy;
  String hKz;
  private String sessionFrom;
  
  private void a(z paramz, AppBrandSysConfigWC paramAppBrandSysConfigWC, e.a parama)
  {
    AppMethodBeat.i(131007);
    String str = paramz.getRuntime().atS().username;
    if ((paramAppBrandSysConfigWC == null) || (bo.isNullOrNil(str)))
    {
      ab.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(131007);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aqf();
    ((b.a)localObject).fsY = new aqg();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((b.a)localObject).funcId = 1303;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    aqf localaqf = (aqf)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localaqf.username = str;
    localaqf.xfD = this.hKu;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new e.2(this, parama, paramz, paramAppBrandSysConfigWC));
    AppMethodBeat.o(131007);
  }
  
  private void a(z paramz, com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131005);
    a(paramz, paramJSONObject, new e.1(this, paramc, paramInt));
    AppMethodBeat.o(131005);
  }
  
  private void a(z paramz, JSONObject paramJSONObject, e.a parama)
  {
    AppMethodBeat.i(131006);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(131006);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramz.getRuntime().atR();
    if (localAppBrandSysConfigWC == null)
    {
      ab.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(131006);
      return;
    }
    this.sessionFrom = paramJSONObject.optString("sessionFrom");
    if (this.sessionFrom.length() > 1024)
    {
      this.sessionFrom = this.sessionFrom.substring(0, 1024);
      ab.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.hKu = paramJSONObject.optString("businessId");
    this.hKv = paramJSONObject.optString("sendMessageTitle");
    this.hKw = paramJSONObject.optString("sendMessagePath");
    this.hKx = paramJSONObject.optString("sendMessageImg");
    this.hKy = paramJSONObject.optBoolean("showMessageCard", false);
    this.hKA = l.CM(this.hKx);
    this.hKz = l.a(paramz, this.hKx, true);
    if (bo.isNullOrNil(this.hKu))
    {
      ab.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramz, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(131006);
      return;
    }
    ab.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramz, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(131006);
  }
  
  private static String b(com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    AppMethodBeat.i(131011);
    String str = "";
    if (paramv != null) {
      str = paramv.hzM;
    }
    ab.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(131011);
    return str;
  }
  
  private static String cc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131009);
    if (!bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(131009);
      return "";
    }
    if (!bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(131009);
      return paramString1;
    }
    ab.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(131009);
    return "";
  }
  
  private static String cd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131010);
    if (!bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(131010);
      return paramString2;
    }
    if (!bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(131010);
      return paramString1;
    }
    ab.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(131010);
    return "";
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131004);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramc = (com.tencent.mm.plugin.appbrand.service.c)paramc;
      z localz = paramc.aLy();
      if (localz == null)
      {
        ab.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramc.h(paramInt, j("fail:current page do not exist", null));
        AppMethodBeat.o(131004);
        return;
      }
      a(localz, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(131004);
      return;
    }
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.page.v))
    {
      a((z)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(131004);
      return;
    }
    paramc.h(paramInt, j("fail:internal error invalid js component", null));
    AppMethodBeat.o(131004);
  }
  
  final void a(z paramz, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, e.a parama)
  {
    AppMethodBeat.i(131008);
    JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramz.getRuntime().atS().username;
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramz.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.cqQ;
    locala.iconUrl = paramAppBrandSysConfigWC.hiQ;
    locala.gXe = paramAppBrandSysConfigWC.hiX.gXe;
    locala.gXf = paramAppBrandSysConfigWC.hiX.gXf;
    locala.hko = paramAppBrandSysConfigWC.hiX.cqq;
    locala.from = 5;
    locala.pageId = b(paramz);
    locala.hkp = com.tencent.mm.plugin.appbrand.v.yg(paramz.getAppId());
    localJsApiChattingTask.username = cd(str, paramString);
    localJsApiChattingTask.nickname = cc(paramAppBrandSysConfigWC.cqQ, paramString);
    localJsApiChattingTask.sessionFrom = this.sessionFrom;
    localJsApiChattingTask.hxp = new e.3(this, localJsApiChattingTask, locala, paramz, parama);
    localJsApiChattingTask.aBj();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(131008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */