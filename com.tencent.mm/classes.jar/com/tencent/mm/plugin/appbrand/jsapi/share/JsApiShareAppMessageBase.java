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
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.fcc;
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
  final int stV = com.tencent.luggage.sdk.h.a.ce(this);
  
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
        paramWWMediaMiniProgram.aida = paramBitmap.toByteArray();
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
        paramWWMediaMiniProgram.aida = new byte[1];
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
    d locald = cuF();
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.hHU = paramc.aQ(Activity.class);
    if (locald.hHU == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.sue = ((ah)paramc.aP(ah.class));
    if (locald.sue == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    Object localObject3 = locald.sue.CF(com.tencent.mm.plugin.appbrand.menu.x.tkk.ordinal());
    Object localObject1 = locald.sue.CF(com.tencent.mm.plugin.appbrand.menu.x.tkK.ordinal());
    if ((localObject3 == null) && (localObject1 == null))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    localObject1 = paramJSONObject.optString("type");
    if (com.tencent.mm.plugin.appbrand.weishi.h.aD(paramc.getRuntime())) {
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
      locald.sui = ((b)localObject1);
      locald.suf = paramc.getRuntime().ccM();
      locald.withShareTicket = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.getBoolean("enable_share_with_share_ticket", false);
      if ((!locald.withShareTicket) && ((paramc instanceof p))) {
        locald.withShareTicket = "withShareTicket".equals(paramJSONObject.optString("mode"));
      }
      locald.sur = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.getBoolean("is_todo_message", false);
      locald.nOY = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.getString("share_todo_activity_id", "");
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
      locald.hzy = paramJSONObject.optString("path");
      locald.imageUrl = paramJSONObject.optString("imageUrl");
      locald.mgR = paramJSONObject.optString("cacheKey");
      locald.sug = paramJSONObject.optBoolean("disableForward", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.sug) });
      locald.idf = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.suo = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      locald.suh = str;
      localObject1 = paramc.getRuntime().getInitConfig();
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
    locald.suj = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.Jp("enable_share_dynamic");
    locald.suk = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.Jp("enable_share_with_updateable_msg");
    locald.sul = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.Jp("enable_share_with_private_msg");
    locald.nSg = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.hJK = locald.suf.qYY.qHO;
    locald.pkgVersion = locald.suf.qYY.pkgVersion;
    locald.sun = paramc.getRuntime().getInitConfig().appServiceType;
    locald.rcN = ac.UC(paramc.getAppId());
    locald.rSD = x.abC(locald.imageUrl);
    locald.hQn = x.a(locald.sue, locald.imageUrl, locald.suo);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.hQn, locald.imageUrl, Boolean.valueOf(locald.suo) });
    locald.sus = new HashMap();
    locald.sus.put("desc", locald.desc);
    locald.sus.put("type", Integer.valueOf(locald.type));
    locald.sus.put("title", locald.title);
    locald.sus.put("app_id", locald.appId);
    locald.sus.put("pkg_type", Integer.valueOf(locald.hJK));
    locald.sus.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.sus.put("img_url", locald.imageUrl);
    locald.sus.put("is_dynamic", Boolean.valueOf(locald.suj));
    locald.sus.put("cache_key", locald.mgR);
    locald.sus.put("path", locald.hzy);
    locald.sus.put("disableForward", Boolean.valueOf(locald.sug));
    locald.sus.put("subType", Integer.valueOf(locald.subType));
    if (!Util.isNullOrNil(locald.hQn)) {
      locald.sus.put("delay_load_img_path", locald.hQn);
    }
    locald.sup = paramJSONObject.optString("openId");
    localObject1 = paramJSONObject.optString("chatroomUsername");
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject1 = "";
      if (localObject3 == null) {
        break label1303;
      }
      localObject1 = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC.getString("share_to_user", "");
      if (localObject3 == null) {
        break label1324;
      }
      localObject3 = ((com.tencent.mm.plugin.appbrand.menu.w)localObject3).rDC;
      localObject2 = localObject1;
      if (!TextUtils.isEmpty("share_to_user"))
      {
        ((ad.b)localObject3).oks.remove("share_to_user");
        localObject2 = localObject1;
      }
    }
    label1193:
    locald.suq = ((String)localObject2);
    locald.sui.a(locald, paramc, paramJSONObject);
    localObject1 = paramc.ccK();
    label1227:
    label1242:
    boolean bool;
    if (localObject1 == null)
    {
      paramc = null;
      if (paramc == null) {
        break label1358;
      }
      locald.suu = paramc.getCurrentUrl();
      bool = paramJSONObject.optBoolean("sdk_isFromMenu", false);
      paramc = getName();
      if ((!TextUtils.isEmpty(paramc)) && (!paramc.equals("shareAppMessage"))) {
        break label1381;
      }
      locald.sut = 0;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
      return locald;
      label1303:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.WxaMenuHelper", "safeGetString, menuInfo is null, key: ".concat(String.valueOf("share_to_user")));
      break;
      label1324:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.WxaMenuHelper", "safeRemove, menuInfo is null, key: ".concat(String.valueOf("share_to_user")));
      localObject2 = localObject1;
      break label1193;
      paramc = ((ah)localObject1).cFg();
      break label1227;
      label1358:
      if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k)) {
        break label1242;
      }
      locald.suu = paramJSONObject.optString("webViewUrl");
      break label1242;
      label1381:
      if (paramc.contains("ToSpecificContact")) {
        locald.sut = 2;
      } else if (bool) {
        locald.sut = 0;
      } else {
        locald.sut = 1;
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
        if (!Util.isNullOrNil(paramSendAppMessageTask.svo))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.svo.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.eoU);
            localJSONObject.put("shareName", localShareInfo.eoT);
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
      paramIntent.putExtra("appbrand_params", paramParam.sus);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.sui.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.plugin.appbrand.service.c paramc, Param paramParam)
  {
    paramSendAppMessageTask.suZ = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    if ((paramString1 != null) && (paramString1.asH() != null) && ((paramString1.asH() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.appVersion = ((AppBrandInitConfigWC)paramString1.asH()).appVersion;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.rcN;
      paramSendAppMessageTask.path = paramParam.hzy;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.rSD = paramParam.rSD;
      paramSendAppMessageTask.sva = paramParam.imageUrl;
      paramSendAppMessageTask.iconUrl = paramParam.suf.phA;
      paramSendAppMessageTask.hJK = paramParam.suf.qYY.qHO;
      paramSendAppMessageTask.rcM = paramParam.suf.qYY.md5;
      paramSendAppMessageTask.version = paramParam.suf.qYY.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.suf.hEy;
      paramSendAppMessageTask.idf = paramParam.idf;
      paramSendAppMessageTask.nOX = paramParam.suf.nOX;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.sug) {
        break label533;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.rxs = i;
      if ((paramString1.asG() instanceof AppBrandSysConfigWC)) {
        paramSendAppMessageTask.opX = com.tencent.mm.plugin.appbrand.config.a.qVw.a((AppBrandSysConfigWC)paramString1.asG());
      }
      paramSendAppMessageTask.sve = u.Uy(paramParam.appId).quY.getAndIncrement();
      paramSendAppMessageTask.svg = paramParam.sue.cgR();
      paramSendAppMessageTask.svh = paramParam.sue.coY();
      paramString1 = paramParam.sue.getRuntime().asA().epn;
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
      paramSendAppMessageTask.hzx = Util.nullAsNil(paramString1.hzx);
      paramSendAppMessageTask.svf = Util.nullAsNil(paramParam.sue.getRuntime().getInitConfig().eoP);
      paramSendAppMessageTask.svb = x.abD(paramParam.hQn);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.suj = paramParam.suj;
      paramSendAppMessageTask.suk = paramParam.suk;
      paramSendAppMessageTask.sul = paramParam.sul;
      paramSendAppMessageTask.nSg = paramParam.nSg;
      paramSendAppMessageTask.mgR = paramParam.mgR;
      paramSendAppMessageTask.serviceType = paramParam.sun;
      paramSendAppMessageTask.suu = paramParam.suu;
      paramParam.sui.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.sur = paramParam.sur;
      paramSendAppMessageTask.nOY = paramParam.nOY;
      paramSendAppMessageTask.nPl = paramBoolean;
      paramSendAppMessageTask.sut = paramParam.sut;
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
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(326427);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.stV)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(326427);
          return;
        }
        String str1;
        boolean bool;
        if (paramAnonymousIntent == null)
        {
          str1 = null;
          if ((paramAnonymousIntent == null) || (!paramAnonymousIntent.getBooleanExtra("KSendGroupToDo", false))) {
            break label189;
          }
          bool = true;
          label70:
          if (paramAnonymousIntent != null) {
            break label195;
          }
        }
        label189:
        label195:
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("KShowTodoIntroduceView", 0))
        {
          if (paramAnonymousInt2 == -1) {
            break label206;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.callback(paramInt, JsApiShareAppMessageBase.this.ZP("cancel"));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.suf.hEy;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(326427);
          return;
          str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User");
          break;
          bool = false;
          break label70;
        }
        label206:
        if ((str1 == null) || (str1.length() == 0))
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.callback(paramInt, JsApiShareAppMessageBase.this.ZP("fail:selected user is nil"));
          AppMethodBeat.o(326427);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.suf.hEy;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(326427);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174894);
        e.bt(paramParam.hHU).b(new e.c()
        {
          public final boolean onResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(326433);
            if (JsApiShareAppMessageBase.this.stV != paramAnonymous2Int1)
            {
              AppMethodBeat.o(326433);
              return false;
            }
            JsApiShareAppMessageBase.4.this.spn.mmOnActivityResult(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(326433);
            return true;
          }
        });
        Activity localActivity = paramParam.hHU;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          com.tencent.mm.br.c.d(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.stV);
          AppMethodBeat.o(174894);
          return;
        }
      }
    };
    if (paramParam.sui.c(paramParam)) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
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
      localSendAppMessageTask.rxj = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(326430);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.cpx();
          paramc.callback(paramInt, JsApiShareAppMessageBase.this.m("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(326430);
        }
      };
      localSendAppMessageTask.bQt();
    }
    for (;;)
    {
      if (paramParam.hHU != null) {
        com.tencent.mm.ui.base.k.cZ(paramParam.hHU, paramParam.hHU.getResources().getString(ba.i.app_brand_app_msg_shared));
      }
      return;
      localSendAppMessageTask.bQt();
      paramc.callback(paramInt, m("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param cuF();
  
  static class ShareDialogTodoReportData
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
    public String nSt;
    public String suv;
    public int suw;
    public int sux;
    public int suy;
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
      this.suv = paramParcel.readString();
      this.username = paramParcel.readString();
      this.nSt = paramParcel.readString();
      this.suw = paramParcel.readInt();
      this.sux = paramParcel.readInt();
      this.suy = paramParcel.readInt();
      AppMethodBeat.o(184722);
    }
    
    public ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.suv = paramString1;
      this.username = paramString2;
      this.nSt = paramString3;
      this.suw = paramInt1;
      this.sux = paramInt2;
      this.suy = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184721);
      paramParcel.writeString(this.suv);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.nSt);
      paramParcel.writeInt(this.suw);
      paramParcel.writeInt(this.sux);
      paramParcel.writeInt(this.suy);
      AppMethodBeat.o(184721);
    }
  }
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> suc = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.suc = null;
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
    JsApiShareAppMessageBase.a sud;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String desc;
    Activity hHU = null;
    int hJK;
    String hQn;
    String hzy;
    String idf;
    String imageUrl;
    String mgR;
    public String nOY = "";
    String nSg;
    int pkgVersion;
    boolean rSD;
    String rcN;
    int subType = 0;
    ah sue = null;
    AppBrandSysConfigWC suf = null;
    boolean sug;
    String suh;
    JsApiShareAppMessageBase.b sui;
    boolean suj;
    boolean suk;
    boolean sul;
    int sun;
    boolean suo = false;
    String sup = "";
    String suq = "";
    public boolean sur;
    HashMap<String, Object> sus;
    int sut = 0;
    String suu;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.hHU + ", pageView=" + this.sue + ", config=" + this.suf + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.hzy + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", cacheKey='" + this.mgR + '\'' + ", disableForward=" + this.sug + ", messageExtraData='" + this.idf + '\'' + ", mShareExtImp=" + this.sui + ", isDynamicMsg=" + this.suj + ", isUpdateMsg=" + this.suk + ", isPrivateMsg=" + this.sul + ", templateId='" + this.nSg + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.hJK + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.sun + ", errorUrl='" + this.rcN + '\'' + ", needDelThumb=" + this.rSD + ", imgPath='" + this.hQn + '\'' + ", useDefaultSnapshot=" + this.suo + ", msgParams=" + this.sus + ", todoActivityId=" + this.nOY + ", isToDoMessage=" + this.sur + ", kv14077ReportShareSourceType=" + this.sut + ", currentHtmlUrl=" + this.suu + '}';
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
    String suz;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.imageUrl);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.suz);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.suz = paramJSONObject.optString("link");
      if (Util.isNullOrNil(this.suz))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.sus.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      paramSendAppMessageTask.svd = 5;
      paramSendAppMessageTask.url = this.suz;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = Util.nullAsNil(paramShareParams.hQn).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.suz + '\'' + '}';
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
      boolean bool = Util.nullAsNil(paramShareParams.hQn).startsWith("delayLoadFile://");
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
    String ibd;
    String nPk;
    String suA;
    String suB;
    String suC;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.ibd = paramJSONObject.optString("videoMD5");
      this.suA = paramJSONObject.optString("videoButtonText");
      this.nPk = paramJSONObject.optString("playDesc");
      this.suB = x.a(paramShareParams.sue, this.videoPath, paramShareParams.suo);
      this.suC = x.a(paramShareParams.sue, paramc, paramShareParams.suo);
      if ((Util.isNullOrNil(this.suB)) || (Util.isNullOrNil(this.suC)) || (Util.isNullOrNil(this.ibd)))
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.sus.put("is_video", Boolean.TRUE);
      paramShareParams.sus.put("footer_icon", paramShareParams.suf.phA);
      paramShareParams.sus.put("footer_text", paramShareParams.suf.hEy);
      paramShareParams.sus.put("video_path", this.suB);
      paramShareParams.sus.put("video_thumb_path", this.suC);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.svd = 4;
      paramSendAppMessageTask.svi = true;
      paramSendAppMessageTask.videoPath = x.abD(this.suB);
      paramSendAppMessageTask.svn = x.abD(this.suC);
      paramSendAppMessageTask.ibd = this.ibd;
      paramSendAppMessageTask.suA = this.suA;
      paramSendAppMessageTask.nPk = this.nPk;
      paramSendAppMessageTask.svb = x.abD(this.suC);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((Util.nullAsNil(paramShareParams.hQn).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.suB).startsWith("delayLoadFile://")) || (Util.nullAsNil(this.suC).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.ibd + '\'' + ", videoButtonText='" + this.suA + '\'' + ", videoPlayDesc='" + this.nPk + '\'' + ", videoPathInFileSystem='" + this.suB + '\'' + ", videoThumbPathInFileSystem='" + this.suC + '\'' + '}';
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
      paramShareParams.suo = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (Util.isNullOrNil(str)) {
        paramJSONObject = ac.UC(paramc.getAppId());
      }
      paramShareParams.rcN = paramJSONObject;
      paramShareParams.sus.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().getInitConfig();
      if ((paramc.eoW != null) && (!Util.isNullOrNil(paramc.eoW.qZj))) {
        paramShareParams.sus.put("msg_img_path", paramc.eoW.qZj);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().getInitConfig();
      paramSendAppMessageTask.svd = 3;
      if (paramc.eoW != null)
      {
        paramSendAppMessageTask.svj = paramc.eoW.appId;
        paramSendAppMessageTask.svk = paramc.eoW.appName;
        paramSendAppMessageTask.svl = paramc.eoW.sourceUserName;
        paramSendAppMessageTask.svm = paramc.eoW.thumbUrl;
        if (Util.isNullOrNil(paramSendAppMessageTask.sva))
        {
          paramSendAppMessageTask.svb = paramc.eoW.qZi;
          paramSendAppMessageTask.rSD = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { paramShareParams.appId, paramShareParams.hzy, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = Util.nullAsNil(paramShareParams.hQn).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */