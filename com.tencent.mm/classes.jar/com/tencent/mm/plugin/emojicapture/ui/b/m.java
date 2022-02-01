package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"})
public final class m
  extends a
{
  int gKH;
  private final int gLM;
  private final FloatBuffer hoj;
  private final int pYX;
  private final int pYY;
  private final int pYZ;
  private final int pZa;
  private final int pZb;
  private final int pZc;
  private final int pZd;
  private boolean pZi;
  private final Rect pZj;
  private float tm;
  
  private m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(869);
    this.gKH = -1;
    this.pZj = new Rect();
    Object localObject = c.hoP;
    this.gLM = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.pYY = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.pYX = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.pZa = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    this.pYZ = GLES20.glGetUniformLocation(this.gLM, "texture");
    this.pZb = GLES20.glGetUniformLocation(this.gLM, "rect");
    this.pZc = GLES20.glGetUniformLocation(this.gLM, "radius");
    this.pZd = GLES20.glGetUniformLocation(this.gLM, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hoj = ((FloatBuffer)localObject);
    AppMethodBeat.o(869);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(868);
    this.pZj.set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(868);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.pZi = paramBoolean;
    this.tm = paramFloat;
  }
  
  public final void amq()
  {
    AppMethodBeat.i(865);
    super.amq();
    this.hoj.position(0);
    this.hoj.put(this.pZj.left);
    this.hoj.put(this.gLE - this.pZj.bottom);
    this.hoj.put(this.pZj.right);
    this.hoj.put(this.gLE - this.pZj.top);
    AppMethodBeat.o(865);
  }
  
  public final void aue()
  {
    AppMethodBeat.i(866);
    if (this.gKH == -1)
    {
      AppMethodBeat.o(866);
      return;
    }
    GLES20.glViewport(this.pZj.left, this.gLE - this.pZj.bottom, this.pZj.width(), this.pZj.height());
    GLES20.glUseProgram(this.gLM);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.gKH);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.pYZ, 0);
    GLES20.glUniformMatrix4fv(this.pZa, 1, false, this.hnx, 0);
    this.gLm.position(0);
    GLES20.glVertexAttribPointer(this.pYY, 2, 5126, false, 0, (Buffer)this.gLm);
    GLES20.glEnableVertexAttribArray(this.pYY);
    this.gLl.position(0);
    GLES20.glVertexAttribPointer(this.pYX, 2, 5126, false, 0, (Buffer)this.gLl);
    GLES20.glEnableVertexAttribArray(this.pYX);
    this.hoj.position(0);
    GLES20.glUniform4fv(this.pZb, 1, this.hoj);
    GLES20.glUniform1f(this.pZc, this.tm);
    int j = this.pZd;
    if (this.pZi) {}
    for (int i = 1;; i = 0)
    {
      GLES20.glUniform1i(j, i);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.pYY);
      GLES20.glDisableVertexAttribArray(this.pYX);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      AppMethodBeat.o(866);
      return;
    }
  }
  
  public final void nN(int paramInt)
  {
    this.gKH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.m
 * JD-Core Version:    0.7.0.1
 */