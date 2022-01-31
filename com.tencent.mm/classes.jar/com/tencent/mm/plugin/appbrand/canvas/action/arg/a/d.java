package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;

public final class d
{
  private static d hfw;
  public com.tencent.mm.sdk.d<DrawCanvasArg> hfu;
  public com.tencent.mm.sdk.d<DrawActionWrapper> hfv;
  
  static
  {
    AppMethodBeat.i(103637);
    hfw = new d();
    AppMethodBeat.o(103637);
  }
  
  private d()
  {
    AppMethodBeat.i(103636);
    this.hfu = new com.tencent.mm.sdk.d(5);
    this.hfv = new com.tencent.mm.sdk.d(500);
    AppMethodBeat.o(103636);
  }
  
  public static d ayb()
  {
    return hfw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d
 * JD-Core Version:    0.7.0.1
 */