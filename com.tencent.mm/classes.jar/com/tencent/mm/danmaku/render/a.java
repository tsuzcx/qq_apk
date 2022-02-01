package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<D extends com.tencent.mm.danmaku.b.a>
{
  private ArrayList<Object> gPT;
  
  private void atc()
  {
    if (this.gPT != null)
    {
      Iterator localIterator = this.gPT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
  
  public final void a(Canvas paramCanvas, D paramD, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramFloat1, paramFloat2);
    atc();
  }
  
  public abstract void b(Canvas paramCanvas, D paramD, float paramFloat1, float paramFloat2);
  
  public abstract boolean f(com.tencent.mm.danmaku.b.a parama);
  
  public abstract com.tencent.mm.danmaku.e.a g(D paramD);
  
  public void h(D paramD) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.a
 * JD-Core Version:    0.7.0.1
 */