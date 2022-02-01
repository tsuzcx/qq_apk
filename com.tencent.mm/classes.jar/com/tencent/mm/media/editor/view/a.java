package com.tencent.mm.media.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-mediaeditor_release"})
public final class a
  extends Drawable
{
  private final Resources aIP;
  private float gQE;
  private final float gQF;
  private final float gQG;
  private final float gQH;
  private final Paint paint;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(93616);
    this.aIP = paramResources;
    this.gQE = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.aIP.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.gQG = this.aIP.getDimension(2131166188);
    this.gQH = this.aIP.getDimension(2131166186);
    this.gQF = this.aIP.getDimension(2131166187);
    AppMethodBeat.o(93616);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(93615);
    k.h(paramCanvas, "canvas");
    float f1 = getBounds().left - this.gQH / this.gQE;
    float f2 = getBounds().top - this.gQH / this.gQE;
    float f3 = getBounds().right + this.gQH / this.gQE;
    float f4 = getBounds().bottom + this.gQH / this.gQE;
    this.paint.setStrokeWidth(this.gQG / this.gQE);
    this.paint.setAntiAlias(true);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(93615);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.view.a
 * JD-Core Version:    0.7.0.1
 */