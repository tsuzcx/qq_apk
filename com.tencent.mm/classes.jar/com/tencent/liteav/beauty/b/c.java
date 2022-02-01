package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends b
{
  private static final String r;
  private float A = 0.0F;
  private f s;
  private a t;
  private r u = null;
  private int v = -1;
  private int w = -1;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  static
  {
    AppMethodBeat.i(15038);
    r = c.class.getSimpleName();
    AppMethodBeat.o(15038);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  private static float b(float paramFloat)
  {
    AppMethodBeat.i(15036);
    if (paramFloat > 1.0F)
    {
      float f;
      if (paramFloat < 2.5D) {
        f = a((paramFloat - 1.0F) / 1.5F, 1.0F, 4.1F);
      }
      for (;;)
      {
        paramFloat = f / 10.0F;
        AppMethodBeat.o(15036);
        return paramFloat;
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
    AppMethodBeat.o(15036);
    return 0.1F;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15029);
    if ((this.v == paramInt1) && (this.w == paramInt2))
    {
      AppMethodBeat.o(15029);
      return;
    }
    new StringBuilder("onOutputSizeChanged mFrameWidth = ").append(paramInt1).append("  mFrameHeight = ").append(paramInt2);
    this.v = paramInt1;
    this.w = paramInt2;
    c(this.v, this.w);
    AppMethodBeat.o(15029);
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(15028);
    if ((this.x <= 0.0F) && (this.y <= 0.0F))
    {
      i = paramInt;
      if (this.z <= 0.0F) {}
    }
    else
    {
      if (this.x == 0.0F) {
        break label92;
      }
    }
    label92:
    for (int i = this.s.b(paramInt);; i = paramInt)
    {
      i = this.t.a(i, paramInt, paramInt);
      paramInt = i;
      if (this.A > 0.0F) {
        paramInt = this.u.b(i);
      }
      AppMethodBeat.o(15028);
      return paramInt;
    }
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(15032);
    this.x = paramInt;
    if (this.t != null) {
      this.t.a(paramInt);
    }
    AppMethodBeat.o(15032);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15030);
    this.v = paramInt1;
    this.w = paramInt2;
    new StringBuilder("init mFrameWidth = ").append(paramInt1).append("  mFrameHeight = ").append(paramInt2);
    if (this.s == null)
    {
      this.s = new f();
      this.s.a(true);
      if (!this.s.a())
      {
        AppMethodBeat.o(15030);
        return false;
      }
    }
    this.s.a(this.v, this.w);
    if (this.t == null)
    {
      this.t = new a();
      this.t.a(true);
      if (!this.t.a())
      {
        AppMethodBeat.o(15030);
        return false;
      }
    }
    this.t.a(this.v, this.w);
    if (this.u == null)
    {
      this.u = new r();
      this.u.a(true);
      if (!this.u.a())
      {
        AppMethodBeat.o(15030);
        return false;
      }
    }
    this.u.a(this.v, this.w);
    AppMethodBeat.o(15030);
    return true;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(15033);
    this.y = paramInt;
    if (this.t != null) {
      this.t.b(paramInt);
    }
    AppMethodBeat.o(15033);
  }
  
  public void e()
  {
    AppMethodBeat.i(15031);
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
    AppMethodBeat.o(15031);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(15034);
    this.z = paramInt;
    if (this.t != null) {
      this.t.c(paramInt);
    }
    AppMethodBeat.o(15034);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(15035);
    float f = paramInt / 15.0F;
    if (Math.abs(this.A - f) < 0.001D)
    {
      AppMethodBeat.o(15035);
      return;
    }
    this.A = f;
    if (this.u != null) {
      this.u.a(this.A);
    }
    AppMethodBeat.o(15035);
  }
  
  public static class a
    extends s
  {
    private int x = -1;
    private int y = -1;
    private int z = -1;
    
    public a()
    {
      super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }
    
    public void a(float paramFloat)
    {
      AppMethodBeat.i(15069);
      a(this.x, c.a(paramFloat));
      AppMethodBeat.o(15069);
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(15067);
      if ((this.f == paramInt2) && (this.e == paramInt1))
      {
        AppMethodBeat.o(15067);
        return;
      }
      super.a(paramInt1, paramInt2);
      this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
      this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
      this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
      AppMethodBeat.o(15067);
    }
    
    public boolean a()
    {
      AppMethodBeat.i(15066);
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(1);
      if ((this.a != 0) && (b())) {}
      for (this.g = true;; this.g = false)
      {
        c();
        boolean bool = this.g;
        AppMethodBeat.o(15066);
        return bool;
      }
    }
    
    public void b(float paramFloat)
    {
      AppMethodBeat.i(15070);
      a(this.y, paramFloat / 3.0F);
      AppMethodBeat.o(15070);
    }
    
    public boolean b()
    {
      AppMethodBeat.i(15068);
      boolean bool = super.b();
      AppMethodBeat.o(15068);
      return bool;
    }
    
    public void c(float paramFloat)
    {
      AppMethodBeat.i(15071);
      a(this.z, paramFloat / 10.0F / 2.0F);
      AppMethodBeat.o(15071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c
 * JD-Core Version:    0.7.0.1
 */