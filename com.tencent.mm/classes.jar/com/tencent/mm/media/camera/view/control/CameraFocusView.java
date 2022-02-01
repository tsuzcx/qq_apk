package com.tencent.mm.media.camera.view.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CameraFocusView
  extends View
{
  public int mHeight;
  Paint mPaint;
  int mStrokeWidth;
  public int mWidth;
  boolean nxb;
  boolean nxc;
  boolean nxd;
  boolean nxe;
  long nxf;
  int nxg;
  int nxh;
  ViewGroup.LayoutParams nxi;
  
  public CameraFocusView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237224);
    this.mPaint = new Paint();
    this.nxb = false;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = 0L;
    AppMethodBeat.o(237224);
  }
  
  public CameraFocusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237221);
    this.mPaint = new Paint();
    this.nxb = false;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = 0L;
    AppMethodBeat.o(237221);
  }
  
  public CameraFocusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237217);
    this.mPaint = new Paint();
    this.nxb = false;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = 0L;
    AppMethodBeat.o(237217);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237246);
    paramCanvas.translate(this.nxg / 2, this.nxh / 2);
    long l = System.currentTimeMillis() - this.nxf;
    if (l > 200L)
    {
      this.nxb = false;
      this.nxc = true;
    }
    if (l > 800L)
    {
      this.nxc = false;
      this.nxd = true;
    }
    if (l > 1100L)
    {
      this.nxd = false;
      this.nxe = true;
    }
    if (l > 1300L)
    {
      this.nxe = false;
      paramCanvas.drawColor(0);
      AppMethodBeat.o(237246);
      return;
    }
    float f;
    if (this.nxb)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.nxg / 2, this.nxh / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.nxc) {
        break label490;
      }
      f = (float)((l - 200L) % 200L) / 200.0F * 2.0F;
      Paint localPaint = this.mPaint;
      if (f <= 1.0F) {
        break label483;
      }
      f -= 1.0F;
      label202:
      localPaint.setAlpha((int)(f * 128.0F + 127.0F));
    }
    for (;;)
    {
      if (this.nxe)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.nxg, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.nxh, this.mPaint);
      paramCanvas.drawLine(this.nxg, 0.0F, this.nxg, this.nxh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.nxh, this.nxg, this.nxh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.nxh / 2, this.nxg / 10, this.nxh / 2, this.mPaint);
      paramCanvas.drawLine(this.nxg, this.nxh / 2, this.nxg * 9 / 10, this.nxh / 2, this.mPaint);
      paramCanvas.drawLine(this.nxg / 2, 0.0F, this.nxg / 2, this.nxh / 10, this.mPaint);
      paramCanvas.drawLine(this.nxg / 2, this.nxh, this.nxg / 2, this.nxh * 9 / 10, this.mPaint);
      invalidate();
      AppMethodBeat.o(237246);
      return;
      paramCanvas.scale(1.0F, 1.0F);
      break;
      label483:
      f = 1.0F - f;
      break label202;
      label490:
      this.mPaint.setAlpha(255);
    }
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(237231);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(237231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.control.CameraFocusView
 * JD-Core Version:    0.7.0.1
 */