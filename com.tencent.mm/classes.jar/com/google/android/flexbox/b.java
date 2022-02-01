package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int Af;
  int Ag;
  int Ah;
  int Ai;
  int aca;
  int aue;
  int bIK;
  int bIL;
  int bIM;
  int bIN;
  float bIO;
  float bIP;
  int bIQ;
  int bIR;
  List<Integer> bIS;
  int bIT;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.Af = 2147483647;
    this.Ag = 2147483647;
    this.Ah = -2147483648;
    this.Ai = -2147483648;
    this.bIS = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.Af = Math.min(this.Af, paramView.getLeft() - localFlexItem.xy() - paramInt1);
    this.Ag = Math.min(this.Ag, paramView.getTop() - localFlexItem.xz() - paramInt2);
    this.Ah = Math.max(this.Ah, paramView.getRight() + localFlexItem.xA() + paramInt3);
    paramInt1 = this.Ai;
    paramInt2 = paramView.getBottom();
    this.Ai = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
  
  public final int xB()
  {
    return this.aue - this.bIN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */