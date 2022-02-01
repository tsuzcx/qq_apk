package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a
{
  private final LinkedList<Runnable> agBC;
  private final String agBD;
  private final String agBE;
  protected int agBF;
  protected int agBG;
  protected int agBH;
  protected int agBI;
  private boolean agBJ;
  protected int mOutputHeight;
  protected int mOutputWidth;
  
  public a()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(231146);
    this.agBC = new LinkedList();
    this.agBD = paramString1;
    this.agBE = paramString2;
    AppMethodBeat.o(231146);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(231183);
    GLES20.glUseProgram(this.agBF);
    jLF();
    if (!this.agBJ)
    {
      AppMethodBeat.o(231183);
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.agBG, 2, 5126, false, 8, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.agBG);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.agBI, 2, 5126, false, 8, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.agBI);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.agBH, 0);
    }
    b(paramFloatBuffer2);
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.agBG);
    GLES20.glDisableVertexAttribArray(this.agBI);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(231183);
  }
  
  public void aFK(int paramInt) {}
  
  public void apC()
  {
    int j = 0;
    AppMethodBeat.i(231165);
    String str1 = this.agBD;
    String str2 = this.agBE;
    int[] arrayOfInt = new int[1];
    int m = h.aD(str1, 35633);
    int i;
    if (m == 0) {
      i = j;
    }
    for (;;)
    {
      this.agBF = i;
      this.agBG = GLES20.glGetAttribLocation(this.agBF, "position");
      this.agBH = GLES20.glGetUniformLocation(this.agBF, "inputImageTexture");
      this.agBI = GLES20.glGetAttribLocation(this.agBF, "inputTextureCoordinate");
      this.agBJ = true;
      AppMethodBeat.o(231165);
      return;
      int n = h.aD(str2, 35632);
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
  
  protected void b(FloatBuffer paramFloatBuffer) {}
  
  protected final void bg(Runnable paramRunnable)
  {
    AppMethodBeat.i(231207);
    synchronized (this.agBC)
    {
      this.agBC.addLast(paramRunnable);
      AppMethodBeat.o(231207);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(231169);
    this.agBJ = false;
    GLES20.glDeleteProgram(this.agBF);
    onDestroy();
    AppMethodBeat.o(231169);
  }
  
  public void er(float paramFloat) {}
  
  public final void init()
  {
    AppMethodBeat.i(231155);
    apC();
    this.agBJ = true;
    AppMethodBeat.o(231155);
  }
  
  public final boolean isInitialized()
  {
    return this.agBJ;
  }
  
  protected final void jLF()
  {
    AppMethodBeat.i(231186);
    while (!this.agBC.isEmpty()) {
      ((Runnable)this.agBC.removeFirst()).run();
    }
    AppMethodBeat.o(231186);
  }
  
  public final int jLG()
  {
    return this.agBF;
  }
  
  public void onDestroy() {}
  
  public void pg(int paramInt1, int paramInt2)
  {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
  
  protected final void ph(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(231200);
    bg(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231106);
        GLES20.glUniform1i(paramInt1, paramInt2);
        AppMethodBeat.o(231106);
      }
    });
    AppMethodBeat.o(231200);
  }
  
  protected final void setFloat(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(231203);
    bg(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231102);
        GLES20.glUniform1f(paramInt, paramFloat);
        AppMethodBeat.o(231102);
      }
    });
    AppMethodBeat.o(231203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.a
 * JD-Core Version:    0.7.0.1
 */