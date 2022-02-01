package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderGridViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "failedArea", "getFailedArea", "()Landroid/view/View;", "setFailedArea", "likeArea", "getLikeArea", "setLikeArea", "likeImgview", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeImgview", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeImgview", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "bindMedia", "", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "dealLickArea", "context", "Landroid/content/Context;", "refreshLickArea", "isActionLike", "plugin-finder_release"})
public final class af
  extends RecyclerView.v
{
  private WeImageView KLl;
  private ValueAnimator jsS;
  private View qhs;
  FinderPostProgressView qrJ;
  private View qrK;
  private View qrS;
  
  public af(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(197455);
    View localView = paramView.findViewById(2131303504);
    k.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.qhs = localView;
    localView = paramView.findViewById(2131303466);
    k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.qrK = localView;
    localView = paramView.findViewById(2131303466);
    k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.qrK = localView;
    localView = paramView.findViewById(2131303505);
    k.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.qrJ = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131307824);
    k.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.qrS = localView;
    paramView = paramView.findViewById(2131307825);
    k.g(paramView, "itemView.findViewById(R.id.profile_like_iv)");
    this.KLl = ((WeImageView)paramView);
    AppMethodBeat.o(197455);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197451);
      this.qrR.invoke();
      AppMethodBeat.o(197451);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(af paramaf) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(197452);
      FinderPostProgressView localFinderPostProgressView = this.KLm.qrJ;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(197452);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.KLm.qrJ.invalidate();
      AppMethodBeat.o(197452);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c KLn;
    
    static
    {
      AppMethodBeat.i(197453);
      KLn = new c();
      AppMethodBeat.o(197453);
    }
    
    public final void onClick(View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */