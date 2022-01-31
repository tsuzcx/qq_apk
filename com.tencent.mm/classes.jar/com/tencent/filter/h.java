package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.util.d;
import com.tencent.util.g;
import com.tencent.view.b;
import com.tencent.view.f;

public final class h
{
  boolean bcB = false;
  public int[] bcC = { 0 };
  public h bcD;
  public int height;
  public boolean needReleaseFrmae = false;
  public int[] texture = { 0 };
  public int width;
  
  public h() {}
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.texture[0] = paramInt2;
    this.bcC[0] = paramInt1;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    f.checkGlError("before glBindFramebuffer");
    if (paramInt1 == 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      if (paramDouble <= 0.0D)
      {
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        return;
      }
      double d2 = paramInt3;
      double d3 = paramInt3 * paramDouble;
      double d1 = d3;
      if (paramInt2 > d3)
      {
        d1 = paramInt2;
        d2 = paramInt2 / paramDouble;
      }
      GLES20.glViewport((int)-(d1 - paramInt2) / 2, (int)-(d2 - paramInt3) / 2, (int)d1, (int)d2);
      return;
    }
    if ((paramInt1 == -2) && (b.xde >= 0))
    {
      int i = GLSLRender.nativeCheckMagicEngine(5, b.xde);
      b.xde = i;
      if (i >= 0)
      {
        GLSLRender.nativeBeginUseEglImage(paramInt2, paramInt3, b.xde);
        this.texture[0] = 0;
        return;
      }
    }
    if (((paramInt1 > 0) && (this.texture[0] != paramInt1)) || (this.width != paramInt2) || (this.height != paramInt3))
    {
      if (this.bcC[0] != 0)
      {
        GLES20.glBindFramebuffer(36160, this.bcC[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      }
      if ((this.bcB) && (this.texture[0] != 0)) {
        GLES20.glDeleteTextures(1, this.texture, 0);
      }
      this.texture[0] = 0;
    }
    this.width = paramInt2;
    this.height = paramInt3;
    if (this.bcC[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.bcC, 0);
    }
    if ((paramInt1 > 0) && (this.texture[0] != paramInt1))
    {
      this.bcB = false;
      this.texture[0] = paramInt1;
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.texture[0]);
      if (!d.cRj().av(this.texture[0], this.width, this.height))
      {
        d.cRj().aw(this.texture[0], this.width, this.height);
        GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
      }
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.bcC[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
      GLES20.glViewport(0, 0, this.width, this.height);
      g.h("Frame", "new frame buffer");
    }
    for (;;)
    {
      f.checkGlError("glBindFramebuffer");
      return;
      if (this.texture[0] <= 0)
      {
        this.bcB = true;
        GLES20.glActiveTexture(33984);
        this.texture[0] = d.cRj().gp(this.width, this.height);
        GLES20.glBindTexture(3553, this.texture[0]);
        if (!d.cRj().av(this.texture[0], this.width, this.height))
        {
          d.cRj().aw(this.texture[0], this.width, this.height);
          GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
        }
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.bcC[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
        GLES20.glViewport(0, 0, this.width, this.height);
        g.h("Frame", "new frame buffer auto");
      }
      else
      {
        GLES20.glBindFramebuffer(36160, this.bcC[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
      }
    }
  }
  
  public final void clear()
  {
    if (this.bcC[0] != 0)
    {
      GLES20.glBindFramebuffer(36160, this.bcC[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      GLES20.glDeleteFramebuffers(1, this.bcC, 0);
      this.bcC[0] = 0;
    }
    pH();
    if (this.bcD != null) {
      this.bcD.clear();
    }
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public final void pH()
  {
    g.h("Frame", "frame clear");
    if (this.texture[0] != 0)
    {
      if (this.bcB) {
        d.cRj().Kr(this.texture[0]);
      }
      this.texture[0] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.h
 * JD-Core Version:    0.7.0.1
 */