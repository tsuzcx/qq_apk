package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  private String gpL;
  String gpM;
  String gpN;
  String gpO;
  boolean gpP;
  String gpQ;
  boolean gpR;
  private String sessionFrom;
  
  private void a(q paramq, com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramc = new c.1(this, paramc, paramInt);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      paramc.a(false, "fail:invalid data", null);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramq.getRuntime().ZB();
    if (localAppBrandSysConfigWC == null)
    {
      y.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      paramc.a(false, "fail:config is null", null);
      return;
    }
    this.sessionFrom = paramJSONObject.optString("sessionFrom");
    if (this.sessionFrom.length() > 1024)
    {
      this.sessionFrom = this.sessionFrom.substring(0, 1024);
      y.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.gpL = paramJSONObject.optString("businessId");
    this.gpM = paramJSONObject.optString("sendMessageTitle");
    this.gpN = paramJSONObject.optString("sendMessagePath");
    this.gpO = paramJSONObject.optString("sendMessageImg");
    this.gpP = paramJSONObject.optBoolean("showMessageCard", false);
    this.gpR = k.uB(this.gpO);
    this.gpQ = k.a(paramq, this.gpO, true);
    if (bk.bl(this.gpL))
    {
      y.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramq, localAppBrandSysConfigWC, "", paramc);
      return;
    }
    y.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    if ((localAppBrandSysConfigWC == null) || (bk.bl(localAppBrandSysConfigWC.bFn)))
    {
      y.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      paramc.a(false, "fail:config is null", null);
      return;
    }
    paramJSONObject = new b.a();
    paramJSONObject.ecH = new aks();
    paramJSONObject.ecI = new akt();
    paramJSONObject.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    paramJSONObject.ecG = 1303;
    paramJSONObject.ecJ = 0;
    paramJSONObject.ecK = 0;
    paramJSONObject = paramJSONObject.Kt();
    aks localaks = (aks)paramJSONObject.ecE.ecN;
    localaks.username = localAppBrandSysConfigWC.bFn;
    localaks.tgP = this.gpL;
    com.tencent.mm.ipcinvoker.wx_extension.b.a(paramJSONObject, new c.2(this, paramc, paramq, localAppBrandSysConfigWC));
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramc instanceof o))
    {
      paramc = (o)paramc;
      q localq = paramc.E(q.class);
      if (localq == null)
      {
        y.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramc.C(paramInt, h("fail:current page do not exist", null));
        return;
      }
      a(localq, paramc, paramJSONObject, paramInt);
      return;
    }
    if ((paramc instanceof q))
    {
      a((q)paramc, paramc, paramJSONObject, paramInt);
      return;
    }
    y.w("MicroMsg.JsApiEnterContact", "not supprot");
  }
  
  final void a(q paramq, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, a parama)
  {
    JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramq.mAppId;
    locala.username = paramAppBrandSysConfigWC.bFn;
    locala.nickname = paramAppBrandSysConfigWC.bJw;
    locala.iconUrl = paramAppBrandSysConfigWC.fPM;
    locala.fEM = paramAppBrandSysConfigWC.fPS.fEM;
    locala.fEN = paramAppBrandSysConfigWC.fPS.fEN;
    locala.fRx = paramAppBrandSysConfigWC.fPS.bIW;
    locala.from = 5;
    Object localObject = "";
    if (paramq != null) {
      localObject = paramq.getURL();
    }
    y.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { localObject });
    locala.bUo = ((String)localObject);
    locala.fRy = r.qN(paramq.mAppId);
    String str = paramAppBrandSysConfigWC.bFn;
    if (!bk.bl(paramString))
    {
      localObject = paramString;
      localJsApiChattingTask.username = ((String)localObject);
      localObject = paramAppBrandSysConfigWC.bJw;
      if (bk.bl(paramString)) {
        break label258;
      }
      paramAppBrandSysConfigWC = "";
    }
    for (;;)
    {
      localJsApiChattingTask.nickname = paramAppBrandSysConfigWC;
      localJsApiChattingTask.sessionFrom = this.sessionFrom;
      localJsApiChattingTask.gfD = new c.3(this, localJsApiChattingTask, locala, paramq, parama);
      localJsApiChattingTask.ahC();
      AppBrandMainProcessService.a(localJsApiChattingTask);
      return;
      localObject = str;
      if (!bk.bl(str)) {
        break;
      }
      y.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
      localObject = "";
      break;
      label258:
      paramAppBrandSysConfigWC = (AppBrandSysConfigWC)localObject;
      if (bk.bl((String)localObject))
      {
        y.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
        paramAppBrandSysConfigWC = "";
      }
    }
  }
  
  private static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c
 * JD-Core Version:    0.7.0.1
 */