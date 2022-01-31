package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;

public class g
{
  private TextureView a;
  private Handler b;
  private int c = 0;
  private int d = 0;
  private int e = 640;
  private int f = 480;
  private int g = 0;
  private int h = 0;
  private int i = 1;
  private int j = 0;
  private float k = 1.0F;
  private int l = 0;
  
  public g(TextureView paramTextureView)
  {
    this.a = paramTextureView;
    this.c = paramTextureView.getWidth();
    this.d = paramTextureView.getHeight();
    this.b = new Handler(paramTextureView.getContext().getMainLooper());
  }
  
  private void a()
  {
    try
    {
      this.b.post(new g.3(this));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (paramInt1 == 0) || (paramInt2 == 0)) {}
    while ((this.c == 0) || (this.d == 0)) {
      return;
    }
    double d1 = paramInt2 / paramInt1;
    if (this.d > (int)(this.c * d1)) {
      this.g = this.c;
    }
    for (this.h = ((int)(d1 * this.c));; this.h = this.d)
    {
      float f1 = (this.c - this.g) / 2.0F;
      float f2 = (this.d - this.h) / 2.0F;
      float f3 = this.g / this.c;
      float f4 = this.h / this.d;
      Matrix localMatrix = new Matrix();
      this.a.getTransform(localMatrix);
      localMatrix.setScale(f3, f4);
      localMatrix.postTranslate(f1, f2);
      this.a.setTransform(localMatrix);
      this.a.requestLayout();
      return;
      this.g = ((int)(this.d / d1));
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.b.post(new g.1(this, paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + paramInt1 + "," + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    a();
  }
  
  public void b(int paramInt)
  {
    float f2 = 1.0F;
    this.i = paramInt;
    float f1;
    if (this.a != null)
    {
      if (paramInt != 1) {
        break label154;
      }
      f1 = f2;
      if (this.j != 0)
      {
        if (this.j != 180) {
          break label79;
        }
        f1 = f2;
      }
    }
    for (;;)
    {
      f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
      label79:
      float f3;
      label154:
      do
      {
        do
        {
          return;
          if (this.j != 270)
          {
            f1 = f2;
            if (this.j != 90) {
              break;
            }
          }
        } while ((this.g == 0) || (this.h == 0));
        f2 = this.d / this.g;
        f3 = this.c / this.h;
        f1 = f3;
        if (f2 > f3) {
          break;
        }
        f1 = f2;
        break;
        f1 = f2;
        if (paramInt != 0) {
          break;
        }
      } while ((this.g == 0) || (this.h == 0));
      if ((this.j == 0) || (this.j == 180))
      {
        f2 = this.d / this.h;
        f3 = this.c / this.g;
        f1 = f3;
        if (f2 >= f3) {
          f1 = f2;
        }
      }
      else if (this.j != 270)
      {
        f1 = f2;
        if (this.j != 90) {}
      }
      else
      {
        f2 = this.d / this.g;
        f3 = this.c / this.h;
        f1 = f3;
        if (f2 >= f3) {
          f1 = f2;
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + paramInt1 + "," + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    a();
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.b.post(new g.2(this, paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(int paramInt)
  {
    float f4 = 1.0F;
    paramInt %= 360;
    this.j = paramInt;
    float f1;
    if (this.a != null)
    {
      if ((paramInt != 0) && (paramInt != 180)) {
        break label156;
      }
      this.a.setRotation(360 - paramInt);
      if (this.i != 1) {
        break label94;
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      float f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
      label94:
      do
      {
        do
        {
          return;
          f1 = f4;
          if (this.i != 0) {
            break;
          }
        } while ((this.g == 0) || (this.h == 0));
        f1 = this.d / this.h;
        f2 = this.c / this.g;
        if (f1 < f2) {
          f1 = f2;
        }
        for (;;)
        {
          break;
        }
        if (paramInt != 270)
        {
          f1 = f4;
          if (paramInt != 90) {
            break;
          }
        }
      } while ((this.g == 0) || (this.h == 0));
      label156:
      this.a.setRotation(360 - paramInt);
      f2 = this.d / this.g;
      float f3 = this.c / this.h;
      if (this.i == 1)
      {
        if (f2 > f3) {}
        for (f1 = f3;; f1 = f2) {
          break;
        }
      }
      f1 = f4;
      if (this.i == 0)
      {
        f1 = f3;
        if (f2 >= f3) {
          f1 = f2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.g
 * JD-Core Version:    0.7.0.1
 */