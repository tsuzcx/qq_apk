package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mm.plugin.emojicapture.d.a;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.PTBeauty;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.PTFilter.PTCopyFilter;
import com.tencent.ttpic.PTSmoothSkin;
import com.tencent.ttpic.baseutils.SourcePathUtil;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public final class f
{
  private boolean dNv = false;
  private int fvY;
  private int fvZ;
  private ByteBuffer fwa;
  private ByteBuffer fwb;
  private int fwc;
  private int fwd;
  private int fwh;
  private int fwi;
  private FloatBuffer fwk;
  private FloatBuffer fwl;
  private float[] fwm = new float[16];
  private float[] fwo = b.fvS;
  private int jrQ;
  private int jrR;
  private int jrS;
  private int jrT;
  private int jrU;
  private int jrV;
  private int jrW;
  private int jrX;
  private int jrY;
  private int jrZ;
  private int jsa;
  private int jsc;
  private int jsd;
  private FloatBuffer jse;
  private FloatBuffer jsf;
  private FloatBuffer jsg;
  private ByteBuffer jsh;
  private float[] jsi;
  private float[] jsj = b.fvS;
  private float[] jsk;
  private int jsl;
  private int jsm;
  private int jsn;
  private a jso = new a();
  private int jsp;
  private int jsq;
  private int jsr;
  private byte[] jss;
  private IntBuffer jst = IntBuffer.allocate(409600);
  private int rotate;
  
  public final void aLb()
  {
    if (this.dNv) {
      return;
    }
    Object localObject1 = b.jqU;
    this.jrQ = b.a.aW("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.jrQ == 0) {
      y.e("MicroMsg.FilterRenderer", "checkInit, load program failed!");
    }
    this.jrS = GLES20.glGetAttribLocation(this.jrQ, "a_position");
    this.jrR = GLES20.glGetAttribLocation(this.jrQ, "a_texCoord");
    this.fwh = GLES20.glGetUniformLocation(this.jrQ, "y_texture");
    this.fwi = GLES20.glGetUniformLocation(this.jrQ, "uv_texture");
    this.jrT = GLES20.glGetUniformLocation(this.jrQ, "uMatrix");
    localObject1 = b.jqU;
    this.fwc = b.a.YW();
    localObject1 = b.jqU;
    this.fwd = b.a.YW();
    localObject1 = b.jqU;
    this.jrU = b.a.aW("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
    this.jrX = GLES20.glGetAttribLocation(this.jrU, "a_position");
    this.jrW = GLES20.glGetAttribLocation(this.jrU, "a_texCoord");
    this.jsa = GLES20.glGetUniformLocation(this.jrU, "size");
    this.jsc = GLES20.glGetUniformLocation(this.jrU, "radius");
    this.jrY = GLES20.glGetUniformLocation(this.jrU, "texture");
    this.jrZ = GLES20.glGetUniformLocation(this.jrU, "uMatrix");
    this.jsd = GLES20.glGetUniformLocation(this.jrU, "calcRoundCorner");
    localObject1 = b.jqU;
    this.jrV = b.a.YW();
    localObject1 = b.jqU;
    this.jsn = b.a.YW();
    this.fwo = Arrays.copyOf(b.fvS, b.fvS.length);
    this.fwk = ByteBuffer.allocateDirect(this.fwo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.fwk.put(this.fwo);
    this.fwk.position(0);
    this.jsi = Arrays.copyOf(b.fvU, b.fvU.length);
    this.fwl = ByteBuffer.allocateDirect(b.fvU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.fwl.put(this.jsi);
    this.fwl.position(0);
    this.jsk = Arrays.copyOf(b.fvU, b.fvU.length);
    this.jse = ByteBuffer.allocateDirect(this.jsk.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jse.put(this.jsk);
    this.jse.position(0);
    this.jsj = Arrays.copyOf(b.fvS, b.fvS.length);
    this.jsf = ByteBuffer.allocateDirect(this.jsj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jsf.put(this.jsj);
    this.jsf.position(0);
    localObject1 = b.jqU;
    this.jsl = b.a.aKY();
    localObject1 = b.jqU;
    this.jsm = b.a.aKY();
    localObject1 = b.jqU;
    this.jsp = b.a.YW();
    this.jso = new a();
    localObject1 = this.jso;
    int i = this.jsn;
    ((a)localObject1).clear();
    y.d("MicroMsg.EmojiFilterProcess", "initial %s, %d", new Object[] { localObject1, Long.valueOf(Thread.currentThread().getId()) });
    ((a)localObject1).jjR = new PTSmoothSkin();
    ((a)localObject1).jjR.init();
    Object localObject2;
    if (SourcePathUtil.isLoadBeautySo())
    {
      ((a)localObject1).jjT = new PTBeauty();
      ((a)localObject1).jjT.init();
      if (!bl.csf()) {
        break label913;
      }
      localObject2 = ae.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
      int j = ((SharedPreferences)localObject2).getInt("skin", 20);
      int k = ((SharedPreferences)localObject2).getInt("shape", 10);
      int m = ((SharedPreferences)localObject2).getInt("faceV", 0);
      int n = ((SharedPreferences)localObject2).getInt("eye", 0);
      int i1 = ((SharedPreferences)localObject2).getInt("nose", 0);
      int i2 = ((SharedPreferences)localObject2).getInt("chin", 0);
      ((a)localObject1).setupSmoothLevel(j);
      ((a)localObject1).a(BeautyRealConfig.TYPE.BASIC3, k);
      ((a)localObject1).a(BeautyRealConfig.TYPE.FACE_V, m);
      ((a)localObject1).a(BeautyRealConfig.TYPE.EYE, n);
      ((a)localObject1).a(BeautyRealConfig.TYPE.NOSE, i1);
      ((a)localObject1).a(BeautyRealConfig.TYPE.CHIN, i2);
    }
    for (;;)
    {
      ((a)localObject1).jjS = new PTFilter.PTCopyFilter();
      ((a)localObject1).jjS.init();
      ((a)localObject1).jjU = new PTFilter.PTCopyFilter();
      ((a)localObject1).jjU.init();
      localObject2 = new int[4];
      GLES20.glGenTextures(4, (int[])localObject2, 0);
      ((a)localObject1).jjX = localObject2[0];
      ((a)localObject1).jjY = localObject2[1];
      ((a)localObject1).jjZ = localObject2[2];
      ((a)localObject1).jka = localObject2[3];
      ((a)localObject1).jjV = i;
      ((a)localObject1).jjW = 0;
      FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
      y.d("MicroMsg.EmojiFilterProcess", "initial end %s", new Object[] { localObject1 });
      this.dNv = true;
      return;
      label913:
      ((a)localObject1).setupSmoothLevel(20);
      ((a)localObject1).a(BeautyRealConfig.TYPE.BASIC3, 10);
      ((a)localObject1).a(BeautyRealConfig.TYPE.FACE_V, 0);
      ((a)localObject1).a(BeautyRealConfig.TYPE.EYE, 0);
      ((a)localObject1).a(BeautyRealConfig.TYPE.NOSE, 0);
      ((a)localObject1).a(BeautyRealConfig.TYPE.CHIN, 0);
    }
  }
  
  public final IntBuffer aLc()
  {
    return this.jst;
  }
  
  public final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jso == null)
    {
      y.e("MicroMsg.FilterRenderer", "drawFrame, emojiFilterProcessTex is null!!");
      return;
    }
    int i;
    float f1;
    float f2;
    if ((this.fvY != paramInt1) || (this.fvZ != paramInt2))
    {
      i = 1;
      this.fvY = paramInt1;
      this.fvZ = paramInt2;
      this.rotate = paramInt3;
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      if ((this.jrQ != 0) && (this.fwc != -1) && (this.fwd != -1) && (this.fvY > 0) && (this.fvZ > 0) && (paramArrayOfByte != null))
      {
        if ((this.fwa == null) || (this.fwb == null) || (this.fwa.capacity() != this.fvZ * this.fvY) || (this.fwb.capacity() != this.fvY * this.fvZ / 2))
        {
          this.fwa = ByteBuffer.allocateDirect(this.fvZ * this.fvY);
          this.fwb = ByteBuffer.allocateDirect(this.fvY * this.fvZ / 2);
          this.fwa.order(ByteOrder.nativeOrder());
          this.fwb.order(ByteOrder.nativeOrder());
        }
        this.fwa.put(paramArrayOfByte, 0, this.fvY * this.fvZ);
        this.fwa.position(0);
        this.fwb.put(paramArrayOfByte, this.fvY * this.fvZ, this.fvY * this.fvZ / 2);
        this.fwb.position(0);
        paramInt1 = Math.min(this.fvY, this.fvZ);
        b.cI(this.jsl, this.jsn);
        GLES20.glViewport(0, 0, 640, 640);
        GLES20.glUseProgram(this.jrQ);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.fwc);
        GLES20.glTexImage2D(3553, 0, 6409, this.fvY, this.fvZ, 0, 6409, 5121, this.fwa);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.fwh, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.fwd);
        GLES20.glTexImage2D(3553, 0, 6410, this.fvY / 2, this.fvZ / 2, 0, 6410, 5121, this.fwb);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.fwi, 1);
        Matrix.setIdentityM(this.fwm, 0);
        if (this.rotate > 0)
        {
          Matrix.setRotateM(this.fwm, 0, this.rotate, 0.0F, 0.0F, -1.0F);
          Matrix.scaleM(this.fwm, 0, -1.0F, 1.0F, 1.0F);
        }
        GLES20.glUniformMatrix4fv(this.jrT, 1, false, this.fwm, 0);
        this.fwk.position(0);
        GLES20.glVertexAttribPointer(this.jrS, 2, 5126, false, 0, this.fwk);
        GLES20.glEnableVertexAttribArray(this.jrS);
        if ((this.rotate == 90) || (this.rotate == 270))
        {
          f1 = (this.fvY - paramInt1) / 2.0F / this.fvY;
          f2 = 1.0F - f1;
          this.jsi[0] = f1;
          this.jsi[2] = f2;
          this.jsi[4] = f1;
          this.jsi[6] = f2;
          this.fwl.put(this.jsi);
          this.fwl.position(0);
          GLES20.glVertexAttribPointer(this.jrR, 2, 5126, false, 0, this.fwl);
          GLES20.glEnableVertexAttribArray(this.jrR);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.jrS);
          GLES20.glDisableVertexAttribArray(this.jrR);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glUseProgram(0);
        }
      }
      else
      {
        if ((this.jss == null) || (i != 0))
        {
          this.jss = new byte[1638400];
          this.jso.jkc = this.jss;
        }
        paramArrayOfByte = this.jso;
        paramArrayOfByte.jkd = 640;
        paramArrayOfByte.jke = 640;
        this.jso.jjV = this.jsn;
      }
      try
      {
        locala = this.jso;
        i = locala.jjV;
        paramArrayOfByte = null;
        if (!locala.aJX()) {
          break label1038;
        }
        paramInt3 = VideoFilterUtil.get4DirectionAngle(FaceDetectorManager.getInstance().getCurrentFaceDetector().getPhotoAngle());
        paramInt1 = locala.jkd;
        paramInt2 = locala.jke;
        f1 = a.jjQ / locala.jkd;
        k = (paramInt3 + 360) % 360;
        if ((k != 90) && (k != 270)) {
          break label1743;
        }
        locala.jjS.setRotationAndFlip(k, false, false);
        locala.jjS.processTexture(i, paramInt2, paramInt1, locala.jka);
        j = locala.jka;
        paramInt3 = paramInt1;
        paramInt1 = j;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          a locala;
          int k;
          label973:
          y.printErrStackTrace("MicroMsg.FilterRenderer", paramArrayOfByte, "filterProcess error: %s", new Object[] { paramArrayOfByte.getMessage() });
          continue;
          locala.jjU.processTexture(paramInt2, locala.jkd, locala.jke, 0);
          continue;
          paramInt1 = i;
          continue;
          int j = i;
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = j;
        }
      }
      BenchUtil.benchStart("PTFaceDetector");
      paramArrayOfByte = PTFaceDetector.getInstance().detectVideoTexture(paramInt1, paramInt2, paramInt3, f1, false);
      BenchUtil.benchEnd("PTFaceDetector");
      if ((k == 0) || (paramArrayOfByte == null)) {
        break label1910;
      }
      AlgoUtils.rotatePointsForList(paramArrayOfByte, (int)(paramInt2 * f1), (int)(paramInt3 * f1), k);
      AlgoUtils.rotateAngles(paramArrayOfByte, -k);
      break label1910;
    }
    label1038:
    label1743:
    label1889:
    label1910:
    for (;;)
    {
      BenchUtil.benchStart("PTSmoothSkin");
      if (locala.jjR.getBeautyLevel() > 0)
      {
        locala.jjR.processTexture(i, locala.jkd, locala.jke, locala.jjX);
        paramInt1 = locala.jjX;
        BenchUtil.benchEnd("PTSmoothSkin");
        paramInt2 = paramInt1;
        if (locala.aJX())
        {
          BenchUtil.benchStart("PTBeauty");
          locala.jjT.processTexture(paramInt1, locala.jkd, locala.jke, paramArrayOfByte, locala.jjZ);
          BenchUtil.benchEnd("PTBeauty");
          paramInt2 = locala.jjZ;
        }
        if (locala.jjW != 0) {
          locala.jjU.processTexture(paramInt2, locala.jkd, locala.jke, locala.jjW);
        }
        for (;;)
        {
          paramArrayOfByte = this.jso.jkc;
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16640);
          if ((this.jrU != 0) && (paramArrayOfByte != null))
          {
            if ((this.jsh == null) || (this.jsh.capacity() != 1638400))
            {
              this.jsh = ByteBuffer.allocateDirect(1638400);
              this.jsh.order(ByteOrder.nativeOrder());
            }
            this.jsh.put(paramArrayOfByte, 0, paramArrayOfByte.length);
            this.jsh.position(0);
            if (this.jsg == null) {
              this.jsg = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            }
            GLES20.glViewport(0, 0, this.jsq, this.jsr);
            GLES20.glUseProgram(this.jrU);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.jrV);
            GLES20.glTexImage2D(3553, 0, 6408, 640, 640, 0, 6408, 5121, this.jsh);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(this.jrY, 0);
            Matrix.setIdentityM(this.fwm, 0);
            GLES20.glUniformMatrix4fv(this.jrZ, 1, false, this.fwm, 0);
            this.jsf.put(this.jsj);
            this.jsf.position(0);
            GLES20.glVertexAttribPointer(this.jrX, 2, 5126, false, 0, this.jsf);
            GLES20.glEnableVertexAttribArray(this.jrX);
            this.jsg.put(this.jsq);
            this.jsg.put(this.jsr);
            this.jsg.position(0);
            GLES20.glUniform2fv(this.jsa, 1, this.jsg);
            GLES20.glUniform1f(this.jsc, c.qi(Math.max(this.jsq, this.jsr)));
            GLES20.glUniform1i(this.jsd, 1);
            this.jse.put(this.jsk);
            this.jse.position(0);
            GLES20.glVertexAttribPointer(this.jrW, 2, 5126, false, 0, this.jse);
            GLES20.glEnableVertexAttribArray(this.jrW);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.jrX);
            GLES20.glDisableVertexAttribArray(this.jrW);
            GLES20.glBindTexture(3553, 0);
            GLES20.glFinish();
            this.jst = ByteBuffer.wrap(this.jss).order(ByteOrder.nativeOrder()).asIntBuffer();
            GLES20.glUseProgram(0);
            GLES20.glBindFramebuffer(36160, 0);
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          return;
          f1 = (this.fvZ - paramInt1) / 2.0F / this.fvZ;
          f2 = 1.0F - f1;
          this.jsi[1] = f1;
          this.jsi[3] = f2;
          this.jsi[5] = f1;
          this.jsi[7] = f2;
          break;
          if (k != 180) {
            break label1889;
          }
          locala.jjS.setRotationAndFlip(k, false, false);
          locala.jjS.processTexture(i, paramInt1, paramInt2, locala.jka);
          j = locala.jka;
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = j;
          break label973;
          if (locala.jkc == null) {
            break label1859;
          }
          locala.jjU.processTexture(paramInt2, locala.jkd, locala.jke, locala.jkc);
        }
      }
      i = 0;
      break;
    }
  }
  
  public final void cJ(int paramInt1, int paramInt2)
  {
    this.jsq = paramInt1;
    this.jsr = paramInt2;
  }
  
  public final void destroy()
  {
    if (!this.dNv) {
      return;
    }
    this.jso.clear();
    GLES20.glDeleteTextures(5, new int[] { this.fwc, this.fwd, this.jrV, this.jsn, this.jsp }, 0);
    GLES20.glDeleteFramebuffers(2, new int[] { this.jsl, this.jsm }, 0);
    GLES20.glDeleteProgram(this.jrQ);
    GLES20.glDeleteProgram(this.jrU);
    this.jss = null;
    this.dNv = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.f
 * JD-Core Version:    0.7.0.1
 */