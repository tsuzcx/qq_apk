package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"})
public final class c
{
  public final String TAG;
  final int height;
  final f rpM;
  final EGL10 rvT;
  EGLDisplay rvU;
  EGLContext rvV;
  EGLSurface rvW;
  EGLConfig rvX;
  public GL10 rvY;
  public d rvZ;
  Surface rwa;
  public MMHandler rwb;
  HandlerThread rwc;
  public a<x> rwd;
  final boolean rwe;
  final int width;
  
  public c(int paramInt1, int paramInt2, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(845);
    this.width = paramInt1;
    this.height = paramInt2;
    this.rwe = paramBoolean;
    this.rpM = paramf;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    paramf = EGLContext.getEGL();
    if (paramf == null)
    {
      paramf = new t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(845);
      throw paramf;
    }
    this.rvT = ((EGL10)paramf);
    this.rvU = EGL10.EGL_NO_DISPLAY;
    this.rvV = EGL10.EGL_NO_CONTEXT;
    this.rvW = EGL10.EGL_NO_SURFACE;
    paramf = com.tencent.f.c.d.hz("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
    p.g(paramf, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.rwc = paramf;
    this.rwc.start();
    this.rwb = new MMHandler(this.rwc.getLooper());
    this.rwb.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(837);
        c localc = this.rwf;
        localc.rvU = localc.rvT.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (localc.rvU == EGL10.EGL_NO_DISPLAY) {
          Log.e(localc.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(localc.rvT.eglGetError()) });
        }
        Object localObject1 = new int[2];
        if (!localc.rvT.eglInitialize(localc.rvU, (int[])localObject1))
        {
          Log.e(localc.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(localc.rvT.eglGetError()) });
          localObject1 = e.roB;
          e.cIY();
        }
        for (;;)
        {
          localc.rvZ = new d(localc.rwe, localc.rpM);
          localObject1 = localc.rvZ;
          if (localObject1 == null) {
            p.btv("renderer");
          }
          if (!((d)localObject1).isInit)
          {
            Log.i(((d)localObject1).TAG, "init: ");
            localObject2 = b.rvS;
            localObject2 = com.tencent.mm.media.g.c.eV(false);
            ((d)localObject1).rwj = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject2).igv);
            ((d)localObject1).rwi = ((com.tencent.mm.media.g.d)localObject2);
            localObject2 = b.rvS;
            ((d)localObject1).rwk = com.tencent.mm.media.g.c.eV(true);
            localObject2 = b.rvS;
            ((d)localObject1).ikf = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
            ((d)localObject1).ikg = GLES20.glGetAttribLocation(((d)localObject1).ikf, "a_position");
            ((d)localObject1).ikh = GLES20.glGetAttribLocation(((d)localObject1).ikf, "a_texCoord");
            ((d)localObject1).ikj = GLES20.glGetUniformLocation(((d)localObject1).ikf, "videoExternalTexture");
            ((d)localObject1).ikk = GLES20.glGetUniformLocation(((d)localObject1).ikf, "videoNormalTexture");
            ((d)localObject1).ikl = GLES20.glGetUniformLocation(((d)localObject1).ikf, "emojiTexture");
            ((d)localObject1).rwl = GLES20.glGetUniformLocation(((d)localObject1).ikf, "size");
            ((d)localObject1).rwm = GLES20.glGetUniformLocation(((d)localObject1).ikf, "radius");
            ((d)localObject1).ikm = GLES20.glGetUniformLocation(((d)localObject1).ikf, "hasEmojiTexture");
            ((d)localObject1).iko = GLES20.glGetUniformLocation(((d)localObject1).ikf, "uMatrix");
            ((d)localObject1).ikn = GLES20.glGetUniformLocation(((d)localObject1).ikf, "useNormalVideoTexture");
            ((d)localObject1).rwn = GLES20.glGetUniformLocation(((d)localObject1).ikf, "enableAlpha");
            localObject2 = b.rvS;
            ((d)localObject1).rwo = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
            ((d)localObject1).rwp = GLES20.glGetAttribLocation(((d)localObject1).rwo, "a_position");
            ((d)localObject1).rwq = GLES20.glGetAttribLocation(((d)localObject1).rwo, "a_texCoord");
            ((d)localObject1).rwr = GLES20.glGetUniformLocation(((d)localObject1).rwo, "texture");
            ((d)localObject1).hDU.put(b.ilm);
            ((d)localObject1).rww.put(b.iln);
            localObject2 = b.rvS;
            ((d)localObject1).rwt = b.a.cJU();
            localObject2 = b.rvS;
            ((d)localObject1).rwu = com.tencent.mm.media.g.c.eV(true);
            localObject2 = b.rvS;
            ((d)localObject1).rwv = com.tencent.mm.media.g.c.eV(true);
            ((d)localObject1).isInit = true;
          }
          localObject1 = localc.rvZ;
          if (localObject1 == null) {
            p.btv("renderer");
          }
          ((d)localObject1).cJW().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)new c.c(localc));
          localObject1 = localc.rvZ;
          if (localObject1 == null) {
            p.btv("renderer");
          }
          localc.rwa = new Surface(((d)localObject1).cJW());
          AppMethodBeat.o(837);
          return;
          localObject1 = b.rvS;
          localObject1 = localc.rvT;
          Object localObject2 = localc.rvU;
          p.g(localObject2, "eGLDisplay");
          p.h(localObject1, "eGL");
          p.h(localObject2, "eGLDisplay");
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
            localc.rvX = ((EGLConfig)localObject1);
            localObject1 = localc.rvX;
            if (localObject1 == null) {
              continue;
            }
            localc.rvV = localc.rvT.eglCreateContext(localc.rvU, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            i = localc.width;
            int j = localc.height;
            localc.rvW = localc.rvT.eglCreatePbufferSurface(localc.rvU, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
            if ((localc.rvW != EGL10.EGL_NO_SURFACE) && (localc.rvV != EGL10.EGL_NO_CONTEXT)) {
              break label1036;
            }
            if (localc.rvT.eglGetError() != 12299) {
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
            localObject1 = e.roB;
            e.cIY();
            break;
            localObject1 = arrayOfEGLConfig[0];
            break label795;
            label1000:
            Log.e(localc.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(localc.rvT.eglGetError()) });
            i = -1;
            continue;
            label1036:
            i = 0;
          }
          label1041:
          if (!localc.rvT.eglMakeCurrent(localc.rvU, localc.rvW, localc.rvW, localc.rvV))
          {
            Log.e(localc.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(localc.rvT.eglGetError()));
            localObject1 = e.roB;
            e.cIY();
          }
          localObject1 = localc.rvV;
          p.g(localObject1, "eGLContext");
          localObject1 = ((EGLContext)localObject1).getGL();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
            AppMethodBeat.o(837);
            throw ((Throwable)localObject1);
          }
          localc.rvY = ((GL10)localObject1);
        }
      }
    });
    AppMethodBeat.o(845);
  }
  
  public final Surface cJV()
  {
    AppMethodBeat.i(844);
    Surface localSurface = this.rwa;
    if (localSurface == null) {
      p.btv("videoDecodeSurface");
    }
    AppMethodBeat.o(844);
    return localSurface;
  }
  
  public final void k(a<x> parama)
  {
    AppMethodBeat.i(843);
    p.h(parama, "callback");
    this.rwb.post((Runnable)new c.e(parama));
    AppMethodBeat.o(843);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements a<x>
  {
    public a(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(c paramc, boolean paramBoolean, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(839);
      c.a(this.rwf).onSurfaceCreated(c.b(this.rwf), this.rwf.rvX);
      c.a(this.rwf).onSurfaceChanged(c.b(this.rwf), this.rwf.width, this.rwf.height);
      Object localObject = c.a(this.rwf);
      ((d)localObject).rqp = this.rwg;
      try
      {
        ((d)localObject).hiH = new com.tencent.mm.plugin.xlabeffect.b((byte)0);
        com.tencent.mm.plugin.xlabeffect.b localb = ((d)localObject).hiH;
        if (localb != null) {
          localb.setSize(((d)localObject).rws, ((d)localObject).rws);
        }
        localb = ((d)localObject).hiH;
        if (localb != null) {
          localb.zG(((d)localObject).rqp);
        }
        localb = ((d)localObject).hiH;
        if (localb != null) {
          localb.a(((d)localObject).rpM);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e locale = e.roB;
          e.cJf();
        }
        AppMethodBeat.o(839);
      }
      localObject = this.rwh;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(839);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class c
    implements SurfaceTexture.OnFrameAvailableListener
  {
    c(c paramc) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(840);
      paramSurfaceTexture = this.rwf;
      Log.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
      paramSurfaceTexture.k((a)new c.d(paramSurfaceTexture));
      AppMethodBeat.o(840);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c
 * JD-Core Version:    0.7.0.1
 */