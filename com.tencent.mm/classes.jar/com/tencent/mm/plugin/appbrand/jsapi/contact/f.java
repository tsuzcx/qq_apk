package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.k.l;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.z;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  private String businessId;
  String oOB;
  String oOK;
  String oOL;
  String oOM;
  boolean oON;
  String oOO;
  boolean oOP;
  final int oOQ;
  String oOZ;
  String oPa;
  String oPb;
  String oPc;
  String oPd;
  String oPe;
  String oPf;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.oOQ = a.aI(this);
    AppMethodBeat.o(174785);
  }
  
  private void a(final ah paramah, final a parama)
  {
    AppMethodBeat.i(275592);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.oPa;
    localJsApiChattingTask.oOB = this.oOB;
    localJsApiChattingTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.oOB);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        Object localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.oOZ;
        ((WxaExposedParams.a)localObject).username = f.this.oPa;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).bLN());
        localIntent.putExtra("keyPrivateAppId", f.this.oOZ);
        localIntent.putExtra("keyPrivateUserName", f.this.oPa);
        localIntent.putExtra("keyPrivateTitle", f.this.oPb);
        localIntent.putExtra("keyPrivateSubTitle", f.this.oPc);
        localIntent.putExtra("keyPrivateHeadImage", f.this.oPd);
        if (paramah.getRuntime().bDl()) {}
        for (int i = 2;; i = 1)
        {
          localObject = paramah.qoI;
          String str = paramah.getAppId();
          Log.i("MicroMsg.JsApiPrivateEnterContact", "doEnterChattingCustomized, scene: %d, sceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(i), localObject, str });
          localIntent.putExtra("app_brand_chatting_from_scene_new", i);
          localIntent.putExtra("app_brand_chatting_from_scene_note_new", (String)localObject);
          localIntent.putExtra("app_brand_chatting_from_app_id", str);
          localObject = AndroidContextUtil.castActivityOrNull(paramah.getRuntime().mContext);
          if (localObject != null) {
            break;
          }
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        com.tencent.luggage.k.f.aI((Context)localObject).b(new f.c()
        {
          public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.oOQ)
            {
              if (f.2.this.oPh != null) {
                f.2.this.oPh.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.oOW.bPk();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        com.tencent.mm.by.c.d((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.oOQ);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.bsM();
    AppMethodBeat.o(275592);
  }
  
  private void a(ah paramah, final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(275590);
    a(paramah, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46275);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = Util.nullAs(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = l.eo(paramAnonymousString);
            paramAnonymousString = l.ep(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          parame.j(paramInt, f.this.m("ok", localHashMap));
          AppMethodBeat.o(46275);
          return;
        }
        parame.j(paramInt, f.this.h(paramAnonymousString, null));
        AppMethodBeat.o(46275);
      }
    });
    AppMethodBeat.o(275590);
  }
  
  private void a(ah paramah, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(275591);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(275591);
      return;
    }
    if (paramah.getRuntime().bDx() == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(275591);
      return;
    }
    this.oOB = paramJSONObject.optString("sessionFrom");
    if (this.oOB.length() > 1024)
    {
      this.oOB = this.oOB.substring(0, 1024);
      Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.oOZ = paramJSONObject.optString("appId");
    if (Util.isNullOrNil(this.oOZ))
    {
      parama.a(false, "fail:appId is null", null);
      AppMethodBeat.o(275591);
      return;
    }
    this.oPa = paramJSONObject.optString("userName");
    this.oPe = paramJSONObject.optString("contactUsername");
    this.oPe = ahz(this.oPe);
    this.oPb = paramJSONObject.optString("title");
    this.oPc = paramJSONObject.optString("subTitle");
    this.oPd = paramJSONObject.optString("headimgUrl");
    if (!Util.isNullOrNil(this.oPa))
    {
      a(paramah, parama);
      AppMethodBeat.o(275591);
      return;
    }
    if (!Util.isNullOrNil(this.oPe))
    {
      this.businessId = paramJSONObject.optString("businessId");
      this.oOK = paramJSONObject.optString("sendMessageTitle");
      this.oOL = paramJSONObject.optString("sendMessagePath");
      this.oOM = paramJSONObject.optString("sendMessageImg");
      this.oON = paramJSONObject.optBoolean("showMessageCard", false);
      this.oOP = z.aiC(this.oOM);
      this.oOO = z.a(paramah, this.oOM, true);
      b(paramah, parama);
    }
    AppMethodBeat.o(275591);
  }
  
  private static String ahz(String paramString)
  {
    AppMethodBeat.i(275596);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275596);
      return "";
    }
    if (paramString.endsWith("@app"))
    {
      AppMethodBeat.o(275596);
      return paramString;
    }
    paramString = paramString + "@app";
    AppMethodBeat.o(275596);
    return paramString;
  }
  
  private void b(final ah paramah, final a parama)
  {
    AppMethodBeat.i(275593);
    if (Util.isNullOrNil(this.oPe))
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(275593);
      return;
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdj();
    ((d.a)localObject).lBV = new cdk();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((d.a)localObject).funcId = 1303;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    cdj localcdj = (cdj)d.b.b(((d)localObject).lBR);
    localcdj.username = this.oPe;
    localcdj.Tlg = this.businessId;
    IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(243068);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (d.c.b(paramAnonymousd.lBS) == null))
        {
          Log.e("MicroMsg.JsApiPrivateEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, d.c.b(paramAnonymousd.lBS) });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(243068);
          return;
        }
        paramAnonymousString = (cdk)d.c.b(paramAnonymousd.lBS);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.Tlh });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284551);
            f.this.oPf = paramAnonymousString.Tlh;
            f localf = f.this;
            ah localah = f.3.this.otx;
            f.a locala = f.3.this.oPh;
            JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
            localJsApiChattingTask.obc = localf.oPe;
            Object localObject = localf.oPe;
            String str = localf.oPf;
            if (!Util.isNullOrNil(str)) {
              localObject = str;
            }
            for (;;)
            {
              localJsApiChattingTask.username = ((String)localObject);
              localJsApiChattingTask.oOB = localf.oOB;
              localJsApiChattingTask.otv = new f.4(localf, localJsApiChattingTask, localah, locala);
              localJsApiChattingTask.bsM();
              AppMethodBeat.o(284551);
              return;
              if (Util.isNullOrNil((String)localObject))
              {
                Log.e("MicroMsg.JsApiPrivateEnterContact", "username & subBusinessUsername is null, err");
                localObject = "";
              }
            }
          }
        });
        AppMethodBeat.o(243068);
      }
    });
    AppMethodBeat.o(275593);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46278);
    if ((parame instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      parame = (com.tencent.mm.plugin.appbrand.service.c)parame;
      ah localah = parame.bDv();
      if (localah == null)
      {
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        parame.j(paramInt, h("fail:current page do not exist", null));
        AppMethodBeat.o(46278);
        return;
      }
      a(localah, parame, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    if ((parame instanceof ah))
    {
      a((ah)parame, parame, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    Log.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
    AppMethodBeat.o(46278);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */