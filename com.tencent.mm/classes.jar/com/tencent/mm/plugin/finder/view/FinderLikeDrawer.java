package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.aw;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.plugin.finder.view.builder.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"})
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  private static final int tvl = 1;
  private static final int tvm = 2;
  public static final a wnm;
  private b likeBuffer;
  private int scene;
  private FinderItem tMO;
  private a wnl;
  
  static
  {
    AppMethodBeat.i(254855);
    wnm = new a((byte)0);
    tvl = 1;
    tvm = 2;
    AppMethodBeat.o(254855);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254852);
    AppMethodBeat.o(254852);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254853);
    AppMethodBeat.o(254853);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254854);
    AppMethodBeat.o(254854);
  }
  
  public final void a(FinderItem paramFinderItem, b paramb)
  {
    AppMethodBeat.i(254850);
    kotlin.g.b.p.h(paramFinderItem, "feedObj");
    if (!dGs())
    {
      this.tMO = paramFinderItem;
      this.likeBuffer = paramb;
      super.bi(true, true);
    }
    AppMethodBeat.o(254850);
  }
  
  public final void dGr()
  {
    AppMethodBeat.i(254851);
    if (dGs()) {
      super.DG(true);
    }
    AppMethodBeat.o(254851);
  }
  
  public final a getBuilder()
  {
    return this.wnl;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.tMO;
  }
  
  public final b getLikeBuffer()
  {
    return this.likeBuffer;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final void setBuilder(a parama)
  {
    this.wnl = parama;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.tMO = paramFinderItem;
  }
  
  public final void setLikeBuffer(b paramb)
  {
    this.likeBuffer = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"})
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, final Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(254849);
      kotlin.g.b.p.h(paramContext, "context");
      kotlin.g.b.p.h(paramWindow, "window");
      Log.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      final FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      final z.f localf = new z.f();
      localf.SYG = null;
      if (paramInt == FinderLikeDrawer.dGP()) {
        localf.SYG = new a((aw)new com.tencent.mm.plugin.finder.feed.p(paramContext));
      }
      for (;;)
      {
        ((a)localf.SYG).a((RecyclerViewDrawer)localFinderLikeDrawer);
        localFinderLikeDrawer.setBuilder((a)localf.SYG);
        paramWindow.getDecorView().post((Runnable)new a(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, localf));
        if ((paramContext instanceof MMFragmentActivity)) {
          ((MMFragmentActivity)paramContext).getLifecycle().addObserver((LifecycleObserver)new FinderLikeDrawer.Companion.createDrawerToAttachWindow.2(localFinderLikeDrawer, paramContext));
        }
        AppMethodBeat.o(254849);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.dGQ()) {
          localf.SYG = new a((aw)new com.tencent.mm.plugin.finder.feed.t());
        } else {
          localf.SYG = new a((aw)new com.tencent.mm.plugin.finder.feed.t());
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, z.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(254847);
        int i = au.aB(this.$context);
        localLayoutParams.bottomMargin = i;
        Log.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject1 = paramWindow.getDecorView();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(254847);
          throw ((Throwable)localObject1);
        }
        ((FrameLayout)localObject1).addView((View)localFinderLikeDrawer, (ViewGroup.LayoutParams)localLayoutParams);
        localObject1 = (a)localf.SYG;
        Object localObject2 = this.$context;
        Object localObject3 = localFinderLikeDrawer.getHeaderLayout();
        kotlin.g.b.p.h(localObject2, "context");
        kotlin.g.b.p.h(localObject3, "headerLayout");
        ((a)localObject1).wrS = ((FrameLayout)localObject3);
        Object localObject4 = aa.jQ((Context)localObject2);
        Object localObject5 = ((a)localObject1).tLU;
        if (localObject5 == null) {
          kotlin.g.b.p.btv("likeDrawer");
        }
        localObject4 = ((LayoutInflater)localObject4).inflate(2131495211, (ViewGroup)((FinderLikeDrawer)localObject5).getHeaderLayout());
        localObject5 = ((View)localObject4).findViewById(2131299803);
        kotlin.g.b.p.g(localObject5, "header.findViewById(R.id.drawer_header_tv)");
        ((a)localObject1).wrR = ((TextView)localObject5);
        localObject5 = ((a)localObject1).wrR;
        if (localObject5 == null) {
          kotlin.g.b.p.btv("headerTitleTv");
        }
        ao.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
        localObject5 = ((View)localObject4).findViewById(2131298777);
        localObject4 = ((View)localObject4).findViewById(2131299804);
        ((View)localObject5).setOnClickListener((View.OnClickListener)new a.b((a)localObject1));
        ((a)localObject1).wrX.a((Context)localObject2, (FrameLayout)localObject3);
        localObject2 = ((a)localObject1).tLU;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("likeDrawer");
        }
        kotlin.g.b.p.g(localObject5, "closeBtn");
        ((FinderLikeDrawer)localObject2).hH((View)localObject5);
        localObject1 = ((a)localObject1).tLU;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("likeDrawer");
        }
        kotlin.g.b.p.g(localObject4, "moreBtn");
        ((FinderLikeDrawer)localObject1).hH((View)localObject4);
        localObject1 = (a)localf.SYG;
        localObject2 = this.$context;
        localObject3 = localFinderLikeDrawer.getCenterLayout();
        kotlin.g.b.p.h(localObject2, "context");
        kotlin.g.b.p.h(localObject3, "rlLayout");
        ((a)localObject1).tLS = ((RefreshLoadMoreLayout)localObject3);
        ((a)localObject1).wrX.dV((View)localObject3);
        localObject4 = aa.jQ((Context)localObject2).inflate(2131495297, null);
        kotlin.g.b.p.g(localObject4, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        ((RefreshLoadMoreLayout)localObject3).setLoadMoreFooter((View)localObject4);
        localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
        ((RecyclerView)localObject3).setHasFixedSize(true);
        localObject4 = ((RecyclerView)localObject3).getItemAnimator();
        if (localObject4 != null) {
          ((RecyclerView.f)localObject4).lB();
        }
        ((RecyclerView)localObject3).setLayoutManager(((a)localObject1).wrX.eS((Context)localObject2));
        ((RecyclerView)localObject3).b(((a)localObject1).wrX.fi((Context)localObject2));
        ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((a)localObject1).wrX.fm((Context)localObject2));
        localObject1 = (a)localf.SYG;
        localObject2 = this.$context;
        localObject3 = localFinderLikeDrawer.getLoadingLayout();
        kotlin.g.b.p.h(localObject2, "context");
        kotlin.g.b.p.h(localObject3, "loadingLayout");
        ((a)localObject1).wrT = ((FrameLayout)localObject3);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131494289, (ViewGroup)localObject3, true);
        localObject3 = ((View)localObject2).findViewById(2131303189);
        kotlin.g.b.p.g(localObject3, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
        ((a)localObject1).hSw = ((View)localObject3);
        localObject3 = ((View)localObject2).findViewById(2131305452);
        kotlin.g.b.p.g(localObject3, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
        ((a)localObject1).wrU = ((View)localObject3);
        localObject2 = ((View)localObject2).findViewById(2131307046);
        kotlin.g.b.p.g(localObject2, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
        ((a)localObject1).wrV = ((View)localObject2);
        localObject2 = ((a)localObject1).hSw;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("loadingView");
        }
        ((View)localObject2).setVisibility(0);
        localObject2 = ((a)localObject1).wrU;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("nothingView");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((a)localObject1).wrV;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("retryView");
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(254847);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */