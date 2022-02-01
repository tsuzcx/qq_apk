package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindFinish", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "refreshFooter", "count", "refreshMask", "liveStatus", "setFooterOpLayoutVisibility", "visibility", "plugin-finder_release"})
public final class x
  extends l<w>
{
  private final String TAG;
  private final i tAi;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  
  public x(com.tencent.mm.plugin.finder.video.k paramk, i parami, boolean paramBoolean)
  {
    super(parami, paramBoolean);
    AppMethodBeat.i(243041);
    this.tCD = paramk;
    this.tAi = parami;
    this.TAG = "FinderFeedLiveConvert";
    AppMethodBeat.o(243041);
  }
  
  private static void a(h paramh, String paramString)
  {
    AppMethodBeat.i(243038);
    View localView = paramh.Mn(2131301670);
    p.g(localView, "holder.getView<View>(R.id.footer_live_info_layout)");
    localView.setVisibility(0);
    ((TextView)paramh.Mn(2131303398)).setText((CharSequence)paramh.getContext().getString(2131760081, new Object[] { paramString }));
    AppMethodBeat.o(243038);
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(243039);
    p.h(paramh, "holder");
    paramh.mf(2131301677, 8);
    AppMethodBeat.o(243039);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243033);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    Log.i(this.TAG, "[onAttachedToRecyclerView]...");
    AppMethodBeat.o(243033);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243032);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.tCD));
    localFinderMediaBanner.setViewPool(this.tAi.dcf());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    a(paramh, "0");
    AppMethodBeat.o(243032);
  }
  
  public final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(243037);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    AppMethodBeat.o(243037);
  }
  
  public final void a(h paramh, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(243036);
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
      AppMethodBeat.o(243036);
      return;
    }
    paramView = paramh.getContext().getClass().getName();
    p.g(paramView, "holder.context.javaClass.name");
    Log.i(this.TAG, "HABBYGE-MALI, onMediaClick, pageName=".concat(String.valueOf(paramView)));
    Object localObject3;
    long l3;
    long l4;
    long l2;
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
          localObject1 = paramFinderObject.liveInfo;
          if (localObject1 == null) {
            break label520;
          }
          l2 = ((awe)localObject1).uBn;
          label264:
          ((com.tencent.mm.plugin.finder.report.live.k)localObject3).a(l3, l1, paramView, l4, l2, s.p.voF, (String)localObject2);
        }
      }
      else
      {
        Log.i(this.TAG, "HABBYGE-MALI, onMediaClick, pageObj:" + c.sEs);
        label309:
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject3 = paramh.getContext();
        p.g(localObject3, "holder.context");
        l2 = paramFinderObject.id;
        paramView = paramFinderObject.liveInfo;
        if (paramView == null) {
          break label927;
        }
        l1 = paramView.liveId;
        label347:
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
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, l2, l1, paramView, (String)localObject1, "", "", paramFinderObject.sessionBuffer);
        paramView = paramh.hgv();
        p.g(paramView, "holder.getAssociatedObject()");
        paramView = (bo)paramView;
        paramFinderObject = new ArrayList();
        paramFinderObject.add(paramView);
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = paramh.getContext();
        p.g(localObject1, "holder.context");
        localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
        if (localObject1 == null) {
          break label933;
        }
      }
    }
    label520:
    label911:
    label919:
    label927:
    label933:
    for (int i = ((FinderReporterUIC)localObject1).tCE;; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramh = paramh.getContext();
      p.g(paramh, "holder.context");
      localObject1 = m.vVH;
      com.tencent.mm.plugin.finder.utils.a.a(paramh, m.a(paramFinderObject, paramView, i), null, null, null, 28);
      AppMethodBeat.o(243036);
      return;
      l1 = 0L;
      break;
      l2 = -1L;
      break label264;
      localObject3 = s.p.voF;
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramView = (String)com.tencent.mm.plugin.finder.report.live.k.dpl().vlY.get(paramView);
      if (paramView == null) {
        break label309;
      }
      label588:
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
          label617:
          localObject2 = paramFinderObject.username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          l4 = paramh.lR();
          localObject2 = paramFinderObject.liveInfo;
          if (localObject2 == null) {
            break label919;
          }
        }
        break;
      }
      for (l2 = ((awe)localObject2).uBn;; l2 = -1L)
      {
        localk.a(l3, l1, (String)localObject1, l4, l2, (s.p)localObject3, paramView);
        break;
        if (!paramView.equals("25")) {
          break label588;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        p.g(localObject1, "HellSessionMonitor.getInstance()");
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).cPQ();
        localObject2 = c.sFa;
        if (c.a.apK((String)localObject1)) {
          break label588;
        }
        if (localObject1 == null) {
          paramView = "39";
        }
        for (;;)
        {
          label735:
          break;
          if (!paramView.equals("27")) {
            break label911;
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
              break label735;
              if (!((String)localObject1).equals("123")) {
                break;
              }
              paramView = "38";
              break label735;
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
        break label588;
        l1 = 0L;
        break label617;
      }
      l1 = 0L;
      break label347;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243034);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    Log.i(this.TAG, "[onDetachedFromRecyclerView]...");
    AppMethodBeat.o(243034);
  }
  
  public final int getLayoutId()
  {
    return 2131492884;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(x paramx, w paramw, h paramh, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243031);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      x.a(this.tDf, this.tzq);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */