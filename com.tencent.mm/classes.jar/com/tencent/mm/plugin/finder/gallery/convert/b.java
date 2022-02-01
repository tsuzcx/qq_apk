package com.tencent.mm.plugin.finder.gallery.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/convert/MaskUILogic;", "", "()V", "refresh", "", "itemView", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "validType", "", "forceDark", "plugin-finder_release"})
public final class b
{
  public static final b xUn;
  
  static
  {
    AppMethodBeat.i(289319);
    xUn = new b();
    AppMethodBeat.o(289319);
  }
  
  public static void a(View paramView, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(289318);
    p.k(paramView, "itemView");
    p.k(paramBaseFinderFeed, "item");
    View localView2 = paramView.findViewById(b.f.post_failed_layout);
    View localView3 = paramView.findViewById(b.f.post_progress_layout);
    View localView1 = paramView.findViewById(b.f.type_invalid_layout);
    if (localView2 != null)
    {
      localObject1 = localView2.getParent();
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      if (localView3 != null) {
        localView3.setVisibility(8);
      }
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      if (localObject1 != null)
      {
        localObject2 = paramView.getContext();
        p.j(localObject2, "itemView.context");
        ((ViewGroup)localObject1).setBackgroundColor(((Context)localObject2).getResources().getColor(b.c.finder_live_black_Alpha_60));
      }
      if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
        break label291;
      }
      if (localView2 != null) {
        localView2.setVisibility(0);
      }
      if (localView2 == null) {
        break label254;
      }
    }
    label254:
    for (Object localObject1 = (TextView)localView2.findViewById(b.f.failed_desc_tv);; localObject1 = null)
    {
      if (localObject1 != null) {
        ((TextView)localObject1).setTextSize(0, com.tencent.mm.ci.a.fromDPToPix(paramView.getContext(), 14));
      }
      if (!paramBaseFinderFeed.feedObject.isPostFailedCanRetry()) {
        break label266;
      }
      if (localObject1 == null) {
        break label260;
      }
      ((TextView)localObject1).setText(b.j.finder_posting_failed_select_tips1);
      AppMethodBeat.o(289318);
      return;
      localObject1 = null;
      break;
    }
    label260:
    AppMethodBeat.o(289318);
    return;
    label266:
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(b.j.finder_item_post_fail);
      AppMethodBeat.o(289318);
      return;
    }
    AppMethodBeat.o(289318);
    return;
    label291:
    if (paramBaseFinderFeed.feedObject.isPostFinish())
    {
      if (paramBoolean1)
      {
        if (localObject1 != null)
        {
          ((ViewGroup)localObject1).setVisibility(8);
          AppMethodBeat.o(289318);
          return;
        }
        AppMethodBeat.o(289318);
        return;
      }
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
      if ((ar.isDarkMode()) || (paramBoolean2)) {
        if (localObject1 != null)
        {
          paramBaseFinderFeed = paramView.getContext();
          p.j(paramBaseFinderFeed, "itemView.context");
          ((ViewGroup)localObject1).setBackgroundColor(paramBaseFinderFeed.getResources().getColor(b.c.BW_100_Alpha_0_0_5));
        }
      }
      while (localView1 != null)
      {
        localView1.setOnClickListener((View.OnClickListener)new a(paramView));
        AppMethodBeat.o(289318);
        return;
        if (localObject1 != null)
        {
          paramBaseFinderFeed = paramView.getContext();
          p.j(paramBaseFinderFeed, "itemView.context");
          ((ViewGroup)localObject1).setBackgroundColor(paramBaseFinderFeed.getResources().getColor(b.c.UN_BW_0_Alpha_0_1));
        }
      }
      AppMethodBeat.o(289318);
      return;
    }
    if (localView3 != null) {
      localView3.setVisibility(0);
    }
    if (localView3 != null)
    {
      paramView = (FinderPostProgressView)localView3.findViewById(b.f.progress_view);
      if (paramView != null)
      {
        paramBaseFinderFeed = ValueAnimator.ofInt(new int[] { paramView.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().TAi });
        paramBaseFinderFeed.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
        paramView = paramBaseFinderFeed.setDuration(400L);
        if (paramView != null)
        {
          paramView.start();
          AppMethodBeat.o(289318);
          return;
        }
        AppMethodBeat.o(289318);
        return;
      }
    }
    AppMethodBeat.o(289318);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275514);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/gallery/convert/MaskUILogic$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      w.cS(this.jLG.getContext(), this.jLG.getContext().getString(b.j.finder_media_type_invalid_tips));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/gallery/convert/MaskUILogic$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275514);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(266424);
      FinderPostProgressView localFinderPostProgressView = this.xiI;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(266424);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.xiI.invalidate();
      AppMethodBeat.o(266424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.convert.b
 * JD-Core Version:    0.7.0.1
 */