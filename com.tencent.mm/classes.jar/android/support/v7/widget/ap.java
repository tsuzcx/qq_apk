package android.support.v7.widget;

import android.view.View;

final class ap
{
  static int a(RecyclerView.s params, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean)
  {
    if ((parami.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(RecyclerView.i.bl(paramView1) - RecyclerView.i.bl(paramView2)) + 1;
    }
    int i = paramaj.aY(paramView2);
    int j = paramaj.aX(paramView1);
    return Math.min(paramaj.hj(), i - j);
  }
  
  static int a(RecyclerView.s params, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (parami.getChildCount() != 0)
    {
      j = i;
      if (params.getItemCount() != 0)
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
    i = Math.min(RecyclerView.i.bl(paramView1), RecyclerView.i.bl(paramView2));
    j = Math.max(RecyclerView.i.bl(paramView1), RecyclerView.i.bl(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, params.getItemCount() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paramaj.aY(paramView2) - paramaj.aX(paramView1));
      int k = Math.abs(RecyclerView.i.bl(paramView1) - RecyclerView.i.bl(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramaj.hh() - paramaj.aX(paramView1)));
    }
  }
  
  static int b(RecyclerView.s params, aj paramaj, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean)
  {
    if ((parami.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return params.getItemCount();
    }
    int i = paramaj.aY(paramView2);
    int j = paramaj.aX(paramView1);
    int k = Math.abs(RecyclerView.i.bl(paramView1) - RecyclerView.i.bl(paramView2));
    return (int)((i - j) / (k + 1) * params.getItemCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */