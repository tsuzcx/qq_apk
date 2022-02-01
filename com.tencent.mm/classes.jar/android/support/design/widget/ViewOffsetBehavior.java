package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private p wt;
  private int wv = 0;
  private int ww = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean G(int paramInt)
  {
    if (this.wt != null) {
      return this.wt.G(paramInt);
    }
    this.wv = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.wt == null) {
      this.wt = new p(paramV);
    }
    this.wt.du();
    if (this.wv != 0)
    {
      this.wt.G(this.wv);
      this.wv = 0;
    }
    if (this.ww != 0)
    {
      paramCoordinatorLayout = this.wt;
      paramInt = this.ww;
      if (paramCoordinatorLayout.wA != paramInt)
      {
        paramCoordinatorLayout.wA = paramInt;
        paramCoordinatorLayout.dv();
      }
      this.ww = 0;
    }
    return true;
  }
  
  public int bR()
  {
    if (this.wt != null) {
      return this.wt.wz;
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