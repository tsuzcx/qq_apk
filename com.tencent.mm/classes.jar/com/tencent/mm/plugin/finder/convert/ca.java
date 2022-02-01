package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "deletedTip", "Landroid/view/View;", "getDeletedTip", "()Landroid/view/View;", "setDeletedTip", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemContainer", "getItemContainer", "setItemContainer", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "getLayoutId", "", "initViews", "itemView", "isSelf", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ca
  extends f<BaseFinderFeed>
{
  private View ALK;
  private WeImageView ALM;
  public ImageIndicatorView ALN;
  public FinderLiveOnliveWidget ALO;
  public FinderLiveOnliveWidget ALP;
  public ImageView ALQ;
  public View ALR;
  public FinderPostProgressView ALS;
  public View ALT;
  public View ALU;
  public View ALV;
  private TextView ALW;
  private View ALX;
  private ImageView ALY;
  public Boolean ALZ;
  private final kotlin.j AMa;
  public View AkF;
  public TextView descTv;
  public ImageView hIz;
  public TextView nga;
  private ValueAnimator rtf;
  
  public ca()
  {
    AppMethodBeat.i(349761);
    this.AMa = k.cm((a)ca.a.AMb);
    AppMethodBeat.o(349761);
  }
  
  private static final void a(ca paramca, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(349892);
    s.u(paramca, "this$0");
    FinderPostProgressView localFinderPostProgressView = paramca.dXR();
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramca = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(349892);
      throw paramca;
    }
    localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramca.dXR().invalidate();
    AppMethodBeat.o(349892);
  }
  
  private final void d(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(349878);
    TextView localTextView = this.ALW;
    if (localTextView != null) {
      if (!paramBaseFinderFeed.markRead) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(349878);
      return;
    }
  }
  
  private ImageIndicatorView dXM()
  {
    AppMethodBeat.i(349780);
    ImageIndicatorView localImageIndicatorView = this.ALN;
    if (localImageIndicatorView != null)
    {
      AppMethodBeat.o(349780);
      return localImageIndicatorView;
    }
    s.bIx("tagImageView");
    AppMethodBeat.o(349780);
    return null;
  }
  
  private FinderLiveOnliveWidget dXN()
  {
    AppMethodBeat.i(349786);
    FinderLiveOnliveWidget localFinderLiveOnliveWidget = this.ALO;
    if (localFinderLiveOnliveWidget != null)
    {
      AppMethodBeat.o(349786);
      return localFinderLiveOnliveWidget;
    }
    s.bIx("feedOnliveLayout");
    AppMethodBeat.o(349786);
    return null;
  }
  
  private FinderLiveOnliveWidget dXO()
  {
    AppMethodBeat.i(349794);
    FinderLiveOnliveWidget localFinderLiveOnliveWidget = this.ALP;
    if (localFinderLiveOnliveWidget != null)
    {
      AppMethodBeat.o(349794);
      return localFinderLiveOnliveWidget;
    }
    s.bIx("liveFinishView");
    AppMethodBeat.o(349794);
    return null;
  }
  
  private ImageView dXP()
  {
    AppMethodBeat.i(349806);
    ImageView localImageView = this.ALQ;
    if (localImageView != null)
    {
      AppMethodBeat.o(349806);
      return localImageView;
    }
    s.bIx("reprintIv");
    AppMethodBeat.o(349806);
    return null;
  }
  
  private View dXQ()
  {
    AppMethodBeat.i(349818);
    View localView = this.ALR;
    if (localView != null)
    {
      AppMethodBeat.o(349818);
      return localView;
    }
    s.bIx("deletedTip");
    AppMethodBeat.o(349818);
    return null;
  }
  
  private FinderPostProgressView dXR()
  {
    AppMethodBeat.i(349828);
    FinderPostProgressView localFinderPostProgressView = this.ALS;
    if (localFinderPostProgressView != null)
    {
      AppMethodBeat.o(349828);
      return localFinderPostProgressView;
    }
    s.bIx("progress");
    AppMethodBeat.o(349828);
    return null;
  }
  
  private View dXS()
  {
    AppMethodBeat.i(349835);
    View localView = this.AkF;
    if (localView != null)
    {
      AppMethodBeat.o(349835);
      return localView;
    }
    s.bIx("progressArea");
    AppMethodBeat.o(349835);
    return null;
  }
  
  private View dXT()
  {
    AppMethodBeat.i(349841);
    View localView = this.ALT;
    if (localView != null)
    {
      AppMethodBeat.o(349841);
      return localView;
    }
    s.bIx("failedArea");
    AppMethodBeat.o(349841);
    return null;
  }
  
  private View dXU()
  {
    AppMethodBeat.i(349850);
    View localView = this.ALU;
    if (localView != null)
    {
      AppMethodBeat.o(349850);
      return localView;
    }
    s.bIx("likeArea");
    AppMethodBeat.o(349850);
    return null;
  }
  
  private TextView dXV()
  {
    AppMethodBeat.i(349859);
    TextView localTextView = this.nga;
    if (localTextView != null)
    {
      AppMethodBeat.o(349859);
      return localTextView;
    }
    s.bIx("likeCountTv");
    AppMethodBeat.o(349859);
    return null;
  }
  
  private View dXW()
  {
    AppMethodBeat.i(349863);
    View localView = this.ALV;
    if (localView != null)
    {
      AppMethodBeat.o(349863);
      return localView;
    }
    s.bIx("paddingArea");
    AppMethodBeat.o(349863);
    return null;
  }
  
  private final Point dXX()
  {
    AppMethodBeat.i(349872);
    Point localPoint = (Point)this.AMa.getValue();
    AppMethodBeat.o(349872);
    return localPoint;
  }
  
  private final boolean e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(349886);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null; (n.T(paramBaseFinderFeed, z.bAW(), false)) && (s.p(this.ALZ, Boolean.TRUE)); paramBaseFinderFeed = paramBaseFinderFeed.field_username)
    {
      AppMethodBeat.o(349886);
      return true;
    }
    AppMethodBeat.o(349886);
    return false;
  }
  
  private TextView getDescTv()
  {
    AppMethodBeat.i(349811);
    TextView localTextView = this.descTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(349811);
      return localTextView;
    }
    s.bIx("descTv");
    AppMethodBeat.o(349811);
    return null;
  }
  
  private ImageView getImageView()
  {
    AppMethodBeat.i(349772);
    ImageView localImageView = this.hIz;
    if (localImageView != null)
    {
      AppMethodBeat.o(349772);
      return localImageView;
    }
    s.bIx("imageView");
    AppMethodBeat.o(349772);
    return null;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(349907);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(349907);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_media_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ca
 * JD-Core Version:    0.7.0.1
 */