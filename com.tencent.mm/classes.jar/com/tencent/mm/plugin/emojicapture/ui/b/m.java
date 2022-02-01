package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"})
public final class m
  extends a
{
  int hDl;
  private final FloatBuffer ikt;
  private final int programId;
  private final int rwA;
  private final int rwB;
  private final int rwC;
  private final int rwD;
  private final int rwE;
  private final int rwF;
  private boolean rwK;
  private final Rect rwL;
  private final int rwz;
  private float tt;
  
  private m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(869);
    this.hDl = -1;
    this.rwL = new Rect();
    Object localObject = c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.rwA = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.rwz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.rwC = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.rwB = GLES20.glGetUniformLocation(this.programId, "texture");
    this.rwD = GLES20.glGetUniformLocation(this.programId, "rect");
    this.rwE = GLES20.glGetUniformLocation(this.programId, "radius");
    this.rwF = GLES20.glGetUniformLocation(this.programId, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ikt = ((FloatBuffer)localObject);
    AppMethodBeat.o(869);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(868);
    this.rwL.set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(868);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.rwK = paramBoolean;
    this.tt = paramFloat;
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(865);
    super.aEB();
    this.ikt.position(0);
    this.ikt.put(this.rwL.left);
    this.ikt.put(this.hEq - this.rwL.bottom);
    this.ikt.put(this.rwL.right);
    this.ikt.put(this.hEq - this.rwL.top);
    AppMethodBeat.o(865);
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(866);
    if (this.hDl == -1)
    {
      AppMethodBeat.o(866);
      return;
    }
    GLES20.glViewport(this.rwL.left, this.hEq - this.rwL.bottom, this.rwL.width(), this.rwL.height());
    GLES20.glUseProgram(this.programId);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.hDl);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.rwB, 0);
    GLES20.glUniformMatrix4fv(this.rwC, 1, false, this.ijG, 0);
    this.hDU.position(0);
    GLES20.glVertexAttribPointer(this.rwA, 2, 5126, false, 0, (Buffer)this.hDU);
    GLES20.glEnableVertexAttribArray(this.rwA);
    this.hDT.position(0);
    GLES20.glVertexAttribPointer(this.rwz, 2, 5126, false, 0, (Buffer)this.hDT);
    GLES20.glEnableVertexAttribArray(this.rwz);
    this.ikt.position(0);
    GLES20.glUniform4fv(this.rwD, 1, this.ikt);
    GLES20.glUniform1f(this.rwE, this.tt);
    int j = this.rwF;
    if (this.rwK) {}
    for (int i = 1;; i = 0)
    {
      GLES20.glUniform1i(j, i);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.rwA);
      GLES20.glDisableVertexAttribArray(this.rwz);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      AppMethodBeat.o(866);
      return;
    }
  }
  
  public final void rl(int paramInt)
  {
    this.hDl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.m
 * JD-Core Version:    0.7.0.1
 */