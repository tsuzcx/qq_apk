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
  
  public final int bNs()
  {
    AppMethodBeat.i(42473);
    int i = this.ahB.mHeight;
    int j = this.ahB.getPaddingTop();
    int k = this.ahB.getPaddingBottom();
    AppMethodBeat.o(42473);
    return i - j - k;
  }
  
  public final int bl(View paramView)
  {
    AppMethodBeat.i(42470);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bx(paramView);
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    AppMethodBeat.o(42470);
    return k + (i + j);
  }
  
  public final int bm(View paramView)
  {
    AppMethodBeat.i(42471);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.by(paramView);
    int j = localLayoutParams.topMargin;
    int k = localLayoutParams.bottomMargin;
    AppMethodBeat.o(42471);
    return k + (i + j);
  }
  
  public final int iI()
  {
    AppMethodBeat.i(42469);
    int i = this.ahB.getPaddingLeft();
    AppMethodBeat.o(42469);
    return i;
  }
  
  public final int iK()
  {
    AppMethodBeat.i(42472);
    int i = this.ahB.mWidth;
    int j = this.ahB.getPaddingLeft();
    int k = this.ahB.getPaddingRight();
    AppMethodBeat.o(42472);
    return i - j - k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b.1
 * JD-Core Version:    0.7.0.1
 */