package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.g;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/HeadLivingListConvertData;", "outsideEventListener", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clear", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getLayoutId", "", "handleClickReport", "activity", "Landroid/app/Activity;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "position", "handleExposeReport", "record", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onBindViewHolder", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "Companion", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f>
{
  public static final a ENW;
  private com.tencent.mm.plugin.finder.live.report.a EJr;
  private com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a EMS;
  private final h ENC;
  private bui ENE;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  
  static
  {
    AppMethodBeat.i(340611);
    ENW = new a((byte)0);
    AppMethodBeat.o(340611);
  }
  
  public e(h paramh, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340522);
    this.ENC = paramh;
    this.ENg = paramb;
    this.EJr = new com.tencent.mm.plugin.finder.live.report.a();
    AppMethodBeat.o(340522);
  }
  
  private final void F(j paramj)
  {
    AppMethodBeat.i(340533);
    Object localObject1 = paramj.tag;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof b)))
    {
      localObject2 = ((b)localObject1).Bog;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = paramj.context;
        if (localObject3 == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(340533);
          throw paramj;
        }
        ((WxRecyclerView)localObject2).setAdapter((RecyclerView.a)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.f(new g((MMActivity)localObject3), new ArrayList()));
      }
      localObject2 = ((b)localObject1).ENJ;
      if (localObject2 != null) {
        this.ENC.listeners.remove(localObject2);
      }
      localObject2 = ((b)localObject1).ENX;
      if (localObject2 != null)
      {
        localObject3 = ((b)localObject1).Bog;
        if (localObject3 != null) {
          ((WxRecyclerView)localObject3).b((RecyclerView.l)localObject2);
        }
      }
      localObject2 = ((b)localObject1).ENK;
      if (localObject2 != null)
      {
        localObject1 = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject1 instanceof Application)) {
          break label203;
        }
      }
    }
    label203:
    for (localObject1 = (Application)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((Application)localObject1).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject2);
      }
      paramj.tag = null;
      AppMethodBeat.o(340533);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340623);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = k.aeZF;
    paramRecyclerView = paramj.context;
    s.s(paramRecyclerView, "holder.context");
    paramRecyclerView = ((as)k.nq(paramRecyclerView).q(as.class)).fou();
    Object localObject = paramj.context;
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(340623);
      throw paramRecyclerView;
    }
    this.EMS = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a(paramRecyclerView, (MMActivity)localObject, null, this.ENg);
    localObject = ah.aiuX;
    this.ENE = paramRecyclerView;
    paramRecyclerView = (WxRecyclerView)paramj.UH(f.d.EGv);
    if (paramRecyclerView != null) {
      c.a((RecyclerView)paramRecyclerView, (com.tencent.mm.view.recyclerview.d)new g(this));
    }
    AppMethodBeat.o(340623);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGT;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(340629);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("Finder.HeadLivingListConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(340629);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert;)V", "caller", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "getCaller", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "setCaller", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "rvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getRvScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setRvScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
  {
    WxRecyclerView Bog;
    h.a ENJ;
    Application.ActivityLifecycleCallbacks ENK;
    RecyclerView.l ENX;
    
    public b()
    {
      AppMethodBeat.i(340505);
      AppMethodBeat.o(340505);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    boolean isLoadingMore;
    
    c(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f paramf, e parame) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(340494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(340494);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340489);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      e locale;
      if (paramRecyclerView != null)
      {
        localObject = this.ENZ;
        locale = this.ENY;
        if (!(paramRecyclerView instanceof LinearLayoutManager))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(340489);
          return;
        }
        if (((LinearLayoutManager)paramRecyclerView).Jw() == ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)localObject).EML.size() - 1) {}
        for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(340489);
          return;
        }
        if (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)localObject).ENs.BeA <= 0) {
          break label240;
        }
      }
      label240:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) && (!this.isLoadingMore))
        {
          Log.i("Finder.HeadLivingListConvert", "#rvScrollListener-onScrollStateChanged ready to load");
          this.isLoadingMore = true;
          e.a(locale).d(((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)localObject).ENs.Zpm, (kotlin.g.a.b)new a(this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(340489);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<b.a<bqr>, ah>
    {
      a(e.c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$5", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller$SampleCaller;", "append", "", "containerId", "", "cards", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends h.a.a
  {
    d(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f paramf, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.f paramf1, e parame) {}
    
    public final void E(int paramInt, List<? extends bmz> paramList)
    {
      AppMethodBeat.i(340487);
      s.u(paramList, "cards");
      if (paramInt != this.ENZ.ENs.Zpm)
      {
        AppMethodBeat.o(340487);
        return;
      }
      Object localObject1 = i.EOv;
      i.a.a(this.ENZ.EML, (WxRecyclerAdapter)this.EOb);
      this.ENZ.ENs.YBg.addAll((Collection)paramList);
      Object localObject2 = (Iterable)paramList;
      paramList = this.ENY;
      localObject1 = this.EOb;
      com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f localf = this.ENZ;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((bmz)((Iterator)localObject2).next()).ZIo;
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          localObject3 = p.listOf(localObject3);
          localObject4 = av.GiL;
          localObject3 = (FinderItem)p.oL(d.a.a((List)localObject3, av.Ui(0), e.b(paramList)));
          if (localObject3 != null)
          {
            localf.EML.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.e((FinderItem)localObject3));
            Log.i("Finder.HeadLivingListConvert", s.X("#caller.append ", ((FinderItem)localObject3).getNickName()));
          }
          ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.f)localObject1).fW(localf.EML.size() - 1);
        }
      }
      paramList = i.EOv;
      i.a.a(this.ENZ.EML, (WxRecyclerAdapter)this.EOb, this.ENZ.ENs.BeA);
      AppMethodBeat.o(340487);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$7", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    e(e parame, j paramj) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(340479);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.HeadLivingListConvert", "#lifeCallback-onActivityDestroyed");
        e.a(this.ENY, this.wHm);
      }
      AppMethodBeat.o(340479);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onBindViewHolder$adapter$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements i.c<j>
  {
    f(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f paramf, e parame, WxRecyclerView paramWxRecyclerView) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingListConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    g(e parame) {}
    
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(340481);
      s.u(paramb, "item");
      AppMethodBeat.o(340481);
    }
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(340478);
      s.u(paramSet, "recordsSet");
      Log.i("Finder.HeadLivingListConvert", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      Object localObject = (Iterable)paramSet;
      paramSet = this.ENY;
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        e.a(paramSet, (com.tencent.mm.view.recyclerview.b)((Iterator)localObject).next());
      }
      AppMethodBeat.o(340478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.e
 * JD-Core Version:    0.7.0.1
 */