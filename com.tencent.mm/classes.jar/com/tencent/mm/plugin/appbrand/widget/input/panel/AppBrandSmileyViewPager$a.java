package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.SoftReference;

final class AppBrandSmileyViewPager$a
  extends q
{
  c jpK;
  SparseArray<SoftReference<View>> jqk;
  private boolean jql;
  
  AppBrandSmileyViewPager$a()
  {
    AppMethodBeat.i(134333);
    this.jqk = new SparseArray();
    this.jql = false;
    AppMethodBeat.o(134333);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(134337);
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(134337);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(134336);
    int i = this.jpK.aRO().getPageCount();
    AppMethodBeat.o(134336);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(134334);
    if (this.jql)
    {
      AppMethodBeat.o(134334);
      return -2;
    }
    int i = super.getItemPosition(paramObject);
    AppMethodBeat.o(134334);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(134338);
    View localView = null;
    if (this.jqk.get(paramInt) != null) {
      localView = (View)((SoftReference)this.jqk.get(paramInt)).get();
    }
    if (localView == null)
    {
      localView = this.jpK.aRO().qE(paramInt);
      if (localView != null)
      {
        paramViewGroup.addView(localView, 0);
        this.jqk.put(paramInt, new SoftReference(localView));
      }
      for (;;)
      {
        AppMethodBeat.o(134338);
        return localView;
        ab.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
      }
    }
    if (localView.getParent() != null) {
      ((ViewGroup)localView.getParent()).removeView(localView);
    }
    paramViewGroup.addView(localView, 0);
    AppMethodBeat.o(134338);
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(134335);
    this.jql = true;
    super.notifyDataSetChanged();
    this.jql = false;
    AppMethodBeat.o(134335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a
 * JD-Core Version:    0.7.0.1
 */