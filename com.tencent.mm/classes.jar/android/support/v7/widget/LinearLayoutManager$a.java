package android.support.v7.widget;

import android.view.View;

final class LinearLayoutManager$a
{
  aj adZ;
  int aem;
  boolean aen;
  boolean aeo;
  int mPosition;
  
  LinearLayoutManager$a()
  {
    reset();
  }
  
  final void hc()
  {
    if (this.aen) {}
    for (int i = this.adZ.hi();; i = this.adZ.hh())
    {
      this.aem = i;
      return;
    }
  }
  
  final void reset()
  {
    this.mPosition = -1;
    this.aem = -2147483648;
    this.aen = false;
    this.aeo = false;
  }
  
  public final String toString()
  {
    return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.aem + ", mLayoutFromEnd=" + this.aen + ", mValid=" + this.aeo + '}';
  }
  
  public final void v(View paramView, int paramInt)
  {
    int i = this.adZ.hg();
    if (i >= 0) {
      w(paramView, paramInt);
    }
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            return;
            this.mPosition = paramInt;
            if (!this.aen) {
              break;
            }
            paramInt = this.adZ.hi() - i - this.adZ.aY(paramView);
            this.aem = (this.adZ.hi() - paramInt);
          } while (paramInt <= 0);
          i = this.adZ.bb(paramView);
          j = this.aem;
          k = this.adZ.hh();
          i = j - i - (k + Math.min(this.adZ.aX(paramView) - k, 0));
        } while (i >= 0);
        j = this.aem;
        this.aem = (Math.min(paramInt, -i) + j);
        return;
        j = this.adZ.aX(paramView);
        paramInt = j - this.adZ.hh();
        this.aem = j;
      } while (paramInt <= 0);
      int k = this.adZ.bb(paramView);
      int m = this.adZ.hi();
      int n = this.adZ.aY(paramView);
      i = this.adZ.hi() - Math.min(0, m - i - n) - (j + k);
    } while (i >= 0);
    this.aem -= Math.min(paramInt, -i);
  }
  
  public final void w(View paramView, int paramInt)
  {
    if (this.aen) {}
    for (this.aem = (this.adZ.aY(paramView) + this.adZ.hg());; this.aem = this.adZ.aX(paramView))
    {
      this.mPosition = paramInt;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.a
 * JD-Core Version:    0.7.0.1
 */