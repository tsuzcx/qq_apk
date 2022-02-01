package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  com.tencent.mm.picker.d.b jKU;
  boolean jKW;
  private int jKu;
  WheelView jLL;
  public WheelView jLM;
  List<T> jLN;
  boolean jLO = true;
  float jLu;
  WheelView.b jLw;
  
  @Deprecated
  private void blj()
  {
    AppMethodBeat.i(175361);
    this.jLM.setDividerColor(this.jKu);
    AppMethodBeat.o(175361);
  }
  
  private void uR(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.jLN != null) {
      this.jLM.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] blk()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.jLM.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.jLM.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.jKu = paramInt;
    blj();
    AppMethodBeat.o(175365);
  }
  
  public final void uQ(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.jLO)
    {
      uR(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.jLM.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */