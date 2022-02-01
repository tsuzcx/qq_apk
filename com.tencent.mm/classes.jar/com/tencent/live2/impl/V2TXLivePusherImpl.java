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
    AppMethodBeat.i(214916);
    h.f();
    AppMethodBeat.o(214916);
  }
  
  public V2TXLivePusherImpl(Context paramContext, V2TXLiveDef.V2TXLiveMode paramV2TXLiveMode)
  {
    AppMethodBeat.i(214836);
    this.mMainHandler = new f(Looper.getMainLooper());
    this.mAsyncState = a.b.a;
    this.mContext = paramContext.getApplicationContext();
    this.mURLMode = paramV2TXLiveMode;
    if (paramV2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      this.mInnerPusher = new e(this.mContext);
      AppMethodBeat.o(214836);
      return;
    }
    this.mInnerPusher = new com.tencent.live2.a.b(this.mContext);
    AppMethodBeat.o(214836);
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(214908);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "v2_api_pusher(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(214908);
      return;
    }
    TXCLog.e("V2-TXLivePusherImpl", "v2_api_pusher(" + hashCode() + ") " + str);
    AppMethodBeat.o(214908);
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(214907);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "v2_api_pusher(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(214907);
      return;
    }
    TXCLog.i("V2-TXLivePusherImpl", "v2_api_pusher(" + hashCode() + ") " + str);
    AppMethodBeat.o(214907);
  }
  
  private void runOnMainThreadAsync(Runnable paramRunnable)
  {
    AppMethodBeat.i(214909);
    this.mMainHandler.post(paramRunnable);
    AppMethodBeat.o(214909);
  }
  
  public int enableCustomVideoCapture(final boolean paramBoolean)
  {
    AppMethodBeat.i(214903);
    apiOnlineLog("enableCustomVideoCapture:".concat(String.valueOf(paramBoolean)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214764);
        V2TXLivePusherImpl.this.mInnerPusher.enableCustomVideoCapture(paramBoolean);
        AppMethodBeat.o(214764);
      }
    });
    AppMethodBeat.o(214903);
    return 0;
  }
  
  public int enableCustomVideoProcess(final boolean paramBoolean, final V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, final V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(214902);
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
          AppMethodBeat.o(214902);
          return -4;
        }
      }
      if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
      {
        if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture)) {}
        while (i == 0)
        {
          apiOnlineError("enable custom video process fail. nonsupport format or type.", false);
          AppMethodBeat.o(214902);
          return -4;
          i = 0;
        }
      }
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214796);
        V2TXLivePusherImpl.this.mInnerPusher.enableCustomVideoProcess(paramBoolean, paramV2TXLivePixelFormat, paramV2TXLiveBufferType);
        AppMethodBeat.o(214796);
      }
    });
    AppMethodBeat.o(214902);
    return 0;
  }
  
  public int enableVolumeEvaluation(final int paramInt)
  {
    AppMethodBeat.i(214897);
    apiOnlineLog("enableVolumeEvaluation:".concat(String.valueOf(paramInt)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214972);
        V2TXLivePusherImpl.this.mInnerPusher.enableVolumeEvaluation(paramInt);
        AppMethodBeat.o(214972);
      }
    });
    AppMethodBeat.o(214897);
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(214889);
    TXAudioEffectManager localTXAudioEffectManager = this.mInnerPusher.getAudioEffectManager();
    AppMethodBeat.o(214889);
    return localTXAudioEffectManager;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(214886);
    TXBeautyManager localTXBeautyManager = this.mInnerPusher.getBeautyManager();
    AppMethodBeat.o(214886);
    return localTXBeautyManager;
  }
  
  public TXDeviceManager getDeviceManager()
  {
    AppMethodBeat.i(214887);
    TXDeviceManager localTXDeviceManager = this.mInnerPusher.getDeviceManager();
    AppMethodBeat.o(214887);
    return localTXDeviceManager;
  }
  
  public int isPushing()
  {
    AppMethodBeat.i(214878);
    if (this.mAsyncState == a.b.a)
    {
      if (this.mInnerPusher != null)
      {
        int i = this.mInnerPusher.isPushing();
        AppMethodBeat.o(214878);
        return i;
      }
      AppMethodBeat.o(214878);
      return 0;
    }
    if (this.mAsyncState == a.b.b)
    {
      AppMethodBeat.o(214878);
      return 1;
    }
    if (this.mAsyncState == a.b.c)
    {
      AppMethodBeat.o(214878);
      return 0;
    }
    AppMethodBeat.o(214878);
    return 0;
  }
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(214904);
    if (paramV2TXLiveVideoFrame == null)
    {
      apiOnlineError("sendCustomVideoFrame frame is null.", false);
      AppMethodBeat.o(214904);
      return -2;
    }
    int i = this.mInnerPusher.sendCustomVideoFrame(paramV2TXLiveVideoFrame);
    AppMethodBeat.o(214904);
    return i;
  }
  
  public int setAudioQuality(final V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    AppMethodBeat.i(214881);
    apiOnlineLog("setAudioQuality: quality-".concat(String.valueOf(paramV2TXLiveAudioQuality)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215134);
        V2TXLivePusherImpl.this.mInnerPusher.setAudioQuality(paramV2TXLiveAudioQuality);
        AppMethodBeat.o(215134);
      }
    });
    AppMethodBeat.o(214881);
    return 0;
  }
  
  public int setEncoderMirror(final boolean paramBoolean)
  {
    AppMethodBeat.i(214893);
    apiOnlineLog("setEncoderMirror:".concat(String.valueOf(paramBoolean)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214973);
        V2TXLivePusherImpl.this.mInnerPusher.setEncoderMirror(paramBoolean);
        AppMethodBeat.o(214973);
      }
    });
    AppMethodBeat.o(214893);
    return 0;
  }
  
  public int setMixTranscodingConfig(final V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    AppMethodBeat.i(214843);
    apiOnlineLog("setMixTranscodingConfig: config-".concat(String.valueOf(paramV2TXLiveTranscodingConfig)), false);
    if (isPushing() != 1)
    {
      apiOnlineError("set mix transcoding config failed. pusher can't set mix transcoding config before calling startPush.", false);
      AppMethodBeat.o(214843);
      return -3;
    }
    if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      apiOnlineError("set mix transcoding config failed. pusher isn't support set mix transcoding when RTMP mode.", false);
      AppMethodBeat.o(214843);
      return -4;
    }
    if (paramV2TXLiveTranscodingConfig == null) {}
    for (paramV2TXLiveTranscodingConfig = null;; paramV2TXLiveTranscodingConfig = new V2TXLiveDef.V2TXLiveTranscodingConfig(paramV2TXLiveTranscodingConfig))
    {
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(214741);
          V2TXLivePusherImpl.this.mInnerPusher.setMixTranscodingConfig(paramV2TXLiveTranscodingConfig);
          AppMethodBeat.o(214741);
        }
      });
      AppMethodBeat.o(214843);
      return 0;
    }
  }
  
  public void setObserver(final V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    AppMethodBeat.i(214838);
    apiOnlineLog("setObserver: ".concat(String.valueOf(paramV2TXLivePusherObserver)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214987);
        V2TXLivePusherImpl.this.mInnerPusher.setObserver(paramV2TXLivePusherObserver);
        AppMethodBeat.o(214987);
      }
    });
    AppMethodBeat.o(214838);
  }
  
  public int setProperty(final String paramString, final Object paramObject)
  {
    AppMethodBeat.i(214840);
    if (paramString != "sendSEIMessage") {
      apiOnlineLog("setProperty: key-" + paramString + " value-" + paramObject, false);
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214744);
        V2TXLivePusherImpl.this.mInnerPusher.setProperty(paramString, paramObject);
        AppMethodBeat.o(214744);
      }
    });
    AppMethodBeat.o(214840);
    return 0;
  }
  
  public int setRenderMirror(final V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    AppMethodBeat.i(214854);
    apiOnlineLog("setRenderMirror: type-".concat(String.valueOf(paramV2TXLiveMirrorType)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214675);
        V2TXLivePusherImpl.this.mInnerPusher.setRenderMirror(paramV2TXLiveMirrorType);
        AppMethodBeat.o(214675);
      }
    });
    AppMethodBeat.o(214854);
    return 0;
  }
  
  public int setRenderRotation(final V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(214856);
    apiOnlineLog("setRenderRotation: rotation-".concat(String.valueOf(paramV2TXLiveRotation)), false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215163);
        V2TXLivePusherImpl.this.mInnerPusher.setRenderRotation(paramV2TXLiveRotation);
        AppMethodBeat.o(215163);
      }
    });
    AppMethodBeat.o(214856);
    return 0;
  }
  
  public int setRenderView(final SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(214850);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramSurfaceView != null) {}
    for (String str = String.valueOf(paramSurfaceView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(214961);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramSurfaceView);
          AppMethodBeat.o(214961);
        }
      });
      AppMethodBeat.o(214850);
      return 0;
    }
  }
  
  public int setRenderView(final TextureView paramTextureView)
  {
    AppMethodBeat.i(214847);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramTextureView != null) {}
    for (String str = String.valueOf(paramTextureView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(214941);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramTextureView);
          AppMethodBeat.o(214941);
        }
      });
      AppMethodBeat.o(214847);
      return 0;
    }
  }
  
  public int setRenderView(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(214844);
    StringBuilder localStringBuilder = new StringBuilder("setRenderView: view-");
    if (paramTXCloudVideoView != null) {}
    for (String str = String.valueOf(paramTXCloudVideoView.hashCode());; str = "null")
    {
      apiOnlineLog(str, false);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(215200);
          V2TXLivePusherImpl.this.mInnerPusher.setRenderView(paramTXCloudVideoView);
          AppMethodBeat.o(215200);
        }
      });
      AppMethodBeat.o(214844);
      return 0;
    }
  }
  
  public int setVideoQuality(final V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, final V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(214883);
    apiOnlineLog("setVideoQuality: resolution-" + paramV2TXLiveVideoResolution + " mode-" + paramV2TXLiveVideoResolutionMode, false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214694);
        V2TXLivePusherImpl.this.mInnerPusher.setVideoQuality(paramV2TXLiveVideoResolution, paramV2TXLiveVideoResolutionMode);
        AppMethodBeat.o(214694);
      }
    });
    AppMethodBeat.o(214883);
    return 0;
  }
  
  public int setWatermark(final Bitmap paramBitmap, final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(214891);
    apiOnlineLog("setWatermark:" + paramBitmap + " x-" + paramFloat1 + " y-" + paramFloat2 + "scale-" + paramFloat3, false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215283);
        V2TXLivePusherImpl.this.mInnerPusher.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        AppMethodBeat.o(215283);
      }
    });
    AppMethodBeat.o(214891);
    return 0;
  }
  
  public void showDebugView(final boolean paramBoolean)
  {
    AppMethodBeat.i(214905);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214789);
        V2TXLivePusherImpl.this.mInnerPusher.showDebugView(paramBoolean);
        AppMethodBeat.o(214789);
      }
    });
    AppMethodBeat.o(214905);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(214888);
    if (isPushing() == 0)
    {
      apiOnlineError("snapshot: snapshot is not allowed before the pusher starts pushing.", false);
      AppMethodBeat.o(214888);
      return -3;
    }
    apiOnlineLog("snapshot", false);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215112);
        V2TXLivePusherImpl.this.mInnerPusher.snapshot();
        AppMethodBeat.o(215112);
      }
    });
    AppMethodBeat.o(214888);
    return 0;
  }
  
  public int startCamera(final boolean paramBoolean)
  {
    AppMethodBeat.i(214858);
    apiOnlineLog("startCamera: frontCamera-".concat(String.valueOf(paramBoolean)), true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214804);
        V2TXLivePusherImpl.this.mInnerPusher.startCamera(paramBoolean);
        AppMethodBeat.o(214804);
      }
    });
    AppMethodBeat.o(214858);
    return 0;
  }
  
  public int startMicrophone()
  {
    AppMethodBeat.i(214870);
    apiOnlineLog("startMicrophone", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214954);
        V2TXLivePusherImpl.this.mInnerPusher.startMicrophone();
        AppMethodBeat.o(214954);
      }
    });
    AppMethodBeat.o(214870);
    return 0;
  }
  
  public int startPush(final String paramString)
  {
    AppMethodBeat.i(214874);
    apiOnlineLog("startPush: url:" + b.b(paramString), true);
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("startPush fail, url invalid:".concat(String.valueOf(paramString)), false);
      AppMethodBeat.o(214874);
      return -2;
    }
    Object localObject = b.a(paramString);
    if (localObject != this.mURLMode)
    {
      apiOnlineError("start push fail. invalid mode.", false);
      AppMethodBeat.o(214874);
      return -2;
    }
    if (localObject == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      localObject = com.tencent.live2.b.b.a(paramString);
      if ((localObject == null) || (!((com.tencent.live2.b.b)localObject).a()))
      {
        apiOnlineError("start push fail. invalid param. [url:" + paramString + "][param:" + localObject + "]", false);
        AppMethodBeat.o(214874);
        return -2;
      }
    }
    this.mAsyncState = a.b.b;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214967);
        if ((paramString.equals(V2TXLivePusherImpl.this.mURL)) && (V2TXLivePusherImpl.this.mInnerPusher.isPushing() == 1))
        {
          V2TXLivePusherImpl.access$200(V2TXLivePusherImpl.this, "startPush fail, same url, current is pushing", false);
          V2TXLivePusherImpl.access$302(V2TXLivePusherImpl.this, a.b.a);
          AppMethodBeat.o(214967);
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
        AppMethodBeat.o(214967);
      }
    });
    AppMethodBeat.o(214874);
    return 0;
  }
  
  public int startScreenCapture()
  {
    AppMethodBeat.i(214865);
    apiOnlineLog("startScreenCapture:", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215252);
        V2TXLivePusherImpl.this.mInnerPusher.startScreenCapture();
        AppMethodBeat.o(215252);
      }
    });
    AppMethodBeat.o(214865);
    return 0;
  }
  
  public int stopCamera()
  {
    AppMethodBeat.i(214861);
    apiOnlineLog("stopCamera", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214929);
        V2TXLivePusherImpl.this.mInnerPusher.stopCamera();
        AppMethodBeat.o(214929);
      }
    });
    AppMethodBeat.o(214861);
    return 0;
  }
  
  public int stopMicrophone()
  {
    AppMethodBeat.i(214871);
    apiOnlineLog("stopMicrophone", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214983);
        V2TXLivePusherImpl.this.mInnerPusher.stopMicrophone();
        AppMethodBeat.o(214983);
      }
    });
    AppMethodBeat.o(214871);
    return 0;
  }
  
  public int stopPush()
  {
    AppMethodBeat.i(214876);
    apiOnlineLog("stopPush", true);
    this.mAsyncState = a.b.c;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214779);
        V2TXLivePusherImpl.access$102(V2TXLivePusherImpl.this, null);
        V2TXLivePusherImpl.access$302(V2TXLivePusherImpl.this, a.b.a);
        V2TXLivePusherImpl.this.mInnerPusher.stopPush();
        AppMethodBeat.o(214779);
      }
    });
    AppMethodBeat.o(214876);
    return 0;
  }
  
  public int stopScreenCapture()
  {
    AppMethodBeat.i(214867);
    apiOnlineLog("stopScreenCapture: ", true);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214802);
        V2TXLivePusherImpl.this.mInnerPusher.stopScreenCapture();
        AppMethodBeat.o(214802);
      }
    });
    AppMethodBeat.o(214867);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl
 * JD-Core Version:    0.7.0.1
 */