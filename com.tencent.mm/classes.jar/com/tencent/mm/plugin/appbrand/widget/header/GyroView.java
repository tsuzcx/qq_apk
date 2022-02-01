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
import com.tencent.mm.sdk.platformtools.ac;

public class GyroView
  extends View
{
  private float asZ;
  private float mBY;
  private float mBZ;
  private float mCa;
  private float mCb;
  private float mCc;
  private float mCd;
  private boolean mCe;
  private Paint mPaint;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(153231);
    this.mBY = 0.0F;
    this.mBZ = 0.0F;
    this.mCe = false;
    init();
    AppMethodBeat.o(153231);
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153232);
    this.mBY = 0.0F;
    this.mBZ = 0.0F;
    this.mCe = false;
    init();
    AppMethodBeat.o(153232);
  }
  
  private void init()
  {
    AppMethodBeat.i(153233);
    this.mCb = (40.0F * getResources().getDisplayMetrics().density);
    this.mCa = (100.0F * getResources().getDisplayMetrics().density);
    this.asZ = (20.0F * getResources().getDisplayMetrics().density);
    this.mCc = (10.0F * getResources().getDisplayMetrics().density);
    this.mCd = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(153233);
  }
  
  public final void b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(153236);
    float f2 = (paramFloat - this.mCb) / (paramInt - this.mCb);
    float f1 = f2;
    if (this.mCe) {
      f1 = 1.0F - f2;
    }
    this.mBZ = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.mCb;
    f1 = f2;
    if (this.mCe) {
      f1 = 1.0F - f2;
    }
    this.mBY = Math.max(0.0F, Math.min(f1, 1.0F));
    ac.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.mBY), Float.valueOf(this.mBZ) });
    postInvalidate();
    AppMethodBeat.o(153236);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(153234);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.mBZ > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.mCc / 2.0F - this.mBZ * (this.mCc - this.mCd) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.mBZ * this.asZ, f2, this.mCd / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.mBZ * this.asZ, f2, this.mCd / 2.0F, this.mPaint);
      AppMethodBeat.o(153234);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.mBY * this.mCc / 2.0F, this.mPaint);
    AppMethodBeat.o(153234);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(153235);
    float f2 = (paramFloat - this.mCb) / (this.mCa - this.mCb);
    float f1 = f2;
    if (this.mCe) {
      f1 = 1.0F - f2;
    }
    this.mBZ = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.mCb;
    paramFloat = f1;
    if (this.mCe) {
      paramFloat = 1.0F - f1;
    }
    this.mBY = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(153235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */