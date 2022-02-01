package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.live.play.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "feedDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "autoPlayManager", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "caller", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "loadMoreCall", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;Lkotlin/jvm/functions/Function0;)V", "getAutoPlayManager", "()Lkotlin/jvm/functions/Function0;", "getCaller", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "getFeedDataList", "()Ljava/util/ArrayList;", "heightPixels", "", "getLoadMoreCall", "checkAutoPlay", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "checkLoadMore", "findMiddleElement", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "onScrollStateChanged", "newState", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.l
{
  public static final j.a ENo;
  private final int ANY;
  private final ArrayList<cc> EML;
  private final h EMO;
  private final kotlin.g.a.a<e> ENp;
  private final kotlin.g.a.a<ah> akhM;
  
  static
  {
    AppMethodBeat.i(340608);
    ENo = new j.a((byte)0);
    AppMethodBeat.o(340608);
  }
  
  public j(ArrayList<cc> paramArrayList, kotlin.g.a.a<e> parama, h paramh, kotlin.g.a.a<ah> parama1)
  {
    AppMethodBeat.i(370490);
    this.EML = paramArrayList;
    this.ENp = parama;
    this.EMO = paramh;
    this.akhM = parama1;
    this.ANY = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(370490);
  }
  
  private final cc a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(340601);
    int i = this.ANY / 2;
    if (paramInt1 <= paramInt2) {}
    for (;;)
    {
      View localView = paramStaggeredGridLayoutManager.findViewByPosition(paramInt1);
      if (localView != null)
      {
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        if (localRect.contains(localRect.left, i))
        {
          Log.i("Finder.NewEntranceRVScrollAutoPlayChecker", s.X("#findMiddleElement find it. index=", Integer.valueOf(paramInt1)));
          paramStaggeredGridLayoutManager = (cc)p.ae((List)this.EML, paramInt1);
          AppMethodBeat.o(340601);
          return paramStaggeredGridLayoutManager;
        }
      }
      if (paramInt1 == paramInt2)
      {
        AppMethodBeat.o(340601);
        return null;
      }
      paramInt1 += 1;
    }
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(340614);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    s.u(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      y(paramRecyclerView);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
        AppMethodBeat.o(340614);
        throw paramRecyclerView;
      }
      paramRecyclerView = (FinderStaggeredGridLayoutManager)paramRecyclerView;
      localObject = new int[2];
      paramRecyclerView.o((int[])localObject);
      paramInt = k.ac((int[])localObject);
      if ((this.EML.size() > 4) && (paramInt > this.EML.size() - 4)) {
        this.akhM.invoke();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(340614);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(340628);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(340628);
  }
  
  public final void y(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(370494);
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
        AppMethodBeat.o(370494);
        throw paramRecyclerView;
      }
      paramRecyclerView = (FinderStaggeredGridLayoutManager)paramRecyclerView;
      Object localObject = new int[2];
      int[] arrayOfInt = new int[2];
      paramRecyclerView.n((int[])localObject);
      paramRecyclerView.o(arrayOfInt);
      paramRecyclerView = a((StaggeredGridLayoutManager)paramRecyclerView, k.aa((int[])localObject), k.ac(arrayOfInt));
      if (paramRecyclerView == null)
      {
        Log.i("Finder.NewEntranceRVScrollAutoPlayChecker", "#checkAutoPlay ops! you are git the margin");
        AppMethodBeat.o(370494);
        return;
      }
      this.EMO.e(paramRecyclerView);
      localObject = (e)this.ENp.invoke();
      if (localObject != null) {
        ((e)localObject).sP(paramRecyclerView instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b);
      }
      paramRecyclerView = (e)this.ENp.invoke();
      if (paramRecyclerView != null) {
        break label169;
      }
    }
    label169:
    for (paramRecyclerView = null;; paramRecyclerView = Boolean.valueOf(paramRecyclerView.EKJ))
    {
      Log.i("Finder.NewEntranceRVScrollAutoPlayChecker", s.X("#checkAutoPlay find it. is my self play? ", paramRecyclerView));
      AppMethodBeat.o(370494);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.j
 * JD-Core Version:    0.7.0.1
 */