package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.a.a;

public final class e
  extends b
{
  private static e qTY;
  
  static
  {
    AppMethodBeat.i(145323);
    qTY = new e();
    AppMethodBeat.o(145323);
  }
  
  public static e cke()
  {
    return qTY;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(145321);
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.FILL);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(i.DC(1));
    super.a(parama);
    AppMethodBeat.o(145321);
  }
  
  public final a ckb()
  {
    AppMethodBeat.i(145322);
    a locala = new a();
    locala.setStyle(Paint.Style.FILL);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(i.DC(1));
    AppMethodBeat.o(145322);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e
 * JD-Core Version:    0.7.0.1
 */