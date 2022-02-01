package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sticker.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"})
public final class c
{
  public final String TAG;
  final int height;
  final f pYP;
  final EGL10 qeV;
  EGLDisplay qeW;
  EGLContext qeX;
  EGLSurface qeY;
  EGLConfig qeZ;
  public GL10 qfa;
  public d qfb;
  Surface qfc;
  public aq qfd;
  HandlerThread qfe;
  public a<z> qff;
  final boolean qfg;
  final int width;
  
  public c(int paramInt1, int paramInt2, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(845);
    this.width = paramInt1;
    this.height = paramInt2;
    this.qfg = paramBoolean;
    this.pYP = paramf;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    paramf = EGLContext.getEGL();
    if (paramf == null)
    {
      paramf = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(845);
      throw paramf;
    }
    this.qeV = ((EGL10)paramf);
    this.qeW = EGL10.EGL_NO_DISPLAY;
    this.qeX = EGL10.EGL_NO_CONTEXT;
    this.qeY = EGL10.EGL_NO_SURFACE;
    paramf = com.tencent.e.c.d.hf("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
    p.g(paramf, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.qfe = paramf;
    this.qfe.start();
    this.qfd = new aq(this.qfe.getLooper());
    this.qfd.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(837);
        c localc = this.qfh;
        localc.qeW = localc.qeV.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (localc.qeW == EGL10.EGL_NO_DISPLAY) {
          ae.e(localc.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(localc.qeV.eglGetError()) });
        }
        Object localObject1 = new int[2];
        if (!localc.qeV.eglInitialize(localc.qeW, (int[])localObject1))
        {
          ae.e(localc.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(localc.qeV.eglGetError()) });
          localObject1 = e.pXD;
          e.ckW();
        }
        for (;;)
        {
          localc.qfb = new d(localc.qfg, localc.pYP);
          localObject1 = localc.qfb;
          if (localObject1 == null) {
            p.bdF("renderer");
          }
          if (!((d)localObject1).cBE)
          {
            ae.i(((d)localObject1).TAG, "init: ");
            localObject2 = b.qeU;
            localObject2 = com.tencent.mm.media.g.c.ee(false);
            ((d)localObject1).qfl = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject2).hnc);
            ((d)localObject1).qfk = ((com.tencent.mm.media.g.d)localObject2);
            localObject2 = b.qeU;
            ((d)localObject1).qfm = com.tencent.mm.media.g.c.ee(true);
            localObject2 = b.qeU;
            ((d)localObject1).hqJ = b.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
            ((d)localObject1).hqK = GLES20.glGetAttribLocation(((d)localObject1).hqJ, "a_position");
            ((d)localObject1).hqL = GLES20.glGetAttribLocation(((d)localObject1).hqJ, "a_texCoord");
            ((d)localObject1).hqN = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "videoExternalTexture");
            ((d)localObject1).hqO = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "videoNormalTexture");
            ((d)localObject1).hqP = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "emojiTexture");
            ((d)localObject1).qfn = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "size");
            ((d)localObject1).qfo = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "radius");
            ((d)localObject1).hqQ = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "hasEmojiTexture");
            ((d)localObject1).hqS = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "uMatrix");
            ((d)localObject1).hqR = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "useNormalVideoTexture");
            ((d)localObject1).qfp = GLES20.glGetUniformLocation(((d)localObject1).hqJ, "enableAlpha");
            localObject2 = b.qeU;
            ((d)localObject1).qfq = b.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
            ((d)localObject1).qfr = GLES20.glGetAttribLocation(((d)localObject1).qfq, "a_position");
            ((d)localObject1).qfs = GLES20.glGetAttribLocation(((d)localObject1).qfq, "a_texCoord");
            ((d)localObject1).qft = GLES20.glGetUniformLocation(((d)localObject1).qfq, "texture");
            ((d)localObject1).gNV.put(b.hrw);
            ((d)localObject1).qfy.put(b.hrx);
            localObject2 = b.qeU;
            ((d)localObject1).qfv = b.a.clS();
            localObject2 = b.qeU;
            ((d)localObject1).qfw = com.tencent.mm.media.g.c.ee(true);
            localObject2 = b.qeU;
            ((d)localObject1).qfx = com.tencent.mm.media.g.c.ee(true);
            ((d)localObject1).cBE = true;
          }
          localObject1 = localc.qfb;
          if (localObject1 == null) {
            p.bdF("renderer");
          }
          ((d)localObject1).clU().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)new c.c(localc));
          localObject1 = localc.qfb;
          if (localObject1 == null) {
            p.bdF("renderer");
          }
          localc.qfc = new Surface(((d)localObject1).clU());
          AppMethodBeat.o(837);
          return;
          localObject1 = b.qeU;
          localObject1 = localc.qeV;
          Object localObject2 = localc.qeW;
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
            ae.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(((EGL10)localObject1).eglGetError()) });
            localObject1 = null;
            label795:
            localc.qeZ = ((EGLConfig)localObject1);
            localObject1 = localc.qeZ;
            if (localObject1 == null) {
              continue;
            }
            localc.qeX = localc.qeV.eglCreateContext(localc.qeW, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            i = localc.width;
            int j = localc.height;
            localc.qeY = localc.qeV.eglCreatePbufferSurface(localc.qeW, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
            if ((localc.qeY != EGL10.EGL_NO_SURFACE) && (localc.qeX != EGL10.EGL_NO_CONTEXT)) {
              break label1036;
            }
            if (localc.qeV.eglGetError() != 12299) {
              break label1000;
            }
            ae.e(localc.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
            i = -1;
          }
          for (;;)
          {
            if (i >= 0) {
              break label1041;
            }
            ae.e(localc.TAG, "createEGLContext failed -1");
            localObject1 = e.pXD;
            e.ckW();
            break;
            localObject1 = arrayOfEGLConfig[0];
            break label795;
            label1000:
            ae.e(localc.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(localc.qeV.eglGetError()) });
            i = -1;
            continue;
            label1036:
            i = 0;
          }
          label1041:
          if (!localc.qeV.eglMakeCurrent(localc.qeW, localc.qeY, localc.qeY, localc.qeX))
          {
            ae.e(localc.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(localc.qeV.eglGetError()));
            localObject1 = e.pXD;
            e.ckW();
          }
          localObject1 = localc.qeX;
          p.g(localObject1, "eGLContext");
          localObject1 = ((EGLContext)localObject1).getGL();
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
            AppMethodBeat.o(837);
            throw ((Throwable)localObject1);
          }
          localc.qfa = ((GL10)localObject1);
        }
      }
    });
    AppMethodBeat.o(845);
  }
  
  public final Surface clT()
  {
    AppMethodBeat.i(844);
    Surface localSurface = this.qfc;
    if (localSurface == null) {
      p.bdF("videoDecodeSurface");
    }
    AppMethodBeat.o(844);
    return localSurface;
  }
  
  public final void j(a<z> parama)
  {
    AppMethodBeat.i(843);
    p.h(parama, "callback");
    this.qfd.post((Runnable)new c.e(parama));
    AppMethodBeat.o(843);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements a<z>
  {
    public a(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(c paramc, boolean paramBoolean, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(839);
      c.a(this.qfh).onSurfaceCreated(c.b(this.qfh), this.qfh.qeZ);
      c.a(this.qfh).onSurfaceChanged(c.b(this.qfh), this.qfh.width, this.qfh.height);
      Object localObject = c.a(this.qfh);
      ((d)localObject).pZs = this.qfi;
      try
      {
        ((d)localObject).gvS = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
        com.tencent.mm.plugin.xlabeffect.b localb = ((d)localObject).gvS;
        if (localb != null) {
          localb.setSize(((d)localObject).qfu, ((d)localObject).qfu);
        }
        localb = ((d)localObject).gvS;
        if (localb != null) {
          localb.vJ(((d)localObject).pZs);
        }
        localb = ((d)localObject).gvS;
        if (localb != null) {
          localb.a(((d)localObject).pYP);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e locale = e.pXD;
          e.cld();
        }
        AppMethodBeat.o(839);
      }
      localObject = this.qfj;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(839);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class c
    implements SurfaceTexture.OnFrameAvailableListener
  {
    c(c paramc) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(840);
      paramSurfaceTexture = this.qfh;
      ae.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
      paramSurfaceTexture.j((a)new c.d(paramSurfaceTexture));
      AppMethodBeat.o(840);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c
 * JD-Core Version:    0.7.0.1
 */