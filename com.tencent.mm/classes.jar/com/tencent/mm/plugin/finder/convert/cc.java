package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "deletedTip", "Landroid/view/View;", "getDeletedTip", "()Landroid/view/View;", "setDeletedTip", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "getLayoutId", "", "initViews", "itemView", "isSelf", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class cc
  extends e<BaseFinderFeed>
{
  public ImageView fDJ;
  public TextView kCB;
  public TextView kEs;
  private ValueAnimator opx;
  public View wOd;
  private WeImageView xoe;
  public ImageIndicatorView xof;
  public FinderLiveOnliveWidget xog;
  public FinderLiveOnliveWidget xoh;
  public ImageView xoi;
  public View xoj;
  public FinderPostProgressView xok;
  public View xol;
  public View xom;
  public View xon;
  private TextView xoo;
  private View xop;
  private ImageView xoq;
  public Boolean xor;
  private final f xos;
  
  public cc()
  {
    AppMethodBeat.i(271439);
    this.xos = g.ar((a)cc.b.xou);
    AppMethodBeat.o(271439);
  }
  
  private final Point dpI()
  {
    AppMethodBeat.i(271434);
    Point localPoint = (Point)this.xos.getValue();
    AppMethodBeat.o(271434);
    return localPoint;
  }
  
  private final void i(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(271437);
    TextView localTextView = this.xoo;
    if (localTextView != null)
    {
      localTextView.setBackgroundColor(b.c.BW_0_Alpha_0_5);
      if (paramBaseFinderFeed.markRead) {}
      for (int i = 0;; i = 8)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(271437);
        return;
      }
    }
    AppMethodBeat.o(271437);
  }
  
  private final boolean j(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(271438);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; (n.L(paramBaseFinderFeed, z.bdh(), false)) && (p.h(this.xor, Boolean.TRUE)); paramBaseFinderFeed = null)
    {
      AppMethodBeat.o(271438);
      return true;
    }
    AppMethodBeat.o(271438);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(271435);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(271435);
  }
  
  public final FinderPostProgressView dpH()
  {
    AppMethodBeat.i(271433);
    FinderPostProgressView localFinderPostProgressView = this.xok;
    if (localFinderPostProgressView == null) {
      p.bGy("progress");
    }
    AppMethodBeat.o(271433);
    return localFinderPostProgressView;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_media_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(cc paramcc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(278465);
      FinderPostProgressView localFinderPostProgressView = this.xot.dpH();
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(278465);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.xot.dpH().invalidate();
      AppMethodBeat.o(278465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cc
 * JD-Core Version:    0.7.0.1
 */