package android.support.v7.view.menu;

import android.support.v7.a.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  static final int Vs = a.g.abc_popup_menu_item_layout;
  private final LayoutInflater Lu;
  private final boolean UB;
  boolean UQ;
  private int Vq = -1;
  public h Vt;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    this.UB = paramBoolean;
    this.Lu = paramLayoutInflater;
    this.Vt = paramh;
    fd();
  }
  
  private void fd()
  {
    j localj = this.Vt.VP;
    if (localj != null)
    {
      ArrayList localArrayList = this.Vt.fn();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.Vq = i;
          return;
        }
        i += 1;
      }
    }
    this.Vq = -1;
  }
  
  public final j bd(int paramInt)
  {
    if (this.UB) {}
    for (ArrayList localArrayList = this.Vt.fn();; localArrayList = this.Vt.fl())
    {
      int i = paramInt;
      if (this.Vq >= 0)
      {
        i = paramInt;
        if (paramInt >= this.Vq) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.UB) {}
    for (ArrayList localArrayList = this.Vt.fn(); this.Vq < 0; localArrayList = this.Vt.fl()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.Lu.inflate(Vs, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (p.a)paramView;
      if (this.UQ) {
        ((ListMenuItemView)paramView).setForceShowIcon(true);
      }
      paramViewGroup.a(bd(paramInt));
      return paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    fd();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */