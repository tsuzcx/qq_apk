package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.widget.p;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "joinCallback", "Lkotlin/Function0;", "", "getJoinCallback", "()Lkotlin/jvm/functions/Function0;", "setJoinCallback", "(Lkotlin/jvm/functions/Function0;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "viewRoot$delegate", "Lkotlin/Lazy;", "visibleChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "getVisibleChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setVisibleChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "hide", "withAnimation", "fadeOut", "show", "rootView", "Landroid/view/ViewGroup;", "isLandscape", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
{
  private final j CSC;
  private kotlin.g.a.a<ah> CSD;
  private kotlin.g.a.b<? super Boolean, ah> CSE;
  private final String TAG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(360738);
    this.TAG = "FinderLiveOlympicsJoinWidget";
    this.CSC = k.cm((kotlin.g.a.a)new c(paramContext, this));
    AppMethodBeat.o(360738);
  }
  
  private static final void a(LiveBottomSheetPanel paramLiveBottomSheetPanel)
  {
    AppMethodBeat.i(360771);
    paramLiveBottomSheetPanel.show();
    AppMethodBeat.o(360771);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(360750);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360750);
      return;
    }
    parama.aa(true, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360750);
  }
  
  private static final void b(LiveBottomSheetPanel paramLiveBottomSheetPanel)
  {
    AppMethodBeat.i(360775);
    paramLiveBottomSheetPanel.hide();
    AppMethodBeat.o(360775);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(360756);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360756);
      return;
    }
    parama.aa(true, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360756);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(360765);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      Log.i(parama.getTAG(), "confirmBtn fast click!");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360765);
      return;
    }
    parama = parama.getJoinCallback();
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360765);
  }
  
  private final View getViewRoot()
  {
    AppMethodBeat.i(360742);
    Object localObject = this.CSC.getValue();
    s.s(localObject, "<get-viewRoot>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(360742);
    return localObject;
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(360858);
    Log.i(this.TAG, "hide withAnimation:" + paramBoolean1 + ",fadeOut:" + paramBoolean2);
    if (paramBoolean2)
    {
      animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new a(this));
      AppMethodBeat.o(360858);
      return;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = (LiveBottomSheetPanel)getViewRoot().findViewById(p.e.BVI);
      if (localObject != null)
      {
        ((LiveBottomSheetPanel)localObject).post(new a..ExternalSyntheticLambda4((LiveBottomSheetPanel)localObject));
        AppMethodBeat.o(360858);
      }
    }
    else
    {
      localObject = this.CSE;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)this);
    }
    AppMethodBeat.o(360858);
  }
  
  public final void e(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(360851);
    s.u(paramViewGroup, "rootView");
    setAlpha(1.0F);
    Object localObject = getViewRoot().findViewById(p.e.BVO);
    s.s(localObject, "viewRoot.findViewById(R.id.join_title)");
    setTextBold((TextView)localObject);
    boolean bool;
    if (paramViewGroup.indexOfChild((View)this) != -1)
    {
      bool = true;
      Log.i(this.TAG, "show isLandscape:" + paramBoolean + ",haveAttachToRootView:" + bool);
      if (!bool) {
        paramViewGroup.addView((View)this);
      }
      getViewRoot().findViewById(p.e.BYQ).setOnClickListener(new a..ExternalSyntheticLambda2(this));
      getViewRoot().findViewById(p.e.BYP).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      getViewRoot().findViewById(p.e.confirm_btn).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      paramViewGroup = (LiveBottomSheetPanel)getViewRoot().findViewById(p.e.BVI);
      if (!paramBoolean) {
        break label260;
      }
      paramViewGroup.getLayoutParams().width = bf.bf(paramViewGroup.getContext()).y;
      paramViewGroup.setTranslationX(bf.bf(paramViewGroup.getContext()).y);
    }
    for (;;)
    {
      paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new b(this));
      paramViewGroup.post(new a..ExternalSyntheticLambda3(paramViewGroup));
      AppMethodBeat.o(360851);
      return;
      bool = false;
      break;
      label260:
      localObject = (RoundCornerRelativeLayout)getViewRoot().findViewById(p.e.BVH);
      if (localObject != null) {
        ((RoundCornerRelativeLayout)localObject).A(getViewRoot().getContext().getResources().getDimension(p.c.Edge_1_5_A), getViewRoot().getContext().getResources().getDimension(p.c.Edge_1_5_A), 0.0F, 0.0F);
      }
      paramViewGroup.setTranslationY(bf.bf(paramViewGroup.getContext()).y);
    }
  }
  
  public final kotlin.g.a.a<ah> getJoinCallback()
  {
    return this.CSD;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getVisibleChangeCallback()
  {
    return this.CSE;
  }
  
  public final void setJoinCallback(kotlin.g.a.a<ah> parama)
  {
    this.CSD = parama;
  }
  
  public final void setVisibleChangeCallback(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.CSE = paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(360707);
      paramAnimator = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)this.CSF);
      AppMethodBeat.o(360707);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(Context paramContext, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.a
 * JD-Core Version:    0.7.0.1
 */