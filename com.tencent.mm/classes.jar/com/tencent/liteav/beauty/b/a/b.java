package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.r;

public class b
  extends r
{
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private final String x = "BeautyBlend";
  
  public b()
  {
    super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  private void q()
  {
    this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
    this.r = GLES20.glGetUniformLocation(p(), "contrast");
    this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
  }
  
  public void a(float paramFloat)
  {
    TXCLog.i("BeautyBlend", "setBrightLevel " + paramFloat);
    a(this.s, paramFloat);
  }
  
  public boolean a()
  {
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(12);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      return this.g;
    }
  }
  
  public void b(float paramFloat)
  {
    a(this.t, paramFloat / 2.0F);
  }
  
  public boolean b()
  {
    super.b();
    q();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.b
 * JD-Core Version:    0.7.0.1
 */