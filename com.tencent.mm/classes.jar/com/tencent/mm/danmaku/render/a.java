package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<D extends com.tencent.mm.danmaku.b.a>
{
  private ArrayList<Object> jAm;
  
  private void azP()
  {
    if (this.jAm != null)
    {
      Iterator localIterator = this.jAm.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
  
  public final void a(Canvas paramCanvas, D paramD, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramFloat1, paramFloat2);
    azP();
  }
  
  public abstract void b(Canvas paramCanvas, D paramD, float paramFloat1, float paramFloat2);
  
  public abstract boolean e(com.tencent.mm.danmaku.b.a parama);
  
  public abstract com.tencent.mm.danmaku.e.a f(D paramD);
  
  public void g(D paramD) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.a
 * JD-Core Version:    0.7.0.1
 */