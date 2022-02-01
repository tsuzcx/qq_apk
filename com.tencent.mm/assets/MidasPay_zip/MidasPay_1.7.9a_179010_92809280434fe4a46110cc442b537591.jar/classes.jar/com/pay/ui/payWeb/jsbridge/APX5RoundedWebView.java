package com.pay.ui.payWeb.jsbridge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APX5RoundedWebView
  extends WebView
{
  public Context b;
  public int c;
  public int d;
  public int e;
  public Paint f;
  public Paint g;
  public Path h;
  public SparseArray<RectF> i;
  public boolean[] j = new boolean[4];
  public boolean k = false;
  
  public APX5RoundedWebView(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public APX5RoundedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public APX5RoundedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private boolean getShouldBeRounded()
  {
    boolean[] arrayOfBoolean = this.j;
    int n = arrayOfBoolean.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfBoolean[m] != 0) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  public static boolean j()
  {
    Object localObject = new Properties();
    boolean bool = false;
    try
    {
      ((Properties)localObject).load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
      if ((((Properties)localObject).getProperty("ro.miui.ui.version.code", null) == null) && (((Properties)localObject).getProperty("ro.miui.ui.version.name", null) == null))
      {
        localObject = ((Properties)localObject).getProperty("ro.miui.internal.storage", null);
        if (localObject == null) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  public final int a(Context paramContext, int paramInt)
  {
    return (int)(paramInt * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public final RectF a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 += paramInt1;
    RectF localRectF2 = (RectF)this.i.get(paramInt3);
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      localRectF1 = new RectF(0.0F, paramInt1, paramInt2, paramInt3);
      this.i.put(paramInt3, localRectF1);
    }
    return localRectF1;
  }
  
  public final void b(Context paramContext)
  {
    this.b = paramContext;
    paramContext = this.j;
    paramContext[3] = 0;
    paramContext[2] = 0;
    paramContext[1] = 0;
    paramContext[0] = 0;
    this.e = a(this.b, 5);
    this.f = h();
    this.g = i();
    this.i = new SparseArray();
    this.h = new Path();
    this.h.setFillType(Path.FillType.INVERSE_WINDING);
    setLayerType(1, null);
    int m = Build.VERSION.SDK_INT;
    if ((m < 18) && (m >= 11) && (j()))
    {
      this.k = true;
      setLayerType(1, null);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if (getShouldBeRounded())
    {
      this.h.reset();
      this.h.setFillType(Path.FillType.INVERSE_WINDING);
      paramView = new float[8];
      int m = 0;
      for (;;)
      {
        boolean[] arrayOfBoolean = this.j;
        if (m >= arrayOfBoolean.length) {
          break;
        }
        int n;
        if (arrayOfBoolean[m] != 0)
        {
          n = m * 2;
          float f1 = this.e;
          paramView[(n + 1)] = f1;
          paramView[n] = f1;
        }
        else
        {
          n = m * 2;
          paramView[(n + 1)] = 0.0F;
          paramView[n] = 0.0F;
        }
        m += 1;
      }
      this.h.addRoundRect(a(getScrollY(), this.c, this.d), paramView, Path.Direction.CW);
      paramCanvas.drawPath(this.h, this.g);
      if (!this.k) {
        paramCanvas.drawPath(this.h, this.f);
      }
    }
    return bool;
  }
  
  public final Paint h()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#dd000000"));
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    return localPaint;
  }
  
  public final Paint i()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(0);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return localPaint;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getShouldBeRounded())
    {
      this.c = paramInt1;
      this.d = paramInt2;
    }
  }
  
  public void setShouldBeRounded(int paramInt)
  {
    paramInt &= 0xF;
    boolean[] arrayOfBoolean = this.j;
    int n = 0;
    if ((paramInt & 0x1) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[0] = m;
    arrayOfBoolean = this.j;
    if ((paramInt & 0x2) == 2) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[1] = m;
    arrayOfBoolean = this.j;
    if ((paramInt & 0x4) == 4) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[2] = m;
    arrayOfBoolean = this.j;
    int m = n;
    if ((paramInt & 0x8) == 8) {
      m = 1;
    }
    arrayOfBoolean[3] = m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APX5RoundedWebView
 * JD-Core Version:    0.7.0.1
 */