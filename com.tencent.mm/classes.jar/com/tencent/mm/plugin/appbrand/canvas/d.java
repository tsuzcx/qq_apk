package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Stack;

public final class d
  implements a
{
  public f czm;
  public final ad.b hpn;
  public com.tencent.mm.plugin.appbrand.canvas.a.a kZl;
  public com.tencent.mm.plugin.appbrand.canvas.a.a kZm;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> kZn;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> kZo;
  public Paint kZp;
  public Paint kZq;
  public e kZr;
  private a kZs;
  boolean kZt;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.kZp = new Paint();
    this.hpn = new ad.b();
    this.kZt = true;
    this.kZs = parama;
    if (this.kZt)
    {
      parama = i.bzt().bzl();
      this.kZl = parama;
      if (!this.kZt) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bzp().bzl();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.kZm = parama;
      this.kZl.setStyle(Paint.Style.STROKE);
      this.kZm.setStyle(Paint.Style.FILL);
      this.kZl.setAntiAlias(true);
      this.kZm.setAntiAlias(true);
      this.kZl.setStrokeWidth(g.zD(1));
      this.kZm.setStrokeWidth(g.zD(1));
      this.kZn = new Stack();
      this.kZo = new Stack();
      this.kZp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.kZs.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.kZn.clear();
    this.kZo.clear();
    this.kZl.reset();
    this.kZm.reset();
    this.kZl.setStyle(Paint.Style.STROKE);
    this.kZm.setStyle(Paint.Style.FILL);
    this.kZl.setAntiAlias(true);
    this.kZm.setAntiAlias(true);
    this.kZl.setStrokeWidth(g.zD(1));
    this.kZm.setStrokeWidth(g.zD(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.kZn.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.kZl;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.kZm;
    this.kZl = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.kZn.pop());
    this.kZm = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.kZo.pop());
    if (this.kZt)
    {
      if (this.kZl != locala1) {
        i.bzt().a(locala1);
      }
      if (this.kZm != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bzp().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void save()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.kZl;
    this.kZn.push(this.kZl);
    if (this.kZt)
    {
      this.kZl = i.bzt().bzl();
      locala.b(this.kZl);
      if (this.kZl == null) {
        this.kZl = locala;
      }
      locala = this.kZm;
      this.kZo.push(this.kZm);
      if (!this.kZt) {
        break label132;
      }
    }
    label132:
    for (this.kZm = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bzp().bzl();; this.kZm = locala.bzu())
    {
      locala.b(this.kZm);
      if (this.kZm == null) {
        this.kZm = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.kZl = locala.bzu();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */