package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  private int hRF;
  float hSE;
  WheelView.b hSG;
  WheelView hSV;
  public WheelView hSW;
  List<T> hSX;
  boolean hSY = true;
  com.tencent.mm.picker.d.b hSe;
  boolean hSg;
  
  @Deprecated
  private void aGh()
  {
    AppMethodBeat.i(175361);
    this.hSW.setDividerColor(this.hRF);
    AppMethodBeat.o(175361);
  }
  
  private void pJ(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.hSX != null) {
      this.hSW.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] aGi()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.hSW.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.hSW.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void pI(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.hSY)
    {
      pJ(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.hSW.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.hRF = paramInt;
    aGh();
    AppMethodBeat.o(175365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */