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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "tagImageView", "getTagImageView", "setTagImageView", "tipDialog", "Landroid/app/Dialog;", "bindMedia", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "isSelf", "plugin-finder_release"})
public final class bc
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView dsD;
  private ImageView fRd;
  private TextView gSC;
  private TextView gUs;
  private ValueAnimator knA;
  private TextView opA;
  private View rOH;
  FinderPostProgressView rOI;
  private View rOJ;
  private WeImageView rPA;
  private ImageView rPB;
  private ImageView rPC;
  private View rPD;
  private View rPE;
  private View rPF;
  private TextView rPG;
  public Long rPH;
  private View rPI;
  private View rzU;
  
  public bc(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    View localView = paramView.findViewById(2131300050);
    p.g(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.dsD = ((ImageView)localView);
    localView = paramView.findViewById(2131300052);
    p.g(localView, "itemView.findViewById(R.…nder_profile_item_tag_iv)");
    this.rPB = ((ImageView)localView);
    localView = paramView.findViewById(2131303465);
    p.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.gUs = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    p.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rOI = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    p.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.rzU = localView;
    localView = paramView.findViewById(2131303466);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rOH = localView;
    localView = paramView.findViewById(2131307916);
    p.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.rOJ = localView;
    localView = paramView.findViewById(2131303471);
    p.g(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.gSC = ((TextView)localView);
    localView = paramView.findViewById(2131300051);
    p.g(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.rPC = ((ImageView)localView);
    localView = paramView.findViewById(2131303921);
    p.g(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.rPD = localView;
    localView = paramView.findViewById(2131303131);
    p.g(localView, "itemView.findViewById(R.id.padding_view)");
    this.rPE = localView;
    this.rPA = ((WeImageView)paramView.findViewById(2131308377));
    localView = paramView.findViewById(2131297011);
    p.g(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.rPF = localView;
    localView = paramView.findViewById(2131297008);
    p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fRd = ((ImageView)localView);
    localView = paramView.findViewById(2131302867);
    p.g(localView, "itemView.findViewById(R.id.nickname_tv)");
    this.opA = ((TextView)localView);
    this.rPI = paramView.findViewById(2131308376);
    this.rPG = ((TextView)paramView.findViewById(2131308312));
    AppMethodBeat.o(165497);
  }
  
  private static boolean d(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(201482);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username;; paramBaseFinderFeed = null)
    {
      boolean bool = d.n.n.H(paramBaseFinderFeed, u.aAu(), false);
      AppMethodBeat.o(201482);
      return bool;
    }
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(165495);
    p.h(paramBaseFinderFeed, "feed");
    p.h(parama, "itemClickListener");
    Object localObject1;
    if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription()))
    {
      localObject1 = (CharSequence)"";
      localObject2 = this.rPA;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(0);
      }
      localObject2 = this.rPH;
      if ((localObject2 != null) && (((Number)localObject2).longValue() == paramBaseFinderFeed.lP()))
      {
        localObject2 = this.rPG;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(0);
        }
      }
      if (!paramBaseFinderFeed.feedObject.getMediaList().isEmpty()) {
        break label256;
      }
      ad.i(this.TAG, "invalid item id " + paramBaseFinderFeed.feedObject.getId());
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label244;
      }
      this.gUs.setVisibility(0);
      this.gUs.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.rOH.setVisibility(0);
      this.rzU.setVisibility(8);
      this.gSC.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      AppMethodBeat.o(165495);
      return;
      localObject1 = (CharSequence)k.c(aj.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription());
      break;
      label244:
      this.gUs.setVisibility(8);
    }
    label256:
    Object localObject2 = (bvf)j.jc((List)paramBaseFinderFeed.feedObject.getMediaList());
    Object localObject3 = this.dsD.getLayoutParams();
    int i = aj.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject4 = aj.getContext().getResources();
    if (localObject4 == null) {
      p.gfZ();
    }
    int k = (i - (int)((Resources)localObject4).getDimension(2131165294)) / 2;
    label546:
    Object localObject5;
    if (k > 0)
    {
      int j = (int)(((bvf)localObject2).height * k / ((bvf)localObject2).width);
      i = j;
      if (j > k * 1.316667F) {
        i = (int)(k * 1.316667F);
      }
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ad.i(this.TAG, "onBindViewHolder " + lN() + " lpWidth:" + ((ViewGroup.LayoutParams)localObject3).width + ", lpHeight:" + ((ViewGroup.LayoutParams)localObject3).height + ", width:" + k + ", height:" + i + ", mediaWidth:" + ((bvf)localObject2).width + ", mediaHeight:" + ((bvf)localObject2).height);
      this.dsD.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.rPD.setVisibility(8);
      if (paramBoolean1)
      {
        if (paramBaseFinderFeed.feedObject.getRefObjectFlag() != 2L) {
          break label1410;
        }
        this.dsD.setImageResource(2131099656);
        this.rPD.setVisibility(0);
      }
      if (!paramBoolean2) {
        break label1621;
      }
      this.rPF.setVisibility(0);
      localObject2 = new y.f();
      ((y.f)localObject2).MLV = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      localObject3 = i.sja;
      localObject3 = i.cCC();
      localObject4 = new com.tencent.mm.plugin.finder.loader.a(((FinderContact)((y.f)localObject2).MLV).headUrl);
      localObject5 = this.fRd;
      i locali = i.sja;
      ((d)localObject3).a(localObject4, (ImageView)localObject5, i.a(i.a.sjd));
      localObject3 = this.opA;
      localObject4 = aj.getContext();
      localObject5 = com.tencent.mm.plugin.finder.search.h.stT;
      localObject5 = ((FinderContact)((y.f)localObject2).MLV).nickname;
      p.g(localObject5, "contact.nickname");
      ((TextView)localObject3).setText((CharSequence)k.d((Context)localObject4, (CharSequence)com.tencent.mm.plugin.finder.search.h.ahY((String)localObject5), this.opA.getTextSize()));
      al.a((Paint)this.opA.getPaint(), 0.8F);
      this.fRd.setOnClickListener((View.OnClickListener)new a((y.f)localObject2, paramBaseFinderFeed, this));
      label740:
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label1645;
      }
      this.gUs.setVisibility(0);
      if (!paramBoolean2) {
        break label1633;
      }
      localObject1 = this.gUs;
      localObject2 = aj.getContext();
      localObject3 = com.tencent.mm.plugin.finder.search.h.stT;
      localObject3 = paramBaseFinderFeed.feedObject.getDescription();
      localObject4 = this.gUs.getPaint();
      p.g(localObject4, "descTv.paint");
      localObject5 = com.tencent.mm.plugin.finder.search.h.stT;
      ((TextView)localObject1).setText((CharSequence)k.d((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.search.h.a((String)localObject3, (TextPaint)localObject4, com.tencent.mm.plugin.finder.search.h.cEO() / 2), 0.0F));
      label841:
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label1657;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.h.fR(2, paramBaseFinderFeed.feedObject.getLikeCount());
      label864:
      this.gSC.setText((CharSequence)localObject1);
      if (((bvf)paramBaseFinderFeed.feedObject.getMediaList().get(0)).mediaType != 2) {
        break label1665;
      }
      this.rPB.setVisibility(0);
      this.rPB.setImageDrawable(ao.k(this.rPB.getContext(), 2131690348, com.tencent.mm.cc.a.n(this.rPB.getContext(), 2131099828)));
      label938:
      if (!d(paramBaseFinderFeed)) {
        break label1689;
      }
      localObject1 = this.rPA;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setImageResource(2131690399);
      }
      localObject1 = this.rPA;
      if (localObject1 != null)
      {
        localObject2 = this.auu;
        p.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        p.g(localObject2, "itemView.context");
        ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100017));
      }
      i = paramBaseFinderFeed.feedObject.getReadCount();
      this.gSC.setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(i));
      localObject1 = this.gSC;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      p.g(localObject2, "itemView.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100017));
      localObject1 = this.rOJ;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      ((View)localObject1).setBackground(((View)localObject2).getContext().getDrawable(2131235053));
      label1128:
      if (paramBaseFinderFeed.feedObject.getRefObjectFlag() <= 0L) {
        break label1832;
      }
      this.rPC.setVisibility(0);
      label1148:
      this.auu.setOnClickListener((View.OnClickListener)new bc.b(parama));
      this.rOJ.setVisibility(0);
      parama = this.knA;
      if (parama != null) {
        parama.cancel();
      }
      if ((!paramBaseFinderFeed.feedObject.isPostFailed()) && (!paramBaseFinderFeed.feedObject.isUploadFailed())) {
        break label1844;
      }
      this.rOH.setVisibility(0);
      this.rzU.setVisibility(8);
      this.rOJ.setVisibility(8);
      label1237:
      if ((this.rOH.getVisibility() != 8) || (this.rzU.getVisibility() != 8) || (this.gUs.getVisibility() != 8) || (paramBoolean2)) {
        break label2001;
      }
      this.rPE.setVisibility(8);
      label1286:
      if (!d(paramBaseFinderFeed)) {
        break label2026;
      }
      parama = this.rPI;
      if (parama == null) {
        break label2019;
      }
      if (!paramBaseFinderFeed.feedObject.isPrivate()) {
        break label2012;
      }
    }
    label1410:
    label1621:
    label2012:
    for (i = 0;; i = 8)
    {
      parama.setVisibility(i);
      AppMethodBeat.o(165495);
      return;
      ad.i(this.TAG, "onBindViewHolder " + lN() + " width invalid:" + k + ", " + this.dsD.getLayoutParams().width + ", " + this.dsD.getLayoutParams().height);
      break;
      if (((bvf)localObject2).mediaType == 4)
      {
        localObject2 = (bvf)j.jc((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (bt.isNullOrNil(((bvf)localObject2).coverUrl))
        {
          localObject2 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject2, r.syE);
          localObject3 = i.sja;
          localObject3 = i.cCB();
          localObject4 = this.dsD;
          localObject5 = i.sja;
          ((d)localObject3).a(localObject2, (ImageView)localObject4, i.a(i.a.sjb));
          break label546;
        }
        localObject2 = new com.tencent.mm.plugin.finder.loader.n((bvf)localObject2, r.syD);
        localObject3 = i.sja;
        localObject3 = i.cCB();
        localObject4 = this.dsD;
        localObject5 = i.sja;
        ((d)localObject3).a(localObject2, (ImageView)localObject4, i.a(i.a.sjb));
        break label546;
      }
      localObject2 = i.sja;
      localObject2 = i.cCB();
      localObject3 = new com.tencent.mm.plugin.finder.loader.g((bvf)j.jc((List)paramBaseFinderFeed.feedObject.getMediaList()), r.syE);
      localObject4 = this.dsD;
      localObject5 = i.sja;
      ((d)localObject2).a(localObject3, (ImageView)localObject4, i.a(i.a.sjb));
      break label546;
      this.rPF.setVisibility(8);
      break label740;
      label1633:
      this.gUs.setText((CharSequence)localObject1);
      break label841;
      label1645:
      this.gUs.setVisibility(8);
      break label841;
      label1657:
      localObject1 = "0";
      break label864;
      paramBaseFinderFeed.feedObject.getMediaList().get(0);
      this.rPB.setVisibility(8);
      break label938;
      localObject1 = this.rPA;
      if (localObject1 != null)
      {
        localObject2 = this.auu;
        p.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        p.g(localObject2, "itemView.context");
        ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131099828));
      }
      localObject1 = this.rOJ;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      ((View)localObject1).setBackground(((View)localObject2).getContext().getDrawable(2131234890));
      localObject1 = this.gSC;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      p.g(localObject2, "itemView.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099828));
      break label1128;
      this.rPC.setVisibility(8);
      break label1148;
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        this.rOH.setVisibility(8);
        this.rzU.setVisibility(8);
        break label1237;
      }
      this.rOH.setVisibility(8);
      this.rOJ.setVisibility(8);
      this.rzU.setVisibility(0);
      this.knA = ValueAnimator.ofInt(new int[] { this.rOI.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().GPz });
      parama = this.knA;
      if (parama == null) {
        p.gfZ();
      }
      parama.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      parama = this.knA;
      if (parama == null) {
        p.gfZ();
      }
      parama = parama.setDuration(400L);
      if (parama == null) {
        break label1237;
      }
      parama.start();
      break label1237;
      this.rPE.setVisibility(0);
      break label1286;
    }
    label1665:
    label1689:
    label1832:
    label1844:
    label2001:
    label2019:
    AppMethodBeat.o(165495);
    return;
    label2026:
    paramBaseFinderFeed = this.rPI;
    if (paramBaseFinderFeed != null)
    {
      paramBaseFinderFeed.setVisibility(8);
      AppMethodBeat.o(165495);
      return;
    }
    AppMethodBeat.o(165495);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$2$1"})
  static final class a
    implements View.OnClickListener
  {
    a(y.f paramf, BaseFinderFeed paramBaseFinderFeed, bc parambc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = new Intent();
      paramView.putExtra("finder_username", ((FinderContact)this.rPJ.MLV).username);
      localObject = FinderReporterUIC.tcM;
      localObject = jdField_this.auu;
      p.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "itemView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, paramBaseFinderFeed.lP(), 6, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject = jdField_this.auu;
      p.g(localObject, "itemView");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "itemView.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      long l = paramBaseFinderFeed.lP();
      paramView = ((FinderContact)this.rPJ.MLV).username;
      p.g(paramView, "contact.username");
      com.tencent.mm.plugin.finder.report.h.a(4, l, 6, 1, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178136);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(bc parambc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201481);
      FinderPostProgressView localFinderPostProgressView = this.rPL.rOI;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201481);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rPL.rOI.invalidate();
      AppMethodBeat.o(201481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bc
 * JD-Core Version:    0.7.0.1
 */