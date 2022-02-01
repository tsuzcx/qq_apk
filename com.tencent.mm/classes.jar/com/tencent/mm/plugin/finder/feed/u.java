package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.data.h.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.g.b.v.e;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class u
  extends y
{
  final Context context;
  private com.tencent.mm.sdk.b.c<hf> xpb;
  
  public u(Context paramContext)
  {
    AppMethodBeat.i(197763);
    this.context = paramContext;
    AppMethodBeat.o(197763);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(197762);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(2131307288);
    k.g(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(2131307288).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(197762);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(197754);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(197754);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(197759);
    k.h(paramb, "builder");
    k.h(paramFinderItem, "feedObj");
    super.a(paramb, paramFinderItem);
    this.xpb = ((com.tencent.mm.sdk.b.c)new d(this));
    com.tencent.mm.sdk.b.a.ESL.b(this.xpb);
    paramb = h.KXp;
    h.a.fVe().onAlive();
    paramb = h.KXp;
    h.a.fVe();
    h.fVc();
    AppMethodBeat.o(197759);
  }
  
  public final RecyclerView.h eC(Context paramContext)
  {
    AppMethodBeat.i(197756);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(197756);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eD(Context paramContext)
  {
    AppMethodBeat.i(197753);
    k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(fTj(), this.data);
    AppMethodBeat.o(197753);
    return paramContext;
  }
  
  public final com.tencent.mm.view.recyclerview.c fTj()
  {
    AppMethodBeat.i(197755);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(197755);
    return localc;
  }
  
  public final void gO(View paramView)
  {
    AppMethodBeat.i(197761);
    k.h(paramView, "view");
    AppMethodBeat.o(197761);
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(197757);
    FinderLikeDrawer.a locala = FinderLikeDrawer.Lfb;
    int i = FinderLikeDrawer.fWQ();
    AppMethodBeat.o(197757);
    return i;
  }
  
  public final RecyclerView.i lw(Context paramContext)
  {
    AppMethodBeat.i(197758);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(197758);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(197760);
    super.onDetach();
    h.a locala = h.KXp;
    h.a.fVe().onDetach();
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    AppMethodBeat.o(197760);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(u paramu, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197744);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a(paramContext, paramView, this.KNu.getFeedObj().getId(), 0, false, 120);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.ah(paramContext, paramView);
      paramView = FinderReporterUIC.Ljl;
      paramView = FinderReporterUIC.a.lB(paramContext);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.b(paramView.fXs(), this.KNu.getFeedObj().getId(), 5, "");
        AppMethodBeat.o(197744);
        return;
      }
      AppMethodBeat.o(197744);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(197747);
      aa localaa = new aa(this.KNu.getFeedObj().getId());
      final dzz localdzz = new dzz();
      localdzz.feedId = this.KNu.getFeedObj().field_id;
      localdzz.objectNonceId = this.KNu.getFeedObj().getFeedObject().objectNonceId;
      localdzz.scene = 2;
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB(this.KNu.context);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).fXs();; localObject = null)
      {
        localdzz.contextObj = ((dzp)localObject);
        localaa.KKO = ((d.g.a.b)new a(this, localdzz));
        localaa.KKP = ((d.g.a.b)new b(this, localdzz));
        localObject = (com.tencent.mm.view.recyclerview.b)localaa;
        AppMethodBeat.o(197747);
        return localObject;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<dzd, d.y>
    {
      a(u.b paramb, dzz paramdzz)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<dzd, d.y>
    {
      b(u.b paramb, dzz paramdzz)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(197748);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(197748);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<hf>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(u.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197752);
      this.KNB.bfo();
      AppMethodBeat.o(197752);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u
 * JD-Core Version:    0.7.0.1
 */