package com.tencent.mm.plugin.kidswatch.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/util/KidsWatchUtil;", "", "()V", "TAG", "", "gotoLauncherUI", "", "context", "Landroid/content/Context;", "loginUrl", "isFinish", "", "gotoMiniProgram", "appId", "path", "scene", "", "sceneNote", "marginAdapter", "cardParentLL", "Landroid/widget/LinearLayout;", "buttonParentLL", "setWindowStyle", "activity", "Landroid/app/Activity;", "isShowStatusBar", "isShowNavigationBar", "showAlertWhenError", "errCode", "errMsg", "plugin-kidswatch_release"})
public final class a
{
  public static final a Edb;
  
  static
  {
    AppMethodBeat.i(252249);
    Edb = new a();
    AppMethodBeat.o(252249);
  }
  
  public static void a(Context paramContext, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(252248);
    p.k(paramContext, "context");
    Log.i("KidsWatchUtil", "marginAdapter, context:".concat(String.valueOf(paramContext)));
    int k = aw.H(paramContext, com.tencent.g.c.c.getScreenWidth(paramContext));
    int j = aw.fromDPToPix(paramContext, 8);
    int i = aw.fromDPToPix(paramContext, 40);
    if (k >= 375)
    {
      j = aw.fromDPToPix(paramContext, 24);
      i = aw.fromDPToPix(paramContext, 96);
    }
    for (;;)
    {
      if (paramLinearLayout1 != null)
      {
        paramContext = paramLinearLayout1.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(252248);
          throw paramContext;
        }
        paramContext = (LinearLayout.LayoutParams)paramContext;
        if (paramContext != null) {
          paramContext.leftMargin = j;
        }
        if (paramContext != null) {
          paramContext.rightMargin = j;
        }
        paramLinearLayout1.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      if (paramLinearLayout2 != null)
      {
        paramContext = paramLinearLayout2.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(252248);
          throw paramContext;
        }
        paramContext = (LinearLayout.LayoutParams)paramContext;
        if (paramContext != null) {
          paramContext.bottomMargin = i;
        }
        paramLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)paramContext);
        AppMethodBeat.o(252248);
        return;
      }
      AppMethodBeat.o(252248);
      return;
    }
  }
  
  public static void aw(Activity paramActivity)
  {
    AppMethodBeat.i(252245);
    p.k(paramActivity, "activity");
    Log.i("KidsWatchUtil", "setWindowStyle, activity:" + paramActivity + ", isShowStatusBar:true, isShowNavigationBar: false");
    Object localObject = paramActivity.getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "activity.window.decorView");
    ((View)localObject).setSystemUiVisibility(5890);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      localObject = paramActivity.getWindow();
      p.j(localObject, "activity.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = paramActivity.getWindow();
      p.j(localObject, "activity.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(252245);
  }
  
  public static void e(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(252244);
    p.k(paramContext, "context");
    Log.i("KidsWatchUtil", "context:" + paramContext + ", errCode:errCode, errMsg:" + paramString);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramString == null) {
        p.iCn();
      }
      if (!n.M(paramString, "<", false))
      {
        com.tencent.mm.ui.base.h.af(paramContext, paramString, "");
        AppMethodBeat.o(252244);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a(paramContext, null, null);
        AppMethodBeat.o(252244);
        return;
      }
      com.tencent.mm.ui.base.h.p(paramContext, b.h.check_big_file_error_parse_resp, 0);
      AppMethodBeat.o(252244);
      return;
    }
    if (paramInt == a.b.Eab.value)
    {
      com.tencent.mm.ui.base.h.af(paramContext, paramContext.getString(b.h.Ebz), "");
      AppMethodBeat.o(252244);
      return;
    }
    if (paramInt == a.b.Eac.value)
    {
      com.tencent.mm.ui.base.h.af(paramContext, paramContext.getString(b.h.EbA), "");
      AppMethodBeat.o(252244);
      return;
    }
    com.tencent.mm.ui.base.h.af(paramContext, paramContext.getString(b.h.EbB, new Object[] { Integer.valueOf(paramInt) }), "");
    AppMethodBeat.o(252244);
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(252246);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "path");
    p.k(paramString3, "sceneNote");
    Log.i("KidsWatchUtil", "gotoMiniProgram, appId:" + paramString1 + ", path:" + paramString2 + ", scene:1180, sceneNote:" + paramString3);
    g localg = new g();
    localg.appId = paramString1;
    localg.nBq = paramString2;
    localg.scene = 1180;
    localg.fvd = paramString3;
    localg.cBU = 0;
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(252246);
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(252243);
    p.k(paramContext, "context");
    p.k(paramString, "loginUrl");
    Log.i("KidsWatchUtil", "gotoLauncherUI, context:" + paramContext + ", url:" + paramString + ", isFinish:" + paramBoolean);
    if (!paramBoolean)
    {
      paramString = new e(paramString);
      com.tencent.mm.kernel.h.aGY().b((q)paramString);
    }
    paramString = new Intent();
    paramString.addFlags(67108864);
    paramString.putExtra("preferred_tab", 0);
    com.tencent.mm.by.c.f(paramContext, ".ui.LauncherUI", paramString);
    AppMethodBeat.o(252243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.b.a
 * JD-Core Version:    0.7.0.1
 */