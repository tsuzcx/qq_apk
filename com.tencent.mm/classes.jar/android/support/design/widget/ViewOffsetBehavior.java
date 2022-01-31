package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private o na;
  private int nb = 0;
  private int nc = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    d(paramCoordinatorLayout, paramV, paramInt);
    if (this.na == null) {
      this.na = new o(paramV);
    }
    this.na.bS();
    if (this.nb != 0)
    {
      this.na.p(this.nb);
      this.nb = 0;
    }
    if (this.nc != 0)
    {
      paramCoordinatorLayout = this.na;
      paramInt = this.nc;
      if (paramCoordinatorLayout.ng != paramInt)
      {
        paramCoordinatorLayout.ng = paramInt;
        paramCoordinatorLayout.bT();
      }
      this.nc = 0;
    }
    return true;
  }
  
  public int aO()
  {
    if (this.na != null) {
      return this.na.nf;
    }
    return 0;
  }
  
  protected void d(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.e(paramV, paramInt);
  }
  
  public boolean p(int paramInt)
  {
    if (this.na != null) {
      return this.na.p(paramInt);
    }
    this.nb = paramInt;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */