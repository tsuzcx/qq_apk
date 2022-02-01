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
import com.tencent.mm.plugin.finder.feed.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.finder.view.builder.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"})
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  private static final int KJE = 1;
  private static final int KJF = 2;
  public static final a Lfb;
  private FinderItem quu;
  private int scene;
  
  static
  {
    AppMethodBeat.i(200114);
    Lfb = new a((byte)0);
    KJE = 1;
    KJF = 2;
    AppMethodBeat.o(200114);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200111);
    AppMethodBeat.o(200111);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200112);
    AppMethodBeat.o(200112);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200113);
    AppMethodBeat.o(200113);
  }
  
  public final void csJ()
  {
    AppMethodBeat.i(200110);
    if (fiQ()) {
      super.xl(true);
    }
    AppMethodBeat.o(200110);
  }
  
  public final FinderItem getFeedObj()
  {
    return this.quu;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final void p(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(200109);
    k.h(paramFinderItem, "feedObj");
    if (!fiQ())
    {
      this.quu = paramFinderItem;
      super.aX(true, true);
    }
    AppMethodBeat.o(200109);
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.quu = paramFinderItem;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"})
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, final Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(200108);
      k.h(paramContext, "context");
      k.h(paramWindow, "window");
      ad.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      final FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      final v.e locale = new v.e();
      locale.Jhw = null;
      if (paramInt == FinderLikeDrawer.fWQ()) {
        locale.Jhw = new b((ak)new u(paramContext));
      }
      for (;;)
      {
        ((b)locale.Jhw).a((RecyclerViewDrawer)localFinderLikeDrawer);
        paramWindow.getDecorView().post((Runnable)new a(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, locale));
        AppMethodBeat.o(200108);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.fWR()) {
          locale.Jhw = new b((ak)new com.tencent.mm.plugin.finder.feed.y());
        } else {
          locale.Jhw = new b((ak)new com.tencent.mm.plugin.finder.feed.y());
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, v.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(200107);
        int i = ap.jv(this.cjo);
        localLayoutParams.bottomMargin = i;
        ad.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject1 = paramWindow.getDecorView();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(200107);
          throw ((Throwable)localObject1);
        }
        ((FrameLayout)localObject1).addView((View)localFinderLikeDrawer, (ViewGroup.LayoutParams)localLayoutParams);
        localObject1 = (b)locale.Jhw;
        Object localObject2 = this.cjo;
        Object localObject3 = localFinderLikeDrawer.getHeaderLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "headerLayout");
        ((b)localObject1).qYD = ((FrameLayout)localObject3);
        Object localObject4 = com.tencent.mm.ui.y.js((Context)localObject2);
        Object localObject5 = ((b)localObject1).KMO;
        if (localObject5 == null) {
          k.aPZ("likeDrawer");
        }
        localObject4 = ((LayoutInflater)localObject4).inflate(2131496273, (ViewGroup)((FinderLikeDrawer)localObject5).getHeaderLayout());
        localObject5 = ((View)localObject4).findViewById(2131299237);
        k.g(localObject5, "header.findViewById(R.id.drawer_header_tv)");
        ((b)localObject1).qYA = ((TextView)localObject5);
        localObject5 = ((b)localObject1).qYA;
        if (localObject5 == null) {
          k.aPZ("headerTitleTv");
        }
        ai.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
        localObject5 = ((View)localObject4).findViewById(2131298369);
        localObject4 = ((View)localObject4).findViewById(2131307288);
        ((View)localObject5).setOnClickListener((View.OnClickListener)new b.b((b)localObject1));
        ((b)localObject1).LgC.a((Context)localObject2, (FrameLayout)localObject3);
        localObject2 = ((b)localObject1).KMO;
        if (localObject2 == null) {
          k.aPZ("likeDrawer");
        }
        k.g(localObject5, "closeBtn");
        ((FinderLikeDrawer)localObject2).gV((View)localObject5);
        localObject1 = ((b)localObject1).KMO;
        if (localObject1 == null) {
          k.aPZ("likeDrawer");
        }
        k.g(localObject4, "moreBtn");
        ((FinderLikeDrawer)localObject1).gV((View)localObject4);
        localObject1 = (b)locale.Jhw;
        localObject2 = this.cjo;
        localObject3 = localFinderLikeDrawer.getCenterLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "rlLayout");
        ((b)localObject1).quj = ((RefreshLoadMoreLayout)localObject3);
        ((b)localObject1).LgC.gO((View)localObject3);
        localObject4 = com.tencent.mm.ui.y.js((Context)localObject2).inflate(2131494590, null);
        k.g(localObject4, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        ((RefreshLoadMoreLayout)localObject3).setLoadMoreFooter((View)localObject4);
        localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
        ((RecyclerView)localObject3).setHasFixedSize(true);
        localObject4 = ((RecyclerView)localObject3).getItemAnimator();
        if (localObject4 != null) {
          ((RecyclerView.f)localObject4).kT();
        }
        ((RecyclerView)localObject3).setLayoutManager(((b)localObject1).LgC.lw((Context)localObject2));
        ((RecyclerView)localObject3).b(((b)localObject1).LgC.eC((Context)localObject2));
        ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((b)localObject1).LgC.eD((Context)localObject2));
        localObject1 = (b)locale.Jhw;
        localObject2 = this.cjo;
        localObject3 = localFinderLikeDrawer.getLoadingLayout();
        k.h(localObject2, "context");
        k.h(localObject3, "loadingLayout");
        ((b)localObject1).qYE = ((FrameLayout)localObject3);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131496189, (ViewGroup)localObject3, true);
        localObject3 = ((View)localObject2).findViewById(2131307419);
        k.g(localObject3, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
        ((b)localObject1).lZo = ((View)localObject3);
        localObject3 = ((View)localObject2).findViewById(2131307793);
        k.g(localObject3, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
        ((b)localObject1).qYF = ((View)localObject3);
        localObject2 = ((View)localObject2).findViewById(2131307835);
        k.g(localObject2, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
        ((b)localObject1).qYG = ((View)localObject2);
        localObject2 = ((b)localObject1).lZo;
        if (localObject2 == null) {
          k.aPZ("loadingView");
        }
        ((View)localObject2).setVisibility(0);
        localObject2 = ((b)localObject1).qYF;
        if (localObject2 == null) {
          k.aPZ("nothingView");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((b)localObject1).qYG;
        if (localObject1 == null) {
          k.aPZ("retryView");
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(200107);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */