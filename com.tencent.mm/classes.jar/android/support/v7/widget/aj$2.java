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
  
  public final void bN(int paramInt)
  {
    this.ahB.bW(paramInt);
  }
  
  public final int bh(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bA(paramView) - localLayoutParams.topMargin;
  }
  
  public final int bi(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bC(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public final int bj(View paramView)
  {
    this.ahB.f(paramView, this.hV);
    return this.hV.bottom;
  }
  
  public final int bk(View paramView)
  {
    this.ahB.f(paramView, this.hV);
    return this.hV.top;
  }
  
  public final int bl(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.by(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public final int bm(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bx(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public final int getEnd()
  {
    return this.ahB.mHeight;
  }
  
  public final int getEndPadding()
  {
    return this.ahB.getPaddingBottom();
  }
  
  public final int getMode()
  {
    return this.ahB.ajw;
  }
  
  public final int iI()
  {
    return this.ahB.getPaddingTop();
  }
  
  public final int iJ()
  {
    return this.ahB.mHeight - this.ahB.getPaddingBottom();
  }
  
  public final int iK()
  {
    return this.ahB.mHeight - this.ahB.getPaddingTop() - this.ahB.getPaddingBottom();
  }
  
  public final int iL()
  {
    return this.ahB.ajv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.aj.2
 * JD-Core Version:    0.7.0.1
 */