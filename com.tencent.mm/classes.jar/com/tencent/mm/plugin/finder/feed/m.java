package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.finder.convert.i;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.g.b.v.f;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class m
  extends q
{
  final Context context;
  private com.tencent.mm.sdk.b.c<gy> rhM;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(201660);
    this.context = paramContext;
    AppMethodBeat.o(201660);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(201659);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(2131307319);
    k.g(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(2131307319).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(201659);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(201656);
    k.h(parama, "builder");
    k.h(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem);
    this.rhM = ((com.tencent.mm.sdk.b.c)new d(this));
    com.tencent.mm.sdk.b.a.GpY.b(this.rhM);
    parama = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    c.a.cBc().onAlive();
    parama = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    c.a.cBc();
    com.tencent.mm.plugin.finder.storage.data.c.cBa();
    AppMethodBeat.o(201656);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201651);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(201651);
  }
  
  public final com.tencent.mm.view.recyclerview.c cuS()
  {
    AppMethodBeat.i(201652);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(201652);
    return localc;
  }
  
  public final void dY(View paramView)
  {
    AppMethodBeat.i(201658);
    k.h(paramView, "view");
    AppMethodBeat.o(201658);
  }
  
  public final RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(201653);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.h)new m.c();
    AppMethodBeat.o(201653);
    return paramContext;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201655);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(201655);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(201650);
    k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cuS(), this.data);
    AppMethodBeat.o(201650);
    return paramContext;
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(201654);
    FinderLikeDrawer.a locala = FinderLikeDrawer.rXU;
    int i = FinderLikeDrawer.cEZ();
    AppMethodBeat.o(201654);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201657);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label85:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((n)localObject3).ruS.EFh == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label85;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n)((Iterator)localObject1).next();
      localObject3 = new hl();
      ((hl)localObject3).diz.diA = ((n)localObject2).ruS.diA;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
    }
    super.onDetach();
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    c.a.cBc().onDetach();
    com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
    AppMethodBeat.o(201657);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(m paramm, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201641);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a(paramContext, paramView, this.rhN.getFeedObj().getId(), 0, false, 120);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.Q(paramContext, paramView);
      paramView = FinderReporterUIC.seQ;
      paramView = FinderReporterUIC.a.eV(paramContext);
      if (paramView != null)
      {
        localObject = d.rxr;
        d.b(paramView.cGb(), this.rhN.getFeedObj().getId(), 5, "");
        AppMethodBeat.o(201641);
        return;
      }
      AppMethodBeat.o(201641);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(201644);
      i locali = new i(this.rhN.getFeedObj().getId());
      final apw localapw = new apw();
      localapw.dig = this.rhN.getFeedObj().field_id;
      localapw.objectNonceId = this.rhN.getFeedObj().getFeedObject().objectNonceId;
      localapw.scene = 2;
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV(this.rhN.context);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).cGb();; localObject = null)
      {
        localapw.contextObj = ((anm)localObject);
        locali.rbj = ((d.g.a.b)new a(this, localapw));
        locali.rbk = ((d.g.a.b)new b(this, localapw));
        localObject = (com.tencent.mm.view.recyclerview.b)locali;
        AppMethodBeat.o(201644);
        return localObject;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<alo, y>
    {
      a(m.b paramb, apw paramapw)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<alo, y>
    {
      b(m.b paramb, apw paramapw)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<gy>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(m.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201649);
      this.rhU.bmi();
      AppMethodBeat.o(201649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.m
 * JD-Core Version:    0.7.0.1
 */