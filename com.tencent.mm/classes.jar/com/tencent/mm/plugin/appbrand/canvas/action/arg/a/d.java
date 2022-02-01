package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.c;

public final class d
{
  private static d iZH;
  public c<DrawCanvasArg> iZF;
  public c<DrawActionWrapper> iZG;
  
  static
  {
    AppMethodBeat.i(145320);
    iZH = new d();
    AppMethodBeat.o(145320);
  }
  
  private d()
  {
    AppMethodBeat.i(145319);
    this.iZF = new c(5);
    this.iZG = new c(500);
    AppMethodBeat.o(145319);
  }
  
  public static d aSU()
  {
    return iZH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d
 * JD-Core Version:    0.7.0.1
 */