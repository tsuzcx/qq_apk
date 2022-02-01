package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sticker.f;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"})
public final class c
{
  public final String TAG;
  final int height;
  final f uVs;
  EGLSurface vbA;
  EGLConfig vbB;
  public GL10 vbC;
  public d vbD;
  Surface vbE;
  public MMHandler vbF;
  HandlerThread vbG;
  public a<x> vbH;
  final boolean vbI;
  final EGL10 vbx;
  EGLDisplay vby;
  EGLContext vbz;
  final int width;
  
  public c(int paramInt1, int paramInt2, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(845);
    this.width = paramInt1;
    this.height = paramInt2;
    this.vbI = paramBoolean;
    this.uVs = paramf;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    paramf = EGLContext.getEGL();
    if (paramf == null)
    {
      paramf = new t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(845);
      throw paramf;
    }
    this.vbx = ((EGL10)paramf);
    this.vby = EGL10.EGL_NO_DISPLAY;
    this.vbz = EGL10.EGL_NO_CONTEXT;
    this.vbA = EGL10.EGL_NO_SURFACE;
    paramf = com.tencent.e.c.d.ij("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
    p.j(paramf, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.vbG = paramf;
    this.vbG.start();
    this.vbF = new MMHandler(this.vbG.getLooper());
    this.vbF.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(837);
        c localc = this.vbJ;
        localc.vby = localc.vbx.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (localc.vby == EGL10.EGL_NO_DISPLAY) {
          Log.e(localc.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(localc.vbx.eglGetError()) });
        }
        Object localObject1 = new int[2];
        if (!localc.vbx.eglInitialize(localc.vby, (int[])localObject1))
        {
          Log.e(localc.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(localc.vbx.eglGetError()) });
          localObject1 = com.tencent.mm.plugin.emojicapture.model.e.uUh;
          com.tencent.mm.plugin.emojicapture.model.e.cXH();
        }
        for (;;)
        {
          localc.vbD = new d(localc.vbI, localc.uVs);
          localObject1 = localc.vbD;
          if (localObject1 == null) {
            p.bGy("renderer");
          }
          if (!((d)localObject1).isInit)
          {
            Log.i(((d)localObject1).TAG, "init: ");
            localObject2 = b.vbw;
            localObject2 = com.tencent.mm.media.g.c.fC(false);
            ((d)localObject1).vbN = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject2).kVj);
            ((d)localObject1).vbM = ((com.tencent.mm.media.g.d)localObject2);
            localObject2 = b.vbw;
            ((d)localObject1).vbO = com.tencent.mm.media.g.c.fC(true);
            localObject2 = b.vbw;
            ((d)localObject1).kYZ = b.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
            ((d)localObject1).kZa = GLES20.glGetAttribLocation(((d)localObject1).kYZ, "a_position");
            ((d)localObject1).kZb = GLES20.glGetAttribLocation(((d)localObject1).kYZ, "a_texCoord");
            ((d)localObject1).kZd = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "videoExternalTexture");
            ((d)localObject1).kZe = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "videoNormalTexture");
            ((d)localObject1).kZf = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "emojiTexture");
            ((d)localObject1).vbP = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "size");
            ((d)localObject1).vbQ = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "radius");
            ((d)localObject1).kZg = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "hasEmojiTexture");
            ((d)localObject1).kZi = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "uMatrix");
            ((d)localObject1).kZh = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "useNormalVideoTexture");
            ((d)localObject1).vbR = GLES20.glGetUniformLocation(((d)localObject1).kYZ, "enableAlpha");
            localObject2 = b.vbw;
            ((d)localObject1).vbS = b.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
            ((d)localObject1).vbT = GLES20.glGetAttribLocation(((d)localObject1).vbS, "a_position");
            ((d)localObject1).vbU = GLES20.glGetAttribLocation(((d)localObject1).vbS, "a_texCoord");
            ((d)localObject1).vbV = GLES20.glGetUniformLocation(((d)localObject1).vbS, "texture");
            ((d)localObject1).ksb.put(b.laj);
            ((d)localObject1).vca.put(b.lak);
            localObject2 = b.vbw;
            ((d)localObject1).vbX = b.a.cYE();
            localObject2 = b.vbw;
            ((d)localObject1).vbY = com.tencent.mm.media.g.c.fC(true);
            localObject2 = b.vbw;
            ((d)localObject1).vbZ = com.tencent.mm.media.g.c.fC(true);
            ((d)localObject1).isInit = true;
          }
          localObject1 = localc.vbD;
          if (localObject1 == null) {
            p.bGy("renderer");
          }
          ((d)localObject1).cYG().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)new c.c(localc));
          localObject1 = localc.vbD;
          if (localObject1 == null) {
            p.bGy("renderer");
          }
          localc.vbE = new Surface(((d)localObject1).cYG());
          AppMethodBeat.o(837);
          return;
          localObject1 = b.vbw;
          localObject1 = localc.vbx;
          Object localObject2 = localc.vby;
          p.j(localObject2, "eGLDisplay");
          p.k(localObject1, "eGL");
          p.k(localObject2, "eGLDisplay");
          int[] arrayOfInt1 = new int[15];
          int[] tmp629_627 = arrayOfInt1;
          tmp629_627[0] = 12324;
          int[] tmp635_629 = tmp629_627;
          tmp635_629[1] = 8;
          int[] tmp640_635 = tmp635_629;
          tmp640_635[2] = 12323;
          int[] tmp646_640 = tmp640_635;
          tmp646_640[3] = 8;
          int[] tmp651_646 = tmp646_640;
          tmp651_646[4] = 12322;
          int[] tmp657_651 = tmp651_646;
          tmp657_651[5] = 8;
          int[] tmp662_657 = tmp657_651;
          tmp662_657[6] = 12321;
          int[] tmp669_662 = tmp662_657;
          tmp669_662[7] = 8;
          int[] tmp675_669 = tmp669_662;
          tmp675_669[8] = 12325;
          int[] tmp682_675 = tmp675_669;
          tmp682_675[9] = 0;
          int[] tmp687_682 = tmp682_675;
          tmp687_682[10] = 12326;
          int[] tmp694_687 = tmp687_682;
          tmp694_687[11] = 0;
          int[] tmp699_694 = tmp694_687;
          tmp699_694[12] = 12352;
          int[] tmp706_699 = tmp699_694;
          tmp706_699[13] = 4;
          int[] tmp711_706 = tmp706_699;
          tmp711_706[14] = 12344;
          tmp711_706;
          int[] arrayOfInt2 = new int[1];
          ((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject2, arrayOfInt1, null, 0, arrayOfInt2);
          int i = arrayOfInt2[0];
          EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
          if (!((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject2, arrayOfInt1, arrayOfEGLConfig, i, arrayOfInt2))
          {
            Log.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(((EGL10)localObject1).eglGetError()) });
            localObject1 = null;
            label795:
            localc.vbB = ((EGLConfig)localObject1);
            localObject1 = localc.vbB;
            if (localObject1 == null) {
              continue;
            }
            localc.vbz = localc.vbx.eglCreateContext(localc.vby, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            i = localc.width;
            int j = localc.height;
            localc.vbA = localc.vbx.eglCreatePbufferSurface(localc.vby, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
            if ((localc.vbA != EGL10.EGL_NO_SURFACE) && (localc.vbz != EGL10.EGL_NO_CONTEXT)) {
              break label1036;
            }
            if (localc.vbx.eglGetError() != 12299) {
              break label1000;
            }
            Log.e(localc.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
            i = -1;
          }
          for (;;)
          {
            if (i >= 0) {
              break label1041;
            }
            Log.e(localc.TAG, "createEGLContext failed -1");
            localObject1 = com.tencent.mm.plugin.emojicapture.model.e.uUh;
            com.tencent.mm.plugin.emojicapture.model.e.cXH();
            break;
            localObject1 = arrayOfEGLConfig[0];
            break label795;
            label1000:
            Log.e(localc.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(localc.vbx.eglGetError()) });
            i = -1;
            continue;
            label1036:
            i = 0;
          }
          label1041:
          if (!localc.vbx.eglMakeCurrent(localc.vby, localc.vbA, localc.vbA, localc.vbz))
          {
            Log.e(localc.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(localc.vbx.eglGetError()));
            localObject1 = com.tencent.mm.plugin.emojicapture.model.e.uUh;
            com.tencent.mm.plugin.emojicapture.model.e.cXH();
          }
          localObject1 = localc.vbz;
          p.j(localObject1, "eGLContext");
          localObject1 = ((EGLContext)localObject1).getGL();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
            AppMethodBeat.o(837);
            throw ((Throwable)localObject1);
          }
          localc.vbC = ((GL10)localObject1);
        }
      }
    });
    AppMethodBeat.o(845);
  }
  
  public final Surface cYF()
  {
    AppMethodBeat.i(844);
    Surface localSurface = this.vbE;
    if (localSurface == null) {
      p.bGy("videoDecodeSurface");
    }
    AppMethodBeat.o(844);
    return localSurface;
  }
  
  public final void j(a<x> parama)
  {
    AppMethodBeat.i(843);
    p.k(parama, "callback");
    this.vbF.post((Runnable)new e(parama));
    AppMethodBeat.o(843);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements a<x>
  {
    public a(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(c paramc, boolean paramBoolean, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(839);
      c.a(this.vbJ).onSurfaceCreated(c.b(this.vbJ), this.vbJ.vbB);
      c.a(this.vbJ).onSurfaceChanged(c.b(this.vbJ), this.vbJ.width, this.vbJ.height);
      Object localObject = c.a(this.vbJ);
      ((d)localObject).uVV = this.vbK;
      try
      {
        ((d)localObject).jUF = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 0, false, false, 15);
        com.tencent.mm.plugin.xlabeffect.e locale1 = ((d)localObject).jUF;
        if (locale1 != null) {
          locale1.setSize(((d)localObject).vbW, ((d)localObject).vbW);
        }
        locale1 = ((d)localObject).jUF;
        if (locale1 != null) {
          locale1.DH(((d)localObject).uVV);
        }
        locale1 = ((d)localObject).jUF;
        if (locale1 != null) {
          locale1.a(((d)localObject).uVs);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.emojicapture.model.e locale = com.tencent.mm.plugin.emojicapture.model.e.uUh;
          com.tencent.mm.plugin.emojicapture.model.e.cXO();
        }
        AppMethodBeat.o(839);
      }
      localObject = this.vbL;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(839);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class c
    implements SurfaceTexture.OnFrameAvailableListener
  {
    c(c paramc) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(840);
      paramSurfaceTexture = this.vbJ;
      Log.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
      paramSurfaceTexture.j((a)new c.d(paramSurfaceTexture));
      AppMethodBeat.o(840);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(842);
      this.kWs.invoke();
      AppMethodBeat.o(842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c
 * JD-Core Version:    0.7.0.1
 */