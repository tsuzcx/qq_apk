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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "updateDrawViewSize", "width", "height", "Companion", "plugin-mediaeditor_release"})
public final class i
  extends a
{
  public static final a laf;
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
    AppMethodBeat.i(262880);
    laf = new a((byte)0);
    AppMethodBeat.o(262880);
  }
  
  public i()
  {
    this(0, 31);
  }
  
  private i(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(262877);
    this.kZT = -1;
    Object localObject = c.lar;
    localObject = com.tencent.mm.media.c.a.kSv;
    localObject = com.tencent.mm.media.c.a.aUe();
    a.a locala = com.tencent.mm.media.c.a.kSv;
    this.programId = c.a.aE((String)localObject, com.tencent.mm.media.c.a.aUf());
    this.kZN = GLES30.glGetUniformLocation(this.programId, "xoffset");
    this.lad = GLES30.glGetUniformLocation(this.programId, "yuvGap");
    this.ksF = GLES30.glGetUniformLocation(this.programId, "inTexture");
    this.ksD = 0;
    this.ksE = 1;
    this.kZq = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.kYB = true;
    AppMethodBeat.o(262877);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(262876);
    if (this.kZT == -1)
    {
      AppMethodBeat.o(262876);
      return;
    }
    GLES30.glUseProgram(this.programId);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.kZT);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 10497);
    GLES30.glTexParameteri(3553, 10243, 10497);
    GLES30.glUniform1i(this.ksF, 0);
    GLES30.glUniform1f(this.kZN, 1.0F / getDrawWidth() / 4.0F);
    GLES30.glUniform1f(this.lad, 0.3333333F);
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
    AppMethodBeat.o(262876);
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262874);
    super.du(paramInt1 / 4, paramInt2 * 3 / 2);
    super.dy(paramInt1 / 4, paramInt2 * 3 / 2);
    AppMethodBeat.o(262874);
  }
  
  public final void ua(int paramInt)
  {
    this.kZT = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.i
 * JD-Core Version:    0.7.0.1
 */