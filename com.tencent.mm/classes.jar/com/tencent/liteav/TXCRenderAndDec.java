package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.renderer.a.a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCRenderAndDec
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.audio.c, com.tencent.liteav.basic.c.a, a.a, f, com.tencent.liteav.videodecoder.c
{
  public static final String TAG = "TXCRenderAndDec";
  private boolean isAddAudioFirstFrame;
  private String mAudioInfo;
  private com.tencent.liteav.audio.a mAudioPlayer;
  private g mConfig;
  private Context mContext;
  private TXCRenderAndDec.a mDecListener;
  private boolean mEnableDecoderChange;
  private boolean mEnableVolumeLevelCal;
  private boolean mFirstRender;
  private long mFrameDecErrCnt;
  private boolean mIsFirstPlay;
  private boolean mIsRendering;
  private long mLastRenderCalculateTS;
  private long mLastRenderFrameCount;
  private long mLastReqKeyFrameTS;
  private final float mMinJitterCacheHWDecode;
  private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener;
  private boolean mRealTime;
  private final float mRealTimeJitterCache;
  private final float mRealTimeJitterCacheMax;
  private final float mRealTimeJitterCacheMin;
  private WeakReference<b> mRenderAndDecDelegate;
  private long mRenderFrameCount;
  private int mRenderMode;
  private int mSmoothMode;
  private int mStreamFormat;
  private int mStreamType;
  private TXCVideoDecoder mVideoDecoder;
  private com.tencent.liteav.basic.d.g mVideoFrameFilter;
  private n mVideoFrameListener;
  private e mVideoRender;
  
  public TXCRenderAndDec(Context paramContext)
  {
    AppMethodBeat.i(146813);
    this.mContext = null;
    this.mConfig = null;
    this.mVideoDecoder = null;
    this.mEnableDecoderChange = false;
    this.mVideoRender = null;
    this.mAudioPlayer = null;
    this.mVideoFrameFilter = null;
    this.mRealTime = false;
    this.mSmoothMode = 0;
    this.mStreamFormat = 0;
    this.mIsRendering = false;
    this.mIsFirstPlay = false;
    this.mAudioInfo = "";
    this.mEnableVolumeLevelCal = false;
    this.mRealTimeJitterCache = com.tencent.liteav.basic.a.a.a;
    this.mRealTimeJitterCacheMin = com.tencent.liteav.basic.a.a.b;
    this.mRealTimeJitterCacheMax = com.tencent.liteav.basic.a.a.c;
    this.mMinJitterCacheHWDecode = 0.4F;
    this.mStreamType = 0;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    this.mFirstRender = false;
    this.mRenderMode = 0;
    this.mLastRenderCalculateTS = 0L;
    this.mRenderFrameCount = 0L;
    this.mLastRenderFrameCount = 0L;
    this.isAddAudioFirstFrame = false;
    this.mDecListener = null;
    this.mContext = paramContext;
    com.tencent.liteav.basic.e.b.a().a(this.mContext);
    AppMethodBeat.o(146813);
  }
  
  public static int GetCorePlayVolumeLevel()
  {
    AppMethodBeat.i(146837);
    int i = com.tencent.liteav.audio.a.h();
    AppMethodBeat.o(146837);
    return i;
  }
  
  private void notifyEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(146853);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    localBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    com.tencent.liteav.basic.util.b.a(this.mNotifyListener, paramInt, localBundle);
    AppMethodBeat.o(146853);
  }
  
  private void requestKeyFrame()
  {
    AppMethodBeat.i(146865);
    long l = TXCTimeUtil.getTimeTick();
    if (l > this.mLastReqKeyFrameTS + 3000L)
    {
      this.mLastReqKeyFrameTS = l;
      TXCLog.e("TXCRenderAndDec", "requestKeyFrame: " + getID());
      if (this.mRenderAndDecDelegate != null)
      {
        b localb = (b)this.mRenderAndDecDelegate.get();
        if (localb != null) {
          localb.a(getID(), this.mStreamType);
        }
      }
    }
    AppMethodBeat.o(146865);
  }
  
  public static void setAudioCorePlayListener(com.tencent.liteav.audio.c paramc)
  {
    AppMethodBeat.i(146812);
    com.tencent.liteav.audio.a.a(paramc);
    AppMethodBeat.o(146812);
  }
  
  public static void setAudioMode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(146835);
    com.tencent.liteav.audio.a.a(paramContext, paramInt);
    AppMethodBeat.o(146835);
  }
  
  public static void setEnableCorePlayVolumeLevel(boolean paramBoolean)
  {
    AppMethodBeat.i(146836);
    com.tencent.liteav.audio.a.f(paramBoolean);
    AppMethodBeat.o(146836);
  }
  
  private void setPlayCacheStrategy()
  {
    AppMethodBeat.i(146851);
    setupRealTimePlayParams(this.mRealTime);
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.a(this.mConfig.a);
      this.mAudioPlayer.a(this.mConfig.g);
      this.mAudioPlayer.c(this.mConfig.c);
      this.mAudioPlayer.b(this.mConfig.b);
      setStatusValue(2012, this.mStreamType, Long.valueOf((this.mConfig.c * 1000.0F)));
      setStatusValue(2013, this.mStreamType, Long.valueOf((this.mConfig.b * 1000.0F)));
      setStatusValue(2015, Long.valueOf(0L));
    }
    if ((this.mVideoDecoder != null) && (this.mVideoDecoder.isHardwareDecode()) && (this.mConfig.c < 0.4F) && (this.mConfig.b < 0.4F))
    {
      this.mConfig.i = false;
      this.mVideoDecoder.stop();
      startDecode();
    }
    if (this.mVideoRender != null) {
      this.mVideoRender.b(this.mConfig.d);
    }
    AppMethodBeat.o(146851);
  }
  
  private void setupRealTimePlayParams(boolean paramBoolean)
  {
    float f3 = 0.4F;
    AppMethodBeat.i(146852);
    float f2;
    float f1;
    if (paramBoolean)
    {
      float f4 = this.mConfig.c;
      f2 = this.mConfig.b;
      f1 = f4;
      if (f4 <= this.mRealTimeJitterCacheMin) {
        break label361;
      }
      f4 = this.mRealTimeJitterCacheMin;
      f1 = f4;
      if (!this.mConfig.i) {
        break label361;
      }
      f1 = f4;
      if (f4 >= 0.4F) {
        break label361;
      }
      f1 = f3;
    }
    label340:
    label361:
    for (;;)
    {
      if (f2 > this.mRealTimeJitterCacheMax) {
        f2 = this.mRealTimeJitterCacheMax;
      }
      for (;;)
      {
        if (f1 >= f2)
        {
          f1 = this.mRealTimeJitterCacheMin;
          f2 = this.mRealTimeJitterCacheMax;
        }
        for (;;)
        {
          this.mConfig.g = true;
          this.mConfig.a = f1;
          this.mConfig.c = f1;
          this.mConfig.b = f2;
          if (this.mAudioPlayer != null)
          {
            this.mAudioPlayer.a(true, this.mContext);
            this.mAudioPlayer.d(true);
          }
          AppMethodBeat.o(146852);
          return;
          TXCLog.e("TXCRenderAndDec", "setupRealTimePlayParams current cache time : min-cache[" + this.mConfig.c + "], max-cache[" + this.mConfig.b + "], org-cache[" + this.mConfig.a + "]");
          if (this.mAudioPlayer != null)
          {
            if ((this.mConfig == null) || (!this.mConfig.h)) {
              break label340;
            }
            this.mAudioPlayer.a(true, this.mContext);
          }
          for (;;)
          {
            this.mAudioPlayer.d(false);
            if ((this.mConfig.a > this.mConfig.b) || (this.mConfig.a < this.mConfig.c)) {
              this.mConfig.a = this.mConfig.b;
            }
            AppMethodBeat.o(146852);
            return;
            this.mAudioPlayer.a(false, this.mContext);
          }
        }
      }
    }
  }
  
  private void startDecode()
  {
    AppMethodBeat.i(146850);
    if (this.mVideoRender != null) {}
    for (SurfaceTexture localSurfaceTexture = this.mVideoRender.a();; localSurfaceTexture = null)
    {
      startDecode(localSurfaceTexture);
      AppMethodBeat.o(146850);
      return;
    }
  }
  
  private void startDecode(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(146849);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null)
    {
      localTXCVideoDecoder.stop();
      localTXCVideoDecoder.enableHWDec(this.mConfig.i);
      String str = getID();
      int i;
      if (this.mConfig.i)
      {
        i = 1;
        TXCEventRecorderProxy.a(str, 4005, i, -1, "", this.mStreamType);
        TXCLog.d("TXCRenderAndDec", "trtc_ start decode " + paramSurfaceTexture + ", hw: " + this.mConfig.i + ", id " + getID() + "_" + this.mStreamType);
        if (paramSurfaceTexture == null) {
          break label190;
        }
        if (this.mRealTime) {
          break label185;
        }
      }
      for (;;)
      {
        localTXCVideoDecoder.setup(paramSurfaceTexture, null, null, bool1);
        localTXCVideoDecoder.setUserId(getID());
        localTXCVideoDecoder.start();
        AppMethodBeat.o(146849);
        return;
        i = 0;
        break;
        label185:
        bool1 = false;
      }
      label190:
      if (!this.mConfig.i) {
        if (this.mRealTime) {
          break label242;
        }
      }
    }
    label242:
    for (bool1 = bool2;; bool1 = false)
    {
      localTXCVideoDecoder.setup(null, null, null, bool1);
      localTXCVideoDecoder.setUserId(getID());
      localTXCVideoDecoder.start();
      AppMethodBeat.o(146849);
      return;
    }
  }
  
  private void switchToSoftDecoder()
  {
    AppMethodBeat.i(146854);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null)
    {
      TXCLog.w("TXCRenderAndDec", "switch to soft decoder when hw error");
      localTXCVideoDecoder.stop();
      this.mConfig.i = false;
      setPlayCacheStrategy();
      localTXCVideoDecoder.enableChange(false);
      startDecode();
    }
    AppMethodBeat.o(146854);
  }
  
  public void decAudio(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146826);
    if (this.mAudioPlayer == null) {
      TXCLog.w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
    }
    AppMethodBeat.o(146826);
  }
  
  public void decVideo(TXSNALPacket paramTXSNALPacket) {}
  
  public void enableDecoderChange(boolean paramBoolean)
  {
    this.mEnableDecoderChange = paramBoolean;
  }
  
  public long getAVNetRecvInterval()
  {
    AppMethodBeat.i(146844);
    long l = getLongValue(6014, 2);
    AppMethodBeat.o(146844);
    return l;
  }
  
  public long getAVPlayInterval()
  {
    AppMethodBeat.i(146842);
    long l = getLongValue(6013, 2);
    AppMethodBeat.o(146842);
    return l;
  }
  
  public long getAudioCacheDuration()
  {
    AppMethodBeat.i(146838);
    long l = getLongValue(2007);
    AppMethodBeat.o(146838);
    return l;
  }
  
  public float getAudioCacheThreshold()
  {
    AppMethodBeat.i(146845);
    if (this.mAudioPlayer != null)
    {
      float f = this.mAudioPlayer.c();
      AppMethodBeat.o(146845);
      return f;
    }
    AppMethodBeat.o(146845);
    return 0.0F;
  }
  
  public String getAudioInfo()
  {
    int k = 0;
    AppMethodBeat.i(146846);
    int i;
    int m;
    int n;
    if (this.mAudioPlayer != null)
    {
      i = this.mAudioPlayer.d();
      m = getIntValue(2019);
      n = getIntValue(2020);
      if (this.mAudioPlayer == null) {
        break label219;
      }
    }
    label219:
    for (int j = this.mAudioPlayer.e();; j = 0)
    {
      if (this.mAudioPlayer != null) {
        k = this.mAudioPlayer.f();
      }
      String str = m + "," + n + " | " + j + "," + k;
      if ((!this.mAudioInfo.equals(str)) && (this.mDecListener != null))
      {
        com.tencent.liteav.basic.structs.a locala = new com.tencent.liteav.basic.structs.a();
        locala.a = j;
        locala.b = k;
        this.mDecListener.a(locala);
      }
      this.mAudioInfo = str;
      str = i + " | " + this.mAudioInfo;
      AppMethodBeat.o(146846);
      return str;
      i = 0;
      break;
    }
  }
  
  public int getAudioJitter()
  {
    AppMethodBeat.i(146843);
    int i = getIntValue(2018);
    AppMethodBeat.o(146843);
    return i;
  }
  
  public com.tencent.liteav.audio.a getAudioPlayer()
  {
    return this.mAudioPlayer;
  }
  
  public g getConfig()
  {
    return this.mConfig;
  }
  
  public int getStreamType()
  {
    return this.mStreamType;
  }
  
  public long getVideoCacheDuration()
  {
    AppMethodBeat.i(146839);
    long l = getIntValue(6010, 2);
    AppMethodBeat.o(146839);
    return l;
  }
  
  public long getVideoCacheFrameCount()
  {
    AppMethodBeat.i(146840);
    long l = getIntValue(6011, 2);
    AppMethodBeat.o(146840);
    return l;
  }
  
  public int getVideoDecCacheFrameCount()
  {
    AppMethodBeat.i(146841);
    int i = getIntValue(6012, 2);
    AppMethodBeat.o(146841);
    return i;
  }
  
  public int getVideoGop()
  {
    return 0;
  }
  
  public e getVideoRender()
  {
    return this.mVideoRender;
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(146834);
    if (this.mAudioPlayer != null)
    {
      int i = this.mAudioPlayer.b();
      AppMethodBeat.o(146834);
      return i;
    }
    AppMethodBeat.o(146834);
    return 0;
  }
  
  public boolean isAddAudioFirstFrame()
  {
    return this.isAddAudioFirstFrame;
  }
  
  public boolean isRendering()
  {
    return this.mIsRendering;
  }
  
  public void onDecodeFailed(int paramInt)
  {
    AppMethodBeat.i(146861);
    TXCLog.e("TXCRenderAndDec", "video decode failed ".concat(String.valueOf(paramInt)));
    requestKeyFrame();
    paramInt = this.mStreamType;
    long l = this.mFrameDecErrCnt + 1L;
    this.mFrameDecErrCnt = l;
    setStatusValue(17014, paramInt, Long.valueOf(l));
    AppMethodBeat.o(146861);
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    AppMethodBeat.i(146859);
    int i;
    if ((paramInt3 != 0) && (paramInt3 != 1) && (paramInt3 != 2))
    {
      i = paramInt3;
      if (paramInt3 != 3) {}
    }
    else
    {
      i = 360 - paramInt3 * 90;
    }
    n localn = this.mVideoFrameListener;
    if (localn != null) {
      if ((this.mVideoRender == null) || (paramTXSVideoFrame == null)) {
        break label205;
      }
    }
    label205:
    for (TXSVideoFrame localTXSVideoFrame = paramTXSVideoFrame.clone();; localTXSVideoFrame = paramTXSVideoFrame)
    {
      localn.onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
      if (!this.mFirstRender)
      {
        this.mFirstRender = true;
        TXCKeyPointReportProxy.a(getID(), 32004);
        TXCEventRecorderProxy.a(getID(), 5007, -1, -1, "", this.mStreamType);
      }
      if (this.mVideoRender != null)
      {
        this.mVideoRender.a(paramTXSVideoFrame, paramInt1, paramInt2, i);
        AppMethodBeat.o(146859);
        return;
      }
      if (this.mLastRenderCalculateTS == 0L)
      {
        this.mLastRenderCalculateTS = System.currentTimeMillis();
        this.mLastRenderFrameCount = 0L;
        this.mRenderFrameCount = 0L;
        AppMethodBeat.o(146859);
        return;
      }
      this.mRenderFrameCount += 1L;
      AppMethodBeat.o(146859);
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(146856);
    if (paramInt == 2106) {
      switchToSoftDecoder();
    }
    do
    {
      for (;;)
      {
        paramBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
        com.tencent.liteav.basic.util.b.a(this.mNotifyListener, paramInt, paramBundle);
        AppMethodBeat.o(146856);
        return;
        if (paramInt != 2003) {
          break;
        }
        if (this.mIsFirstPlay)
        {
          notifyEvent(2004, "视频播放开始");
          this.mIsFirstPlay = false;
        }
      }
    } while (paramInt != 2020);
    TXCLog.e("TXCRenderAndDec", "decoding too many frame(>40) without output! request key frame now.");
    requestKeyFrame();
    AppMethodBeat.o(146856);
  }
  
  public void onPlayError(int paramInt, String paramString) {}
  
  public void onPlayJitterStateNotify(int paramInt)
  {
    AppMethodBeat.i(146864);
    if (paramInt == 2024)
    {
      notifyEvent(2007, "视频缓冲中...");
      AppMethodBeat.o(146864);
      return;
    }
    if (paramInt == 2023)
    {
      notifyEvent(2007, "视频缓冲中...");
      AppMethodBeat.o(146864);
      return;
    }
    if (paramInt == 2025)
    {
      notifyEvent(2004, "视频播放开始");
      AppMethodBeat.o(146864);
      return;
    }
    if (paramInt == 2026)
    {
      if (this.mIsFirstPlay)
      {
        notifyEvent(2004, "视频播放开始");
        this.mIsFirstPlay = false;
      }
      notifyEvent(2026, "音频播放开始");
    }
    AppMethodBeat.o(146864);
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146863);
    if (this.mDecListener != null) {
      this.mDecListener.a(paramArrayOfByte, paramLong, paramInt1, paramInt2);
    }
    AppMethodBeat.o(146863);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(146857);
    TXCLog.w("TXCRenderAndDec", "play decode when surface texture create hw " + this.mConfig.i);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null) {
      if (this.mRealTime) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localTXCVideoDecoder.setup(paramSurfaceTexture, null, null, bool);
      if (this.mConfig.i) {
        startDecode(paramSurfaceTexture);
      }
      AppMethodBeat.o(146857);
      return;
    }
  }
  
  public void onSurfaceTextureDestroy(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(146858);
    try
    {
      TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
      if (this.mVideoDecoder != null) {
        this.mVideoDecoder.stop();
      }
      if (this.mVideoFrameFilter != null)
      {
        this.mVideoFrameFilter.d();
        this.mVideoFrameFilter = null;
      }
      if (this.mDecListener != null) {
        this.mDecListener.a(paramSurfaceTexture);
      }
      AppMethodBeat.o(146858);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      AppMethodBeat.o(146858);
    }
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146862);
    if ((this.mVideoFrameListener != null) && (this.mConfig.i)) {
      if (this.mVideoFrameFilter == null)
      {
        this.mVideoFrameFilter = new o(1, true);
        this.mVideoFrameFilter.a(true);
        if (!this.mVideoFrameFilter.a()) {
          break label124;
        }
        this.mVideoFrameFilter.a(paramInt2, paramInt3);
        this.mVideoFrameFilter.a(new TXCRenderAndDec.1(this));
      }
    }
    for (;;)
    {
      if (this.mVideoFrameFilter != null)
      {
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        this.mVideoFrameFilter.a(paramInt2, paramInt3);
        this.mVideoFrameFilter.b(paramInt1);
      }
      AppMethodBeat.o(146862);
      return;
      label124:
      TXCLog.i("TXCRenderAndDec", "throwVideoFrame->release mVideoFrameFilter");
      this.mVideoFrameFilter = null;
    }
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146860);
    if (this.mVideoRender != null) {
      this.mVideoRender.b(paramInt1, paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("EVT_MSG", "分辨率改变为" + paramInt1 + "x" + paramInt2);
    localBundle.putInt("EVT_PARAM1", paramInt1);
    localBundle.putInt("EVT_PARAM2", paramInt2);
    localBundle.putString("EVT_USERID", getID());
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    onNotifyEvent(2009, localBundle);
    setStatusValue(5003, this.mStreamType, Integer.valueOf(paramInt1 << 16 | paramInt2));
    TXCEventRecorderProxy.a(getID(), 4003, paramInt1, paramInt2, "", this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40002, paramInt1);
    TXCKeyPointReportProxy.a(getID(), 40003, paramInt2);
    AppMethodBeat.o(146860);
  }
  
  public void restartDecoder()
  {
    AppMethodBeat.i(146855);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if ((localTXCVideoDecoder != null) && (localTXCVideoDecoder.isHevc())) {
      localTXCVideoDecoder.restart(true);
    }
    AppMethodBeat.o(146855);
  }
  
  public void setAddAudioFirstFrame(boolean paramBoolean)
  {
    this.isAddAudioFirstFrame = paramBoolean;
  }
  
  public void setBlockInterval(int paramInt)
  {
    AppMethodBeat.i(146832);
    if (this.mVideoRender != null) {
      this.mVideoRender.e(paramInt);
    }
    AppMethodBeat.o(146832);
  }
  
  public void setConfig(g paramg)
  {
    AppMethodBeat.i(146818);
    this.mConfig = paramg;
    setPlayCacheStrategy();
    AppMethodBeat.o(146818);
  }
  
  public void setDecListener(TXCRenderAndDec.a parama)
  {
    this.mDecListener = parama;
  }
  
  public void setEnableVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(146833);
    this.mEnableVolumeLevelCal = paramBoolean;
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.b(paramBoolean);
    }
    AppMethodBeat.o(146833);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(146819);
    super.setID(paramString);
    if (this.mVideoRender != null) {
      this.mVideoRender.setID(getID());
    }
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.setUserId(paramString);
    }
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.a(paramString);
    }
    AppMethodBeat.o(146819);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(146829);
    String str;
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.e(paramBoolean);
      str = getID();
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 0)
    {
      TXCEventRecorderProxy.a(str, 3002, i, -1, "", this.mStreamType);
      AppMethodBeat.o(146829);
      return;
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146815);
    this.mNotifyListener = new WeakReference(parama);
    AppMethodBeat.o(146815);
  }
  
  public void setRenderAndDecDelegate(b paramb)
  {
    AppMethodBeat.i(146816);
    this.mRenderAndDecDelegate = new WeakReference(paramb);
    AppMethodBeat.o(146816);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(146827);
    this.mRenderMode = paramInt;
    if (this.mVideoRender != null) {
      this.mVideoRender.c(paramInt);
    }
    AppMethodBeat.o(146827);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(146828);
    if (this.mVideoRender != null) {
      this.mVideoRender.d(paramInt);
    }
    AppMethodBeat.o(146828);
  }
  
  public void setSmoothMode(int paramInt)
  {
    AppMethodBeat.i(146830);
    this.mSmoothMode = paramInt;
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.b(this.mSmoothMode);
    }
    AppMethodBeat.o(146830);
  }
  
  public void setStreamFormat(int paramInt)
  {
    AppMethodBeat.i(146831);
    this.mStreamFormat = paramInt;
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.a(this.mStreamFormat);
    }
    AppMethodBeat.o(146831);
  }
  
  public void setStreamType(int paramInt)
  {
    AppMethodBeat.i(146848);
    this.mStreamType = paramInt;
    if (this.mVideoRender != null) {
      this.mVideoRender.a(this.mStreamType);
    }
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.setStreamType(this.mStreamType);
    }
    AppMethodBeat.o(146848);
  }
  
  public void setVideoFrameListener(n paramn)
  {
    AppMethodBeat.i(146817);
    this.mVideoFrameListener = paramn;
    TXCLog.i("TXCRenderAndDec", "setVideoFrameListener->enter listener: ".concat(String.valueOf(paramn)));
    AppMethodBeat.o(146817);
  }
  
  public void setVideoRender(e parame)
  {
    AppMethodBeat.i(146814);
    TXCLog.i("TXCRenderAndDec", "set video render " + parame + " id " + getID() + ", " + this.mStreamType);
    this.mVideoRender = parame;
    if (this.mVideoRender == null)
    {
      AppMethodBeat.o(146814);
      return;
    }
    this.mVideoRender.setID(getID());
    this.mVideoRender.a(this.mStreamType);
    this.mVideoRender.a(this);
    this.mVideoRender.c(this.mRenderMode);
    if ((this.mVideoRender instanceof com.tencent.liteav.renderer.a)) {
      ((com.tencent.liteav.renderer.a)this.mVideoRender).b(this);
    }
    if (this.mConfig != null) {
      this.mVideoRender.b(this.mConfig.d);
    }
    AppMethodBeat.o(146814);
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(146820);
    TXCLog.i("TXCRenderAndDec", "start render dec " + getID() + ", " + this.mStreamType);
    this.mRealTime = paramBoolean;
    this.mIsFirstPlay = true;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(this);
      this.mVideoRender.i();
      this.mVideoRender.setID(getID());
    }
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    if (this.mAudioPlayer == null) {
      this.mAudioPlayer = new com.tencent.liteav.audio.a();
    }
    this.mAudioPlayer.b(this);
    setupRealTimePlayParams(this.mRealTime);
    this.mAudioPlayer.b(this.mSmoothMode);
    this.mAudioPlayer.a(this.mStreamFormat);
    this.mAudioPlayer.a(getID());
    this.mAudioPlayer.b(this.mEnableVolumeLevelCal);
    this.mAudioPlayer.a(this.mContext);
    startDecode();
    setPlayCacheStrategy();
    this.mIsRendering = true;
    AppMethodBeat.o(146820);
  }
  
  public void startAudio()
  {
    AppMethodBeat.i(146823);
    this.mRealTime = true;
    if (this.mAudioPlayer == null) {
      this.mAudioPlayer = new com.tencent.liteav.audio.a();
    }
    this.mAudioPlayer.b(this);
    setupRealTimePlayParams(this.mRealTime);
    this.mAudioPlayer.b(this.mSmoothMode);
    this.mAudioPlayer.a(this.mStreamFormat);
    this.mAudioPlayer.a(getID());
    this.mAudioPlayer.b(this.mEnableVolumeLevelCal);
    this.mAudioPlayer.a(this.mContext);
    AppMethodBeat.o(146823);
  }
  
  public void startVideo()
  {
    AppMethodBeat.i(146821);
    stopVideo();
    this.mRealTime = true;
    this.mIsFirstPlay = true;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(this);
      this.mVideoRender.i();
      this.mVideoRender.setID(getID());
    }
    TXCLog.i("TXCRenderAndDec", "start video dec " + getID() + ", " + this.mStreamType);
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    startDecode();
    this.mIsRendering = true;
    AppMethodBeat.o(146821);
  }
  
  public void stop()
  {
    AppMethodBeat.i(146825);
    TXCLog.d("TXCRenderAndDec", "stop video render dec " + getID() + ", " + this.mStreamType);
    this.mIsRendering = false;
    this.mRealTime = false;
    this.mSmoothMode = 0;
    if (this.mVideoDecoder != null)
    {
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.b(null);
      this.mAudioPlayer.a();
    }
    if (this.mVideoRender != null)
    {
      this.mVideoRender.j();
      this.mVideoRender.a(null);
    }
    AppMethodBeat.o(146825);
  }
  
  public void stopAudio()
  {
    AppMethodBeat.i(146824);
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.b(null);
      this.mAudioPlayer.a();
    }
    AppMethodBeat.o(146824);
  }
  
  public void stopVideo()
  {
    AppMethodBeat.i(146822);
    this.mIsRendering = false;
    this.mSmoothMode = 0;
    if (this.mVideoDecoder != null)
    {
      TXCLog.d("TXCRenderAndDec", "stop video dec " + getID() + ", " + this.mStreamType);
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    if (this.mVideoRender != null)
    {
      this.mVideoRender.j();
      this.mVideoRender.a(null);
    }
    AppMethodBeat.o(146822);
  }
  
  public void updateLoadInfo()
  {
    long l3 = 0L;
    AppMethodBeat.i(146847);
    TXAudioJitterBufferReportInfo localTXAudioJitterBufferReportInfo;
    if (this.mAudioPlayer != null)
    {
      localTXAudioJitterBufferReportInfo = this.mAudioPlayer.g();
      if (localTXAudioJitterBufferReportInfo != null)
      {
        if (localTXAudioJitterBufferReportInfo.mLoadCnt != 0) {
          break label319;
        }
        l1 = 0L;
        if (localTXAudioJitterBufferReportInfo.mTimeTotalCacheTimeCnt != 0L) {
          break label336;
        }
        l2 = 0L;
        label54:
        if (localTXAudioJitterBufferReportInfo.mTimeTotalJittCnt != 0) {
          break label352;
        }
      }
    }
    label319:
    label336:
    label352:
    for (int i = 0;; i = localTXAudioJitterBufferReportInfo.mTimeTotalJitt / localTXAudioJitterBufferReportInfo.mTimeTotalJittCnt)
    {
      long l4 = i;
      setStatusValue(2001, this.mStreamType, Long.valueOf(l1));
      setStatusValue(2002, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mLoadCnt));
      setStatusValue(2003, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mLoadMaxTime));
      setStatusValue(2004, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mSpeedCnt));
      setStatusValue(2005, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mNoDataCnt));
      setStatusValue(2008, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mAvgCacheTime));
      setStatusValue(2009, this.mStreamType, Long.valueOf(localTXAudioJitterBufferReportInfo.mIsRealTime));
      setStatusValue(2010, Long.valueOf(l2));
      setStatusValue(2011, Long.valueOf(l4));
      setStatusValue(2014, Long.valueOf(localTXAudioJitterBufferReportInfo.mTimeDropCnt));
      if (this.mVideoDecoder != null)
      {
        i = this.mStreamType;
        l1 = l3;
        if (this.mVideoDecoder.isHardwareDecode() == true) {
          l1 = 1L;
        }
        setStatusValue(5002, i, Long.valueOf(l1));
      }
      if (this.mVideoRender == null) {
        break label367;
      }
      this.mVideoRender.r();
      AppMethodBeat.o(146847);
      return;
      l1 = localTXAudioJitterBufferReportInfo.mLoadTime / localTXAudioJitterBufferReportInfo.mLoadCnt;
      break;
      l2 = localTXAudioJitterBufferReportInfo.mTimeTotalCacheTime / localTXAudioJitterBufferReportInfo.mTimeTotalCacheTimeCnt;
      break label54;
    }
    label367:
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastRenderCalculateTS;
    if (l2 >= 1000L)
    {
      double d = (this.mRenderFrameCount - this.mLastRenderFrameCount) * 1000.0D / l2;
      this.mLastRenderFrameCount = this.mRenderFrameCount;
      this.mLastRenderCalculateTS = l1;
      setStatusValue(6002, this.mStreamType, Double.valueOf(d));
    }
    AppMethodBeat.o(146847);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.TXCRenderAndDec
 * JD-Core Version:    0.7.0.1
 */