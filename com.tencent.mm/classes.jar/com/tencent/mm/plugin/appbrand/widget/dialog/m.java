package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "shouldInLargeScreenCompatMode", "", "getAppropriateLargeScreenRequestDialogWidth", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "onPreDrawOnce", "block", "Lkotlin/Function0;", "postRequestLayout", "wrapScreenAdaptiveContextForRequestDialogIfNeed", "luggage-wechat-full-sdk_release"})
public final class m
{
  public static final m ruC;
  
  static
  {
    AppMethodBeat.i(148269);
    ruC = new m();
    AppMethodBeat.o(148269);
  }
  
  public static final int S(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(169666);
    p.k(paramContext, "context");
    int i = paramContext.getResources().getDimensionPixelSize(com.tencent.luggage.l.a.b.authorize_bottom_dialog_width_landscape);
    Resources localResources = paramContext.getResources();
    p.j(localResources, "context.resources");
    int j = Math.max(i, localResources.getDisplayMetrics().widthPixels / 2);
    if (paramInt < i) {}
    for (;;)
    {
      paramContext = paramContext.getResources();
      p.j(paramContext, "context.resources");
      paramInt = Math.min(i, paramContext.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(169666);
      return paramInt;
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
  }
  
  public static void a(final Context paramContext, View paramView1, View paramView2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(183080);
    p.k(paramContext, "context");
    p.k(paramView1, "rootView");
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView2 != null)
    {
      localLayoutParams = paramView2.getLayoutParams();
      if ((paramInt != 1) && (paramInt != 3)) {
        break label142;
      }
      if (paramView2 == null) {
        break label84;
      }
      paramView2 = paramView2.getParent();
    }
    for (;;)
    {
      if ((paramView2 instanceof RelativeLayout))
      {
        if (localLayoutParams == null)
        {
          paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(183080);
          throw paramContext;
          localLayoutParams = null;
          break;
          label84:
          paramView2 = null;
          continue;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(com.tencent.luggage.l.a.b.authorize_bottom_dialog_bottom_margin_bottom_landscape);
      }
    }
    if (!paramBoolean)
    {
      paramView2 = paramView1.getLayoutParams();
      paramView2.width = paramContext.getResources().getDimensionPixelSize(com.tencent.luggage.l.a.b.authorize_bottom_dialog_width_landscape);
      paramView1.setLayoutParams(paramView2);
      AppMethodBeat.o(183080);
      return;
      label142:
      Object localObject1;
      if (paramView2 != null) {
        localObject1 = paramView2.getParent();
      }
      while ((localObject1 instanceof RelativeLayout)) {
        if (localLayoutParams == null)
        {
          paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(183080);
          throw paramContext;
          localObject1 = null;
        }
        else
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(com.tencent.luggage.l.a.b.authorize_bottom_dialog_bottom_margin_bottom_portrait);
        }
      }
      if ((!paramBoolean) && (dh(paramContext)))
      {
        localObject1 = (kotlin.g.a.a)new a(paramView1, paramContext);
        ViewTreeObserver localViewTreeObserver = paramView1.getViewTreeObserver();
        p.j(localViewTreeObserver, "this.viewTreeObserver");
        if (localViewTreeObserver.isAlive()) {
          paramView1.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new m.b(paramView1, (kotlin.g.a.a)localObject1));
        }
        paramView1 = localObject2;
        if (paramView2 != null) {
          paramView1 = paramView2.getParent();
        }
        if ((paramView1 instanceof RelativeLayout))
        {
          if (localLayoutParams == null)
          {
            paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(183080);
            throw paramContext;
          }
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(com.tencent.luggage.l.a.b.authorize_bottom_dialog_bottom_margin_bottom_landscape);
          AppMethodBeat.o(183080);
        }
      }
      else
      {
        paramContext = paramView1.getLayoutParams();
        paramContext.width = -1;
        paramView1.setLayoutParams(paramContext);
      }
    }
    AppMethodBeat.o(183080);
  }
  
  private static boolean dh(Context paramContext)
  {
    AppMethodBeat.i(183081);
    paramContext = paramContext.getResources();
    p.j(paramContext, "this.resources");
    if ((paramContext.getConfiguration().screenLayout & 0xF) >= 3)
    {
      AppMethodBeat.o(183081);
      return true;
    }
    AppMethodBeat.o(183081);
    return false;
  }
  
  public static final Context eA(Context paramContext)
  {
    AppMethodBeat.i(169667);
    p.k(paramContext, "$this$wrapScreenAdaptiveContextForRequestDialogIfNeed");
    if (!dh(paramContext))
    {
      AppMethodBeat.o(169667);
      return paramContext;
    }
    paramContext = (Context)new com.tencent.luggage.j.a(paramContext, (com.tencent.luggage.j.a.b)d.rsL);
    AppMethodBeat.o(169667);
    return paramContext;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(View paramView, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/util/DisplayMetrics;", "originalMetrics", "<anonymous parameter 1>", "Landroid/content/res/Configuration;", "applyScreenAdaptiveDensity"})
  static final class d
    implements com.tencent.luggage.j.a.b
  {
    public static final d rsL;
    
    static
    {
      AppMethodBeat.i(169664);
      rsL = new d();
      AppMethodBeat.o(169664);
    }
    
    public final DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
    {
      AppMethodBeat.i(169663);
      p.k(paramDisplayMetrics, "originalMetrics");
      p.k(paramConfiguration, "<anonymous parameter 1>");
      int i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      Math.max(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      float f1;
      if (i / paramDisplayMetrics.density >= 600.0F) {
        f1 = i / 600.0F;
      }
      for (;;)
      {
        float f2 = paramDisplayMetrics.scaledDensity / paramDisplayMetrics.density;
        i = Math.round(160.0F * f1);
        paramConfiguration = new DisplayMetrics();
        paramConfiguration.setTo(paramDisplayMetrics);
        paramConfiguration.scaledDensity = (f2 * f1);
        paramConfiguration.densityDpi = i;
        paramConfiguration.density = f1;
        AppMethodBeat.o(169663);
        return paramConfiguration;
        if (i / paramDisplayMetrics.density <= 240.0F) {
          f1 = i / 240.0F;
        } else {
          f1 = i / 450.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.m
 * JD-Core Version:    0.7.0.1
 */