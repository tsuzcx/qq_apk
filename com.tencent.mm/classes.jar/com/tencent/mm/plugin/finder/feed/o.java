package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.ht.a;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class o
  extends s
{
  final Context context;
  private com.tencent.mm.sdk.b.c<hd> seA;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(202322);
    this.context = paramContext;
    AppMethodBeat.o(202322);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(202321);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(2131307319);
    d.g.b.p.g(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(2131307319).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(202321);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(202318);
    d.g.b.p.h(parama, "builder");
    d.g.b.p.h(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem, paramb);
    this.seA = ((com.tencent.mm.sdk.b.c)new d(this));
    com.tencent.mm.sdk.b.a.IvT.b(this.seA);
    parama = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    c.a.cLE().onAlive();
    parama = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    c.a.cLE();
    com.tencent.mm.plugin.finder.storage.data.c.cLC();
    AppMethodBeat.o(202318);
  }
  
  public final com.tencent.mm.view.recyclerview.c cCV()
  {
    AppMethodBeat.i(202314);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(202314);
    return localc;
  }
  
  public final RecyclerView.h eO(Context paramContext)
  {
    AppMethodBeat.i(202315);
    d.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new o.c();
    AppMethodBeat.o(202315);
    return paramContext;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202317);
    d.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(202317);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eQ(Context paramContext)
  {
    AppMethodBeat.i(202313);
    d.g.b.p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cCV(), this.data);
    AppMethodBeat.o(202313);
    return paramContext;
  }
  
  public final void ee(View paramView)
  {
    AppMethodBeat.i(202320);
    d.g.b.p.h(paramView, "view");
    AppMethodBeat.o(202320);
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(202316);
    FinderLikeDrawer.a locala = FinderLikeDrawer.tgd;
    int i = FinderLikeDrawer.cQd();
    AppMethodBeat.o(202316);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202319);
    if (!this.hAF)
    {
      ae.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(202319);
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
      if (((com.tencent.mm.plugin.finder.model.p)localObject3).sti.GGt == 1) {}
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
      localObject2 = (com.tencent.mm.plugin.finder.model.p)((Iterator)localObject1).next();
      localObject3 = new ht();
      ((ht)localObject3).dvp.dvq = ((com.tencent.mm.plugin.finder.model.p)localObject2).sti.dvq;
      ht.a locala = ((ht)localObject3).dvp;
      if (((com.tencent.mm.plugin.finder.model.p)localObject2).sta) {}
      for (i = 1;; i = 0)
      {
        locala.dvr = i;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
        break;
      }
    }
    super.onDetach();
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    c.a.cLE().onDetach();
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    AppMethodBeat.o(202319);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(o paramo, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202304);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new Intent();
      localObject = FinderReporterUIC.tnG;
      FinderReporterUIC.a.a(paramContext, paramView, this.seB.getFeedObj().getId(), 0, false, 120);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.Q(paramContext, paramView);
      paramView = FinderReporterUIC.tnG;
      paramView = FinderReporterUIC.a.fc(paramContext);
      if (paramView != null)
      {
        localObject = i.syT;
        i.b(paramView.cQZ(), this.seB.getFeedObj().getId(), 5, "");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202304);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(202307);
      j localj = new j(this.seB.getFeedObj().getId());
      final aug localaug = new aug();
      localaug.duw = this.seB.getFeedObj().field_id;
      localaug.objectNonceId = this.seB.getFeedObj().getFeedObject().objectNonceId;
      localaug.scene = 2;
      Object localObject = FinderReporterUIC.tnG;
      localObject = FinderReporterUIC.a.fc(this.seB.context);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
      {
        localaug.rQw = ((arn)localObject);
        localj.rWl = ((d.g.a.b)new a(this, localaug));
        localj.rWm = ((d.g.a.b)new b(this, localaug));
        localObject = (com.tencent.mm.view.recyclerview.b)localj;
        AppMethodBeat.o(202307);
        return localObject;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<apg, z>
    {
      a(o.b paramb, aug paramaug)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends q
      implements d.g.a.b<apg, z>
    {
      b(o.b paramb, aug paramaug)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<hd>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */