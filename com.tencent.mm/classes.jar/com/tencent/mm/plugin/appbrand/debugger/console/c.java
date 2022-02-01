package com.tencent.mm.plugin.appbrand.debugger.console;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "onShown", "Lkotlin/Function0;", "", "onHidden", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "isAnimating", "", "printer", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;", "getPrinter", "()Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;", "hide", "show", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends LinearLayout
{
  public static final c.a rfv;
  private boolean isAnimating;
  private final kotlin.g.a.a<ah> rfw;
  private final kotlin.g.a.a<ah> rfx;
  private final e rfy;
  
  static
  {
    AppMethodBeat.i(319840);
    rfv = new c.a((byte)0);
    AppMethodBeat.o(319840);
  }
  
  public c(Context paramContext, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2)
  {
    super(paramContext);
    AppMethodBeat.i(319787);
    this.rfw = parama1;
    this.rfx = parama2;
    setOrientation(1);
    setBackgroundColor(androidx.core.content.a.w(paramContext, ba.c.BG_0));
    setVisibility(4);
    post(new c..ExternalSyntheticLambda2(this));
    parama1 = new e(paramContext);
    addView((View)parama1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0F));
    parama2 = ah.aiuX;
    this.rfy = parama1;
    parama1 = new LinearLayout(paramContext);
    parama1.setOrientation(0);
    parama1.setBackgroundColor(androidx.core.content.a.w(paramContext, ba.c.BG_3));
    parama2 = new TextView(paramContext);
    parama2.setGravity(17);
    int i = com.tencent.mm.cd.a.bs(paramContext, ba.d.Edge_1_5_A);
    parama2.setPadding(0, i, 0, i);
    parama2.setTextColor(androidx.core.content.a.w(paramContext, ba.c.FG_0));
    parama2.setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallBtnTextSize));
    parama2.setText((CharSequence)"Clear");
    parama2.setOnClickListener(new c..ExternalSyntheticLambda0(this));
    parama1.addView((View)parama2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, -2, 1.0F));
    parama2 = new View(paramContext);
    i = com.tencent.mm.cd.a.bs(paramContext, ba.d.Edge_0_5_A);
    parama2.setPadding(0, i, 0, i);
    parama2.setBackgroundColor(androidx.core.content.a.w(paramContext, ba.c.FG_3));
    parama1.addView(parama2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(com.tencent.mm.cd.a.bs(paramContext, ba.d.Edge_0_1_2_5_A), -1));
    parama2 = new TextView(paramContext);
    parama2.setGravity(17);
    i = com.tencent.mm.cd.a.bs(paramContext, ba.d.Edge_1_5_A);
    parama2.setPadding(0, i, 0, i);
    parama2.setTextColor(androidx.core.content.a.w(paramContext, ba.c.FG_0));
    parama2.setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallBtnTextSize));
    parama2.setText((CharSequence)"Hide");
    parama2.setOnClickListener(new c..ExternalSyntheticLambda1(this));
    parama1.addView((View)parama2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, -2, 1.0F));
    addView((View)parama1, -1, -2);
    AppMethodBeat.o(319787);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(319794);
    s.u(paramc, "this$0");
    int i = paramc.getMeasuredHeight();
    Log.i("MicroMsg.AppBrand.ConsolePrintPanel", s.X("<init>, measured, measuredHeight: ", Integer.valueOf(i)));
    paramc.setTranslationY(i);
    paramc.setVisibility(0);
    paramc.show();
    AppMethodBeat.o(319794);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(319805);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onClick#clearTv");
    paramc = paramc.getPrinter();
    paramc.setText((CharSequence)"");
    paramc.rfH.clear();
    paramc.rfI = new SpannableStringBuilder();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(319805);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(319815);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onClick#hideTv");
    paramc.hide();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(319815);
  }
  
  public final e getPrinter()
  {
    return this.rfy;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(319863);
    float f = getTranslationY();
    boolean bool = this.isAnimating;
    Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "hide, curTranslationY: " + f + ", curIsAnimating: " + bool);
    if (getMeasuredHeight() == f) {}
    for (int i = 1; (i != 0) || (bool); i = 0)
    {
      AppMethodBeat.o(319863);
      return;
    }
    this.isAnimating = true;
    animate().translationY(getMeasuredHeight()).setDuration(300L).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setListener((Animator.AnimatorListener)new b(this));
    AppMethodBeat.o(319863);
  }
  
  public final void show()
  {
    AppMethodBeat.i(319860);
    float f = getTranslationY();
    boolean bool = this.isAnimating;
    Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "show, curTranslationY: " + f + ", curIsAnimating: " + bool);
    if (0.0F == f) {}
    for (int i = 1; (i != 0) || (bool); i = 0)
    {
      AppMethodBeat.o(319860);
      return;
    }
    this.isAnimating = true;
    animate().translationY(0.0F).setDuration(300L).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setListener((Animator.AnimatorListener)new c(this));
    AppMethodBeat.o(319860);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel$hide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(c paramc) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(319737);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationCancel#hide");
      c.b(this.rfz);
      paramAnimator = c.d(this.rfz);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(319737);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(319732);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationEnd#hide");
      c.b(this.rfz);
      paramAnimator = c.d(this.rfz);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(319732);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(319727);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationRepeat#hide");
      AppMethodBeat.o(319727);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(319718);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationStart#hide");
      AppMethodBeat.o(319718);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel$show$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(c paramc) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(319723);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationCancel#show");
      c.b(this.rfz);
      paramAnimator = c.c(this.rfz);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(319723);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(319719);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationEnd#show");
      c.b(this.rfz);
      paramAnimator = c.c(this.rfz);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(319719);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(319715);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationRepeat#show");
      AppMethodBeat.o(319715);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(319710);
      Log.i("MicroMsg.AppBrand.ConsolePrintPanel", "onAnimationStart#show");
      AppMethodBeat.o(319710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.c
 * JD-Core Version:    0.7.0.1
 */