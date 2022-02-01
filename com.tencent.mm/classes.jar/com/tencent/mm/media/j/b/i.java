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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/RGB2YUVNV12RenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programIdUV", "programIdY", "uniformMatrixUV", "uniformMatrixY", "uniformTextureUV", "uniformTextureY", "uniformXOffsetUV", "uniformXOffsetY", "viewPortOffsetX", "getViewPortOffsetX", "()I", "setViewPortOffsetX", "(I)V", "viewPortOffsetY", "getViewPortOffsetY", "setViewPortOffsetY", "renderImpl", "", "renderUV", "renderY", "setInputTexture", "texture", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public static final i.a nFn;
  private final int mWv;
  private final int mWw;
  int nEW;
  private final int nFb;
  private final int nFc;
  private final int nFe;
  private final int nFg;
  private final int nFh;
  private final int nFi;
  private final int nFj;
  private final int nFk;
  private int nFl;
  int nFm;
  
  static
  {
    AppMethodBeat.i(237757);
    nFn = new i.a((byte)0);
    AppMethodBeat.o(237757);
  }
  
  public i()
  {
    this(0, 31);
  }
  
  private i(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(237748);
    this.nEW = -1;
    Object localObject = c.nFs;
    localObject = com.tencent.mm.media.c.a.nxX;
    localObject = com.tencent.mm.media.c.a.boI();
    a.a locala = com.tencent.mm.media.c.a.nxX;
    this.nFb = c.a.aN((String)localObject, com.tencent.mm.media.c.a.boJ());
    this.nFc = GLES30.glGetUniformLocation(this.nFb, "xoffset");
    this.nFe = GLES30.glGetUniformLocation(this.nFb, "inTexture");
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
    AppMethodBeat.o(237748);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(237763);
    if (this.nEW == -1)
    {
      AppMethodBeat.o(237763);
      return;
    }
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.nEW);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
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
    GLES30.glViewport(this.nFl, this.nFm, getDrawWidth(), getDrawHeight() / 3);
    GLES30.glUseProgram(this.nFb);
    GLES30.glUniform1i(this.nFe, 0);
    GLES30.glUniform1f(this.nFc, 1.0F / getDrawWidth() / 4.0F);
    GLES30.glUniformMatrix4fv(this.nFg, 1, false, bpY(), 0);
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
    AppMethodBeat.o(237763);
  }
  
  public final void uc(int paramInt)
  {
    this.nEW = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.i
 * JD-Core Version:    0.7.0.1
 */