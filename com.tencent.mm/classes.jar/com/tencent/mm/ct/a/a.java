package com.tencent.mm.ct.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a
{
  private final LinkedList<Runnable> YFU;
  private final String YFV;
  private final String YFW;
  protected int YFX;
  protected int YFY;
  protected int YFZ;
  protected int YGa;
  private boolean YGb;
  protected int mOutputHeight;
  protected int mOutputWidth;
  
  public a()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187932);
    this.YFU = new LinkedList();
    this.YFV = paramString1;
    this.YFW = paramString2;
    AppMethodBeat.o(187932);
  }
  
  public void Pu()
  {
    int j = 0;
    AppMethodBeat.i(187939);
    String str1 = this.YFV;
    String str2 = this.YFW;
    int[] arrayOfInt = new int[1];
    int m = h.au(str1, 35633);
    int i;
    if (m == 0) {
      i = j;
    }
    for (;;)
    {
      this.YFX = i;
      this.YFY = GLES20.glGetAttribLocation(this.YFX, "position");
      this.YFZ = GLES20.glGetUniformLocation(this.YFX, "inputImageTexture");
      this.YGa = GLES20.glGetAttribLocation(this.YFX, "inputTextureCoordinate");
      this.YGb = true;
      AppMethodBeat.o(187939);
      return;
      int n = h.au(str2, 35632);
      i = j;
      if (n != 0)
      {
        int k = GLES20.glCreateProgram();
        GLES20.glAttachShader(k, m);
        GLES20.glAttachShader(k, n);
        GLES20.glLinkProgram(k);
        GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
        i = j;
        if (arrayOfInt[0] > 0)
        {
          GLES20.glDeleteShader(m);
          GLES20.glDeleteShader(n);
          i = k;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(187947);
    GLES20.glUseProgram(this.YFX);
    igs();
    if (!this.YGb)
    {
      AppMethodBeat.o(187947);
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.YFY, 2, 5126, false, 8, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.YFY);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.YGa, 2, 5126, false, 8, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.YGa);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.YFZ, 0);
    }
    b(paramFloatBuffer2);
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.YFY);
    GLES20.glDisableVertexAttribArray(this.YGa);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(187947);
  }
  
  protected final void aY(Runnable paramRunnable)
  {
    AppMethodBeat.i(187976);
    synchronized (this.YFU)
    {
      this.YFU.addLast(paramRunnable);
      AppMethodBeat.o(187976);
      return;
    }
  }
  
  public void azg(int paramInt) {}
  
  protected void b(FloatBuffer paramFloatBuffer) {}
  
  public void dc(float paramFloat) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(187940);
    this.YGb = false;
    GLES20.glDeleteProgram(this.YFX);
    onDestroy();
    AppMethodBeat.o(187940);
  }
  
  protected final void igs()
  {
    AppMethodBeat.i(187956);
    while (!this.YFU.isEmpty()) {
      ((Runnable)this.YFU.removeFirst()).run();
    }
    AppMethodBeat.o(187956);
  }
  
  public final int igt()
  {
    return this.YFX;
  }
  
  public final void init()
  {
    AppMethodBeat.i(187936);
    Pu();
    this.YGb = true;
    AppMethodBeat.o(187936);
  }
  
  public final boolean isInitialized()
  {
    return this.YGb;
  }
  
  public void nj(int paramInt1, int paramInt2)
  {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
  
  protected final void nk(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(187967);
    aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187918);
        GLES20.glUniform1i(paramInt1, paramInt2);
        AppMethodBeat.o(187918);
      }
    });
    AppMethodBeat.o(187967);
  }
  
  public void onDestroy() {}
  
  protected final void setFloat(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(187970);
    aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187924);
        GLES20.glUniform1f(paramInt, paramFloat);
        AppMethodBeat.o(187924);
      }
    });
    AppMethodBeat.o(187970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.a
 * JD-Core Version:    0.7.0.1
 */