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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/util/KidsWatchUtil;", "", "()V", "TAG", "", "gotoLauncherUI", "", "context", "Landroid/content/Context;", "loginUrl", "isFinish", "", "gotoMiniProgram", "appId", "path", "scene", "", "sceneNote", "marginAdapter", "cardParentLL", "Landroid/widget/LinearLayout;", "buttonParentLL", "setWindowStyle", "activity", "Landroid/app/Activity;", "isShowStatusBar", "isShowNavigationBar", "showAlertWhenError", "errCode", "errMsg", "plugin-kidswatch_release"})
public final class a
{
  public static final a yBL;
  
  static
  {
    AppMethodBeat.i(256388);
    yBL = new a();
    AppMethodBeat.o(256388);
  }
  
  public static void a(Context paramContext, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(256387);
    p.h(paramContext, "context");
    Log.i("KidsWatchUtil", "marginAdapter, context:".concat(String.valueOf(paramContext)));
    int k = at.E(paramContext, com.tencent.h.c.c.getScreenWidth(paramContext));
    int j = at.fromDPToPix(paramContext, 8);
    int i = at.fromDPToPix(paramContext, 40);
    if (k >= 375)
    {
      j = at.fromDPToPix(paramContext, 24);
      i = at.fromDPToPix(paramContext, 96);
    }
    for (;;)
    {
      if (paramLinearLayout1 != null)
      {
        paramContext = paramLinearLayout1.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(256387);
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
          AppMethodBeat.o(256387);
          throw paramContext;
        }
        paramContext = (LinearLayout.LayoutParams)paramContext;
        if (paramContext != null) {
          paramContext.bottomMargin = i;
        }
        paramLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)paramContext);
        AppMethodBeat.o(256387);
        return;
      }
      AppMethodBeat.o(256387);
      return;
    }
  }
  
  public static void aq(Activity paramActivity)
  {
    AppMethodBeat.i(256385);
    p.h(paramActivity, "activity");
    Log.i("KidsWatchUtil", "setWindowStyle, activity:" + paramActivity + ", isShowStatusBar:true, isShowNavigationBar: false");
    Object localObject = paramActivity.getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    ((View)localObject).setSystemUiVisibility(5890);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      localObject = paramActivity.getWindow();
      p.g(localObject, "activity.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = paramActivity.getWindow();
      p.g(localObject, "activity.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(256385);
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(256384);
    p.h(paramContext, "context");
    Log.i("KidsWatchUtil", "context:" + paramContext + ", errCode:errCode, errMsg:" + paramString);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramString == null) {
        p.hyc();
      }
      if (!n.J(paramString, "<", false))
      {
        h.X(paramContext, paramString, "");
        AppMethodBeat.o(256384);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null)
      {
        paramString.a(paramContext, null, null);
        AppMethodBeat.o(256384);
        return;
      }
      h.n(paramContext, 2131757552, 0);
      AppMethodBeat.o(256384);
      return;
    }
    if (paramInt == a.b.yAj.value)
    {
      h.X(paramContext, paramContext.getString(2131762077), "");
      AppMethodBeat.o(256384);
      return;
    }
    if (paramInt == a.b.yAk.value)
    {
      h.X(paramContext, paramContext.getString(2131762078), "");
      AppMethodBeat.o(256384);
      return;
    }
    h.X(paramContext, paramContext.getString(2131762079, new Object[] { Integer.valueOf(paramInt) }), "");
    AppMethodBeat.o(256384);
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256386);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "path");
    p.h(paramString3, "sceneNote");
    Log.i("KidsWatchUtil", "gotoMiniProgram, appId:" + paramString1 + ", path:" + paramString2 + ", scene:1180, sceneNote:" + paramString3);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.kHw = paramString2;
    localg.scene = 1180;
    localg.dCw = paramString3;
    localg.iOo = 0;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, localg);
    AppMethodBeat.o(256386);
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256383);
    p.h(paramContext, "context");
    p.h(paramString, "loginUrl");
    Log.i("KidsWatchUtil", "gotoLauncherUI, context:" + paramContext + ", url:" + paramString + ", isFinish:" + paramBoolean);
    if (!paramBoolean)
    {
      paramString = new e(paramString);
      com.tencent.mm.kernel.g.azz().b((q)paramString);
    }
    paramString = new Intent();
    paramString.addFlags(67108864);
    paramString.putExtra("preferred_tab", 0);
    com.tencent.mm.br.c.f(paramContext, ".ui.LauncherUI", paramString);
    AppMethodBeat.o(256383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.b.a
 * JD-Core Version:    0.7.0.1
 */