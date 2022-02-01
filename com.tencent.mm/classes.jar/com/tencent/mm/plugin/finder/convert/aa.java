package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderGridViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "failedArea", "getFailedArea", "()Landroid/view/View;", "setFailedArea", "likeArea", "getLikeArea", "setLikeArea", "likeImgview", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeImgview", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeImgview", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "bindMedia", "", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "dealLickArea", "context", "Landroid/content/Context;", "refreshLickArea", "isActionLike", "plugin-finder_release"})
public final class aa
  extends RecyclerView.w
{
  private ValueAnimator knA;
  private View rOH;
  FinderPostProgressView rOI;
  private View rOJ;
  private WeImageView rOK;
  private View rzU;
  
  public aa(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(201418);
    View localView = paramView.findViewById(2131303504);
    p.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.rzU = localView;
    localView = paramView.findViewById(2131303466);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rOH = localView;
    localView = paramView.findViewById(2131303466);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rOH = localView;
    localView = paramView.findViewById(2131303505);
    p.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rOI = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131307916);
    p.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.rOJ = localView;
    paramView = paramView.findViewById(2131307917);
    p.g(paramView, "itemView.findViewById(R.id.profile_like_iv)");
    this.rOK = ((WeImageView)paramView);
    AppMethodBeat.o(201418);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(aa paramaa) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201414);
      FinderPostProgressView localFinderPostProgressView = this.rOM.rOI;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201414);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rOM.rOI.invalidate();
      AppMethodBeat.o(201414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */