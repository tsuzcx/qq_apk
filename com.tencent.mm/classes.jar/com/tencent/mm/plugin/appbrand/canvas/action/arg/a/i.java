package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;

public final class i
  extends b
{
  public static final i lai;
  
  static
  {
    AppMethodBeat.i(145332);
    lai = new i();
    AppMethodBeat.o(145332);
  }
  
  public static i bzt()
  {
    return lai;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(145330);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.STROKE);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(g.zD(1));
    super.a(parama);
    AppMethodBeat.o(145330);
  }
  
  public final a bzm()
  {
    AppMethodBeat.i(145331);
    a locala = new a();
    locala.setStyle(Paint.Style.STROKE);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(g.zD(1));
    AppMethodBeat.o(145331);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i
 * JD-Core Version:    0.7.0.1
 */