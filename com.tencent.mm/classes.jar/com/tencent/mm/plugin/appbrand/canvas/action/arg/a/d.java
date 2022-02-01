package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.SynchronizedPool;

public final class d
{
  private static d nUn;
  public SynchronizedPool<DrawCanvasArg> nUl;
  public SynchronizedPool<DrawActionWrapper> nUm;
  
  static
  {
    AppMethodBeat.i(145320);
    nUn = new d();
    AppMethodBeat.o(145320);
  }
  
  private d()
  {
    AppMethodBeat.i(145319);
    this.nUl = new SynchronizedPool(5);
    this.nUm = new SynchronizedPool(500);
    AppMethodBeat.o(145319);
  }
  
  public static d bKD()
  {
    return nUn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d
 * JD-Core Version:    0.7.0.1
 */