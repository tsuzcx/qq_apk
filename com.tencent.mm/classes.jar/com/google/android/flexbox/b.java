package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int Al;
  int Am;
  int An;
  int Ao;
  int acn;
  int auc;
  int bJa;
  int bJb;
  int bJc;
  int bJd;
  float bJe;
  float bJf;
  int bJg;
  int bJh;
  List<Integer> bJi;
  int bJj;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.Al = 2147483647;
    this.Am = 2147483647;
    this.An = -2147483648;
    this.Ao = -2147483648;
    this.bJi = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  final void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.Al = Math.min(this.Al, paramView.getLeft() - localFlexItem.xG() - paramInt1);
    this.Am = Math.min(this.Am, paramView.getTop() - localFlexItem.xH() - paramInt2);
    this.An = Math.max(this.An, paramView.getRight() + localFlexItem.xI() + paramInt3);
    paramInt1 = this.Ao;
    paramInt2 = paramView.getBottom();
    this.Ao = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
  
  public final int xJ()
  {
    return this.auc - this.bJd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */