package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTSegment;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(3155);
    d locald = this.lAT;
    locald.lAJ = locald.lAI.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (locald.lAJ == EGL10.EGL_NO_DISPLAY) {
      ab.e(locald.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(locald.lAI.eglGetError()) });
    }
    Object localObject1 = new int[2];
    if (!locald.lAI.eglInitialize(locald.lAJ, (int[])localObject1))
    {
      ab.e(locald.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(locald.lAI.eglGetError()) });
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.bod();
    }
    for (;;)
    {
      locald.lAO = new e();
      localObject1 = locald.lAO;
      if (localObject1 == null) {
        j.ays("renderer");
      }
      Object localObject2;
      if (!((e)localObject1).bRB)
      {
        ab.i(((e)localObject1).TAG, "init: ");
        localObject2 = c.lAH;
        ((e)localObject1).lAW = c.a.bpi();
        ((e)localObject1).lAX = new SurfaceTexture(((e)localObject1).lAW);
        localObject2 = c.lAH;
        ((e)localObject1).eYM = c.a.Vm();
        localObject2 = c.lAH;
        ((e)localObject1).eYN = c.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
        ((e)localObject1).eYO = GLES20.glGetAttribLocation(((e)localObject1).eYN, "a_position");
        ((e)localObject1).eYP = GLES20.glGetAttribLocation(((e)localObject1).eYN, "a_texCoord");
        ((e)localObject1).eYQ = GLES20.glGetUniformLocation(((e)localObject1).eYN, "videoExternalTexture");
        ((e)localObject1).eYR = GLES20.glGetUniformLocation(((e)localObject1).eYN, "videoNormalTexture");
        ((e)localObject1).eYS = GLES20.glGetUniformLocation(((e)localObject1).eYN, "emojiTexture");
        ((e)localObject1).lAY = GLES20.glGetUniformLocation(((e)localObject1).eYN, "size");
        ((e)localObject1).lAZ = GLES20.glGetUniformLocation(((e)localObject1).eYN, "radius");
        ((e)localObject1).eYT = GLES20.glGetUniformLocation(((e)localObject1).eYN, "hasEmojiTexture");
        ((e)localObject1).eYV = GLES20.glGetUniformLocation(((e)localObject1).eYN, "uMatrix");
        ((e)localObject1).eYU = GLES20.glGetUniformLocation(((e)localObject1).eYN, "useNormalVideoTexture");
        localObject2 = c.lAH;
        ((e)localObject1).lBa = c.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        ((e)localObject1).lBb = GLES20.glGetAttribLocation(((e)localObject1).lBa, "a_position");
        ((e)localObject1).lBc = GLES20.glGetAttribLocation(((e)localObject1).lBa, "a_texCoord");
        ((e)localObject1).lBd = GLES20.glGetUniformLocation(((e)localObject1).lBa, "texture");
        localObject2 = c.lAH;
        ((e)localObject1).lBf = c.a.Vm();
        localObject2 = c.lAH;
        ((e)localObject1).lBe = c.a.Vn();
        localObject2 = c.lAH;
        ((e)localObject1).lBl = c.a.Vm();
        ((e)localObject1).eYv.put(c.eZq);
        ((e)localObject1).lBm.put(c.eZr);
        ((e)localObject1).lBi.init();
        ((e)localObject1).lBj.init();
      }
      try
      {
        ((e)localObject1).lBk = new h(((e)localObject1).lBe, ((e)localObject1).lBf, ((e)localObject1).lBg, ((e)localObject1).lBg);
        ((e)localObject1).bRB = true;
        localObject1 = locald.lAO;
        if (localObject1 == null) {
          j.ays("renderer");
        }
        ((e)localObject1).bpk().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)new d.c(locald));
        localObject1 = locald.lAO;
        if (localObject1 == null) {
          j.ays("renderer");
        }
        locald.lAP = new Surface(((e)localObject1).bpk());
        AppMethodBeat.o(3155);
        return;
        localObject1 = c.lAH;
        localObject1 = locald.lAI;
        localObject2 = locald.lAJ;
        j.p(localObject2, "eGLDisplay");
        j.q(localObject1, "eGL");
        j.q(localObject2, "eGLDisplay");
        int[] arrayOfInt1 = new int[15];
        int[] tmp638_636 = arrayOfInt1;
        tmp638_636[0] = 12324;
        int[] tmp644_638 = tmp638_636;
        tmp644_638[1] = 8;
        int[] tmp649_644 = tmp644_638;
        tmp649_644[2] = 12323;
        int[] tmp655_649 = tmp649_644;
        tmp655_649[3] = 8;
        int[] tmp660_655 = tmp655_649;
        tmp660_655[4] = 12322;
        int[] tmp666_660 = tmp660_655;
        tmp666_660[5] = 8;
        int[] tmp671_666 = tmp666_660;
        tmp671_666[6] = 12321;
        int[] tmp678_671 = tmp671_666;
        tmp678_671[7] = 8;
        int[] tmp684_678 = tmp678_671;
        tmp684_678[8] = 12325;
        int[] tmp691_684 = tmp684_678;
        tmp691_684[9] = 0;
        int[] tmp696_691 = tmp691_684;
        tmp696_691[10] = 12326;
        int[] tmp703_696 = tmp696_691;
        tmp703_696[11] = 0;
        int[] tmp708_703 = tmp703_696;
        tmp708_703[12] = 12352;
        int[] tmp715_708 = tmp708_703;
        tmp715_708[13] = 4;
        int[] tmp720_715 = tmp715_708;
        tmp720_715[14] = 12344;
        tmp720_715;
        int[] arrayOfInt2 = new int[1];
        ((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject2, arrayOfInt1, null, 0, arrayOfInt2);
        int i = arrayOfInt2[0];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
        if (!((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject2, arrayOfInt1, arrayOfEGLConfig, i, arrayOfInt2))
        {
          ab.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(((EGL10)localObject1).eglGetError()) });
          localObject1 = null;
          label804:
          locald.lAM = ((EGLConfig)localObject1);
          localObject1 = locald.lAM;
          if (localObject1 == null) {
            continue;
          }
          locald.lAK = locald.lAI.eglCreateContext(locald.lAJ, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          i = locald.width;
          int j = locald.height;
          locald.lAL = locald.lAI.eglCreatePbufferSurface(locald.lAJ, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
          if ((locald.lAL != EGL10.EGL_NO_SURFACE) && (locald.lAK != EGL10.EGL_NO_CONTEXT)) {
            break label1045;
          }
          if (locald.lAI.eglGetError() != 12299) {
            break label1009;
          }
          ab.e(locald.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
          i = -1;
        }
        for (;;)
        {
          if (i >= 0) {
            break label1050;
          }
          ab.e(locald.TAG, "createEGLContext failed -1");
          localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
          com.tencent.mm.plugin.emojicapture.model.d.bod();
          break;
          localObject1 = arrayOfEGLConfig[0];
          break label804;
          label1009:
          ab.e(locald.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(locald.lAI.eglGetError()) });
          i = -1;
          continue;
          label1045:
          i = 0;
        }
        label1050:
        if (!locald.lAI.eglMakeCurrent(locald.lAJ, locald.lAL, locald.lAL, locald.lAK))
        {
          ab.e(locald.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(locald.lAI.eglGetError()));
          localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
          com.tencent.mm.plugin.emojicapture.model.d.bod();
        }
        localObject1 = locald.lAK;
        j.p(localObject1, "eGLContext");
        localObject1 = ((EGLContext)localObject1).getGL();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
          AppMethodBeat.o(3155);
          throw ((Throwable)localObject1);
        }
        locald.lAN = ((GL10)localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.emojicapture.model.d locald1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
          com.tencent.mm.plugin.emojicapture.model.d.bok();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d.1
 * JD-Core Version:    0.7.0.1
 */