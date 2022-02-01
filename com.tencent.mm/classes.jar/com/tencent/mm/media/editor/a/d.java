package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/BitmapEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-mediaeditor_release"})
public final class d
  extends b
{
  private Bitmap bitmap;
  
  public d(Bitmap paramBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93563);
    this.bitmap = paramBitmap;
    AppMethodBeat.o(93563);
  }
  
  public final long ajy()
  {
    return 9223372036854775807L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93562);
    k.h(paramCanvas, "canvas");
    k.h(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.dY);
    paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(93562);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.d
 * JD-Core Version:    0.7.0.1
 */