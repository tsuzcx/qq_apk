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
import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.widget.bf.a;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.n.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderGameLiveUtil;", "", "()V", "ENTRY_AUTH", "", "ENTRY_FAN", "ENTRY_LIVE", "ENTRY_POST", "ENTRY_SCENE", "", "getENTRY_SCENE", "()Ljava/lang/String;", "ENTRY_SHARE", "EXPORT_ID", "getEXPORT_ID", "TAG", "TICKET", "getTICKET", "checkAccountScene", "", "getCheckAccountScene", "()Ljava/util/List;", "adjustStatusbarPadding", "", "root", "Landroid/view/View;", "checkAccount", "", "businessType", "appid", "extInfo", "isSameAccount", "checkAppInstalled", "context", "Landroid/content/Context;", "packageName", "dealShare", "doDownloadApp", "downloadUrl", "fallback", "errcode", "errMsg", "filterGame", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "gameList", "genExtDeviceInfo", "Lcom/tencent/mm/protocal/protobuf/ExtDeviceInfo;", "getExposeText", "teamMode", "defaultStr", "getJumpGameWording", "isWAGame", "gameName", "getLicenseTxt", "Landroid/text/SpannableString;", "strId", "isMiniGame", "getTextWithLimit", "text", "limit", "getTotalMem", "", "getVisitorBtnText", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "jumpGameAuthUI", "json", "Lorg/json/JSONObject;", "intent", "Landroid/content/Intent;", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "jumpGameLiveUI", "action", "jumpGamePostUI", "showToast", "wording", "transferToExternalMsgType", "originMsgType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t GgN;
  public static final String GgO;
  private static final String GgP;
  private static final String GgQ;
  private static final List<Integer> GgR;
  public static final String TAG;
  
  static
  {
    AppMethodBeat.i(333999);
    GgN = new t();
    TAG = "Finder.FinderGameLiveUtil";
    GgO = "liveEntryScene";
    GgP = "ticket";
    GgQ = "liveObjectExportId";
    GgR = kotlin.a.p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) });
    AppMethodBeat.o(333999);
  }
  
  public static int TV(int paramInt)
  {
    AppMethodBeat.i(333937);
    switch (paramInt)
    {
    default: 
      paramInt = a.a.ahiA.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 1: 
    case 20001: 
    case 20002: 
      paramInt = a.a.ahiC.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 10005: 
      paramInt = a.a.ahiD.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 10006: 
    case 10007: 
      paramInt = a.a.ahiG.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 10008: 
      paramInt = a.a.ahiH.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 100000: 
      paramInt = a.a.ahiB.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 20009: 
    case 20013: 
      paramInt = a.a.ahiK.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 20014: 
      paramInt = a.a.ahiL.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 20019: 
      paramInt = a.a.ahiN.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    case 20020: 
      paramInt = a.a.ahiO.ordinal();
      AppMethodBeat.o(333937);
      return paramInt;
    }
    paramInt = a.a.ahiB.ordinal();
    AppMethodBeat.o(333937);
    return paramInt;
  }
  
  public static String a(int paramInt, Context paramContext, String paramString)
  {
    AppMethodBeat.i(333882);
    s.u(paramContext, "context");
    s.u(paramString, "defaultStr");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(333882);
      return paramString;
    case 1: 
      AppMethodBeat.o(333882);
      return paramString;
    case 2: 
      paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition2);
      s.s(paramContext, "context.getString(R.stri…e_team_expose_condition2)");
      AppMethodBeat.o(333882);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition3);
      s.s(paramContext, "context.getString(R.stri…e_team_expose_condition3)");
      AppMethodBeat.o(333882);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition4);
      s.s(paramContext, "context.getString(R.stri…e_team_expose_condition4)");
      AppMethodBeat.o(333882);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition5);
      s.s(paramContext, "context.getString(R.stri…e_team_expose_condition5)");
      AppMethodBeat.o(333882);
      return paramContext;
    case 7: 
      paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition6);
      s.s(paramContext, "context.getString(R.stri…e_team_expose_condition6)");
      AppMethodBeat.o(333882);
      return paramContext;
    }
    paramContext = paramContext.getString(p.h.finder_game_live_team_expose_condition1);
    s.s(paramContext, "context.getString(R.stri…e_team_expose_condition1)");
    AppMethodBeat.o(333882);
    return paramContext;
  }
  
  public static String a(bhf parambhf, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(333896);
    s.u(parambhf, "gameTeamInfo");
    s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.live.widget.bf.Evf;
    if (bf.a.g(parambhf)) {}
    for (parambhf = parambhf.ZQR;; parambhf = paramContext.getString(p.h.CgP))
    {
      localObject = parambhf;
      if (parambhf == null) {
        localObject = paramContext.getString(p.h.CgP);
      }
      s.s(localObject, "(if (FinderLiveVisitorGa…tion_default_replacement)");
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(333896);
        return localObject;
      }
    }
    parambhf = paramContext.getString(p.h.CgK, new Object[] { localObject });
    s.s(parambhf, "context.getString(R.stri…ondition2, actionWording)");
    AppMethodBeat.o(333896);
    return parambhf;
    parambhf = paramContext.getString(p.h.CgL, new Object[] { localObject });
    s.s(parambhf, "context.getString(R.stri…ondition3, actionWording)");
    AppMethodBeat.o(333896);
    return parambhf;
    parambhf = paramContext.getString(p.h.CgM, new Object[] { localObject });
    s.s(parambhf, "context.getString(R.stri…ondition4, actionWording)");
    AppMethodBeat.o(333896);
    return parambhf;
    parambhf = paramContext.getString(p.h.CgN, new Object[] { localObject });
    s.s(parambhf, "context.getString(R.stri…ondition5, actionWording)");
    AppMethodBeat.o(333896);
    return parambhf;
    AppMethodBeat.o(333896);
    return localObject;
  }
  
  public static String a(boolean paramBoolean, int paramInt, String paramString, Context paramContext)
  {
    AppMethodBeat.i(333913);
    s.u(paramString, "gameName");
    s.u(paramContext, "context");
    if (paramBoolean)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        paramString = paramContext.getString(p.h.Chv, new Object[] { paramString });
      }
      for (;;)
      {
        s.s(paramString, "{\n            when (team…)\n            }\n        }");
        AppMethodBeat.o(333913);
        return paramString;
        paramString = paramContext.getString(p.h.Chr, new Object[] { paramString });
        continue;
        paramString = paramContext.getString(p.h.Chs, new Object[] { paramString });
        continue;
        paramString = paramContext.getString(p.h.Cht, new Object[] { paramString });
        continue;
        paramString = paramContext.getString(p.h.Chu, new Object[] { paramString });
        continue;
        paramString = paramContext.getString(p.h.Chw, new Object[] { paramString });
      }
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      paramString = paramContext.getString(p.h.CgI, new Object[] { paramString });
    }
    for (;;)
    {
      s.s(paramString, "{\n            when (team…)\n            }\n        }");
      AppMethodBeat.o(333913);
      return paramString;
      paramString = paramContext.getString(p.h.CgE, new Object[] { paramString });
      continue;
      paramString = paramContext.getString(p.h.CgF, new Object[] { paramString });
      continue;
      paramString = paramContext.getString(p.h.CgG, new Object[] { paramString });
      continue;
      paramString = paramContext.getString(p.h.CgH, new Object[] { paramString });
      continue;
      paramString = paramContext.getString(p.h.Chl, new Object[] { paramString });
    }
  }
  
  private static final ah a(Intent paramIntent, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(333972);
    s.u(paramIntent, "$intent");
    s.u(paramString2, "$appid");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (bil)parama.ott;
      if (parama == null)
      {
        parama = null;
        if (parama != null) {
          break label194;
        }
        label62:
        if (localObject1 != null) {
          break label204;
        }
        Log.w(TAG, "detail null");
      }
    }
    for (;;)
    {
      paramIntent = ah.aiuX;
      AppMethodBeat.o(333972);
      return paramIntent;
      parama = parama.ZRA;
      if (parama == null)
      {
        parama = null;
        break;
      }
      Object localObject3 = ((Iterable)parama).iterator();
      label118:
      Object localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        parama = ((ccb)localObject2).aals;
        if (parama == null)
        {
          parama = null;
          label155:
          if (!s.p(parama, paramString2)) {
            break label186;
          }
        }
      }
      for (parama = (b.a)localObject2;; parama = null)
      {
        parama = (ccb)parama;
        break;
        parama = parama.app_id;
        break label155;
        label186:
        break label118;
      }
      label194:
      localObject1 = parama.aalt;
      break label62;
      label204:
      localObject1 = parama.aalt;
      if (localObject1 == null)
      {
        localObject1 = "";
        label221:
        localObject2 = parama.aalt;
        if (localObject2 != null) {
          break label362;
        }
        localObject2 = "";
      }
      for (;;)
      {
        paramIntent.putExtra("COVER_URL", (String)localObject1);
        paramIntent.putExtra("DESC", (String)localObject2);
        paramIntent.putExtra("TICKET", paramString1);
        paramIntent.putExtra("APPID", paramString2);
        paramIntent.putExtra("POST_FROM_SCENE", paramInt);
        paramIntent.putExtra("GameUserInfo", parama.toByteArray());
        paramIntent.addFlags(536870912);
        paramString1 = (com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class);
        paramString2 = MMApplicationContext.getContext();
        s.s(paramString2, "getContext()");
        paramString1.o(paramString2, paramIntent);
        break;
        localObject2 = ((cbq)localObject1).aabN;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label221;
        }
        localObject1 = "";
        break label221;
        label362:
        localObject3 = ((cbq)localObject2).description;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
      }
      Log.w(TAG, "CgiFinderLiveGetUserGameConfig failed.");
    }
  }
  
  public static void a(JSONObject paramJSONObject, Intent paramIntent, fby paramfby, String paramString)
  {
    AppMethodBeat.i(333743);
    paramJSONObject = paramJSONObject.getString(GgP);
    paramIntent.putExtra("KEY_POST_FROM_SHARE", paramfby.toByteArray());
    paramIntent.putExtra("KEY_TICKET", paramJSONObject);
    paramIntent.putExtra("KEY_APPID", paramString);
    paramIntent.putExtra("KEY_FROM_SCAN", false);
    paramJSONObject = (com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class);
    paramfby = MMApplicationContext.getContext();
    s.s(paramfby, "getContext()");
    paramJSONObject.enterFinderGameLiveAuthUI(paramfby, paramIntent);
    AppMethodBeat.o(333743);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(333755);
    paramJSONObject = paramJSONObject.optString(GgP, "");
    new com.tencent.mm.plugin.finder.live.cgi.p(paramString, 0).bFJ().g(new t..ExternalSyntheticLambda1(paramIntent, paramJSONObject, paramString, 0));
    AppMethodBeat.o(333755);
  }
  
  public static String aBy(String paramString)
  {
    AppMethodBeat.i(333921);
    s.u(paramString, "text");
    k localk = new k("[一-龥]");
    int n = paramString.length() - 1;
    int j;
    int i;
    int k;
    if (n >= 0)
    {
      j = 0;
      i = 0;
      k = 0;
    }
    for (;;)
    {
      int m = j + 1;
      String str = paramString.substring(j, j + 1);
      s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (localk.bm((CharSequence)str)) {
        k += 1;
      }
      while (k * 2 + i > 12)
      {
        paramString = paramString.substring(0, j);
        s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = s.X(paramString, "...");
        AppMethodBeat.o(333921);
        return paramString;
        i += 1;
      }
      if (m > n)
      {
        AppMethodBeat.o(333921);
        return paramString;
      }
      j = m;
    }
  }
  
  public static void aL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(333815);
    s.u(paramContext, "context");
    s.u(paramString, "downloadUrl");
    Log.i(TAG, s.X("download SecondCut url ", paramString));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(333815);
  }
  
  public static boolean aN(Context paramContext, String paramString)
  {
    bool = true;
    AppMethodBeat.i(333807);
    s.u(paramContext, "context");
    s.u(paramString, "packageName");
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
        Log.w(TAG, "checkInstalled " + paramString + " Exception: %s", new Object[] { paramContext.getMessage() });
        bool = false;
      }
    }
    AppMethodBeat.o(333807);
    return bool;
  }
  
  private static final void ad(boolean paramBoolean, String paramString) {}
  
  public static void ao(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333785);
    s.u(paramString1, "errMsg");
    Object localObject = new JSONObject();
    com.tencent.mm.plugin.findersdk.a.p localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    ((JSONObject)localObject).put(com.tencent.mm.plugin.findersdk.a.p.frR(), -1);
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    ((JSONObject)localObject).put(com.tencent.mm.plugin.findersdk.a.p.frS(), paramString1);
    paramString1 = ((JSONObject)localObject).toString();
    s.s(paramString1, "retJson.toString()");
    showToast(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localObject = ((JSONObject)localObject).toString();
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    com.tencent.mm.pluginsdk.ui.tools.n.d(paramString1, (String)localObject, paramString2, -1, "");
    AppMethodBeat.o(333785);
  }
  
  public static void c(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(333770);
    paramJSONObject = paramJSONObject.getString(GgQ);
    String str1 = ((cn)h.az(cn.class)).genContextId(11, 8, 65);
    String str2 = z.bAW();
    ((cn)h.az(cn.class)).getFinderUtilApi().f(paramInt, paramJSONObject, str2, str1, "");
    AppMethodBeat.o(333770);
  }
  
  public static SpannableString d(final Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(333829);
    s.u(paramContext, "context");
    String str1;
    int i;
    SpannableString localSpannableString;
    if (paramBoolean)
    {
      str1 = paramContext.getString(p.h.Cuv);
      s.s(str1, "if (isMiniGame) {\n      …eerror_license)\n        }");
      String str2 = paramContext.getString(paramInt, new Object[] { str1 });
      s.s(str2, "context.getString(strId, strForIndex)");
      i = kotlin.n.n.a((CharSequence)str2, str1, 0, false, 6);
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
      AppMethodBeat.o(333829);
      return localSpannableString;
      str1 = paramContext.getString(p.h.Cut);
      break;
    }
  }
  
  public static boolean f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(333726);
    Log.i(TAG, "checkAccount, isSameAccount:" + paramBoolean + ", businessType:" + paramString1 + ", appid:" + paramString2 + ", extInfo:" + paramString3);
    if (paramBoolean)
    {
      AppMethodBeat.o(333726);
      return true;
    }
    if ((paramString3 == null) || (Util.isNullOrNil(paramString3)) || (paramString1 == null) || (Util.isNullOrNil(paramString1)) || (paramString2 == null) || (Util.isNullOrNil(paramString2)))
    {
      ao("appid or extInfo empty", paramString1, paramString2);
      AppMethodBeat.o(333726);
      return true;
    }
    try
    {
      int i = new JSONObject(paramString3).getInt(GgO);
      if ((GgR.contains(Integer.valueOf(i))) && (!paramBoolean))
      {
        Log.i(TAG, "checkAccount false");
        paramString1 = new g.a(MMApplicationContext.getContext());
        paramString1.bDE(MMApplicationContext.getContext().getString(p.h.Cky)).NF(true).bDI(MMApplicationContext.getContext().getString(p.h.app_ok)).b(t..ExternalSyntheticLambda0.INSTANCE);
        paramString1.show();
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(333726);
    }
    return true;
  }
  
  public static long feT()
  {
    AppMethodBeat.i(333850);
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(333850);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    AppMethodBeat.o(333850);
    return l;
  }
  
  public static apc feU()
  {
    AppMethodBeat.i(333864);
    apc localapc = new apc();
    localapc.Zoi = q.aPo();
    localapc.Zwf = Build.BRAND;
    localapc.Zoh = Build.MANUFACTURER;
    localapc.Zoj = Build.VERSION.RELEASE;
    localapc.Zok = Build.VERSION.INCREMENTAL;
    localapc.Zol = Build.DISPLAY;
    AppMethodBeat.o(333864);
    return localapc;
  }
  
  public static void gO(View paramView)
  {
    AppMethodBeat.i(333840);
    if (paramView != null)
    {
      int i = com.tencent.mm.ui.bf.getStatusBarHeight(paramView.getContext());
      paramView.setPadding(paramView.getPaddingLeft(), i + paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
    }
    AppMethodBeat.o(333840);
  }
  
  private static void showToast(String paramString)
  {
    AppMethodBeat.i(333792);
    s.u(paramString, "wording");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      d.uiThread((a)new t.b(paramString));
    }
    AppMethodBeat.o(333792);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderGameLiveUtil$getLicenseTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ClickableSpan
  {
    a(boolean paramBoolean, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(333227);
      s.u(paramView, "widget");
      Log.i(t.aUw(), "license click");
      Intent localIntent = new Intent();
      if (this.GgS) {}
      for (String str = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_mini_game_agreement&lang=zh_CN";; str = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_game_agreement&lang=zh_CN")
      {
        localIntent.putExtra("rawUrl", str);
        c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(333227);
        return;
      }
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(333237);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(paramContext.getResources().getColor(p.b.ByK));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(333237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.t
 * JD-Core Version:    0.7.0.1
 */