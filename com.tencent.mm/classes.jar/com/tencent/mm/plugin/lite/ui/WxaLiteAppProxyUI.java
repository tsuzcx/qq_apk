package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.c;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(2)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "START_UI_UN_NEED_DO_ININT", "", "getSTART_UI_UN_NEED_DO_ININT", "()I", "setSTART_UI_UN_NEED_DO_ININT", "(I)V", "START_UI_WITH_DO_INIT", "getSTART_UI_WITH_DO_INIT", "setSTART_UI_WITH_DO_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getLayoutId", "isSameMapContent", "", "m1", "", "m2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "query2Map", "query", "removeDebugInfo", "m", "Companion", "luggage-lite-app_release"})
public final class WxaLiteAppProxyUI
  extends MMActivity
{
  private static boolean yFo;
  public static final WxaLiteAppProxyUI.a yFp;
  private String TAG = "MicroMsg.WxaLiteAppProxyUI";
  private int yFm = 4;
  private int yFn = 5;
  
  static
  {
    AppMethodBeat.i(198978);
    yFp = new WxaLiteAppProxyUI.a((byte)0);
    yFo = true;
    AppMethodBeat.o(198978);
  }
  
  private static Map<String, String> aCW(String paramString)
  {
    AppMethodBeat.i(198974);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = (Map)localHashMap;
      AppMethodBeat.o(198974);
      return paramString;
    }
    paramString = n.b((CharSequence)paramString, new String[] { "&" }).iterator();
    while (paramString.hasNext())
    {
      List localList = n.b((CharSequence)paramString.next(), new String[] { "=" });
      localHashMap.put(localList.get(0), localList.get(1));
    }
    paramString = (Map)localHashMap;
    AppMethodBeat.o(198974);
    return paramString;
  }
  
  private static Map<String, String> ar(Map<String, String> paramMap)
  {
    AppMethodBeat.i(198975);
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
    AppMethodBeat.o(198975);
    return paramMap;
  }
  
  private static boolean c(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    AppMethodBeat.i(198976);
    if (paramMap1.size() != paramMap2.size())
    {
      AppMethodBeat.o(198976);
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = (String)localEntry.getKey();
      if (!((String)localEntry.getValue()).equals(paramMap2.get(str)))
      {
        AppMethodBeat.o(198976);
        return false;
      }
    }
    AppMethodBeat.o(198976);
    return true;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198977);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    setNavigationbarColor(0);
    if (com.tencent.mm.plugin.lite.a.yDP.Pv(0)) {
      h.CyF.dN(1404, this.yFn);
    }
    int i;
    for (;;)
    {
      if (yFo)
      {
        yFo = false;
        paramBundle = ao.az((Context)this);
        localObject1 = new DisplayMetrics();
        localObject2 = getWindowManager();
        p.g(localObject2, "getWindowManager()");
        ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        i = paramBundle.x;
        int j = paramBundle.y;
        float f1 = ((DisplayMetrics)localObject1).density;
        int k = au.ay((Context)this);
        int m = au.aD((Context)this);
        float f2 = 48.0F * f1;
        LiteAppCenter.setDisplayParams(i / f1, j / f1, paramBundle.x / f1, paramBundle.y / f1, ((DisplayMetrics)localObject1).densityDpi, f1, f2 / f1, k / f1, m / f1);
        Log.i(this.TAG, "updateLvCppDisplayParams SetDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramBundle.x), Integer.valueOf(paramBundle.y), Integer.valueOf(((DisplayMetrics)localObject1).densityDpi), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f2) });
        paramBundle = getResources().getDisplayMetrics();
        p.g(paramBundle, "getResources().getDisplayMetrics()");
        localObject1 = ao.bl((Activity)this);
        LiteAppCenter.setSafeAreaInsets(((Rect)localObject1).left / f1, ((Rect)localObject1).top / f1, (paramBundle.widthPixels - ((Rect)localObject1).right) / f1, (paramBundle.heightPixels - ((Rect)localObject1).bottom) / f1);
      }
      paramBundle = getIntent().getParcelableExtra("WxaLiteAppLaunchInfo");
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo");
      AppMethodBeat.o(198977);
      throw paramBundle;
      h.CyF.dN(1404, this.yFm);
    }
    Object localObject2 = (WxaLiteAppLaunchInfo)paramBundle;
    Object localObject1 = aCW(((WxaLiteAppLaunchInfo)localObject2).yEx);
    paramBundle = (Bundle)localObject1;
    if (!BuildInfo.DEBUG)
    {
      paramBundle = (Bundle)localObject1;
      if (!WeChatEnvironment.isCoolassistEnv())
      {
        paramBundle = (Bundle)localObject1;
        if (n.I((String)((Map)localObject1).get("debug"), "1", false)) {
          paramBundle = ar((Map)localObject1);
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.lite.a.yDP;
    if ((!c(paramBundle, com.tencent.mm.plugin.lite.a.ecu())) || (n.I((String)paramBundle.get("debug"), "1", false)))
    {
      localObject1 = com.tencent.mm.plugin.lite.a.yDP;
      p.h(paramBundle, "<set-?>");
      com.tencent.mm.plugin.lite.a.ap(paramBundle);
      c.setPath(c.getLastPath(), paramBundle);
    }
    paramBundle = ((WxaLiteAppLaunchInfo)localObject2).path;
    if (paramBundle != null)
    {
      if (((CharSequence)paramBundle).length() != 0) {
        break label1037;
      }
      i = 1;
      if (i == 0) {
        break label1043;
      }
    }
    label1037:
    label1043:
    for (paramBundle = LiteAppCenter.showIndexView(((WxaLiteAppLaunchInfo)localObject2).appId, s.k(((WxaLiteAppLaunchInfo)localObject2).pkgPath, true), ((WxaLiteAppLaunchInfo)localObject2).crh, ((WxaLiteAppLaunchInfo)localObject2).query);; paramBundle = LiteAppCenter.showView(((WxaLiteAppLaunchInfo)localObject2).appId, paramBundle, ((WxaLiteAppLaunchInfo)localObject2).query, s.k(((WxaLiteAppLaunchInfo)localObject2).pkgPath, false), ((WxaLiteAppLaunchInfo)localObject2).crh))
    {
      Log.i(this.TAG, "show index view result %b", new Object[] { Boolean.valueOf(paramBundle.success) });
      localObject1 = new HashMap();
      ((Map)localObject1).put("activityId", Long.valueOf(paramBundle.appUuid));
      ((Map)localObject1).put("appId", ((WxaLiteAppLaunchInfo)localObject2).appId);
      ((Map)localObject1).put("appPtr", Long.valueOf(paramBundle.appPtr));
      ((Map)localObject1).put("pageViewId", Long.valueOf(paramBundle.pageId));
      Object localObject3 = (Map)localObject1;
      String str = paramBundle.basePath;
      p.g(str, "page.basePath");
      ((Map)localObject3).put("basePath", str);
      ((Map)localObject1).put("pageRenderPtr", Long.valueOf(paramBundle.renderId));
      ((Map)localObject1).put("flags", Integer.valueOf(paramBundle.flags));
      ((Map)localObject1).put("startTime", Long.valueOf(((WxaLiteAppLaunchInfo)localObject2).startTime));
      localObject3 = new Intent((Context)this, WxaLiteAppLiteUI.class);
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).putExtra("main", "liteApp");
      ((Intent)localObject3).putExtra("name", String.valueOf(paramBundle.pageId));
      ((Intent)localObject3).putExtra("params", (Serializable)new com.tencent.wxa.d.a((Map)localObject1));
      ((Intent)localObject3).putExtra("background_mode", "transparent");
      ((Intent)localObject3).putExtra("bundle", getIntent().getBundleExtra("bundle"));
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i(this.TAG, "cpan appId%s appPtr:%s pageViewId:%s, pageRenderPtr%s", new Object[] { ((WxaLiteAppLaunchInfo)localObject2).appId, Long.valueOf(paramBundle.appPtr), Long.valueOf(paramBundle.pageId), Long.valueOf(paramBundle.renderId) });
      finish();
      AppMethodBeat.o(198977);
      return;
      i = 0;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI
 * JD-Core Version:    0.7.0.1
 */