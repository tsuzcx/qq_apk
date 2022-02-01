package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.m.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "shouldInLargeScreenCompatMode", "", "isShowingUserAgreement", "getAppropriateLargeScreenRequestDialogWidth", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "onPreDrawOnce", "block", "Lkotlin/Function0;", "postRequestLayout", "wrapScreenAdaptiveContextForRequestDialogIfNeed", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t uFu;
  
  static
  {
    AppMethodBeat.i(148269);
    uFu = new t();
    AppMethodBeat.o(148269);
  }
  
  public static final int Y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(169666);
    s.u(paramContext, "context");
    int i = paramContext.getResources().getDimensionPixelSize(a.b.authorize_bottom_dialog_width_landscape);
    int j = Math.max(i, paramContext.getResources().getDisplayMetrics().widthPixels / 2);
    if (paramInt < i) {}
    for (;;)
    {
      paramInt = Math.min(i, paramContext.getResources().getDisplayMetrics().widthPixels);
      AppMethodBeat.o(169666);
      return paramInt;
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
  }
  
  private static final DisplayMetrics a(DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    AppMethodBeat.i(324695);
    s.u(paramDisplayMetrics, "originalMetrics");
    s.u(paramConfiguration, "$noName_1");
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
      AppMethodBeat.o(324695);
      return paramConfiguration;
      if (i / paramDisplayMetrics.density <= 240.0F) {
        f1 = i / 240.0F;
      } else {
        f1 = i / 450.0F;
      }
    }
  }
  
  public static void a(final Context paramContext, View paramView1, View paramView2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(324679);
    s.u(paramContext, "context");
    s.u(paramView1, "rootView");
    Object localObject1;
    Object localObject2;
    if (paramView2 == null)
    {
      localObject1 = null;
      switch (paramInt)
      {
      case 2: 
      default: 
        if (paramView2 == null) {
          localObject2 = null;
        }
        break;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof RelativeLayout))
      {
        if (localObject1 == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(324679);
          throw paramContext;
          localObject1 = paramView2.getLayoutParams();
          break;
          if (paramView2 == null) {
            paramView2 = null;
          }
          while ((paramView2 instanceof RelativeLayout)) {
            if (localObject1 == null)
            {
              paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(324679);
              throw paramContext;
              paramView2 = paramView2.getParent();
            }
            else
            {
              paramView2 = (RelativeLayout.LayoutParams)localObject1;
              localObject1 = paramContext.getResources();
              if (!paramBoolean2) {
                break label215;
              }
            }
          }
          label215:
          for (paramInt = a.b.authorize_bottom_dialog_bottom_margin_bottom_user_agreement_visible;; paramInt = a.b.authorize_bottom_dialog_bottom_margin_bottom_landscape)
          {
            paramView2.bottomMargin = ((Resources)localObject1).getDimensionPixelSize(paramInt);
            if (paramBoolean1) {
              break;
            }
            paramView2 = paramView1.getLayoutParams();
            paramView2.width = paramContext.getResources().getDimensionPixelSize(a.b.authorize_bottom_dialog_width_landscape);
            paramContext = ah.aiuX;
            paramView1.setLayoutParams(paramView2);
            AppMethodBeat.o(324679);
            return;
          }
          localObject2 = paramView2.getParent();
          continue;
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject1;
        Resources localResources = paramContext.getResources();
        if (!paramBoolean2) {
          break label356;
        }
        paramInt = a.b.authorize_bottom_dialog_bottom_margin_bottom_user_agreement_visible;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = localResources.getDimensionPixelSize(paramInt);
      }
    }
    if ((!paramBoolean1) && (fv(paramContext)))
    {
      localObject2 = (kotlin.g.a.a)new a(paramView1, paramContext);
      if (paramView1.getViewTreeObserver().isAlive()) {
        paramView1.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new t.b(paramView1, (kotlin.g.a.a)localObject2));
      }
      if (paramView2 == null) {
        paramView1 = localObject3;
      }
    }
    for (;;)
    {
      if ((paramView1 instanceof RelativeLayout))
      {
        if (localObject1 == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(324679);
          throw paramContext;
          label356:
          paramInt = a.b.authorize_bottom_dialog_bottom_margin_bottom_portrait;
          break;
          paramView1 = paramView2.getParent();
          continue;
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = paramContext.getResources().getDimensionPixelSize(a.b.authorize_bottom_dialog_bottom_margin_bottom_landscape);
        AppMethodBeat.o(324679);
        return;
        paramContext = paramView1.getLayoutParams();
        paramContext.width = -1;
        paramView2 = ah.aiuX;
        paramView1.setLayoutParams(paramContext);
      }
    }
    AppMethodBeat.o(324679);
  }
  
  private static final void dZ(View paramView)
  {
    AppMethodBeat.i(324690);
    s.u(paramView, "$this_postRequestLayout");
    paramView.requestLayout();
    AppMethodBeat.o(324690);
  }
  
  private static boolean fv(Context paramContext)
  {
    AppMethodBeat.i(183081);
    if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3)
    {
      AppMethodBeat.o(183081);
      return true;
    }
    AppMethodBeat.o(183081);
    return false;
  }
  
  public static final Context fw(Context paramContext)
  {
    AppMethodBeat.i(169667);
    s.u(paramContext, "<this>");
    if (!fv(paramContext))
    {
      AppMethodBeat.o(169667);
      return paramContext;
    }
    paramContext = (Context)new com.tencent.luggage.k.a(paramContext, t..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(169667);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(View paramView, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.t
 * JD-Core Version:    0.7.0.1
 */