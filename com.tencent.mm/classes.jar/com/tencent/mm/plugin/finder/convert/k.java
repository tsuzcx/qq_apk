package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.report.v.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.g.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.MediaBanner.d;
import com.tencent.mm.view.MediaBannerIndicator;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isClickSwitch", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "plugin-finder_release"})
public class k
  extends h<n>
{
  private final com.tencent.mm.plugin.finder.feed.h rMI;
  private boolean rOa;
  
  public k(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    super(paramh, paramBoolean, paramInt);
    AppMethodBeat.i(165394);
    this.rMI = paramh;
    AppMethodBeat.o(165394);
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165392);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    Object localObject1 = (FinderMediaBanner)parame.Gd(2131302203);
    ((FinderMediaBanner)localObject1).setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    ((FinderMediaBanner)localObject1).setViewPool(this.rMI.cAF());
    ((FinderMediaBanner)localObject1).setParentRecyclerView(paramRecyclerView);
    ((FinderMediaBanner)localObject1).getIndicator().setShowOnlyOneIndicator(true);
    if ((((FinderMediaBanner)localObject1).getIndicator().getVisibility() == 0) && (((FinderMediaBanner)localObject1).getStyle() == MediaBanner.d.LoS)) {
      ((FinderMediaBanner)localObject1).getSpaceView().setVisibility(8);
    }
    ((FinderMediaBanner)localObject1).setPageChangeCallback((MediaBanner.c)new a(parame));
    paramRecyclerView = (FinderImageBulletSubtitleLayout)parame.Gd(2131308136);
    localObject1 = (TextView)parame.Gd(2131308135);
    paramRecyclerView.rWe.a(paramRecyclerView.rWd);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new b(this, paramRecyclerView));
    if ((parame.getContext() instanceof MMActivity))
    {
      Object localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject2 = parame.getContext();
      if (localObject2 == null)
      {
        paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(165392);
        throw paramRecyclerView;
      }
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject2).get(FinderReporterUIC.class)).Gt(this.duh);
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new c(parame, paramRecyclerView, (TextView)localObject1));
        AppMethodBeat.o(165392);
        return;
      }
    }
    AppMethodBeat.o(165392);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, View paramView)
  {
    AppMethodBeat.i(201383);
    p.h(parame, "holder");
    p.h(paramView, "view");
    parame = (BaseFinderFeed)parame.fQC();
    if (!parame.feedObject.isPostFinish())
    {
      AppMethodBeat.o(201383);
      return;
    }
    g.a locala = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    if (!((Boolean)com.tencent.mm.plugin.finder.upload.action.g.cKV().k(parame.feedObject.getFeedObject()).first).booleanValue()) {
      t.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(2131766751), 0).show();
    }
    AppMethodBeat.o(201383);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201382);
    p.h(parame, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObj");
    if (this.rOa)
    {
      this.rOa = false;
      AppMethodBeat.o(201382);
      return;
    }
    paramView = (TextView)parame.Gd(2131308135);
    paramFinderObject = (TextView)parame.Gd(2131308135);
    parame = (FinderImageBulletSubtitleLayout)parame.Gd(2131308136);
    p.g(paramView, "button");
    if (paramView.getVisibility() == 0)
    {
      paramView.setVisibility(8);
      parame.setBulletSubtitleAlpha(1.0F);
      AppMethodBeat.o(201382);
      return;
    }
    p.g(paramFinderObject, "bulletSubtitleSwitch");
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    paramFinderObject.setSelected(locale.ajl().getBoolean(al.a.IIP, true));
    paramView.setVisibility(0);
    parame.setBulletSubtitleAlpha(0.3F);
    AppMethodBeat.o(201382);
  }
  
  public final int getLayoutId()
  {
    return 2131492870;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class a
    implements MediaBanner.c
  {
    a(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165391);
      n localn = (n)this.oNd.fQC();
      Object localObject1 = localn.feedObject.getMediaList().get(paramInt);
      p.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bvf)localObject1;
      Object localObject2 = FinderReporterUIC.tcM;
      localObject2 = this.oNd.getContext();
      p.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.eY((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = new com.tencent.mm.plugin.finder.report.v(FinderReporterUIC.a((FinderReporterUIC)localObject2)).cEA();
        long l = localn.feedObject.getId();
        String str = localn.feedObject.getObjectNonceId();
        LinkedList localLinkedList = new LinkedList((Collection)localn.feedObject.getMediaList());
        p.g(localn, "feed");
        ((v.a)localObject2).a(l, (bvf)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localn);
        AppMethodBeat.o(165391);
        return;
      }
      AppMethodBeat.o(165391);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(k paramk, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201378);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      k.a(this.rOb);
      if (!paramRecyclerView.getFunctionSwitch()) {}
      for (boolean bool = true;; bool = false)
      {
        p.g(paramView, "it");
        paramView.setSelected(bool);
        paramView = com.tencent.mm.kernel.g.ajC();
        p.g(paramView, "MMKernel.storage()");
        paramView.ajl().set(al.a.IIP, Boolean.valueOf(bool));
        paramRecyclerView.rWd.N(bool, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201378);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$3", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "resetBulletSubtitle", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    c(com.tencent.mm.view.recyclerview.e parame, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout, TextView paramTextView) {}
    
    private void cyY()
    {
      AppMethodBeat.i(201380);
      TextView localTextView = (TextView)this.oNd.Gd(2131308135);
      p.g(localTextView, "button");
      localTextView.setVisibility(8);
      paramRecyclerView.rWd.reset(false);
      AppMethodBeat.o(201380);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201379);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        Object localObject = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRn;
        if (localObject != null)
        {
          localObject = ((BaseFinderFeed)localObject).feedObject;
          if ((localObject != null) && (((FinderItem)localObject).getMediaType() == 2))
          {
            if (this.oNd.lN() == ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRk)
            {
              if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)
              {
                cyY();
                AppMethodBeat.o(201379);
                return;
              }
              if (((((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 0) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 5) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 6)) || (!paramRecyclerView.getFunctionSwitch()) || (paramRecyclerView.rWd.rUw)) {
                break label223;
              }
              paramRecyclerView.rWe.aUU();
              paramRecyclerView.rWd.cAX();
              paramb = this.rOd;
              p.g(paramb, "bulletSubtitleSwitch");
              if (paramb.getVisibility() == 0)
              {
                paramRecyclerView.setBulletSubtitleAlpha(0.3F);
                AppMethodBeat.o(201379);
                return;
              }
              paramRecyclerView.setBulletSubtitleAlpha(1.0F);
              AppMethodBeat.o(201379);
              return;
            }
            cyY();
            AppMethodBeat.o(201379);
            return;
          }
        }
      }
      cyY();
      label223:
      AppMethodBeat.o(201379);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201381);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)))
      {
        AppMethodBeat.o(201381);
        return true;
      }
      AppMethodBeat.o(201381);
      return false;
    }
    
    public final boolean cyW()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k
 * JD-Core Version:    0.7.0.1
 */