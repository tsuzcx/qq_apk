package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int aak;
  int asn;
  float byA;
  float byB;
  int byC;
  int byD;
  List<Integer> byE;
  int byF;
  int byw;
  int byx;
  int byy;
  int byz;
  int ym;
  int yn;
  int yo;
  int yp;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.ym = 2147483647;
    this.yn = 2147483647;
    this.yo = -2147483648;
    this.yp = -2147483648;
    this.byE = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.ym = Math.min(this.ym, paramView.getLeft() - localFlexItem.wb() - paramInt1);
    this.yn = Math.min(this.yn, paramView.getTop() - localFlexItem.wc() - paramInt2);
    this.yo = Math.max(this.yo, paramView.getRight() + localFlexItem.wd() + paramInt3);
    paramInt1 = this.yp;
    paramInt2 = paramView.getBottom();
    this.yp = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
  
  public final int we()
  {
    return this.asn - this.byz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */