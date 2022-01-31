package android.support.v7.widget;

import android.support.v4.view.v;
import android.view.View;

class GridLayout$e
{
  public int afl;
  public int afm;
  public int afn;
  
  GridLayout$e()
  {
    reset();
  }
  
  protected void R(int paramInt1, int paramInt2)
  {
    this.afl = Math.max(this.afl, paramInt1);
    this.afm = Math.max(this.afm, paramInt2);
  }
  
  protected int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
  {
    return this.afl - parama.l(paramView, paramInt, v.d(paramGridLayout));
  }
  
  protected final void a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, GridLayout.d paramd, int paramInt)
  {
    int j = this.afn;
    if ((parami.afE == GridLayout.aen) && (parami.weight == 0.0F)) {}
    for (int i = 0;; i = 2)
    {
      this.afn = (i & j);
      i = parami.ah(paramd.aeH).l(paramView, paramInt, v.d(paramGridLayout));
      R(i, paramInt - i);
      return;
    }
  }
  
  protected int ad(boolean paramBoolean)
  {
    if ((!paramBoolean) && (GridLayout.by(this.afn))) {
      return 100000;
    }
    return this.afl + this.afm;
  }
  
  protected void reset()
  {
    this.afl = -2147483648;
    this.afm = -2147483648;
    this.afn = 2;
  }
  
  public String toString()
  {
    return "Bounds{before=" + this.afl + ", after=" + this.afm + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.e
 * JD-Core Version:    0.7.0.1
 */