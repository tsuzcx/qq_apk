package com.tencent.mm.media.editor.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-mediaeditor_release"})
public abstract class b
{
  public Matrix dY;
  long goC;
  
  public b(Matrix paramMatrix)
  {
    this.dY = paramMatrix;
  }
  
  public abstract long ajy();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public abstract void init();
  
  public long lz(long paramLong)
  {
    while (this.goC <= paramLong) {
      this.goC += ajy();
    }
    this.goC -= paramLong;
    return this.goC;
  }
  
  public void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.b
 * JD-Core Version:    0.7.0.1
 */