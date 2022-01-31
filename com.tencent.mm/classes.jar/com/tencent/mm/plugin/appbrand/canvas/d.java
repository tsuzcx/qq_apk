package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Stack;

public final class d
  implements a
{
  public final u.b dIV = new u.b();
  public com.tencent.mm.plugin.appbrand.canvas.a.a fLp;
  public com.tencent.mm.plugin.appbrand.canvas.a.a fLq;
  public Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> fLr;
  public Stack<com.tencent.mm.plugin.appbrand.canvas.a.a> fLs;
  public Paint fLt = new Paint();
  public Paint fLu;
  public e fLv;
  private a fLw;
  public c fLx;
  public boolean fLy = true;
  
  public d(a parama)
  {
    this.fLw = parama;
    if (this.fLy)
    {
      parama = i.adO().adG();
      this.fLp = parama;
      if (!this.fLy) {
        break label186;
      }
    }
    label186:
    for (parama = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e.adK().adG();; parama = new com.tencent.mm.plugin.appbrand.canvas.a.a())
    {
      this.fLq = parama;
      this.fLp.setStyle(Paint.Style.STROKE);
      this.fLq.setStyle(Paint.Style.FILL);
      this.fLp.setAntiAlias(true);
      this.fLq.setAntiAlias(true);
      this.fLp.setStrokeWidth(h.my(1));
      this.fLq.setStrokeWidth(h.my(1));
      this.fLr = new Stack();
      this.fLs = new Stack();
      this.fLt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      return;
      parama = new com.tencent.mm.plugin.appbrand.canvas.a.a();
      break;
    }
  }
  
  public final void invalidate()
  {
    this.fLw.invalidate();
  }
  
  public final void reset()
  {
    this.fLr.clear();
    this.fLs.clear();
    this.fLp.reset();
    this.fLq.reset();
    this.fLp.setStyle(Paint.Style.STROKE);
    this.fLq.setStyle(Paint.Style.FILL);
    this.fLp.setAntiAlias(true);
    this.fLq.setAntiAlias(true);
    this.fLp.setStrokeWidth(h.my(1));
    this.fLq.setStrokeWidth(h.my(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.d
 * JD-Core Version:    0.7.0.1
 */