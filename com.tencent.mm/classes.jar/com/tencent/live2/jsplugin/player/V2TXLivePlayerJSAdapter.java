package com.tencent.live2.jsplugin.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.b;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class V2TXLivePlayerJSAdapter
  extends a
{
  private static final String TAG = "V2TXLivePlayerJSAdapter";
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private V2TXLivePlayerJSConfig mConfig;
  private boolean mIsInit;
  private boolean mNeedCompressSnapshot;
  private ITXLivePlayListener mPlayListener;
  private V2TXLiveDef.V2TXLiveMode mPlayMode;
  private V2TXLivePlayer mPlayer;
  private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
  private int mTRTCNetworkQuality;
  private Handler mThreadHandler;
  
  static
  {
    AppMethodBeat.i(215580);
    h.f();
    AppMethodBeat.o(215580);
  }
  
  public V2TXLivePlayerJSAdapter(Context paramContext)
  {
    AppMethodBeat.i(215532);
    this.mPlayer = new V2TXLivePlayerImpl(paramContext);
    this.mPlayer.setObserver(this);
    this.mTRTCNetworkQuality = 2;
    this.mThreadHandler = new Handler(Looper.getMainLooper());
    this.mConfig = new V2TXLivePlayerJSConfig();
    AppMethodBeat.o(215532);
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215565);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "V2TXLivePlayerJSAdapter(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(215565);
      return;
    }
    TXCLog.e("V2TXLivePlayerJSAdapter", "V2TXLivePlayerJSAdapter(" + hashCode() + ") " + str);
    AppMethodBeat.o(215565);
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215563);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "V2TXLivePlayerJSAdapter(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(215563);
      return;
    }
    TXCLog.i("V2TXLivePlayerJSAdapter", "V2TXLivePlayerJSAdapter(" + hashCode() + ") " + str);
    AppMethodBeat.o(215563);
  }
  
  private void callbackSDKVersion()
  {
    AppMethodBeat.i(215560);
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      localITXLivePlayListener.onPlayEvent(-9999999, localBundle);
    }
    AppMethodBeat.o(215560);
  }
  
  private V2TXJSAdapterError initLivePlayerInner(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(215541);
    if (paramBundle == null)
    {
      apiOnlineError("init player inner fail. invalid bundle params.", false);
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(215541);
      return paramTXCloudVideoView;
    }
    if (this.mIsInit)
    {
      apiOnlineError("invalid operation. already init.", false);
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid operation. already init.");
      AppMethodBeat.o(215541);
      return paramTXCloudVideoView;
    }
    if (paramTXCloudVideoView != null) {
      this.mPlayer.setRenderView(paramTXCloudVideoView);
    }
    apiOnlineLog("init player.", false);
    this.mIsInit = true;
    this.mConfig.updateFromBundle(paramBundle);
    setFullParams(this.mConfig);
    paramTXCloudVideoView = new V2TXJSAdapterError();
    AppMethodBeat.o(215541);
    return paramTXCloudVideoView;
  }
  
  private boolean isRTCProtocol()
  {
    return this.mPlayMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
  }
  
  private void runOnLivePlayerThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(215559);
    Handler localHandler = this.mThreadHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
    AppMethodBeat.o(215559);
  }
  
  private void setDiffParams(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig1, V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig2)
  {
    AppMethodBeat.i(215558);
    String str = paramV2TXLivePlayerJSConfig2.diffConfig(paramV2TXLivePlayerJSConfig1);
    if (!TextUtils.isEmpty(str)) {
      apiOnlineLog("set diff config:".concat(String.valueOf(str)), true);
    }
    if (paramV2TXLivePlayerJSConfig1.isMuteVideo != paramV2TXLivePlayerJSConfig2.isMuteVideo)
    {
      if (paramV2TXLivePlayerJSConfig2.isMuteVideo) {
        this.mPlayer.pauseVideo();
      }
    }
    else if (paramV2TXLivePlayerJSConfig1.isMuteAudio != paramV2TXLivePlayerJSConfig2.isMuteAudio)
    {
      if (!paramV2TXLivePlayerJSConfig2.isMuteAudio) {
        break label502;
      }
      this.mPlayer.pauseAudio();
    }
    for (;;)
    {
      if (paramV2TXLivePlayerJSConfig1.enableRecvSEIMessage != paramV2TXLivePlayerJSConfig2.enableRecvSEIMessage) {
        this.mPlayer.setProperty("enableRecvSEIMessage", Boolean.valueOf(paramV2TXLivePlayerJSConfig2.enableRecvSEIMessage));
      }
      if (paramV2TXLivePlayerJSConfig1.enableDebugView != paramV2TXLivePlayerJSConfig2.enableDebugView) {
        this.mPlayer.showDebugView(paramV2TXLivePlayerJSConfig2.enableDebugView);
      }
      if ((paramV2TXLivePlayerJSConfig1.minCache != paramV2TXLivePlayerJSConfig2.minCache) || (paramV2TXLivePlayerJSConfig1.maxCache != paramV2TXLivePlayerJSConfig2.maxCache)) {
        this.mPlayer.setCacheParams(Math.min(paramV2TXLivePlayerJSConfig2.minCache, paramV2TXLivePlayerJSConfig2.maxCache), Math.max(paramV2TXLivePlayerJSConfig2.minCache, paramV2TXLivePlayerJSConfig2.maxCache));
      }
      if (paramV2TXLivePlayerJSConfig1.volumeNotifyIntervals != paramV2TXLivePlayerJSConfig2.volumeNotifyIntervals) {
        this.mPlayer.enableVolumeEvaluation(paramV2TXLivePlayerJSConfig2.volumeNotifyIntervals);
      }
      if (paramV2TXLivePlayerJSConfig1.fillMode != paramV2TXLivePlayerJSConfig2.fillMode) {
        this.mPlayer.setRenderFillMode(paramV2TXLivePlayerJSConfig2.fillMode);
      }
      if (paramV2TXLivePlayerJSConfig1.renderRotation != paramV2TXLivePlayerJSConfig2.renderRotation) {
        this.mPlayer.setRenderRotation(paramV2TXLivePlayerJSConfig2.renderRotation);
      }
      if (paramV2TXLivePlayerJSConfig1.audioRoute != paramV2TXLivePlayerJSConfig2.audioRoute) {
        TXCAudioEngine.setAudioRoute(paramV2TXLivePlayerJSConfig2.audioRoute);
      }
      if ((paramV2TXLivePlayerJSConfig2.url != null) && (!paramV2TXLivePlayerJSConfig2.url.equals(paramV2TXLivePlayerJSConfig1.url)))
      {
        if (this.mPlayer.isPlaying() == 1)
        {
          apiOnlineLog("stop play when update url.", false);
          this.mPlayer.stopPlay();
        }
        if ((paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (paramV2TXLivePlayerJSConfig2.isAutoPlay))
        {
          apiOnlineLog("auto start play when update url.", false);
          startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
        }
      }
      if (paramV2TXLivePlayerJSConfig1.mode != paramV2TXLivePlayerJSConfig2.mode)
      {
        if (this.mPlayer.isPlaying() == 1)
        {
          apiOnlineLog("stop play when update mode.", false);
          this.mPlayer.stopPlay();
        }
        if ((paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (paramV2TXLivePlayerJSConfig2.isAutoPlay))
        {
          apiOnlineLog("auto start play when update mode.", false);
          startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
        }
      }
      if ((paramV2TXLivePlayerJSConfig2.isAutoPlay) && (paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (!TextUtils.isEmpty(paramV2TXLivePlayerJSConfig2.url)) && (this.mPlayer.isPlaying() != 1))
      {
        apiOnlineLog("start auto play.", false);
        startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
      }
      AppMethodBeat.o(215558);
      return;
      this.mPlayer.resumeVideo();
      break;
      label502:
      this.mPlayer.resumeAudio();
    }
  }
  
  private void setFullParams(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    AppMethodBeat.i(215555);
    apiOnlineLog("set full config:".concat(String.valueOf(paramV2TXLivePlayerJSConfig)), true);
    if (paramV2TXLivePlayerJSConfig.isMuteVideo)
    {
      this.mPlayer.pauseVideo();
      if (!paramV2TXLivePlayerJSConfig.isMuteAudio) {
        break label249;
      }
      this.mPlayer.pauseAudio();
    }
    for (;;)
    {
      this.mPlayer.setProperty("enableRecvSEIMessage", Boolean.valueOf(paramV2TXLivePlayerJSConfig.enableRecvSEIMessage));
      this.mPlayer.showDebugView(paramV2TXLivePlayerJSConfig.enableDebugView);
      this.mPlayer.setCacheParams(Math.min(paramV2TXLivePlayerJSConfig.minCache, paramV2TXLivePlayerJSConfig.maxCache), Math.max(paramV2TXLivePlayerJSConfig.minCache, paramV2TXLivePlayerJSConfig.maxCache));
      this.mPlayer.enableVolumeEvaluation(paramV2TXLivePlayerJSConfig.volumeNotifyIntervals);
      TXCAudioEngine.setAudioRoute(paramV2TXLivePlayerJSConfig.audioRoute);
      this.mPlayer.setRenderFillMode(paramV2TXLivePlayerJSConfig.fillMode);
      this.mPlayer.setRenderRotation(paramV2TXLivePlayerJSConfig.renderRotation);
      if ((this.mConfig.isCanAutoPlay) && (this.mConfig.isAutoPlay) && (!TextUtils.isEmpty(this.mConfig.url)))
      {
        if (this.mPlayer.isPlaying() == 1)
        {
          this.mPlayer.stopPlay();
          apiOnlineError("stop play when set full params.", false);
        }
        startPlayInner(this.mConfig.url, this.mConfig.mode);
      }
      AppMethodBeat.o(215555);
      return;
      this.mPlayer.resumeVideo();
      break;
      label249:
      this.mPlayer.resumeAudio();
    }
  }
  
  private void startPlayInner(String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(215553);
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("start play fail. url is empty.", false);
      AppMethodBeat.o(215553);
      return;
    }
    if (paramInt == 1) {
      if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (paramString.contains(".flv"))) {
        paramInt = i;
      }
    }
    for (;;)
    {
      apiOnlineLog("start play.[url:" + paramString + "][type:" + paramInt + "]", false);
      this.mPlayMode = b.a(paramString);
      this.mPlayer.setProperty("setPlayURLType", Integer.valueOf(paramInt));
      this.mPlayer.setProperty("setFrameWorkType", Integer.valueOf(3));
      this.mPlayer.startPlay(paramString);
      AppMethodBeat.o(215553);
      return;
      paramInt = 0;
      continue;
      paramInt = 5;
    }
  }
  
  public V2TXJSAdapterError initLivePlayer(Bundle paramBundle)
  {
    AppMethodBeat.i(215538);
    callbackSDKVersion();
    paramBundle = initLivePlayerInner(null, paramBundle);
    AppMethodBeat.o(215538);
    return paramBundle;
  }
  
  public V2TXJSAdapterError initLivePlayer(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(215539);
    if (paramTXCloudVideoView == null)
    {
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(215539);
      return paramTXCloudVideoView;
    }
    paramTXCloudVideoView = initLivePlayerInner(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(215539);
    return paramTXCloudVideoView;
  }
  
  public boolean isMuted()
  {
    return this.mConfig.isMuteAudio;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(215548);
    if (this.mPlayer.isPlaying() == 1)
    {
      AppMethodBeat.o(215548);
      return true;
    }
    AppMethodBeat.o(215548);
    return false;
  }
  
  public void onAudioPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle)
  {
    AppMethodBeat.i(215576);
    apiOnlineLog("onAudioPlayStatusUpdate: [status:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]", false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onAudioPlayStatusUpdate: isn't rtc protocol,ignore.", false);
      AppMethodBeat.o(215576);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null)
    {
      AppMethodBeat.o(215576);
      return;
    }
    switch (2.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePlayStatus[paramV2TXLivePlayStatus.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215576);
      return;
      paramV2TXLivePlayer.onPlayEvent(2001, paramBundle);
    }
  }
  
  public void onError(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(215574);
    apiOnlineLog("onError: [code:" + paramInt + "][msg:" + paramString + "][info:" + paramBundle + "]", false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onError: isn't rtc protocol, ignore.", false);
      AppMethodBeat.o(215574);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null)
    {
      AppMethodBeat.o(215574);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215574);
      return;
      paramV2TXLivePlayer.onPlayEvent(-2301, paramBundle);
    }
  }
  
  public void onNetworkQuality(int paramInt)
  {
    this.mTRTCNetworkQuality = paramInt;
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(215571);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      runOnLivePlayerThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(215631);
          V2TXLivePlayerJSAdapter.this.operateLivePlayer("stop", null);
          AppMethodBeat.o(215631);
        }
      });
    }
    Object localObject;
    if (paramInt == 2012)
    {
      if ((!this.mConfig.enableRecvSEIMessage) || (paramBundle == null)) {
        break label120;
      }
      localObject = paramBundle.getByteArray("EVT_GET_MSG");
      if ((localObject == null) || (localObject.length <= 0)) {
        break label114;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramBundle.putString("EVT_MSG", (String)localObject);
        localObject = this.mPlayListener;
        if (localObject != null) {
          ((ITXLivePlayListener)localObject).onPlayEvent(paramInt, paramBundle);
        }
        AppMethodBeat.o(215571);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label114:
      String str = "";
    }
    label120:
    AppMethodBeat.o(215571);
  }
  
  public void onPlayNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(215572);
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null) {
      localITXLivePlayListener.onNetStatus(paramBundle);
    }
    AppMethodBeat.o(215572);
  }
  
  public void onPlayoutVolumeUpdate(V2TXLivePlayer paramV2TXLivePlayer, int paramInt)
  {
    AppMethodBeat.i(215566);
    paramV2TXLivePlayer = this.mAudioVolumeListener;
    if (paramV2TXLivePlayer != null) {
      paramV2TXLivePlayer.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(215566);
  }
  
  public void onRecvSEIMessage(String paramString)
  {
    AppMethodBeat.i(215578);
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localITXLivePlayListener.onPlayEvent(2012, localBundle);
    }
    AppMethodBeat.o(215578);
  }
  
  public void onSnapshotComplete(V2TXLivePlayer paramV2TXLivePlayer, Bitmap paramBitmap)
  {
    AppMethodBeat.i(215568);
    paramV2TXLivePlayer = this.mSnapshotListener;
    if (paramV2TXLivePlayer == null)
    {
      AppMethodBeat.o(215568);
      return;
    }
    if (paramBitmap != null)
    {
      if (this.mNeedCompressSnapshot)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.5F, 0.5F);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, false);
        paramV2TXLivePlayer.onSnapshot(paramBitmap);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
        AppMethodBeat.o(215568);
        return;
      }
      paramV2TXLivePlayer.onSnapshot(paramBitmap);
      AppMethodBeat.o(215568);
      return;
    }
    paramV2TXLivePlayer.onSnapshot(paramBitmap);
    AppMethodBeat.o(215568);
  }
  
  public void onStatisticsUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics paramV2TXLivePlayerStatistics)
  {
    AppMethodBeat.i(215570);
    String str1 = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(paramV2TXLivePlayerStatistics.appCpu), Integer.valueOf(paramV2TXLivePlayerStatistics.systemCpu) });
    String str2 = TXCStatus.b("18446744073709551615", 10001);
    paramV2TXLivePlayer = new Bundle();
    paramV2TXLivePlayer.putString("CPU_USAGE", str1);
    paramV2TXLivePlayer.putInt("VIDEO_WIDTH", paramV2TXLivePlayerStatistics.width);
    paramV2TXLivePlayer.putInt("VIDEO_HEIGHT", paramV2TXLivePlayerStatistics.height);
    paramV2TXLivePlayer.putInt("VIDEO_FPS", paramV2TXLivePlayerStatistics.fps);
    paramV2TXLivePlayer.putInt("NET_SPEED", paramV2TXLivePlayerStatistics.audioBitrate + paramV2TXLivePlayerStatistics.videoBitrate);
    paramV2TXLivePlayer.putInt("VIDEO_BITRATE", paramV2TXLivePlayerStatistics.videoBitrate);
    paramV2TXLivePlayer.putInt("AUDIO_BITRATE", paramV2TXLivePlayerStatistics.audioBitrate);
    paramV2TXLivePlayer.putString("SERVER_IP", str2);
    paramV2TXLivePlayer.putInt("NET_QUALITY_LEVEL", this.mTRTCNetworkQuality);
    paramV2TXLivePlayer.putInt("AUDIO_CACHE", 0);
    paramV2TXLivePlayer.putInt("VIDEO_CACHE", 0);
    paramV2TXLivePlayer.putInt("V_SUM_CACHE_SIZE", 0);
    paramV2TXLivePlayer.putInt("V_DEC_CACHE_SIZE", 0);
    paramV2TXLivePlayer.putString("AUDIO_PLAY_INFO", "");
    paramV2TXLivePlayerStatistics = this.mPlayListener;
    if (paramV2TXLivePlayerStatistics != null) {
      paramV2TXLivePlayerStatistics.onNetStatus(paramV2TXLivePlayer);
    }
    AppMethodBeat.o(215570);
  }
  
  public void onVideoPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle)
  {
    AppMethodBeat.i(215577);
    apiOnlineLog("onVideoPlayStatusUpdate: [status:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]", false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onVideoPlayStatusUpdate: isn't rtc protocol,ignore.", false);
      AppMethodBeat.o(215577);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null)
    {
      AppMethodBeat.o(215577);
      return;
    }
    switch (2.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePlayStatus[paramV2TXLivePlayStatus.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215577);
      return;
      paramV2TXLivePlayer.onPlayEvent(2003, paramBundle);
      paramV2TXLivePlayer.onPlayEvent(2004, paramBundle);
      AppMethodBeat.o(215577);
      return;
      paramV2TXLivePlayer.onPlayEvent(2007, paramBundle);
    }
  }
  
  public void onWarning(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(215575);
    if (!isRTCProtocol())
    {
      AppMethodBeat.o(215575);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null)
    {
      AppMethodBeat.o(215575);
      return;
    }
    if (paramInt == 2105) {
      paramV2TXLivePlayer.onPlayEvent(2105, paramBundle);
    }
    AppMethodBeat.o(215575);
  }
  
  public V2TXJSAdapterError operateLivePlayer(String paramString, JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    AppMethodBeat.i(215547);
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("operate live player fail. operate name is empty.", false);
      paramString = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(215547);
      return paramString;
    }
    if (!this.mIsInit)
    {
      if ((!paramString.equals("start")) && (!paramString.equals("stop")) && (!paramString.equals("resume")) && (!paramString.equals("pause")))
      {
        bool1 = bool3;
        if (!paramString.equals("mute")) {}
      }
      else
      {
        bool1 = true;
      }
      apiOnlineError("operate live player fail. player isn't init.", bool1);
      paramString = new V2TXJSAdapterError(-3, "uninited livePlayer");
      AppMethodBeat.o(215547);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    apiOnlineLog("operate live player.[name:" + paramString + "][param:" + str + "]", true);
    if ((paramString.equalsIgnoreCase("play")) || (paramString.equalsIgnoreCase("resume"))) {
      startPlayInner(this.mConfig.url, this.mConfig.mode);
    }
    for (;;)
    {
      paramString = new V2TXJSAdapterError();
      AppMethodBeat.o(215547);
      return paramString;
      if ((paramString.equalsIgnoreCase("stop")) || (paramString.equalsIgnoreCase("pause")))
      {
        this.mPlayer.stopPlay();
      }
      else if (paramString.equalsIgnoreCase("mute"))
      {
        paramString = this.mConfig;
        if (!this.mConfig.isMuteAudio) {}
        for (;;)
        {
          paramString.isMuteAudio = bool1;
          if (!this.mConfig.isMuteAudio) {
            break label333;
          }
          this.mPlayer.pauseAudio();
          break;
          bool1 = false;
        }
        label333:
        this.mPlayer.resumeAudio();
      }
      else
      {
        if (!paramString.equalsIgnoreCase("snapshot")) {
          break;
        }
        bool1 = bool2;
        if (paramJSONObject != null)
        {
          paramString = paramJSONObject.optString("quality");
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.equalsIgnoreCase("compressed")) {
              bool1 = true;
            }
          }
        }
        takePhoto(bool1, this.mSnapshotListener);
      }
    }
    paramString = new V2TXJSAdapterError(-4, "invalid operate command");
    AppMethodBeat.o(215547);
    return paramString;
  }
  
  public void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.mPlayListener = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public V2TXJSAdapterError setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(215550);
    this.mPlayer.setProperty("setSurface", paramSurface);
    paramSurface = new V2TXJSAdapterError();
    AppMethodBeat.o(215550);
    return paramSurface;
  }
  
  public V2TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215552);
    this.mPlayer.setProperty("setSurfaceSize", new a.a(paramInt1, paramInt2));
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(215552);
    return localV2TXJSAdapterError;
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(215549);
    this.mNeedCompressSnapshot = paramBoolean;
    this.mSnapshotListener = paramITXSnapshotListener;
    this.mPlayer.snapshot();
    AppMethodBeat.o(215549);
  }
  
  public V2TXJSAdapterError uninitLivePlayer()
  {
    AppMethodBeat.i(215545);
    if (!this.mIsInit)
    {
      apiOnlineError("un init player fail. player isn't init.", false);
      localV2TXJSAdapterError = new V2TXJSAdapterError(-3, "uninited livePlayer");
      AppMethodBeat.o(215545);
      return localV2TXJSAdapterError;
    }
    apiOnlineLog("un init player.", false);
    this.mIsInit = false;
    this.mPlayer.stopPlay();
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(215545);
    return localV2TXJSAdapterError;
  }
  
  public V2TXJSAdapterError updateLivePlayer(Bundle paramBundle)
  {
    AppMethodBeat.i(215543);
    if (paramBundle == null)
    {
      apiOnlineError("update player fail. invalid params.", false);
      paramBundle = new V2TXJSAdapterError(-1, "invalid params.");
      AppMethodBeat.o(215543);
      return paramBundle;
    }
    if (!this.mIsInit)
    {
      apiOnlineError("update player fail. player isn't init.", false);
      paramBundle = new V2TXJSAdapterError(-3, "uninited livePlayer.");
      AppMethodBeat.o(215543);
      return paramBundle;
    }
    V2TXLivePlayerJSConfig localV2TXLivePlayerJSConfig = new V2TXLivePlayerJSConfig(this.mConfig);
    localV2TXLivePlayerJSConfig.updateFromBundle(paramBundle);
    setDiffParams(this.mConfig, localV2TXLivePlayerJSConfig);
    this.mConfig = localV2TXLivePlayerJSConfig;
    paramBundle = new V2TXJSAdapterError();
    AppMethodBeat.o(215543);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */