package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;

public final class i
  extends b
{
  public static final i qUc;
  
  static
  {
    AppMethodBeat.i(145332);
    qUc = new i();
    AppMethodBeat.o(145332);
  }
  
  public static i cki()
  {
    return qUc;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(145330);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.STROKE);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
    super.a(parama);
    AppMethodBeat.o(145330);
  }
  
  public final a ckb()
  {
    AppMethodBeat.i(145331);
    a locala = new a();
    locala.setStyle(Paint.Style.STROKE);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
    AppMethodBeat.o(145331);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i
 * JD-Core Version:    0.7.0.1
 */