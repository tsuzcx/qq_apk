package com.tencent.mm.plugin.finder.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.by.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.cgi.j;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderGameLiveUtil;", "", "()V", "ENTRY_SCENE", "", "getENTRY_SCENE", "()Ljava/lang/String;", "EXPORT_ID", "getEXPORT_ID", "TAG", "TICKET", "getTICKET", "adjustStatusbarPadding", "", "root", "Landroid/view/View;", "checkAppInstalled", "", "context", "Landroid/content/Context;", "packageName", "dealShare", "businessType", "appid", "extInfo", "doDownloadApp", "downloadUrl", "fallback", "errcode", "", "errMsg", "filterGame", "", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "gameList", "genExtDeviceInfo", "Lcom/tencent/mm/protocal/protobuf/ExtDeviceInfo;", "getExposeText", "teamMode", "defaultStr", "getJumpGameWording", "gameName", "getLicenseTxt", "Landroid/text/SpannableString;", "strId", "isMiniGame", "getTotalMem", "", "getVisitorBtnText", "jumpGameAuthUI", "json", "Lorg/json/JSONObject;", "intent", "Landroid/content/Intent;", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "jumpGameLiveUI", "action", "jumpGamePostUI", "showToast", "wording", "transferToExternalMsgType", "originMsgType", "plugin-finder_release"})
public final class p
{
  public static final String ADB = "liveEntryScene";
  private static final String ADC = "ticket";
  private static final String ADE = "liveObjectExportId";
  public static final p ADF;
  public static final String TAG = "Finder.FinderGameLiveUtil";
  
  static
  {
    AppMethodBeat.i(292029);
    ADF = new p();
    TAG = "Finder.FinderGameLiveUtil";
    ADB = "liveEntryScene";
    ADC = "ticket";
    ADE = "liveObjectExportId";
    AppMethodBeat.o(292029);
  }
  
  public static int QK(int paramInt)
  {
    AppMethodBeat.i(292028);
    switch (paramInt)
    {
    default: 
      paramInt = a.a.ZiQ.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 1: 
    case 20001: 
    case 20002: 
      paramInt = a.a.ZiS.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 10005: 
      paramInt = a.a.ZiT.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 10006: 
    case 10007: 
      paramInt = a.a.ZiW.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 10008: 
      paramInt = a.a.ZiX.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 100000: 
      paramInt = a.a.ZiR.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 20009: 
    case 20013: 
      paramInt = a.a.Zja.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 20014: 
      paramInt = a.a.Zjb.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    case 20019: 
      paramInt = a.a.Zjd.ordinal();
      AppMethodBeat.o(292028);
      return paramInt;
    }
    paramInt = a.a.Zje.ordinal();
    AppMethodBeat.o(292028);
    return paramInt;
  }
  
