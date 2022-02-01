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
  public c cnl;
  public final y.b gzS;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jSY;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jSZ;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jTa;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jTb;
  public Paint jTc;
  public Paint jTd;
  public e jTe;
  private a jTf;
  boolean jTg;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.jTc = new Paint();
    this.gzS = new y.b();
    this.jTg = true;
    this.jTf = parama;
    if (this.jTg)
    {
      parama = i.bdx().bdp();
      this.jSY = parama;
      if (!this.jTg) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdt().bdp();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.jSZ = parama;
      this.jSY.setStyle(Paint.Style.STROKE);
      this.jSZ.setStyle(Paint.Style.FILL);
      this.jSY.setAntiAlias(true);
      this.jSZ.setAntiAlias(true);
      this.jSY.setStrokeWidth(g.vJ(1));
      this.jSZ.setStrokeWidth(g.vJ(1));
      this.jTa = new Stack();
      this.jTb = new Stack();
      this.jTc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.jTf.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.jTa.clear();
    this.jTb.clear();
    this.jSY.reset();
    this.jSZ.reset();
    this.jSY.setStyle(Paint.Style.STROKE);
    this.jSZ.setStyle(Paint.Style.FILL);
    this.jSY.setAntiAlias(true);
    this.jSZ.setAntiAlias(true);
    this.jSY.setStrokeWidth(g.vJ(1));
    this.jSZ.setStrokeWidth(g.vJ(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.jTa.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.jSY;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.jSZ;
    this.jSY = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jTa.pop());
    this.jSZ = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jTb.pop());
    if (this.jTg)
    {
      if (this.jSY != locala1) {
        i.bdx().a(locala1);
      }
      if (this.jSZ != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdt().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void save()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.jSY;
    this.jTa.push(this.jSY);
    if (this.jTg)
    {
      this.jSY = i.bdx().bdp();
      locala.b(this.jSY);
      if (this.jSY == null) {
        this.jSY = locala;
      }
      locala = this.jSZ;
      this.jTb.push(this.jSZ);
      if (!this.jTg) {
        break label132;
      }
    }
    label132:
    for (this.jSZ = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdt().bdp();; this.jSZ = locala.bdy())
    {
      locala.b(this.jSZ);
      if (this.jSZ == null) {
        this.jSZ = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.jSY = locala.bdy();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */