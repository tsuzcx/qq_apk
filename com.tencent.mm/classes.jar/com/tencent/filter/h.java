package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.f;
import com.tencent.util.i;
import com.tencent.view.b;
import com.tencent.view.g;

public final class h
{
  boolean btd;
  public int[] bte;
  public h btf;
  public int height;
  public boolean needReleaseFrmae;
  public int[] texture;
  public int width;
  
  public h()
  {
    AppMethodBeat.i(86364);
    this.btd = false;
    this.texture = new int[] { 0 };
    this.bte = new int[] { 0 };
    this.needReleaseFrmae = false;
    AppMethodBeat.o(86364);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(86365);
    this.btd = false;
    this.texture = new int[] { 0 };
    this.bte = new int[] { 0 };
    this.needReleaseFrmae = false;
    this.texture[0] = paramInt2;
    this.bte[0] = paramInt1;
    this.width = paramInt3;
    this.height = paramInt4;
    AppMethodBeat.o(86365);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    AppMethodBeat.i(86366);
    g.checkGlError("before glBindFramebuffer");
    if (paramInt1 == 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      if (paramDouble <= 0.0D)
      {
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        AppMethodBeat.o(86366);
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
      AppMethodBeat.o(86366);
      return;
    }
    if ((paramInt1 == -2) && (b.BzL >= 0))
    {
      int i = GLSLRender.nativeCheckMagicEngine(5, b.BzL);
      b.BzL = i;
      if (i >= 0)
      {
        GLSLRender.nativeBeginUseEglImage(paramInt2, paramInt3, b.BzL);
        this.texture[0] = 0;
        AppMethodBeat.o(86366);
        return;
      }
    }
    if (((paramInt1 > 0) && (this.texture[0] != paramInt1)) || (this.width != paramInt2) || (this.height != paramInt3))
    {
      if (this.bte[0] != 0)
      {
        GLES20.glBindFramebuffer(36160, this.bte[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      }
      if ((this.btd) && (this.texture[0] != 0)) {
        GLES20.glDeleteTextures(1, this.texture, 0);
      }
      this.texture[0] = 0;
    }
    this.width = paramInt2;
    this.height = paramInt3;
    if (this.bte[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.bte, 0);
    }
    if ((paramInt1 > 0) && (this.texture[0] != paramInt1))
    {
      this.btd = false;
      this.texture[0] = paramInt1;
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.texture[0]);
      if (!f.dWZ().aH(this.texture[0], this.width, this.height))
      {
        f.dWZ().aI(this.texture[0], this.width, this.height);
        GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
        f.dWZ().iy(this.width, this.height);
      }
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.bte[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
      GLES20.glViewport(0, 0, this.width, this.height);
      i.l("Frame", "new frame buffer");
    }
    for (;;)
    {
      g.checkGlError("glBindFramebuffer");
      AppMethodBeat.o(86366);
      return;
      if (this.texture[0] <= 0)
      {
        this.btd = true;
        GLES20.glActiveTexture(33984);
        this.texture[0] = f.dWZ().ix(this.width, this.height);
        GLES20.glBindTexture(3553, this.texture[0]);
        if (!f.dWZ().aH(this.texture[0], this.width, this.height))
        {
          f.dWZ().aI(this.texture[0], this.width, this.height);
          GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
          f.dWZ().iy(this.width, this.height);
        }
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.bte[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
        GLES20.glViewport(0, 0, this.width, this.height);
        i.l("Frame", "new frame buffer auto");
      }
      else
      {
        GLES20.glBindFramebuffer(36160, this.bte[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
      }
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(86367);
    if (this.bte[0] != 0)
    {
      GLES20.glBindFramebuffer(36160, this.bte[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      GLES20.glDeleteFramebuffers(1, this.bte, 0);
      this.bte[0] = 0;
    }
    tN();
    if (this.btf != null) {
      this.btf.clear();
    }
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(86367);
  }
  
  public final int getTextureId()
  {
    return this.texture[0];
  }
  
  public final int tM()
  {
    return this.bte[0];
  }
  
  public final void tN()
  {
    AppMethodBeat.i(86368);
    i.l("Frame", "frame clear");
    if (this.texture[0] != 0)
    {
      if (this.btd)
      {
        f.dWZ().FC(this.texture[0]);
        f.dWZ().iz(this.width, this.height);
      }
      this.texture[0] = 0;
    }
    AppMethodBeat.o(86368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.h
 * JD-Core Version:    0.7.0.1
 */