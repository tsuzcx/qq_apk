package com.tencent.live2.impl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class V2TXLivePlayerImpl
  extends V2TXLivePlayer
{
  private static final String TAG = "V2-TXLivePlayerImpl";
  private a.b mAsyncState;
  private V2TXLiveDef.V2TXLiveBufferType mBufferType;
  private float mCacheMaxTime;
  private float mCacheMinTime;
  private Context mContext;
  private boolean mEnableCustomRendering;
  private boolean mEnableDebugView;
  private V2TXLivePlayer mInnerPlayer;
  private boolean mIsPauseAudio;
  private boolean mIsPauseVideo;
  private f mMainHandler;
  private V2TXLiveDef.V2TXLivePixelFormat mPixelFormat;
  private V2TXLivePlayerObserver mPlayerObserver;
  private int mPlayoutVolume;
  private HashMap<String, Object> mPropertyMap;
  private V2TXLiveDef.V2TXLiveFillMode mRenderFillMode;
  private V2TXLiveDef.V2TXLiveRotation mRenderRotation;
  private Surface mSurface;
  private a.a mSurfaceSize;
  private Object mView;
  private int mVolumeIntervals;
  
  static
  {
    AppMethodBeat.i(211780);
    h.d();
    AppMethodBeat.o(211780);
  }
  
  public V2TXLivePlayerImpl(Context paramContext)
  {
    AppMethodBeat.i(211626);
    this.mAsyncState = a.b.a;
    this.mMainHandler = new f(Looper.getMainLooper());
    this.mVolumeIntervals = -1;
    this.mPlayoutVolume = -1;
    apiLog("create: context-".concat(String.valueOf(paramContext)));
    this.mContext = paramContext.getApplicationContext();
    this.mPropertyMap = new HashMap();
    AppMethodBeat.o(211626);
  }
  
  private void apiError(String paramString)
  {
    AppMethodBeat.i(211642);
    TXCLog.e("V2-TXLivePlayerImpl", "v2_api_player(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211642);
  }
  
  private void apiLog(String paramString)
  {
    AppMethodBeat.i(211634);
    TXCLog.i("V2-TXLivePlayerImpl", "v2_api_player(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211634);
  }
  
  private void runOnMainThreadAsync(Runnable paramRunnable)
  {
    AppMethodBeat.i(211618);
    this.mMainHandler.post(paramRunnable);
    AppMethodBeat.o(211618);
  }
  
  private void setupParams()
  {
    AppMethodBeat.i(211610);
    Object localObject = this.mInnerPlayer;
    if (localObject == null)
    {
      AppMethodBeat.o(211610);
      return;
    }
    ((V2TXLivePlayer)localObject).setObserver(this.mPlayerObserver);
    ((V2TXLivePlayer)localObject).enableCustomRendering(this.mEnableCustomRendering, this.mPixelFormat, this.mBufferType);
    if (this.mView != null)
    {
      if ((this.mView instanceof TXCloudVideoView)) {
        ((V2TXLivePlayer)localObject).setRenderView((TXCloudVideoView)this.mView);
      }
    }
    else
    {
      if (this.mRenderFillMode != null) {
        ((V2TXLivePlayer)localObject).setRenderFillMode(this.mRenderFillMode);
      }
      if (this.mRenderRotation != null) {
        ((V2TXLivePlayer)localObject).setRenderRotation(this.mRenderRotation);
      }
      if (!this.mIsPauseAudio) {
        break label349;
      }
      ((V2TXLivePlayer)localObject).pauseAudio();
      label120:
      if (!this.mIsPauseVideo) {
        break label357;
      }
      ((V2TXLivePlayer)localObject).pauseVideo();
    }
    for (;;)
    {
      if ((this.mCacheMinTime > 0.0F) && (this.mCacheMaxTime > 0.0F)) {
        ((V2TXLivePlayer)localObject).setCacheParams(this.mCacheMinTime, this.mCacheMaxTime);
      }
      if (this.mPlayoutVolume > 0) {
        ((V2TXLivePlayer)localObject).setPlayoutVolume(this.mPlayoutVolume);
      }
      if (this.mVolumeIntervals > 0) {
        ((V2TXLivePlayer)localObject).enableVolumeEvaluation(this.mVolumeIntervals);
      }
      ((V2TXLivePlayer)localObject).showDebugView(this.mEnableDebugView);
      if (this.mSurface != null) {
        ((V2TXLivePlayer)localObject).setProperty("setSurface", this.mSurface);
      }
      if (this.mSurfaceSize != null) {
        ((V2TXLivePlayer)localObject).setProperty("setSurfaceSize", this.mSurfaceSize);
      }
      localObject = this.mPropertyMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.mInnerPlayer.setProperty((String)localEntry.getKey(), localEntry.getValue());
      }
      if ((this.mView instanceof TextureView))
      {
        ((V2TXLivePlayer)localObject).setRenderView((TextureView)this.mView);
        break;
      }
      if (!(this.mView instanceof SurfaceView)) {
        break;
      }
      ((V2TXLivePlayer)localObject).setRenderView((SurfaceView)this.mView);
      break;
      label349:
      ((V2TXLivePlayer)localObject).resumeAudio();
      break label120;
      label357:
      ((V2TXLivePlayer)localObject).resumeVideo();
    }
    AppMethodBeat.o(211610);
  }
  
  public int enableCustomRendering(final boolean paramBoolean, final V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, final V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    AppMethodBeat.i(211891);
    apiLog("enableCustomRendering: enable-" + paramBoolean + " pixelFormat-" + paramV2TXLivePixelFormat + " bufferType-" + paramV2TXLiveBufferType);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211564);
        V2TXLivePlayerImpl.access$1702(V2TXLivePlayerImpl.this, paramBoolean);
        V2TXLivePlayerImpl.access$1802(V2TXLivePlayerImpl.this, paramV2TXLivePixelFormat);
        V2TXLivePlayerImpl.access$1902(V2TXLivePlayerImpl.this, paramV2TXLiveBufferType);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.enableCustomRendering(paramBoolean, paramV2TXLivePixelFormat, paramV2TXLiveBufferType);
        }
        AppMethodBeat.o(211564);
      }
    });
    AppMethodBeat.o(211891);
    return 0;
  }
  
  public int enableVolumeEvaluation(final int paramInt)
  {
    AppMethodBeat.i(211882);
    apiLog("enableVolumeEvaluation: intervalMs-".concat(String.valueOf(paramInt)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211562);
        V2TXLivePlayerImpl.access$1602(V2TXLivePlayerImpl.this, paramInt);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.enableVolumeEvaluation(paramInt);
        }
        AppMethodBeat.o(211562);
      }
    });
    AppMethodBeat.o(211882);
    return 0;
  }
  
  public int isPlaying()
  {
    AppMethodBeat.i(211848);
    if (this.mAsyncState == a.b.a)
    {
      if (this.mInnerPlayer != null)
      {
        int i = this.mInnerPlayer.isPlaying();
        AppMethodBeat.o(211848);
        return i;
      }
      AppMethodBeat.o(211848);
      return 0;
    }
    if (this.mAsyncState == a.b.b)
    {
      AppMethodBeat.o(211848);
      return 1;
    }
    if (this.mAsyncState == a.b.c)
    {
      AppMethodBeat.o(211848);
      return 0;
    }
    AppMethodBeat.o(211848);
    return 0;
  }
  
  public int pauseAudio()
  {
    AppMethodBeat.i(211853);
    apiLog("pauseAudio: ");
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211575);
        V2TXLivePlayerImpl.access$1102(V2TXLivePlayerImpl.this, true);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.pauseAudio();
        }
        AppMethodBeat.o(211575);
      }
    });
    AppMethodBeat.o(211853);
    return 0;
  }
  
  public int pauseVideo()
  {
    AppMethodBeat.i(211865);
    apiLog("pauseVideo: ");
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211552);
        V2TXLivePlayerImpl.access$1202(V2TXLivePlayerImpl.this, true);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.pauseVideo();
        }
        AppMethodBeat.o(211552);
      }
    });
    AppMethodBeat.o(211865);
    return 0;
  }
  
  public int resumeAudio()
  {
    AppMethodBeat.i(211859);
    apiLog("resumeAudio: ");
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211570);
        V2TXLivePlayerImpl.access$1102(V2TXLivePlayerImpl.this, false);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.resumeAudio();
        }
        AppMethodBeat.o(211570);
      }
    });
    AppMethodBeat.o(211859);
    return 0;
  }
  
  public int resumeVideo()
  {
    AppMethodBeat.i(211870);
    apiLog("resumeVideo: ");
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211550);
        V2TXLivePlayerImpl.access$1202(V2TXLivePlayerImpl.this, false);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.resumeVideo();
        }
        AppMethodBeat.o(211550);
      }
    });
    AppMethodBeat.o(211870);
    return 0;
  }
  
  public int setCacheParams(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(211878);
    apiLog("setCacheParams: minTime-" + paramFloat1 + " maxTime-" + paramFloat2);
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F))
    {
      apiError("set cache param failed, invalid cache params.");
      AppMethodBeat.o(211878);
      return -2;
    }
    if (isPlaying() == 1)
    {
      apiError("set cache param failed, cant's set param when playing.");
      AppMethodBeat.o(211878);
      return -3;
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211565);
        V2TXLivePlayerImpl.access$1402(V2TXLivePlayerImpl.this, paramFloat2);
        V2TXLivePlayerImpl.access$1502(V2TXLivePlayerImpl.this, paramFloat1);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.setCacheParams(paramFloat1, paramFloat2);
        }
        AppMethodBeat.o(211565);
      }
    });
    AppMethodBeat.o(211878);
    return 0;
  }
  
  public void setObserver(final V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    AppMethodBeat.i(211786);
    apiLog("setObserver: observer-".concat(String.valueOf(paramV2TXLivePlayerObserver)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211686);
        V2TXLivePlayerImpl.access$002(V2TXLivePlayerImpl.this, paramV2TXLivePlayerObserver);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.setObserver(paramV2TXLivePlayerObserver);
        }
        AppMethodBeat.o(211686);
      }
    });
    AppMethodBeat.o(211786);
  }
  
  public int setPlayoutVolume(final int paramInt)
  {
    AppMethodBeat.i(211874);
    apiLog("setPlayoutVolume: volume-".concat(String.valueOf(paramInt)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211551);
        V2TXLivePlayerImpl.access$1302(V2TXLivePlayerImpl.this, paramInt);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.setPlayoutVolume(paramInt);
        }
        AppMethodBeat.o(211551);
      }
    });
    AppMethodBeat.o(211874);
    return 0;
  }
  
  public int setProperty(final String paramString, final Object paramObject)
  {
    AppMethodBeat.i(211796);
    apiLog("setProperty: key-" + paramString + " value-" + paramObject);
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211732);
        String str = paramString;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
            V2TXLivePlayerImpl.this.mInnerPlayer.setProperty(paramString, paramObject);
          }
          AppMethodBeat.o(211732);
          return;
          if (!str.equals("setSurface")) {
            break;
          }
          i = 0;
          break;
          if (!str.equals("setSurfaceSize")) {
            break;
          }
          i = 1;
          break;
          if (!str.equals("setPlayURLType")) {
            break;
          }
          i = 2;
          break;
          if (!str.equals("enableRecvSEIMessage")) {
            break;
          }
          i = 3;
          break;
          if (paramObject == null)
          {
            V2TXLivePlayerImpl.access$202(V2TXLivePlayerImpl.this, null);
          }
          else if ((paramObject instanceof Surface))
          {
            V2TXLivePlayerImpl.access$202(V2TXLivePlayerImpl.this, (Surface)paramObject);
            continue;
            if (paramObject == null)
            {
              V2TXLivePlayerImpl.access$302(V2TXLivePlayerImpl.this, null);
            }
            else if ((paramObject instanceof a.a))
            {
              V2TXLivePlayerImpl.access$302(V2TXLivePlayerImpl.this, (a.a)paramObject);
              continue;
              V2TXLivePlayerImpl.this.mPropertyMap.put(paramString, paramObject);
            }
          }
        }
      }
    });
    AppMethodBeat.o(211796);
    return 0;
  }
  
  public int setRenderFillMode(final V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    AppMethodBeat.i(211826);
    apiLog("setRenderFillMode: mode-".concat(String.valueOf(paramV2TXLiveFillMode)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211685);
        V2TXLivePlayerImpl.access$702(V2TXLivePlayerImpl.this, paramV2TXLiveFillMode);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.setRenderFillMode(paramV2TXLiveFillMode);
        }
        AppMethodBeat.o(211685);
      }
    });
    AppMethodBeat.o(211826);
    return 0;
  }
  
  public int setRenderRotation(final V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211820);
    apiLog("setRenderRotation: rotation-".concat(String.valueOf(paramV2TXLiveRotation)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211684);
        V2TXLivePlayerImpl.access$602(V2TXLivePlayerImpl.this, paramV2TXLiveRotation);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.setRenderRotation(paramV2TXLiveRotation);
        }
        AppMethodBeat.o(211684);
      }
    });
    AppMethodBeat.o(211820);
    return 0;
  }
  
  public int setRenderView(final SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(211815);
    StringBuilder localStringBuilder = new StringBuilder("setSurfaceView: view-");
    if (paramSurfaceView != null) {}
    for (String str = paramSurfaceView.hashCode();; str = "null")
    {
      apiLog(str);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211663);
          V2TXLivePlayerImpl.access$502(V2TXLivePlayerImpl.this, paramSurfaceView);
          if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
            V2TXLivePlayerImpl.this.mInnerPlayer.setRenderView(paramSurfaceView);
          }
          AppMethodBeat.o(211663);
        }
      });
      AppMethodBeat.o(211815);
      return 0;
    }
  }
  
  public int setRenderView(final TextureView paramTextureView)
  {
    AppMethodBeat.i(211808);
    StringBuilder localStringBuilder = new StringBuilder("setTextureView: view-");
    if (paramTextureView != null) {}
    for (String str = paramTextureView.hashCode();; str = "null")
    {
      apiLog(str);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211670);
          V2TXLivePlayerImpl.access$502(V2TXLivePlayerImpl.this, paramTextureView);
          if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
            V2TXLivePlayerImpl.this.mInnerPlayer.setRenderView(paramTextureView);
          }
          AppMethodBeat.o(211670);
        }
      });
      AppMethodBeat.o(211808);
      return 0;
    }
  }
  
  public int setRenderView(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211803);
    StringBuilder localStringBuilder = new StringBuilder("setTXCloudVideoView: view-");
    if (paramTXCloudVideoView != null) {}
    for (String str = paramTXCloudVideoView.hashCode();; str = "null")
    {
      apiLog(str);
      runOnMainThreadAsync(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211689);
          V2TXLivePlayerImpl.access$502(V2TXLivePlayerImpl.this, paramTXCloudVideoView);
          if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
            V2TXLivePlayerImpl.this.mInnerPlayer.setRenderView(paramTXCloudVideoView);
          }
          AppMethodBeat.o(211689);
        }
      });
      AppMethodBeat.o(211803);
      return 0;
    }
  }
  
  public void showDebugView(final boolean paramBoolean)
  {
    AppMethodBeat.i(211895);
    apiLog("showDebugView: enable-".concat(String.valueOf(paramBoolean)));
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211563);
        V2TXLivePlayerImpl.access$2002(V2TXLivePlayerImpl.this, paramBoolean);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.showDebugView(paramBoolean);
        }
        AppMethodBeat.o(211563);
      }
    });
    AppMethodBeat.o(211895);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(211887);
    if (isPlaying() == 0)
    {
      apiError("snapshot: snapshot is not allowed before the player starts playing.");
      AppMethodBeat.o(211887);
      return -3;
    }
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211559);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null) {
          V2TXLivePlayerImpl.this.mInnerPlayer.snapshot();
        }
        AppMethodBeat.o(211559);
      }
    });
    AppMethodBeat.o(211887);
    return 0;
  }
  
  public int startPlay(final String paramString)
  {
    AppMethodBeat.i(211835);
    apiLog("startPlay url:".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("V2-TXLivePlayerImpl", "start play fail, url invalid:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211835);
      return -2;
    }
    final V2TXLiveDef.V2TXLiveMode localV2TXLiveMode = b.a(paramString);
    if (localV2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      com.tencent.live2.b.a locala = com.tencent.live2.b.a.b(paramString);
      if ((locala == null) || (!locala.h()))
      {
        apiError("start play fail. invalid param. [url:" + paramString + "][param:" + locala + "]");
        AppMethodBeat.o(211835);
        return -2;
      }
    }
    else
    {
      int i = com.tencent.live2.a.a.a(paramString);
      if (i != 0)
      {
        AppMethodBeat.o(211835);
        return i;
      }
    }
    this.mAsyncState = a.b.b;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211671);
        if ((V2TXLivePlayerImpl.this.mInnerPlayer != null) && (V2TXLivePlayerImpl.this.mInnerPlayer.isPlaying() == 1)) {
          V2TXLivePlayerImpl.this.mInnerPlayer.stopPlay();
        }
        if (localV2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) {
          V2TXLivePlayerImpl.access$102(V2TXLivePlayerImpl.this, new d(V2TXLivePlayerImpl.this, V2TXLivePlayerImpl.this.mContext));
        }
        for (;;)
        {
          V2TXLivePlayerImpl.access$900(V2TXLivePlayerImpl.this);
          V2TXLivePlayerImpl.this.mInnerPlayer.startPlay(paramString);
          V2TXLivePlayerImpl.access$1002(V2TXLivePlayerImpl.this, a.b.a);
          AppMethodBeat.o(211671);
          return;
          V2TXLivePlayerImpl.access$102(V2TXLivePlayerImpl.this, new com.tencent.live2.a.a(V2TXLivePlayerImpl.this, V2TXLivePlayerImpl.this.mContext));
        }
      }
    });
    AppMethodBeat.o(211835);
    return 0;
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(211842);
    apiLog("stopPlay");
    this.mAsyncState = a.b.c;
    runOnMainThreadAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211719);
        if (V2TXLivePlayerImpl.this.mInnerPlayer != null)
        {
          V2TXLivePlayerImpl.access$1002(V2TXLivePlayerImpl.this, a.b.a);
          V2TXLivePlayerImpl.this.mInnerPlayer.stopPlay();
          V2TXLivePlayerImpl.access$102(V2TXLivePlayerImpl.this, null);
        }
        AppMethodBeat.o(211719);
      }
    });
    AppMethodBeat.o(211842);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl
 * JD-Core Version:    0.7.0.1
 */