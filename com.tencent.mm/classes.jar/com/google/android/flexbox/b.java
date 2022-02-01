package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int Zp;
  int ars;
  int bAO;
  int bAP;
  int bAQ;
  int bAR;
  float bAS;
  float bAT;
  int bAU;
  int bAV;
  List<Integer> bAW;
  int bAX;
  int xo;
  int xp;
  int xq;
  int xr;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.xo = 2147483647;
    this.xp = 2147483647;
    this.xq = -2147483648;
    this.xr = -2147483648;
    this.bAW = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.xo = Math.min(this.xo, paramView.getLeft() - localFlexItem.wo() - paramInt1);
    this.xp = Math.min(this.xp, paramView.getTop() - localFlexItem.wp() - paramInt2);
    this.xq = Math.max(this.xq, paramView.getRight() + localFlexItem.wq() + paramInt3);
    paramInt1 = this.xr;
    paramInt2 = paramView.getBottom();
    this.xr = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
  
  public final int wr()
  {
    return this.ars - this.bAR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */