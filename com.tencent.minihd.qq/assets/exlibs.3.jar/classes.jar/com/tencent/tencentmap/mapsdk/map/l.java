package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class l
  extends Overlay
{
  private Drawable a = null;
  private Bitmap b = null;
  private String c = "logo.png";
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private float m = 0.02F;
  private float n = 0.022F;
  private float o = 0.0185F;
  private float p = 0.6675F;
  private float q = 0.673F;
  private float r = 0.6853F;
  private float s = 0.012F;
  private float t = 0.0125F;
  private float u = 0.0104F;
  private int v = -2147483648;
  private int w = -2147483648;
  private float x = 1.4E-45F;
  private float y = 1.4E-45F;
  private float z = 1.4E-45F;
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt3;
    this.k = paramInt2;
    this.l = paramInt4;
    if (this.h <= 0)
    {
      paramInt1 = this.i;
      paramInt3 = this.j;
      paramInt2 = this.k;
      paramInt4 = this.l;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.setBounds(paramInt1, paramInt3, paramInt2, paramInt4);
      }
      return;
      if (this.h <= 1)
      {
        paramInt1 = this.f - this.k;
        paramInt3 = this.j;
        paramInt2 = this.f - this.i;
        paramInt4 = this.l;
      }
      else if (this.h <= 2)
      {
        paramInt1 = this.f - this.k;
        paramInt3 = this.g - this.l;
        paramInt2 = this.f - this.i;
        paramInt4 = this.g - this.j;
      }
      else
      {
        paramInt1 = this.i;
        paramInt3 = this.g - this.l;
        paramInt2 = this.k;
        paramInt4 = this.g - this.j;
      }
    }
  }
  
  void a(int paramInt)
  {
    this.v = paramInt;
    a(this.f, this.g, null);
  }
  
  void a(int paramInt, float paramFloat, Context paramContext)
  {
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    paramFloat = f1;
    if (f1 > 1.0F) {
      paramFloat = 1.0F;
    }
    if (paramInt == 0) {
      this.x = paramFloat;
    }
    for (;;)
    {
      a(this.f, this.g, paramContext);
      return;
      if (paramInt == 1) {
        this.y = paramFloat;
      } else if (paramInt == 2) {
        this.z = paramFloat;
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, Context paramContext)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    if ((this.f == 0) || (this.g == 0)) {}
    do
    {
      do
      {
        return;
        if (this.a != null) {
          break;
        }
        if ((this.b == null) && (paramContext != null)) {
          this.b = q.a(paramContext, this.c);
        }
      } while (this.b == null);
      this.a = new BitmapDrawable(this.b);
    } while (this.a == null);
    this.d = this.a.getIntrinsicWidth();
    this.e = this.a.getIntrinsicHeight();
    float f3 = this.m;
    float f2 = this.p;
    float f1 = this.s;
    if (this.f >= 1080)
    {
      f3 = this.o;
      f2 = this.r;
      f1 = this.u;
    }
    for (;;)
    {
      if (this.x != 1.4E-45F) {
        f3 = this.x;
      }
      if (this.y != 1.4E-45F) {
        f2 = this.y;
      }
      if (this.z != 1.4E-45F) {
        f1 = this.z;
      }
      int i1 = (int)(this.f * f3);
      int i2 = this.f - (int)(this.f * f2);
      paramInt1 = i2 - i1;
      int i3 = this.e * paramInt1 / this.d;
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = i3;
      if (i3 <= 0) {
        paramInt1 = 1;
      }
      int i4 = this.g - (int)(this.g * f1);
      i3 = i4 - paramInt1;
      if (this.v != -2147483648)
      {
        i1 = this.v;
        i2 = i1 + paramInt2;
      }
      paramInt2 = i4;
      if (this.w != -2147483648)
      {
        paramInt2 = this.g - this.w;
        i3 = paramInt2 - paramInt1;
      }
      a(i1, i2, i3, paramInt2);
      return;
      if (this.f >= 720)
      {
        f3 = this.n;
        f2 = this.q;
        f1 = this.t;
      }
    }
  }
  
  void a(q.b paramb, Context paramContext)
  {
    if (paramb == q.b.d) {}
    for (this.c = "logo_satelite.png";; this.c = "logo.png")
    {
      if (this.a != null) {
        this.a = null;
      }
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        this.b.recycle();
        this.b = null;
      }
      a(this.f, this.g, paramContext);
      return;
    }
  }
  
  void b(int paramInt)
  {
    this.w = paramInt;
    a(this.f, this.g, null);
  }
  
  void c(int paramInt)
  {
    this.h = paramInt;
    a(this.i, this.k, this.j, this.l);
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView)
  {
    if (this.a == null) {
      return;
    }
    this.a.draw(paramCanvas);
    super.draw(paramCanvas, paramMapView);
  }
  
  protected void onRemoveOverlay()
  {
    super.onRemoveOverlay();
    if (this.a != null) {
      this.a = null;
    }
    if ((this.b != null) && (!this.b.isRecycled()))
    {
      this.b.recycle();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.l
 * JD-Core Version:    0.7.0.1
 */