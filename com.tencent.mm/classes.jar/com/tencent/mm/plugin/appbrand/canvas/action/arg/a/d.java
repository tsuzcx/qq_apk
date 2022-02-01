package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.c;

public final class d
{
  private static d jXg;
  public c<DrawCanvasArg> jXe;
  public c<DrawActionWrapper> jXf;
  
  static
  {
    AppMethodBeat.i(145320);
    jXg = new d();
    AppMethodBeat.o(145320);
  }
  
  private d()
  {
    AppMethodBeat.i(145319);
    this.jXe = new c(5);
    this.jXf = new c(500);
    AppMethodBeat.o(145319);
  }
  
  public static d bdX()
  {
    return jXg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d
 * JD-Core Version:    0.7.0.1
 */