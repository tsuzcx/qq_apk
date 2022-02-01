package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class py
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 16;
  public static final int f = 256;
  public static final int g = 4096;
  public static final int h = 65536;
  private Rect A;
  public GeoPoint i;
  public Bitmap[] j;
  public float k = 0.5F;
  public float l = 0.5F;
  public float m = 1.0F;
  public boolean n = false;
  public int o;
  boolean p;
  public int q;
  public int r;
  public int s;
  public int t = 2;
  public boolean u;
  public boolean v = true;
  protected String w;
  public boolean x;
  public boolean y;
  public boolean z = true;
  
  private py a(float paramFloat)
  {
    this.m = paramFloat;
    return this;
  }
  
  private py a(int paramInt)
  {
    this.o = paramInt;
    return this;
  }
  
  private py a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
    return this;
  }
  
  private py a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225679);
    this.A = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(225679);
    return this;
  }
  
  private py a(GeoPoint paramGeoPoint)
  {
    this.i = paramGeoPoint;
    return this;
  }
  
  private py a(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }
  
  private py a(int... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      this.k = 0.5F;
      this.l = 1.0F;
    }
    do
    {
      do
      {
        return this;
        this.k = 0.5F;
        this.l = 0.5F;
      } while (paramVarArgs.length != 1);
      if ((paramVarArgs[0] & 0x100) == 256) {
        this.l = 0.0F;
      }
      while ((paramVarArgs[0] & 0x1000) == 4096)
      {
        this.k = 0.0F;
        return this;
        if ((paramVarArgs[0] & 0x10) == 16) {
          this.l = 1.0F;
        }
      }
    } while ((paramVarArgs[0] & 0x10000) != 65536);
    this.k = 1.0F;
    return this;
  }
  
  private GeoPoint b()
  {
    return this.i;
  }
  
  private py b(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  private py b(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  private Rect c()
  {
    return this.A;
  }
  
  private py c(int paramInt)
  {
    this.t = paramInt;
    return this;
  }
  
  private py c(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }
  
  private py d(boolean paramBoolean)
  {
    this.x = paramBoolean;
    return this;
  }
  
  private Bitmap[] d()
  {
    return this.j;
  }
  
  private py e(boolean paramBoolean)
  {
    this.y = paramBoolean;
    return this;
  }
  
  private boolean e()
  {
    return this.n;
  }
  
  private float f()
  {
    return this.m;
  }
  
  private py f(boolean paramBoolean)
  {
    this.u = paramBoolean;
    return this;
  }
  
  private py g(boolean paramBoolean)
  {
    this.z = paramBoolean;
    return this;
  }
  
  private int[] g()
  {
    int i1;
    if (this.k == 0.0F) {
      i1 = 4096;
    }
    for (;;)
    {
      int i2;
      if (this.l == 0.0F) {
        i2 = 256;
      }
      for (;;)
      {
        return new int[] { i1 | i2 };
        if (this.k != 1.0F) {
          break label71;
        }
        i1 = 65536;
        break;
        if (this.l == 1.0F) {
          i2 = 16;
        } else {
          i2 = 1;
        }
      }
      label71:
      i1 = 1;
    }
  }
  
  private int h()
  {
    int i1;
    if (this.k == 0.0F) {
      i1 = 4096;
    }
    for (;;)
    {
      int i2;
      if (this.l == 0.0F) {
        i2 = 256;
      }
      for (;;)
      {
        return new int[] { i1 | i2 }[0];
        if (this.k != 1.0F) {
          break label73;
        }
        i1 = 65536;
        break;
        if (this.l == 1.0F) {
          i2 = 16;
        } else {
          i2 = 1;
        }
      }
      label73:
      i1 = 1;
    }
  }
  
  private float i()
  {
    return this.k;
  }
  
  private float j()
  {
    return this.l;
  }
  
  private int k()
  {
    return this.o;
  }
  
  private boolean l()
  {
    return this.p;
  }
  
  private boolean m()
  {
    return this.x;
  }
  
  private boolean n()
  {
    return this.y;
  }
  
  private int o()
  {
    return this.q;
  }
  
  private int p()
  {
    return this.r;
  }
  
  private int q()
  {
    return this.s;
  }
  
  private int r()
  {
    return this.t;
  }
  
  private boolean s()
  {
    return this.u;
  }
  
  private boolean t()
  {
    return this.v;
  }
  
  private boolean u()
  {
    return this.z;
  }
  
  public final py a(float paramFloat1, float paramFloat2)
  {
    this.k = paramFloat1;
    this.l = paramFloat2;
    return this;
  }
  
  public final py a(String paramString, Bitmap... paramVarArgs)
  {
    this.w = paramString;
    this.j = paramVarArgs;
    return this;
  }
  
  public final String a()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.py
 * JD-Core Version:    0.7.0.1
 */