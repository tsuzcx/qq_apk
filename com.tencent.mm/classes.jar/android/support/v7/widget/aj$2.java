package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

final class aj$2
  extends aj
{
  aj$2(RecyclerView.i parami)
  {
    super(parami, (byte)0);
  }
  
  public final int aX(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bp(paramView) - localLayoutParams.topMargin;
  }
  
  public final int aY(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.br(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public final int aZ(View paramView)
  {
    this.afm.f(paramView, this.hc);
    return this.hc.bottom;
  }
  
  public final void bI(int paramInt)
  {
    this.afm.bQ(paramInt);
  }
  
  public final int ba(View paramView)
  {
    this.afm.f(paramView, this.hc);
    return this.hc.top;
  }
  
  public final int bb(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bn(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public final int bc(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bm(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public final int getEnd()
  {
    return this.afm.mHeight;
  }
  
  public final int getEndPadding()
  {
    return this.afm.getPaddingBottom();
  }
  
  public final int getMode()
  {
    return this.afm.ahg;
  }
  
  public final int hh()
  {
    return this.afm.getPaddingTop();
  }
  
  public final int hi()
  {
    return this.afm.mHeight - this.afm.getPaddingBottom();
  }
  
  public final int hj()
  {
    return this.afm.mHeight - this.afm.getPaddingTop() - this.afm.getPaddingBottom();
  }
  
  public final int hk()
  {
    return this.afm.ahf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.aj.2
 * JD-Core Version:    0.7.0.1
 */