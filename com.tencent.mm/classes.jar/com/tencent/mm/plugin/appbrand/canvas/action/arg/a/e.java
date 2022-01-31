package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.s.g;

public final class e
  extends b
{
  private static e hfx;
  
  static
  {
    AppMethodBeat.i(103640);
    hfx = new e();
    AppMethodBeat.o(103640);
  }
  
  public static e ayc()
  {
    return hfx;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103638);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.FILL);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(g.pO(1));
    super.a(parama);
    AppMethodBeat.o(103638);
  }
  
  public final a axZ()
  {
    AppMethodBeat.i(103639);
    a locala = new a();
    locala.setStyle(Paint.Style.FILL);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(g.pO(1));
    AppMethodBeat.o(103639);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e
 * JD-Core Version:    0.7.0.1
 */