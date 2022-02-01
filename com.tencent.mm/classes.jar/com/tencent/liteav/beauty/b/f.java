package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  extends j
{
  private int[] A;
  private float B = 4.0F;
  int r;
  int s;
  boolean t;
  private d u;
  private j v;
  private c w;
  private a x;
  private b y;
  private int[] z;
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15120);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(15120);
      return;
    }
    super.a(paramInt1, paramInt2);
    int i;
    if (!this.t)
    {
      if (paramInt1 >= paramInt2) {
        break label389;
      }
      if (paramInt1 < 540) {
        this.B = 1.0F;
      }
    }
    else
    {
      this.r = ((int)(paramInt1 / this.B));
      this.s = ((int)(paramInt2 / this.B));
      this.v.a(this.r, this.s);
      this.w.a(this.r, this.s);
      this.x.a(this.r, this.s);
      this.y.a(paramInt1, paramInt2);
      this.u.a(this.r, this.s);
      if (this.z != null)
      {
        GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
        GLES20.glDeleteTextures(this.z.length, this.A, 0);
        this.z = null;
        this.A = null;
      }
      this.z = new int[8];
      this.A = new int[this.z.length];
      GLES20.glGenFramebuffers(this.z.length, this.z, 0);
      GLES20.glGenTextures(this.z.length, this.A, 0);
      i = 0;
      label242:
      if (i >= this.z.length) {
        break label442;
      }
      GLES20.glBindTexture(3553, this.A[i]);
      if (i < 5) {
        break label413;
      }
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.z[i]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      i += 1;
      break label242;
      this.B = 4.0F;
      break;
      label389:
      if (paramInt2 < 540)
      {
        this.B = 1.0F;
        break;
      }
      this.B = 4.0F;
      break;
      label413:
      GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, null);
    }
    label442:
    AppMethodBeat.o(15120);
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(15121);
    if (this.B != 1.0F) {
      GLES20.glViewport(0, 0, this.r, this.s);
    }
    for (int i = this.v.b(paramInt);; i = paramInt)
    {
      int j = this.u.a(i, this.z[4], this.A[4]);
      i = this.w.a(i, j, this.z[0], this.A[0]);
      j = this.x.a(i, j, this.z[1], this.A[1]);
      int k = this.u.a(i, this.z[2], this.A[2]);
      int m = this.u.a(j, this.z[3], this.A[3]);
      j = k;
      i = m;
      if (this.B != 1.0F)
      {
        GLES20.glViewport(0, 0, this.e, this.f);
        j = this.v.a(k, this.z[5], this.A[5]);
        i = this.v.a(m, this.z[6], this.A[6]);
      }
      paramInt = this.y.a(j, i, paramInt, this.z[7], this.A[7]);
      AppMethodBeat.o(15121);
      return paramInt;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15119);
    boolean bool2 = super.b();
    if (bool2)
    {
      this.u = new d();
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = this.u.a();
      }
      this.w = new c();
      bool2 = bool1;
      if (bool1) {
        bool2 = this.w.a();
      }
      this.x = new a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
      bool1 = bool2;
      if (bool2) {
        bool1 = this.x.a();
      }
      this.y = new b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
      bool2 = bool1;
      if (bool1) {
        bool2 = this.y.a();
      }
      this.v = new j();
      this.v.a(true);
      bool1 = bool2;
      if (bool2) {
        bool1 = this.v.a();
      }
      if (bool1)
      {
        AppMethodBeat.o(15119);
        return true;
      }
    }
    d();
    AppMethodBeat.o(15119);
    return false;
  }
  
  public void e()
  {
    AppMethodBeat.i(15122);
    if (this.g)
    {
      super.e();
      this.u.d();
      this.w.d();
      this.x.d();
      this.y.d();
      this.v.d();
      if (this.z != null)
      {
        GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
        GLES20.glDeleteTextures(this.z.length, this.A, 0);
        this.z = null;
      }
      this.A = null;
    }
    AppMethodBeat.o(15122);
  }
  
  static class a
    extends t
  {
    public a(String paramString)
    {
      super();
    }
    
    public boolean b()
    {
      AppMethodBeat.i(15108);
      if (super.b())
      {
        AppMethodBeat.o(15108);
        return true;
      }
      AppMethodBeat.o(15108);
      return false;
    }
  }
  
  static class b
    extends s
  {
    public b(String paramString)
    {
      super();
    }
    
    public boolean b()
    {
      AppMethodBeat.i(15021);
      if (super.b())
      {
        AppMethodBeat.o(15021);
        return true;
      }
      AppMethodBeat.o(15021);
      return false;
    }
  }
  
  static class c
    extends t
  {
    int r;
    int s;
    float t = 1.5F;
    
    public c()
    {
      super(null);
    }
    
    void a(float paramFloat)
    {
      AppMethodBeat.i(15057);
      this.t = paramFloat;
      a(this.r, this.t / this.e);
      a(this.s, this.t / this.f);
      AppMethodBeat.o(15057);
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(15058);
      super.a(paramInt1, paramInt2);
      a(this.t);
      AppMethodBeat.o(15058);
    }
    
    public boolean a()
    {
      AppMethodBeat.i(15055);
      this.a = NativeLoad.nativeLoadGLProgram(2);
      if ((this.a != 0) && (b())) {}
      for (this.g = true;; this.g = false)
      {
        c();
        boolean bool = this.g;
        AppMethodBeat.o(15055);
        return bool;
      }
    }
    
    public boolean b()
    {
      AppMethodBeat.i(15056);
      if (super.b())
      {
        this.r = GLES20.glGetUniformLocation(this.a, "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(this.a, "texelHeightOffset");
        AppMethodBeat.o(15056);
        return true;
      }
      AppMethodBeat.o(15056);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.f
 * JD-Core Version:    0.7.0.1
 */