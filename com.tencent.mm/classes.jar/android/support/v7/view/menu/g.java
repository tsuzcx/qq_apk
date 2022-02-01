package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  boolean afG;
  private final int afi;
  private final boolean afr;
  private int agk = -1;
  public h agm;
  private final LayoutInflater mInflater;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.afr = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.agm = paramh;
    this.afi = paramInt;
    hV();
  }
  
  private void hV()
  {
    j localj = this.agm.agI;
    if (localj != null)
    {
      ArrayList localArrayList = this.agm.ih();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.agk = i;
          return;
        }
        i += 1;
      }
    }
    this.agk = -1;
  }
  
  public final j bv(int paramInt)
  {
    if (this.afr) {}
    for (ArrayList localArrayList = this.agm.ih();; localArrayList = this.agm.jdMethod_if())
    {
      int i = paramInt;
      if (this.agk >= 0)
      {
        i = paramInt;
        if (paramInt >= this.agk) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.afr) {}
    for (ArrayList localArrayList = this.agm.ih(); this.agk < 0; localArrayList = this.agm.jdMethod_if()) {
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
      paramView = this.mInflater.inflate(this.afi, paramViewGroup, false);
    }
    for (;;)
    {
      int j = bv(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = bv(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.agm.hX()) || (j == i)) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.afG) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(bv(paramInt));
        return paramView;
        i = j;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    hV();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */