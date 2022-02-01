package com.pay.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import midas.x.gx;

public class APTypegifView
  extends View
  implements Runnable
{
  static Bitmap a;
  gx b;
  int c;
  
  public APTypegifView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public APTypegifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(int paramInt)
  {
    return this.b.b();
  }
  
  private int b(int paramInt)
  {
    return this.b.c();
  }
  
  public void a() {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(a, 0.0F, 0.0F, new Paint());
    a = this.b.e();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(200L);
        postInvalidate();
      }
    }
    catch (Exception localException) {}
  }
  
  public void setDelta(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSrc(int paramInt)
  {
    this.b = gx.a();
    this.b.a(getResources().openRawResource(paramInt));
    a = this.b.a(0);
    new Thread(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APTypegifView
 * JD-Core Version:    0.7.0.1
 */