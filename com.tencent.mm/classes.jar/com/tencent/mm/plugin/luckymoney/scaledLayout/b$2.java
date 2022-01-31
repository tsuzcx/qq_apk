package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  extends b
{
  b$2(RecyclerView.i parami)
  {
    super(parami, (byte)0);
  }
  
  public final int bNs()
  {
    AppMethodBeat.i(42478);
    int i = this.ahB.mWidth;
    int j = this.ahB.getPaddingLeft();
    int k = this.ahB.getPaddingRight();
    AppMethodBeat.o(42478);
    return i - j - k;
  }
  
  public final int bl(View paramView)
  {
    AppMethodBeat.i(42475);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.by(paramView);
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(42475);
    return k + (i + j);
  }
  
  public final int bm(View paramView)
  {
    AppMethodBeat.i(42476);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bx(paramView);
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    AppMethodBeat.o(42476);
    return k + (i + j);
  }
  
  public final int iI()
  {
    AppMethodBeat.i(42474);
    int i = this.ahB.getPaddingTop();
    AppMethodBeat.o(42474);
    return i;
  }
  
  public final int iK()
  {
    AppMethodBeat.i(42477);
    int i = this.ahB.mHeight;
    int j = this.ahB.getPaddingTop();
    int k = this.ahB.getPaddingBottom();
    AppMethodBeat.o(42477);
    return i - j - k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b.2
 * JD-Core Version:    0.7.0.1
 */