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
  private final int b = 18;
  private Context c;
  private int d;
  private int e;
  private int f;
  private Paint g;
  private Paint h;
  private Path i;
  private SparseArray<RectF> j;
  private boolean[] k = new boolean[4];
  private boolean l = false;
  
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
  
  private RectF a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 += paramInt1;
    RectF localRectF2 = (RectF)this.j.get(paramInt3);
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      localRectF1 = new RectF(0.0F, paramInt1, paramInt2, paramInt3);
      this.j.put(paramInt3, localRectF1);
    }
    return localRectF1;
  }
  
  private void b(Context paramContext)
  {
    this.c = paramContext;
    paramContext = this.k;
    boolean[] arrayOfBoolean1 = this.k;
    boolean[] arrayOfBoolean2 = this.k;
    this.k[3] = false;
    arrayOfBoolean2[2] = false;
    arrayOfBoolean1[1] = false;
    paramContext[0] = 0;
    this.f = a(this.c, 5);
    this.g = i();
    this.h = j();
    this.j = new SparseArray();
    this.i = new Path();
    this.i.setFillType(Path.FillType.INVERSE_WINDING);
    setLayerType(1, null);
    if ((Build.VERSION.SDK_INT < 18) && (Build.VERSION.SDK_INT >= 11) && (h()))
    {
      this.l = true;
      setLayerType(1, null);
    }
  }
  
  private boolean getShouldBeRounded()
  {
    boolean[] arrayOfBoolean = this.k;
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
  
  public static boolean h()
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
  
  private Paint i()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#dd000000"));
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    return localPaint;
  }
  
  private Paint j()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(0);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return localPaint;
  }
  
  public final int a(Context paramContext, int paramInt)
  {
    return (int)(paramInt * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if (getShouldBeRounded())
    {
      this.i.reset();
      this.i.setFillType(Path.FillType.INVERSE_WINDING);
      paramView = new float[8];
      int m = 0;
      while (m < this.k.length)
      {
        int n;
        if (this.k[m] != 0)
        {
          n = m * 2;
          float f1 = this.f;
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
      this.i.addRoundRect(a(getScrollY(), this.d, this.e), paramView, Path.Direction.CW);
      paramCanvas.drawPath(this.i, this.h);
      if (!this.l) {
        paramCanvas.drawPath(this.i, this.g);
      }
    }
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getShouldBeRounded())
    {
      this.d = paramInt1;
      this.e = paramInt2;
    }
  }
  
  public void setShouldBeRounded(int paramInt)
  {
    paramInt &= 0xF;
    boolean[] arrayOfBoolean = this.k;
    int n = 0;
    if ((paramInt & 0x1) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[0] = m;
    arrayOfBoolean = this.k;
    if ((paramInt & 0x2) == 2) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[1] = m;
    arrayOfBoolean = this.k;
    if ((paramInt & 0x4) == 4) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[2] = m;
    arrayOfBoolean = this.k;
    int m = n;
    if ((paramInt & 0x8) == 8) {
      m = 1;
    }
    arrayOfBoolean[3] = m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APX5RoundedWebView
 * JD-Core Version:    0.7.0.1
 */