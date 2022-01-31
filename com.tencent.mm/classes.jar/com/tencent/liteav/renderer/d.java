package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
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
    AppMethodBeat.i(67252);
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
    AppMethodBeat.o(67252);
  }
  
  private void a()
  {
    AppMethodBeat.i(67257);
    try
    {
      this.b.post(new d.3(this));
      AppMethodBeat.o(67257);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67257);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67258);
    if ((this.a == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(67258);
      return;
    }
    if ((this.c == 0) || (this.d == 0))
    {
      AppMethodBeat.o(67258);
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
      AppMethodBeat.o(67258);
      return;
      this.g = ((int)(this.d / d1));
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(67253);
    try
    {
      this.b.post(new d.1(this, paramInt));
      AppMethodBeat.o(67253);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67253);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67259);
    TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + paramInt1 + "," + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    a();
    AppMethodBeat.o(67259);
  }
  
  public void b(int paramInt)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(67254);
    this.i = paramInt;
    float f1;
    if (this.a != null)
    {
      if (paramInt != 1) {
        break label170;
      }
      f1 = f2;
      if (this.j != 0)
      {
        if (this.j != 180) {
          break label89;
        }
        f1 = f2;
      }
    }
    label170:
    for (;;)
    {
      f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
      AppMethodBeat.o(67254);
      return;
      label89:
      if (this.j != 270)
      {
        f1 = f2;
        if (this.j != 90) {}
      }
      else
      {
        if ((this.g == 0) || (this.h == 0))
        {
          AppMethodBeat.o(67254);
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
              AppMethodBeat.o(67254);
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
    AppMethodBeat.i(67260);
    TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + paramInt1 + "," + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    a();
    AppMethodBeat.o(67260);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(67255);
    try
    {
      this.b.post(new d.2(this, paramInt));
      AppMethodBeat.o(67255);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67255);
    }
  }
  
  public void d(int paramInt)
  {
    float f4 = 1.0F;
    AppMethodBeat.i(67256);
    paramInt %= 360;
    this.j = paramInt;
    float f1;
    if (this.a != null)
    {
      if ((paramInt != 0) && (paramInt != 180)) {
        break label172;
      }
      this.a.setRotation(360 - paramInt);
      if (this.i != 1) {
        break label104;
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
      AppMethodBeat.o(67256);
      return;
      label104:
      f1 = f4;
      if (this.i == 0)
      {
        if ((this.g == 0) || (this.h == 0))
        {
          AppMethodBeat.o(67256);
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
        label172:
        if (paramInt != 270)
        {
          f1 = f4;
          if (paramInt != 90) {}
        }
        else
        {
          if ((this.g == 0) || (this.h == 0))
          {
            AppMethodBeat.o(67256);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.renderer.d
 * JD-Core Version:    0.7.0.1
 */