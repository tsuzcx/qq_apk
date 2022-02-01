package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.e.b;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  private String koP;
  private String koY;
  String koZ;
  String kpa;
  String kpb;
  boolean kpc;
  String kpd;
  boolean kpe;
  final int kpf;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.kpf = com.tencent.luggage.sdk.g.a.aA(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ae paramae, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramae.getRuntime().aTS().username;
    if ((paramAppBrandSysConfigWC == null) || (bs.isNullOrNil(str)))
    {
      ac.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(46263);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bem();
    ((b.a)localObject).hvu = new ben();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((b.a)localObject).funcId = 1303;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    bem localbem = (bem)((b)localObject).hvr.hvw;
    localbem.username = str;
    localbem.ETU = this.koY;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hvs.hvw == null))
        {
          ac.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hvs.hvw });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (ben)paramAnonymousb.hvs.hvw;
        ac.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.ETV });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.jxW, e.2.this.kpi, paramAnonymousString.ETV, e.2.this.kph);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ae paramae, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46261);
    a(paramae, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46255);
        ac.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = bs.bG(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = k.cp(paramAnonymousString);
            paramAnonymousString = k.cq(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          ac.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, e.this.k("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        paramc.h(paramInt, e.this.e(paramAnonymousString, null));
        AppMethodBeat.o(46255);
      }
    });
    AppMethodBeat.o(46261);
  }
  
  private void a(ae paramae, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46262);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46262);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramae.getRuntime().aTR();
    if (localAppBrandSysConfigWC == null)
    {
      ac.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.koP = paramJSONObject.optString("sessionFrom");
    if (this.koP.length() > 1024)
    {
      this.koP = this.koP.substring(0, 1024);
      ac.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.koY = paramJSONObject.optString("businessId");
    this.koZ = paramJSONObject.optString("sendMessageTitle");
    this.kpa = paramJSONObject.optString("sendMessagePath");
    this.kpb = paramJSONObject.optString("sendMessageImg");
    this.kpc = paramJSONObject.optBoolean("showMessageCard", false);
    this.kpe = r.Nb(this.kpb);
    this.kpd = r.a(paramae, this.kpb, true);
    if (bs.isNullOrNil(this.koY))
    {
      ac.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramae, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(46262);
      return;
    }
    ac.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramae, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(46262);
  }
  
  private static String cU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46265);
    if (!bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46265);
      return "";
    }
    if (!bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46265);
      return paramString1;
    }
    ac.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46265);
    return "";
  }
  
  private static String cV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46266);
    if (!bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46266);
      return paramString2;
    }
    if (!bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46266);
      return paramString1;
    }
    ac.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46266);
    return "";
  }
  
  private static String e(aa paramaa)
  {
    AppMethodBeat.i(46267);
    String str = "";
    if (paramaa != null) {
      str = paramaa.jZJ;
    }
    ac.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramc = (com.tencent.mm.plugin.appbrand.service.c)paramc;
      ae localae = paramc.aTP();
      if (localae == null)
      {
        ac.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramc.h(paramInt, e("fail:current page do not exist", null));
        AppMethodBeat.o(46260);
        return;
      }
      a(localae, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((paramc instanceof aa))
    {
      a((ae)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    paramc.h(paramInt, e("fail:internal error invalid js component", null));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ae paramae, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramae.getRuntime().aTS().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramae.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.ddh;
    locala.iconUrl = paramAppBrandSysConfigWC.igG;
    locala.jpa = paramAppBrandSysConfigWC.jEg.jpa;
    locala.pkgVersion = paramAppBrandSysConfigWC.jEg.pkgVersion;
    locala.jGi = paramAppBrandSysConfigWC.jEg.md5;
    locala.from = 5;
    locala.pageId = e(paramae);
    locala.jGj = u.Hx(paramae.getAppId());
    localJsApiChattingTask.username = cV(str, paramString);
    localJsApiChattingTask.nickname = cU(paramAppBrandSysConfigWC.ddh, paramString);
    localJsApiChattingTask.koP = this.koP;
    localJsApiChattingTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        ac.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.baT());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.koP);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        if (e.this.kpc)
        {
          localIntent.putExtra("sendMessageTitle", e.this.koZ);
          localIntent.putExtra("sendMessagePath", e.this.kpa);
          localIntent.putExtra("sendMessageImg", e.this.kpb);
          localIntent.putExtra("sendMessageLocalImg", r.Nc(e.this.kpd));
          localIntent.putExtra("needDelThumb", e.this.kpe);
        }
        localIntent.putExtra("showMessageCard", e.this.kpc);
        Activity localActivity = com.tencent.mm.sdk.f.a.jg(paramae.getRuntime().mContext);
        if (localActivity == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ac.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
          AppMethodBeat.o(46259);
          return;
        }
        com.tencent.luggage.h.e.aA(localActivity).b(new e.b()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.kpf)
            {
              if (e.3.this.kph != null) {
                e.3.this.kph.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.kpl.bek();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        d.c(localActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.kpf);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.bej();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46264);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */