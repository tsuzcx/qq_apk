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
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "tagImageView", "getTagImageView", "setTagImageView", "tipDialog", "Landroid/app/Dialog;", "bindMedia", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function0;", "isSelf", "plugin-finder_release"})
public final class bd
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView dtJ;
  private ImageView fTj;
  private TextView gVl;
  private TextView gXb;
  private ValueAnimator kqQ;
  private TextView ovs;
  private View rIf;
  private View rXh;
  FinderPostProgressView rXi;
  private View rXj;
  private WeImageView rYb;
  private ImageView rYc;
  private ImageView rYd;
  private View rYe;
  private View rYf;
  private View rYg;
  private TextView rYh;
  public Long rYi;
  private View rYj;
  
  public bd(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    View localView = paramView.findViewById(2131300050);
    p.g(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.dtJ = ((ImageView)localView);
    localView = paramView.findViewById(2131300052);
    p.g(localView, "itemView.findViewById(R.…nder_profile_item_tag_iv)");
    this.rYc = ((ImageView)localView);
    localView = paramView.findViewById(2131303465);
    p.g(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.gXb = ((TextView)localView);
    localView = paramView.findViewById(2131303505);
    p.g(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.rXi = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(2131303504);
    p.g(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.rIf = localView;
    localView = paramView.findViewById(2131303466);
    p.g(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.rXh = localView;
    localView = paramView.findViewById(2131307916);
    p.g(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.rXj = localView;
    localView = paramView.findViewById(2131303471);
    p.g(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.gVl = ((TextView)localView);
    localView = paramView.findViewById(2131300051);
    p.g(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.rYd = ((ImageView)localView);
    localView = paramView.findViewById(2131303921);
    p.g(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.rYe = localView;
    localView = paramView.findViewById(2131303131);
    p.g(localView, "itemView.findViewById(R.id.padding_view)");
    this.rYf = localView;
    this.rYb = ((WeImageView)paramView.findViewById(2131308377));
    localView = paramView.findViewById(2131297011);
    p.g(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.rYg = localView;
    localView = paramView.findViewById(2131297008);
    p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fTj = ((ImageView)localView);
    localView = paramView.findViewById(2131302867);
    p.g(localView, "itemView.findViewById(R.id.nickname_tv)");
    this.ovs = ((TextView)localView);
    this.rYj = paramView.findViewById(2131308376);
    this.rYh = ((TextView)paramView.findViewById(2131308312));
    AppMethodBeat.o(165497);
  }
  
  private static boolean d(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(201924);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null) {}
    for (paramBaseFinderFeed = paramBaseFinderFeed.field_username;; paramBaseFinderFeed = null)
    {
      boolean bool = d.n.n.H(paramBaseFinderFeed, com.tencent.mm.model.v.aAK(), false);
      AppMethodBeat.o(201924);
      return bool;
    }
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(165495);
    p.h(paramBaseFinderFeed, "feed");
    p.h(parama, "itemClickListener");
    Object localObject1;
    if (bu.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription()))
    {
      localObject1 = (CharSequence)"";
      localObject2 = this.rYb;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(0);
      }
      localObject2 = this.rYi;
      if ((localObject2 != null) && (((Number)localObject2).longValue() == paramBaseFinderFeed.lP()))
      {
        localObject2 = this.rYh;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(0);
        }
      }
      if (!paramBaseFinderFeed.feedObject.getMediaList().isEmpty()) {
        break label256;
      }
      ae.i(this.TAG, "invalid item id " + paramBaseFinderFeed.feedObject.getId());
      if (bu.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label244;
      }
      this.gXb.setVisibility(0);
      this.gXb.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.rXh.setVisibility(0);
      this.rIf.setVisibility(8);
      this.gVl.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      AppMethodBeat.o(165495);
      return;
      localObject1 = (CharSequence)k.c(ak.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription());
      break;
      label244:
      this.gXb.setVisibility(8);
    }
    label256:
    Object localObject2 = (bvz)j.jl((List)paramBaseFinderFeed.feedObject.getMediaList());
    Object localObject3 = this.dtJ.getLayoutParams();
    int i = ak.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject4 = ak.getContext().getResources();
    if (localObject4 == null) {
      p.gkB();
    }
    int k = (i - (int)((Resources)localObject4).getDimension(2131165294)) / 2;
    label546:
    label614:
    Object localObject5;
    if (k > 0)
    {
      int j = (int)(((bvz)localObject2).height * k / ((bvz)localObject2).width);
      i = j;
      if (j > k * 1.316667F) {
        i = (int)(k * 1.316667F);
      }
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ae.i(this.TAG, "onBindViewHolder " + lN() + " lpWidth:" + ((ViewGroup.LayoutParams)localObject3).width + ", lpHeight:" + ((ViewGroup.LayoutParams)localObject3).height + ", width:" + k + ", height:" + i + ", mediaWidth:" + ((bvz)localObject2).width + ", mediaHeight:" + ((bvz)localObject2).height);
      this.dtJ.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.rYe.setVisibility(8);
      if (paramBoolean1)
      {
        if (paramBaseFinderFeed.feedObject.getRefObjectFlag() != 2L) {
          break label1438;
        }
        this.dtJ.setImageResource(2131099656);
        this.rYe.setVisibility(0);
      }
      if (!paramBoolean2) {
        break label1655;
      }
      this.rYg.setVisibility(0);
      localObject4 = new y.f();
      ((y.f)localObject4).NiY = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject3 = com.tencent.mm.plugin.finder.loader.i.cEo();
      localObject2 = (FinderContact)((y.f)localObject4).NiY;
      if (localObject2 == null) {
        break label1649;
      }
      localObject2 = ((FinderContact)localObject2).headUrl;
      localObject2 = new com.tencent.mm.plugin.finder.loader.a((String)localObject2);
      localObject5 = this.fTj;
      Object localObject6 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((d)localObject3).a(localObject2, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      localObject5 = this.ovs;
      localObject6 = ak.getContext();
      localObject2 = com.tencent.mm.plugin.finder.search.h.sEe;
      localObject2 = (FinderContact)((y.f)localObject4).NiY;
      if (localObject2 != null)
      {
        localObject3 = ((FinderContact)localObject2).nickname;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      ((TextView)localObject5).setText((CharSequence)k.d((Context)localObject6, (CharSequence)com.tencent.mm.plugin.finder.search.h.aiW((String)localObject2), this.ovs.getTextSize()));
      al.a((Paint)this.ovs.getPaint(), 0.8F);
      this.fTj.setOnClickListener((View.OnClickListener)new a((y.f)localObject4, paramBaseFinderFeed, this));
      label768:
      if (bu.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label1679;
      }
      this.gXb.setVisibility(0);
      if (!paramBoolean2) {
        break label1667;
      }
      localObject1 = this.gXb;
      localObject2 = ak.getContext();
      localObject3 = com.tencent.mm.plugin.finder.search.h.sEe;
      localObject3 = paramBaseFinderFeed.feedObject.getDescription();
      localObject4 = this.gXb.getPaint();
      p.g(localObject4, "descTv.paint");
      localObject5 = com.tencent.mm.plugin.finder.search.h.sEe;
      ((TextView)localObject1).setText((CharSequence)k.d((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.search.h.a((String)localObject3, (TextPaint)localObject4, com.tencent.mm.plugin.finder.search.h.cGK() / 2), 0.0F));
      label869:
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label1691;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.h.fR(2, paramBaseFinderFeed.feedObject.getLikeCount());
      label892:
      this.gVl.setText((CharSequence)localObject1);
      if (((bvz)paramBaseFinderFeed.feedObject.getMediaList().get(0)).mediaType != 2) {
        break label1699;
      }
      this.rYc.setVisibility(0);
      this.rYc.setImageDrawable(ao.k(this.rYc.getContext(), 2131690348, com.tencent.mm.cb.a.n(this.rYc.getContext(), 2131099828)));
      label966:
      if (!d(paramBaseFinderFeed)) {
        break label1723;
      }
      localObject1 = this.rYb;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setImageResource(2131690399);
      }
      localObject1 = this.rYb;
      if (localObject1 != null)
      {
        localObject2 = this.auu;
        p.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        p.g(localObject2, "itemView.context");
        ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100017));
      }
      i = paramBaseFinderFeed.feedObject.getReadCount();
      this.gVl.setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(i));
      localObject1 = this.gVl;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      p.g(localObject2, "itemView.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100017));
      localObject1 = this.rXj;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      ((View)localObject1).setBackground(((View)localObject2).getContext().getDrawable(2131235053));
      label1156:
      if (paramBaseFinderFeed.feedObject.getRefObjectFlag() <= 0L) {
        break label1866;
      }
      this.rYd.setVisibility(0);
      label1176:
      this.auu.setOnClickListener((View.OnClickListener)new bd.b(parama));
      this.rXj.setVisibility(0);
      parama = this.kqQ;
      if (parama != null) {
        parama.cancel();
      }
      if ((!paramBaseFinderFeed.feedObject.isPostFailed()) && (!paramBaseFinderFeed.feedObject.isUploadFailed())) {
        break label1878;
      }
      this.rXh.setVisibility(0);
      this.rIf.setVisibility(8);
      this.rXj.setVisibility(8);
      label1265:
      if ((this.rXh.getVisibility() != 8) || (this.rIf.getVisibility() != 8) || (this.gXb.getVisibility() != 8) || (paramBoolean2)) {
        break label2035;
      }
      this.rYf.setVisibility(8);
      label1314:
      if (!d(paramBaseFinderFeed)) {
        break label2060;
      }
      parama = this.rYj;
      if (parama == null) {
        break label2053;
      }
      if (!paramBaseFinderFeed.feedObject.isPrivate()) {
        break label2046;
      }
    }
    label1438:
    label1649:
    label1655:
    label2046:
    for (i = 0;; i = 8)
    {
      parama.setVisibility(i);
      AppMethodBeat.o(165495);
      return;
      ae.i(this.TAG, "onBindViewHolder " + lN() + " width invalid:" + k + ", " + this.dtJ.getLayoutParams().width + ", " + this.dtJ.getLayoutParams().height);
      break;
      if (((bvz)localObject2).mediaType == 4)
      {
        localObject2 = (bvz)j.jl((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (bu.isNullOrNil(((bvz)localObject2).coverUrl))
        {
          localObject2 = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject2, r.sJv);
          localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
          localObject3 = com.tencent.mm.plugin.finder.loader.i.cEn();
          localObject4 = this.dtJ;
          localObject5 = com.tencent.mm.plugin.finder.loader.i.srW;
          ((d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
          break label546;
        }
        localObject2 = new com.tencent.mm.plugin.finder.loader.n((bvz)localObject2, r.sJu);
        localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject3 = com.tencent.mm.plugin.finder.loader.i.cEn();
        localObject4 = this.dtJ;
        localObject5 = com.tencent.mm.plugin.finder.loader.i.srW;
        ((d)localObject3).a(localObject2, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        break label546;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
      localObject3 = new com.tencent.mm.plugin.finder.loader.g((bvz)j.jl((List)paramBaseFinderFeed.feedObject.getMediaList()), r.sJv);
      localObject4 = this.dtJ;
      localObject5 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((d)localObject2).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
      break label546;
      localObject2 = null;
      break label614;
      this.rYg.setVisibility(8);
      break label768;
      this.gXb.setText((CharSequence)localObject1);
      break label869;
      this.gXb.setVisibility(8);
      break label869;
      localObject1 = "0";
      break label892;
      paramBaseFinderFeed.feedObject.getMediaList().get(0);
      this.rYc.setVisibility(8);
      break label966;
      localObject1 = this.rYb;
      if (localObject1 != null)
      {
        localObject2 = this.auu;
        p.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        p.g(localObject2, "itemView.context");
        ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131099828));
      }
      localObject1 = this.rXj;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      ((View)localObject1).setBackground(((View)localObject2).getContext().getDrawable(2131234890));
      localObject1 = this.gVl;
      localObject2 = this.auu;
      p.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      p.g(localObject2, "itemView.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099828));
      break label1156;
      this.rYd.setVisibility(8);
      break label1176;
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        this.rXh.setVisibility(8);
        this.rIf.setVisibility(8);
        break label1265;
      }
      this.rXh.setVisibility(8);
      this.rXj.setVisibility(8);
      this.rIf.setVisibility(0);
      this.kqQ = ValueAnimator.ofInt(new int[] { this.rXi.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().Hjb });
      parama = this.kqQ;
      if (parama == null) {
        p.gkB();
      }
      parama.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      parama = this.kqQ;
      if (parama == null) {
        p.gkB();
      }
      parama = parama.setDuration(400L);
      if (parama == null) {
        break label1265;
      }
      parama.start();
      break label1265;
      this.rYf.setVisibility(0);
      break label1314;
    }
    label1667:
    label1679:
    label1691:
    label1699:
    label1723:
    label1866:
    label1878:
    label2035:
    AppMethodBeat.o(165495);
    label2053:
    return;
    label2060:
    paramBaseFinderFeed = this.rYj;
    if (paramBaseFinderFeed != null)
    {
      paramBaseFinderFeed.setVisibility(8);
      AppMethodBeat.o(165495);
      return;
    }
    AppMethodBeat.o(165495);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$2$1"})
  static final class a
    implements View.OnClickListener
  {
    a(y.f paramf, BaseFinderFeed paramBaseFinderFeed, bd parambd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178136);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent();
      paramView = (FinderContact)this.rYk.NiY;
      long l;
      if (paramView != null)
      {
        paramView = paramView.username;
        ((Intent)localObject).putExtra("finder_username", paramView);
        paramView = FinderReporterUIC.tnG;
        paramView = jdField_this.auu;
        p.g(paramView, "itemView");
        paramView = paramView.getContext();
        p.g(paramView, "itemView.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject, paramBaseFinderFeed.lP(), 6, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = jdField_this.auu;
        p.g(paramView, "itemView");
        paramView = paramView.getContext();
        p.g(paramView, "itemView.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, (Intent)localObject);
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        l = paramBaseFinderFeed.lP();
        paramView = (FinderContact)this.rYk.NiY;
        if (paramView == null) {
          break label221;
        }
      }
      label221:
      for (paramView = paramView.username;; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.i.a(4, l, 6, 1, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178136);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(bd parambd) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201923);
      FinderPostProgressView localFinderPostProgressView = this.rYm.rXi;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201923);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rYm.rXi.invalidate();
      AppMethodBeat.o(201923);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bd
 * JD-Core Version:    0.7.0.1
 */