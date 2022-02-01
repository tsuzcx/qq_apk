package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private p tA;
  private int tB = 0;
  private int tC = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean G(int paramInt)
  {
    if (this.tA != null) {
      return this.tA.G(paramInt);
    }
    this.tB = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.tA == null) {
      this.tA = new p(paramV);
    }
    this.tA.cY();
    if (this.tB != 0)
    {
      this.tA.G(this.tB);
      this.tB = 0;
    }
    if (this.tC != 0)
    {
      paramCoordinatorLayout = this.tA;
      paramInt = this.tC;
      if (paramCoordinatorLayout.tG != paramInt)
      {
        paramCoordinatorLayout.tG = paramInt;
        paramCoordinatorLayout.cZ();
      }
      this.tC = 0;
    }
    return true;
  }
  
  public int bv()
  {
    if (this.tA != null) {
      return this.tA.tF;
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