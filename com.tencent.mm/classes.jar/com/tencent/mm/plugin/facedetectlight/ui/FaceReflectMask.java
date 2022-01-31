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
  private Paint mqQ;
  private Paint mqR;
  private PorterDuffXfermode mqS;
  public boolean mqT;
  public boolean msf;
  private Rect rect;
  
  public FaceReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(803);
    this.rect = new Rect();
    this.mqT = false;
    this.mqQ = new Paint(1);
    this.mqQ.setStyle(Paint.Style.FILL);
    this.mqR = new Paint(1);
    this.mColorMatrixColorFilter = ReflectController.DEFAULT_MATRIX_COLOR_FILTER;
    setWillNotDraw(false);
    this.mqS = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.msf = true;
    setLayerType(1, null);
    AppMethodBeat.o(803);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(805);
    paramCanvas.save();
    float f1 = (float)(getWidth() * 0.35D);
    float f2 = (float)(getWidth() * 0.5D);
    float f3 = (float)(getHeight() * 0.4D);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    if (this.msf)
    {
      this.mqQ.setColor(-16777216);
      this.msf = false;
    }
    for (;;)
    {
      paramCanvas.drawARGB(255, 0, 0, 0);
      paramCanvas.drawRect(this.rect, this.mqQ);
      if (!this.mqT)
      {
        this.mqR.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mqR.setXfermode(this.mqS);
        paramCanvas.drawCircle(f2, f3, f1, this.mqR);
      }
      paramCanvas.restore();
      AppMethodBeat.o(805);
      return;
      this.mqQ.setColor(-16777216);
      this.mqQ.setColorFilter(this.mColorMatrixColorFilter);
    }
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(804);
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    invalidate();
    AppMethodBeat.o(804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask
 * JD-Core Version:    0.7.0.1
 */