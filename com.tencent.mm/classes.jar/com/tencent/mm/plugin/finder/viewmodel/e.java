package com.tencent.mm.plugin.finder.viewmodel;

import androidx.lifecycle.af;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.t;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroidx/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerDarkViewPool", "getCommentDrawerDarkViewPool", "setCommentDrawerDarkViewPool", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "fullFoldedLayoutViewPool", "getFullFoldedLayoutViewPool", "setFullFoldedLayoutViewPool", "fullTimeLinePool", "getFullTimeLinePool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends af
{
  public static final a GKS;
  public RecyclerView.m ATp;
  private final RecyclerView.m GKT;
  public final RecyclerView.m GKU;
  public RecyclerView.m GKV;
  public RecyclerView.m GKW;
  public RecyclerView.m GKX;
  public RecyclerView.m GKY;
  public RecyclerView.m GKZ;
  private RecyclerView.m GLa;
  private RecyclerView.m GLb;
  
  static
  {
    AppMethodBeat.i(337188);
    GKS = new a((byte)0);
    AppMethodBeat.o(337188);
  }
  
  public e()
  {
    AppMethodBeat.i(337179);
    Object localObject1 = new c();
    ((c)localObject1).bD(4, 18);
    ((c)localObject1).bD(2, 6);
    ((c)localObject1).bD(2003, 0);
    Object localObject2 = ah.aiuX;
    this.GKT = ((RecyclerView.m)localObject1);
    localObject1 = new b();
    ((b)localObject1).bD(4, 18);
    ((b)localObject1).bD(2, 6);
    localObject2 = ah.aiuX;
    this.GKU = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    ((RecyclerView.m)localObject1).bD(2, 16);
    ((RecyclerView.m)localObject1).bD(4, 12);
    localObject2 = ah.aiuX;
    this.ATp = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    ((RecyclerView.m)localObject1).bD(4, 20);
    ((RecyclerView.m)localObject1).bD(2, 20);
    ((RecyclerView.m)localObject1).bD(-3, 2);
    ((RecyclerView.m)localObject1).bD(2003, 0);
    localObject2 = ah.aiuX;
    this.GKV = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    ((RecyclerView.m)localObject1).bD(4, 20);
    ((RecyclerView.m)localObject1).bD(2, 20);
    ((RecyclerView.m)localObject1).bD(-3, 2);
    localObject2 = ah.aiuX;
    this.GKW = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDj(), 10);
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDk(), 10);
    localObject2 = ah.aiuX;
    this.GKX = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDj(), 10);
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDk(), 10);
    localObject2 = ah.aiuX;
    this.GKY = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDj(), 10);
    localObject2 = t.ECt;
    ((RecyclerView.m)localObject1).bD(t.eDk(), 5);
    localObject2 = ah.aiuX;
    this.GKZ = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    ((RecyclerView.m)localObject1).bD(4, 10);
    ((RecyclerView.m)localObject1).bD(2, 10);
    localObject2 = ah.aiuX;
    this.GLa = ((RecyclerView.m)localObject1);
    localObject1 = new RecyclerView.m();
    ((RecyclerView.m)localObject1).bD(4, 10);
    localObject2 = ah.aiuX;
    this.GLb = ((RecyclerView.m)localObject1);
    AppMethodBeat.o(337179);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$fullTimeLinePool$1", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.m
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.m
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.e
 * JD-Core Version:    0.7.0.1
 */