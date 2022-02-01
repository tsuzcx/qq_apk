package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"})
public final class m
  extends a
{
  private final FloatBuffer gWd;
  int gqX;
  private final int gse;
  private boolean pvD;
  private final Rect pvE;
  private final int pvs;
  private final int pvt;
  private final int pvu;
  private final int pvv;
  private final int pvw;
  private final int pvx;
  private final int pvy;
  private float rs;
  
  private m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(869);
    this.gqX = -1;
    this.pvE = new Rect();
    Object localObject = c.gWJ;
    this.gse = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.pvt = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.pvs = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.pvv = GLES20.glGetUniformLocation(this.gse, "uMatrix");
    this.pvu = GLES20.glGetUniformLocation(this.gse, "texture");
    this.pvw = GLES20.glGetUniformLocation(this.gse, "rect");
    this.pvx = GLES20.glGetUniformLocation(this.gse, "radius");
    this.pvy = GLES20.glGetUniformLocation(this.gse, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gWd = ((FloatBuffer)localObject);
    AppMethodBeat.o(869);
  }
  
  public final void B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(868);
    this.pvE.set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(868);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.pvD = paramBoolean;
    this.rs = paramFloat;
  }
  
  public final void ajE()
  {
    AppMethodBeat.i(865);
    super.ajE();
    this.gWd.position(0);
    this.gWd.put(this.pvE.left);
    this.gWd.put(this.grW - this.pvE.bottom);
    this.gWd.put(this.pvE.right);
    this.gWd.put(this.grW - this.pvE.top);
    AppMethodBeat.o(865);
  }
  
  public final void arr()
  {
    AppMethodBeat.i(866);
    if (this.gqX == -1)
    {
      AppMethodBeat.o(866);
      return;
    }
    GLES20.glViewport(this.pvE.left, this.grW - this.pvE.bottom, this.pvE.width(), this.pvE.height());
    GLES20.glUseProgram(this.gse);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.gqX);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.pvu, 0);
    GLES20.glUniformMatrix4fv(this.pvv, 1, false, this.gVu, 0);
    this.grE.position(0);
    GLES20.glVertexAttribPointer(this.pvt, 2, 5126, false, 0, (Buffer)this.grE);
    GLES20.glEnableVertexAttribArray(this.pvt);
    this.grD.position(0);
    GLES20.glVertexAttribPointer(this.pvs, 2, 5126, false, 0, (Buffer)this.grD);
    GLES20.glEnableVertexAttribArray(this.pvs);
    this.gWd.position(0);
    GLES20.glUniform4fv(this.pvw, 1, this.gWd);
    GLES20.glUniform1f(this.pvx, this.rs);
    int j = this.pvy;
    if (this.pvD) {}
    for (int i = 1;; i = 0)
    {
      GLES20.glUniform1i(j, i);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.pvt);
      GLES20.glDisableVertexAttribArray(this.pvs);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      AppMethodBeat.o(866);
      return;
    }
  }
  
  public final void no(int paramInt)
  {
    this.gqX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.m
 * JD-Core Version:    0.7.0.1
 */