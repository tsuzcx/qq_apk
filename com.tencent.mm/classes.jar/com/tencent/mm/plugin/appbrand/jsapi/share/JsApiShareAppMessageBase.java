package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  final int kjK = com.tencent.luggage.sdk.g.a.aD(this);
  
  protected Param a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
  {
    ad.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
    d locald = bbS();
    if (paramJSONObject == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
      throw new c("data is null");
    }
    locald.djj = paramc.au(Activity.class);
    if (locald.djj == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
      throw new c("fail:internal error invalid android context");
    }
    locald.kjS = ((ae)paramc.at(ae.class));
    if (locald.kjS == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
      throw new c("current page do not exist");
    }
    p localp = locald.kjS.ts(com.tencent.mm.plugin.appbrand.menu.q.kSb.ordinal());
    if (localp == null)
    {
      ad.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
      throw new c("menu is null");
    }
    Object localObject1 = paramJSONObject.optString("type");
    if (g.as(paramc.getRuntime())) {
      localObject1 = "weishi";
    }
    Object localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = "normal";
    }
    ad.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", new Object[] { localObject2 });
    if ("video".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = new h();
      locald.kjV = ((b)localObject1);
      locald.kjT = paramc.getRuntime().aNb();
      locald.withShareTicket = localp.jBF.getBoolean("enable_share_with_share_ticket", false);
      locald.kkc = localp.jBF.getBoolean("is_todo_message", false);
      locald.gFz = localp.jBF.getString("share_todo_activity_id", "");
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
      locald.dbu = paramJSONObject.optString("path");
      locald.gFC = paramJSONObject.optString("imageUrl");
      locald.cacheKey = paramJSONObject.optString("cacheKey");
      locald.kjU = paramJSONObject.optBoolean("disableForward", false);
      ad.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", new Object[] { Boolean.valueOf(locald.kjU) });
      locald.dzY = paramJSONObject.optString("messageExtraData");
      locald.subType = paramJSONObject.optInt("cardSubType", 0);
      locald.kjZ = paramJSONObject.optBoolean("useDefaultSnapshot", true);
      localObject1 = paramc.getRuntime().aNc();
      if (localObject1 != null) {
        break label531;
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
    label531:
    locald.kjW = localp.jBF.tE("enable_share_dynamic");
    locald.kjX = localp.jBF.tE("enable_share_with_updateable_msg");
    locald.gIj = localp.jBF.getString("enable_share_with_updateable_msg_template_id", "");
    locald.appId = paramc.getAppId();
    locald.userName = ((AppBrandInitConfigWC)localObject1).username;
    locald.dkC = locald.kjT.jdS.iOQ;
    locald.pkgVersion = locald.kjT.jdS.pkgVersion;
    locald.kjY = paramc.getRuntime().aNc().cfd;
    locald.jfU = u.Du(paramc.getAppId());
    locald.jOD = r.IX(locald.gFC);
    locald.dpa = r.a(locald.kjS, locald.gFC, locald.kjZ);
    ad.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", new Object[] { locald.dpa, locald.gFC, Boolean.valueOf(locald.kjZ) });
    locald.kkd = new HashMap();
    locald.kkd.put("desc", locald.desc);
    locald.kkd.put("type", Integer.valueOf(locald.type));
    locald.kkd.put("title", locald.title);
    locald.kkd.put("app_id", locald.appId);
    locald.kkd.put("pkg_type", Integer.valueOf(locald.dkC));
    locald.kkd.put("pkg_version", Integer.valueOf(locald.pkgVersion));
    locald.kkd.put("img_url", locald.gFC);
    locald.kkd.put("is_dynamic", Boolean.valueOf(locald.kjW));
    locald.kkd.put("cache_key", locald.cacheKey);
    locald.kkd.put("path", locald.dbu);
    locald.kkd.put("disableForward", Boolean.valueOf(locald.kjU));
    locald.kkd.put("subType", Integer.valueOf(locald.subType));
    if (!bt.isNullOrNil(locald.dpa)) {
      locald.kkd.put("delay_load_img_path", locald.dpa);
    }
    locald.kka = paramJSONObject.optString("openId");
    locald.kkb = paramJSONObject.optString("chatroomUsername");
    locald.kjV.a(locald, paramc, paramJSONObject);
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
        if (!bt.gL(paramSendAppMessageTask.kkQ))
        {
          paramSendAppMessageTask = paramSendAppMessageTask.kkQ.iterator();
          while (paramSendAppMessageTask.hasNext())
          {
            ShareInfo localShareInfo = (ShareInfo)paramSendAppMessageTask.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareKey", localShareInfo.cfh);
            localJSONObject.put("shareName", localShareInfo.cff);
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
      paramIntent.putExtra("appbrand_params", paramParam.kkd);
      paramIntent.putExtra("Retr_Msg_Type", 2);
      paramParam.kjV.a(paramParam, paramIntent);
      return;
    }
  }
  
  protected void a(Param paramParam) {}
  
  protected void a(Param paramParam, int paramInt) {}
  
  protected void a(SendAppMessageTask paramSendAppMessageTask, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.plugin.appbrand.service.c paramc, Param paramParam)
  {
    paramSendAppMessageTask.kkB = paramString2;
    paramSendAppMessageTask.toUser = paramString1;
    paramSendAppMessageTask.appId = paramParam.appId;
    paramString1 = paramc.getRuntime();
    int i;
    if ((paramString1 != null) && (paramString1.Eg() != null) && ((paramString1.Eg() instanceof AppBrandInitConfigWC)))
    {
      paramSendAppMessageTask.aAS = ((AppBrandInitConfigWC)paramString1.Eg()).aAS;
      paramSendAppMessageTask.userName = paramParam.userName;
      paramSendAppMessageTask.title = paramParam.title;
      paramSendAppMessageTask.description = paramParam.desc;
      paramSendAppMessageTask.url = paramParam.jfU;
      paramSendAppMessageTask.path = paramParam.dbu;
      paramSendAppMessageTask.type = paramParam.type;
      paramSendAppMessageTask.jOD = paramParam.jOD;
      paramSendAppMessageTask.kkC = paramParam.gFC;
      paramSendAppMessageTask.iconUrl = paramParam.kjT.hGe;
      paramSendAppMessageTask.dkC = paramParam.kjT.jdS.iOQ;
      paramSendAppMessageTask.jfT = paramParam.kjT.jdS.md5;
      paramSendAppMessageTask.version = paramParam.kjT.jdS.pkgVersion;
      paramSendAppMessageTask.nickname = paramParam.kjT.dfM;
      paramSendAppMessageTask.dzY = paramParam.dzY;
      paramSendAppMessageTask.cfU = paramParam.kjT.cfU;
      paramSendAppMessageTask.subType = paramParam.subType;
      if (!paramParam.kjU) {
        break label500;
      }
      i = 1;
      label242:
      paramSendAppMessageTask.jwB = i;
      paramSendAppMessageTask.shareCount = n.Dp(paramParam.appId).iFM.getAndIncrement();
      paramSendAppMessageTask.kkH = paramParam.kjS.jzm;
      paramSendAppMessageTask.kkI = paramParam.kjS.aWO();
      paramString1 = paramParam.kjS.getRuntime().DZ().cfo;
      if (paramString1 != null)
      {
        if (paramString1.scene != 0) {
          break label506;
        }
        i = 1000;
        label321:
        paramSendAppMessageTask.scene = i;
        paramSendAppMessageTask.dbt = bt.nullAsNil(paramString1.dbt);
        paramSendAppMessageTask.kkG = bt.nullAsNil(paramParam.kjS.getRuntime().aNc().Da());
      }
      paramSendAppMessageTask.kkD = r.IY(paramParam.dpa);
      paramSendAppMessageTask.withShareTicket = paramParam.withShareTicket;
      paramSendAppMessageTask.kjW = paramParam.kjW;
      paramSendAppMessageTask.kjX = paramParam.kjX;
      paramSendAppMessageTask.gIj = paramParam.gIj;
      paramSendAppMessageTask.cacheKey = paramParam.cacheKey;
      paramSendAppMessageTask.cIB = paramParam.kjY;
      paramString1 = paramParam.kjS.bkd();
      if (paramString1 != null) {
        break label515;
      }
    }
    label515:
    for (paramString1 = "";; paramString1 = paramString1.getWebView().getUrl())
    {
      paramSendAppMessageTask.kkK = paramString1;
      paramParam.kjV.a(paramSendAppMessageTask, paramc);
      paramSendAppMessageTask.kkc = paramParam.kkc;
      paramSendAppMessageTask.gFz = paramParam.gFz;
      paramSendAppMessageTask.gFM = paramBoolean;
      return;
      ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
      paramSendAppMessageTask.aAS = -1;
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
        if (paramAnonymousInt1 != JsApiShareAppMessageBase.this.kjK)
        {
          ad.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          ad.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          JsApiShareAppMessageBase.this.a(paramParam, paramAnonymousInt2);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("cancel", null));
          paramAnonymousIntent = paramParam.userName;
          str2 = paramParam.kjT.dfM;
          paramAnonymousInt2 = i;
          if (bool) {
            paramAnonymousInt2 = 1;
          }
          JsApiShareAppMessageBase.b(str1, paramAnonymousIntent, str2, paramAnonymousInt2, paramAnonymousInt1, 1);
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
          ad.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
          JsApiShareAppMessageBase.this.a(paramParam);
          paramc.h(paramInt, JsApiShareAppMessageBase.this.e("fail:selected user is nil", null));
          AppMethodBeat.o(174891);
          return;
        }
        ad.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", new Object[] { str1 });
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        String str2 = paramParam.userName;
        String str3 = paramParam.kjT.dfM;
        paramAnonymousInt2 = j;
        if (bool) {
          paramAnonymousInt2 = 1;
        }
        JsApiShareAppMessageBase.b(str1, str2, str3, paramAnonymousInt2, paramAnonymousInt1, 2);
        JsApiShareAppMessageBase.this.a(str1, paramAnonymousIntent, bool, paramc, paramInt, paramParam);
        AppMethodBeat.o(174891);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(174893);
        e.az(paramParam.djj).b(new e.b()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174892);
            if (JsApiShareAppMessageBase.this.kjK != paramAnonymous2Int1)
            {
              AppMethodBeat.o(174892);
              return false;
            }
            JsApiShareAppMessageBase.3.this.kfQ.c(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(174892);
            return true;
          }
        });
        Activity localActivity = paramParam.djj;
        if (paramBoolean) {}
        for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
        {
          d.c(localActivity, str, paramIntent, JsApiShareAppMessageBase.this.kjK);
          AppMethodBeat.o(174893);
          return;
        }
      }
    };
    if (paramParam.kjV.c(paramParam)) {
      ad.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
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
      localSendAppMessageTask.jwt = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174894);
          ad.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
          localSendAppMessageTask.aXn();
          paramc.h(paramInt, JsApiShareAppMessageBase.this.k("ok", JsApiShareAppMessageBase.this.a(paramParam, localSendAppMessageTask, paramString1)));
          JsApiShareAppMessageBase.this.a(true, paramParam, paramString1);
          AppMethodBeat.o(174894);
        }
      };
      localSendAppMessageTask.aXm();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (paramParam.djj != null) {
        com.tencent.mm.ui.base.h.cf(paramParam.djj, paramParam.djj.getResources().getString(2131755317));
      }
      return;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramc.h(paramInt, k("ok", a(paramParam, localSendAppMessageTask, paramString1)));
      a(false, paramParam, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, Param paramParam, String paramString) {}
  
  protected abstract Param bbS();
  
  static class ShareDialogTodoReportData
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
    public String gIw;
    public String kke;
    public int kkf;
    public int kkg;
    public int kkh;
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
      this.kke = paramParcel.readString();
      this.username = paramParcel.readString();
      this.gIw = paramParcel.readString();
      this.kkf = paramParcel.readInt();
      this.kkg = paramParcel.readInt();
      this.kkh = paramParcel.readInt();
      AppMethodBeat.o(184722);
    }
    
    public ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.kke = paramString1;
      this.username = paramString2;
      this.gIw = paramString3;
      this.kkf = paramInt1;
      this.kkg = paramInt2;
      this.kkh = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184721);
      paramParcel.writeString(this.kke);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.gIw);
      paramParcel.writeInt(this.kkf);
      paramParcel.writeInt(this.kkg);
      paramParcel.writeInt(this.kkh);
      AppMethodBeat.o(184721);
    }
  }
  
  protected static final class a
  {
    int errCode = 0;
    String errMsg = "";
    Map<String, String> kjQ = null;
    
    a(String paramString)
    {
      this(paramString, (byte)0);
    }
    
    private a(String paramString, byte paramByte)
    {
      this.errMsg = paramString;
      this.kjQ = null;
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
    JsApiShareAppMessageBase.a kjR;
    
    c(String paramString)
    {
      super();
    }
  }
  
  protected static class d
  {
    String appId;
    String cacheKey;
    String dbu;
    String desc;
    Activity djj = null;
    int dkC;
    String dpa;
    String dzY;
    String gFC;
    public String gFz = "";
    String gIj;
    boolean jOD;
    String jfU;
    ae kjS = null;
    AppBrandSysConfigWC kjT = null;
    boolean kjU;
    JsApiShareAppMessageBase.b kjV;
    boolean kjW;
    boolean kjX;
    int kjY;
    boolean kjZ = false;
    String kka = "";
    String kkb = "";
    public boolean kkc;
    HashMap<String, Object> kkd;
    int pkgVersion;
    int subType = 0;
    String title;
    int type = -1;
    String userName;
    boolean withShareTicket = false;
    
    public String toString()
    {
      AppMethodBeat.i(174895);
      String str = "Params{context=" + this.djj + ", pageView=" + this.kjS + ", config=" + this.kjT + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.dbu + '\'' + ", imageUrl='" + this.gFC + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.kjU + ", messageExtraData='" + this.dzY + '\'' + ", mShareExtImp=" + this.kjV + ", isDynamicMsg=" + this.kjW + ", isUpdateMsg=" + this.kjX + ", templateId='" + this.gIj + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.dkC + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.kjY + ", errorUrl='" + this.jfU + '\'' + ", needDelThumb=" + this.jOD + ", imgPath='" + this.dpa + '\'' + ", useDefaultSnapshot=" + this.kjZ + ", msgParams=" + this.kkd + ", todoActivityId=" + this.gFz + ", isToDoMessage=" + this.kkc + '}';
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
    String kki;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent)
    {
      AppMethodBeat.i(174897);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("img_url", paramShareParams.gFC);
      localHashMap.put("title", paramShareParams.title);
      localHashMap.put("desc", paramShareParams.desc);
      localHashMap.put("url", this.kki);
      paramIntent.putExtra("webview_params", localHashMap);
      AppMethodBeat.o(174897);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174896);
      this.kki = paramJSONObject.optString("link");
      if (bt.isNullOrNil(this.kki))
      {
        ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
        paramShareParams = new JsApiShareAppMessageBase.c("is h5 share type but no h5 link");
        AppMethodBeat.o(174896);
        throw paramShareParams;
      }
      paramShareParams.kkd.put("is_h5", Boolean.TRUE);
      AppMethodBeat.o(174896);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      paramSendAppMessageTask.kkF = 5;
      paramSendAppMessageTask.url = this.kki;
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174898);
      boolean bool = bt.nullAsNil(paramShareParams.dpa).startsWith("delayLoadFile://");
      AppMethodBeat.o(174898);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(174899);
      String str = "ShareTypeH5{h5Link='" + this.kki + '\'' + '}';
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
      boolean bool = bt.nullAsNil(paramShareParams.dpa).startsWith("delayLoadFile://");
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
    String dyw;
    String gFL;
    String kkj;
    String kkk;
    String kkl;
    String videoPath;
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, Intent paramIntent) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(ShareParams paramShareParams, com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(174901);
      this.videoPath = paramJSONObject.optString("videoPath");
      paramc = paramJSONObject.optString("videoThumbPath");
      this.dyw = paramJSONObject.optString("videoMD5");
      this.kkj = paramJSONObject.optString("videoButtonText");
      this.gFL = paramJSONObject.optString("playDesc");
      this.kkk = r.a(paramShareParams.kjS, this.videoPath, paramShareParams.kjZ);
      this.kkl = r.a(paramShareParams.kjS, paramc, paramShareParams.kjZ);
      if ((bt.isNullOrNil(this.kkk)) || (bt.isNullOrNil(this.kkl)) || (bt.isNullOrNil(this.dyw)))
      {
        ad.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
        paramShareParams = new JsApiShareAppMessageBase.c("try share video but video path or video thumbpath is null nil");
        AppMethodBeat.o(174901);
        throw paramShareParams;
      }
      paramShareParams.kkd.put("is_video", Boolean.TRUE);
      paramShareParams.kkd.put("footer_icon", paramShareParams.kjT.hGe);
      paramShareParams.kkd.put("footer_text", paramShareParams.kjT.dfM);
      paramShareParams.kkd.put("video_path", this.kkk);
      paramShareParams.kkd.put("video_thumb_path", this.kkl);
      AppMethodBeat.o(174901);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174902);
      paramSendAppMessageTask.kkF = 4;
      paramSendAppMessageTask.kkJ = true;
      paramSendAppMessageTask.videoPath = r.IY(this.kkk);
      paramSendAppMessageTask.kkP = r.IY(this.kkl);
      paramSendAppMessageTask.dyw = this.dyw;
      paramSendAppMessageTask.kkj = this.kkj;
      paramSendAppMessageTask.gFL = this.gFL;
      paramSendAppMessageTask.kkD = r.IY(this.kkl);
      AppMethodBeat.o(174902);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams) {}
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174903);
      if ((bt.nullAsNil(paramShareParams.dpa).startsWith("delayLoadFile://")) || (bt.nullAsNil(this.kkk).startsWith("delayLoadFile://")) || (bt.nullAsNil(this.kkl).startsWith("delayLoadFile://")))
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
      String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.dyw + '\'' + ", videoButtonText='" + this.kkj + '\'' + ", videoPlayDesc='" + this.gFL + '\'' + ", videoPathInFileSystem='" + this.kkk + '\'' + ", videoThumbPathInFileSystem='" + this.kkl + '\'' + '}';
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
      paramShareParams.kjZ = false;
      String str = paramJSONObject.optString("webpageUrl");
      paramJSONObject = str;
      if (bt.isNullOrNil(str)) {
        paramJSONObject = u.Du(paramc.getAppId());
      }
      paramShareParams.jfU = paramJSONObject;
      paramShareParams.kkd.put("is_weishi_video", Boolean.TRUE);
      paramc = paramc.getRuntime().aNc();
      if ((paramc.cfj != null) && (!bt.isNullOrNil(paramc.cfj.jeb))) {
        paramShareParams.kkd.put("msg_img_path", paramc.cfj.jeb);
      }
      AppMethodBeat.o(174905);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void a(SendAppMessageTask paramSendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(174906);
      paramc = paramc.getRuntime().aNc();
      paramSendAppMessageTask.kkF = 3;
      if (paramc.cfj != null)
      {
        paramSendAppMessageTask.kkL = paramc.cfj.appId;
        paramSendAppMessageTask.kkM = paramc.cfj.appName;
        paramSendAppMessageTask.kkN = paramc.cfj.jec;
        paramSendAppMessageTask.kkO = paramc.cfj.thumbUrl;
        if (bt.isNullOrNil(paramSendAppMessageTask.kkC))
        {
          paramSendAppMessageTask.kkD = paramc.cfj.jea;
          paramSendAppMessageTask.jOD = false;
        }
      }
      AppMethodBeat.o(174906);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> void b(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174908);
      com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { paramShareParams.appId, paramShareParams.dbu, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(174908);
    }
    
    public final <ShareParams extends JsApiShareAppMessageBase.d> boolean c(ShareParams paramShareParams)
    {
      AppMethodBeat.i(174907);
      boolean bool = bt.nullAsNil(paramShareParams.dpa).startsWith("delayLoadFile://");
      AppMethodBeat.o(174907);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
 * JD-Core Version:    0.7.0.1
 */