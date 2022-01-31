package com.tencent.mm.plugin.emojicapture.ui.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.PTSegmentor;
import com.tencent.ttpic.PTSticker;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.BrightnessAdjustmentFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoTemplateParser;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public final class h
{
  private boolean eLc;
  private boolean eYf;
  private FloatBuffer eYu;
  private FloatBuffer eYv;
  private int eZe;
  private int eZf;
  private int eZg;
  private int eZh;
  private int eZi;
  private int eZj;
  private int eZk;
  private int eZl;
  private ByteBuffer eZm;
  private ByteBuffer eZn;
  private int gNA;
  private int gNB;
  private float[] gND;
  private float[] gNF;
  private int jgD;
  private int jgE;
  private int lBA;
  private int lBB;
  private int lBC;
  private int lBD;
  private FloatBuffer lBE;
  private FloatBuffer lBF;
  private FloatBuffer lBG;
  private float[] lBH;
  private float[] lBI;
  private float[] lBJ;
  private int lBK;
  private int lBL;
  private int lBM;
  private com.tencent.mm.plugin.emojicapture.d.a lBN;
  private int lBO;
  private byte[] lBP;
  private IntBuffer lBQ;
  private int lBo;
  private int lBp;
  private int lBq;
  private int lBr;
  private int lBs;
  private int lBt;
  private int lBu;
  private int lBv;
  private int lBw;
  private int lBx;
  private int lBy;
  private int lBz;
  private int rotate;
  
  public h()
  {
    AppMethodBeat.i(2560);
    com.tencent.mm.plugin.emojicapture.model.c.a locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    this.lBo = com.tencent.mm.plugin.emojicapture.model.c.bnP();
    locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    this.lBp = com.tencent.mm.plugin.emojicapture.model.c.bnP();
    this.gND = new float[16];
    this.gNF = c.eZq;
    this.lBI = c.eZq;
    this.lBQ = IntBuffer.allocate(this.lBo * this.lBp);
    this.eLc = false;
    AppMethodBeat.o(2560);
  }
  
  private static void clearStatus()
  {
    AppMethodBeat.i(2566);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(2566);
  }
  
  private void uT(int paramInt)
  {
    AppMethodBeat.i(2565);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.lBG == null) {
      this.lBG = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    GLES20.glViewport(0, 0, this.jgD, this.jgE);
    GLES20.glUseProgram(this.lBv);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.lBz, 0);
    Matrix.setIdentityM(this.gND, 0);
    GLES20.glUniformMatrix4fv(this.lBA, 1, false, this.gND, 0);
    this.lBG.put(this.jgD);
    this.lBG.put(this.jgE);
    this.lBG.position(0);
    GLES20.glUniform2fv(this.lBB, 1, this.lBG);
    GLES20.glUniform1f(this.lBC, com.tencent.mm.plugin.emojicapture.model.c.uE(Math.max(this.jgD, this.jgE)));
    GLES20.glUniform1i(this.lBD, 1);
    this.lBF.put(c.eZq);
    this.lBF.position(0);
    GLES20.glVertexAttribPointer(this.lBy, 2, 5126, false, 0, this.lBF);
    GLES20.glEnableVertexAttribArray(this.lBy);
    this.lBE.put(c.eZr);
    this.lBE.position(0);
    GLES20.glVertexAttribPointer(this.lBx, 2, 5126, false, 0, this.lBE);
    GLES20.glEnableVertexAttribArray(this.lBx);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.lBy);
    GLES20.glDisableVertexAttribArray(this.lBx);
    GLES20.glBindTexture(3553, 0);
    GLES20.glUseProgram(0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(2565);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(2563);
    if (this.lBN == null)
    {
      ab.e("MicroMsg.FilterRenderer", "drawFrame, emojiFilterProcessTex is null!!");
      AppMethodBeat.o(2563);
      return;
    }
    if (paramInt1 <= 0)
    {
      ab.e("MicroMsg.FilterRenderer", "drawFrame, externalTextureId error:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(2563);
      return;
    }
    this.gNA = paramInt2;
    this.gNB = paramInt3;
    this.eYf = paramBoolean;
    this.rotate = paramInt4;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    float[] arrayOfFloat;
    float f1;
    if ((this.lBv != 0) && (this.gNA > 0) && (this.gNB > 0))
    {
      paramInt2 = Math.min(this.gNA, this.gNB);
      c.r(this.lBK, this.lBM, this.lBo, this.lBp);
      GLES20.glViewport(0, 0, this.lBo, this.lBp);
      GLES20.glUseProgram(this.lBq);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt1);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      GLES20.glUniform1i(this.lBt, 0);
      Matrix.setIdentityM(this.gND, 0);
      if (this.rotate > 0)
      {
        Matrix.setRotateM(this.gND, 0, this.rotate, 0.0F, 0.0F, -1.0F);
        arrayOfFloat = this.gND;
        if (!this.eYf) {
          break label552;
        }
        f1 = -1.0F;
      }
    }
    for (;;)
    {
      Matrix.scaleM(arrayOfFloat, 0, -1.0F, f1, 1.0F);
      GLES20.glUniformMatrix4fv(this.lBu, 1, false, this.gND, 0);
      this.eYv.position(0);
      GLES20.glVertexAttribPointer(this.lBs, 2, 5126, false, 0, this.eYv);
      GLES20.glEnableVertexAttribArray(this.lBs);
      float f2;
      if ((this.rotate == 90) || (this.rotate == 270))
      {
        f1 = (this.gNA - paramInt2) / 2.0F / this.gNA;
        f2 = 1.0F - f1;
        this.lBH[0] = f1;
        this.lBH[2] = f2;
        this.lBH[4] = f1;
        this.lBH[6] = f2;
        label416:
        this.eYu.put(this.lBH);
        this.eYu.position(0);
        GLES20.glVertexAttribPointer(this.lBr, 2, 5126, false, 0, this.eYu);
        GLES20.glEnableVertexAttribArray(this.lBr);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.lBs);
        GLES20.glDisableVertexAttribArray(this.lBr);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glFinish();
        this.lBN.cm(this.lBo, this.lBp);
        this.lBN.eYd = this.lBM;
      }
      try
      {
        this.lBN.bnG();
        uT(this.lBO);
        clearStatus();
        AppMethodBeat.o(2563);
        return;
        label552:
        f1 = 1.0F;
        continue;
        f1 = (this.gNB - paramInt2) / 2.0F / this.gNB;
        f2 = 1.0F - f1;
        this.lBH[1] = f1;
        this.lBH[3] = f2;
        this.lBH[5] = f1;
        this.lBH[7] = f2;
        break label416;
        ab.i("MicroMsg.FilterRenderer", "skip %s, %s, %s", new Object[] { Integer.valueOf(this.lBv), Integer.valueOf(this.gNA), Integer.valueOf(this.gNB) });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FilterRenderer", localException, "filterProcess error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void a(b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(2564);
    com.tencent.mm.plugin.emojicapture.d.a locala = this.lBN;
    if (locala.mPTSticker != null) {
      locala.mPTSticker.destroy();
    }
    if (paramb == null)
    {
      locala.mPTSticker = null;
      ab.i("MicroMsg.EmojiFilterProcess", "changeSticker: null");
      AppMethodBeat.o(2564);
      return;
    }
    locala.mPTSticker = null;
    ab.i("MicroMsg.EmojiFilterProcess", "changeSticker: %s", new Object[] { paramb });
    String str = paramb.ltJ;
    PTFaceDetector localPTFaceDetector = locala.ltk.yik;
    paramb = localObject;
    if (localPTFaceDetector != null) {
      paramb = localPTFaceDetector.getFaceDetector();
    }
    if (paramb != null)
    {
      locala.mPTSticker = new PTSticker(str, paramb);
      locala.mPTSticker.init();
    }
    if (!TextUtils.isEmpty(str)) {
      ab.i("MicroMsg.EmojiFilterProcess", "changeVideoFilter: %s", new Object[] { VideoTemplateParser.parseVideoMaterial(str).getTipsText() });
    }
    AppMethodBeat.o(2564);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2562);
    if (this.lBN == null)
    {
      ab.e("MicroMsg.FilterRenderer", "drawFrame, emojiFilterProcessTex is null!!");
      AppMethodBeat.o(2562);
      return;
    }
    this.gNA = paramInt1;
    this.gNB = paramInt2;
    this.eYf = paramBoolean;
    this.rotate = paramInt3;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    float f1;
    float f2;
    if ((this.eZg != 0) && (this.eZe != -1) && (this.eZf != -1) && (this.gNA > 0) && (this.gNB > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length == this.gNA * this.gNB / 2 * 3))
    {
      if ((this.eZm == null) || (this.eZn == null) || (this.eZm.capacity() != this.gNB * this.gNA) || (this.eZn.capacity() != this.gNA * this.gNB / 2))
      {
        this.eZm = ByteBuffer.allocateDirect(this.gNB * this.gNA);
        this.eZn = ByteBuffer.allocateDirect(this.gNA * this.gNB / 2);
        this.eZm.order(ByteOrder.nativeOrder());
        this.eZn.order(ByteOrder.nativeOrder());
      }
      this.eZm.position(0);
      this.eZm.put(paramArrayOfByte, 0, this.gNA * this.gNB);
      this.eZm.position(0);
      this.eZn.position(0);
      this.eZn.put(paramArrayOfByte, this.gNA * this.gNB, this.gNA * this.gNB / 2);
      this.eZn.position(0);
      paramInt1 = Math.min(this.gNA, this.gNB);
      c.r(this.lBK, this.lBM, this.lBo, this.lBp);
      GLES20.glViewport(0, 0, this.lBo, this.lBp);
      GLES20.glUseProgram(this.eZg);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.eZe);
      GLES20.glTexImage2D(3553, 0, 6409, this.gNA, this.gNB, 0, 6409, 5121, this.eZm);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.eZj, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.eZf);
      GLES20.glTexImage2D(3553, 0, 6410, this.gNA / 2, this.gNB / 2, 0, 6410, 5121, this.eZn);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.eZk, 1);
      Matrix.setIdentityM(this.gND, 0);
      if (this.rotate > 0)
      {
        Matrix.setRotateM(this.gND, 0, this.rotate, 0.0F, 0.0F, -1.0F);
        Matrix.scaleM(this.gND, 0, -1.0F, 1.0F, 1.0F);
      }
      if (this.eYf) {
        Matrix.scaleM(this.gND, 0, 1.0F, -1.0F, 1.0F);
      }
      GLES20.glUniformMatrix4fv(this.eZl, 1, false, this.gND, 0);
      this.eYv.position(0);
      GLES20.glVertexAttribPointer(this.eZi, 2, 5126, false, 0, this.eYv);
      GLES20.glEnableVertexAttribArray(this.eZi);
      if ((this.rotate != 90) && (this.rotate != 270)) {
        break label886;
      }
      f1 = (this.gNA - paramInt1) / 2.0F / this.gNA;
      f2 = 1.0F - f1;
      this.lBH[0] = f1;
      this.lBH[2] = f2;
      this.lBH[4] = f1;
      this.lBH[6] = f2;
    }
    for (;;)
    {
      this.eYu.put(this.lBH);
      this.eYu.position(0);
      GLES20.glVertexAttribPointer(this.eZh, 2, 5126, false, 0, this.eYu);
      GLES20.glEnableVertexAttribArray(this.eZh);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.eZi);
      GLES20.glDisableVertexAttribArray(this.eZh);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glUseProgram(0);
      this.lBN.cm(this.lBo, this.lBp);
      this.lBN.eYd = this.lBM;
      try
      {
        this.lBN.bnG();
        uT(this.lBO);
        clearStatus();
        AppMethodBeat.o(2562);
        return;
        label886:
        f1 = (this.gNB - paramInt1) / 2.0F / this.gNB;
        f2 = 1.0F - f1;
        this.lBH[1] = f1;
        this.lBH[3] = f2;
        this.lBH[5] = f1;
        this.lBH[7] = f2;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FilterRenderer", paramArrayOfByte, "filterProcess error: %s", new Object[] { paramArrayOfByte.getMessage() });
        }
      }
    }
  }
  
  public final void bpl()
  {
    AppMethodBeat.i(2561);
    if (this.eLc)
    {
      AppMethodBeat.o(2561);
      return;
    }
    long l = bo.yB();
    Object localObject1 = c.lAH;
    this.eZg = c.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.eZg == 0) {
      ab.e("MicroMsg.FilterRenderer", "checkInit, load yuvProgramId failed!");
    }
    this.eZi = GLES20.glGetAttribLocation(this.eZg, "a_position");
    this.eZh = GLES20.glGetAttribLocation(this.eZg, "a_texCoord");
    this.eZj = GLES20.glGetUniformLocation(this.eZg, "y_texture");
    this.eZk = GLES20.glGetUniformLocation(this.eZg, "uv_texture");
    this.eZl = GLES20.glGetUniformLocation(this.eZg, "uMatrix");
    localObject1 = c.lAH;
    this.eZe = c.a.Vm();
    localObject1 = c.lAH;
    this.eZf = c.a.Vm();
    localObject1 = c.lAH;
    this.lBv = c.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.lBy = GLES20.glGetAttribLocation(this.lBv, "a_position");
    this.lBx = GLES20.glGetAttribLocation(this.lBv, "a_texCoord");
    this.lBB = GLES20.glGetUniformLocation(this.lBv, "size");
    this.lBC = GLES20.glGetUniformLocation(this.lBv, "radius");
    this.lBz = GLES20.glGetUniformLocation(this.lBv, "texture");
    this.lBA = GLES20.glGetUniformLocation(this.lBv, "uMatrix");
    this.lBD = GLES20.glGetUniformLocation(this.lBv, "calcRoundCorner");
    localObject1 = c.lAH;
    this.lBw = c.a.Vm();
    localObject1 = c.lAH;
    this.lBq = c.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    if (this.lBq == 0) {
      ab.e("MicroMsg.FilterRenderer", "checkInit, load externalProgramId failed");
    }
    this.lBs = GLES20.glGetAttribLocation(this.lBq, "a_position");
    this.lBr = GLES20.glGetAttribLocation(this.lBq, "a_texCoord");
    this.lBt = GLES20.glGetUniformLocation(this.lBq, "texture");
    this.lBu = GLES20.glGetUniformLocation(this.lBq, "uMatrix");
    localObject1 = c.lAH;
    this.lBM = c.a.Vm();
    localObject1 = c.eZq;
    this.gNF = Arrays.copyOf((float[])localObject1, localObject1.length);
    this.eYv = ByteBuffer.allocateDirect(this.gNF.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.eYv.put(this.gNF);
    this.eYv.position(0);
    localObject1 = c.eZr;
    this.lBH = Arrays.copyOf((float[])localObject1, localObject1.length);
    this.eYu = ByteBuffer.allocateDirect(c.eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.eYu.put(this.lBH);
    this.eYu.position(0);
    localObject1 = c.eZr;
    this.lBJ = Arrays.copyOf((float[])localObject1, localObject1.length);
    this.lBE = ByteBuffer.allocateDirect(this.lBJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.lBE.put(this.lBJ);
    this.lBE.position(0);
    localObject1 = c.eZq;
    this.lBI = Arrays.copyOf((float[])localObject1, localObject1.length);
    this.lBF = ByteBuffer.allocateDirect(this.lBI.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.lBF.put(this.lBI);
    this.lBF.position(0);
    localObject1 = c.lAH;
    this.lBK = c.a.Vn();
    localObject1 = c.lAH;
    this.lBL = c.a.Vn();
    localObject1 = c.lAH;
    this.lBO = c.a.Vm();
    if (this.lBN != null) {
      this.lBN.clear();
    }
    this.lBN = new com.tencent.mm.plugin.emojicapture.d.a();
    localObject1 = this.lBN;
    int i2 = this.lBM;
    int i3 = this.lBO;
    try
    {
      ab.i("MicroMsg.EmojiFilterProcess", "initial %s, %d", new Object[] { localObject1, Long.valueOf(Thread.currentThread().getId()) });
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ltk.init();
      PTSegmentor.getInstance().init();
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).lth.ApplyGLSLFilter(true, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYj, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYk);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSwapCopyFilter.ApplyGLSLFilter(true, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYj, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYk);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ltf.ApplyGLSLFilter(true, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYj, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYk);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSmoothBFilters.initial();
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSmoothBFilters.updateBlurAlpha(0.4F);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mBeautyFaceList.initial();
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mBeautyParam.changeFaceMeshSet(1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mBeautyTransformList.initial();
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mCopyFilter.ApplyGLSLFilter(true, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYj, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYk);
      VideoFilterUtil.setRenderMode(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).lth, 1);
      VideoFilterUtil.setRenderMode(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ltf, 1);
      VideoFilterUtil.setRenderMode(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mCopyFilter, 1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mBeautyTransformList.setRenderMode(1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mBeautyFaceList.setRenderMode(1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSmoothBFilters.setRenderMode(1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mRemodelFilter.setRenderMode(1);
      if (((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mPTSticker != null) {
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mPTSticker.setRenderMode(1);
      }
      int i1 = 50;
      int n = 20;
      int m = 0;
      int k = 0;
      int j = 0;
      int i = 0;
      if (bp.dud())
      {
        localObject2 = ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
        i1 = ((SharedPreferences)localObject2).getInt("skin", 50);
        n = ((SharedPreferences)localObject2).getInt("shape", 20);
        m = ((SharedPreferences)localObject2).getInt("faceV", 0);
        k = ((SharedPreferences)localObject2).getInt("eye", 0);
        j = ((SharedPreferences)localObject2).getInt("nose", 0);
        i = ((SharedPreferences)localObject2).getInt("chin", 0);
      }
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.BEAUTY, i1);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.BASIC3, n);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.FACE_V, m);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.EYE, k);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.NOSE, j);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).a(BeautyRealConfig.TYPE.CHIN, i);
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).eYd = i2;
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ltl = i3;
      Object localObject2 = c.lAH;
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ltn = c.a.Vn();
      i = 0;
      while (i < ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSwapFrames.length)
      {
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mSwapFrames[i] = new com.tencent.filter.h();
        i += 1;
      }
      ab.d("MicroMsg.EmojiFilterProcess", "initial end %s", new Object[] { localObject1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", localException, "initial error", new Object[0]);
        d locald = d.ltx;
        d.boa();
      }
    }
    this.eLc = true;
    ab.i("MicroMsg.FilterRenderer", "init cost %s", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(2561);
  }
  
  public final int bpm()
  {
    return this.lBO;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(2567);
    ab.i("MicroMsg.FilterRenderer", "destroy, init:%s", new Object[] { Boolean.valueOf(this.eLc) });
    if (!this.eLc)
    {
      AppMethodBeat.o(2567);
      return;
    }
    if (this.lBN != null)
    {
      this.lBN.clear();
      this.lBN = null;
    }
    GLES20.glDeleteTextures(5, new int[] { this.eZe, this.eZf, this.lBw, this.lBM, this.lBO }, 0);
    GLES20.glDeleteFramebuffers(2, new int[] { this.lBK, this.lBL }, 0);
    GLES20.glDeleteProgram(this.eZg);
    GLES20.glDeleteProgram(this.lBv);
    GLES20.glDeleteProgram(this.lBq);
    this.lBP = null;
    this.eLc = false;
    AppMethodBeat.o(2567);
  }
  
  public final void updateSize(int paramInt1, int paramInt2)
  {
    this.jgD = paramInt1;
    this.jgE = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.h
 * JD-Core Version:    0.7.0.1
 */