package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/BitmapArrayEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
public final class c
  extends b
{
  private int goD;
  private final List<Bitmap> goE;
  private final long goF;
  
  public c(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93561);
    this.goF = 100L;
    this.goE = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.goE.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(93561);
  }
  
  public final long ajy()
  {
    AppMethodBeat.i(93560);
    if (this.goE.isEmpty())
    {
      AppMethodBeat.o(93560);
      return 9223372036854775807L;
    }
    this.goD += 1;
    this.goD %= ((Collection)this.goE).size();
    long l = this.goF;
    AppMethodBeat.o(93560);
    return l;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93559);
    k.h(paramCanvas, "canvas");
    k.h(paramPaint, "paint");
    if (this.goE.isEmpty())
    {
      AppMethodBeat.o(93559);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.goE.get(this.goD);
    paramCanvas.save();
    paramCanvas.concat(this.dY);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(93559);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.c
 * JD-Core Version:    0.7.0.1
 */