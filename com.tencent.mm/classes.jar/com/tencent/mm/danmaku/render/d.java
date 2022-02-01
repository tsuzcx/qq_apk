package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.View.OnTouchListener;

public abstract interface d
{
  public abstract void a(d.a parama);
  
  public abstract void a(d.b paramb);
  
  public abstract float atd();
  
  public abstract Canvas lockCanvas();
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void unlock();
  
  public abstract void unlockCanvasAndPost(Canvas paramCanvas);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.d
 * JD-Core Version:    0.7.0.1
 */