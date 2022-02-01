package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "inputTexture", "programId", "rgbSizeBuff", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class i
  extends a
{
  private int hDl;
  private final int programId;
  private final int rwA;
  private final int rwB;
  private final int rwC;
  private final int rwD;
  private final int rwE;
  private final int rwF;
  private FloatBuffer rwG;
  private final int rwz;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
    AppMethodBeat.i(864);
    this.hDl = -1;
    Object localObject = b.rvS;
    this.programId = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = texture2D(texture, v_texCoord);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.rwA = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.rwz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.rwD = GLES20.glGetUniformLocation(this.programId, "size");
    this.rwE = GLES20.glGetUniformLocation(this.programId, "radius");
    this.rwB = GLES20.glGetUniformLocation(this.programId, "texture");
    this.rwC = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.rwF = GLES20.glGetUniformLocation(this.programId, "calcRoundCorner");
    localObject = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.rwG = ((FloatBuffer)localObject);
    AppMethodBeat.o(864);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(862);
    super.aEB();
    this.rwG.position(0);
    this.rwG.put(this.hEp);
    this.rwG.put(this.hEq);
    AppMethodBeat.o(862);
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(863);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.programId);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.hDl);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.rwB, 0);
    GLES20.glUniformMatrix4fv(this.rwC, 1, false, this.ijG, 0);
    this.rwG.position(0);
    GLES20.glUniform2fv(this.rwD, 1, this.rwG);
    int i = this.rwE;
    d.a locala = d.roA;
    GLES20.glUniform1f(i, Math.max(this.hEp, this.hEq) * 0.0666667F);
    GLES20.glUniform1i(this.rwF, 1);
    this.hDU.position(0);
    GLES20.glVertexAttribPointer(this.rwA, 2, 5126, false, 0, (Buffer)this.hDU);
    GLES20.glEnableVertexAttribArray(this.rwA);
    this.hDT.position(0);
    GLES20.glVertexAttribPointer(this.rwz, 2, 5126, false, 0, (Buffer)this.hDT);
    GLES20.glEnableVertexAttribArray(this.rwz);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.rwA);
    GLES20.glDisableVertexAttribArray(this.rwz);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFinish();
    AppMethodBeat.o(863);
  }
  
  public final void rl(int paramInt)
  {
    this.hDl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.i
 * JD-Core Version:    0.7.0.1
 */