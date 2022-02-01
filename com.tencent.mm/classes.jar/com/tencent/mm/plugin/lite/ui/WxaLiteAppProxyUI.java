package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(2)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "START_UI_UN_NEED_DO_ININT", "", "getSTART_UI_UN_NEED_DO_ININT", "()I", "setSTART_UI_UN_NEED_DO_ININT", "(I)V", "START_UI_WITH_DO_INIT", "getSTART_UI_WITH_DO_INIT", "setSTART_UI_WITH_DO_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getLayoutId", "isSameMapContent", "", "m1", "", "m2", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "query2Map", "query", "removeDebugInfo", "m", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaLiteAppProxyUI
  extends MMActivity
{
  public static final a KbL;
  private static boolean KbO;
  private int KbM = 4;
  private int KbN = 5;
  private String TAG = "MicroMsg.WxaLiteAppProxyUI";
  
  static
  {
    AppMethodBeat.i(271463);
    KbL = new a((byte)0);
    KbO = true;
    AppMethodBeat.o(271463);
  }
  
  private static Map<String, String> aA(Map<String, String> paramMap)
  {
    AppMethodBeat.i(271452);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((!paramMap.equals("debug")) && (!paramMap.equals("debugSvr"))) {
        localHashMap.put(str, localObject);
      }
    }
    paramMap = (Map)localHashMap;
    AppMethodBeat.o(271452);
    return paramMap;
  }
  
  private static Map<String, String> aKb(String paramString)
  {
    AppMethodBeat.i(271444);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = (Map)localHashMap;
      AppMethodBeat.o(271444);
      return paramString;
    }
    paramString = n.b((CharSequence)paramString, new String[] { "&" }).iterator();
    while (paramString.hasNext())
    {
      List localList = n.b((CharSequence)paramString.next(), new String[] { "=" });
      localHashMap.put(localList.get(0), localList.get(1));
    }
    paramString = (Map)localHashMap;
    AppMethodBeat.o(271444);
    return paramString;
  }
  
  private static boolean d(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    AppMethodBeat.i(271457);
    if (paramMap1.size() != paramMap2.size())
    {
      AppMethodBeat.o(271457);
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = (String)localEntry.getKey();
      if (!((String)localEntry.getValue()).equals(paramMap2.get(str)))
      {
        AppMethodBeat.o(271457);
        return false;
      }
    }
    AppMethodBeat.o(271457);
    return true;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271506);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(271506);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271501);
    super.onCreate(paramBundle);
    Object localObject2;
    if (getIntent().hasExtra("report"))
    {
      paramBundle = getIntent().getParcelableExtra("report");
      s.checkNotNull(paramBundle);
      s.s(paramBundle, "intent.getParcelableExtr…iteAppConstants.report)!!");
      paramBundle = (WxaLiteAppStartReport)paramBundle;
      setActionbarColor(0);
      setNavigationbarColor(0);
      localObject2 = com.tencent.mm.plugin.lite.a.JYS.a(0, paramBundle);
      if (!((WxaLiteAppStartReport)localObject2).baY) {
        break label474;
      }
      h.OAn.kJ(1404, this.KbN);
    }
    int j;
    Object localObject4;
    for (;;)
    {
      if (KbO)
      {
        KbO = false;
        paramBundle = aw.bf((Context)this);
        localObject1 = new DisplayMetrics();
        localObject3 = getWindowManager();
        s.s(localObject3, "getWindowManager()");
        ((WindowManager)localObject3).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        i = paramBundle.x;
        j = paramBundle.y;
        float f1 = ((DisplayMetrics)localObject1).density;
        int k = bf.be((Context)this);
        int m = bf.bk((Context)this);
        float f2 = 48.0F * f1;
        localObject3 = getResources().getDisplayMetrics();
        s.s(localObject3, "getResources().getDisplayMetrics()");
        localObject4 = aw.bV((Activity)this);
        LiteAppCenter.setSafeAreaInsets(0L, ((Rect)localObject4).left / f1, ((Rect)localObject4).top / f1, (((DisplayMetrics)localObject3).widthPixels - ((Rect)localObject4).right) / f1, (((DisplayMetrics)localObject3).heightPixels - ((Rect)localObject4).bottom) / f1, false);
        LiteAppCenter.setDisplayParams(0L, i / f1, j / f1, paramBundle.x / f1, paramBundle.y / f1, ((DisplayMetrics)localObject1).densityDpi, f1, f2 / f1, k / f1, m / f1);
        Log.i(this.TAG, "updateLvCppDisplayParams SetDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramBundle.x), Integer.valueOf(paramBundle.y), Integer.valueOf(((DisplayMetrics)localObject1).densityDpi), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f2) });
      }
      if (!com.tencent.mm.plugin.lite.c.fontScaleFollowSystem) {
        com.tencent.mm.plugin.lite.c.fontScale = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      }
      if (!com.tencent.mm.plugin.lite.c.fontScaleFollowSystem) {
        com.tencent.mm.plugin.lite.c.fontScale = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      }
      paramBundle = getIntent().getParcelableExtra("WxaLiteAppLaunchInfo");
      if (paramBundle != null) {
        break label490;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo");
      AppMethodBeat.o(271501);
      throw paramBundle;
      paramBundle = new WxaLiteAppStartReport();
      break;
      label474:
      h.OAn.kJ(1404, this.KbM);
    }
    label490:
    Object localObject3 = (WxaLiteAppLaunchInfo)paramBundle;
    Object localObject1 = aKb(((WxaLiteAppLaunchInfo)localObject3).KaF);
    paramBundle = (Bundle)localObject1;
    if (!BuildInfo.DEBUG)
    {
      paramBundle = (Bundle)localObject1;
      if (!WeChatEnvironment.isCoolassistEnv())
      {
        paramBundle = (Bundle)localObject1;
        if (n.T((String)((Map)localObject1).get("debug"), "1", false)) {
          paramBundle = aA((Map)localObject1);
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.lite.a.JYS;
    if ((!d(paramBundle, com.tencent.mm.plugin.lite.a.fTP())) || (n.T((String)paramBundle.get("debug"), "1", false)))
    {
      localObject1 = com.tencent.mm.plugin.lite.a.JYS;
      s.u(paramBundle, "<set-?>");
      com.tencent.mm.plugin.lite.a.ay(paramBundle);
      com.tencent.mm.plugin.lite.c.setPath(com.tencent.mm.plugin.lite.c.getLastPath(), paramBundle, "Vue");
    }
    if (com.tencent.wxa.c.keQ().aidp != null)
    {
      i = 1;
      if (i == 0) {
        break label1331;
      }
      ((WxaLiteAppStartReport)localObject2).egt = true;
      label640:
      paramBundle = com.tencent.wxa.c.keQ().OM(false);
      j = com.tencent.wxa.c.keQ().d(paramBundle);
      paramBundle = ((WxaLiteAppLaunchInfo)localObject3).path;
      if (i == 0) {
        ((WxaLiteAppStartReport)localObject2).egv = (System.currentTimeMillis() - ((WxaLiteAppStartReport)localObject2).egu);
      }
      ((WxaLiteAppStartReport)localObject2).egD = System.currentTimeMillis();
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() != 0) {
          break label1348;
        }
        i = 1;
        label709:
        if (i == 0) {
          break label1354;
        }
      }
      ((WxaLiteAppStartReport)localObject2).egj = "index";
      paramBundle = LiteAppCenter.showIndexView(((WxaLiteAppLaunchInfo)localObject3).appId, y.n(((WxaLiteAppLaunchInfo)localObject3).pkgPath, true), ((WxaLiteAppLaunchInfo)localObject3).egI, ((WxaLiteAppLaunchInfo)localObject3).query, j);
      s.s(paramBundle, "showIndexView(launchInfo…unchInfo.query, engineId)");
      label759:
      ((WxaLiteAppStartReport)localObject2).query = ((WxaLiteAppLaunchInfo)localObject3).query;
      ((WxaLiteAppStartReport)localObject2).egE = (System.currentTimeMillis() - ((WxaLiteAppStartReport)localObject2).egD);
      ((WxaLiteAppStartReport)localObject2).egC = paramBundle.success;
      Log.i(this.TAG, "show index view result %b", new Object[] { Integer.valueOf(paramBundle.success) });
      localObject1 = new HashMap();
      ((Map)localObject1).put("activityId", Long.valueOf(paramBundle.appUuid));
      ((Map)localObject1).put("appId", ((WxaLiteAppLaunchInfo)localObject3).appId);
      ((Map)localObject1).put("appPtr", Long.valueOf(paramBundle.appPtr));
      ((Map)localObject1).put("pageViewId", Long.valueOf(paramBundle.pageId));
      localObject4 = (Map)localObject1;
      String str = paramBundle.basePath;
      s.s(str, "page.basePath");
      ((Map)localObject4).put("basePath", str);
      ((Map)localObject1).put("pageRenderPtr", Long.valueOf(paramBundle.renderId));
      ((Map)localObject1).put("flags", Integer.valueOf(paramBundle.flags));
      ((Map)localObject1).put("startTime", Long.valueOf(((WxaLiteAppLaunchInfo)localObject3).startTime));
      ((Map)localObject1).put("success", Integer.valueOf(paramBundle.success));
      localObject4 = new Intent((Context)this, WxaLiteAppLiteUI.class);
      ((Intent)localObject4).putExtra("main", "liteApp");
      ((Intent)localObject4).putExtra("name", String.valueOf(paramBundle.pageId));
      ((Intent)localObject4).putExtra("params", (Serializable)new com.tencent.wxa.d.a((Map)localObject1));
      ((Intent)localObject4).putExtra("background_mode", "transparent");
      ((Intent)localObject4).putExtra("report", (Parcelable)localObject2);
      localObject1 = getIntent().getBundleExtra("bundle");
      ((Intent)localObject4).putExtra("bundle", (Bundle)localObject1);
      if (localObject1 == null) {
        break label1480;
      }
      if (((Bundle)localObject1).containsKey("mode"))
      {
        localObject2 = ((Bundle)localObject1).getString("mode", "");
        s.s(localObject2, "bundle.getString(ILiteAppConstants.MODE, \"\")");
        if ((!Util.isNullOrNil((String)localObject2)) && (n.T((String)localObject2, "bottom_sheet", true))) {
          ((Intent)localObject4).setClass(MMApplicationContext.getContext(), WxaLiteAppSheetUI.class);
        }
      }
      if (!((Bundle)localObject1).containsKey("requestCode")) {
        break label1480;
      }
    }
    label1331:
    label1348:
    label1480:
    for (int i = ((Bundle)localObject1).getInt("requestCode");; i = 0)
    {
      if (i <= 0) {
        ((Intent)localObject4).addFlags(268435456);
      }
      if (i > 0) {
        startActivityForResult((Intent)localObject4, i);
      }
      for (;;)
      {
        Log.i(this.TAG, "cpan appId%s appPtr:%s pageViewId:%s, pageRenderPtr%s", new Object[] { ((WxaLiteAppLaunchInfo)localObject3).appId, Long.valueOf(paramBundle.appPtr), Long.valueOf(paramBundle.pageId), Long.valueOf(paramBundle.renderId) });
        if (i <= 0) {
          finish();
        }
        AppMethodBeat.o(271501);
        return;
        i = 0;
        break;
        ((WxaLiteAppStartReport)localObject2).egt = false;
        ((WxaLiteAppStartReport)localObject2).egu = System.currentTimeMillis();
        break label640;
        i = 0;
        break label709;
        label1354:
        ((WxaLiteAppStartReport)localObject2).egj = paramBundle;
        paramBundle = LiteAppCenter.showView(((WxaLiteAppLaunchInfo)localObject3).appId, paramBundle, ((WxaLiteAppLaunchInfo)localObject3).query, y.n(((WxaLiteAppLaunchInfo)localObject3).pkgPath, false), ((WxaLiteAppLaunchInfo)localObject3).egI, j);
        s.s(paramBundle, "showView(launchInfo.appI…o.signatureKey, engineId)");
        break label759;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject4);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI$Companion;", "", "()V", "needetDisplayParams", "", "getNeedetDisplayParams", "()Z", "setNeedetDisplayParams", "(Z)V", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI
 * JD-Core Version:    0.7.0.1
 */