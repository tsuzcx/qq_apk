package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hz;
import com.tencent.mm.autogen.a.jw;
import com.tencent.mm.autogen.a.jw.a;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends y
{
  final Context context;
  private IListener<hz> qmO;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(362619);
    this.context = paramContext;
    AppMethodBeat.o(362619);
  }
  
  private static final void a(Context paramContext, s params, View paramView)
  {
    AppMethodBeat.i(362652);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(params);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(params, "this$0");
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a(paramContext, paramView, params.getFeedObj().getId(), 0, false, 120);
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hd(paramContext);
    paramView = as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext != null)
    {
      paramView = z.FrZ;
      z.a(paramContext.fou(), params.getFeedObj().getId(), 5, "");
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362652);
  }
  
  private static final void b(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(362636);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362636);
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(362793);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFrameLayout, "headerLayout");
    paramFrameLayout.findViewById(e.e.drawer_more_op).setVisibility(0);
    paramFrameLayout.findViewById(e.e.drawer_more_op).setOnClickListener(new s..ExternalSyntheticLambda0(paramContext, this));
    AppMethodBeat.o(362793);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(362758);
    kotlin.g.b.s.u(parama, "builder");
    kotlin.g.b.s.u(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem, paramb);
    this.qmO = ((IListener)new FinderFriendLikeListDrawerPresenter.onAttach.1(this, com.tencent.mm.app.f.hfK));
    parama = this.qmO;
    if (parama != null) {
      parama.alive();
    }
    parama = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onAlive();
    parama = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX();
    com.tencent.mm.plugin.finder.storage.data.d.eZV();
    AppMethodBeat.o(362758);
  }
  
  public final g ech()
  {
    AppMethodBeat.i(362718);
    g localg = (g)new a(this);
    AppMethodBeat.o(362718);
    return localg;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362749);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(362749);
    return paramContext;
  }
  
  public final void fx(View paramView)
  {
    AppMethodBeat.i(362786);
    kotlin.g.b.s.u(paramView, "view");
    AppMethodBeat.o(362786);
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(362739);
    FinderLikeDrawer.a locala = FinderLikeDrawer.GAf;
    int i = FinderLikeDrawer.fkM();
    AppMethodBeat.o(362739);
    return i;
  }
  
  public final RecyclerView.h gl(Context paramContext)
  {
    AppMethodBeat.i(362730);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (RecyclerView.h)new b();
    AppMethodBeat.o(362730);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> gr(Context paramContext)
  {
    AppMethodBeat.i(362705);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = new WxRecyclerAdapter(ech(), this.data);
    AppMethodBeat.o(362705);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362774);
    if (!isAttached())
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(362774);
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
      if (((w)localObject3).ECH.ZNz == 1) {}
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
      localObject2 = (w)((Iterator)localObject1).next();
      localObject3 = new jw();
      ((jw)localObject3).hLu.hLv = ((w)localObject2).ECH.hLv;
      jw.a locala = ((jw)localObject3).hLu;
      if (((w)localObject2).ECz) {}
      for (i = 1;; i = 0)
      {
        locala.hLw = i;
        ((jw)localObject3).publish();
        break;
      }
    }
    super.onDetach();
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onDetach();
    localObject1 = this.qmO;
    if (localObject1 != null) {
      ((IListener)localObject1).dead();
    }
    AppMethodBeat.o(362774);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    a(s params) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363672);
      o localo = new o(this.AVI.getFeedObj().getId());
      final cak localcak = new cak();
      Object localObject = this.AVI;
      localcak.feedId = ((s)localObject).getFeedObj().field_id;
      localcak.objectNonceId = ((s)localObject).getFeedObj().getFeedObject().objectNonceId;
      localcak.scene = 2;
      as.a locala = as.GSQ;
      localObject = as.a.hu(((s)localObject).context);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((as)localObject).fou())
      {
        localcak.Auc = ((bui)localObject);
        localo.AIb = ((kotlin.g.a.b)new a(this.AVI, localcak));
        localo.AIc = ((kotlin.g.a.b)new b(this.AVI, localcak));
        localObject = (com.tencent.mm.view.recyclerview.f)localo;
        AppMethodBeat.o(363672);
        return localObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<bco, ah>
    {
      a(s params, cak paramcak)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<bco, ah>
    {
      b(s params, cak paramcak)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(363673);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(363673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s
 * JD-Core Version:    0.7.0.1
 */