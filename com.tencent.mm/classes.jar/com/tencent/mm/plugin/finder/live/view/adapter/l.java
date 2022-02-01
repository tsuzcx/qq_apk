package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "gridList", "Ljava/util/ArrayList;", "Landroid/widget/GridView;", "Lkotlin/collections/ArrayList;", "getGridList", "()Ljava/util/ArrayList;", "setGridList", "(Ljava/util/ArrayList;)V", "add", "", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "p0", "Landroid/view/View;", "p1", "plugin-finder_release"})
public final class l
  extends a
{
  private final String TAG;
  public ArrayList<GridView> yXN;
  
  public l()
  {
    AppMethodBeat.i(287667);
    this.TAG = "FinderLiveGiftViewPagerAdapter";
    this.yXN = new ArrayList();
    AppMethodBeat.o(287667);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(287666);
    p.k(paramViewGroup, "container");
    p.k(paramObject, "object");
    Log.i(this.TAG, "destroyItem pos:".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(287666);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(287663);
    int i = this.yXN.size();
    AppMethodBeat.o(287663);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(287664);
    p.k(paramObject, "object");
    AppMethodBeat.o(287664);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(287665);
    p.k(paramViewGroup, "container");
    Log.i(this.TAG, "instantiateItem pos:".concat(String.valueOf(paramInt)));
    Object localObject = this.yXN.get(paramInt);
    p.j(localObject, "gridList[position]");
    localObject = (GridView)localObject;
    paramViewGroup.addView((View)localObject);
    AppMethodBeat.o(287665);
    return localObject;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(287662);
    p.k(paramView, "p0");
    p.k(paramObject, "p1");
    boolean bool = p.h(paramView, paramObject);
    AppMethodBeat.o(287662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.l
 * JD-Core Version:    0.7.0.1
 */