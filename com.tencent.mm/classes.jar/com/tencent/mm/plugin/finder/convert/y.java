package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import d.a.j;
import d.g.b.v.e;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "tagImageView", "getTagImageView", "setTagImageView", "tipDialog", "Landroid/app/Dialog;", "bindMedia", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "isSelf", "plugin-finder_release"})
public final class y
  extends RecyclerView.v
{
  private final String TAG;
  private ImageView djK;
  private ImageView fuj;
  private ValueAnimator jsS;
  private TextView lEA;
  private TextView nkb;
  private View qhs;
  private ImageView qrG;
  private ImageView qrH;
  private View qrI;
  FinderPostProgressView qrJ;
  private View qrK;
  private TextView qrL;
  private View qrM;
  private View qrN;
  private View qrS;
  
  public y(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    View localView = paramView.findViewById(2131300050);
    d.g.b.k.g(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.djK = ((ImageView)localView);
    localView = paramView.findViewById(2131300052);
    d.g.b.k.g(localView, "itemView.findViewById(R.…nder_profile_item_tag_iv)");
    this.qrG = ((ImageView)localView);
    localView = paramView.findViewById(2131303465);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.lEA = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    d.g.b.k.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.qrJ = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.qhs = localView;
    localView = paramView.findViewById(2131303466);
    d.g.b.k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.qrK = localView;
    localView = paramView.findViewById(2131307824);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.qrS = localView;
    localView = paramView.findViewById(2131303471);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.qrL = ((TextView)localView);
    localView = paramView.findViewById(2131300051);
    d.g.b.k.g(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.qrH = ((ImageView)localView);
    localView = paramView.findViewById(2131303921);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.qrI = localView;
    localView = paramView.findViewById(2131303131);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.padding_view)");
    this.qrM = localView;
    localView = paramView.findViewById(2131297011);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.qrN = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fuj = ((ImageView)localView);
    paramView = paramView.findViewById(2131302867);
    d.g.b.k.g(paramView, "itemView.findViewById(R.id.nickname_tv)");
    this.nkb = ((TextView)paramView);
    AppMethodBeat.o(165497);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<d.y> parama)
  {
    AppMethodBeat.i(165495);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parama, "itemClickListener");
    Object localObject1;
    if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription()))
    {
      localObject1 = (CharSequence)"";
      if (!paramBaseFinderFeed.feedObject.getMediaList().isEmpty()) {
        break label190;
      }
      ad.i(this.TAG, "invalid item id " + paramBaseFinderFeed.feedObject.getId());
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label178;
      }
      this.lEA.setVisibility(0);
      this.lEA.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.qrK.setVisibility(0);
      this.qhs.setVisibility(8);
      this.qrL.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      AppMethodBeat.o(165495);
      return;
      localObject1 = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription());
      break;
      label178:
      this.lEA.setVisibility(8);
    }
    label190:
    Object localObject2 = (bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList());
    Object localObject3 = this.djK.getLayoutParams();
    int i = aj.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject4 = aj.getContext().getResources();
    if (localObject4 == null) {
      d.g.b.k.fvU();
    }
    int k = (i - (int)((Resources)localObject4).getDimension(2131165294)) / 2;
    label480:
    Object localObject5;
    if (k > 0)
    {
      int j = (int)(((bmd)localObject2).height * k / ((bmd)localObject2).width);
      i = j;
      if (j > k * 1.166666666666667D) {
        i = (int)(k * 1.166666666666667D);
      }
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ad.i(this.TAG, "onBindViewHolder " + ln() + " lpWidth:" + ((ViewGroup.LayoutParams)localObject3).width + ", lpHeight:" + ((ViewGroup.LayoutParams)localObject3).height + ", width:" + k + ", height:" + i + ", mediaWidth:" + ((bmd)localObject2).width + ", mediaHeight:" + ((bmd)localObject2).height);
      this.djK.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.qrI.setVisibility(8);
      if (paramBoolean1)
      {
        if (paramBaseFinderFeed.feedObject.getRefObjectFlag() != 2L) {
          break label1100;
        }
        this.djK.setImageResource(2131099656);
        this.qrI.setVisibility(0);
      }
      if (!paramBoolean2) {
        break label1311;
      }
      this.qrN.setVisibility(0);
      localObject2 = new v.e();
      ((v.e)localObject2).Jhw = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      localObject3 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject3 = com.tencent.mm.plugin.finder.loader.h.cmV();
      localObject4 = new com.tencent.mm.plugin.finder.loader.a(((FinderContact)((v.e)localObject2).Jhw).headUrl);
      localObject5 = this.fuj;
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject3).a(localObject4, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
      localObject3 = this.nkb;
      localObject4 = aj.getContext();
      localObject5 = i.qIB;
      localObject5 = ((FinderContact)((v.e)localObject2).Jhw).nickname;
      d.g.b.k.g(localObject5, "contact.nickname");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject4, (CharSequence)i.Zr((String)localObject5), this.nkb.getTextSize()));
      ai.a((Paint)this.nkb.getPaint(), 0.8F);
      this.fuj.setOnClickListener((View.OnClickListener)new a((v.e)localObject2, paramBaseFinderFeed, this));
      label674:
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label1335;
      }
      this.lEA.setVisibility(0);
      if (!paramBoolean2) {
        break label1323;
      }
      localObject1 = this.lEA;
      localObject2 = aj.getContext();
      localObject3 = i.qIB;
      localObject3 = paramBaseFinderFeed.feedObject.getDescription();
      localObject4 = this.lEA.getPaint();
      d.g.b.k.g(localObject4, "descTv.paint");
      localObject5 = i.qIB;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)i.a((String)localObject3, (TextPaint)localObject4, i.cou() / 2), 0.0F));
      label775:
      this.qrL.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      if (((bmd)paramBaseFinderFeed.feedObject.getMediaList().get(0)).mediaType != 2) {
        break label1347;
      }
      this.qrG.setVisibility(0);
      this.qrG.setImageDrawable(am.i(this.qrG.getContext(), 2131690348, com.tencent.mm.cd.a.n(this.qrG.getContext(), 2131099828)));
      label857:
      if (paramBaseFinderFeed.feedObject.getRefObjectFlag() <= 0L) {
        break label1371;
      }
      this.qrH.setVisibility(0);
      label877:
      this.arI.setOnClickListener((View.OnClickListener)new y.b(parama));
      this.qrS.setVisibility(0);
      parama = this.jsS;
      if (parama != null) {
        parama.cancel();
      }
      if ((!paramBaseFinderFeed.feedObject.isPostFailed()) && (!paramBaseFinderFeed.feedObject.isUploadFailed())) {
        break label1383;
      }
      this.qrK.setVisibility(0);
      this.qhs.setVisibility(8);
      this.qrS.setVisibility(8);
    }
    for (;;)
    {
      if ((this.qrK.getVisibility() != 8) || (this.qhs.getVisibility() != 8) || (this.lEA.getVisibility() != 8) || (paramBoolean2)) {
        break label1531;
      }
      this.qrM.setVisibility(8);
      AppMethodBeat.o(165495);
      return;
      ad.i(this.TAG, "onBindViewHolder " + ln() + " width invalid:" + k + ", " + this.djK.getLayoutParams().width + ", " + this.djK.getLayoutParams().height);
      break;
      label1100:
      if (((bmd)localObject2).mediaType == 4)
      {
        localObject2 = (bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (bt.isNullOrNil(((bmd)localObject2).coverUrl))
        {
          localObject2 = new f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJZ);
          localObject3 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject3 = com.tencent.mm.plugin.finder.loader.h.cmU();
          localObject4 = this.djK;
          localObject5 = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
          break label480;
        }
        localObject2 = new n((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJY);
        localObject3 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject3 = com.tencent.mm.plugin.finder.loader.h.cmU();
        localObject4 = this.djK;
        localObject5 = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        break label480;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
      localObject3 = new f((bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList()), com.tencent.mm.plugin.finder.storage.h.qJZ);
      localObject4 = this.djK;
      localObject5 = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject2).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
      break label480;
      label1311:
      this.qrN.setVisibility(8);
      break label674;
      label1323:
      this.lEA.setText((CharSequence)localObject1);
      break label775;
      label1335:
      this.lEA.setVisibility(8);
      break label775;
      label1347:
      paramBaseFinderFeed.feedObject.getMediaList().get(0);
      this.qrG.setVisibility(8);
      break label857;
      label1371:
      this.qrH.setVisibility(8);
      break label877;
      label1383:
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        this.qrK.setVisibility(8);
        this.qhs.setVisibility(8);
      }
      else
      {
        this.qrK.setVisibility(8);
        this.qrS.setVisibility(8);
        this.qhs.setVisibility(0);
        this.jsS = ValueAnimator.ofInt(new int[] { this.qrJ.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().DJH });
        paramBaseFinderFeed = this.jsS;
        if (paramBaseFinderFeed == null) {
          d.g.b.k.fvU();
        }
        paramBaseFinderFeed.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramBaseFinderFeed = this.jsS;
        if (paramBaseFinderFeed == null) {
          d.g.b.k.fvU();
        }
        paramBaseFinderFeed = paramBaseFinderFeed.setDuration(400L);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.start();
        }
      }
    }
    label1531:
    this.qrM.setVisibility(0);
    AppMethodBeat.o(165495);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(v.e parame, BaseFinderFeed paramBaseFinderFeed, y paramy) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      paramView = new Intent();
      paramView.putExtra("finder_username", ((FinderContact)this.qrO.Jhw).username);
      Object localObject = FinderReporterUIC.Ljl;
      localObject = jdField_this.arI;
      d.g.b.k.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "itemView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, paramBaseFinderFeed.bMs(), 6, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject = jdField_this.arI;
      d.g.b.k.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "itemView.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      paramView = b.qFq;
      long l = paramBaseFinderFeed.bMs();
      paramView = ((FinderContact)this.qrO.Jhw).username;
      d.g.b.k.g(paramView, "contact.username");
      b.a(4, l, 6, 1, paramView);
      AppMethodBeat.o(178136);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(y paramy) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(165494);
      FinderPostProgressView localFinderPostProgressView = this.qrQ.qrJ;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(165494);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.qrQ.qrJ.invalidate();
      AppMethodBeat.o(165494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */