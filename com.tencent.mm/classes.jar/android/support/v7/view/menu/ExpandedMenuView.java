package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
  extends ListView
  implements h.b, p, AdapterView.OnItemClickListener
{
  private static final int[] VO = { 16842964, 16843049 };
  private int VP;
  private h eq;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = az.a(paramContext, paramAttributeSet, VO, paramInt, 0);
    if (paramContext.hasValue(0)) {
      setBackgroundDrawable(paramContext.getDrawable(0));
    }
    if (paramContext.hasValue(1)) {
      setDivider(paramContext.getDrawable(1));
    }
    paramContext.aoo.recycle();
  }
  
  public final void a(h paramh)
  {
    this.eq = paramh;
  }
  
  public final boolean f(j paramj)
  {
    return this.eq.a(paramj, null, 0);
  }
  
  public final int getWindowAnimations()
  {
    return this.VP;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    f((j)getAdapter().getItem(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */