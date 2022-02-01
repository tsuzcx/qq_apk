package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import androidx.viewpager.widget.a;
import com.tencent.d.a.a.a.d.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "gridList", "Ljava/util/ArrayList;", "Landroid/widget/GridView;", "Lkotlin/collections/ArrayList;", "getGridList", "()Ljava/util/ArrayList;", "setGridList", "(Ljava/util/ArrayList;)V", "add", "", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "p0", "Landroid/view/View;", "p1", "updateGridView", "curGiftId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends a
{
  public ArrayList<GridView> DRs;
  private final String TAG;
  
  public r()
  {
    AppMethodBeat.i(358667);
    this.TAG = "FinderLiveGiftViewPagerAdapter";
    this.DRs = new ArrayList();
    AppMethodBeat.o(358667);
  }
  
  public final void aya(String paramString)
  {
    AppMethodBeat.i(358688);
    s.u(paramString, "curGiftId");
    Iterator localIterator = ((Iterable)this.DRs).iterator();
    while (localIterator.hasNext())
    {
      GridView localGridView = (GridView)localIterator.next();
      Object localObject1 = localGridView.getAdapter();
      if (localObject1 == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveGiftGridAdapter");
        AppMethodBeat.o(358688);
        throw paramString;
      }
      q localq = (q)localObject1;
      int m = localq.getCount();
      if (m > 0)
      {
        int i = 0;
        int k = i + 1;
        Object localObject2 = localq.getItem(i);
        label125:
        int j;
        if ((localObject2 instanceof d))
        {
          localObject1 = (d)localObject2;
          if ((localObject1 == null) || (((d)localObject1).jWv() != true)) {
            break label265;
          }
          j = 1;
          label141:
          if (j != 0)
          {
            if (!s.p(((d)localObject2).field_rewardProductId, paramString)) {
              break label296;
            }
            localObject1 = localGridView.getChildAt(i);
            if (localObject1 != null) {
              break label270;
            }
            localObject1 = null;
            label176:
            if (!(localObject1 instanceof q.b)) {
              break label280;
            }
            localObject1 = (q.b)localObject1;
            label191:
            if (localObject1 != null) {
              break label286;
            }
          }
        }
        label265:
        label270:
        label280:
        label286:
        for (localObject1 = null;; localObject1 = ((q.b)localObject1).DRr)
        {
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          Log.i(this.TAG, "select " + ((d)localObject2).field_name + '!');
          label246:
          if (k >= m) {
            break label382;
          }
          i = k;
          break;
          localObject1 = null;
          break label125;
          j = 0;
          break label141;
          localObject1 = ((View)localObject1).getTag();
          break label176;
          localObject1 = null;
          break label191;
        }
        label296:
        localObject1 = localGridView.getChildAt(i);
        if (localObject1 == null)
        {
          localObject1 = null;
          label312:
          if (!(localObject1 instanceof q.b)) {
            break label394;
          }
          localObject1 = (q.b)localObject1;
          label327:
          if (localObject1 != null) {
            break label400;
          }
        }
        label394:
        label400:
        for (localObject1 = null;; localObject1 = ((q.b)localObject1).DRr)
        {
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          Log.i(this.TAG, "unselect " + ((d)localObject2).field_name + '!');
          break label246;
          label382:
          break;
          localObject1 = ((View)localObject1).getTag();
          break label312;
          localObject1 = null;
          break label327;
        }
      }
    }
    AppMethodBeat.o(358688);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(358728);
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    Log.i(this.TAG, s.X("destroyItem pos:", Integer.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(358728);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(358703);
    int i = this.DRs.size();
    AppMethodBeat.o(358703);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(358708);
    s.u(paramObject, "object");
    AppMethodBeat.o(358708);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(358718);
    s.u(paramViewGroup, "container");
    Log.i(this.TAG, s.X("instantiateItem pos:", Integer.valueOf(paramInt)));
    Object localObject = this.DRs.get(paramInt);
    s.s(localObject, "gridList[position]");
    localObject = (GridView)localObject;
    paramViewGroup.addView((View)localObject);
    AppMethodBeat.o(358718);
    return localObject;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(358696);
    s.u(paramView, "p0");
    s.u(paramObject, "p1");
    boolean bool = s.p(paramView, paramObject);
    AppMethodBeat.o(358696);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.r
 * JD-Core Version:    0.7.0.1
 */