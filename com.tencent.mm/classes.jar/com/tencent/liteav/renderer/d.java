package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  private TextureView a;
  private Handler b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private float k;
  private int l;
  
  public d(TextureView paramTextureView)
  {
    AppMethodBeat.i(16783);
    this.c = 0;
    this.d = 0;
    this.e = 640;
    this.f = 480;
    this.g = 0;
    this.h = 0;
    this.i = 1;
    this.j = 0;
    this.k = 1.0F;
    this.l = 0;
    this.a = paramTextureView;
    this.c = paramTextureView.getWidth();
    this.d = paramTextureView.getHeight();
    this.b = new Handler(paramTextureView.getContext().getMainLooper());
    AppMethodBeat.o(16783);
  }
  
  private void a()
  {
    AppMethodBeat.i(16788);
    try
    {
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16756);
          d.a(d.this, d.a(d.this), d.b(d.this));
          d.this.b(d.c(d.this));
          d.this.d(d.d(d.this));
          AppMethodBeat.o(16756);
        }
      });
      AppMethodBeat.o(16788);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "adjust video size failed.", localException);
      AppMethodBeat.o(16788);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(16792);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(16792);
      return;
    }
    this.b.post(paramRunnable);
    AppMethodBeat.o(16792);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16789);
    if ((this.a == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(16789);
      return;
    }
    if ((this.c == 0) || (this.d == 0))
    {
      AppMethodBeat.o(16789);
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
      AppMethodBeat.o(16789);
      return;
      this.g = ((int)(this.d / d1));
    }
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(16784);
    try
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16840);
          d.this.b(paramInt);
          AppMethodBeat.o(16840);
        }
      });
      AppMethodBeat.o(16784);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set render mode failed", localException);
      AppMethodBeat.o(16784);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16790);
    TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + paramInt1 + "," + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    a();
    AppMethodBeat.o(16790);
  }
  
  public void a(final boolean paramBoolean)
  {
    AppMethodBeat.i(220261);
    try
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(220966);
          if (d.e(d.this) != null)
          {
            d.a(d.this, Math.abs(d.f(d.this)));
            if (paramBoolean) {
              d.a(d.this, -d.f(d.this));
            }
            d.e(d.this).setScaleX(d.f(d.this));
            d.e(d.this).setScaleY(Math.abs(d.f(d.this)));
          }
          AppMethodBeat.o(220966);
        }
      });
      AppMethodBeat.o(220261);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set mirror failed.", localException);
      AppMethodBeat.o(220261);
    }
  }
  
  public void b(int paramInt)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(16785);
    this.i = paramInt;
    float f1;
    if (this.a != null)
    {
      if (paramInt != 1) {
        break label173;
      }
      f1 = f2;
      if (this.j != 0)
      {
        if (this.j != 180) {
          break label91;
        }
        f1 = f2;
      }
    }
    label173:
    for (;;)
    {
      f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
      AppMethodBeat.o(16785);
      return;
      label91:
      if (this.j != 270)
      {
        f1 = f2;
        if (this.j != 90) {}
      }
      else
      {
        if ((this.g == 0) || (this.h == 0))
        {
          AppMethodBeat.o(16785);
          return;
        }
        f2 = this.d / this.g;
        float f3 = this.c / this.h;
        f1 = f3;
        if (f2 <= f3)
        {
          f1 = f2;
          continue;
          f1 = f2;
          if (paramInt == 0)
          {
            if ((this.g == 0) || (this.h == 0))
            {
              AppMethodBeat.o(16785);
              return;
            }
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
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16791);
    TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + paramInt1 + "," + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    a();
    AppMethodBeat.o(16791);
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(16786);
    try
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16889);
          d.this.d(paramInt);
          AppMethodBeat.o(16889);
        }
      });
      AppMethodBeat.o(16786);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set render rotation failed.", localException);
      AppMethodBeat.o(16786);
    }
  }
  
  public void d(int paramInt)
  {
    float f4 = 1.0F;
    AppMethodBeat.i(16787);
    paramInt %= 360;
    this.j = paramInt;
    float f1;
    if (this.a != null)
    {
      if ((paramInt != 0) && (paramInt != 180)) {
        break label175;
      }
      this.a.setRotation(360 - paramInt);
      if (this.i != 1) {
        break label106;
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
      AppMethodBeat.o(16787);
      return;
      label106:
      f1 = f4;
      if (this.i == 0)
      {
        if ((this.g == 0) || (this.h == 0))
        {
          AppMethodBeat.o(16787);
          return;
        }
        f1 = this.d / this.h;
        f2 = this.c / this.g;
        if (f1 < f2) {
          f1 = f2;
        }
        for (;;)
        {
          break;
        }
        label175:
        if (paramInt != 270)
        {
          f1 = f4;
          if (paramInt != 90) {}
        }
        else
        {
          if ((this.g == 0) || (this.h == 0))
          {
            AppMethodBeat.o(16787);
            return;
          }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.d
 * JD-Core Version:    0.7.0.1
 */