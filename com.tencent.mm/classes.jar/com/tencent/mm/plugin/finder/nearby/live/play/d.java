package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.k.c;
import kotlin.k.e;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlaySelector;", "", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFeedList", "()Ljava/util/ArrayList;", "heightPixels", "", "findAutoPlayItem", "", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "findAutoPlayItemInternal", "findAutoPlayItemTest1", "findAutoPlayItemTest2", "findAutoPlayItemTest3", "findItemByPriority", "autoPlayPos", "getFeedByPos", "pos", "getMaxSelectedItemCount", "Companion", "plugin-finder-nearby_release"})
public final class d
{
  private static int zFy;
  public static final a zFz;
  private final ArrayList<bu> feedList;
  private final int zFx;
  
  static
  {
    AppMethodBeat.i(199653);
    zFz = new a((byte)0);
    zFy = 2;
    AppMethodBeat.o(199653);
  }
  
  public d(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(199652);
    this.feedList = paramArrayList;
    paramArrayList = MMApplicationContext.getContext();
    p.j(paramArrayList, "MMApplicationContext.getContext()");
    paramArrayList = paramArrayList.getResources();
    p.j(paramArrayList, "MMApplicationContext.getContext().resources");
    this.zFx = paramArrayList.getDisplayMetrics().heightPixels;
    AppMethodBeat.o(199652);
  }
  
  private final bu Or(int paramInt)
  {
    AppMethodBeat.i(199651);
    if (this.feedList == null)
    {
      Log.w("NearbyLiveAutoPlaySelector", "getFeedByPos return for feedList:" + this.feedList);
      AppMethodBeat.o(199651);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("NearbyLiveAutoPlaySelector", "getFeedByPos return for invalid pos:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(199651);
      return null;
    }
    bu localbu = (bu)this.feedList.get(paramInt);
    AppMethodBeat.o(199651);
    return localbu;
  }
  
  private final int[] b(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(199647);
    int m = this.zFx / 2;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramArrayOfInt1[0];
    arrayOfInt[1] = paramArrayOfInt1[1];
    paramArrayOfInt1 = i.a((c)new e(paramArrayOfInt1[0], paramArrayOfInt2[(paramArrayOfInt2.length - 1)]), 1);
    int j = paramArrayOfInt1.dHa;
    int n = paramArrayOfInt1.aaBQ;
    int i1 = paramArrayOfInt1.oxQ;
    int i;
    if (i1 >= 0)
    {
      if (j > n) {
        break label290;
      }
      i = 0;
      paramArrayOfInt1 = Or(j);
      if ((paramArrayOfInt1 instanceof w)) {
        break label164;
      }
      Log.w("NearbyLiveAutoPlaySelector", "findAutoPlayItem invalid feed:" + paramArrayOfInt1 + " index:" + j);
    }
    label164:
    label298:
    label469:
    label487:
    for (;;)
    {
      if (j != n)
      {
        j += i1;
        break;
        if (j >= n)
        {
          i = 0;
          break;
          paramArrayOfInt1 = paramStaggeredGridLayoutManager.findViewByPosition(j);
          if (paramArrayOfInt1 == null) {
            break label469;
          }
          paramArrayOfInt2 = new Rect();
          paramArrayOfInt1.getGlobalVisibleRect(paramArrayOfInt2);
          if (!paramArrayOfInt2.contains(paramArrayOfInt2.left, m)) {
            break label298;
          }
          k = i + 1;
          arrayOfInt[i] = j;
          Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit baseline, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + k + " rect:" + paramArrayOfInt2 + " baseline:" + m);
          i = k;
          if (k < 2) {
            break label487;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199647);
        return arrayOfInt;
        if (paramArrayOfInt2.top <= m) {
          break;
        }
        Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit divider, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + i + " rect:" + paramArrayOfInt2 + " baseline:" + m);
      }
      Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit cache, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + i + " rect:" + paramArrayOfInt2 + " baseline:" + m);
      int k = i + 1;
      arrayOfInt[i] = j;
      i = k;
      if (k >= 2)
      {
        i = 0;
        continue;
        Log.w("NearbyLiveAutoPlaySelector", "findAutoPlayItem invalid view index:".concat(String.valueOf(j)));
      }
    }
  }
  
  public static int dLR()
  {
    return zFy;
  }
  
  final int[] a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(199640);
    zFy = 2;
    paramStaggeredGridLayoutManager = b(paramStaggeredGridLayoutManager, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(199640);
    return paramStaggeredGridLayoutManager;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlaySelector$Companion;", "", "()V", "MAX_FOCUS_ITEMS", "", "MAX_SELECTED_ITEMS", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.d
 * JD-Core Version:    0.7.0.1
 */