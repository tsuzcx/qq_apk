package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.s;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.wework.api.model.WWMediaMiniProgram;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsApiShareAppMessageBase<Param extends d>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  final int llm = com.tencent.luggage.sdk.g.a.aC(this);
  
  static void a(Bitmap paramBitmap, WWMediaMiniProgram paramWWMediaMiniProgram)
  {
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.JsApiShareAppMessageBase", "writeBitmap, w:%d, h:%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        int n = paramBitmap.getWidth();
        int i1 = paramBitmap.getHeight();
        int k = paramBitmap.getWidth();
        int m = paramBitmap.getHeight();
        i = m;
        j = k;
        if (k != 0)
        {
          i = m;
          j = k;
          if (m != 0)
          {
            if ((k <= 1024) || (m <= 1024)) {
              continue;
            }
            if (k <= m) {
              break label284;
            }
            i = m * 1024 / k;
            j = 1024;
          }
        }
        Bitmap localBitmap = paramBitmap;
        if (j != n)
        {
          localBitmap = paramBitmap;
          if (i != i1) {
            localBitmap = com.tencent.mm.sdk.platformtools.h.b(paramBitmap, 0.0F, j / n, i / i1);
          }
        }
        paramBitmap = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 70, paramBitmap);
        paramWWMediaMiniProgram.MLt = paramBitmap.toByteArray();
        paramBitmap.close();
        return;
        j = k * 1024 / m;
        i = 1024;
        continue;
        if (k > 1024)
        {
          i = m * 1024 / k;
          j = 1024;
          continue;
        }
        i = m;
        j = k;
        if (m <= 1024) {
          continue;
        }
        j = k * 1024 / m;
        i = 1024;
        continue;
        if (k != m) {
          continue;
        }
      }
      catch (Exception paramBitmap)
      {
        ae.i("MicroMsg.JsApiShareAppMessageBase", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramBitmap.getMessage() });
        paramWWMediaMiniProgram.MLt = new byte[1];
        return;
      }
      label284:
      int i = 1024;
      int j = 1024;
    }
  }
  
  protected Param a(c paramc, JSONObject paramJSONObject)
  {
    ae.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = bni();
    if (paramJSONObject == null)
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.dtg = paramc.au(Activity.class);
    if (locald.dtg == null)
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.llv = ((ad)paramc.at(ad.class));
    if (locald.llv == null)
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    com.tencent.mm.plugin.appbrand.menu.r localr = locald.llv.uS(s.lXl.ordinal());
    Object localObject1 = locald.llv.uS(s.lXL.ordinal());
    if ((localr == null) && (localObject1 == null))
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    localObject1 = paramJSONObject.optString("type");
    if (com.tencent.mm.plugin.appbrand.aa.g.am(paramc.getRuntime())) {
      localObject1 = "weishi";
    }
    Object localObject2 = localObject1;
    if (bu.isNullOrNil((String)localObject1)) {
      localObject2 = "normal";
    }
    String str = paramJSONObject.optString("to");
    ae.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", new Object[] { localObject2 });
    if ("video".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = new h();
      locald.llz = ((b)localObject1);
      locald.llw = paramc.getRuntime().aXw();
      locald.withShareTicket = localr.kzP.getBoolean("enable_share_with_share_ticket", false);
      if ((!locald.withShareTicket) && ((paramc instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p))) {
        locald.withShareTicket = "withShareTicket".equals(paramJSONObject.optString("mode"));
      }
      locald.llH = localr.kzP.getBoolean("is_todo_message", false);
      locald.hAW = localr.kzP.getString("share_todo_activity_id", "");
      if (!locald.withShareTicket) {
        break label605;
      }
    }
    label605:
    for (int i = 3;; i = 2)
    {
      locald.type = i;
      locald.title = paramJSONObject.optString("title");
      locald.desc = paramJSONObject.optString("desc", "");
      locald.dlk = paramJSONObject.optString("path");
      locald.hBa = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.llx = paramJSONObject.optBoolean("disableForward", false);
      ae.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.llx) });
      locald.dLl = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.llE = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      locald.lly = str;
      localObject1 = paramc.getRuntime().aXx();
      if (localObject1 != null) {
        break label610;
      }
      ae.e("MicroMsg.JsApiShareAppMessageBase", "hy: no init config");
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
    label610:
    locald.llA = localr.kzP.Bs("enable_share_dynamic");
    locald.llB = localr.kzP.Bs("enable_share_with_updateable_msg");
    locald.llC = localr.kzP.Bs("enable_share_with_private_msg");
    locald.hDH = localr.kzP.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.duK = locald.llw.kbw.jLV;
    locald.pkgVersion = locald.llw.kbw.pkgVersion;
    locald.llD = paramc.getRuntime().aXx().cmt;
    locald.kdJ = v.Lj(paramc.getAppId());
    locald.kNt = r.Rh(locald.hBa);
    locald.dzD = r.a(locald.llv, locald.hBa, locald.llE);
    ae.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.dzD, locald.hBa, Boolean.valueOf(locald.llE) });
    locald.llI = new HashMap();
    locald.llI.put("desc", locald.desc);
    locald.llI.put("type", Integer.valueOf(locald.type));
    locald.llI.put("title", locald.title);
    locald.llI.put("app_id", locald.appId);
    locald.llI.put("pkg_type", Integer.valueOf(locald.duK));
    locald.llI.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.llI.put("img_url", locald.hBa);
    locald.llI.put("is_dynamic", Boolean.valueOf(locald.llA));
    locald.llI.put("cache_key", locald.cacheKey);
    locald.llI.put("path", locald.dlk);
    locald.llI.put("disableForward", Boolean.valueOf(locald.llx));
    locald.llI.put("subType", Integer.valueOf(locald.subType));
    if (!bu.isNullOrNil(locald.dzD)) {
      locald.llI.put("delay_load_img_path", locald.dzD);
    }
    locald.llF = paramJSONObject.optString("openId");
    locald.llG = paramJSONObject.optString("chatroomUsername");
    locald.llz.a(locald, paramc, paramJSONObject);
    ae.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
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
        if (!bu.ht(paramSendAppMessageTask.lmx))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.lmx.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.cmw);
            localJSONObject.put("shareName", localShareInfo.cmv);
            paramString.put(localJSONObject);
          }
        }
        return null;
      }
      catch (JSONException paramSendAppMessageTask)
      {
        ae.e("MicroMsg.JsApiShareAppMessageBase", Log.getStackTraceString(paramSendAppMessageTask));
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
      paramIntent.putExtra("appbrand_params", paramParam.llI);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.llz.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, c paramc, Param paramParam)
  {
    paramSendAppMessageTask.lmh = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    int i;
    if ((paramString1 != null) && (paramString1.Fn() != null) && ((paramString1.Fn() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.aDD = ((AppBrandInitConfigWC)paramString1.Fn()).aDD;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.kdJ;
      paramSendAppMessageTask.path = paramParam.dlk;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.kNt = paramParam.kNt;
      paramSendAppMessageTask.lmi = paramParam.hBa;
      paramSendAppMessageTask.iconUrl = paramParam.llw.iCT;
      paramSendAppMessageTask.duK = paramParam.llw.kbw.jLV;
      paramSendAppMessageTask.kdI = paramParam.llw.kbw.md5;
      paramSendAppMessageTask.version = paramParam.llw.kbw.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.llw.dpI;
      paramSendAppMessageTask.dLl = paramParam.dLl;
      paramSendAppMessageTask.kaX = paramParam.llw.kaX;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.llx) {
        break label510;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.kuE = i;
      paramSendAppMessageTask.lmm = o.Le(paramParam.appId).jBU.getAndIncrement();
      paramSendAppMessageTask.lmo = paramParam.llv.kxv;
      paramSendAppMessageTask.lmp = paramParam.llv.bhY();
      paramString1 = paramParam.llv.getRuntime().Fg().cmE;
      if (paramString1 != null)
      {
        if (paramString1.scene != 0) {
          break label516;
        }
        i = 1000;
        label321:
        paramSendAppMessageTask.scene = i;
        paramSendAppMessageTask.dlj = bu.nullAsNil(paramString1.dlj);
        paramSendAppMessageTask.lmn = bu.nullAsNil(paramParam.llv.getRuntime().aXx().Ef());
      }
      paramSendAppMessageTask.lmj = r.Ri(paramParam.dzD);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.llA = paramParam.llA;
      paramSendAppMessageTask.llB = paramParam.llB;
      paramSendAppMessageTask.llC = paramParam.llC;
      paramSendAppMessageTask.hDH = paramParam.hDH;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.cRx = paramParam.llD;
      paramString1 = paramParam.llv.bvG();
      if (paramString1 != null) {
        break label525;
      }
    }
    label516:
    label525:
    for (paramString1 = "";; paramString1 = paramString1.getWebView().getUrl())
    {
      paramSendAppMessageTask.lmr = paramString1;
      paramParam.llz.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.llH = paramParam.llH;
      paramSendAppMessageTask.hAW = paramParam.hAW;
      paramSendAppMessageTask.hBk = paramBoolean;
      return;
      ae.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.aDD = -1;
      break;
      label510:
      i = 0;
      break label242;
      i = paramString1.scene;
      break label321;
    }
  }
  
  final void a(final c paramc, final int paramInt, final Param paramParam, final Intent paramIntent, final boolean paramBoolean)
  {
    paramIntent = new Runnable()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(222672);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.llm)
        {
          ae.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(222672);
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
          ae.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.llw.dpI;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(222672);
          return;
          str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User");
          break;
          bool = false;
          break label70;
        }
        label207:
        if ((str1 == null) || (str1.length() == 0))
        {
          ae.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("fail:selected user is nil", null));
          AppMethodBeat.o(222672);
          return;
        }
        ae.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.llw.dpI;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(222672);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174894);
        e.aB(paramParam.dtg).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(222673);
            if (JsApiShareAppMessageBase.this.llm != paramAnonymous2Int1)
            {
              AppMethodBeat.o(222673);
              return false;
            }
            JsApiShareAppMessageBase.4.this.lgL.c(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(222673);
            return true;
          }
        });
        Activity localActivity = paramParam.dtg;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          com.tencent.mm.br.d.c(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.llm);
          AppMethodBeat.o(174894);
          return;
        }
      }
    };
    if (paramParam.llz.c(paramParam)) {
      ae.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
    }
    for (long l = 200L;; l = 0L)
    {
      paramc.j(paramIntent, l);
      return;
    }
  }
  
  protected final void a(final String paramString1, String paramString2, boolean paramBoolean, final c paramc, final int paramInt, final Param paramParam)
  {
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    a(localSendAppMessageTask, paramString1, paramString2, paramBoolean, paramc, paramParam);
    if (paramParam.withShareTicket)
    {
      localSendAppMessageTask.kuv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222674);
          ae.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.bix();
          paramc.h(paramInt, JsApiShareAppMessageBase.this.n("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(222674);
        }
      };
      localSendAppMessageTask.biw();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (paramParam.dtg != null) {
        com.tencent.mm.ui.base.h.cm(paramParam.dtg, paramParam.dtg.getResources().getString(2131755317));
      }
      return;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramc.h(paramInt, n("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param bni();
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> llt = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.llt = null;
    }
  }
  
  protected static abstract interface b
  {
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams);
    
    public abstract <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams);
  }
  
  protected static final class c
    extends IllegalArgumentException
  {
    JsApiShareAppMessageBase.a llu;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cacheKey;
    String dLl;
    String desc;
    String dlk;
    Activity dtg = null;
    int duK;
    String dzD;
    public String hAW = "";
    String hBa;
    String hDH;
    boolean kNt;
    String kdJ;
    boolean llA;
    boolean llB;
    boolean llC;
    int llD;
    boolean llE = false;
    String llF = "";
    String llG = "";
    public boolean llH;
    HashMap<String, Object> llI;
    ad llv = null;
    AppBrandSysConfigWC llw = null;
    boolean llx;
    String lly;
    JsApiShareAppMessageBase.b llz;
    int pkgVersion;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.dtg + ", pageView=" + this.llv + ", config=" + this.llw + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.dlk + '\'' + ", imageUrl='" + this.hBa + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.llx + ", messageExtraData='" + this.dLl + '\'' + ", mShareExtImp=" + this.llz + ", isDynamicMsg=" + this.llA + ", isUpdateMsg=" + this.llB + ", isPrivateMsg=" + this.llC + ", templateId='" + this.hDH + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.duK + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.llD + ", errorUrl='" + this.kdJ + '\'' + ", needDelThumb=" + this.kNt + ", imgPath='" + this.dzD + '\'' + ", useDefaultSnapshot=" + this.llE + ", msgParams=" + this.llI + ", todoActivityId=" + this.hAW + ", isToDoMessage=" + this.llH + '}';
      AppMethodBeat.o(174895);
      return str;
    }
  }
  
  protected static final class f
    implements JsApiShareAppMessageBase.b
  {
    String llN;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.hBa);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.llN);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.llN = paramJSONObject.optString("link");
      if (bu.isNullOrNil(this.llN))
      {
        ae.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.llI.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      paramSendAppMessageTask.lml = 5;
      paramSendAppMessageTask.url = this.llN;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = bu.nullAsNil(paramShareParams.dzD).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.llN + '\'' + '}';
      AppMethodBeat.o(174899);
      return str;
    }
  }
  
  static final class g
    implements JsApiShareAppMessageBase.b
  {
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174900);
      boolean bool = bu.nullAsNil(paramShareParams.dzD).startsWith("delayLoadFile://");
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
    String dJw;
    String hBj;
    String llO;
    String llP;
    String llQ;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.dJw = paramJSONObject.optString("videoMD5");
      this.llO = paramJSONObject.optString("videoButtonText");
      this.hBj = paramJSONObject.optString("playDesc");
      this.llP = r.a(paramShareParams.llv, this.videoPath, paramShareParams.llE);
      this.llQ = r.a(paramShareParams.llv, paramc, paramShareParams.llE);
      if ((bu.isNullOrNil(this.llP)) || (bu.isNullOrNil(this.llQ)) || (bu.isNullOrNil(this.dJw)))
      {
        ae.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.llI.put("is_video", Boolean.TRUE);
      paramShareParams.llI.put("footer_icon", paramShareParams.llw.iCT);
      paramShareParams.llI.put("footer_text", paramShareParams.llw.dpI);
      paramShareParams.llI.put("video_path", this.llP);
      paramShareParams.llI.put("video_thumb_path", this.llQ);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.lml = 4;
      paramSendAppMessageTask.lmq = true;
      paramSendAppMessageTask.videoPath = r.Ri(this.llP);
      paramSendAppMessageTask.lmw = r.Ri(this.llQ);
      paramSendAppMessageTask.dJw = this.dJw;
      paramSendAppMessageTask.llO = this.llO;
      paramSendAppMessageTask.hBj = this.hBj;
      paramSendAppMessageTask.lmj = r.Ri(this.llQ);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((bu.nullAsNil(paramShareParams.dzD).startsWith("delayLoadFile://")) || (bu.nullAsNil(this.llP).startsWith("delayLoadFile://")) || (bu.nullAsNil(this.llQ).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.dJw + '\'' + ", videoButtonText='" + this.llO + '\'' + ", videoPlayDesc='" + this.hBj + '\'' + ", videoPathInFileSystem='" + this.llP + '\'' + ", videoThumbPathInFileSystem='" + this.llQ + '\'' + '}';
      AppMethodBeat.o(174904);
      return str;
    }
  }
  
  protected static final class i
    implements JsApiShareAppMessageBase.b
  {
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174905);
      paramShareParams.llE = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (bu.isNullOrNil(str)) {
        paramJSONObject = v.Lj(paramc.getAppId());
      }
      paramShareParams.kdJ = paramJSONObject;
      paramShareParams.llI.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().aXx();
      if ((paramc.cmy != null) && (!bu.isNullOrNil(paramc.cmy.kbG))) {
        paramShareParams.llI.put("msg_img_path", paramc.cmy.kbG);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().aXx();
      paramSendAppMessageTask.lml = 3;
      if (paramc.cmy != null)
      {
        paramSendAppMessageTask.lms = paramc.cmy.appId;
        paramSendAppMessageTask.lmt = paramc.cmy.appName;
        paramSendAppMessageTask.lmu = paramc.cmy.kbH;
        paramSendAppMessageTask.lmv = paramc.cmy.thumbUrl;
        if (bu.isNullOrNil(paramSendAppMessageTask.lmi))
        {
          paramSendAppMessageTask.lmj = paramc.cmy.kbF;
          paramSendAppMessageTask.kNt = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { paramShareParams.appId, paramShareParams.dlk, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = bu.nullAsNil(paramShareParams.dzD).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */