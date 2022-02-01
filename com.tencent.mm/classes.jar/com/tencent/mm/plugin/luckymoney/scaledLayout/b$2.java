package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  extends b
{
  b$2(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, (byte)0);
  }
  
  public final int bs(View paramView)
  {
    AppMethodBeat.i(65331);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.arI.getDecoratedMeasuredHeight(paramView);
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(65331);
    return k + (i + j);
  }
  
  public final int bt(View paramView)
  {
    AppMethodBeat.i(65332);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.arI.getDecoratedMeasuredWidth(paramView);
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    AppMethodBeat.o(65332);
    return k + (i + j);
  }
  
  public final int efm()
  {
    AppMethodBeat.i(65334);
    int i = this.arI.getWidth();
    int j = this.arI.getPaddingLeft();
    int k = this.arI.getPaddingRight();
    AppMethodBeat.o(65334);
    return i - j - k;
  }
  
  public final int kH()
  {
    AppMethodBeat.i(65330);
    int i = this.arI.getPaddingTop();
    AppMethodBeat.o(65330);
    return i;
  }
  
  public final int kJ()
  {
    AppMethodBeat.i(65333);
    int i = this.arI.getHeight();
    int j = this.arI.getPaddingTop();
    int k = this.arI.getPaddingBottom();
    AppMethodBeat.o(65333);
    return i - j - k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b.2
 * JD-Core Version:    0.7.0.1
 */