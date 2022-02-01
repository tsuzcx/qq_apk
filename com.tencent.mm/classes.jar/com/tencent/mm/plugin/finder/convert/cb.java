package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "isSelf", "plugin-finder_release"})
public final class cb
  extends RecyclerView.v
{
  public final String TAG;
  public ImageView dKU;
  public ImageView gyr;
  public TextView hOf;
  public TextView hPW;
  public ValueAnimator luz;
  public TextView pIN;
  public Long readFeedId;
  public View tFA;
  public FinderPostProgressView tFB;
  public View tFC;
  public View tFD;
  public View tFE;
  public TextView tFF;
  public View tFG;
  public ImageView tFH;
  private final f tFJ;
  public View tFX;
  public WeImageView tFv;
  public ImageIndicatorView tFw;
  public FinderLiveOnliveWidget tFx;
  public FinderLiveOnliveWidget tFy;
  public ImageView tFz;
  public View thM;
  
  public cb(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    this.tFJ = kotlin.g.ah((kotlin.g.a.a)cb.d.tGd);
    View localView = paramView.findViewById(2131301449);
    p.g(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.dKU = ((ImageView)localView);
    localView = paramView.findViewById(2131302571);
    p.g(localView, "itemView.findViewById(R.id.image_indicator)");
    this.tFw = ((ImageIndicatorView)localView);
    localView = paramView.findViewById(2131301215);
    p.g(localView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.tFx = ((FinderLiveOnliveWidget)localView);
    localView = paramView.findViewById(2131301145);
    p.g(localView, "itemView.findViewById<Fi…id.finder_live_mask_view)");
    this.tFy = ((FinderLiveOnliveWidget)localView);
    this.tFv = ((WeImageView)paramView.findViewById(2131306208));
    localView = paramView.findViewById(2131306205);
    p.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.hPW = ((TextView)localView);
    localView = paramView.findViewById(2131306271);
    p.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.tFB = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131306270);
    p.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.thM = localView;
    localView = paramView.findViewById(2131306206);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.tFC = localView;
    localView = paramView.findViewById(2131306210);
    p.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.tFD = localView;
    localView = paramView.findViewById(2131306213);
    p.g(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.hOf = ((TextView)localView);
    localView = paramView.findViewById(2131301451);
    p.g(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.tFz = ((ImageView)localView);
    localView = paramView.findViewById(2131306765);
    p.g(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.tFA = localView;
    localView = paramView.findViewById(2131305768);
    p.g(localView, "itemView.findViewById(R.id.padding_view)");
    this.tFE = localView;
    this.tFv = ((WeImageView)paramView.findViewById(2131306208));
    localView = paramView.findViewById(2131297137);
    p.g(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.tFX = localView;
    localView = paramView.findViewById(2131297134);
    p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.gyr = ((ImageView)localView);
    localView = paramView.findViewById(2131305440);
    p.g(localView, "itemView.findViewById(R.id.nickname_tv)");
    this.pIN = ((TextView)localView);
    this.tFG = paramView.findViewById(2131306140);
    this.tFH = ((ImageView)paramView.findViewById(2131306201));
    this.tFF = ((TextView)paramView.findViewById(2131301450));
    AppMethodBeat.o(165497);
  }
  
  public final Point cZM()
  {
    AppMethodBeat.i(243267);
    Point localPoint = (Point)this.tFJ.getValue();
    AppMethodBeat.o(243267);
    return localPoint;
  }
  
  public final boolean h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(243268);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; n.I(paramBaseFinderFeed, z.aUg(), false); paramBaseFinderFeed = null)
    {
      Object localObject = this.aus.getTag(2131306192);
      paramBaseFinderFeed = localObject;
      if (!(localObject instanceof Boolean)) {
        paramBaseFinderFeed = null;
      }
      if (!p.j((Boolean)paramBaseFinderFeed, Boolean.TRUE)) {
        break;
      }
      AppMethodBeat.o(243268);
      return true;
    }
    AppMethodBeat.o(243268);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$2$1"})
  public static final class a
    implements View.OnClickListener
  {
    public a(z.f paramf, BaseFinderFeed paramBaseFinderFeed, cb paramcb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent();
      paramView = (FinderContact)this.tFY.SYG;
      long l;
      if (paramView != null)
      {
        paramView = paramView.username;
        ((Intent)localObject).putExtra("finder_username", paramView);
        paramView = FinderReporterUIC.wzC;
        paramView = this.tGa.aus;
        p.g(paramView, "itemView");
        paramView = paramView.getContext();
        p.g(paramView, "itemView.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject, this.tFZ.lT(), 6, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.tGa.aus;
        p.g(paramView, "itemView");
        paramView = paramView.getContext();
        p.g(paramView, "itemView.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, (Intent)localObject);
        paramView = k.vfA;
        l = this.tFZ.lT();
        paramView = (FinderContact)this.tFY.SYG;
        if (paramView == null) {
          break label221;
        }
      }
      label221:
      for (paramView = paramView.username;; paramView = null)
      {
        k.a(4, l, 6, 1, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178136);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  public static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public c(cb paramcb) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(243264);
      FinderPostProgressView localFinderPostProgressView = this.tGa.tFB;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(243264);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.tGa.tFB.invalidate();
      AppMethodBeat.o(243264);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cb
 * JD-Core Version:    0.7.0.1
 */