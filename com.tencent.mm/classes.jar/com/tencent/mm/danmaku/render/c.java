package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.d;

public final class c
  extends a
{
  private TextPaint wi;
  
  public c()
  {
    AppMethodBeat.i(280747);
    this.wi = new TextPaint();
    AppMethodBeat.o(280747);
  }
  
  public final void b(Canvas paramCanvas, com.tencent.mm.danmaku.b.a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280749);
    m localm = com.tencent.mm.danmaku.c.a.azC();
    this.wi.setTextSize(localm.jAg);
    this.wi.setColor(-1);
    paramCanvas.drawText(String.valueOf(parama.mData), localm.jAj + paramFloat1, localm.jAi + paramFloat2 - this.wi.ascent(), this.wi);
    AppMethodBeat.o(280749);
  }
  
  public final boolean e(com.tencent.mm.danmaku.b.a parama)
  {
    return true;
  }
  
  public final com.tencent.mm.danmaku.e.a f(com.tencent.mm.danmaku.b.a parama)
  {
    AppMethodBeat.i(280748);
    m localm = com.tencent.mm.danmaku.c.a.azC();
    float f1 = d.a(localm.jAg, String.valueOf(parama.mData)) + localm.jAj + localm.jAj;
    float f2 = d.ao(localm.jAg);
    f2 = localm.jAi * 2.0F + f2;
    parama.jzw = f2;
    parama.jzv = f1;
    parama = new com.tencent.mm.danmaku.e.a(f1, f2);
    AppMethodBeat.o(280748);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.c
 * JD-Core Version:    0.7.0.1
 */