package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.TXCRenderAndDec.b;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXCSoundEffectPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy.a;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.e.a;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d.a;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManager.TXAudioRoute;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;
import com.tencent.liteav.o;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrameCallbackFormat;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCRenderParams;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudDef.TRTCSwitchRoomConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TRTCCloudImpl
  extends TRTCCloud
  implements SurfaceHolder.Callback, TXCRenderAndDec.b, com.tencent.liteav.audio.c, com.tencent.liteav.audio.d, com.tencent.liteav.audio.e, com.tencent.liteav.audio.f, com.tencent.liteav.audio.g, com.tencent.liteav.audio.h, com.tencent.liteav.basic.c.b, d.a, o, a.a
{
  private static final int CURRENT_ENCODE_TYPE_H264 = 0;
  private static final int CURRENT_ENCODE_TYPE_H265 = 1;
  private static final int DEFAULT_FPS_FOR_SCREEN_CAPTURE = 10;
  private static final int DEFAULT_GOP_FOR_SCREEN_CAPTURE = 3;
  private static final String KEY_CONFIG_ADJUST_RESOLUTION = "config_adjust_resolution";
  private static final String KEY_CONFIG_FPS = "config_fps";
  private static final String KEY_CONFIG_GOP = "config_gop";
  private static final int MIN_VOLUME_EVALUATION_INTERVAL_MS = 100;
  private static final int RECV_MODE_AUTO_AUDIO_ONLY = 2;
  private static final int RECV_MODE_AUTO_AUDIO_VIDEO = 1;
  private static final int RECV_MODE_AUTO_VIDEO_ONLY = 3;
  private static final int RECV_MODE_MANUAL = 4;
  private static final int RECV_MODE_UNKNOWN = 0;
  protected static final int ROOM_STATE_ENTRING = 1;
  private static final int ROOM_STATE_IN = 2;
  protected static final int ROOM_STATE_OUT = 0;
  private static final int START_LOCAL_RECORDING_FAILED = -1;
  private static final int STATE_INTERVAL = 2000;
  private static final String TAG = "TRTCCloudImpl";
  private static TRTCCloudImpl sInstance;
  public int mAppScene;
  private int mAudioCaptureVolume;
  public TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
  private int mAudioPlayoutVolume;
  public int mAudioVolumeEvalInterval;
  private TRTCCloud.BGMNotify mBGMNotify;
  private int mBackground;
  private com.tencent.liteav.basic.c.a mCallback;
  public com.tencent.liteav.d mCaptureAndEnc;
  private int mCodecType;
  protected com.tencent.liteav.g mConfig;
  public Context mContext;
  private int mCurrentOrientation;
  public HashMap<Integer, TRTCCloudImpl> mCurrentPublishClouds;
  public int mCurrentRole;
  private int mCustomCaptureGLSyncMode;
  private final Object mCustomCaptureLock;
  private boolean mCustomRemoteRender;
  private TRTCCustomTextureUtil mCustomSubStreamVideoUtil;
  private TRTCCustomTextureUtil mCustomVideoUtil;
  protected int mDebugType;
  private TXDeviceManagerImpl mDeviceManager;
  private TXDeviceManagerImpl.TXDeviceManagerListener mDeviceManagerListener;
  private boolean mEnableCustomAudioCapture;
  private boolean mEnableCustomVideoCapture;
  protected boolean mEnableEosMode;
  private boolean mEnableSmallStream;
  private boolean mEnableSoftAEC;
  private boolean mEnableSoftAGC;
  private boolean mEnableSoftANS;
  private View mFloatingWindow;
  private int mFramework;
  private TRTCEncodeTypeDecision mH265Decision;
  private boolean mIsAudioCapturing;
  public boolean mIsExitOldRoom;
  private AtomicBoolean mIsSDKThreadAlive;
  private boolean mIsVideoCapturing;
  private boolean mKeepAVCaptureWhenEnterRoomFailed;
  private long mLastLogCustomCmdMsgTs;
  private long mLastLogSEIMsgTs;
  private long mLastSendMsgTimeMs;
  public long mLastStateTimeMs;
  private final Bundle mLatestParamsOfBigEncoder;
  private final Bundle mLatestParamsOfSmallEncoder;
  private Handler mListenerHandler;
  private com.tencent.liteav.basic.util.f mMainHandler;
  public Object mNativeLock;
  public long mNativeRtcContext;
  private int mNetType;
  private DisplayOrientationDetector mOrientationEventListener;
  private int mOriginalFramework;
  private boolean mOverrideFPSFromUser;
  public int mPerformanceMode;
  private int mPlayoutAudioTunnelId;
  public int mPriorStreamType;
  private int mPublishAudioTunnelId;
  private int mQosMode;
  private int mQosPreference;
  private long mRecvCustomCmdMsgCountInPeriod;
  public int mRecvMode;
  private long mRecvSEIMsgCountInPeriod;
  protected HashMap<String, RenderListenerAdapter> mRenderListenerMap;
  public TRTCRoomInfo mRoomInfo;
  public int mRoomState;
  public int mRoomType;
  public com.tencent.liteav.basic.util.f mSDKHandler;
  private int mSendMsgCount;
  private int mSendMsgSize;
  private int mSensorMode;
  private final TRTCCloudDef.TRTCVideoEncParam mSmallEncParam;
  private int mSoftAECLevel;
  private int mSoftAGCLevel;
  private int mSoftANSLevel;
  private StatusTask mStatusNotifyTask;
  private Set<Integer> mStreamTypes;
  public ArrayList<WeakReference<TRTCCloudImpl>> mSubClouds;
  protected com.tencent.liteav.d mSubStreamCaptureAndEnc;
  private Surface mSurfaceFromTextureView;
  public TRTCCloudListener mTRTCListener;
  public int mTargetRole;
  private final TextureView.SurfaceTextureListener mTextureViewListener;
  private final TRTCVideoPreprocessListenerAdapter mVideoPreprocessListenerAdapter;
  private int mVideoRenderMirror;
  private TRTCVideoServerConfig mVideoServerConfig;
  private VideoSourceType mVideoSourceType;
  private VolumeLevelNotifyTask mVolumeLevelNotifyTask;
  final TXAudioEffectManager.TXVoiceReverbType[] reverbTypes;
  final TXAudioEffectManager.TXVoiceChangerType[] voiceChangerTypes;
  
  static
  {
    AppMethodBeat.i(16059);
    sInstance = null;
    com.tencent.liteav.basic.util.h.d();
    AppMethodBeat.o(16059);
  }
  
  protected TRTCCloudImpl(Context paramContext)
  {
    AppMethodBeat.i(15781);
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
    this.mCustomCaptureLock = new Object();
    this.mCustomSubStreamVideoUtil = null;
    this.mPublishAudioTunnelId = -1;
    this.mPlayoutAudioTunnelId = -1;
    this.mPriorStreamType = 2;
    this.mEnableSmallStream = false;
    this.mVideoRenderMirror = 0;
    this.mCustomRemoteRender = false;
    this.mAudioVolumeEvalInterval = 0;
    this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    this.mQosMode = 1;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mSoftAECLevel = 100;
    this.mSoftANSLevel = 100;
    this.mSoftAGCLevel = 100;
    this.mAudioCaptureVolume = 100;
    this.mAudioPlayoutVolume = 100;
    this.mCustomVideoUtil = null;
    this.mCustomCaptureGLSyncMode = 0;
    this.mEnableCustomAudioCapture = false;
    this.mEnableCustomVideoCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mVideoPreprocessListenerAdapter = new TRTCVideoPreprocessListenerAdapter();
    this.mPerformanceMode = 0;
    this.mRoomType = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mOriginalFramework = 1;
    this.mTextureViewListener = new TextureView.SurfaceTextureListener()
    {
      public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(230660);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceCreated ".concat(String.valueOf(paramAnonymousSurfaceTexture)));
        TRTCCloudImpl.access$002(TRTCCloudImpl.this, new Surface(paramAnonymousSurfaceTexture));
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mSurfaceFromTextureView);
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(230660);
      }
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(230667);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceDestroyed %s", new Object[] { paramAnonymousSurfaceTexture });
        TRTCCloudImpl.this.mCaptureAndEnc.a(null);
        if (TRTCCloudImpl.this.mSurfaceFromTextureView != null)
        {
          TRTCCloudImpl.this.mSurfaceFromTextureView.release();
          TRTCCloudImpl.access$002(TRTCCloudImpl.this, null);
        }
        AppMethodBeat.o(230667);
        return true;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(230664);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceChanged %s width: %d, height: %d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(230664);
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    this.mKeepAVCaptureWhenEnterRoomFailed = false;
    this.mCallback = new com.tencent.liteav.basic.c.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230672);
        Bundle localBundle;
        StringBuilder localStringBuilder;
        if (TRTCCloudImpl.this.mTRTCListener != null)
        {
          localBundle = new Bundle();
          localBundle.putString("EVT_USERID", paramAnonymousString1);
          localBundle.putInt("EVT_ID", paramAnonymousInt);
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          if (paramAnonymousString2 != null)
          {
            localStringBuilder = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label221;
            }
          }
        }
        label221:
        for (String str = paramAnonymousString3;; str = "")
        {
          localBundle.putCharSequence("EVT_MSG", str);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(3, paramAnonymousInt, "onError => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
          if ((paramAnonymousInt == -1302) || (paramAnonymousInt == -1317) || (paramAnonymousInt == -1318) || (paramAnonymousInt == -1319))
          {
            TXCKeyPointReportProxy.b(30002, paramAnonymousInt);
            if (paramAnonymousInt == -1317) {
              TXCEventRecorderProxy.a("18446744073709551615", 2002, 4L, -1L, "", 0);
            }
          }
          AppMethodBeat.o(230672);
          return;
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230656);
        onEventInternal(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3);
        Monitor.a(2, paramAnonymousInt, "onEvent => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
        if (paramAnonymousInt == 2027) {
          TXCKeyPointReportProxy.b(30002, 0);
        }
        AppMethodBeat.o(230656);
      }
      
      void onEventInternal(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230661);
        Bundle localBundle;
        if (TRTCCloudImpl.this.mTRTCListener != null)
        {
          localBundle = new Bundle();
          localBundle.putString("EVT_USERID", paramAnonymousString1);
          localBundle.putInt("EVT_ID", paramAnonymousInt);
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          if (paramAnonymousString2 != null)
          {
            paramAnonymousString1 = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label103;
            }
          }
        }
        for (;;)
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString3);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          AppMethodBeat.o(230661);
          return;
          label103:
          paramAnonymousString3 = "";
        }
      }
      
      public void onWarning(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230665);
        onEventInternal(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3);
        Monitor.a(4, paramAnonymousInt, "onWarning => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
        AppMethodBeat.o(230665);
      }
    };
    this.mDeviceManagerListener = new TXDeviceManagerImpl.TXDeviceManagerListener()
    {
      public void onSwitchAutoFocus(boolean paramAnonymousBoolean)
      {
        com.tencent.liteav.g localg = TRTCCloudImpl.this.mConfig;
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          localg.L = paramAnonymousBoolean;
          return;
        }
      }
      
      public void onSwitchCamera(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(230651);
        TRTCCloudImpl.this.mConfig.n = paramAnonymousBoolean;
        TRTCCloudImpl.access$100(TRTCCloudImpl.this);
        AppMethodBeat.o(230651);
      }
      
      public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramAnonymousTXSystemVolumeType)
      {
        AppMethodBeat.i(230657);
        switch (TRTCCloudImpl.199.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[paramAnonymousTXSystemVolumeType.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 0;
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 2;
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 1;
        }
      }
    };
    this.mSubClouds = new ArrayList();
    this.mCurrentPublishClouds = new HashMap();
    this.mVolumeLevelNotifyTask = null;
    this.mDebugType = 0;
    this.mStatusNotifyTask = null;
    this.mNetType = -1;
    this.mBackground = -1;
    init(paramContext, null);
    TXCCommonUtil.setAppContext(this.mContext);
    TXCLog.init();
    TRTCAudioServerConfig localTRTCAudioServerConfig = TRTCAudioServerConfig.loadFromSharedPreferences(paramContext);
    TXCLog.i("TRTCCloudImpl", "audio config from shared preference: %s", new Object[] { localTRTCAudioServerConfig });
    Object localObject = TXCAudioEngine.buildTRAEConfig(paramContext, Boolean.valueOf(localTRTCAudioServerConfig.enableOpenSL), localTRTCAudioServerConfig.isLowLatencySampleRateSupported, localTRTCAudioServerConfig.lowLatencySampleRateBlockTime);
    TXCAudioEngine.CreateInstanceWithoutInitDevice(this.mContext, (String)localObject);
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.mCallback));
    TXCAudioEngine.getInstance().enableAutoRestartDevice(localTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(localTRTCAudioServerConfig.maxSelectedPlayStreams);
    localObject = TXCAudioEngine.getInstance();
    if (localTRTCAudioServerConfig.enableInbandFEC != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((TXCAudioEngine)localObject).enableInbandFEC(bool1);
      localObject = TXCAudioEngine.getInstance();
      bool1 = bool2;
      if (localTRTCAudioServerConfig.enableDeviceAbnormalDetection != 0) {
        bool1 = true;
      }
      ((TXCAudioEngine)localObject).enableDeviceAbnormalDetection(bool1);
      TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(true);
      this.mCaptureAndEnc = new com.tencent.liteav.d(paramContext);
      this.mCaptureAndEnc.j(2);
      this.mCaptureAndEnc.a(this.mConfig);
      this.mCaptureAndEnc.j(true);
      this.mCaptureAndEnc.h(true);
      this.mCaptureAndEnc.a(this);
      this.mCaptureAndEnc.a(this);
      this.mCaptureAndEnc.setID("18446744073709551615");
      this.mCaptureAndEnc.i(true);
      this.mDeviceManager.setCaptureAndEnc(this.mCaptureAndEnc);
      this.mDeviceManager.setDeviceManagerListener(this.mDeviceManagerListener);
      TXCKeyPointReportProxy.a(this.mContext);
      apiLog("reset audio volume");
      setAudioCaptureVolume(100);
      setAudioPlayoutVolume(100);
      TXCSoundEffectPlayer.getInstance().setSoundEffectListener(this);
      this.mH265Decision = new TRTCEncodeTypeDecision(this);
      AppMethodBeat.o(15781);
      return;
    }
  }
  
  protected TRTCCloudImpl(Context paramContext, com.tencent.liteav.basic.util.f paramf)
  {
    AppMethodBeat.i(230716);
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
    this.mCustomCaptureLock = new Object();
    this.mCustomSubStreamVideoUtil = null;
    this.mPublishAudioTunnelId = -1;
    this.mPlayoutAudioTunnelId = -1;
    this.mPriorStreamType = 2;
    this.mEnableSmallStream = false;
    this.mVideoRenderMirror = 0;
    this.mCustomRemoteRender = false;
    this.mAudioVolumeEvalInterval = 0;
    this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    this.mQosMode = 1;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mSoftAECLevel = 100;
    this.mSoftANSLevel = 100;
    this.mSoftAGCLevel = 100;
    this.mAudioCaptureVolume = 100;
    this.mAudioPlayoutVolume = 100;
    this.mCustomVideoUtil = null;
    this.mCustomCaptureGLSyncMode = 0;
    this.mEnableCustomAudioCapture = false;
    this.mEnableCustomVideoCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mVideoPreprocessListenerAdapter = new TRTCVideoPreprocessListenerAdapter();
    this.mPerformanceMode = 0;
    this.mRoomType = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mOriginalFramework = 1;
    this.mTextureViewListener = new TextureView.SurfaceTextureListener()
    {
      public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(230660);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceCreated ".concat(String.valueOf(paramAnonymousSurfaceTexture)));
        TRTCCloudImpl.access$002(TRTCCloudImpl.this, new Surface(paramAnonymousSurfaceTexture));
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mSurfaceFromTextureView);
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(230660);
      }
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(230667);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceDestroyed %s", new Object[] { paramAnonymousSurfaceTexture });
        TRTCCloudImpl.this.mCaptureAndEnc.a(null);
        if (TRTCCloudImpl.this.mSurfaceFromTextureView != null)
        {
          TRTCCloudImpl.this.mSurfaceFromTextureView.release();
          TRTCCloudImpl.access$002(TRTCCloudImpl.this, null);
        }
        AppMethodBeat.o(230667);
        return true;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(230664);
        TRTCCloudImpl.this.apiLog("startLocalPreview surfaceChanged %s width: %d, height: %d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(230664);
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    this.mKeepAVCaptureWhenEnterRoomFailed = false;
    this.mCallback = new com.tencent.liteav.basic.c.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230672);
        Bundle localBundle;
        StringBuilder localStringBuilder;
        if (TRTCCloudImpl.this.mTRTCListener != null)
        {
          localBundle = new Bundle();
          localBundle.putString("EVT_USERID", paramAnonymousString1);
          localBundle.putInt("EVT_ID", paramAnonymousInt);
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          if (paramAnonymousString2 != null)
          {
            localStringBuilder = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label221;
            }
          }
        }
        label221:
        for (String str = paramAnonymousString3;; str = "")
        {
          localBundle.putCharSequence("EVT_MSG", str);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(3, paramAnonymousInt, "onError => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
          if ((paramAnonymousInt == -1302) || (paramAnonymousInt == -1317) || (paramAnonymousInt == -1318) || (paramAnonymousInt == -1319))
          {
            TXCKeyPointReportProxy.b(30002, paramAnonymousInt);
            if (paramAnonymousInt == -1317) {
              TXCEventRecorderProxy.a("18446744073709551615", 2002, 4L, -1L, "", 0);
            }
          }
          AppMethodBeat.o(230672);
          return;
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230656);
        onEventInternal(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3);
        Monitor.a(2, paramAnonymousInt, "onEvent => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
        if (paramAnonymousInt == 2027) {
          TXCKeyPointReportProxy.b(30002, 0);
        }
        AppMethodBeat.o(230656);
      }
      
      void onEventInternal(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230661);
        Bundle localBundle;
        if (TRTCCloudImpl.this.mTRTCListener != null)
        {
          localBundle = new Bundle();
          localBundle.putString("EVT_USERID", paramAnonymousString1);
          localBundle.putInt("EVT_ID", paramAnonymousInt);
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          if (paramAnonymousString2 != null)
          {
            paramAnonymousString1 = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label103;
            }
          }
        }
        for (;;)
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString3);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          AppMethodBeat.o(230661);
          return;
          label103:
          paramAnonymousString3 = "";
        }
      }
      
      public void onWarning(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(230665);
        onEventInternal(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3);
        Monitor.a(4, paramAnonymousInt, "onWarning => msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3 + " code:" + paramAnonymousInt + " id:" + paramAnonymousString1, "", 0, 0);
        AppMethodBeat.o(230665);
      }
    };
    this.mDeviceManagerListener = new TXDeviceManagerImpl.TXDeviceManagerListener()
    {
      public void onSwitchAutoFocus(boolean paramAnonymousBoolean)
      {
        com.tencent.liteav.g localg = TRTCCloudImpl.this.mConfig;
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          localg.L = paramAnonymousBoolean;
          return;
        }
      }
      
      public void onSwitchCamera(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(230651);
        TRTCCloudImpl.this.mConfig.n = paramAnonymousBoolean;
        TRTCCloudImpl.access$100(TRTCCloudImpl.this);
        AppMethodBeat.o(230651);
      }
      
      public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramAnonymousTXSystemVolumeType)
      {
        AppMethodBeat.i(230657);
        switch (TRTCCloudImpl.199.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[paramAnonymousTXSystemVolumeType.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 0;
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 2;
          AppMethodBeat.o(230657);
          return;
          TRTCCloudImpl.this.mConfig.y = 1;
        }
      }
    };
    this.mSubClouds = new ArrayList();
    this.mCurrentPublishClouds = new HashMap();
    this.mVolumeLevelNotifyTask = null;
    this.mDebugType = 0;
    this.mStatusNotifyTask = null;
    this.mNetType = -1;
    this.mBackground = -1;
    init(paramContext, paramf);
    this.mCurrentRole = 21;
    this.mTargetRole = 21;
    this.mH265Decision = new TRTCEncodeTypeDecision(this);
    AppMethodBeat.o(230716);
  }
  
  private int GetPublishingCloudState(int paramInt)
  {
    AppMethodBeat.i(230921);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null)
    {
      paramInt = localTRTCCloudImpl.mRoomState;
      AppMethodBeat.o(230921);
      return paramInt;
    }
    AppMethodBeat.o(230921);
    return 0;
  }
  
  private void addRemoteStatistics(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo, TRTCStatistics paramTRTCStatistics, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(15981);
    paramTXCRenderAndDec = getRemoteStatistics(paramTXCRenderAndDec, paramUserInfo);
    paramTRTCStatistics.remoteArray.add(paramTXCRenderAndDec);
    paramTRTCStatistics.downLoss = TXCStatus.c(String.valueOf(paramUserInfo.tinyID), 16002);
    TRTCCloudDef.TRTCQuality localTRTCQuality = new TRTCCloudDef.TRTCQuality();
    localTRTCQuality.userId = paramUserInfo.userID;
    localTRTCQuality.quality = getNetworkQuality(paramTRTCStatistics.rtt, paramTXCRenderAndDec.finalLoss);
    paramArrayList.add(localTRTCQuality);
    AppMethodBeat.o(15981);
  }
  
  private void addUpStreamType(int paramInt)
  {
    AppMethodBeat.i(230926);
    if (!this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.add(Integer.valueOf(paramInt));
    }
    addUpstream(paramInt);
    AppMethodBeat.o(230926);
  }
  
  private void addUpstream(int paramInt)
  {
    AppMethodBeat.i(230931);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeAddUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
    AppMethodBeat.o(230931);
  }
  
  private void appendDashboardLog(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(15967);
    appendDashboardLog(paramString1, paramInt, paramString2, "");
    AppMethodBeat.o(15967);
  }
  
  private void appendDashboardLog(final String paramString1, int paramInt, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(15968);
    apiLog(paramString3 + paramString2);
    paramString3 = null;
    if ((TextUtils.isEmpty(paramString1)) || ((this.mRoomInfo.userId != null) && (paramString1.equalsIgnoreCase(this.mRoomInfo.userId)))) {
      paramString1 = this.mRoomInfo.localView;
    }
    for (;;)
    {
      runOnMainThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230775);
          if (paramString1 != null) {
            paramString1.appendEventInfo(paramString2);
          }
          AppMethodBeat.o(230775);
        }
      });
      AppMethodBeat.o(15968);
      return;
      TRTCRoomInfo.UserInfo localUserInfo = this.mRoomInfo.getUser(paramString1);
      paramString1 = paramString3;
      if (localUserInfo != null) {
        if (paramInt == 7) {
          paramString1 = localUserInfo.subRender.view;
        } else {
          paramString1 = localUserInfo.mainRender.view;
        }
      }
    }
  }
  
  private void applyRenderConfig(TXCRenderAndDec paramTXCRenderAndDec)
  {
    AppMethodBeat.i(15963);
    com.tencent.liteav.h localh = new com.tencent.liteav.h();
    localh.h = false;
    if (this.mAppScene == 1) {
      localh.h = true;
    }
    int j = TXCStatus.c("18446744073709551615", 17020);
    int i = j;
    if (j == 0) {
      i = 600;
    }
    localh.d = i;
    localh.r = this.mRoomInfo.decProperties;
    applyRenderPlayStrategy(paramTXCRenderAndDec, localh);
    AppMethodBeat.o(15963);
  }
  
  private void applyRenderPlayStrategy(TXCRenderAndDec paramTXCRenderAndDec, com.tencent.liteav.h paramh)
  {
    AppMethodBeat.i(230923);
    paramh.g = true;
    if (this.mCurrentRole == 20)
    {
      paramh.a = com.tencent.liteav.basic.b.a.a;
      paramh.c = com.tencent.liteav.basic.b.a.b;
      paramh.b = com.tencent.liteav.basic.b.a.c;
    }
    for (;;)
    {
      paramTXCRenderAndDec.setConfig(paramh);
      AppMethodBeat.o(230923);
      return;
      if (this.mCurrentRole == 21)
      {
        paramh.a = com.tencent.liteav.basic.b.a.d;
        paramh.c = com.tencent.liteav.basic.b.a.e;
        paramh.b = com.tencent.liteav.basic.b.a.f;
      }
    }
  }
  
  private void checkRTCState()
  {
    AppMethodBeat.i(15982);
    long l = System.currentTimeMillis();
    if (l < this.mLastStateTimeMs + 2000L)
    {
      AppMethodBeat.o(15982);
      return;
    }
    this.mLastStateTimeMs = l;
    Object localObject = com.tencent.liteav.basic.util.h.a();
    final ArrayList localArrayList = new ArrayList();
    final TRTCStatistics localTRTCStatistics = new TRTCStatistics();
    localTRTCStatistics.appCpu = (localObject[0] / 10);
    localTRTCStatistics.systemCpu = (localObject[1] / 10);
    localTRTCStatistics.rtt = TXCStatus.c("18446744073709551615", 12002);
    localTRTCStatistics.sendBytes = TXCStatus.a("18446744073709551615", 12004);
    localTRTCStatistics.receiveBytes = TXCStatus.a("18446744073709551615", 16004);
    localTRTCStatistics.upLoss = TXCStatus.c("18446744073709551615", 12003);
    localTRTCStatistics.localArray = new ArrayList();
    localTRTCStatistics.remoteArray = new ArrayList();
    localObject = getLocalStatistics(2);
    localTRTCStatistics.localArray.add(localObject);
    if (this.mEnableSmallStream)
    {
      localObject = getLocalStatistics(3);
      localTRTCStatistics.localArray.add(localObject);
    }
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(230809);
        if (paramAnonymousUserInfo.mainRender.render != null) {
          TRTCCloudImpl.access$10900(TRTCCloudImpl.this, paramAnonymousUserInfo.mainRender.render, paramAnonymousUserInfo, localTRTCStatistics, localArrayList);
        }
        if ((paramAnonymousUserInfo.subRender.render != null) && (paramAnonymousUserInfo.subRender.render.isRendering())) {
          TRTCCloudImpl.access$10900(TRTCCloudImpl.this, paramAnonymousUserInfo.subRender.render, paramAnonymousUserInfo, localTRTCStatistics, localArrayList);
        }
        AppMethodBeat.o(230809);
      }
    });
    localObject = new TRTCCloudDef.TRTCQuality();
    ((TRTCCloudDef.TRTCQuality)localObject).userId = this.mRoomInfo.getUserId();
    ((TRTCCloudDef.TRTCQuality)localObject).quality = TXCStatus.c("18446744073709551615", 12005);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230749);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null)
        {
          localTRTCCloudListener.onStatistics(localTRTCStatistics);
          localTRTCCloudListener.onNetworkQuality(this.val$localQuality, localArrayList);
        }
        AppMethodBeat.o(230749);
      }
    });
    AppMethodBeat.o(15982);
  }
  
  private void checkRenderRotation(int paramInt)
  {
    AppMethodBeat.i(15989);
    int k = getDisplayRotation();
    int j = (360 - k - (this.mConfig.m - 1) * 90) % 360;
    int i;
    if (((paramInt % 2 == k % 2) && (this.mConfig.m == 1)) || ((paramInt % 2 != k % 2) && (this.mConfig.m == 0)))
    {
      i = 1;
      if (this.mVideoRenderMirror != 1) {
        break label231;
      }
      if ((this.mConfig.n) || (i == 0)) {
        break label262;
      }
      i = j + 180;
    }
    label262:
    for (;;)
    {
      TXCLog.d("TRTCCloudImpl", String.format("vrotation rotation-change %d-%d-%d ======= renderRotation %d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.mRoomInfo.localRenderRotation) }) + " self:" + hashCode());
      paramInt = this.mRoomInfo.localRenderRotation;
      this.mCaptureAndEnc.g((i + paramInt) % 360);
      AppMethodBeat.o(15989);
      return;
      i = 0;
      break;
      label231:
      if ((this.mVideoRenderMirror == 2) && (this.mConfig.n) && (i != 0)) {
        i = j + 180;
      } else {
        i = j;
      }
    }
  }
  
  private void checkVideoEncRotation(int paramInt)
  {
    AppMethodBeat.i(15990);
    int i;
    if (this.mConfig.m != 1) {
      if (((this.mConfig.T) && (this.mConfig.n)) || ((!this.mConfig.T) && (!this.mConfig.n))) {
        i = 90;
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        TXCLog.d("TRTCCloudImpl", String.format("vrotation rotation-change %d-%d ======= encRotation %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.m), Integer.valueOf(i) }) + " self:" + hashCode());
        this.mCurrentOrientation = paramInt;
        this.mCaptureAndEnc.a(i);
        AppMethodBeat.o(15990);
        return;
        i = 270;
        break;
        i = (i + 0) % 360;
        continue;
        i = (i + 90) % 360;
        int j = i;
        if (!this.mConfig.n) {
          j = (i + 180) % 360;
        }
        i = j;
        if (this.mConfig.T)
        {
          i = (j + 180) % 360;
          continue;
          i = (i + 180) % 360;
          continue;
          i = (i + 270) % 360;
          j = i;
          if (!this.mConfig.n) {
            j = (i + 180) % 360;
          }
          i = j;
          if (this.mConfig.T) {
            i = (j + 180) % 360;
          }
        }
      }
      i = 0;
    }
  }
  
  private void collectCustomCaptureFps()
  {
    AppMethodBeat.i(15975);
    TRTCCustomTextureUtil localTRTCCustomTextureUtil = this.mCustomVideoUtil;
    if (localTRTCCustomTextureUtil != null) {
      TXCStatus.a("18446744073709551615", 1001, 2, Double.valueOf(localTRTCCustomTextureUtil.getCurrentFPS()));
    }
    localTRTCCustomTextureUtil = this.mCustomSubStreamVideoUtil;
    if (localTRTCCustomTextureUtil != null) {
      TXCStatus.a("18446744073709551615", 1001, 7, Double.valueOf(localTRTCCustomTextureUtil.getCurrentFPS()));
    }
    AppMethodBeat.o(15975);
  }
  
  private static TRTCAudioServerConfig createAudioServerConfigFromNative()
  {
    AppMethodBeat.i(230915);
    TRTCAudioServerConfig localTRTCAudioServerConfig = new TRTCAudioServerConfig();
    AppMethodBeat.o(230915);
    return localTRTCAudioServerConfig;
  }
  
  private com.tencent.liteav.d createCaptureAndEnc(int paramInt)
  {
    AppMethodBeat.i(230748);
    com.tencent.liteav.d locald = new com.tencent.liteav.d(this.mContext);
    locald.j(paramInt);
    locald.a(this.mConfig);
    locald.j(true);
    locald.h(true);
    locald.a(this);
    locald.a(this);
    locald.setID("18446744073709551615");
    locald.i(true);
    AppMethodBeat.o(230748);
    return locald;
  }
  
  private TXCRenderAndDec createRender(long paramLong, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(15921);
    TXCRenderAndDec localTXCRenderAndDec = new TXCRenderAndDec(this.mContext);
    localTXCRenderAndDec.setID(String.valueOf(paramLong));
    localTXCRenderAndDec.setVideoRender(new com.tencent.liteav.renderer.a());
    localTXCRenderAndDec.setStreamType(paramInt);
    localTXCRenderAndDec.setNotifyListener(this);
    localTXCRenderAndDec.setRenderAndDecDelegate(this);
    localTXCRenderAndDec.setRenderMode(0);
    if (this.mPerformanceMode != 1) {}
    for (;;)
    {
      localTXCRenderAndDec.enableDecoderChange(bool);
      localTXCRenderAndDec.enableRestartDecoder(this.mRoomInfo.enableRestartDecoder);
      localTXCRenderAndDec.enableLimitDecCache(this.mVideoServerConfig.enableHWVUI);
      applyRenderConfig(localTXCRenderAndDec);
      AppMethodBeat.o(15921);
      return localTXCRenderAndDec;
      bool = false;
    }
  }
  
  private TRTCRoomInfo.UserInfo createUserInfo(String paramString)
  {
    AppMethodBeat.i(15972);
    paramString = new TRTCRoomInfo.UserInfo(0L, paramString, 0, 0);
    paramString.mainRender.muteVideo = this.mRoomInfo.muteRemoteVideo;
    paramString.mainRender.muteAudio = this.mRoomInfo.muteRemoteAudio;
    AppMethodBeat.o(15972);
    return paramString;
  }
  
  private static TRTCVideoServerConfig createVideoServerConfigFromNative()
  {
    AppMethodBeat.i(230910);
    TRTCVideoServerConfig localTRTCVideoServerConfig = new TRTCVideoServerConfig();
    AppMethodBeat.o(230910);
    return localTRTCVideoServerConfig;
  }
  
  public static void destroySharedInstance()
  {
    AppMethodBeat.i(15780);
    try
    {
      if (sInstance != null)
      {
        TXCLog.i("TRTCCloudImpl", "trtc_api destroy instance self:" + sInstance.hashCode());
        sInstance.destroy();
        sInstance = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(15780);
    }
  }
  
  private void disconnectOtherRoom(String paramString)
  {
    AppMethodBeat.i(230725);
    apiOnlineLog("DisconnectOtherRoom");
    nativeDisconnectOtherRoom(this.mNativeRtcContext, paramString);
    AppMethodBeat.o(230725);
  }
  
  private void enableAudioAEC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15863);
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable")))
    {
      apiLog("enableAudioAEC[lack parameter or illegal type]: enable");
      AppMethodBeat.o(15863);
      return;
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftAEC = false;
      if (!paramJSONObject.has("level")) {
        break label99;
      }
    }
    label99:
    for (this.mSoftAECLevel = paramJSONObject.getInt("level");; this.mSoftAECLevel = 100)
    {
      TXCAudioEngine.getInstance().enableSoftAEC(this.mEnableSoftAEC, this.mSoftAECLevel);
      AppMethodBeat.o(15863);
      return;
      this.mEnableSoftAEC = true;
      break;
    }
  }
  
  private void enableAudioAGC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15862);
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable")))
    {
      apiLog("enableAudioAGC[lack parameter or illegal type]: enable");
      AppMethodBeat.o(15862);
      return;
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftAGC = false;
      if (!paramJSONObject.has("level")) {
        break label99;
      }
    }
    label99:
    for (this.mSoftAGCLevel = paramJSONObject.getInt("level");; this.mSoftAGCLevel = 100)
    {
      TXCAudioEngine.getInstance().enableSoftAGC(this.mEnableSoftAGC, this.mSoftAGCLevel);
      AppMethodBeat.o(15862);
      return;
      this.mEnableSoftAGC = true;
      break;
    }
  }
  
  private void enableAudioANS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15864);
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable")))
    {
      apiLog("enableAudioANS[lack parameter or illegal type]: enable");
      AppMethodBeat.o(15864);
      return;
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftANS = false;
      if (!paramJSONObject.has("level")) {
        break label99;
      }
    }
    label99:
    for (this.mSoftANSLevel = paramJSONObject.getInt("level");; this.mSoftANSLevel = 100)
    {
      TXCAudioEngine.getInstance().enableSoftANS(this.mEnableSoftANS, this.mSoftANSLevel);
      AppMethodBeat.o(15864);
      return;
      this.mEnableSoftANS = true;
      break;
    }
  }
  
  private void enableBlackStream(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230754);
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable")))
    {
      apiLog("callExperimentalAPI[lack parameter or illegal type]: enable");
      AppMethodBeat.o(230754);
      return;
    }
    boolean bool = paramJSONObject.getBoolean("enable");
    apiLog("enableBlackStream ".concat(String.valueOf(bool)));
    enableNetworkBlackStream(bool);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.c(bool);
    }
    if (bool) {
      addUpstream(2);
    }
    AppMethodBeat.o(230754);
  }
  
  private void forceCallbackMixedPlayAudioFrame(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(230782);
    if (paramJSONObject == null)
    {
      apiLog("forceCallbackMixedPlayAudioFrame param is null");
      AppMethodBeat.o(230782);
      return;
    }
    if (!paramJSONObject.has("enable"))
    {
      apiLog("forceCallbackMixedPlayAudioFrame[lack parameter]: enable");
      AppMethodBeat.o(230782);
      return;
    }
    int i = paramJSONObject.optInt("enable", 0);
    paramJSONObject = TXCAudioEngine.getInstance();
    if (i != 0) {
      bool = true;
    }
    paramJSONObject.forceCallbackMixedPlayAudioFrame(bool);
    AppMethodBeat.o(230782);
  }
  
  private int getDisplayRotation()
  {
    int j = 0;
    AppMethodBeat.i(15987);
    int i = j;
    switch (com.tencent.liteav.basic.util.h.g(this.mContext))
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(15987);
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  private CharSequence getDownloadStreamInfo(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(15986);
    String str = String.valueOf(paramUserInfo.tinyID);
    int[] arrayOfInt = com.tencent.liteav.basic.util.h.a();
    int i = paramTXCRenderAndDec.getStreamType();
    long l = TXCStatus.a(str, 17014, i);
    int j = TXCStatus.c(str, 5003, i);
    if (i == 3) {
      paramTXCRenderAndDec = "S";
    }
    for (;;)
    {
      paramTXCRenderAndDec = String.format("REMOTE: [%s]%s RTT:%dms\n", new Object[] { paramUserInfo.userID, paramTXCRenderAndDec, Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }) + String.format(Locale.CHINA, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17001, i) + TXCStatus.c(str, 18001)), Integer.valueOf(TXCStatus.c(str, 17010, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17011, i)), Integer.valueOf(TXCStatus.c(str, 18013)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18014)), Integer.valueOf(TXCStatus.c(str, 16002)) }) + String.format(Locale.CHINA, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17002, i)), Integer.valueOf(TXCStatus.c(str, 18002)), Integer.valueOf(j >> 16), Integer.valueOf(j & 0xFFFF), Integer.valueOf((int)TXCStatus.d(str, 6002, i)), Integer.valueOf((int)TXCStatus.d(str, 17003, i)) }) + String.format(Locale.CHINA, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17007, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17006, i)), Integer.valueOf(TXCStatus.c(str, 18009)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18008)), Integer.valueOf(TXCStatus.c(str, 17009, i)), Integer.valueOf(TXCStatus.c(str, 17008, i)), Integer.valueOf(TXCStatus.c(str, 18012)), Integer.valueOf(TXCStatus.c(str, 18010)) }) + String.format(Locale.CHINA, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", new Object[] { Integer.valueOf(arrayOfInt[0] / 10), Integer.valueOf(arrayOfInt[1] / 10), Integer.valueOf(TXCStatus.c(str, 17012, i)), Integer.valueOf(TXCStatus.c(str, 17013, i)), Long.valueOf(l) }) + String.format(Locale.CHINA, "Jitter: %d,%d|%d,%d|%d  p2pDelay: %d  ADROP: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 2007)), Integer.valueOf(TXCStatus.c(str, 6104, i)), Integer.valueOf(TXCStatus.c(str, 6105, i)), Integer.valueOf(TXCStatus.c(str, 6106, i)), Integer.valueOf(TXCStatus.c(str, 2021)), Integer.valueOf(TXCStatus.c(str, 18042)), Integer.valueOf(TXCStatus.c(str, 18015)) }) + String.format(Locale.CHINA, "QUALITY: %d   LEN: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 18023)), Integer.valueOf(TXCStatus.c(str, 18016)) });
      paramUserInfo = new SpannableString(paramTXCRenderAndDec);
      i = paramTXCRenderAndDec.lastIndexOf("DECERR:");
      if ((-1 != i) && (l > 0L)) {
        paramUserInfo.setSpan(new ForegroundColorSpan(-65536), i + 7, paramTXCRenderAndDec.length(), 33);
      }
      AppMethodBeat.o(15986);
      return paramUserInfo;
      if (i == 7) {
        paramTXCRenderAndDec = "Sub";
      } else if (i == 1) {
        paramTXCRenderAndDec = "A";
      } else {
        paramTXCRenderAndDec = "B";
      }
    }
  }
  
  private Pair<Integer, String> getEncoderTypeAndMsg(Bundle paramBundle)
  {
    AppMethodBeat.i(230924);
    String str = "";
    int j = paramBundle.getInt("EVT_PARAM1", 0);
    int i;
    if ((j == b.a.a.a()) || (j == b.a.b.a()))
    {
      paramBundle = String.format(Locale.getDefault(), "Current encode type is %s encoder", new Object[] { "H264" });
      i = 0;
    }
    for (;;)
    {
      paramBundle = new Pair(Integer.valueOf(i), paramBundle);
      AppMethodBeat.o(230924);
      return paramBundle;
      if (j != b.a.c.a())
      {
        paramBundle = str;
        i = j;
        if (j != b.a.d.a()) {}
      }
      else
      {
        paramBundle = String.format(Locale.getDefault(), "Current encode type is %s encoder", new Object[] { "H265" });
        i = 1;
      }
    }
  }
  
  private TRTCStatistics.TRTCLocalStatistics getLocalStatistics(int paramInt)
  {
    AppMethodBeat.i(15980);
    int i = TXCStatus.c("18446744073709551615", 4003, paramInt);
    TRTCStatistics.TRTCLocalStatistics localTRTCLocalStatistics = new TRTCStatistics.TRTCLocalStatistics();
    localTRTCLocalStatistics.width = (i >> 16);
    localTRTCLocalStatistics.height = (i & 0xFFFF);
    localTRTCLocalStatistics.frameRate = ((int)(TXCStatus.d("18446744073709551615", 4001, paramInt) + 0.5D));
    localTRTCLocalStatistics.videoBitrate = TXCStatus.c("18446744073709551615", 13002, paramInt);
    localTRTCLocalStatistics.audioSampleRate = TXCStatus.c("18446744073709551615", 14003);
    localTRTCLocalStatistics.audioBitrate = TXCStatus.c("18446744073709551615", 14002);
    localTRTCLocalStatistics.streamType = translateStreamType(paramInt);
    localTRTCLocalStatistics.audioCaptureState = translateAudioAbnormalDetectState(TXCStatus.c("18446744073709551615", 14032));
    AppMethodBeat.o(15980);
    return localTRTCLocalStatistics;
  }
  
  private com.tencent.liteav.basic.b.b getPixelFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return com.tencent.liteav.basic.b.b.a;
    case 1: 
      return com.tencent.liteav.basic.b.b.b;
    case 2: 
      return com.tencent.liteav.basic.b.b.c;
    case 3: 
      return com.tencent.liteav.basic.b.b.d;
    case 4: 
      return com.tencent.liteav.basic.b.b.e;
    }
    return com.tencent.liteav.basic.b.b.f;
  }
  
  private String getQosValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ERR";
    case 0: 
      return "HOLD";
    case 1: 
      return "UP";
    }
    return "DOWN";
  }
  
  private TRTCStatistics.TRTCRemoteStatistics getRemoteStatistics(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(15979);
    String str = String.valueOf(paramUserInfo.tinyID);
    int k = paramTXCRenderAndDec.getStreamType();
    int m = TXCStatus.c(str, 5003, k);
    int i = TXCStatus.c(str, 17011, k);
    int j = TXCStatus.c(str, 18014);
    paramTXCRenderAndDec = new TRTCStatistics.TRTCRemoteStatistics();
    paramTXCRenderAndDec.userId = paramUserInfo.userID;
    if (j > i)
    {
      i = j;
      paramTXCRenderAndDec.finalLoss = i;
      paramTXCRenderAndDec.width = (m >> 16);
      paramTXCRenderAndDec.height = (0xFFFF & m);
      paramTXCRenderAndDec.frameRate = ((int)(TXCStatus.d(str, 6002, k) + 0.5D));
      paramTXCRenderAndDec.videoBitrate = TXCStatus.c(str, 17002, k);
      paramTXCRenderAndDec.audioSampleRate = TXCStatus.c(str, 18003);
      paramTXCRenderAndDec.audioBitrate = TXCStatus.c(str, 18002);
      paramTXCRenderAndDec.jitterBufferDelay = TXCStatus.c(str, 2007);
      paramTXCRenderAndDec.point2PointDelay = TXCStatus.c(str, 18042);
      paramTXCRenderAndDec.streamType = translateStreamType(k);
      paramTXCRenderAndDec.audioTotalBlockTime = TXCStatus.c(str, 18031);
      i = TXCStatus.c(str, 18030);
      if (i <= 0) {
        break label305;
      }
      i = (int)(paramTXCRenderAndDec.audioTotalBlockTime * 100.0D / i + 0.9D);
      label237:
      paramTXCRenderAndDec.audioBlockRate = i;
      paramTXCRenderAndDec.videoTotalBlockTime = TXCStatus.c(str, 6006, k);
      i = TXCStatus.c(str, 6012, k);
      if (i <= 0) {
        break label310;
      }
    }
    label305:
    label310:
    for (i = (int)(paramTXCRenderAndDec.videoTotalBlockTime * 100.0D / i + 0.9D);; i = 0)
    {
      paramTXCRenderAndDec.videoBlockRate = i;
      AppMethodBeat.o(15979);
      return paramTXCRenderAndDec;
      break;
      i = 0;
      break label237;
    }
  }
  
  private com.tencent.liteav.g.a getSizeByResolution(int paramInt1, int paramInt2)
  {
    int k = 640;
    int m = 368;
    AppMethodBeat.i(230925);
    int i = m;
    int j = k;
    com.tencent.liteav.g.a locala;
    switch (paramInt1)
    {
    default: 
      j = k;
      i = m;
    case 108: 
      locala = new com.tencent.liteav.g.a();
      if (paramInt2 == 1) {
        locala.a = i;
      }
      break;
    }
    for (locala.b = j;; locala.b = i)
    {
      AppMethodBeat.o(230925);
      return locala;
      i = 128;
      j = 128;
      break;
      i = 160;
      j = 160;
      break;
      i = 272;
      j = 272;
      break;
      i = 480;
      j = 480;
      break;
      i = 128;
      j = 176;
      break;
      i = 192;
      j = 256;
      break;
      i = 224;
      j = 288;
      break;
      i = 240;
      j = 320;
      break;
      i = 304;
      j = 400;
      break;
      j = 480;
      i = m;
      break;
      i = 480;
      j = k;
      break;
      i = 720;
      j = 960;
      break;
      i = 96;
      j = 176;
      break;
      i = 144;
      j = 256;
      break;
      i = 192;
      j = 336;
      break;
      i = 272;
      j = 480;
      break;
      i = 544;
      j = 960;
      break;
      i = 720;
      j = 1280;
      break;
      i = 1088;
      j = 1920;
      break;
      locala.a = j;
    }
  }
  
  private void hideFloatingWindow()
  {
    AppMethodBeat.i(230732);
    if (this.mFloatingWindow == null)
    {
      AppMethodBeat.o(230732);
      return;
    }
    ((WindowManager)this.mFloatingWindow.getContext().getSystemService("window")).removeViewImmediate(this.mFloatingWindow);
    this.mFloatingWindow = null;
    AppMethodBeat.o(230732);
  }
  
  private void identifyTRTCFrameworkType()
  {
    AppMethodBeat.i(230722);
    for (;;)
    {
      int i;
      String str;
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        i = 0;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        str = arrayOfStackTraceElement[i].getClassName();
        if (str.contains("TUIKitImpl"))
        {
          TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
          this.mFramework = 6;
          AppMethodBeat.o(230722);
          return;
        }
        if (str.contains("WXTRTCCloud"))
        {
          TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
          this.mFramework = 3;
          AppMethodBeat.o(230722);
          return;
        }
      }
      catch (Exception localException)
      {
        TXCLog.e("TRTCCloudImpl", "identifyTRTCFrameworkType catch exception:" + localException.getCause());
        AppMethodBeat.o(230722);
        return;
      }
      if (str.contains("TRTCCloudPlugin"))
      {
        TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
        this.mFramework = 7;
        AppMethodBeat.o(230722);
        return;
      }
      if ((str.contains("TRTCMeetingImpl")) || (str.contains("TRTCLiveRoomImpl")) || (str.contains("TRTCAudioCallImpl")) || (str.contains("TRTCVideoCallImpl")) || (str.contains("TRTCVoiceRoomImpl")) || (str.contains("TRTCAVCallImpl")))
      {
        TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
        this.mFramework = 5;
      }
      this.mOriginalFramework = this.mFramework;
      i += 1;
    }
    AppMethodBeat.o(230722);
  }
  
  private void init(Context paramContext, com.tencent.liteav.basic.util.f arg2)
  {
    AppMethodBeat.i(230720);
    this.mCurrentPublishClouds.put(Integer.valueOf(2), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(3), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(7), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(1), this);
    this.mContext = paramContext.getApplicationContext();
    this.mConfig = new com.tencent.liteav.g();
    this.mConfig.l = com.tencent.liteav.basic.b.c.e;
    this.mConfig.Y = 90;
    this.mConfig.k = 0;
    this.mConfig.Q = true;
    this.mConfig.i = 15;
    this.mConfig.L = false;
    this.mConfig.U = false;
    this.mConfig.V = false;
    this.mConfig.a = 368;
    this.mConfig.b = 640;
    this.mConfig.c = 750;
    this.mConfig.e = 0;
    this.mConfig.X = false;
    this.mRoomInfo = new TRTCRoomInfo();
    this.mRoomInfo.bigEncSize.a = 368;
    this.mRoomInfo.bigEncSize.b = 640;
    this.mMainHandler = new com.tencent.liteav.basic.util.f(paramContext.getMainLooper());
    this.mListenerHandler = new Handler(paramContext.getMainLooper());
    this.mIsSDKThreadAlive = new AtomicBoolean(true);
    if (??? != null) {
      this.mSDKHandler = ???;
    }
    for (;;)
    {
      this.mDeviceManager = new TXDeviceManagerImpl(this.mSDKHandler);
      this.mStatusNotifyTask = new StatusTask(this);
      this.mLastSendMsgTimeMs = 0L;
      this.mSendMsgCount = 0;
      this.mSendMsgSize = 0;
      this.mSensorMode = 2;
      this.mAppScene = 0;
      this.mQosPreference = 2;
      this.mQosMode = 1;
      this.mOrientationEventListener = new DisplayOrientationDetector(this.mContext, this);
      this.mRenderListenerMap = new HashMap();
      this.mStreamTypes = new HashSet();
      synchronized (this.mNativeLock)
      {
        int[] arrayOfInt = TXCCommonUtil.getSDKVersion();
        int i;
        if (arrayOfInt.length > 0)
        {
          i = arrayOfInt[0];
          label403:
          if (arrayOfInt.length < 2) {
            break label581;
          }
        }
        label581:
        for (int j = arrayOfInt[1];; j = 0)
        {
          if (arrayOfInt.length < 3) {
            break label587;
          }
          k = arrayOfInt[2];
          this.mNativeRtcContext = nativeCreateContext(i, j, k);
          apiLog("trtc cloud create");
          this.mRoomState = 0;
          this.mVideoSourceType = VideoSourceType.NONE;
          this.mIsAudioCapturing = false;
          this.mIsVideoCapturing = false;
          this.mCurrentRole = 20;
          this.mTargetRole = 20;
          this.mRecvMode = 1;
          this.mLatestParamsOfBigEncoder.putInt("config_gop", this.mConfig.j);
          this.mLatestParamsOfSmallEncoder.putInt("config_gop", this.mConfig.j);
          identifyTRTCFrameworkType();
          this.mVideoServerConfig = TRTCVideoServerConfig.loadFromSharedPreferences(paramContext);
          AppMethodBeat.o(230720);
          return;
          ??? = new HandlerThread("TRTCCloudApi");
          ???.start();
          this.mSDKHandler = new com.tencent.liteav.basic.util.f(???.getLooper());
          break;
          i = 0;
          break label403;
        }
        label587:
        int k = 0;
      }
    }
  }
  
  private boolean isNumericRoom(int paramInt)
  {
    return (paramInt != 0) && (paramInt != -1);
  }
  
  private void muteUpstream(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230930);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeMuteUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt, paramBoolean);
    }
    AppMethodBeat.o(230930);
  }
  
  private native int nativeCancelDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeChangeRole(long paramLong, int paramInt);
  
  private native int nativeConnectOtherRoom(long paramLong, String paramString);
  
  private native int nativeDisconnectOtherRoom(long paramLong, String paramString);
  
  private native void nativeEnableBlackStream(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableSmallStream(long paramLong, boolean paramBoolean);
  
  private native void nativeMuteUpstream(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativePushVideo(long paramLong1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
  
  private native void nativeReenterRoom(long paramLong, int paramInt);
  
  private native int nativeRemoveUpstream(long paramLong, int paramInt);
  
  private native int nativeRequestDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeRequestKeyFrame(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSendCustomCmdMsg(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeSendJsonCmd(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSendSEIMsg(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeSetAVSyncPlaySources(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSetAllowSwitchToHighPerformanceMode(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAudioEncodeConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSetDataReportDeviceInfo(String paramString1, String paramString2, int paramInt);
  
  private native void nativeSetEncodedDataProcessingListener(long paramLong1, long paramLong2);
  
  private native void nativeSetHeartBeatTimeoutSec(long paramLong, int paramInt);
  
  private native void nativeSetNetEnv(long paramLong, int paramInt);
  
  private native boolean nativeSetSEIPayloadType(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncoderConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, boolean paramBoolean2);
  
  private native void nativeSetVideoQuality(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeStartLocalRecording(long paramLong, TRTCCloudDef.TRTCLocalRecordingParams paramTRTCLocalRecordingParams);
  
  private native void nativeStartPublishCDNStream(long paramLong, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam);
  
  private native void nativeStartPublishing(long paramLong, String paramString, int paramInt);
  
  private native void nativeStartSpeedTest(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeStopLocalRecording(long paramLong);
  
  private native void nativeStopPublishCDNStream(long paramLong);
  
  private native void nativeStopPublishing(long paramLong);
  
  private native void nativeStopSpeedTest(long paramLong);
  
  private native void nativeUpdatePrivateMapKey(long paramLong, String paramString);
  
  private void notifyCaptureStarted(final String paramString)
  {
    AppMethodBeat.i(230937);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230745);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener == null)
        {
          AppMethodBeat.o(230745);
          return;
        }
        localTRTCCloudListener.onWarning(4000, paramString, null);
        AppMethodBeat.o(230745);
      }
    });
    apiLog(paramString);
    AppMethodBeat.o(230937);
  }
  
  private void notifyEvent(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(15970);
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", paramString2);
    notifyEvent(paramString1, paramInt, localBundle);
    AppMethodBeat.o(15970);
  }
  
  private void notifyEventByUserId(final String paramString, final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(15966);
    if ((paramString == null) || (paramBundle == null))
    {
      AppMethodBeat.o(15966);
      return;
    }
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(230785);
        if (paramString.equalsIgnoreCase(String.valueOf(paramAnonymousUserInfo.tinyID))) {
          TRTCCloudImpl.this.notifyEvent(paramAnonymousUserInfo.userID, paramInt, paramBundle);
        }
        AppMethodBeat.o(230785);
      }
    });
    AppMethodBeat.o(15966);
  }
  
  private void notifyLogByUserId(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(15965);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(15965);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", paramInt2);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", paramString2);
    localBundle.putInt("EVT_STREAM_TYPE", paramInt1);
    notifyEventByUserId(paramString1, paramInt2, localBundle);
    AppMethodBeat.o(15965);
  }
  
  private void onAVMemberChange(final long paramLong, String paramString, int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(15924);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182291);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberChange when out room");
          AppMethodBeat.o(182291);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(182291);
          return;
        }
        TRTCCloudImpl.this.apiLog("onAVMemberChange " + paramLong + ", " + paramInt3 + ", old state:" + paramInt2 + ", new state:" + this.val$streamState);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramInt3);
        if (localUserInfo != null)
        {
          localUserInfo.streamState = this.val$streamState;
          TRTCCloudImpl.this.checkUserState(paramInt3, paramLong, this.val$streamState, paramInt2);
        }
        AppMethodBeat.o(182291);
      }
    });
    AppMethodBeat.o(15924);
  }
  
  private void onAddUpStream(final int paramInt1, final String paramString, int paramInt2)
  {
    AppMethodBeat.i(230892);
    apiOnlineLog("onAddUpStream  streamType:%d, err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    if ((paramInt2 == 7) && (paramInt1 != 0))
    {
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15675);
          TRTCCloudImpl.access$5000(TRTCCloudImpl.this, 7);
          AppMethodBeat.o(15675);
        }
      });
      runOnListenerThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15654);
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          if (localTRTCCloudListener != null) {
            localTRTCCloudListener.onError(paramInt1, paramString, null);
          }
          AppMethodBeat.o(15654);
        }
      });
    }
    AppMethodBeat.o(230892);
  }
  
  private void onCallExperimentalAPI(int paramInt, String paramString)
  {
    AppMethodBeat.i(15919);
    apiLog("onCallExperimentalAPI " + paramInt + ", " + paramString);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182303);
        AppMethodBeat.o(182303);
      }
    });
    AppMethodBeat.o(15919);
  }
  
  private void onChangeRole(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15946);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230825);
        if (paramInt == 0) {
          TRTCCloudImpl.this.mCurrentRole = TRTCCloudImpl.this.mTargetRole;
        }
        for (;;)
        {
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          if (localTRTCCloudListener != null) {
            localTRTCCloudListener.onSwitchRole(paramInt, paramString);
          }
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(230739);
              if (paramAnonymous2UserInfo.mainRender.render != null) {
                TRTCCloudImpl.access$9900(TRTCCloudImpl.this, paramAnonymous2UserInfo.mainRender.render, paramAnonymous2UserInfo.mainRender.render.getConfig());
              }
              AppMethodBeat.o(230739);
            }
          });
          TRTCCloudImpl.access$9100(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onChangeRole:" + paramInt);
          TRTCCloudImpl.this.apiOnlineLog("onChangeRole err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
          AppMethodBeat.o(230825);
          return;
          TRTCCloudImpl.this.mCurrentRole = 21;
          TRTCCloudImpl.this.mTargetRole = 21;
        }
      }
    });
    AppMethodBeat.o(15946);
  }
  
  private void onConnectOtherRoom(final String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(15917);
    apiOnlineLog("onConnectOtherRoom userId:%s err:%d, msg:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15569);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onConnectOtherRoom(paramString1, paramInt, paramString2);
        }
        AppMethodBeat.o(15569);
      }
    });
    AppMethodBeat.o(15917);
  }
  
  private void onConnectionLost()
  {
    AppMethodBeat.i(15932);
    this.mRoomInfo.networkStatus = 1;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Network anomaly.");
    apiOnlineLog("onConnectionLost");
    resetFeelingBlockReport();
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230852);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onConnectionLost();
        }
        AppMethodBeat.o(230852);
      }
    });
    AppMethodBeat.o(15932);
  }
  
  private void onConnectionRecovery()
  {
    AppMethodBeat.i(15934);
    this.mRoomInfo.networkStatus = 3;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Network recovered. Successfully re-enter room");
    apiOnlineLog("onConnectionRecovery");
    resetFeelingBlockReport();
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230847);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onConnectionRecovery();
        }
        AppMethodBeat.o(230847);
      }
    });
    AppMethodBeat.o(15934);
  }
  
  private void onDisConnectOtherRoom(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15918);
    apiOnlineLog("onDisConnectOtherRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15722);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onDisConnectOtherRoom(paramInt, paramString);
        }
        AppMethodBeat.o(15722);
      }
    });
    AppMethodBeat.o(15918);
  }
  
  private void onExitRoom(final int paramInt, String paramString)
  {
    AppMethodBeat.i(15915);
    apiOnlineLog("onExitRoom err:" + paramInt + ", msg:" + paramString);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15626);
        if (TRTCCloudImpl.this.mIsExitOldRoom)
        {
          TRTCCloudImpl.this.mIsExitOldRoom = false;
          TRTCCloudImpl.this.apiLog("exit no current room, ignore onExitRoom.");
          AppMethodBeat.o(15626);
          return;
        }
        if (TRTCCloudImpl.this.mRoomInfo.isMicStard())
        {
          TRTCCloudImpl.this.mRoomInfo.setRoomExit(true, paramInt);
          TRTCCloudImpl.this.apiLog("onExitRoom delay 2s when mic is not release.");
          TRTCCloudImpl.access$9300(TRTCCloudImpl.this, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230670);
              if (TRTCCloudImpl.this.mRoomInfo.isRoomExit())
              {
                TRTCCloudImpl.this.apiLog("force onExitRoom after 2s");
                final int i = TRTCCloudImpl.this.mRoomInfo.getRoomExitCode();
                TRTCCloudImpl.this.mRoomInfo.setRoomExit(false, 0);
                TRTCCloudImpl.this.runOnListenerThread(new Runnable()
                {
                  public void run()
                  {
                    AppMethodBeat.i(230638);
                    TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                    if (localTRTCCloudListener != null) {
                      localTRTCCloudListener.onExitRoom(i);
                    }
                    AppMethodBeat.o(230638);
                  }
                });
              }
              AppMethodBeat.o(230670);
            }
          }, 2000);
          AppMethodBeat.o(15626);
          return;
        }
        TRTCCloudImpl.this.runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230702);
            TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
            if (localTRTCCloudListener != null) {
              localTRTCCloudListener.onExitRoom(TRTCCloudImpl.140.this.val$err);
            }
            AppMethodBeat.o(230702);
          }
        });
        AppMethodBeat.o(15626);
      }
    });
    AppMethodBeat.o(15915);
  }
  
  private void onKickOut(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15916);
    apiLog("onKickOut " + paramInt + ", " + paramString);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15575);
        TRTCCloudImpl.this.exitRoomInternal(false, "onKickOut " + paramString);
        TRTCCloudImpl.access$9400(TRTCCloudImpl.this, paramInt, paramString);
        AppMethodBeat.o(15575);
      }
    });
    AppMethodBeat.o(15916);
  }
  
  private void onLocalRecordBegin(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(230912);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230842);
        TRTCCloudImpl.this.apiLog("onLocalRecordBegin " + paramInt + " " + paramString);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onLocalRecordBegin(paramInt, paramString);
        }
        AppMethodBeat.o(230842);
      }
    });
    AppMethodBeat.o(230912);
  }
  
  private void onLocalRecordComplete(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(230913);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230841);
        TRTCCloudImpl.this.apiLog("onLocalRecordComplete " + paramInt + " " + paramString);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onLocalRecordComplete(paramInt, paramString);
        }
        AppMethodBeat.o(230841);
      }
    });
    AppMethodBeat.o(230913);
  }
  
  private void onLocalRecording(final long paramLong, String paramString)
  {
    AppMethodBeat.i(230914);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230843);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onLocalRecording(paramLong, this.val$storagePath);
        }
        AppMethodBeat.o(230843);
      }
    });
    AppMethodBeat.o(230914);
  }
  
  private void onNotify(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(15927);
    apiLog(paramLong + " event " + paramInt2 + ", " + paramString);
    String str = String.valueOf(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", paramInt2);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", paramString);
    localBundle.putInt("EVT_STREAM_TYPE", paramInt1);
    if ((TextUtils.isEmpty(str)) || (paramLong == 0L) || (str.equalsIgnoreCase("18446744073709551615")) || (str.equalsIgnoreCase(this.mRoomInfo.getTinyId())))
    {
      notifyEvent(this.mRoomInfo.getUserId(), paramInt2, localBundle);
      AppMethodBeat.o(15927);
      return;
    }
    notifyLogByUserId(String.valueOf(paramLong), paramInt1, paramInt2, paramString);
    AppMethodBeat.o(15927);
  }
  
  private void onRecvAudioServerConfig(TRTCAudioServerConfig paramTRTCAudioServerConfig)
  {
    boolean bool2 = true;
    AppMethodBeat.i(230916);
    TXCLog.i("TRTCCloudImpl", "on receive audio config: [%s]", new Object[] { paramTRTCAudioServerConfig });
    TRTCAudioServerConfig.saveToSharedPreferences(this.mContext, paramTRTCAudioServerConfig);
    TXCAudioEngine.getInstance().enableAutoRestartDevice(paramTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(paramTRTCAudioServerConfig.maxSelectedPlayStreams);
    TXCAudioEngine localTXCAudioEngine = TXCAudioEngine.getInstance();
    if (paramTRTCAudioServerConfig.enableInbandFEC != 0)
    {
      bool1 = true;
      localTXCAudioEngine.enableInbandFEC(bool1);
      localTXCAudioEngine = TXCAudioEngine.getInstance();
      if (paramTRTCAudioServerConfig.enableDeviceAbnormalDetection == 0) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localTXCAudioEngine.enableDeviceAbnormalDetection(bool1);
      AppMethodBeat.o(230916);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void onRecvCustomCmdMsg(final String paramString, long paramLong1, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte, final boolean paramBoolean, final int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(230905);
    long l = System.currentTimeMillis();
    this.mRecvCustomCmdMsgCountInPeriod += 1L;
    if (l - this.mLastLogCustomCmdMsgTs > 10000L)
    {
      TXCLog.i("TRTCCloudImpl", "onRecvMsg. tinyId=" + paramLong1 + ", streamId = " + paramInt1 + ", msg = " + paramArrayOfByte + ", recvTime = " + paramLong2 + ", recvCustomMsgCountInPeriod = " + this.mRecvCustomCmdMsgCountInPeriod + " self:" + hashCode());
      this.mLastLogCustomCmdMsgTs = l;
      this.mRecvCustomCmdMsgCountInPeriod = 0L;
    }
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230849);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null)
        {
          localTRTCCloudListener.onRecvCustomCmdMsg(paramString, paramInt1, paramInt2, paramArrayOfByte);
          if ((paramBoolean) && (paramInt3 > 0)) {
            localTRTCCloudListener.onMissCustomCmdMsg(paramString, paramInt1, -1, paramInt3);
          }
        }
        AppMethodBeat.o(230849);
      }
    });
    AppMethodBeat.o(230905);
  }
  
  private void onRecvEnterRoomVideoConfig(final boolean paramBoolean)
  {
    AppMethodBeat.i(230917);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230788);
        TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByServer(paramBoolean, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_ENTERROOM_RESPOND);
        boolean bool = TRTCCloudImpl.this.mH265Decision.isVideoEncoderCodecUsingH265();
        if (TRTCCloudImpl.this.mCaptureAndEnc != null)
        {
          TXCLog.i("TRTCCloudImpl", "codecability onRecvEnterRoomVideoConfig: enabledHevc =".concat(String.valueOf(bool)));
          TRTCCloudImpl.this.mCaptureAndEnc.k(bool);
        }
        AppMethodBeat.o(230788);
      }
    });
    AppMethodBeat.o(230917);
  }
  
  private void onRecvFirstAudio(long paramLong)
  {
    AppMethodBeat.i(15940);
    runOnSDKThread(new Runnable()
    {
      public void run() {}
    });
    AppMethodBeat.o(15940);
  }
  
  private void onRecvFirstVideo(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(15941);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230862);
        int i = TRTCCloudImpl.this.mRoomInfo.recvFirstIFrame(paramLong);
        final String str2 = null;
        try
        {
          String str3 = TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(paramLong);
          localObject = str2;
          if (str3 != null) {
            localObject = TRTCCloudImpl.this.mRoomInfo.getUser(str3);
          }
        }
        catch (Exception localException)
        {
          String str1;
          for (;;)
          {
            Object localObject;
            TXCLog.e("TRTCCloudImpl", "get user info failed.", localException);
            str1 = str2;
          }
          str2 = str1.userID;
          if (((!TRTCRoomInfo.hasMainVideo(str1.streamState)) && (!TRTCRoomInfo.hasSmallVideo(str1.streamState))) || (TRTCRoomInfo.isMuteMainVideo(str1.streamState))) {
            break label173;
          }
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230839);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener != null)
              {
                localTRTCCloudListener.onUserVideoAvailable(str2, true);
                TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { str2, Boolean.TRUE }));
                Monitor.a(2, String.format("onUserVideoAvailable by recv first video. userID:%s, bAvailable:%b", new Object[] { str2, Boolean.TRUE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
              }
              AppMethodBeat.o(230839);
            }
          });
          label173:
          AppMethodBeat.o(230862);
        }
        TRTCCloudImpl.this.apiLog("onRecvFirstVideo " + paramLong + ", " + i);
        if ((localObject == null) || (i > 1))
        {
          AppMethodBeat.o(230862);
          return;
        }
      }
    });
    AppMethodBeat.o(15941);
  }
  
  private void onRecvSEIMsg(final long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15937);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230853);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          try
          {
            String str = TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(paramLong);
            if (str != null)
            {
              long l = System.currentTimeMillis();
              TRTCCloudImpl.access$9708(TRTCCloudImpl.this);
              if (l - TRTCCloudImpl.this.mLastLogSEIMsgTs > 10000L)
              {
                TXCLog.i("TRTCCloudImpl", "onRecvSEIMsg. userId=" + str + ", message = " + new String(this.val$message) + ", recvSEIMsgCountInPeriod = " + TRTCCloudImpl.this.mRecvSEIMsgCountInPeriod + " self:" + TRTCCloudImpl.this.hashCode());
                TRTCCloudImpl.access$9802(TRTCCloudImpl.this, l);
                TRTCCloudImpl.access$9702(TRTCCloudImpl.this, 0L);
              }
              localTRTCCloudListener.onRecvSEIMsg(str, this.val$message);
              AppMethodBeat.o(230853);
              return;
            }
            TXCLog.i("TRTCCloudImpl", "onRecvSEIMsg Error, user id is null for tinyId=" + paramLong + " self:" + TRTCCloudImpl.this.hashCode());
            AppMethodBeat.o(230853);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e("TRTCCloudImpl", "onRecvSEIMsg failed.", localException);
          }
        }
        AppMethodBeat.o(230853);
      }
    });
    AppMethodBeat.o(15937);
  }
  
  private void onRecvVideoServerConfig(final TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    AppMethodBeat.i(230911);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230834);
        TRTCCloudImpl.this.apiLog("onRecvVideoServerConfig " + paramTRTCVideoServerConfig);
        TRTCCloudImpl.access$10102(TRTCCloudImpl.this, paramTRTCVideoServerConfig);
        TRTCVideoServerConfig.saveToSharedPreferences(TRTCCloudImpl.this.mContext, paramTRTCVideoServerConfig);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230756);
            paramAnonymous2String = paramAnonymous2UserInfo.mainRender.render;
            if (paramAnonymous2String != null) {
              paramAnonymous2String.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
            }
            paramAnonymous2String = paramAnonymous2UserInfo.subRender.render;
            if (paramAnonymous2String != null) {
              paramAnonymous2String.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
            }
            AppMethodBeat.o(230756);
          }
        });
        AppMethodBeat.o(230834);
      }
    });
    AppMethodBeat.o(230911);
  }
  
  private void onRequestAccIP(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15913);
    apiLog("onRequestAccIP err:" + paramInt + " " + paramString + " isAcc:" + paramBoolean);
    if (paramInt == 0) {
      if (!paramBoolean) {
        break label128;
      }
    }
    label128:
    for (paramString = "connect ACC";; paramString = "connect PROXY")
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      localBundle.putString("EVT_MSG", paramString);
      localBundle.putInt("EVT_STREAM_TYPE", 2);
      notifyEvent(this.mRoomInfo.getUserId(), paramInt, localBundle);
      AppMethodBeat.o(15913);
      return;
    }
  }
  
  private void onRequestDownStream(final int paramInt1, final String paramString, final long paramLong, final int paramInt2)
  {
    AppMethodBeat.i(15920);
    if (paramInt1 != 0)
    {
      runOnListenerThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170195);
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          if (localTRTCCloudListener != null) {
            localTRTCCloudListener.onError(paramInt1, paramString, null);
          }
          AppMethodBeat.o(170195);
        }
      });
      AppMethodBeat.o(15920);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182408);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230724);
            if ((TRTCCloudImpl.149.this.val$stream != 1) && (TRTCCloudImpl.149.this.val$tinyID == paramAnonymous2UserInfo.tinyID))
            {
              TRTCCloudImpl.this.apiLog("onRequestDownStream " + paramAnonymous2UserInfo.tinyID + ", " + paramAnonymous2UserInfo.userID + ", " + TRTCCloudImpl.149.this.val$stream);
              if (TRTCCloudImpl.149.this.val$stream == 7)
              {
                if ((paramAnonymous2UserInfo.subRender.render != null) && (paramAnonymous2UserInfo.subRender.render.getStreamType() != TRTCCloudImpl.149.this.val$stream))
                {
                  paramAnonymous2UserInfo.subRender.render.stopVideo();
                  paramAnonymous2UserInfo.subRender.render.setStreamType(TRTCCloudImpl.149.this.val$stream);
                  paramAnonymous2UserInfo.subRender.render.startVideo();
                  AppMethodBeat.o(230724);
                }
              }
              else if ((paramAnonymous2UserInfo.mainRender.render != null) && (paramAnonymous2UserInfo.mainRender.render.getStreamType() != TRTCCloudImpl.149.this.val$stream))
              {
                paramAnonymous2UserInfo.mainRender.render.stopVideo();
                paramAnonymous2UserInfo.mainRender.render.setStreamType(TRTCCloudImpl.149.this.val$stream);
                paramAnonymous2UserInfo.mainRender.render.startVideo();
                TXCKeyPointReportProxy.a(String.valueOf(paramAnonymous2UserInfo.tinyID), 40038, 0L, TRTCCloudImpl.149.this.val$stream);
              }
            }
            AppMethodBeat.o(230724);
          }
        });
        AppMethodBeat.o(182408);
      }
    });
    AppMethodBeat.o(15920);
  }
  
  private void onRequestToken(int paramInt, String paramString, final long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15912);
    apiLog("onRequestToken " + paramLong + "," + paramInt + ", " + paramString);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15618);
        TRTCCloudImpl.this.mRoomInfo.setTinyId(String.valueOf(paramLong));
        TRTCCloudImpl.this.mRoomInfo.setToken(TRTCCloudImpl.this.mContext, this.val$token);
        AppMethodBeat.o(15618);
      }
    });
    AppMethodBeat.o(15912);
  }
  
  private void onSendCustomCmdMsgResult(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(15935);
    AppMethodBeat.o(15935);
  }
  
  private void onSpeedTest(final String paramString, final int paramInt1, final float paramFloat1, final float paramFloat2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(15938);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230881);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        TRTCCloudDef.TRTCSpeedTestResult localTRTCSpeedTestResult;
        if (localTRTCCloudListener != null)
        {
          localTRTCSpeedTestResult = new TRTCCloudDef.TRTCSpeedTestResult();
          localTRTCSpeedTestResult.ip = paramString;
          localTRTCSpeedTestResult.rtt = paramInt1;
          localTRTCSpeedTestResult.upLostRate = paramFloat1;
          localTRTCSpeedTestResult.downLostRate = paramFloat2;
          if (paramFloat1 < paramFloat2) {
            break label151;
          }
        }
        label151:
        for (localTRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(paramInt1, (int)(paramFloat1 * 100.0F));; localTRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(paramInt1, (int)(paramFloat2 * 100.0F)))
        {
          localTRTCCloudListener.onSpeedTest(localTRTCSpeedTestResult, paramInt2, paramInt3);
          TRTCCloudImpl.this.apiLog("SpeedTest progress %d/%d, result: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localTRTCSpeedTestResult.toString() });
          AppMethodBeat.o(230881);
          return;
        }
      }
    });
    AppMethodBeat.o(15938);
  }
  
  private void onStartPublishing(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(182323);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230831);
        TRTCCloudImpl.this.apiOnlineLog("onStartPublishing err:" + paramInt + ", msg:" + paramString);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStartPublishing(paramInt, paramString);
        }
        AppMethodBeat.o(230831);
      }
    });
    AppMethodBeat.o(182323);
  }
  
  private void onStopPublishing(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(182324);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230826);
        TRTCCloudImpl.this.apiOnlineLog("onStopPublishing err:" + paramInt + ", msg:" + paramString);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStopPublishing(paramInt, paramString);
        }
        AppMethodBeat.o(230826);
      }
    });
    AppMethodBeat.o(182324);
  }
  
  private void onStreamPublished(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15942);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230830);
        TRTCCloudImpl.this.apiOnlineLog("onStreamPublished err:" + paramInt + ", msg:" + paramString);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStartPublishCDNStream(paramInt, paramString);
        }
        AppMethodBeat.o(230830);
      }
    });
    AppMethodBeat.o(15942);
  }
  
  private void onStreamUnpublished(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15943);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230828);
        TRTCCloudImpl.this.apiOnlineLog("onStreamUnpublished err:" + paramInt + ", msg:" + paramString);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStopPublishCDNStream(paramInt, paramString);
        }
        AppMethodBeat.o(230828);
      }
    });
    AppMethodBeat.o(15943);
  }
  
  private void onSwitchRoom(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(230890);
    apiOnlineLog(String.format("onSwitchRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(170201);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onSwitchRoom(paramInt, paramString);
        }
        AppMethodBeat.o(170201);
      }
    });
    AppMethodBeat.o(230890);
  }
  
  private void onTranscodingUpdated(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15944);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230823);
        TRTCCloudImpl.this.apiOnlineLog("onTranscodingUpdated err:" + paramInt + ", msg:" + paramString);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSetMixTranscodingConfig(paramInt, paramString);
        }
        AppMethodBeat.o(230823);
      }
    });
    AppMethodBeat.o(15944);
  }
  
  private void onTryToReconnect()
  {
    AppMethodBeat.i(15933);
    this.mRoomInfo.networkStatus = 2;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Retry enter room.");
    apiOnlineLog("onTryToReconnect");
    resetFeelingBlockReport();
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230850);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onTryToReconnect();
        }
        AppMethodBeat.o(230850);
      }
    });
    AppMethodBeat.o(15933);
  }
  
  private void onVideoBlockThresholdChanged(final int paramInt)
  {
    AppMethodBeat.i(230898);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230594);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230621);
            if (paramAnonymous2UserInfo.mainRender.render != null) {
              paramAnonymous2UserInfo.mainRender.render.setBlockInterval(TRTCCloudImpl.159.this.val$videoBlockThreshold);
            }
            if (paramAnonymous2UserInfo.subRender.render != null) {
              paramAnonymous2UserInfo.subRender.render.setBlockInterval(TRTCCloudImpl.159.this.val$videoBlockThreshold);
            }
            AppMethodBeat.o(230621);
          }
        });
        AppMethodBeat.o(230594);
      }
    });
    AppMethodBeat.o(230898);
  }
  
  private void onWholeMemberEnter(long paramLong, final String paramString)
  {
    AppMethodBeat.i(15925);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182390);
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(182390);
          return;
        }
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onRemoteUserEnterRoom(paramString);
        }
        AppMethodBeat.o(182390);
      }
    });
    AppMethodBeat.o(15925);
  }
  
  private void onWholeMemberExit(long paramLong, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15926);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230618);
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(230618);
          return;
        }
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onRemoteUserLeaveRoom(paramString, paramInt);
        }
        AppMethodBeat.o(230618);
      }
    });
    AppMethodBeat.o(15926);
  }
  
  private void pushVideoFrame(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(230935);
    for (;;)
    {
      synchronized (this.mCurrentPublishClouds)
      {
        TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramTXSNALPacket.streamType));
        if (localTRTCCloudImpl != null)
        {
          long l = localTRTCCloudImpl.getNetworkContext();
          if (paramTXSNALPacket.codecId == 1)
          {
            i = 14;
            nativePushVideo(l, paramTXSNALPacket.streamType, i, paramTXSNALPacket.nalType, paramTXSNALPacket.nalData, paramTXSNALPacket.gopIndex, paramTXSNALPacket.gopFrameIndex, paramTXSNALPacket.refFremeIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
          }
        }
        else
        {
          AppMethodBeat.o(230935);
          return;
        }
      }
      int i = 1;
    }
  }
  
  private void removeUpStreamType(int paramInt)
  {
    AppMethodBeat.i(230927);
    if (this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.remove(Integer.valueOf(paramInt));
    }
    removeUpstream(paramInt);
    AppMethodBeat.o(230927);
  }
  
  private void removeUpstream(int paramInt)
  {
    AppMethodBeat.i(230932);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeRemoveUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
    AppMethodBeat.o(230932);
  }
  
  private void resetFeelingBlockReport()
  {
    AppMethodBeat.i(230899);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230856);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230762);
            if (paramAnonymous2UserInfo.mainRender.render != null) {
              paramAnonymous2UserInfo.mainRender.render.resetPeriodFeelingStatistics();
            }
            if (paramAnonymous2UserInfo.subRender.render != null) {
              paramAnonymous2UserInfo.subRender.render.resetPeriodFeelingStatistics();
            }
            AppMethodBeat.o(230762);
          }
        });
        AppMethodBeat.o(230856);
      }
    });
    AppMethodBeat.o(230899);
  }
  
  private void runOnListenerThread(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(15951);
    Handler localHandler = this.mListenerHandler;
    if (localHandler == null)
    {
      this.mMainHandler.postDelayed(paramRunnable, paramInt);
      AppMethodBeat.o(15951);
      return;
    }
    localHandler.postDelayed(paramRunnable, paramInt);
    AppMethodBeat.o(15951);
  }
  
  private void runOnMainThreadAndWaitDone(Runnable paramRunnable)
  {
    AppMethodBeat.i(230919);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mMainHandler.a(paramRunnable);
      AppMethodBeat.o(230919);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(230919);
  }
  
  private void runOnSDKThread(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(15952);
    if (this.mSDKHandler != null) {
      this.mSDKHandler.postDelayed(paramRunnable, paramInt);
    }
    AppMethodBeat.o(15952);
  }
  
  private void runOnSDKThreadAndWaitDone(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(230920);
    if (this.mSDKHandler != null)
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper())
      {
        this.mSDKHandler.a(paramRunnable, paramLong);
        AppMethodBeat.o(230920);
        return;
      }
      paramRunnable.run();
    }
    AppMethodBeat.o(230920);
  }
  
  private void setAVSyncPlaySources(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230797);
    if (paramJSONObject == null)
    {
      apiLog("setAVSyncPlaySources param is null");
      AppMethodBeat.o(230797);
      return;
    }
    if (!paramJSONObject.has("audioSourceUserID"))
    {
      apiLog("setAVSyncPlaySources[lack parameter]: audioSourceUserID");
      AppMethodBeat.o(230797);
      return;
    }
    if (!paramJSONObject.has("videoSourceUserID"))
    {
      apiLog("setAVSyncPlaySources[lack parameter]: videoSourceUserID");
      AppMethodBeat.o(230797);
      return;
    }
    String str = paramJSONObject.getString("audioSourceUserID");
    if (str == null)
    {
      apiLog("setAVSyncPlaySources[illegal type]: audioSourceUserID");
      AppMethodBeat.o(230797);
      return;
    }
    paramJSONObject = paramJSONObject.getString("videoSourceUserID");
    if (paramJSONObject == null)
    {
      apiLog("setAVSyncPlaySources[illegal type]: videoSourceUserID");
      AppMethodBeat.o(230797);
      return;
    }
    nativeSetAVSyncPlaySources(this.mNativeRtcContext, str, paramJSONObject);
    AppMethodBeat.o(230797);
  }
  
  private void setAudioEncodeConfiguration()
  {
    AppMethodBeat.i(230933);
    setQoSParams();
    AppMethodBeat.o(230933);
  }
  
  private void setAudioSampleRate(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15861);
    if ((paramJSONObject == null) || (!paramJSONObject.has("sampleRate")))
    {
      apiLog("setAudioSampleRate[lack parameter or illegal type]: sampleRate");
      AppMethodBeat.o(15861);
      return;
    }
    int i = paramJSONObject.getInt("sampleRate");
    if ((this.mEnableCustomAudioCapture) || (this.mIsAudioCapturing))
    {
      apiLog("setAudioSampleRate[illegal state]");
      AppMethodBeat.o(15861);
      return;
    }
    if ((16000 != i) && (48000 != i))
    {
      apiLog("muteRemoteAudioInSpeaker[illegal sampleRate]: ".concat(String.valueOf(i)));
      AppMethodBeat.o(15861);
      return;
    }
    TXCAudioEngine.getInstance().setEncoderSampleRate(i);
    AppMethodBeat.o(15861);
  }
  
  private void setCustomCaptureGLSyncMode(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230805);
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[setCustomCaptureGLMode failed, params is null");
      AppMethodBeat.o(230805);
      return;
    }
    this.mCustomCaptureGLSyncMode = paramJSONObject.getInt("mode");
    apiLog("setCustomCaptureGLMode: mode:" + this.mCustomCaptureGLSyncMode);
    AppMethodBeat.o(230805);
  }
  
  private void setCustomRenderMode(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(182314);
    if (paramJSONObject == null)
    {
      apiLog("setCustomRenderMode param is null");
      AppMethodBeat.o(182314);
      return;
    }
    if (!paramJSONObject.has("mode"))
    {
      apiLog("setCustomRenderMode[lack parameter]: mode");
      AppMethodBeat.o(182314);
      return;
    }
    int i = paramJSONObject.optInt("mode", 0);
    paramJSONObject = this.mRoomInfo;
    if (i == 1) {}
    for (;;)
    {
      paramJSONObject.enableCustomPreprocessor = bool;
      this.mCaptureAndEnc.a(this.mRoomInfo.enableCustomPreprocessor);
      AppMethodBeat.o(182314);
      return;
      bool = false;
    }
  }
  
  private void setEnableH265Encoder(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(230790);
    if (paramJSONObject == null)
    {
      apiLog("setEnableH265Encoder param is null");
      AppMethodBeat.o(230790);
      return;
    }
    if (paramJSONObject.has("enable"))
    {
      int i = paramJSONObject.optInt("enable", 0);
      paramJSONObject = this.mH265Decision;
      if (i != 0) {
        bool = true;
      }
      paramJSONObject.setEnableH265EncodeByPrivateAPI(bool);
      if ((this.mCaptureAndEnc != null) && (this.mAppScene == 1))
      {
        bool = this.mH265Decision.isVideoEncoderCodecUsingH265();
        TXCLog.i("TRTCCloudImpl", "enableH265 = " + bool + " ,mRoomState= " + this.mRoomState);
        this.mCaptureAndEnc.k(bool);
      }
    }
    AppMethodBeat.o(230790);
  }
  
  private void setFramework(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230776);
    if (paramJSONObject == null)
    {
      apiLog("setFramework[lack parameter]");
      AppMethodBeat.o(230776);
      return;
    }
    if (!paramJSONObject.has("framework"))
    {
      apiLog("setFramework[lack parameter]: framework");
      AppMethodBeat.o(230776);
      return;
    }
    this.mFramework = paramJSONObject.getInt("framework");
    AppMethodBeat.o(230776);
  }
  
  private void setHeartBeatTimeoutSec(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230795);
    if (paramJSONObject == null)
    {
      apiLog("setHeartBeatTimeoutSec param is null");
      AppMethodBeat.o(230795);
      return;
    }
    if (!paramJSONObject.has("timeoutSec"))
    {
      apiLog("setHeartBeatTimeoutSec[lack parameter]: timeoutSec");
      AppMethodBeat.o(230795);
      return;
    }
    int i = paramJSONObject.optInt("timeoutSec", 0);
    nativeSetHeartBeatTimeoutSec(this.mNativeRtcContext, i);
    AppMethodBeat.o(230795);
  }
  
  private void setKeepAVCaptureOption(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(230786);
    if (paramJSONObject == null)
    {
      apiLog("setKeepAVCaptureOption param is null");
      AppMethodBeat.o(230786);
      return;
    }
    if (paramJSONObject.optInt("keepWhenEnterRoomFailed", 0) != 0) {
      bool = true;
    }
    this.mKeepAVCaptureWhenEnterRoomFailed = bool;
    apiLog("setKeepAVCaptureOption " + this.mKeepAVCaptureWhenEnterRoomFailed);
    AppMethodBeat.o(230786);
  }
  
  private void setLocalAudioMuteMode(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15860);
    if ((paramJSONObject == null) || (!paramJSONObject.has("mode"))) {
      apiLog("setLocalAudioMuteMode[lack parameter or illegal type]: mode");
    }
    if (paramJSONObject.getInt("mode") == 0) {}
    for (this.mEnableEosMode = false;; this.mEnableEosMode = true)
    {
      TXCAudioEngine.getInstance().enableCaptureEOSMode(this.mEnableEosMode);
      AppMethodBeat.o(15860);
      return;
    }
  }
  
  private void setMediaCodecConfig(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    boolean bool = false;
    AppMethodBeat.i(182315);
    if (paramJSONObject == null)
    {
      apiLog("setMediaCodecConfig param is null");
      AppMethodBeat.o(182315);
      return;
    }
    if (paramJSONObject.has("encProperties")) {}
    for (Object localObject1 = paramJSONObject.getJSONArray("encProperties");; localObject1 = null)
    {
      this.mConfig.Z = ((JSONArray)localObject1);
      this.mCaptureAndEnc.a(this.mConfig);
      localObject1 = localObject2;
      if (paramJSONObject.has("decProperties")) {
        localObject1 = paramJSONObject.getJSONArray("decProperties");
      }
      this.mRoomInfo.decProperties = ((JSONArray)localObject1);
      if (paramJSONObject.has("restartDecoder")) {}
      for (int i = paramJSONObject.getInt("restartDecoder");; i = 0)
      {
        paramJSONObject = this.mRoomInfo;
        if (i != 0) {
          bool = true;
        }
        paramJSONObject.enableRestartDecoder = bool;
        AppMethodBeat.o(182315);
        return;
      }
    }
  }
  
  private void setNetEnv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230803);
    if (paramJSONObject == null)
    {
      apiLog("setNetEnv param is null");
      AppMethodBeat.o(230803);
      return;
    }
    if (!paramJSONObject.has("env"))
    {
      apiLog("setNetEnv[lack parameter]: env");
      AppMethodBeat.o(230803);
      return;
    }
    int i = paramJSONObject.optInt("env", 0);
    nativeSetNetEnv(this.mNativeRtcContext, i);
    AppMethodBeat.o(230803);
  }
  
  private void setOrientation(final int paramInt)
  {
    AppMethodBeat.i(15991);
    if (paramInt == -1)
    {
      AppMethodBeat.o(15991);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230746);
        TRTCCloudImpl.access$11000(TRTCCloudImpl.this, paramInt);
        if (TRTCCloudImpl.this.mSensorMode != 0) {
          TRTCCloudImpl.access$11100(TRTCCloudImpl.this, paramInt);
        }
        AppMethodBeat.o(230746);
      }
    });
    AppMethodBeat.o(15991);
  }
  
  private void setQoSParams()
  {
    AppMethodBeat.i(230918);
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngine.getInstance().getAudioEncoderConfig();
    TXCLog.i("", "setQoSParams:" + localTXCAudioEncoderConfig.sampleRate + " " + localTXCAudioEncoderConfig.channels + " " + localTXCAudioEncoderConfig.minBitrate + " " + localTXCAudioEncoderConfig.maxBitrate);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(1));
    if (localTRTCCloudImpl != null) {
      nativeSetAudioEncodeConfiguration(localTRTCCloudImpl.getNetworkContext(), localTXCAudioEncoderConfig.minBitrate, localTXCAudioEncoderConfig.maxBitrate, localTXCAudioEncoderConfig.sampleRate, localTXCAudioEncoderConfig.channels);
    }
    AppMethodBeat.o(230918);
  }
  
  private void setRemoteViewMirror(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(230738);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15771);
        Object localObject = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(15771);
          return;
        }
        if ((paramInt1 == 0) || (paramInt1 == 1)) {}
        for (localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render; localObject == null; localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render)
        {
          AppMethodBeat.o(15771);
          return;
        }
        switch (paramInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(15771);
          return;
          ((TXCRenderAndDec)localObject).setRenderMirrorType(1);
          AppMethodBeat.o(15771);
          return;
          ((TXCRenderAndDec)localObject).setRenderMirrorType(2);
        }
      }
    });
    AppMethodBeat.o(230738);
  }
  
  private void setStartVideoEncodeCodec()
  {
    AppMethodBeat.i(230750);
    if (this.mCaptureAndEnc != null)
    {
      boolean bool = this.mH265Decision.isVideoEncoderStartCodecUsingH265();
      this.mCaptureAndEnc.k(bool);
    }
    AppMethodBeat.o(230750);
  }
  
  private void setVideoEncConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, int paramInt6, boolean paramBoolean2)
  {
    AppMethodBeat.i(230922);
    if (GetPublishingCloudState(paramInt1) == 0)
    {
      apiLog("setVideoEncConfig ignore when no in room");
      AppMethodBeat.o(230922);
      return;
    }
    if (this.mCodecType != 2)
    {
      setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1, paramBoolean1, paramInt6, paramBoolean2);
      AppMethodBeat.o(230922);
      return;
    }
    setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.mAppScene, paramBoolean1, paramInt6, paramBoolean2);
    AppMethodBeat.o(230922);
  }
  
  private void setVideoEncoderConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, boolean paramBoolean2)
  {
    AppMethodBeat.i(230928);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt1));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoEncoderConfiguration(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean1, paramInt7, paramBoolean2);
    }
    AppMethodBeat.o(230928);
  }
  
  private void setVideoEncoderParamEx(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    AppMethodBeat.i(15859);
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[lack parameter or illegal type]: codecType");
      AppMethodBeat.o(15859);
      return;
    }
    int i = paramJSONObject.optInt("codecType", -1);
    boolean bool1;
    if (i != -1)
    {
      this.mCodecType = i;
      if (this.mCodecType == 0)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("softwareCodecParams");
        if (localJSONObject != null)
        {
          com.tencent.liteav.g localg = this.mConfig;
          if (localJSONObject.optInt("enableRealTime") == 0) {
            break label482;
          }
          bool1 = true;
          localg.Q = bool1;
          this.mConfig.o = localJSONObject.optInt("profile");
        }
      }
    }
    int j = paramJSONObject.optInt("videoWidth", 0);
    int m = paramJSONObject.optInt("videoHeight", 0);
    int n = paramJSONObject.optInt("videoFps", 0);
    int i1 = paramJSONObject.optInt("videoBitrate", 0);
    int i2 = paramJSONObject.optInt("minVideoBitrate", 0);
    int i3 = paramJSONObject.optInt("rcMethod", 0);
    int k;
    if ((j > 0) && (m > 0))
    {
      k = m;
      i = j;
      if (j > 1920)
      {
        k = m * 1920 / 1920;
        i = 1920;
      }
      m = k;
      j = i;
      if (k > 1920)
      {
        j = i * 1920 / 1920;
        m = 1920;
      }
      k = m;
      i = j;
      if (j < 90)
      {
        k = m * 90 / 90;
        i = 90;
      }
      j = k;
      m = i;
      if (k < 90)
      {
        m = i * 90 / 90;
        j = 90;
      }
      i = (m + 15) / 16 * 16;
      j = (j + 15) / 16 * 16;
      k = paramJSONObject.optInt("streamType", 0);
      if (k != 0) {
        break label494;
      }
      this.mConfig.h = true;
      this.mLatestParamsOfBigEncoder.putInt("config_fps", n);
      if (i > j) {
        break label488;
      }
      bool1 = bool2;
      label352:
      updateBigStreamEncoder(bool1, i, j, n, i1, this.mConfig.q, i2, this.mConfig.h);
      this.mCaptureAndEnc.n(i3);
    }
    for (;;)
    {
      apiLog("vsize setVideoEncoderParamEx->width:" + this.mRoomInfo.bigEncSize.a + ", height:" + this.mRoomInfo.bigEncSize.b + ", fps:" + n + ", bitrate:" + i1 + ", stream:" + k);
      updateOrientation();
      AppMethodBeat.o(15859);
      return;
      label482:
      bool1 = false;
      break;
      label488:
      bool1 = false;
      break label352;
      label494:
      if (k == 1)
      {
        this.mLatestParamsOfSmallEncoder.putInt("config_fps", n);
        updateSmallStreamEncoder(i, j, n, i1, i2);
      }
    }
  }
  
  private void setVideoEncoderParamInternal(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    AppMethodBeat.i(230734);
    if (paramTRTCVideoEncParam != null)
    {
      this.mLatestParamsOfBigEncoder.putInt("config_fps", paramTRTCVideoEncParam.videoFps);
      this.mLatestParamsOfBigEncoder.putBoolean("config_adjust_resolution", paramTRTCVideoEncParam.enableAdjustRes);
      com.tencent.liteav.g.a locala = getSizeByResolution(paramTRTCVideoEncParam.videoResolution, paramTRTCVideoEncParam.videoResolutionMode);
      this.mConfig.h = true;
      if (paramTRTCVideoEncParam.videoResolutionMode == 1) {}
      for (boolean bool = true;; bool = false)
      {
        updateBigStreamEncoder(bool, locala.a, locala.b, paramTRTCVideoEncParam.videoFps, paramTRTCVideoEncParam.videoBitrate, paramTRTCVideoEncParam.enableAdjustRes, paramTRTCVideoEncParam.minVideoBitrate, this.mConfig.h);
        apiOnlineLog(String.format("setVideoEncoderParam width:%d, height:%d, fps:%d, bitrate:%d, mode:%d, minBitrate:%d", new Object[] { Integer.valueOf(this.mRoomInfo.bigEncSize.a), Integer.valueOf(this.mRoomInfo.bigEncSize.b), Integer.valueOf(paramTRTCVideoEncParam.videoFps), Integer.valueOf(paramTRTCVideoEncParam.videoBitrate), Integer.valueOf(paramTRTCVideoEncParam.videoResolutionMode), Integer.valueOf(paramTRTCVideoEncParam.minVideoBitrate) }));
        updateOrientation();
        TXCEventRecorderProxy.a("18446744073709551615", 4007, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, "", 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4008, paramTRTCVideoEncParam.videoFps, -1L, "", 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4009, paramTRTCVideoEncParam.videoBitrate, -1L, "", 2);
        AppMethodBeat.o(230734);
        return;
      }
    }
    apiLog("setVideoEncoderParam param is null");
    AppMethodBeat.o(230734);
  }
  
  private void setVideoQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230929);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoQuality(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2);
    }
    AppMethodBeat.o(230929);
  }
  
  public static TRTCCloud sharedInstance(Context paramContext)
  {
    AppMethodBeat.i(15779);
    try
    {
      if (sInstance == null) {
        sInstance = new TRTCCloudImpl(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(15779);
    }
  }
  
  private void showFloatingWindow(View paramView)
  {
    AppMethodBeat.i(230729);
    if (paramView == null)
    {
      AppMethodBeat.o(230729);
      return;
    }
    if ((TXCBuild.VersionInt() >= 23) && (!Settings.canDrawOverlays(paramView.getContext())))
    {
      TXCLog.e("TRTCCloudImpl", "can't show floating window for no drawing overlay permission");
      AppMethodBeat.o(230729);
      return;
    }
    this.mFloatingWindow = paramView;
    WindowManager localWindowManager = (WindowManager)paramView.getContext().getSystemService("window");
    int i = 2005;
    if (TXCBuild.VersionInt() >= 26) {
      i = 2038;
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(i);
      localLayoutParams.flags = 8;
      localLayoutParams.flags |= 0x40000;
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.format = -3;
      localWindowManager.addView(paramView, localLayoutParams);
      AppMethodBeat.o(230729);
      return;
      if (TXCBuild.VersionInt() > 24) {
        i = 2002;
      }
    }
  }
  
  private void startRemoteRender(TXCRenderAndDec paramTXCRenderAndDec, int paramInt)
  {
    AppMethodBeat.i(15957);
    paramTXCRenderAndDec.stopVideo();
    paramTXCRenderAndDec.setStreamType(paramInt);
    paramTXCRenderAndDec.startVideo();
    AppMethodBeat.o(15957);
  }
  
  private void stopLocalAudioInternal()
  {
    AppMethodBeat.i(230743);
    if (!this.mIsAudioCapturing)
    {
      apiLog("stopLocalAudio when no capturing audio, ignore!!!");
      AppMethodBeat.o(230743);
      return;
    }
    apiOnlineLog("stopLocalAudio");
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 2L, -1L, "", 0);
    this.mIsAudioCapturing = false;
    TXCAudioEngine.getInstance().stopLocalAudio();
    if (!this.mEnableCustomAudioCapture) {
      enableAudioStream(false);
    }
    TXCKeyPointReportProxy.a(40050, 0, 1);
    TXCLog.i("TRTCCloudImpl", "(%d)stopLocalAudioInternal end", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(230743);
  }
  
  private void stopRemoteMainRender(TRTCRoomInfo.UserInfo paramUserInfo, Boolean paramBoolean)
  {
    AppMethodBeat.i(15959);
    if (paramUserInfo == null)
    {
      AppMethodBeat.o(15959);
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(paramUserInfo.streamType) }));
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 2, paramBoolean.booleanValue());
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 3, paramBoolean.booleanValue());
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.stopVideo();
    }
    AppMethodBeat.o(15959);
  }
  
  private void stopRemoteSubRender(TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(15958);
    if (paramUserInfo == null)
    {
      AppMethodBeat.o(15958);
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(7) }));
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 7, false);
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.stopVideo();
    }
    AppMethodBeat.o(15958);
  }
  
  private int translateAudioAbnormalDetectState(int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      return 1;
    }
    if ((paramInt & 0x2) != 0) {
      return 2;
    }
    if ((paramInt & 0x4) != 0) {
      return 3;
    }
    return 0;
  }
  
  private int translateStreamType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return 0;
    case 3: 
      return 1;
    }
    return 2;
  }
  
  private void updateBigStreamEncoder(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, boolean paramBoolean3)
  {
    AppMethodBeat.i(230759);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.bigEncSize.a = paramInt1;
      this.mRoomInfo.bigEncSize.b = paramInt2;
      if (this.mVideoSourceType == VideoSourceType.SCREEN)
      {
        this.mConfig.m = 1;
        this.mConfig.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
        this.mConfig.l = com.tencent.liteav.basic.b.c.a;
      }
    }
    else
    {
      if (paramInt3 > 0)
      {
        if (paramInt3 <= 30) {
          break label414;
        }
        apiLog("setVideoEncoderParam fps > 30, limit fps to 30");
        this.mConfig.i = 30;
      }
      label126:
      if (paramInt4 > 0) {
        this.mConfig.c = paramInt4;
      }
      if (paramInt5 >= 0) {
        this.mConfig.e = paramInt5;
      }
      if (this.mVideoSourceType != VideoSourceType.SCREEN) {
        break label426;
      }
      this.mConfig.j = 3;
      this.mConfig.q = false;
      if (this.mOverrideFPSFromUser) {
        this.mConfig.i = 10;
      }
    }
    for (;;)
    {
      setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.i, this.mConfig.c, this.mConfig.q, this.mConfig.e, paramBoolean3);
      if ((this.mCodecType == 2) && (this.mConfig.a * this.mConfig.b >= 518400)) {
        this.mConfig.k = 1;
      }
      this.mCaptureAndEnc.e(this.mConfig.i);
      this.mCaptureAndEnc.a(this.mConfig);
      AppMethodBeat.o(230759);
      return;
      if (paramBoolean1)
      {
        this.mConfig.m = 1;
        this.mConfig.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
        break;
      }
      this.mConfig.m = 0;
      this.mConfig.a = this.mRoomInfo.bigEncSize.b;
      this.mConfig.b = this.mRoomInfo.bigEncSize.a;
      break;
      label414:
      this.mConfig.i = paramInt3;
      break label126;
      label426:
      this.mConfig.q = paramBoolean2;
    }
  }
  
  private void updateEncType()
  {
    if ((this.mCodecType == 0) || (this.mCodecType == 1)) {
      this.mConfig.k = this.mCodecType;
    }
    while (this.mAppScene != 1) {
      return;
    }
    this.mConfig.k = 1;
  }
  
  private void updateOrientation()
  {
    AppMethodBeat.i(15988);
    if ((this.mVideoSourceType == VideoSourceType.CUSTOM) || (this.mVideoSourceType == VideoSourceType.SCREEN))
    {
      AppMethodBeat.o(15988);
      return;
    }
    if (this.mCurrentOrientation == -1) {
      if (com.tencent.liteav.basic.util.h.g(this.mContext) != 1) {
        break label72;
      }
    }
    label72:
    for (this.mCurrentOrientation = 0;; this.mCurrentOrientation = 1)
    {
      setOrientation(this.mCurrentOrientation);
      AppMethodBeat.o(15988);
      return;
    }
  }
  
  private void updateSmallStreamEncoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(230761);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.smallEncSize.a = paramInt1;
      this.mRoomInfo.smallEncSize.b = paramInt2;
    }
    if (paramInt3 > 0)
    {
      if (paramInt3 <= 20) {
        break label246;
      }
      apiLog("setVideoSmallEncoderParam fps > 20, limit fps to 20");
    }
    label246:
    for (this.mSmallEncParam.videoFps = 20;; this.mSmallEncParam.videoFps = paramInt3)
    {
      if (paramInt4 > 0) {
        this.mSmallEncParam.videoBitrate = paramInt4;
      }
      if (paramInt5 >= 0) {
        this.mSmallEncParam.minVideoBitrate = paramInt5;
      }
      paramInt1 = this.mConfig.j;
      if (this.mVideoSourceType == VideoSourceType.SCREEN)
      {
        this.mSmallEncParam.enableAdjustRes = false;
        paramInt2 = 3;
        paramInt1 = paramInt2;
        if (this.mOverrideFPSFromUser)
        {
          this.mSmallEncParam.videoFps = 10;
          paramInt1 = paramInt2;
        }
      }
      this.mCaptureAndEnc.a(this.mEnableSmallStream, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, paramInt1);
      setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.q, this.mSmallEncParam.minVideoBitrate, false);
      AppMethodBeat.o(230761);
      return;
    }
  }
  
  public void ConnectOtherRoom(final String paramString)
  {
    AppMethodBeat.i(15788);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15691);
        TRTCCloudImpl.this.apiOnlineLog("ConnectOtherRoom");
        TRTCCloudImpl.access$1700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramString);
        AppMethodBeat.o(15691);
      }
    });
    AppMethodBeat.o(15788);
  }
  
  public void DisconnectOtherRoom()
  {
    AppMethodBeat.i(15789);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15564);
        TRTCCloudImpl.access$1800(TRTCCloudImpl.this, "");
        AppMethodBeat.o(15564);
      }
    });
    AppMethodBeat.o(15789);
  }
  
  public void apiLog(String paramString)
  {
    AppMethodBeat.i(15971);
    TXCLog.i("TRTCCloudImpl", "(" + hashCode() + ")trtc_api " + paramString);
    AppMethodBeat.o(15971);
  }
  
  protected void apiLog(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(231410);
    TXCLog.i("TRTCCloudImpl", "(" + hashCode() + ")trtc_api " + String.format(paramString, paramVarArgs));
    AppMethodBeat.o(231410);
  }
  
  public void apiOnlineLog(String paramString)
  {
    AppMethodBeat.i(231413);
    String str = "(" + hashCode() + ")trtc_api";
    Monitor.a(1, paramString + " self:" + hashCode(), "", 0, str);
    AppMethodBeat.o(231413);
  }
  
  protected void apiOnlineLog(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(231419);
    String str = "(" + hashCode() + ")trtc_api";
    Monitor.a(1, String.format(paramString, paramVarArgs) + " self:" + hashCode(), "", 0, str);
    AppMethodBeat.o(231419);
  }
  
  public void callExperimentalAPI(final String paramString)
  {
    AppMethodBeat.i(15867);
    Object localObject2 = "";
    final Object localObject1 = localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      if (!((JSONObject)localObject3).has("api"))
      {
        localObject1 = localObject2;
        apiLog("callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(15867);
        return;
      }
      localObject1 = localObject2;
      localObject2 = ((JSONObject)localObject3).getString("api");
      localObject1 = localObject2;
      if (!((JSONObject)localObject3).has("params"))
      {
        localObject1 = localObject2;
        apiLog("callExperimentalAPI[lack params or illegal type]: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(15867);
        return;
      }
      localObject1 = localObject2;
      localObject3 = ((JSONObject)localObject3).getJSONObject("params");
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      final JSONObject localJSONObject;
      for (;;)
      {
        apiLog("callExperimentalAPI[failed]: " + paramString + " " + localException);
        localJSONObject = null;
        continue;
        Object localObject3 = paramString;
        continue;
        localObject3 = this.mRoomInfo.strRoomId;
      }
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15614);
          try
          {
            if (localObject1.equals("enableBlackStream"))
            {
              TRTCCloudImpl.access$6000(TRTCCloudImpl.this, localJSONObject);
              AppMethodBeat.o(15614);
              return;
            }
            if (localObject1.equals("setSEIPayloadType"))
            {
              TRTCCloudImpl.this.setSEIPayloadType(localJSONObject);
              AppMethodBeat.o(15614);
              return;
            }
          }
          catch (Exception localException)
          {
            TRTCCloudImpl.this.apiLog("callExperimentalAPI[failed]: ".concat(String.valueOf(localException)));
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setLocalAudioMuteMode"))
          {
            TRTCCloudImpl.access$6100(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setVideoEncodeParamEx"))
          {
            TRTCCloudImpl.access$6200(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setAudioSampleRate"))
          {
            TRTCCloudImpl.access$6300(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("muteRemoteAudioInSpeaker"))
          {
            TRTCCloudImpl.this.muteRemoteAudioInSpeaker(localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("enableAudioAGC"))
          {
            TRTCCloudImpl.access$6400(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("enableAudioAEC"))
          {
            TRTCCloudImpl.access$6500(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("enableAudioANS"))
          {
            TRTCCloudImpl.access$6600(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setPerformanceMode"))
          {
            TRTCCloudImpl.this.setPerformanceMode(localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setCustomRenderMode"))
          {
            TRTCCloudImpl.access$6700(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setMediaCodecConfig"))
          {
            TRTCCloudImpl.access$6800(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("sendJsonCMD"))
          {
            TRTCCloudImpl.this.sendJsonCmd(localJSONObject, paramString);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("updatePrivateMapKey"))
          {
            TRTCCloudImpl.this.updatePrivateMapKey(localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setFramework"))
          {
            TRTCCloudImpl.access$6900(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("forceCallbackMixedPlayAudioFrame"))
          {
            TRTCCloudImpl.access$7000(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setSystemAudioKitEnabled"))
          {
            TXCAudioEngine.getInstance().setSystemAudioKitEnabled();
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setKeepAVCaptureOption"))
          {
            TRTCCloudImpl.access$7100(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setHeartBeatTimeoutSec"))
          {
            TRTCCloudImpl.access$7200(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setNetEnv"))
          {
            TRTCCloudImpl.access$7300(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("SetAudioCacheParams"))
          {
            TXCAudioEngine.getInstance().SetAudioCacheParams(localJSONObject.getInt("min_cache_time"), localJSONObject.getInt("max_cache_time"));
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setRoomType"))
          {
            TRTCCloudImpl.this.setRoomType(localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setAVSyncPlaySources"))
          {
            TRTCCloudImpl.access$7400(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("enableHevcEncode"))
          {
            TRTCCloudImpl.access$7500(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("setCustomCaptureGLSyncMode"))
          {
            TRTCCloudImpl.access$7600(TRTCCloudImpl.this, localJSONObject);
            AppMethodBeat.o(15614);
            return;
          }
          if (localObject1.equals("disconnectOtherRoom"))
          {
            TRTCCloudImpl.access$1800(TRTCCloudImpl.this, localJSONObject.toString());
            AppMethodBeat.o(15614);
            return;
          }
          TRTCCloudImpl.this.apiLog("callExperimentalAPI[illegal api]: " + localObject1);
          AppMethodBeat.o(15614);
        }
      });
      AppMethodBeat.o(15867);
      return;
    }
    localObject3 = Arrays.asList(new String[] { "updatePrivateMapKey", "disconnectOtherRoom" }).iterator();
    do
    {
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
    } while (!localObject1.equals((String)((Iterator)localObject3).next()));
    for (int i = 1;; i = 0)
    {
      StringBuilder localStringBuilder = new StringBuilder("callExperimentalAPI ");
      if (i != 0)
      {
        localObject3 = localObject1;
        localStringBuilder = localStringBuilder.append((String)localObject3).append(", roomid = ");
        if (this.mRoomInfo.roomId == -1L) {
          continue;
        }
        localObject3 = Long.valueOf(this.mRoomInfo.roomId);
        apiOnlineLog(localObject3);
        if (!localObject1.equals("setEncodedDataProcessingListener")) {
          continue;
        }
        setEncodedDataProcessingListener((JSONObject)localObject2);
        AppMethodBeat.o(15867);
      }
    }
  }
  
  protected void checkDashBoard()
  {
    AppMethodBeat.i(15977);
    if (this.mDebugType != 0)
    {
      final TXCloudVideoView localTXCloudVideoView = this.mRoomInfo.localView;
      if (localTXCloudVideoView != null)
      {
        final CharSequence localCharSequence = getUploadStreamInfo();
        TXCLog.i("TRTCCloudImpl", "[STATUS]" + localCharSequence.toString().replace("\n", "") + " self:" + hashCode());
        runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230812);
            localTXCloudVideoView.setDashBoardStatusInfo(localCharSequence);
            AppMethodBeat.o(230812);
          }
        });
      }
    }
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(230815);
        if ((paramAnonymousUserInfo.mainRender.render != null) && (paramAnonymousUserInfo.mainRender.render.isRendering())) {
          paramAnonymousUserInfo.mainRender.render.updateLoadInfo();
        }
        if ((paramAnonymousUserInfo.subRender.render != null) && (paramAnonymousUserInfo.subRender.render.isRendering())) {
          paramAnonymousUserInfo.subRender.render.updateLoadInfo();
        }
        if (TRTCCloudImpl.this.mDebugType != 0)
        {
          TRTCCloudImpl.this.checkRemoteDashBoard(paramAnonymousUserInfo.mainRender.view, paramAnonymousUserInfo.mainRender.render, paramAnonymousUserInfo);
          TRTCCloudImpl.this.checkRemoteDashBoard(paramAnonymousUserInfo.subRender.view, paramAnonymousUserInfo.subRender.render, paramAnonymousUserInfo);
        }
        AppMethodBeat.o(230815);
      }
    });
    AppMethodBeat.o(15977);
  }
  
  public void checkRemoteDashBoard(final TXCloudVideoView paramTXCloudVideoView, final TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(15976);
    if ((paramTXCloudVideoView != null) && (paramTXCRenderAndDec != null) && (paramTXCRenderAndDec.isRendering()))
    {
      paramTXCRenderAndDec = getDownloadStreamInfo(paramTXCRenderAndDec, paramUserInfo);
      TXCLog.i("TRTCCloudImpl", "[STATUS]" + paramTXCRenderAndDec.toString().replace("\n", "") + " self:" + hashCode());
      runOnMainThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230813);
          paramTXCloudVideoView.setDashBoardStatusInfo(paramTXCRenderAndDec);
          AppMethodBeat.o(230813);
        }
      });
    }
    AppMethodBeat.o(15976);
  }
  
  protected void checkUserState(final String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15974);
    final TRTCCloudListener localTRTCCloudListener = this.mTRTCListener;
    final boolean bool1;
    boolean bool2;
    label62:
    int i;
    label72:
    label211:
    label238:
    label248:
    int j;
    label267:
    TRTCRoomInfo.UserInfo localUserInfo;
    if ((localTRTCCloudListener != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!TRTCRoomInfo.hasAudio(paramInt1)) || (TRTCRoomInfo.isMuteAudio(paramInt1))) {
        break label667;
      }
      bool1 = true;
      if ((!TRTCRoomInfo.hasAudio(paramInt2)) || (TRTCRoomInfo.isMuteAudio(paramInt2))) {
        break label673;
      }
      bool2 = true;
      if (bool2 == bool1) {
        break label679;
      }
      i = 1;
      if (i != 0)
      {
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230773);
            localTRTCCloudListener.onUserAudioAvailable(paramString, bool1);
            AppMethodBeat.o(230773);
          }
        });
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }) + " self:" + hashCode(), "", 0);
      }
      if (((!TRTCRoomInfo.hasMainVideo(paramInt1)) && (!TRTCRoomInfo.hasSmallVideo(paramInt1))) || (TRTCRoomInfo.isMuteMainVideo(paramInt1))) {
        break label685;
      }
      bool1 = true;
      if (((!TRTCRoomInfo.hasMainVideo(paramInt2)) && (!TRTCRoomInfo.hasSmallVideo(paramInt2))) || (TRTCRoomInfo.isMuteMainVideo(paramInt2))) {
        break label691;
      }
      bool2 = true;
      if (bool2 == bool1) {
        break label697;
      }
      i = 1;
      if ((this.mRecvMode == 3) || (this.mRecvMode == 1)) {
        break label703;
      }
      j = 1;
      if (i != 0)
      {
        localUserInfo = this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.mainRender.render != null))
        {
          localUserInfo.mainRender.render.resetPeriodStatistics();
          localUserInfo.mainRender.render.enableReport(bool1);
        }
      }
      if ((i != 0) && ((this.mRoomInfo.hasRecvFirstIFrame(paramLong)) || (j != 0)))
      {
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230820);
            localTRTCCloudListener.onUserVideoAvailable(paramString, bool1);
            AppMethodBeat.o(230820);
          }
        });
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }) + " self:" + hashCode(), "", 0);
      }
      if ((!TRTCRoomInfo.hasSubVideo(paramInt1)) || (TRTCRoomInfo.isMuteSubVideo(paramInt1))) {
        break label709;
      }
      bool1 = true;
      label469:
      if ((!TRTCRoomInfo.hasSubVideo(paramInt2)) || (TRTCRoomInfo.isMuteSubVideo(paramInt2))) {
        break label715;
      }
      bool2 = true;
      label488:
      if (bool2 == bool1) {
        break label721;
      }
    }
    label667:
    label673:
    label679:
    label685:
    label691:
    label697:
    label703:
    label709:
    label715:
    label721:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        localUserInfo = this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.subRender.render != null))
        {
          localUserInfo.subRender.render.resetPeriodStatistics();
          localUserInfo.subRender.render.enableReport(bool1);
        }
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230816);
            localTRTCCloudListener.onUserSubStreamAvailable(paramString, bool1);
            AppMethodBeat.o(230816);
          }
        });
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }) + " self:" + hashCode(), "", 0);
      }
      AppMethodBeat.o(15974);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label62;
      i = 0;
      break label72;
      bool1 = false;
      break label211;
      bool2 = false;
      break label238;
      i = 0;
      break label248;
      j = 0;
      break label267;
      bool1 = false;
      break label469;
      bool2 = false;
      break label488;
    }
  }
  
  protected void clearRemoteMuteStates()
  {
    AppMethodBeat.i(231066);
    this.mRoomInfo.muteRemoteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
    this.mRoomInfo.muteRemoteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        paramAnonymousUserInfo.mainRender.muteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
        paramAnonymousUserInfo.mainRender.muteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
      }
    });
    AppMethodBeat.o(231066);
  }
  
  public TRTCCloud createSubCloud()
  {
    AppMethodBeat.i(231079);
    final TRTCSubCloud localTRTCSubCloud = new TRTCSubCloud(this.mContext, new WeakReference(this), this.mSDKHandler);
    localTRTCSubCloud.setListenerHandler(this.mListenerHandler);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15766);
        TRTCCloudImpl.this.mSubClouds.add(new WeakReference(localTRTCSubCloud));
        AppMethodBeat.o(15766);
      }
    });
    AppMethodBeat.o(231079);
    return localTRTCSubCloud;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(15782);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15578);
        TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(false);
        synchronized (TRTCCloudImpl.this.mNativeLock)
        {
          if (TRTCCloudImpl.this.mNativeRtcContext != 0L)
          {
            TRTCCloudImpl.this.apiLog("destroy context");
            TRTCCloudImpl.this.nativeDestroyContext(TRTCCloudImpl.this.mNativeRtcContext);
          }
          TRTCCloudImpl.this.mNativeRtcContext = 0L;
          TRTCCloudImpl.this.mTRTCListener = null;
          TRTCCloudImpl.this.mAudioFrameListener = null;
          TRTCCloudImpl.this.setAudioCaptureVolume(100);
          TRTCCloudImpl.this.setAudioPlayoutVolume(100);
          TXCSoundEffectPlayer.getInstance().setSoundEffectListener(null);
          TXCAudioEngine.getInstance().clean();
          TXCAudioEngine.getInstance().UnInitAudioDevice();
        }
        synchronized (TRTCCloudImpl.this.mCurrentPublishClouds)
        {
          TRTCCloudImpl.this.mCurrentPublishClouds.clear();
          ??? = TRTCCloudImpl.this.mSubClouds.iterator();
          while (((Iterator)???).hasNext())
          {
            TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)((Iterator)???).next()).get();
            if (localTRTCCloudImpl != null)
            {
              localTRTCCloudImpl.destroy();
              continue;
              localObject2 = finally;
              AppMethodBeat.o(15578);
              throw localObject2;
            }
          }
        }
        TRTCCloudImpl.this.mSubClouds.clear();
        com.tencent.liteav.audio.a.a().a(TRTCCloudImpl.this.hashCode());
        TRTCCloudImpl.this.mIsSDKThreadAlive.set(false);
        try
        {
          if (TRTCCloudImpl.this.mSDKHandler != null) {
            TRTCCloudImpl.this.mSDKHandler.getLooper().quit();
          }
          TRTCCloudImpl.this.apiLog("destroy instance finish.");
          AppMethodBeat.o(15578);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            TXCLog.e("TRTCCloudImpl", "(" + TRTCCloudImpl.this.hashCode() + ") error occur when quit looper.", localException);
          }
        }
        catch (Error localError)
        {
          for (;;)
          {
            TXCLog.e("TRTCCloudImpl", "(" + TRTCCloudImpl.this.hashCode() + ") error occur when quit looper.");
          }
        }
      }
    });
    AppMethodBeat.o(15782);
  }
  
  public void destroySubCloud(final TRTCCloud paramTRTCCloud)
  {
    AppMethodBeat.i(231080);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15639);
        Iterator localIterator = TRTCCloudImpl.this.mSubClouds.iterator();
        while (localIterator.hasNext())
        {
          TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)localIterator.next()).get();
          if ((localTRTCCloudImpl != null) && (localTRTCCloudImpl == paramTRTCCloud))
          {
            localTRTCCloudImpl.destroy();
            localIterator.remove();
            AppMethodBeat.o(15639);
            return;
          }
        }
        AppMethodBeat.o(15639);
      }
    });
    AppMethodBeat.o(231080);
  }
  
  public void enableAudioEarMonitoring(final boolean paramBoolean)
  {
    AppMethodBeat.i(15824);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15652);
        TRTCCloudImpl.this.apiOnlineLog("enableAudioEarMonitoring enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        TXAudioEffectManagerImpl.getInstance().enableVoiceEarMonitor(paramBoolean);
        AppMethodBeat.o(15652);
      }
    });
    AppMethodBeat.o(15824);
  }
  
  protected void enableAudioStream(boolean paramBoolean)
  {
    AppMethodBeat.i(15962);
    if (paramBoolean)
    {
      addUpStreamType(1);
      AppMethodBeat.o(15962);
      return;
    }
    removeUpStreamType(1);
    AppMethodBeat.o(15962);
  }
  
  public void enableAudioVolumeEvaluation(final int paramInt)
  {
    AppMethodBeat.i(15829);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 100;
        AppMethodBeat.i(15695);
        if (paramInt > 0) {
          if (paramInt >= 100) {}
        }
        while (i == TRTCCloudImpl.this.mAudioVolumeEvalInterval)
        {
          AppMethodBeat.o(15695);
          return;
          i = paramInt;
          continue;
          i = 0;
        }
        TRTCCloudImpl.this.apiLog("enableAudioVolumeEvaluation ".concat(String.valueOf(i)));
        TRTCCloudImpl.this.mAudioVolumeEvalInterval = i;
        if (TRTCCloudImpl.this.mAudioVolumeEvalInterval > 0)
        {
          TRTCCloudImpl.this.startVolumeLevelCal(true);
          AppMethodBeat.o(15695);
          return;
        }
        TRTCCloudImpl.this.startVolumeLevelCal(false);
        AppMethodBeat.o(15695);
      }
    });
    AppMethodBeat.o(15829);
  }
  
  public void enableCustomAudioCapture(final boolean paramBoolean)
  {
    AppMethodBeat.i(15871);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        AppMethodBeat.i(15690);
        if (TRTCCloudImpl.this.mEnableCustomAudioCapture == paramBoolean)
        {
          AppMethodBeat.o(15690);
          return;
        }
        TRTCCloudImpl.access$1402(TRTCCloudImpl.this, paramBoolean);
        com.tencent.liteav.g localg;
        if (paramBoolean)
        {
          localg = TRTCCloudImpl.this.mConfig;
          localg.S |= 0x1;
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230707);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(230707);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore send custom audio,for role audience", null);
                AppMethodBeat.o(230707);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore enableCustomAudioCapture,for role audience");
          }
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TRTCCloudImpl.this.apiOnlineLog("enableCustomAudioCapture " + paramBoolean);
          if (!TRTCCloudImpl.this.mIsAudioCapturing) {
            TRTCCloudImpl.this.enableAudioStream(paramBoolean);
          }
          if (!paramBoolean) {
            break label263;
          }
          TRTCCloudImpl.access$5200(TRTCCloudImpl.this);
          TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
          TXCAudioEngine.getInstance().startLocalAudio(11, true);
          TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
          TXCEventRecorderProxy.a("18446744073709551615", 3003, 11L, -1L, "", 0);
        }
        for (;;)
        {
          if (paramBoolean) {
            i = 1;
          }
          TXCKeyPointReportProxy.a(40050, i, 1);
          AppMethodBeat.o(15690);
          return;
          localg = TRTCCloudImpl.this.mConfig;
          localg.S &= 0xFFFFFFFE;
          break;
          label263:
          TXCAudioEngine.getInstance().stopLocalAudio();
        }
      }
    });
    AppMethodBeat.o(15871);
  }
  
  public void enableCustomVideoCapture(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(231229);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 1;
        AppMethodBeat.i(15579);
        if (paramInt == 2)
        {
          if (paramBoolean)
          {
            if (TRTCCloudImpl.this.mCurrentRole == 21)
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(15776);
                  TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                  if (localTRTCCloudListener == null)
                  {
                    AppMethodBeat.o(15776);
                    return;
                  }
                  localTRTCCloudListener.onWarning(6001, "ignore send custom video,for role audience", null);
                  AppMethodBeat.o(15776);
                }
              });
              TRTCCloudImpl.this.apiLog("ignore enableCustomVideoCapture,for role audience");
            }
            TRTCCloudImpl.this.apiOnlineLog("enableCustomVideoCapture stremType:%d enable:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
            if (!paramBoolean) {
              break label185;
            }
            TRTCCloudImpl.access$4800(TRTCCloudImpl.this, 7);
            if (!paramBoolean) {
              break label197;
            }
          }
          for (;;)
          {
            for (;;)
            {
              TXCKeyPointReportProxy.a(40046, i, 7);
              AppMethodBeat.o(15579);
              return;
              synchronized (TRTCCloudImpl.this.mCustomCaptureLock)
              {
                if (TRTCCloudImpl.this.mCustomSubStreamVideoUtil != null)
                {
                  TRTCCloudImpl.this.mCustomSubStreamVideoUtil.release();
                  TRTCCloudImpl.access$5802(TRTCCloudImpl.this, null);
                }
              }
            }
            label185:
            TRTCCloudImpl.access$5000(TRTCCloudImpl.this, 7);
            break;
            label197:
            i = 0;
          }
        }
        TRTCCloudImpl.this.enableCustomVideoCapture(paramBoolean);
        AppMethodBeat.o(15579);
      }
    });
    AppMethodBeat.o(231229);
  }
  
  public void enableCustomVideoCapture(final boolean paramBoolean)
  {
    AppMethodBeat.i(15854);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15657);
        if ((paramBoolean) && (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE))
        {
          TRTCCloudImpl.access$3300(TRTCCloudImpl.this, "Has started capturing, ignore enableCustomVideoCapture");
          AppMethodBeat.o(15657);
          return;
        }
        if ((!paramBoolean) && (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.CUSTOM))
        {
          AppMethodBeat.o(15657);
          return;
        }
        TRTCCloudImpl.access$1300(TRTCCloudImpl.this);
        TRTCCloudImpl localTRTCCloudImpl = TRTCCloudImpl.this;
        if (paramBoolean)
        {
          ??? = TRTCCloudImpl.VideoSourceType.CUSTOM;
          TRTCCloudImpl.access$1602(localTRTCCloudImpl, (TRTCCloudImpl.VideoSourceType)???);
          if (!paramBoolean) {
            break label259;
          }
          ??? = TRTCCloudImpl.this.mConfig;
          ((com.tencent.liteav.g)???).S |= 0x2;
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(15714);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(15714);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore send custom video,for role audience", null);
                AppMethodBeat.o(15714);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore enableCustomVideoCapture,for role audience");
          }
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TRTCCloudImpl.access$2502(TRTCCloudImpl.this, paramBoolean);
          TRTCCloudImpl.this.apiOnlineLog("enableCustomVideoCapture " + paramBoolean);
          if (!paramBoolean) {
            break label333;
          }
          TRTCCloudImpl.this.enableVideoStream(true);
          label229:
          if (!paramBoolean) {
            break label354;
          }
        }
        label259:
        label333:
        label354:
        for (int i = 1;; i = 0)
        {
          for (;;)
          {
            TXCKeyPointReportProxy.a(40046, i, 2);
            AppMethodBeat.o(15657);
            return;
            ??? = TRTCCloudImpl.VideoSourceType.NONE;
            break;
            ??? = TRTCCloudImpl.this.mConfig;
            ((com.tencent.liteav.g)???).S &= 0xFFFFFFFD;
            synchronized (TRTCCloudImpl.this.mCustomCaptureLock)
            {
              if (TRTCCloudImpl.this.mCustomVideoUtil != null)
              {
                TRTCCloudImpl.this.mCustomVideoUtil.release();
                TRTCCloudImpl.access$5902(TRTCCloudImpl.this, null);
              }
            }
          }
          if (TRTCCloudImpl.this.mIsVideoCapturing) {
            break label229;
          }
          TRTCCloudImpl.this.enableVideoStream(false);
          break label229;
        }
      }
    });
    AppMethodBeat.o(15854);
  }
  
  public int enableEncSmallVideoStream(final boolean paramBoolean, final TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    AppMethodBeat.i(15811);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15703);
        TRTCCloudImpl.this.apiLog("enableEncSmallVideoStream " + paramBoolean);
        TRTCCloudImpl.access$902(TRTCCloudImpl.this, paramBoolean);
        TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
        if (paramTRTCVideoEncParam != null)
        {
          TRTCCloudImpl.this.mSmallEncParam.videoBitrate = paramTRTCVideoEncParam.videoBitrate;
          TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate = paramTRTCVideoEncParam.minVideoBitrate;
          TRTCCloudImpl.this.mSmallEncParam.videoFps = paramTRTCVideoEncParam.videoFps;
          TRTCCloudImpl.this.mSmallEncParam.videoResolution = paramTRTCVideoEncParam.videoResolution;
          TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode = paramTRTCVideoEncParam.videoResolutionMode;
          TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.putInt("config_fps", paramTRTCVideoEncParam.videoFps);
          TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.putBoolean("config_adjust_resolution", paramTRTCVideoEncParam.enableAdjustRes);
        }
        boolean bool = TRTCCloudImpl.this.mConfig.q;
        int i = TRTCCloudImpl.this.mConfig.j;
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          i = 3;
          if (TRTCCloudImpl.this.mOverrideFPSFromUser) {
            TRTCCloudImpl.this.mSmallEncParam.videoFps = 10;
          }
          bool = false;
        }
        for (;;)
        {
          TRTCCloudImpl.this.mRoomInfo.smallEncSize = TRTCCloudImpl.access$3800(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, i);
          if (TRTCCloudImpl.this.mEnableSmallStream)
          {
            TRTCCloudImpl.access$4700(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, bool, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate, false);
            TRTCCloudImpl.access$4800(TRTCCloudImpl.this, 3);
            AppMethodBeat.o(15703);
            return;
          }
          TRTCCloudImpl.access$4900(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.q, 0, false);
          TRTCCloudImpl.access$5000(TRTCCloudImpl.this, 3);
          AppMethodBeat.o(15703);
          return;
        }
      }
    });
    AppMethodBeat.o(15811);
    return 0;
  }
  
  public void enableMixExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(231265);
    if (paramBoolean1) {
      if (this.mPublishAudioTunnelId < 0) {
        this.mPublishAudioTunnelId = TXCAudioEngineJNI.nativeOpenAudioTunnel(true);
      }
    }
    while (paramBoolean2)
    {
      if (this.mPlayoutAudioTunnelId >= 0) {
        break label92;
      }
      this.mPlayoutAudioTunnelId = TXCAudioEngineJNI.nativeOpenAudioTunnel(false);
      AppMethodBeat.o(231265);
      return;
      if (this.mPublishAudioTunnelId >= 0)
      {
        TXCAudioEngineJNI.nativeCloseAudioTunnel(this.mPublishAudioTunnelId);
        this.mPublishAudioTunnelId = -1;
      }
    }
    if (this.mPlayoutAudioTunnelId >= 0)
    {
      TXCAudioEngineJNI.nativeCloseAudioTunnel(this.mPlayoutAudioTunnelId);
      this.mPlayoutAudioTunnelId = -1;
    }
    label92:
    AppMethodBeat.o(231265);
  }
  
  public void enableNetworkBlackStream(boolean paramBoolean)
  {
    AppMethodBeat.i(231442);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableBlackStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
    AppMethodBeat.o(231442);
  }
  
  public void enableNetworkSmallStream(boolean paramBoolean)
  {
    AppMethodBeat.i(231443);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableSmallStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
    AppMethodBeat.o(231443);
  }
  
  public boolean enableTorch(boolean paramBoolean)
  {
    AppMethodBeat.i(15836);
    paramBoolean = this.mDeviceManager.enableCameraTorch(paramBoolean);
    AppMethodBeat.o(15836);
    return paramBoolean;
  }
  
  protected void enableVideoStream(boolean paramBoolean)
  {
    AppMethodBeat.i(15961);
    if (paramBoolean)
    {
      addUpStreamType(2);
      if (this.mEnableSmallStream)
      {
        addUpStreamType(3);
        AppMethodBeat.o(15961);
      }
    }
    else
    {
      if (!this.mCaptureAndEnc.j()) {
        removeUpStreamType(2);
      }
      removeUpStreamType(3);
    }
    AppMethodBeat.o(15961);
  }
  
  public void enterRoom(final TRTCCloudDef.TRTCParams paramTRTCParams, final int paramInt)
  {
    AppMethodBeat.i(15785);
    if (paramTRTCParams == null)
    {
      apiLog("enter room, param nil!");
      onEnterRoom(-3316, "enter room param null");
      AppMethodBeat.o(15785);
      return;
    }
    final TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams(paramTRTCParams);
    if ((localTRTCParams.sdkAppId == 0) || (TextUtils.isEmpty(localTRTCParams.userId)) || (TextUtils.isEmpty(localTRTCParams.userSig)))
    {
      apiLog("enterRoom param invalid:".concat(String.valueOf(localTRTCParams)));
      if (localTRTCParams.sdkAppId == 0) {
        onEnterRoom(-3317, "enter room sdkAppId invalid.");
      }
      if (TextUtils.isEmpty(localTRTCParams.userSig)) {
        onEnterRoom(-3320, "enter room userSig invalid.");
      }
      if (TextUtils.isEmpty(localTRTCParams.userId)) {
        onEnterRoom(-3319, "enter room userId invalid.");
      }
      AppMethodBeat.o(15785);
      return;
    }
    final long l = 0xFFFFFFFF & localTRTCParams.roomId;
    paramTRTCParams = "";
    Object localObject = localTRTCParams.businessInfo;
    if ((l == 0L) || ((localTRTCParams.roomId == -1) && (!TextUtils.isEmpty((CharSequence)localObject))))
    {
      if (l == 0L) {
        paramTRTCParams = localTRTCParams.strRoomId;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          localObject = new StringBuilder("");
          extractBizInfo(localJSONObject, "strGroupId", (StringBuilder)localObject);
          if (localTRTCParams.roomId != -1) {
            break label399;
          }
          paramTRTCParams = ((StringBuilder)localObject).toString();
          localObject = "";
          if (localJSONObject.length() != 0) {
            localObject = localJSONObject.toString();
          }
        }
        catch (Exception paramTRTCParams)
        {
          for (;;)
          {
            label293:
            apiLog("enter room, room id error, busInfo " + localTRTCParams.businessInfo);
            paramTRTCParams = "";
            localObject = "";
          }
        }
        if (TextUtils.isEmpty(paramTRTCParams))
        {
          onEnterRoom(-3318, "room id invalid.");
          AppMethodBeat.o(15785);
          return;
        }
      }
    }
    for (;;)
    {
      TXCKeyPointReportProxy.a(30001);
      final int i = localTRTCParams.role;
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15658);
          TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByServer(false);
          Object localObject2 = localTRTCParams.userId;
          int i = localTRTCParams.sdkAppId;
          if (TextUtils.isEmpty(paramTRTCParams)) {}
          for (Object localObject1 = l;; localObject1 = paramTRTCParams)
          {
            Monitor.a((String)localObject2, i, (String)localObject1);
            if (TRTCCloudImpl.this.mRoomState == 0) {
              break label272;
            }
            if (((TextUtils.isEmpty(paramTRTCParams)) || (!paramTRTCParams.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.strRoomId))) && ((TRTCCloudImpl.this.mRoomInfo.roomId != l) || (l == 0L) || (l == -1L))) {
              break;
            }
            TRTCCloudImpl.this.apiLog(String.format("enter the same room[%d] again!!!", new Object[] { Long.valueOf(l) }));
            TRTCCloudImpl.this.mRoomInfo.enterTime = paramInt;
            TRTCCloudImpl.this.onEnterRoom(0, "enter the same room.");
            AppMethodBeat.o(15658);
            return;
          }
          TRTCCloudImpl.this.apiLog(String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l), Long.valueOf(TRTCCloudImpl.this.mRoomInfo.roomId) }));
          TRTCCloudImpl.this.mIsExitOldRoom = true;
          TRTCCloudImpl.this.exitRoom();
          label272:
          TRTCCloudImpl.this.apiLog("========================================================================================================");
          TRTCCloudImpl.this.apiLog("========================================================================================================");
          TRTCCloudImpl.this.apiLog(String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), TXCBuild.Model(), TXCBuild.Version() }));
          TRTCCloudImpl.this.apiLog("========================================================================================================");
          TRTCCloudImpl.this.apiLog("========================================================================================================");
          localObject2 = String.format("enterRoom roomId:%d(%s) userId:%s sdkAppId:%d scene:%d, bizinfo:%s", new Object[] { Long.valueOf(l), paramTRTCParams, localTRTCParams.userId, Integer.valueOf(localTRTCParams.sdkAppId), Integer.valueOf(i), jdField_this });
          i = i;
          localObject1 = "VideoCall";
          int j = 2;
          Object localObject3;
          Object localObject4;
          String str;
          label544:
          label674:
          int k;
          label686:
          int m;
          switch (i)
          {
          default: 
            TXCLog.w("TRTCCloudImpl", "enter room scene:%u error! default to VideoCall! " + i + " self:" + TRTCCloudImpl.this.hashCode());
            i = 0;
            TXCAudioEngine.getInstance().setAudioQuality(j, 1);
            localObject3 = TRTCCloudImpl.this;
            localObject4 = new StringBuilder().append((String)localObject2);
            str = jdField_this;
            if (this.val$finalRole == 20)
            {
              localObject2 = "Anchor";
              ((TRTCCloudImpl)localObject3).apiOnlineLog(String.format(" bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { str, localObject1, localObject2, localTRTCParams.streamId }));
              if (TRTCCloudImpl.this.mAudioFrameListener != null) {
                TXCAudioEngine.setPlayoutDataListener(this.val$refThis);
              }
              TXCEventRecorderProxy.a("18446744073709551615", 5001, l, -1L, "", 0);
              TXCStatus.a("18446744073709551615", 10003, TXCBuild.Model());
              TRTCCloudImpl.this.mRoomState = 1;
              if (TRTCCloudImpl.this.mNativeRtcContext == 0L)
              {
                localObject1 = TXCCommonUtil.getSDKVersion();
                if (localObject1.length <= 0) {
                  break label1687;
                }
                j = localObject1[0];
                if (localObject1.length < 2) {
                  break label1692;
                }
                k = localObject1[1];
                if (localObject1.length < 3) {
                  break label1697;
                }
                m = localObject1[2];
                label699:
                TRTCCloudImpl.this.mNativeRtcContext = TRTCCloudImpl.this.nativeCreateContext(j, k, m);
              }
              TRTCCloudImpl.this.updateAppScene(i);
              TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
              boolean bool = true;
              i = 1;
              if ((i != 0) || (TRTCCloudImpl.this.mCodecType != 2))
              {
                bool = false;
                i = 0;
              }
              TRTCCloudImpl.this.mCaptureAndEnc.h(bool);
              TRTCCloudImpl.access$800(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
              TRTCCloudImpl.this.flushBigVideoEncParamsIntoNetwork();
              TRTCCloudImpl.this.flushSmallVideoEncParamsIntoNetwork();
              TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.j);
              localObject1 = TXCBuild.Version();
              localObject3 = TXCBuild.Model();
              TRTCCloudImpl.access$1100(TRTCCloudImpl.this, (String)localObject3, (String)localObject1, localTRTCParams.sdkAppId);
              localObject2 = new TXCKeyPointReportProxy.a();
              ((TXCKeyPointReportProxy.a)localObject2).d = i;
              ((TXCKeyPointReportProxy.a)localObject2).e = ((String)localObject3);
              ((TXCKeyPointReportProxy.a)localObject2).f = ((String)localObject1);
              if (TRTCCloudImpl.this.mContext == null) {
                break label1703;
              }
              localObject1 = TRTCCloudImpl.this.mContext.getPackageName();
              label973:
              ((TXCKeyPointReportProxy.a)localObject2).h = ((String)localObject1);
              ((TXCKeyPointReportProxy.a)localObject2).b = localTRTCParams.sdkAppId;
              ((TXCKeyPointReportProxy.a)localObject2).g = TXCCommonUtil.getSDKVersionStr();
              ((TXCKeyPointReportProxy.a)localObject2).c = TRTCCloudImpl.this.mFramework;
              TXCKeyPointReportProxy.a((TXCKeyPointReportProxy.a)localObject2);
              TRTCCloudImpl.this.nativeSetPriorRemoteVideoStreamType(TRTCCloudImpl.this.mNativeRtcContext, TRTCCloudImpl.this.mPriorStreamType);
              localObject1 = TRTCCloudImpl.this.mRoomInfo.getToken(TRTCCloudImpl.this.mContext);
              TRTCCloudImpl.this.nativeInit(TRTCCloudImpl.this.mNativeRtcContext, localTRTCParams.sdkAppId, localTRTCParams.userId, localTRTCParams.userSig, (byte[])localObject1);
              TRTCCloudImpl.this.makeStreamsEffectiveAfterNetworkInited();
              TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
              TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.j());
              if (localTRTCParams.privateMapKey == null) {
                break label1710;
              }
              localObject1 = localTRTCParams.privateMapKey;
              label1152:
              if (paramTRTCParams == null) {
                break label1717;
              }
              localObject2 = paramTRTCParams;
              label1165:
              if (jdField_this == null) {
                break label1724;
              }
              localObject3 = jdField_this;
              label1178:
              if (localTRTCParams.userDefineRecordId == null) {
                break label1731;
              }
              localObject4 = localTRTCParams.userDefineRecordId;
              label1197:
              if (localTRTCParams.streamId == null) {
                break label1738;
              }
              str = localTRTCParams.streamId;
              label1216:
              j = 3;
              k = com.tencent.liteav.basic.util.g.a.a.a();
              if (TRTCCloudImpl.this.mAppScene != 1) {
                break label1745;
              }
              j = TRTCEncodeTypeDecision.getEnterRoomCodecSupportValue();
              TRTCCloudImpl.access$1300(TRTCCloudImpl.this);
              k = TRTCCloudImpl.this.mH265Decision.getExpectVideoCodecType(TRTCCloudImpl.this.mAppScene);
            }
            break;
          }
          for (;;)
          {
            TRTCCloudImpl.this.nativeEnterRoom(TRTCCloudImpl.this.mNativeRtcContext, l, (String)localObject3, (String)localObject1, (String)localObject2, this.val$finalRole, 255, i, i, TRTCCloudImpl.this.mPerformanceMode, TXCBuild.Model(), TXCBuild.Version(), TRTCCloudImpl.this.mRecvMode, (String)localObject4, str, TRTCCloudImpl.this.mRoomType, j, k);
            TRTCCloudImpl.this.mCurrentRole = this.val$finalRole;
            TRTCCloudImpl.this.mTargetRole = this.val$finalRole;
            if ((TRTCCloudImpl.this.mCurrentRole == 21) && ((TRTCCloudImpl.this.mEnableCustomAudioCapture) || (TRTCCloudImpl.this.mIsAudioCapturing) || (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)))
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230876);
                  TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                  if (localTRTCCloudListener == null)
                  {
                    AppMethodBeat.o(230876);
                    return;
                  }
                  localTRTCCloudListener.onWarning(6001, "ignore upstream for audience", null);
                  AppMethodBeat.o(230876);
                }
              });
              TRTCCloudImpl.this.apiLog("ignore upstream for audience, when enter room!!");
            }
            TRTCCloudImpl.this.mCaptureAndEnc.f();
            TRTCCloudImpl.this.startCollectStatus();
            TRTCCloudImpl.this.mLastStateTimeMs = 0L;
            TRTCCloudImpl.this.mRoomInfo.init(l, localTRTCParams.userId);
            TRTCCloudImpl.this.mRoomInfo.strRoomId = ((String)localObject2);
            TRTCCloudImpl.this.mRoomInfo.sdkAppId = localTRTCParams.sdkAppId;
            TRTCCloudImpl.this.mRoomInfo.userSig = localTRTCParams.userSig;
            TRTCCloudImpl.this.mRoomInfo.privateMapKey = ((String)localObject1);
            TRTCCloudImpl.this.mRoomInfo.enterTime = paramInt;
            TXCEventRecorderProxy.a("18446744073709551615", 4007, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.b, "", 2);
            TXCEventRecorderProxy.a("18446744073709551615", 4008, TRTCCloudImpl.this.mConfig.i, -1L, "", 2);
            TXCEventRecorderProxy.a("18446744073709551615", 4009, TRTCCloudImpl.this.mConfig.c, -1L, "", 2);
            AppMethodBeat.o(15658);
            return;
            localObject1 = "VideoCall";
            j = 1;
            break;
            localObject1 = "Live";
            j = 2;
            break;
            localObject1 = "AudioCall";
            j = 1;
            i = 0;
            break;
            localObject1 = "VoiceChatRoom";
            j = 2;
            i = 1;
            break;
            localObject2 = "Audience";
            break label544;
            label1687:
            j = 0;
            break label674;
            label1692:
            k = 0;
            break label686;
            label1697:
            m = 0;
            break label699;
            label1703:
            localObject1 = "";
            break label973;
            label1710:
            localObject1 = "";
            break label1152;
            label1717:
            localObject2 = "";
            break label1165;
            label1724:
            localObject3 = "";
            break label1178;
            label1731:
            localObject4 = "";
            break label1197;
            label1738:
            str = "";
            break label1216;
            label1745:
            TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByPrivateAPI(false);
          }
        }
      });
      AppMethodBeat.o(15785);
      return;
      label399:
      break;
      break label293;
      paramTRTCParams = "";
    }
  }
  
  public void exitRoom()
  {
    AppMethodBeat.i(15786);
    runOnSDKThreadAndWaitDone(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15710);
        TRTCCloudImpl.this.mConfig.h = false;
        TRTCCloudImpl.this.exitRoomInternal(true, "call from api");
        AppMethodBeat.o(15710);
      }
    }, TimeUnit.SECONDS.toMillis(2L));
    AppMethodBeat.o(15786);
  }
  
  protected void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(231067);
    this.mH265Decision.setEnableH265EncodeByServer(false);
    this.mH265Decision.setEnableH265EncodeByPrivateAPI(false);
    paramString = String.format(Locale.ENGLISH, "exitRoom %s, self: %d, reason: %s", new Object[] { Long.valueOf(this.mRoomInfo.getRoomId()), Integer.valueOf(hashCode()), paramString });
    apiOnlineLog(paramString);
    Monitor.a(1, paramString, "", 0);
    if ((this.mRoomState == 0) && (!this.mKeepAVCaptureWhenEnterRoomFailed))
    {
      clearRemoteMuteStates();
      Monitor.a();
      apiLog("exitRoom ignore when no in room.");
      AppMethodBeat.o(231067);
      return;
    }
    this.mRoomState = 0;
    this.mCaptureAndEnc.g();
    TXCSoundEffectPlayer.getInstance().stopAllEffect();
    stopCollectStatus();
    startVolumeLevelCal(false);
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(230811);
        TRTCCloudImpl.this.stopRemoteRender(paramAnonymousUserInfo);
        com.tencent.liteav.audio.a.a().a(String.valueOf(paramAnonymousUserInfo.tinyID), TRTCCloudImpl.this.hashCode());
        if (paramAnonymousUserInfo.mainRender.render != null) {
          paramAnonymousUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
        }
        if (paramAnonymousUserInfo.subRender.render != null) {
          paramAnonymousUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
        }
        AppMethodBeat.o(230811);
      }
    });
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setPlayoutDataListener(null);
    enableVideoStream(false);
    enableAudioStream(false);
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    enableAudioEarMonitoring(false);
    stopLocalAudioInternal();
    stopBGM();
    TXCKeyPointReportProxy.a(31004);
    stopLocalPreview();
    stopScreenCapture();
    TXCKeyPointReportProxy.b(31004, 0);
    this.mConfig.B = null;
    this.mConfig.D = 10;
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    this.mVideoSourceType = VideoSourceType.NONE;
    this.mEnableSmallStream = false;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mRoomType = 0;
    this.mFramework = this.mOriginalFramework;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mCaptureAndEnc.a(false);
    TXCAudioEngine.getInstance().muteLocalAudio(false);
    TXCAudioEngine.getInstance().clean();
    enableCustomAudioCapture(false);
    enableMixExternalAudioFrame(false, false);
    enableCustomVideoCapture(0, false);
    enableCustomVideoCapture(2, false);
    this.mCaptureAndEnc.a(null, 0);
    stopAudioRecording();
    stopLocalRecording();
    TXCSoundEffectPlayer.getInstance().clearCache();
    Monitor.a();
    TXCLog.i("TRTCCloudImpl", "(%d) exitRoomInternal end", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(231067);
  }
  
  void extractBizInfo(JSONObject paramJSONObject, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(231062);
    if (paramString.equals("strGroupId"))
    {
      paramStringBuilder.append(paramJSONObject.optString("strGroupId").toString());
      paramJSONObject.remove("strGroupId");
      paramJSONObject.remove("Role");
    }
    apiLog("extractBizInfo: key" + paramString + " value:" + paramStringBuilder.toString());
    AppMethodBeat.o(231062);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(15900);
    super.finalize();
    try
    {
      destroy();
      AppMethodBeat.o(15900);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(15900);
      return;
    }
    catch (Error localError)
    {
      AppMethodBeat.o(15900);
    }
  }
  
  public void flushBigVideoEncParamsIntoNetwork()
  {
    AppMethodBeat.i(231064);
    setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.i, this.mConfig.c, this.mConfig.q, this.mConfig.e, this.mConfig.h);
    AppMethodBeat.o(231064);
  }
  
  public void flushSmallVideoEncParamsIntoNetwork()
  {
    AppMethodBeat.i(231065);
    if (this.mEnableSmallStream)
    {
      setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.q, this.mSmallEncParam.minVideoBitrate, this.mConfig.h);
      AppMethodBeat.o(231065);
      return;
    }
    setVideoEncoderConfiguration(3, 0, 0, 0, 0, 0, this.mConfig.q, 0, false);
    AppMethodBeat.o(231065);
  }
  
  public long generateCustomPTS()
  {
    AppMethodBeat.i(231327);
    long l = TXCTimeUtil.generatePtsMS();
    AppMethodBeat.o(231327);
    return l;
  }
  
  public int getAudioCaptureVolume()
  {
    return this.mAudioCaptureVolume;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(231278);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getAutoCacheHolder();
    AppMethodBeat.o(231278);
    return localTXAudioEffectManagerImpl;
  }
  
  public int getAudioPlayoutVolume()
  {
    return this.mAudioPlayoutVolume;
  }
  
  public int getBGMDuration(String paramString)
  {
    AppMethodBeat.i(15877);
    int i = TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
    AppMethodBeat.o(15877);
    return i;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(15840);
    if (this.mCaptureAndEnc == null) {
      this.mCaptureAndEnc = new com.tencent.liteav.d(this.mContext);
    }
    TXBeautyManager localTXBeautyManager = this.mCaptureAndEnc.b();
    AppMethodBeat.o(15840);
    return localTXBeautyManager;
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return this.mDeviceManager;
  }
  
  public long getNetworkContext()
  {
    return this.mNativeRtcContext;
  }
  
  public int getNetworkQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15978);
    if (!com.tencent.liteav.basic.util.h.d(this.mContext))
    {
      AppMethodBeat.o(15978);
      return 6;
    }
    if ((paramInt2 > 50) || (paramInt1 > 500))
    {
      AppMethodBeat.o(15978);
      return 5;
    }
    if ((paramInt2 > 30) || (paramInt1 > 350))
    {
      AppMethodBeat.o(15978);
      return 4;
    }
    if ((paramInt2 > 20) || (paramInt1 > 200))
    {
      AppMethodBeat.o(15978);
      return 3;
    }
    if ((paramInt2 > 10) || (paramInt1 > 100))
    {
      AppMethodBeat.o(15978);
      return 2;
    }
    if ((paramInt2 >= 0) || (paramInt1 >= 0))
    {
      AppMethodBeat.o(15978);
      return 1;
    }
    AppMethodBeat.o(15978);
    return 0;
  }
  
  protected CharSequence getUploadStreamInfo()
  {
    AppMethodBeat.i(15985);
    Object localObject = com.tencent.liteav.basic.util.h.a();
    int i = TXCStatus.c("18446744073709551615", 4003, 2);
    String str = TXCStatus.b("18446744073709551615", 10001);
    localObject = String.format("LOCAL: [%s] RTT:%dms\n", new Object[] { this.mRoomInfo.getUserId(), Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }) + String.format(Locale.CHINA, "SEND:% 5dkbps LOSS:%d-%d-%d-%d|%d-%d-%d-%d|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 12001)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13011, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13012, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13013, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14011)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14012)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14013)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14010)), Integer.valueOf(TXCStatus.c("18446744073709551615", 12003)) }) + String.format(Locale.CHINA, "BIT:%d|%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 3)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14002)), Integer.valueOf(i >> 16), Integer.valueOf(i & 0xFFFF), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 4001, 2)), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 13014, 2)) }) + String.format(Locale.CHINA, "FEC:%d%%|%d%%  ARQ:%d|%dkbps  RPS:%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13004, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14006)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13008, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14008)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13007, 2)) }) + String.format(Locale.CHINA, "CPU:%d%%|%d%%    QOS:%s|%dkbps|%d-%d\n", new Object[] { Integer.valueOf(localObject[0] / 10), Integer.valueOf(localObject[1] / 10), getQosValue(TXCStatus.c("18446744073709551615", 15009, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15005, 2)) }) + String.format(Locale.CHINA, "SVR:%s", new Object[] { str });
    AppMethodBeat.o(15985);
    return localObject;
  }
  
  public boolean isCameraAutoFocusFaceModeSupported()
  {
    AppMethodBeat.i(15839);
    boolean bool = this.mCaptureAndEnc.q();
    AppMethodBeat.o(15839);
    return bool;
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    AppMethodBeat.i(15837);
    boolean bool = this.mCaptureAndEnc.p();
    AppMethodBeat.o(15837);
    return bool;
  }
  
  public boolean isCameraTorchSupported()
  {
    AppMethodBeat.i(15835);
    boolean bool = this.mCaptureAndEnc.o();
    AppMethodBeat.o(15835);
    return bool;
  }
  
  public boolean isCameraZoomSupported()
  {
    AppMethodBeat.i(15833);
    boolean bool = this.mCaptureAndEnc.n();
    AppMethodBeat.o(15833);
    return bool;
  }
  
  public boolean isPublishingInCloud(TRTCCloudImpl paramTRTCCloudImpl, int paramInt)
  {
    AppMethodBeat.i(231445);
    synchronized (this.mCurrentPublishClouds)
    {
      if ((TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt)) == paramTRTCCloudImpl)
      {
        AppMethodBeat.o(231445);
        return true;
      }
      AppMethodBeat.o(231445);
      return false;
    }
  }
  
  public void makeStreamsEffectiveAfterNetworkInited()
  {
    AppMethodBeat.i(231063);
    Iterator localIterator = this.mStreamTypes.iterator();
    while (localIterator.hasNext()) {
      addUpStreamType(((Integer)localIterator.next()).intValue());
    }
    if ((this.mRoomInfo.muteLocalVideo) && (this.mConfig.B == null)) {
      muteUpstream(2, this.mRoomInfo.muteLocalVideo);
    }
    if (this.mRoomInfo.muteLocalAudio) {
      muteUpstream(1, this.mRoomInfo.muteLocalAudio);
    }
    AppMethodBeat.o(231063);
  }
  
  public void mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame)
  {
    AppMethodBeat.i(231266);
    if (paramTRTCAudioFrame == null)
    {
      AppMethodBeat.o(231266);
      return;
    }
    if (this.mPublishAudioTunnelId >= 0) {
      TXCAudioEngineJNI.nativeWriteDataToTunnel(this.mPublishAudioTunnelId, paramTRTCAudioFrame.sampleRate, paramTRTCAudioFrame.channel, 16, paramTRTCAudioFrame.data);
    }
    if (this.mPlayoutAudioTunnelId >= 0) {
      TXCAudioEngineJNI.nativeWriteDataToTunnel(this.mPlayoutAudioTunnelId, paramTRTCAudioFrame.sampleRate, paramTRTCAudioFrame.channel, 16, paramTRTCAudioFrame.data);
    }
    AppMethodBeat.o(231266);
  }
  
  public void muteAllRemoteAudio(final boolean paramBoolean)
  {
    AppMethodBeat.i(15821);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15661);
        TRTCCloudImpl.this.apiOnlineLog("muteAllRemoteAudio " + paramBoolean);
        TRTCRoomInfo localTRTCRoomInfo = TRTCCloudImpl.this.mRoomInfo;
        if (paramBoolean) {}
        for (TRTCRoomInfo.TRTCRemoteMuteState localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
        {
          localTRTCRoomInfo.muteRemoteAudio = localTRTCRemoteMuteState;
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(230623);
              TRTCRoomInfo.RenderInfo localRenderInfo = paramAnonymous2UserInfo.mainRender;
              if (TRTCCloudImpl.58.this.val$mute) {}
              for (paramAnonymous2String = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; paramAnonymous2String = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
              {
                localRenderInfo.muteAudio = paramAnonymous2String;
                TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCCloudImpl.58.this.val$mute);
                if (!TRTCCloudImpl.58.this.val$mute) {
                  break;
                }
                TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 1, true);
                AppMethodBeat.o(230623);
                return;
              }
              TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 1, true);
              AppMethodBeat.o(230623);
            }
          });
          AppMethodBeat.o(15661);
          return;
        }
      }
    });
    AppMethodBeat.o(15821);
  }
  
  public void muteAllRemoteVideoStreams(final boolean paramBoolean)
  {
    AppMethodBeat.i(15802);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15601);
        TRTCCloudImpl.this.apiOnlineLog("muteAllRemoteVideoStreams mute " + paramBoolean);
        TRTCRoomInfo localTRTCRoomInfo = TRTCCloudImpl.this.mRoomInfo;
        if (paramBoolean) {}
        for (TRTCRoomInfo.TRTCRemoteMuteState localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
        {
          localTRTCRoomInfo.muteRemoteVideo = localTRTCRemoteMuteState;
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(230800);
              TRTCRoomInfo.RenderInfo localRenderInfo = paramAnonymous2UserInfo.mainRender;
              boolean bool;
              label115:
              long l2;
              if (TRTCCloudImpl.36.this.val$mute)
              {
                paramAnonymous2String = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
                localRenderInfo.muteVideo = paramAnonymous2String;
                TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + paramAnonymous2UserInfo.userID + ", mute " + TRTCCloudImpl.36.this.val$mute);
                if (paramAnonymous2UserInfo.mainRender.render != null)
                {
                  paramAnonymous2UserInfo.mainRender.render.resetPeriodStatistics();
                  paramAnonymous2String = paramAnonymous2UserInfo.mainRender.render;
                  if (TRTCCloudImpl.36.this.val$mute) {
                    break label347;
                  }
                  bool = true;
                  paramAnonymous2String.enableReport(bool);
                }
                if (paramAnonymous2UserInfo.subRender.render != null)
                {
                  paramAnonymous2UserInfo.subRender.render.resetPeriodStatistics();
                  paramAnonymous2String = paramAnonymous2UserInfo.subRender.render;
                  if (TRTCCloudImpl.36.this.val$mute) {
                    break label352;
                  }
                  bool = true;
                  label160:
                  paramAnonymous2String.enableReport(bool);
                }
                if (!TRTCCloudImpl.36.this.val$mute) {
                  break label357;
                }
                TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 2, true);
                TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 3, true);
                TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 7, true);
                label257:
                l2 = paramAnonymous2UserInfo.tinyID;
                if (!TRTCCloudImpl.36.this.val$mute) {
                  break label496;
                }
                l1 = 1L;
                label276:
                TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 2);
                l2 = paramAnonymous2UserInfo.tinyID;
                if (!TRTCCloudImpl.36.this.val$mute) {
                  break label502;
                }
              }
              label347:
              label352:
              label357:
              label496:
              label502:
              for (long l1 = 1L;; l1 = 0L)
              {
                TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 7);
                AppMethodBeat.o(230800);
                return;
                paramAnonymous2String = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
                break;
                bool = false;
                break label115;
                bool = false;
                break label160;
                if ((paramAnonymous2UserInfo.mainRender.render != null) && (paramAnonymous2UserInfo.mainRender.render.isRendering()))
                {
                  TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, paramAnonymous2UserInfo.streamType, true);
                  TXCKeyPointReportProxy.a(String.valueOf(paramAnonymous2UserInfo.tinyID), 40021, 0L, paramAnonymous2UserInfo.streamType);
                }
                if ((paramAnonymous2UserInfo.subRender.render == null) || (!paramAnonymous2UserInfo.subRender.render.isRendering())) {
                  break label257;
                }
                TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 7, true);
                TXCKeyPointReportProxy.a(String.valueOf(paramAnonymous2UserInfo.tinyID), 40021, 0L, 7);
                break label257;
                l1 = 0L;
                break label276;
              }
            }
          });
          AppMethodBeat.o(15601);
          return;
        }
      }
    });
    AppMethodBeat.o(15802);
  }
  
  public void muteLocalAudio(final boolean paramBoolean)
  {
    AppMethodBeat.i(15819);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15574);
        TRTCCloudImpl.this.apiOnlineLog("muteLocalAudio " + paramBoolean);
        TRTCCloudImpl.this.muteLocalAudio(paramBoolean, TRTCCloudImpl.this);
        if (paramBoolean)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 3001, 1L, -1L, "", 0);
          AppMethodBeat.o(15574);
          return;
        }
        TXCEventRecorderProxy.a("18446744073709551615", 3001, 3L, -1L, "", 0);
        AppMethodBeat.o(15574);
      }
    });
    AppMethodBeat.o(15819);
  }
  
  public void muteLocalAudio(final boolean paramBoolean, final TRTCCloudImpl paramTRTCCloudImpl)
  {
    AppMethodBeat.i(231158);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15572);
        ??? = (TRTCCloudImpl)TRTCCloudImpl.this.mCurrentPublishClouds.get(Integer.valueOf(1));
        if (!paramBoolean)
        {
          if (??? != paramTRTCCloudImpl) {
            TRTCCloudImpl.this.enableAudioStream(false);
          }
          synchronized (TRTCCloudImpl.this.mCurrentPublishClouds)
          {
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(1), paramTRTCCloudImpl);
            TRTCCloudImpl.access$5400(TRTCCloudImpl.this);
            TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = paramBoolean;
            TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
            TRTCCloudImpl.access$4400(TRTCCloudImpl.this, 1, paramBoolean);
            TRTCCloudImpl.this.enableAudioStream(true);
            AppMethodBeat.o(15572);
            return;
          }
        }
        if (??? == paramTRTCCloudImpl)
        {
          TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = paramBoolean;
          TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
          TRTCCloudImpl.access$4400(TRTCCloudImpl.this, 1, paramBoolean);
        }
        AppMethodBeat.o(15572);
      }
    });
    AppMethodBeat.o(231158);
  }
  
  public void muteLocalVideo(final boolean paramBoolean)
  {
    AppMethodBeat.i(15800);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15721);
        TRTCCloudImpl.this.apiOnlineLog("muteLocalVideo mute:" + paramBoolean + ", pauseImg:" + TRTCCloudImpl.this.mConfig.B);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 4006, l, -1L, "", 2);
          TRTCCloudImpl.this.muteLocalVideo(paramBoolean, TRTCCloudImpl.this);
          AppMethodBeat.o(15721);
          return;
        }
      }
    });
    AppMethodBeat.o(15800);
  }
  
  public void muteLocalVideo(final boolean paramBoolean, final TRTCCloudImpl paramTRTCCloudImpl)
  {
    AppMethodBeat.i(231097);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15753);
        ??? = (TRTCCloudImpl)TRTCCloudImpl.this.mCurrentPublishClouds.get(Integer.valueOf(2));
        if (!paramBoolean)
        {
          if (??? != paramTRTCCloudImpl) {
            TRTCCloudImpl.this.enableVideoStream(false);
          }
          synchronized (TRTCCloudImpl.this.mCurrentPublishClouds)
          {
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(2), paramTRTCCloudImpl);
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(3), paramTRTCCloudImpl);
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(7), paramTRTCCloudImpl);
            TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.j());
            TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
            TRTCCloudImpl.access$800(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
            TRTCCloudImpl.this.flushBigVideoEncParamsIntoNetwork();
            TRTCCloudImpl.this.flushSmallVideoEncParamsIntoNetwork();
            TRTCCloudImpl.this.enableVideoStream(true);
            TRTCCloudImpl.this.mCaptureAndEnc.i();
            TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = paramBoolean;
            TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.j());
            TRTCCloudImpl.access$4400(TRTCCloudImpl.this, 2, paramBoolean);
            TRTCCloudImpl.this.mCaptureAndEnc.k(2);
            if (!TRTCCloudImpl.this.mEnableSmallStream) {
              break label375;
            }
            TRTCCloudImpl.this.mCaptureAndEnc.k(3);
            AppMethodBeat.o(15753);
            return;
          }
        }
        if (??? == paramTRTCCloudImpl)
        {
          TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = paramBoolean;
          TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.j());
          if (TRTCCloudImpl.this.mConfig.B != null)
          {
            TRTCCloudImpl.this.mCaptureAndEnc.h();
            AppMethodBeat.o(15753);
            return;
          }
          TRTCCloudImpl.access$4400(TRTCCloudImpl.this, 2, paramBoolean);
        }
        label375:
        AppMethodBeat.o(15753);
      }
    });
    AppMethodBeat.o(231097);
  }
  
  public void muteRemoteAudio(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(15820);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15752);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("muteRemoteAudio " + paramString + " no exist.");
          localUserInfo = TRTCCloudImpl.access$2600(TRTCCloudImpl.this, paramString);
          localRenderInfo = localUserInfo.mainRender;
          if (paramBoolean) {}
          for (localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
          {
            localRenderInfo.muteAudio = localTRTCRemoteMuteState;
            TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
            AppMethodBeat.o(15752);
            return;
          }
        }
        TRTCRoomInfo.RenderInfo localRenderInfo = localUserInfo.mainRender;
        if (paramBoolean) {}
        for (TRTCRoomInfo.TRTCRemoteMuteState localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localTRTCRemoteMuteState = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
        {
          localRenderInfo.muteAudio = localTRTCRemoteMuteState;
          TRTCCloudImpl.this.apiOnlineLog("muteRemoteAudio userId:%s mute:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
          if (localUserInfo.tinyID != 0L) {
            break;
          }
          AppMethodBeat.o(15752);
          return;
        }
        TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(localUserInfo.tinyID), paramBoolean);
        if (paramBoolean)
        {
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 1, true);
          AppMethodBeat.o(15752);
          return;
        }
        TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 1, true);
        AppMethodBeat.o(15752);
      }
    });
    AppMethodBeat.o(15820);
  }
  
  public void muteRemoteAudioInSpeaker(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(15866);
    if (paramJSONObject == null)
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]");
      AppMethodBeat.o(15866);
      return;
    }
    if (!paramJSONObject.has("userID"))
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]: userID");
      AppMethodBeat.o(15866);
      return;
    }
    Object localObject = paramJSONObject.getString("userID");
    if (localObject == null)
    {
      apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
      AppMethodBeat.o(15866);
      return;
    }
    if (!paramJSONObject.has("mute"))
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]: mute");
      AppMethodBeat.o(15866);
      return;
    }
    int i = paramJSONObject.getInt("mute");
    paramJSONObject = this.mRoomInfo.getUser((String)localObject);
    if (paramJSONObject == null)
    {
      apiLog("muteRemoteAudioInSpeaker " + (String)localObject + " no exist, create one.");
      paramJSONObject = createUserInfo((String)localObject);
      if (i == 1) {}
      for (;;)
      {
        paramJSONObject.muteAudioInSpeaker = bool1;
        this.mRoomInfo.addUserInfo((String)localObject, paramJSONObject);
        AppMethodBeat.o(15866);
        return;
        bool1 = false;
      }
    }
    if (paramJSONObject != null)
    {
      localObject = TXCAudioEngine.getInstance();
      long l = paramJSONObject.tinyID;
      if (i == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((TXCAudioEngine)localObject).muteRemoteAudioInSpeaker(String.valueOf(l), bool1);
        AppMethodBeat.o(15866);
        return;
      }
    }
    apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
    AppMethodBeat.o(15866);
  }
  
  public void muteRemoteVideoStream(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(15801);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15625);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + paramString + " no exist.");
          localUserInfo = TRTCCloudImpl.access$2600(TRTCCloudImpl.this, paramString);
          localRenderInfo = localUserInfo.mainRender;
          if (paramBoolean) {}
          for (localObject = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localObject = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
          {
            localRenderInfo.muteVideo = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject);
            TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
            AppMethodBeat.o(15625);
            return;
          }
        }
        TRTCRoomInfo.RenderInfo localRenderInfo = localUserInfo.mainRender;
        if (paramBoolean) {}
        for (Object localObject = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;; localObject = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE)
        {
          localRenderInfo.muteVideo = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject);
          TRTCCloudImpl.this.apiOnlineLog("muteRemoteVideoStream userId:" + paramString + ", mute:" + paramBoolean);
          if (localUserInfo.tinyID != 0L) {
            break;
          }
          AppMethodBeat.o(15625);
          return;
        }
        boolean bool;
        label315:
        long l2;
        if (localUserInfo.mainRender.render != null)
        {
          localUserInfo.mainRender.render.resetPeriodStatistics();
          localObject = localUserInfo.mainRender.render;
          if (!paramBoolean)
          {
            bool = true;
            ((TXCRenderAndDec)localObject).enableReport(bool);
          }
        }
        else
        {
          if (!paramBoolean) {
            break label361;
          }
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 2, true);
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 3, true);
          l2 = localUserInfo.tinyID;
          if (!paramBoolean) {
            break label409;
          }
        }
        label409:
        for (long l1 = 1L;; l1 = 0L)
        {
          TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 2);
          AppMethodBeat.o(15625);
          return;
          bool = false;
          break;
          label361:
          TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, localUserInfo.streamType, true);
          TXCKeyPointReportProxy.a(String.valueOf(localUserInfo.tinyID), 40021, 0L, localUserInfo.streamType);
          break label315;
        }
      }
    });
    AppMethodBeat.o(15801);
  }
  
  public native int nativeAddUpstream(long paramLong, int paramInt);
  
  public native long nativeCreateContext(int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeDestroyContext(long paramLong);
  
  public native int nativeEnterRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, String paramString6, String paramString7, int paramInt7, int paramInt8, int paramInt9);
  
  protected native int nativeExitRoom(long paramLong);
  
  protected native void nativeFlushC2SVideoCodecConfig(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeInit(long paramLong, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected native void nativeSetMixTranscodingConfig(long paramLong, TRTCTranscodingConfigInner paramTRTCTranscodingConfigInner);
  
  public native int nativeSetPriorRemoteVideoStreamType(long paramLong, int paramInt);
  
  public native void nativeSwitchRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3);
  
  public void notifyCurrentEncodeType(final boolean paramBoolean)
  {
    AppMethodBeat.i(231386);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182404);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener == null)
        {
          AppMethodBeat.o(182404);
          return;
        }
        Bundle localBundle = new Bundle();
        int i;
        if (paramBoolean)
        {
          i = 1;
          localBundle.putInt("type", i);
          if (!paramBoolean) {
            break label92;
          }
        }
        label92:
        for (String str = "H265";; str = "H264")
        {
          localTRTCCloudListener.onWarning(1104, String.format("Current encoder type is %s", new Object[] { str }), localBundle);
          AppMethodBeat.o(182404);
          return;
          i = 0;
          break;
        }
      }
    });
    AppMethodBeat.o(231386);
  }
  
  protected void notifyEvent(final String paramString, final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(15969);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230781);
        TRTCCloudImpl.access$10200(TRTCCloudImpl.this, paramString, paramBundle.getInt("EVT_STREAM_TYPE", 2), paramBundle.getString("EVT_MSG", ""), String.format("event %d, ", new Object[] { Integer.valueOf(paramInt) }));
        final int i;
        if (paramInt == 2029)
        {
          TRTCCloudImpl.this.apiLog("release mic~");
          if (TRTCCloudImpl.this.mRoomInfo.isRoomExit())
          {
            TRTCCloudImpl.this.apiLog("onExitRoom when mic release.");
            i = TRTCCloudImpl.this.mRoomInfo.getRoomExitCode();
            TRTCCloudImpl.this.mRoomInfo.setRoomExit(false, 0);
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230700);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener != null) {
                  localTRTCCloudListener.onExitRoom(i);
                }
                AppMethodBeat.o(230700);
              }
            });
          }
        }
        for (;;)
        {
          i = TRTCCloudImpl.access$10000(TRTCCloudImpl.this, paramBundle.getInt("EVT_STREAM_TYPE", 2));
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230697);
              Object localObject = TRTCCloudImpl.this.mTRTCListener;
              if (localObject == null)
              {
                AppMethodBeat.o(230697);
                return;
              }
              if (TRTCCloudImpl.188.this.val$eventCode == 2003)
              {
                if ((TRTCCloudImpl.188.this.val$userId != null) && (TRTCCloudImpl.188.this.val$userId.equals(TRTCCloudImpl.this.mRoomInfo.getUserId())))
                {
                  TRTCCloudImpl.this.apiLog("onFirstVideoFrame local.");
                  ((TRTCCloudListener)localObject).onFirstVideoFrame(null, i, TRTCCloudImpl.188.this.val$eventParam.getInt("EVT_PARAM1"), TRTCCloudImpl.188.this.val$eventParam.getInt("EVT_PARAM2"));
                  AppMethodBeat.o(230697);
                  return;
                }
                TRTCCloudImpl.this.apiLog("onFirstVideoFrame " + TRTCCloudImpl.188.this.val$userId);
                ((TRTCCloudListener)localObject).onFirstVideoFrame(TRTCCloudImpl.188.this.val$userId, i, TRTCCloudImpl.188.this.val$eventParam.getInt("EVT_PARAM1"), TRTCCloudImpl.188.this.val$eventParam.getInt("EVT_PARAM2"));
                AppMethodBeat.o(230697);
                return;
              }
              if (TRTCCloudImpl.188.this.val$eventCode == 2026)
              {
                TRTCCloudImpl.this.apiLog("onFirstAudioFrame " + TRTCCloudImpl.188.this.val$userId);
                ((TRTCCloudListener)localObject).onFirstAudioFrame(TRTCCloudImpl.188.this.val$userId);
                localObject = TRTCCloudImpl.this.mRoomInfo.getUser(TRTCCloudImpl.188.this.val$userId);
                if (localObject != null) {
                  TXCKeyPointReportProxy.b(((TRTCRoomInfo.UserInfo)localObject).tinyID, 32006);
                }
                AppMethodBeat.o(230697);
                return;
              }
              if (TRTCCloudImpl.188.this.val$eventCode == 1003)
              {
                ((TRTCCloudListener)localObject).onCameraDidReady();
                TRTCCloudImpl.this.apiOnlineLog("onCameraDidReady");
                AppMethodBeat.o(230697);
                return;
              }
              if (TRTCCloudImpl.188.this.val$eventCode == 2027)
              {
                ((TRTCCloudListener)localObject).onMicDidReady();
                TRTCCloudImpl.this.apiOnlineLog("onMicDidReady");
                AppMethodBeat.o(230697);
                return;
              }
              if (TRTCCloudImpl.188.this.val$eventCode != 1008)
              {
                if (TRTCCloudImpl.188.this.val$eventCode >= 0) {
                  break label524;
                }
                ((TRTCCloudListener)localObject).onError(TRTCCloudImpl.188.this.val$eventCode, TRTCCloudImpl.188.this.val$eventParam.getString("EVT_MSG", ""), TRTCCloudImpl.188.this.val$eventParam);
                Monitor.a(3, String.format("onError event:%d, msg:%s", new Object[] { Integer.valueOf(TRTCCloudImpl.188.this.val$eventCode), TRTCCloudImpl.188.this.val$eventParam }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXCKeyPointReportProxy.b(TRTCCloudImpl.188.this.val$eventCode);
              }
              for (;;)
              {
                AppMethodBeat.o(230697);
                return;
                label524:
                if (((TRTCCloudImpl.188.this.val$eventCode > 1100) && (TRTCCloudImpl.188.this.val$eventCode < 1110)) || ((TRTCCloudImpl.188.this.val$eventCode > 1200) && (TRTCCloudImpl.188.this.val$eventCode < 1206)) || ((TRTCCloudImpl.188.this.val$eventCode > 2100) && (TRTCCloudImpl.188.this.val$eventCode < 2110)) || ((TRTCCloudImpl.188.this.val$eventCode > 3001) && (TRTCCloudImpl.188.this.val$eventCode < 3011)) || ((TRTCCloudImpl.188.this.val$eventCode > 5100) && (TRTCCloudImpl.188.this.val$eventCode < 5104)))
                {
                  ((TRTCCloudListener)localObject).onWarning(TRTCCloudImpl.188.this.val$eventCode, TRTCCloudImpl.188.this.val$eventParam.getString("EVT_MSG", ""), TRTCCloudImpl.188.this.val$eventParam);
                  if (TRTCCloudImpl.188.this.val$eventCode != 2105) {
                    Monitor.a(4, String.format("onWarning event:%d, msg:%s", new Object[] { Integer.valueOf(TRTCCloudImpl.188.this.val$eventCode), TRTCCloudImpl.188.this.val$eventParam }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  }
                  switch (TRTCCloudImpl.188.this.val$eventCode)
                  {
                  }
                }
              }
            }
          });
          AppMethodBeat.o(230781);
          return;
          TRTCCloudImpl.this.mRoomInfo.micStart(false);
          continue;
          if (paramInt == 2027)
          {
            TRTCCloudImpl.this.apiLog(String.format("onMicDidReady~", new Object[0]));
            TRTCCloudImpl.this.mRoomInfo.micStart(true);
          }
          else
          {
            if ((paramInt == -2304) || (paramInt == -2312))
            {
              TXCLog.i("TRTCCloudImpl", "codecability eventCode = ERR_H265_DECODE_FAIL");
              TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByPrivateAPI(false, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_DECODE_ERROR);
              TRTCCloudImpl.this.mCaptureAndEnc.k(false);
              TRTCCloudImpl.this.notifyCurrentEncodeType(false);
              TRTCCloudImpl.this.nativeFlushC2SVideoCodecConfig(TRTCCloudImpl.this.mNativeRtcContext, 3, com.tencent.liteav.basic.util.g.a.a.a());
              AppMethodBeat.o(230781);
              return;
            }
            if ((paramInt == -2310) || (paramInt == -2311))
            {
              TXCLog.i("TRTCCloudImpl", "codecability eventCode: " + paramInt);
              TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByPrivateAPI(false, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_ENCODE_ERROR);
              i = TRTCEncodeTypeDecision.getH265DecoderValue();
              TRTCCloudImpl.this.nativeFlushC2SVideoCodecConfig(TRTCCloudImpl.this.mNativeRtcContext, i | 0x3, com.tencent.liteav.basic.util.g.a.a.a());
              AppMethodBeat.o(230781);
              return;
            }
            if (paramInt == 1008)
            {
              Pair localPair = TRTCCloudImpl.access$10300(TRTCCloudImpl.this, paramBundle);
              i = paramBundle.getInt("EVT_STREAM_TYPE", 0);
              TXCEventRecorderProxy.a("18446744073709551615", 4016, ((Integer)localPair.first).intValue(), -1L, (String)localPair.second, i);
            }
          }
        }
      }
    });
    AppMethodBeat.o(15969);
  }
  
  protected void onAVMemberEnter(final long paramLong, final String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(15922);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182415);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberEnter when out room.");
          AppMethodBeat.o(182415);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(182415);
          return;
        }
        Object localObject1 = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject1 != null) {
          TRTCCloudImpl.this.apiLog(" user " + paramString + "enter room when user is in room " + paramLong);
        }
        Object localObject2 = String.valueOf(paramLong);
        if (localObject1 == null) {
          localObject1 = TRTCCloudImpl.access$2600(TRTCCloudImpl.this, paramString);
        }
        label1031:
        label1422:
        for (;;)
        {
          TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener((String)localObject2, TRTCCloudImpl.this);
          if (TRTCCloudImpl.this.mAudioFrameListener != null) {
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener((String)localObject2, TRTCCloudImpl.this);
          }
          com.tencent.liteav.audio.a.a().a((String)localObject2, true, TRTCCloudImpl.this.hashCode());
          TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker((String)localObject2, ((TRTCRoomInfo.UserInfo)localObject1).muteAudioInSpeaker);
          if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio == TRTCRoomInfo.TRTCRemoteMuteState.MUTE)
          {
            TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramLong, 1, true);
            TXCAudioEngine.getInstance().muteRemoteAudio((String)localObject2, true);
            TXCRenderAndDec localTXCRenderAndDec = TRTCCloudImpl.access$9500(TRTCCloudImpl.this, paramLong, TRTCCloudImpl.this.mPriorStreamType);
            TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)TRTCCloudImpl.this.mRenderListenerMap.get(paramString);
            if (localRenderListenerAdapter != null)
            {
              localRenderListenerAdapter.strTinyID = ((String)localObject2);
              if (localRenderListenerAdapter.listener != null) {
                localTXCRenderAndDec.setVideoFrameListener(TRTCCloudImpl.this, TRTCCloudImpl.access$7900(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
              }
            }
            ((TRTCRoomInfo.UserInfo)localObject1).tinyID = paramLong;
            ((TRTCRoomInfo.UserInfo)localObject1).userID = paramString;
            ((TRTCRoomInfo.UserInfo)localObject1).terminalType = paramInt2;
            ((TRTCRoomInfo.UserInfo)localObject1).streamState = this.val$videoState;
            ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render = localTXCRenderAndDec;
            ((TRTCRoomInfo.UserInfo)localObject1).mainRender.tinyID = paramLong;
            ((TRTCRoomInfo.UserInfo)localObject1).streamType = TRTCCloudImpl.this.mPriorStreamType;
            if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView.booleanValue())
            {
              TRTCCloudImpl.this.setRenderView(paramString, ((TRTCRoomInfo.UserInfo)localObject1).mainRender, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
              TRTCCloudImpl.this.apiLog(String.format("startRemoteView when user enter userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(((TRTCRoomInfo.UserInfo)localObject1).streamType) }));
              TRTCCloudImpl.access$2700(TRTCCloudImpl.this, String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), ((TRTCRoomInfo.UserInfo)localObject1).streamType, 0, "Start watching " + paramString);
              TRTCCloudImpl.access$2800(TRTCCloudImpl.this, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
              if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
                TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
              }
              TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 1L, -1L, "", ((TRTCRoomInfo.UserInfo)localObject1).streamType);
              if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
                break label1356;
              }
              TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
              TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 1L, -1L, "", 2);
            }
            label625:
            localObject2 = TRTCCloudImpl.access$9500(TRTCCloudImpl.this, paramLong, 7);
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.render = ((TXCRenderAndDec)localObject2);
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.tinyID = paramLong;
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo = TRTCCloudImpl.this.mRoomInfo.muteRemoteVideo;
            if (((TRTCRoomInfo.UserInfo)localObject1).subRender.startRenderView.booleanValue())
            {
              TRTCCloudImpl.this.setRenderView(paramString, ((TRTCRoomInfo.UserInfo)localObject1).subRender, ((TRTCRoomInfo.UserInfo)localObject1).subRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
              TRTCCloudImpl.this.apiOnlineLog(String.format("onUserScreenAvailable when user enter userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(7) }));
              TRTCCloudImpl.access$2700(TRTCCloudImpl.this, String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 7, 0, "Start watching " + paramString);
              TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 1L, -1L, "", 7);
              TRTCCloudImpl.access$2800(TRTCCloudImpl.this, ((TRTCRoomInfo.UserInfo)localObject1).subRender.render, 7);
              if (((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
                TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
              }
              if (((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
                break label1422;
              }
              TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
              TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 1L, -1L, "", 7);
            }
            label917:
            TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, (TRTCRoomInfo.UserInfo)localObject1);
            TRTCCloudImpl.this.apiLog("onAVMemberEnter " + paramLong + ", " + paramString + ", " + this.val$videoState);
            localObject1 = TRTCCloudImpl.this.mTRTCListener;
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230872);
                if (this.val$listener != null) {
                  this.val$listener.onUserEnter(TRTCCloudImpl.150.this.val$userID);
                }
                AppMethodBeat.o(230872);
              }
            });
            if ((!TRTCRoomInfo.hasAudio(this.val$videoState)) || (TRTCRoomInfo.isMuteAudio(this.val$videoState))) {
              break label1485;
            }
            bool = true;
            if (bool)
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230875);
                  if (this.val$listener != null) {
                    this.val$listener.onUserAudioAvailable(TRTCCloudImpl.150.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.150.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(230875);
                }
              });
              TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[true]", new Object[] { paramString }));
            }
            if (((!TRTCRoomInfo.hasMainVideo(this.val$videoState)) && (!TRTCRoomInfo.hasSmallVideo(this.val$videoState))) || (TRTCRoomInfo.isMuteMainVideo(this.val$videoState))) {
              break label1490;
            }
            bool = true;
            label1119:
            if ((bool) && (TRTCCloudImpl.this.mRoomInfo.hasRecvFirstIFrame(paramLong)))
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230863);
                  if (this.val$listener != null) {
                    this.val$listener.onUserVideoAvailable(TRTCCloudImpl.150.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.150.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(230863);
                }
              });
              TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[true]", new Object[] { paramString }));
            }
            if ((!TRTCRoomInfo.hasSubVideo(this.val$videoState)) || (TRTCRoomInfo.isMuteSubVideo(this.val$videoState))) {
              break label1495;
            }
          }
          label1356:
          label1485:
          label1490:
          label1495:
          for (final boolean bool = true;; bool = false)
          {
            if (bool)
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230866);
                  if (this.val$listener != null) {
                    this.val$listener.onUserSubStreamAvailable(TRTCCloudImpl.150.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.150.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(230866);
                }
              });
              TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subvideo Available[true]", new Object[] { paramString }));
            }
            TRTCCloudImpl.access$9100(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]enter room", new Object[] { paramString }));
            AppMethodBeat.o(182415);
            return;
            if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio != TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE) {
              break;
            }
            TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramLong, 1, true);
            TXCAudioEngine.getInstance().muteRemoteAudio((String)localObject2, false);
            break;
            TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
            TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
            TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 0L, -1L, "", 2);
            break label625;
            TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
            TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 0L, -1L, "", 7);
            TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
            break label917;
            bool = false;
            break label1031;
            bool = false;
            break label1119;
          }
        }
      }
    });
    AppMethodBeat.o(15922);
  }
  
  protected void onAVMemberExit(final long paramLong, final String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15923);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182399);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberExit when out room.");
          AppMethodBeat.o(182399);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(182399);
          return;
        }
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo != null)
        {
          TRTCCloudImpl.this.stopRemoteRender(localUserInfo);
          TRTCCloudImpl.this.mRoomInfo.removeRenderInfo(localUserInfo.userID);
        }
        for (;;)
        {
          com.tencent.liteav.audio.a.a().a(String.valueOf(paramLong), TRTCCloudImpl.this.hashCode());
          TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramLong), null);
          TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(String.valueOf(paramLong), null);
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230718);
              TRTCCloudImpl.this.apiLog("onAVMemberExit " + TRTCCloudImpl.151.this.val$tinyID + ", " + TRTCCloudImpl.151.this.val$userID + ", " + TRTCCloudImpl.151.this.val$videoState);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener != null)
              {
                if ((TRTCRoomInfo.hasAudio(TRTCCloudImpl.151.this.val$videoState)) && (!TRTCRoomInfo.isMuteAudio(TRTCCloudImpl.151.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserAudioAvailable(TRTCCloudImpl.151.this.val$userID, false);
                  TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                if (((TRTCRoomInfo.hasMainVideo(TRTCCloudImpl.151.this.val$videoState)) || (TRTCRoomInfo.hasSmallVideo(TRTCCloudImpl.151.this.val$videoState))) && (!TRTCRoomInfo.isMuteMainVideo(TRTCCloudImpl.151.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserVideoAvailable(TRTCCloudImpl.151.this.val$userID, false);
                  TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                if ((TRTCRoomInfo.hasSubVideo(TRTCCloudImpl.151.this.val$videoState)) && (!TRTCRoomInfo.isMuteSubVideo(TRTCCloudImpl.151.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserSubStreamAvailable(TRTCCloudImpl.151.this.val$userID, false);
                  TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.151.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                localTRTCCloudListener.onUserExit(TRTCCloudImpl.151.this.val$userID, 0);
              }
              AppMethodBeat.o(230718);
            }
          });
          AppMethodBeat.o(182399);
          return;
          TRTCCloudImpl.this.apiLog("user " + paramString + " exit room when user is not in room " + paramLong);
        }
      }
    });
    notifyEvent(this.mRoomInfo.getUserId(), 0, String.format("[%s]leave room", new Object[] { paramString }));
    AppMethodBeat.o(15923);
  }
  
  public void onAudioJitterBufferError(String paramString1, int paramInt, String paramString2) {}
  
  public void onAudioJitterBufferNotify(final String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(15905);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15720);
        Bundle localBundle = new Bundle();
        localBundle.putLong("EVT_ID", paramInt);
        localBundle.putLong("EVT_TIME", System.currentTimeMillis());
        localBundle.putString("EVT_MSG", paramString2);
        TRTCCloudImpl.access$8900(TRTCCloudImpl.this, paramString1, paramInt, localBundle);
        AppMethodBeat.o(15720);
      }
    });
    AppMethodBeat.o(15905);
  }
  
  public void onAudioPlayPcmData(final String paramString, final byte[] paramArrayOfByte, final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(15904);
    if (paramString == null)
    {
      paramString = this.mAudioFrameListener;
      if (paramString != null)
      {
        TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        localTRTCAudioFrame.data = paramArrayOfByte;
        localTRTCAudioFrame.timestamp = paramLong;
        localTRTCAudioFrame.sampleRate = paramInt1;
        localTRTCAudioFrame.channel = paramInt2;
        paramString.onMixedPlayAudioFrame(localTRTCAudioFrame);
      }
      AppMethodBeat.o(15904);
      return;
    }
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15763);
        TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = TRTCCloudImpl.this.mAudioFrameListener;
        if (localTRTCAudioFrameListener != null)
        {
          TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
          localTRTCAudioFrame.data = paramArrayOfByte;
          localTRTCAudioFrame.timestamp = paramLong;
          localTRTCAudioFrame.sampleRate = paramInt2;
          localTRTCAudioFrame.channel = paramString;
          try
          {
            long l = Long.valueOf(this.val$id).longValue();
            localTRTCAudioFrameListener.onRemoteUserAudioFrame(localTRTCAudioFrame, TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(l));
            AppMethodBeat.o(15763);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e("TRTCCloudImpl", "onPlayAudioFrame failed." + localException.getMessage());
          }
        }
        AppMethodBeat.o(15763);
      }
    });
    AppMethodBeat.o(15904);
  }
  
  public void onAudioQosChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15928);
    onAudioQosChanged(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(15928);
  }
  
  public void onAudioQosChanged(TRTCCloudImpl paramTRTCCloudImpl, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(231380);
    if (!isPublishingInCloud(paramTRTCCloudImpl, 1))
    {
      AppMethodBeat.o(231380);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230611);
        TXCAudioEngine.getInstance().setAudioEncoderParam(paramInt1, paramInt2);
        TXCAudioEngine.getInstance().setEncoderFECPercent(paramInt3);
        AppMethodBeat.o(230611);
      }
    });
    AppMethodBeat.o(231380);
  }
  
  public void onBackgroudPushStop() {}
  
  protected void onCancelTranscoding(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15945);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230821);
        TRTCCloudImpl.this.apiOnlineLog(String.format("onCancelTranscoding err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSetMixTranscodingConfig(paramInt, paramString);
        }
        AppMethodBeat.o(230821);
      }
    });
    AppMethodBeat.o(15945);
  }
  
  public void onEffectPlayFinish(final int paramInt)
  {
    AppMethodBeat.i(15883);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15642);
        TRTCCloudImpl.this.apiLog("onEffectPlayFinish -> effectId = " + paramInt);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onAudioEffectFinished(paramInt, 0);
        }
        AppMethodBeat.o(15642);
      }
    });
    AppMethodBeat.o(15883);
  }
  
  public void onEffectPlayStart(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(231280);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15608);
        TRTCCloudImpl.this.apiLog("onEffectPlayStart -> effectId = " + paramInt1 + " code = " + paramInt2);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if ((localTRTCCloudListener != null) && (paramInt2 < 0)) {
          localTRTCCloudListener.onAudioEffectFinished(paramInt1, paramInt2);
        }
        AppMethodBeat.o(15608);
      }
    });
    AppMethodBeat.o(231280);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(15902);
    if (paramTXSNALPacket == null)
    {
      AppMethodBeat.o(15902);
      return;
    }
    synchronized (this.mNativeLock)
    {
      pushVideoFrame(paramTXSNALPacket);
      AppMethodBeat.o(15902);
      return;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat) {}
  
  protected void onEnterRoom(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15914);
    apiOnlineLog("onEnterRoom err:" + paramInt + ", msg:" + paramString);
    if (paramInt == 0) {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 1L, -1L, "", 0);
    }
    for (;;)
    {
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15692);
          if (paramInt == 0)
          {
            TRTCCloudImpl.this.mRoomState = 2;
            TRTCCloudImpl.this.mRoomInfo.networkStatus = 3;
            TRTCCloudImpl.access$9100(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "Enter room success");
            AppMethodBeat.o(15692);
            return;
          }
          if (TRTCCloudImpl.this.mKeepAVCaptureWhenEnterRoomFailed)
          {
            TRTCCloudImpl.this.mRoomState = 0;
            TRTCCloudImpl.access$9100(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), paramInt, "Enter room fail " + paramString);
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(15692);
            return;
            TRTCCloudImpl.this.exitRoomInternal(false, "enter room failed");
            break;
            TXCKeyPointReportProxy.b(paramInt);
          }
        }
      });
      runOnListenerThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15650);
          TXCKeyPointReportProxy.b(30001, paramInt);
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          long l = TRTCCloudImpl.this.mRoomInfo.getRoomElapsed();
          if (localTRTCCloudListener != null)
          {
            if (paramInt == 0)
            {
              localTRTCCloudListener.onEnterRoom(l);
              AppMethodBeat.o(15650);
              return;
            }
            localTRTCCloudListener.onEnterRoom(paramInt);
          }
          AppMethodBeat.o(15650);
        }
      });
      AppMethodBeat.o(15914);
      return;
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 0L, -1L, "", 0);
    }
  }
  
  public void onIdrFpsChanged(int paramInt)
  {
    AppMethodBeat.i(15930);
    onIdrFpsChanged(this, paramInt);
    AppMethodBeat.o(15930);
  }
  
  public void onIdrFpsChanged(TRTCCloudImpl paramTRTCCloudImpl, final int paramInt)
  {
    AppMethodBeat.i(231389);
    if (!isPublishingInCloud(paramTRTCCloudImpl, 2))
    {
      AppMethodBeat.o(231389);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230601);
        TRTCCloudImpl.this.mCaptureAndEnc.c(paramInt);
        AppMethodBeat.o(230601);
      }
    });
    AppMethodBeat.o(231389);
  }
  
  public void onMixedAllData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231360);
    final TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
    localTRTCAudioFrame.data = paramArrayOfByte;
    localTRTCAudioFrame.timestamp = 0L;
    localTRTCAudioFrame.sampleRate = paramInt1;
    localTRTCAudioFrame.channel = paramInt2;
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15676);
        TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = TRTCCloudImpl.this.mAudioFrameListener;
        if (localTRTCAudioFrameListener != null) {
          localTRTCAudioFrameListener.onMixedAllAudioFrame(localTRTCAudioFrame);
        }
        AppMethodBeat.o(15676);
      }
    });
    AppMethodBeat.o(231360);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(15901);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15635);
        if (paramBundle == null)
        {
          AppMethodBeat.o(15635);
          return;
        }
        String str = paramBundle.getString("EVT_USERID", "");
        if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase("18446744073709551615")) || (str.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.getTinyId())))
        {
          TRTCCloudImpl.this.notifyEvent(TRTCCloudImpl.this.mRoomInfo.getUserId(), paramInt, paramBundle);
          AppMethodBeat.o(15635);
          return;
        }
        TRTCCloudImpl.access$8900(TRTCCloudImpl.this, str, paramInt, paramBundle);
        AppMethodBeat.o(15635);
      }
    });
    AppMethodBeat.o(15901);
  }
  
  public void onPlayEnd(final int paramInt)
  {
    AppMethodBeat.i(15910);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15769);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMComplete(paramInt);
        }
        AppMethodBeat.o(15769);
      }
    });
    AppMethodBeat.o(15910);
  }
  
  public void onPlayProgress(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(15911);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(170215);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMProgress(paramLong1, this.val$durationMS);
        }
        AppMethodBeat.o(170215);
      }
    });
    AppMethodBeat.o(15911);
  }
  
  public void onPlayStart()
  {
    AppMethodBeat.i(15909);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15640);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMStart(0);
        }
        AppMethodBeat.o(15640);
      }
    });
    AppMethodBeat.o(15909);
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(15907);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", "18446744073709551615");
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    TXCLog.e("TRTCCloudImpl", "onRecordError code = " + paramInt + ":" + paramString + " self:" + hashCode());
    if (paramInt == -1)
    {
      localBundle.putInt("EVT_ID", -1302);
      onNotifyEvent(-1302, localBundle);
    }
    if (paramInt == -6)
    {
      localBundle.putInt("EVT_ID", 2027);
      onNotifyEvent(2027, localBundle);
    }
    if (paramInt == -7)
    {
      localBundle.putInt("EVT_ID", 2029);
      onNotifyEvent(2029, localBundle);
    }
    AppMethodBeat.o(15907);
  }
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15906);
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.timestamp = paramLong;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrameListener.onLocalProcessedAudioFrame(localTRTCAudioFrame);
    }
    AppMethodBeat.o(15906);
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(231353);
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.timestamp = paramLong;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrameListener.onCapturedRawAudioFrame(localTRTCAudioFrame);
    }
    AppMethodBeat.o(231353);
  }
  
  public void onRenderVideoFrame(String paramString, int paramInt, TXSVideoFrame paramTXSVideoFrame)
  {
    AppMethodBeat.i(15908);
    if (paramTXSVideoFrame == null)
    {
      AppMethodBeat.o(15908);
      return;
    }
    TRTCCloudDef.TRTCVideoFrame localTRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
    localTRTCVideoFrame.width = paramTXSVideoFrame.width;
    localTRTCVideoFrame.height = paramTXSVideoFrame.height;
    localTRTCVideoFrame.rotation = paramTXSVideoFrame.rotation;
    localTRTCVideoFrame.timestamp = paramTXSVideoFrame.pts;
    int i = translateStreamType(paramInt);
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase("18446744073709551615")) || (paramString.equalsIgnoreCase(this.mRoomInfo.getTinyId())))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label262;
      }
      paramString = this.mRoomInfo.getUserId();
      localTRTCVideoFrame.pixelFormat = this.mRoomInfo.localPixelFormat;
      localTRTCVideoFrame.bufferType = this.mRoomInfo.localBufferType;
      localObject = this.mRoomInfo.localListener;
    }
    for (;;)
    {
      label147:
      if (localObject != null)
      {
        if (localTRTCVideoFrame.bufferType == 1) {
          if (paramTXSVideoFrame.eglContext != null)
          {
            localTRTCVideoFrame.buffer = ByteBuffer.allocateDirect(paramTXSVideoFrame.width * paramTXSVideoFrame.height * 4);
            TXCOpenGlUtils.a(e.a.a, paramTXSVideoFrame.width, paramTXSVideoFrame.height, localTRTCVideoFrame.buffer);
          }
        }
        for (;;)
        {
          ((TRTCCloudListener.TRTCVideoRenderListener)localObject).onRenderVideoFrame(paramString, i, localTRTCVideoFrame);
          if ((!this.mRoomInfo.enableCustomPreprocessor) || (paramInt == 0)) {
            break label628;
          }
          if (localTRTCVideoFrame.bufferType != 2) {
            break label607;
          }
          paramTXSVideoFrame.data = localTRTCVideoFrame.data;
          AppMethodBeat.o(15908);
          return;
          paramInt = 0;
          break;
          localObject = this.mRenderListenerMap.entrySet().iterator();
          Map.Entry localEntry;
          RenderListenerAdapter localRenderListenerAdapter;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localEntry = (Map.Entry)((Iterator)localObject).next();
            localRenderListenerAdapter = (RenderListenerAdapter)localEntry.getValue();
          } while ((localRenderListenerAdapter == null) || (!paramString.equalsIgnoreCase(((RenderListenerAdapter)localEntry.getValue()).strTinyID)));
          localTRTCVideoFrame.pixelFormat = localRenderListenerAdapter.pixelFormat;
          localTRTCVideoFrame.bufferType = localRenderListenerAdapter.bufferType;
          localObject = localRenderListenerAdapter.listener;
          paramString = (String)localEntry.getKey();
          break label147;
          if (paramTXSVideoFrame.buffer == null) {
            paramTXSVideoFrame.loadYUVBufferFromGL();
          }
          localTRTCVideoFrame.buffer = paramTXSVideoFrame.buffer;
          continue;
          if (localTRTCVideoFrame.bufferType == 2)
          {
            if (paramTXSVideoFrame.eglContext != null)
            {
              localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 4];
              TXCOpenGlUtils.a(e.a.a, paramTXSVideoFrame.width, paramTXSVideoFrame.height, localTRTCVideoFrame.data);
            }
            else
            {
              localTRTCVideoFrame.data = paramTXSVideoFrame.data;
              if (localTRTCVideoFrame.data == null)
              {
                localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2];
                paramTXSVideoFrame.loadYUVArray(localTRTCVideoFrame.data);
              }
            }
          }
          else if (localTRTCVideoFrame.bufferType == 3)
          {
            if (paramTXSVideoFrame.eglContext == null)
            {
              AppMethodBeat.o(15908);
              return;
            }
            localTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
            localTRTCVideoFrame.texture.textureId = paramTXSVideoFrame.textureId;
            if ((paramTXSVideoFrame.eglContext instanceof javax.microedition.khronos.egl.EGLContext)) {
              localTRTCVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)paramTXSVideoFrame.eglContext);
            } else if ((paramTXSVideoFrame.eglContext instanceof android.opengl.EGLContext)) {
              localTRTCVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)paramTXSVideoFrame.eglContext);
            }
          }
        }
        label607:
        if (localTRTCVideoFrame.bufferType == 3) {
          paramTXSVideoFrame.textureId = localTRTCVideoFrame.texture.textureId;
        }
      }
      label262:
      label628:
      AppMethodBeat.o(15908);
      return;
      paramString = null;
      localObject = null;
    }
  }
  
  public void onRequestKeyFrame(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15903);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(15903);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15673);
        TRTCCloudImpl.access$9000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, Long.valueOf(paramString).longValue(), paramInt);
        AppMethodBeat.o(15673);
      }
    });
    AppMethodBeat.o(15903);
  }
  
  public void onScreenCapturePaused()
  {
    AppMethodBeat.i(231190);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15772);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCapturePaused();
        }
        AppMethodBeat.o(15772);
      }
    });
    AppMethodBeat.o(231190);
  }
  
  public void onScreenCaptureResumed()
  {
    AppMethodBeat.i(231189);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15631);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureResumed();
        }
        AppMethodBeat.o(15631);
      }
    });
    AppMethodBeat.o(231189);
  }
  
  public void onScreenCaptureStarted()
  {
    AppMethodBeat.i(231188);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15688);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureStarted();
        }
        AppMethodBeat.o(15688);
      }
    });
    AppMethodBeat.o(231188);
  }
  
  public void onScreenCaptureStopped(final int paramInt)
  {
    AppMethodBeat.i(231193);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15561);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureStopped(paramInt);
        }
        AppMethodBeat.o(15561);
      }
    });
    AppMethodBeat.o(231193);
  }
  
  protected void onSendFirstLocalAudioFrame()
  {
    AppMethodBeat.i(15948);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230824);
        TRTCCloudImpl.this.apiLog("onSendFirstLocalAudioFrame");
        TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalAudioFrame");
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSendFirstLocalAudioFrame();
        }
        AppMethodBeat.o(230824);
      }
    });
    AppMethodBeat.o(15948);
  }
  
  protected void onSendFirstLocalVideoFrame(final int paramInt)
  {
    AppMethodBeat.i(15947);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230819);
        TRTCCloudImpl.this.apiLog("onSendFirstLocalVideoFrame " + paramInt);
        int i = TRTCCloudImpl.access$10000(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.access$9600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalVideoFrame:".concat(String.valueOf(i)));
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSendFirstLocalVideoFrame(i);
        }
        AppMethodBeat.o(230819);
      }
    });
    AppMethodBeat.o(15947);
  }
  
  public void onVideoConfigChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(15939);
    onVideoConfigChanged(this, paramInt, paramBoolean);
    AppMethodBeat.o(15939);
  }
  
  public void onVideoConfigChanged(TRTCCloudImpl paramTRTCCloudImpl, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(231392);
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt))
    {
      AppMethodBeat.o(231392);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230869);
        if (paramInt == 2) {
          TRTCCloudImpl.this.mCaptureAndEnc.h(paramBoolean);
        }
        AppMethodBeat.o(230869);
      }
    });
    AppMethodBeat.o(231392);
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(231382);
    onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(231382);
  }
  
  public void onVideoQosChanged(TRTCCloudImpl paramTRTCCloudImpl, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final int paramInt7, final int paramInt8)
  {
    AppMethodBeat.i(231384);
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt1))
    {
      AppMethodBeat.o(231384);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        AppMethodBeat.i(182407);
        boolean bool;
        if (paramInt8 == 1)
        {
          bool = true;
          if (paramInt1 != 7) {
            break label100;
          }
          if (TRTCCloudImpl.this.mSubStreamCaptureAndEnc != null) {
            TRTCCloudImpl.this.mSubStreamCaptureAndEnc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, bool);
          }
        }
        label207:
        for (;;)
        {
          TRTCCloudImpl.this.mH265Decision.setEnableH265EncodeByServer(bool, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_QOS);
          AppMethodBeat.o(182407);
          return;
          bool = false;
          break;
          label100:
          if (paramInt1 == 2)
          {
            TRTCCloudImpl.this.mCaptureAndEnc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, bool);
            if (paramInt2 > paramInt3) {}
            for (;;)
            {
              if ((TRTCCloudImpl.this.mConfig.m == i) || (paramInt2 == paramInt3)) {
                break label207;
              }
              TRTCCloudImpl.this.mConfig.m = i;
              TRTCCloudImpl.access$100(TRTCCloudImpl.this);
              break;
              i = 1;
            }
          }
        }
      }
    });
    AppMethodBeat.o(231384);
  }
  
  public void pauseAudioEffect(final int paramInt)
  {
    AppMethodBeat.i(182319);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15655);
        TRTCCloudImpl.this.apiLog("pauseAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().pauseEffectWithId(paramInt);
        AppMethodBeat.o(15655);
      }
    });
    AppMethodBeat.o(182319);
  }
  
  public void pauseBGM()
  {
    AppMethodBeat.i(15875);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15758);
        TRTCCloudImpl.this.apiLog("pauseBGM");
        TXCLiveBGMPlayer.getInstance().pause();
        AppMethodBeat.o(15758);
      }
    });
    AppMethodBeat.o(15875);
  }
  
  public void pauseScreenCapture()
  {
    AppMethodBeat.i(231092);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15627);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiOnlineLog("pauseScreenCapture");
          TRTCCloudImpl.this.mCaptureAndEnc.h();
        }
        AppMethodBeat.o(15627);
      }
    });
    AppMethodBeat.o(231092);
  }
  
  public void playAudioEffect(final TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam)
  {
    AppMethodBeat.i(15885);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15615);
        TRTCCloudImpl.this.apiLog("playAudioEffect -> effectId = " + paramTRTCAudioEffectParam.effectId + " path = " + paramTRTCAudioEffectParam.path + " publish = " + paramTRTCAudioEffectParam.publish + " loopCount = " + paramTRTCAudioEffectParam.loopCount);
        TXCSoundEffectPlayer.getInstance().playEffectWithId(paramTRTCAudioEffectParam.effectId, paramTRTCAudioEffectParam.path, paramTRTCAudioEffectParam.publish, paramTRTCAudioEffectParam.loopCount);
        AppMethodBeat.o(15615);
      }
    });
    AppMethodBeat.o(15885);
  }
  
  public void playBGM(final String paramString, final TRTCCloud.BGMNotify paramBGMNotify)
  {
    AppMethodBeat.i(15873);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15719);
        TRTCCloudImpl.this.apiLog("playBGM");
        TRTCCloudImpl.access$8002(TRTCCloudImpl.this, paramBGMNotify);
        if (TRTCCloudImpl.this.mBGMNotify != null) {
          TXCLiveBGMPlayer.getInstance().setOnPlayListener(TRTCCloudImpl.this);
        }
        for (;;)
        {
          TXCLiveBGMPlayer.getInstance().startPlay(paramString);
          AppMethodBeat.o(15719);
          return;
          TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
        }
      }
    });
    AppMethodBeat.o(15873);
  }
  
  public void resumeAudioEffect(final int paramInt)
  {
    AppMethodBeat.i(182320);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15757);
        TRTCCloudImpl.this.apiLog("resumeAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().resumeEffectWithId(paramInt);
        AppMethodBeat.o(15757);
      }
    });
    AppMethodBeat.o(182320);
  }
  
  public void resumeBGM()
  {
    AppMethodBeat.i(15876);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15567);
        TRTCCloudImpl.this.apiLog("resumeBGM");
        TXCLiveBGMPlayer.getInstance().resume();
        AppMethodBeat.o(15567);
      }
    });
    AppMethodBeat.o(15876);
  }
  
  public void resumeScreenCapture()
  {
    AppMethodBeat.i(231093);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16060);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiOnlineLog("resumeScreenCapture");
          TRTCCloudImpl.this.mCaptureAndEnc.i();
        }
        AppMethodBeat.o(16060);
      }
    });
    AppMethodBeat.o(231093);
  }
  
  public void runOnListenerThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(15950);
    Handler localHandler = this.mListenerHandler;
    if (localHandler == null)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        this.mMainHandler.post(paramRunnable);
        AppMethodBeat.o(15950);
        return;
      }
      paramRunnable.run();
      AppMethodBeat.o(15950);
      return;
    }
    if (Looper.myLooper() != localHandler.getLooper())
    {
      localHandler.post(paramRunnable);
      AppMethodBeat.o(15950);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(15950);
  }
  
  protected void runOnMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(15949);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mMainHandler.post(paramRunnable);
      AppMethodBeat.o(15949);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(15949);
  }
  
  public void runOnSDKThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(15953);
    if ((this.mSDKHandler != null) && (this.mIsSDKThreadAlive.get()))
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper()) {
        try
        {
          this.mSDKHandler.post(paramRunnable);
          AppMethodBeat.o(15953);
          return;
        }
        catch (Exception paramRunnable)
        {
          TXCLog.e("TRTCCloudImpl", "(" + hashCode() + ")trtc_api run on sdk fail. alive:" + this.mIsSDKThreadAlive.get(), paramRunnable);
          AppMethodBeat.o(15953);
          return;
        }
      }
      paramRunnable.run();
      AppMethodBeat.o(15953);
      return;
    }
    TXCLog.e("TRTCCloudImpl", "(" + hashCode() + ")trtc_api sdk thread is dead, ignore task.");
    AppMethodBeat.o(15953);
  }
  
  public void selectMotionTmpl(final String paramString)
  {
    AppMethodBeat.i(15844);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15573);
        TRTCCloudImpl.this.apiLog("selectMotionTmpl " + paramString);
        TRTCCloudImpl.this.getBeautyManager().setMotionTmpl(paramString);
        AppMethodBeat.o(15573);
      }
    });
    AppMethodBeat.o(15844);
  }
  
  public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame)
  {
    AppMethodBeat.i(15872);
    if (paramTRTCAudioFrame == null)
    {
      apiLog("sendCustomAudioData parameter is null");
      AppMethodBeat.o(15872);
      return;
    }
    final com.tencent.liteav.basic.structs.a locala = new com.tencent.liteav.basic.structs.a();
    locala.f = new byte[paramTRTCAudioFrame.data.length];
    System.arraycopy(paramTRTCAudioFrame.data, 0, locala.f, 0, paramTRTCAudioFrame.data.length);
    locala.a = paramTRTCAudioFrame.sampleRate;
    locala.b = paramTRTCAudioFrame.channel;
    locala.c = 16;
    if (0L == paramTRTCAudioFrame.timestamp) {}
    for (locala.e = TXCTimeUtil.generatePtsMS();; locala.e = paramTRTCAudioFrame.timestamp)
    {
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16061);
          if (!TRTCCloudImpl.this.mEnableCustomAudioCapture)
          {
            TRTCCloudImpl.this.apiLog("sendCustomAudioData when mEnableCustomAudioCapture is false");
            AppMethodBeat.o(16061);
            return;
          }
          TXCAudioEngine.getInstance().sendCustomPCMData(locala);
          AppMethodBeat.o(16061);
        }
      });
      AppMethodBeat.o(15872);
      return;
    }
  }
  
  public boolean sendCustomCmdMsg(final int paramInt, final byte[] paramArrayOfByte, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    boolean bool = true;
    AppMethodBeat.i(15897);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(15897);
      return false;
    }
    if (this.mCurrentRole == 21)
    {
      apiLog("ignore send custom cmd msg for audience");
      AppMethodBeat.o(15897);
      return false;
    }
    long l = System.currentTimeMillis();
    if (this.mLastSendMsgTimeMs == 0L) {
      this.mLastSendMsgTimeMs = l;
    }
    if (l - this.mLastSendMsgTimeMs < 1000L) {
      if ((this.mSendMsgCount < 30) && (this.mSendMsgSize < 8192))
      {
        this.mSendMsgCount += 1;
        this.mSendMsgSize += paramArrayOfByte.length;
      }
    }
    for (;;)
    {
      if (bool) {
        runOnSDKThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15648);
            TRTCCloudImpl.access$8700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2);
            AppMethodBeat.o(15648);
          }
        });
      }
      AppMethodBeat.o(15897);
      return bool;
      TXCLog.e("TRTCCloudImpl", "send msg too more self:" + hashCode());
      bool = false;
      continue;
      this.mLastSendMsgTimeMs = l;
      this.mSendMsgCount = 1;
      this.mSendMsgSize = paramArrayOfByte.length;
    }
  }
  
  public void sendCustomVideoData(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(231232);
    if (paramTRTCVideoFrame == null)
    {
      apiLog("sendCustomVideoData parameter is null");
      AppMethodBeat.o(231232);
      return;
    }
    if ((paramTRTCVideoFrame.pixelFormat != 1) && (paramTRTCVideoFrame.pixelFormat != 4) && (paramTRTCVideoFrame.pixelFormat != 2))
    {
      apiLog("sendCustomVideoData parameter error unsupported pixel format " + paramTRTCVideoFrame.pixelFormat);
      AppMethodBeat.o(231232);
      return;
    }
    if ((paramTRTCVideoFrame.bufferType != 2) && (paramTRTCVideoFrame.texture == null))
    {
      apiLog("sendCustomVideoData parameter error unsupported buffer type " + paramTRTCVideoFrame.bufferType);
      AppMethodBeat.o(231232);
      return;
    }
    if ((paramInt == 0) && ((this.mVideoSourceType != VideoSourceType.CUSTOM) || (this.mRoomInfo.muteLocalVideo)))
    {
      AppMethodBeat.o(231232);
      return;
    }
    localObject = this.mCustomCaptureLock;
    if (paramInt == 2) {}
    for (;;)
    {
      try
      {
        if (this.mSubStreamCaptureAndEnc == null) {
          this.mSubStreamCaptureAndEnc = createCaptureAndEnc(7);
        }
        if (this.mCustomSubStreamVideoUtil == null) {
          this.mCustomSubStreamVideoUtil = new TRTCCustomTextureUtil(this.mSubStreamCaptureAndEnc, this.mCustomCaptureGLSyncMode);
        }
        if (this.mCustomSubStreamVideoUtil != null) {
          this.mCustomSubStreamVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(231232);
      }
      if (this.mCustomVideoUtil == null) {
        this.mCustomVideoUtil = new TRTCCustomTextureUtil(this.mCaptureAndEnc, this.mCustomCaptureGLSyncMode);
      }
      if (this.mCustomVideoUtil != null) {
        this.mCustomVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
      }
    }
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15855);
    sendCustomVideoData(0, paramTRTCVideoFrame);
    AppMethodBeat.o(15855);
  }
  
  public void sendJsonCmd(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(15868);
    if ((paramJSONObject == null) || (!paramJSONObject.has("jsonParam")) || (!(paramJSONObject.get("jsonParam") instanceof JSONObject)))
    {
      apiLog("callExperimentalAPI[lack parameter or illegal type]: sendJsonCMD");
      AppMethodBeat.o(15868);
      return;
    }
    paramJSONObject = paramJSONObject.getJSONObject("jsonParam").toString();
    nativeSendJsonCmd(this.mNativeRtcContext, paramJSONObject, paramString);
    AppMethodBeat.o(15868);
  }
  
  public boolean sendSEIMsg(final byte[] paramArrayOfByte, final int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(15898);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(15898);
      return false;
    }
    if (this.mCurrentRole == 21)
    {
      apiLog("ignore send sei msg for audience");
      AppMethodBeat.o(15898);
      return false;
    }
    long l = System.currentTimeMillis();
    if (this.mLastSendMsgTimeMs == 0L) {
      this.mLastSendMsgTimeMs = l;
    }
    if (l - this.mLastSendMsgTimeMs < 1000L) {
      if ((this.mSendMsgCount < 30) && (this.mSendMsgSize < 8192))
      {
        this.mSendMsgCount += 1;
        this.mSendMsgSize += paramArrayOfByte.length;
        bool = true;
      }
    }
    for (;;)
    {
      if (bool) {
        runOnSDKThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15619);
            TRTCCloudImpl.access$8800(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramArrayOfByte, paramInt);
            AppMethodBeat.o(15619);
          }
        });
      }
      AppMethodBeat.o(15898);
      return bool;
      TXCLog.e("TRTCCloudImpl", "send msg too more self:" + hashCode());
      continue;
      this.mLastSendMsgTimeMs = l;
      this.mSendMsgCount = 1;
      this.mSendMsgSize = paramArrayOfByte.length;
      bool = true;
    }
  }
  
  public void setAllAudioEffectsVolume(final int paramInt)
  {
    AppMethodBeat.i(15889);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15760);
        TRTCCloudImpl.this.apiLog("setAllAudioEffectsVolume volume = " + paramInt);
        float f = paramInt / 100.0F;
        TXCSoundEffectPlayer.getInstance().setEffectsVolume(f);
        AppMethodBeat.o(15760);
      }
    });
    AppMethodBeat.o(15889);
  }
  
  public void setAudioCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(182311);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mAudioCaptureVolume = i;
    apiLog("setAudioCaptureVolume:  volume=" + this.mAudioCaptureVolume);
    TXAudioEffectManagerImpl.getInstance().setVoiceCaptureVolume(i);
    AppMethodBeat.o(182311);
  }
  
  public void setAudioEffectVolume(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(15886);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15581);
        TRTCCloudImpl.this.apiLog("setAudioEffectVolume -> effectId = " + paramInt1 + " volume = " + paramInt2);
        float f = paramInt2 / 100.0F;
        TXCSoundEffectPlayer.getInstance().setVolumeOfEffect(paramInt1, f);
        AppMethodBeat.o(15581);
      }
    });
    AppMethodBeat.o(15886);
  }
  
  public void setAudioFrameListener(final TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener)
  {
    AppMethodBeat.i(15899);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15647);
        TRTCCloudImpl.this.apiLog("setAudioFrameListener " + paramTRTCAudioFrameListener);
        TRTCCloudImpl.this.mAudioFrameListener = paramTRTCAudioFrameListener;
        if (TRTCCloudImpl.this.mAudioFrameListener == null)
        {
          TXCAudioEngine.setPlayoutDataListener(null);
          TXCAudioEngine.getInstance().setAudioCaptureDataListener(null);
          TXCAudioEngine.getInstance().setMixedAllDataListener(null);
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(230860);
              TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), null);
              AppMethodBeat.o(230860);
            }
          });
          AppMethodBeat.o(15647);
          return;
        }
        TXCAudioEngine.setPlayoutDataListener(TRTCCloudImpl.this);
        TXCAudioEngine.getInstance().setAudioCaptureDataListener(TRTCCloudImpl.this);
        TXCAudioEngine.getInstance().setMixedAllDataListener(TRTCCloudImpl.this);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230864);
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCCloudImpl.this);
            AppMethodBeat.o(230864);
          }
        });
        AppMethodBeat.o(15647);
      }
    });
    AppMethodBeat.o(15899);
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(182312);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mAudioPlayoutVolume = i;
    apiLog("setAudioPlayoutVolume:  volume=" + this.mAudioPlayoutVolume);
    TXAudioEffectManagerImpl.getInstance().setAudioPlayoutVolume(i);
    AppMethodBeat.o(182312);
  }
  
  public void setAudioQuality(final int paramInt)
  {
    AppMethodBeat.i(231126);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15750);
        TRTCCloudImpl.this.apiLog("setAudioQuality " + paramInt);
        TXCAudioEngine.getInstance().setAudioQuality(paramInt, 2);
        AppMethodBeat.o(15750);
      }
    });
    AppMethodBeat.o(231126);
  }
  
  public void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(15818);
    TXDeviceManager.TXAudioRoute localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mDeviceManager.setAudioRoute(localTXAudioRoute);
      AppMethodBeat.o(15818);
      return;
      localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
      continue;
      localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
    }
  }
  
  public void setBGMPlayoutVolume(final int paramInt)
  {
    AppMethodBeat.i(182317);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15571);
        float f = paramInt / 100.0F;
        TRTCCloudImpl.this.apiLog("setBGMPlayoutVolume:" + paramInt + " fVolume:" + f);
        TXCLiveBGMPlayer.getInstance().setPlayoutVolume(f);
        AppMethodBeat.o(15571);
      }
    });
    AppMethodBeat.o(182317);
  }
  
  public int setBGMPosition(final int paramInt)
  {
    AppMethodBeat.i(15878);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15704);
        TRTCCloudImpl.this.apiLog("setBGMPosition " + paramInt);
        TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt);
        AppMethodBeat.o(15704);
      }
    });
    AppMethodBeat.o(15878);
    return 0;
  }
  
  public void setBGMPublishVolume(final int paramInt)
  {
    AppMethodBeat.i(182318);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15633);
        float f = paramInt / 100.0F;
        TRTCCloudImpl.this.apiLog("setBGMPublishVolume " + paramInt);
        TXCLiveBGMPlayer.getInstance().setPublishVolume(f);
        AppMethodBeat.o(15633);
      }
    });
    AppMethodBeat.o(182318);
  }
  
  public void setBGMVolume(final int paramInt)
  {
    AppMethodBeat.i(15880);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15699);
        TRTCCloudImpl.this.apiLog("setBGMVolume " + paramInt);
        float f = paramInt / 100.0F;
        TXCLiveBGMPlayer.getInstance().setVolume(f);
        AppMethodBeat.o(15699);
      }
    });
    AppMethodBeat.o(15880);
  }
  
  public void setBeautyStyle(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(15841);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15761);
        TRTCCloudImpl.this.getBeautyManager().setBeautyStyle(paramInt1);
        TRTCCloudImpl.this.getBeautyManager().setBeautyLevel(paramInt2);
        TRTCCloudImpl.this.getBeautyManager().setWhitenessLevel(paramInt3);
        TRTCCloudImpl.this.getBeautyManager().setRuddyLevel(paramInt4);
        AppMethodBeat.o(15761);
      }
    });
    AppMethodBeat.o(15841);
  }
  
  public int setCapturedRawAudioFrameCallbackFormat(final TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    AppMethodBeat.i(231329);
    apiLog(String.format("setCaptureAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall))
    {
      AppMethodBeat.o(231329);
      return -1;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(170203);
        TXCAudioEngine.getInstance().setCaptureDataCallbackFormat(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall);
        AppMethodBeat.o(170203);
      }
    });
    AppMethodBeat.o(231329);
    return 0;
  }
  
  public void setChinLevel(final int paramInt)
  {
    AppMethodBeat.i(15851);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15644);
        TRTCCloudImpl.this.apiLog("setChinLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setChinLevel(paramInt);
        AppMethodBeat.o(15644);
      }
    });
    AppMethodBeat.o(15851);
  }
  
  public void setDebugViewMargin(final String paramString, final TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    AppMethodBeat.i(15891);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(15891);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15774);
        TRTCCloudImpl.this.apiLog("setDebugViewMargin");
        final TXCloudVideoView localTXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
        if ((localTXCloudVideoView != null) && (paramString.equalsIgnoreCase(localTXCloudVideoView.getUserId()))) {
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230688);
              localTXCloudVideoView.setLogMarginRatio(TRTCCloudImpl.115.this.val$margin.leftMargin, TRTCCloudImpl.115.this.val$margin.rightMargin, TRTCCloudImpl.115.this.val$margin.topMargin, TRTCCloudImpl.115.this.val$margin.bottomMargin);
              AppMethodBeat.o(230688);
            }
          });
        }
        Object localObject = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          ((TRTCRoomInfo.UserInfo)localObject).debugMargin = paramTRTCViewMargin;
          localTXCloudVideoView = ((TRTCRoomInfo.UserInfo)localObject).mainRender.view;
          localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.view;
          if ((localTXCloudVideoView != null) || (localObject != null)) {
            TRTCCloudImpl.this.runOnMainThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230679);
                if (localTXCloudVideoView != null) {
                  localTXCloudVideoView.setLogMarginRatio(TRTCCloudImpl.115.this.val$margin.leftMargin, TRTCCloudImpl.115.this.val$margin.rightMargin, TRTCCloudImpl.115.this.val$margin.topMargin, TRTCCloudImpl.115.this.val$margin.bottomMargin);
                }
                if (this.val$remoteSubView != null) {
                  this.val$remoteSubView.setLogMarginRatio(TRTCCloudImpl.115.this.val$margin.leftMargin, TRTCCloudImpl.115.this.val$margin.rightMargin, TRTCCloudImpl.115.this.val$margin.topMargin, TRTCCloudImpl.115.this.val$margin.bottomMargin);
                }
                AppMethodBeat.o(230679);
              }
            });
          }
        }
        AppMethodBeat.o(15774);
      }
    });
    AppMethodBeat.o(15891);
  }
  
  public void setDefaultStreamRecvMode(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(15790);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15698);
        TRTCCloudImpl.this.mRecvMode = 0;
        if ((paramBoolean1) && (paramBoolean2)) {
          TRTCCloudImpl.this.mRecvMode = 1;
        }
        for (;;)
        {
          String str = String.format("setDefaultStreamRecvMode audio:%b, video:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }) + " self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiOnlineLog(str);
          AppMethodBeat.o(15698);
          return;
          if (paramBoolean1) {
            TRTCCloudImpl.this.mRecvMode = 2;
          } else if (paramBoolean2) {
            TRTCCloudImpl.this.mRecvMode = 3;
          } else {
            TRTCCloudImpl.this.mRecvMode = 4;
          }
        }
      }
    });
    AppMethodBeat.o(15790);
  }
  
  public void setEncodedDataProcessingListener(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(231336);
    if ((paramJSONObject == null) || (!paramJSONObject.has("listener")))
    {
      apiLog("setEncodedDataProcessingListener [lack parameter or illegal type]: listener");
      AppMethodBeat.o(231336);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = paramJSONObject.getLong("listener");
      l1 = l2;
    }
    catch (JSONException paramJSONObject)
    {
      label48:
      break label48;
    }
    apiLog("setEncodedDataProcessingListener:" + Long.toHexString(l1));
    nativeSetEncodedDataProcessingListener(this.mNativeRtcContext, l1);
    AppMethodBeat.o(231336);
  }
  
  public void setEyeScaleLevel(final int paramInt)
  {
    AppMethodBeat.i(15847);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15756);
        TRTCCloudImpl.this.apiLog("setEyeScaleLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setEyeScaleLevel(paramInt);
        AppMethodBeat.o(15756);
      }
    });
    AppMethodBeat.o(15847);
  }
  
  public void setFaceShortLevel(final int paramInt)
  {
    AppMethodBeat.i(15850);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15660);
        TRTCCloudImpl.this.apiLog("setFaceShortLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceShortLevel(paramInt);
        AppMethodBeat.o(15660);
      }
    });
    AppMethodBeat.o(15850);
  }
  
  public void setFaceSlimLevel(final int paramInt)
  {
    AppMethodBeat.i(15848);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15678);
        TRTCCloudImpl.this.apiLog("setFaceSlimLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceSlimLevel(paramInt);
        AppMethodBeat.o(15678);
      }
    });
    AppMethodBeat.o(15848);
  }
  
  public void setFaceVLevel(final int paramInt)
  {
    AppMethodBeat.i(15849);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15649);
        TRTCCloudImpl.this.apiLog("setFaceVLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceVLevel(paramInt);
        AppMethodBeat.o(15649);
      }
    });
    AppMethodBeat.o(15849);
  }
  
  public void setFilter(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(15842);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15609);
        TRTCCloudImpl.this.apiLog("setFilter");
        TRTCCloudImpl.this.getBeautyManager().setFilter(paramBitmap);
        AppMethodBeat.o(15609);
      }
    });
    AppMethodBeat.o(15842);
  }
  
  public void setFilterConcentration(final float paramFloat)
  {
    AppMethodBeat.i(15843);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15701);
        TRTCCloudImpl.this.apiLog("setFilterStrength: " + paramFloat);
        TRTCCloudImpl.this.getBeautyManager().setFilterStrength(paramFloat);
        AppMethodBeat.o(15701);
      }
    });
    AppMethodBeat.o(15843);
  }
  
  public void setFocusPosition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15838);
    this.mDeviceManager.setCameraFocusPosition(paramInt1, paramInt2);
    AppMethodBeat.o(15838);
  }
  
  public void setGSensorMode(final int paramInt)
  {
    AppMethodBeat.i(15810);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15607);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiLog("setGSensorMode has been ignored for screen capturing");
          AppMethodBeat.o(15607);
          return;
        }
        TRTCCloudImpl.access$3402(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.this.apiLog("vrotation setGSensorMode " + paramInt);
        AppMethodBeat.o(15607);
      }
    });
    AppMethodBeat.o(15810);
  }
  
  public boolean setGreenScreenFile(final String paramString)
  {
    AppMethodBeat.i(15846);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15685);
        TRTCCloudImpl.this.apiLog("setGreenScreenFile " + paramString);
        TRTCCloudImpl.this.getBeautyManager().setGreenScreenFile(paramString);
        AppMethodBeat.o(15685);
      }
    });
    AppMethodBeat.o(15846);
    return true;
  }
  
  public void setListener(final TRTCCloudListener paramTRTCCloudListener)
  {
    AppMethodBeat.i(15783);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230650);
        TRTCCloudImpl.this.apiLog("setListener " + paramTRTCCloudListener);
        TRTCCloudImpl.this.mTRTCListener = paramTRTCCloudListener;
        AppMethodBeat.o(230650);
      }
    });
    AppMethodBeat.o(15783);
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    AppMethodBeat.i(15784);
    apiLog("setListenerHandler ".concat(String.valueOf(paramHandler)));
    if (paramHandler == null) {}
    for (this.mListenerHandler = new Handler(Looper.getMainLooper());; this.mListenerHandler = paramHandler)
    {
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15775);
          Iterator localIterator = TRTCCloudImpl.this.mSubClouds.iterator();
          while (localIterator.hasNext())
          {
            TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)localIterator.next()).get();
            if (localTRTCCloudImpl != null) {
              localTRTCCloudImpl.setListenerHandler(TRTCCloudImpl.this.mListenerHandler);
            } else {
              localIterator.remove();
            }
          }
          AppMethodBeat.o(15775);
        }
      });
      AppMethodBeat.o(15784);
      return;
    }
  }
  
  public int setLocalProcessedAudioFrameCallbackFormat(final TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    AppMethodBeat.i(231331);
    apiLog(String.format("setLocalProcessedAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall))
    {
      AppMethodBeat.o(231331);
      return -1;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15605);
        TXCAudioEngine.getInstance().setLocalProcessedDataCallbackFormat(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall);
        AppMethodBeat.o(15605);
      }
    });
    AppMethodBeat.o(231331);
    return 0;
  }
  
  public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    AppMethodBeat.i(231101);
    setLocalViewFillMode(paramTRTCRenderParams.fillMode);
    setLocalViewRotation(paramTRTCRenderParams.rotation);
    setLocalViewMirror(paramTRTCRenderParams.mirrorType);
    AppMethodBeat.o(231101);
  }
  
  public void setLocalSurface(final Surface paramSurface)
  {
    AppMethodBeat.i(231246);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15570);
        TRTCCloudImpl.this.apiLog("setLocalSurface " + paramSurface);
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramSurface);
        AppMethodBeat.o(15570);
      }
    });
    AppMethodBeat.o(231246);
  }
  
  public void setLocalSurfaceSize(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(231247);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15669);
        TRTCCloudImpl.this.apiLog("setLocalSurfaceSize: " + paramInt1 + "," + paramInt2);
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramInt1, paramInt2);
        AppMethodBeat.o(15669);
      }
    });
    AppMethodBeat.o(231247);
  }
  
  public int setLocalVideoProcessListener(final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    AppMethodBeat.i(231257);
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
    {
      apiLog("setLocalVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(231257);
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      apiLog("setLocalVideoRenderListener unsupported bufferType : ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(231257);
      return -1328;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        boolean bool = true;
        AppMethodBeat.i(15621);
        TRTCCloudImpl.this.apiLog("setLocalVideoPreprocessListener pixelFormat: %d, bufferType: %d, listener: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTRTCVideoFrameListener });
        TRTCCloudImpl.this.mVideoPreprocessListenerAdapter.setListener(paramInt1, paramInt2, paramTRTCVideoFrameListener);
        com.tencent.liteav.d locald = TRTCCloudImpl.this.mCaptureAndEnc;
        if (paramTRTCVideoFrameListener == null) {}
        for (;;)
        {
          locald.b(bool);
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mVideoPreprocessListenerAdapter);
          AppMethodBeat.o(15621);
          return;
          bool = false;
        }
      }
    });
    AppMethodBeat.o(231257);
    return 0;
  }
  
  public int setLocalVideoRenderListener(final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(15869);
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2) && (paramInt1 != 5))
    {
      apiLog("setLocalVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(15869);
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      apiLog("setLocalVideoRenderListener unsupported bufferType : ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(15869);
      return -1328;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15560);
        TRTCCloudImpl.this.apiLog(String.format("setLocalVideoRenderListener pixelFormat:%d bufferType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        TRTCCloudImpl.this.mRoomInfo.localPixelFormat = paramInt1;
        TRTCCloudImpl.this.mRoomInfo.localBufferType = paramInt2;
        TRTCCloudImpl.this.mRoomInfo.localListener = paramTRTCVideoRenderListener;
        if (paramTRTCVideoRenderListener == null)
        {
          TRTCCloudImpl.this.mCaptureAndEnc.a(null, paramInt1);
          AppMethodBeat.o(15560);
          return;
        }
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this, paramInt1);
        AppMethodBeat.o(15560);
      }
    });
    AppMethodBeat.o(15869);
    return 0;
  }
  
  public void setLocalViewFillMode(final int paramInt)
  {
    AppMethodBeat.i(15805);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15773);
        TRTCCloudImpl.this.apiLog("setLocalViewFillMode " + paramInt);
        TRTCCloudImpl.this.mCaptureAndEnc.f(paramInt);
        AppMethodBeat.o(15773);
      }
    });
    AppMethodBeat.o(15805);
  }
  
  public void setLocalViewMirror(final int paramInt)
  {
    AppMethodBeat.i(15813);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15697);
        TRTCCloudImpl.access$5102(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.this.apiLog("setLocalViewMirror " + paramInt);
        TRTCCloudImpl.this.mCaptureAndEnc.b(paramInt);
        TRTCCloudImpl.access$100(TRTCCloudImpl.this);
        AppMethodBeat.o(15697);
      }
    });
    AppMethodBeat.o(15813);
  }
  
  public void setLocalViewRotation(final int paramInt)
  {
    AppMethodBeat.i(15807);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(170190);
        TRTCCloudImpl.this.apiLog("vrotation setLocalViewRotation " + paramInt);
        TRTCCloudImpl.this.mRoomInfo.localRenderRotation = (paramInt * 90);
        TRTCCloudImpl.this.mCaptureAndEnc.g(paramInt * 90);
        TRTCCloudImpl.access$100(TRTCCloudImpl.this);
        AppMethodBeat.o(170190);
      }
    });
    AppMethodBeat.o(15807);
  }
  
  public void setMicVolumeOnMixing(final int paramInt)
  {
    AppMethodBeat.i(15879);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15577);
        TRTCCloudImpl.this.apiLog("setMicVolume " + paramInt);
        float f = paramInt / 100.0F;
        TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
        AppMethodBeat.o(15577);
      }
    });
    AppMethodBeat.o(15879);
  }
  
  public void setMixTranscodingConfig(final TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    AppMethodBeat.i(15896);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15706);
        TRTCCloudImpl.this.apiOnlineLog("setMixTranscodingConfig " + paramTRTCTranscodingConfig);
        if (paramTRTCTranscodingConfig != null)
        {
          TRTCTranscodingConfigInner localTRTCTranscodingConfigInner = new TRTCTranscodingConfigInner(paramTRTCTranscodingConfig);
          TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, localTRTCTranscodingConfigInner);
          AppMethodBeat.o(15706);
          return;
        }
        TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, null);
        AppMethodBeat.o(15706);
      }
    });
    AppMethodBeat.o(15896);
  }
  
  public int setMixedPlayAudioFrameCallbackFormat(final TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    AppMethodBeat.i(231333);
    apiLog(String.format("setMixedPlayAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall))
    {
      AppMethodBeat.o(231333);
      return -1;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15759);
        TXCAudioEngine.getInstance().setPlayoutDataCallbackFormat(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall);
        AppMethodBeat.o(15759);
      }
    });
    AppMethodBeat.o(231333);
    return 0;
  }
  
  public void setMotionMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(15845);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15559);
        TRTCCloudImpl.this.apiLog("setMotionMute " + paramBoolean);
        TRTCCloudImpl.this.getBeautyManager().setMotionMute(paramBoolean);
        AppMethodBeat.o(15559);
      }
    });
    AppMethodBeat.o(15845);
  }
  
  public void setNetworkQosParam(final TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam)
  {
    AppMethodBeat.i(15804);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15632);
        if (paramTRTCNetworkQosParam != null)
        {
          TRTCCloudImpl.this.apiLog("setNetworkQosParam");
          TRTCCloudImpl.access$702(TRTCCloudImpl.this, paramTRTCNetworkQosParam.preference);
          TRTCCloudImpl.access$602(TRTCCloudImpl.this, paramTRTCNetworkQosParam.controlMode);
          TRTCCloudImpl.access$800(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
          AppMethodBeat.o(15632);
          return;
        }
        TRTCCloudImpl.this.apiLog("setNetworkQosParam param is null");
        AppMethodBeat.o(15632);
      }
    });
    AppMethodBeat.o(15804);
  }
  
  public void setNoseSlimLevel(final int paramInt)
  {
    AppMethodBeat.i(15852);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15700);
        TRTCCloudImpl.this.apiLog("setNoseSlimLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setNoseSlimLevel(paramInt);
        AppMethodBeat.o(15700);
      }
    });
    AppMethodBeat.o(15852);
  }
  
  public void setPerformanceMode(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15865);
    if (paramJSONObject == null)
    {
      apiLog("setPerformanceMode[lack parameter]");
      AppMethodBeat.o(15865);
      return;
    }
    if (!paramJSONObject.has("mode"))
    {
      apiLog("setPerformanceMode[lack parameter]: mode");
      AppMethodBeat.o(15865);
      return;
    }
    int i = paramJSONObject.getInt("mode");
    if (i == 1)
    {
      this.mPerformanceMode = 1;
      this.mCaptureAndEnc.b().enableSharpnessEnhancement(false);
      paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
      if (paramJSONObject != null) {
        nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), true);
      }
      AppMethodBeat.o(15865);
      return;
    }
    if (i == 2)
    {
      paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
      if (paramJSONObject != null) {
        nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), false);
      }
      AppMethodBeat.o(15865);
      return;
    }
    this.mPerformanceMode = 0;
    paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (paramJSONObject != null) {
      nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), true);
    }
    AppMethodBeat.o(15865);
  }
  
  public int setPriorRemoteVideoStreamType(final int paramInt)
  {
    AppMethodBeat.i(15812);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15624);
        if ((paramInt != 0) && (paramInt == 1)) {}
        for (TRTCCloudImpl.this.mPriorStreamType = 3;; TRTCCloudImpl.this.mPriorStreamType = 2)
        {
          TRTCCloudImpl.this.apiLog("setPriorRemoteVideoStreamType " + TRTCCloudImpl.this.mPriorStreamType);
          AppMethodBeat.o(15624);
          return;
        }
      }
    });
    AppMethodBeat.o(15812);
    return 0;
  }
  
  public void setRemoteAudioVolume(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15822);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15687);
        int j = paramInt;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        TRTCCloudImpl.this.apiLog("setRemoteAudioVolume: userId = " + paramString + " volume = " + i);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo != null) {
          TXCAudioEngine.getInstance().setRemotePlayoutVolume(String.valueOf(localUserInfo.tinyID), i);
        }
        AppMethodBeat.o(15687);
      }
    });
    AppMethodBeat.o(15822);
  }
  
  public void setRemoteRenderParams(String paramString, int paramInt, TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    AppMethodBeat.i(231105);
    switch (paramInt)
    {
    default: 
      TXCLog.e("TRTCCloudImpl", "setRemoteRenderParams unsupported streamType:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(231105);
      return;
    case 0: 
    case 1: 
      setRemoteViewFillMode(paramString, paramTRTCRenderParams.fillMode);
      setRemoteViewRotation(paramString, paramTRTCRenderParams.rotation);
      setRemoteViewMirror(paramString, paramInt, paramTRTCRenderParams.mirrorType);
      AppMethodBeat.o(231105);
      return;
    }
    setRemoteSubStreamViewFillMode(paramString, paramTRTCRenderParams.fillMode);
    setRemoteSubStreamViewRotation(paramString, paramTRTCRenderParams.rotation);
    setRemoteViewMirror(paramString, paramInt, paramTRTCRenderParams.mirrorType);
    AppMethodBeat.o(231105);
  }
  
  public void setRemoteSubStreamViewFillMode(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15798);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15671);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        TRTCCloudImpl.this.apiLog("setSubStreamRemoteViewFillMode->userId: " + paramString + ", fillMode: " + paramInt);
        if ((localUserInfo != null) && (localUserInfo.subRender.render != null)) {
          localUserInfo.subRender.render.setRenderMode(paramInt);
        }
        AppMethodBeat.o(15671);
      }
    });
    AppMethodBeat.o(15798);
  }
  
  public void setRemoteSubStreamViewRotation(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(182309);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15643);
        TRTCCloudImpl.this.apiLog("setRemoteSubStreamViewRotation->userId: " + paramString + ", rotation: " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.subRender.render != null)) {
          localUserInfo.subRender.render.setRenderRotation(paramInt * 90);
        }
        AppMethodBeat.o(15643);
      }
    });
    AppMethodBeat.o(182309);
  }
  
  public void setRemoteSurface(final String paramString, final int paramInt, final Surface paramSurface)
  {
    AppMethodBeat.i(231240);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15723);
        TRTCCloudImpl.this.apiLog("setRemoteSurface " + paramString + ", " + paramSurface);
        Object localObject = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          if (paramInt == 2) {
            localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
          }
          while (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((com.tencent.liteav.renderer.e)localObject).a(paramSurface);
              AppMethodBeat.o(15723);
              return;
              localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
            }
            else
            {
              TRTCCloudImpl.this.apiLog("videoRender no exist");
              AppMethodBeat.o(15723);
              return;
            }
          }
          TRTCCloudImpl.this.apiLog("render no exist");
          AppMethodBeat.o(15723);
          return;
        }
        TRTCCloudImpl.this.apiLog("user no exist");
        AppMethodBeat.o(15723);
      }
    });
    AppMethodBeat.o(231240);
  }
  
  public void setRemoteSurfaceSize(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(231243);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15684);
        TRTCCloudImpl.this.apiLog("setRemoteSurfaceSize: " + paramString + ", " + paramInt2 + "," + paramInt3);
        Object localObject = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          if (paramInt1 == 2) {
            localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
          }
          while (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((com.tencent.liteav.renderer.e)localObject).d(paramInt2, paramInt3);
              AppMethodBeat.o(15684);
              return;
              localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
            }
            else
            {
              TRTCCloudImpl.this.apiLog("videoRender no exist");
              AppMethodBeat.o(15684);
              return;
            }
          }
          TRTCCloudImpl.this.apiLog("render no exist");
          AppMethodBeat.o(15684);
          return;
        }
        TRTCCloudImpl.this.apiLog("user no exist");
        AppMethodBeat.o(15684);
      }
    });
    AppMethodBeat.o(231243);
  }
  
  public int setRemoteVideoRenderListener(final String paramString, final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(15870);
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2) && (paramInt1 != 5))
    {
      apiLog("setRemoteVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(15870);
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      apiLog("setRemoteVideoRenderListener unsupported bufferType : ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(15870);
      return -1328;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15651);
        TRTCCloudImpl.this.apiLog(String.format("setRemoteVideoRenderListener userid:%s pixelFormat:%d bufferType:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        if (paramTRTCVideoRenderListener == null) {
          TRTCCloudImpl.this.mRenderListenerMap.remove(paramString);
        }
        for (;;)
        {
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(15659);
              TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter;
              if (paramAnonymous2String.equalsIgnoreCase(TRTCCloudImpl.91.this.val$userId))
              {
                localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)TRTCCloudImpl.this.mRenderListenerMap.get(TRTCCloudImpl.91.this.val$userId);
                if (localRenderListenerAdapter != null) {
                  localRenderListenerAdapter.strTinyID = String.valueOf(paramAnonymous2UserInfo.tinyID);
                }
                if (TRTCCloudImpl.91.this.val$listener == null) {
                  break label154;
                }
              }
              label154:
              for (paramAnonymous2String = TRTCCloudImpl.this;; paramAnonymous2String = null)
              {
                if (paramAnonymous2UserInfo.mainRender.render != null) {
                  paramAnonymous2UserInfo.mainRender.render.setVideoFrameListener(paramAnonymous2String, TRTCCloudImpl.access$7900(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
                }
                if (paramAnonymous2UserInfo.subRender.render != null) {
                  paramAnonymous2UserInfo.subRender.render.setVideoFrameListener(paramAnonymous2String, TRTCCloudImpl.access$7900(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
                }
                AppMethodBeat.o(15659);
                return;
              }
            }
          });
          AppMethodBeat.o(15651);
          return;
          TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = new TRTCCloudImpl.RenderListenerAdapter();
          localRenderListenerAdapter.bufferType = paramInt2;
          localRenderListenerAdapter.pixelFormat = paramInt1;
          localRenderListenerAdapter.listener = paramTRTCVideoRenderListener;
          TRTCCloudImpl.this.mRenderListenerMap.put(paramString, localRenderListenerAdapter);
          TRTCCloudImpl.access$7802(TRTCCloudImpl.this, true);
        }
      }
    });
    AppMethodBeat.o(15870);
    return 0;
  }
  
  public int setRemoteVideoStreamType(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15817);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15670);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          AppMethodBeat.o(15670);
          return;
        }
        int i = 2;
        if (paramInt == 1) {
          i = 3;
        }
        if (localUserInfo.streamType == i)
        {
          AppMethodBeat.o(15670);
          return;
        }
        localUserInfo.streamType = i;
        TRTCCloudImpl.this.apiLog("setRemoteVideoStreamType " + paramString + ", " + i + ", " + localUserInfo.tinyID);
        TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, i, false);
        AppMethodBeat.o(15670);
      }
    });
    AppMethodBeat.o(15817);
    return 0;
  }
  
  public void setRemoteViewFillMode(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15806);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15582);
        TRTCCloudImpl.this.apiLog("setRemoteViewFillMode " + paramString + ", " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.mainRender.render != null)) {
          localUserInfo.mainRender.render.setRenderMode(paramInt);
        }
        AppMethodBeat.o(15582);
      }
    });
    AppMethodBeat.o(15806);
  }
  
  public void setRemoteViewRotation(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15808);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15682);
        TRTCCloudImpl.this.apiLog("vrotation setRemoteViewRotation " + paramString + ", " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.mainRender.render != null)) {
          localUserInfo.mainRender.render.setRenderRotation(paramInt * 90);
        }
        AppMethodBeat.o(15682);
      }
    });
    AppMethodBeat.o(15808);
  }
  
  protected void setRenderView(final String paramString, final TRTCRoomInfo.RenderInfo paramRenderInfo, final TXCloudVideoView paramTXCloudVideoView, final TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    AppMethodBeat.i(15956);
    if ((paramRenderInfo == null) || (paramRenderInfo.render == null) || (paramRenderInfo.render.getVideoRender() == null))
    {
      AppMethodBeat.o(15956);
      return;
    }
    final com.tencent.liteav.renderer.e locale = paramRenderInfo.render.getVideoRender();
    if (paramTXCloudVideoView == null)
    {
      locale.c(null);
      AppMethodBeat.o(15956);
      return;
    }
    runOnMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230807);
        Object localObject = paramTXCloudVideoView.getSurfaceView();
        if (localObject != null)
        {
          ((SurfaceView)localObject).setVisibility(0);
          SurfaceHolder localSurfaceHolder = ((SurfaceView)localObject).getHolder();
          localSurfaceHolder.removeCallback(paramRenderInfo);
          localSurfaceHolder.addCallback(paramRenderInfo);
          if (localSurfaceHolder.getSurface().isValid())
          {
            TRTCCloudImpl.this.apiLog(String.format(Locale.ENGLISH, "startRemoteView with valid surface %s, width: %d, height: %d", new Object[] { localSurfaceHolder.getSurface(), Integer.valueOf(((SurfaceView)localObject).getWidth()), Integer.valueOf(((SurfaceView)localObject).getHeight()) }));
            locale.a(localSurfaceHolder.getSurface());
            locale.d(((SurfaceView)localObject).getWidth(), ((SurfaceView)localObject).getHeight());
            AppMethodBeat.o(230807);
            return;
          }
          TRTCCloudImpl.this.apiLog("startRemoteView with surfaceView add callback " + paramRenderInfo);
          AppMethodBeat.o(230807);
          return;
        }
        localObject = new TextureView(paramTXCloudVideoView.getContext());
        paramTXCloudVideoView.addVideoView((TextureView)localObject);
        paramTXCloudVideoView.setVisibility(0);
        paramTXCloudVideoView.setUserId(paramString);
        paramTXCloudVideoView.showVideoDebugLog(TRTCCloudImpl.this.mDebugType);
        if (paramTRTCViewMargin != null) {
          paramTXCloudVideoView.setLogMarginRatio(paramTRTCViewMargin.leftMargin, paramTRTCViewMargin.rightMargin, paramTRTCViewMargin.topMargin, paramTRTCViewMargin.bottomMargin);
        }
        locale.a((TextureView)localObject);
        AppMethodBeat.o(230807);
      }
    });
    AppMethodBeat.o(15956);
  }
  
  public void setReverbType(final int paramInt)
  {
    AppMethodBeat.i(15881);
    if ((paramInt < 0) || (paramInt > 7))
    {
      TXCLog.e("TRTCCloudImpl", "reverbType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(15881);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15708);
        TRTCCloudImpl.this.apiLog("setLocalViewFillMode");
        TXAudioEffectManagerImpl.getInstance().setVoiceReverbType(TRTCCloudImpl.this.reverbTypes[paramInt]);
        AppMethodBeat.o(15708);
      }
    });
    AppMethodBeat.o(15881);
  }
  
  public void setRoomType(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(231250);
    if (paramJSONObject == null)
    {
      apiLog("setRoomType param is null");
      AppMethodBeat.o(231250);
      return;
    }
    if (!paramJSONObject.has("type"))
    {
      apiLog("setRoomType[lack parameter]: type");
      AppMethodBeat.o(231250);
      return;
    }
    this.mRoomType = paramJSONObject.optInt("type", 0);
    AppMethodBeat.o(231250);
  }
  
  public void setSEIPayloadType(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15856);
    if ((paramJSONObject == null) || (!paramJSONObject.has("payloadType")))
    {
      apiLog("callExperimentalAPI[lack parameter or illegal type]: payloadType");
      AppMethodBeat.o(15856);
      return;
    }
    int i = paramJSONObject.getInt("payloadType");
    if ((i != 5) && (i != 243))
    {
      apiLog("callExperimentalAPI[invalid param]: payloadType[" + i + "]");
      AppMethodBeat.o(15856);
      return;
    }
    if (nativeSetSEIPayloadType(this.mNativeRtcContext, i))
    {
      apiLog("callExperimentalAPI[succeeded]: setSEIPayloadType (" + i + ")");
      AppMethodBeat.o(15856);
      return;
    }
    apiLog("callExperimentalAPI[failed]: setSEIPayloadType (" + i + ")");
    AppMethodBeat.o(15856);
  }
  
  public void setSubStreamEncoderParam(final TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    AppMethodBeat.i(231099);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15726);
        for (;;)
        {
          synchronized (TRTCCloudImpl.this.mCustomCaptureLock)
          {
            if (TRTCCloudImpl.this.mSubStreamCaptureAndEnc == null) {
              TRTCCloudImpl.this.mSubStreamCaptureAndEnc = TRTCCloudImpl.access$4600(TRTCCloudImpl.this, 7);
            }
            ??? = TRTCCloudImpl.access$3800(TRTCCloudImpl.this, paramTRTCVideoEncParam.videoResolution, paramTRTCVideoEncParam.videoResolutionMode);
            com.tencent.liteav.g localg = TRTCCloudImpl.this.mSubStreamCaptureAndEnc.c();
            if (paramTRTCVideoEncParam.videoResolutionMode == 1)
            {
              localg.m = 1;
              localg.a = ((com.tencent.liteav.g.a)???).a;
              localg.b = ((com.tencent.liteav.g.a)???).b;
              if (paramTRTCVideoEncParam.videoFps > 0)
              {
                if (paramTRTCVideoEncParam.videoFps <= 30) {
                  break label319;
                }
                TRTCCloudImpl.this.apiLog("setSubStreamEncoderParam fps > 30, limit fps to 30");
                localg.i = 30;
              }
              if (paramTRTCVideoEncParam.videoBitrate > 0) {
                localg.c = paramTRTCVideoEncParam.videoBitrate;
              }
              if (paramTRTCVideoEncParam.minVideoBitrate >= 0) {
                localg.e = paramTRTCVideoEncParam.minVideoBitrate;
              }
              TRTCCloudImpl.access$4700(TRTCCloudImpl.this, 7, localg.a, localg.b, localg.i, localg.c, localg.q, localg.e, true);
              if ((TRTCCloudImpl.this.mCodecType == 2) && (localg.a * localg.b >= 518400)) {
                localg.k = 1;
              }
              TRTCCloudImpl.this.mSubStreamCaptureAndEnc.e(localg.i);
              TRTCCloudImpl.this.mSubStreamCaptureAndEnc.a(localg);
              AppMethodBeat.o(15726);
              return;
            }
          }
          localObject2.m = 0;
          localObject2.a = ((com.tencent.liteav.g.a)???).b;
          localObject2.b = ((com.tencent.liteav.g.a)???).a;
          continue;
          label319:
          localObject2.i = paramTRTCVideoEncParam.videoFps;
        }
      }
    });
    AppMethodBeat.o(231099);
  }
  
  public void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(15823);
    TXDeviceManager.TXSystemVolumeType localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mDeviceManager.setSystemVolumeType(localTXSystemVolumeType);
      AppMethodBeat.o(15823);
      return;
      localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
      continue;
      localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
      continue;
      localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
    }
  }
  
  public void setVideoEncoderMirror(final boolean paramBoolean)
  {
    AppMethodBeat.i(15814);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15724);
        TRTCCloudImpl.this.apiLog("setVideoEncoderMirror " + paramBoolean);
        TRTCCloudImpl.this.mConfig.T = paramBoolean;
        TRTCCloudImpl.this.mCaptureAndEnc.g(paramBoolean);
        TRTCCloudImpl.access$100(TRTCCloudImpl.this);
        AppMethodBeat.o(15724);
      }
    });
    AppMethodBeat.o(15814);
  }
  
  public void setVideoEncoderParam(final TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    AppMethodBeat.i(15803);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15663);
        TRTCCloudImpl.access$3600(TRTCCloudImpl.this, paramTRTCVideoEncParam);
        AppMethodBeat.o(15663);
      }
    });
    AppMethodBeat.o(15803);
  }
  
  public void setVideoEncoderRotation(final int paramInt)
  {
    AppMethodBeat.i(15809);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15730);
        TRTCCloudImpl.this.apiLog("vrotation setVideoEncoderRotation " + paramInt + ", g sensor mode " + TRTCCloudImpl.this.mSensorMode);
        if (TRTCCloudImpl.this.mSensorMode == 0) {
          TRTCCloudImpl.this.mCaptureAndEnc.a(paramInt * 90);
        }
        AppMethodBeat.o(15730);
      }
    });
    AppMethodBeat.o(15809);
  }
  
  public void setVideoMuteImage(final Bitmap paramBitmap, final int paramInt)
  {
    AppMethodBeat.i(231094);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 20;
        AppMethodBeat.i(15748);
        TRTCCloudImpl.this.apiLog("setVideoMuteImage " + paramBitmap + ", " + paramInt);
        int j = paramInt;
        if (j > 20) {}
        for (;;)
        {
          TRTCCloudImpl.this.mConfig.B = paramBitmap;
          TRTCCloudImpl.this.mConfig.D = i;
          TRTCCloudImpl.this.mConfig.C = -1;
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          AppMethodBeat.o(15748);
          return;
          if (j < 5) {
            i = 5;
          } else {
            i = j;
          }
        }
      }
    });
    AppMethodBeat.o(231094);
  }
  
  public boolean setVoiceChangerType(final int paramInt)
  {
    AppMethodBeat.i(15882);
    if ((paramInt < 0) || (paramInt > 11))
    {
      TXCLog.e("TRTCCloudImpl", "voiceChangerType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(15882);
      return false;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15610);
        TXAudioEffectManagerImpl.getInstance().setVoiceChangerType(TRTCCloudImpl.this.voiceChangerTypes[paramInt]);
        AppMethodBeat.o(15610);
      }
    });
    AppMethodBeat.o(15882);
    return true;
  }
  
  public void setWatermark(final Bitmap paramBitmap, final int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(15853);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15777);
        TRTCCloudImpl.this.apiLog("addWatermark stream:" + paramInt);
        if (paramInt != 2)
        {
          TRTCCloudImpl.this.mConfig.F = paramBitmap;
          TRTCCloudImpl.this.mConfig.I = paramFloat1;
          TRTCCloudImpl.this.mConfig.J = paramFloat2;
          TRTCCloudImpl.this.mConfig.K = paramFloat3;
          TRTCCloudImpl.this.mCaptureAndEnc.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        }
        AppMethodBeat.o(15777);
      }
    });
    AppMethodBeat.o(15853);
  }
  
  public void setZoom(int paramInt)
  {
    AppMethodBeat.i(15834);
    this.mDeviceManager.setCameraZoomRatio(paramInt);
    AppMethodBeat.o(15834);
  }
  
  public void showDebugView(final int paramInt)
  {
    AppMethodBeat.i(15890);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15563);
        TRTCCloudImpl.this.apiLog("showDebugView " + paramInt);
        TRTCCloudImpl.this.mDebugType = paramInt;
        final TXCloudVideoView localTXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
        if (localTXCloudVideoView != null) {
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230793);
              localTXCloudVideoView.showVideoDebugLog(TRTCCloudImpl.114.this.val$showType);
              AppMethodBeat.o(230793);
            }
          });
        }
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(final String paramAnonymous2String, final TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230791);
            paramAnonymous2String = paramAnonymous2UserInfo.mainRender.view;
            paramAnonymous2UserInfo = paramAnonymous2UserInfo.subRender.view;
            if ((paramAnonymous2String != null) || (paramAnonymous2UserInfo != null)) {
              TRTCCloudImpl.this.runOnMainThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230675);
                  if (paramAnonymous2String != null) {
                    paramAnonymous2String.showVideoDebugLog(TRTCCloudImpl.114.this.val$showType);
                  }
                  if (paramAnonymous2UserInfo != null) {
                    paramAnonymous2UserInfo.showVideoDebugLog(TRTCCloudImpl.114.this.val$showType);
                  }
                  AppMethodBeat.o(230675);
                }
              });
            }
            AppMethodBeat.o(230791);
          }
        });
        AppMethodBeat.o(15563);
      }
    });
    AppMethodBeat.o(15890);
  }
  
  public void snapshotVideo(final String paramString, final int paramInt, final TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    AppMethodBeat.i(182310);
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15751);
        if (paramString == null)
        {
          TRTCCloudImpl.this.apiLog("snapshotLocalView");
          TRTCCloudImpl.this.mCaptureAndEnc.a(new p()
          {
            public void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(230736);
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230703);
                  if (TRTCCloudImpl.27.this.val$listener != null) {
                    TRTCCloudImpl.27.this.val$listener.onSnapshotComplete(paramAnonymous2Bitmap);
                  }
                  AppMethodBeat.o(230703);
                }
              });
              AppMethodBeat.o(230736);
            }
          });
          AppMethodBeat.o(15751);
          return;
        }
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        Object localObject2 = null;
        Object localObject1;
        if (paramInt == 2)
        {
          localObject1 = localObject2;
          if (localUserInfo != null)
          {
            localObject1 = localObject2;
            if (localUserInfo.mainRender != null)
            {
              localObject1 = localObject2;
              if (localUserInfo.mainRender.render != null)
              {
                TRTCCloudImpl.this.apiLog("snapshotRemoteSubStreamView->userId: " + paramString);
                localObject1 = localUserInfo.subRender.render.getVideoRender();
              }
            }
          }
        }
        while (localObject1 != null)
        {
          ((com.tencent.liteav.renderer.e)localObject1).a(new p()
          {
            public void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(230737);
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(230827);
                  if (TRTCCloudImpl.27.this.val$listener != null) {
                    TRTCCloudImpl.27.this.val$listener.onSnapshotComplete(paramAnonymous2Bitmap);
                  }
                  AppMethodBeat.o(230827);
                }
              });
              AppMethodBeat.o(230737);
            }
          });
          AppMethodBeat.o(15751);
          return;
          localObject1 = localObject2;
          if (localUserInfo != null)
          {
            localObject1 = localObject2;
            if (localUserInfo.mainRender != null)
            {
              localObject1 = localObject2;
              if (localUserInfo.mainRender.render != null)
              {
                TRTCCloudImpl.this.apiLog("snapshotRemoteView->userId: " + paramString);
                localObject1 = localUserInfo.mainRender.render.getVideoRender();
              }
            }
          }
        }
        TRTCCloudImpl.this.runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230735);
            if (TRTCCloudImpl.27.this.val$listener != null) {
              TRTCCloudImpl.27.this.val$listener.onSnapshotComplete(null);
            }
            AppMethodBeat.o(230735);
          }
        });
        AppMethodBeat.o(15751);
      }
    });
    AppMethodBeat.o(182310);
  }
  
  public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams)
  {
    AppMethodBeat.i(15830);
    if (TextUtils.isEmpty(paramTRTCAudioRecordingParams.filePath))
    {
      apiLog("startLocalAudioRecord error:" + paramTRTCAudioRecordingParams.filePath);
      AppMethodBeat.o(15830);
      return -1;
    }
    apiLog("startLocalAudioRecord:" + paramTRTCAudioRecordingParams.filePath);
    TXCAudioEngine.getInstance().setAudioDumpingListener(new TXCAudioEngineJNI.a()
    {
      public void onLocalAudioWriteFailed()
      {
        AppMethodBeat.i(230639);
        TRTCCloudImpl.this.runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230836);
            TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
            if (localTRTCCloudListener == null)
            {
              AppMethodBeat.o(230836);
              return;
            }
            TRTCCloudImpl.this.apiLog("startLocalAudioRecord onWarning:7001");
            localTRTCCloudListener.onWarning(7001, "write file failed when recording audio.", null);
            AppMethodBeat.o(230836);
          }
        });
        AppMethodBeat.o(230639);
      }
    });
    int i = TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, paramTRTCAudioRecordingParams.filePath);
    AppMethodBeat.o(15830);
    return i;
  }
  
  public void startCollectStatus()
  {
    AppMethodBeat.i(15983);
    if (this.mSDKHandler != null) {
      this.mSDKHandler.postDelayed(this.mStatusNotifyTask, 1000L);
    }
    AppMethodBeat.o(15983);
  }
  
  public void startLocalAudio()
  {
    AppMethodBeat.i(15815);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15568);
        if (TRTCCloudImpl.this.mEnableCustomAudioCapture)
        {
          TRTCCloudImpl.this.apiLog("startLocalAudio when enable custom audio capturing, ignore!!!");
          AppMethodBeat.o(15568);
          return;
        }
        if (TRTCCloudImpl.this.mIsAudioCapturing)
        {
          TRTCCloudImpl.this.apiLog("startLocalAudio when capturing audio, ignore!!!");
          AppMethodBeat.o(15568);
          return;
        }
        if (TRTCCloudImpl.this.mCurrentRole == 21)
        {
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230741);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener == null)
              {
                AppMethodBeat.o(230741);
                return;
              }
              localTRTCCloudListener.onWarning(6001, "ignore start local audio,for role audience", null);
              AppMethodBeat.o(230741);
            }
          });
          TRTCCloudImpl.this.apiLog("ignore startLocalAudio,for role audience");
        }
        TRTCCloudImpl.this.apiOnlineLog("startLocalAudio");
        TXCEventRecorderProxy.a("18446744073709551615", 3001, 0L, -1L, "", 0);
        TXCKeyPointReportProxy.a(30002);
        TRTCCloudImpl.access$1502(TRTCCloudImpl.this, true);
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
        TRTCCloudImpl.access$5200(TRTCCloudImpl.this);
        TXCAudioEngine.getInstance().enableCaptureEOSMode(TRTCCloudImpl.this.mEnableEosMode);
        TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
        TXCAudioEngine.getInstance().startLocalAudio(11, false);
        TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
        TXCAudioEngine.getInstance().muteLocalAudio(TRTCCloudImpl.this.mRoomInfo.muteLocalAudio);
        TXCEventRecorderProxy.a("18446744073709551615", 3003, 11L, -1L, "", 0);
        TRTCCloudImpl.this.enableAudioStream(true);
        TXCKeyPointReportProxy.a(40050, 1, 1);
        AppMethodBeat.o(15568);
      }
    });
    AppMethodBeat.o(15815);
  }
  
  public void startLocalAudio(int paramInt)
  {
    AppMethodBeat.i(231128);
    setAudioQuality(paramInt);
    startLocalAudio();
    AppMethodBeat.o(231128);
  }
  
  public void startLocalPreview(final boolean paramBoolean, final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(15792);
    this.mDeviceManager.setFrontCamera(paramBoolean);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15585);
        int i;
        Object localObject2;
        Object localObject1;
        label111:
        boolean bool;
        if (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)
        {
          i = 1;
          if (i != 0) {
            TRTCCloudImpl.this.apiLog("startLocalPreview just reset view when is started");
          }
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230829);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(230829);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore start local preview,for role audience", null);
                AppMethodBeat.o(230829);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
          }
          localObject2 = new StringBuilder("startLocalPreview front:").append(paramBoolean).append(", view:");
          if (paramTXCloudVideoView == null) {
            break label449;
          }
          localObject1 = Integer.valueOf(paramTXCloudVideoView.hashCode());
          localObject1 = localObject1 + " " + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiOnlineLog((String)localObject1);
          TXCEventRecorderProxy.a("18446744073709551615", 4006, 2L, -1L, "", 2);
          TRTCCloudImpl.access$1300(TRTCCloudImpl.this);
          TRTCCloudImpl.this.mRoomInfo.localView = paramTXCloudVideoView;
          TRTCCloudImpl.this.mConfig.n = paramBoolean;
          localObject1 = TRTCCloudImpl.this.mConfig;
          if (TRTCCloudImpl.this.mPerformanceMode != 1) {
            break label455;
          }
          bool = true;
          label217:
          ((com.tencent.liteav.g)localObject1).V = bool;
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TXCKeyPointReportProxy.a(40046, 1, 2);
          TRTCCloudImpl.access$2102(TRTCCloudImpl.this, true);
          TRTCCloudImpl.this.mOrientationEventListener.enable();
          TRTCCloudImpl.access$100(TRTCCloudImpl.this);
          TRTCCloudImpl.this.enableVideoStream(true);
          if (paramTXCloudVideoView == null) {
            break label460;
          }
          localObject1 = paramTXCloudVideoView.getSurfaceView();
          label295:
          if (paramTXCloudVideoView == null) {
            break label465;
          }
          localObject2 = paramTXCloudVideoView.getHWVideoView();
          label311:
          if ((localObject1 == null) && (localObject2 == null)) {
            break label483;
          }
          if ((i != 0) || (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)) {
            break label471;
          }
          TRTCCloudImpl.access$1602(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.CAMERA);
          TRTCCloudImpl.this.mCaptureAndEnc.a(null);
        }
        for (;;)
        {
          final Surface[] arrayOfSurface = new Surface[1];
          final com.tencent.liteav.basic.util.e locale = new com.tencent.liteav.basic.util.e();
          TRTCCloudImpl.access$2400(TRTCCloudImpl.this, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230835);
              Object localObject;
              if (this.val$surfaceView != null)
              {
                localObject = this.val$surfaceView.getHolder();
                ((SurfaceHolder)localObject).removeCallback(TRTCCloudImpl.this);
                ((SurfaceHolder)localObject).addCallback(TRTCCloudImpl.this);
                if (((SurfaceHolder)localObject).getSurface().isValid())
                {
                  TRTCCloudImpl.this.apiLog("startLocalPreview with valid surface " + ((SurfaceHolder)localObject).getSurface() + " width " + this.val$surfaceView.getWidth() + ", height " + this.val$surfaceView.getHeight());
                  arrayOfSurface[0] = ((SurfaceHolder)localObject).getSurface();
                  locale.a = this.val$surfaceView.getWidth();
                  locale.b = this.val$surfaceView.getHeight();
                }
              }
              else if (this.val$textureView != null)
              {
                localObject = this.val$textureView.getSurfaceTexture();
                this.val$textureView.setSurfaceTextureListener(TRTCCloudImpl.this.mTextureViewListener);
                if (localObject == null) {
                  break label445;
                }
                TRTCCloudImpl.access$002(TRTCCloudImpl.this, new Surface((SurfaceTexture)localObject));
                arrayOfSurface[0] = TRTCCloudImpl.this.mSurfaceFromTextureView;
                locale.a = this.val$textureView.getWidth();
                locale.b = this.val$textureView.getHeight();
                TRTCCloudImpl.this.apiLog("startLocalPreview with TextureView, SurfaceTexture: %s, width: %d, height: %d", new Object[] { localObject, Integer.valueOf(locale.a), Integer.valueOf(locale.b) });
              }
              for (;;)
              {
                if (TRTCCloudImpl.18.this.val$view != null)
                {
                  TRTCCloudImpl.18.this.val$view.showVideoDebugLog(TRTCCloudImpl.this.mDebugType);
                  if (TRTCCloudImpl.this.mRoomInfo.debugMargin != null) {
                    TRTCCloudImpl.18.this.val$view.setLogMarginRatio(TRTCCloudImpl.this.mRoomInfo.debugMargin.leftMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.rightMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.topMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.bottomMargin);
                  }
                }
                AppMethodBeat.o(230835);
                return;
                TRTCCloudImpl.this.apiLog("startLocalPreview with surfaceView add callback");
                break;
                label445:
                TRTCCloudImpl.this.apiLog("startLocalPreview with textureView add callback");
              }
            }
          });
          if (arrayOfSurface[0] != null)
          {
            TRTCCloudImpl.this.mCaptureAndEnc.a(arrayOfSurface[0]);
            TRTCCloudImpl.this.mCaptureAndEnc.a(locale.a, locale.b);
          }
          AppMethodBeat.o(15585);
          return;
          i = 0;
          break;
          label449:
          localObject1 = "";
          break label111;
          label455:
          bool = false;
          break label217;
          label460:
          localObject1 = null;
          break label295;
          label465:
          localObject2 = null;
          break label311;
          label471:
          TRTCCloudImpl.this.apiLog("startLocalPreview with surface view when is started");
          continue;
          label483:
          if ((i == 0) && (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.NONE))
          {
            TRTCCloudImpl.access$1602(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.CAMERA);
            TRTCCloudImpl.this.mCaptureAndEnc.a(paramTXCloudVideoView);
          }
          else
          {
            TRTCCloudImpl.this.apiLog("startLocalPreview with view view when is started");
          }
        }
      }
    });
    AppMethodBeat.o(15792);
  }
  
  public void startLocalRecording(final TRTCCloudDef.TRTCLocalRecordingParams paramTRTCLocalRecordingParams)
  {
    AppMethodBeat.i(231202);
    if (paramTRTCLocalRecordingParams == null)
    {
      apiLog("startLocalRecording params is null!");
      onLocalRecordBegin(-1, "");
      AppMethodBeat.o(231202);
      return;
    }
    if ((paramTRTCLocalRecordingParams.recordType != 0) && (paramTRTCLocalRecordingParams.recordType != 1) && (paramTRTCLocalRecordingParams.recordType != 2))
    {
      apiLog("startLocalRecording recordType invalid: " + paramTRTCLocalRecordingParams.recordType);
      onLocalRecordBegin(-1, paramTRTCLocalRecordingParams.filePath);
      AppMethodBeat.o(231202);
      return;
    }
    if (((paramTRTCLocalRecordingParams.interval < 1000) || (paramTRTCLocalRecordingParams.interval > 10000)) && (paramTRTCLocalRecordingParams.interval != -1))
    {
      apiLog("startLocalRecording interval invalid: " + paramTRTCLocalRecordingParams.interval);
      onLocalRecordBegin(-1, paramTRTCLocalRecordingParams.filePath);
      AppMethodBeat.o(231202);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15770);
        TRTCCloudImpl.this.apiLog("startLocalRecording params: " + paramTRTCLocalRecordingParams);
        TRTCCloudImpl.access$5600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramTRTCLocalRecordingParams);
        TRTCCloudImpl.this.mCaptureAndEnc.k(2);
        AppMethodBeat.o(15770);
      }
    });
    AppMethodBeat.o(231202);
  }
  
  public void startPublishCDNStream(final TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    AppMethodBeat.i(15894);
    if (paramTRTCPublishCDNParam == null)
    {
      apiLog("startPublishCDNStream param is null");
      AppMethodBeat.o(15894);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15611);
        TRTCCloudImpl.this.apiLog("startPublishCDNStream");
        TRTCCloudImpl.access$8300(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramTRTCPublishCDNParam);
        AppMethodBeat.o(15611);
      }
    });
    AppMethodBeat.o(15894);
  }
  
  public void startPublishing(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(182322);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 2;
        AppMethodBeat.i(15767);
        TRTCCloudImpl.this.apiLog("startPublishing streamId:" + paramString + ", streamType:" + paramInt);
        if (paramInt == 2) {
          i = 7;
        }
        TRTCCloudImpl.access$8600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramString, i);
        AppMethodBeat.o(15767);
      }
    });
    AppMethodBeat.o(182322);
  }
  
  public void startRemoteSubStreamView(final String paramString, final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(15796);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15587);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user is not exist save view" + paramString);
          localUserInfo = TRTCCloudImpl.access$2600(TRTCCloudImpl.this, paramString);
          localUserInfo.subRender.view = paramTXCloudVideoView;
          localUserInfo.subRender.startRenderView = Boolean.TRUE;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
          AppMethodBeat.o(15587);
          return;
        }
        if ((paramTXCloudVideoView != null) && (paramTXCloudVideoView.equals(localUserInfo.subRender.view)))
        {
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user view is the same, ignore " + paramString);
          AppMethodBeat.o(15587);
          return;
        }
        if (localUserInfo.subRender.view != null) {}
        for (int i = 1;; i = 0)
        {
          localUserInfo.subRender.view = paramTXCloudVideoView;
          localUserInfo.subRender.startRenderView = Boolean.TRUE;
          if (localUserInfo.subRender.tinyID != 0L) {
            break;
          }
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user tinyID is 0, ignore " + paramString);
          AppMethodBeat.o(15587);
          return;
        }
        TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4015, 1L, -1L, "", 7);
        TRTCCloudImpl.this.setRenderView(paramString, localUserInfo.subRender, paramTXCloudVideoView, localUserInfo.debugMargin);
        TRTCCloudImpl localTRTCCloudImpl = TRTCCloudImpl.this;
        String str = paramString;
        long l = localUserInfo.tinyID;
        if (paramTXCloudVideoView != null) {}
        for (int j = paramTXCloudVideoView.hashCode();; j = 0)
        {
          localTRTCCloudImpl.apiOnlineLog(String.format("startRemoteSubStreamView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { str, Long.valueOf(l), Integer.valueOf(7), Integer.valueOf(j) }));
          TRTCCloudImpl.access$2700(TRTCCloudImpl.this, String.valueOf(localUserInfo.tinyID), 7, 0, "Start watching " + paramString);
          if ((i == 0) || (!localUserInfo.subRender.render.isRendering())) {
            TRTCCloudImpl.access$2800(TRTCCloudImpl.this, localUserInfo.subRender.render, 7);
          }
          if (localUserInfo.subRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
            break;
          }
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 7, true);
          AppMethodBeat.o(15587);
          return;
        }
        TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 7, true);
        TXCKeyPointReportProxy.a(String.valueOf(localUserInfo.tinyID), 40021, 0L, 7);
        AppMethodBeat.o(15587);
      }
    });
    AppMethodBeat.o(15796);
  }
  
  public void startRemoteView(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(231095);
    switch (paramInt)
    {
    default: 
      TXCLog.e("TRTCCloudImpl", "startRemoteView unsupported streamType:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(231095);
      return;
    case 0: 
    case 1: 
      startRemoteView(paramString, paramTXCloudVideoView);
      setRemoteVideoStreamType(paramString, paramInt);
      AppMethodBeat.o(231095);
      return;
    }
    startRemoteSubStreamView(paramString, paramTXCloudVideoView);
    AppMethodBeat.o(231095);
  }
  
  public void startRemoteView(final String paramString, final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(15794);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15712);
        Object localObject1 = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject1 == null)
        {
          localObject1 = TRTCCloudImpl.access$2600(TRTCCloudImpl.this, paramString);
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = paramTXCloudVideoView;
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView = Boolean.TRUE;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, (TRTCRoomInfo.UserInfo)localObject1);
          localObject1 = String.format("Remote-startRemoteView userID:%s (save view before user enter)", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiOnlineLog((String)localObject1);
          AppMethodBeat.o(15712);
          return;
        }
        if ((paramTXCloudVideoView != null) && (paramTXCloudVideoView.equals(((TRTCRoomInfo.UserInfo)localObject1).mainRender.view)))
        {
          TRTCCloudImpl.this.apiLog("startRemoteView user view is the same, ignore " + paramString);
          AppMethodBeat.o(15712);
          return;
        }
        if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.view != null) {}
        for (int i = 1;; i = 0)
        {
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = paramTXCloudVideoView;
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView = Boolean.TRUE;
          if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.tinyID != 0L) {
            break;
          }
          TRTCCloudImpl.this.apiLog("startRemoteView user tinyID is 0, ignore " + paramString);
          AppMethodBeat.o(15712);
          return;
        }
        TRTCCloudImpl.this.setRenderView(paramString, ((TRTCRoomInfo.UserInfo)localObject1).mainRender, paramTXCloudVideoView, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
        Object localObject2 = new StringBuilder();
        String str = paramString;
        long l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
        int k = ((TRTCRoomInfo.UserInfo)localObject1).streamType;
        int j;
        if (paramTXCloudVideoView != null)
        {
          j = paramTXCloudVideoView.hashCode();
          localObject2 = String.format("Remote-startRemoteView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { str, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(j) }) + " self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiOnlineLog((String)localObject2);
          TRTCCloudImpl.access$2700(TRTCCloudImpl.this, String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), ((TRTCRoomInfo.UserInfo)localObject1).streamType, 0, "Start watching " + paramString);
          if ((i == 0) || (!((TRTCRoomInfo.UserInfo)localObject1).mainRender.render.isRendering())) {
            TRTCCloudImpl.access$2800(TRTCCloudImpl.this, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
          }
          if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo != TRTCRoomInfo.TRTCRemoteMuteState.MUTE) {
            break label575;
          }
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
        }
        for (;;)
        {
          TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 1L, -1L, "", 0);
          AppMethodBeat.o(15712);
          return;
          j = 0;
          break;
          label575:
          TRTCCloudImpl.access$3000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
          TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
        }
      }
    });
    AppMethodBeat.o(15794);
  }
  
  public void startScreenCapture(final TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    AppMethodBeat.i(231089);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15580);
        if (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)
        {
          TRTCCloudImpl.access$3300(TRTCCloudImpl.this, "Has started capturing, ignore startScreenCapture");
          AppMethodBeat.o(15580);
          return;
        }
        TRTCCloudImpl.access$1602(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.SCREEN);
        TRTCCloudImpl.access$3402(TRTCCloudImpl.this, 0);
        TRTCCloudImpl.this.mOrientationEventListener.disable();
        TRTCCloudImpl.access$1300(TRTCCloudImpl.this);
        if (paramTRTCVideoEncParam != null)
        {
          TRTCCloudImpl.access$3502(TRTCCloudImpl.this, false);
          TRTCCloudImpl.access$3600(TRTCCloudImpl.this, paramTRTCVideoEncParam);
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(230877);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(230877);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore start local preview,for role audience", null);
                AppMethodBeat.o(230877);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
          }
          TRTCCloudImpl.this.apiOnlineLog("startScreenCapture");
          TRTCCloudImpl.this.mCaptureAndEnc.a(0);
          if ((TRTCCloudImpl.this.mConfig.m != 1) && (TRTCCloudImpl.this.mConfig.m != 3)) {
            break label425;
          }
          TRTCCloudImpl.access$3700(TRTCCloudImpl.this, true, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.b, TRTCCloudImpl.this.mConfig.i, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.q, TRTCCloudImpl.this.mConfig.e, TRTCCloudImpl.this.mConfig.h);
        }
        for (;;)
        {
          com.tencent.liteav.g.a locala = TRTCCloudImpl.access$3800(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
          TRTCCloudImpl.access$3900(TRTCCloudImpl.this, locala.a, locala.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
          TRTCCloudImpl.this.mRoomInfo.localView = null;
          TRTCCloudImpl.this.enableVideoStream(true);
          TXCKeyPointReportProxy.a(40046, 1, 2);
          TXCEventRecorderProxy.a("18446744073709551615", 4006, 2L, -1L, "", 2);
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this);
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230882);
              if (TRTCCloudImpl.28.this.val$screenShareParams != null) {
                TRTCCloudImpl.access$4000(TRTCCloudImpl.this, TRTCCloudImpl.28.this.val$screenShareParams.floatingView);
              }
              AppMethodBeat.o(230882);
            }
          });
          AppMethodBeat.o(15580);
          return;
          TRTCCloudImpl.access$3502(TRTCCloudImpl.this, true);
          break;
          label425:
          TRTCCloudImpl.access$3700(TRTCCloudImpl.this, false, TRTCCloudImpl.this.mConfig.b, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.i, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.q, TRTCCloudImpl.this.mConfig.e, TRTCCloudImpl.this.mConfig.h);
        }
      }
    });
    AppMethodBeat.o(231089);
  }
  
  public void startSpeedTest(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(15892);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      TXCLog.e("TRTCCloudImpl", "startSpeedTest failed with invalid params. userId = " + paramString1 + ", userSig = " + paramString2 + " self:" + hashCode());
      AppMethodBeat.o(15892);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15557);
        TRTCCloudImpl.this.apiLog("startSpeedTest");
        TRTCCloudImpl.access$8100(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt, paramString1, paramString2);
        AppMethodBeat.o(15557);
      }
    });
    AppMethodBeat.o(15892);
  }
  
  protected void startVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(15828);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, this.mAudioVolumeEvalInterval);
    if (paramBoolean)
    {
      if (this.mVolumeLevelNotifyTask == null) {
        this.mVolumeLevelNotifyTask = new VolumeLevelNotifyTask(this);
      }
      if (this.mVolumeLevelNotifyTask != null) {
        this.mSDKHandler.removeCallbacks(this.mVolumeLevelNotifyTask);
      }
      this.mSDKHandler.postDelayed(this.mVolumeLevelNotifyTask, this.mAudioVolumeEvalInterval);
      AppMethodBeat.o(15828);
      return;
    }
    if (this.mVolumeLevelNotifyTask != null) {
      this.mSDKHandler.removeCallbacks(this.mVolumeLevelNotifyTask);
    }
    this.mAudioVolumeEvalInterval = 0;
    AppMethodBeat.o(15828);
  }
  
  public void stopAllAudioEffects()
  {
    AppMethodBeat.i(15888);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15696);
        TRTCCloudImpl.this.apiLog("stopAllAudioEffects");
        TXCSoundEffectPlayer.getInstance().stopAllEffect();
        AppMethodBeat.o(15696);
      }
    });
    AppMethodBeat.o(15888);
  }
  
  public void stopAllRemoteView()
  {
    AppMethodBeat.i(15799);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15656);
        TRTCCloudImpl.this.apiOnlineLog("stopAllRemoteView");
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230845);
            TRTCCloudImpl.access$3100(TRTCCloudImpl.this, paramAnonymous2UserInfo, Boolean.TRUE);
            TRTCCloudImpl.access$3200(TRTCCloudImpl.this, paramAnonymous2UserInfo);
            paramAnonymous2UserInfo.mainRender.view = null;
            paramAnonymous2UserInfo.mainRender.startRenderView = Boolean.FALSE;
            paramAnonymous2UserInfo.subRender.view = null;
            paramAnonymous2UserInfo.subRender.startRenderView = Boolean.FALSE;
            AppMethodBeat.o(230845);
          }
        });
        AppMethodBeat.o(15656);
      }
    });
    AppMethodBeat.o(15799);
  }
  
  public void stopAudioEffect(final int paramInt)
  {
    AppMethodBeat.i(15887);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15705);
        TRTCCloudImpl.this.apiLog("stopAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().stopEffectWithId(paramInt);
        AppMethodBeat.o(15705);
      }
    });
    AppMethodBeat.o(15887);
  }
  
  public void stopAudioRecording()
  {
    AppMethodBeat.i(15831);
    TXCAudioEngine.getInstance().stopLocalAudioDumping();
    AppMethodBeat.o(15831);
  }
  
  public void stopBGM()
  {
    AppMethodBeat.i(15874);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15725);
        TRTCCloudImpl.this.apiLog("stopBGM");
        TXCLiveBGMPlayer.getInstance().stopPlay();
        TRTCCloudImpl.access$8002(TRTCCloudImpl.this, null);
        AppMethodBeat.o(15725);
      }
    });
    AppMethodBeat.o(15874);
  }
  
  protected void stopCollectStatus()
  {
    AppMethodBeat.i(15984);
    if (this.mSDKHandler != null) {
      this.mSDKHandler.removeCallbacks(this.mStatusNotifyTask);
    }
    AppMethodBeat.o(15984);
  }
  
  public void stopLocalAudio()
  {
    AppMethodBeat.i(15816);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15778);
        TRTCCloudImpl.access$5300(TRTCCloudImpl.this);
        AppMethodBeat.o(15778);
      }
    });
    AppMethodBeat.o(15816);
  }
  
  public void stopLocalPreview()
  {
    AppMethodBeat.i(15793);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15683);
        TRTCCloudImpl.this.apiOnlineLog("stopLocalPreview");
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.CAMERA)
        {
          TRTCCloudImpl.access$1602(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.NONE);
          TRTCCloudImpl.this.mCaptureAndEnc.d(true);
        }
        if (TRTCCloudImpl.this.mRoomInfo.localView != null)
        {
          final SurfaceView localSurfaceView = TRTCCloudImpl.this.mRoomInfo.localView.getSurfaceView();
          final TextureView localTextureView = TRTCCloudImpl.this.mRoomInfo.localView.getHWVideoView();
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230710);
              if (localSurfaceView != null)
              {
                localSurfaceView.getHolder().removeCallback(TRTCCloudImpl.this);
                AppMethodBeat.o(230710);
                return;
              }
              if (localTextureView != null) {
                localTextureView.setSurfaceTextureListener(null);
              }
              AppMethodBeat.o(230710);
            }
          });
        }
        TRTCCloudImpl.this.mRoomInfo.localView = null;
        TRTCCloudImpl.access$2102(TRTCCloudImpl.this, false);
        TRTCCloudImpl.this.mOrientationEventListener.disable();
        if (!TRTCCloudImpl.this.mEnableCustomVideoCapture) {
          TRTCCloudImpl.this.enableVideoStream(false);
        }
        TXCKeyPointReportProxy.a(40046, 0, 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4006, 3L, -1L, "", 2);
        AppMethodBeat.o(15683);
      }
    });
    AppMethodBeat.o(15793);
  }
  
  public void stopLocalRecording()
  {
    AppMethodBeat.i(231205);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15586);
        TRTCCloudImpl.this.apiLog("stopLocalRecording");
        TRTCCloudImpl.access$5700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15586);
      }
    });
    AppMethodBeat.o(231205);
  }
  
  public void stopPublishCDNStream()
  {
    AppMethodBeat.i(15895);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15628);
        TRTCCloudImpl.this.apiLog("stopPublishCDNStream");
        TRTCCloudImpl.access$8500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15628);
      }
    });
    AppMethodBeat.o(15895);
  }
  
  public void stopPublishing()
  {
    AppMethodBeat.i(182321);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15565);
        TRTCCloudImpl.this.apiLog("stopPublishing");
        TRTCCloudImpl.access$8400(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15565);
      }
    });
    AppMethodBeat.o(182321);
  }
  
  public void stopRemoteRender(TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(15960);
    if (paramUserInfo == null)
    {
      AppMethodBeat.o(15960);
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(paramUserInfo.streamType) }));
    com.tencent.liteav.audio.a.a().a(String.valueOf(paramUserInfo.tinyID), hashCode());
    final TXCloudVideoView localTXCloudVideoView1 = paramUserInfo.mainRender.view;
    final TXCloudVideoView localTXCloudVideoView2 = paramUserInfo.subRender.view;
    if (paramUserInfo.mainRender.render != null)
    {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
      paramUserInfo.mainRender.render.stop();
      if ((localTXCloudVideoView1 == null) && (paramUserInfo.mainRender.render.getVideoRender() != null)) {
        paramUserInfo.mainRender.render.getVideoRender().d();
      }
    }
    if (paramUserInfo.subRender.render != null)
    {
      paramUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
      paramUserInfo.subRender.render.stop();
      if ((localTXCloudVideoView2 == null) && (paramUserInfo.subRender.render.getVideoRender() != null)) {
        paramUserInfo.subRender.render.getVideoRender().d();
      }
    }
    paramUserInfo.mainRender.stop();
    paramUserInfo.subRender.stop();
    runOnMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230783);
        if (localTXCloudVideoView1 != null) {
          localTXCloudVideoView1.removeVideoView();
        }
        if (localTXCloudVideoView2 != null) {
          localTXCloudVideoView2.removeVideoView();
        }
        AppMethodBeat.o(230783);
      }
    });
    AppMethodBeat.o(15960);
  }
  
  public void stopRemoteSubStreamView(final String paramString)
  {
    AppMethodBeat.i(15797);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15556);
        final TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("stopRemoteSubStreamView user is not exist " + paramString);
          AppMethodBeat.o(15556);
          return;
        }
        TRTCCloudImpl.this.apiOnlineLog(String.format("stopRemoteSubStreamView userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(localUserInfo.tinyID), Integer.valueOf(localUserInfo.streamType) }));
        TRTCCloudImpl.access$3200(TRTCCloudImpl.this, localUserInfo);
        final TXCloudVideoView localTXCloudVideoView = localUserInfo.subRender.view;
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230712);
            if (localTXCloudVideoView != null)
            {
              SurfaceView localSurfaceView = localTXCloudVideoView.getSurfaceView();
              if ((localSurfaceView != null) && (localUserInfo.subRender != null)) {
                localSurfaceView.getHolder().removeCallback(localUserInfo.subRender);
              }
              localTXCloudVideoView.removeVideoView();
            }
            AppMethodBeat.o(230712);
          }
        });
        localUserInfo.subRender.view = null;
        localUserInfo.subRender.startRenderView = Boolean.FALSE;
        AppMethodBeat.o(15556);
      }
    });
    AppMethodBeat.o(15797);
  }
  
  public void stopRemoteView(final String paramString)
  {
    AppMethodBeat.i(15795);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15617);
        final TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("stopRemoteRender user is not exist " + paramString);
          AppMethodBeat.o(15617);
          return;
        }
        TRTCCloudImpl.this.apiOnlineLog(String.format("stopRemoteView userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(localUserInfo.tinyID), Integer.valueOf(localUserInfo.streamType) }));
        TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4015, 0L, -1L, "", 0);
        TRTCCloudImpl.access$3100(TRTCCloudImpl.this, localUserInfo, Boolean.FALSE);
        final TXCloudVideoView localTXCloudVideoView = localUserInfo.mainRender.view;
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230705);
            if (localTXCloudVideoView != null)
            {
              SurfaceView localSurfaceView = localTXCloudVideoView.getSurfaceView();
              if ((localSurfaceView != null) && (localUserInfo.mainRender != null)) {
                localSurfaceView.getHolder().removeCallback(localUserInfo.mainRender);
              }
              localTXCloudVideoView.removeVideoView();
            }
            AppMethodBeat.o(230705);
          }
        });
        localUserInfo.mainRender.view = null;
        localUserInfo.mainRender.startRenderView = Boolean.FALSE;
        AppMethodBeat.o(15617);
      }
    });
    AppMethodBeat.o(15795);
  }
  
  public void stopRemoteView(String paramString, int paramInt)
  {
    AppMethodBeat.i(231096);
    switch (paramInt)
    {
    default: 
      TXCLog.e("TRTCCloudImpl", "stopRemoteView unsupported streamType:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(231096);
      return;
    case 0: 
    case 1: 
      stopRemoteView(paramString);
      AppMethodBeat.o(231096);
      return;
    }
    stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(231096);
  }
  
  public void stopScreenCapture()
  {
    AppMethodBeat.i(231091);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15583);
        if (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiOnlineLog("stopScreenCapture been ignored for Screen capture is not started");
          AppMethodBeat.o(15583);
          return;
        }
        TRTCCloudImpl.access$1602(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.NONE);
        TRTCCloudImpl.this.apiOnlineLog("stopScreenCapture");
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230728);
            TRTCCloudImpl.access$4100(TRTCCloudImpl.this);
            AppMethodBeat.o(230728);
          }
        });
        TRTCCloudImpl.this.mCaptureAndEnc.m();
        TRTCCloudImpl.this.mRoomInfo.localView = null;
        TRTCCloudImpl.this.enableVideoStream(false);
        TXCKeyPointReportProxy.a(40046, 0, 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4006, 3L, -1L, "", 2);
        TRTCCloudImpl.this.mConfig.i = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt("config_fps", TRTCCloudImpl.this.mConfig.i);
        TRTCCloudImpl.this.mConfig.j = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt("config_gop", TRTCCloudImpl.this.mConfig.j);
        TRTCCloudImpl.this.mConfig.q = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getBoolean("config_adjust_resolution", TRTCCloudImpl.this.mConfig.q);
        TRTCCloudImpl.this.mSmallEncParam.videoFps = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getInt("config_fps", TRTCCloudImpl.this.mSmallEncParam.videoFps);
        TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getBoolean("config_adjust_resolution", TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes);
        TXCLog.i("TRTCCloudImpl", String.format(Locale.ENGLISH, "restore big encoder's fps: %d, gop: %d, small encoder's fps: %d", new Object[] { Integer.valueOf(TRTCCloudImpl.this.mConfig.i), Integer.valueOf(TRTCCloudImpl.this.mConfig.j), Integer.valueOf(TRTCCloudImpl.this.mSmallEncParam.videoFps) }));
        AppMethodBeat.o(15583);
      }
    });
    AppMethodBeat.o(231091);
  }
  
  public void stopSpeedTest()
  {
    AppMethodBeat.i(15893);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15620);
        TRTCCloudImpl.this.apiLog("stopSpeedTest");
        TRTCCloudImpl.access$8200(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15620);
      }
    });
    AppMethodBeat.o(15893);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15826);
    apiLog("startLocalPreview surfaceChanged " + paramSurfaceHolder.getSurface() + " width " + paramInt2 + ", height " + paramInt3);
    this.mCaptureAndEnc.a(paramInt2, paramInt3);
    AppMethodBeat.o(15826);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(15825);
    if (paramSurfaceHolder.getSurface().isValid())
    {
      apiLog("startLocalPreview surfaceCreated " + paramSurfaceHolder.getSurface());
      this.mCaptureAndEnc.a(paramSurfaceHolder.getSurface());
    }
    AppMethodBeat.o(15825);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(15827);
    apiLog("startLocalPreview surfaceDestroyed " + paramSurfaceHolder.getSurface());
    this.mCaptureAndEnc.a(null);
    AppMethodBeat.o(15827);
  }
  
  public void switchCamera()
  {
    AppMethodBeat.i(15832);
    TXDeviceManagerImpl localTXDeviceManagerImpl = this.mDeviceManager;
    if (!this.mDeviceManager.isFrontCamera()) {}
    for (boolean bool = true;; bool = false)
    {
      localTXDeviceManagerImpl.switchCamera(bool);
      AppMethodBeat.o(15832);
      return;
    }
  }
  
  public void switchRole(final int paramInt)
  {
    AppMethodBeat.i(15791);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15702);
        TRTCCloudImpl localTRTCCloudImpl = TRTCCloudImpl.this;
        if (paramInt == 20) {}
        for (String str = "Anchor";; str = "Audience")
        {
          localTRTCCloudImpl.apiOnlineLog(String.format("switchRole:%s", new Object[] { str }));
          TRTCCloudImpl.this.mTargetRole = paramInt;
          TRTCCloudImpl.access$1900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt);
          AppMethodBeat.o(15702);
          return;
        }
      }
    });
    AppMethodBeat.o(15791);
  }
  
  public void switchRoom(final TRTCCloudDef.TRTCSwitchRoomConfig paramTRTCSwitchRoomConfig)
  {
    AppMethodBeat.i(231081);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int j = 0;
        AppMethodBeat.i(15612);
        String str1 = String.format("switchRoom roomId:%d, strRoomId:%s", new Object[] { Integer.valueOf(paramTRTCSwitchRoomConfig.roomId), paramTRTCSwitchRoomConfig.strRoomId }) + " self:" + TRTCCloudImpl.this.hashCode();
        TRTCCloudImpl.this.apiOnlineLog(str1);
        if ((!TRTCCloudImpl.access$2000(TRTCCloudImpl.this, paramTRTCSwitchRoomConfig.roomId)) && (TextUtils.isEmpty(paramTRTCSwitchRoomConfig.strRoomId)))
        {
          TRTCCloudImpl.this.apiLog("Switch room failed with invalid room id");
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230796);
              if (TRTCCloudImpl.this.mTRTCListener != null) {
                TRTCCloudImpl.this.mTRTCListener.onSwitchRoom(-3301, "Invalid room id");
              }
              AppMethodBeat.o(230796);
            }
          });
          AppMethodBeat.o(15612);
          return;
        }
        if (((TRTCCloudImpl.access$2000(TRTCCloudImpl.this, paramTRTCSwitchRoomConfig.roomId)) && (paramTRTCSwitchRoomConfig.roomId == TRTCCloudImpl.this.mRoomInfo.roomId)) || ((!TRTCCloudImpl.access$2000(TRTCCloudImpl.this, paramTRTCSwitchRoomConfig.roomId)) && (paramTRTCSwitchRoomConfig.strRoomId == TRTCCloudImpl.this.mRoomInfo.strRoomId)))
        {
          TRTCCloudImpl.this.apiLog("Switch room to the same one");
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(230799);
              if (TRTCCloudImpl.this.mTRTCListener != null) {
                TRTCCloudImpl.this.mTRTCListener.onSwitchRoom(0, "Switch room to the same one");
              }
              AppMethodBeat.o(230799);
            }
          });
          AppMethodBeat.o(15612);
          return;
        }
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(230810);
            TRTCCloudImpl.this.stopRemoteRender(paramAnonymous2UserInfo);
            com.tencent.liteav.audio.a.a().a(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCCloudImpl.this.hashCode());
            if (paramAnonymous2UserInfo.mainRender.render != null) {
              paramAnonymous2UserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
            }
            if (paramAnonymous2UserInfo.subRender.render != null) {
              paramAnonymous2UserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
            }
            AppMethodBeat.o(230810);
          }
        });
        TRTCCloudImpl.this.mRoomInfo.clearUserList();
        str1 = "";
        String str2 = "";
        String str3 = "";
        int i;
        if (TRTCCloudImpl.access$2000(TRTCCloudImpl.this, paramTRTCSwitchRoomConfig.roomId))
        {
          i = paramTRTCSwitchRoomConfig.roomId;
          TRTCCloudImpl.this.mRoomInfo.roomId = paramTRTCSwitchRoomConfig.roomId;
          TRTCCloudImpl.this.mRoomInfo.strRoomId = "";
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramTRTCSwitchRoomConfig.userSig))
          {
            TRTCCloudImpl.this.mRoomInfo.userSig = paramTRTCSwitchRoomConfig.userSig;
            str2 = paramTRTCSwitchRoomConfig.userSig;
          }
          if (!TextUtils.isEmpty(paramTRTCSwitchRoomConfig.privateMapKey))
          {
            TRTCCloudImpl.this.mRoomInfo.privateMapKey = paramTRTCSwitchRoomConfig.privateMapKey;
            str3 = paramTRTCSwitchRoomConfig.privateMapKey;
          }
          TRTCCloudImpl.this.nativeSwitchRoom(TRTCCloudImpl.this.mNativeRtcContext, i, str1, str2, str3);
          AppMethodBeat.o(15612);
          return;
          i = j;
          if (!TextUtils.isEmpty(paramTRTCSwitchRoomConfig.strRoomId))
          {
            TRTCCloudImpl.this.mRoomInfo.strRoomId = paramTRTCSwitchRoomConfig.strRoomId;
            TRTCCloudImpl.this.mRoomInfo.roomId = -1L;
            str1 = paramTRTCSwitchRoomConfig.strRoomId;
            i = j;
          }
        }
      }
    });
    AppMethodBeat.o(231081);
  }
  
  public void updateAppScene(int paramInt)
  {
    AppMethodBeat.i(15954);
    this.mAppScene = paramInt;
    if ((this.mAppScene != 0) && (this.mAppScene != 1)) {
      this.mAppScene = 0;
    }
    if (this.mConfig.a * this.mConfig.b >= 518400) {
      this.mAppScene = 1;
    }
    updateEncType();
    apiLog(String.format("update appScene[%d] for video enc[%d] source scene[%d]", new Object[] { Integer.valueOf(this.mAppScene), Integer.valueOf(this.mConfig.k), Integer.valueOf(paramInt) }));
    AppMethodBeat.o(15954);
  }
  
  public void updatePrivateMapKey(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182316);
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[update private map key fail, params is null");
      AppMethodBeat.o(182316);
      return;
    }
    paramJSONObject = paramJSONObject.getString("privateMapKey");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      nativeUpdatePrivateMapKey(this.mNativeRtcContext, paramJSONObject);
      AppMethodBeat.o(182316);
      return;
    }
    apiLog("callExperimentalAPI[update private map key fail, key is empty");
    AppMethodBeat.o(182316);
  }
  
  static class DisplayOrientationDetector
    extends OrientationEventListener
  {
    public int mCurOrientation;
    private int mCurrentDisplayRotation;
    private WeakReference<TRTCCloudImpl> mTRTCEngine;
    
    DisplayOrientationDetector(Context paramContext, TRTCCloudImpl paramTRTCCloudImpl)
    {
      super();
      AppMethodBeat.i(15602);
      this.mCurOrientation = -1;
      this.mCurrentDisplayRotation = 0;
      this.mTRTCEngine = new WeakReference(paramTRTCCloudImpl);
      AppMethodBeat.o(15602);
    }
    
    public void checkOrientation()
    {
      AppMethodBeat.i(15604);
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mTRTCEngine.get();
      if (localTRTCCloudImpl != null)
      {
        int i = TRTCCloudImpl.access$11200(localTRTCCloudImpl);
        if (this.mCurrentDisplayRotation != i)
        {
          this.mCurrentDisplayRotation = i;
          TRTCCloudImpl.access$11300(localTRTCCloudImpl, this.mCurOrientation);
        }
      }
      AppMethodBeat.o(15604);
    }
    
    public void onOrientationChanged(int paramInt)
    {
      AppMethodBeat.i(15603);
      if (paramInt == -1)
      {
        TXCLog.i("DisplayOrientationDetector", "rotation-change invalid ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(15603);
        return;
      }
      int i;
      StringBuilder localStringBuilder;
      if (paramInt > 45) {
        if (paramInt <= 135)
        {
          i = 2;
          if (this.mCurOrientation != i)
          {
            this.mCurOrientation = i;
            localObject = (TRTCCloudImpl)this.mTRTCEngine.get();
            if (localObject != null)
            {
              this.mCurrentDisplayRotation = TRTCCloudImpl.access$11200((TRTCCloudImpl)localObject);
              TRTCCloudImpl.access$11300((TRTCCloudImpl)localObject, this.mCurOrientation);
            }
            localStringBuilder = new StringBuilder("rotation-change onOrientationChanged ").append(paramInt).append(", orientation ").append(this.mCurOrientation).append(" self:");
            if (localObject == null) {
              break label185;
            }
          }
        }
      }
      label185:
      for (Object localObject = Integer.valueOf(localObject.hashCode());; localObject = "")
      {
        TXCLog.d("DisplayOrientationDetector", localObject);
        AppMethodBeat.o(15603);
        return;
        if (paramInt <= 225)
        {
          i = 3;
          break;
        }
        if (paramInt <= 315)
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
    }
  }
  
  static class RenderListenerAdapter
  {
    public int bufferType;
    public TRTCCloudListener.TRTCVideoRenderListener listener;
    public int pixelFormat;
    public String strTinyID;
  }
  
  static class StatusTask
    implements Runnable
  {
    private WeakReference<TRTCCloudImpl> mTRTCEngine;
    
    StatusTask(TRTCCloudImpl paramTRTCCloudImpl)
    {
      AppMethodBeat.i(15727);
      this.mTRTCEngine = new WeakReference(paramTRTCCloudImpl);
      AppMethodBeat.o(15727);
    }
    
    public void run()
    {
      AppMethodBeat.i(15728);
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mTRTCEngine.get();
      if (localTRTCCloudImpl == null)
      {
        AppMethodBeat.o(15728);
        return;
      }
      int j = com.tencent.liteav.basic.util.h.e(localTRTCCloudImpl.mContext);
      int[] arrayOfInt = com.tencent.liteav.basic.util.h.a();
      int i = com.tencent.liteav.basic.util.h.b();
      TXCStatus.a("18446744073709551615", 11006, Integer.valueOf(j));
      TXCStatus.a("18446744073709551615", 11001, Integer.valueOf(arrayOfInt[0] / 10));
      TXCStatus.a("18446744073709551615", 11002, Integer.valueOf(arrayOfInt[1] / 10));
      TXCStatus.a("18446744073709551615", 11003, Integer.valueOf(i * 1024));
      long l;
      if (com.tencent.liteav.basic.util.h.a(localTRTCCloudImpl.mContext))
      {
        TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(1));
        i = 1;
        if (localTRTCCloudImpl.mNetType != j)
        {
          if ((localTRTCCloudImpl.mNetType >= 0) && (j > 0)) {
            TRTCCloudImpl.access$10500(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, 100);
          }
          if (j != 0) {
            break label400;
          }
          l = 0L;
          label181:
          TXCEventRecorderProxy.a("18446744073709551615", 1003, l, -1L, "", 0);
          Monitor.a(2, String.format("network switch from:%d to %d", new Object[] { Integer.valueOf(localTRTCCloudImpl.mNetType), Integer.valueOf(j) }) + " self:" + localTRTCCloudImpl.hashCode(), "1:wifi/2:4G/3:3G/4:2G/5:Cable/6:5G", 0);
          TRTCCloudImpl.access$10402(localTRTCCloudImpl, j);
          TXCKeyPointReportProxy.a(40039, j, 0);
        }
        if (localTRTCCloudImpl.mBackground != i)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 2001, i, -1L, "", 0);
          TRTCCloudImpl.access$10602(localTRTCCloudImpl, i);
          if (i != 0) {
            break label406;
          }
          localTRTCCloudImpl.apiOnlineLog("onAppDidBecomeActive");
        }
      }
      for (;;)
      {
        TXCKeyPointReportProxy.c(50001, i);
        TXCKeyPointReportProxy.a(arrayOfInt[0] / 10, arrayOfInt[1] / 10);
        TXCKeyPointReportProxy.a();
        TRTCCloudImpl.access$10700(localTRTCCloudImpl);
        localTRTCCloudImpl.checkDashBoard();
        TRTCCloudImpl.access$10800(localTRTCCloudImpl);
        localTRTCCloudImpl.startCollectStatus();
        if (localTRTCCloudImpl.mSensorMode != 0) {
          localTRTCCloudImpl.mOrientationEventListener.checkOrientation();
        }
        AppMethodBeat.o(15728);
        return;
        TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(0));
        i = 0;
        break;
        label400:
        l = j;
        break label181;
        label406:
        localTRTCCloudImpl.apiOnlineLog("onAppEnterBackground");
      }
    }
  }
  
  static enum VideoSourceType
  {
    static
    {
      AppMethodBeat.i(230868);
      NONE = new VideoSourceType("NONE", 0);
      CAMERA = new VideoSourceType("CAMERA", 1);
      SCREEN = new VideoSourceType("SCREEN", 2);
      CUSTOM = new VideoSourceType("CUSTOM", 3);
      $VALUES = new VideoSourceType[] { NONE, CAMERA, SCREEN, CUSTOM };
      AppMethodBeat.o(230868);
    }
    
    private VideoSourceType() {}
  }
  
  static class VolumeLevelNotifyTask
    implements Runnable
  {
    private WeakReference<TRTCCloudImpl> mWeakTRTCEngine;
    
    VolumeLevelNotifyTask(TRTCCloudImpl paramTRTCCloudImpl)
    {
      AppMethodBeat.i(15716);
      this.mWeakTRTCEngine = new WeakReference(paramTRTCCloudImpl);
      AppMethodBeat.o(15716);
    }
    
    public void run()
    {
      AppMethodBeat.i(15717);
      if (this.mWeakTRTCEngine != null) {}
      for (TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mWeakTRTCEngine.get();; localTRTCCloudImpl = null)
      {
        if (localTRTCCloudImpl != null)
        {
          final ArrayList localArrayList = new ArrayList();
          final int i = 0;
          if (localTRTCCloudImpl.mCaptureAndEnc != null) {
            i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
          }
          if (i > 0)
          {
            TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
            localTRTCVolumeInfo.userId = localTRTCCloudImpl.mRoomInfo.userId;
            localTRTCVolumeInfo.volume = i;
            localArrayList.add(localTRTCVolumeInfo);
          }
          localTRTCCloudImpl.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
            {
              AppMethodBeat.i(15693);
              int i = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(paramAnonymousUserInfo.tinyID));
              if (i > 0)
              {
                paramAnonymousString = new TRTCCloudDef.TRTCVolumeInfo();
                paramAnonymousString.userId = paramAnonymousUserInfo.userID;
                paramAnonymousString.volume = i;
                localArrayList.add(paramAnonymousString);
              }
              AppMethodBeat.o(15693);
            }
          });
          i = TXCAudioEngine.getMixingPlayoutVolumeLevel();
          localTRTCCloudImpl.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(15558);
              if (this.val$listener != null) {
                this.val$listener.onUserVoiceVolume(localArrayList, i);
              }
              AppMethodBeat.o(15558);
            }
          });
          if (localTRTCCloudImpl.mAudioVolumeEvalInterval > 0) {
            localTRTCCloudImpl.mSDKHandler.postDelayed(localTRTCCloudImpl.mVolumeLevelNotifyTask, localTRTCCloudImpl.mAudioVolumeEvalInterval);
          }
        }
        AppMethodBeat.o(15717);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl
 * JD-Core Version:    0.7.0.1
 */