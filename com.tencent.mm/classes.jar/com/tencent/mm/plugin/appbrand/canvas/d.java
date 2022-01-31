package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Stack;

public final class d
  implements a
{
  public c bDN;
  public final v.b eGu;
  public com.tencent.mm.plugin.appbrand.canvas.a.a heB;
  public com.tencent.mm.plugin.appbrand.canvas.a.a heC;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> heD;
  private Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> heE;
  public Paint heF;
  public Paint heG;
  public e heH;
  private a heI;
  boolean heJ;
  
  public d(a parama)
  {
    AppMethodBeat.i(103165);
    this.heF = new Paint();
    this.eGu = new v.b();
    this.heJ = true;
    this.heI = parama;
    if (this.heJ)
    {
      parama = i.ayg().axY();
      this.heB = parama;
      if (!this.heJ) {
        break label196;
      }
    }
    label196:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.ayc().axY();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.heC = parama;
      this.heB.setStyle(Paint.Style.STROKE);
      this.heC.setStyle(Paint.Style.FILL);
      this.heB.setAntiAlias(true);
      this.heC.setAntiAlias(true);
      this.heB.setStrokeWidth(g.pO(1));
      this.heC.setStrokeWidth(g.pO(1));
      this.heD = new Stack();
      this.heE = new Stack();
      this.heF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      AppMethodBeat.o(103165);
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(103169);
    this.heI.invalidate();
    AppMethodBeat.o(103169);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103166);
    this.heD.clear();
    this.heE.clear();
    this.heB.reset();
    this.heC.reset();
    this.heB.setStyle(Paint.Style.STROKE);
    this.heC.setStyle(Paint.Style.FILL);
    this.heB.setAntiAlias(true);
    this.heC.setAntiAlias(true);
    this.heB.setStrokeWidth(g.pO(1));
    this.heC.setStrokeWidth(g.pO(1));
    AppMethodBeat.o(103166);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(103168);
    if (this.heD.isEmpty())
    {
      AppMethodBeat.o(103168);
      return;
    }
    com.tencent.mm.plugin.appbrand.canvas.a.a locala1 = this.heB;
    com.tencent.mm.plugin.appbrand.canvas.a.a locala2 = this.heC;
    this.heB = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.heD.pop());
    this.heC = ((com.tencent.mm.plugin.appbrand.canvas.a.a)this.heE.pop());
    if (this.heJ)
    {
      if (this.heB != locala1) {
        i.ayg().a(locala1);
      }
      if (this.heC != locala2) {
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.ayc().a(locala2);
      }
    }
    AppMethodBeat.o(103168);
  }
  
  public final void save()
  {
    AppMethodBeat.i(103167);
    com.tencent.mm.plugin.appbrand.canvas.a.a locala = this.heB;
    this.heD.push(this.heB);
    if (this.heJ)
    {
      this.heB = i.ayg().axY();
      locala.b(this.heB);
      if (this.heB == null) {
        this.heB = locala;
      }
      locala = this.heC;
      this.heE.push(this.heC);
      if (!this.heJ) {
        break label132;
      }
    }
    label132:
    for (this.heC = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.ayc().axY();; this.heC = locala.ayh())
    {
      locala.b(this.heC);
      if (this.heC == null) {
        this.heC = locala;
      }
      AppMethodBeat.o(103167);
      return;
      this.heB = locala.ayh();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */