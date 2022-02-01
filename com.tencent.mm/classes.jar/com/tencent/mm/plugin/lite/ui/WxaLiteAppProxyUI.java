package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.plugin.lite.d;
import com.tencent.mm.plugin.lite.d.a;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(2)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "START_UI_UN_NEED_DO_ININT", "", "getSTART_UI_UN_NEED_DO_ININT", "()I", "setSTART_UI_UN_NEED_DO_ININT", "(I)V", "START_UI_WITH_DO_INIT", "getSTART_UI_WITH_DO_INIT", "setSTART_UI_WITH_DO_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppProxyUI
  extends MMActivity
{
  private String TAG = "MicroMsg.WxaLiteAppProxyUI";
  private int uZc = 4;
  private int uZd = 5;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217234);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    setNavigationbarColor(0);
    paramBundle = d.uYh;
    if (d.a.IU(0)) {
      g.yhR.dD(1404, this.uZd);
    }
    for (;;)
    {
      paramBundle = getIntent().getParcelableExtra("WxaLiteAppLaunchInfo");
      if (paramBundle != null) {
        break;
      }
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo");
      AppMethodBeat.o(217234);
      throw paramBundle;
      g.yhR.dD(1404, this.uZc);
    }
    paramBundle = (WxaLiteAppLaunchInfo)paramBundle;
    Object localObject1 = getIntent().getStringExtra("data");
    localObject1 = LiteAppCenter.showIndexView(paramBundle.appId, paramBundle.pkgPath, paramBundle.nUi, (String)localObject1);
    ad.i(this.TAG, "show index view result %b", new Object[] { Boolean.valueOf(((LiteAppCenter.PageInfo)localObject1).success) });
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("appId", paramBundle.appId);
    ((Map)localObject2).put("appPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject1).appPtr));
    ((Map)localObject2).put("pageViewId", Long.valueOf(((LiteAppCenter.PageInfo)localObject1).pageId));
    Object localObject3 = (Map)localObject2;
    String str = ((LiteAppCenter.PageInfo)localObject1).basePath;
    p.g(str, "page.basePath");
    ((Map)localObject3).put("basePath", str);
    ((Map)localObject2).put("pageRenderPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject1).renderId));
    localObject3 = (Map)localObject2;
    str = ((LiteAppCenter.PageInfo)localObject1).title;
    p.g(str, "page.title");
    ((Map)localObject3).put("title", str);
    localObject3 = (Map)localObject2;
    str = ((LiteAppCenter.PageInfo)localObject1).titleColor;
    p.g(str, "page.titleColor");
    ((Map)localObject3).put("titleColor", str);
    localObject3 = (Map)localObject2;
    str = ((LiteAppCenter.PageInfo)localObject1).darkTitleColor;
    p.g(str, "page.darkTitleColor");
    ((Map)localObject3).put("darkTitleColor", str);
    localObject3 = (Map)localObject2;
    str = ((LiteAppCenter.PageInfo)localObject1).titleBackgroundColor;
    p.g(str, "page.titleBackgroundColor");
    ((Map)localObject3).put("titleBackgroundColor", str);
    localObject3 = (Map)localObject2;
    str = ((LiteAppCenter.PageInfo)localObject1).darkTitleBackgroundColor;
    p.g(str, "page.darkTitleBackgroundColor");
    ((Map)localObject3).put("darkTitleBackgroundColor", str);
    ((Map)localObject2).put("flags", Integer.valueOf(((LiteAppCenter.PageInfo)localObject1).flags));
    ((Map)localObject2).put("startTime", Long.valueOf(paramBundle.startTime));
    localObject3 = new Intent((Context)this, WxaLiteAppUI.class);
    ((Intent)localObject3).addFlags(268435456);
    ((Intent)localObject3).putExtra("main", "liteApp");
    ((Intent)localObject3).putExtra("name", String.valueOf(((LiteAppCenter.PageInfo)localObject1).pageId));
    ((Intent)localObject3).putExtra("params", (Serializable)new com.tencent.wax.d.a((Map)localObject2));
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ad.i(this.TAG, "cpan appId%s pageViewId:%s, pageRenderPtr%s", new Object[] { paramBundle.appId, Long.valueOf(((LiteAppCenter.PageInfo)localObject1).pageId), Long.valueOf(((LiteAppCenter.PageInfo)localObject1).renderId) });
    finish();
    AppMethodBeat.o(217234);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI
 * JD-Core Version:    0.7.0.1
 */