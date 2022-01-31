package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.support.v4.view.n;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.SoftReference;

final class AppBrandSmileyViewPager$a
  extends n
{
  c hxA;
  SparseArray<SoftReference<View>> hya = new SparseArray();
  private boolean hyb = false;
  
  public final int F(Object paramObject)
  {
    if (this.hyb) {
      return -2;
    }
    return super.F(paramObject);
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = null;
    if (this.hya.get(paramInt) != null) {
      localView = (View)((SoftReference)this.hya.get(paramInt)).get();
    }
    if (localView == null)
    {
      localView = this.hxA.asJ().na(paramInt);
      if (localView != null)
      {
        paramViewGroup.addView(localView, 0);
        this.hya.put(paramInt, new SoftReference(localView));
        return localView;
      }
      y.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
      return localView;
    }
    if (localView.getParent() != null) {
      ((ViewGroup)localView.getParent()).removeView(localView);
    }
    paramViewGroup.addView(localView, 0);
    return localView;
  }
  
  public final int getCount()
  {
    return this.hxA.asJ().getPageCount();
  }
  
  public final void notifyDataSetChanged()
  {
    this.hyb = true;
    super.notifyDataSetChanged();
    this.hyb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a
 * JD-Core Version:    0.7.0.1
 */