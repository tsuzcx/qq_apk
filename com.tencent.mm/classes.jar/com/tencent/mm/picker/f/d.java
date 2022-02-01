package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public final class d<T>
{
  private int iKN;
  float iLM;
  WheelView.b iLO;
  com.tencent.mm.picker.d.b iLm;
  boolean iLo;
  WheelView iMd;
  public WheelView iMe;
  List<T> iMf;
  boolean iMg = true;
  
  @Deprecated
  private void aQf()
  {
    AppMethodBeat.i(175361);
    this.iMe.setDividerColor(this.iKN);
    AppMethodBeat.o(175361);
  }
  
  private void qW(int paramInt)
  {
    AppMethodBeat.i(175364);
    if (this.iMf != null) {
      this.iMe.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(175364);
  }
  
  public final int[] aQg()
  {
    AppMethodBeat.i(175362);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.iMe.getCurrentItem();
    AppMethodBeat.o(175362);
    return arrayOfInt;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175366);
    this.iMe.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175366);
  }
  
  public final void qV(int paramInt)
  {
    AppMethodBeat.i(175363);
    if (this.iMg)
    {
      qW(paramInt);
      AppMethodBeat.o(175363);
      return;
    }
    this.iMe.setCurrentItem(paramInt);
    AppMethodBeat.o(175363);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175365);
    this.iKN = paramInt;
    aQf();
    AppMethodBeat.o(175365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.d
 * JD-Core Version:    0.7.0.1
 */