package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onAttachedToRecyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindFinish", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onVideoPause", "ev", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "onVideoRealPlay", "refreshFooter", "count", "refreshMask", "liveStatus", "setFooterOpLayoutVisibility", "visibility", "plugin-finder_release"})
public final class y
  extends m<w>
{
  private final String TAG;
  private RecyclerView jLl;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  
  public y(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
  {
    super(parami, paramBoolean);
    AppMethodBeat.i(275268);
    this.xkW = paraml;
    this.xhU = parami;
    this.TAG = "FinderFeedLiveConvert";
    paraml = this.xhU.getActivity();
    if (paraml != null)
    {
      paraml = paraml.getContext();
      if (paraml != null)
      {
        parami = aj.Bnu;
        paraml = aj.a.fZ((Context)paraml);
        if (paraml != null)
        {
          paraml = paraml.RU(this.fEH);
          if (paraml != null)
          {
            paraml.a((d)new a(this));
            AppMethodBeat.o(275268);
            return;
          }
        }
        AppMethodBeat.o(275268);
        return;
      }
    }
    AppMethodBeat.o(275268);
  }
  
  private static void b(com.tencent.mm.view.recyclerview.i parami, String paramString)
  {
    AppMethodBeat.i(275265);
    View localView = parami.RD(b.f.footer_live_info_layout);
    p.j(localView, "holder.getView<View>(R.id.footer_live_info_layout)");
    localView.setVisibility(0);
    ((TextView)parami.RD(b.f.live_footer_desc)).setText((CharSequence)parami.getContext().getString(b.j.finder_live_members_total_tip, new Object[] { paramString }));
    AppMethodBeat.o(275265);
  }
  
  public final void a(int paramInt, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(275266);
    p.k(parami, "holder");
    parami.nx(b.f.footer_real_op_layout, 8);
    AppMethodBeat.o(275266);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(275259);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    Log.i(this.TAG, "[onAttachedToRecyclerView]...");
    this.jLl = paramRecyclerView;
    AppMethodBeat.o(275259);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(275258);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.xkW));
    localFinderMediaBanner.setViewPool(this.xhU.dsv());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    b(parami, "0");
    AppMethodBeat.o(275258);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView)
  {
    AppMethodBeat.i(275264);
    p.k(parami, "holder");
    p.k(paramView, "view");
    AppMethodBeat.o(275264);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(275263);
    p.k(parami, "holder");
    p.k(paramView, "view");
    p.k(paramFinderObject, "finderObj");
    Object localObject2;
    long l1;
    Object localObject1;
    if (Util.isEqual(paramFinderObject.username, z.bdh()))
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject2 = parami.getContext();
      p.j(localObject2, "holder.context");
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
      AppMethodBeat.o(275263);
      return;
    }
    paramView = parami.getContext().getClass().getName();
    p.j(paramView, "holder.context.javaClass.name");
    Log.i(this.TAG, "HABBYGE-MALI, onMediaClick, pageName=".concat(String.valueOf(paramView)));
    Object localObject3;
    long l3;
    long l4;
    long l2;
    label271:
    label316:
    Object localObject4;
    if (p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramView))
    {
      paramView = k.yBj;
      localObject2 = (String)k.dDm().yDm.get(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkn);
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
          localObject1 = paramFinderObject.liveInfo;
          if (localObject1 == null) {
            break label644;
          }
          l2 = ((bac)localObject1).yYz;
          k.a((k)localObject3, l3, l1, paramView, l4, l2, s.t.yGS, (String)localObject2);
        }
      }
      else
      {
        Log.i(this.TAG, "HABBYGE-MALI, onMediaClick, pageObj:" + com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkn);
        localObject4 = com.tencent.mm.plugin.finder.utils.a.ACH;
        Context localContext = parami.getContext();
        p.j(localContext, "holder.context");
        l2 = paramFinderObject.id;
        paramView = paramFinderObject.liveInfo;
        if (paramView == null) {
          break label1051;
        }
        l1 = paramView.liveId;
        label355:
        localObject1 = paramFinderObject.username;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject2 = paramFinderObject.objectNonceId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = paramFinderObject.objectDesc;
        if (localObject2 != null)
        {
          localObject3 = ((FinderObjectDesc)localObject2).description;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localObject3 = paramFinderObject.liveInfo;
        if (localObject3 == null) {
          break label1057;
        }
        i = ((bac)localObject3).SLO;
        label443:
        String str = paramFinderObject.sessionBuffer;
        localObject3 = paramFinderObject.liveInfo;
        if (localObject3 == null) {
          break label1063;
        }
        localObject3 = ((bac)localObject3).kih;
        label467:
        paramFinderObject = paramFinderObject.liveInfo;
        if (paramFinderObject == null) {
          break label1069;
        }
        paramFinderObject = paramFinderObject.SLN;
        if (paramFinderObject == null) {
          break label1069;
        }
        paramFinderObject = Integer.valueOf(paramFinderObject.kmi);
        label493:
        com.tencent.mm.plugin.finder.utils.a.a((com.tencent.mm.plugin.finder.utils.a)localObject4, null, localContext, l2, l1, paramView, (String)localObject1, (String)localObject2, "", i, str, null, (String)localObject3, paramFinderObject, 0, 9216);
        paramView = parami.ihX();
        p.j(paramView, "holder.getAssociatedObject()");
        paramView = (bu)paramView;
        paramFinderObject = new ArrayList();
        paramFinderObject.add(paramView);
        localObject1 = aj.Bnu;
        localObject1 = parami.getContext();
        p.j(localObject1, "holder.context");
        localObject1 = aj.a.fZ((Context)localObject1);
        if (localObject1 == null) {
          break label1074;
        }
      }
    }
    label644:
    label1035:
    label1043:
    label1051:
    label1057:
    label1063:
    label1069:
    label1074:
    for (int i = ((aj)localObject1).xkX;; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.utils.a.a(parami, com.tencent.mm.plugin.finder.live.utils.a.a(paramFinderObject, paramView, i), null, null, null, 28);
      AppMethodBeat.o(275263);
      return;
      l1 = 0L;
      break;
      l2 = -1L;
      break label271;
      localObject3 = s.t.yGS;
      localObject1 = k.yBj;
      paramView = (String)k.dDm().yDl.get(paramView);
      if (paramView == null) {
        break label316;
      }
      switch (paramView.hashCode())
      {
      case 1604: 
      default: 
        label712:
        localObject4 = k.yBj;
        l3 = paramFinderObject.id;
        localObject1 = paramFinderObject.liveInfo;
        if (localObject1 != null)
        {
          l1 = ((bac)localObject1).liveId;
          label741:
          localObject2 = paramFinderObject.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          l4 = parami.md();
          localObject2 = paramFinderObject.liveInfo;
          if (localObject2 == null) {
            break label1043;
          }
        }
        break;
      }
      for (l2 = ((bac)localObject2).yYz;; l2 = -1L)
      {
        k.a((k)localObject4, l3, l1, (String)localObject1, l4, l2, (s.t)localObject3, paramView);
        break;
        if (!paramView.equals("25")) {
          break label712;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        p.j(localObject1, "HellSessionMonitor.getInstance()");
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).deK();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.axK((String)localObject1)) {
          break label712;
        }
        if (localObject1 == null) {
          paramView = "39";
        }
        for (;;)
        {
          label860:
          break;
          if (!paramView.equals("27")) {
            break label1035;
          }
          paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddE()) {}
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
              break label860;
              if (!((String)localObject1).equals("123")) {
                break;
              }
              paramView = "38";
              break label860;
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
        break label712;
        l1 = 0L;
        break label741;
      }
      l1 = 0L;
      break label355;
      i = 0;
      break label443;
      localObject3 = null;
      break label467;
      paramFinderObject = null;
      break label493;
    }
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(275260);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    Log.i(this.TAG, "[onDetachedFromRecyclerView]...");
    this.jLl = null;
    AppMethodBeat.o(275260);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_live_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$1$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class a
    extends d
  {
    a(y paramy) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(225734);
      p.k(paramb, "ev");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 1))
      {
        y.a(this.xlB, (com.tencent.mm.plugin.finder.event.c.a)paramb);
        AppMethodBeat.o(225734);
        return;
      }
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 11)) {
        y.b(this.xlB, (com.tencent.mm.plugin.finder.event.c.a)paramb);
      }
      AppMethodBeat.o(225734);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(225735);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.c.a;
      AppMethodBeat.o(225735);
      return bool;
    }
    
    public final boolean dpw()
    {
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(y paramy, w paramw, com.tencent.mm.view.recyclerview.i parami, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229139);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      y.a(this.xlB, this.xhb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */