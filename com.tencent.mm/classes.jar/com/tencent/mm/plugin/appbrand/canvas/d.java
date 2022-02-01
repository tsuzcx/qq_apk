package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Stack;

public final class d
  implements a
{
  public c cfX;
  public final y.b gbC;
  public com.tencent.mm.plugin.appbrand.canvas.a.a iYL;
  public com.tencent.mm.plugin.appbrand.canvas.a.a iYM;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> iYN;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> iYO;
  public Paint iYP;
  public Paint iYQ;
  public e iYR;
  private a iYS;
  boolean iYT;
  
  public d(a parama)
  {
    AppMethodBeat.i(144848);
    this.iYP = new Paint();
    this.gbC = new y.b();
    this.iYT = true;
    this.iYS = parama;
    if (this.iYT)
    {
      parama = i.aSZ().aSR();
      this.iYL = parama;
      if (!this.iYT) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aSV().aSR();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.iYM = parama;
      this.iYL.setStyle(Paint.Style.STROKE);
      this.iYM.setStyle(Paint.Style.FILL);
      this.iYL.setAntiAlias(true);
      this.iYM.setAntiAlias(true);
      this.iYL.setStrokeWidth(g.um(1));
      this.iYM.setStrokeWidth(g.um(1));
      this.iYN = new Stack();
      this.iYO = new Stack();
      this.iYP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(144848);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144852);
    this.iYS.invalidate();
    AppMethodBeat.o(144852);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(144849);
    this.iYN.clear();
    this.iYO.clear();
    this.iYL.reset();
    this.iYM.reset();
    this.iYL.setStyle(Paint.Style.STROKE);
    this.iYM.setStyle(Paint.Style.FILL);
    this.iYL.setAntiAlias(true);
    this.iYM.setAntiAlias(true);
    this.iYL.setStrokeWidth(g.um(1));
    this.iYM.setStrokeWidth(g.um(1));
    AppMethodBeat.o(144849);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(144851);
    if (this.iYN.isEmpty())
    {
      AppMethodBeat.o(144851);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.iYL;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.iYM;
    this.iYL = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.iYN.pop());
    this.iYM = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.iYO.pop());
    if (this.iYT)
    {
      if (this.iYL != locala1) {
        i.aSZ().a(locala1);
      }
      if (this.iYM != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aSV().a(locala2);
      }
    }
    AppMethodBeat.o(144851);
  }
  
  public final void save()
  {
    AppMethodBeat.i(144850);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.iYL;
    this.iYN.push(this.iYL);
    if (this.iYT)
    {
      this.iYL = i.aSZ().aSR();
      locala.b(this.iYL);
      if (this.iYL == null) {
        this.iYL = locala;
      }
      locala = this.iYM;
      this.iYO.push(this.iYM);
      if (!this.iYT) {
        break label132;
      }
    }
    label132:
    for (this.iYM = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.aSV().aSR();; this.iYM = locala.aTa())
    {
      locala.b(this.iYM);
      if (this.iYM == null) {
        this.iYM = locala;
      }
      AppMethodBeat.o(144850);
      return;
      this.iYL = locala.aTa();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */