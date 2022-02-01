package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.view.EllipsizedTextView;
import com.tencent.mm.plugin.finder.view.FadeOutLinearLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "showFollowAnim", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "needAnim", "", "onClickFollow", "Lkotlin/Function0;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends UIComponent
{
  public static final a GQb;
  private static final kotlin.j<Integer> GQc;
  private static final kotlin.j<Integer> GQd;
  private static final kotlin.j<Integer> GQe;
  private static final kotlin.j<Integer> GQf;
  
  static
  {
    AppMethodBeat.i(338088);
    GQb = new a((byte)0);
    GQc = k.cm((kotlin.g.a.a)c.GQh);
    GQd = k.cm((kotlin.g.a.a)e.GQj);
    GQe = k.cm((kotlin.g.a.a)b.GQg);
    GQf = k.cm((kotlin.g.a.a)d.GQi);
    AppMethodBeat.o(338088);
  }
  
  public y(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337969);
    AppMethodBeat.o(337969);
  }
  
  private static final void a(ah.d paramd, View paramView1, View paramView2, ah.a parama, com.tencent.mm.view.recyclerview.j paramj, FrameLayout paramFrameLayout, long paramLong)
  {
    AppMethodBeat.i(337993);
    s.u(paramd, "$headerBarWidth");
    s.u(parama, "$hasShrinkText");
    s.u(paramj, "$holder");
    paramd.aixb = (paramView1.getWidth() + paramView2.getWidth() + a.fnF());
    if (parama.aiwY)
    {
      paramView1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
        break label292;
      }
    }
    label292:
    for (paramView1 = paramj.UH(e.e.icon_feed_star_first);; paramView1 = paramj.UH(e.e.icon_feed_share))
    {
      s.s(paramView1, "leftIcon");
      int i = com.tencent.mm.ae.d.cZ(paramView1)[0];
      s.s(paramFrameLayout, "feedHeaderBar");
      i -= com.tencent.mm.ae.d.cZ((View)paramFrameLayout)[0] + paramd.aixb;
      if (i < a.fnG())
      {
        paramd.aixb = (i + paramd.aixb - a.fnG());
        paramView1 = (FadeOutLinearLayout)paramFrameLayout.findViewById(e.e.content_layout);
        if (paramView1 != null)
        {
          i = paramView1.getWidth();
          int j = paramFrameLayout.findViewById(e.e.avatar_iv).getWidth();
          int k = a.fnF();
          paramView1.ax(paramView2.getWidth() + a.fnF() - (paramd.aixb - (i + j + k * 2)) + (paramView2.getWidth() + a.fnF()), paramLong);
        }
      }
      Log.i("FinderFollowAnimUIC", "showFollowAnim: feedId = " + com.tencent.mm.ae.d.hF(paramLong) + ", hasShrinkText = " + parama.aiwY + ", headerBarWidth = " + paramd.aixb);
      paramFrameLayout.getLayoutParams().width = paramd.aixb;
      paramFrameLayout.requestLayout();
      AppMethodBeat.o(337993);
      return;
    }
  }
  
  private static final void a(boolean[] paramArrayOfBoolean, kotlin.g.a.a parama, TextView paramTextView, y paramy, View paramView1, View paramView2, com.tencent.mm.view.recyclerview.j paramj, View paramView3)
  {
    AppMethodBeat.i(338026);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramArrayOfBoolean);
    localb.cH(parama);
    localb.cH(paramTextView);
    localb.cH(paramy);
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramj);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramArrayOfBoolean, "$followOnTouchDownCalled");
    s.u(parama, "$onClickFollow");
    s.u(paramy, "this$0");
    s.u(paramj, "$holder");
    if (paramArrayOfBoolean[0] != 0) {
      paramArrayOfBoolean[0] = false;
    }
    for (;;)
    {
      parama.invoke();
      paramTextView.setText(e.h.has_follow_tip);
      paramTextView.setTextColor(paramy.getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
      paramView1.setVisibility(8);
      paramView2.setBackground(paramj.context.getDrawable(e.d.finder_feed_has_followed_btn_bg));
      int i = paramj.context.getResources().getDimensionPixelOffset(e.c.Edge_A);
      paramView2.setPadding(i, paramView2.getPaddingTop(), i, paramView2.getPaddingBottom());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("view_clk", paramView3, null, 24617);
      paramView2.setOnClickListener(null);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338026);
      return;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_follow", "<FeedFollow>");
      paramArrayOfBoolean = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_follow", paramArrayOfBoolean);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_follow");
    }
  }
  
  private static final boolean f(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(338008);
    s.u(paramArrayOfBoolean, "$followOnTouchDownCalled");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(338008);
      return false;
      paramArrayOfBoolean[0] = true;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_follow", "<FeedFollow>");
      continue;
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_follow", paramMotionEvent);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_follow");
    }
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, long paramLong, boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(338166);
    s.u(paramj, "holder");
    s.u(parama, "onClickFollow");
    Object localObject2 = (FrameLayout)paramj.UH(e.e.feedHeaderBar);
    View localView = ((FrameLayout)localObject2).findViewById(e.e.follow_btn);
    if (localView.getVisibility() == 0)
    {
      AppMethodBeat.o(338166);
      return;
    }
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(localView, "finder_feed_follow");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(localView, 8, 24617);
    Object localObject3 = ((FrameLayout)localObject2).findViewById(e.e.feed_header_content);
    ah.d locald = new ah.d();
    locald.aixb = (((View)localObject3).getWidth() + localView.getWidth() + a.fnF());
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() == 1)
    {
      localObject1 = paramj.UH(e.e.icon_feed_star_first);
      s.s(localObject1, "leftIcon");
      int i = com.tencent.mm.ae.d.cZ(localObject1)[0];
      s.s(localObject2, "feedHeaderBar");
      int j = com.tencent.mm.ae.d.cZ((View)localObject2)[0];
      int k = locald.aixb;
      localObject1 = new ah.a();
      if (i - (j + k) < a.fnG())
      {
        ((EllipsizedTextView)((FrameLayout)localObject2).findViewById(e.e.nickname)).setTextSize(0, ((FrameLayout)localObject2).getContext().getResources().getDimension(e.c.FootnoteextSize));
        ((ah.a)localObject1).aiwY = true;
      }
      ((FrameLayout)localObject2).post(new y..ExternalSyntheticLambda2(locald, (View)localObject3, localView, (ah.a)localObject1, paramj, (FrameLayout)localObject2, paramLong));
      localObject1 = ((FrameLayout)localObject2).findViewById(e.e.follow_btn_icon);
      localObject2 = (TextView)((FrameLayout)localObject2).findViewById(e.e.follow_btn_tv);
      localObject3 = new boolean[1];
      localObject3[0] = 0;
      localView.setOnTouchListener(new y..ExternalSyntheticLambda1((boolean[])localObject3));
      localView.setOnClickListener(new y..ExternalSyntheticLambda0((boolean[])localObject3, parama, (TextView)localObject2, this, (View)localObject1, localView, paramj));
      localView.setVisibility(0);
      if (!paramBoolean) {
        break label474;
      }
      localView.setAlpha(0.0F);
      localView.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new f(localView)).start();
      label413:
      parama = bb.FuK;
      parama = as.GSQ;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label483;
      }
    }
    label474:
    label483:
    for (paramj = null;; paramj = paramj.fou())
    {
      bb.a(paramj, "follow", true, paramLong);
      AppMethodBeat.o(338166);
      return;
      localObject1 = paramj.UH(e.e.icon_feed_share);
      break;
      localView.setAlpha(1.0F);
      break label413;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC$Companion;", "", "()V", "DURATION", "", "TAG", "", "feedHeaderBarWidthMin", "", "getFeedHeaderBarWidthMin", "()I", "feedHeaderBarWidthMin$delegate", "Lkotlin/Lazy;", "followBtnMargin", "getFollowBtnMargin", "followBtnMargin$delegate", "headerBarMargin", "getHeaderBarMargin", "headerBarMargin$delegate", "shrinkTextSizeThreshold", "getShrinkTextSizeThreshold", "shrinkTextSizeThreshold$delegate", "checkDisToShare", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "resetHeaderLayout", "feedHeaderBar", "Landroid/widget/FrameLayout;", "feedId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void X(com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(338474);
      s.u(paramj, "holder");
      View localView = paramj.UH(e.e.feedHeaderBar);
      if (localView != null) {
        localView.post(new y.a..ExternalSyntheticLambda0(localView, paramj));
      }
      AppMethodBeat.o(338474);
    }
    
    private static final void b(View paramView, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(338482);
      s.u(paramj, "$holder");
      View localView = paramView.findViewById(e.e.feed_header_content);
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() == 1) {}
      int j;
      int k;
      for (paramj = paramj.UH(e.e.icon_feed_star_first);; paramj = paramj.UH(e.e.icon_feed_share))
      {
        s.s(paramj, "leftIcon");
        j = com.tencent.mm.ae.d.cZ(paramj)[0];
        s.s(paramView, "feedHeaderBar");
        k = com.tencent.mm.ae.d.cZ(paramView)[0];
        if ((j > 0) && (k > 0)) {
          break;
        }
        AppMethodBeat.o(338482);
        return;
      }
      int m = localView.getWidth();
      int i = paramView.getLayoutParams().width;
      paramj = y.GQb;
      if (i > ((Number)y.fnD().getValue()).intValue()) {}
      for (;;)
      {
        if (i > 0) {
          paramView.getLayoutParams().width = i;
        }
        paramView.requestLayout();
        AppMethodBeat.o(338482);
        return;
        i = localView.getWidth();
        paramj = y.GQb;
        i = i + (j - (k + m)) - ((Number)y.fnE().getValue()).intValue();
      }
    }
    
    public static int fnF()
    {
      AppMethodBeat.i(338457);
      int i = ((Number)y.fnB().getValue()).intValue();
      AppMethodBeat.o(338457);
      return i;
    }
    
    public static int fnG()
    {
      AppMethodBeat.i(338463);
      int i = ((Number)y.fnC().getValue()).intValue();
      AppMethodBeat.o(338463);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b GQg;
    
    static
    {
      AppMethodBeat.i(338470);
      GQg = new b();
      AppMethodBeat.o(338470);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c GQh;
    
    static
    {
      AppMethodBeat.i(338453);
      GQh = new c();
      AppMethodBeat.o(338453);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final d GQi;
    
    static
    {
      AppMethodBeat.i(338448);
      GQi = new d();
      AppMethodBeat.o(338448);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final e GQj;
    
    static
    {
      AppMethodBeat.i(338420);
      GQj = new e();
      AppMethodBeat.o(338420);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC$showFollowAnim$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338425);
      this.GQk.setAlpha(1.0F);
      AppMethodBeat.o(338425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.y
 * JD-Core Version:    0.7.0.1
 */