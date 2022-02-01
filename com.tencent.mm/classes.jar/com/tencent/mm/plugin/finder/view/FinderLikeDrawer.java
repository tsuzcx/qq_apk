package com.tencent.mm.plugin.finder.view;

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
import com.tencent.mm.plugin.finder.feed.ak;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.plugin.finder.view.builder.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"})
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  private static final int qXZ = 1;
  private static final int qYa = 2;
  public static final a rXU;
  private FinderItem rgw;
  private int scene;
  
  static
  {
    AppMethodBeat.i(204184);
    rXU = new a((byte)0);
    qXZ = 1;
    qYa = 2;
    AppMethodBeat.o(204184);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204181);
    AppMethodBeat.o(204181);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204182);
    AppMethodBeat.o(204182);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204183);
    AppMethodBeat.o(204183);
  }
  
  public final void cEF()
  {
    AppMethodBeat.i(204180);
    if (cEG()) {
      super.yv(true);
    }
    AppMethodBeat.o(204180);
  }
  
  public final FinderItem getFeedObj()
  {
    return this.rgw;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final void p(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204179);
    k.h(paramFinderItem, "feedObj");
    if (!cEG())
    {
      this.rgw = paramFinderItem;
      super.aR(true, true);
    }
    AppMethodBeat.o(204179);
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.rgw = paramFinderItem;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"})
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, final Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(204178);
      k.h(paramContext, "context");
      k.h(paramWindow, "window");
      ac.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      final FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      final v.f localf = new v.f();
      localf.KUQ = null;
      if (paramInt == FinderLikeDrawer.cEZ()) {
        localf.KUQ = new a((ak)new m(paramContext));
      }
      for (;;)
      {
        ((a)localf.KUQ).a((RecyclerViewDrawer)localFinderLikeDrawer);
        paramWindow.getDecorView().post((Runnable)new a(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, localf));
        AppMethodBeat.o(204178);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.cFa()) {
          localf.KUQ = new a((ak)new q());
        } else {
          localf.KUQ = new a((ak)new q());
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, v.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(204177);
        int i = ap.jG(this.cgl);
        localLayoutParams.bottomMargin = i;
        ac.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject1 = paramWindow.getDecorView();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(204177);
          throw ((Throwable)localObject1);
        }
        ((FrameLayout)localObject1).addView((View)localFinderLikeDrawer, (ViewGroup.LayoutParams)localLayoutParams);
        localObject1 = (a)localf.KUQ;
        Object localObject2 = this.cgl;
        Object localObject3 = localFinderLikeDrawer.getHeaderLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "headerLayout");
        ((a)localObject1).saq = ((FrameLayout)localObject3);
        Object localObject4 = z.jD((Context)localObject2);
        Object localObject5 = ((a)localObject1).rfV;
        if (localObject5 == null) {
          k.aVY("likeDrawer");
        }
        localObject4 = ((LayoutInflater)localObject4).inflate(2131496280, (ViewGroup)((FinderLikeDrawer)localObject5).getHeaderLayout());
        localObject5 = ((View)localObject4).findViewById(2131299237);
        k.g(localObject5, "header.findViewById(R.id.drawer_header_tv)");
        ((a)localObject1).sap = ((TextView)localObject5);
        localObject5 = ((a)localObject1).sap;
        if (localObject5 == null) {
          k.aVY("headerTitleTv");
        }
        aj.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
        localObject5 = ((View)localObject4).findViewById(2131298369);
        localObject4 = ((View)localObject4).findViewById(2131307319);
        ((View)localObject5).setOnClickListener((View.OnClickListener)new a.b((a)localObject1));
        ((a)localObject1).sav.a((Context)localObject2, (FrameLayout)localObject3);
        localObject2 = ((a)localObject1).rfV;
        if (localObject2 == null) {
          k.aVY("likeDrawer");
        }
        k.g(localObject5, "closeBtn");
        ((FinderLikeDrawer)localObject2).gT((View)localObject5);
        localObject1 = ((a)localObject1).rfV;
        if (localObject1 == null) {
          k.aVY("likeDrawer");
        }
        k.g(localObject4, "moreBtn");
        ((FinderLikeDrawer)localObject1).gT((View)localObject4);
        localObject1 = (a)localf.KUQ;
        localObject2 = this.cgl;
        localObject3 = localFinderLikeDrawer.getCenterLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "rlLayout");
        ((a)localObject1).rfT = ((RefreshLoadMoreLayout)localObject3);
        ((a)localObject1).sav.dY((View)localObject3);
        localObject4 = z.jD((Context)localObject2).inflate(2131494590, null);
        k.g(localObject4, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        ((RefreshLoadMoreLayout)localObject3).setLoadMoreFooter((View)localObject4);
        localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
        ((RecyclerView)localObject3).setHasFixedSize(true);
        localObject4 = ((RecyclerView)localObject3).getItemAnimator();
        if (localObject4 != null) {
          ((RecyclerView.f)localObject4).lb();
        }
        ((RecyclerView)localObject3).setLayoutManager(((a)localObject1).sav.eL((Context)localObject2));
        ((RecyclerView)localObject3).b(((a)localObject1).sav.eK((Context)localObject2));
        ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((a)localObject1).sav.eM((Context)localObject2));
        localObject1 = (a)localf.KUQ;
        localObject2 = this.cgl;
        localObject3 = localFinderLikeDrawer.getLoadingLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "loadingLayout");
        ((a)localObject1).sar = ((FrameLayout)localObject3);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131496190, (ViewGroup)localObject3, true);
        localObject3 = ((View)localObject2).findViewById(2131307495);
        k.g(localObject3, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
        ((a)localObject1).gDe = ((View)localObject3);
        localObject3 = ((View)localObject2).findViewById(2131307885);
        k.g(localObject3, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
        ((a)localObject1).sas = ((View)localObject3);
        localObject2 = ((View)localObject2).findViewById(2131307942);
        k.g(localObject2, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
        ((a)localObject1).sat = ((View)localObject2);
        localObject2 = ((a)localObject1).gDe;
        if (localObject2 == null) {
          k.aVY("loadingView");
        }
        ((View)localObject2).setVisibility(0);
        localObject2 = ((a)localObject1).sas;
        if (localObject2 == null) {
          k.aVY("nothingView");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((a)localObject1).sat;
        if (localObject1 == null) {
          k.aVY("retryView");
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(204177);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */