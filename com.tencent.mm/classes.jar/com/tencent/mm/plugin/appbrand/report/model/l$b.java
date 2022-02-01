package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(48147);
    myn = new b("DESKTOP_SEARCH", 0, 1);
    myo = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
    myp = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
    myq = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
    myr = new b[] { myn, myo, myp, myq };
    AppMethodBeat.o(48147);
  }
  
  private l$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l.b
 * JD-Core Version:    0.7.0.1
 */