package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftViewPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "gridList", "Ljava/util/ArrayList;", "Landroid/widget/GridView;", "Lkotlin/collections/ArrayList;", "getGridList", "()Ljava/util/ArrayList;", "setGridList", "(Ljava/util/ArrayList;)V", "add", "", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "p0", "Landroid/view/View;", "p1", "plugin-finder_release"})
public final class e
  extends q
{
  private final String TAG;
  public ArrayList<GridView> uAT;
  
  public e()
  {
    AppMethodBeat.i(247784);
    this.TAG = "FinderLiveGiftViewPagerAdapter";
    this.uAT = new ArrayList();
    AppMethodBeat.o(247784);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(247783);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "object");
    Log.i(this.TAG, "destroyItem pos:".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(247783);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(247780);
    int i = this.uAT.size();
    AppMethodBeat.o(247780);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(247781);
    p.h(paramObject, "object");
    AppMethodBeat.o(247781);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(247782);
    p.h(paramViewGroup, "container");
    Log.i(this.TAG, "instantiateItem pos:".concat(String.valueOf(paramInt)));
    Object localObject = this.uAT.get(paramInt);
    p.g(localObject, "gridList[position]");
    localObject = (GridView)localObject;
    paramViewGroup.addView((View)localObject);
    AppMethodBeat.o(247782);
    return localObject;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(247779);
    p.h(paramView, "p0");
    p.h(paramObject, "p1");
    boolean bool = p.j(paramView, paramObject);
    AppMethodBeat.o(247779);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.e
 * JD-Core Version:    0.7.0.1
 */