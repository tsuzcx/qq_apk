package com.tencent.mm.plugin.finder.live.olympic;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsBulletClickPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "bulletListener", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$BulletCommentClickData;", "getBulletListener", "()Landroidx/lifecycle/Observer;", "danmuClickView", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "maxWidth", "", "getMaxWidth", "()I", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "animateToGone", "", "layout", "Landroid/view/View;", "delay", "", "bulletCommentInfo", "initDanmuClickView", "measureText", "Lkotlin/Pair;", "text", "", "tv", "Landroid/widget/TextView;", "mount", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "visitChild", "visitor", "Lkotlin/Function1;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final j.c COl;
  private static final int COn;
  private static final String TAG;
  private final FrameLayout COm;
  final MMActivity activity;
  private final y<n.a> agjE;
  private final int maxWidth;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(360534);
    COl = new j.c((byte)0);
    TAG = "Finder.FinderLiveOlympicsBulletClickPlugin";
    COn = 2;
    AppMethodBeat.o(360534);
  }
  
  public j(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360469);
    this.nfT = paramb;
    this.activity = paramMMActivity;
    this.COm = ((FrameLayout)paramViewGroup.findViewById(p.e.BWE));
    this.maxWidth = ((int)(bf.bf(paramViewGroup.getContext()).x * 2 / 3.0F - paramViewGroup.getContext().getResources().getDimension(p.c.Edge_5_5_A)));
    this.agjE = new j..ExternalSyntheticLambda1(this, paramViewGroup);
    tO(8);
    AppMethodBeat.o(360469);
  }
  
  private final void a(final View paramView, long paramLong, final n.a parama)
  {
    AppMethodBeat.i(360480);
    paramView.animate().setStartDelay(paramLong).setDuration(500L).alpha(0.0F).setListener((Animator.AnimatorListener)new e(this, paramView, parama)).start();
    AppMethodBeat.o(360480);
  }
  
  private static void a(ViewGroup paramViewGroup, kotlin.g.a.b<? super View, ah> paramb)
  {
    AppMethodBeat.i(360494);
    int i = 0;
    int k = paramViewGroup.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      if (localView != null) {
        paramb.invoke(localView);
      }
      if (j >= k)
      {
        AppMethodBeat.o(360494);
        return;
      }
      i = j;
    }
  }
  
  private static final void a(j paramj, ViewGroup paramViewGroup, n.a parama)
  {
    AppMethodBeat.i(371580);
    s.u(paramj, "this$0");
    s.u(paramViewGroup, "$root");
    int i;
    label70:
    float f1;
    float f2;
    Object localObject1;
    Object localObject2;
    label117:
    ImageView localImageView;
    label269:
    label320:
    int j;
    label435:
    float f4;
    if (parama != null) {
      if (!s.p(parama.Ehq, "")) {
        if (parama.Eho == -1.0F)
        {
          i = 1;
          if (i != 0) {
            break label823;
          }
          if (parama.Ehp != -1.0F) {
            break label723;
          }
          i = 1;
          if (i != 0) {
            break label823;
          }
          f1 = parama.Eho;
          f2 = parama.Ehp;
          localObject1 = parama.Ehq;
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label729;
          }
          i = 1;
          if (i != 0) {
            break label853;
          }
          localObject2 = paramj.COm;
          s.s(localObject2, "danmuClickView");
          a((ViewGroup)localObject2, (kotlin.g.a.b)new a(paramj));
          Object localObject3 = p.b(paramViewGroup.getContext(), (CharSequence)localObject1);
          localObject2 = View.inflate(paramViewGroup.getContext(), p.f.CeT, null);
          paramj.COm.addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
          localImageView = (ImageView)((View)localObject2).findViewById(p.e.Cbq);
          localObject1 = (TextView)((View)localObject2).findViewById(p.e.BYI);
          n.e locale = (n.e)((n)paramj.business(n.class)).Ehd.getValue();
          if ((locale == null) || (locale.EhJ != true)) {
            break label735;
          }
          i = 1;
          if (i == 0) {
            break label741;
          }
          localImageView.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.finder_olympics_star, paramViewGroup.getContext().getResources().getColor(p.b.finder_live_olympic_lighted_color)));
          ((TextView)localObject1).setTextColor(paramViewGroup.getContext().getResources().getColor(p.b.finder_live_olympic_lighted_color));
          ((TextView)localObject1).setMaxWidth(paramj.maxWidth);
          ((TextView)localObject1).setText((CharSequence)localObject3);
          s.s(localObject3, "text");
          localObject3 = (CharSequence)localObject3;
          s.s(localObject1, "danmuTv");
          i = paramj.maxWidth;
          localObject1 = new StaticLayout((CharSequence)localObject3, 0, ((CharSequence)localObject3).length(), ((TextView)localObject1).getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
          if (((StaticLayout)localObject1).getLineCount() <= 0) {
            break label795;
          }
          localObject1 = new r(Integer.valueOf((int)((StaticLayout)localObject1).getLineWidth(0)), Integer.valueOf(((StaticLayout)localObject1).getHeight()));
          j = ((Number)((r)localObject1).bsC).intValue();
          i = ((Number)((r)localObject1).bsD).intValue();
          j = (int)(j + paramViewGroup.getContext().getResources().getDimension(p.c.Edge_5_5_A));
          i = (int)(i + paramViewGroup.getContext().getResources().getDimension(p.c.Edge_2A));
          f4 = paramViewGroup.getContext().getResources().getDimension(p.c.Edge_2A);
          if (f1 >= f4) {
            break label863;
          }
          f1 = f4;
        }
      }
    }
    label723:
    label729:
    label863:
    for (;;)
    {
      if (f2 < 0.0F) {
        f2 = 0.0F;
      }
      for (;;)
      {
        float f3 = f1;
        if (j + f1 > paramj.COm.getWidth() - f4) {
          f3 = paramj.COm.getWidth() - f4 - j;
        }
        f1 = f2;
        if (i + f2 > paramj.COm.getHeight()) {
          f1 = paramj.COm.getHeight() - i;
        }
        ((View)localObject2).setX(f3);
        ((View)localObject2).setY(f1);
        ((View)localObject2).setVisibility(0);
        s.s(localObject2, "layout");
        paramj.a((View)localObject2, 3000L, parama);
        Log.i(TAG, "danmu targetX:" + f3 + ", targetY:" + f1 + ", " + paramj.COm.getVisibility() + ", " + ((View)localObject2).getVisibility());
        AppMethodBeat.o(371580);
        return;
        i = 0;
        break;
        i = 0;
        break label70;
        i = 0;
        break label117;
        label735:
        i = 0;
        break label269;
        label741:
        localImageView.clearColorFilter();
        localImageView.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.finder_olympics_star, paramViewGroup.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8)));
        ((TextView)localObject1).setTextColor(paramViewGroup.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
        break label320;
        localObject1 = new r(Integer.valueOf(((StaticLayout)localObject1).getWidth()), Integer.valueOf(((StaticLayout)localObject1).getHeight()));
        break label435;
        paramViewGroup = paramj.COm;
        s.s(paramViewGroup, "danmuClickView");
        a((ViewGroup)paramViewGroup, (kotlin.g.a.b)new b(paramj));
        AppMethodBeat.o(371580);
        return;
      }
    }
  }
  
  private static final void a(j paramj, Float paramFloat)
  {
    AppMethodBeat.i(360523);
    s.u(paramj, "this$0");
    if (paramFloat != null) {
      d.a(0L, (kotlin.g.a.a)new f(paramj, ((Number)paramFloat).floatValue()));
    }
    AppMethodBeat.o(360523);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(371584);
    super.mount();
    ((n)getBuContext().business(n.class)).Ehi.a((q)this.activity, this.agjE);
    AppMethodBeat.o(371584);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360552);
    s.u(paramc, "status");
    if (j.d.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      paramc = bj.GlQ;
      if ((bj.y(getBuContext())) && (!isLandscape()))
      {
        tO(0);
        ((n)business(n.class)).Ehn.a((q)this.activity, new j..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(360552);
        return;
      }
      tO(8);
    }
    AppMethodBeat.o(360552);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(360562);
    super.unMount();
    ((n)getBuContext().business(n.class)).Ehi.b(this.agjE);
    this.COm.removeAllViews();
    AppMethodBeat.o(360562);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsBulletClickPlugin$animateToGone$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(j paramj, View paramView, n.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(360509);
      j.a(this.COo).removeView(paramView);
      if (s.p(parama, ((n)this.COo.business(n.class)).Ehi.getValue())) {
        ((n)this.COo.business(n.class)).ezj();
      }
      AppMethodBeat.o(360509);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(360506);
      j.a(this.COo).removeView(paramView);
      if (s.p(parama, ((n)this.COo.business(n.class)).Ehi.getValue())) {
        ((n)this.COo.business(n.class)).ezj();
      }
      AppMethodBeat.o(360506);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(j paramj, float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.j
 * JD-Core Version:    0.7.0.1
 */