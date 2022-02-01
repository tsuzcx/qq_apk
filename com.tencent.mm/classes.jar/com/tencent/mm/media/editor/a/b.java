package com.tencent.mm.media.editor.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-mediaeditor_release"})
public abstract class b
{
  public Matrix eY;
  long gPk;
  
  public b(Matrix paramMatrix)
  {
    this.eY = paramMatrix;
  }
  
  public abstract long aqx();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public abstract void init();
  
  public long pn(long paramLong)
  {
    while (this.gPk <= paramLong) {
      this.gPk += aqx();
    }
    this.gPk -= paramLong;
    return this.gPk;
  }
  
  public void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.b
 * JD-Core Version:    0.7.0.1
 */