package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveRecommendView;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "commentScene", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZII)V", "getCommentScene", "()I", "liveFeedStateChangeListener", "com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$liveFeedStateChangeListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$liveFeedStateChangeListener$1;", "lockScreenRecord", "getLockScreenRecord", "()Z", "setLockScreenRecord", "(Z)V", "calculateMediaLayoutParams", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "convertMedia", "position", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "withAnim", "getLayoutId", "handleLiveStatusEnd", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "isNeedHideLoading", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onFocusFeedCenter", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "e", "Landroid/view/MotionEvent;", "onUnFocusFeedCenter", "isFromScroll", "onVideoPause", "ev", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "onVideoRealPlay", "onViewRecycled", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "isOnlyShowDesc", "blinkDuration", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFinderLivingStatusView", "refreshLiveIcon", "refreshLivingIcon", "refreshMask", "liveStatus", "tryToLockScreenRecord", "window", "Landroid/view/Window;", "tryToUnlockScreenRecord", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends FinderFeedFullConvert<x>
{
  public static final a AJm;
  private final com.tencent.mm.plugin.finder.feed.i AIh;
  private final l AJn;
  private final int AJo;
  private final FinderFeedFullLiveConvert.liveFeedStateChangeListener.1 AJp;
  private volatile boolean AJq;
  
  static
  {
    AppMethodBeat.i(350741);
    AJm = new a((byte)0);
    AppMethodBeat.o(350741);
  }
  
  public r(l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(parami, paramBoolean, paramInt1);
    AppMethodBeat.i(350585);
    this.AJn = paraml;
    this.AIh = parami;
    this.AJo = paramInt2;
    this.AJp = new FinderFeedFullLiveConvert.liveFeedStateChangeListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(350585);
  }
  
  private static final void a(r paramr, j paramj, x paramx, View paramView)
  {
    AppMethodBeat.i(350693);
    s.u(paramr, "this$0");
    s.u(paramj, "$holder");
    s.u(paramx, "$item");
    paramView = paramj.caK;
    s.s(paramView, "holder.itemView");
    paramr.a(paramj, paramView, paramx.feedObject.getFinderObject());
    AppMethodBeat.o(350693);
  }
  
  private final void a(cc paramcc, j paramj, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(350623);
    Intent localIntent = new Intent();
    localIntent.putExtra("LAUNCH_WITH_ANIM", paramBoolean);
    localIntent.putExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", true);
    MMActivity localMMActivity = this.AIh.getActivity();
    Object localObject1;
    label69:
    Object localObject2;
    Object localObject3;
    if (localMMActivity != null)
    {
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label338;
      }
      localObject1 = (BaseFinderFeed)paramcc;
      if (localObject1 != null) {
        break label344;
      }
      localObject2 = new bkt();
      localObject3 = new bks();
      bcc localbcc = new bcc();
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((ap)com.tencent.mm.ui.component.k.d((AppCompatActivity)localMMActivity).cq(ap.class)).nw(l);
      if (localObject1 != null) {
        break label366;
      }
      localObject1 = null;
      label135:
      localbcc.ZNk = ((String)localObject1);
      localObject1 = ah.aiuX;
      ((bks)localObject3).ZMQ = localbcc;
      localObject1 = ah.aiuX;
      ((bkt)localObject2).ZTQ = ((bks)localObject3);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label376;
      }
      localObject1 = (BaseFinderFeed)paramcc;
      label179:
      if (localObject1 != null) {
        break label382;
      }
      localObject1 = null;
      label187:
      ((bkt)localObject2).ZTR = ((String)localObject1);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label410;
      }
      localObject1 = (BaseFinderFeed)paramcc;
      label207:
      if (localObject1 != null) {
        break label416;
      }
      localObject1 = null;
    }
    for (;;)
    {
      ((bkt)localObject2).location = ((boi)localObject1);
      localIntent.putExtra("PRE_JOIN_LIVE_INFO", ((bkt)localObject2).toByteArray());
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramcc);
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      s.s(localObject2, "service(IActivityRouter::class.java)");
      localObject2 = (com.tencent.mm.plugin.f)localObject2;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      s.s(localObject3, "service(IFinderCommonLiveService::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject2, paramj, g.a.a((com.tencent.mm.plugin.g)localObject3, (ArrayList)localObject1, paramcc, this.AJo), null, null, localIntent, false, 44);
      AppMethodBeat.o(350623);
      return;
      label338:
      localObject1 = null;
      break;
      label344:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null) {
        break label69;
      }
      l = ((FinderItem)localObject1).getId();
      break label69;
      label366:
      localObject1 = ((bcc)localObject1).ZNk;
      break label135;
      label376:
      localObject1 = null;
      break label179;
      label382:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label187;
      }
      localObject1 = ((FinderItem)localObject1).getDescription();
      break label187;
      label410:
      localObject1 = null;
      break label207;
      label416:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FinderItem)localObject1).getLocation();
      }
    }
  }
  
  private void a(j paramj, x paramx, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350647);
    s.u(paramj, "holder");
    s.u(paramx, "item");
    super.a(paramj, (BaseFinderFeed)paramx, paramInt1, paramInt2, paramBoolean, paramList);
    label110:
    Object localObject1;
    label118:
    ImageView localImageView;
    dji localdji;
    Object localObject2;
    label188:
    label220:
    label240:
    label248:
    long l2;
    if (!paramBoolean)
    {
      Log.i("Finder.FeedFullLiveConvert", s.X("onBindViewHolder liveFeedStateChangeListener:", this.AJp));
      this.AJp.alive();
      paramList = paramx.feedObject.getLiveInfo();
      if (paramList != null) {
        break label502;
      }
      paramInt1 = 2;
      paramList = ((FinderMediaBanner)paramj.UH(e.e.media_banner)).getAdapter();
      if (!(paramList instanceof FinderMediaBannerAdapter)) {
        break label511;
      }
      paramList = (FinderMediaBannerAdapter)paramList;
      if (paramList != null) {
        break label517;
      }
      localObject1 = null;
      localImageView = (ImageView)paramj.UH(e.e.finder_live_blur_view);
      View localView = paramj.UH(e.e.live_loading_video);
      localdji = (dji)kotlin.a.p.oL((List)paramx.feedObject.getLiveMediaList());
      if (localdji == null)
      {
        localObject2 = new StringBuilder();
        paramList = paramx.feedObject.getLiveInfo();
        if (paramList != null) {
          break label551;
        }
        paramList = null;
        Log.i("Finder.FeedFullLiveConvert", paramList + " firstMedia is empty");
      }
      if (localdji != null) {
        break label564;
      }
      paramList = "";
      localObject2 = paramList;
      if (Util.isNullOrNil(paramList))
      {
        if (localdji != null) {
          break label588;
        }
        paramList = null;
        if (localdji != null) {
          break label598;
        }
        localObject2 = null;
        localObject2 = s.X(paramList, Util.nullAsNil((String)localObject2));
      }
      paramList = paramx.contact;
      if (paramList != null) {
        break label608;
      }
      paramList = null;
      label274:
      Log.i("Finder.FeedFullLiveConvert", s.X("refreshMask item=", paramList));
      localImageView.setVisibility(0);
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (paramInt1 != 1) {
        break label618;
      }
      paramj.caK.post(new r..ExternalSyntheticLambda1(paramj, paramx, paramInt1, this));
      label330:
      if (!a(paramx)) {
        break label632;
      }
      paramList = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramList = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject1 = new com.tencent.mm.plugin.finder.loader.i((String)localObject2);
      s.s(localImageView, "blurView");
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramList.a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      if (localView != null) {
        localView.setVisibility(8);
      }
      label398:
      paramj = paramj.caK.getContext();
      if (!(paramj instanceof MMFinderUI)) {
        break label675;
      }
      paramj = (MMFinderUI)paramj;
      label418:
      if (paramj != null)
      {
        paramList = com.tencent.mm.ui.component.k.aeZF;
        paramList = (ap)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramj).cq(ap.class);
        l2 = paramx.feedObject.getId();
        localObject1 = paramx.feedObject.getObjectNonceId();
        paramx = paramx.feedObject.getLiveInfo();
        if (paramx != null) {
          break label680;
        }
      }
    }
    label517:
    label551:
    label680:
    for (long l1 = 0L;; l1 = paramx.liveId)
    {
      paramList.a(l2, (String)localObject1, l1, (Context)paramj);
      AppMethodBeat.o(350647);
      return;
      label502:
      paramInt1 = paramList.liveStatus;
      break;
      label511:
      paramList = null;
      break label110;
      paramList = paramList.GGd;
      if (paramList == null)
      {
        localObject1 = null;
        break label118;
      }
      localObject1 = (ImageView)paramList.findViewById(e.e.thumb_video);
      break label118;
      paramList = Long.valueOf(paramList.liveId);
      break label188;
      label564:
      localObject2 = localdji.coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 != null) {
        break label220;
      }
      paramList = "";
      break label220;
      label588:
      paramList = localdji.thumbUrl;
      break label240;
      label598:
      localObject2 = localdji.thumb_url_token;
      break label248;
      label608:
      paramList = paramList.getNickname();
      break label274;
      label618:
      a(paramj, paramx.feedObject.getLiveInfo());
      break label330;
      label632:
      paramList = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      s.s(paramList, "service(IFinderCommonLiveService::class.java)");
      paramList = (com.tencent.mm.plugin.g)paramList;
      s.s(localImageView, "blurView");
      g.a.a(paramList, localImageView, (String)localObject2);
      break label398;
      paramj = null;
      break label418;
    }
  }
  
  private static final void a(j paramj, x paramx, int paramInt, r paramr)
  {
    AppMethodBeat.i(350706);
    s.u(paramj, "$holder");
    s.u(paramx, "$item");
    s.u(paramr, "this$0");
    ((FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view)).a(paramx.feedObject.getLiveInfo(), paramInt);
    ((FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view)).setOnClickListener(new r..ExternalSyntheticLambda0(paramr, paramj, paramx));
    AppMethodBeat.o(350706);
  }
  
  public static void a(j paramj, bip parambip)
  {
    AppMethodBeat.i(350683);
    if (paramj == null) {}
    for (parambip = null;; parambip = ah.aiuX)
    {
      if (parambip == null) {
        Log.w("Finder.FeedFullLiveConvert", s.X("handleLiveStatus holder:", paramj));
      }
      AppMethodBeat.o(350683);
      return;
      Log.i("Finder.FeedFullLiveConvert", "handleLiveStatus");
      Object localObject = paramj.UH(e.e.live_loading_video);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = (ImageView)paramj.UH(e.e.finder_live_blur_view);
      if (localObject != null)
      {
        ((ImageView)localObject).animate().cancel();
        ((ImageView)localObject).setVisibility(0);
      }
      ((FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view)).a(parambip, 2);
    }
  }
  
  private static boolean a(x paramx)
  {
    AppMethodBeat.i(350672);
    Object localObject1 = paramx.feedObject.getLiveInfo();
    boolean bool;
    label38:
    label58:
    Object localObject2;
    if (localObject1 == null)
    {
      bool = false;
      if (!bool)
      {
        localObject1 = paramx.feedObject.getLiveInfo();
        if (localObject1 != null) {
          break label153;
        }
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label161;
        }
        i = 1;
        if (i == 0)
        {
          localObject1 = paramx.feedObject.getLiveInfo();
          if (localObject1 == null) {
            break label166;
          }
          localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          if (com.tencent.mm.plugin.finder.live.view.convert.a.b((bip)localObject1)) {
            break label166;
          }
          i = 1;
          label88:
          if (i == 0)
          {
            paramx = paramx.feedObject.getLiveInfo();
            if ((paramx == null) || (paramx.ZSl != 1)) {
              break label171;
            }
          }
        }
      }
    }
    label153:
    label161:
    label166:
    label171:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label176;
      }
      AppMethodBeat.o(350672);
      return true;
      localObject1 = ((bip)localObject1).ZSn;
      if (localObject1 == null)
      {
        bool = false;
        break;
      }
      localObject2 = com.tencent.d.a.a.a.b.b.ahnU;
      bool = com.tencent.d.a.a.a.b.b.a((bgr)localObject1);
      break;
      localObject1 = ((bip)localObject1).mIE;
      break label38;
      i = 0;
      break label58;
      i = 0;
      break label88;
    }
    label176:
    AppMethodBeat.o(350672);
    return false;
  }
  
  private final void c(Window paramWindow)
  {
    AppMethodBeat.i(350660);
    if ((this.AJq) && (paramWindow != null)) {
      paramWindow.clearFlags(8192);
    }
    StringBuilder localStringBuilder = new StringBuilder("unlock screen record:").append(this.AJq).append(",window:");
    if (paramWindow != null) {}
    for (int i = paramWindow.hashCode();; i = 0)
    {
      Log.i("Finder.FeedFullLiveConvert", i + '!');
      this.AJq = false;
      AppMethodBeat.o(350660);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350778);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.AIh.ebz());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    paramj.pt(e.e.awesome_icon_container, 8);
    paramj.pt(e.e.comment_icon_container, 8);
    paramj.pt(e.e.share_icon_container, 8);
    paramj.pt(e.e.star_icon_container, 8);
    paramj.pt(e.e.star_icon_container_first, 8);
    AppMethodBeat.o(350778);
  }
  
  protected final void a(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350893);
    s.u(parama, "ev");
    Object localObject1 = this.mkw;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        break label58;
      }
    }
    label58:
    for (localObject1 = (WxRecyclerAdapter)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label63;
      }
      AppMethodBeat.o(350893);
      return;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break;
    }
    label63:
    localObject1 = (j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, parama.feedId);
    if (localObject1 == null)
    {
      AppMethodBeat.o(350893);
      return;
    }
    parama = ((j)localObject1).CSA;
    if ((parama instanceof x)) {}
    for (parama = (x)parama; parama == null; parama = null)
    {
      AppMethodBeat.o(350893);
      return;
    }
    Object localObject3 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    Object localObject4 = ((j)localObject1).context;
    s.s(localObject4, "holder.context");
    localObject3 = ((com.tencent.mm.plugin.h)localObject3).el((Context)localObject4);
    if (localObject3 == null) {}
    for (int i = 0;; i = ((bn)localObject3).fow())
    {
      ((FinderFeedLiveRecommendView)((j)localObject1).UH(e.e.finder_feed_live_recommend_view)).c(parama);
      if (((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(this.hJx, i, (BaseFinderFeed)parama)) {
        break;
      }
      AppMethodBeat.o(350893);
      return;
    }
    localObject3 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
    localObject4 = parama.feedObject.getFeedObject();
    parama = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    localObject1 = ((j)localObject1).context;
    s.s(localObject1, "holder.context");
    parama = parama.el((Context)localObject1);
    if (parama == null) {}
    for (parama = localObject2;; parama = parama.fou())
    {
      ((com.tencent.mm.plugin.g)localObject3).b((FinderObject)localObject4, parama);
      AppMethodBeat.o(350893);
      return;
    }
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350869);
    s.u(paramj, "holder");
    super.a(paramj, paramInt1, paramInt2, paramBoolean);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = paramj.context;
    s.s(localObject1, "holder.context");
    paramInt1 = ((FinderHomeUIC)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(FinderHomeUIC.class)).fnX();
    StringBuilder localStringBuilder = new StringBuilder("onUnFocusFeedCenter isFromScroll:").append(paramBoolean).append(",newTabType:").append(paramInt1).append(",curTabType:").append(this.hJx).append(',');
    localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localObject1 = paramj.CSA;
    if ((localObject1 instanceof x))
    {
      localObject1 = (x)localObject1;
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = null;
      label141:
      Log.i("Finder.FeedFullLiveConvert", com.tencent.mm.plugin.finder.live.view.convert.a.c((bip)localObject1));
      if ((paramBoolean) || (paramInt1 != this.hJx))
      {
        paramj = paramj.getRecyclerView().getContext();
        if (!(paramj instanceof Activity)) {
          break label246;
        }
        paramj = (Activity)paramj;
        label193:
        if (paramj != null) {
          break label251;
        }
      }
    }
    label218:
    label246:
    label251:
    for (paramj = localObject2;; paramj = paramj.getWindow())
    {
      c(paramj);
      AppMethodBeat.o(350869);
      return;
      localObject1 = null;
      break;
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label141;
      }
      localObject1 = ((FinderItem)localObject1).getLiveInfo();
      break label141;
      paramj = null;
      break label193;
    }
  }
  
  public final void a(j paramj, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(350880);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    s.u(paramMotionEvent, "e");
    AppMethodBeat.o(350880);
  }
  
  public final void a(j paramj, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(350786);
    s.u(paramj, "holder");
    paramj = (FinderFeedLiveNoticeView)paramj.UH(e.e.finder_feed_live_notice_view);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    AppMethodBeat.o(350786);
  }
  
  public final boolean a(final j paramj, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(350824);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    s.u(paramFinderObject, "finderObj");
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUp();
    ((FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view)).fkz();
    Object localObject3 = (FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view);
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).putAll((Map)((FinderFeedLiveRecommendView)localObject3).Gzi);
    Object localObject4 = (Map)localObject2;
    if (((FinderFeedLiveRecommendView)localObject3).Gzg)
    {
      localObject1 = "1";
      ((Map)localObject4).put("button_colour", localObject1);
      if (!((FinderFeedLiveRecommendView)localObject3).Gzg)
      {
        localObject1 = ((FinderFeedLiveRecommendView)localObject3).Gzb;
        if (localObject1 == null) {
          break label426;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label420;
        }
        i = 1;
        label157:
        if (i != 1) {
          break label426;
        }
      }
    }
    long l1;
    label420:
    label426:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((Map)localObject2).put("text_index", String.valueOf(((FinderFeedLiveRecommendView)localObject3).Gzd - 2));
        localObject1 = (Map)localObject2;
        localObject4 = ((FinderFeedLiveRecommendView)localObject3).Gzb;
        s.checkNotNull(localObject4);
        localObject3 = ((LinkedList)localObject4).get(((FinderFeedLiveRecommendView)localObject3).Gzd - 2);
        s.s(localObject3, "recommendTips!![curVisiblePosition - 2]");
        ((Map)localObject1).put("text_value", localObject3);
      }
      localObject1 = c.zGj;
      s.u(localObject2, "extra");
      c.n((HashMap)localObject2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.s.Dvg, (Map)localObject2);
      if (!Util.isEqual(paramFinderObject.username, z.bAW())) {
        break label432;
      }
      paramView = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      s.s(paramView, "service(IActivityRouter::class.java)");
      localObject2 = (com.tencent.mm.plugin.f)paramView;
      localObject3 = paramj.context;
      s.s(localObject3, "holder.context");
      l1 = paramFinderObject.id;
      paramView = paramFinderObject.objectNonceId;
      paramj = paramView;
      if (paramView == null) {
        paramj = "";
      }
      localObject1 = paramFinderObject.liveInfo;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = new bip();
      }
      f.a.a((com.tencent.mm.plugin.f)localObject2, (Context)localObject3, l1, paramj, paramView, null, null, null, null, null, paramFinderObject.sessionBuffer, null, null, 7152);
      AppMethodBeat.o(350824);
      return true;
      localObject1 = "0";
      break;
      i = 0;
      break label157;
    }
    label432:
    Object localObject1 = paramj.context.getClass().getName();
    Log.i("Finder.FeedFullLiveConvert", s.X("HABBYGE-MALI, onMediaClick, pageName=", localObject1));
    long l3;
    long l4;
    long l2;
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", localObject1)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", localObject1)))
    {
      localObject3 = (String)((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqg.get(c.zGs);
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.kernel.h.ax(ce.class);
        s.s(localObject1, "service(IHellLiveReport::class.java)");
        localObject4 = (ce)localObject1;
        l3 = paramFinderObject.id;
        localObject1 = paramFinderObject.liveInfo;
        if (localObject1 == null)
        {
          l1 = 0L;
          localObject2 = paramFinderObject.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          l4 = paramj.KJ();
          localObject2 = paramFinderObject.liveInfo;
          if (localObject2 != null) {
            break label860;
          }
          l2 = -1L;
          label599:
          ce.a.a((ce)localObject4, l3, l1, (String)localObject1, l4, l2, q.w.DwU, (String)localObject3);
        }
      }
      else
      {
        Log.i("Finder.FeedFullLiveConvert", s.X("HABBYGE-MALI, onMediaClick, pageObj:", c.zGs));
      }
    }
    label690:
    boolean bool;
    label713:
    label736:
    do
    {
      localObject1 = ((FinderMediaBanner)paramj.UH(e.e.media_banner)).getPagerView().fU(0);
      s.checkNotNull(localObject1);
      s.s(localObject1, "banner.pagerView.findVie…erForAdapterPosition(0)!!");
      localObject1 = (FinderVideoLayout)((RecyclerView.v)localObject1).caK.findViewById(e.e.finder_banner_video_layout);
      if (localObject1 != null) {
        break label1258;
      }
      localObject1 = null;
      localObject2 = paramFinderObject.liveInfo;
      if ((localObject2 == null) || (((bip)localObject2).liveStatus != 1)) {
        break label1268;
      }
      bool = true;
      localObject2 = paramFinderObject.liveInfo;
      if ((localObject2 == null) || (((bip)localObject2).ZSl != 1)) {
        break label1274;
      }
      i = 1;
      Log.i("Finder.FeedFullLiveConvert", s.X("liveStatusOpen ", Boolean.valueOf(bool)));
      if ((localObject1 == null) || (!((t)localObject1).isPlaying())) {
        break label1362;
      }
      localObject2 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
      if ((!com.tencent.mm.plugin.finder.live.fluent.a.isEnable()) || (com.tencent.mm.n.a.r(paramView.getContext(), false)) || (!bool) || (i != 0)) {
        break label1362;
      }
      l1 = paramFinderObject.id;
      paramFinderObject = ((t)localObject1).pu(l1);
      if (paramFinderObject != null) {
        break label1280;
      }
      paramView = paramj.CSA;
      s.s(paramView, "holder.getAssociatedObject()");
      a((cc)paramView, paramj, false);
      AppMethodBeat.o(350824);
      return true;
      l1 = ((bip)localObject1).liveId;
      break;
      l2 = ((bip)localObject2).DSe;
      break label599;
      localObject4 = q.w.DwU;
      localObject1 = (String)((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqf.get(localObject1);
    } while (localObject1 == null);
    label860:
    if (s.p(localObject1, "27"))
    {
      localObject1 = c.zGj;
      if (c.dKo()) {
        localObject1 = "27";
      }
    }
    label1280:
    label1427:
    for (;;)
    {
      label935:
      localObject2 = com.tencent.mm.kernel.h.ax(ce.class);
      s.s(localObject2, "service(IHellLiveReport::class.java)");
      ce localce = (ce)localObject2;
      l3 = paramFinderObject.id;
      localObject2 = paramFinderObject.liveInfo;
      if (localObject2 == null)
      {
        l1 = 0L;
        label978:
        localObject3 = paramFinderObject.username;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        l4 = paramj.KJ();
        localObject3 = paramFinderObject.liveInfo;
        if (localObject3 != null) {
          break label1247;
        }
      }
      label1247:
      for (l2 = -1L;; l2 = ((bip)localObject3).DSe)
      {
        ce.a.a(localce, l3, l1, (String)localObject2, l4, l2, (q.w)localObject4, (String)localObject1);
        break;
        localObject1 = "9";
        break label935;
        if (!s.p(localObject1, "25")) {
          break label1427;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
        localObject3 = c.zGj;
        if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.arO((String)localObject2)) {
          break label1427;
        }
        if (localObject2 != null) {}
        switch (((String)localObject2).hashCode())
        {
        default: 
          label1144:
          localObject1 = "39";
        }
        for (;;)
        {
          label1149:
          break;
          if (!((String)localObject2).equals("101")) {
            break label1144;
          }
          do
          {
            do
            {
              localObject1 = "25";
              break label1149;
              if (!((String)localObject2).equals("123")) {
                break;
              }
              localObject1 = "38";
              break label1149;
            } while (((String)localObject2).equals("102"));
            break;
          } while (((String)localObject2).equals("999"));
          if ((goto 1144) || (!((String)localObject2).equals("150"))) {
            break label1144;
          }
          localObject1 = "15";
        }
        l1 = ((bip)localObject2).liveId;
        break label978;
      }
      label1258:
      localObject1 = ((FinderVideoLayout)localObject1).getVideoView();
      break label690;
      label1268:
      bool = false;
      break label713;
      label1274:
      i = 0;
      break label736;
      localObject2 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      paramView = com.tencent.mm.plugin.finder.live.fluent.g.a(paramView, paramFinderObject);
      Log.w("Finder.FeedFullLiveConvert", "startSwitchOutFromSquare animation for feed:" + com.tencent.mm.ae.d.hF(l1) + " finderLivePlayView:" + localObject1);
      paramView.aX((kotlin.g.a.a)new c(this, paramj));
      break;
      label1362:
      Log.w("Finder.FeedFullLiveConvert", "startSwitchOutFromSquare no animation for feed:" + com.tencent.mm.ae.d.hF(paramFinderObject.id) + " finderLivePlayView:" + localObject1);
      paramView = paramj.CSA;
      s.s(paramView, "holder.getAssociatedObject()");
      a((cc)paramView, paramj, false);
      break;
    }
  }
  
  protected final void b(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    AppMethodBeat.i(350905);
    s.u(parama, "ev");
    Object localObject = this.mkw;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof WxRecyclerAdapter)) {
        break label55;
      }
    }
    label55:
    for (localObject = (WxRecyclerAdapter)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label60;
      }
      AppMethodBeat.o(350905);
      return;
      localObject = ((RecyclerView)localObject).getAdapter();
      break;
    }
    label60:
    localObject = (j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject, parama.feedId);
    if (localObject == null)
    {
      AppMethodBeat.o(350905);
      return;
    }
    parama = ((j)localObject).CSA;
    if ((parama instanceof x)) {}
    for (parama = (x)parama; parama == null; parama = null)
    {
      AppMethodBeat.o(350905);
      return;
    }
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUp();
    ((FinderFeedLiveRecommendView)((j)localObject).UH(e.e.finder_feed_live_recommend_view)).fkz();
    AppMethodBeat.o(350905);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350843);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    Log.i("Finder.FeedFullLiveConvert", s.X("onDetachedFromRecyclerView liveFeedStateChangeListener:", this.AJp));
    paramRecyclerView = paramRecyclerView.getContext();
    if ((paramRecyclerView instanceof Activity))
    {
      paramRecyclerView = (Activity)paramRecyclerView;
      if (paramRecyclerView != null) {
        break label81;
      }
    }
    label81:
    for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.getWindow())
    {
      c(paramRecyclerView);
      this.AJp.dead();
      AppMethodBeat.o(350843);
      return;
      paramRecyclerView = null;
      break;
    }
  }
  
  public final void e(j paramj)
  {
    AppMethodBeat.i(350855);
    s.u(paramj, "holder");
    super.e(paramj);
    AppMethodBeat.o(350855);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_full_live_item;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(350835);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("Finder.FeedFullLiveConvert", s.X("onViewRecycled liveFeedStateChangeListener:", this.AJp));
    Object localObject = paramj.getRecyclerView();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof Activity)) {
        break label166;
      }
      localObject = (Activity)localObject;
      label57:
      if (localObject != null) {
        break label171;
      }
    }
    label166:
    label171:
    for (localObject = null;; localObject = ((Activity)localObject).getWindow())
    {
      c((Window)localObject);
      this.AJp.dead();
      paramj = (FinderFeedLiveRecommendView)paramj.UH(e.e.finder_feed_live_recommend_view);
      paramj.getTimeHandler().stopTimer();
      paramj.getHandlerForEmptyTips().removeCallbacksAndMessages(null);
      paramj.Gzd = 3;
      paramj.Gzb = null;
      paramj.Gzf = false;
      paramj.Gzg = false;
      paramj.getEntryBg().setAlpha(0.0F);
      paramj.Gzh = false;
      paramj.Gzi.clear();
      Log.i(paramj.TAG, "[clearAll]");
      AppMethodBeat.o(350835);
      return;
      localObject = ((RecyclerView)localObject).getContext();
      break;
      localObject = null;
      break label57;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<Boolean, FinderVideoLayout.b, ah>
  {
    b(FinderMediaBannerAdapter paramFinderMediaBannerAdapter, View paramView, j paramj, x paramx, r paramr)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$convertMedia$3$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.plugin.finder.animation.a
    {
      a(ImageView paramImageView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(349643);
        this.AJv.setVisibility(8);
        this.AJv.setAlpha(1.0F);
        this.AJv.setTag(Boolean.FALSE);
        AppMethodBeat.o(349643);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(r paramr, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */