package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.xlabeffect.k;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final String TAG;
  private final int height;
  private final int width;
  private final f yhU;
  private Surface ynA;
  private MMHandler ynB;
  HandlerThread ynC;
  public a<ah> ynD;
  private final boolean yns;
  final EGL10 ynt;
  EGLDisplay ynu;
  EGLContext ynv;
  EGLSurface ynw;
  private EGLConfig ynx;
  public GL10 yny;
  public d ynz;
  
  public c(int paramInt1, int paramInt2, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(845);
    this.width = paramInt1;
    this.height = paramInt2;
    this.yns = paramBoolean;
    this.yhU = paramf;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    paramf = EGLContext.getEGL();
    if (paramf == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(845);
      throw paramf;
    }
    this.ynt = ((EGL10)paramf);
    this.ynu = EGL10.EGL_NO_DISPLAY;
    this.ynv = EGL10.EGL_NO_CONTEXT;
    this.ynw = EGL10.EGL_NO_SURFACE;
    paramf = com.tencent.threadpool.c.d.jv("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
    s.s(paramf, "createEGLThread(\"EmojiCa…ad\",Thread.NORM_PRIORITY)");
    this.ynC = paramf;
    this.ynC.start();
    this.ynB = new MMHandler(this.ynC.getLooper());
    this.ynB.post(new c..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(845);
  }
  
  private static final void a(c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(269450);
    s.u(paramc, "this$0");
    paramc.ynu = paramc.ynt.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (paramc.ynu == EGL10.EGL_NO_DISPLAY) {
      Log.e(paramc.TAG, "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(paramc.ynt.eglGetError()) });
    }
    Object localObject1 = new int[2];
    Object localObject3;
    Object localObject4;
    if (!paramc.ynt.eglInitialize(paramc.ynu, (int[])localObject1))
    {
      Log.e(paramc.TAG, "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(paramc.ynt.eglGetError()) });
      localObject1 = e.ygT;
      e.dDX();
      paramc.ynz = new d(paramc.yns, paramc.yhU);
      localObject3 = paramc.ynz;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("renderer");
        localObject1 = null;
      }
      if (!((d)localObject1).isInit)
      {
        Log.i(((d)localObject1).TAG, "init: ");
        localObject3 = b.ynr;
        localObject3 = com.tencent.mm.media.g.c.gm(false);
        ((d)localObject1).ynG = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject3).nAF);
        localObject4 = ah.aiuX;
        ((d)localObject1).ynF = ((com.tencent.mm.media.g.d)localObject3);
        localObject3 = b.ynr;
        ((d)localObject1).ynH = com.tencent.mm.media.g.c.gm(true);
        localObject3 = b.ynr;
        ((d)localObject1).nEf = b.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
        ((d)localObject1).nEg = GLES20.glGetAttribLocation(((d)localObject1).nEf, "a_position");
        ((d)localObject1).nEh = GLES20.glGetAttribLocation(((d)localObject1).nEf, "a_texCoord");
        ((d)localObject1).nEj = GLES20.glGetUniformLocation(((d)localObject1).nEf, "videoExternalTexture");
        ((d)localObject1).nEk = GLES20.glGetUniformLocation(((d)localObject1).nEf, "videoNormalTexture");
        ((d)localObject1).nEl = GLES20.glGetUniformLocation(((d)localObject1).nEf, "emojiTexture");
        ((d)localObject1).ynI = GLES20.glGetUniformLocation(((d)localObject1).nEf, "size");
        ((d)localObject1).ynJ = GLES20.glGetUniformLocation(((d)localObject1).nEf, "radius");
        ((d)localObject1).nEm = GLES20.glGetUniformLocation(((d)localObject1).nEf, "hasEmojiTexture");
        ((d)localObject1).nEo = GLES20.glGetUniformLocation(((d)localObject1).nEf, "uMatrix");
        ((d)localObject1).nEn = GLES20.glGetUniformLocation(((d)localObject1).nEf, "useNormalVideoTexture");
        ((d)localObject1).ynK = GLES20.glGetUniformLocation(((d)localObject1).nEf, "enableAlpha");
        localObject3 = b.ynr;
        ((d)localObject1).ynL = b.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        ((d)localObject1).ynM = GLES20.glGetAttribLocation(((d)localObject1).ynL, "a_position");
        ((d)localObject1).ynN = GLES20.glGetAttribLocation(((d)localObject1).ynL, "a_texCoord");
        ((d)localObject1).ynO = GLES20.glGetUniformLocation(((d)localObject1).ynL, "texture");
        ((d)localObject1).mVV.put(b.nFt);
        ((d)localObject1).ynT.put(b.nFu);
        localObject3 = b.ynr;
        ((d)localObject1).ynQ = b.a.dEV();
        localObject3 = b.ynr;
        ((d)localObject1).ynR = com.tencent.mm.media.g.c.gm(true);
        localObject3 = b.ynr;
        ((d)localObject1).ynS = com.tencent.mm.media.g.c.gm(true);
        ((d)localObject1).isInit = true;
      }
      localObject3 = paramc.ynz;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("renderer");
        localObject1 = null;
      }
      ((d)localObject1).dEX().setOnFrameAvailableListener(new c..ExternalSyntheticLambda0(paramc));
      localObject1 = paramc.ynz;
      if (localObject1 != null) {
        break label1167;
      }
      s.bIx("renderer");
      localObject1 = localObject2;
    }
    label1027:
    label1167:
    for (;;)
    {
      paramc.ynA = new Surface(((d)localObject1).dEX());
      AppMethodBeat.o(269450);
      return;
      localObject1 = b.ynr;
      localObject1 = paramc.ynt;
      localObject3 = paramc.ynu;
      s.s(localObject3, "eGLDisplay");
      s.u(localObject1, "eGL");
      s.u(localObject3, "eGLDisplay");
      localObject4 = new int[15];
      localObject4[0] = 12324;
      localObject4[1] = 8;
      localObject4[2] = 12323;
      localObject4[3] = 8;
      localObject4[4] = 12322;
      localObject4[5] = 8;
      localObject4[6] = 12321;
      localObject4[7] = 8;
      localObject4[8] = 12325;
      localObject4[9] = 0;
      localObject4[10] = 12326;
      localObject4[11] = 0;
      localObject4[12] = 12352;
      localObject4[13] = 4;
      localObject4[14] = 12344;
      int[] arrayOfInt = new int[1];
      ((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject3, (int[])localObject4, null, 0, arrayOfInt);
      int i = arrayOfInt[0];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!((EGL10)localObject1).eglChooseConfig((EGLDisplay)localObject3, (int[])localObject4, arrayOfEGLConfig, i, arrayOfInt))
      {
        Log.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(((EGL10)localObject1).eglGetError()) });
        localObject1 = null;
        label830:
        paramc.ynx = ((EGLConfig)localObject1);
        localObject1 = paramc.ynx;
        if (localObject1 == null) {
          break;
        }
        paramc.ynv = paramc.ynt.eglCreateContext(paramc.ynu, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        i = paramc.width;
        int j = paramc.height;
        paramc.ynw = paramc.ynt.eglCreatePbufferSurface(paramc.ynu, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
        if ((paramc.ynw != EGL10.EGL_NO_SURFACE) && (paramc.ynv != EGL10.EGL_NO_CONTEXT)) {
          break label1061;
        }
        if (paramc.ynt.eglGetError() != 12299) {
          break label1027;
        }
        Log.e(paramc.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
        i = -1;
      }
      for (;;)
      {
        if (i >= 0) {
          break label1066;
        }
        Log.e(paramc.TAG, s.X("createEGLContext failed ", Integer.valueOf(i)));
        localObject1 = e.ygT;
        e.dDX();
        break;
        localObject1 = arrayOfEGLConfig[0];
        break label830;
        Log.e(paramc.TAG, "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(paramc.ynt.eglGetError()) });
        i = -1;
        continue;
        label1061:
        i = 0;
      }
      label1066:
      if (!paramc.ynt.eglMakeCurrent(paramc.ynu, paramc.ynw, paramc.ynw, paramc.ynv))
      {
        Log.e(paramc.TAG, s.X("eglMakeCurrent failed : ", GLUtils.getEGLErrorString(paramc.ynt.eglGetError())));
        localObject1 = e.ygT;
        e.dDX();
      }
      localObject1 = paramc.ynv.getGL();
      if (localObject1 == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
        AppMethodBeat.o(269450);
        throw paramc;
      }
      paramc.yny = ((GL10)localObject1);
      break;
    }
  }
  
  private static final void a(c paramc, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(269453);
    s.u(paramc, "this$0");
    Log.i(paramc.TAG, "onVideoSurfaceFrameAvailable");
    paramc.K((a)new c.b(paramc));
    AppMethodBeat.o(269453);
  }
  
  private static final void a(c paramc, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(269461);
    s.u(paramc, "this$0");
    Object localObject2 = paramc.ynz;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("renderer");
      localObject1 = null;
    }
    GL10 localGL10 = paramc.yny;
    localObject2 = localGL10;
    if (localGL10 == null)
    {
      s.bIx("gl");
      localObject2 = null;
    }
    ((d)localObject1).onSurfaceCreated((GL10)localObject2, paramc.ynx);
    localObject2 = paramc.ynz;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("renderer");
      localObject1 = null;
    }
    localGL10 = paramc.yny;
    localObject2 = localGL10;
    if (localGL10 == null)
    {
      s.bIx("gl");
      localObject2 = null;
    }
    ((d)localObject1).onSurfaceChanged((GL10)localObject2, paramc.width, paramc.height);
    paramc = paramc.ynz;
    if (paramc == null)
    {
      s.bIx("renderer");
      paramc = null;
    }
    for (;;)
    {
      paramc.yis = paramBoolean;
      try
      {
        paramc.muW = new k(0, 0, 0, false, false, 47);
        localObject1 = paramc.muW;
        if (localObject1 != null) {
          ((k)localObject1).setSize(paramc.ynP, paramc.ynP);
        }
        localObject1 = paramc.muW;
        if (localObject1 != null) {
          ((k)localObject1).Jo(paramc.yis);
        }
        localObject1 = paramc.muW;
        if (localObject1 != null) {
          ((k)localObject1).a(paramc.yhU);
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          paramc = e.ygT;
          e.dEe();
        }
      }
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(269461);
      return;
    }
  }
  
  private static final void aN(a parama)
  {
    AppMethodBeat.i(269456);
    s.u(parama, "$callback");
    parama.invoke();
    AppMethodBeat.o(269456);
  }
  
  public final void K(a<ah> parama)
  {
    AppMethodBeat.i(843);
    s.u(parama, "callback");
    this.ynB.post(new c..ExternalSyntheticLambda3(parama));
    AppMethodBeat.o(843);
  }
  
  public final void b(boolean paramBoolean, a<ah> parama)
  {
    AppMethodBeat.i(269481);
    this.ynB.post(new c..ExternalSyntheticLambda2(this, paramBoolean, parama));
    AppMethodBeat.o(269481);
  }
  
  public final Surface dEW()
  {
    AppMethodBeat.i(844);
    Surface localSurface = this.ynA;
    if (localSurface == null)
    {
      s.bIx("videoDecodeSurface");
      AppMethodBeat.o(844);
      return null;
    }
    AppMethodBeat.o(844);
    return localSurface;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements a<ah>
  {
    public a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c
 * JD-Core Version:    0.7.0.1
 */