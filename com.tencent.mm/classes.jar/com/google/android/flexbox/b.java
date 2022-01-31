package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int Sm;
  int ake;
  int bcO;
  int bcP;
  int bcQ;
  int bcR;
  float bcS;
  float bcT;
  int bcU;
  int bcV;
  List<Integer> bcW;
  int bcX;
  int qO;
  int qP;
  int qQ;
  int qR;
  
  b()
  {
    AppMethodBeat.i(54677);
    this.qO = 2147483647;
    this.qP = 2147483647;
    this.qQ = -2147483648;
    this.qR = -2147483648;
    this.bcW = new ArrayList();
    AppMethodBeat.o(54677);
  }
  
  final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54678);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.qO = Math.min(this.qO, paramView.getLeft() - localFlexItem.rp() - paramInt1);
    this.qP = Math.min(this.qP, paramView.getTop() - localFlexItem.rq() - paramInt2);
    this.qQ = Math.max(this.qQ, paramView.getRight() + localFlexItem.rr() + paramInt3);
    paramInt1 = this.qR;
    paramInt2 = paramView.getBottom();
    this.qR = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(54678);
  }
  
  public final int rs()
  {
    return this.ake - this.bcR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */