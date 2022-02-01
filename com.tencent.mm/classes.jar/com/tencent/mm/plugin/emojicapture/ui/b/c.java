package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sticker.f;
import d.g.a.a;
import d.g.b.k;
import d.v;
import d.y;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"})
public final class c
{
  public final String TAG;
  final int height;
  final f poJ;
  final EGL10 puL;
  EGLDisplay puM;
  EGLContext puN;
  EGLSurface puO;
  EGLConfig puP;
  public GL10 puQ;
  public d puR;
  Surface puS;
  public ao puT;
  HandlerThread puU;
  public a<y> puV;
  final boolean puW;
  final int width;
  
  public c(int paramInt1, int paramInt2, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(845);
    this.width = paramInt1;
    this.height = paramInt2;
    this.puW = paramBoolean;
    this.poJ = paramf;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    paramf = EGLContext.getEGL();
    if (paramf == null)
    {
      paramf = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(845);
      throw paramf;
    }
    this.puL = ((EGL10)paramf);
    this.puM = EGL10.EGL_NO_DISPLAY;
    this.puN = EGL10.EGL_NO_CONTEXT;
    this.puO = EGL10.EGL_NO_SURFACE;
    paramf = com.tencent.e.c.d.gy("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
    k.g(paramf, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.puU = paramf;
    this.puU.start();
    this.puT = new ao(this.puU.getLooper());
    this.puT.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(837);
        c localc = this.puX;
        localc.puM = localc.puL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (localc.puM == EGL10.EGL_NO_DISPLAY) {
          ac.e(localc.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(localc.puL.eglGetError()) });
        }
        Object localObject1 = new int[2];
        if (!localc.puL.eglInitialize(localc.puM, (int[])localObject1))
        {
          ac.e(localc.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(localc.puL.eglGetError()) });
          localObject1 = e.pny;
          e.cfd();
        }
        for (;;)
        {
          localc.puR = new d(localc.puW, localc.poJ);
          localObject1 = localc.puR;
          if (localObject1 == null) {
            k.aVY("renderer");
          }
          if (!((d)localObject1).cqf)
          {
            ac.i(((d)localObject1).TAG, "init: ");
            localObject2 = b.puK;
            localObject2 = com.tencent.mm.media.f.c.ea(false);
            ((d)localObject1).pvb = new SurfaceTexture(((com.tencent.mm.media.f.d)localObject2).gRW);
            ((d)localObject1).pva = ((com.tencent.mm.media.f.d)localObject2);
            localObject2 = b.puK;
            ((d)localObject1).pvc = com.tencent.mm.media.f.c.ea(true);
            localObject2 = b.puK;
            ((d)localObject1).gVP = b.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
            ((d)localObject1).gVQ = GLES20.glGetAttribLocation(((d)localObject1).gVP, "a_position");
            ((d)localObject1).gVR = GLES20.glGetAttribLocation(((d)localObject1).gVP, "a_texCoord");
            ((d)localObject1).gVT = GLES20.glGetUniformLocation(((d)localObject1).gVP, "videoExternalTexture");
            ((d)localObject1).gVU = GLES20.glGetUniformLocation(((d)localObject1).gVP, "videoNormalTexture");
            ((d)localObject1).gVV = GLES20.glGetUniformLocation(((d)localObject1).gVP, "emojiTexture");
            ((d)localObject1).pvd = GLES20.glGetUniformLocation(((d)localObject1).gVP, "size");
            ((d)localObject1).pve = GLES20.glGetUniformLocation(((d)localObject1).gVP, "radius");
            ((d)localObject1).gVW = GLES20.glGetUniformLocation(((d)localObject1).gVP, "hasEmojiTexture");
            ((d)localObject1).gVY = GLES20.glGetUniformLocation(((d)localObject1).gVP, "uMatrix");
            ((d)localObject1).gVX = GLES20.glGetUniformLocation(((d)localObject1).gVP, "useNormalVideoTexture");
            ((d)localObject1).pvf = GLES20.glGetUniformLocation(((d)localObject1).gVP, "enableAlpha");
            localObject2 = b.puK;
            ((d)localObject1).pvg = b.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
            ((d)localObject1).pvh = GLES20.glGetAttribLocation(((d)localObject1).pvg, "a_position");
            ((d)localObject1).pvi = GLES20.glGetAttribLocation(((d)localObject1).pvg, "a_texCoord");
            ((d)localObject1).pvj = GLES20.glGetUniformLocation(((d)localObject1).pvg, "texture");
            ((d)localObject1).grE.put(b.gWC);
            ((d)localObject1).pvo.put(b.gWD);
            localObject2 = b.puK;
            ((d)localObject1).pvl = b.a.cfY();
            localObject2 = b.puK;
            ((d)localObject1).pvm = com.tencent.mm.media.f.c.ea(true);
            localObject2 = b.puK;
            ((d)localObject1).pvn = com.tencent.mm.media.f.c.ea(true);
            ((d)localObject1).cqf = true;
          }
          localObject1 = localc.puR;
          if (localObject1 == null) {
            k.aVY("renderer");
          }
          ((d)localObject1).cga().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)new c.c(localc));
          localObject1 = localc.puR;
          if (localObject1 == null) {
            k.aVY("renderer");
          }
          localc.puS = new Surface(((d)localObject1).cga());
          AppMethodBeat.o(837);
          return;
          localObject1 = b.puK;
          localObject1 = localc.puL;
          Object localObject2 = localc.puM;
          k.g(localObject2, "eGLDisplay");
          k.h(localObject1, "eGL");
          k.h(localObject2, "eGLDisplay");
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
            ac.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(((EGL10)localObject1).eglGetError()) });
            localObject1 = null;
            label795:
            localc.puP = ((EGLConfig)localObject1);
            localObject1 = localc.puP;
            if (localObject1 == null) {
              continue;
            }
            localc.puN = localc.puL.eglCreateContext(localc.puM, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            i = localc.width;
            int j = localc.height;
            localc.puO = localc.puL.eglCreatePbufferSurface(localc.puM, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
            if ((localc.puO != EGL10.EGL_NO_SURFACE) && (localc.puN != EGL10.EGL_NO_CONTEXT)) {
              break label1036;
            }
            if (localc.puL.eglGetError() != 12299) {
              break label1000;
            }
            ac.e(localc.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
            i = -1;
          }
          for (;;)
          {
            if (i >= 0) {
              break label1041;
            }
            ac.e(localc.TAG, "createEGLContext failed -1");
            localObject1 = e.pny;
            e.cfd();
            break;
            localObject1 = arrayOfEGLConfig[0];
            break label795;
            label1000:
            ac.e(localc.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(localc.puL.eglGetError()) });
            i = -1;
            continue;
            label1036:
            i = 0;
          }
          label1041:
          if (!localc.puL.eglMakeCurrent(localc.puM, localc.puO, localc.puO, localc.puN))
          {
            ac.e(localc.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(localc.puL.eglGetError()));
            localObject1 = e.pny;
            e.cfd();
          }
          localObject1 = localc.puN;
          k.g(localObject1, "eGLContext");
          localObject1 = ((EGLContext)localObject1).getGL();
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
            AppMethodBeat.o(837);
            throw ((Throwable)localObject1);
          }
          localc.puQ = ((GL10)localObject1);
        }
      }
    });
    AppMethodBeat.o(845);
  }
  
  public final Surface cfZ()
  {
    AppMethodBeat.i(844);
    Surface localSurface = this.puS;
    if (localSurface == null) {
      k.aVY("videoDecodeSurface");
    }
    AppMethodBeat.o(844);
    return localSurface;
  }
  
  public final void i(a<y> parama)
  {
    AppMethodBeat.i(843);
    k.h(parama, "callback");
    this.puT.post((Runnable)new c.e(parama));
    AppMethodBeat.o(843);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.l
    implements a<y>
  {
    public a(c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(c paramc, boolean paramBoolean, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(839);
      c.a(this.puX).onSurfaceCreated(c.b(this.puX), this.puX.puP);
      c.a(this.puX).onSurfaceChanged(c.b(this.puX), this.puX.width, this.puX.height);
      Object localObject = c.a(this.puX);
      ((d)localObject).ppm = this.puY;
      try
      {
        ((d)localObject).fZP = new XLabEffect(0, 0, 0, false, 15);
        XLabEffect localXLabEffect = ((d)localObject).fZP;
        if (localXLabEffect != null) {
          localXLabEffect.setSize(((d)localObject).pvk, ((d)localObject).pvk);
        }
        localXLabEffect = ((d)localObject).fZP;
        if (localXLabEffect != null) {
          localXLabEffect.uQ(((d)localObject).ppm);
        }
        localXLabEffect = ((d)localObject).fZP;
        if (localXLabEffect != null) {
          localXLabEffect.a(((d)localObject).poJ);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e locale = e.pny;
          e.cfk();
        }
        AppMethodBeat.o(839);
      }
      localObject = this.puZ;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(839);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c
 * JD-Core Version:    0.7.0.1
 */