package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int alU;
  int apP;
  int apQ;
  int bsJ;
  int bsK;
  int bsL;
  int bsM;
  float bsN;
  float bsO;
  int bsP;
  int bsQ;
  List<Integer> bsR;
  int bsS;
  int iV;
  int tF;
  int tG;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.tF = 2147483647;
    this.apP = 2147483647;
    this.tG = -2147483648;
    this.apQ = -2147483648;
    this.bsR = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  final void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.tF = Math.min(this.tF, paramView.getLeft() - localFlexItem.vJ() - paramInt1);
    this.apP = Math.min(this.apP, paramView.getTop() - localFlexItem.vK() - paramInt2);
    this.tG = Math.max(this.tG, paramView.getRight() + localFlexItem.vL() + paramInt3);
    paramInt1 = this.apQ;
    paramInt2 = paramView.getBottom();
    this.apQ = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
  
  public final int vM()
  {
    return this.alU - this.bsM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */