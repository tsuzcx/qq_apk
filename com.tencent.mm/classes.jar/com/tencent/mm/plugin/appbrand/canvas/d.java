package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.Stack;

public final class d
  implements a
{
  public c cnn;
  public final z.b gCz;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jWp;
  public com.tencent.mm.plugin.appbrand.canvas.a.a jWq;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jWr;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> jWs;
  public Paint jWt;
  public Paint jWu;
  public e jWv;
  private a jWw;
  boolean jWx;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.jWt = new Paint();
    this.gCz = new z.b();
    this.jWx = true;
    this.jWw = parama;
    if (this.jWx)
    {
      parama = i.bec().bdU();
      this.jWp = parama;
      if (!this.jWx) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdY().bdU();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.jWq = parama;
      this.jWp.setStyle(Paint.Style.STROKE);
      this.jWq.setStyle(Paint.Style.FILL);
      this.jWp.setAntiAlias(true);
      this.jWq.setAntiAlias(true);
      this.jWp.setStrokeWidth(g.vO(1));
      this.jWq.setStrokeWidth(g.vO(1));
      this.jWr = new Stack();
      this.jWs = new Stack();
      this.jWt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.jWw.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.jWr.clear();
    this.jWs.clear();
    this.jWp.reset();
    this.jWq.reset();
    this.jWp.setStyle(Paint.Style.STROKE);
    this.jWq.setStyle(Paint.Style.FILL);
    this.jWp.setAntiAlias(true);
    this.jWq.setAntiAlias(true);
    this.jWp.setStrokeWidth(g.vO(1));
    this.jWq.setStrokeWidth(g.vO(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.jWr.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.jWp;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.jWq;
    this.jWp = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jWr.pop());
    this.jWq = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.jWs.pop());
    if (this.jWx)
    {
      if (this.jWp != locala1) {
        i.bec().a(locala1);
      }
      if (this.jWq != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdY().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void save()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.jWp;
    this.jWr.push(this.jWp);
    if (this.jWx)
    {
      this.jWp = i.bec().bdU();
      locala.b(this.jWp);
      if (this.jWp == null) {
        this.jWp = locala;
      }
      locala = this.jWq;
      this.jWs.push(this.jWq);
      if (!this.jWx) {
        break label132;
      }
    }
    label132:
    for (this.jWq = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.bdY().bdU();; this.jWq = locala.bed())
    {
      locala.b(this.jWq);
      if (this.jWq == null) {
        this.jWq = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.jWp = locala.bed();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */