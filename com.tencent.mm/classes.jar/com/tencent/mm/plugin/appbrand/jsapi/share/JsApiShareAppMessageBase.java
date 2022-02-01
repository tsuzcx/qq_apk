package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ab.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsApiShareAppMessageBase<Param extends d>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.service.c>
{
  final int kLb = com.tencent.luggage.sdk.g.a.aA(this);
  
  protected Param a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
  {
    ac.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = biN();
    if (paramJSONObject == null)
    {
      ac.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.dgE = paramc.au(Activity.class);
    if (locald.dgE == null)
    {
      ac.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.kLj = ((ae)paramc.at(ae.class));
    if (locald.kLj == null)
    {
      ac.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    p localp = locald.kLj.uj(com.tencent.mm.plugin.appbrand.menu.q.ltB.ordinal());
    if (localp == null)
    {
      ac.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    Object localObject1 = paramJSONObject.optString("type");
    if (g.as(paramc.getRuntime())) {
      localObject1 = "weishi";
    }
    Object localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      localObject2 = "normal";
    }
    ac.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", new Object[] { localObject2 });
    if ("video".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = new h();
      locald.kLm = ((b)localObject1);
      locald.kLk = paramc.getRuntime().aTR();
      locald.withShareTicket = localp.kcb.getBoolean("enable_share_with_share_ticket", false);
      locald.kLt = localp.kcb.getBoolean("is_todo_message", false);
      locald.hga = localp.kcb.getString("share_todo_activity_id", "");
      if (!locald.withShareTicket) {
        break label526;
      }
    }
    label526:
    for (int i = 3;; i = 2)
    {
      locald.type = i;
      locald.title = paramJSONObject.optString("title");
      locald.desc = paramJSONObject.optString("desc", "");
      locald.cYQ = paramJSONObject.optString("path");
      locald.hgd = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.kLl = paramJSONObject.optBoolean("disableForward", false);
      ac.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.kLl) });
      locald.dxK = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.kLq = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      localObject1 = paramc.getRuntime().aTS();
      if (localObject1 != null) {
        break label531;
      }
      ac.e("MicroMsg.JsApiShareAppMessageBase", "hy: no init config");
      throw new c("no init config");
      if ("h5".equalsIgnoreCase((String)localObject2))
      {
        localObject1 = new f();
        break;
      }
      if ("weishi".equalsIgnoreCase((String)localObject2))
      {
        localObject1 = new i();
        break;
      }
      localObject1 = new g((byte)0);
      break;
    }
    label531:
    locald.kLn = localp.kcb.xK("enable_share_dynamic");
    locald.kLo = localp.kcb.xK("enable_share_with_updateable_msg");
    locald.hiK = localp.kcb.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.dib = locald.kLk.jEg.jpa;
    locald.pkgVersion = locald.kLk.jEg.pkgVersion;
    locald.kLp = paramc.getRuntime().aTS().cca;
    locald.jGj = u.Hx(paramc.getAppId());
    locald.kpe = r.Nb(locald.hgd);
    locald.dmK = r.a(locald.kLj, locald.hgd, locald.kLq);
    ac.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.dmK, locald.hgd, Boolean.valueOf(locald.kLq) });
    locald.kLu = new HashMap();
    locald.kLu.put("desc", locald.desc);
    locald.kLu.put("type", Integer.valueOf(locald.type));
    locald.kLu.put("title", locald.title);
    locald.kLu.put("app_id", locald.appId);
    locald.kLu.put("pkg_type", Integer.valueOf(locald.dib));
    locald.kLu.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.kLu.put("img_url", locald.hgd);
    locald.kLu.put("is_dynamic", Boolean.valueOf(locald.kLn));
    locald.kLu.put("cache_key", locald.cacheKey);
    locald.kLu.put("path", locald.cYQ);
    locald.kLu.put("disableForward", Boolean.valueOf(locald.kLl));
    locald.kLu.put("subType", Integer.valueOf(locald.subType));
    if (!bs.isNullOrNil(locald.dmK)) {
      locald.kLu.put("delay_load_img_path", locald.dmK);
    }
    locald.kLr = paramJSONObject.optString("openId");
    locald.kLs = paramJSONObject.optString("chatroomUsername");
    locald.kLm.a(locald, paramc, paramJSONObject);
    ac.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
    return locald;
  }
  
  protected Map<String, Object> a(Param paramParam, SendAppMessageTask paramSendAppMessageTask, String paramString)
  {
    if (paramParam.withShareTicket)
    {
      paramParam = new HashMap();
      paramString = new JSONArray();
      try
      {
        if (!bs.gY(paramSendAppMessageTask.kMi))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.kMi.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.ccd);
            localJSONObject.put("shareName", localShareInfo.ccc);
            paramString.put(localJSONObject);
          }
        }
        return null;
      }
      catch (JSONException paramSendAppMessageTask)
      {
        ac.e("MicroMsg.JsApiShareAppMessageBase", Log.getStackTraceString(paramSendAppMessageTask));
        paramParam.put("shareInfos", paramString);
        return paramParam;
      }
    }
  }
  
  protected void a(Intent paramIntent, Param paramParam)
  {
    paramIntent.putExtra("Select_Conv_Type", 3);
    if (!paramParam.withShareTicket) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.putExtra("mutil_select_is_ret", bool);
      paramIntent.putExtra("select_is_ret", true);
      paramIntent.putExtra("scene_from", 3);
      paramIntent.putExtra("appbrand_params", paramParam.kLu);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.kLm.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.plugin.appbrand.service.c paramc, Param paramParam)
  {
    paramSendAppMessageTask.kLS = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    int i;
    if ((paramString1 != null) && (paramString1.DJ() != null) && ((paramString1.DJ() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.aBM = ((AppBrandInitConfigWC)paramString1.DJ()).aBM;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.jGj;
      paramSendAppMessageTask.path = paramParam.cYQ;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.kpe = paramParam.kpe;
      paramSendAppMessageTask.kLT = paramParam.hgd;
      paramSendAppMessageTask.iconUrl = paramParam.kLk.igG;
      paramSendAppMessageTask.dib = paramParam.kLk.jEg.jpa;
      paramSendAppMessageTask.jGi = paramParam.kLk.jEg.md5;
      paramSendAppMessageTask.version = paramParam.kLk.jEg.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.kLk.ddh;
      paramSendAppMessageTask.dxK = paramParam.dxK;
      paramSendAppMessageTask.ccR = paramParam.kLk.ccR;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.kLl) {
        break label500;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.jWX = i;
      paramSendAppMessageTask.kLX = n.Hs(paramParam.appId).jfO.getAndIncrement();
      paramSendAppMessageTask.kLZ = paramParam.kLj.jZJ;
      paramSendAppMessageTask.kMa = paramParam.kLj.bdM();
      paramString1 = paramParam.kLj.getRuntime().DC().ccl;
      if (paramString1 != null)
      {
        if (paramString1.scene != 0) {
          break label506;
        }
        i = 1000;
        label321:
        paramSendAppMessageTask.scene = i;
        paramSendAppMessageTask.cYP = bs.nullAsNil(paramString1.cYP);
        paramSendAppMessageTask.kLY = bs.nullAsNil(paramParam.kLj.getRuntime().aTS().CD());
      }
      paramSendAppMessageTask.kLU = r.Nc(paramParam.dmK);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.kLn = paramParam.kLn;
      paramSendAppMessageTask.kLo = paramParam.kLo;
      paramSendAppMessageTask.hiK = paramParam.hiK;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.cFI = paramParam.kLp;
      paramString1 = paramParam.kLj.bqU();
      if (paramString1 != null) {
        break label515;
      }
    }
    label515:
    for (paramString1 = "";; paramString1 = paramString1.getWebView().getUrl())
    {
      paramSendAppMessageTask.kMc = paramString1;
      paramParam.kLm.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.kLt = paramParam.kLt;
      paramSendAppMessageTask.hga = paramParam.hga;
      paramSendAppMessageTask.hgn = paramBoolean;
      return;
      ac.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.aBM = -1;
      break;
      label500:
      i = 0;
      break label242;
      label506:
      i = paramString1.scene;
      break label321;
    }
  }
  
  final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, final Param paramParam, final Intent paramIntent, final boolean paramBoolean)
  {
    paramIntent = new Runnable()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(174891);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.kLb)
        {
          ac.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(174891);
          return;
        }
        String str1;
        boolean bool;
        if (paramAnonymousIntent == null)
        {
          str1 = null;
          if ((paramAnonymousIntent == null) || (!paramAnonymousIntent.getBooleanExtra("KSendGroupToDo", false))) {
            break label190;
          }
          bool = true;
          label70:
          if (paramAnonymousIntent != null) {
            break label196;
          }
        }
        label190:
        label196:
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("KShowTodoIntroduceView", 0))
        {
          if (paramAnonymousInt2 == -1) {
            break label207;
          }
          ac.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.kLk.ddh;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(174891);
          return;
          str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User");
          break;
          bool = false;
          break label70;
        }
        label207:
        if ((str1 == null) || (str1.length() == 0))
        {
          ac.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("fail:selected user is nil", null));
          AppMethodBeat.o(174891);
          return;
        }
        ac.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.kLk.ddh;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(174891);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174893);
        e.aA(paramParam.dgE).b(new e.b()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174892);
            if (JsApiShareAppMessageBase.this.kLb != paramAnonymous2Int1)
            {
              AppMethodBeat.o(174892);
              return false;
            }
            JsApiShareAppMessageBase.3.this.kGG.c(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(174892);
            return true;
          }
        });
        Activity localActivity = paramParam.dgE;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          d.c(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.kLb);
          AppMethodBeat.o(174893);
          return;
        }
      }
    };
    if (paramParam.kLm.c(paramParam)) {
      ac.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
    }
    for (long l = 200L;; l = 0L)
    {
      paramc.i(paramIntent, l);
      return;
    }
  }
  
  protected final void a(final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, final Param paramParam)
  {
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    a(localSendAppMessageTask, paramString1, paramString2, paramBoolean, paramc, paramParam);
    if (paramParam.withShareTicket)
    {
      localSendAppMessageTask.jWP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174894);
          ac.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.bek();
          paramc.h(paramInt, JsApiShareAppMessageBase.this.k("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(174894);
        }
      };
      localSendAppMessageTask.bej();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (paramParam.dgE != null) {
        com.tencent.mm.ui.base.h.cg(paramParam.dgE, paramParam.dgE.getResources().getString(2131755317));
      }
      return;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramc.h(paramInt, k("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param biN();
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> kLh = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.kLh = null;
    }
  }
  
  protected static abstract interface b
  {
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams);
  }
  
  protected static final class c
    extends IllegalArgumentException
  {
    JsApiShareAppMessageBase.a kLi;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cYQ;
    String cacheKey;
    String desc;
    Activity dgE = null;
    int dib;
    String dmK;
    String dxK;
    public String hga = "";
    String hgd;
    String hiK;
    String jGj;
    ae kLj = null;
    AppBrandSysConfigWC kLk = null;
    boolean kLl;
    JsApiShareAppMessageBase.b kLm;
    boolean kLn;
    boolean kLo;
    int kLp;
    boolean kLq = false;
    String kLr = "";
    String kLs = "";
    public boolean kLt;
    HashMap<String, Object> kLu;
    boolean kpe;
    int pkgVersion;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.dgE + ", pageView=" + this.kLj + ", config=" + this.kLk + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.cYQ + '\'' + ", imageUrl='" + this.hgd + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.kLl + ", messageExtraData='" + this.dxK + '\'' + ", mShareExtImp=" + this.kLm + ", isDynamicMsg=" + this.kLn + ", isUpdateMsg=" + this.kLo + ", templateId='" + this.hiK + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.dib + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.kLp + ", errorUrl='" + this.jGj + '\'' + ", needDelThumb=" + this.kpe + ", imgPath='" + this.dmK + '\'' + ", useDefaultSnapshot=" + this.kLq + ", msgParams=" + this.kLu + ", todoActivityId=" + this.hga + ", isToDoMessage=" + this.kLt + '}';
      AppMethodBeat.o(174895);
      return str;
    }
  }
  
  protected static final class f
    implements JsApiShareAppMessageBase.b
  {
    String kLz;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.hgd);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.kLz);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.kLz = paramJSONObject.optString("link");
      if (bs.isNullOrNil(this.kLz))
      {
        ac.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.kLu.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      paramSendAppMessageTask.kLW = 5;
      paramSendAppMessageTask.url = this.kLz;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = bs.nullAsNil(paramShareParams.dmK).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.kLz + '\'' + '}';
      AppMethodBeat.o(174899);
      return str;
    }
  }
  
  static final class g
    implements JsApiShareAppMessageBase.b
  {
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174900);
      boolean bool = bs.nullAsNil(paramShareParams.dmK).startsWith("delayLoadFile://");
      AppMethodBeat.o(174900);
      return bool;
    }
    
    public final String toString()
    {
      return "ShareTypeNormal{}";
    }
  }
  
  protected static final class h
    implements JsApiShareAppMessageBase.b
  {
    String dwi;
    String hgm;
    String kLA;
    String kLB;
    String kLC;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.dwi = paramJSONObject.optString("videoMD5");
      this.kLA = paramJSONObject.optString("videoButtonText");
      this.hgm = paramJSONObject.optString("playDesc");
      this.kLB = r.a(paramShareParams.kLj, this.videoPath, paramShareParams.kLq);
      this.kLC = r.a(paramShareParams.kLj, paramc, paramShareParams.kLq);
      if ((bs.isNullOrNil(this.kLB)) || (bs.isNullOrNil(this.kLC)) || (bs.isNullOrNil(this.dwi)))
      {
        ac.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.kLu.put("is_video", Boolean.TRUE);
      paramShareParams.kLu.put("footer_icon", paramShareParams.kLk.igG);
      paramShareParams.kLu.put("footer_text", paramShareParams.kLk.ddh);
      paramShareParams.kLu.put("video_path", this.kLB);
      paramShareParams.kLu.put("video_thumb_path", this.kLC);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.kLW = 4;
      paramSendAppMessageTask.kMb = true;
      paramSendAppMessageTask.videoPath = r.Nc(this.kLB);
      paramSendAppMessageTask.kMh = r.Nc(this.kLC);
      paramSendAppMessageTask.dwi = this.dwi;
      paramSendAppMessageTask.kLA = this.kLA;
      paramSendAppMessageTask.hgm = this.hgm;
      paramSendAppMessageTask.kLU = r.Nc(this.kLC);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((bs.nullAsNil(paramShareParams.dmK).startsWith("delayLoadFile://")) || (bs.nullAsNil(this.kLB).startsWith("delayLoadFile://")) || (bs.nullAsNil(this.kLC).startsWith("delayLoadFile://")))
      {
        AppMethodBeat.o(174903);
        return true;
      }
      AppMethodBeat.o(174903);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174904);
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.dwi + '\'' + ", videoButtonText='" + this.kLA + '\'' + ", videoPlayDesc='" + this.hgm + '\'' + ", videoPathInFileSystem='" + this.kLB + '\'' + ", videoThumbPathInFileSystem='" + this.kLC + '\'' + '}';
      AppMethodBeat.o(174904);
      return str;
    }
  }
  
  protected static final class i
    implements JsApiShareAppMessageBase.b
  {
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174905);
      paramShareParams.kLq = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (bs.isNullOrNil(str)) {
        paramJSONObject = u.Hx(paramc.getAppId());
      }
      paramShareParams.jGj = paramJSONObject;
      paramShareParams.kLu.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().aTS();
      if ((paramc.ccf != null) && (!bs.isNullOrNil(paramc.ccf.jEp))) {
        paramShareParams.kLu.put("msg_img_path", paramc.ccf.jEp);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().aTS();
      paramSendAppMessageTask.kLW = 3;
      if (paramc.ccf != null)
      {
        paramSendAppMessageTask.kMd = paramc.ccf.appId;
        paramSendAppMessageTask.kMe = paramc.ccf.appName;
        paramSendAppMessageTask.kMf = paramc.ccf.jEq;
        paramSendAppMessageTask.kMg = paramc.ccf.thumbUrl;
        if (bs.isNullOrNil(paramSendAppMessageTask.kLT))
        {
          paramSendAppMessageTask.kLU = paramc.ccf.jEo;
          paramSendAppMessageTask.kpe = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { paramShareParams.appId, paramShareParams.cYQ, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = bs.nullAsNil(paramShareParams.dmK).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */