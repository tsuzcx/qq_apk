package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Paint;
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
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.bc;
import com.tencent.mm.plugin.finder.feed.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.plugin.finder.view.builder.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"})
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  public static final a AYs;
  private static final int xcS = 1;
  private static final int xcT = 2;
  private a AYr;
  private b likeBuffer;
  private int scene;
  private FinderItem xwF;
  
  static
  {
    AppMethodBeat.i(271187);
    AYs = new a((byte)0);
    xcS = 1;
    xcT = 2;
    AppMethodBeat.o(271187);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(271184);
    AppMethodBeat.o(271184);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(271185);
    AppMethodBeat.o(271185);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(271186);
    AppMethodBeat.o(271186);
  }
  
  public final void a(FinderItem paramFinderItem, b paramb)
  {
    AppMethodBeat.i(271181);
    p.k(paramFinderItem, "feedObj");
    if (!eis())
    {
      this.xwF = paramFinderItem;
      this.likeBuffer = paramb;
      super.bs(true, true);
    }
    AppMethodBeat.o(271181);
  }
  
  public final void eir()
  {
    AppMethodBeat.i(271183);
    if (eis()) {
      super.Ig(true);
    }
    AppMethodBeat.o(271183);
  }
  
  public final a getBuilder()
  {
    return this.AYr;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.xwF;
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
    this.AYr = parama;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.xwF = paramFinderItem;
  }
  
  public final void setLikeBuffer(b paramb)
  {
    this.likeBuffer = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"})
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, final Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(223232);
      p.k(paramContext, "context");
      p.k(paramWindow, "window");
      Log.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      final FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      final aa.f localf = new aa.f();
      localf.aaBC = null;
      if (paramInt == FinderLikeDrawer.eiO()) {
        localf.aaBC = new a((bc)new com.tencent.mm.plugin.finder.feed.t(paramContext));
      }
      for (;;)
      {
        ((a)localf.aaBC).a((RecyclerViewDrawer)localFinderLikeDrawer);
        localFinderLikeDrawer.setBuilder((a)localf.aaBC);
        paramWindow.getDecorView().post((Runnable)new a(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, localf));
        if ((paramContext instanceof MMFragmentActivity)) {
          ((MMFragmentActivity)paramContext).getLifecycle().a((k)new FinderLikeDrawer.Companion.createDrawerToAttachWindow.2(localFinderLikeDrawer, paramContext));
        }
        AppMethodBeat.o(223232);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.eiP()) {
          localf.aaBC = new a((bc)new x());
        } else {
          localf.aaBC = new a((bc)new x());
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, aa.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(290731);
        int i = ax.az(this.$context);
        localLayoutParams.bottomMargin = i;
        Log.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject1 = paramWindow.getDecorView();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(290731);
          throw ((Throwable)localObject1);
        }
        ((FrameLayout)localObject1).addView((View)localFinderLikeDrawer, (ViewGroup.LayoutParams)localLayoutParams);
        localObject1 = (a)localf.aaBC;
        Object localObject2 = this.$context;
        Object localObject3 = localFinderLikeDrawer.getHeaderLayout();
        p.k(localObject2, "context");
        p.k(localObject3, "headerLayout");
        ((a)localObject1).Beh = ((FrameLayout)localObject3);
        Object localObject4 = ad.kS((Context)localObject2);
        i = b.g.like_drawer_header;
        Object localObject5 = ((a)localObject1).xvL;
        if (localObject5 == null) {
          p.bGy("likeDrawer");
        }
        localObject4 = ((LayoutInflater)localObject4).inflate(i, (ViewGroup)((FinderLikeDrawer)localObject5).getHeaderLayout());
        localObject5 = ((View)localObject4).findViewById(b.f.drawer_header_tv);
        p.j(localObject5, "header.findViewById(R.id.drawer_header_tv)");
        ((a)localObject1).Beg = ((TextView)localObject5);
        localObject5 = ((a)localObject1).Beg;
        if (localObject5 == null) {
          p.bGy("headerTitleTv");
        }
        ar.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
        localObject5 = ((View)localObject4).findViewById(b.f.close_drawer_layout);
        localObject4 = ((View)localObject4).findViewById(b.f.drawer_more_op);
        ((View)localObject5).setOnClickListener((View.OnClickListener)new a.b((a)localObject1));
        ((a)localObject1).Bel.a((Context)localObject2, (FrameLayout)localObject3);
        localObject2 = ((a)localObject1).xvL;
        if (localObject2 == null) {
          p.bGy("likeDrawer");
        }
        p.j(localObject5, "closeBtn");
        ((FinderLikeDrawer)localObject2).jc((View)localObject5);
        localObject1 = ((a)localObject1).xvL;
        if (localObject1 == null) {
          p.bGy("likeDrawer");
        }
        p.j(localObject4, "moreBtn");
        ((FinderLikeDrawer)localObject1).jc((View)localObject4);
        localObject1 = (a)localf.aaBC;
        localObject2 = this.$context;
        localObject3 = localFinderLikeDrawer.getCenterLayout();
        p.k(localObject2, "context");
        p.k(localObject3, "rlLayout");
        ((a)localObject1).xvJ = ((RefreshLoadMoreLayout)localObject3);
        ((a)localObject1).Bel.ev((View)localObject3);
        localObject4 = ad.kS((Context)localObject2).inflate(b.g.load_more_footer, null);
        p.j(localObject4, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        ((RefreshLoadMoreLayout)localObject3).setLoadMoreFooter((View)localObject4);
        localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
        ((RecyclerView)localObject3).setHasFixedSize(true);
        localObject4 = ((RecyclerView)localObject3).getItemAnimator();
        if (localObject4 != null) {
          ((RecyclerView.f)localObject4).n(0L);
        }
        ((RecyclerView)localObject3).setLayoutManager(((a)localObject1).Bel.eW((Context)localObject2));
        ((RecyclerView)localObject3).b(((a)localObject1).Bel.fn((Context)localObject2));
        ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((a)localObject1).Bel.fs((Context)localObject2));
        localObject1 = (a)localf.aaBC;
        localObject2 = this.$context;
        localObject3 = localFinderLikeDrawer.getLoadingLayout();
        p.k(localObject2, "context");
        p.k(localObject3, "loadingLayout");
        ((a)localObject1).Bei = ((FrameLayout)localObject3);
        localObject2 = LayoutInflater.from((Context)localObject2).inflate(b.g.finder_feed_like_loading_tips_layout, (ViewGroup)localObject3, true);
        localObject3 = ((View)localObject2).findViewById(b.f.like_loading_bar);
        p.j(localObject3, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
        ((a)localObject1).kGT = ((View)localObject3);
        localObject3 = ((View)localObject2).findViewById(b.f.no_like_hint);
        p.j(localObject3, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
        ((a)localObject1).Bej = ((View)localObject3);
        localObject2 = ((View)localObject2).findViewById(b.f.retry_like_layout);
        p.j(localObject2, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
        ((a)localObject1).Aol = ((View)localObject2);
        localObject2 = ((a)localObject1).kGT;
        if (localObject2 == null) {
          p.bGy("loadingView");
        }
        ((View)localObject2).setVisibility(0);
        localObject2 = ((a)localObject1).Bej;
        if (localObject2 == null) {
          p.bGy("nothingView");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((a)localObject1).Aol;
        if (localObject1 == null) {
          p.bGy("retryView");
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(290731);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */