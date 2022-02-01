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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "updateDrawViewSize", "width", "height", "Companion", "plugin-mediaeditor_release"})
public final class i
  extends a
{
  public static final i.a ilk;
  private final int hEA;
  private final int hEy;
  private final int hEz;
  private final int ikT;
  public int ikZ;
  private final int ikw;
  private final int ili;
  private final int programId;
  
  static
  {
    AppMethodBeat.i(218785);
    ilk = new i.a((byte)0);
    AppMethodBeat.o(218785);
  }
  
  public i()
  {
    this(0, 31);
  }
  
  private i(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(218783);
    this.ikZ = -1;
    Object localObject = c.ilt;
    localObject = com.tencent.mm.media.c.a.idP;
    localObject = com.tencent.mm.media.c.a.aLV();
    a.a locala = com.tencent.mm.media.c.a.idP;
    this.programId = c.a.aB((String)localObject, com.tencent.mm.media.c.a.aLW());
    this.ikT = GLES30.glGetUniformLocation(this.programId, "xoffset");
    this.ili = GLES30.glGetUniformLocation(this.programId, "yuvGap");
    this.hEA = GLES30.glGetUniformLocation(this.programId, "inTexture");
    this.hEy = 0;
    this.hEz = 1;
    this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.ijH = true;
    AppMethodBeat.o(218783);
  }
  
  protected final void aMV()
  {
    AppMethodBeat.i(218782);
    if (this.ikZ == -1)
    {
      AppMethodBeat.o(218782);
      return;
    }
    GLES30.glUseProgram(this.programId);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(3553, this.ikZ);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9729);
    GLES30.glTexParameteri(3553, 10242, 10497);
    GLES30.glTexParameteri(3553, 10243, 10497);
    GLES30.glUniform1i(this.hEA, 0);
    GLES30.glUniform1f(this.ikT, 1.0F / this.hEp / 4.0F);
    GLES30.glUniform1f(this.ili, 0.3333333F);
    GLES30.glUniformMatrix4fv(this.ikw, 1, false, this.ijG, 0);
    this.hDU.position(0);
    GLES30.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer)this.hDU);
    GLES30.glEnableVertexAttribArray(this.hEy);
    this.hDT.position(0);
    GLES30.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer)this.hDT);
    GLES30.glEnableVertexAttribArray(this.hEz);
    GLES30.glDrawArrays(5, 0, 4);
    GLES30.glDisableVertexAttribArray(this.hEy);
    GLES30.glDisableVertexAttribArray(this.hEz);
    GLES30.glBindTexture(3553, 0);
    GLES30.glBindTexture(36197, 0);
    AppMethodBeat.o(218782);
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218781);
    super.cY(paramInt1 / 4, paramInt2 * 3 / 2);
    super.dc(paramInt1 / 4, paramInt2 * 3 / 2);
    AppMethodBeat.o(218781);
  }
  
  public final void rl(int paramInt)
  {
    this.ikZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.i
 * JD-Core Version:    0.7.0.1
 */