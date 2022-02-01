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
import com.tencent.luggage.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "shouldInLargeScreenCompatMode", "", "getAppropriateLargeScreenRequestDialogWidth", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "onPreDrawOnce", "block", "Lkotlin/Function0;", "postRequestLayout", "wrapScreenAdaptiveContextForRequestDialogIfNeed", "luggage-wechat-full-sdk_release"})
public final class n
{
  public static final n swJ;
  
  static
  {
    AppMethodBeat.i(148269);
    swJ = new n();
    AppMethodBeat.o(148269);
  }
  
  public static final int K(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(169666);
    p.h(paramContext, "context");
    int i = paramContext.getResources().getDimensionPixelSize(2131165885);
    Resources localResources = paramContext.getResources();
    p.g(localResources, "context.resources");
    int j = Math.max(i, localResources.getDisplayMetrics().widthPixels / 2);
    if (paramInt < i) {}
    for (;;)
    {
      paramContext = paramContext.getResources();
      p.g(paramContext, "context.resources");
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
    p.h(paramContext, "context");
    p.h(paramView1, "rootView");
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView2 != null)
    {
      localLayoutParams = paramView2.getLayoutParams();
      if ((paramInt != 1) && (paramInt != 3)) {
        break label140;
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
          paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(183080);
          throw paramContext;
          localLayoutParams = null;
          break;
          label84:
          paramView2 = null;
          continue;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131165882);
      }
    }
    if (!paramBoolean)
    {
      paramView2 = paramView1.getLayoutParams();
      paramView2.width = paramContext.getResources().getDimensionPixelSize(2131165885);
      paramView1.setLayoutParams(paramView2);
      AppMethodBeat.o(183080);
      return;
      label140:
      Object localObject1;
      if (paramView2 != null) {
        localObject1 = paramView2.getParent();
      }
      while ((localObject1 instanceof RelativeLayout)) {
        if (localLayoutParams == null)
        {
          paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(183080);
          throw paramContext;
          localObject1 = null;
        }
        else
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131165883);
        }
      }
      if ((!paramBoolean) && (cN(paramContext)))
      {
        localObject1 = (d.g.a.a)new a(paramView1, paramContext);
        ViewTreeObserver localViewTreeObserver = paramView1.getViewTreeObserver();
        p.g(localViewTreeObserver, "this.viewTreeObserver");
        if (localViewTreeObserver.isAlive()) {
          paramView1.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b(paramView1, (d.g.a.a)localObject1));
        }
        paramView1 = localObject2;
        if (paramView2 != null) {
          paramView1 = paramView2.getParent();
        }
        if ((paramView1 instanceof RelativeLayout))
        {
          if (localLayoutParams == null)
          {
            paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(183080);
            throw paramContext;
          }
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131165882);
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
  
  public static final Context bq(Context paramContext)
  {
    AppMethodBeat.i(169667);
    p.h(paramContext, "$this$wrapScreenAdaptiveContextForRequestDialogIfNeed");
    if (!cN(paramContext))
    {
      AppMethodBeat.o(169667);
      return paramContext;
    }
    paramContext = (Context)new com.tencent.luggage.g.a(paramContext, (a.b)d.ncf);
    AppMethodBeat.o(169667);
    return paramContext;
  }
  
  private static boolean cN(Context paramContext)
  {
    AppMethodBeat.i(183081);
    paramContext = paramContext.getResources();
    p.g(paramContext, "this.resources");
    if ((paramContext.getConfiguration().screenLayout & 0xF) >= 3)
    {
      AppMethodBeat.o(183081);
      return true;
    }
    AppMethodBeat.o(183081);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(View paramView, Context paramContext)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "luggage-wechat-full-sdk_release"})
  public static final class b
    implements ViewTreeObserver.OnPreDrawListener
  {
    b(View paramView, d.g.a.a parama) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(169661);
      ViewTreeObserver localViewTreeObserver = this.iDM.getViewTreeObserver();
      p.g(localViewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
      if (localViewTreeObserver.isAlive()) {
        this.iDM.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
      this.gFS.invoke();
      AppMethodBeat.o(169661);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(169662);
      this.iDN.requestLayout();
      AppMethodBeat.o(169662);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/util/DisplayMetrics;", "originalMetrics", "<anonymous parameter 1>", "Landroid/content/res/Configuration;", "applyScreenAdaptiveDensity"})
  static final class d
    implements a.b
  {
    public static final d ncf;
    
    static
    {
      AppMethodBeat.i(169664);
      ncf = new d();
      AppMethodBeat.o(169664);
    }
    
    public final DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
    {
      AppMethodBeat.i(169663);
      p.h(paramDisplayMetrics, "originalMetrics");
      p.h(paramConfiguration, "<anonymous parameter 1>");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n
 * JD-Core Version:    0.7.0.1
 */