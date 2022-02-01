package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  com.tencent.mm.picker.d.b mBZ;
  private int mBx;
  WheelView.b mCA;
  WheelView mCQ;
  public WheelView mCR;
  List<T> mCS;
  boolean mCT = true;
  boolean mCb;
  float mCy;
  
  @Deprecated
  private void buZ()
  {
    AppMethodBeat.i(175361);
    this.mCR.setDividerColor(this.mBx);
    AppMethodBeat.o(175361);
  }
  
  private void xV(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.mCS != null) {
      this.mCR.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] bva()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.mCR.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.mCR.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.mBx = paramInt;
    buZ();
    AppMethodBeat.o(175365);
  }
  
  public final void xU(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.mCT)
    {
      xV(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.mCR.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */