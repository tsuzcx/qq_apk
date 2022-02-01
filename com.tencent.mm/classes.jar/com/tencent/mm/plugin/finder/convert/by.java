package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "deletedTip", "Landroid/view/View;", "getDeletedTip", "()Landroid/view/View;", "setDeletedTip", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "getLayoutId", "", "initViews", "itemView", "isSelf", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class by
  extends e<BaseFinderFeed>
{
  public ImageView dKU;
  public TextView hOf;
  public TextView hPW;
  private ValueAnimator luz;
  public View tFA;
  public FinderPostProgressView tFB;
  public View tFC;
  public View tFD;
  public View tFE;
  private TextView tFF;
  private View tFG;
  private ImageView tFH;
  public Boolean tFI;
  private final f tFJ;
  private WeImageView tFv;
  public ImageIndicatorView tFw;
  public FinderLiveOnliveWidget tFx;
  public FinderLiveOnliveWidget tFy;
  public ImageView tFz;
  public View thM;
  
  public by()
  {
    AppMethodBeat.i(243244);
    this.tFJ = kotlin.g.ah((a)by.b.tFL);
    AppMethodBeat.o(243244);
  }
  
  private final Point cZM()
  {
    AppMethodBeat.i(243239);
    Point localPoint = (Point)this.tFJ.getValue();
    AppMethodBeat.o(243239);
    return localPoint;
  }
  
  private final void g(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(243242);
    TextView localTextView = this.tFF;
    if (localTextView != null)
    {
      localTextView.setBackgroundColor(2131099665);
      if (paramBaseFinderFeed.markRead) {}
      for (int i = 0;; i = 8)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(243242);
        return;
      }
    }
    AppMethodBeat.o(243242);
  }
  
  private final boolean h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(243243);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; (n.I(paramBaseFinderFeed, z.aUg(), false)) && (p.j(this.tFI, Boolean.TRUE)); paramBaseFinderFeed = null)
    {
      AppMethodBeat.o(243243);
      return true;
    }
    AppMethodBeat.o(243243);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243240);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243240);
  }
  
  public final FinderPostProgressView cZL()
  {
    AppMethodBeat.i(243238);
    FinderPostProgressView localFinderPostProgressView = this.tFB;
    if (localFinderPostProgressView == null) {
      p.btv("progress");
    }
    AppMethodBeat.o(243238);
    return localFinderPostProgressView;
  }
  
  public final int getLayoutId()
  {
    return 2131494588;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(by paramby) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(243235);
      FinderPostProgressView localFinderPostProgressView = this.tFK.cZL();
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(243235);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.tFK.cZL().invalidate();
      AppMethodBeat.o(243235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.by
 * JD-Core Version:    0.7.0.1
 */