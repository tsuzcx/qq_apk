package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceReflectMask
  extends YTReflectLayout
{
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private Paint qFZ;
  private Paint qGa;
  private PorterDuffXfermode qGb;
  public boolean qGc;
  public boolean qHs;
  private Rect rect;
  
  public FaceReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104323);
    this.rect = new Rect();
    this.qGc = false;
    this.qFZ = new Paint(1);
    this.qFZ.setStyle(Paint.Style.FILL);
    this.qGa = new Paint(1);
    this.mColorMatrixColorFilter = ReflectController.DEFAULT_MATRIX_COLOR_FILTER;
    setWillNotDraw(false);
    this.qGb = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.qHs = true;
    setLayerType(1, null);
    AppMethodBeat.o(104323);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104325);
    paramCanvas.save();
    float f1 = (float)(getWidth() * 0.35D);
    float f2 = (float)(getWidth() * 0.5D);
    float f3 = (float)(getHeight() * 0.4D);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    if (this.qHs)
    {
      this.qFZ.setColor(-16777216);
      this.qHs = false;
    }
    for (;;)
    {
      paramCanvas.drawARGB(255, 0, 0, 0);
      paramCanvas.drawRect(this.rect, this.qFZ);
      if (!this.qGc)
      {
        this.qGa.setStyle(Paint.Style.FILL_AND_STROKE);
        this.qGa.setXfermode(this.qGb);
        paramCanvas.drawCircle(f2, f3, f1, this.qGa);
      }
      paramCanvas.restore();
      AppMethodBeat.o(104325);
      return;
      this.qFZ.setColor(-16777216);
      this.qFZ.setColorFilter(this.mColorMatrixColorFilter);
    }
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(104324);
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    invalidate();
    AppMethodBeat.o(104324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask
 * JD-Core Version:    0.7.0.1
 */