package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "getImageView", "setImageView", "itemContainer", "getItemContainer", "setItemContainer", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "isSelf", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ch
  extends RecyclerView.v
{
  private View ALK;
  private WeImageView ALM;
  private ImageIndicatorView ALN;
  private FinderLiveOnliveWidget ALO;
  private FinderLiveOnliveWidget ALP;
  private ImageView ALQ;
  private View ALR;
  private FinderPostProgressView ALS;
  private View ALT;
  private View ALU;
  private View ALV;
  private TextView ALW;
  private View ALX;
  private ImageView ALY;
  private final j AMa;
  private View AMj;
  private View AkF;
  private final String TAG;
  private TextView descTv;
  private ImageView hIz;
  private ImageView lKK;
  private TextView nga;
  private TextView nicknameTv;
  private Long readFeedId;
  private ValueAnimator rtf;
  
  public ch(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165497);
    this.TAG = "Finder.FinderProfileUIMediaViewHolder";
    this.AMa = kotlin.k.cm((kotlin.g.a.a)ch.a.AMk);
    this.ALK = paramView.findViewById(e.e.finder_mix_search_media_item_container);
    View localView = paramView.findViewById(e.e.finder_profile_item_image);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.…inder_profile_item_image)");
    this.hIz = ((ImageView)localView);
    localView = paramView.findViewById(e.e.image_indicator);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.image_indicator)");
    this.ALN = ((ImageIndicatorView)localView);
    localView = paramView.findViewById(e.e.finder_live_onlive_widget);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.ALO = ((FinderLiveOnliveWidget)localView);
    localView = paramView.findViewById(e.e.finder_live_mask_view);
    kotlin.g.b.s.s(localView, "itemView.findViewById<Fi…id.finder_live_mask_view)");
    this.ALP = ((FinderLiveOnliveWidget)localView);
    this.ALM = ((WeImageView)paramView.findViewById(e.e.profile_item_like_iv));
    localView = paramView.findViewById(e.e.profile_item_desc_tv);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.profile_item_desc_tv)");
    this.descTv = ((TextView)localView);
    localView = paramView.findViewById(e.e.profile_upload_progress);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.….profile_upload_progress)");
    this.ALS = ((FinderPostProgressView)localView);
    localView = paramView.findViewById(e.e.profile_upload_area);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.profile_upload_area)");
    this.AkF = localView;
    localView = paramView.findViewById(e.e.profile_item_failed_area);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.…profile_item_failed_area)");
    this.ALT = localView;
    localView = paramView.findViewById(e.e.profile_like_area);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.profile_like_area)");
    this.ALU = localView;
    localView = paramView.findViewById(e.e.profile_like_count_tv);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.profile_like_count_tv)");
    this.nga = ((TextView)localView);
    localView = paramView.findViewById(e.e.finder_profile_item_reprint_iv);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.…_profile_item_reprint_iv)");
    this.ALQ = ((ImageView)localView);
    localView = paramView.findViewById(e.e.ref_deleted_tips);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.ref_deleted_tips)");
    this.ALR = localView;
    localView = paramView.findViewById(e.e.padding_view);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.padding_view)");
    this.ALV = localView;
    this.ALM = ((WeImageView)paramView.findViewById(e.e.profile_item_like_iv));
    localView = paramView.findViewById(e.e.avatar_layout);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.avatar_layout)");
    this.AMj = localView;
    localView = paramView.findViewById(e.e.avatar_iv);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.lKK = ((ImageView)localView);
    localView = paramView.findViewById(e.e.nickname_tv);
    kotlin.g.b.s.s(localView, "itemView.findViewById(R.id.nickname_tv)");
    this.nicknameTv = ((TextView)localView);
    this.ALX = paramView.findViewById(e.e.private_icon_layout);
    this.ALY = ((ImageView)paramView.findViewById(e.e.profile_feed_icon_iv));
    this.ALW = ((TextView)paramView.findViewById(e.e.finder_profile_item_mask));
    AppMethodBeat.o(165497);
  }
  
  private static final void a(m paramm, ch paramch, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(349781);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramch);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBaseFinderFeed);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$it");
    label109:
    long l;
    if (paramm == null)
    {
      paramView = null;
      if (paramView == null)
      {
        localObject1 = new Intent();
        if (paramm != null) {
          break label362;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("finder_username", paramView);
        paramView = as.GSQ;
        paramView = paramch.caK.getContext();
        kotlin.g.b.s.s(paramView, "itemView.context");
        as.a.a(paramView, (Intent)localObject1, paramBaseFinderFeed.bZA(), 6, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramch = paramch.caK.getContext();
        kotlin.g.b.s.s(paramch, "itemView.context");
        paramView.enterFinderProfileUI(paramch, (Intent)localObject1);
      }
      paramch = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = paramBaseFinderFeed.bZA();
      if (paramm != null) {
        break label370;
      }
    }
    label362:
    label370:
    for (paramm = null;; paramm = paramm.getUsername())
    {
      com.tencent.mm.plugin.finder.report.z.a(4, l, 6, 1, paramm);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349781);
      return;
      paramView = com.tencent.mm.plugin.finder.api.c.b(paramm);
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      localObject2 = new Intent();
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Scene", 213);
      ((Intent)localObject2).putExtra("biz_profile_enter_from_finder", true);
      ((Intent)localObject2).putExtra("force_get_contact", true);
      ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
      ((Intent)localObject2).putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramch.caK.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      paramView = ah.aiuX;
      break;
      paramView = paramm.getUsername();
      break label109;
    }
  }
  
  private static final void a(ch paramch, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(349802);
    kotlin.g.b.s.u(paramch, "this$0");
    FinderPostProgressView localFinderPostProgressView = paramch.ALS;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramch = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(349802);
      throw paramch;
    }
    localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramch.ALS.invalidate();
    AppMethodBeat.o(349802);
  }
  
  private static final void b(kotlin.g.a.b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(349790);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$itemClickListener");
    paramb.invoke(Integer.valueOf(paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349790);
  }
  
  private final Point dXX()
  {
    AppMethodBeat.i(349755);
    Point localPoint = (Point)this.AMa.getValue();
    AppMethodBeat.o(349755);
    return localPoint;
  }
  
  private final boolean e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(349762);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null)
    {
      paramBaseFinderFeed = null;
      if (!kotlin.n.n.T(paramBaseFinderFeed, com.tencent.mm.model.z.bAW(), false)) {
        break label82;
      }
      paramBaseFinderFeed = this.caK.getTag(e.e.profile_convert_is_self_tag);
      if (!(paramBaseFinderFeed instanceof Boolean)) {
        break label77;
      }
    }
    label77:
    for (paramBaseFinderFeed = (Boolean)paramBaseFinderFeed;; paramBaseFinderFeed = null)
    {
      if (!kotlin.g.b.s.p(paramBaseFinderFeed, Boolean.TRUE)) {
        break label82;
      }
      AppMethodBeat.o(349762);
      return true;
      paramBaseFinderFeed = paramBaseFinderFeed.field_username;
      break;
    }
    label82:
    AppMethodBeat.o(349762);
    return false;
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(349890);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramb, "itemClickListener");
    Object localObject1 = this.descTv;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() == 1)
      {
        i = 2;
        ((TextView)localObject1).setMaxLines(i);
      }
    }
    else
    {
      if (!Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label288;
      }
      localObject1 = (CharSequence)"";
      label83:
      localObject2 = this.ALM;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(0);
      }
      this.nga.setVisibility(0);
      localObject2 = this.readFeedId;
      if (localObject2 != null)
      {
        if (((Number)localObject2).longValue() == paramBaseFinderFeed.bZA())
        {
          localObject2 = this.ALW;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            localObject2 = ah.aiuX;
            localObject2 = ah.aiuX;
          }
        }
        localObject2 = ah.aiuX;
        localObject2 = ah.aiuX;
      }
      if (!paramBaseFinderFeed.feedObject.getMediaList().isEmpty()) {
        break label315;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("invalid item id ", Long.valueOf(paramBaseFinderFeed.feedObject.getId())));
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label303;
      }
      this.descTv.setVisibility(0);
      this.descTv.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.ALT.setVisibility(0);
      this.AkF.setVisibility(8);
      this.nga.setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      AppMethodBeat.o(349890);
      return;
      i = 1;
      break;
      label288:
      localObject1 = (CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan();
      break label83;
      label303:
      this.descTv.setVisibility(8);
    }
    label315:
    label343:
    int j;
    label377:
    Object localObject3;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject1 = this.hIz.getLayoutParams();
      i = dXX().x;
      j = dXX().y;
      if (j < i) {
        break label1772;
      }
      i /= 2;
      localObject3 = av.GiL;
      j = av.a(paramBaseFinderFeed, (dji)localObject2, i);
      if (j <= 0) {
        break label1802;
      }
      ((ViewGroup.LayoutParams)localObject1).height = j;
      Log.i(this.TAG, "onBindViewHolder " + KJ() + " lpWidth:" + ((ViewGroup.LayoutParams)localObject1).width + ", lpHeight:" + ((ViewGroup.LayoutParams)localObject1).height + ", width:" + i + ", height:" + j + ", mediaWidth:" + ((dji)localObject2).width + ", mediaHeight:" + ((dji)localObject2).height);
      this.hIz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label524:
      this.ALR.setVisibility(8);
      if (paramBaseFinderFeed.feedObject.getRefObjectFlag() != 2L) {
        break label1881;
      }
      this.hIz.setImageResource(e.b.BW_0_Alpha_0_1);
      this.ALR.setVisibility(0);
    }
    label593:
    Object localObject5;
    label613:
    Object localObject4;
    for (;;)
    {
      this.AMj.setVisibility(0);
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      if (localObject1 != null) {
        break label2248;
      }
      localObject3 = null;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
      if (localObject3 != null) {
        break label2258;
      }
      localObject1 = "";
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1, v.FLG);
      localObject4 = this.lKK;
      Object localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject5 = this.nicknameTv;
      localObject6 = MMApplicationContext.getContext();
      localObject1 = com.tencent.mm.plugin.finder.search.k.FxZ;
      if (localObject3 != null) {
        break label2282;
      }
      localObject1 = "";
      label679:
      ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject6, (CharSequence)com.tencent.mm.plugin.finder.search.k.aAh((String)localObject1), this.nicknameTv.getTextSize()));
      com.tencent.mm.ui.aw.a((Paint)this.nicknameTv.getPaint(), 0.8F);
      this.lKK.setOnClickListener(new ch..ExternalSyntheticLambda1((m)localObject3, this, paramBaseFinderFeed));
      localObject1 = ah.aiuX;
      localObject1 = ah.aiuX;
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label2321;
      }
      this.descTv.setVisibility(0);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() != 1) {
        break label2306;
      }
      localObject1 = com.tencent.mm.plugin.finder.search.k.FxZ;
      i = com.tencent.mm.plugin.finder.search.k.ePd();
      label803:
      localObject1 = this.descTv;
      localObject3 = MMApplicationContext.getContext();
      localObject4 = com.tencent.mm.plugin.finder.search.k.FxZ;
      localObject4 = paramBaseFinderFeed.feedObject.getDescription();
      localObject5 = this.descTv.getPaint();
      kotlin.g.b.s.s(localObject5, "descTv.paint");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject3, (CharSequence)com.tencent.mm.plugin.finder.search.k.a((String)localObject4, (TextPaint)localObject5, i), 0.0F));
      label871:
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label2333;
      }
      localObject1 = r.ip(2, paramBaseFinderFeed.feedObject.getLikeCount());
      label894:
      this.nga.setText((CharSequence)localObject1);
      this.ALO.setVisibility(8);
      this.ALP.setVisibility(8);
      this.ALN.setVisibility(8);
      j = paramBaseFinderFeed.feedObject.getMediaType();
      switch (j)
      {
      case 3: 
      default: 
        this.ALN.setVisibility(8);
        localObject1 = ah.aiuX;
        label986:
        if (!e(paramBaseFinderFeed)) {
          break label2391;
        }
        localObject1 = this.ALM;
        if (localObject1 != null)
        {
          ((WeImageView)localObject1).setImageResource(e.g.icons_filled_eyes_on);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.ALM;
        if (localObject1 != null)
        {
          ((WeImageView)localObject1).setIconColor(this.caK.getContext().getResources().getColor(e.b.black));
          localObject1 = ah.aiuX;
        }
        i = paramBaseFinderFeed.feedObject.getReadCount();
        this.nga.setText((CharSequence)r.TR(i));
        this.nga.setTextColor(this.caK.getContext().getResources().getColor(e.b.black));
        this.ALU.setBackground(this.caK.getContext().getDrawable(e.d.finder_stagged_feed_float_sef_bg));
        label1122:
        if (paramBaseFinderFeed.feedObject.getRefObjectFlag() <= 0L) {
          break label2653;
        }
        this.ALQ.setVisibility(0);
        label1142:
        this.caK.setOnClickListener(new ch..ExternalSyntheticLambda2(paramb, j));
        this.ALU.setVisibility(0);
        paramb = this.rtf;
        if (paramb != null)
        {
          paramb.cancel();
          paramb = ah.aiuX;
        }
        if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
          break label2665;
        }
        this.ALT.setVisibility(0);
        this.AkF.setVisibility(8);
        this.ALU.setVisibility(8);
        label1220:
        if ((this.ALT.getVisibility() == 8) && (this.AkF.getVisibility() == 8)) {
          this.descTv.getVisibility();
        }
        this.ALV.setVisibility(0);
        if (!e(paramBaseFinderFeed)) {
          break label2878;
        }
        paramb = this.ALX;
        if (paramb != null) {
          paramb.setVisibility(8);
        }
        if (!paramBaseFinderFeed.feedObject.isPrivate()) {
          break label2865;
        }
        localObject1 = this.ALY;
        label1315:
        int k;
        if (localObject1 != null)
        {
          paramb = this.ALY;
          if (paramb != null) {
            break label2808;
          }
          paramb = null;
          k = e.g.icons_filled_lock;
          localObject3 = this.ALY;
          if (localObject3 != null) {
            break label2816;
          }
          i = 0;
          label1334:
          ((ImageView)localObject1).setImageDrawable(bb.m(paramb, k, i));
          paramb = ah.aiuX;
        }
        paramb = this.ALX;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        label1365:
        paramb = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (com.tencent.mm.plugin.finder.utils.aw.s(paramBaseFinderFeed))
        {
          paramb = paramBaseFinderFeed.feedObject.getLiveInfo();
          if ((paramb == null) || (paramb.liveStatus != 1)) {
            break label2904;
          }
          i = 1;
          label1399:
          if (i == 0) {
            break label2946;
          }
          this.ALO.setVisibility(0);
          paramb = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          localObject1 = (View)this.ALO;
          if (!((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(paramBaseFinderFeed.feedObject.getLiveInfo())) {
            break label2910;
          }
          i = 2;
          label1458:
          paramb.setFinderLiveTagText((View)localObject1, i);
          this.ALP.setVisibility(8);
          paramb = this.ALM;
          if (paramb != null) {
            paramb.setVisibility(8);
          }
          paramb = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramb != null) {
            break label2916;
          }
          i = 0;
          label1507:
          if (i <= 0) {
            break label2925;
          }
          this.nga.setText((CharSequence)this.caK.getContext().getString(e.h.finder_live_members_total_tip, new Object[] { r.ip(2, i) }));
          label1548:
          this.descTv.setVisibility(8);
        }
        paramb = this.ALK;
        if (paramb != null)
        {
          paramb.setTag(e.e.finder_accessibility_content_desc_tag, this.descTv.getText());
          paramb.setTag(e.e.finder_accessibility_nickname_tag, this.nicknameTv.getText());
          k = e.e.finder_accessibility_auth_icon_type_tag;
          localObject1 = paramBaseFinderFeed.contact;
          if (localObject1 != null) {
            break label2966;
          }
          i = 0;
          label1613:
          paramb.setTag(k, Integer.valueOf(i));
          paramb.setTag(e.e.finder_accessibility_media_type_tag, Integer.valueOf(j));
          paramb.setTag(e.e.finder_accessibility_like_count_tag, this.nga.getText());
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("mediaType:").append(((dji)localObject2).mediaType).append(",liveStatus:");
        paramb = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramb != null) {
          break label2994;
        }
        paramb = null;
        label1704:
        paramb = ((StringBuilder)localObject2).append(paramb).append(",contact liveStatus:");
        paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getRefObjectContact();
        if (paramBaseFinderFeed != null) {
          break label3005;
        }
        paramBaseFinderFeed = null;
        label1731:
        Log.i((String)localObject1, paramBaseFinderFeed);
        AppMethodBeat.o(349890);
        return;
        localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
        break label343;
        label1772:
        localObject3 = MMApplicationContext.getContext().getResources();
        kotlin.g.b.s.checkNotNull(localObject3);
        i = j - (int)((Resources)localObject3).getDimension(e.c.Edge_4A);
        break label377;
        label1802:
        Log.i(this.TAG, "onBindViewHolder " + KJ() + " width invalid:" + i + ", " + this.hIz.getLayoutParams().width + ", " + this.hIz.getLayoutParams().height);
        break label524;
        label1881:
        if (((dji)localObject2).mediaType != 4) {
          break label2011;
        }
        if (Util.isNullOrNil(((dji)localObject2).coverUrl))
        {
          localObject1 = new com.tencent.mm.plugin.finder.loader.n((dji)localObject2, v.FKZ, null, null, 12);
          localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject4 = this.hIz;
          localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        }
        else
        {
          localObject1 = new t((dji)localObject2, v.FKY);
          localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject4 = this.hIz;
          localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        }
        break;
      }
    }
    label2011:
    if (((dji)localObject2).mediaType == 9)
    {
      localObject3 = ((dji)localObject2).coverUrl;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label3016;
      }
      localObject1 = kotlin.g.b.s.X(((dji)localObject2).thumbUrl, Util.nullAsNil(((dji)localObject2).thumb_url_token));
    }
    label2306:
    label2321:
    label2333:
    label2865:
    label2878:
    label3016:
    for (;;)
    {
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject3 != null) && (((bip)localObject3).liveStatus == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2158;
        }
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY);
        localObject4 = this.hIz;
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        break;
      }
      label2158:
      localObject3 = com.tencent.mm.kernel.h.ax(g.class);
      kotlin.g.b.s.s(localObject3, "service(IFinderCommonLiveService::class.java)");
      g.a.a((g)localObject3, this.hIz, (String)localObject1);
      break;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject3 = new com.tencent.mm.plugin.finder.loader.n((dji)localObject2, v.FKZ, null, null, 12);
      localObject4 = this.hIz;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      break;
      label2248:
      localObject3 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject1);
      break label593;
      label2258:
      localObject4 = ((m)localObject3).amx();
      localObject1 = localObject4;
      if (localObject4 != null) {
        break label613;
      }
      localObject1 = "";
      break label613;
      label2282:
      localObject4 = ((m)localObject3).getNickname();
      localObject1 = localObject4;
      if (localObject4 != null) {
        break label679;
      }
      localObject1 = "";
      break label679;
      localObject1 = com.tencent.mm.plugin.finder.search.k.FxZ;
      i = com.tencent.mm.plugin.finder.search.k.ePd() / 2;
      break label803;
      this.descTv.setVisibility(8);
      break label871;
      localObject1 = "0";
      break label894;
      this.ALN.setVisibility(0);
      this.ALN.RVj = paramBaseFinderFeed.feedObject.getMediaList().size();
      localObject1 = ah.aiuX;
      break label986;
      this.ALN.setVisibility(8);
      localObject1 = ah.aiuX;
      break label986;
      label2391:
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.h.TA(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (localObject3 != null)
      {
        localObject1 = (CharSequence)((brk)localObject3).ZZy;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label2532;
        }
      }
      label2532:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2538;
        }
        localObject1 = this.ALM;
        if (localObject1 != null)
        {
          ((WeImageView)localObject1).setIconColor(this.caK.getContext().getResources().getColor(e.b.White));
          localObject1 = ah.aiuX;
        }
        this.ALU.setBackground(this.caK.getContext().getDrawable(e.d.finder_stagged_feed_float_bg));
        this.nga.setTextColor(this.caK.getContext().getResources().getColor(e.b.White));
        break;
      }
      label2538:
      localObject4 = this.ALM;
      if (localObject4 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject3 = new com.tencent.mm.plugin.finder.loader.s(((brk)localObject3).ZZy, v.FKY);
        localObject4 = (ImageView)localObject4;
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = this.ALM;
      if (localObject1 == null) {
        break label1122;
      }
      ((WeImageView)localObject1).setColorFilter(com.tencent.mm.cd.a.w(this.caK.getContext(), e.b.White), PorterDuff.Mode.SRC_ATOP);
      localObject1 = ah.aiuX;
      break label1122;
      label2653:
      this.ALQ.setVisibility(8);
      break label1142;
      label2665:
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        this.ALT.setVisibility(8);
        this.AkF.setVisibility(8);
        break label1220;
      }
      this.ALT.setVisibility(8);
      this.ALU.setVisibility(8);
      this.AkF.setVisibility(0);
      this.rtf = ValueAnimator.ofInt(new int[] { this.ALS.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().aaPw });
      paramb = this.rtf;
      kotlin.g.b.s.checkNotNull(paramb);
      paramb.addUpdateListener(new ch..ExternalSyntheticLambda0(this));
      paramb = this.rtf;
      kotlin.g.b.s.checkNotNull(paramb);
      paramb = paramb.setDuration(400L);
      if (paramb == null) {
        break label1220;
      }
      paramb.start();
      paramb = ah.aiuX;
      break label1220;
      label2808:
      paramb = paramb.getContext();
      break label1315;
      localObject3 = ((ImageView)localObject3).getContext();
      if (localObject3 == null)
      {
        i = 0;
        break label1334;
      }
      localObject3 = ((Context)localObject3).getResources();
      if (localObject3 == null)
      {
        i = 0;
        break label1334;
      }
      i = ((Resources)localObject3).getColor(e.b.black);
      break label1334;
      if (paramBaseFinderFeed.feedObject.getStickyTime() <= 0) {
        break label1365;
      }
      break label1365;
      paramb = this.ALX;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      paramBaseFinderFeed.feedObject.getStickyTime();
      break label1365;
      label2904:
      i = 0;
      break label1399;
      label2910:
      i = 0;
      break label1458;
      label2916:
      i = paramb.EOg;
      break label1507;
      label2925:
      this.nga.setVisibility(8);
      this.ALU.setVisibility(8);
      break label1548;
      this.ALO.setVisibility(8);
      this.ALP.setVisibility(0);
      break label1548;
      localObject1 = ((m)localObject1).field_authInfo;
      if (localObject1 == null)
      {
        i = 0;
        break label1613;
      }
      i = ((FinderAuthInfo)localObject1).authIconType;
      break label1613;
      paramb = Integer.valueOf(paramb.liveStatus);
      break label1704;
      paramBaseFinderFeed = Integer.valueOf(paramBaseFinderFeed.liveStatus);
      break label1731;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ch
 * JD-Core Version:    0.7.0.1
 */