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
import com.tencent.mm.sdk.platformtools.ad;

public class GyroView
  extends View
{
  private float auQ;
  private Paint mPaint;
  private float ncA;
  private float ncB;
  private float ncC;
  private float ncD;
  private boolean ncE;
  private float ncy;
  private float ncz;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(153231);
    this.ncy = 0.0F;
    this.ncz = 0.0F;
    this.ncE = false;
    init();
    AppMethodBeat.o(153231);
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153232);
    this.ncy = 0.0F;
    this.ncz = 0.0F;
    this.ncE = false;
    init();
    AppMethodBeat.o(153232);
  }
  
  private void init()
  {
    AppMethodBeat.i(153233);
    this.ncB = (40.0F * getResources().getDisplayMetrics().density);
    this.ncA = (100.0F * getResources().getDisplayMetrics().density);
    this.auQ = (20.0F * getResources().getDisplayMetrics().density);
    this.ncC = (10.0F * getResources().getDisplayMetrics().density);
    this.ncD = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(153233);
  }
  
  public final void b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(153236);
    float f2 = (paramFloat - this.ncB) / (paramInt - this.ncB);
    float f1 = f2;
    if (this.ncE) {
      f1 = 1.0F - f2;
    }
    this.ncz = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.ncB;
    f1 = f2;
    if (this.ncE) {
      f1 = 1.0F - f2;
    }
    this.ncy = Math.max(0.0F, Math.min(f1, 1.0F));
    ad.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.ncy), Float.valueOf(this.ncz) });
    postInvalidate();
    AppMethodBeat.o(153236);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(153234);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.ncz > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.ncC / 2.0F - this.ncz * (this.ncC - this.ncD) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.ncz * this.auQ, f2, this.ncD / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.ncz * this.auQ, f2, this.ncD / 2.0F, this.mPaint);
      AppMethodBeat.o(153234);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.ncy * this.ncC / 2.0F, this.mPaint);
    AppMethodBeat.o(153234);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(153235);
    float f2 = (paramFloat - this.ncB) / (this.ncA - this.ncB);
    float f1 = f2;
    if (this.ncE) {
      f1 = 1.0F - f2;
    }
    this.ncz = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.ncB;
    paramFloat = f1;
    if (this.ncE) {
      paramFloat = 1.0F - f1;
    }
    this.ncy = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(153235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */