package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  private int iNG;
  float iOF;
  WheelView.b iOH;
  WheelView iOW;
  public WheelView iOX;
  List<T> iOY;
  boolean iOZ = true;
  com.tencent.mm.picker.d.b iOf;
  boolean iOh;
  
  @Deprecated
  private void aQE()
  {
    AppMethodBeat.i(175361);
    this.iOX.setDividerColor(this.iNG);
    AppMethodBeat.o(175361);
  }
  
  private void qZ(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.iOY != null) {
      this.iOX.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] aQF()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.iOX.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.iOX.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void qY(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.iOZ)
    {
      qZ(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.iOX.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.iNG = paramInt;
    aQE();
    AppMethodBeat.o(175365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */