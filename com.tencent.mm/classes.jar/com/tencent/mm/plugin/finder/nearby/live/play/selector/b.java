package com.tencent.mm.plugin.finder.nearby.live.play.selector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.live.play.e.b;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/NearbyLiveAutoPlaySelector;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/ILiveAutoPlaySelector;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFeedList", "()Ljava/util/ArrayList;", "heightPixels", "", "weightPixels", "findAutoPlayItem", "", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "findAutoPlayItemInternal", "findAutoPlayItemTest1", "findAutoPlayItemTest2", "findAutoPlayItemTest3", "findAutoStopItem", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "curLivePreviewDataSet", "findItemByPriority", "autoPlayPos", "getFeedByPos", "pos", "isLeftPos", "", "isSingleOneLine", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private static int EJU;
  public static final a ELs;
  private final int ANY;
  private final int akhx;
  private final ArrayList<cc> feedList;
  
  static
  {
    AppMethodBeat.i(341132);
    ELs = new a((byte)0);
    EJU = 2;
    AppMethodBeat.o(341132);
  }
  
  public b(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(341091);
    this.feedList = paramArrayList;
    this.ANY = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    this.akhx = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(341091);
  }
  
  private final int[] E(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341120);
    if (paramArrayOfInt.length == 1)
    {
      localObject = Arrays.toString(paramArrayOfInt);
      s.s(localObject, "java.util.Arrays.toString(this)");
      Log.i("NearbyLiveAutoPlaySelector", s.X("findItemByPriority return for autoPlayPos:", localObject));
      AppMethodBeat.o(341120);
      return paramArrayOfInt;
    }
    Object localObject = Arrays.toString(paramArrayOfInt);
    s.s(localObject, "java.util.Arrays.toString(this)");
    Log.i("NearbyLiveAutoPlaySelector", s.X("findItemByPriority autoPlayPos:", localObject));
    int j = paramArrayOfInt[0];
    int i1 = paramArrayOfInt.length;
    int m = 0;
    int k = -1;
    int n;
    int i;
    if (m < i1)
    {
      n = paramArrayOfInt[m];
      localObject = QF(n);
      if (!(localObject instanceof x)) {
        break label234;
      }
      localObject = ((x)localObject).feedObject.getFeedObject().liveInfo;
      if (localObject == null) {
        i = -1;
      }
    }
    for (;;)
    {
      label134:
      if (i > k) {
        j = n;
      }
      for (;;)
      {
        m += 1;
        k = i;
        break;
        i = ((bip)localObject).ZRY;
        break label134;
        paramArrayOfInt = new int[1];
        paramArrayOfInt[0] = j;
        localObject = new StringBuilder("findItemByPriority selectPosArray:");
        String str = Arrays.toString(paramArrayOfInt);
        s.s(str, "java.util.Arrays.toString(this)");
        Log.i("NearbyLiveAutoPlaySelector", str + " maxAutoPlayPriority:" + k);
        AppMethodBeat.o(341120);
        return paramArrayOfInt;
        i = k;
      }
      label234:
      i = 1;
    }
  }
  
  private final boolean QE(int paramInt)
  {
    AppMethodBeat.i(370451);
    int m;
    int j;
    int k;
    int i2;
    int i1;
    label49:
    int n;
    int i;
    if (paramInt > 0)
    {
      m = 0;
      j = 0;
      k = paramInt;
      i2 = m + 1;
      if (((m - j) % 2 == 0) && (!(QF(m + 1) instanceof x)))
      {
        i1 = 1;
        if (((QF(m) instanceof x)) && (!(QF(m) instanceof c)))
        {
          n = j;
          i = k;
          if (i1 == 0) {}
        }
        else
        {
          i = k - 1;
          n = j + 1;
        }
        if (i2 < paramInt) {
          break label126;
        }
      }
    }
    for (;;)
    {
      if (i % 2 == 0)
      {
        AppMethodBeat.o(370451);
        return true;
        i1 = 0;
        break label49;
      }
      AppMethodBeat.o(370451);
      return false;
      label126:
      m = i2;
      j = n;
      k = i;
      break;
      i = paramInt;
    }
  }
  
  private final cc QF(int paramInt)
  {
    AppMethodBeat.i(341129);
    if (this.feedList == null)
    {
      Log.w("NearbyLiveAutoPlaySelector", s.X("getFeedByPos return for feedList:", this.feedList));
      AppMethodBeat.o(341129);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("NearbyLiveAutoPlaySelector", s.X("getFeedByPos return for invalid pos:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(341129);
      return null;
    }
    cc localcc = (cc)this.feedList.get(paramInt);
    AppMethodBeat.o(341129);
    return localcc;
  }
  
  private final boolean aNC(int paramInt)
  {
    AppMethodBeat.i(370452);
    if ((QF(paramInt) instanceof c))
    {
      AppMethodBeat.o(370452);
      return true;
    }
    if (!(QF(paramInt + 1) instanceof x)) {}
    for (int i = 1; (QE(paramInt)) && (i != 0); i = 0)
    {
      AppMethodBeat.o(370452);
      return true;
    }
    AppMethodBeat.o(370452);
    return false;
  }
  
  private final int[] b(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(341107);
    int i1 = this.ANY / 2;
    int[] arrayOfInt = new int[2];
    int j = 0;
    arrayOfInt[0] = paramArrayOfInt1[0];
    arrayOfInt[1] = paramArrayOfInt1[1];
    int m = paramArrayOfInt1[0];
    int i2 = paramArrayOfInt2[(paramArrayOfInt2.length - 1)];
    int i;
    if (m <= i2)
    {
      i = 1;
      paramArrayOfInt1 = QF(m);
      if ((paramArrayOfInt1 instanceof x)) {
        break label120;
      }
      Log.w("NearbyLiveAutoPlaySelector", "findAutoPlayItem invalid feed:" + paramArrayOfInt1 + " index:" + m);
    }
    for (;;)
    {
      label120:
      int k;
      if (m == i2)
      {
        paramStaggeredGridLayoutManager = arrayOfInt;
        for (;;)
        {
          AppMethodBeat.o(341107);
          return paramStaggeredGridLayoutManager;
          paramArrayOfInt1 = paramStaggeredGridLayoutManager.findViewByPosition(m);
          if (paramArrayOfInt1 == null) {
            break label555;
          }
          paramArrayOfInt2 = new Rect();
          paramArrayOfInt1.getGlobalVisibleRect(paramArrayOfInt2);
          if (paramArrayOfInt2.contains(paramArrayOfInt2.left, i1))
          {
            k = i;
            if (i != 0)
            {
              j = 0;
              k = 0;
            }
            i = j + 1;
            arrayOfInt[j] = m;
            if (aNC(m))
            {
              Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit baseline for big card, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + i + " rect:" + paramArrayOfInt2 + " baseline:" + i1);
              paramStaggeredGridLayoutManager = new int[] { m };
            }
            else
            {
              j = k;
              k = i;
              if (i < 2) {
                break label583;
              }
              Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit baseline, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + i + " rect:" + paramArrayOfInt2 + " baseline:" + i1);
              paramStaggeredGridLayoutManager = arrayOfInt;
            }
          }
          else
          {
            if (paramArrayOfInt2.top <= i1) {
              break;
            }
            Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit divider, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + j + " rect:" + paramArrayOfInt2 + " baseline:" + i1);
            paramStaggeredGridLayoutManager = arrayOfInt;
          }
        }
        Log.i("NearbyLiveAutoPlaySelector", "findAutoPlayItem item hit cache, focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + "] focusItemIndex:" + j + " rect:" + paramArrayOfInt2 + " baseline:" + i1);
        int n = j + 1;
        arrayOfInt[j] = m;
        j = i;
        k = n;
        if (n >= 2)
        {
          j = 0;
          continue;
          label555:
          Log.w("NearbyLiveAutoPlaySelector", s.X("findAutoPlayItem invalid view index:", Integer.valueOf(m)));
        }
      }
      else
      {
        m += 1;
        break;
      }
      label583:
      i = j;
      j = k;
    }
  }
  
  public final HashSet<e.b> a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, HashSet<e.b> paramHashSet)
  {
    AppMethodBeat.i(341139);
    s.u(paramStaggeredGridLayoutManager, "layoutManager");
    s.u(paramHashSet, "curLivePreviewDataSet");
    if ((paramHashSet.size() == 1) && (aNC(((e.b)p.e((Iterable)paramHashSet)).pos))) {}
    for (boolean bool = true; (paramHashSet.size() >= EJU) || (bool); bool = false)
    {
      Log.i("NearbyLiveAutoPlaySelector", s.X("findAutoStopItem isSingleOneLine:", Boolean.valueOf(bool)));
      AppMethodBeat.o(341139);
      return paramHashSet;
    }
    paramStaggeredGridLayoutManager = new HashSet();
    AppMethodBeat.o(341139);
    return paramStaggeredGridLayoutManager;
  }
  
  public final int[] a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(341147);
    s.u(paramStaggeredGridLayoutManager, "layoutManager");
    s.u(paramArrayOfInt1, "firstVisibleItemPos");
    s.u(paramArrayOfInt2, "lastVisibleItemPos");
    com.tencent.mm.plugin.finder.nearby.live.play.abtest.a locala = com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.ELr;
    if (!com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.eFp())
    {
      locala = com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.ELr;
      if (com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.eFq())
      {
        EJU = 1;
        paramStaggeredGridLayoutManager = E(b(paramStaggeredGridLayoutManager, paramArrayOfInt1, paramArrayOfInt2));
        AppMethodBeat.o(341147);
        return paramStaggeredGridLayoutManager;
      }
      locala = com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.ELr;
      if (com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.eFr())
      {
        EJU = 1;
        paramStaggeredGridLayoutManager = E(b(paramStaggeredGridLayoutManager, paramArrayOfInt1, paramArrayOfInt2));
        AppMethodBeat.o(341147);
        return paramStaggeredGridLayoutManager;
      }
    }
    EJU = 2;
    paramStaggeredGridLayoutManager = b(paramStaggeredGridLayoutManager, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(341147);
    return paramStaggeredGridLayoutManager;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/NearbyLiveAutoPlaySelector$Companion;", "", "()V", "MAX_FOCUS_ITEMS", "", "MAX_SELECTED_ITEMS", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.selector.b
 * JD-Core Version:    0.7.0.1
 */