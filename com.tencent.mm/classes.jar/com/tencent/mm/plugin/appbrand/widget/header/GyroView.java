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
  private float ase;
  private float lZX;
  private float lZY;
  private float lZZ;
  private Paint mPaint;
  private float maa;
  private float mab;
  private float mad;
  private boolean mae;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(153231);
    this.lZX = 0.0F;
    this.lZY = 0.0F;
    this.mae = false;
    init();
    AppMethodBeat.o(153231);
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153232);
    this.lZX = 0.0F;
    this.lZY = 0.0F;
    this.mae = false;
    init();
    AppMethodBeat.o(153232);
  }
  
  private void init()
  {
    AppMethodBeat.i(153233);
    this.maa = (40.0F * getResources().getDisplayMetrics().density);
    this.lZZ = (100.0F * getResources().getDisplayMetrics().density);
    this.ase = (20.0F * getResources().getDisplayMetrics().density);
    this.mab = (10.0F * getResources().getDisplayMetrics().density);
    this.mad = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(153233);
  }
  
  public final void b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(153236);
    float f2 = (paramFloat - this.maa) / (paramInt - this.maa);
    float f1 = f2;
    if (this.mae) {
      f1 = 1.0F - f2;
    }
    this.lZY = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.maa;
    f1 = f2;
    if (this.mae) {
      f1 = 1.0F - f2;
    }
    this.lZX = Math.max(0.0F, Math.min(f1, 1.0F));
    ad.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.lZX), Float.valueOf(this.lZY) });
    postInvalidate();
    AppMethodBeat.o(153236);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(153234);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.lZY > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.mab / 2.0F - this.lZY * (this.mab - this.mad) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.lZY * this.ase, f2, this.mad / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.lZY * this.ase, f2, this.mad / 2.0F, this.mPaint);
      AppMethodBeat.o(153234);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.lZX * this.mab / 2.0F, this.mPaint);
    AppMethodBeat.o(153234);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(153235);
    float f2 = (paramFloat - this.maa) / (this.lZZ - this.maa);
    float f1 = f2;
    if (this.mae) {
      f1 = 1.0F - f2;
    }
    this.lZY = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.maa;
    paramFloat = f1;
    if (this.mae) {
      paramFloat = 1.0F - f1;
    }
    this.lZX = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(153235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */