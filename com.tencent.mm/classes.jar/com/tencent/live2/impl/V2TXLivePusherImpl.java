package com.tencent.live2.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class V2TXLivePusherImpl
  extends V2TXLivePusher
{
  private static final String TAG = "V2-TXLivePusherImpl";
  private a.b mAsyncState;
  private Context mContext;
  private V2TXLivePusher mInnerPusher;
  private f mMainHandler;
  private String mURL;
  private V2TXLiveDef.V2TXLiveMode mURLMode;
  
  static
  {
    AppMethodBeat.i(211702);
    h.d();
    AppMethodBeat.o(211702);
  }
  
  public V2TXLivePusherImpl(Context paramContext, V2TXLiveDef.V2TXLiveMode paramV2TXLiveMode)
  {
    AppMethodBeat.i(211633);
    this.mMainHandler = new f(Looper.getMainLooper());
    this.mAsyncState = a.b.a;
    this.mContext = paramContext.getApplicationContext();
    this.mURLMode = paramV2TXLiveMode;
    if (paramV2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      this.mInnerPusher = new e(this.mContext);
      AppMethodBeat.o(211633);
      return;
    }
    this.mInnerPusher = new com.tencent.live2.a.b(this.mContext);
    AppMethodBeat.o(211633);
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211650);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "v2_api_pusher(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(211650);
      return;
    }
    TXCLog.e("V2-TXLivePusherImpl", "v2_api_pusher(" + hashCode() + ") " + str);
    AppMethodBeat.o(211650);
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211644);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "v2_api_pusher(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(211644);
      return;
    }
    TXCLog.i("V2-TXLivePusherImpl", "v2_api_pusher(" + hashCode() + ") " + str);
    AppMethodBeat.o(211644);
  }
  
  private void runOnMainThreadAsync(Runnable paramRunnable)
  {
    AppMethodBeat.i(211660);
    this.mMainHandler.post(paramRunnable);
    AppMethodBeat.o(211660);
  }
  
  public int enableCustomVideoCapture(final boolean paramBoolean)
  {
    AppMethodBeat.i(211879);
    apiOnlineLog("enableCustomVideoCapture:".concat(String.valueOf(paramBoolean)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211723);
        V2TXLivePusherImpl.this.mInnerPusher.enableCustomVideoCapture(paramBoolean);
        AppMethodBeat.o(211723);
      }
    });
    AppMethodBeat.o(211879);
    return 0;
  }
  
  public int enableCustomVideoProcess(final boolean paramBoolean, final V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, final V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(211876);
    apiOnlineLog("enableCustomVideoProcess：" + paramBoolean + " format:" + paramV2TXLivePixelFormat + "type:" + paramV2TXLiveBufferType, false);
    if (paramBoolean)
    {
      if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
      {
        if (paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D)
        {
          i = j;
          if (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {}
        }
        else if (paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420)
        {
          i = j;
          if (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {}
        }
        else
        {
          if ((paramV2TXLivePixelFormat != V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) || (paramV2TXLiveBufferType != V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray)) {
            break label139;
          }
        }
        label139:
        for (i = j; i == 0; i = 0)
        {
          apiOnlineError("enable custom video process fail. nonsupport format or type.", false);
          AppMethodBeat.o(211876);
          return -4;
        }
      }
      if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
      {
        if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture)) {}
        while (i == 0)
        {
          apiOnlineError("enable custom video process fail. nonsupport format or type.", false);
          AppMethodBeat.o(211876);
          return -4;
          i = 0;
        }
      }
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211701);
        V2TXLivePusherImpl.this.mInnerPusher.enableCustomVideoProcess(paramBoolean, paramV2TXLivePixelFormat, paramV2TXLiveBufferType);
        AppMethodBeat.o(211701);
      }
    });
    AppMethodBeat.o(211876);
    return 0;
  }
  
  public int enableVolumeEvaluation(final int paramInt)
  {
    AppMethodBeat.i(211868);
    apiOnlineLog("enableVolumeEvaluation:".concat(String.valueOf(paramInt)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211688);
        V2TXLivePusherImpl.this.mInnerPusher.enableVolumeEvaluation(paramInt);
        AppMethodBeat.o(211688);
      }
    });
    AppMethodBeat.o(211868);
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(211850);
    TXAudioEffectManager localTXAudioEffectManager = this.mInnerPusher.getAudioEffectManager();
    AppMethodBeat.o(211850);
    return localTXAudioEffectManager;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(211831);
    TXBeautyManager localTXBeautyManager = this.mInnerPusher.getBeautyManager();
    AppMethodBeat.o(211831);
    return localTXBeautyManager;
  }
  
  public TXDeviceManager getDeviceManager()
  {
    AppMethodBeat.i(211838);
    TXDeviceManager localTXDeviceManager = this.mInnerPusher.getDeviceManager();
    AppMethodBeat.o(211838);
    return localTXDeviceManager;
  }
  
  public int isPushing()
  {
    AppMethodBeat.i(211814);
    if (this.mAsyncState == a.b.a)
    {
      if (this.mInnerPusher != null)
      {
        int i = this.mInnerPusher.isPushing();
        AppMethodBeat.o(211814);
        return i;
      }
      AppMethodBeat.o(211814);
      return 0;
    }
    if (this.mAsyncState == a.b.b)
    {
      AppMethodBeat.o(211814);
      return 1;
    }
    if (this.mAsyncState == a.b.c)
    {
      AppMethodBeat.o(211814);
      return 0;
    }
    AppMethodBeat.o(211814);
    return 0;
  }
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(211883);
    if (paramV2TXLiveVideoFrame == null)
    {
      apiOnlineError("sendCustomVideoFrame frame is null.", false);
      AppMethodBeat.o(211883);
      return -2;
    }
    int i = this.mInnerPusher.sendCustomVideoFrame(paramV2TXLiveVideoFrame);
    AppMethodBeat.o(211883);
    return i;
  }
  
  public int setAudioQuality(final V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    AppMethodBeat.i(211818);
    apiOnlineLog("setAudioQuality: quality-".concat(String.valueOf(paramV2TXLiveAudioQuality)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211640);
        V2TXLivePusherImpl.this.mInnerPusher.setAudioQuality(paramV2TXLiveAudioQuality);
        AppMethodBeat.o(211640);
      }
    });
    AppMethodBeat.o(211818);
    return 0;
  }
  
  public int setEncoderMirror(final boolean paramBoolean)
  {
    AppMethodBeat.i(211863);
    apiOnlineLog("setEncoderMirror:".concat(String.valueOf(paramBoolean)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211692);
        V2TXLivePusherImpl.this.mInnerPusher.setEncoderMirror(paramBoolean);
        AppMethodBeat.o(211692);
      }
    });
    AppMethodBeat.o(211863);
    return 0;
  }
  
  public int setMixTranscodingConfig(final V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    AppMethodBeat.i(211729);
    apiOnlineLog("setMixTranscodingConfig: config-".concat(String.valueOf(paramV2TXLiveTranscodingConfig)), false);
    if (isPushing() != 1)
    {
      apiOnlineError("set mix transcoding config failed. pusher can't set mix transcoding config before calling startPush.", false);
      AppMethodBeat.o(211729);
      return -3;
    }
    if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      apiOnlineError("set mix transcoding config failed. pusher isn't support set mix transcoding when RTMP mode.", false);
      AppMethodBeat.o(211729);
      return -4;
    }
    if (paramV2TXLiveTranscodingConfig == null) {}
    for (paramV2TXLiveTranscodingConfig = null;; paramV2TXLiveTranscodingConfig = new V2TXLiveDef.V2TXLiveTranscodingConfig(paramV2TXLiveTranscodingConfig))
    {
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211571);
          V2TXLivePusherImpl.this.mInnerPusher.setMixTranscodingConfig(paramV2TXLiveTranscodingConfig);
          AppMethodBeat.o(211571);
        }
      });
      AppMethodBeat.o(211729);
      return 0;
    }
  }
  
  public void setObserver(final V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    AppMethodBeat.i(211709);
    apiOnlineLog("setObserver: ".concat(String.valueOf(paramV2TXLivePusherObserver)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211577);
        V2TXLivePusherImpl.this.mInnerPusher.setObserver(paramV2TXLivePusherObserver);
        AppMethodBeat.o(211577);
      }
    });
    AppMethodBeat.o(211709);
  }
  
  public int setProperty(final String paramString, final Object paramObject)
  {
    AppMethodBeat.i(211717);
    if (paramString != "sendSEIMessage") {
      apiOnlineLog("setProperty: key-" + paramString + " value-" + paramObject, false);
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211596);
        V2TXLivePusherImpl.this.mInnerPusher.setProperty(paramString, paramObject);
        AppMethodBeat.o(211596);
      }
    });
    AppMethodBeat.o(211717);
    return 0;
  }
  
  public int setRenderMirror(final V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    AppMethodBeat.i(211757);
    apiOnlineLog("setRenderMirror: type-".concat(String.valueOf(paramV2TXLiveMirrorType)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211580);
        V2TXLivePusherImpl.this.mInnerPusher.setRenderMirror(paramV2TXLiveMirrorType);
        AppMethodBeat.o(211580);
      }
    });
    AppMethodBeat.o(211757);
    return 0;
  }
  
  public int setRenderRotation(final V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211763);
    apiOnlineLog("setRenderRotation: rotation-".concat(String.valueOf(paramV2TXLiveRotation)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211579);
        V2TXLivePusherImpl.this.mInnerPusher.setRenderRotation(paramV2TXLiveRotation);
        AppMethodBeat.o(211579);
      }
    });
    AppMethodBeat.o(211763);
    return 0;
  }
  
  public int setRenderView(final SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(211750);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramSurfaceView != null) {}
    for (String str = String.valueOf(paramSurfaceView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211589);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramSurfaceView);
          AppMethodBeat.o(211589);
        }
      });
      AppMethodBeat.o(211750);
      return 0;
    }
  }
  
  public int setRenderView(final TextureView paramTextureView)
  {
    AppMethodBeat.i(211744);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramTextureView != null) {}
    for (String str = String.valueOf(paramTextureView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211590);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramTextureView);
          AppMethodBeat.o(211590);
        }
      });
      AppMethodBeat.o(211744);
      return 0;
    }
  }
  
  public int setRenderView(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211736);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramTXCloudVideoView != null) {}
    for (String str = String.valueOf(paramTXCloudVideoView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211584);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramTXCloudVideoView);
          AppMethodBeat.o(211584);
        }
      });
      AppMethodBeat.o(211736);
      return 0;
    }
  }
  
  public int setVideoQuality(final V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, final V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(211825);
    apiOnlineLog("setVideoQuality: resolution-" + paramV2TXLiveVideoResolution + " mode-" + paramV2TXLiveVideoResolutionMode, false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211654);
        V2TXLivePusherImpl.this.mInnerPusher.setVideoQuality(paramV2TXLiveVideoResolution, paramV2TXLiveVideoResolutionMode);
        AppMethodBeat.o(211654);
      }
    });
    AppMethodBeat.o(211825);
    return 0;
  }
  
  public int setWatermark(final Bitmap paramBitmap, final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(211857);
    apiOnlineLog("setWatermark:" + paramBitmap + " x-" + paramFloat1 + " y-" + paramFloat2 + "scale-" + paramFloat3, false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211676);
        V2TXLivePusherImpl.this.mInnerPusher.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        AppMethodBeat.o(211676);
      }
    });
    AppMethodBeat.o(211857);
    return 0;
  }
  
  public void showDebugView(final boolean paramBoolean)
  {
    AppMethodBeat.i(211886);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211655);
        V2TXLivePusherImpl.this.mInnerPusher.showDebugView(paramBoolean);
        AppMethodBeat.o(211655);
      }
    });
    AppMethodBeat.o(211886);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(211844);
    if (isPushing() == 0)
    {
      apiOnlineError("snapshot: snapshot is not allowed before the pusher starts pushing.", false);
      AppMethodBeat.o(211844);
      return -3;
    }
    apiOnlineLog("snapshot", false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211659);
        V2TXLivePusherImpl.this.mInnerPusher.snapshot();
        AppMethodBeat.o(211659);
      }
    });
    AppMethodBeat.o(211844);
    return 0;
  }
  
  public int startCamera(final boolean paramBoolean)
  {
    AppMethodBeat.i(211767);
    apiOnlineLog("startCamera: frontCamera-".concat(String.valueOf(paramBoolean)), true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211593);
        V2TXLivePusherImpl.this.mInnerPusher.startCamera(paramBoolean);
        AppMethodBeat.o(211593);
      }
    });
    AppMethodBeat.o(211767);
    return 0;
  }
  
  public int startMicrophone()
  {
    AppMethodBeat.i(211788);
    apiOnlineLog("startMicrophone", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211600);
        V2TXLivePusherImpl.this.mInnerPusher.startMicrophone();
        AppMethodBeat.o(211600);
      }
    });
    AppMethodBeat.o(211788);
    return 0;
  }
  
  public int startPush(final String paramString)
  {
    AppMethodBeat.i(211804);
    apiOnlineLog("startPush: url:" + b.b(paramString), true);
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("startPush fail, url invalid:".concat(String.valueOf(paramString)), false);
      AppMethodBeat.o(211804);
      return -2;
    }
    Object localObject = b.a(paramString);
    if (localObject != this.mURLMode)
    {
      apiOnlineError("start push fail. invalid mode.", false);
      AppMethodBeat.o(211804);
      return -2;
    }
    if (localObject == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      localObject = com.tencent.live2.b.b.a(paramString);
      if ((localObject == null) || (!((com.tencent.live2.b.b)localObject).a()))
      {
        apiOnlineError("start push fail. invalid param. [url:" + paramString + "][param:" + localObject + "]", false);
        AppMethodBeat.o(211804);
        return -2;
      }
    }
    this.mAsyncState = a.b.b;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211612);
        if ((paramString.equals(V2TXLivePusherImpl.this.mURL)) && (V2TXLivePusherImpl.this.mInnerPusher.isPushing() == 1))
        {
          V2TXLivePusherImpl.access$200(V2TXLivePusherImpl.this, "startPush fail, same url, current is pushing", false);
          V2TXLivePusherImpl.access$302(V2TXLivePusherImpl.this, a.b.a);
          AppMethodBeat.o(211612);
          return;
        }
        if (V2TXLivePusherImpl.this.mInnerPusher.isPushing() == 1)
        {
          V2TXLivePusherImpl.access$400(V2TXLivePusherImpl.this, "startPusher，now is pushing so stop current push", false);
          V2TXLivePusherImpl.this.mInnerPusher.stopPush();
        }
        V2TXLivePusherImpl.this.mInnerPusher.startPush(paramString);
        V2TXLivePusherImpl.access$102(V2TXLivePusherImpl.this, paramString);
        V2TXLivePusherImpl.access$302(V2TXLivePusherImpl.this, a.b.a);
        AppMethodBeat.o(211612);
      }
    });
    AppMethodBeat.o(211804);
    return 0;
  }
  
  public int startScreenCapture()
  {
    AppMethodBeat.i(211775);
    apiOnlineLog("startScreenCapture:", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211623);
        V2TXLivePusherImpl.this.mInnerPusher.startScreenCapture();
        AppMethodBeat.o(211623);
      }
    });
    AppMethodBeat.o(211775);
    return 0;
  }
  
  public int stopCamera()
  {
    AppMethodBeat.i(211769);
    apiOnlineLog("stopCamera", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211608);
        V2TXLivePusherImpl.this.mInnerPusher.stopCamera();
        AppMethodBeat.o(211608);
      }
    });
    AppMethodBeat.o(211769);
    return 0;
  }
  
  public int stopMicrophone()
  {
    AppMethodBeat.i(211795);
    apiOnlineLog("stopMicrophone", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211609);
        V2TXLivePusherImpl.this.mInnerPusher.stopMicrophone();
        AppMethodBeat.o(211609);
      }
    });
    AppMethodBeat.o(211795);
    return 0;
  }
  
  public int stopPush()
  {
    AppMethodBeat.i(211809);
    apiOnlineLog("stopPush", true);
    this.mAsyncState = a.b.c;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211651);
        V2TXLivePusherImpl.access$102(V2TXLivePusherImpl.this, null);
        V2TXLivePusherImpl.access$302(V2TXLivePusherImpl.this, a.b.a);
        V2TXLivePusherImpl.this.mInnerPusher.stopPush();
        AppMethodBeat.o(211651);
      }
    });
    AppMethodBeat.o(211809);
    return 0;
  }
  
  public int stopScreenCapture()
  {
    AppMethodBeat.i(211781);
    apiOnlineLog("stopScreenCapture: ", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211601);
        V2TXLivePusherImpl.this.mInnerPusher.stopScreenCapture();
        AppMethodBeat.o(211601);
      }
    });
    AppMethodBeat.o(211781);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl
 * JD-Core Version:    0.7.0.1
 */