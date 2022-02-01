package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.y;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "commentScene", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZII)V", "getCommentScene", "()I", "calculateMediaLayoutParams", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "convertMedia", "position", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "e", "Landroid/view/MotionEvent;", "onVideoPause", "ev", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "onVideoRealPlay", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshLiveIcon", "refreshLivingIcon", "refreshMask", "liveStatus", "Companion", "plugin-finder_release"})
public final class s
  extends p<w>
{
  public static final a xkY;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private final int xkX;
  
  static
  {
    AppMethodBeat.i(276050);
    xkY = new a((byte)0);
    AppMethodBeat.o(276050);
  }
  
  public s(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(parami, paramBoolean, paramInt1);
    AppMethodBeat.i(276048);
    this.xkW = paraml;
    this.xhU = parami;
    this.xkX = paramInt2;
    AppMethodBeat.o(276048);
  }
  
  private void a(com.tencent.mm.view.recyclerview.i parami, final w paramw, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(276038);
    kotlin.g.b.p.k(parami, "holder");
    kotlin.g.b.p.k(paramw, "item");
    super.a(parami, (BaseFinderFeed)paramw, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = paramw.feedObject.getLiveInfo();
    Object localObject1;
    label120:
    TextView localTextView;
    Object localObject2;
    if (paramList != null)
    {
      paramInt1 = paramList.liveStatus;
      localObject1 = ((FinderMediaBanner)parami.RD(b.f.media_banner)).getAdapter();
      paramList = (List<Object>)localObject1;
      if (!(localObject1 instanceof FinderMediaBannerAdapter)) {
        paramList = null;
      }
      paramList = (FinderMediaBannerAdapter)paramList;
      if (paramList == null) {
        break label712;
      }
      paramList = paramList.Bdr;
      if (paramList == null) {
        break label712;
      }
      localObject1 = (ImageView)paramList.findViewById(b.f.thumb_video);
      ImageView localImageView = (ImageView)parami.RD(b.f.finder_live_blur_view);
      localTextView = (TextView)parami.RD(b.f.finder_live_entry_txt);
      kotlin.g.b.p.j(localTextView, "logoWidget");
      ar.a((Paint)localTextView.getPaint(), 0.8F);
      Object localObject3 = (csg)j.lp((List)paramw.feedObject.getLiveMediaList());
      if (localObject3 == null)
      {
        localObject2 = new StringBuilder();
        paramList = paramw.feedObject.getLiveInfo();
        if (paramList == null) {
          break label718;
        }
        paramList = Long.valueOf(paramList.liveId);
        label220:
        Log.i("Finder.FeedFullLiveConvert", paramList + " firstMedia is empty");
      }
      if (localObject3 != null)
      {
        localObject2 = ((csg)localObject3).coverUrl;
        paramList = (List<Object>)localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        paramList = "";
      }
      kotlin.g.b.p.j(paramList, "firstMedia?.coverUrl ?: \"\"");
      localObject2 = paramList;
      if (Util.isNullOrNil(paramList))
      {
        if (localObject3 == null) {
          break label724;
        }
        paramList = ((csg)localObject3).thumbUrl;
        label298:
        if (localObject3 == null) {
          break label730;
        }
        localObject2 = ((csg)localObject3).thumb_url_token;
        label310:
        localObject2 = kotlin.g.b.p.I(paramList, Util.nullAsNil((String)localObject2));
      }
      localObject3 = new StringBuilder("refreshMask item=");
      paramList = paramw.contact;
      if (paramList == null) {
        break label736;
      }
      paramList = paramList.getNickname();
      label352:
      Log.i("Finder.FeedFullLiveConvert", paramList);
      kotlin.g.b.p.j(localImageView, "blurView");
      localImageView.setVisibility(0);
      paramList = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.g(localImageView, (String)localObject2);
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (paramInt1 != 1) {
        break label742;
      }
      paramList = parami.RD(b.f.finder_live_onlive_widget);
      kotlin.g.b.p.j(paramList, "holder.getView<View>(R.i…inder_live_onlive_widget)");
      paramList.setVisibility(0);
      paramList = MMApplicationContext.getContext();
      kotlin.g.b.p.j(paramList, "MMApplicationContext.getContext()");
      localTextView.setText((CharSequence)paramList.getResources().getString(b.j.finder_live_entry_wording));
      label465:
      paramList = paramw.contact;
      if (paramList == null) {
        break label822;
      }
      paramInt1 = paramList.field_liveStatus;
      label482:
      paramList = paramw.feedObject.getLiveInfo();
      if (paramList == null) {
        break label827;
      }
      paramInt2 = paramList.SFG;
      label503:
      localObject1 = (FinderLiveOnliveWidget)parami.RD(b.f.finder_live_onlive_widget);
      localObject2 = new StringBuilder("[refreshLiveIcon] username:");
      paramList = paramw.contact;
      if (paramList == null) {
        break label833;
      }
      paramList = paramList.getNickname();
      label545:
      paramList = ((StringBuilder)localObject2).append(paramList).append(",liveStatus:").append(paramInt1).append(",participantCount=").append(paramInt2).append(" onliveView is null:");
      if (localObject1 != null) {
        break label839;
      }
      paramBoolean = true;
      label589:
      Log.i("Finder.FeedFullLiveConvert", paramBoolean);
      if (paramInt1 != 1) {
        break label985;
      }
      if (localObject1 != null) {
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
      }
      if (localObject1 != null) {
        ((FinderLiveOnliveWidget)localObject1).setOnClickListener((View.OnClickListener)new c(parami, paramw));
      }
      parami = paramw.feedObject.getLiveInfo();
      if (parami == null) {
        break label845;
      }
      parami = parami.SLS;
    }
    for (;;)
    {
      if (parami != null)
      {
        if (localObject1 != null)
        {
          parami = paramw.feedObject.getLiveInfo();
          if (parami != null)
          {
            paramw = parami.SLS;
            parami = paramw;
            if (paramw != null) {}
          }
          else
          {
            parami = "";
          }
          ((FinderLiveOnliveWidget)localObject1).setText(parami);
          AppMethodBeat.o(276038);
          return;
          paramInt1 = 2;
          break;
          label712:
          localObject1 = null;
          break label120;
          label718:
          paramList = null;
          break label220;
          label724:
          paramList = null;
          break label298;
          label730:
          localObject2 = null;
          break label310;
          label736:
          paramList = null;
          break label352;
          label742:
          paramList = parami.RD(b.f.finder_live_onlive_widget);
          kotlin.g.b.p.j(paramList, "holder.getView<View>(R.i…inder_live_onlive_widget)");
          paramList.setVisibility(8);
          paramList = MMApplicationContext.getContext();
          kotlin.g.b.p.j(paramList, "MMApplicationContext.getContext()");
          localTextView.setText((CharSequence)paramList.getResources().getString(b.j.finder_live_end));
          paramList = parami.RD(b.f.live_loading_video);
          if (paramList == null) {
            break label465;
          }
          paramList.setVisibility(8);
          break label465;
          label822:
          paramInt1 = 2;
          break label482;
          label827:
          paramInt2 = 0;
          break label503;
          label833:
          paramList = null;
          break label545;
          label839:
          paramBoolean = false;
          break label589;
          label845:
          parami = null;
          continue;
        }
        AppMethodBeat.o(276038);
        return;
      }
    }
    if (paramInt2 > 0)
    {
      if (localObject1 != null)
      {
        parami = MMApplicationContext.getContext();
        kotlin.g.b.p.j(parami, "MMApplicationContext.getContext()");
        parami = parami.getResources();
        paramInt1 = b.j.finder_onlive_status_with_member_new;
        paramw = com.tencent.mm.plugin.finder.utils.aj.AGc;
        parami = parami.getString(paramInt1, new Object[] { com.tencent.mm.plugin.finder.utils.aj.Rh(paramInt2) });
        kotlin.g.b.p.j(parami, "MMApplicationContext.get…unt, formatFloat = true))");
        ((FinderLiveOnliveWidget)localObject1).setText(parami);
        AppMethodBeat.o(276038);
        return;
      }
      AppMethodBeat.o(276038);
      return;
    }
    if (localObject1 != null)
    {
      parami = MMApplicationContext.getContext();
      kotlin.g.b.p.j(parami, "MMApplicationContext.getContext()");
      parami = parami.getResources().getString(b.j.finder_onlive_status);
      kotlin.g.b.p.j(parami, "MMApplicationContext.get…ing.finder_onlive_status)");
      ((FinderLiveOnliveWidget)localObject1).setText(parami);
      AppMethodBeat.o(276038);
      return;
    }
    AppMethodBeat.o(276038);
    return;
    label985:
    if (localObject1 != null)
    {
      ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
      AppMethodBeat.o(276038);
      return;
    }
    AppMethodBeat.o(276038);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(276032);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.xhU.dsv());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    parami.nx(b.f.awesome_icon_container, 8);
    parami.nx(b.f.comment_icon_container, 8);
    parami.nx(b.f.share_icon_container, 8);
    AppMethodBeat.o(276032);
  }
  
  protected final void a(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(276045);
    kotlin.g.b.p.k(parama, "ev");
    Object localObject1 = this.jLl;
    if (localObject1 != null) {}
    for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        localObject2 = null;
      }
      localObject1 = (WxRecyclerAdapter)localObject2;
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(276045);
      return;
    }
    Object localObject2 = (com.tencent.mm.view.recyclerview.i)com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject1, parama.feedId);
    if (localObject2 == null)
    {
      AppMethodBeat.o(276045);
      return;
    }
    localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject2).ihX();
    parama = (com.tencent.mm.plugin.finder.event.c.a)localObject1;
    if (!(localObject1 instanceof w)) {
      parama = null;
    }
    parama = (w)parama;
    if (parama == null)
    {
      AppMethodBeat.o(276045);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject2).getContext();
    kotlin.g.b.p.j(localObject1, "holder.context");
    localObject1 = aj.a.fZ((Context)localObject1);
    if (localObject1 != null) {}
    for (int i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).xkX;; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.model.l.yfp;
      if (com.tencent.mm.plugin.finder.live.model.l.a(this.fEH, i, parama)) {
        break;
      }
      AppMethodBeat.o(276045);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.live.model.l.yfp;
    localObject1 = parama.feedObject.getFeedObject();
    parama = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    parama = ((com.tencent.mm.view.recyclerview.i)localObject2).getContext();
    kotlin.g.b.p.j(parama, "holder.context");
    localObject2 = aj.a.fZ(parama);
    parama = localObject3;
    if (localObject2 != null) {
      parama = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
    }
    com.tencent.mm.plugin.finder.live.model.l.a((FinderObject)localObject1, parama);
    AppMethodBeat.o(276045);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(276042);
    kotlin.g.b.p.k(parami, "holder");
    kotlin.g.b.p.k(paramView, "view");
    kotlin.g.b.p.k(paramMotionEvent, "e");
    AppMethodBeat.o(276042);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(276035);
    kotlin.g.b.p.k(parami, "holder");
    parami = (FinderFeedLiveNoticeView)parami.RD(b.f.finder_feed_live_notice_view);
    if (parami != null)
    {
      parami.setVisibility(8);
      AppMethodBeat.o(276035);
      return;
    }
    AppMethodBeat.o(276035);
  }
  
  protected final void b(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    AppMethodBeat.i(276047);
    kotlin.g.b.p.k(parama, "ev");
    Object localObject1 = this.jLl;
    if (localObject1 != null) {}
    for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        localObject2 = null;
      }
      localObject1 = (WxRecyclerAdapter)localObject2;
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(276047);
      return;
    }
    parama = (com.tencent.mm.view.recyclerview.i)com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject1, parama.feedId);
    if (parama == null)
    {
      AppMethodBeat.o(276047);
      return;
    }
    localObject1 = parama.ihX();
    parama = (com.tencent.mm.plugin.finder.event.c.a)localObject1;
    if (!(localObject1 instanceof w)) {
      parama = null;
    }
    if ((w)parama == null)
    {
      AppMethodBeat.o(276047);
      return;
    }
    parama = com.tencent.mm.plugin.finder.live.model.l.yfp;
    com.tencent.mm.plugin.finder.live.model.l.dyr();
    AppMethodBeat.o(276047);
  }
  
  public final boolean b(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(276037);
    kotlin.g.b.p.k(parami, "holder");
    kotlin.g.b.p.k(paramView, "view");
    kotlin.g.b.p.k(paramFinderObject, "finderObj");
    Object localObject2;
    long l1;
    Object localObject1;
    if (Util.isEqual(paramFinderObject.username, z.bdh()))
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject2 = parami.getContext();
      kotlin.g.b.p.j(localObject2, "holder.context");
      l1 = paramFinderObject.id;
      paramView = paramFinderObject.objectNonceId;
      parami = paramView;
      if (paramView == null) {
        parami = "";
      }
      localObject1 = paramFinderObject.liveInfo;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = new bac();
      }
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, l1, parami, paramView, null, null, null, null, null, paramFinderObject.sessionBuffer, null, null, 7152);
      AppMethodBeat.o(276037);
      return true;
    }
    paramView = parami.getContext().getClass().getName();
    kotlin.g.b.p.j(paramView, "holder.context.javaClass.name");
    Log.i("Finder.FeedFullLiveConvert", "HABBYGE-MALI, onMediaClick, pageName=".concat(String.valueOf(paramView)));
    Object localObject3;
    long l3;
    label226:
    long l4;
    if (kotlin.g.b.p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramView))
    {
      paramView = k.yBj;
      localObject2 = (String)k.dDm().yDm.get(c.wkn);
      if (localObject2 != null)
      {
        localObject3 = k.yBj;
        l3 = paramFinderObject.id;
        paramView = paramFinderObject.liveInfo;
        if (paramView != null)
        {
          l1 = paramView.liveId;
          localObject1 = paramFinderObject.username;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          l4 = parami.md();
          paramFinderObject = paramFinderObject.liveInfo;
          if (paramFinderObject == null) {
            break label391;
          }
          l2 = paramFinderObject.yYz;
          label267:
          k.a((k)localObject3, l3, l1, paramView, l4, l2, s.t.yGS, (String)localObject2);
        }
      }
      else
      {
        Log.i("Finder.FeedFullLiveConvert", "HABBYGE-MALI, onMediaClick, pageObj:" + c.wkn);
      }
    }
    label391:
    do
    {
      paramView = parami.ihX();
      kotlin.g.b.p.j(paramView, "holder.getAssociatedObject()");
      paramView = (bu)paramView;
      paramFinderObject = new ArrayList();
      paramFinderObject.add(paramView);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      parami = parami.getContext();
      kotlin.g.b.p.j(parami, "holder.context");
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.utils.a.a(parami, com.tencent.mm.plugin.finder.live.utils.a.a(paramFinderObject, paramView, this.xkX), null, null, null, 28);
      break;
      l1 = 0L;
      break label226;
      l2 = -1L;
      break label267;
      localObject3 = s.t.yGS;
      localObject1 = k.yBj;
      paramView = (String)k.dDm().yDl.get(paramView);
    } while (paramView == null);
    label456:
    k localk;
    switch (paramView.hashCode())
    {
    case 1604: 
    default: 
      localk = k.yBj;
      l3 = paramFinderObject.id;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null)
      {
        l1 = ((bac)localObject1).liveId;
        label485:
        localObject2 = paramFinderObject.username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        l4 = parami.md();
        paramFinderObject = paramFinderObject.liveInfo;
        if (paramFinderObject == null) {
          break label783;
        }
      }
      break;
    }
    label775:
    label783:
    for (long l2 = paramFinderObject.yYz;; l2 = -1L)
    {
      k.a(localk, l3, l1, (String)localObject1, l4, l2, (s.t)localObject3, paramView);
      break;
      if (!paramView.equals("25")) {
        break label456;
      }
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      kotlin.g.b.p.j(localObject1, "HellSessionMonitor.getInstance()");
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).deK();
      localObject2 = c.wkV;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.axK((String)localObject1)) {
        break label456;
      }
      if (localObject1 == null) {
        paramView = "39";
      }
      for (;;)
      {
        label601:
        break;
        if (!paramView.equals("27")) {
          break label775;
        }
        paramView = c.wkV;
        if (c.ddE()) {}
        for (paramView = "27";; paramView = "9") {
          break;
        }
        switch (((String)localObject1).hashCode())
        {
        default: 
          break;
        case 48626: 
          if (!((String)localObject1).equals("101")) {
            break;
          }
        case 48690: 
        case 48627: 
        case 56601: 
          for (;;)
          {
            paramView = "25";
            break label601;
            if (!((String)localObject1).equals("123")) {
              break;
            }
            paramView = "38";
            break label601;
            if (!((String)localObject1).equals("102")) {
              break;
            }
            continue;
            if (!((String)localObject1).equals("999")) {
              break;
            }
          }
        case 48780: 
          if (!((String)localObject1).equals("150")) {
            break;
          }
          paramView = "15";
        }
      }
      break label456;
      l1 = 0L;
      break label485;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_full_live_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
  static final class b
    extends q
    implements m<Boolean, FinderVideoLayout.b, x>
  {
    b(FinderMediaBannerAdapter paramFinderMediaBannerAdapter, View paramView, com.tencent.mm.view.recyclerview.i parami, w paramw)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$convertMedia$3$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.animation.a
    {
      a(ImageView paramImageView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(287987);
        this.xlb.setVisibility(8);
        this.xlb.setAlpha(1.0F);
        this.xlb.setTag(Boolean.FALSE);
        AppMethodBeat.o(287987);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.view.recyclerview.i parami, w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286522);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.tDl.getContext();
      kotlin.g.b.p.j(localObject, "holder.context");
      paramView = paramw.contact;
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        new y((Context)localObject, paramView, this.tDl.md(), paramw.feedObject.isLiveFeed()).dvx();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286522);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */