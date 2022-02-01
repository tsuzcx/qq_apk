package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a.a;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/RGB2YUVI420RenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programIdUV", "programIdY", "uniformMatrixUV", "uniformMatrixY", "uniformPreMultipUV", "uniformTextureUV", "uniformTextureY", "uniformXOffsetUV", "uniformXOffsetY", "uniformYOffsetUV", "viewPortOffsetX", "getViewPortOffsetX", "()I", "setViewPortOffsetX", "(I)V", "viewPortOffsetY", "getViewPortOffsetY", "setViewPortOffsetY", "renderImpl", "", "renderUV", "isU", "", "renderY", "setInputTexture", "texture", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  public static final h.a nFa;
  private final int mWv;
  private final int mWw;
  public int nEW;
  private final int nFb;
  private final int nFc;
  private final int nFd;
  private final int nFe;
  private final int nFf;
  private final int nFg;
  private final int nFh;
  private final int nFi;
  private final int nFj;
  private final int nFk;
  private int nFl;
  int nFm;
  
  static
  {
    AppMethodBeat.i(237764);
    nFa = new h.a((byte)0);
    AppMethodBeat.o(237764);
  }
  
  public h()
  {
    this(0, 31);
  }
  
  private h(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(237752);
    this.nEW = -1;
    Object localObject = c.nFs;
    localObject = com.tencent.mm.media.c.a.nxX;
    localObject = com.tencent.mm.media.c.a.boK();
    a.a locala = com.tencent.mm.media.c.a.nxX;
    this.nFb = c.a.aN((String)localObject, com.tencent.mm.media.c.a.boM());
    this.nFc = GLES30.glGetUniformLocation(this.nFb, "xoffset");
    this.nFd = GLES30.glGetUniformLocation(this.nFb, "yoffset");
    this.nFe = GLES30.glGetUniformLocation(this.nFb, "inTexture");
    this.nFf = GLES30.glGetUniformLocation(this.nFb, "preMultip");
    this.nFg = GLES20.glGetUniformLocation(this.nFb, "uMatrix");
    localObject = c.nFs;
    localObject = com.tencent.mm.media.c.a.nxX;
    localObject = com.tencent.mm.media.c.a.boI();
    locala = com.tencent.mm.media.c.a.nxX;
    this.nFh = c.a.aN((String)localObject, com.tencent.mm.media.c.a.boL());
    this.nFi = GLES30.glGetUniformLocation(this.nFh, "xoffset");
    this.nFj = GLES30.glGetUniformLocation(this.nFh, "inTexture");
    this.nFk = GLES20.glGetUniformLocation(this.nFh, "uMatrix");
    this.mWv = 0;
    this.mWw = 1;
    gq(true);
    AppMethodBeat.o(237752);
  }
  
  private final void gs(boolean paramBoolean)
  {
    AppMethodBeat.i(237759);
    int j = this.nFl;
    int k = this.nFm;
    int i;
    if (paramBoolean)
    {
      i = getDrawHeight() / 6;
      GLES30.glViewport(j, i + k, getDrawWidth(), getDrawHeight() / 6);
      GLES30.glUseProgram(this.nFb);
      GLES30.glUniform1i(this.nFe, 0);
      GLES30.glUniform1f(this.nFc, 1.0F / getDrawWidth() / 4.0F);
      GLES30.glUniform1f(this.nFd, 1.0F / getDrawHeight());
      if (!paramBoolean) {
        break label214;
      }
      GLES30.glUniform4f(this.nFf, -0.168736F, -0.331264F, 0.5F, 0.0F);
    }
    for (;;)
    {
      GLES30.glUniformMatrix4fv(this.nFg, 1, false, bpY(), 0);
      bpW().position(0);
      GLES30.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, (Buffer)bpW());
      GLES30.glEnableVertexAttribArray(this.mWv);
      bpV().position(0);
      GLES30.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, (Buffer)bpV());
      GLES30.glEnableVertexAttribArray(this.mWw);
      GLES30.glDrawArrays(5, 0, 4);
      AppMethodBeat.o(237759);
      return;
      i = 0;
      break;
      label214:
      GLES30.glUniform4f(this.nFf, 0.5F, -0.418688F, -0.081312F, 0.0F);
    }
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(237769);
    if (this.nEW == -1)
    {
      AppMethodBeat.o(237769);
      return;
    }
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.nEW);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
    gs(true);
    gs(false);
    GLES30.glViewport(this.nFl, this.nFm + getDrawHeight() / 3, getDrawWidth(), getDrawHeight() / 3 * 2);
    GLES30.glUseProgram(this.nFh);
    GLES30.glUniform1i(this.nFj, 0);
    GLES30.glUniform1f(this.nFi, 1.0F / getDrawWidth() / 4.0F);
    GLES30.glUniformMatrix4fv(this.nFk, 1, false, bpY(), 0);
    bpW().position(0);
    GLES30.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, (Buffer)bpW());
    GLES30.glEnableVertexAttribArray(this.mWv);
    bpV().position(0);
    GLES30.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, (Buffer)bpV());
    GLES30.glEnableVertexAttribArray(this.mWw);
    GLES30.glDrawArrays(5, 0, 4);
    GLES30.glDisableVertexAttribArray(this.mWv);
    GLES30.glDisableVertexAttribArray(this.mWw);
    GLES30.glBindTexture(3553, 0);
    GLES30.glBindTexture(36197, 0);
    AppMethodBeat.o(237769);
  }
  
  public final void uc(int paramInt)
  {
    this.nEW = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.h
 * JD-Core Version:    0.7.0.1
 */