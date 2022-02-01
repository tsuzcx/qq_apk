package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Random;
import kzg;

public class TCTransitDrawable
  extends Drawable
  implements URLDrawable.URLDrawableListener
{
  private static final int A = 3;
  private static final int B = 50;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int k = 1;
  public static final int l = 2;
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;
  private static final int x = 0;
  private static final int y = 1;
  private static final int z = 2;
  private long jdField_a_of_type_Long;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public Scroller a;
  Random jdField_a_of_type_JavaUtilRandom;
  public boolean a;
  private Matrix[] jdField_a_of_type_ArrayOfAndroidGraphicsMatrix = new Matrix[3];
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public boolean b;
  public boolean c;
  public int d;
  private boolean d;
  public int e;
  public int f;
  public int g;
  int h;
  int i;
  int j;
  private int p = 2;
  private int q;
  private int r;
  private int s;
  private int t = 0;
  private int u;
  private int v;
  private int w;
  
  public TCTransitDrawable(Context paramContext)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new kzg(this);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[0] = new Matrix();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[1] = new Matrix();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2] = new Matrix();
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.j = 0;
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new LinearInterpolator());
    a();
  }
  
  private Point a(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
    switch (this.j)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsPoint;
      if (i1 == 0)
      {
        this.j = 2;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
      }
      else if (i1 == 1)
      {
        this.j = 1;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
        continue;
        if (i1 == 1)
        {
          this.j = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
        }
        else if (i1 == 0)
        {
          this.j = 3;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
          this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
          continue;
          if (i1 == 1)
          {
            this.j = 3;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
          }
          else if (i1 == 0)
          {
            this.j = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            continue;
            if (i1 == 0)
            {
              this.j = 1;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            }
            else if (i1 == 1)
            {
              this.j = 2;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
            }
          }
        }
      }
    }
  }
  
  private Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void a(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|setDrawable|drawable = " + paramDrawable);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
      ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setURLDrawableListener(null);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) && (paramDrawable == null))
    {
      URL localURL = ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getURL();
      if (localURL != null) {
        URLDrawable.removeMemoryCacheByUrl(localURL.toString());
      }
    }
    if ((paramDrawable instanceof URLDrawable)) {
      ((URLDrawable)paramDrawable).setURLDrawableListener(this);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  private Drawable b()
  {
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void b(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  private void e()
  {
    float f5 = 0.0F;
    int i2 = this.u;
    int i3 = this.v;
    Drawable localDrawable = a();
    int i4;
    int i5;
    int i1;
    float f3;
    float f2;
    label189:
    float f1;
    float f4;
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[0];
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      i4 = localDrawable.getIntrinsicWidth();
      i5 = localDrawable.getIntrinsicHeight();
      localDrawable.setBounds(0, 0, i4, i5);
      if (((i4 < 0) || (i2 == i4)) && ((i5 < 0) || (i3 == i5))) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix = null;
        f3 = 0.0F;
        f2 = 0.0F;
        localDrawable = b();
        if (localDrawable == null) {
          break label646;
        }
        this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[1];
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        i4 = localDrawable.getIntrinsicWidth();
        i5 = localDrawable.getIntrinsicHeight();
        localDrawable.setBounds(0, 0, i4, i5);
        if (((i4 >= 0) && (i2 != i4)) || ((i5 >= 0) && (i3 != i5))) {
          break label446;
        }
        i1 = 1;
        if (i1 == 0) {
          break label452;
        }
        this.jdField_b_of_type_AndroidGraphicsMatrix = null;
        return;
      }
      if (i4 * i3 > i2 * i5)
      {
        f1 = i3 / i5;
        if (this.w == 0)
        {
          f2 = i2;
          f4 = i4;
          f3 = f1;
          f2 = (f2 - f4 * f1) * 0.5F;
          f1 = 0.0F;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f1);
      f3 = f1;
      break;
      if (this.w == 1)
      {
        f2 = 0.0F;
        f3 = f1;
        f4 = 0.0F;
        f1 = f2;
        f2 = f4;
      }
      else
      {
        f2 = f1;
        if (this.w == 2)
        {
          f2 = i2;
          f4 = i4;
          f3 = f1;
          f2 -= f4 * f1;
          f1 = 0.0F;
          continue;
          f1 = i2 / i4;
          if (this.w == 0)
          {
            f2 = (i3 - i5 * f1) * 0.5F;
            f3 = f1;
            f4 = 0.0F;
            f1 = f2;
            f2 = f4;
            continue;
          }
          if (this.w == 1)
          {
            f2 = 0.0F;
            f3 = f1;
            f4 = 0.0F;
            f1 = f2;
            f2 = f4;
            continue;
          }
          f2 = f1;
          if (this.w == 2)
          {
            f2 = i3 - i5 * f1;
            f3 = f1;
            f4 = 0.0F;
            f1 = f2;
            f2 = f4;
            continue;
            this.jdField_a_of_type_AndroidGraphicsMatrix = null;
            f3 = 0.0F;
            f2 = 0.0F;
            break;
            label446:
            i1 = 0;
            break label189;
            label452:
            if (i4 * i3 > i2 * i5)
            {
              f1 = i3 / i5;
              if (this.w == 0)
              {
                f2 = (i2 - i4 * f1) * 0.5F;
                f3 = f5;
              }
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
              this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
              return;
              if (this.w == 1)
              {
                f2 = 0.0F;
                f3 = f5;
              }
              else
              {
                f4 = f1;
                if (this.w == 2)
                {
                  f2 = i2 - i4 * f1;
                  f3 = f5;
                  continue;
                  f1 = i2 / i4;
                  if (this.w == 0)
                  {
                    f3 = i3;
                    f4 = i5;
                    f2 = 0.0F;
                    f3 = (f3 - f4 * f1) * 0.5F;
                    continue;
                  }
                  if (this.w == 1)
                  {
                    f2 = 0.0F;
                    f3 = f5;
                    continue;
                  }
                  f4 = f1;
                  if (this.w == 2)
                  {
                    f3 = i3;
                    f4 = i5;
                    f2 = 0.0F;
                    f3 -= f4 * f1;
                    continue;
                    label646:
                    this.jdField_b_of_type_AndroidGraphicsMatrix = null;
                    return;
                  }
                }
                f1 = f4;
              }
            }
          }
        }
        f1 = 0.0F;
        f3 = f2;
        f2 = 0.0F;
      }
    }
  }
  
  public void a()
  {
    a(null);
    b(null);
    this.jdField_a_of_type_AndroidGraphicsMatrix = null;
    this.jdField_b_of_type_AndroidGraphicsMatrix = null;
    this.jdField_a_of_type_Boolean = false;
    this.c = false;
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, float paramFloat, Drawable.Callback paramCallback)
  {
    boolean bool2 = true;
    QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|startTranslate|drawable = " + paramDrawable + "|[" + paramInt1 + "," + paramInt2 + "]|fScale = " + paramFloat + "|callback = " + paramCallback);
    this.w = 1;
    this.c = true;
    int i1 = (int)(paramInt1 * paramFloat);
    int i2 = (int)(paramInt2 * paramFloat);
    if ((this.u != i1) || (this.v != i2))
    {
      this.u = i1;
      this.v = i2;
      this.h = (this.u - paramInt1);
      this.i = (this.v - paramInt2);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Drawable localDrawable = a();
      if (localDrawable != paramDrawable)
      {
        a(paramDrawable);
        b(localDrawable);
        this.q = 0;
        this.r = 255;
        this.t = 0;
        this.s = 1000;
        this.p = 0;
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          e();
        }
        setCallback(paramCallback);
        return bool1;
      }
    }
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, Drawable.Callback paramCallback)
  {
    boolean bool2 = true;
    QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|setDrawable|drawable = " + paramDrawable + "|[" + paramInt1 + "," + paramInt2 + "]|nScaleType = " + paramInt3 + "|callback = " + paramCallback);
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.w = paramInt3;
    if ((this.u != paramInt1) || (this.v != paramInt2))
    {
      this.u = paramInt1;
      this.v = paramInt2;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Drawable localDrawable = a();
      if (localDrawable != paramDrawable)
      {
        a(paramDrawable);
        b(localDrawable);
        this.q = 0;
        this.r = 255;
        this.t = 0;
        this.s = 1000;
        this.p = 0;
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          e();
        }
        setCallback(paramCallback);
        return bool1;
      }
    }
  }
  
  public void b()
  {
    b(null);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      invalidateSelf();
    }
  }
  
  public void d()
  {
    switch (this.j)
    {
    }
    for (;;)
    {
      Point localPoint = a(this.h, this.i);
      this.f = 0;
      this.g = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      int i1 = Math.max(Math.abs(localPoint.x), Math.abs(localPoint.y));
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, localPoint.x, localPoint.y, i1 * 100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      this.jdField_d_of_type_Int = 0;
      this.e = (-this.i);
      continue;
      this.jdField_d_of_type_Int = 0;
      this.e = 0;
      continue;
      this.jdField_d_of_type_Int = (-this.h);
      this.e = (-this.i);
      continue;
      this.jdField_d_of_type_Int = (-this.h);
      this.e = 0;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1;
    switch (this.p)
    {
    default: 
      i1 = 1;
      label31:
      int i2 = this.t;
      boolean bool = this.jdField_d_of_type_Boolean;
      Drawable localDrawable = b();
      if (localDrawable != null)
      {
        if (bool) {
          localDrawable.setAlpha(255 - i2);
        }
        int i3 = paramCanvas.getSaveCount();
        paramCanvas.save();
        if (this.jdField_b_of_type_AndroidGraphicsMatrix == null) {
          break label442;
        }
        if (!this.c) {
          break;
        }
        this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].set(this.jdField_b_of_type_AndroidGraphicsMatrix);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].postTranslate(this.jdField_d_of_type_Int, this.e);
        paramCanvas.concat(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2]);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].reset();
        label147:
        localDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
        if (bool) {
          localDrawable.setAlpha(255);
        }
      }
      localDrawable = a();
      if ((localDrawable != null) && (i2 > 0))
      {
        localDrawable.setAlpha(i2);
        i2 = paramCanvas.getSaveCount();
        paramCanvas.save();
        if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
          break label502;
        }
        if (this.c)
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].set(this.jdField_a_of_type_AndroidGraphicsMatrix);
          this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].postTranslate(this.jdField_d_of_type_Int, this.e);
          paramCanvas.concat(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2]);
          label263:
          localDrawable.draw(paramCanvas);
          paramCanvas.restoreToCount(i2);
          localDrawable.setAlpha(255);
        }
      }
      else
      {
        if (i1 != 0) {
          break label551;
        }
        invalidateSelf();
      }
      break;
    }
    for (;;)
    {
      if ((this.c) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
      }
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.p = 1;
      i1 = 0;
      break label31;
      if (this.jdField_a_of_type_Long < 0L) {
        break;
      }
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.s;
      if (f1 >= 1.0F) {}
      for (i1 = 1;; i1 = 0)
      {
        f1 = Math.min(f1, 1.0F);
        float f2 = this.q;
        this.t = ((int)(f1 * (this.r - this.q) + f2));
        break;
      }
      paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
      break label147;
      label442:
      if (!this.c) {
        break label147;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].reset();
      this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].postTranslate(this.jdField_d_of_type_Int, this.e);
      paramCanvas.concat(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2]);
      break label147;
      paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
      break label263;
      label502:
      if (!this.c) {
        break label263;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].reset();
      this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2].postTranslate(this.jdField_d_of_type_Int, this.e);
      paramCanvas.concat(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[2]);
      break label263;
      label551:
      b(null);
      this.jdField_b_of_type_AndroidGraphicsMatrix = null;
      if (a() == null)
      {
        this.c = false;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if ((a() == paramURLDrawable) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|onLoadCanceled|drawable = " + paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((a() == paramURLDrawable) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|onLoadFialed|drawable = " + paramURLDrawable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if ((a() == paramURLDrawable) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|onLoadProgressed|drawable = " + paramURLDrawable + ", progress = " + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (a() == paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.PhotoWall.Bg", 2, "TCTransitDrawable|onLoadSuccessed|drawable = " + paramURLDrawable);
      }
      e();
      invalidateSelf();
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TCTransitDrawable
 * JD-Core Version:    0.7.0.1
 */