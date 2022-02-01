package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "inputTexture", "programId", "rgbSizeBuff", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class i
  extends a
{
  private int gqX;
  private final int gse;
  private final int pvs;
  private final int pvt;
  private final int pvu;
  private final int pvv;
  private final int pvw;
  private final int pvx;
  private final int pvy;
  private FloatBuffer pvz;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(864);
    this.gqX = -1;
    Object localObject = b.puK;
    this.gse = b.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = texture2D(texture, v_texCoord);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.pvt = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.pvs = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.pvw = GLES20.glGetUniformLocation(this.gse, "size");
    this.pvx = GLES20.glGetUniformLocation(this.gse, "radius");
    this.pvu = GLES20.glGetUniformLocation(this.gse, "texture");
    this.pvv = GLES20.glGetUniformLocation(this.gse, "uMatrix");
    this.pvy = GLES20.glGetUniformLocation(this.gse, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.pvz = ((FloatBuffer)localObject);
    AppMethodBeat.o(864);
  }
  
  public final void ajE()
  {
    AppMethodBeat.i(862);
    super.ajE();
    this.pvz.position(0);
    this.pvz.put(this.grV);
    this.pvz.put(this.grW);
    AppMethodBeat.o(862);
  }
  
  public final void arr()
  {
    AppMethodBeat.i(863);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.gse);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.gqX);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.pvu, 0);
    GLES20.glUniformMatrix4fv(this.pvv, 1, false, this.gVu, 0);
    this.pvz.position(0);
    GLES20.glUniform2fv(this.pvw, 1, this.pvz);
    int i = this.pvx;
    d.a locala = d.pnw;
    GLES20.glUniform1f(i, Math.max(this.grV, this.grW) * 0.0666667F);
    GLES20.glUniform1i(this.pvy, 1);
    this.grE.position(0);
    GLES20.glVertexAttribPointer(this.pvt, 2, 5126, false, 0, (Buffer)this.grE);
    GLES20.glEnableVertexAttribArray(this.pvt);
    this.grD.position(0);
    GLES20.glVertexAttribPointer(this.pvs, 2, 5126, false, 0, (Buffer)this.grD);
    GLES20.glEnableVertexAttribArray(this.pvs);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.pvt);
    GLES20.glDisableVertexAttribArray(this.pvs);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFinish();
    AppMethodBeat.o(863);
  }
  
  public final void no(int paramInt)
  {
    this.gqX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.i
 * JD-Core Version:    0.7.0.1
 */