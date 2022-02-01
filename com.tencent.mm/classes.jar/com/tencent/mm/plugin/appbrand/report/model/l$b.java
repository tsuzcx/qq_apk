package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(48147);
    lrG = new b("DESKTOP_SEARCH", 0, 1);
    lrH = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
    lrI = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
    lrJ = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
    lrK = new b[] { lrG, lrH, lrI, lrJ };
    AppMethodBeat.o(48147);
  }
  
  private l$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l.b
 * JD-Core Version:    0.7.0.1
 */