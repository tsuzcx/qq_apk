package android.support.v7.widget;

import android.support.v4.view.t;
import android.view.View;

final class GridLayout$5
  extends GridLayout.a
{
  GridLayout$5(GridLayout.a parama1, GridLayout.a parama2) {}
  
  final String hP()
  {
    return "SWITCHING[L:" + this.aez.hP() + ", R:" + this.aeA.hP() + "]";
  }
  
  public final int l(View paramView, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (t.T(paramView) == 1) {
      if (i != 0) {
        break label37;
      }
    }
    label37:
    for (GridLayout.a locala = this.aez;; locala = this.aeA)
    {
      return locala.l(paramView, paramInt1, paramInt2);
      i = 0;
      break;
    }
  }
  
  final int z(View paramView, int paramInt)
  {
    int i = 1;
    if (t.T(paramView) == 1) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (GridLayout.a locala = this.aez;; locala = this.aeA)
    {
      return locala.z(paramView, paramInt);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.5
 * JD-Core Version:    0.7.0.1
 */