package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private p wB;
  private int wC = 0;
  private int wD = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean G(int paramInt)
  {
    if (this.wB != null) {
      return this.wB.G(paramInt);
    }
    this.wC = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.wB == null) {
      this.wB = new p(paramV);
    }
    this.wB.dx();
    if (this.wC != 0)
    {
      this.wB.G(this.wC);
      this.wC = 0;
    }
    if (this.wD != 0)
    {
      paramCoordinatorLayout = this.wB;
      paramInt = this.wD;
      if (paramCoordinatorLayout.wH != paramInt)
      {
        paramCoordinatorLayout.wH = paramInt;
        paramCoordinatorLayout.dy();
      }
      this.wD = 0;
    }
    return true;
  }
  
  public int bT()
  {
    if (this.wB != null) {
      return this.wB.wG;
    }
    return 0;
  }
  
  protected void c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.g(paramV, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */