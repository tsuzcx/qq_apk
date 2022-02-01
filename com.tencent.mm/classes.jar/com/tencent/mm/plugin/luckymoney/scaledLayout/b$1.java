package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  extends b
{
  b$1(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, (byte)0);
  }
  
  public final int bs(View paramView)
  {
    AppMethodBeat.i(65326);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.arI.getDecoratedMeasuredWidth(paramView);
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    AppMethodBeat.o(65326);
    return k + (i + j);
  }
  
  public final int bt(View paramView)
  {
    AppMethodBeat.i(65327);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.arI.getDecoratedMeasuredHeight(paramView);
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(65327);
    return k + (i + j);
  }
  
  public final int efm()
  {
    AppMethodBeat.i(65329);
    int i = this.arI.getHeight();
    int j = this.arI.getPaddingTop();
    int k = this.arI.getPaddingBottom();
    AppMethodBeat.o(65329);
    return i - j - k;
  }
  
  public final int kH()
  {
    AppMethodBeat.i(65325);
    int i = this.arI.getPaddingLeft();
    AppMethodBeat.o(65325);
    return i;
  }
  
  public final int kJ()
  {
    AppMethodBeat.i(65328);
    int i = this.arI.getWidth();
    int j = this.arI.getPaddingLeft();
    int k = this.arI.getPaddingRight();
    AppMethodBeat.o(65328);
    return i - j - k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b.1
 * JD-Core Version:    0.7.0.1
 */