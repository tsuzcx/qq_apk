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
  
  public final void bN(int paramInt)
  {
    this.ahB.bV(paramInt);
  }
  
  public final int bh(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bz(paramView) - localLayoutParams.leftMargin;
  }
  
  public final int bi(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bB(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public final int bj(View paramView)
  {
    this.ahB.f(paramView, this.hV);
    return this.hV.right;
  }
  
  public final int bk(View paramView)
  {
    this.ahB.f(paramView, this.hV);
    return this.hV.left;
  }
  
  public final int bl(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bx(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public final int bm(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.by(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public final int getEnd()
  {
    return this.ahB.mWidth;
  }
  
  public final int getEndPadding()
  {
    return this.ahB.getPaddingRight();
  }
  
  public final int getMode()
  {
    return this.ahB.ajv;
  }
  
  public final int iI()
  {
    return this.ahB.getPaddingLeft();
  }
  
  public final int iJ()
  {
    return this.ahB.mWidth - this.ahB.getPaddingRight();
  }
  
  public final int iK()
  {
    return this.ahB.mWidth - this.ahB.getPaddingLeft() - this.ahB.getPaddingRight();
  }
  
  public final int iL()
  {
    return this.ahB.ajw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.aj.1
 * JD-Core Version:    0.7.0.1
 */