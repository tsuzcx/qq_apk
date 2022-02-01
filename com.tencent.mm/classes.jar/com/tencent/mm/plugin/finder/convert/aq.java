package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import d.a.j;
import d.g.b.v.f;
import d.l;
import d.v;
import d.y;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "tagImageView", "getTagImageView", "setTagImageView", "tipDialog", "Landroid/app/Dialog;", "bindMedia", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "isSelf", "plugin-finder_release"})
public final class aq
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView dhf;
  private ImageView fxQ;
  private TextView gAI;
  private TextView gyR;
  private ValueAnimator jTm;
  private TextView nMU;
  private View qPU;
  private View rbU;
  FinderPostProgressView rbV;
  private View rbW;
  private ImageView rcs;
  private ImageView rct;
  private View rcu;
  private View rcv;
  private View rcw;
  
  public aq(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    View localView = paramView.findViewById(2131300050);
    d.g.b.k.g(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.dhf = ((ImageView)localView);
    localView = paramView.findViewById(2131300052);
    d.g.b.k.g(localView, "itemView.findViewById(R.…nder_profile_item_tag_iv)");
    this.rcs = ((ImageView)localView);
    localView = paramView.findViewById(2131303465);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.gAI = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    d.g.b.k.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rbV = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.qPU = localView;
    localView = paramView.findViewById(2131303466);
    d.g.b.k.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rbU = localView;
    localView = paramView.findViewById(2131307916);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.rbW = localView;
    localView = paramView.findViewById(2131303471);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.gyR = ((TextView)localView);
    localView = paramView.findViewById(2131300051);
    d.g.b.k.g(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.rct = ((ImageView)localView);
    localView = paramView.findViewById(2131303921);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.rcu = localView;
    localView = paramView.findViewById(2131303131);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.padding_view)");
    this.rcv = localView;
    localView = paramView.findViewById(2131297011);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.rcw = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fxQ = ((ImageView)localView);
    paramView = paramView.findViewById(2131302867);
    d.g.b.k.g(paramView, "itemView.findViewById(R.id.nickname_tv)");
    this.nMU = ((TextView)paramView);
    AppMethodBeat.o(165497);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(165495);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parama, "itemClickListener");
    Object localObject1;
    if (bs.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription()))
    {
      localObject1 = (CharSequence)"";
      if (!paramBaseFinderFeed.feedObject.getMediaList().isEmpty()) {
        break label190;
      }
      ac.i(this.TAG, "invalid item id " + paramBaseFinderFeed.feedObject.getId());
      if (bs.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label178;
      }
      this.gAI.setVisibility(0);
      this.gAI.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.rbU.setVisibility(0);
      this.qPU.setVisibility(8);
      this.gyR.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      AppMethodBeat.o(165495);
      return;
      localObject1 = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription());
      break;
      label178:
      this.gAI.setVisibility(8);
    }
    label190:
    Object localObject2 = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
    Object localObject3 = this.dhf.getLayoutParams();
    int i = ai.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject4 = ai.getContext().getResources();
    if (localObject4 == null) {
      d.g.b.k.fOy();
    }
    int k = (i - (int)((Resources)localObject4).getDimension(2131165294)) / 2;
    label480:
    Object localObject5;
    if (k > 0)
    {
      int j = (int)(((bqs)localObject2).height * k / ((bqs)localObject2).width);
      i = j;
      if (j > k * 1.166666666666667D) {
        i = (int)(k * 1.166666666666667D);
      }
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ac.i(this.TAG, "onBindViewHolder " + lv() + " lpWidth:" + ((ViewGroup.LayoutParams)localObject3).width + ", lpHeight:" + ((ViewGroup.LayoutParams)localObject3).height + ", width:" + k + ", height:" + i + ", mediaWidth:" + ((bqs)localObject2).width + ", mediaHeight:" + ((bqs)localObject2).height);
      this.dhf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.rcu.setVisibility(8);
      if (paramBoolean1)
      {
        if (paramBaseFinderFeed.feedObject.getRefObjectFlag() != 2L) {
          break label1115;
        }
        this.dhf.setImageResource(2131099656);
        this.rcu.setVisibility(0);
      }
      if (!paramBoolean2) {
        break label1326;
      }
      this.rcw.setVisibility(0);
      localObject2 = new v.f();
      ((v.f)localObject2).KUQ = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      localObject3 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject3 = com.tencent.mm.plugin.finder.loader.h.cwo();
      localObject4 = new com.tencent.mm.plugin.finder.loader.a(((FinderContact)((v.f)localObject2).KUQ).headUrl);
      localObject5 = this.fxQ;
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((com.tencent.mm.loader.d)localObject3).a(localObject4, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
      localObject3 = this.nMU;
      localObject4 = ai.getContext();
      localObject5 = com.tencent.mm.plugin.finder.search.h.rBC;
      localObject5 = ((FinderContact)((v.f)localObject2).KUQ).nickname;
      d.g.b.k.g(localObject5, "contact.nickname");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject4, (CharSequence)com.tencent.mm.plugin.finder.search.h.adZ((String)localObject5), this.nMU.getTextSize()));
      aj.a((Paint)this.nMU.getPaint(), 0.8F);
      this.fxQ.setOnClickListener((View.OnClickListener)new a((v.f)localObject2, paramBaseFinderFeed, this));
      label674:
      if (bs.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label1350;
      }
      this.gAI.setVisibility(0);
      if (!paramBoolean2) {
        break label1338;
      }
      localObject1 = this.gAI;
      localObject2 = ai.getContext();
      localObject3 = com.tencent.mm.plugin.finder.search.h.rBC;
      localObject3 = paramBaseFinderFeed.feedObject.getDescription();
      localObject4 = this.gAI.getPaint();
      d.g.b.k.g(localObject4, "descTv.paint");
      localObject5 = com.tencent.mm.plugin.finder.search.h.rBC;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.search.h.a((String)localObject3, (TextPaint)localObject4, com.tencent.mm.plugin.finder.search.h.cxR() / 2), 0.0F));
      label775:
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label1362;
      }
      localObject1 = g.fD(2, paramBaseFinderFeed.feedObject.getLikeCount());
      label798:
      this.gyR.setText((CharSequence)localObject1);
      if (((bqs)paramBaseFinderFeed.feedObject.getMediaList().get(0)).mediaType != 2) {
        break label1370;
      }
      this.rcs.setVisibility(0);
      this.rcs.setImageDrawable(am.k(this.rcs.getContext(), 2131690348, com.tencent.mm.cc.a.n(this.rcs.getContext(), 2131099828)));
      label872:
      if (paramBaseFinderFeed.feedObject.getRefObjectFlag() <= 0L) {
        break label1394;
      }
      this.rct.setVisibility(0);
      label892:
      this.asD.setOnClickListener((View.OnClickListener)new aq.b(parama));
      this.rbW.setVisibility(0);
      parama = this.jTm;
      if (parama != null) {
        parama.cancel();
      }
      if ((!paramBaseFinderFeed.feedObject.isPostFailed()) && (!paramBaseFinderFeed.feedObject.isUploadFailed())) {
        break label1406;
      }
      this.rbU.setVisibility(0);
      this.qPU.setVisibility(8);
      this.rbW.setVisibility(8);
    }
    for (;;)
    {
      if ((this.rbU.getVisibility() != 8) || (this.qPU.getVisibility() != 8) || (this.gAI.getVisibility() != 8) || (paramBoolean2)) {
        break label1554;
      }
      this.rcv.setVisibility(8);
      AppMethodBeat.o(165495);
      return;
      ac.i(this.TAG, "onBindViewHolder " + lv() + " width invalid:" + k + ", " + this.dhf.getLayoutParams().width + ", " + this.dhf.getLayoutParams().height);
      break;
      label1115:
      if (((bqs)localObject2).mediaType == 4)
      {
        localObject2 = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (bs.isNullOrNil(((bqs)localObject2).coverUrl))
        {
          localObject2 = new f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDR);
          localObject3 = com.tencent.mm.plugin.finder.loader.h.rtK;
          localObject3 = com.tencent.mm.plugin.finder.loader.h.cwn();
          localObject4 = this.dhf;
          localObject5 = com.tencent.mm.plugin.finder.loader.h.rtK;
          ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
          break label480;
        }
        localObject2 = new com.tencent.mm.plugin.finder.loader.m((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDQ);
        localObject3 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject3 = com.tencent.mm.plugin.finder.loader.h.cwn();
        localObject4 = this.dhf;
        localObject5 = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
        break label480;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cwn();
      localObject3 = new f((bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList()), com.tencent.mm.plugin.finder.storage.m.rDR);
      localObject4 = this.dhf;
      localObject5 = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
      break label480;
      label1326:
      this.rcw.setVisibility(8);
      break label674;
      label1338:
      this.gAI.setText((CharSequence)localObject1);
      break label775;
      label1350:
      this.gAI.setVisibility(8);
      break label775;
      label1362:
      localObject1 = "0";
      break label798;
      label1370:
      paramBaseFinderFeed.feedObject.getMediaList().get(0);
      this.rcs.setVisibility(8);
      break label872;
      label1394:
      this.rct.setVisibility(8);
      break label892;
      label1406:
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        this.rbU.setVisibility(8);
        this.qPU.setVisibility(8);
      }
      else
      {
        this.rbU.setVisibility(8);
        this.rbW.setVisibility(8);
        this.qPU.setVisibility(0);
        this.jTm = ValueAnimator.ofInt(new int[] { this.rbV.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().FfV });
        paramBaseFinderFeed = this.jTm;
        if (paramBaseFinderFeed == null) {
          d.g.b.k.fOy();
        }
        paramBaseFinderFeed.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramBaseFinderFeed = this.jTm;
        if (paramBaseFinderFeed == null) {
          d.g.b.k.fOy();
        }
        paramBaseFinderFeed = paramBaseFinderFeed.setDuration(400L);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.start();
        }
      }
    }
    label1554:
    this.rcv.setVisibility(0);
    AppMethodBeat.o(165495);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(v.f paramf, BaseFinderFeed paramBaseFinderFeed, aq paramaq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      paramView = new Intent();
      paramView.putExtra("finder_username", ((FinderContact)this.rcx.KUQ).username);
      Object localObject = FinderReporterUIC.seQ;
      localObject = jdField_this.asD;
      d.g.b.k.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "itemView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, paramBaseFinderFeed.lx(), 6, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject = jdField_this.asD;
      d.g.b.k.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "itemView.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      paramView = com.tencent.mm.plugin.finder.report.d.rxr;
      long l = paramBaseFinderFeed.lx();
      paramView = ((FinderContact)this.rcx.KUQ).username;
      d.g.b.k.g(paramView, "contact.username");
      com.tencent.mm.plugin.finder.report.d.a(4, l, 6, 1, paramView);
      AppMethodBeat.o(178136);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(aq paramaq) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(165494);
      FinderPostProgressView localFinderPostProgressView = this.rcz.rbV;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(165494);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rcz.rbV.invalidate();
      AppMethodBeat.o(165494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aq
 * JD-Core Version:    0.7.0.1
 */