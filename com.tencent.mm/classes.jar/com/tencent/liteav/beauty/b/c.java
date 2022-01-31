package com.tencent.liteav.beauty.b;

public class c
  extends b
{
  private static final String r = c.class.getSimpleName();
  private float A = 0.0F;
  private f s;
  private c.a t;
  private p u = null;
  private int v = -1;
  private int w = -1;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  private static float b(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      float f;
      if (paramFloat < 2.5D) {
        f = a((paramFloat - 1.0F) / 1.5F, 1.0F, 4.1F);
      }
      for (;;)
      {
        return f / 10.0F;
        if (paramFloat < 4.0F)
        {
          f = a((paramFloat - 2.5F) / 1.5F, 4.1F, 5.6F);
        }
        else if (paramFloat < 5.5D)
        {
          f = a((paramFloat - 4.0F) / 1.5F, 5.6F, 6.8F);
        }
        else
        {
          f = paramFloat;
          if (paramFloat <= 7.0D) {
            f = a((paramFloat - 5.5F) / 1.5F, 6.8F, 7.0F);
          }
        }
      }
    }
    return 0.1F;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.v == paramInt1) && (this.w == paramInt2)) {
      return;
    }
    new StringBuilder("onOutputSizeChanged mFrameWidth = ").append(paramInt1).append("  mFrameHeight = ").append(paramInt2);
    this.v = paramInt1;
    this.w = paramInt2;
    b(this.v, this.w);
  }
  
  public int b(int paramInt)
  {
    if ((this.x <= 0.0F) && (this.y <= 0.0F))
    {
      i = paramInt;
      if (this.z <= 0.0F) {}
    }
    else
    {
      if (this.x == 0.0F) {
        break label80;
      }
    }
    label80:
    for (int i = this.s.b(paramInt);; i = paramInt)
    {
      i = this.t.a(i, paramInt, paramInt);
      paramInt = i;
      if (this.A > 0.0F) {
        paramInt = this.u.b(i);
      }
      return paramInt;
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
    new StringBuilder("init mFrameWidth = ").append(paramInt1).append("  mFrameHeight = ").append(paramInt2);
    if (this.s == null)
    {
      this.s = new f();
      this.s.a(true);
      if (this.s.a()) {}
    }
    do
    {
      do
      {
        return false;
        this.s.a(this.v, this.w);
        if (this.t != null) {
          break;
        }
        this.t = new c.a();
        this.t.a(true);
      } while (!this.t.a());
      this.t.a(this.v, this.w);
      if (this.u != null) {
        break;
      }
      this.u = new p();
      this.u.a(true);
    } while (!this.u.a());
    this.u.a(this.v, this.w);
    return true;
  }
  
  public void c(int paramInt)
  {
    this.x = paramInt;
    if (this.t != null) {
      this.t.a(paramInt);
    }
  }
  
  public void d(int paramInt)
  {
    this.y = paramInt;
    if (this.t != null) {
      this.t.b(paramInt);
    }
  }
  
  public void e()
  {
    if (this.t != null)
    {
      this.t.d();
      this.t = null;
    }
    if (this.s != null)
    {
      this.s.d();
      this.s = null;
    }
    if (this.u != null)
    {
      this.u.d();
      this.u = null;
    }
  }
  
  public void e(int paramInt)
  {
    this.z = paramInt;
    if (this.t != null) {
      this.t.c(paramInt);
    }
  }
  
  public void f(int paramInt)
  {
    this.A = (paramInt / 15.0F);
    if (this.u != null) {
      this.u.a(this.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c
 * JD-Core Version:    0.7.0.1
 */