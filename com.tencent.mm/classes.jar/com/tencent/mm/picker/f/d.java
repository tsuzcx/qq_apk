package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  private int irK;
  float isJ;
  WheelView.b isL;
  com.tencent.mm.picker.d.b isj;
  boolean isl;
  WheelView ita;
  public WheelView itb;
  List<T> itc;
  boolean itd = true;
  
  @Deprecated
  private void aMU()
  {
    AppMethodBeat.i(175361);
    this.itb.setDividerColor(this.irK);
    AppMethodBeat.o(175361);
  }
  
  private void qw(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.itc != null) {
      this.itb.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] aMV()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.itb.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.itb.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void qv(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.itd)
    {
      qw(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.itb.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.irK = paramInt;
    aMU();
    AppMethodBeat.o(175365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */