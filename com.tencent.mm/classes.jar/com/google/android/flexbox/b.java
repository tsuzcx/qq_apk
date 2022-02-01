package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  int cau;
  int cey;
  int cez;
  int dml;
  int dmm;
  int dmn;
  int dmo;
  float dmp;
  float dmq;
  int dmr;
  int dms;
  List<Integer> dmt;
  int dmu;
  boolean dmv;
  boolean dmw;
  int jQ;
  int uE;
  int uF;
  
  b()
  {
    AppMethodBeat.i(62214);
    this.uE = 2147483647;
    this.cey = 2147483647;
    this.uF = -2147483648;
    this.cez = -2147483648;
    this.dmt = new ArrayList();
    AppMethodBeat.o(62214);
  }
  
  public final int Vl()
  {
    return this.cau - this.dmo;
  }
  
  final void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62215);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.uE = Math.min(this.uE, paramView.getLeft() - localFlexItem.Vi() - paramInt1);
    this.cey = Math.min(this.cey, paramView.getTop() - localFlexItem.Vj() - paramInt2);
    this.uF = Math.max(this.uF, paramView.getRight() + localFlexItem.Vk() + paramInt3);
    paramInt1 = this.cez;
    paramInt2 = paramView.getBottom();
    this.cez = Math.max(paramInt1, localFlexItem.getMarginBottom() + paramInt2 + paramInt4);
    AppMethodBeat.o(62215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.flexbox.b
 * JD-Core Version:    0.7.0.1
 */