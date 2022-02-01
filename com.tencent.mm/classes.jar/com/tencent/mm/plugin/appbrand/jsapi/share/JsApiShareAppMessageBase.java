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
import android.util.Log;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.wework.api.IWWAPI;
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
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.service.c>
{
  final int lhA = com.tencent.luggage.sdk.g.a.aC(this);
  
  static void a(Bitmap paramBitmap, WWMediaMiniProgram paramWWMediaMiniProgram)
  {
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.JsApiShareAppMessageBase", "writeBitmap, w:%d, h:%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
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
            localBitmap = com.tencent.mm.sdk.platformtools.g.b(paramBitmap, 0.0F, j / n, i / i1);
          }
        }
        paramBitmap = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 70, paramBitmap);
        paramWWMediaMiniProgram.Mox = paramBitmap.toByteArray();
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
        ad.i("MicroMsg.JsApiShareAppMessageBase", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramBitmap.getMessage() });
        paramWWMediaMiniProgram.Mox = new byte[1];
        return;
      }
      label284:
      int i = 1024;
      int j = 1024;
    }
  }
  
  protected Param a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
  {
    ad.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = bmz();
    if (paramJSONObject == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.dsa = paramc.au(Activity.class);
    if (locald.dsa == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.lhJ = ((ae)paramc.at(ae.class));
    if (locald.lhJ == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    com.tencent.mm.plugin.appbrand.menu.q localq = locald.lhJ.uN(com.tencent.mm.plugin.appbrand.menu.r.lSK.ordinal());
    Object localObject1 = locald.lhJ.uN(com.tencent.mm.plugin.appbrand.menu.r.lTk.ordinal());
    if ((localq == null) && (localObject1 == null))
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    localObject1 = paramJSONObject.optString("type");
    if (com.tencent.mm.plugin.appbrand.ab.g.am(paramc.getRuntime())) {
      localObject1 = "weishi";
    }
    Object localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = "normal";
    }
    String str = paramJSONObject.optString("to");
    ad.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", new Object[] { localObject2 });
    if ("video".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = new h();
      locald.lhN = ((b)localObject1);
      locald.lhK = paramc.getRuntime().aXb();
      locald.withShareTicket = localq.kwA.getBoolean("enable_share_with_share_ticket", false);
      if ((!locald.withShareTicket) && ((paramc instanceof p))) {
        locald.withShareTicket = "withShareTicket".equals(paramJSONObject.optString("mode"));
      }
      locald.lhV = localq.kwA.getBoolean("is_todo_message", false);
      locald.hyi = localq.kwA.getString("share_todo_activity_id", "");
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
      locald.dki = paramJSONObject.optString("path");
      locald.hym = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.lhL = paramJSONObject.optBoolean("disableForward", false);
      ad.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.lhL) });
      locald.dJW = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.lhS = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      locald.lhM = str;
      localObject1 = paramc.getRuntime().aXc();
      if (localObject1 != null) {
        break label610;
      }
      ad.e("MicroMsg.JsApiShareAppMessageBase", "hy: no init config");
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
    locald.lhO = localq.kwA.AI("enable_share_dynamic");
    locald.lhP = localq.kwA.AI("enable_share_with_updateable_msg");
    locald.lhQ = localq.kwA.AI("enable_share_with_private_msg");
    locald.hAT = localq.kwA.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.dtF = locald.lhK.jYh.jIU;
    locald.pkgVersion = locald.lhK.jYh.pkgVersion;
    locald.lhR = paramc.getRuntime().aXc().cmr;
    locald.kas = u.KJ(paramc.getAppId());
    locald.kKe = r.Qy(locald.hym);
    locald.dyy = r.a(locald.lhJ, locald.hym, locald.lhS);
    ad.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.dyy, locald.hym, Boolean.valueOf(locald.lhS) });
    locald.lhW = new HashMap();
    locald.lhW.put("desc", locald.desc);
    locald.lhW.put("type", Integer.valueOf(locald.type));
    locald.lhW.put("title", locald.title);
    locald.lhW.put("app_id", locald.appId);
    locald.lhW.put("pkg_type", Integer.valueOf(locald.dtF));
    locald.lhW.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.lhW.put("img_url", locald.hym);
    locald.lhW.put("is_dynamic", Boolean.valueOf(locald.lhO));
    locald.lhW.put("cache_key", locald.cacheKey);
    locald.lhW.put("path", locald.dki);
    locald.lhW.put("disableForward", Boolean.valueOf(locald.lhL));
    locald.lhW.put("subType", Integer.valueOf(locald.subType));
    if (!bt.isNullOrNil(locald.dyy)) {
      locald.lhW.put("delay_load_img_path", locald.dyy);
    }
    locald.lhT = paramJSONObject.optString("openId");
    locald.lhU = paramJSONObject.optString("chatroomUsername");
    locald.lhN.a(locald, paramc, paramJSONObject);
    ad.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", new Object[] { locald.toString() });
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
        if (!bt.hj(paramSendAppMessageTask.liL))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.liL.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.cmu);
            localJSONObject.put("shareName", localShareInfo.cmt);
            paramString.put(localJSONObject);
          }
        }
        return null;
      }
      catch (JSONException paramSendAppMessageTask)
      {
        ad.e("MicroMsg.JsApiShareAppMessageBase", Log.getStackTraceString(paramSendAppMessageTask));
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
      paramIntent.putExtra("appbrand_params", paramParam.lhW);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.lhN.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.plugin.appbrand.service.c paramc, Param paramParam)
  {
    paramSendAppMessageTask.liv = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    int i;
    if ((paramString1 != null) && (paramString1.Fi() != null) && ((paramString1.Fi() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.aDD = ((AppBrandInitConfigWC)paramString1.Fi()).aDD;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.kas;
      paramSendAppMessageTask.path = paramParam.dki;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.kKe = paramParam.kKe;
      paramSendAppMessageTask.liw = paramParam.hym;
      paramSendAppMessageTask.iconUrl = paramParam.lhK.iAa;
      paramSendAppMessageTask.dtF = paramParam.lhK.jYh.jIU;
      paramSendAppMessageTask.kar = paramParam.lhK.jYh.md5;
      paramSendAppMessageTask.version = paramParam.lhK.jYh.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.lhK.doD;
      paramSendAppMessageTask.dJW = paramParam.dJW;
      paramSendAppMessageTask.jXI = paramParam.lhK.jXI;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.lhL) {
        break label510;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.kro = i;
      paramSendAppMessageTask.liA = com.tencent.mm.plugin.appbrand.n.KF(paramParam.appId).jyU.getAndIncrement();
      paramSendAppMessageTask.liC = paramParam.lhJ.kuf;
      paramSendAppMessageTask.liD = paramParam.lhJ.bhq();
      paramString1 = paramParam.lhJ.getRuntime().Fb().cmC;
      if (paramString1 != null)
      {
        if (paramString1.scene != 0) {
          break label516;
        }
        i = 1000;
        label321:
        paramSendAppMessageTask.scene = i;
        paramSendAppMessageTask.dkh = bt.nullAsNil(paramString1.dkh);
        paramSendAppMessageTask.liB = bt.nullAsNil(paramParam.lhJ.getRuntime().aXc().Ec());
      }
      paramSendAppMessageTask.lix = r.Qz(paramParam.dyy);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.lhO = paramParam.lhO;
      paramSendAppMessageTask.lhP = paramParam.lhP;
      paramSendAppMessageTask.lhQ = paramParam.lhQ;
      paramSendAppMessageTask.hAT = paramParam.hAT;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.cQN = paramParam.lhR;
      paramString1 = paramParam.lhJ.buV();
      if (paramString1 != null) {
        break label525;
      }
    }
    label516:
    label525:
    for (paramString1 = "";; paramString1 = paramString1.getWebView().getUrl())
    {
      paramSendAppMessageTask.liF = paramString1;
      paramParam.lhN.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.lhV = paramParam.lhV;
      paramSendAppMessageTask.hyi = paramParam.hyi;
      paramSendAppMessageTask.hyw = paramBoolean;
      return;
      ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.aDD = -1;
      break;
      label510:
      i = 0;
      break label242;
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
        AppMethodBeat.i(188522);
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.lhA)
        {
          ad.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(188522);
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
          ad.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.lhK.doD;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.c(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
          AppMethodBeat.o(188522);
          return;
          str1 = paramAnonymousIntent.getStringExtra("Select_Conv_User");
          break;
          bool = false;
          break label70;
        }
        label207:
        if ((str1 == null) || (str1.length() == 0))
        {
          ad.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("fail:selected user is nil", null));
          AppMethodBeat.o(188522);
          return;
        }
        ad.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.lhK.doD;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.c(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(188522);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174894);
        e.aA(paramParam.dsa).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(188523);
            if (JsApiShareAppMessageBase.this.lhA != paramAnonymous2Int1)
            {
              AppMethodBeat.o(188523);
              return false;
            }
            JsApiShareAppMessageBase.4.this.lda.c(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(188523);
            return true;
          }
        });
        Activity localActivity = paramParam.dsa;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          d.c(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.lhA);
          AppMethodBeat.o(174894);
          return;
        }
      }
    };
    if (paramParam.lhN.c(paramParam)) {
      ad.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
    }
    for (long l = 200L;; l = 0L)
    {
      paramc.j(paramIntent, l);
      return;
    }
  }
  
  protected final void a(final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, final Param paramParam)
  {
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    a(localSendAppMessageTask, paramString1, paramString2, paramBoolean, paramc, paramParam);
    if (paramParam.withShareTicket)
    {
      localSendAppMessageTask.krg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188524);
          ad.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.bhO();
          paramc.h(paramInt, JsApiShareAppMessageBase.this.m("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(188524);
        }
      };
      localSendAppMessageTask.bhN();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (paramParam.dsa != null) {
        h.cl(paramParam.dsa, paramParam.dsa.getResources().getString(2131755317));
      }
      return;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramc.h(paramInt, m("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param bmz();
  
  static class ShareDialogTodoReportData
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
    public String hBg;
    public String lhX;
    public int lhY;
    public int lhZ;
    public int lia;
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
      this.lhX = paramParcel.readString();
      this.username = paramParcel.readString();
      this.hBg = paramParcel.readString();
      this.lhY = paramParcel.readInt();
      this.lhZ = paramParcel.readInt();
      this.lia = paramParcel.readInt();
      AppMethodBeat.o(184722);
    }
    
    public ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.lhX = paramString1;
      this.username = paramString2;
      this.hBg = paramString3;
      this.lhY = paramInt1;
      this.lhZ = paramInt2;
      this.lia = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184721);
      paramParcel.writeString(this.lhX);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.hBg);
      paramParcel.writeInt(this.lhY);
      paramParcel.writeInt(this.lhZ);
      paramParcel.writeInt(this.lia);
      AppMethodBeat.o(184721);
    }
  }
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> lhH = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.lhH = null;
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
    JsApiShareAppMessageBase.a lhI;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cacheKey;
    String dJW;
    String desc;
    String dki;
    Activity dsa = null;
    int dtF;
    String dyy;
    String hAT;
    public String hyi = "";
    String hym;
    boolean kKe;
    String kas;
    ae lhJ = null;
    AppBrandSysConfigWC lhK = null;
    boolean lhL;
    String lhM;
    JsApiShareAppMessageBase.b lhN;
    boolean lhO;
    boolean lhP;
    boolean lhQ;
    int lhR;
    boolean lhS = false;
    String lhT = "";
    String lhU = "";
    public boolean lhV;
    HashMap<String, Object> lhW;
    int pkgVersion;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.dsa + ", pageView=" + this.lhJ + ", config=" + this.lhK + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.dki + '\'' + ", imageUrl='" + this.hym + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.lhL + ", messageExtraData='" + this.dJW + '\'' + ", mShareExtImp=" + this.lhN + ", isDynamicMsg=" + this.lhO + ", isUpdateMsg=" + this.lhP + ", isPrivateMsg=" + this.lhQ + ", templateId='" + this.hAT + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.dtF + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.lhR + ", errorUrl='" + this.kas + '\'' + ", needDelThumb=" + this.kKe + ", imgPath='" + this.dyy + '\'' + ", useDefaultSnapshot=" + this.lhS + ", msgParams=" + this.lhW + ", todoActivityId=" + this.hyi + ", isToDoMessage=" + this.lhV + '}';
      AppMethodBeat.o(174895);
      return str;
    }
  }
  
  static class e
    implements com.tencent.mm.ipcinvoker.k<JsApiShareAppMessageBase.ShareDialogTodoReportData, IPCVoid>
  {}
  
  protected static final class f
    implements JsApiShareAppMessageBase.b
  {
    String lib;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.hym);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.lib);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.lib = paramJSONObject.optString("link");
      if (bt.isNullOrNil(this.lib))
      {
        ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.lhW.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      paramSendAppMessageTask.liz = 5;
      paramSendAppMessageTask.url = this.lib;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = bt.nullAsNil(paramShareParams.dyy).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.lib + '\'' + '}';
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
      boolean bool = bt.nullAsNil(paramShareParams.dyy).startsWith("delayLoadFile://");
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
    String dIs;
    String hyv;
    String lic;
    String lid;
    String lie;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.dIs = paramJSONObject.optString("videoMD5");
      this.lic = paramJSONObject.optString("videoButtonText");
      this.hyv = paramJSONObject.optString("playDesc");
      this.lid = r.a(paramShareParams.lhJ, this.videoPath, paramShareParams.lhS);
      this.lie = r.a(paramShareParams.lhJ, paramc, paramShareParams.lhS);
      if ((bt.isNullOrNil(this.lid)) || (bt.isNullOrNil(this.lie)) || (bt.isNullOrNil(this.dIs)))
      {
        ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.lhW.put("is_video", Boolean.TRUE);
      paramShareParams.lhW.put("footer_icon", paramShareParams.lhK.iAa);
      paramShareParams.lhW.put("footer_text", paramShareParams.lhK.doD);
      paramShareParams.lhW.put("video_path", this.lid);
      paramShareParams.lhW.put("video_thumb_path", this.lie);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.liz = 4;
      paramSendAppMessageTask.liE = true;
      paramSendAppMessageTask.videoPath = r.Qz(this.lid);
      paramSendAppMessageTask.liK = r.Qz(this.lie);
      paramSendAppMessageTask.dIs = this.dIs;
      paramSendAppMessageTask.lic = this.lic;
      paramSendAppMessageTask.hyv = this.hyv;
      paramSendAppMessageTask.lix = r.Qz(this.lie);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((bt.nullAsNil(paramShareParams.dyy).startsWith("delayLoadFile://")) || (bt.nullAsNil(this.lid).startsWith("delayLoadFile://")) || (bt.nullAsNil(this.lie).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.dIs + '\'' + ", videoButtonText='" + this.lic + '\'' + ", videoPlayDesc='" + this.hyv + '\'' + ", videoPathInFileSystem='" + this.lid + '\'' + ", videoThumbPathInFileSystem='" + this.lie + '\'' + '}';
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
      paramShareParams.lhS = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (bt.isNullOrNil(str)) {
        paramJSONObject = u.KJ(paramc.getAppId());
      }
      paramShareParams.kas = paramJSONObject;
      paramShareParams.lhW.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().aXc();
      if ((paramc.cmw != null) && (!bt.isNullOrNil(paramc.cmw.jYr))) {
        paramShareParams.lhW.put("msg_img_path", paramc.cmw.jYr);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().aXc();
      paramSendAppMessageTask.liz = 3;
      if (paramc.cmw != null)
      {
        paramSendAppMessageTask.liG = paramc.cmw.appId;
        paramSendAppMessageTask.liH = paramc.cmw.appName;
        paramSendAppMessageTask.liI = paramc.cmw.jYs;
        paramSendAppMessageTask.liJ = paramc.cmw.thumbUrl;
        if (bt.isNullOrNil(paramSendAppMessageTask.liw))
        {
          paramSendAppMessageTask.lix = paramc.cmw.jYq;
          paramSendAppMessageTask.kKe = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { paramShareParams.appId, paramShareParams.dki, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = bt.nullAsNil(paramShareParams.dyy).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */