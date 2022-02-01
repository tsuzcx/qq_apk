package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private p uB;
  private int uC = 0;
  private int uD = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean G(int paramInt)
  {
    if (this.uB != null) {
      return this.uB.G(paramInt);
    }
    this.uC = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.uB == null) {
      this.uB = new p(paramV);
    }
    this.uB.df();
    if (this.uC != 0)
    {
      this.uB.G(this.uC);
      this.uC = 0;
    }
    if (this.uD != 0)
    {
      paramCoordinatorLayout = this.uB;
      paramInt = this.uD;
      if (paramCoordinatorLayout.uH != paramInt)
      {
        paramCoordinatorLayout.uH = paramInt;
        paramCoordinatorLayout.dg();
      }
      this.uD = 0;
    }
    return true;
  }
  
  public int bC()
  {
    if (this.uB != null) {
      return this.uB.uG;
    }
    return 0;
  }
  
  protected void c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.f(paramV, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */