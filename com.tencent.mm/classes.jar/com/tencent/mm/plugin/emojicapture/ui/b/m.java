package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
{
  private float dwJ;
  int mVb;
  private final FloatBuffer nEt;
  private final int programId;
  private final int ynY;
  private final int ynZ;
  private final int yoa;
  private final int yob;
  private final int yoc;
  private final int yod;
  private final int yoe;
  private boolean yoj;
  private final Rect yok;
  
  private m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(869);
    this.mVb = -1;
    this.yok = new Rect();
    Object localObject = c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.ynZ = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ynY = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.yob = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.yoa = GLES20.glGetUniformLocation(this.programId, "texture");
    this.yoc = GLES20.glGetUniformLocation(this.programId, "rect");
    this.yod = GLES20.glGetUniformLocation(this.programId, "radius");
    this.yoe = GLES20.glGetUniformLocation(this.programId, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(4 * 4).or…eOrder()).asFloatBuffer()");
    this.nEt = ((FloatBuffer)localObject);
    AppMethodBeat.o(869);
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(868);
    this.yok.set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(868);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.yoj = paramBoolean;
    this.dwJ = paramFloat;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(865);
    super.bgB();
    this.nEt.position(0);
    this.nEt.put(this.yok.left);
    this.nEt.put(getDrawHeight() - this.yok.bottom);
    this.nEt.put(this.yok.right);
    this.nEt.put(getDrawHeight() - this.yok.top);
    AppMethodBeat.o(865);
  }
  
  public final void bqg()
  {
    AppMethodBeat.i(866);
    if (this.mVb == -1)
    {
      AppMethodBeat.o(866);
      return;
    }
    GLES20.glViewport(this.yok.left, getDrawHeight() - this.yok.bottom, this.yok.width(), this.yok.height());
    GLES20.glUseProgram(this.programId);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mVb);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.yoa, 0);
    GLES20.glUniformMatrix4fv(this.yob, 1, false, bpY(), 0);
    bpW().position(0);
    GLES20.glVertexAttribPointer(this.ynZ, 2, 5126, false, 0, (Buffer)bpW());
    GLES20.glEnableVertexAttribArray(this.ynZ);
    bpV().position(0);
    GLES20.glVertexAttribPointer(this.ynY, 2, 5126, false, 0, (Buffer)bpV());
    GLES20.glEnableVertexAttribArray(this.ynY);
    this.nEt.position(0);
    GLES20.glUniform4fv(this.yoc, 1, this.nEt);
    GLES20.glUniform1f(this.yod, this.dwJ);
    int j = this.yoe;
    if (this.yoj) {}
    for (int i = 1;; i = 0)
    {
      GLES20.glUniform1i(j, i);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.ynZ);
      GLES20.glDisableVertexAttribArray(this.ynY);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      AppMethodBeat.o(866);
      return;
    }
  }
  
  public final void uc(int paramInt)
  {
    this.mVb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.m
 * JD-Core Version:    0.7.0.1
 */