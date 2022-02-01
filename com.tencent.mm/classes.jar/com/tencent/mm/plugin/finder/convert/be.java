package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIPlainTextViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "()Landroid/view/View;", "setFailedArea", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "bindPlainText", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "fromSearch", "", "itemClickListener", "Lkotlin/Function0;", "plugin-finder_release"})
public final class be
  extends RecyclerView.w
{
  private TextView gVl;
  private TextView gXb;
  private View rIf;
  private View rXh;
  private FinderPostProgressView rXi;
  private View rXj;
  
  public be(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165501);
    View localView = paramView.findViewById(2131303465);
    p.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.gXb = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    p.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rXi = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    p.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.rIf = localView;
    localView = paramView.findViewById(2131303466);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rXh = localView;
    localView = paramView.findViewById(2131301411);
    p.g(localView, "itemView.findViewById(R.id.like_area)");
    this.rXj = localView;
    paramView = paramView.findViewById(2131303471);
    p.g(paramView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.gVl = ((TextView)paramView);
    AppMethodBeat.o(165501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.be
 * JD-Core Version:    0.7.0.1
 */