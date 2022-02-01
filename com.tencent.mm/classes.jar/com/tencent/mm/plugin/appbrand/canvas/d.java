package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import java.util.Stack;

public class d
  implements a
{
  public com.tencent.mm.plugin.appbrand.jsapi.e cyi;
  public final ad.b kbe;
  public Paint nTA;
  public Paint nTB;
  public e nTC;
  private a nTD;
  boolean nTE;
  public com.tencent.mm.plugin.appbrand.canvas.a.a nTw;
  public com.tencent.mm.plugin.appbrand.canvas.a.a nTx;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> nTy;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> nTz;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.nTA = new Paint();
    this.kbe = new ad.b();
    this.nTE = true;
    this.nTD = parama;
    if (this.nTE)
    {
      parama = i.bKI().bKA();
      this.nTw = parama;
      if (!this.nTE) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bKE().bKA();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.nTx = parama;
      this.nTw.setStyle(Paint.Style.STROKE);
      this.nTx.setStyle(Paint.Style.FILL);
      this.nTw.setAntiAlias(true);
      this.nTx.setAntiAlias(true);
      this.nTw.setStrokeWidth(g.Di(1));
      this.nTx.setStrokeWidth(g.Di(1));
      this.nTy = new Stack();
      this.nTz = new Stack();
      this.nTA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void arg()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.nTw;
    this.nTy.push(this.nTw);
    if (this.nTE)
    {
      this.nTw = i.bKI().bKA();
      locala.b(this.nTw);
      if (this.nTw == null) {
        this.nTw = locala;
      }
      locala = this.nTx;
      this.nTz.push(this.nTx);
      if (!this.nTE) {
        break label132;
      }
    }
    label132:
    for (this.nTx = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bKE().bKA();; this.nTx = locala.bKJ())
    {
      locala.b(this.nTx);
      if (this.nTx == null) {
        this.nTx = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.nTw = locala.bKJ();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.nTD.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.nTy.clear();
    this.nTz.clear();
    this.nTw.reset();
    this.nTx.reset();
    this.nTw.setStyle(Paint.Style.STROKE);
    this.nTx.setStyle(Paint.Style.FILL);
    this.nTw.setAntiAlias(true);
    this.nTx.setAntiAlias(true);
    this.nTw.setStrokeWidth(g.Di(1));
    this.nTx.setStrokeWidth(g.Di(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.nTy.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.nTw;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.nTx;
    this.nTw = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.nTy.pop());
    this.nTx = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.nTz.pop());
    if (this.nTE)
    {
      if (this.nTw != locala1) {
        i.bKI().a(locala1);
      }
      if (this.nTx != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bKE().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */