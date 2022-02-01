package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;
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
  extends com.tencent.mm.plugin.appbrand.jsapi.d<c>
{
  final int mqZ = com.tencent.luggage.sdk.g.a.aK(this);
  
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
        paramWWMediaMiniProgram.Sxw = paramBitmap.toByteArray();
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
        paramWWMediaMiniProgram.Sxw = new byte[1];
        return;
      }
      label284:
      int i = 1024;
      int j = 1024;
    }
  }
  
  protected Param a(c paramc, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = bIJ();
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.dKq = paramc.ay(Activity.class);
    if (locald.dKq == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.mri = ((ag)paramc.ax(ag.class));
    if (locald.mri == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    t localt = locald.mri.yK(u.neY.ordinal());
    Object localObject1 = locald.mri.yK(u.nfy.ordinal());
    if ((localt == null) && (localObject1 == null))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    localObject1 = paramJSONObject.optString("type");
    if (g.an(paramc.getRuntime())) {
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
      locald.mrm = ((b)localObject1);
      locald.mrj = paramc.getRuntime().bsB();
      locald.withShareTicket = localt.lEi.getBoolean("enable_share_with_share_ticket", false);
      if ((!locald.withShareTicket) && ((paramc instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p))) {
        locald.withShareTicket = "withShareTicket".equals(paramJSONObject.optString("mode"));
      }
      locald.mru = localt.lEi.getBoolean("is_todo_message", false);
      locald.ivd = localt.lEi.getString("share_todo_activity_id", "");
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
      locald.dCx = paramJSONObject.optString("path");
      locald.imageUrl = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.mrk = paramJSONObject.optBoolean("disableForward", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.mrk) });
      locald.eda = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.mrr = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      locald.mrl = str;
      localObject1 = paramc.getRuntime().bsC();
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
    locald.mrn = localt.lEi.JY("enable_share_dynamic");
    locald.mro = localt.lEi.JY("enable_share_with_updateable_msg");
    locald.mrp = localt.lEi.JY("enable_share_with_private_msg");
    locald.ixM = localt.lEi.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.dMe = locald.mrj.leE.kNW;
    locald.pkgVersion = locald.mrj.leE.pkgVersion;
    locald.mrq = paramc.getRuntime().bsC().cyo;
    locald.lho = w.Ur(paramc.getAppId());
    locald.lSk = y.aaK(locald.imageUrl);
    locald.dRr = y.a(locald.mri, locald.imageUrl, locald.mrr);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.dRr, locald.imageUrl, Boolean.valueOf(locald.mrr) });
    locald.mrv = new HashMap();
    locald.mrv.put("desc", locald.desc);
    locald.mrv.put("type", Integer.valueOf(locald.type));
    locald.mrv.put("title", locald.title);
    locald.mrv.put("app_id", locald.appId);
    locald.mrv.put("pkg_type", Integer.valueOf(locald.dMe));
    locald.mrv.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.mrv.put("img_url", locald.imageUrl);
    locald.mrv.put("is_dynamic", Boolean.valueOf(locald.mrn));
    locald.mrv.put("cache_key", locald.cacheKey);
    locald.mrv.put("path", locald.dCx);
    locald.mrv.put("disableForward", Boolean.valueOf(locald.mrk));
    locald.mrv.put("subType", Integer.valueOf(locald.subType));
    if (!Util.isNullOrNil(locald.dRr)) {
      locald.mrv.put("delay_load_img_path", locald.dRr);
    }
    locald.mrs = paramJSONObject.optString("openId");
    locald.mrt = paramJSONObject.optString("chatroomUsername");
    locald.mrm.a(locald, paramc, paramJSONObject);
    localObject1 = paramc.bsz();
    label1158:
    boolean bool;
    if (localObject1 == null)
    {
      paramc = null;
      if (paramc == null) {
        break label1228;
      }
      locald.mrx = paramc.getWebView().getUrl();
      bool = paramJSONObject.optBoolean("sdk_isFromMenu", false);
      paramc = getName();
      if ((!TextUtils.isEmpty(paramc)) && (!paramc.equals("shareAppMessage"))) {
        break label1251;
      }
      locald.mrw = 0;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
      return locald;
      paramc = ((ag)localObject1).bRM();
      break;
      label1228:
      if (!(localObject1 instanceof k)) {
        break label1158;
      }
      locald.mrx = paramJSONObject.optString("webViewUrl");
      break label1158;
      label1251:
      if (paramc.contains("ToSpecificContact")) {
        locald.mrw = 2;
      } else if (bool) {
        locald.mrw = 0;
      } else {
        locald.mrw = 1;
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
        if (!Util.isNullOrNil(paramSendAppMessageTask.mst))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.mst.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.cyr);
            localJSONObject.put("shareName", localShareInfo.cyq);
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
      paramIntent.putExtra("appbrand_params", paramParam.mrv);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.mrm.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, c paramc, Param paramParam)
  {
    paramSendAppMessageTask.msd = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    if ((paramString1 != null) && (paramString1.OU() != null) && ((paramString1.OU() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.appVersion = ((AppBrandInitConfigWC)paramString1.OU()).appVersion;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.lho;
      paramSendAppMessageTask.path = paramParam.dCx;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.lSk = paramParam.lSk;
      paramSendAppMessageTask.mse = paramParam.imageUrl;
      paramSendAppMessageTask.iconUrl = paramParam.mrj.jyi;
      paramSendAppMessageTask.dMe = paramParam.mrj.leE.kNW;
      paramSendAppMessageTask.lhn = paramParam.mrj.leE.md5;
      paramSendAppMessageTask.version = paramParam.mrj.leE.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.mrj.brandName;
      paramSendAppMessageTask.eda = paramParam.eda;
      paramSendAppMessageTask.leb = paramParam.mrj.leb;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.mrk) {
        break label506;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.lyE = i;
      paramSendAppMessageTask.msj = com.tencent.mm.plugin.appbrand.p.Un(paramParam.appId).kCQ.getAndIncrement();
      paramSendAppMessageTask.msl = paramParam.mri.lBI;
      paramSendAppMessageTask.msm = paramParam.mri.bDn();
      paramString1 = paramParam.mri.getRuntime().ON().cyA;
      if (paramString1 != null) {
        if (paramString1.scene != 0) {
          break label512;
        }
      }
    }
    label512:
    for (int i = 1000;; i = paramString1.scene)
    {
      paramSendAppMessageTask.scene = i;
      paramSendAppMessageTask.dCw = Util.nullAsNil(paramString1.dCw);
      paramSendAppMessageTask.msk = Util.nullAsNil(paramParam.mri.getRuntime().bsC().cym);
      paramSendAppMessageTask.msf = y.aaL(paramParam.dRr);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.mrn = paramParam.mrn;
      paramSendAppMessageTask.mro = paramParam.mro;
      paramSendAppMessageTask.mrp = paramParam.mrp;
      paramSendAppMessageTask.ixM = paramParam.ixM;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.serviceType = paramParam.mrq;
      paramSendAppMessageTask.mrx = paramParam.mrx;
      paramParam.mrm.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.mru = paramParam.mru;
      paramSendAppMessageTask.ivd = paramParam.ivd;
      paramSendAppMessageTask.ivq = paramBoolean;
      paramSendAppMessageTask.mrw = paramParam.mrw;
      return;
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.appVersion = -1;
      break;
      label506:
      i = 0;
      break label242;
    }
  }
  
  final void a(final c paramc, final int paramInt, final Param paramParam, Intent paramIntent, boolean paramBoolean)
  {
    paramIntent = new JsApiShareAppMessageBase.4(this, paramParam, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(226984);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.mqZ)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(226984);
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
          paramc.i(paramInt, JsApiShareAppMessageBase.this.h("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.mrj.brandName;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(226984);
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
          paramc.i(paramInt, JsApiShareAppMessageBase.this.h("fail:selected user is nil", null));
          AppMethodBeat.o(226984);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.mrj.brandName;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(226984);
      }
    }, paramBoolean, paramIntent);
    if (paramParam.mrm.c(paramParam)) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
    }
    for (long l = 200L;; l = 0L)
    {
      paramc.i(paramIntent, l);
      return;
    }
  }
  
  protected final void a(final String paramString1, String paramString2, boolean paramBoolean, final c paramc, final int paramInt, final Param paramParam)
  {
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    a(localSendAppMessageTask, paramString1, paramString2, paramBoolean, paramc, paramParam);
    if (paramParam.withShareTicket)
    {
      localSendAppMessageTask.lyv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226986);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.bDK();
          paramc.i(paramInt, JsApiShareAppMessageBase.this.n("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(226986);
        }
      };
      localSendAppMessageTask.bDJ();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (paramParam.dKq != null) {
        com.tencent.mm.ui.base.h.cD(paramParam.dKq, paramParam.dKq.getResources().getString(2131755353));
      }
      return;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramc.i(paramInt, n("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param bIJ();
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> mrg = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.mrg = null;
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
    JsApiShareAppMessageBase.a mrh;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cacheKey;
    String dCx;
    Activity dKq = null;
    int dMe;
    String dRr;
    String desc;
    String eda;
    String imageUrl;
    public String ivd = "";
    String ixM;
    boolean lSk;
    String lho;
    ag mri = null;
    AppBrandSysConfigWC mrj = null;
    boolean mrk;
    String mrl;
    JsApiShareAppMessageBase.b mrm;
    boolean mrn;
    boolean mro;
    boolean mrp;
    int mrq;
    boolean mrr = false;
    String mrs = "";
    String mrt = "";
    public boolean mru;
    HashMap<String, Object> mrv;
    int mrw = 0;
    String mrx;
    int pkgVersion;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.dKq + ", pageView=" + this.mri + ", config=" + this.mrj + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.dCx + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.mrk + ", messageExtraData='" + this.eda + '\'' + ", mShareExtImp=" + this.mrm + ", isDynamicMsg=" + this.mrn + ", isUpdateMsg=" + this.mro + ", isPrivateMsg=" + this.mrp + ", templateId='" + this.ixM + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.dMe + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.mrq + ", errorUrl='" + this.lho + '\'' + ", needDelThumb=" + this.lSk + ", imgPath='" + this.dRr + '\'' + ", useDefaultSnapshot=" + this.mrr + ", msgParams=" + this.mrv + ", todoActivityId=" + this.ivd + ", isToDoMessage=" + this.mru + ", kv14077ReportShareSourceType=" + this.mrw + ", currentHtmlUrl=" + this.mrx + '}';
      AppMethodBeat.o(174895);
      return str;
    }
  }
  
  protected static final class f
    implements JsApiShareAppMessageBase.b
  {
    String mrC;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.imageUrl);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.mrC);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.mrC = paramJSONObject.optString("link");
      if (Util.isNullOrNil(this.mrC))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.mrv.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      paramSendAppMessageTask.msi = 5;
      paramSendAppMessageTask.url = this.mrC;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = Util.nullAsNil(paramShareParams.dRr).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.mrC + '\'' + '}';
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
      boolean bool = Util.nullAsNil(paramShareParams.dRr).startsWith("delayLoadFile://");
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
    String ebj;
    String ivp;
    String mrD;
    String mrE;
    String mrF;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.ebj = paramJSONObject.optString("videoMD5");
      this.mrD = paramJSONObject.optString("videoButtonText");
      this.ivp = paramJSONObject.optString("playDesc");
      this.mrE = y.a(paramShareParams.mri, this.videoPath, paramShareParams.mrr);
      this.mrF = y.a(paramShareParams.mri, paramc, paramShareParams.mrr);
      if ((Util.isNullOrNil(this.mrE)) || (Util.isNullOrNil(this.mrF)) || (Util.isNullOrNil(this.ebj)))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.mrv.put("is_video", Boolean.TRUE);
      paramShareParams.mrv.put("footer_icon", paramShareParams.mrj.jyi);
      paramShareParams.mrv.put("footer_text", paramShareParams.mrj.brandName);
      paramShareParams.mrv.put("video_path", this.mrE);
      paramShareParams.mrv.put("video_thumb_path", this.mrF);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.msi = 4;
      paramSendAppMessageTask.msn = true;
      paramSendAppMessageTask.videoPath = y.aaL(this.mrE);
      paramSendAppMessageTask.mss = y.aaL(this.mrF);
      paramSendAppMessageTask.ebj = this.ebj;
      paramSendAppMessageTask.mrD = this.mrD;
      paramSendAppMessageTask.ivp = this.ivp;
      paramSendAppMessageTask.msf = y.aaL(this.mrF);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((Util.nullAsNil(paramShareParams.dRr).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.mrE).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.mrF).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.ebj + '\'' + ", videoButtonText='" + this.mrD + '\'' + ", videoPlayDesc='" + this.ivp + '\'' + ", videoPathInFileSystem='" + this.mrE + '\'' + ", videoThumbPathInFileSystem='" + this.mrF + '\'' + '}';
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
      paramShareParams.mrr = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (Util.isNullOrNil(str)) {
        paramJSONObject = w.Ur(paramc.getAppId());
      }
      paramShareParams.lho = paramJSONObject;
      paramShareParams.mrv.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().bsC();
      if ((paramc.cyt != null) && (!Util.isNullOrNil(paramc.cyt.leO))) {
        paramShareParams.mrv.put("msg_img_path", paramc.cyt.leO);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().bsC();
      paramSendAppMessageTask.msi = 3;
      if (paramc.cyt != null)
      {
        paramSendAppMessageTask.mso = paramc.cyt.appId;
        paramSendAppMessageTask.msp = paramc.cyt.appName;
        paramSendAppMessageTask.msq = paramc.cyt.sourceUserName;
        paramSendAppMessageTask.msr = paramc.cyt.thumbUrl;
        if (Util.isNullOrNil(paramSendAppMessageTask.mse))
        {
          paramSendAppMessageTask.msf = paramc.cyt.leN;
          paramSendAppMessageTask.lSk = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { paramShareParams.appId, paramShareParams.dCx, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = Util.nullAsNil(paramShareParams.dRr).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */