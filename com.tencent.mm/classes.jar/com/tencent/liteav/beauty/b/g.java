package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;
import java.util.Iterator;
import java.util.List;

public class g
  extends d
{
  protected List<d> r;
  protected List<d> s;
  private int[] t;
  private int[] u;
  private d v;
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = this.s.size();
    k();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      d locald = (d)this.s.get(j);
      if (i != 0)
      {
        paramInt1 = locald.a(paramInt1, paramInt2, paramInt3);
        label58:
        if (i == 0) {
          break label97;
        }
      }
      label97:
      for (i = 0;; i = 1)
      {
        j += 1;
        break;
        paramInt1 = locald.a(paramInt1, this.t[0], this.u[0]);
        break label58;
      }
    }
    if (i != 0) {
      this.v.a(paramInt1, paramInt2, paramInt3);
    }
    return paramInt3;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2)) {}
    for (;;)
    {
      return;
      if (this.t != null) {
        f();
      }
      super.a(paramInt1, paramInt2);
      int j = this.s.size();
      int i = 0;
      while (i < j)
      {
        ((d)this.s.get(i)).a(paramInt1, paramInt2);
        i += 1;
      }
      this.v.a(paramInt1, paramInt2);
      if ((this.s != null) && (this.s.size() > 0))
      {
        this.s.size();
        this.t = new int[2];
        this.u = new int[2];
        i = 0;
        while (i < 2)
        {
          GLES20.glGenFramebuffers(1, this.t, i);
          GLES20.glGenTextures(1, this.u, i);
          GLES20.glBindTexture(3553, this.u[i]);
          GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glBindFramebuffer(36160, this.t[i]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[i], 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          i += 1;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = super.b();
    boolean bool1 = bool2;
    if (bool2)
    {
      Iterator localIterator = this.r.iterator();
      d locald;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locald = (d)localIterator.next();
        locald.a();
      } while (locald.m());
      bool1 = this.v.a();
    }
    return (bool1) && (GLES20.glGetError() == 0);
  }
  
  public void e()
  {
    super.e();
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).d();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.u != null)
    {
      GLES20.glDeleteTextures(2, this.u, 0);
      this.u = null;
    }
    if (this.t != null)
    {
      GLES20.glDeleteFramebuffers(2, this.t, 0);
      this.t = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.g
 * JD-Core Version:    0.7.0.1
 */