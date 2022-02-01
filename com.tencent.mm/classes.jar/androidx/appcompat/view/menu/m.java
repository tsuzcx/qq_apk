package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class m
  implements AdapterView.OnItemClickListener, o, s
{
  Rect nq;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = paramListAdapter.getCount();
    int j = 0;
    int m = 0;
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = paramViewGroup;
    paramViewGroup = (ViewGroup)localObject2;
    int k;
    if (j < i3)
    {
      int n = paramListAdapter.getItemViewType(j);
      k = m;
      if (n != m)
      {
        k = n;
        paramViewGroup = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FrameLayout(paramContext);
      }
      paramViewGroup = paramListAdapter.getView(j, paramViewGroup, (ViewGroup)localObject2);
      paramViewGroup.measure(i1, i2);
      m = paramViewGroup.getMeasuredWidth();
      if (m >= paramInt) {
        return paramInt;
      }
      if (m <= i) {
        break label158;
      }
      i = m;
    }
    label158:
    for (;;)
    {
      j += 1;
      localObject1 = localObject2;
      m = k;
      break;
      return i;
    }
  }
  
  protected static g a(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (g)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (g)paramListAdapter;
  }
  
  protected static boolean h(h paramh)
  {
    boolean bool2 = false;
    int j = paramh.size();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        MenuItem localMenuItem = paramh.getItem(i);
        if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void a(Context paramContext, h paramh) {}
  
  public abstract void ag(int paramInt);
  
  public abstract void ah(int paramInt);
  
  protected boolean bW()
  {
    return true;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean d(j paramj)
  {
    return false;
  }
  
  public abstract void e(h paramh);
  
  public final int getId()
  {
    return 0;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = a(paramView).mw;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (bW()) {}
    for (paramInt = 0;; paramInt = 4)
    {
      paramAdapterView.a(paramView, this, paramInt);
      return;
    }
  }
  
  public abstract void setAnchorView(View paramView);
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.m
 * JD-Core Version:    0.7.0.1
 */