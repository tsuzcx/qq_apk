package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class GyroView
  extends View
{
  private float akQ;
  private float jkl;
  private float jkm;
  private float jkn;
  private float jko;
  private float jkp;
  private float jkq;
  private boolean jkr;
  private Paint mPaint;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(114922);
    this.jkl = 0.0F;
    this.jkm = 0.0F;
    this.jkr = false;
    init();
    AppMethodBeat.o(114922);
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(114923);
    this.jkl = 0.0F;
    this.jkm = 0.0F;
    this.jkr = false;
    init();
    AppMethodBeat.o(114923);
  }
  
  private void init()
  {
    AppMethodBeat.i(114924);
    this.jko = (40.0F * getResources().getDisplayMetrics().density);
    this.jkn = (100.0F * getResources().getDisplayMetrics().density);
    this.akQ = (20.0F * getResources().getDisplayMetrics().density);
    this.jkp = (10.0F * getResources().getDisplayMetrics().density);
    this.jkq = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(114924);
  }
  
  public final void c(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(114927);
    float f2 = (paramFloat - this.jko) / (paramInt - this.jko);
    float f1 = f2;
    if (this.jkr) {
      f1 = 1.0F - f2;
    }
    this.jkm = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.jko;
    f1 = f2;
    if (this.jkr) {
      f1 = 1.0F - f2;
    }
    this.jkl = Math.max(0.0F, Math.min(f1, 1.0F));
    ab.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.jkl), Float.valueOf(this.jkm) });
    postInvalidate();
    AppMethodBeat.o(114927);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(114925);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.jkm > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.jkp / 2.0F - this.jkm * (this.jkp - this.jkq) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.jkm * this.akQ, f2, this.jkq / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.jkm * this.akQ, f2, this.jkq / 2.0F, this.mPaint);
      AppMethodBeat.o(114925);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.jkl * this.jkp / 2.0F, this.mPaint);
    AppMethodBeat.o(114925);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(114926);
    float f2 = (paramFloat - this.jko) / (this.jkn - this.jko);
    float f1 = f2;
    if (this.jkr) {
      f1 = 1.0F - f2;
    }
    this.jkm = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.jko;
    paramFloat = f1;
    if (this.jkr) {
      paramFloat = 1.0F - f1;
    }
    this.jkl = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(114926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */