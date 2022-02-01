package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "inputTexture", "programId", "rgbSizeBuff", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class i
  extends a
{
  private int gKH;
  private final int gLM;
  private final int pYX;
  private final int pYY;
  private final int pYZ;
  private final int pZa;
  private final int pZb;
  private final int pZc;
  private final int pZd;
  private FloatBuffer pZe;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(864);
    this.gKH = -1;
    Object localObject = b.pYp;
    this.gLM = b.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = texture2D(texture, v_texCoord);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.pYY = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.pYX = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.pZb = GLES20.glGetUniformLocation(this.gLM, "size");
    this.pZc = GLES20.glGetUniformLocation(this.gLM, "radius");
    this.pYZ = GLES20.glGetUniformLocation(this.gLM, "texture");
    this.pZa = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    this.pZd = GLES20.glGetUniformLocation(this.gLM, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.pZe = ((FloatBuffer)localObject);
    AppMethodBeat.o(864);
  }
  
  public final void amq()
  {
    AppMethodBeat.i(862);
    super.amq();
    this.pZe.position(0);
    this.pZe.put(this.gLD);
    this.pZe.put(this.gLE);
    AppMethodBeat.o(862);
  }
  
  public final void aue()
  {
    AppMethodBeat.i(863);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.gLM);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.gKH);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.pYZ, 0);
    GLES20.glUniformMatrix4fv(this.pZa, 1, false, this.hnx, 0);
    this.pZe.position(0);
    GLES20.glUniform2fv(this.pZb, 1, this.pZe);
    int i = this.pZc;
    d.a locala = d.pQW;
    GLES20.glUniform1f(i, Math.max(this.gLD, this.gLE) * 0.0666667F);
    GLES20.glUniform1i(this.pZd, 1);
    this.gLm.position(0);
    GLES20.glVertexAttribPointer(this.pYY, 2, 5126, false, 0, (Buffer)this.gLm);
    GLES20.glEnableVertexAttribArray(this.pYY);
    this.gLl.position(0);
    GLES20.glVertexAttribPointer(this.pYX, 2, 5126, false, 0, (Buffer)this.gLl);
    GLES20.glEnableVertexAttribArray(this.pYX);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.pYY);
    GLES20.glDisableVertexAttribArray(this.pYX);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFinish();
    AppMethodBeat.o(863);
  }
  
  public final void nN(int paramInt)
  {
    this.gKH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.i
 * JD-Core Version:    0.7.0.1
 */