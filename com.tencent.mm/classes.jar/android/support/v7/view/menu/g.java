package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  private final int aeV;
  private int afX = -1;
  public h afZ;
  private final boolean afe;
  boolean aft;
  private final LayoutInflater mInflater;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.afe = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.afZ = paramh;
    this.aeV = paramInt;
    hM();
  }
  
  private void hM()
  {
    j localj = this.afZ.agv;
    if (localj != null)
    {
      ArrayList localArrayList = this.afZ.hX();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.afX = i;
          return;
        }
        i += 1;
      }
    }
    this.afX = -1;
  }
  
  public final j bu(int paramInt)
  {
    if (this.afe) {}
    for (ArrayList localArrayList = this.afZ.hX();; localArrayList = this.afZ.hV())
    {
      int i = paramInt;
      if (this.afX >= 0)
      {
        i = paramInt;
        if (paramInt >= this.afX) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.afe) {}
    for (ArrayList localArrayList = this.afZ.hX(); this.afX < 0; localArrayList = this.afZ.hV()) {
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
      paramView = this.mInflater.inflate(this.aeV, paramViewGroup, false);
    }
    for (;;)
    {
      int j = bu(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = bu(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.afZ.hO()) || (j == i)) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.aft) {
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
    hM();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */