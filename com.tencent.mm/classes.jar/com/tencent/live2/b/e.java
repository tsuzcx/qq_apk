package com.tencent.live2.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends V2TXLivePusher
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, f.a, TRTCCloudListener.TRTCVideoFrameListener
{
  private Context a;
  private f b;
  private Handler c;
  private V2TXLiveDef.V2TXLiveAudioQuality d;
  private V2TXLivePusherObserver e;
  private int f;
  private TXCloudVideoView g;
  private TextureView h;
  private SurfaceView i;
  private Surface j;
  private int k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private a.c q;
  private boolean r;
  private V2TXLiveDef.V2TXLivePixelFormat s;
  private V2TXLiveDef.V2TXLiveBufferType t;
  private boolean u;
  private boolean v;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(211379);
    this.c = new Handler(Looper.getMainLooper());
    this.d = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
    this.a = paramContext.getApplicationContext();
    f.a(paramContext);
    AppMethodBeat.o(211379);
  }
  
  private void a()
  {
    AppMethodBeat.i(211385);
    this.v = false;
    this.u = false;
    c();
    if (this.b != null)
    {
      this.b.h();
      f.a(this.b);
      this.b = null;
      AppMethodBeat.o(211385);
      return;
    }
    stopCamera();
    stopMicrophone();
    stopScreenCapture();
    enableCustomVideoCapture(false);
    f.a(null, com.tencent.live2.impl.b.a(V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D), com.tencent.live2.impl.b.a(V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture));
    AppMethodBeat.o(211385);
  }
  
  private static void a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(211387);
    TXCLog.i("V2-TXTRTCPusherImpl", "enableAGC enable: " + paramBoolean + ", level: " + paramInt);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("api", "enableAudioAGC");
      JSONObject localJSONObject2 = new JSONObject();
      if (paramBoolean) {}
      for (int i1 = 1;; i1 = 0)
      {
        localJSONObject2.put("enable", i1);
        if (paramInt > 0) {
          localJSONObject2.put("level", paramInt);
        }
        localJSONObject1.put("params", localJSONObject2);
        f.b(localJSONObject1.toString());
        AppMethodBeat.o(211387);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(211387);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(211421);
    Object localObject1 = this.h;
    Object localObject2 = this.i;
    Surface localSurface = this.j;
    if (localObject1 != null)
    {
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      if (localObject2 != null)
      {
        b("bindRenderView surface texture is valid, set into player.");
        f.a(new Surface((SurfaceTexture)localObject2));
        f.a(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
      AppMethodBeat.o(211421);
      return;
    }
    if (localObject2 != null)
    {
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        b("bindRenderView surface is valid, set into player.");
        f.a((Surface)localObject1);
        f.a(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
        AppMethodBeat.o(211421);
      }
    }
    else if (localSurface != null)
    {
      f.a(localSurface);
      f.a(this.k, this.l);
    }
    AppMethodBeat.o(211421);
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(211401);
    TXCLog.i("V2-TXTRTCPusherImpl", "v2_api_trtc_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211401);
  }
  
  private static void b(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(211398);
    TXCLog.i("V2-TXTRTCPusherImpl", "enableANS enable: " + paramBoolean + ", level: " + paramInt);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("api", "enableAudioANS");
      JSONObject localJSONObject2 = new JSONObject();
      if (paramBoolean) {}
      for (int i1 = 1;; i1 = 0)
      {
        localJSONObject2.put("enable", i1);
        if (paramInt > 0) {
          localJSONObject2.put("level", paramInt);
        }
        localJSONObject1.put("params", localJSONObject2);
        f.b(localJSONObject1.toString());
        AppMethodBeat.o(211398);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(211398);
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(211431);
    Object localObject = this.h;
    if (localObject != null)
    {
      b("unbindRenderView unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      f.a(null);
      f.a(0, 0);
    }
    localObject = this.i;
    if (localObject != null)
    {
      b("unbindRenderView unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      f.a(null);
      f.a(0, 0);
    }
    if (this.j != null)
    {
      b("unbindRenderView: unbind surface.");
      f.a(null);
      f.a(0, 0);
    }
    AppMethodBeat.o(211431);
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(211408);
    TXCLog.e("V2-TXTRTCPusherImpl", "v2_api_trtc_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211408);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(211414);
    TXCLog.w("V2-TXTRTCPusherImpl", "v2_api_trtc_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211414);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(211661);
    c("onExitRoomByServer reason:" + paramInt + " stop push.");
    a();
    AppMethodBeat.o(211661);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(211668);
    c("onEnterRoomFail reason:".concat(String.valueOf(paramLong)));
    a();
    AppMethodBeat.o(211668);
  }
  
  public void a(String paramString) {}
  
  public int enableCustomVideoCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(211629);
    f.b(paramBoolean);
    AppMethodBeat.o(211629);
    return 0;
  }
  
  public int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    AppMethodBeat.i(211620);
    this.r = paramBoolean;
    this.s = paramV2TXLivePixelFormat;
    this.t = paramV2TXLiveBufferType;
    if (paramBoolean) {
      f.a(this, com.tencent.live2.impl.b.a(paramV2TXLivePixelFormat), com.tencent.live2.impl.b.a(paramV2TXLiveBufferType));
    }
    for (;;)
    {
      AppMethodBeat.o(211620);
      return 0;
      f.a(null, com.tencent.live2.impl.b.a(paramV2TXLivePixelFormat), com.tencent.live2.impl.b.a(paramV2TXLiveBufferType));
    }
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(211614);
    this.f = paramInt;
    if (this.b != null) {
      this.b.a(paramInt);
    }
    AppMethodBeat.o(211614);
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(211586);
    TXAudioEffectManager localTXAudioEffectManager = f.e();
    AppMethodBeat.o(211586);
    return localTXAudioEffectManager;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(211578);
    TXBeautyManager localTXBeautyManager = f.f();
    AppMethodBeat.o(211578);
    return localTXBeautyManager;
  }
  
  public TXDeviceManager getDeviceManager()
  {
    AppMethodBeat.i(211592);
    TXDeviceManager localTXDeviceManager = f.g();
    AppMethodBeat.o(211592);
    return localTXDeviceManager;
  }
  
  public int isPushing()
  {
    AppMethodBeat.i(211560);
    if (this.b != null) {}
    for (boolean bool = this.b.i();; bool = false)
    {
      if (bool)
      {
        AppMethodBeat.o(211560);
        return 1;
      }
      AppMethodBeat.o(211560);
      return 0;
    }
  }
  
  public void onGLContextCreated()
  {
    AppMethodBeat.i(211739);
    b("onGLContextCreated");
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextCreated();
    }
    AppMethodBeat.o(211739);
  }
  
  public void onGLContextDestory()
  {
    AppMethodBeat.i(211753);
    b("onGLContextDestory");
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextDestroyed();
    }
    AppMethodBeat.o(211753);
  }
  
  public int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2)
  {
    AppMethodBeat.i(211746);
    paramTRTCVideoFrame1 = com.tencent.live2.impl.b.a(paramTRTCVideoFrame1);
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = com.tencent.live2.impl.b.a(paramTRTCVideoFrame2);
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null)
    {
      localV2TXLivePusherObserver.onProcessVideoFrame(paramTRTCVideoFrame1, localV2TXLiveVideoFrame);
      com.tencent.live2.impl.b.a(localV2TXLiveVideoFrame, paramTRTCVideoFrame2);
    }
    AppMethodBeat.o(211746);
    return 0;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211677);
    b("onSurfaceTextureAvailable surface: " + paramSurfaceTexture + ", width: " + paramInt1 + ", height: " + paramInt2);
    if (paramSurfaceTexture != null) {
      f.a(new Surface(paramSurfaceTexture));
    }
    f.a(paramInt1, paramInt2);
    AppMethodBeat.o(211677);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(211696);
    b("onSurfaceTextureDestroyed surface: ".concat(String.valueOf(paramSurfaceTexture)));
    f.a(null);
    AppMethodBeat.o(211696);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211683);
    b("onSurfaceTextureSizeChanged surface: " + paramSurfaceTexture + ", width: " + paramInt1 + ", height: " + paramInt2);
    f.a(paramInt1, paramInt2);
    AppMethodBeat.o(211683);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(211635);
    f.a(paramV2TXLiveVideoFrame);
    AppMethodBeat.o(211635);
    return 0;
  }
  
  public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    AppMethodBeat.i(211566);
    V2TXLiveDef.V2TXLiveAudioQuality localV2TXLiveAudioQuality = paramV2TXLiveAudioQuality;
    if (paramV2TXLiveAudioQuality == null) {
      localV2TXLiveAudioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
    }
    if (this.u)
    {
      c("set audio quality fail. you should set audio quality before start microphone.");
      AppMethodBeat.o(211566);
      return -3;
    }
    this.d = localV2TXLiveAudioQuality;
    AppMethodBeat.o(211566);
    return 0;
  }
  
  public int setEncoderMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(211607);
    f.a(paramBoolean);
    AppMethodBeat.o(211607);
    return 0;
  }
  
  public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    AppMethodBeat.i(211455);
    this.b.a(paramV2TXLiveTranscodingConfig);
    AppMethodBeat.o(211455);
    return 0;
  }
  
  public void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    AppMethodBeat.i(211442);
    this.e = paramV2TXLivePusherObserver;
    if (this.b != null) {
      this.b.a(this.e);
    }
    AppMethodBeat.o(211442);
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(211452);
    int i1;
    switch (paramString.hashCode())
    {
    default: 
      i1 = -1;
      label102:
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(211452);
      return 0;
      if (!paramString.equals("enableAudioAGC")) {
        break;
      }
      i1 = 0;
      break label102;
      if (!paramString.equals("enableAudioANS")) {
        break;
      }
      i1 = 1;
      break label102;
      if (!paramString.equals("setSurface")) {
        break;
      }
      i1 = 2;
      break label102;
      if (!paramString.equals("setSurfaceSize")) {
        break;
      }
      i1 = 3;
      break label102;
      if (!paramString.equals("setCustomVideoEncParam")) {
        break;
      }
      i1 = 4;
      break label102;
      if (!paramString.equals("muteAudio")) {
        break;
      }
      i1 = 5;
      break label102;
      if (!paramString.equals("sendSEIMessage")) {
        break;
      }
      i1 = 6;
      break label102;
      if (!paramString.equals("pausePusher")) {
        break;
      }
      i1 = 7;
      break label102;
      if (!paramString.equals("setPauseParam")) {
        break;
      }
      i1 = 8;
      break label102;
      if ((paramObject instanceof Boolean))
      {
        a(((Boolean)paramObject).booleanValue(), -1);
        continue;
        if ((paramObject instanceof Boolean))
        {
          b(((Boolean)paramObject).booleanValue(), -1);
          continue;
          if (paramObject == null)
          {
            this.j = null;
            f.a(null);
          }
          else if ((paramObject instanceof Surface))
          {
            this.j = ((Surface)paramObject);
            f.a((Surface)paramObject);
            continue;
            if (paramObject == null)
            {
              this.k = 0;
              this.l = 0;
              f.a(0, 0);
            }
            else if ((paramObject instanceof a.a))
            {
              paramString = (a.a)paramObject;
              f.a(paramString.a, paramString.b);
              this.k = paramString.a;
              this.l = paramString.b;
              continue;
              if ((paramObject != null) && ((paramObject instanceof a.g)))
              {
                f.a((a.g)paramObject);
                continue;
                if ((paramObject != null) && ((paramObject instanceof Boolean)))
                {
                  this.n = ((Boolean)paramObject).booleanValue();
                  if (this.b != null)
                  {
                    paramString = this.b;
                    boolean bool1 = bool2;
                    if (!this.n) {
                      if (!this.o) {
                        break label530;
                      }
                    }
                    label530:
                    for (bool1 = bool2;; bool1 = false)
                    {
                      paramString.c(bool1);
                      break;
                    }
                    if ((paramObject != null) && ((paramObject instanceof byte[])) && (this.b != null))
                    {
                      this.b.a((byte[])paramObject);
                      continue;
                      if ((paramObject != null) && ((paramObject instanceof Boolean))) {
                        if (((Boolean)paramObject).booleanValue())
                        {
                          if (this.q != null)
                          {
                            this.p = this.q.c;
                            this.o = this.q.d;
                            label621:
                            if (this.b == null) {
                              continue;
                            }
                            this.b.d(this.p);
                            paramString = this.b;
                            bool1 = bool3;
                            if (!this.o) {
                              if (!this.n) {
                                break label688;
                              }
                            }
                          }
                          label688:
                          for (bool1 = bool3;; bool1 = false)
                          {
                            paramString.c(bool1);
                            break;
                            this.p = true;
                            this.o = true;
                            break label621;
                          }
                        }
                        else
                        {
                          this.p = false;
                          this.o = false;
                          if (this.b != null)
                          {
                            this.b.d(false);
                            this.b.c(this.n);
                            continue;
                            if (paramObject == null)
                            {
                              this.q = null;
                              f.a(null, 0);
                            }
                            else if ((paramObject instanceof a.c))
                            {
                              this.q = ((a.c)paramObject);
                              f.a(this.q.a, this.q.b);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    AppMethodBeat.i(211482);
    V2TXLiveDef.V2TXLiveMirrorType localV2TXLiveMirrorType = paramV2TXLiveMirrorType;
    if (paramV2TXLiveMirrorType == null) {
      localV2TXLiveMirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
    }
    f.a(localV2TXLiveMirrorType);
    AppMethodBeat.o(211482);
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211490);
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    f.a(localV2TXLiveRotation);
    AppMethodBeat.o(211490);
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(211477);
    c();
    this.i = paramSurfaceView;
    b();
    AppMethodBeat.o(211477);
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    AppMethodBeat.i(211472);
    c();
    this.h = paramTextureView;
    b();
    AppMethodBeat.o(211472);
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211469);
    c();
    if ((this.v) && (this.g != paramTXCloudVideoView))
    {
      f.b();
      f.a(getDeviceManager().isFrontCamera(), paramTXCloudVideoView);
    }
    this.g = paramTXCloudVideoView;
    AppMethodBeat.o(211469);
    return 0;
  }
  
  public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(211572);
    V2TXLiveDef.V2TXLiveVideoResolution localV2TXLiveVideoResolution = paramV2TXLiveVideoResolution;
    if (paramV2TXLiveVideoResolution == null) {
      localV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540;
    }
    paramV2TXLiveVideoResolution = paramV2TXLiveVideoResolutionMode;
    if (paramV2TXLiveVideoResolutionMode == null) {
      paramV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
    }
    f.a(new a.g(localV2TXLiveVideoResolution, paramV2TXLiveVideoResolution));
    AppMethodBeat.o(211572);
    return 0;
  }
  
  public int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(211603);
    f.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(211603);
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    AppMethodBeat.i(211645);
    this.m = paramBoolean;
    if (this.b != null) {
      this.b.e(this.m);
    }
    AppMethodBeat.o(211645);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(211599);
    if (this.b != null) {
      this.b.e(null, 0);
    }
    AppMethodBeat.o(211599);
    return 0;
  }
  
  public int startCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(211494);
    this.v = true;
    f.a(paramBoolean, this.g);
    b();
    AppMethodBeat.o(211494);
    return 0;
  }
  
  public int startMicrophone()
  {
    boolean bool2 = true;
    AppMethodBeat.i(211528);
    this.u = true;
    f.a(this.d);
    f localf;
    if (this.b != null)
    {
      b("audio state when start microphone.[muteAudio:" + this.n + "][pauseAudio:" + this.o + "]");
      localf = this.b;
      bool1 = bool2;
      if (!this.n) {
        if (!this.o) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localf.c(bool1);
      AppMethodBeat.o(211528);
      return 0;
    }
  }
  
  public int startPush(String paramString)
  {
    AppMethodBeat.i(211546);
    b("startPush url : ".concat(String.valueOf(paramString)));
    Object localObject = b.a(paramString);
    if (f.a(((b)localObject).f()))
    {
      c("start push fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.");
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211356);
          V2TXLivePusherObserver localV2TXLivePusherObserver = e.a(e.this);
          if (localV2TXLivePusherObserver != null) {
            localV2TXLivePusherObserver.onError(-3, "start push fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.", new Bundle());
          }
          AppMethodBeat.o(211356);
        }
      });
      AppMethodBeat.o(211546);
      return -3;
    }
    if (this.b != null)
    {
      d("find old instance when start push.");
      this.b.h();
      f.a(this.b);
      this.b = null;
    }
    this.b = f.a(this.a, ((b)localObject).f(), ((b)localObject).j(), this);
    this.b.a(this.e);
    if (this.f > 0) {
      this.b.a(this.f);
    }
    b("audio state when start push.[muteAudio:" + this.n + "][pauseAudio:" + this.o + "]");
    localObject = this.b;
    if ((this.n) || (this.o)) {}
    for (boolean bool = true;; bool = false)
    {
      ((f)localObject).c(bool);
      this.b.d(this.p);
      showDebugView(this.m);
      if (this.r) {
        f.a(this, com.tencent.live2.impl.b.a(this.s), com.tencent.live2.impl.b.a(this.t));
      }
      final int i1 = this.b.c(paramString);
      if (i1 != 0) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211359);
            V2TXLivePusherObserver localV2TXLivePusherObserver = e.a(e.this);
            if (localV2TXLivePusherObserver != null) {
              localV2TXLivePusherObserver.onError(i1, "start push fail. [errorCode:" + i1 + "]", new Bundle());
            }
            AppMethodBeat.o(211359);
          }
        });
      }
      AppMethodBeat.o(211546);
      return i1;
    }
  }
  
  public int startScreenCapture()
  {
    AppMethodBeat.i(211508);
    f.a(null, new TRTCCloudDef.TRTCScreenShareParams());
    AppMethodBeat.o(211508);
    return 0;
  }
  
  public int stopCamera()
  {
    AppMethodBeat.i(211500);
    this.v = false;
    f.b();
    c();
    AppMethodBeat.o(211500);
    return 0;
  }
  
  public int stopMicrophone()
  {
    AppMethodBeat.i(211535);
    this.u = false;
    f.c();
    if (this.b != null) {
      this.b.c(true);
    }
    AppMethodBeat.o(211535);
    return 0;
  }
  
  public int stopPush()
  {
    AppMethodBeat.i(211554);
    a();
    AppMethodBeat.o(211554);
    return 0;
  }
  
  public int stopScreenCapture()
  {
    AppMethodBeat.i(211517);
    f.d();
    AppMethodBeat.o(211517);
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211721);
    b("surfaceChanged holder: " + paramSurfaceHolder + ", format: " + paramInt1 + ", width: " + paramInt2 + ", height: " + paramInt3);
    f.a(paramInt2, paramInt3);
    AppMethodBeat.o(211721);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211713);
    if (paramSurfaceHolder != null)
    {
      b("surfaceCreated holder: " + paramSurfaceHolder + ", surface: " + paramSurfaceHolder.getSurface());
      f.a(paramSurfaceHolder.getSurface());
    }
    AppMethodBeat.o(211713);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211734);
    b("surfaceDestroyed holder: ".concat(String.valueOf(paramSurfaceHolder)));
    f.a(null);
    AppMethodBeat.o(211734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.e
 * JD-Core Version:    0.7.0.1
 */