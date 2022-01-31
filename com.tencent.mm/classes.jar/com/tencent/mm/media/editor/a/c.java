package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/BitmapArrayEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
public final class c
  extends b
{
  private final Matrix asO;
  private final List<Bitmap> bitmaps;
  private int eSA;
  private final long eSB;
  
  public c(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    AppMethodBeat.i(12877);
    this.eSB = 100L;
    this.asO = paramMatrix;
    this.bitmaps = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.bitmaps.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(12877);
  }
  
  public final long UG()
  {
    AppMethodBeat.i(12876);
    if (this.bitmaps.isEmpty())
    {
      AppMethodBeat.o(12876);
      return 9223372036854775807L;
    }
    this.eSA += 1;
    this.eSA %= ((Collection)this.bitmaps).size();
    long l = this.eSB;
    AppMethodBeat.o(12876);
    return l;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(12875);
    j.q(paramCanvas, "canvas");
    j.q(paramPaint, "paint");
    if (this.bitmaps.isEmpty())
    {
      AppMethodBeat.o(12875);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.bitmaps.get(this.eSA);
    paramCanvas.save();
    paramCanvas.concat(this.asO);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(12875);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.c
 * JD-Core Version:    0.7.0.1
 */