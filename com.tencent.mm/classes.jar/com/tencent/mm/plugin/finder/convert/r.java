package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "commentScene", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZII)V", "getCommentScene", "()I", "calculateMediaLayoutParams", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "convertMedia", "position", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "e", "Landroid/view/MotionEvent;", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshLiveIcon", "refreshLivingIcon", "refreshMask", "liveStatus", "Companion", "plugin-finder_release"})
public final class r
  extends o<w>
{
  public static final a tCF;
  private final i tAi;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  private final int tCE;
  
  static
  {
    AppMethodBeat.i(242991);
    tCF = new a((byte)0);
    AppMethodBeat.o(242991);
  }
  
  public r(com.tencent.mm.plugin.finder.video.k paramk, i parami, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(parami, paramBoolean, paramInt1);
    AppMethodBeat.i(242989);
    this.tCD = paramk;
    this.tAi = parami;
    this.tCE = paramInt2;
    AppMethodBeat.o(242989);
  }
  
  private void a(com.tencent.mm.view.recyclerview.h paramh, final w paramw, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(242984);
    p.h(paramh, "holder");
    p.h(paramw, "item");
    super.a(paramh, (BaseFinderFeed)paramw, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = paramw.feedObject.getLiveInfo();
    Object localObject1;
    label118:
    TextView localTextView;
    Object localObject2;
    if (paramList != null)
    {
      paramInt1 = paramList.liveStatus;
      localObject1 = ((FinderMediaBanner)paramh.Mn(2131304549)).getAdapter();
      paramList = (List<Object>)localObject1;
      if (!(localObject1 instanceof FinderMediaBannerAdapter)) {
        paramList = null;
      }
      paramList = (FinderMediaBannerAdapter)paramList;
      if (paramList == null) {
        break label704;
      }
      paramList = paramList.wrm;
      if (paramList == null) {
        break label704;
      }
      localObject1 = (ImageView)paramList.findViewById(2131309075);
      ImageView localImageView = (ImageView)paramh.Mn(2131300936);
      localTextView = (TextView)paramh.Mn(2131300981);
      p.g(localTextView, "logoWidget");
      ao.a((Paint)localTextView.getPaint(), 0.8F);
      Object localObject3 = (cjl)j.kt((List)paramw.feedObject.getLiveMediaList());
      if (localObject3 == null)
      {
        localObject2 = new StringBuilder();
        paramList = paramw.feedObject.getLiveInfo();
        if (paramList == null) {
          break label710;
        }
        paramList = Long.valueOf(paramList.liveId);
        label216:
        Log.i("Finder.FeedFullLiveConvert", paramList + " firstMedia is empty");
      }
      if (localObject3 != null)
      {
        localObject2 = ((cjl)localObject3).coverUrl;
        paramList = (List<Object>)localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        paramList = "";
      }
      p.g(paramList, "firstMedia?.coverUrl ?: \"\"");
      localObject2 = paramList;
      if (Util.isNullOrNil(paramList))
      {
        if (localObject3 == null) {
          break label716;
        }
        paramList = ((cjl)localObject3).thumbUrl;
        label292:
        if (localObject3 == null) {
          break label722;
        }
        localObject2 = ((cjl)localObject3).thumb_url_token;
        label304:
        localObject2 = p.I(paramList, Util.nullAsNil((String)localObject2));
      }
      localObject3 = new StringBuilder("refreshMask item=");
      paramList = paramw.contact;
      if (paramList == null) {
        break label728;
      }
      paramList = paramList.getNickname();
      label346:
      Log.i("Finder.FeedFullLiveConvert", paramList);
      p.g(localImageView, "blurView");
      localImageView.setVisibility(0);
      paramList = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.h(localImageView, (String)localObject2);
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (paramInt1 != 1) {
        break label734;
      }
      paramList = paramh.Mn(2131301215);
      p.g(paramList, "holder.getView<View>(R.i…inder_live_onlive_widget)");
      paramList.setVisibility(0);
      paramList = MMApplicationContext.getContext();
      p.g(paramList, "MMApplicationContext.getContext()");
      localTextView.setText((CharSequence)paramList.getResources().getString(2131759920));
      label459:
      paramList = paramw.contact;
      if (paramList == null) {
        break label814;
      }
      paramInt1 = paramList.field_liveStatus;
      label476:
      paramList = paramw.feedObject.getLiveInfo();
      if (paramList == null) {
        break label819;
      }
      paramInt2 = paramList.LCy;
      label497:
      localObject1 = (FinderLiveOnliveWidget)paramh.Mn(2131301215);
      localObject2 = new StringBuilder("[refreshLiveIcon] username:");
      paramList = paramw.contact;
      if (paramList == null) {
        break label825;
      }
      paramList = paramList.getNickname();
      label539:
      paramList = ((StringBuilder)localObject2).append(paramList).append(",liveStatus:").append(paramInt1).append(",participantCount=").append(paramInt2).append(" onliveView is null:");
      if (localObject1 != null) {
        break label831;
      }
    }
    label814:
    label819:
    label825:
    label831:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("Finder.FeedFullLiveConvert", paramBoolean);
      if (paramInt1 != 1) {
        break label895;
      }
      if (localObject1 != null) {
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
      }
      if (localObject1 != null) {
        ((FinderLiveOnliveWidget)localObject1).setOnClickListener((View.OnClickListener)new c(paramh, paramw));
      }
      if (paramInt2 <= 0) {
        break label843;
      }
      if (localObject1 == null) {
        break label837;
      }
      paramh = MMApplicationContext.getContext();
      p.g(paramh, "MMApplicationContext.getContext()");
      paramh = paramh.getResources().getString(2131760369, new Object[] { Integer.valueOf(paramInt2) });
      p.g(paramh, "MMApplicationContext.get…member, participantCount)");
      ((FinderLiveOnliveWidget)localObject1).setText(paramh);
      AppMethodBeat.o(242984);
      return;
      paramInt1 = 2;
      break;
      label704:
      localObject1 = null;
      break label118;
      label710:
      paramList = null;
      break label216;
      label716:
      paramList = null;
      break label292;
      label722:
      localObject2 = null;
      break label304;
      label728:
      paramList = null;
      break label346;
      label734:
      paramList = paramh.Mn(2131301215);
      p.g(paramList, "holder.getView<View>(R.i…inder_live_onlive_widget)");
      paramList.setVisibility(8);
      paramList = MMApplicationContext.getContext();
      p.g(paramList, "MMApplicationContext.getContext()");
      localTextView.setText((CharSequence)paramList.getResources().getString(2131759918));
      paramList = paramh.Mn(2131303430);
      if (paramList == null) {
        break label459;
      }
      paramList.setVisibility(8);
      break label459;
      paramInt1 = 2;
      break label476;
      paramInt2 = 0;
      break label497;
      paramList = null;
      break label539;
    }
    label837:
    AppMethodBeat.o(242984);
    return;
    label843:
    if (localObject1 != null)
    {
      paramh = MMApplicationContext.getContext();
      p.g(paramh, "MMApplicationContext.getContext()");
      paramh = paramh.getResources().getString(2131760368);
      p.g(paramh, "MMApplicationContext.get…ing.finder_onlive_status)");
      ((FinderLiveOnliveWidget)localObject1).setText(paramh);
      AppMethodBeat.o(242984);
      return;
    }
    AppMethodBeat.o(242984);
    return;
    label895:
    if (localObject1 != null)
    {
      ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
      AppMethodBeat.o(242984);
      return;
    }
    AppMethodBeat.o(242984);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(242979);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.tCD));
    localFinderMediaBanner.setViewPool(this.tAi.dcf());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    paramh.mf(2131297154, 8);
    paramh.mf(2131298948, 8);
    paramh.mf(2131307809, 8);
    paramRecyclerView = paramh.getRecyclerView();
    p.g(paramRecyclerView, "holder.recyclerView");
    if (paramRecyclerView.getParent() == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.RefreshLoadMoreLayout");
      AppMethodBeat.o(242979);
      throw paramRecyclerView;
    }
    paramRecyclerView = paramh.getRecyclerView();
    p.g(paramRecyclerView, "holder.recyclerView");
    paramRecyclerView = paramRecyclerView.getParent();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.RefreshLoadMoreLayout");
      AppMethodBeat.o(242979);
      throw paramRecyclerView;
    }
    ((RefreshLoadMoreLayout)paramRecyclerView).getActionCallback();
    AppMethodBeat.o(242979);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(242987);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(242987);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(242981);
    p.h(paramh, "holder");
    paramh = (FinderFeedLiveNoticeView)paramh.Mn(2131300834);
    if (paramh != null)
    {
      paramh.setVisibility(8);
      AppMethodBeat.o(242981);
      return;
    }
    AppMethodBeat.o(242981);
  }
  
  public final boolean b(com.tencent.mm.view.recyclerview.h paramh, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(242983);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObj");
    Object localObject2;
    long l1;
    Object localObject1;
    if (Util.isEqual(paramFinderObject.username, z.aUg()))
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject2 = paramh.getContext();
      p.g(localObject2, "holder.context");
      l1 = paramFinderObject.id;
      paramView = paramFinderObject.objectNonceId;
      paramh = paramView;
      if (paramView == null) {
        paramh = "";
      }
      localObject1 = paramFinderObject.liveInfo;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = new awe();
      }
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, l1, paramh, paramView, false, null, null, null, null, null, paramFinderObject.sessionBuffer, null, 6128);
      AppMethodBeat.o(242983);
      return true;
    }
    paramView = paramh.getContext().getClass().getName();
    p.g(paramView, "holder.context.javaClass.name");
    Log.i("Finder.FeedFullLiveConvert", "HABBYGE-MALI, onMediaClick, pageName=".concat(String.valueOf(paramView)));
    Object localObject3;
    long l3;
    label225:
    long l4;
    if (p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramView))
    {
      paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject2 = (String)com.tencent.mm.plugin.finder.report.live.k.dpl().vlZ.get(c.sEs);
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
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
          l4 = paramh.lR();
          paramFinderObject = paramFinderObject.liveInfo;
          if (paramFinderObject == null) {
            break label388;
          }
          l2 = paramFinderObject.uBn;
          label265:
          ((com.tencent.mm.plugin.finder.report.live.k)localObject3).a(l3, l1, paramView, l4, l2, s.p.voF, (String)localObject2);
        }
      }
      else
      {
        Log.i("Finder.FeedFullLiveConvert", "HABBYGE-MALI, onMediaClick, pageObj:" + c.sEs);
      }
    }
    label388:
    do
    {
      paramView = paramh.hgv();
      p.g(paramView, "holder.getAssociatedObject()");
      paramView = (bo)paramView;
      paramFinderObject = new ArrayList();
      paramFinderObject.add(paramView);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramh = paramh.getContext();
      p.g(paramh, "holder.context");
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.a.a(paramh, com.tencent.mm.plugin.finder.utils.m.a(paramFinderObject, paramView, this.tCE), null, null, null, 28);
      break;
      l1 = 0L;
      break label225;
      l2 = -1L;
      break label265;
      localObject3 = s.p.voF;
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramView = (String)com.tencent.mm.plugin.finder.report.live.k.dpl().vlY.get(paramView);
    } while (paramView == null);
    label456:
    com.tencent.mm.plugin.finder.report.live.k localk;
    switch (paramView.hashCode())
    {
    case 1604: 
    default: 
      localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
      l3 = paramFinderObject.id;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null)
      {
        l1 = ((awe)localObject1).liveId;
        label485:
        localObject2 = paramFinderObject.username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        l4 = paramh.lR();
        paramFinderObject = paramFinderObject.liveInfo;
        if (paramFinderObject == null) {
          break label783;
        }
      }
      break;
    }
    label775:
    label783:
    for (long l2 = paramFinderObject.uBn;; l2 = -1L)
    {
      localk.a(l3, l1, (String)localObject1, l4, l2, (s.p)localObject3, paramView);
      break;
      if (!paramView.equals("25")) {
        break label456;
      }
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      p.g(localObject1, "HellSessionMonitor.getInstance()");
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).cPQ();
      localObject2 = c.sFa;
      if (c.a.apK((String)localObject1)) {
        break label456;
      }
      if (localObject1 == null) {
        paramView = "39";
      }
      for (;;)
      {
        label600:
        break;
        if (!paramView.equals("27")) {
          break label775;
        }
        paramView = c.sFa;
        if (c.cOL()) {}
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
            break label600;
            if (!((String)localObject1).equals("123")) {
              break;
            }
            paramView = "38";
            break label600;
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
    return 2131492879;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isShow", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.m<Boolean, FinderVideoLayout.b, x>
  {
    b(FinderMediaBannerAdapter paramFinderMediaBannerAdapter, View paramView, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$convertMedia$3$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.animation.a
    {
      a(ImageView paramImageView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(242976);
        this.tCH.setVisibility(8);
        this.tCH.setAlpha(1.0F);
        this.tCH.setTag(Boolean.FALSE);
        AppMethodBeat.o(242976);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.view.recyclerview.h paramh, w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242978);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      paramView = paramw.contact;
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        new com.tencent.mm.plugin.finder.view.r((Context)localObject, paramView, this.qhp.lR(), paramw.feedObject.isLiveFeed()).dzC();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242978);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */