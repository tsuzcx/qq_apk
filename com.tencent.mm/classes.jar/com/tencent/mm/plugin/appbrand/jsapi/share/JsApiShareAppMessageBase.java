package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ag.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
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
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  final int pph = com.tencent.luggage.sdk.h.a.aI(this);
  
  static void a(Bitmap paramBitmap, WWMediaMiniProgram paramWWMediaMiniProgram)
  {
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "writeBitmap, w:%d, h:%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
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
            localBitmap = BitmapUtil.rotateAndScale(paramBitmap, 0.0F, j / n, i / i1);
          }
        }
        paramBitmap = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 70, paramBitmap);
        paramWWMediaMiniProgram.ZYw = paramBitmap.toByteArray();
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
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramBitmap.getMessage() });
        paramWWMediaMiniProgram.ZYw = new byte[1];
        return;
      }
      label284:
      int i = 1024;
      int j = 1024;
    }
  }
  
  protected Param a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = bUr();
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.fDf = paramc.ax(Activity.class);
    if (locald.fDf == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.ppq = ((ah)paramc.aw(ah.class));
    if (locald.ppq == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    com.tencent.mm.plugin.appbrand.menu.v localv = locald.ppq.Cp(w.qfG.ordinal());
    Object localObject1 = locald.ppq.Cp(w.qgg.ordinal());
    if ((localv == null) && (localObject1 == null))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    localObject1 = paramJSONObject.optString("type");
    if (g.ap(paramc.getRuntime())) {
      localObject1 = "weishi";
    }
    Object localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "normal";
    }
    String str = paramJSONObject.optString("to");
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", new Object[] { localObject2 });
    if ("video".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = new h();
      locald.ppu = ((b)localObject1);
      locald.ppr = paramc.getRuntime().bDx();
      locald.withShareTicket = localv.ozJ.getBoolean("enable_share_with_share_ticket", false);
      if ((!locald.withShareTicket) && ((paramc instanceof p))) {
        locald.withShareTicket = "withShareTicket".equals(paramJSONObject.optString("mode"));
      }
      locald.ppC = localv.ozJ.getBoolean("is_todo_message", false);
      locald.lkm = localv.ozJ.getString("share_todo_activity_id", "");
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
      locald.fve = paramJSONObject.optString("path");
      locald.imageUrl = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.pps = paramJSONObject.optBoolean("disableForward", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.pps) });
      locald.fXg = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.ppz = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      locald.ppt = str;
      localObject1 = paramc.getRuntime().bDy();
      if (localObject1 != null) {
        break label610;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiShareAppMessageBase", "hy: no init config");
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
    locald.ppv = localv.ozJ.Rq("enable_share_dynamic");
    locald.ppw = localv.ozJ.Rq("enable_share_with_updateable_msg");
    locald.ppx = localv.ozJ.Rq("enable_share_with_private_msg");
    locald.lnb = localv.ozJ.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.fES = locald.ppr.nYR.nHY;
    locald.pkgVersion = locald.ppr.nYR.pkgVersion;
    locald.ppy = paramc.getRuntime().bDy().cwR;
    locald.obX = com.tencent.mm.plugin.appbrand.z.aca(paramc.getAppId());
    locald.oOP = z.aiC(locald.imageUrl);
    locald.fKH = z.a(locald.ppq, locald.imageUrl, locald.ppz);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.fKH, locald.imageUrl, Boolean.valueOf(locald.ppz) });
    locald.ppD = new HashMap();
    locald.ppD.put("desc", locald.desc);
    locald.ppD.put("type", Integer.valueOf(locald.type));
    locald.ppD.put("title", locald.title);
    locald.ppD.put("app_id", locald.appId);
    locald.ppD.put("pkg_type", Integer.valueOf(locald.fES));
    locald.ppD.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.ppD.put("img_url", locald.imageUrl);
    locald.ppD.put("is_dynamic", Boolean.valueOf(locald.ppv));
    locald.ppD.put("cache_key", locald.cacheKey);
    locald.ppD.put("path", locald.fve);
    locald.ppD.put("disableForward", Boolean.valueOf(locald.pps));
    locald.ppD.put("subType", Integer.valueOf(locald.subType));
    if (!Util.isNullOrNil(locald.fKH)) {
      locald.ppD.put("delay_load_img_path", locald.fKH);
    }
    locald.ppA = paramJSONObject.optString("openId");
    locald.ppB = paramJSONObject.optString("chatroomUsername");
    locald.ppu.a(locald, paramc, paramJSONObject);
    localObject1 = paramc.bDv();
    label1157:
    boolean bool;
    if (localObject1 == null)
    {
      paramc = null;
      if (paramc == null) {
        break label1227;
      }
      locald.ppF = paramc.getCurrentUrl();
      bool = paramJSONObject.optBoolean("sdk_isFromMenu", false);
      paramc = getName();
      if ((!TextUtils.isEmpty(paramc)) && (!paramc.equals("shareAppMessage"))) {
        break label1250;
      }
      locald.ppE = 0;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
      return locald;
      paramc = ((ah)localObject1).ceE();
      break;
      label1227:
      if (!(localObject1 instanceof k)) {
        break label1157;
      }
      locald.ppF = paramJSONObject.optString("webViewUrl");
      break label1157;
      label1250:
      if (paramc.contains("ToSpecificContact")) {
        locald.ppE = 2;
      } else if (bool) {
        locald.ppE = 0;
      } else {
        locald.ppE = 1;
      }
    }
  }
  
  protected Map<String, Object> a(Param paramParam, SendAppMessageTask paramSendAppMessageTask, String paramString)
  {
    if (paramParam.withShareTicket)
    {
      paramParam = new HashMap();
      paramString = new JSONArray();
      try
      {
        if (!Util.isNullOrNil(paramSendAppMessageTask.pqB))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.pqB.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.cwU);
            localJSONObject.put("shareName", localShareInfo.cwT);
            paramString.put(localJSONObject);
          }
        }
        return null;
      }
      catch (JSONException paramSendAppMessageTask)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiShareAppMessageBase", android.util.Log.getStackTraceString(paramSendAppMessageTask));
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
      paramIntent.putExtra("appbrand_params", paramParam.ppD);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.ppu.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.plugin.appbrand.service.c paramc, Param paramParam)
  {
    paramSendAppMessageTask.pqm = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    if ((paramString1 != null) && (paramString1.Sq() != null) && ((paramString1.Sq() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.appVersion = ((AppBrandInitConfigWC)paramString1.Sq()).appVersion;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.obX;
      paramSendAppMessageTask.path = paramParam.fve;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.oOP = paramParam.oOP;
      paramSendAppMessageTask.pqn = paramParam.imageUrl;
      paramSendAppMessageTask.iconUrl = paramParam.ppr.mnM;
      paramSendAppMessageTask.fES = paramParam.ppr.nYR.nHY;
      paramSendAppMessageTask.obW = paramParam.ppr.nYR.md5;
      paramSendAppMessageTask.version = paramParam.ppr.nYR.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.ppr.fzM;
      paramSendAppMessageTask.fXg = paramParam.fXg;
      paramSendAppMessageTask.nYp = paramParam.ppr.nYp;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.pps) {
        break label533;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.otE = i;
      if ((paramString1.Sp() instanceof AppBrandSysConfigWC)) {
        paramSendAppMessageTask.lyw = com.tencent.mm.plugin.appbrand.config.a.nVO.a((AppBrandSysConfigWC)paramString1.Sp());
      }
      paramSendAppMessageTask.pqr = s.abW(paramParam.appId).nwb.getAndIncrement();
      paramSendAppMessageTask.pqt = paramParam.ppq.oxe;
      paramSendAppMessageTask.pqu = paramParam.ppq.bOK();
      paramString1 = paramParam.ppq.getRuntime().Sk().cxf;
      if (paramString1 != null) {
        if (paramString1.scene != 0) {
          break label539;
        }
      }
    }
    label533:
    label539:
    for (int i = 1000;; i = paramString1.scene)
    {
      paramSendAppMessageTask.scene = i;
      paramSendAppMessageTask.fvd = Util.nullAsNil(paramString1.fvd);
      paramSendAppMessageTask.pqs = Util.nullAsNil(paramParam.ppq.getRuntime().bDy().cwP);
      paramSendAppMessageTask.pqo = z.aiD(paramParam.fKH);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.ppv = paramParam.ppv;
      paramSendAppMessageTask.ppw = paramParam.ppw;
      paramSendAppMessageTask.ppx = paramParam.ppx;
      paramSendAppMessageTask.lnb = paramParam.lnb;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.serviceType = paramParam.ppy;
      paramSendAppMessageTask.ppF = paramParam.ppF;
      paramParam.ppu.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.ppC = paramParam.ppC;
      paramSendAppMessageTask.lkm = paramParam.lkm;
      paramSendAppMessageTask.lkz = paramBoolean;
      paramSendAppMessageTask.ppE = paramParam.ppE;
      return;
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.appVersion = -1;
      break;
      i = 0;
      break label242;
    }
  }
  
  final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, final Param paramParam, final Intent paramIntent, final boolean paramBoolean)
  {
    paramIntent = new Runnable()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(281454);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.pph)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(281454);
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
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.j(paramInt, JsApiShareAppMessageBase.this.h("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.ppr.fzM;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(281454);
          return;
          str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User");
          break;
          bool = false;
          break label70;
        }
        label207:
        if ((str1 == null) || (str1.length() == 0))
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.j(paramInt, JsApiShareAppMessageBase.this.h("fail:selected user is nil", null));
          AppMethodBeat.o(281454);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.ppr.fzM;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(281454);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174894);
        f.aI(paramParam.fDf).b(new f.c()
        {
          public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(274298);
            if (JsApiShareAppMessageBase.this.pph != paramAnonymous2Int1)
            {
              AppMethodBeat.o(274298);
              return false;
            }
            JsApiShareAppMessageBase.4.this.pkm.d(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(274298);
            return true;
          }
        });
        Activity localActivity = paramParam.fDf;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          com.tencent.mm.by.c.d(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.pph);
          AppMethodBeat.o(174894);
          return;
        }
      }
    };
    if (paramParam.ppu.c(paramParam)) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
    }
    for (long l = 200L;; l = 0L)
    {
      paramc.h(paramIntent, l);
      return;
    }
  }
  
  protected final void a(final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, final Param paramParam)
  {
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    a(localSendAppMessageTask, paramString1, paramString2, paramBoolean, paramc, paramParam);
    if (paramParam.withShareTicket)
    {
      localSendAppMessageTask.otv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(280915);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.bPk();
          paramc.j(paramInt, JsApiShareAppMessageBase.this.m("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(280915);
        }
      };
      localSendAppMessageTask.bsM();
    }
    for (;;)
    {
      if (paramParam.fDf != null) {
        com.tencent.mm.ui.base.h.cO(paramParam.fDf, paramParam.fDf.getResources().getString(au.i.app_brand_app_msg_shared));
      }
      return;
      localSendAppMessageTask.bsM();
      paramc.j(paramInt, m("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param bUr();
  
  static class ShareDialogTodoReportData
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
    public String lnp;
    public String ppG;
    public int ppH;
    public int ppI;
    public int ppJ;
    public String username;
    
    static
    {
      AppMethodBeat.i(184723);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184723);
    }
    
    protected ShareDialogTodoReportData(Parcel paramParcel)
    {
      AppMethodBeat.i(184722);
      this.ppG = paramParcel.readString();
      this.username = paramParcel.readString();
      this.lnp = paramParcel.readString();
      this.ppH = paramParcel.readInt();
      this.ppI = paramParcel.readInt();
      this.ppJ = paramParcel.readInt();
      AppMethodBeat.o(184722);
    }
    
    public ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.ppG = paramString1;
      this.username = paramString2;
      this.lnp = paramString3;
      this.ppH = paramInt1;
      this.ppI = paramInt2;
      this.ppJ = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184721);
      paramParcel.writeString(this.ppG);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.lnp);
      paramParcel.writeInt(this.ppH);
      paramParcel.writeInt(this.ppI);
      paramParcel.writeInt(this.ppJ);
      AppMethodBeat.o(184721);
    }
  }
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> ppo = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.ppo = null;
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
    JsApiShareAppMessageBase.a ppp;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cacheKey;
    String desc;
    Activity fDf = null;
    int fES;
    String fKH;
    String fXg;
    String fve;
    String imageUrl;
    public String lkm = "";
    String lnb;
    boolean oOP;
    String obX;
    int pkgVersion;
    String ppA = "";
    String ppB = "";
    public boolean ppC;
    HashMap<String, Object> ppD;
    int ppE = 0;
    String ppF;
    ah ppq = null;
    AppBrandSysConfigWC ppr = null;
    boolean pps;
    String ppt;
    JsApiShareAppMessageBase.b ppu;
    boolean ppv;
    boolean ppw;
    boolean ppx;
    int ppy;
    boolean ppz = false;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.fDf + ", pageView=" + this.ppq + ", config=" + this.ppr + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.fve + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.pps + ", messageExtraData='" + this.fXg + '\'' + ", mShareExtImp=" + this.ppu + ", isDynamicMsg=" + this.ppv + ", isUpdateMsg=" + this.ppw + ", isPrivateMsg=" + this.ppx + ", templateId='" + this.lnb + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.fES + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.ppy + ", errorUrl='" + this.obX + '\'' + ", needDelThumb=" + this.oOP + ", imgPath='" + this.fKH + '\'' + ", useDefaultSnapshot=" + this.ppz + ", msgParams=" + this.ppD + ", todoActivityId=" + this.lkm + ", isToDoMessage=" + this.ppC + ", kv14077ReportShareSourceType=" + this.ppE + ", currentHtmlUrl=" + this.ppF + '}';
      AppMethodBeat.o(174895);
      return str;
    }
  }
  
  static class e
    implements m<JsApiShareAppMessageBase.ShareDialogTodoReportData, IPCVoid>
  {}
  
  protected static final class f
    implements JsApiShareAppMessageBase.b
  {
    String ppK;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.imageUrl);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.ppK);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.ppK = paramJSONObject.optString("link");
      if (Util.isNullOrNil(this.ppK))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.ppD.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      paramSendAppMessageTask.pqq = 5;
      paramSendAppMessageTask.url = this.ppK;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = Util.nullAsNil(paramShareParams.fKH).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.ppK + '\'' + '}';
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
      boolean bool = Util.nullAsNil(paramShareParams.fKH).startsWith("delayLoadFile://");
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
    String fVg;
    String lky;
    String ppL;
    String ppM;
    String ppN;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.fVg = paramJSONObject.optString("videoMD5");
      this.ppL = paramJSONObject.optString("videoButtonText");
      this.lky = paramJSONObject.optString("playDesc");
      this.ppM = z.a(paramShareParams.ppq, this.videoPath, paramShareParams.ppz);
      this.ppN = z.a(paramShareParams.ppq, paramc, paramShareParams.ppz);
      if ((Util.isNullOrNil(this.ppM)) || (Util.isNullOrNil(this.ppN)) || (Util.isNullOrNil(this.fVg)))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.ppD.put("is_video", Boolean.TRUE);
      paramShareParams.ppD.put("footer_icon", paramShareParams.ppr.mnM);
      paramShareParams.ppD.put("footer_text", paramShareParams.ppr.fzM);
      paramShareParams.ppD.put("video_path", this.ppM);
      paramShareParams.ppD.put("video_thumb_path", this.ppN);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.pqq = 4;
      paramSendAppMessageTask.pqv = true;
      paramSendAppMessageTask.videoPath = z.aiD(this.ppM);
      paramSendAppMessageTask.pqA = z.aiD(this.ppN);
      paramSendAppMessageTask.fVg = this.fVg;
      paramSendAppMessageTask.ppL = this.ppL;
      paramSendAppMessageTask.lky = this.lky;
      paramSendAppMessageTask.pqo = z.aiD(this.ppN);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((Util.nullAsNil(paramShareParams.fKH).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.ppM).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.ppN).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.fVg + '\'' + ", videoButtonText='" + this.ppL + '\'' + ", videoPlayDesc='" + this.lky + '\'' + ", videoPathInFileSystem='" + this.ppM + '\'' + ", videoThumbPathInFileSystem='" + this.ppN + '\'' + '}';
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
      paramShareParams.ppz = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (Util.isNullOrNil(str)) {
        paramJSONObject = com.tencent.mm.plugin.appbrand.z.aca(paramc.getAppId());
      }
      paramShareParams.obX = paramJSONObject;
      paramShareParams.ppD.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().bDy();
      if ((paramc.cwW != null) && (!Util.isNullOrNil(paramc.cwW.nZb))) {
        paramShareParams.ppD.put("msg_img_path", paramc.cwW.nZb);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().bDy();
      paramSendAppMessageTask.pqq = 3;
      if (paramc.cwW != null)
      {
        paramSendAppMessageTask.pqw = paramc.cwW.appId;
        paramSendAppMessageTask.pqx = paramc.cwW.appName;
        paramSendAppMessageTask.pqy = paramc.cwW.sourceUserName;
        paramSendAppMessageTask.pqz = paramc.cwW.thumbUrl;
        if (Util.isNullOrNil(paramSendAppMessageTask.pqn))
        {
          paramSendAppMessageTask.pqo = paramc.cwW.nZa;
          paramSendAppMessageTask.oOP = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { paramShareParams.appId, paramShareParams.fve, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = Util.nullAsNil(paramShareParams.fKH).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */