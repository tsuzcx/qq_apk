package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "Companion", "plugin-mediaeditor_release"})
public final class h
  extends a
{
  public static final a lae;
  private final int kZN;
  public int kZT;
  private final int kZq;
  private final int ksD;
  private final int ksE;
  private final int ksF;
  private final int lad;
  private final int programId;
  
  static
  {
    AppMethodBeat.i(258134);
    lae = new a((byte)0);
    AppMethodBeat.o(258134);
  }
  
  public h()
  {
    this(0, 31);
  }
  
  private h(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(258131);
    this.kZT = -1;
    Object localObject = c.lar;
    localObject = com.tencent.mm.media.c.a.kSv;
    localObject = com.tencent.mm.media.c.a.aUe();
    a.a locala = com.tencent.mm.media.c.a.kSv;
    this.programId = c.a.aE((String)localObject, com.tencent.mm.media.c.a.aUg());
    this.kZN = GLES30.glGetUniformLocation(this.programId, "xoffset");
    this.lad = GLES30.glGetUniformLocation(this.programId, "yuvGap");
    this.ksF = GLES30.glGetUniformLocation(this.programId, "inTexture");
    this.ksD = 0;
    this.ksE = 1;
    this.kZq = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.kYB = true;
    AppMethodBeat.o(258131);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(258130);
    if (this.kZT == -1)
    {
      AppMethodBeat.o(258130);
      return;
    }
    GLES30.glUseProgram(this.programId);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.kZT);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
    GLES30.glUniform1i(this.ksF, 0);
    GLES30.glUniform1f(this.kZN, 1.0F / aVx());
    if (aVy() % 3 == 0) {
      GLES30.glUniform1f(this.lad, 0.3333333F);
    }
    for (;;)
    {
      GLES30.glUniformMatrix4fv(this.kZq, 1, false, aVo(), 0);
      aVm().position(0);
      GLES30.glVertexAttribPointer(this.ksD, 2, 5126, false, 0, (Buffer)aVm());
      GLES30.glEnableVertexAttribArray(this.ksD);
      aVl().position(0);
      GLES30.glVertexAttribPointer(this.ksE, 2, 5126, false, 0, (Buffer)aVl());
      GLES30.glEnableVertexAttribArray(this.ksE);
      GLES30.glDrawArrays(5, 0, 4);
      GLES30.glDisableVertexAttribArray(this.ksD);
      GLES30.glDisableVertexAttribArray(this.ksE);
      GLES30.glBindTexture(3553, 0);
      GLES30.glBindTexture(36197, 0);
      AppMethodBeat.o(258130);
      return;
      float f = aVy() % 3 * 1.0F / aVy() / 2.0F;
      GLES30.glUniform1f(this.lad, 0.3333333F - f);
    }
  }
  
  public final void ua(int paramInt)
  {
    this.kZT = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.h
 * JD-Core Version:    0.7.0.1
 */