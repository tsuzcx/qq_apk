package com.tencent.mm.plugin.finder.nearby.live.play.selector;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.live.play.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/NearbyLiveAutoPlaySelectorHorizontal;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/ILiveAutoPlaySelector;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFeedList", "()Ljava/util/ArrayList;", "findAutoPlayItem", "", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "findAutoPlayItemInternal", "findAutoStopItem", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "curLivePreviewDataSet", "getFeedByPos", "pos", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public static final a ELt;
  private final ArrayList<cc> feedList;
  
  static
  {
    AppMethodBeat.i(341116);
    ELt = new a((byte)0);
    AppMethodBeat.o(341116);
  }
  
  public c(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(341093);
    this.feedList = paramArrayList;
    AppMethodBeat.o(341093);
  }
  
  private final cc QF(int paramInt)
  {
    AppMethodBeat.i(341105);
    if (this.feedList == null)
    {
      Log.w("NearbyLiveAutoPlaySelectorHorizontal", s.X("getFeedByPos return for feedList:", this.feedList));
      AppMethodBeat.o(341105);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("NearbyLiveAutoPlaySelectorHorizontal", s.X("getFeedByPos return for invalid pos:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(341105);
      return null;
    }
    cc localcc = (cc)this.feedList.get(paramInt);
    AppMethodBeat.o(341105);
    return localcc;
  }
  
  public final HashSet<e.b> a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, HashSet<e.b> paramHashSet)
  {
    AppMethodBeat.i(341131);
    s.u(paramStaggeredGridLayoutManager, "layoutManager");
    s.u(paramHashSet, "curLivePreviewDataSet");
    HashSet localHashSet = new HashSet();
    Object localObject1 = new int[2];
    Object localObject2 = new int[2];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int i = localObject1[0];
    int k = localObject2[0];
    if (i <= k) {}
    for (;;)
    {
      localObject1 = QF(i);
      if (!(localObject1 instanceof x)) {
        Log.w("NearbyLiveAutoPlaySelectorHorizontal", "findAutoPlayItem invalid feed:" + localObject1 + " index:" + i);
      }
      while (i == k)
      {
        AppMethodBeat.o(341131);
        return localHashSet;
        localObject1 = paramStaggeredGridLayoutManager.findViewByPosition(i);
        if (localObject1 != null)
        {
          ((View)localObject1).getGlobalVisibleRect(new Rect());
          localObject2 = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
          if (com.tencent.mm.plugin.finder.nearby.live.base.a.l(0, (View)localObject1))
          {
            localObject2 = ((Iterable)paramHashSet).iterator();
            label177:
            int j;
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (i == ((e.b)localObject1).pos)
              {
                j = 1;
                label211:
                if (j == 0) {
                  break label281;
                }
              }
            }
            for (;;)
            {
              localObject1 = (e.b)localObject1;
              if (localObject1 == null) {
                break;
              }
              localHashSet.add(localObject1);
              Log.w("NearbyLiveAutoPlaySelectorHorizontal", "findAutoStopItem hit view index:" + ((e.b)localObject1).pos + " size:" + localHashSet.size());
              break;
              j = 0;
              break label211;
              label281:
              break label177;
              localObject1 = null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final int[] a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(341140);
    s.u(paramStaggeredGridLayoutManager, "layoutManager");
    s.u(paramArrayOfInt1, "firstVisibleItemPos");
    s.u(paramArrayOfInt2, "lastVisibleItemPos");
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfInt1[0];
    int j = paramArrayOfInt2[0];
    if (i <= j) {}
    for (;;)
    {
      paramArrayOfInt1 = QF(i);
      if (!(paramArrayOfInt1 instanceof x)) {
        Log.w("NearbyLiveAutoPlaySelectorHorizontal", "findAutoPlayItem invalid feed:" + paramArrayOfInt1 + " index:" + i);
      }
      while (i == j)
      {
        paramStaggeredGridLayoutManager = p.I((Collection)localArrayList);
        AppMethodBeat.o(341140);
        return paramStaggeredGridLayoutManager;
        paramArrayOfInt1 = paramStaggeredGridLayoutManager.findViewByPosition(i);
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1.getGlobalVisibleRect(new Rect());
          paramArrayOfInt2 = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
          if (com.tencent.mm.plugin.finder.nearby.live.base.a.gx(paramArrayOfInt1))
          {
            localArrayList.add(Integer.valueOf(i));
            Log.w("NearbyLiveAutoPlaySelectorHorizontal", "findAutoPlayItem hit view index:" + i + ' ' + localArrayList);
          }
        }
        else
        {
          Log.w("NearbyLiveAutoPlaySelectorHorizontal", s.X("findAutoPlayItem invalid view index:", Integer.valueOf(i)));
        }
      }
      i += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/NearbyLiveAutoPlaySelectorHorizontal$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.selector.c
 * JD-Core Version:    0.7.0.1
 */