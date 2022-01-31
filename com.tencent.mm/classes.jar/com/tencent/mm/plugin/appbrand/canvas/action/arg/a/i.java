package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.u.h;

public final class i
  extends b
{
  public static final i fMr = new i();
  
  public static i adO()
  {
    return fMr;
  }
  
  public final void a(a parama)
  {
    parama.reset();
    parama.release();
    parama.setStyle(Paint.Style.STROKE);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(h.my(1));
    super.a(parama);
  }
  
  public final a adH()
  {
    a locala = new a();
    locala.setStyle(Paint.Style.STROKE);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(h.my(1));
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i
 * JD-Core Version:    0.7.0.1
 */