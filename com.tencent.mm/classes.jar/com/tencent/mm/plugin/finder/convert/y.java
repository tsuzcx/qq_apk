package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderGridViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "failedArea", "getFailedArea", "()Landroid/view/View;", "setFailedArea", "likeArea", "getLikeArea", "setLikeArea", "likeImgview", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeImgview", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeImgview", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "bindMedia", "", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "dealLickArea", "context", "Landroid/content/Context;", "refreshLickArea", "isActionLike", "plugin-finder_release"})
public final class y
  extends RecyclerView.w
{
  private ValueAnimator jTm;
  private View qPU;
  private View rbU;
  FinderPostProgressView rbV;
  private View rbW;
  private WeImageView rbX;
  
  public y(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(201330);
    View localView = paramView.findViewById(2131303504);
    k.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.qPU = localView;
    localView = paramView.findViewById(2131303466);
    k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rbU = localView;
    localView = paramView.findViewById(2131303466);
    k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rbU = localView;
    localView = paramView.findViewById(2131303505);
    k.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rbV = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131307916);
    k.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.rbW = localView;
    paramView = paramView.findViewById(2131307917);
    k.g(paramView, "itemView.findViewById(R.id.profile_like_iv)");
    this.rbX = ((WeImageView)paramView);
    AppMethodBeat.o(201330);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(y paramy) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201327);
      FinderPostProgressView localFinderPostProgressView = this.rbZ.rbV;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201327);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rbZ.rbV.invalidate();
      AppMethodBeat.o(201327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */