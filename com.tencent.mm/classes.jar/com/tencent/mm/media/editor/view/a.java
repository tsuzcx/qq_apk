package com.tencent.mm.media.editor.view;

import a.f.b.j;
import a.l;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-mediaeditor_release"})
public final class a
  extends Drawable
{
  private float eTS;
  private final float eTT;
  private final float eTU;
  private final float eTV;
  private final Resources eTW;
  private final Paint paint;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(12925);
    this.eTW = paramResources;
    this.eTS = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.eTW.getDimension(2131428336));
    this.paint.setStyle(Paint.Style.FILL);
    this.eTU = this.eTW.getDimension(2131428336);
    this.eTV = this.eTW.getDimension(2131428334);
    this.eTT = this.eTW.getDimension(2131428335);
    AppMethodBeat.o(12925);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12924);
    j.q(paramCanvas, "canvas");
    float f1 = getBounds().left - this.eTV / this.eTS;
    float f2 = getBounds().top - this.eTV / this.eTS;
    float f3 = getBounds().right + this.eTV / this.eTS;
    float f4 = getBounds().bottom + this.eTV / this.eTS;
    float f5 = this.eTT / 2.0F / this.eTS;
    this.paint.setStrokeWidth(this.eTU / this.eTS);
    this.paint.setAntiAlias(true);
    paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
    paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
    paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
    paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(12924);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.editor.view.a
 * JD-Core Version:    0.7.0.1
 */