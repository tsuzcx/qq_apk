package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Stack;

public class d
  implements a
{
  public f eqB;
  public final ad.b mBj;
  public com.tencent.mm.plugin.appbrand.canvas.a.a qTi;
  public com.tencent.mm.plugin.appbrand.canvas.a.a qTj;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> qTk;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> qTl;
  public Paint qTm;
  public Paint qTn;
  public e qTo;
  private a qTp;
  boolean qTq;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.qTm = new Paint();
    this.mBj = new ad.b();
    this.qTq = true;
    this.qTp = parama;
    if (this.qTq)
    {
      parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i.cki().cka();
      this.qTi = parama;
      if (!this.qTq) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.cke().cka();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.qTj = parama;
      this.qTi.setStyle(Paint.Style.STROKE);
      this.qTj.setStyle(Paint.Style.FILL);
      this.qTi.setAntiAlias(true);
      this.qTj.setAntiAlias(true);
      this.qTi.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
      this.qTj.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
      this.qTk = new Stack();
      this.qTl = new Stack();
      this.qTm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.qTp.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.qTk.clear();
    this.qTl.clear();
    this.qTi.reset();
    this.qTj.reset();
    this.qTi.setStyle(Paint.Style.STROKE);
    this.qTj.setStyle(Paint.Style.FILL);
    this.qTi.setAntiAlias(true);
    this.qTj.setAntiAlias(true);
    this.qTi.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
    this.qTj.setStrokeWidth(com.tencent.mm.plugin.appbrand.af.i.DC(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.qTk.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.qTi;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.qTj;
    this.qTi = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.qTk.pop());
    this.qTj = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.qTl.pop());
    if (this.qTq)
    {
      if (this.qTi != locala1) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i.cki().a(locala1);
      }
      if (this.qTj != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.cke().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void sz()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.qTi;
    this.qTk.push(this.qTi);
    if (this.qTq)
    {
      this.qTi = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i.cki().cka();
      locala.b(this.qTi);
      if (this.qTi == null) {
        this.qTi = locala;
      }
      locala = this.qTj;
      this.qTl.push(this.qTj);
      if (!this.qTq) {
        break label132;
      }
    }
    label132:
    for (this.qTj = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.cke().cka();; this.qTj = locala.ckj())
    {
      locala.b(this.qTj);
      if (this.qTj == null) {
        this.qTj = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.qTi = locala.ckj();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */