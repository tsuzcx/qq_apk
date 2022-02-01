package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class x
  extends g
{
  private static final float[] A = { 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F };
  protected static final short[] v = { 1, 2, 0, 2, 0, 3 };
  private static final float[] z = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  private String B;
  protected a[] r;
  protected List<c.e> s;
  protected boolean t;
  protected int u;
  protected ShortBuffer w;
  private a x;
  private int y;
  
  public x()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public x(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(14969);
    this.r = null;
    this.x = null;
    this.s = null;
    this.t = false;
    this.u = 1;
    this.y = 1;
    this.w = null;
    this.B = "GPUWatermark";
    paramString1 = ByteBuffer.allocateDirect(v.length * 2);
    paramString1.order(ByteOrder.nativeOrder());
    this.w = paramString1.asShortBuffer();
    this.w.put(v);
    this.w.position(0);
    this.o = true;
    AppMethodBeat.o(14969);
  }
  
  private void q()
  {
    AppMethodBeat.i(14974);
    if (this.r != null)
    {
      int i = 0;
      while (i < this.r.length)
      {
        if (this.r[i] != null)
        {
          if (this.r[i].d != null) {
            GLES20.glDeleteTextures(1, this.r[i].d, 0);
          }
          this.r[i].d = null;
          this.r[i].c = null;
          this.r[i] = null;
        }
        i += 1;
      }
    }
    this.r = null;
    AppMethodBeat.o(14974);
  }
  
  protected void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(14972);
    Object localObject = ByteBuffer.allocateDirect(z.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.r[paramInt3].a = ((ByteBuffer)localObject).asFloatBuffer();
    localObject = new float[z.length];
    float f = paramInt2 / paramInt1 * paramFloat3 * this.e / this.f;
    localObject[0] = (2.0F * paramFloat1 - 1.0F);
    localObject[1] = (1.0F - 2.0F * paramFloat2);
    localObject[2] = localObject[0];
    localObject[3] = (localObject[1] - f * 2.0F);
    localObject[4] = (localObject[0] + 2.0F * paramFloat3);
    localObject[5] = localObject[3];
    localObject[6] = localObject[4];
    localObject[7] = localObject[1];
    paramInt1 = i;
    while (paramInt1 <= 7)
    {
      localObject[paramInt1] *= -1.0F;
      paramInt1 += 2;
    }
    this.r[paramInt3].a.put((float[])localObject);
    this.r[paramInt3].a.position(0);
    localObject = ByteBuffer.allocateDirect(A.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.r[paramInt3].b = ((ByteBuffer)localObject).asFloatBuffer();
    this.r[paramInt3].b.put(A);
    this.r[paramInt3].b.position(0);
    AppMethodBeat.o(14972);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(14973);
    if (this.r == null) {
      this.r = new a[1];
    }
    if (this.r[0] == null) {
      this.r[0] = new a();
    }
    a(paramBitmap, paramFloat1, paramFloat2, paramFloat3, 0);
    this.x = this.r[0];
    AppMethodBeat.o(14973);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(14971);
    if (paramBitmap == null)
    {
      if ((this.r != null) && (this.r[paramInt] != null))
      {
        new StringBuilder("release ").append(paramInt).append(" water mark!");
        if (this.r[paramInt].d != null) {
          GLES20.glDeleteTextures(1, this.r[paramInt].d, 0);
        }
        this.r[paramInt].d = null;
        this.r[paramInt].c = null;
        this.r[paramInt] = null;
      }
      AppMethodBeat.o(14971);
      return;
    }
    if ((this.r[paramInt] == null) || (paramInt >= this.r.length))
    {
      AppMethodBeat.o(14971);
      return;
    }
    a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramFloat1, paramFloat2, paramFloat3, paramInt);
    if (this.r[paramInt].d == null)
    {
      this.r[paramInt].d = new int[1];
      GLES20.glGenTextures(1, this.r[paramInt].d, 0);
      GLES20.glBindTexture(3553, this.r[paramInt].d[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    if ((this.r[paramInt].c == null) || (!this.r[paramInt].c.equals(paramBitmap)))
    {
      GLES20.glBindTexture(3553, this.r[paramInt].d[0]);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    this.r[paramInt].c = paramBitmap;
    AppMethodBeat.o(14971);
  }
  
  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void d()
  {
    AppMethodBeat.i(14970);
    super.d();
    this.t = false;
    q();
    AppMethodBeat.o(14970);
  }
  
  public void j()
  {
    AppMethodBeat.i(14975);
    super.j();
    if (this.t)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(this.u, 771);
      GLES20.glActiveTexture(33984);
      int i = 0;
      while (i < this.r.length)
      {
        if (this.r[i] != null)
        {
          GLES20.glBindTexture(3553, this.r[i].d[0]);
          GLES20.glUniform1i(this.c, 0);
          GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, this.r[i].a);
          GLES20.glEnableVertexAttribArray(this.b);
          GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 16, this.r[i].b);
          GLES20.glEnableVertexAttribArray(this.d);
          GLES20.glDrawElements(4, v.length, 5123, this.w);
          GLES20.glDisableVertexAttribArray(this.b);
          GLES20.glDisableVertexAttribArray(this.d);
        }
        i += 1;
      }
      GLES20.glDisable(3042);
    }
    AppMethodBeat.o(14975);
  }
  
  public class a
  {
    public FloatBuffer a = null;
    public FloatBuffer b = null;
    public Bitmap c;
    public int[] d = null;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.x
 * JD-Core Version:    0.7.0.1
 */