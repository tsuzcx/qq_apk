package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
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
  c ZJ;
  private int ZK = 4;
  boolean ZL;
  private boolean ZM;
  private boolean ZN;
  
  ActivityChooserView$a(ActivityChooserView paramActivityChooserView) {}
  
  public final void bi(int paramInt)
  {
    if (this.ZK != paramInt)
    {
      this.ZK = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public final void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.ZL != paramBoolean1) || (this.ZM != paramBoolean2))
    {
      this.ZL = paramBoolean1;
      this.ZM = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public final int gV()
  {
    int k = this.ZK;
    this.ZK = 2147483647;
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
    this.ZK = k;
    return j;
  }
  
  public final int getCount()
  {
    int j = this.ZJ.gI();
    int i = j;
    if (!this.ZL)
    {
      i = j;
      if (this.ZJ.gJ() != null) {
        i = j - 1;
      }
    }
    j = Math.min(i, this.ZK);
    i = j;
    if (this.ZN) {
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
    if (!this.ZL)
    {
      i = paramInt;
      if (this.ZJ.gJ() != null) {
        i = paramInt + 1;
      }
    }
    return this.ZJ.be(i);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.ZN) && (paramInt == getCount() - 1)) {
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
        localView = LayoutInflater.from(this.ZI.getContext()).inflate(2130968591, paramViewGroup, false);
        localView.setId(1);
        ((TextView)localView.findViewById(2131820680)).setText(this.ZI.getContext().getString(2131296260));
      }
      return localView;
    }
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getId() == 2131820928) {}
    }
    else
    {
      localView = LayoutInflater.from(this.ZI.getContext()).inflate(2130968591, paramViewGroup, false);
    }
    paramView = this.ZI.getContext().getPackageManager();
    paramViewGroup = (ImageView)localView.findViewById(2131820929);
    ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
    paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
    ((TextView)localView.findViewById(2131820680)).setText(localResolveInfo.loadLabel(paramView));
    if ((this.ZL) && (paramInt == 0) && (this.ZM))
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
    if (this.ZN != paramBoolean)
    {
      this.ZN = paramBoolean;
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.a
 * JD-Core Version:    0.7.0.1
 */