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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"})
public final class m
  extends a
{
  int gNq;
  private final int gOv;
  private final FloatBuffer hqX;
  private final int qfC;
  private final int qfD;
  private final int qfE;
  private final int qfF;
  private final int qfG;
  private final int qfH;
  private final int qfI;
  private boolean qfN;
  private final Rect qfO;
  private float tm;
  
  private m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(869);
    this.gNq = -1;
    this.qfO = new Rect();
    Object localObject = c.hrD;
    this.gOv = c.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.qfD = GLES20.glGetAttribLocation(this.gOv, "a_position");
    this.qfC = GLES20.glGetAttribLocation(this.gOv, "a_texCoord");
    this.qfF = GLES20.glGetUniformLocation(this.gOv, "uMatrix");
    this.qfE = GLES20.glGetUniformLocation(this.gOv, "texture");
    this.qfG = GLES20.glGetUniformLocation(this.gOv, "rect");
    this.qfH = GLES20.glGetUniformLocation(this.gOv, "radius");
    this.qfI = GLES20.glGetUniformLocation(this.gOv, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hqX = ((FloatBuffer)localObject);
    AppMethodBeat.o(869);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(868);
    this.qfO.set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(868);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.qfN = paramBoolean;
    this.tm = paramFloat;
  }
  
  public final void amF()
  {
    AppMethodBeat.i(865);
    super.amF();
    this.hqX.position(0);
    this.hqX.put(this.qfO.left);
    this.hqX.put(this.gOn - this.qfO.bottom);
    this.hqX.put(this.qfO.right);
    this.hqX.put(this.gOn - this.qfO.top);
    AppMethodBeat.o(865);
  }
  
  public final void aut()
  {
    AppMethodBeat.i(866);
    if (this.gNq == -1)
    {
      AppMethodBeat.o(866);
      return;
    }
    GLES20.glViewport(this.qfO.left, this.gOn - this.qfO.bottom, this.qfO.width(), this.qfO.height());
    GLES20.glUseProgram(this.gOv);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.gNq);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.qfE, 0);
    GLES20.glUniformMatrix4fv(this.qfF, 1, false, this.hql, 0);
    this.gNV.position(0);
    GLES20.glVertexAttribPointer(this.qfD, 2, 5126, false, 0, (Buffer)this.gNV);
    GLES20.glEnableVertexAttribArray(this.qfD);
    this.gNU.position(0);
    GLES20.glVertexAttribPointer(this.qfC, 2, 5126, false, 0, (Buffer)this.gNU);
    GLES20.glEnableVertexAttribArray(this.qfC);
    this.hqX.position(0);
    GLES20.glUniform4fv(this.qfG, 1, this.hqX);
    GLES20.glUniform1f(this.qfH, this.tm);
    int j = this.qfI;
    if (this.qfN) {}
    for (int i = 1;; i = 0)
    {
      GLES20.glUniform1i(j, i);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.qfD);
      GLES20.glDisableVertexAttribArray(this.qfC);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      AppMethodBeat.o(866);
      return;
    }
  }
  
  public final void nQ(int paramInt)
  {
    this.gNq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.m
 * JD-Core Version:    0.7.0.1
 */