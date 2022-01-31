package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

final class aj$1
  extends aj
{
  aj$1(RecyclerView.i parami)
  {
    super(parami, (byte)0);
  }
  
  public final int aX(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bo(paramView) - localLayoutParams.leftMargin;
  }
  
  public final int aY(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bq(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public final int aZ(View paramView)
  {
    this.afm.f(paramView, this.hc);
    return this.hc.right;
  }
  
  public final void bI(int paramInt)
  {
    this.afm.bP(paramInt);
  }
  
  public final int ba(View paramView)
  {
    this.afm.f(paramView, this.hc);
    return this.hc.left;
  }
  
  public final int bb(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bm(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public final int bc(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bn(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public final int getEnd()
  {
    return this.afm.mWidth;
  }
  
  public final int getEndPadding()
  {
    return this.afm.getPaddingRight();
  }
  
  public final int getMode()
  {
    return this.afm.ahf;
  }
  
  public final int hh()
  {
    return this.afm.getPaddingLeft();
  }
  
  public final int hi()
  {
    return this.afm.mWidth - this.afm.getPaddingRight();
  }
  
  public final int hj()
  {
    return this.afm.mWidth - this.afm.getPaddingLeft() - this.afm.getPaddingRight();
  }
  
  public final int hk()
  {
    return this.afm.ahg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.aj.1
 * JD-Core Version:    0.7.0.1
 */