  public static String a(int paramInt, Context paramContext, String paramString)
  {
    AppMethodBeat.i(292025);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "defaultStr");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(292025);
      return paramString;
    case 1: 
      AppMethodBeat.o(292025);
      return paramString;
    case 2: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_expose_condition2);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…e_team_expose_condition2)");
      AppMethodBeat.o(292025);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_expose_condition3);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…e_team_expose_condition3)");
      AppMethodBeat.o(292025);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_expose_condition4);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…e_team_expose_condition4)");
      AppMethodBeat.o(292025);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_expose_condition5);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…e_team_expose_condition5)");
      AppMethodBeat.o(292025);
      return paramContext;
    }
    paramContext = paramContext.getString(b.j.finder_game_live_team_expose_condition1);
    kotlin.g.b.p.j(paramContext, "context.getString(R.stri…e_team_expose_condition1)");
    AppMethodBeat.o(292025);
    return paramContext;
  }
  
  public static void a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(292017);
    paramJSONObject = paramJSONObject.getString(ADE);
    String str1 = ((ak)h.ag(ak.class)).genContextId(11, 8, 65);
    String str2 = z.bdh();
    com.tencent.mm.kernel.b.a locala = h.ag(ak.class);
    kotlin.g.b.p.j(locala, "MMKernel.plugin(IPluginFinder::class.java)");
    ((ak)locala).getFinderUtilApi().f(paramInt, paramJSONObject, str2, str1, "");
    AppMethodBeat.o(292017);
  }
  
  public static void a(JSONObject paramJSONObject, Intent paramIntent, ehy paramehy, String paramString)
  {
    AppMethodBeat.i(292015);
    paramJSONObject = paramJSONObject.getString(ADC);
    paramIntent.putExtra("KEY_POST_FROM_SHARE", paramehy.toByteArray());
    paramIntent.putExtra("KEY_TICKET", paramJSONObject);
    paramIntent.putExtra("KEY_APPID", paramString);
    paramIntent.putExtra("KEY_FROM_SCAN", false);
    paramJSONObject = a.ACH;
    paramJSONObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(paramJSONObject, "MMApplicationContext.getContext()");
    a.enterFinderGameLiveAuthUI(paramJSONObject, paramIntent);
    AppMethodBeat.o(292015);
  }
  
  public static void a(final JSONObject paramJSONObject, String paramString, final Intent paramIntent)
  {
    AppMethodBeat.i(292016);
    paramJSONObject = paramJSONObject.optString(ADC, "");
    new j(paramString, 0).bhW().g((com.tencent.mm.vending.c.a)new b(paramString, paramIntent, paramJSONObject));
    AppMethodBeat.o(292016);
  }
  
  public static boolean aJ(Context paramContext, String paramString)
  {
    bool = true;
    AppMethodBeat.i(292019);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "packageName");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext == null) {
        break label85;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("MicroMsg.CheckDownloadUtil", "checkInstalled " + paramString + " Exception: %s", new Object[] { paramContext.getMessage() });
        bool = false;
      }
    }
    AppMethodBeat.o(292019);
    return bool;
  }
  
  public static void aK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(292020);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "downloadUrl");
    Log.i("MicroMsg.CheckDownloadUtil", "download SecondCut url ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(292020);
  }
  
  public static String c(int paramInt, String paramString, Context paramContext)
  {
    AppMethodBeat.i(292027);
    kotlin.g.b.p.k(paramString, "gameName");
    kotlin.g.b.p.k(paramContext, "context");
    switch (paramInt)
    {
    default: 
      paramString = paramContext.getString(b.j.finder_game_live_team_alert_default, new Object[] { paramString });
      kotlin.g.b.p.j(paramString, "context.getString(R.stri…_alert_default, gameName)");
      AppMethodBeat.o(292027);
      return paramString;
    case 2: 
      paramString = paramContext.getString(b.j.finder_game_live_team_alert_condition2, new Object[] { paramString });
      kotlin.g.b.p.j(paramString, "context.getString(R.stri…ert_condition2, gameName)");
      AppMethodBeat.o(292027);
      return paramString;
    case 3: 
      paramString = paramContext.getString(b.j.finder_game_live_team_alert_condition3, new Object[] { paramString });
      kotlin.g.b.p.j(paramString, "context.getString(R.stri…ert_condition3, gameName)");
      AppMethodBeat.o(292027);
      return paramString;
    case 4: 
      paramString = paramContext.getString(b.j.finder_game_live_team_alert_condition4, new Object[] { paramString });
      kotlin.g.b.p.j(paramString, "context.getString(R.stri…ert_condition4, gameName)");
      AppMethodBeat.o(292027);
      return paramString;
    }
    paramString = paramContext.getString(b.j.finder_game_live_team_alert_condition5, new Object[] { paramString });
    kotlin.g.b.p.j(paramString, "context.getString(R.stri…ert_condition5, gameName)");
    AppMethodBeat.o(292027);
    return paramString;
  }
  
  public static SpannableString d(final Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292021);
    kotlin.g.b.p.k(paramContext, "context");
    String str1;
    int i;
    SpannableString localSpannableString;
    if (paramBoolean)
    {
      str1 = paramContext.getString(b.j.wcfinder_gamelive_minigame_forbidlivepageerror_license);
      kotlin.g.b.p.j(str1, "if (isMiniGame) {\n      …eerror_license)\n        }");
      String str2 = paramContext.getString(paramInt, new Object[] { str1 });
      kotlin.g.b.p.j(str2, "context.getString(strId, strForIndex)");
      i = n.a((CharSequence)str2, str1, 0, false, 6);
      paramInt = i + str1.length();
      localSpannableString = new SpannableString((CharSequence)str2);
      if ((i > 0) && (paramInt <= str2.length())) {
        break label189;
      }
      paramInt = str2.length();
      Log.e(TAG, "license text err,all string:" + str2 + ",license:" + str1);
      i = 0;
    }
    label189:
    for (;;)
    {
      localSpannableString.setSpan(new a(paramBoolean, paramContext), i, paramInt, 33);
      AppMethodBeat.o(292021);
      return localSpannableString;
      str1 = paramContext.getString(b.j.wcfinder_gamelive_forbidlivepageerror_license);
      break;
    }
  }
  
  public static String d(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(292026);
    kotlin.g.b.p.k(paramContext, "context");
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_join_btn_default);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…ve_team_join_btn_default)");
      AppMethodBeat.o(292026);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_btn_condition2);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…live_team_btn_condition2)");
      AppMethodBeat.o(292026);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_btn_condition3);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…live_team_btn_condition3)");
      AppMethodBeat.o(292026);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_btn_condition4);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…live_team_btn_condition4)");
      AppMethodBeat.o(292026);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(b.j.finder_game_live_team_btn_condition5);
      kotlin.g.b.p.j(paramContext, "context.getString(R.stri…live_team_btn_condition5)");
      AppMethodBeat.o(292026);
      return paramContext;
    }
    paramContext = paramContext.getString(b.j.finder_game_live_team_btn_condition1);
    kotlin.g.b.p.j(paramContext, "context.getString(R.stri…live_team_btn_condition1)");
    AppMethodBeat.o(292026);
    return paramContext;
  }
  
  public static void eM(View paramView)
  {
    AppMethodBeat.i(292022);
    if (paramView != null)
    {
      int i = ax.getStatusBarHeight(paramView.getContext());
      paramView.setPadding(paramView.getPaddingLeft(), i + paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
    }
    AppMethodBeat.o(292022);
  }
  
  public static long ecY()
  {
    AppMethodBeat.i(292023);
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(292023);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    AppMethodBeat.o(292023);
    return l;
  }
  
  public static alr ecZ()
  {
    AppMethodBeat.i(292024);
    alr localalr = new alr();
    localalr.Spt = Build.MODEL;
    localalr.SvW = Build.BRAND;
    localalr.Sps = Build.MANUFACTURER;
    localalr.Spu = Build.VERSION.RELEASE;
    localalr.Spv = Build.VERSION.INCREMENTAL;
    localalr.Spw = Build.DISPLAY;
    AppMethodBeat.o(292024);
    return localalr;
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(292018);
    kotlin.g.b.p.k(paramString, "wording");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      d.uiThread((kotlin.g.a.a)new p.c(paramString));
    }
    AppMethodBeat.o(292018);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderGameLiveUtil$getLicenseTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class a
    extends ClickableSpan
  {
    a(boolean paramBoolean, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281276);
      kotlin.g.b.p.k(paramView, "widget");
      Object localObject = p.ADF;
      Log.i(p.eda(), "license click");
      Intent localIntent = new Intent();
      if (this.ADG) {}
      for (localObject = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_mini_game_agreement&lang=zh_CN";; localObject = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_game_agreement&lang=zh_CN")
      {
        localIntent.putExtra("rawUrl", (String)localObject);
        c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(281276);
        return;
      }
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(281277);
      kotlin.g.b.p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(paramContext.getResources().getColor(b.c.finder_license_link_color));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(281277);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString1, Intent paramIntent, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */