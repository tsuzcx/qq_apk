package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

final class ActivityChooserView$a
  extends BaseAdapter
{
  d YY;
  private int YZ = 4;
  boolean Za;
  private boolean Zb;
  private boolean Zc;
  
  ActivityChooserView$a(ActivityChooserView paramActivityChooserView) {}
  
  public final void bk(int paramInt)
  {
    if (this.YZ != paramInt)
    {
      this.YZ = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public final void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.Za != paramBoolean1) || (this.Zb != paramBoolean2))
    {
      this.Za = paramBoolean1;
      this.Zb = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public final int fY()
  {
    int k = this.YZ;
    this.YZ = 2147483647;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = getCount();
    int i = 0;
    View localView = null;
    int j = 0;
    while (i < i1)
    {
      localView = getView(i, localView, null);
      localView.measure(m, n);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
    }
    this.YZ = k;
    return j;
  }
  
  public final int getCount()
  {
    int j = this.YY.fO();
    int i = j;
    if (!this.Za)
    {
      i = j;
      if (this.YY.fP() != null) {
        i = j - 1;
      }
    }
    j = Math.min(i, this.YZ);
    i = j;
    if (this.Zc) {
      i = j + 1;
    }
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return null;
    }
    int i = paramInt;
    if (!this.Za)
    {
      i = paramInt;
      if (this.YY.fP() != null) {
        i = paramInt + 1;
      }
    }
    return this.YY.bh(i);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.Zc) && (paramInt == getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == 1) {}
      }
      else
      {
        localView = LayoutInflater.from(this.YX.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
        localView.setId(1);
        ((TextView)localView.findViewById(a.f.title)).setText(this.YX.getContext().getString(a.h.abc_activity_chooser_view_see_all));
      }
      return localView;
    }
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getId() == a.f.list_item) {}
    }
    else
    {
      localView = LayoutInflater.from(this.YX.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
    }
    paramView = this.YX.getContext().getPackageManager();
    paramViewGroup = (ImageView)localView.findViewById(a.f.icon);
    ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
    paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
    ((TextView)localView.findViewById(a.f.title)).setText(localResolveInfo.loadLabel(paramView));
    if ((this.Za) && (paramInt == 0) && (this.Zb))
    {
      localView.setActivated(true);
      return localView;
    }
    localView.setActivated(false);
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final void setShowFooterView(boolean paramBoolean)
  {
    if (this.Zc != paramBoolean)
    {
      this.Zc = paramBoolean;
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.a
 * JD-Core Version:    0.7.0.1
 */