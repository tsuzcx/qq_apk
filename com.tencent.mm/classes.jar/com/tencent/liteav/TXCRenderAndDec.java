package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.liteav.basic.c.h.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.a.a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCRenderAndDec
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.basic.b.b, a.a, com.tencent.liteav.renderer.f, com.tencent.liteav.videodecoder.f
{
  public static final String TAG = "TXCRenderAndDec";
  private h mConfig;
  private Context mContext;
  private a mDecListener;
  private boolean mEnableDecoderChange;
  private boolean mEnableLimitHWDecCache;
  private boolean mEnableRestartDecoder;
  private boolean mFirstRender;
  private long mFrameDecErrCnt;
  private boolean mIsRendering;
  private long mLastRenderCalculateTS;
  private long mLastRenderFrameCount;
  private long mLastReqKeyFrameTS;
  private WeakReference<com.tencent.liteav.basic.b.b> mNotifyListener;
  private boolean mRealTime;
  private WeakReference<b> mRenderAndDecDelegate;
  private long mRenderFrameCount;
  private int mRenderMode;
  private int mRenderRotation;
  private int mStreamType;
  private TXCVideoDecoder mVideoDecoder;
  private com.tencent.liteav.basic.c.h mVideoFrameFilter;
  private com.tencent.liteav.basic.a.b mVideoFrameFormat;
  private o mVideoFrameListener;
  private e mVideoRender;
  
  public TXCRenderAndDec(Context paramContext)
  {
    AppMethodBeat.i(16065);
    this.mContext = null;
    this.mConfig = null;
    this.mEnableLimitHWDecCache = false;
    this.mVideoDecoder = null;
    this.mEnableDecoderChange = false;
    this.mEnableRestartDecoder = false;
    this.mVideoRender = null;
    this.mVideoFrameFilter = null;
    this.mVideoFrameFormat = com.tencent.liteav.basic.a.b.a;
    this.mRealTime = false;
    this.mIsRendering = false;
    this.mStreamType = 0;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    this.mFirstRender = false;
    this.mRenderMode = 0;
    this.mRenderRotation = 0;
    this.mLastRenderCalculateTS = 0L;
    this.mRenderFrameCount = 0L;
    this.mLastRenderFrameCount = 0L;
    this.mDecListener = null;
    this.mContext = paramContext;
    c.a().a(this.mContext);
    AppMethodBeat.o(16065);
  }
  
  private void notifyEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(16089);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    localBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    com.tencent.liteav.basic.util.f.a(this.mNotifyListener, paramInt, localBundle);
    AppMethodBeat.o(16089);
  }
  
  private void requestKeyFrame()
  {
    AppMethodBeat.i(16099);
    long l = TXCTimeUtil.getTimeTick();
    if (l > this.mLastReqKeyFrameTS + 3000L)
    {
      this.mLastReqKeyFrameTS = l;
      TXCLog.e("TXCRenderAndDec", "requestKeyFrame: " + getID());
      if (this.mRenderAndDecDelegate != null)
      {
        b localb = (b)this.mRenderAndDecDelegate.get();
        if (localb != null) {
          localb.onRequestKeyFrame(getID(), this.mStreamType);
        }
      }
    }
    AppMethodBeat.o(16099);
  }
  
  private void startDecode()
  {
    AppMethodBeat.i(16088);
    if (this.mVideoRender != null) {}
    for (SurfaceTexture localSurfaceTexture = this.mVideoRender.a();; localSurfaceTexture = null)
    {
      startDecode(localSurfaceTexture);
      AppMethodBeat.o(16088);
      return;
    }
  }
  
  private void startDecode(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(16087);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null)
    {
      localTXCVideoDecoder.stop();
      localTXCVideoDecoder.enableHWDec(this.mConfig.h);
      localTXCVideoDecoder.config(this.mConfig.r);
      TXCLog.i("TXCRenderAndDec", "trtc_ start decode " + paramSurfaceTexture + ", hw: " + this.mConfig.h + ", id " + getID() + "_" + this.mStreamType);
      if (paramSurfaceTexture != null)
      {
        if (!this.mRealTime) {}
        for (;;)
        {
          localTXCVideoDecoder.setup(paramSurfaceTexture, null, null, bool1);
          localTXCVideoDecoder.setUserId(getID());
          localTXCVideoDecoder.start();
          AppMethodBeat.o(16087);
          return;
          bool1 = false;
        }
      }
      if (!this.mConfig.h) {
        if (this.mRealTime) {
          break label212;
        }
      }
    }
    label212:
    for (bool1 = bool2;; bool1 = false)
    {
      localTXCVideoDecoder.setup(null, null, null, bool1);
      localTXCVideoDecoder.setUserId(getID());
      localTXCVideoDecoder.start();
      AppMethodBeat.o(16087);
      return;
    }
  }
  
  public void decVideo(TXSNALPacket paramTXSNALPacket) {}
  
  public void enableDecoderChange(boolean paramBoolean)
  {
    this.mEnableDecoderChange = paramBoolean;
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    AppMethodBeat.i(221783);
    this.mEnableLimitHWDecCache = paramBoolean;
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null) {
      localTXCVideoDecoder.enableLimitDecCache(paramBoolean);
    }
    AppMethodBeat.o(221783);
  }
  
  public void enableRestartDecoder(boolean paramBoolean)
  {
    this.mEnableRestartDecoder = paramBoolean;
  }
  
  public long getAVNetRecvInterval()
  {
    AppMethodBeat.i(16083);
    long l = getLongValue(6014, 2);
    AppMethodBeat.o(16083);
    return l;
  }
  
  public long getAVPlayInterval()
  {
    AppMethodBeat.i(16082);
    long l = getLongValue(6013, 2);
    AppMethodBeat.o(16082);
    return l;
  }
  
  public h getConfig()
  {
    return this.mConfig;
  }
  
  public int getStreamType()
  {
    return this.mStreamType;
  }
  
  public long getVideoCacheDuration()
  {
    AppMethodBeat.i(16079);
    long l = getIntValue(6010, 2);
    AppMethodBeat.o(16079);
    return l;
  }
  
  public long getVideoCacheFrameCount()
  {
    AppMethodBeat.i(16080);
    long l = getIntValue(6011, 2);
    AppMethodBeat.o(16080);
    return l;
  }
  
  public int getVideoDecCacheFrameCount()
  {
    AppMethodBeat.i(16081);
    int i = getIntValue(6012, 2);
    AppMethodBeat.o(16081);
    return i;
  }
  
  public int getVideoGop()
  {
    AppMethodBeat.i(16084);
    int i = getIntValue(7120);
    AppMethodBeat.o(16084);
    return i;
  }
  
  public e getVideoRender()
  {
    return this.mVideoRender;
  }
  
  public boolean isRendering()
  {
    return this.mIsRendering;
  }
  
  public void muteVideo(boolean paramBoolean)
  {
    AppMethodBeat.i(182282);
    if ((!paramBoolean) && (this.mVideoRender != null)) {
      this.mVideoRender.m();
    }
    AppMethodBeat.o(182282);
  }
  
  public void onDecodeFailed(int paramInt)
  {
    AppMethodBeat.i(16097);
    TXCLog.e("TXCRenderAndDec", "video decode failed ".concat(String.valueOf(paramInt)));
    requestKeyFrame();
    paramInt = this.mStreamType;
    long l = this.mFrameDecErrCnt + 1L;
    this.mFrameDecErrCnt = l;
    setStatusValue(17014, paramInt, Long.valueOf(l));
    AppMethodBeat.o(16097);
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    AppMethodBeat.i(16095);
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
    o localo = this.mVideoFrameListener;
    if ((localo != null) && (paramTXSVideoFrame != null) && ((this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.b) || (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.e))) {
      if (this.mVideoRender == null) {
        break label301;
      }
    }
    label301:
    for (TXSVideoFrame localTXSVideoFrame = paramTXSVideoFrame.clone();; localTXSVideoFrame = paramTXSVideoFrame)
    {
      localTXSVideoFrame.rotation = ((this.mRenderRotation + i) % 360);
      if (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.e) {
        localTXSVideoFrame.loadNV21BufferFromI420Buffer();
      }
      localo.onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
      if (!this.mFirstRender)
      {
        this.mFirstRender = true;
        TXCEventRecorderProxy.a(getID(), 5007, -1L, -1L, "", this.mStreamType);
        if (this.mVideoRender == null) {
          TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.mStreamType);
        }
        if (this.mVideoDecoder != null) {
          TXCKeyPointReportProxy.a(getID(), 40029, this.mVideoDecoder.GetDecodeFirstFrameTS(), this.mStreamType);
        }
      }
      if (this.mVideoRender != null)
      {
        this.mVideoRender.a(paramTXSVideoFrame, paramInt1, paramInt2, i);
        AppMethodBeat.o(16095);
        return;
      }
      if (this.mLastRenderCalculateTS == 0L)
      {
        this.mLastRenderCalculateTS = System.currentTimeMillis();
        this.mLastRenderFrameCount = 0L;
        this.mRenderFrameCount = 0L;
        AppMethodBeat.o(16095);
        return;
      }
      this.mRenderFrameCount += 1L;
      AppMethodBeat.o(16095);
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16092);
    if (paramInt == 2106)
    {
      this.mConfig.h = false;
      localTXCVideoDecoder = this.mVideoDecoder;
      if (localTXCVideoDecoder != null) {
        localTXCVideoDecoder.restart(this.mConfig.h);
      }
    }
    while (paramInt != 2020)
    {
      TXCVideoDecoder localTXCVideoDecoder;
      paramBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
      com.tencent.liteav.basic.util.f.a(this.mNotifyListener, paramInt, paramBundle);
      AppMethodBeat.o(16092);
      return;
    }
    TXCLog.e("TXCRenderAndDec", "decoding too many frame(>40) without output! request key frame now.");
    requestKeyFrame();
    AppMethodBeat.o(16092);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16093);
    TXCLog.w("TXCRenderAndDec", "play decode when surface texture create hw " + this.mConfig.h);
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
      if (this.mConfig.h) {
        startDecode(paramSurfaceTexture);
      }
      AppMethodBeat.o(16093);
      return;
    }
  }
  
  public void onSurfaceTextureDestroy(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16094);
    try
    {
      TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
      if ((this.mConfig.h) && (this.mVideoDecoder != null)) {
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
      AppMethodBeat.o(16094);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      TXCLog.e("TXCRenderAndDec", "onSurfaceTextureDestroy failed.", paramSurfaceTexture);
      AppMethodBeat.o(16094);
    }
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(16098);
    Object localObject = this.mVideoFrameListener;
    if (localObject != null)
    {
      if (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.c)
      {
        TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
        localTXSVideoFrame.width = paramInt2;
        localTXSVideoFrame.height = paramInt3;
        localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
        localTXSVideoFrame.rotation = ((this.mRenderRotation + paramInt4) % 360);
        localTXSVideoFrame.textureId = paramInt1;
        if ((this.mVideoRender instanceof com.tencent.liteav.renderer.a)) {
          localTXSVideoFrame.eglContext = ((com.tencent.liteav.renderer.a)this.mVideoRender).b();
        }
        ((o)localObject).onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
        AppMethodBeat.o(16098);
        return;
      }
      localObject = this.mVideoDecoder;
      if ((localObject != null) && (!((TXCVideoDecoder)localObject).isHardwareDecode()))
      {
        AppMethodBeat.o(16098);
        return;
      }
      if (this.mVideoFrameFilter == null)
      {
        if (this.mVideoFrameFormat != com.tencent.liteav.basic.a.b.e) {
          break label265;
        }
        this.mVideoFrameFilter = new com.tencent.liteav.beauty.b.o(3);
        this.mVideoFrameFilter.a(true);
        if (!this.mVideoFrameFilter.a()) {
          break label280;
        }
        this.mVideoFrameFilter.a(paramInt2, paramInt3);
        this.mVideoFrameFilter.a(new h.a()
        {
          public void a(int paramAnonymousInt)
          {
            AppMethodBeat.i(15553);
            com.tencent.liteav.basic.c.h localh = TXCRenderAndDec.this.mVideoFrameFilter;
            o localo = TXCRenderAndDec.this.mVideoFrameListener;
            if ((localh != null) && (localo != null))
            {
              TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
              localTXSVideoFrame.width = localh.n();
              localTXSVideoFrame.height = localh.o();
              localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
              localTXSVideoFrame.rotation = ((paramInt4 + TXCRenderAndDec.this.mRenderRotation) % 360);
              localo.onRenderVideoFrame(TXCRenderAndDec.this.getID(), TXCRenderAndDec.this.mStreamType, localTXSVideoFrame);
            }
            AppMethodBeat.o(15553);
          }
        });
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
      AppMethodBeat.o(16098);
      return;
      label265:
      this.mVideoFrameFilter = new com.tencent.liteav.beauty.b.o(1);
      break;
      label280:
      TXCLog.i("TXCRenderAndDec", "throwVideoFrame->release mVideoFrameFilter");
      this.mVideoFrameFilter = null;
    }
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16096);
    if (this.mVideoRender != null) {
      this.mVideoRender.b(paramInt1, paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("EVT_MSG", "Resolution changed to" + paramInt1 + "x" + paramInt2);
    localBundle.putInt("EVT_PARAM1", paramInt1);
    localBundle.putInt("EVT_PARAM2", paramInt2);
    localBundle.putString("EVT_USERID", getID());
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    onNotifyEvent(2009, localBundle);
    setStatusValue(5003, this.mStreamType, Integer.valueOf(paramInt1 << 16 | paramInt2));
    TXCEventRecorderProxy.a(getID(), 4003, paramInt1, paramInt2, "", this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40002, paramInt1, this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40003, paramInt2, this.mStreamType);
    AppMethodBeat.o(16096);
  }
  
  public void restartDecoder()
  {
    AppMethodBeat.i(16091);
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if ((localTXCVideoDecoder != null) && (localTXCVideoDecoder.isHevc())) {
      localTXCVideoDecoder.restart(true);
    }
    AppMethodBeat.o(16091);
  }
  
  public void setBlockInterval(int paramInt)
  {
    AppMethodBeat.i(16078);
    if (this.mVideoRender != null) {
      this.mVideoRender.e(paramInt);
    }
    AppMethodBeat.o(16078);
  }
  
  public void setConfig(h paramh)
  {
    AppMethodBeat.i(221782);
    this.mConfig = paramh;
    if (this.mVideoRender != null) {
      this.mVideoRender.b(this.mConfig.d);
    }
    AppMethodBeat.o(221782);
  }
  
  public void setDecListener(a parama)
  {
    this.mDecListener = parama;
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(16071);
    super.setID(paramString);
    if (this.mVideoRender != null) {
      this.mVideoRender.setID(getID());
    }
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.setUserId(paramString);
    }
    AppMethodBeat.o(16071);
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.b.b paramb)
  {
    AppMethodBeat.i(221780);
    this.mNotifyListener = new WeakReference(paramb);
    AppMethodBeat.o(221780);
  }
  
  public void setRenderAndDecDelegate(b paramb)
  {
    AppMethodBeat.i(16068);
    this.mRenderAndDecDelegate = new WeakReference(paramb);
    AppMethodBeat.o(16068);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(16076);
    this.mRenderMode = paramInt;
    if (this.mVideoRender != null) {
      this.mVideoRender.c(paramInt);
    }
    AppMethodBeat.o(16076);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(16077);
    TXCLog.i("TXCRenderAndDec", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    this.mRenderRotation = paramInt;
    if (this.mVideoRender != null) {
      this.mVideoRender.d(paramInt);
    }
    AppMethodBeat.o(16077);
  }
  
  public void setStreamType(int paramInt)
  {
    AppMethodBeat.i(16086);
    this.mStreamType = paramInt;
    if (this.mVideoRender != null) {
      this.mVideoRender.a(this.mStreamType);
    }
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.setStreamType(this.mStreamType);
    }
    AppMethodBeat.o(16086);
  }
  
  public void setVideoFrameListener(o paramo, com.tencent.liteav.basic.a.b paramb)
  {
    AppMethodBeat.i(221781);
    this.mVideoFrameListener = paramo;
    this.mVideoFrameFormat = paramb;
    TXCLog.i("TXCRenderAndDec", "setVideoFrameListener->enter listener: " + paramo + ", format: " + paramb);
    if ((this.mVideoRender != null) && ((this.mVideoRender instanceof com.tencent.liteav.renderer.a)))
    {
      if (paramo == null)
      {
        TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> clean listener.");
        ((com.tencent.liteav.renderer.a)this.mVideoRender).b(null);
        AppMethodBeat.o(221781);
        return;
      }
      TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> set listener.");
      ((com.tencent.liteav.renderer.a)this.mVideoRender).b(this);
    }
    AppMethodBeat.o(221781);
  }
  
  public void setVideoRender(e parame)
  {
    AppMethodBeat.i(16066);
    TXCLog.i("TXCRenderAndDec", "set video render " + parame + " id " + getID() + ", " + this.mStreamType);
    this.mVideoRender = parame;
    if (this.mVideoRender == null)
    {
      AppMethodBeat.o(16066);
      return;
    }
    this.mVideoRender.setID(getID());
    this.mVideoRender.a(this.mStreamType);
    this.mVideoRender.a(this);
    this.mVideoRender.c(this.mRenderMode);
    this.mVideoRender.d(this.mRenderRotation);
    if ((this.mVideoFrameListener != null) && ((this.mVideoRender instanceof com.tencent.liteav.renderer.a))) {
      ((com.tencent.liteav.renderer.a)this.mVideoRender).b(this);
    }
    if (this.mConfig != null) {
      this.mVideoRender.b(this.mConfig.d);
    }
    AppMethodBeat.o(16066);
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(16072);
    TXCLog.i("TXCRenderAndDec", "start render dec " + getID() + ", " + this.mStreamType);
    this.mRealTime = paramBoolean;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(this);
      this.mVideoRender.f();
      this.mVideoRender.setID(getID());
    }
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    startDecode();
    this.mIsRendering = true;
    AppMethodBeat.o(16072);
  }
  
  public void startVideo()
  {
    AppMethodBeat.i(16073);
    stopVideo();
    this.mRealTime = true;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(this);
      this.mVideoRender.f();
      this.mVideoRender.setID(getID());
    }
    TXCLog.i("TXCRenderAndDec", "start video dec " + getID() + ", " + this.mStreamType);
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    startDecode();
    this.mIsRendering = true;
    AppMethodBeat.o(16073);
  }
  
  public void stop()
  {
    AppMethodBeat.i(16075);
    TXCLog.i("TXCRenderAndDec", "stop video render dec " + getID() + ", " + this.mStreamType);
    this.mIsRendering = false;
    this.mRealTime = false;
    if (this.mVideoDecoder != null)
    {
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(true);
      this.mVideoRender.a(null);
    }
    AppMethodBeat.o(16075);
  }
  
  public void stopVideo()
  {
    AppMethodBeat.i(16074);
    this.mIsRendering = false;
    if (this.mVideoDecoder != null)
    {
      TXCLog.i("TXCRenderAndDec", "stop video dec " + getID() + ", " + this.mStreamType);
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    if (this.mVideoRender != null)
    {
      this.mVideoRender.a(false);
      this.mVideoRender.a(null);
    }
    AppMethodBeat.o(16074);
  }
  
  public void updateLoadInfo()
  {
    AppMethodBeat.i(16085);
    int i;
    if (this.mVideoDecoder != null)
    {
      i = this.mStreamType;
      if (this.mVideoDecoder.isHardwareDecode() != true) {
        break label67;
      }
    }
    label67:
    for (long l1 = 1L;; l1 = 0L)
    {
      setStatusValue(5002, i, Long.valueOf(l1));
      if (this.mVideoRender == null) {
        break;
      }
      this.mVideoRender.n();
      AppMethodBeat.o(16085);
      return;
    }
    l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastRenderCalculateTS;
    if (l2 >= 1000L)
    {
      double d = (this.mRenderFrameCount - this.mLastRenderFrameCount) * 1000.0D / l2;
      this.mLastRenderFrameCount = this.mRenderFrameCount;
      this.mLastRenderCalculateTS = l1;
      setStatusValue(6002, this.mStreamType, Double.valueOf(d));
    }
    AppMethodBeat.o(16085);
  }
  
  public static abstract interface a
  {
    public abstract void a(SurfaceTexture paramSurfaceTexture);
  }
  
  public static abstract interface b
  {
    public abstract void onRequestKeyFrame(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.TXCRenderAndDec
 * JD-Core Version:    0.7.0.1
 */