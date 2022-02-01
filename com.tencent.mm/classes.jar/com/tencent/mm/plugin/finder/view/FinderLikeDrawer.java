package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.bj;
import com.tencent.mm.plugin.finder.feed.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.Metadata;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "scene", "getScene", "()I", "setScene", "(I)V", "closeDrawer", "", "openDrawer", "Builder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikeDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  private static final int ACj;
  private static final int ACk;
  public static final a GAf;
  private FinderItem AUj;
  private a GAg;
  private b likeBuffer;
  private int scene;
  
  static
  {
    AppMethodBeat.i(344954);
    GAf = new a((byte)0);
    ACj = 1;
    ACk = 2;
    AppMethodBeat.o(344954);
  }
  
  public FinderLikeDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344927);
    AppMethodBeat.o(344927);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344930);
    AppMethodBeat.o(344930);
  }
  
  public FinderLikeDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344937);
    AppMethodBeat.o(344937);
  }
  
  public final void a(FinderItem paramFinderItem, b paramb)
  {
    AppMethodBeat.i(344996);
    kotlin.g.b.s.u(paramFinderItem, "feedObj");
    if (!fkp())
    {
      this.AUj = paramFinderItem;
      this.likeBuffer = paramb;
      super.bS(true, true);
    }
    AppMethodBeat.o(344996);
  }
  
  public final void fdh()
  {
    AppMethodBeat.i(345000);
    if (fkp()) {
      super.Ob(true);
    }
    AppMethodBeat.o(345000);
  }
  
  public final a getBuilder()
  {
    return this.GAg;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.AUj;
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
    this.GAg = parama;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.AUj = paramFinderItem;
  }
  
  public final void setLikeBuffer(b paramb)
  {
    this.likeBuffer = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "MMFinder_FeedLikedListAll", "getMMFinder_FeedLikedListAll", "()I", "MMFinder_FeedLikedListFriend", "getMMFinder_FeedLikedListFriend", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "scene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static FinderLikeDrawer a(Context paramContext, Window paramWindow, int paramInt)
    {
      AppMethodBeat.i(344842);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramWindow, "window");
      Log.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
      FinderLikeDrawer localFinderLikeDrawer = new FinderLikeDrawer(paramContext);
      localFinderLikeDrawer.setScene(paramInt);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ah.f localf = new ah.f();
      a locala;
      RecyclerViewDrawer localRecyclerViewDrawer;
      Object localObject;
      if (paramInt == FinderLikeDrawer.fkM())
      {
        localf.aqH = new a((bj)new com.tencent.mm.plugin.finder.feed.s(paramContext));
        locala = (a)localf.aqH;
        localRecyclerViewDrawer = (RecyclerViewDrawer)localFinderLikeDrawer;
        kotlin.g.b.s.u(localRecyclerViewDrawer, "drawer");
        localObject = localRecyclerViewDrawer.getContext();
        kotlin.g.b.s.s(localObject, "drawer.context");
        kotlin.g.b.s.u(localObject, "<set-?>");
        locala.context = ((Context)localObject);
        paramInt = locala.GGG.getScene();
        localObject = FinderLikeDrawer.GAf;
        if (paramInt != FinderLikeDrawer.fkM()) {
          break label342;
        }
        localRecyclerViewDrawer.setId(e.e.finder_feed_friend_like_drawer);
      }
      for (;;)
      {
        localObject = (FinderLikeDrawer)localRecyclerViewDrawer;
        kotlin.g.b.s.u(localObject, "<set-?>");
        locala.ATz = ((FinderLikeDrawer)localObject);
        localRecyclerViewDrawer.setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
        localRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
        localRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)locala);
        localFinderLikeDrawer.setBuilder((a)localf.aqH);
        paramWindow.getDecorView().post(new FinderLikeDrawer.a..ExternalSyntheticLambda0(paramContext, localLayoutParams, paramWindow, localFinderLikeDrawer, localf));
        if ((paramContext instanceof MMFragmentActivity)) {
          ((MMFragmentActivity)paramContext).getLifecycle().addObserver((p)new FinderLikeDrawer.Companion.createDrawerToAttachWindow.2(localFinderLikeDrawer, paramContext));
        }
        AppMethodBeat.o(344842);
        return localFinderLikeDrawer;
        if (paramInt == FinderLikeDrawer.fkN())
        {
          localf.aqH = new a((bj)new y());
          break;
        }
        localf.aqH = new a((bj)new y());
        break;
        label342:
        localObject = FinderLikeDrawer.GAf;
        if (paramInt == FinderLikeDrawer.fkN()) {
          localRecyclerViewDrawer.setId(e.e.finder_feed_all_like_drawer);
        }
      }
    }
    
    private static final void a(Context paramContext, FrameLayout.LayoutParams paramLayoutParams, Window paramWindow, FinderLikeDrawer paramFinderLikeDrawer, ah.f paramf)
    {
      AppMethodBeat.i(344857);
      kotlin.g.b.s.u(paramContext, "$context");
      kotlin.g.b.s.u(paramLayoutParams, "$params");
      kotlin.g.b.s.u(paramWindow, "$window");
      kotlin.g.b.s.u(paramFinderLikeDrawer, "$drawer");
      kotlin.g.b.s.u(paramf, "$builder");
      int i = bf.bi(paramContext);
      paramLayoutParams.bottomMargin = i;
      Log.i("Finder.FinderLikeDrawer", kotlin.g.b.s.X("[initView] bottomMargin= ", Integer.valueOf(i)));
      ((FrameLayout)paramWindow.getDecorView()).addView((View)paramFinderLikeDrawer, (ViewGroup.LayoutParams)paramLayoutParams);
      ((a)paramf.aqH).b(paramContext, paramFinderLikeDrawer.getHeaderLayout());
      paramLayoutParams = (a)paramf.aqH;
      paramWindow = paramFinderLikeDrawer.getCenterLayout();
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramWindow, "rlLayout");
      kotlin.g.b.s.u(paramWindow, "<set-?>");
      paramLayoutParams.ATx = paramWindow;
      paramLayoutParams.GGG.fx((View)paramWindow);
      Object localObject = af.mU(paramContext).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject, "getInflater(context).inf…t.load_more_footer, null)");
      paramWindow.setLoadMoreFooter((View)localObject);
      paramWindow = paramWindow.getRecyclerView();
      paramWindow.setHasFixedSize(true);
      localObject = paramWindow.getItemAnimator();
      if (localObject != null) {
        ((RecyclerView.f)localObject).bZL = 0L;
      }
      paramWindow.setLayoutManager(paramLayoutParams.GGG.fT(paramContext));
      paramWindow.a(paramLayoutParams.GGG.gl(paramContext));
      paramWindow.setAdapter((RecyclerView.a)paramLayoutParams.GGG.gr(paramContext));
      paramLayoutParams = (a)paramf.aqH;
      paramWindow = paramFinderLikeDrawer.getLoadingLayout();
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramWindow, "loadingLayout");
      kotlin.g.b.s.u(paramWindow, "<set-?>");
      paramLayoutParams.FZT = paramWindow;
      paramContext = LayoutInflater.from(paramContext).inflate(e.f.finder_feed_like_loading_tips_layout, (ViewGroup)paramWindow, true);
      paramWindow = paramContext.findViewById(e.e.like_loading_bar);
      kotlin.g.b.s.s(paramWindow, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
      kotlin.g.b.s.u(paramWindow, "<set-?>");
      paramLayoutParams.njN = paramWindow;
      paramWindow = paramContext.findViewById(e.e.no_like_hint);
      kotlin.g.b.s.s(paramWindow, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
      kotlin.g.b.s.u(paramWindow, "<set-?>");
      paramLayoutParams.FZU = paramWindow;
      paramContext = paramContext.findViewById(e.e.retry_like_layout);
      kotlin.g.b.s.s(paramContext, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
      kotlin.g.b.s.u(paramContext, "<set-?>");
      paramLayoutParams.BsS = paramContext;
      paramLayoutParams.getLoadingView().setVisibility(0);
      paramLayoutParams.fdw().setVisibility(8);
      paramLayoutParams.fdx().setVisibility(8);
      AppMethodBeat.o(344857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer
 * JD-Core Version:    0.7.0.1
 */