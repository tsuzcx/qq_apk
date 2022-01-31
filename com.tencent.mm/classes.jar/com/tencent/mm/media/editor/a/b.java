package com.tencent.mm.media.editor.a;

import a.l;
import android.graphics.Canvas;
import android.graphics.Paint;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "", "()V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
public abstract class b
{
  long eSz;
  
  public abstract long UG();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public long gk(long paramLong)
  {
    while (this.eSz <= paramLong) {
      this.eSz += UG();
    }
    this.eSz -= paramLong;
    return this.eSz;
  }
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.b
 * JD-Core Version:    0.7.0.1
 */