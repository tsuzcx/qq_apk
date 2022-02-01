package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.Stack;

public final class d
  implements a
{
  public c ccU;
  public final y.b ggi;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jzb;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jzc;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jzd;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jze;
  public Paint jzf;
  public Paint jzg;
  public e jzh;
  private a jzi;
  boolean jzj;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.jzf = new Paint();
    this.ggi = new y.b();
    this.jzj = true;
    this.jzi = parama;
    if (this.jzj)
    {
      parama = i.aZY().aZQ();
      this.jzb = parama;
      if (!this.jzj) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aZU().aZQ();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.jzc = parama;
      this.jzb.setStyle(Paint.Style.STROKE);
      this.jzc.setStyle(Paint.Style.FILL);
      this.jzb.setAntiAlias(true);
      this.jzc.setAntiAlias(true);
      this.jzb.setStrokeWidth(g.ve(1));
      this.jzc.setStrokeWidth(g.ve(1));
      this.jzd = new Stack();
      this.jze = new Stack();
      this.jzf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.jzi.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.jzd.clear();
    this.jze.clear();
    this.jzb.reset();
    this.jzc.reset();
    this.jzb.setStyle(Paint.Style.STROKE);
    this.jzc.setStyle(Paint.Style.FILL);
    this.jzb.setAntiAlias(true);
    this.jzc.setAntiAlias(true);
    this.jzb.setStrokeWidth(g.ve(1));
    this.jzc.setStrokeWidth(g.ve(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.jzd.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.jzb;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.jzc;
    this.jzb = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jzd.pop());
    this.jzc = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jze.pop());
    if (this.jzj)
    {
      if (this.jzb != locala1) {
        i.aZY().a(locala1);
      }
      if (this.jzc != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aZU().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void save()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.jzb;
    this.jzd.push(this.jzb);
    if (this.jzj)
    {
      this.jzb = i.aZY().aZQ();
      locala.b(this.jzb);
      if (this.jzb == null) {
        this.jzb = locala;
      }
      locala = this.jzc;
      this.jze.push(this.jzc);
      if (!this.jzj) {
        break label132;
      }
    }
    label132:
    for (this.jzc = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aZU().aZQ();; this.jzc = locala.aZZ())
    {
      locala.b(this.jzc);
      if (this.jzc == null) {
        this.jzc = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.jzb = locala.aZZ();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */