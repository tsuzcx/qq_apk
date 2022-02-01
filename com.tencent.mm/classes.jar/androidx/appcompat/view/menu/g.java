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
  private final boolean lA;
  boolean lQ;
  private final int lr;
  private final LayoutInflater mInflater;
  private int mu;
  public h mw;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(239309);
    this.mu = -1;
    this.lA = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mw = paramh;
    this.lr = paramInt;
    bZ();
    AppMethodBeat.o(239309);
  }
  
  private void bZ()
  {
    AppMethodBeat.i(239317);
    j localj = this.mw.mT;
    if (localj != null)
    {
      ArrayList localArrayList = this.mw.ck();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.mu = i;
          AppMethodBeat.o(239317);
          return;
        }
        i += 1;
      }
    }
    this.mu = -1;
    AppMethodBeat.o(239317);
  }
  
  public final j ai(int paramInt)
  {
    AppMethodBeat.i(239313);
    if (this.lA) {}
    for (Object localObject = this.mw.ck();; localObject = this.mw.ci())
    {
      int i = paramInt;
      if (this.mu >= 0)
      {
        i = paramInt;
        if (paramInt >= this.mu) {
          i = paramInt + 1;
        }
      }
      localObject = (j)((ArrayList)localObject).get(i);
      AppMethodBeat.o(239313);
      return localObject;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(239310);
    if (this.lA) {}
    for (ArrayList localArrayList = this.mw.ck(); this.mu < 0; localArrayList = this.mw.ci())
    {
      i = localArrayList.size();
      AppMethodBeat.o(239310);
      return i;
    }
    int i = localArrayList.size();
    AppMethodBeat.o(239310);
    return i - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(239315);
    if (paramView == null) {
      paramView = this.mInflater.inflate(this.lr, paramViewGroup, false);
    }
    for (;;)
    {
      int j = ai(paramInt).getGroupId();
      int i;
      if (paramInt - 1 >= 0)
      {
        i = ai(paramInt - 1).getGroupId();
        paramViewGroup = (ListMenuItemView)paramView;
        if ((!this.mw.cb()) || (j == i)) {
          break label127;
        }
      }
      label127:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setGroupDividerEnabled(bool);
        paramViewGroup = (p.a)paramView;
        if (this.lQ) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(ai(paramInt));
        AppMethodBeat.o(239315);
        return paramView;
        i = j;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(239320);
    bZ();
    super.notifyDataSetChanged();
    AppMethodBeat.o(239320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.g
 * JD-Core Version:    0.7.0.1
 */