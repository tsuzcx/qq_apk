package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  boolean VD;
  private final int Vf;
  private final boolean Vo;
  private int Wg = -1;
  public h Wi;
  private final LayoutInflater mInflater;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.Vo = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.Wi = paramh;
    this.Vf = paramInt;
    fS();
  }
  
  private void fS()
  {
    j localj = this.Wi.WE;
    if (localj != null)
    {
      ArrayList localArrayList = this.Wi.ge();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.Wg = i;
          return;
        }
        i += 1;
      }
    }
    this.Wg = -1;
  }
  
  public final j bb(int paramInt)
  {
    if (this.Vo) {}
    for (ArrayList localArrayList = this.Wi.ge();; localArrayList = this.Wi.gb())
    {
      int i = paramInt;
      if (this.Wg >= 0)
      {
        i = paramInt;
        if (paramInt >= this.Wg) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.Vo) {}
    for (ArrayList localArrayList = this.Wi.ge(); this.Wg < 0; localArrayList = this.Wi.gb()) {
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
      paramView = this.mInflater.inflate(this.Vf, paramViewGroup, false);
    }
    for (;;)
    {
      int j = bb(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = bb(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.Wi.fU()) || (j == i)) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.VD) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(bb(paramInt));
        return paramView;
        i = j;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    fS();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */