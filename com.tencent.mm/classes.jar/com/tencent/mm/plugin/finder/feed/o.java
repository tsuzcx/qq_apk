package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.hs.a;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class o
  extends s
{
  final Context context;
  private com.tencent.mm.sdk.b.c<hc> rVT;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(201862);
    this.context = paramContext;
    AppMethodBeat.o(201862);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(201861);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(2131307319);
    p.g(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(2131307319).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(201861);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(201858);
    p.h(parama, "builder");
    p.h(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem, paramb);
    this.rVT = ((com.tencent.mm.sdk.b.c)new d(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    parama = com.tencent.mm.plugin.finder.storage.data.c.szF;
    c.a.cJc().onAlive();
    parama = com.tencent.mm.plugin.finder.storage.data.c.szF;
    c.a.cJc();
    com.tencent.mm.plugin.finder.storage.data.c.cJa();
    AppMethodBeat.o(201858);
  }
  
  public final com.tencent.mm.view.recyclerview.c cBj()
  {
    AppMethodBeat.i(201854);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(201854);
    return localc;
  }
  
  public final RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(201855);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(201855);
    return paramContext;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201857);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(201857);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(201853);
    p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cBj(), this.data);
    AppMethodBeat.o(201853);
    return paramContext;
  }
  
  public final void ee(View paramView)
  {
    AppMethodBeat.i(201860);
    p.h(paramView, "view");
    AppMethodBeat.o(201860);
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(201856);
    FinderLikeDrawer.a locala = FinderLikeDrawer.sUO;
    int i = FinderLikeDrawer.cNt();
    AppMethodBeat.o(201856);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201859);
    if (!this.hxR)
    {
      ad.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(201859);
      return;
    }
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    int i;
    label108:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.plugin.finder.model.o)localObject3).skl.Gnn == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label108;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.finder.model.o)((Iterator)localObject1).next();
      localObject3 = new hs();
      ((hs)localObject3).duk.dul = ((com.tencent.mm.plugin.finder.model.o)localObject2).skl.dul;
      hs.a locala = ((hs)localObject3).duk;
      if (((com.tencent.mm.plugin.finder.model.o)localObject2).skd) {}
      for (i = 1;; i = 0)
      {
        locala.dum = i;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
        break;
      }
    }
    super.onDetach();
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.szF;
    c.a.cJc().onDetach();
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    AppMethodBeat.o(201859);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(o paramo, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201844);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a(paramContext, paramView, this.rVU.getFeedObj().getId(), 0, false, 120);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.Q(paramContext, paramView);
      paramView = FinderReporterUIC.tcM;
      paramView = FinderReporterUIC.a.eY(paramContext);
      if (paramView != null)
      {
        localObject = h.soM;
        h.b(paramView.cOu(), this.rVU.getFeedObj().getId(), 5, "");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201844);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(201847);
      j localj = new j(this.rVU.getFeedObj().getId());
      final atq localatq = new atq();
      localatq.dtq = this.rVU.getFeedObj().field_id;
      localatq.objectNonceId = this.rVU.getFeedObj().getFeedObject().objectNonceId;
      localatq.scene = 2;
      Object localObject = FinderReporterUIC.tcM;
      localObject = FinderReporterUIC.a.eY(this.rVU.context);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
      {
        localatq.rIl = ((aqy)localObject);
        localj.rNT = ((d.g.a.b)new a(this, localatq));
        localj.rNU = ((d.g.a.b)new b(this, localatq));
        localObject = (com.tencent.mm.view.recyclerview.b)localj;
        AppMethodBeat.o(201847);
        return localObject;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<aot, z>
    {
      a(o.b paramb, atq paramatq)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends q
      implements d.g.a.b<aot, z>
    {
      b(o.b paramb, atq paramatq)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(201848);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(201848);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<hc>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(o.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201852);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.rVZ.bpT();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201852);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */