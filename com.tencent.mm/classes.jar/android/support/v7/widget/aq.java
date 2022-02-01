package android.support.v7.widget;

import android.view.View;

final class aq
{
  static int a(RecyclerView.t paramt, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean)
  {
    if ((parami.getChildCount() == 0) || (paramt.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(RecyclerView.i.bB(paramView1) - RecyclerView.i.bB(paramView2)) + 1;
    }
    int i = paramaj.bo(paramView2);
    int j = paramaj.bn(paramView1);
    return Math.min(paramaj.kD(), i - j);
  }
  
  static int a(RecyclerView.t paramt, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (parami.getChildCount() != 0)
    {
      j = i;
      if (paramt.getItemCount() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(RecyclerView.i.bB(paramView1), RecyclerView.i.bB(paramView2));
    j = Math.max(RecyclerView.i.bB(paramView1), RecyclerView.i.bB(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, paramt.getItemCount() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paramaj.bo(paramView2) - paramaj.bn(paramView1));
      int k = Math.abs(RecyclerView.i.bB(paramView1) - RecyclerView.i.bB(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramaj.kB() - paramaj.bn(paramView1)));
    }
  }
  
  static int b(RecyclerView.t paramt, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean)
  {
    if ((parami.getChildCount() == 0) || (paramt.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return paramt.getItemCount();
    }
    int i = paramaj.bo(paramView2);
    int j = paramaj.bn(paramView1);
    int k = Math.abs(RecyclerView.i.bB(paramView1) - RecyclerView.i.bB(paramView2));
    return (int)((i - j) / (k + 1) * paramt.getItemCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.aq
 * JD-Core Version:    0.7.0.1
 */