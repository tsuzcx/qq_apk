package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;
import java.util.List;

public class t
  extends s
{
  protected float u;
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    s();
  }
  
  public boolean b()
  {
    return (super.b()) && (GLES20.glGetError() == 0);
  }
  
  public float q()
  {
    return this.u;
  }
  
  public float r()
  {
    return this.u;
  }
  
  protected void s()
  {
    float f = r();
    d locald = (d)this.r.get(0);
    int i = GLES20.glGetUniformLocation(locald.p(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(locald.p(), "texelHeightOffset");
    locald.a(i, f / this.e);
    locald.a(j, 0.0F);
    f = q();
    locald = (d)this.r.get(1);
    i = GLES20.glGetUniformLocation(locald.p(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(locald.p(), "texelHeightOffset");
    locald.a(i, 0.0F);
    locald.a(j, f / this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.t
 * JD-Core Version:    0.7.0.1
 */