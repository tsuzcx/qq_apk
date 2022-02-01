package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIPlainTextViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "()Landroid/view/View;", "setFailedArea", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "bindPlainText", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "fromSearch", "", "itemClickListener", "Lkotlin/Function0;", "plugin-finder_release"})
public final class z
  extends RecyclerView.v
{
  private TextView lEA;
  private View qhs;
  private FinderPostProgressView qrJ;
  private View qrK;
  private TextView qrL;
  private View qrS;
  
  public z(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165501);
    View localView = paramView.findViewById(2131303465);
    k.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.lEA = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    k.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.qrJ = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    k.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.qhs = localView;
    localView = paramView.findViewById(2131303466);
    k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.qrK = localView;
    localView = paramView.findViewById(2131301411);
    k.g(localView, "itemView.findViewById(R.id.like_area)");
    this.qrS = localView;
    paramView = paramView.findViewById(2131303471);
    k.g(paramView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.qrL = ((TextView)paramView);
    AppMethodBeat.o(165501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.z
 * JD-Core Version:    0.7.0.1
 */