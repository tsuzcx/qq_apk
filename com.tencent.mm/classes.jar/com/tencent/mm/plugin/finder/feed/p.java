package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.ii.a;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class p
  extends t
{
  final Context context;
  private IListener<hh> tOh;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(243874);
    this.context = paramContext;
    AppMethodBeat.o(243874);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(243873);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(2131299804);
    kotlin.g.b.p.g(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(2131299804).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(243873);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(243870);
    kotlin.g.b.p.h(parama, "builder");
    kotlin.g.b.p.h(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem, paramb);
    this.tOh = ((IListener)new d(this));
    EventCenter.instance.add(this.tOh);
    parama = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    d.a.dyw().onAlive();
    parama = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    d.a.dyw();
    com.tencent.mm.plugin.finder.storage.data.d.dyu();
    AppMethodBeat.o(243870);
  }
  
  public final void dV(View paramView)
  {
    AppMethodBeat.i(243872);
    kotlin.g.b.p.h(paramView, "view");
    AppMethodBeat.o(243872);
  }
  
  public final f dcK()
  {
    AppMethodBeat.i(243866);
    f localf = (f)new b(this);
    AppMethodBeat.o(243866);
    return localf;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243869);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(243869);
    return paramContext;
  }
  
  public final RecyclerView.h fi(Context paramContext)
  {
    AppMethodBeat.i(243867);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(243867);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> fm(Context paramContext)
  {
    AppMethodBeat.i(243865);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(dcK(), this.data);
    AppMethodBeat.o(243865);
    return paramContext;
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(243868);
    FinderLikeDrawer.a locala = FinderLikeDrawer.wnm;
    int i = FinderLikeDrawer.dGP();
    AppMethodBeat.o(243868);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243871);
    if (!this.iuM)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(243871);
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
      if (((v)localObject3).uOk.LFn == 1) {}
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
      localObject2 = (v)((Iterator)localObject1).next();
      localObject3 = new ii();
      ((ii)localObject3).dMV.dMW = ((v)localObject2).uOk.dMW;
      ii.a locala = ((ii)localObject3).dMV;
      if (((v)localObject2).uOb) {}
      for (i = 1;; i = 0)
      {
        locala.dMX = i;
        EventCenter.instance.publish((IEvent)localObject3);
        break;
      }
    }
    super.onDetach();
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    d.a.dyw().onDetach();
    EventCenter.instance.removeListener(this.tOh);
    AppMethodBeat.o(243871);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(p paramp, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243856);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a(paramContext, paramView, this.tOi.getFeedObj().getId(), 0, false, 120);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fx(paramContext);
      paramView = FinderReporterUIC.wzC;
      paramView = FinderReporterUIC.a.fH(paramContext);
      if (paramView != null)
      {
        localObject = k.vfA;
        k.a(paramView.dIx(), this.tOi.getFeedObj().getId(), 5, "");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243856);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(243859);
      n localn = new n(this.tOi.getFeedObj().getId());
      final bfp localbfp = new bfp();
      localbfp.feedId = this.tOi.getFeedObj().field_id;
      localbfp.objectNonceId = this.tOi.getFeedObj().getFeedObject().objectNonceId;
      localbfp.scene = 2;
      Object localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH(this.tOi.context);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        localbfp.ttO = ((bbn)localObject);
        localn.tBx = ((kotlin.g.a.b)new a(this, localbfp));
        localn.tBy = ((kotlin.g.a.b)new b(this, localbfp));
        localObject = (e)localn;
        AppMethodBeat.o(243859);
        return localObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<aul, x>
    {
      a(p.b paramb, bfp parambfp)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<aul, x>
    {
      b(p.b paramb, bfp parambfp)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(243860);
      kotlin.g.b.p.h(paramRect, "outRect");
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramRecyclerView, "parent");
      kotlin.g.b.p.h(params, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(243860);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hh>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(p.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243864);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tOn.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.p
 * JD-Core Version:    0.7.0.1
 */