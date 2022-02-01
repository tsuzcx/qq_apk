package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.y.g;

public final class e
  extends b
{
  private static e jXh;
  
  static
  {
    AppMethodBeat.i(145323);
    jXh = new e();
    AppMethodBeat.o(145323);
  }
  
  public static e bdY()
  {
    return jXh;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(145321);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.FILL);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(g.vO(1));
    super.a(parama);
    AppMethodBeat.o(145321);
  }
  
  public final a bdV()
  {
    AppMethodBeat.i(145322);
    a locala = new a();
    locala.setStyle(Paint.Style.FILL);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(g.vO(1));
    AppMethodBeat.o(145322);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e
 * JD-Core Version:    0.7.0.1
 */