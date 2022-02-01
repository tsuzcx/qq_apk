package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class g
  extends BaseAdapter
{
  private final LayoutInflater mInflater;
  boolean mN;
  private final int mn;
  private final boolean mw;
  private int nt;
  public h nv;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(200910);
    this.nt = -1;
    this.mw = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.nv = paramh;
    this.mn = paramInt;
    cS();
    AppMethodBeat.o(200910);
  }
  
  private void cS()
  {
    AppMethodBeat.i(200921);
    j localj = this.nv.nR;
    if (localj != null)
    {
      ArrayList localArrayList = this.nv.dd();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.nt = i;
          AppMethodBeat.o(200921);
          return;
        }
        i += 1;
      }
    }
    this.nt = -1;
    AppMethodBeat.o(200921);
  }
  
  public final j ag(int paramInt)
  {
    AppMethodBeat.i(200943);
    if (this.mw) {}
    for (Object localObject = this.nv.dd();; localObject = this.nv.db())
    {
      int i = paramInt;
      if (this.nt >= 0)
      {
        i = paramInt;
        if (paramInt >= this.nt) {
          i = paramInt + 1;
        }
      }
      localObject = (j)((ArrayList)localObject).get(i);
      AppMethodBeat.o(200943);
      return localObject;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(200934);
    if (this.mw) {}
    for (ArrayList localArrayList = this.nv.dd(); this.nt < 0; localArrayList = this.nv.db())
    {
      i = localArrayList.size();
      AppMethodBeat.o(200934);
      return i;
    }
    int i = localArrayList.size();
    AppMethodBeat.o(200934);
    return i - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200961);
    if (paramView == null) {
      paramView = this.mInflater.inflate(this.mn, paramViewGroup, false);
    }
    for (;;)
    {
      int j = ag(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = ag(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.nv.cU()) || (j == i)) {
          break label127;
        }
      }
      label127:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.mN) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(ag(paramInt));
        AppMethodBeat.o(200961);
        return paramView;
        i = j;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(200969);
    cS();
    super.notifyDataSetChanged();
    AppMethodBeat.o(200969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.g
 * JD-Core Version:    0.7.0.1
 */