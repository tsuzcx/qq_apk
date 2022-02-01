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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(2)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "START_UI_UN_NEED_DO_ININT", "", "getSTART_UI_UN_NEED_DO_ININT", "()I", "setSTART_UI_UN_NEED_DO_ININT", "(I)V", "START_UI_WITH_DO_INIT", "getSTART_UI_WITH_DO_INIT", "setSTART_UI_WITH_DO_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppProxyUI
  extends MMActivity
{
  private String TAG = "MicroMsg.WxaLiteAppProxyUI";
  private int vlg = 4;
  private int vlh = 5;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217880);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    setNavigationbarColor(0);
    paramBundle = d.vjW;
    if (d.a.Js(0)) {
      g.yxI.dD(1404, this.vlh);
    }
    for (;;)
    {
      paramBundle = getIntent().getParcelableExtra("WxaLiteAppLaunchInfo");
      if (paramBundle != null) {
        break;
      }
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo");
      AppMethodBeat.o(217880);
      throw paramBundle;
      g.yxI.dD(1404, this.vlg);
    }
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = (WxaLiteAppLaunchInfo)paramBundle;
    paramBundle = localWxaLiteAppLaunchInfo.path;
    label139:
    Object localObject1;
    Object localObject2;
    if (((CharSequence)paramBundle).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label779;
      }
      paramBundle = LiteAppCenter.showIndexView(localWxaLiteAppLaunchInfo.appId, localWxaLiteAppLaunchInfo.pkgPath, localWxaLiteAppLaunchInfo.nZO, localWxaLiteAppLaunchInfo.query);
      ae.i(this.TAG, "show index view result %b", new Object[] { Boolean.valueOf(paramBundle.success) });
      localObject1 = new HashMap();
      ((Map)localObject1).put("activityId", Long.valueOf(paramBundle.appPtr));
      ((Map)localObject1).put("appId", localWxaLiteAppLaunchInfo.appId);
      ((Map)localObject1).put("appPtr", Long.valueOf(paramBundle.appPtr));
      ((Map)localObject1).put("pageViewId", Long.valueOf(paramBundle.pageId));
      localObject2 = (Map)localObject1;
      String str = paramBundle.basePath;
      p.g(str, "page.basePath");
      ((Map)localObject2).put("basePath", str);
      ((Map)localObject1).put("pageRenderPtr", Long.valueOf(paramBundle.renderId));
      localObject2 = (Map)localObject1;
      str = paramBundle.title;
      p.g(str, "page.title");
      ((Map)localObject2).put("title", str);
      localObject2 = (Map)localObject1;
      str = paramBundle.titleColor;
      p.g(str, "page.titleColor");
      ((Map)localObject2).put("titleColor", str);
      localObject2 = (Map)localObject1;
      str = paramBundle.darkTitleColor;
      p.g(str, "page.darkTitleColor");
      ((Map)localObject2).put("darkTitleColor", str);
      localObject2 = (Map)localObject1;
      str = paramBundle.titleBackgroundColor;
      p.g(str, "page.titleBackgroundColor");
      ((Map)localObject2).put("titleBackgroundColor", str);
      localObject2 = (Map)localObject1;
      str = paramBundle.darkTitleBackgroundColor;
      p.g(str, "page.darkTitleBackgroundColor");
      ((Map)localObject2).put("darkTitleBackgroundColor", str);
      ((Map)localObject1).put("flags", Integer.valueOf(paramBundle.flags));
      localObject2 = (Map)localObject1;
      if (!paramBundle.showMenu) {
        break label803;
      }
    }
    label779:
    label803:
    for (int i = 1;; i = 0)
    {
      ((Map)localObject2).put("showMenu", Integer.valueOf(i));
      ((Map)localObject1).put("startTime", Long.valueOf(localWxaLiteAppLaunchInfo.startTime));
      localObject2 = new Intent((Context)this, WxaLiteAppUI.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).putExtra("main", "liteApp");
      ((Intent)localObject2).putExtra("name", String.valueOf(paramBundle.pageId));
      ((Intent)localObject2).putExtra("params", (Serializable)new com.tencent.wax.d.a((Map)localObject1));
      ((Intent)localObject2).putExtra("background_mode", "transparent");
      ((Intent)localObject2).putExtra("bundle", getIntent().getBundleExtra("bundle"));
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ae.i(this.TAG, "cpan appId%s appPtr:%s pageViewId:%s, pageRenderPtr%s", new Object[] { localWxaLiteAppLaunchInfo.appId, Long.valueOf(paramBundle.appPtr), Long.valueOf(paramBundle.pageId), Long.valueOf(paramBundle.renderId) });
      finish();
      AppMethodBeat.o(217880);
      return;
      i = 0;
      break;
      paramBundle = LiteAppCenter.showView(localWxaLiteAppLaunchInfo.appId, paramBundle, localWxaLiteAppLaunchInfo.query, localWxaLiteAppLaunchInfo.pkgPath, localWxaLiteAppLaunchInfo.nZO);
      break label139;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI
 * JD-Core Version:    0.7.0.1
 */