package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ho;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.f.a.ix.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class t
  extends x
{
  final Context context;
  private IListener<ho> xyI;
  
  public t(Context paramContext)
  {
    AppMethodBeat.i(266344);
    this.context = paramContext;
    AppMethodBeat.o(266344);
  }
  
  public final void a(final Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(266343);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "headerLayout");
    View localView = paramFrameLayout.findViewById(b.f.drawer_more_op);
    p.j(localView, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
    localView.setVisibility(0);
    paramFrameLayout.findViewById(b.f.drawer_more_op).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(266343);
  }
  
  public final void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(266340);
    p.k(parama, "builder");
    p.k(paramFinderItem, "feedObj");
    super.a(parama, paramFinderItem, paramb);
    this.xyI = ((IListener)new d(this));
    EventCenter.instance.add(this.xyI);
    parama = d.AmR;
    d.a.dZo().onAlive();
    parama = d.AmR;
    d.a.dZo();
    d.dZm();
    AppMethodBeat.o(266340);
  }
  
  public final f dtg()
  {
    AppMethodBeat.i(266336);
    f localf = (f)new b(this);
    AppMethodBeat.o(266336);
    return localf;
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(266339);
    p.k(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(266339);
    return paramContext;
  }
  
  public final void ev(View paramView)
  {
    AppMethodBeat.i(266342);
    p.k(paramView, "view");
    AppMethodBeat.o(266342);
  }
  
  public final RecyclerView.h fn(Context paramContext)
  {
    AppMethodBeat.i(266337);
    p.k(paramContext, "context");
    paramContext = (RecyclerView.h)new t.c();
    AppMethodBeat.o(266337);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> fs(Context paramContext)
  {
    AppMethodBeat.i(266335);
    p.k(paramContext, "context");
    paramContext = new WxRecyclerAdapter(dtg(), this.data);
    AppMethodBeat.o(266335);
    return paramContext;
  }
  
  public final int getScene()
  {
    AppMethodBeat.i(266338);
    FinderLikeDrawer.a locala = FinderLikeDrawer.AYs;
    int i = FinderLikeDrawer.eiO();
    AppMethodBeat.o(266338);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(266341);
    if (!isAttached())
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(266341);
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
      if (((v)localObject3).zAz.SJo == 1) {}
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
      localObject3 = new ix();
      ((ix)localObject3).fGd.fGe = ((v)localObject2).zAz.fGe;
      ix.a locala = ((ix)localObject3).fGd;
      if (((v)localObject2).zAp) {}
      for (i = 1;; i = 0)
      {
        locala.fGf = i;
        EventCenter.instance.publish((IEvent)localObject3);
        break;
      }
    }
    super.onDetach();
    localObject1 = d.AmR;
    d.a.dZo().onDetach();
    EventCenter.instance.removeListener(this.xyI);
    AppMethodBeat.o(266341);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(t paramt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287102);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      localObject = aj.Bnu;
      aj.a.a(paramContext, paramView, this.xyJ.getFeedObj().getId(), 0, false, 120);
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fJ(paramContext);
      paramView = aj.Bnu;
      paramView = aj.a.fZ(paramContext);
      if (paramView != null)
      {
        localObject = n.zWF;
        n.a(paramView.ekY(), this.xyJ.getFeedObj().getId(), 5, "");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287102);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(225675);
      o localo = new o(this.xyJ.getFeedObj().getId());
      final bmq localbmq = new bmq();
      localbmq.feedId = this.xyJ.getFeedObj().field_id;
      localbmq.objectNonceId = this.xyJ.getFeedObj().getFeedObject().objectNonceId;
      localbmq.scene = 2;
      Object localObject = aj.Bnu;
      localObject = aj.a.fZ(this.xyJ.context);
      if (localObject != null) {}
      for (localObject = ((aj)localObject).ekY();; localObject = null)
      {
        localbmq.xbu = ((bid)localObject);
        localo.xjj = ((kotlin.g.a.b)new a(this, localbmq));
        localo.xjk = ((kotlin.g.a.b)new b(this, localbmq));
        localObject = (com.tencent.mm.view.recyclerview.e)localo;
        AppMethodBeat.o(225675);
        return localObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<awr, kotlin.x>
    {
      a(t.b paramb, bmq parambmq)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<awr, kotlin.x>
    {
      b(t.b paramb, bmq parambmq)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<ho>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(t.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(292074);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZG.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t
 * JD-Core Version:    0.7.0.1
 */