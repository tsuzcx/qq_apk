package com.pay.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import midas.x.b7;

public class APTypegifView
  extends View
  implements Runnable
{
  public static Bitmap b;
  public b7 a;
  
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
  
  public final int a(int paramInt)
  {
    return this.a.c();
  }
  
  public void a() {}
  
  public final int b(int paramInt)
  {
    return this.a.d();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(b, 0.0F, 0.0F, new Paint());
    b = this.a.f();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(b(paramInt1), a(paramInt2));
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
  
  public void setDelta(int paramInt) {}
  
  public void setSrc(int paramInt)
  {
    this.a = b7.s();
    this.a.a(getResources().openRawResource(paramInt));
    b = this.a.a(0);
    new Thread(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APTypegifView
 * JD-Core Version:    0.7.0.1
 */