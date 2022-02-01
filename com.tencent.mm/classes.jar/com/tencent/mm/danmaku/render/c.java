package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.d;

public final class c
  extends a
{
  private TextPaint ayn;
  
  public c()
  {
    AppMethodBeat.i(241698);
    this.ayn = new TextPaint();
    AppMethodBeat.o(241698);
  }
  
  public final void b(Canvas paramCanvas, com.tencent.mm.danmaku.b.a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(241700);
    m localm = com.tencent.mm.danmaku.c.a.asO();
    this.ayn.setTextSize(localm.gPN);
    this.ayn.setColor(-1);
    paramCanvas.drawText(String.valueOf(parama.mData), localm.gPQ + paramFloat1, localm.gPP + paramFloat2 - this.ayn.ascent(), this.ayn);
    AppMethodBeat.o(241700);
  }
  
  public final boolean f(com.tencent.mm.danmaku.b.a parama)
  {
    return true;
  }
  
  public final com.tencent.mm.danmaku.e.a g(com.tencent.mm.danmaku.b.a parama)
  {
    AppMethodBeat.i(241699);
    m localm = com.tencent.mm.danmaku.c.a.asO();
    float f1 = d.a(localm.gPN, String.valueOf(parama.mData)) + localm.gPQ + localm.gPQ;
    float f2 = d.ap(localm.gPN);
    f2 = localm.gPP * 2.0F + f2;
    parama.gPc = f2;
    parama.gPb = f1;
    parama = new com.tencent.mm.danmaku.e.a(f1, f2);
    AppMethodBeat.o(241699);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.c
 * JD-Core Version:    0.7.0.1
 */