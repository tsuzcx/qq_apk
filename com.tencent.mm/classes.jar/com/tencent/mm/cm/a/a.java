package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a
{
  private final LinkedList<Runnable> Rfa;
  private final String Rfb;
  private final String Rfc;
  protected int Rfd;
  protected int Rfe;
  protected int Rff;
  protected int Rfg;
  boolean Rfh;
  protected int mOutputHeight;
  protected int mOutputWidth;
  
  public a()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190218);
    this.Rfa = new LinkedList();
    this.Rfb = paramString1;
    this.Rfc = paramString2;
    AppMethodBeat.o(190218);
  }
  
  public void MC()
  {
    int j = 0;
    AppMethodBeat.i(190220);
    String str1 = this.Rfb;
    String str2 = this.Rfc;
    int[] arrayOfInt = new int[1];
    int m = i.ac(str1, 35633);
    int i;
    if (m == 0) {
      i = j;
    }
    for (;;)
    {
      this.Rfd = i;
      this.Rfe = GLES20.glGetAttribLocation(this.Rfd, "position");
      this.Rff = GLES20.glGetUniformLocation(this.Rfd, "inputImageTexture");
      this.Rfg = GLES20.glGetAttribLocation(this.Rfd, "inputTextureCoordinate");
      this.Rfh = true;
      AppMethodBeat.o(190220);
      return;
      int n = i.ac(str2, 35632);
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
    AppMethodBeat.i(190222);
    GLES20.glUseProgram(this.Rfd);
    heZ();
    if (!this.Rfh)
    {
      AppMethodBeat.o(190222);
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.Rfe, 2, 5126, false, 8, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.Rfe);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.Rfg, 2, 5126, false, 8, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.Rfg);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.Rff, 0);
    }
    b(paramFloatBuffer2);
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.Rfe);
    GLES20.glDisableVertexAttribArray(this.Rfg);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(190222);
  }
  
  protected final void aR(Runnable paramRunnable)
  {
    AppMethodBeat.i(190226);
    synchronized (this.Rfa)
    {
      this.Rfa.addLast(paramRunnable);
      AppMethodBeat.o(190226);
      return;
    }
  }
  
  public void apH(int paramInt) {}
  
  protected void b(FloatBuffer paramFloatBuffer) {}
  
  public void cH(float paramFloat) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(190221);
    this.Rfh = false;
    GLES20.glDeleteProgram(this.Rfd);
    onDestroy();
    AppMethodBeat.o(190221);
  }
  
  protected final void heZ()
  {
    AppMethodBeat.i(190223);
    while (!this.Rfa.isEmpty()) {
      ((Runnable)this.Rfa.removeFirst()).run();
    }
    AppMethodBeat.o(190223);
  }
  
  public final int hfa()
  {
    return this.Rfd;
  }
  
  public final void init()
  {
    AppMethodBeat.i(190219);
    MC();
    this.Rfh = true;
    AppMethodBeat.o(190219);
  }
  
  public void lS(int paramInt1, int paramInt2)
  {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
  
  protected final void lT(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(190224);
    aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190216);
        GLES20.glUniform1i(paramInt1, paramInt2);
        AppMethodBeat.o(190216);
      }
    });
    AppMethodBeat.o(190224);
  }
  
  public void onDestroy() {}
  
  protected final void setFloat(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(190225);
    aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190217);
        GLES20.glUniform1f(paramInt, paramFloat);
        AppMethodBeat.o(190217);
      }
    });
    AppMethodBeat.o(190225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.a
 * JD-Core Version:    0.7.0.1
 */