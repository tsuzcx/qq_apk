package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  boolean adC;
  private final int ade;
  private final boolean adn;
  private int aeg = -1;
  public h aei;
  private final LayoutInflater mInflater;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.adn = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.aei = paramh;
    this.ade = paramInt;
    hw();
  }
  
  private void hw()
  {
    j localj = this.aei.aeE;
    if (localj != null)
    {
      ArrayList localArrayList = this.aei.hH();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.aeg = i;
          return;
        }
        i += 1;
      }
    }
    this.aeg = -1;
  }
  
  public final j bu(int paramInt)
  {
    if (this.adn) {}
    for (ArrayList localArrayList = this.aei.hH();; localArrayList = this.aei.hF())
    {
      int i = paramInt;
      if (this.aeg >= 0)
      {
        i = paramInt;
        if (paramInt >= this.aeg) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.adn) {}
    for (ArrayList localArrayList = this.aei.hH(); this.aeg < 0; localArrayList = this.aei.hF()) {
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
      paramView = this.mInflater.inflate(this.ade, paramViewGroup, false);
    }
    for (;;)
    {
      int j = bu(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = bu(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.aei.hy()) || (j == i)) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.adC) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(bu(paramInt));
        return paramView;
        i = j;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    hw();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */