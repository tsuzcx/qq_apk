package android.support.v7.widget;

import android.view.View;

final class LinearLayoutManager$a
{
  boolean agA;
  boolean agB;
  aj agm;
  int agz;
  int mPosition;
  
  LinearLayoutManager$a()
  {
    reset();
  }
  
  public final void A(View paramView, int paramInt)
  {
    int i = this.agm.iH();
    if (i >= 0) {
      B(paramView, paramInt);
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
            if (!this.agA) {
              break;
            }
            paramInt = this.agm.iJ() - i - this.agm.bi(paramView);
            this.agz = (this.agm.iJ() - paramInt);
          } while (paramInt <= 0);
          i = this.agm.bl(paramView);
          j = this.agz;
          k = this.agm.iI();
          i = j - i - (k + Math.min(this.agm.bh(paramView) - k, 0));
        } while (i >= 0);
        j = this.agz;
        this.agz = (Math.min(paramInt, -i) + j);
        return;
        j = this.agm.bh(paramView);
        paramInt = j - this.agm.iI();
        this.agz = j;
      } while (paramInt <= 0);
      int k = this.agm.bl(paramView);
      int m = this.agm.iJ();
      int n = this.agm.bi(paramView);
      i = this.agm.iJ() - Math.min(0, m - i - n) - (j + k);
    } while (i >= 0);
    this.agz -= Math.min(paramInt, -i);
  }
  
  public final void B(View paramView, int paramInt)
  {
    if (this.agA) {}
    for (this.agz = (this.agm.bi(paramView) + this.agm.iH());; this.agz = this.agm.bh(paramView))
    {
      this.mPosition = paramInt;
      return;
    }
  }
  
  final void ix()
  {
    if (this.agA) {}
    for (int i = this.agm.iJ();; i = this.agm.iI())
    {
      this.agz = i;
      return;
    }
  }
  
  final void reset()
  {
    this.mPosition = -1;
    this.agz = -2147483648;
    this.agA = false;
    this.agB = false;
  }
  
  public final String toString()
  {
    return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.agz + ", mLayoutFromEnd=" + this.agA + ", mValid=" + this.agB + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.a
 * JD-Core Version:    0.7.0.1
 */