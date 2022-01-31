package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private com.tencent.luggage.xweb_ext.extendplugin.a bFZ;
  private a.a bGa;
  private int bGb;
  private int bGc;
  private boolean bGd;
  boolean bGe;
  boolean bGf;
  public boolean bHA;
  boolean bHB;
  boolean bHC;
  boolean bHD;
  long bHE;
  boolean bHF;
  public boolean bHG;
  volatile boolean bHH;
  boolean bHI;
  private boolean bHJ;
  int bHK;
  int bHL;
  private String bHM;
  private String bHN;
  boolean bHO;
  boolean bHP;
  private final ConcurrentLinkedQueue<Runnable> bHQ;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b bHu;
  public c bHv;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b bHw;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.a.d bHx;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.a.e bHy;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a bHz;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  int mVideoHeight;
  int mVideoWidth;
  
  public a()
  {
    AppMethodBeat.i(139855);
    this.bHI = false;
    this.bHJ = false;
    this.bHQ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(139855);
  }
  
  private String a(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(139861);
    String str = paramString;
    if (this.bHz != null) {
      str = this.bHz.a(parama, paramString);
    }
    cn(str);
    AppMethodBeat.o(139861);
    return str;
  }
  
  private void cn(String paramString)
  {
    AppMethodBeat.i(154422);
    if (((this.bHu instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b)) && (com.tencent.luggage.a.e.q(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class) != null))
    {
      boolean bool = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b)com.tencent.luggage.a.e.q(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class)).k(paramString, 0L, -1L);
      ab.i(xo(), "convertVideoPath, video cached:%s", new Object[] { Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(154422);
  }
  
  private static void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(154427);
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, null);
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject, 1, arrayOfInt);
    arrayOfInt = localObject[0];
    localObject = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    paramSurfaceTexture = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, paramSurfaceTexture, new int[] { 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    localEGL10.eglSwapBuffers(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglDestroySurface(localEGLDisplay, paramSurfaceTexture);
    paramSurfaceTexture = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject);
    localEGL10.eglTerminate(localEGLDisplay);
    AppMethodBeat.o(154427);
  }
  
  private void fy(int paramInt)
  {
    AppMethodBeat.i(139874);
    if (this.bHx != null) {
      this.bHx.at(paramInt);
    }
    AppMethodBeat.o(139874);
  }
  
  private void mw()
  {
    AppMethodBeat.i(139873);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(139873);
  }
  
  private void xA()
  {
    AppMethodBeat.i(139858);
    synchronized (this.bHQ)
    {
      if (this.bHQ.isEmpty()) {
        break label99;
      }
      ab.i(xo(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.bHQ.size()) });
      Iterator localIterator = this.bHQ.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.bHQ.clear();
    label99:
    AppMethodBeat.o(139858);
  }
  
  private void xC()
  {
    AppMethodBeat.i(154423);
    if (this.bHw != null)
    {
      this.bHw.destroy();
      this.bHw = null;
    }
    AppMethodBeat.o(154423);
  }
  
  private void xD()
  {
    AppMethodBeat.i(154424);
    if (this.bHv != null)
    {
      this.bHv.destroy();
      this.bHv = null;
    }
    AppMethodBeat.o(154424);
  }
  
  private void xE()
  {
    AppMethodBeat.i(139869);
    xF();
    xG();
    xH();
    AppMethodBeat.o(139869);
  }
  
  private void xF()
  {
    try
    {
      AppMethodBeat.i(139870);
      if (this.bHu != null)
      {
        ab.i(xo(), "releaseMediaPlayer");
        this.bHu.a(null);
        this.bHu.a(null);
        this.bHu.a(null);
        this.bHu.a(null);
        this.bHu.a(null);
        this.bHu.a(null);
        this.bHu.stop();
        this.bHu.reset();
        this.bHu.release();
      }
      this.bHu = null;
      this.bHH = false;
      AppMethodBeat.o(139870);
      return;
    }
    finally {}
  }
  
  private void xG()
  {
    AppMethodBeat.i(139871);
    ab.i(xo(), "createMediaPlayer");
    if (this.bHz != null) {
      this.bHu = this.bHz.g(this.bFZ);
    }
    if (this.bHu != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bHH = bool;
      if (this.bHH) {
        break;
      }
      ab.e("MicroMsg.SameLayer.VideoPluginHandler", "createMediaPlayer, create media player fail");
      AppMethodBeat.o(139871);
      return;
    }
    String str2 = xo();
    if ((this.bHu instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d)) {}
    for (String str1 = "SystemMediaPlayer";; str1 = "ExoMediaPlayer")
    {
      ab.i(str2, "createMediaPlayer, %s", new Object[] { str1 });
      this.bHu.a(new a.7(this));
      this.bHu.a(new a.8(this));
      this.bHu.a(new a.9(this));
      this.bHu.a(new a.10(this));
      this.bHu.a(new a.11(this));
      this.bHu.a(new a.2(this));
      this.bHu.a(new a.3(this));
      AppMethodBeat.o(139871);
      return;
    }
  }
  
  private void xH()
  {
    AppMethodBeat.i(139872);
    if (this.bHu != null)
    {
      this.bHu.setMute(this.bHJ);
      if (this.mSurface != null) {
        this.bHu.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(139872);
  }
  
  private void xI()
  {
    AppMethodBeat.i(154426);
    try
    {
      if ((this.mSurfaceTexture != null) && (this.bHG))
      {
        ab.i(xo(), "clearSurfaceTexture");
        e(this.mSurfaceTexture);
      }
      AppMethodBeat.o(154426);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.VideoPluginHandler", localException, "clearSurfaceTexture error", new Object[0]);
      AppMethodBeat.o(154426);
    }
  }
  
  private void xs()
  {
    AppMethodBeat.i(154421);
    if (this.bFZ != null)
    {
      this.bFZ.xm();
      this.bGa = null;
    }
    AppMethodBeat.o(154421);
  }
  
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool2 = true;
    int k = 1;
    boolean bool3 = false;
    int i = 0;
    AppMethodBeat.i(139860);
    Object localObject1 = parama.xl();
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(139860);
      return null;
    }
    Object localObject2 = parama.xk();
    ab.i(xo(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { tX(), localObject1, ((JSONObject)localObject2).toString() });
    if (((String)localObject1).contains("insert"))
    {
      fy(21);
      this.bFZ = parama;
      if (this.bHu == null)
      {
        ab.w("MicroMsg.SameLayer.VideoPluginHandler", "insert, media player is null");
        xE();
      }
      this.bGa = new a.4(this);
      parama.a(this.bGa);
      if ((this.mSurface != null) && (this.bHu != null))
      {
        ab.i("MicroMsg.SameLayer.VideoPluginHandler", "insert, setSurface");
        this.bHu.setSurface(this.mSurface);
      }
      localObject1 = parama.xk();
      this.bHF = ((JSONObject)localObject1).optBoolean("autoplay", false);
      this.bHE = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
      this.bHI = ((JSONObject)localObject1).optBoolean("loop", false);
      this.bHJ = ((JSONObject)localObject1).optBoolean("muted", false);
      this.bHu.setMute(this.bHJ);
      this.bGe = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
      this.bGf = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
      this.bGd = ((JSONObject)localObject1).optBoolean("needEvent", false);
      if ((this.bGd) && (this.bHv != null))
      {
        this.bHv.d(parama);
        localObject2 = ((JSONObject)localObject1).optString("data", "");
        this.bHv.co((String)localObject2);
      }
      if (((JSONObject)localObject1).has("position"))
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("position");
        if (localObject2 != null)
        {
          this.bGb = ((JSONObject)localObject2).optInt("width", 0);
          this.bGc = ((JSONObject)localObject2).optInt("height", 0);
          ab.i(xo(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
        }
      }
      this.bHN = ((JSONObject)localObject1).optString("objectFit", "contain");
      if (bo.isNullOrNil(this.bHN)) {
        this.bHN = "contain";
      }
      xB();
      this.bHM = ((JSONObject)localObject1).optString("filePath");
      if ((!bo.isNullOrNil(this.bHM)) && (this.bHu != null))
      {
        this.bHM = a(parama, this.bHM);
        ab.i(xo(), "insert, path:%s", new Object[] { this.bHM });
        this.bHu.setDataSource(this.bHM);
        ab.i("MicroMsg.SameLayer.VideoPluginHandler", "insert, media player prepare async");
        prepareAsync();
      }
      parama.ck("ok");
    }
    for (;;)
    {
      AppMethodBeat.o(139860);
      return null;
      if (!((String)localObject1).contains("update")) {
        break label1226;
      }
      fy(22);
      if (this.bHu != null) {
        break;
      }
      ab.w("MicroMsg.SameLayer.VideoPluginHandler", "update, media player is null");
      parama.ck("fail");
    }
    localObject1 = parama.xk();
    if (((JSONObject)localObject1).has("filePath"))
    {
      localObject2 = a(parama, ((JSONObject)localObject1).optString("filePath"));
      if ((!bo.isNullOrNil((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(this.bHM)))
      {
        ab.i(xo(), "update, path:%s", new Object[] { localObject2 });
        if ((this.bHu == null) || (!bo.isNullOrNil(this.bHM))) {
          xE();
        }
        this.bHM = ((String)localObject2);
        this.bHu.setDataSource(this.bHM);
      }
    }
    for (int j = 1;; j = 0)
    {
      if ((this.mSurface != null) && (this.bHu != null))
      {
        ab.i("MicroMsg.SameLayer.VideoPluginHandler", "update, setSurface");
        this.bHu.setSurface(this.mSurface);
      }
      if (((JSONObject)localObject1).has("autoplay")) {
        this.bHF = ((JSONObject)localObject1).optBoolean("autoplay", this.bHF);
      }
      if (((JSONObject)localObject1).has("initialTime")) {
        this.bHE = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
      }
      if (((JSONObject)localObject1).has("loop")) {
        this.bHI = ((JSONObject)localObject1).optBoolean("loop", this.bHI);
      }
      if (((JSONObject)localObject1).has("muted"))
      {
        this.bHJ = ((JSONObject)localObject1).optBoolean("muted", this.bHJ);
        this.bHu.setMute(this.bHJ);
      }
      if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
        this.bGe = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", this.bGe);
      }
      if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
        this.bGf = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", this.bGf);
      }
      if (((JSONObject)localObject1).has("needEvent"))
      {
        this.bGd = ((JSONObject)localObject1).optBoolean("needEvent", this.bGd);
        if ((this.bGd) && (this.bHv != null))
        {
          this.bHv.d(parama);
          if (((JSONObject)localObject1).has("data"))
          {
            localObject2 = ((JSONObject)localObject1).optString("data", "");
            this.bHv.co((String)localObject2);
          }
        }
      }
      if (((JSONObject)localObject1).has("position"))
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("position");
        if (localObject2 != null)
        {
          this.bGb = ((JSONObject)localObject2).optInt("width", this.bGb);
          this.bGc = ((JSONObject)localObject2).optInt("height", this.bGc);
          ab.i(xo(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
        }
        i = 1;
      }
      if (((JSONObject)localObject1).has("objectFit"))
      {
        this.bHN = ((JSONObject)localObject1).optString("objectFit", this.bHN);
        i = k;
        if (bo.isNullOrNil(this.bHN))
        {
          this.bHN = "contain";
          i = k;
        }
      }
      for (;;)
      {
        if (i != 0) {
          xB();
        }
        if (j != 0)
        {
          ab.i("MicroMsg.SameLayer.VideoPluginHandler", "update, media player prepare async");
          prepareAsync();
        }
        parama.ck("ok");
        break;
        label1226:
        boolean bool1;
        if (((String)localObject1).contains("operate"))
        {
          fy(23);
          if (this.bHu == null)
          {
            ab.w("MicroMsg.SameLayer.VideoPluginHandler", "operate, media player is null");
            parama.ck("fail");
            break;
          }
          localObject1 = parama.xk();
          localObject2 = ((JSONObject)localObject1).optString("type");
          if (bo.isNullOrNil((String)localObject2)) {
            break label1997;
          }
          ab.i(xo(), "operate, type:%s", new Object[] { localObject2 });
          if (((String)localObject2).equalsIgnoreCase("play"))
          {
            fy(25);
            bool1 = play();
          }
        }
        for (;;)
        {
          label1340:
          if (bool1) {}
          for (localObject1 = "ok";; localObject1 = "fail")
          {
            parama.ck((String)localObject1);
            break;
            if (((String)localObject2).equalsIgnoreCase("pause"))
            {
              fy(26);
              bool1 = pause();
              break label1340;
            }
            if (((String)localObject2).equalsIgnoreCase("stop"))
            {
              fy(27);
              if (this.bHu != null)
              {
                ab.i(xo(), "video stop");
                this.bHu.stop();
                bool1 = bool2;
                if (!xt()) {
                  break label1340;
                }
                this.bHv.onVideoPause();
                bool1 = bool2;
                break label1340;
              }
              bool1 = false;
              break label1340;
            }
            label1542:
            double d;
            if (((String)localObject2).equalsIgnoreCase("seek"))
            {
              fy(28);
              if ((this.bHu != null) && (localObject1 != null) && (((JSONObject)localObject1).has("data")))
              {
                localObject1 = ((JSONObject)localObject1).optJSONArray("data");
                if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                  break label1542;
                }
                ab.w("MicroMsg.SameLayer.VideoPluginHandler", "seek, data array is null");
              }
              for (;;)
              {
                bool1 = false;
                break;
                d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                if (d >= 0.0D) {
                  break label1581;
                }
                ab.w("MicroMsg.SameLayer.VideoPluginHandler", "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
              }
              label1581:
              ab.i(xo(), "seek, position:%s", new Object[] { Double.valueOf(d) });
              seek((d * 1000.0D));
              bool1 = bool2;
              break label1340;
            }
            if (((String)localObject2).equalsIgnoreCase("playbackRate"))
            {
              fy(29);
              bool1 = bool3;
              if (this.bHu != null)
              {
                bool1 = bool3;
                if (localObject1 != null)
                {
                  bool1 = bool3;
                  if (((JSONObject)localObject1).has("data"))
                  {
                    localObject1 = ((JSONObject)localObject1).optJSONArray("data");
                    if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                      break label1710;
                    }
                    ab.w("MicroMsg.SameLayer.VideoPluginHandler", "speed, data array is null");
                    bool1 = bool3;
                  }
                }
              }
              for (;;)
              {
                break;
                label1710:
                d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                if (d < 0.0D)
                {
                  ab.w("MicroMsg.SameLayer.VideoPluginHandler", "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                  bool1 = bool3;
                }
                else
                {
                  ab.i(xo(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                  bool1 = this.bHu.Y((float)d);
                }
              }
            }
            if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
            {
              fy(30);
              ab.i(xo(), "requestFullscreen");
              if (this.bHz != null)
              {
                bool1 = bool2;
                if (this.bHz.b(parama)) {
                  break label1340;
                }
              }
              bool1 = false;
              break label1340;
            }
            if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
            {
              fy(31);
              ab.i(xo(), "exitFullscreen");
              if (this.bHz != null)
              {
                bool1 = bool2;
                if (this.bHz.c(parama)) {
                  break label1340;
                }
              }
              bool1 = false;
              break label1340;
            }
            if (!((String)localObject2).equalsIgnoreCase("setScreenBrightness")) {
              break label1997;
            }
            ab.i(xo(), "setScreenBrightness");
            if (this.bHz != null)
            {
              bool1 = bool2;
              if (this.bHz.h(parama)) {
                break label1340;
              }
            }
            bool1 = false;
            break label1340;
          }
          if (!((String)localObject1).contains("remove")) {
            break;
          }
          fy(24);
          release();
          parama.ck("ok");
          break;
          label1997:
          bool1 = false;
        }
      }
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139857);
    super.d(paramSurfaceTexture);
    ab.i(xo(), "*** handler(%s) handlePluginReady", new Object[] { tX() });
    this.bHA = false;
    this.bHB = false;
    this.bHC = false;
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(paramSurfaceTexture);
    if (this.bHu != null)
    {
      ab.i("MicroMsg.SameLayer.VideoPluginHandler", "handlePluginReady, setSurface");
      this.bHu.setSurface(this.mSurface);
    }
    xA();
    AppMethodBeat.o(139857);
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(139867);
    if (this.bHu != null)
    {
      int i = this.bHu.getDuration();
      AppMethodBeat.o(139867);
      return i;
    }
    AppMethodBeat.o(139867);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(154425);
    if (this.bHu != null)
    {
      boolean bool = this.bHu.isPlaying();
      AppMethodBeat.o(154425);
      return bool;
    }
    AppMethodBeat.o(154425);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(139865);
    if (this.bHu != null)
    {
      if (!this.bHu.isPlaying())
      {
        ab.i(xo(), "video pause, video is not playing");
        AppMethodBeat.o(139865);
        return true;
      }
      if (!this.bHG)
      {
        ab.i(xo(), "video pause, video not prepared yet, pause video when prepared");
        this.bHF = false;
        AppMethodBeat.o(139865);
        return true;
      }
      ab.i(xo(), "video pause");
      this.bHu.pause();
      if (xt()) {
        this.bHv.onVideoPause();
      }
      AppMethodBeat.o(139865);
      return true;
    }
    AppMethodBeat.o(139865);
    return false;
  }
  
  final boolean play()
  {
    AppMethodBeat.i(139864);
    if (this.bHu != null)
    {
      if ((this.bHG) && (this.bHu.isPlaying()))
      {
        ab.i(xo(), "video play, video is playing");
        if (xt()) {
          this.bHv.onVideoPlay();
        }
        AppMethodBeat.o(139864);
        return true;
      }
      if ((this.bHu != null) && (!this.bHG))
      {
        ab.i(xo(), "video play, video not prepared yet, start until prepared");
        this.bHF = true;
        AppMethodBeat.o(139864);
        return true;
      }
      if ((this.bHu != null) && (this.bHu.getState() == 5))
      {
        ab.i(xo(), "video play, video has stopped now, try prepare and start when prepared");
        this.bHF = true;
        ab.i("MicroMsg.SameLayer.VideoPluginHandler", "video play, media player prepare async");
        prepareAsync();
        AppMethodBeat.o(139864);
        return true;
      }
      if (this.bHO)
      {
        ab.i(xo(), "video play, video has ended playing, clear surface and start again");
        this.bHO = false;
        xI();
        xE();
        if (this.bHu != null)
        {
          this.bHF = true;
          this.bHu.setDataSource(this.bHM);
          ab.i("MicroMsg.SameLayer.VideoPluginHandler", "video play, media player state:%s", new Object[] { Integer.valueOf(this.bHu.getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(139864);
        return true;
      }
      if (this.bHu != null)
      {
        this.bHu.start();
        if (xt()) {
          this.bHv.onVideoPlay();
        }
      }
      AppMethodBeat.o(139864);
      return true;
    }
    AppMethodBeat.o(139864);
    return false;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(139863);
    if (this.bHu != null)
    {
      ab.i(xo(), "video prepare async");
      if (xt()) {
        this.bHv.onVideoWaiting();
      }
      this.bHG = false;
      if (this.bHu != null) {
        this.bHu.prepareAsync();
      }
    }
    AppMethodBeat.o(139863);
  }
  
  final void release()
  {
    AppMethodBeat.i(139866);
    ab.i(xo(), "video release");
    xD();
    xC();
    xF();
    mw();
    xs();
    AppMethodBeat.o(139866);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(139868);
    if ((this.bHG) && (this.bHu != null))
    {
      if (xt()) {
        this.bHv.onVideoWaiting();
      }
      if (this.bHu != null)
      {
        this.bHB = isPlaying();
        this.bHu.seekTo(paramLong);
        AppMethodBeat.o(139868);
      }
    }
    else
    {
      this.bHE = paramLong;
    }
    AppMethodBeat.o(139868);
  }
  
  final void xB()
  {
    AppMethodBeat.i(139862);
    if (!bo.isNullOrNil(this.bHN))
    {
      if ((this.bHG) && (yh() != null) && (this.bHy != null))
      {
        if (this.bHy.a(this.bHN, this.bGb, this.bGc, this.mVideoWidth, this.mVideoHeight))
        {
          ab.i(xo(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.bHN, Float.valueOf(this.bHy.xU()), Float.valueOf(this.bHy.xV()) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(yh(), getType(), getId(), this.bHy.xU(), this.bHy.xV());
          AppMethodBeat.o(139862);
        }
      }
      else
      {
        ab.i(xo(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(139862);
      }
    }
    else {
      ab.i(xo(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(139862);
  }
  
  public final String xo()
  {
    AppMethodBeat.i(139856);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", tX() });
    AppMethodBeat.o(139856);
    return str;
  }
  
  public final boolean xp()
  {
    return true;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(139859);
    super.xq();
    ab.i(xo(), "*** handler(%s) handlePluginDestroy", new Object[] { tX() });
    pause();
    mw();
    AppMethodBeat.o(139859);
  }
  
  /* Error */
  final boolean xt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 490	com/tencent/luggage/xweb_ext/extendplugin/component/video/a:bGd	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 272	com/tencent/luggage/xweb_ext/extendplugin/component/video/a:bHv	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/a/c;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	a
    //   19	7	1	bool	boolean
    //   13	2	2	localc	c
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a
 * JD-Core Version:    0.7.0.1
 */