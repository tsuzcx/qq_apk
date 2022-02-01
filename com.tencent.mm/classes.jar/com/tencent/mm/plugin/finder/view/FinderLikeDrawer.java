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
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.feed.o;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.plugin.finder.view.builder.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"})
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  private static final int rJl = 1;
  private static final int rJm = 2;
  public static final a sUO;
  private a Odl;
  private b likeBuffer;
  private FinderItem rUg;
  private int scene;
  
  static
  {
    AppMethodBeat.i(205162);
    sUO = new a((byte)0);
    rJl = 1;
    rJm = 2;
    AppMethodBeat.o(205162);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205159);
    AppMethodBeat.o(205159);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205160);
    AppMethodBeat.o(205160);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205161);
    AppMethodBeat.o(205161);
  }
  
  public final void a(FinderItem paramFinderItem, b paramb)
  {
    AppMethodBeat.i(205157);
    p.h(paramFinderItem, "feedObj");
    if (!cMZ())
    {
      this.rUg = paramFinderItem;
      this.likeBuffer = paramb;
      super.aZ(true, true);
    }
    AppMethodBeat.o(205157);
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(205158);
    if (cMZ()) {
      super.zi(true);
    }
    AppMethodBeat.o(205158);
  }
  
  public final a getBuilder()
  {
    return this.Odl;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.rUg;
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
    this.Odl = parama;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.rUg = paramFinderItem;
  }
  
  public final void setLikeBuffer(b paramb)
  {
    this.likeBuffer = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"})
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, final Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(205156);
      p.h(paramContext, "context");
      p.h(paramWindow, "window");
      ad.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      final FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      final y.f localf = new y.f();
      localf.MLV = null;
      if (paramInt == FinderLikeDrawer.cNt()) {
        localf.MLV = new a((aq)new o(paramContext));
      }
      for (;;)
      {
        ((a)localf.MLV).a((RecyclerViewDrawer)localFinderLikeDrawer);
        localFinderLikeDrawer.setBuilder((a)localf.MLV);
        paramWindow.getDecorView().post((Runnable)new a(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, localf));
        if ((paramContext instanceof MMActivity)) {
          ((MMActivity)paramContext).getLifecycle().addObserver((LifecycleObserver)new FinderLikeDrawer.Companion.createDrawerToAttachWindow.2(localFinderLikeDrawer, paramContext));
        }
        AppMethodBeat.o(205156);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.cNu()) {
          localf.MLV = new a((aq)new s());
        } else {
          localf.MLV = new a((aq)new s());
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, y.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(205154);
        int i = ar.jS(this.cqB);
        localLayoutParams.bottomMargin = i;
        ad.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject1 = paramWindow.getDecorView();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(205154);
          throw ((Throwable)localObject1);
        }
        ((FrameLayout)localObject1).addView((View)localFinderLikeDrawer, (ViewGroup.LayoutParams)localLayoutParams);
        localObject1 = (a)localf.MLV;
        Object localObject2 = this.cqB;
        Object localObject3 = localFinderLikeDrawer.getHeaderLayout();
        p.h(localObject2, "context");
        p.h(localObject3, "headerLayout");
        ((a)localObject1).sXF = ((FrameLayout)localObject3);
        Object localObject4 = z.jO((Context)localObject2);
        Object localObject5 = ((a)localObject1).rTH;
        if (localObject5 == null) {
          p.bcb("likeDrawer");
        }
        localObject4 = ((LayoutInflater)localObject4).inflate(2131496280, (ViewGroup)((FinderLikeDrawer)localObject5).getHeaderLayout());
        localObject5 = ((View)localObject4).findViewById(2131299237);
        p.g(localObject5, "header.findViewById(R.id.drawer_header_tv)");
        ((a)localObject1).sXE = ((TextView)localObject5);
        localObject5 = ((a)localObject1).sXE;
        if (localObject5 == null) {
          p.bcb("headerTitleTv");
        }
        al.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
        localObject5 = ((View)localObject4).findViewById(2131298369);
        localObject4 = ((View)localObject4).findViewById(2131307319);
        ((View)localObject5).setOnClickListener((View.OnClickListener)new a.b((a)localObject1));
        ((a)localObject1).sXK.a((Context)localObject2, (FrameLayout)localObject3);
        localObject2 = ((a)localObject1).rTH;
        if (localObject2 == null) {
          p.bcb("likeDrawer");
        }
        p.g(localObject5, "closeBtn");
        ((FinderLikeDrawer)localObject2).hk((View)localObject5);
        localObject1 = ((a)localObject1).rTH;
        if (localObject1 == null) {
          p.bcb("likeDrawer");
        }
        p.g(localObject4, "moreBtn");
        ((FinderLikeDrawer)localObject1).hk((View)localObject4);
        localObject1 = (a)localf.MLV;
        localObject2 = this.cqB;
        localObject3 = localFinderLikeDrawer.getCenterLayout();
        p.h(localObject2, "context");
        p.h(localObject3, "rlLayout");
        ((a)localObject1).rTF = ((RefreshLoadMoreLayout)localObject3);
        ((a)localObject1).sXK.ee((View)localObject3);
        localObject4 = z.jO((Context)localObject2).inflate(2131494590, null);
        p.g(localObject4, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        ((RefreshLoadMoreLayout)localObject3).setLoadMoreFooter((View)localObject4);
        localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
        ((RecyclerView)localObject3).setHasFixedSize(true);
        localObject4 = ((RecyclerView)localObject3).getItemAnimator();
        if (localObject4 != null) {
          ((RecyclerView.f)localObject4).lt();
        }
        ((RecyclerView)localObject3).setLayoutManager(((a)localObject1).sXK.eL((Context)localObject2));
        ((RecyclerView)localObject3).b(((a)localObject1).sXK.eK((Context)localObject2));
        ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((a)localObject1).sXK.eM((Context)localObject2));
        localObject1 = (a)localf.MLV;
        localObject2 = this.cqB;
        localObject3 = localFinderLikeDrawer.getLoadingLayout();
        p.h(localObject2, "context");
        p.h(localObject3, "loadingLayout");
        ((a)localObject1).sXG = ((FrameLayout)localObject3);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131496190, (ViewGroup)localObject3, true);
        localObject3 = ((View)localObject2).findViewById(2131307495);
        p.g(localObject3, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
        ((a)localObject1).gWO = ((View)localObject3);
        localObject3 = ((View)localObject2).findViewById(2131307885);
        p.g(localObject3, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
        ((a)localObject1).sXH = ((View)localObject3);
        localObject2 = ((View)localObject2).findViewById(2131307942);
        p.g(localObject2, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
        ((a)localObject1).sXI = ((View)localObject2);
        localObject2 = ((a)localObject1).gWO;
        if (localObject2 == null) {
          p.bcb("loadingView");
        }
        ((View)localObject2).setVisibility(0);
        localObject2 = ((a)localObject1).sXH;
        if (localObject2 == null) {
          p.bcb("nothingView");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((a)localObject1).sXI;
        if (localObject1 == null) {
          p.bcb("retryView");
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(205154);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */