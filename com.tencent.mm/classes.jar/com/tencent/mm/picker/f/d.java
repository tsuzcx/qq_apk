package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import com.tencent.mm.picker.d.c;
import java.util.List;

public final class d<T>
{
  float bbg;
  c pyH;
  boolean pyJ;
  private int pyf;
  List<T> pzA;
  boolean pzB = true;
  WheelView.b pzh;
  WheelView pzy;
  public WheelView pzz;
  
  @Deprecated
  private void bTi()
  {
    AppMethodBeat.i(175361);
    this.pzz.setDividerColor(this.pyf);
    AppMethodBeat.o(175361);
  }
  
  private void ya(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.pzA != null) {
      this.pzz.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] bTj()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.pzz.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.pzz.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.pyf = paramInt;
    bTi();
    AppMethodBeat.o(175365);
  }
  
  public final void xZ(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.pzB)
    {
      ya(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.pzz.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */