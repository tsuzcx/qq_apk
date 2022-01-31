package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private p md;
  private int me = 0;
  private int mf = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    d(paramCoordinatorLayout, paramV, paramInt);
    if (this.md == null) {
      this.md = new p(paramV);
    }
    this.md.bh();
    if (this.me != 0)
    {
      this.md.q(this.me);
      this.me = 0;
    }
    if (this.mf != 0)
    {
      paramCoordinatorLayout = this.md;
      paramInt = this.mf;
      if (paramCoordinatorLayout.mj != paramInt)
      {
        paramCoordinatorLayout.mj = paramInt;
        paramCoordinatorLayout.bi();
      }
      this.mf = 0;
    }
    return true;
  }
  
  public int ag()
  {
    if (this.md != null) {
      return this.md.mi;
    }
    return 0;
  }
  
  protected void d(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.e(paramV, paramInt);
  }
  
  public boolean q(int paramInt)
  {
    if (this.md != null) {
      return this.md.q(paramInt);
    }
    this.me = paramInt;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */