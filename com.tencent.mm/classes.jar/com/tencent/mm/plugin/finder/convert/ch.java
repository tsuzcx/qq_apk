package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "isSelf", "plugin-finder_release"})
public final class ch
  extends RecyclerView.v
{
  public final String TAG;
  public ImageView fDJ;
  public ImageView jiu;
  public TextView kCB;
  public TextView kEs;
  public ValueAnimator opx;
  public Long readFeedId;
  public View wOd;
  public View xoJ;
  public TextView xoK;
  public WeImageView xoe;
  public ImageIndicatorView xof;
  public FinderLiveOnliveWidget xog;
  public FinderLiveOnliveWidget xoh;
  public ImageView xoi;
  public View xoj;
  public FinderPostProgressView xok;
  public View xol;
  public View xom;
  public View xon;
  public TextView xoo;
  public View xop;
  public ImageView xoq;
  private final f xos;
  
  public ch(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    this.xos = g.ar((kotlin.g.a.a)ch.d.xoO);
    View localView = paramView.findViewById(b.f.finder_profile_item_image);
    p.j(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.fDJ = ((ImageView)localView);
    localView = paramView.findViewById(b.f.image_indicator);
    p.j(localView, "itemView.findViewById(R.id.image_indicator)");
    this.xof = ((ImageIndicatorView)localView);
    localView = paramView.findViewById(b.f.finder_live_onlive_widget);
    p.j(localView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.xog = ((FinderLiveOnliveWidget)localView);
    localView = paramView.findViewById(b.f.finder_live_mask_view);
    p.j(localView, "itemView.findViewById<Fi…id.finder_live_mask_view)");
    this.xoh = ((FinderLiveOnliveWidget)localView);
    this.xoe = ((WeImageView)paramView.findViewById(b.f.profile_item_like_iv));
    localView = paramView.findViewById(b.f.profile_item_desc_tv);
    p.j(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.kEs = ((TextView)localView);
    localView = paramView.findViewById(b.f.profile_upload_progress);
    p.j(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.xok = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(b.f.profile_upload_area);
    p.j(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.wOd = localView;
    localView = paramView.findViewById(b.f.profile_item_failed_area);
    p.j(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.xol = localView;
    localView = paramView.findViewById(b.f.profile_like_area);
    p.j(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.xom = localView;
    localView = paramView.findViewById(b.f.profile_like_count_tv);
    p.j(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.kCB = ((TextView)localView);
    localView = paramView.findViewById(b.f.finder_profile_item_reprint_iv);
    p.j(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.xoi = ((ImageView)localView);
    localView = paramView.findViewById(b.f.ref_deleted_tips);
    p.j(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.xoj = localView;
    localView = paramView.findViewById(b.f.padding_view);
    p.j(localView, "itemView.findViewById(R.id.padding_view)");
    this.xon = localView;
    this.xoe = ((WeImageView)paramView.findViewById(b.f.profile_item_like_iv));
    localView = paramView.findViewById(b.f.avatar_layout);
    p.j(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.xoJ = localView;
    localView = paramView.findViewById(b.f.avatar_iv);
    p.j(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.jiu = ((ImageView)localView);
    localView = paramView.findViewById(b.f.nickname_tv);
    p.j(localView, "itemView.findViewById(R.id.nickname_tv)");
    this.xoK = ((TextView)localView);
    this.xop = paramView.findViewById(b.f.private_icon_layout);
    this.xoq = ((ImageView)paramView.findViewById(b.f.profile_feed_icon_iv));
    this.xoo = ((TextView)paramView.findViewById(b.f.finder_profile_item_mask));
    AppMethodBeat.o(165497);
  }
  
  public final Point dpI()
  {
    AppMethodBeat.i(286418);
    Point localPoint = (Point)this.xos.getValue();
    AppMethodBeat.o(286418);
    return localPoint;
  }
  
  public final boolean j(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(286419);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; kotlin.n.n.L(paramBaseFinderFeed, z.bdh(), false); paramBaseFinderFeed = null)
    {
      Object localObject = this.amk.getTag(b.f.profile_convert_is_self_tag);
      paramBaseFinderFeed = localObject;
      if (!(localObject instanceof Boolean)) {
        paramBaseFinderFeed = null;
      }
      if (!p.h((Boolean)paramBaseFinderFeed, Boolean.TRUE)) {
        break;
      }
      AppMethodBeat.o(286419);
      return true;
    }
    AppMethodBeat.o(286419);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$2$1"})
  public static final class a
    implements View.OnClickListener
  {
    public a(aa.f paramf, BaseFinderFeed paramBaseFinderFeed, ch paramch) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = new Intent();
      paramView = (FinderContact)this.xoL.aaBC;
      long l;
      if (paramView != null)
      {
        paramView = paramView.username;
        ((Intent)localObject).putExtra("finder_username", paramView);
        paramView = aj.Bnu;
        paramView = this.xoN.amk;
        p.j(paramView, "itemView");
        paramView = paramView.getContext();
        p.j(paramView, "itemView.context");
        aj.a.a(paramView, (Intent)localObject, this.xoM.mf(), 6, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.xoN.amk;
        p.j(paramView, "itemView");
        paramView = paramView.getContext();
        p.j(paramView, "itemView.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, (Intent)localObject);
        paramView = com.tencent.mm.plugin.finder.report.n.zWF;
        l = this.xoM.mf();
        paramView = (FinderContact)this.xoL.aaBC;
        if (paramView == null) {
          break label221;
        }
      }
      label221:
      for (paramView = paramView.username;; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.n.a(4, l, 6, 1, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178136);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  public static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public c(ch paramch) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(268537);
      FinderPostProgressView localFinderPostProgressView = this.xoN.xok;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(268537);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.xoN.xok.invalidate();
      AppMethodBeat.o(268537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ch
 * JD-Core Version:    0.7.0.1
 */