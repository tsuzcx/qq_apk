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
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/util/KidsWatchUtil;", "", "()V", "TAG", "", "gotoLauncherUI", "", "context", "Landroid/content/Context;", "loginUrl", "isFinish", "", "gotoMiniProgram", "appId", "path", "scene", "", "sceneNote", "marginAdapter", "cardParentLL", "Landroid/widget/LinearLayout;", "buttonParentLL", "setWindowStyle", "activity", "Landroid/app/Activity;", "isShowStatusBar", "isShowNavigationBar", "showAlertWhenError", "errCode", "errMsg", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a JTW;
  
  static
  {
    AppMethodBeat.i(262113);
    JTW = new a();
    AppMethodBeat.o(262113);
  }
  
  public static void a(Context paramContext, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(262106);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("KidsWatchUtil", kotlin.g.b.s.X("marginAdapter, context:", paramContext));
    int k = bd.K(paramContext, com.tencent.g.c.c.getScreenWidth(paramContext));
    int j = bd.fromDPToPix(paramContext, 8);
    int i = bd.fromDPToPix(paramContext, 40);
    if (k >= 375)
    {
      j = bd.fromDPToPix(paramContext, 24);
      i = bd.fromDPToPix(paramContext, 96);
    }
    for (;;)
    {
      if (paramLinearLayout1 != null)
      {
        paramContext = paramLinearLayout1.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(262106);
          throw paramContext;
        }
        paramContext = (LinearLayout.LayoutParams)paramContext;
        paramContext.leftMargin = j;
        paramContext.rightMargin = j;
        paramLinearLayout1.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      if (paramLinearLayout2 != null)
      {
        paramContext = paramLinearLayout2.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(262106);
          throw paramContext;
        }
        paramContext = (LinearLayout.LayoutParams)paramContext;
        paramContext.bottomMargin = i;
        paramLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      AppMethodBeat.o(262106);
      return;
    }
  }
  
  public static void aX(Activity paramActivity)
  {
    AppMethodBeat.i(262093);
    kotlin.g.b.s.u(paramActivity, "activity");
    Log.i("KidsWatchUtil", "setWindowStyle, activity:" + paramActivity + ", isShowStatusBar:true, isShowNavigationBar: false");
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(5890);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      paramActivity.getWindow().setStatusBarColor(0);
      paramActivity.getWindow().setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(262093);
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(262084);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "loginUrl");
    Log.i("KidsWatchUtil", "gotoLauncherUI, context:" + paramContext + ", url:" + paramString + ", isFinish:" + paramBoolean);
    if (!paramBoolean)
    {
      paramString = new d(paramString);
      h.aZW().a((p)paramString, 0);
    }
    paramString = new Intent();
    paramString.addFlags(67108864);
    paramString.putExtra("preferred_tab", 0);
    com.tencent.mm.br.c.g(paramContext, ".ui.LauncherUI", paramString);
    AppMethodBeat.o(262084);
  }
  
  public static void i(Context paramContext, int paramInt, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(262090);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("KidsWatchUtil", "context:" + paramContext + ", errCode:errCode, errMsg:" + paramString);
    if (!Util.isNullOrNil(paramString))
    {
      kotlin.g.b.s.checkNotNull(paramString);
      if (!n.U(paramString, "<", false))
      {
        k.c(paramContext, paramString, "", true);
        AppMethodBeat.o(262090);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString == null) {}
      for (paramString = localObject;; paramString = Boolean.valueOf(paramString.a(paramContext, null, null)))
      {
        if (paramString == null) {
          k.s(paramContext, b.h.check_big_file_error_parse_resp, 0);
        }
        AppMethodBeat.o(262090);
        return;
      }
    }
    if (paramInt == a.b.JRj.value)
    {
      k.c(paramContext, paramContext.getString(b.h.JSH), "", true);
      AppMethodBeat.o(262090);
      return;
    }
    if (paramInt == a.b.JRk.value)
    {
      k.c(paramContext, paramContext.getString(b.h.JSI), "", true);
      AppMethodBeat.o(262090);
      return;
    }
    k.c(paramContext, paramContext.getString(b.h.JSJ, new Object[] { Integer.valueOf(paramInt) }), "", true);
    AppMethodBeat.o(262090);
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(262099);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "path");
    kotlin.g.b.s.u(paramString3, "sceneNote");
    Log.i("KidsWatchUtil", "gotoMiniProgram, appId:" + paramString1 + ", path:" + paramString2 + ", scene:1180, sceneNote:" + paramString3);
    g localg = new g();
    localg.appId = paramString1;
    localg.qAF = paramString2;
    localg.scene = 1180;
    localg.hzx = paramString3;
    localg.euz = 0;
    ((t)h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(262099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.b.a
 * JD-Core Version:    0.7.0.1
 */