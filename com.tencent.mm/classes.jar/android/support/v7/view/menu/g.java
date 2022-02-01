package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  boolean acI;
  private final int ack;
  private final boolean act;
  private int adm = -1;
  public h ado;
  private final LayoutInflater mInflater;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.act = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.ado = paramh;
    this.ack = paramInt;
    ho();
  }
  
  private void ho()
  {
    j localj = this.ado.adK;
    if (localj != null)
    {
      ArrayList localArrayList = this.ado.hz();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.adm = i;
          return;
        }
        i += 1;
      }
    }
    this.adm = -1;
  }
  
  public final j bu(int paramInt)
  {
    if (this.act) {}
    for (ArrayList localArrayList = this.ado.hz();; localArrayList = this.ado.hx())
    {
      int i = paramInt;
      if (this.adm >= 0)
      {
        i = paramInt;
        if (paramInt >= this.adm) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (this.act) {}
    for (ArrayList localArrayList = this.ado.hz(); this.adm < 0; localArrayList = this.ado.hx()) {
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
      paramView = this.mInflater.inflate(this.ack, paramViewGroup, false);
    }
    for (;;)
    {
      int j = bu(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = bu(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.ado.hq()) || (j == i)) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.acI) {
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
    ho();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.7.0.1
 */