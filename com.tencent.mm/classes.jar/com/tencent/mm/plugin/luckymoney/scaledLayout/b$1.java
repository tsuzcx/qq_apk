package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  extends b
{
  b$1(RecyclerView.i parami)
  {
    super(parami, (byte)0);
  }
  
  public final int br(View paramView)
  {
    AppMethodBeat.i(65326);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bE(paramView);
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    AppMethodBeat.o(65326);
    return k + (i + j);
  }
  
  public final int bs(View paramView)
  {
    AppMethodBeat.i(65327);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bF(paramView);
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(65327);
    return k + (i + j);
  }
  
  public final int dlr()
  {
    AppMethodBeat.i(65329);
    int i = this.arw.mHeight;
    int j = this.arw.getPaddingTop();
    int k = this.arw.getPaddingBottom();
    AppMethodBeat.o(65329);
    return i - j - k;
  }
  
  public final int kB()
  {
    AppMethodBeat.i(65325);
    int i = this.arw.getPaddingLeft();
    AppMethodBeat.o(65325);
    return i;
  }
  
  public final int kD()
  {
    AppMethodBeat.i(65328);
    int i = this.arw.mWidth;
    int j = this.arw.getPaddingLeft();
    int k = this.arw.getPaddingRight();
    AppMethodBeat.o(65328);
    return i - j - k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b.1
 * JD-Core Version:    0.7.0.1
 */