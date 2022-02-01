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
import com.tencent.mm.sdk.platformtools.ae;

public class GyroView
  extends View
{
  private float auQ;
  private Paint mPaint;
  private float nhH;
  private float nhI;
  private float nhJ;
  private float nhK;
  private float nhL;
  private float nhM;
  private boolean nhN;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(153231);
    this.nhH = 0.0F;
    this.nhI = 0.0F;
    this.nhN = false;
    init();
    AppMethodBeat.o(153231);
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153232);
    this.nhH = 0.0F;
    this.nhI = 0.0F;
    this.nhN = false;
    init();
    AppMethodBeat.o(153232);
  }
  
  private void init()
  {
    AppMethodBeat.i(153233);
    this.nhK = (40.0F * getResources().getDisplayMetrics().density);
    this.nhJ = (100.0F * getResources().getDisplayMetrics().density);
    this.auQ = (20.0F * getResources().getDisplayMetrics().density);
    this.nhL = (10.0F * getResources().getDisplayMetrics().density);
    this.nhM = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(153233);
  }
  
  public final void b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(153236);
    float f2 = (paramFloat - this.nhK) / (paramInt - this.nhK);
    float f1 = f2;
    if (this.nhN) {
      f1 = 1.0F - f2;
    }
    this.nhI = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.nhK;
    f1 = f2;
    if (this.nhN) {
      f1 = 1.0F - f2;
    }
    this.nhH = Math.max(0.0F, Math.min(f1, 1.0F));
    ae.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.nhH), Float.valueOf(this.nhI) });
    postInvalidate();
    AppMethodBeat.o(153236);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(153234);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.nhI > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.nhL / 2.0F - this.nhI * (this.nhL - this.nhM) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.nhI * this.auQ, f2, this.nhM / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.nhI * this.auQ, f2, this.nhM / 2.0F, this.mPaint);
      AppMethodBeat.o(153234);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.nhH * this.nhL / 2.0F, this.mPaint);
    AppMethodBeat.o(153234);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(153235);
    float f2 = (paramFloat - this.nhK) / (this.nhJ - this.nhK);
    float f1 = f2;
    if (this.nhN) {
      f1 = 1.0F - f2;
    }
    this.nhI = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.nhK;
    paramFloat = f1;
    if (this.nhN) {
      paramFloat = 1.0F - f1;
    }
    this.nhH = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(153235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */