package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.s.g;

public final class i
  extends b
{
  public static final i hfB;
  
  static
  {
    AppMethodBeat.i(103649);
    hfB = new i();
    AppMethodBeat.o(103649);
  }
  
  public static i ayg()
  {
    return hfB;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103647);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.STROKE);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(g.pO(1));
    super.a(parama);
    AppMethodBeat.o(103647);
  }
  
  public final a axZ()
  {
    AppMethodBeat.i(103648);
    a locala = new a();
    locala.setStyle(Paint.Style.STROKE);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(g.pO(1));
    AppMethodBeat.o(103648);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i
 * JD-Core Version:    0.7.0.1
 */