package com.tencent.liteav.trtc.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
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
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d.a;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.liteav.h;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class TRTCCloudImpl
  extends TRTCCloud
  implements SurfaceHolder.Callback, TXCRenderAndDec.b, com.tencent.liteav.audio.b, com.tencent.liteav.audio.c, com.tencent.liteav.audio.d, com.tencent.liteav.audio.e, com.tencent.liteav.audio.f, com.tencent.liteav.basic.b.b, d.a, com.tencent.liteav.o, a.a
{
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
  private com.tencent.liteav.basic.b.a mCallback;
  public com.tencent.liteav.d mCaptureAndEnc;
  private long mCaptureFrameCount;
  private int mCodecType;
  protected g mConfig;
  public Context mContext;
  private int mCurrentOrientation;
  public HashMap<Integer, TRTCCloudImpl> mCurrentPublishClouds;
  public int mCurrentRole;
  private boolean mCustomRemoteRender;
  private TRTCCustomTextureUtil mCustomVideoUtil;
  protected int mDebugType;
  private Display mDisplay;
  private boolean mEnableCustomAudioCapture;
  protected boolean mEnableEosMode;
  private boolean mEnableSmallStream;
  private boolean mEnableSoftAEC;
  private boolean mEnableSoftAGC;
  private boolean mEnableSoftANS;
  private View mFloatingWindow;
  private int mFramework;
  private boolean mIsAudioCapturing;
  public boolean mIsExitOldRoom;
  private long mLastCaptureCalculateTS;
  private long mLastCaptureFrameCount;
  private long mLastLogCustomCmdMsgTs;
  private long mLastLogSEIMsgTs;
  private long mLastSendMsgTimeMs;
  public long mLastStateTimeMs;
  private final Bundle mLatestParamsOfBigEncoder;
  private final Bundle mLatestParamsOfSmallEncoder;
  private Handler mListenerHandler;
  private com.tencent.liteav.basic.util.e mMainHandler;
  public Object mNativeLock;
  public long mNativeRtcContext;
  private int mNetType;
  private DisplayOrientationDetector mOrientationEventListener;
  private boolean mOverrideFPSFromUser;
  public int mPerformanceMode;
  public int mPriorStreamType;
  private int mQosMode;
  private int mQosPreference;
  private long mRecvCustomCmdMsgCountInPeriod;
  public int mRecvMode;
  private long mRecvSEIMsgCountInPeriod;
  protected HashMap<String, RenderListenerAdapter> mRenderListenerMap;
  public TRTCRoomInfo mRoomInfo;
  public int mRoomState;
  public Handler mSDKHandler;
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
  public TRTCCloudListener mTRTCListener;
  public int mTargetRole;
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
    com.tencent.liteav.basic.util.f.f();
    AppMethodBeat.o(16059);
  }
  
  protected TRTCCloudImpl(Context paramContext)
  {
    AppMethodBeat.i(15781);
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
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
    this.mEnableCustomAudioCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mLastCaptureCalculateTS = 0L;
    this.mCaptureFrameCount = 0L;
    this.mLastCaptureFrameCount = 0L;
    this.mPerformanceMode = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mCallback = new com.tencent.liteav.basic.b.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222394);
        TXCLog.e("TRTCCloudImpl", "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
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
              break label166;
            }
          }
        }
        label166:
        for (paramAnonymousString1 = paramAnonymousString3;; paramAnonymousString1 = "")
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString1);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(3, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3, 0, 0);
          AppMethodBeat.o(222394);
          return;
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222393);
        TXCLog.i("TRTCCloudImpl", "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
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
              break label166;
            }
          }
        }
        label166:
        for (paramAnonymousString1 = paramAnonymousString3;; paramAnonymousString1 = "")
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString1);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(2, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3, 0, 0);
          AppMethodBeat.o(222393);
          return;
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
    String str = TXCAudioEngine.buildTRAEConfig(paramContext, Boolean.valueOf(localTRTCAudioServerConfig.enableOpenSL), localTRTCAudioServerConfig.isLowLatencySampleRateSupported, localTRTCAudioServerConfig.lowLatencySampleRateBlockTime);
    TXCAudioEngine.CreateInstanceWithoutInitDevice(this.mContext, str);
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.mCallback));
    TXCAudioEngine.getInstance().enableAutoRestartDevice(localTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(localTRTCAudioServerConfig.maxSelectedPlayStreams);
    TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(true);
    this.mCaptureAndEnc = new com.tencent.liteav.d(paramContext);
    this.mCaptureAndEnc.j(2);
    this.mCaptureAndEnc.a(this.mConfig);
    this.mCaptureAndEnc.i(true);
    this.mCaptureAndEnc.g(true);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.setID("18446744073709551615");
    this.mCaptureAndEnc.h(true);
    TXCKeyPointReportProxy.a(this.mContext);
    apiLog("reset audio volume");
    setAudioCaptureVolume(100);
    setAudioPlayoutVolume(100);
    TXCSoundEffectPlayer.getInstance().setSoundEffectListener(this);
    AppMethodBeat.o(15781);
  }
  
  protected TRTCCloudImpl(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(222451);
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
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
    this.mEnableCustomAudioCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mLastCaptureCalculateTS = 0L;
    this.mCaptureFrameCount = 0L;
    this.mLastCaptureFrameCount = 0L;
    this.mPerformanceMode = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mCallback = new com.tencent.liteav.basic.b.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222394);
        TXCLog.e("TRTCCloudImpl", "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
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
              break label166;
            }
          }
        }
        label166:
        for (paramAnonymousString1 = paramAnonymousString3;; paramAnonymousString1 = "")
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString1);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(3, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3, 0, 0);
          AppMethodBeat.o(222394);
          return;
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222393);
        TXCLog.i("TRTCCloudImpl", "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
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
              break label166;
            }
          }
        }
        label166:
        for (paramAnonymousString1 = paramAnonymousString3;; paramAnonymousString1 = "")
        {
          localBundle.putCharSequence("EVT_MSG", paramAnonymousString1);
          TRTCCloudImpl.this.onNotifyEvent(paramAnonymousInt, localBundle);
          Monitor.a(2, paramAnonymousInt, paramAnonymousString2, paramAnonymousString3, 0, 0);
          AppMethodBeat.o(222393);
          return;
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
    init(paramContext, paramHandler);
    this.mCurrentRole = 21;
    this.mTargetRole = 21;
    AppMethodBeat.o(222451);
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
    AppMethodBeat.i(222494);
    if (!this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.add(Integer.valueOf(paramInt));
    }
    addUpstream(paramInt);
    AppMethodBeat.o(222494);
  }
  
  private void addUpstream(int paramInt)
  {
    AppMethodBeat.i(222499);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeAddUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
    AppMethodBeat.o(222499);
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
          AppMethodBeat.i(222425);
          if (paramString1 != null) {
            paramString1.appendEventInfo(paramString2);
          }
          AppMethodBeat.o(222425);
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
    h localh = new h();
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
  
  private void applyRenderPlayStrategy(TXCRenderAndDec paramTXCRenderAndDec, h paramh)
  {
    AppMethodBeat.i(222492);
    paramh.g = true;
    if (this.mCurrentRole == 20)
    {
      paramh.a = com.tencent.liteav.basic.a.a.a;
      paramh.c = com.tencent.liteav.basic.a.a.b;
      paramh.b = com.tencent.liteav.basic.a.a.c;
    }
    for (;;)
    {
      paramTXCRenderAndDec.setConfig(paramh);
      AppMethodBeat.o(222492);
      return;
      if (this.mCurrentRole == 21)
      {
        paramh.a = com.tencent.liteav.basic.a.a.d;
        paramh.c = com.tencent.liteav.basic.a.a.e;
        paramh.b = com.tencent.liteav.basic.a.a.f;
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
    Object localObject = com.tencent.liteav.basic.util.f.a();
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
        AppMethodBeat.i(222419);
        if (paramAnonymousUserInfo.mainRender.render != null) {
          TRTCCloudImpl.access$8900(TRTCCloudImpl.this, paramAnonymousUserInfo.mainRender.render, paramAnonymousUserInfo, localTRTCStatistics, localArrayList);
        }
        if ((paramAnonymousUserInfo.subRender.render != null) && (paramAnonymousUserInfo.subRender.render.isRendering())) {
          TRTCCloudImpl.access$8900(TRTCCloudImpl.this, paramAnonymousUserInfo.subRender.render, paramAnonymousUserInfo, localTRTCStatistics, localArrayList);
        }
        AppMethodBeat.o(222419);
      }
    });
    localObject = new TRTCCloudDef.TRTCQuality();
    ((TRTCCloudDef.TRTCQuality)localObject).userId = this.mRoomInfo.getUserId();
    ((TRTCCloudDef.TRTCQuality)localObject).quality = TXCStatus.c("18446744073709551615", 12005);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222435);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null)
        {
          localTRTCCloudListener.onStatistics(localTRTCStatistics);
          localTRTCCloudListener.onNetworkQuality(this.val$localQuality, localArrayList);
        }
        AppMethodBeat.o(222435);
      }
    });
    AppMethodBeat.o(15982);
  }
  
  private void checkRenderRotation(int paramInt)
  {
    AppMethodBeat.i(15989);
    int k = getDisplayRotation();
    int j = (360 - k - (this.mConfig.l - 1) * 90) % 360;
    int i;
    if (((paramInt % 2 == k % 2) && (this.mConfig.l == 1)) || ((paramInt % 2 != k % 2) && (this.mConfig.l == 0)))
    {
      i = 1;
      if (this.mVideoRenderMirror != 1) {
        break label231;
      }
      if ((this.mConfig.m) || (i == 0)) {
        break label262;
      }
      i = j + 180;
    }
    label262:
    for (;;)
    {
      TXCLog.d("TRTCCloudImpl", String.format("vrotation rotation-change %d-%d-%d ======= renderRotation %d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.l), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.mRoomInfo.localRenderRotation) }) + " self:" + hashCode());
      paramInt = this.mRoomInfo.localRenderRotation;
      this.mCaptureAndEnc.g((i + paramInt) % 360);
      AppMethodBeat.o(15989);
      return;
      i = 0;
      break;
      label231:
      if ((this.mVideoRenderMirror == 2) && (this.mConfig.m) && (i != 0)) {
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
    if (this.mConfig.l != 1) {
      if (((this.mConfig.S) && (this.mConfig.m)) || ((!this.mConfig.S) && (!this.mConfig.m))) {
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
        TXCLog.d("TRTCCloudImpl", String.format("vrotation rotation-change %d-%d ======= encRotation %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.l), Integer.valueOf(i) }) + " self:" + hashCode());
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
        if (!this.mConfig.m) {
          j = (i + 180) % 360;
        }
        i = j;
        if (this.mConfig.S)
        {
          i = (j + 180) % 360;
          continue;
          i = (i + 180) % 360;
          continue;
          i = (i + 270) % 360;
          j = i;
          if (!this.mConfig.m) {
            j = (i + 180) % 360;
          }
          i = j;
          if (this.mConfig.S) {
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
    if (this.mVideoSourceType == VideoSourceType.CUSTOM)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.mLastCaptureCalculateTS;
      if (l2 >= 1000L)
      {
        double d = (this.mCaptureFrameCount - this.mLastCaptureFrameCount) * 1000.0D / l2;
        this.mLastCaptureFrameCount = this.mCaptureFrameCount;
        this.mLastCaptureCalculateTS = l1;
        TXCStatus.a("18446744073709551615", 1001, 2, Double.valueOf(d));
      }
    }
    AppMethodBeat.o(15975);
  }
  
  private static TRTCAudioServerConfig createAudioServerConfigFromNative()
  {
    AppMethodBeat.i(222487);
    TRTCAudioServerConfig localTRTCAudioServerConfig = new TRTCAudioServerConfig();
    AppMethodBeat.o(222487);
    return localTRTCAudioServerConfig;
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
    AppMethodBeat.i(222485);
    TRTCVideoServerConfig localTRTCVideoServerConfig = new TRTCVideoServerConfig();
    AppMethodBeat.o(222485);
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
  
  private void enableAudioAEC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15863);
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioAEC[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftAEC = false;
      if (!paramJSONObject.has("level")) {
        break label92;
      }
    }
    label92:
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
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioAGC[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftAGC = false;
      if (!paramJSONObject.has("level")) {
        break label92;
      }
    }
    label92:
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
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioANS[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0)
    {
      this.mEnableSoftANS = false;
      if (!paramJSONObject.has("level")) {
        break label92;
      }
    }
    label92:
    for (this.mSoftANSLevel = paramJSONObject.getInt("level");; this.mSoftANSLevel = 100)
    {
      TXCAudioEngine.getInstance().enableSoftANS(this.mEnableSoftANS, this.mSoftANSLevel);
      AppMethodBeat.o(15864);
      return;
      this.mEnableSoftANS = true;
      break;
    }
  }
  
  private void forceCallbackMixedPlayAudioFrame(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(222476);
    if (paramJSONObject == null)
    {
      apiLog("forceCallbackMixedPlayAudioFrame param is null");
      AppMethodBeat.o(222476);
      return;
    }
    if (!paramJSONObject.has("enable"))
    {
      apiLog("forceCallbackMixedPlayAudioFrame[lack parameter]: enable");
      AppMethodBeat.o(222476);
      return;
    }
    int i = paramJSONObject.optInt("enable", 0);
    paramJSONObject = TXCAudioEngine.getInstance();
    if (i != 0) {
      bool = true;
    }
    paramJSONObject.forceCallbackMixedPlayAudioFrame(bool);
    AppMethodBeat.o(222476);
  }
  
  private int getDisplayRotation()
  {
    int j = 0;
    AppMethodBeat.i(15987);
    int i = j;
    switch (this.mDisplay.getRotation())
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
    int[] arrayOfInt = com.tencent.liteav.basic.util.f.a();
    int i = paramTXCRenderAndDec.getStreamType();
    long l = TXCStatus.a(str, 17014, i);
    int j = TXCStatus.c(str, 5003, i);
    if (i == 3) {
      paramTXCRenderAndDec = "S";
    }
    for (;;)
    {
      paramTXCRenderAndDec = String.format("REMOTE: [%s]%s RTT:%dms\n", new Object[] { paramUserInfo.userID, paramTXCRenderAndDec, Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }) + String.format(Locale.CHINA, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17001, i) + TXCStatus.c(str, 18001)), Integer.valueOf(TXCStatus.c(str, 17010, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17011, i)), Integer.valueOf(TXCStatus.c(str, 18013)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18014)), Integer.valueOf(TXCStatus.c(str, 16002)) }) + String.format(Locale.CHINA, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17002, i)), Integer.valueOf(TXCStatus.c(str, 18002)), Integer.valueOf(j >> 16), Integer.valueOf(j & 0xFFFF), Integer.valueOf((int)TXCStatus.d(str, 6002, i)), Integer.valueOf((int)TXCStatus.d(str, 17003, i)) }) + String.format(Locale.CHINA, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17007, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17006, i)), Integer.valueOf(TXCStatus.c(str, 18009)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18008)), Integer.valueOf(TXCStatus.c(str, 17009, i)), Integer.valueOf(TXCStatus.c(str, 17008, i)), Integer.valueOf(TXCStatus.c(str, 18012)), Integer.valueOf(TXCStatus.c(str, 18010)) }) + String.format(Locale.CHINA, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", new Object[] { Integer.valueOf(arrayOfInt[0] / 10), Integer.valueOf(arrayOfInt[1] / 10), Integer.valueOf(TXCStatus.c(str, 17012, i)), Integer.valueOf(TXCStatus.c(str, 17013, i)), Long.valueOf(l) }) + String.format(Locale.CHINA, "Jitter: %d,%d|%d,%d|%d   ADROP: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 2007)), Integer.valueOf(TXCStatus.c(str, 6010, i)), Integer.valueOf(TXCStatus.c(str, 6011, i)), Integer.valueOf(TXCStatus.c(str, 6012, i)), Integer.valueOf(TXCStatus.c(str, 2021)), Integer.valueOf(TXCStatus.c(str, 18015)) }) + String.format(Locale.CHINA, "QUALITY: %d   LEN: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 18023)), Integer.valueOf(TXCStatus.c(str, 18016)) });
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
    AppMethodBeat.o(15980);
    return localTRTCLocalStatistics;
  }
  
  private com.tencent.liteav.basic.a.b getPixelFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return com.tencent.liteav.basic.a.b.a;
    case 1: 
      return com.tencent.liteav.basic.a.b.b;
    case 2: 
      return com.tencent.liteav.basic.a.b.c;
    case 3: 
      return com.tencent.liteav.basic.a.b.d;
    }
    return com.tencent.liteav.basic.a.b.e;
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
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      paramTXCRenderAndDec.finalLoss = i;
      paramTXCRenderAndDec.width = (m >> 16);
      paramTXCRenderAndDec.height = (0xFFFF & m);
      paramTXCRenderAndDec.frameRate = ((int)(TXCStatus.d(str, 6002, k) + 0.5D));
      paramTXCRenderAndDec.videoBitrate = TXCStatus.c(str, 17002, k);
      paramTXCRenderAndDec.audioSampleRate = TXCStatus.c(str, 18003);
      paramTXCRenderAndDec.audioBitrate = TXCStatus.c(str, 18002);
      paramTXCRenderAndDec.jitterBufferDelay = TXCStatus.c(str, 2007);
      paramTXCRenderAndDec.streamType = translateStreamType(k);
      AppMethodBeat.o(15979);
      return paramTXCRenderAndDec;
    }
  }
  
  private g.a getSizeByResolution(int paramInt1, int paramInt2)
  {
    int k = 640;
    int m = 368;
    AppMethodBeat.i(222493);
    int i = m;
    int j = k;
    g.a locala;
    switch (paramInt1)
    {
    default: 
      j = k;
      i = m;
    case 108: 
      locala = new g.a();
      if (paramInt2 == 1) {
        locala.a = i;
      }
      break;
    }
    for (locala.b = j;; locala.b = i)
    {
      AppMethodBeat.o(222493);
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
    AppMethodBeat.i(222461);
    if (this.mFloatingWindow == null)
    {
      AppMethodBeat.o(222461);
      return;
    }
    ((WindowManager)this.mFloatingWindow.getContext().getSystemService("window")).removeViewImmediate(this.mFloatingWindow);
    this.mFloatingWindow = null;
    AppMethodBeat.o(222461);
  }
  
  private void identifyTRTCFrameworkType()
  {
    AppMethodBeat.i(222454);
    for (;;)
    {
      int i;
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        i = 0;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        String str = arrayOfStackTraceElement[i].getClassName();
        if ((str.contains("TRTCMeetingImpl")) || (str.contains("TRTCLiveRoomImpl")) || (str.contains("TRTCAudioCallImpl")) || (str.contains("TRTCVideoCallImpl")) || (str.contains("TRTCVoiceRoomImpl")) || (str.contains("TRTCAVCallImpl")))
        {
          TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
          this.mFramework = 5;
          AppMethodBeat.o(222454);
          return;
        }
        if (str.contains("WXTRTCCloud"))
        {
          TXCLog.i("TRTCCloudImpl", "identifyTRTCFrameworkType callName:".concat(String.valueOf(str)));
          this.mFramework = 3;
          AppMethodBeat.o(222454);
          return;
        }
      }
      catch (Exception localException)
      {
        TXCLog.e("TRTCCloudImpl", "identifyTRTCFrameworkType catch exception:" + localException.getCause());
        AppMethodBeat.o(222454);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(222454);
  }
  
  private void init(Context paramContext, Handler arg2)
  {
    AppMethodBeat.i(222452);
    this.mCurrentPublishClouds.put(Integer.valueOf(2), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(3), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(7), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(1), this);
    this.mContext = paramContext.getApplicationContext();
    this.mConfig = new g();
    this.mConfig.k = com.tencent.liteav.basic.a.c.e;
    this.mConfig.X = 90;
    this.mConfig.j = 0;
    this.mConfig.P = true;
    this.mConfig.h = 15;
    this.mConfig.K = false;
    this.mConfig.T = false;
    this.mConfig.U = false;
    this.mConfig.a = 368;
    this.mConfig.b = 640;
    this.mConfig.c = 750;
    this.mConfig.e = 0;
    this.mConfig.W = false;
    this.mRoomInfo = new TRTCRoomInfo();
    this.mRoomInfo.bigEncSize.a = 368;
    this.mRoomInfo.bigEncSize.b = 640;
    this.mMainHandler = new com.tencent.liteav.basic.util.e(paramContext.getMainLooper());
    this.mListenerHandler = new Handler(paramContext.getMainLooper());
    if (??? != null) {
      this.mSDKHandler = ???;
    }
    for (;;)
    {
      this.mStatusNotifyTask = new StatusTask(this);
      this.mLastSendMsgTimeMs = 0L;
      this.mSendMsgCount = 0;
      this.mSendMsgSize = 0;
      this.mSensorMode = 2;
      this.mAppScene = 0;
      this.mQosPreference = 2;
      this.mQosMode = 1;
      this.mOrientationEventListener = new DisplayOrientationDetector(this.mContext, this);
      this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      this.mRenderListenerMap = new HashMap();
      this.mStreamTypes = new HashSet();
      synchronized (this.mNativeLock)
      {
        int[] arrayOfInt = TXCCommonUtil.getSDKVersion();
        int i;
        if (arrayOfInt.length > 0)
        {
          i = arrayOfInt[0];
          label395:
          if (arrayOfInt.length < 2) {
            break label568;
          }
        }
        label568:
        for (int j = arrayOfInt[1];; j = 0)
        {
          if (arrayOfInt.length < 3) {
            break label574;
          }
          k = arrayOfInt[2];
          this.mNativeRtcContext = nativeCreateContext(i, j, k);
          apiLog("trtc cloud create");
          this.mRoomState = 0;
          this.mVideoSourceType = VideoSourceType.NONE;
          this.mIsAudioCapturing = false;
          this.mCurrentRole = 20;
          this.mTargetRole = 20;
          this.mRecvMode = 1;
          this.mLatestParamsOfBigEncoder.putInt("config_gop", this.mConfig.i);
          this.mLatestParamsOfSmallEncoder.putInt("config_gop", this.mConfig.i);
          identifyTRTCFrameworkType();
          this.mVideoServerConfig = TRTCVideoServerConfig.loadFromSharedPreferences(paramContext);
          AppMethodBeat.o(222452);
          return;
          ??? = new HandlerThread("TRTCCloudApi");
          ???.start();
          this.mSDKHandler = new Handler(???.getLooper());
          break;
          i = 0;
          break label395;
        }
        label574:
        int k = 0;
      }
    }
  }
  
  private void muteUpstream(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(222498);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeMuteUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt, paramBoolean);
    }
    AppMethodBeat.o(222498);
  }
  
  private native int nativeCancelDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeChangeRole(long paramLong, int paramInt);
  
  private native int nativeConnectOtherRoom(long paramLong, String paramString);
  
  private native int nativeDisconnectOtherRoom(long paramLong);
  
  private native void nativeEnableBlackStream(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableSmallStream(long paramLong, boolean paramBoolean);
  
  private native void nativeMuteUpstream(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativePushVideo(long paramLong1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
  
  private native void nativeReenterRoom(long paramLong, int paramInt);
  
  private native int nativeRemoveUpstream(long paramLong, int paramInt);
  
  private native int nativeRequestDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeRequestKeyFrame(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSendCustomCmdMsg(long paramLong, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeSendJsonCmd(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSendSEIMsg(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeSetAudioEncodeConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSetDataReportDeviceInfo(String paramString1, String paramString2, int paramInt);
  
  private native boolean nativeSetSEIPayloadType(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncoderConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7);
  
  private native void nativeSetVideoQuality(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeStartPublishCDNStream(long paramLong, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam);
  
  private native void nativeStartPublishing(long paramLong, String paramString, int paramInt);
  
  private native void nativeStartSpeedTest(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeStopPublishCDNStream(long paramLong);
  
  private native void nativeStopPublishing(long paramLong);
  
  private native void nativeStopSpeedTest(long paramLong);
  
  private native void nativeUpdatePrivateMapKey(long paramLong, String paramString);
  
  private void notifyCaptureStarted(final String paramString)
  {
    AppMethodBeat.i(222506);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222433);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener == null)
        {
          AppMethodBeat.o(222433);
          return;
        }
        localTRTCCloudListener.onWarning(4000, paramString, null);
        AppMethodBeat.o(222433);
      }
    });
    apiLog(paramString);
    AppMethodBeat.o(222506);
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
        AppMethodBeat.i(222442);
        if (paramString.equalsIgnoreCase(String.valueOf(paramAnonymousUserInfo.tinyID))) {
          TRTCCloudImpl.this.notifyEvent(paramAnonymousUserInfo.userID, paramInt, paramBundle);
        }
        AppMethodBeat.o(222442);
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
        AppMethodBeat.i(170215);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberChange when out room");
          AppMethodBeat.o(170215);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(170215);
          return;
        }
        TRTCCloudImpl.this.apiLog("onAVMemberChange " + paramLong + ", " + paramInt3 + ", old state:" + paramInt2 + ", new state:" + this.val$streamState);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramInt3);
        if (localUserInfo != null)
        {
          localUserInfo.streamState = this.val$streamState;
          TRTCCloudImpl.this.checkUserState(paramInt3, paramLong, this.val$streamState, paramInt2);
        }
        AppMethodBeat.o(170215);
      }
    });
    AppMethodBeat.o(15924);
  }
  
  private void onCallExperimentalAPI(int paramInt, String paramString)
  {
    AppMethodBeat.i(15919);
    apiLog("onCallExperimentalAPI " + paramInt + ", " + paramString);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15763);
        AppMethodBeat.o(15763);
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
        AppMethodBeat.i(222439);
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
              AppMethodBeat.i(222392);
              if (paramAnonymous2UserInfo.mainRender.render != null) {
                TRTCCloudImpl.access$8000(TRTCCloudImpl.this, paramAnonymous2UserInfo.mainRender.render, paramAnonymous2UserInfo.mainRender.render.getConfig());
              }
              AppMethodBeat.o(222392);
            }
          });
          TRTCCloudImpl.access$7300(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onChangeRole:" + paramInt);
          Monitor.a(1, String.format("onChangeRole err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          AppMethodBeat.o(222439);
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
    apiLog("onConnectOtherRoom " + paramString1 + ", " + paramInt + ", " + paramString2);
    Monitor.a(1, String.format("onConnectOtherRoom userId:%s err:%d, msg:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 }) + " self:" + hashCode(), "", 0);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15635);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onConnectOtherRoom(paramString1, paramInt, paramString2);
        }
        AppMethodBeat.o(15635);
      }
    });
    AppMethodBeat.o(15917);
  }
  
  private void onConnectionLost()
  {
    AppMethodBeat.i(15932);
    this.mRoomInfo.networkStatus = 1;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Network anomaly.");
    Monitor.a(1, "onConnectionLost self:" + hashCode(), "", 0);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15722);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onConnectionLost();
        }
        AppMethodBeat.o(15722);
      }
    });
    AppMethodBeat.o(15932);
  }
  
  private void onConnectionRecovery()
  {
    AppMethodBeat.i(15934);
    this.mRoomInfo.networkStatus = 3;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Network recovered. Successfully re-enter room");
    Monitor.a(1, "onConnectionRecovery self:" + hashCode(), "", 0);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182303);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onConnectionRecovery();
        }
        AppMethodBeat.o(182303);
      }
    });
    AppMethodBeat.o(15934);
  }
  
  private void onDisConnectOtherRoom(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15918);
    apiLog("onDisConnectOtherRoom " + paramInt + ", " + paramString);
    Monitor.a(1, String.format("onDisConnectOtherRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + hashCode(), "", 0);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15673);
        if (TRTCCloudImpl.this.mTRTCListener != null) {
          TRTCCloudImpl.this.mTRTCListener.onDisConnectOtherRoom(paramInt, paramString);
        }
        AppMethodBeat.o(15673);
      }
    });
    AppMethodBeat.o(15918);
  }
  
  private void onExitRoom(final int paramInt, String paramString)
  {
    AppMethodBeat.i(15915);
    apiLog("onExitRoom " + paramInt + ", " + paramString);
    Monitor.a(1, String.format("onExitRoom err:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + hashCode(), "", 0);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15605);
        if (TRTCCloudImpl.this.mIsExitOldRoom)
        {
          TRTCCloudImpl.this.mIsExitOldRoom = false;
          TRTCCloudImpl.this.apiLog("exit no current room, ignore onExitRoom.");
          AppMethodBeat.o(15605);
          return;
        }
        if (TRTCCloudImpl.this.mRoomInfo.isMicStard())
        {
          TRTCCloudImpl.this.mRoomInfo.setRoomExit(true, paramInt);
          TRTCCloudImpl.this.apiLog("onExitRoom delay 2s when mic is not release.");
          TRTCCloudImpl.access$7400(TRTCCloudImpl.this, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(15686);
              if (TRTCCloudImpl.this.mRoomInfo.isRoomExit())
              {
                TRTCCloudImpl.this.apiLog("force onExitRoom after 2s");
                final int i = TRTCCloudImpl.this.mRoomInfo.getRoomExitCode();
                TRTCCloudImpl.this.mRoomInfo.setRoomExit(false, 0);
                TRTCCloudImpl.this.runOnListenerThread(new Runnable()
                {
                  public void run()
                  {
                    AppMethodBeat.i(222422);
                    TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                    if (localTRTCCloudListener != null) {
                      localTRTCCloudListener.onExitRoom(i);
                    }
                    AppMethodBeat.o(222422);
                  }
                });
              }
              AppMethodBeat.o(15686);
            }
          }, 2000);
          AppMethodBeat.o(15605);
          return;
        }
        TRTCCloudImpl.this.runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222438);
            TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
            if (localTRTCCloudListener != null) {
              localTRTCCloudListener.onExitRoom(TRTCCloudImpl.127.this.val$err);
            }
            AppMethodBeat.o(222438);
          }
        });
        AppMethodBeat.o(15605);
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
        AppMethodBeat.i(15759);
        TRTCCloudImpl.this.exitRoomInternal(false, "onKickOut " + paramString);
        TRTCCloudImpl.access$7500(TRTCCloudImpl.this, paramInt, paramString);
        AppMethodBeat.o(15759);
      }
    });
    AppMethodBeat.o(15916);
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
    AppMethodBeat.i(222488);
    TXCLog.i("TRTCCloudImpl", "on receive audio config: [%s]", new Object[] { paramTRTCAudioServerConfig });
    TRTCAudioServerConfig.saveToSharedPreferences(this.mContext, paramTRTCAudioServerConfig);
    TXCAudioEngine.getInstance().enableAutoRestartDevice(paramTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(paramTRTCAudioServerConfig.maxSelectedPlayStreams);
    AppMethodBeat.o(222488);
  }
  
  private void onRecvCustomCmdMsg(final String paramString1, long paramLong1, final int paramInt1, final int paramInt2, final String paramString2, final boolean paramBoolean, final int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(15936);
    long l = System.currentTimeMillis();
    this.mRecvCustomCmdMsgCountInPeriod += 1L;
    if (l - this.mLastLogCustomCmdMsgTs > 10000L)
    {
      TXCLog.i("TRTCCloudImpl", "onRecvMsg. tinyId=" + paramLong1 + ", streamId = " + paramInt1 + ", msg = " + paramString2 + ", recvTime = " + paramLong2 + ", recvCustomMsgCountInPeriod = " + this.mRecvCustomCmdMsgCountInPeriod + " self:" + hashCode());
      this.mLastLogCustomCmdMsgTs = l;
      this.mRecvCustomCmdMsgCountInPeriod = 0L;
    }
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15675);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {}
        try
        {
          localTRTCCloudListener.onRecvCustomCmdMsg(paramString1, paramInt1, paramInt2, paramString2.getBytes("UTF-8"));
          if ((paramBoolean) && (paramInt3 > 0)) {
            localTRTCCloudListener.onMissCustomCmdMsg(paramString1, paramInt1, -1, paramInt3);
          }
          AppMethodBeat.o(15675);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            TXCLog.e("TRTCCloudImpl", "onRecvCustomCmdMsg failed.", localUnsupportedEncodingException);
          }
        }
      }
    });
    AppMethodBeat.o(15936);
  }
  
  private void onRecvFirstAudio(long paramLong)
  {
    AppMethodBeat.i(15940);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182415);
        AppMethodBeat.o(182415);
      }
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
        AppMethodBeat.i(182399);
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
              AppMethodBeat.i(222410);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              TXCLog.i("TRTCCloudImpl", "notify onUserVideoAvailable:" + TRTCCloudImpl.151.this.val$tinyId + " [true] by IDR. self:" + TRTCCloudImpl.this.hashCode());
              if (localTRTCCloudListener != null)
              {
                localTRTCCloudListener.onUserVideoAvailable(str2, true);
                TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { str2, Boolean.TRUE }));
              }
              AppMethodBeat.o(222410);
            }
          });
          label173:
          AppMethodBeat.o(182399);
        }
        TRTCCloudImpl.this.apiLog("onRecvFirstVideo " + paramLong + ", " + i);
        if ((localObject == null) || (i > 1))
        {
          AppMethodBeat.o(182399);
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
        AppMethodBeat.i(15654);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          try
          {
            String str = TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(paramLong);
            if (str != null)
            {
              long l = System.currentTimeMillis();
              TRTCCloudImpl.access$7808(TRTCCloudImpl.this);
              if (l - TRTCCloudImpl.this.mLastLogSEIMsgTs > 10000L)
              {
                TXCLog.i("TRTCCloudImpl", "onRecvSEIMsg. userId=" + str + ", message = " + new String(this.val$message) + ", recvSEIMsgCountInPeriod = " + TRTCCloudImpl.this.mRecvSEIMsgCountInPeriod + " self:" + TRTCCloudImpl.this.hashCode());
                TRTCCloudImpl.access$7902(TRTCCloudImpl.this, l);
                TRTCCloudImpl.access$7802(TRTCCloudImpl.this, 0L);
              }
              localTRTCCloudListener.onRecvSEIMsg(str, this.val$message);
              AppMethodBeat.o(15654);
              return;
            }
            TXCLog.i("TRTCCloudImpl", "onRecvSEIMsg Error, user id is null for tinyId=" + paramLong + " self:" + TRTCCloudImpl.this.hashCode());
            AppMethodBeat.o(15654);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e("TRTCCloudImpl", "onRecvSEIMsg failed.", localException);
          }
        }
        AppMethodBeat.o(15654);
      }
    });
    AppMethodBeat.o(15937);
  }
  
  private void onRecvVideoServerConfig(final TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    AppMethodBeat.i(222486);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222403);
        TRTCCloudImpl.this.apiLog("onRecvVideoServerConfig " + paramTRTCVideoServerConfig);
        TRTCCloudImpl.access$8202(TRTCCloudImpl.this, paramTRTCVideoServerConfig);
        TRTCVideoServerConfig.saveToSharedPreferences(TRTCCloudImpl.this.mContext, paramTRTCVideoServerConfig);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(222584);
            paramAnonymous2String = paramAnonymous2UserInfo.mainRender.render;
            if (paramAnonymous2String != null) {
              paramAnonymous2String.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
            }
            paramAnonymous2String = paramAnonymous2UserInfo.subRender.render;
            if (paramAnonymous2String != null) {
              paramAnonymous2String.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
            }
            AppMethodBeat.o(222584);
          }
        });
        AppMethodBeat.o(222403);
      }
    });
    AppMethodBeat.o(222486);
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
          AppMethodBeat.i(15720);
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          if (localTRTCCloudListener != null) {
            localTRTCCloudListener.onError(paramInt1, paramString, null);
          }
          AppMethodBeat.o(15720);
        }
      });
      AppMethodBeat.o(15920);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15676);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(170197);
            if ((TRTCCloudImpl.133.this.val$stream != 1) && (TRTCCloudImpl.133.this.val$tinyID == paramAnonymous2UserInfo.tinyID))
            {
              TRTCCloudImpl.this.apiLog("onRequestDownStream " + paramAnonymous2UserInfo.tinyID + ", " + paramAnonymous2UserInfo.userID + ", " + TRTCCloudImpl.133.this.val$stream);
              if (TRTCCloudImpl.133.this.val$stream == 7)
              {
                if ((paramAnonymous2UserInfo.subRender.render != null) && (paramAnonymous2UserInfo.subRender.render.getStreamType() != TRTCCloudImpl.133.this.val$stream))
                {
                  paramAnonymous2UserInfo.subRender.render.stopVideo();
                  paramAnonymous2UserInfo.subRender.render.setStreamType(TRTCCloudImpl.133.this.val$stream);
                  paramAnonymous2UserInfo.subRender.render.startVideo();
                  AppMethodBeat.o(170197);
                }
              }
              else if ((paramAnonymous2UserInfo.mainRender.render != null) && (paramAnonymous2UserInfo.mainRender.render.getStreamType() != TRTCCloudImpl.133.this.val$stream))
              {
                paramAnonymous2UserInfo.mainRender.render.stopVideo();
                paramAnonymous2UserInfo.mainRender.render.setStreamType(TRTCCloudImpl.133.this.val$stream);
                paramAnonymous2UserInfo.mainRender.render.startVideo();
                TXCKeyPointReportProxy.a(String.valueOf(paramAnonymous2UserInfo.tinyID), 40038, 0L, TRTCCloudImpl.133.this.val$stream);
              }
            }
            AppMethodBeat.o(170197);
          }
        });
        AppMethodBeat.o(15676);
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
        AppMethodBeat.i(15619);
        TRTCCloudImpl.this.mRoomInfo.setTinyId(String.valueOf(paramLong));
        TRTCCloudImpl.this.mRoomInfo.setToken(TRTCCloudImpl.this.mContext, this.val$token);
        AppMethodBeat.o(15619);
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
        AppMethodBeat.i(170195);
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
            break label154;
          }
        }
        label154:
        for (localTRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(paramInt1, (int)(paramFloat1 * 100.0F));; localTRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(paramInt1, (int)(paramFloat2 * 100.0F)))
        {
          localTRTCCloudListener.onSpeedTest(localTRTCSpeedTestResult, paramInt2, paramInt3);
          TRTCCloudImpl.this.apiLog(String.format("SpeedTest progress %d/%d, result: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localTRTCSpeedTestResult.toString() }));
          AppMethodBeat.o(170195);
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
        AppMethodBeat.i(182291);
        TRTCCloudImpl.this.apiLog("onStartPublishing " + paramInt + ", " + paramString);
        Monitor.a(1, String.format("onStartPublishing err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStartPublishing(paramInt, paramString);
        }
        AppMethodBeat.o(182291);
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
        AppMethodBeat.i(182390);
        TRTCCloudImpl.this.apiLog("onStopPublishing " + paramInt + ", " + paramString);
        Monitor.a(1, String.format("onStopPublishing err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStopPublishing(paramInt, paramString);
        }
        AppMethodBeat.o(182390);
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
        AppMethodBeat.i(222400);
        TRTCCloudImpl.this.apiLog("onStreamPublished " + paramInt + ", " + paramString);
        Monitor.a(1, String.format("onStreamPublished err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStartPublishCDNStream(paramInt, paramString);
        }
        AppMethodBeat.o(222400);
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
        AppMethodBeat.i(222570);
        TRTCCloudImpl.this.apiLog("onStreamUnpublished " + paramInt + ", " + paramString);
        Monitor.a(1, String.format("onStreamUnpublished err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onStopPublishCDNStream(paramInt, paramString);
        }
        AppMethodBeat.o(222570);
      }
    });
    AppMethodBeat.o(15943);
  }
  
  private void onTranscodingUpdated(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15944);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182407);
        TRTCCloudImpl.this.apiLog("onTranscodingUpdated " + paramInt + ", " + paramString);
        Monitor.a(1, String.format("onTranscodingUpdated err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSetMixTranscodingConfig(paramInt, paramString);
        }
        AppMethodBeat.o(182407);
      }
    });
    AppMethodBeat.o(15944);
  }
  
  private void onTryToReconnect()
  {
    AppMethodBeat.i(15933);
    this.mRoomInfo.networkStatus = 2;
    notifyEvent(this.mRoomInfo.getUserId(), 0, "Retry enter room.");
    Monitor.a(1, "onTryToReconnect self:" + hashCode(), "", 0);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(170201);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onTryToReconnect();
        }
        AppMethodBeat.o(170201);
      }
    });
    AppMethodBeat.o(15933);
  }
  
  private void onVideoBlockThresholdChanged(final int paramInt)
  {
    AppMethodBeat.i(222483);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15569);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(182307);
            if (paramAnonymous2UserInfo.mainRender.render != null) {
              paramAnonymous2UserInfo.mainRender.render.setBlockInterval(TRTCCloudImpl.142.this.val$videoBlockThreshold);
            }
            if (paramAnonymous2UserInfo.subRender.render != null) {
              paramAnonymous2UserInfo.subRender.render.setBlockInterval(TRTCCloudImpl.142.this.val$videoBlockThreshold);
            }
            AppMethodBeat.o(182307);
          }
        });
        AppMethodBeat.o(15569);
      }
    });
    AppMethodBeat.o(222483);
  }
  
  private void onWholeMemberEnter(long paramLong, final String paramString)
  {
    AppMethodBeat.i(15925);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15618);
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(15618);
          return;
        }
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onRemoteUserEnterRoom(paramString);
        }
        AppMethodBeat.o(15618);
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
        AppMethodBeat.i(15692);
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(15692);
          return;
        }
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onRemoteUserLeaveRoom(paramString, paramInt);
        }
        AppMethodBeat.o(15692);
      }
    });
    AppMethodBeat.o(15926);
  }
  
  private void pushVideoFrame(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(222504);
    synchronized (this.mCurrentPublishClouds)
    {
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramTXSNALPacket.streamType));
      if (localTRTCCloudImpl != null) {
        nativePushVideo(localTRTCCloudImpl.getNetworkContext(), paramTXSNALPacket.streamType, 1, paramTXSNALPacket.nalType, paramTXSNALPacket.nalData, paramTXSNALPacket.gopIndex, paramTXSNALPacket.gopFrameIndex, paramTXSNALPacket.refFremeIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
      }
      AppMethodBeat.o(222504);
      return;
    }
  }
  
  private void removeUpStreamType(int paramInt)
  {
    AppMethodBeat.i(222495);
    if (this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.remove(Integer.valueOf(paramInt));
    }
    removeUpstream(paramInt);
    AppMethodBeat.o(222495);
  }
  
  private void removeUpstream(int paramInt)
  {
    AppMethodBeat.i(222500);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeRemoveUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
    AppMethodBeat.o(222500);
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
    AppMethodBeat.i(222490);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mMainHandler.a(paramRunnable);
      AppMethodBeat.o(222490);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(222490);
  }
  
  private void runOnSDKThread(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(15952);
    if (this.mSDKHandler != null) {
      this.mSDKHandler.postDelayed(paramRunnable, paramInt);
    }
    AppMethodBeat.o(15952);
  }
  
  private void setAudioEncodeConfiguration()
  {
    AppMethodBeat.i(222501);
    setQoSParams();
    AppMethodBeat.o(222501);
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
  
  private void setFramework(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222475);
    if (paramJSONObject == null)
    {
      apiLog("setFramework[lack parameter]");
      AppMethodBeat.o(222475);
      return;
    }
    if (!paramJSONObject.has("framework"))
    {
      apiLog("setFramework[lack parameter]: framework");
      AppMethodBeat.o(222475);
      return;
    }
    this.mFramework = paramJSONObject.getInt("framework");
    AppMethodBeat.o(222475);
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
      this.mConfig.Y = ((JSONArray)localObject1);
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
        AppMethodBeat.i(222404);
        TRTCCloudImpl.access$9000(TRTCCloudImpl.this, paramInt);
        if (TRTCCloudImpl.this.mSensorMode != 0) {
          TRTCCloudImpl.access$9100(TRTCCloudImpl.this, paramInt);
        }
        AppMethodBeat.o(222404);
      }
    });
    AppMethodBeat.o(15991);
  }
  
  private void setQoSParams()
  {
    AppMethodBeat.i(222489);
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngine.getInstance().getAudioEncoderConfig();
    TXCLog.i("", "setQoSParams:" + localTXCAudioEncoderConfig.sampleRate + " " + localTXCAudioEncoderConfig.channels + " " + localTXCAudioEncoderConfig.minBitrate + " " + localTXCAudioEncoderConfig.maxBitrate);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(1));
    if (localTRTCCloudImpl != null) {
      nativeSetAudioEncodeConfiguration(localTRTCCloudImpl.getNetworkContext(), localTXCAudioEncoderConfig.minBitrate, localTXCAudioEncoderConfig.maxBitrate, localTXCAudioEncoderConfig.sampleRate, localTXCAudioEncoderConfig.channels);
    }
    AppMethodBeat.o(222489);
  }
  
  private void setVideoEncConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6)
  {
    AppMethodBeat.i(222491);
    if (this.mRoomState == 0)
    {
      apiLog("setVideoEncConfig ignore when no in room");
      AppMethodBeat.o(222491);
      return;
    }
    if (this.mCodecType != 2)
    {
      setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1, paramBoolean, paramInt6);
      AppMethodBeat.o(222491);
      return;
    }
    setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.mAppScene, paramBoolean, paramInt6);
    AppMethodBeat.o(222491);
  }
  
  private void setVideoEncoderConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    AppMethodBeat.i(222496);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt1));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoEncoderConfiguration(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, paramInt7);
    }
    AppMethodBeat.o(222496);
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
          g localg = this.mConfig;
          if (localJSONObject.optInt("enableRealTime") == 0) {
            break label467;
          }
          bool1 = true;
          localg.P = bool1;
          this.mConfig.n = localJSONObject.optInt("profile");
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
        break label479;
      }
      this.mLatestParamsOfBigEncoder.putInt("config_fps", n);
      if (i > j) {
        break label473;
      }
      bool1 = bool2;
      label344:
      updateBigStreamEncoder(bool1, i, j, n, i1, this.mConfig.p, i2);
      this.mCaptureAndEnc.n(i3);
    }
    for (;;)
    {
      apiLog("vsize setVideoEncoderParamEx->width:" + this.mRoomInfo.bigEncSize.a + ", height:" + this.mRoomInfo.bigEncSize.b + ", fps:" + n + ", bitrate:" + i1 + ", stream:" + k);
      updateOrientation();
      AppMethodBeat.o(15859);
      return;
      label467:
      bool1 = false;
      break;
      label473:
      bool1 = false;
      break label344;
      label479:
      if (k == 1)
      {
        this.mLatestParamsOfSmallEncoder.putInt("config_fps", n);
        updateSmallStreamEncoder(i, j, n, i1, i2);
      }
    }
  }
  
  private void setVideoEncoderParamInternal(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    AppMethodBeat.i(222466);
    if (paramTRTCVideoEncParam != null)
    {
      this.mLatestParamsOfBigEncoder.putInt("config_fps", paramTRTCVideoEncParam.videoFps);
      this.mLatestParamsOfBigEncoder.putBoolean("config_adjust_resolution", paramTRTCVideoEncParam.enableAdjustRes);
      g.a locala = getSizeByResolution(paramTRTCVideoEncParam.videoResolution, paramTRTCVideoEncParam.videoResolutionMode);
      if (paramTRTCVideoEncParam.videoResolutionMode == 1) {}
      for (boolean bool = true;; bool = false)
      {
        updateBigStreamEncoder(bool, locala.a, locala.b, paramTRTCVideoEncParam.videoFps, paramTRTCVideoEncParam.videoBitrate, paramTRTCVideoEncParam.enableAdjustRes, paramTRTCVideoEncParam.minVideoBitrate);
        apiLog("vsize setVideoEncoderParam->width:" + this.mRoomInfo.bigEncSize.a + ", height:" + this.mRoomInfo.bigEncSize.b + ", fps:" + paramTRTCVideoEncParam.videoFps + ", bitrate:" + paramTRTCVideoEncParam.videoBitrate + ", mode:" + paramTRTCVideoEncParam.videoResolutionMode + " minVideoBitrate:" + paramTRTCVideoEncParam.minVideoBitrate);
        Monitor.a(1, String.format("setVideoEncoderParam width:%d, height:%d, fps:%d, bitrate:%d, mode:%d, minBitrate:%d", new Object[] { Integer.valueOf(this.mRoomInfo.bigEncSize.a), Integer.valueOf(this.mRoomInfo.bigEncSize.b), Integer.valueOf(paramTRTCVideoEncParam.videoFps), Integer.valueOf(paramTRTCVideoEncParam.videoBitrate), Integer.valueOf(paramTRTCVideoEncParam.videoResolutionMode), Integer.valueOf(paramTRTCVideoEncParam.minVideoBitrate) }) + " self:" + hashCode(), "", 0);
        updateOrientation();
        TXCEventRecorderProxy.a("18446744073709551615", 4007, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, "", 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4008, paramTRTCVideoEncParam.videoFps, -1L, "", 2);
        TXCEventRecorderProxy.a("18446744073709551615", 4009, paramTRTCVideoEncParam.videoBitrate, -1L, "", 2);
        AppMethodBeat.o(222466);
        return;
      }
    }
    apiLog("setVideoEncoderParam param is null");
    AppMethodBeat.o(222466);
  }
  
  private void setVideoQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222497);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoQuality(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2);
    }
    AppMethodBeat.o(222497);
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
    AppMethodBeat.i(222459);
    if (paramView == null)
    {
      AppMethodBeat.o(222459);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(paramView.getContext())))
    {
      TXCLog.e("TRTCCloudImpl", "can't show floating window for no drawing overlay permission");
      AppMethodBeat.o(222459);
      return;
    }
    this.mFloatingWindow = paramView;
    WindowManager localWindowManager = (WindowManager)paramView.getContext().getSystemService("window");
    int i = 2005;
    if (Build.VERSION.SDK_INT >= 26) {
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
      AppMethodBeat.o(222459);
      return;
      if (Build.VERSION.SDK_INT > 24) {
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
  
  private void updateBigStreamEncoder(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    AppMethodBeat.i(222473);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.bigEncSize.a = paramInt1;
      this.mRoomInfo.bigEncSize.b = paramInt2;
      if (this.mVideoSourceType == VideoSourceType.SCREEN)
      {
        this.mConfig.l = 1;
        this.mConfig.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
        this.mConfig.k = com.tencent.liteav.basic.a.c.a;
      }
    }
    else
    {
      if (paramInt3 > 0)
      {
        if (paramInt3 <= 30) {
          break label412;
        }
        apiLog("setVideoEncoderParam fps > 30, limit fps to 30");
        this.mConfig.h = 30;
      }
      label126:
      if (paramInt4 > 0) {
        this.mConfig.c = paramInt4;
      }
      if (paramInt5 >= 0) {
        this.mConfig.e = paramInt5;
      }
      if (this.mVideoSourceType != VideoSourceType.SCREEN) {
        break label424;
      }
      this.mConfig.i = 3;
      this.mConfig.p = false;
      if (this.mOverrideFPSFromUser) {
        this.mConfig.h = 10;
      }
    }
    for (;;)
    {
      setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.h, this.mConfig.c, this.mConfig.p, this.mConfig.e);
      if ((this.mCodecType == 2) && (this.mConfig.a * this.mConfig.b >= 518400)) {
        this.mConfig.j = 1;
      }
      this.mCaptureAndEnc.e(this.mConfig.h);
      this.mCaptureAndEnc.a(this.mConfig);
      AppMethodBeat.o(222473);
      return;
      if (paramBoolean1)
      {
        this.mConfig.l = 1;
        this.mConfig.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
        break;
      }
      this.mConfig.l = 0;
      this.mConfig.a = this.mRoomInfo.bigEncSize.b;
      this.mConfig.b = this.mRoomInfo.bigEncSize.a;
      break;
      label412:
      this.mConfig.h = paramInt3;
      break label126;
      label424:
      this.mConfig.p = paramBoolean2;
    }
  }
  
  private void updateEncType()
  {
    if ((this.mCodecType == 0) || (this.mCodecType == 1)) {
      this.mConfig.j = this.mCodecType;
    }
    while (this.mAppScene != 1) {
      return;
    }
    this.mConfig.j = 1;
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
      if (this.mDisplay.getRotation() != 1) {
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
    AppMethodBeat.i(222474);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.smallEncSize.a = paramInt1;
      this.mRoomInfo.smallEncSize.b = paramInt2;
    }
    if (paramInt3 > 0)
    {
      if (paramInt3 <= 20) {
        break label241;
      }
      apiLog("setVideoSmallEncoderParam fps > 20, limit fps to 20");
    }
    label241:
    for (this.mSmallEncParam.videoFps = 20;; this.mSmallEncParam.videoFps = paramInt3)
    {
      if (paramInt4 > 0) {
        this.mSmallEncParam.videoBitrate = paramInt4;
      }
      if (paramInt5 >= 0) {
        this.mSmallEncParam.minVideoBitrate = paramInt5;
      }
      paramInt1 = this.mConfig.i;
      if (this.mVideoSourceType == VideoSourceType.SCREEN)
      {
        this.mSmallEncParam.enableAdjustRes = false;
        if (this.mOverrideFPSFromUser) {
          this.mSmallEncParam.videoFps = 10;
        }
        paramInt1 = 3;
      }
      this.mCaptureAndEnc.a(this.mEnableSmallStream, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, paramInt1);
      setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.p, this.mSmallEncParam.minVideoBitrate);
      AppMethodBeat.o(222474);
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
        AppMethodBeat.i(15710);
        TRTCCloudImpl.this.apiLog("ConnectOtherRoom " + paramString);
        Monitor.a(1, String.format("ConnectOtherRoom param:%s", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.access$1600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramString);
        AppMethodBeat.o(15710);
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
        AppMethodBeat.i(15681);
        TRTCCloudImpl.this.apiLog("DisconnectOtherRoom");
        Monitor.a(1, "DisconnectOtherRoom self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.access$1700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15681);
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
  
  public void callExperimentalAPI(final String paramString)
  {
    AppMethodBeat.i(15867);
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder("callExperimentalAPI  ").append(paramString).append(", roomid = ");
      if (this.mRoomInfo.roomId == -1L) {
        break label136;
      }
    }
    label136:
    for (Object localObject = Long.valueOf(this.mRoomInfo.roomId);; localObject = this.mRoomInfo.strRoomId)
    {
      apiLog(localObject);
      Monitor.a(1, String.format("callExperimentalAPI:%s", new Object[] { paramString }) + " self:" + hashCode(), "", 0);
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15700);
          String str;
          try
          {
            JSONObject localJSONObject2 = new JSONObject(paramString);
            if (!localJSONObject2.has("api"))
            {
              TRTCCloudImpl.this.apiLog("callExperimentalAPI[lack api or illegal type]: " + paramString);
              AppMethodBeat.o(15700);
              return;
            }
            str = localJSONObject2.getString("api");
            JSONObject localJSONObject1 = null;
            if (localJSONObject2.has("params")) {
              localJSONObject1 = localJSONObject2.getJSONObject("params");
            }
            if (str.equals("setSEIPayloadType"))
            {
              TRTCCloudImpl.this.setSEIPayloadType(localJSONObject1);
              AppMethodBeat.o(15700);
              return;
            }
          }
          catch (Exception localException)
          {
            TRTCCloudImpl.this.apiLog("callExperimentalAPI[failed]: " + paramString + " " + localException.getMessage());
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setLocalAudioMuteMode"))
          {
            TRTCCloudImpl.access$5000(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setVideoEncodeParamEx"))
          {
            TRTCCloudImpl.access$5100(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setAudioSampleRate"))
          {
            TRTCCloudImpl.access$5200(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("muteRemoteAudioInSpeaker"))
          {
            TRTCCloudImpl.this.muteRemoteAudioInSpeaker(localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("enableAudioAGC"))
          {
            TRTCCloudImpl.access$5300(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("enableAudioAEC"))
          {
            TRTCCloudImpl.access$5400(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("enableAudioANS"))
          {
            TRTCCloudImpl.access$5500(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setPerformanceMode"))
          {
            TRTCCloudImpl.this.setPerformanceMode(localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setCustomRenderMode"))
          {
            TRTCCloudImpl.access$5600(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setMediaCodecConfig"))
          {
            TRTCCloudImpl.access$5700(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("sendJsonCMD"))
          {
            TRTCCloudImpl.this.sendJsonCmd(localException, paramString);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("updatePrivateMapKey"))
          {
            TRTCCloudImpl.this.updatePrivateMapKey(localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("setFramework"))
          {
            TRTCCloudImpl.access$5800(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          if (str.equals("forceCallbackMixedPlayAudioFrame"))
          {
            TRTCCloudImpl.access$5900(TRTCCloudImpl.this, localException);
            AppMethodBeat.o(15700);
            return;
          }
          TRTCCloudImpl.this.apiLog("callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
          AppMethodBeat.o(15700);
        }
      });
      AppMethodBeat.o(15867);
      return;
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
            AppMethodBeat.i(222401);
            localTXCloudVideoView.setDashBoardStatusInfo(localCharSequence);
            AppMethodBeat.o(222401);
          }
        });
      }
    }
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(222450);
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
        AppMethodBeat.o(222450);
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
          AppMethodBeat.i(222443);
          paramTXCloudVideoView.setDashBoardStatusInfo(paramTXCRenderAndDec);
          AppMethodBeat.o(222443);
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
    if ((localTRTCCloudListener != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!TRTCRoomInfo.hasAudio(paramInt1)) || (TRTCRoomInfo.isMuteAudio(paramInt1))) {
        break label562;
      }
      bool1 = true;
      if ((!TRTCRoomInfo.hasAudio(paramInt2)) || (TRTCRoomInfo.isMuteAudio(paramInt2))) {
        break label568;
      }
      bool2 = true;
      if (bool2 == bool1) {
        break label574;
      }
      i = 1;
      if (i != 0)
      {
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222398);
            localTRTCCloudListener.onUserAudioAvailable(paramString, bool1);
            AppMethodBeat.o(222398);
          }
        });
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }) + " self:" + hashCode(), "", 0);
      }
      if (((!TRTCRoomInfo.hasMainVideo(paramInt1)) && (!TRTCRoomInfo.hasSmallVideo(paramInt1))) || (TRTCRoomInfo.isMuteMainVideo(paramInt1))) {
        break label580;
      }
      bool1 = true;
      if (((!TRTCRoomInfo.hasMainVideo(paramInt2)) && (!TRTCRoomInfo.hasSmallVideo(paramInt2))) || (TRTCRoomInfo.isMuteMainVideo(paramInt2))) {
        break label586;
      }
      bool2 = true;
      if (bool2 == bool1) {
        break label592;
      }
      i = 1;
      if ((this.mRecvMode == 3) || (this.mRecvMode == 1)) {
        break label598;
      }
      j = 1;
      label267:
      if ((i != 0) && ((this.mRoomInfo.hasRecvFirstIFrame(paramLong)) || (j != 0)))
      {
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222414);
            localTRTCCloudListener.onUserVideoAvailable(paramString, bool1);
            AppMethodBeat.o(222414);
          }
        });
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }) + " self:" + hashCode(), "", 0);
      }
      if ((!TRTCRoomInfo.hasSubVideo(paramInt1)) || (TRTCRoomInfo.isMuteSubVideo(paramInt1))) {
        break label604;
      }
      bool1 = true;
      label414:
      if ((!TRTCRoomInfo.hasSubVideo(paramInt2)) || (TRTCRoomInfo.isMuteSubVideo(paramInt2))) {
        break label610;
      }
      bool2 = true;
      label433:
      if (bool2 == bool1) {
        break label616;
      }
    }
    label562:
    label568:
    label574:
    label580:
    label586:
    label592:
    label598:
    label604:
    label610:
    label616:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222412);
            localTRTCCloudListener.onUserSubStreamAvailable(paramString, bool1);
            AppMethodBeat.o(222412);
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
      break label414;
      bool2 = false;
      break label433;
    }
  }
  
  public TRTCCloud createSubCloud()
  {
    AppMethodBeat.i(222456);
    final TRTCSubCloud localTRTCSubCloud = new TRTCSubCloud(this.mContext, new WeakReference(this), this.mSDKHandler);
    localTRTCSubCloud.setListenerHandler(this.mListenerHandler);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15564);
        TRTCCloudImpl.this.mSubClouds.add(new WeakReference(localTRTCSubCloud));
        AppMethodBeat.o(15564);
      }
    });
    AppMethodBeat.o(222456);
    return localTRTCSubCloud;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(15782);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15668);
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
              AppMethodBeat.o(15668);
              throw localObject2;
            }
          }
        }
        TRTCCloudImpl.this.mSubClouds.clear();
        AppMethodBeat.o(15668);
      }
    });
    AppMethodBeat.o(15782);
  }
  
  public void destroySubCloud(final TRTCCloud paramTRTCCloud)
  {
    AppMethodBeat.i(222457);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15698);
        Iterator localIterator = TRTCCloudImpl.this.mSubClouds.iterator();
        while (localIterator.hasNext())
        {
          TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)localIterator.next()).get();
          if ((localTRTCCloudImpl != null) && (localTRTCCloudImpl == paramTRTCCloud))
          {
            localTRTCCloudImpl.destroy();
            localIterator.remove();
            AppMethodBeat.o(15698);
            return;
          }
        }
        AppMethodBeat.o(15698);
      }
    });
    AppMethodBeat.o(222457);
  }
  
  public void enableAudioEarMonitoring(final boolean paramBoolean)
  {
    AppMethodBeat.i(15824);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15572);
        Monitor.a(1, String.format("enableAudioEarMonitoring enable:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TXAudioEffectManagerImpl.getInstance().enableVoiceEarMonitor(paramBoolean);
        AppMethodBeat.o(15572);
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
        AppMethodBeat.i(15688);
        if (paramInt > 0) {
          if (paramInt >= 100) {}
        }
        while (i == TRTCCloudImpl.this.mAudioVolumeEvalInterval)
        {
          AppMethodBeat.o(15688);
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
          AppMethodBeat.o(15688);
          return;
        }
        TRTCCloudImpl.this.startVolumeLevelCal(false);
        AppMethodBeat.o(15688);
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
        AppMethodBeat.i(15657);
        if (TRTCCloudImpl.this.mEnableCustomAudioCapture == paramBoolean)
        {
          AppMethodBeat.o(15657);
          return;
        }
        TRTCCloudImpl.access$1302(TRTCCloudImpl.this, paramBoolean);
        g localg;
        if (paramBoolean)
        {
          localg = TRTCCloudImpl.this.mConfig;
          localg.R |= 0x1;
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
                localTRTCCloudListener.onWarning(6001, "ignore send custom audio,for role audience", null);
                AppMethodBeat.o(15714);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore enableCustomAudioCapture,for role audience");
          }
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TRTCCloudImpl.this.apiLog("enableCustomAudioCapture " + paramBoolean);
          Monitor.a(1, String.format("enableCustomAudioCapture:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          if (!TRTCCloudImpl.this.mIsAudioCapturing) {
            TRTCCloudImpl.this.enableAudioStream(paramBoolean);
          }
          if (!paramBoolean) {
            break label317;
          }
          TRTCCloudImpl.access$4300(TRTCCloudImpl.this);
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
          AppMethodBeat.o(15657);
          return;
          localg = TRTCCloudImpl.this.mConfig;
          localg.R &= 0xFFFFFFFE;
          break;
          label317:
          TXCAudioEngine.getInstance().stopLocalAudio();
        }
      }
    });
    AppMethodBeat.o(15871);
  }
  
  public void enableCustomVideoCapture(final boolean paramBoolean)
  {
    AppMethodBeat.i(15854);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15644);
        if ((paramBoolean) && (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE))
        {
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, "Has started capturing, ignore enableCustomVideoCapture");
          AppMethodBeat.o(15644);
          return;
        }
        if ((!paramBoolean) && (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.CUSTOM))
        {
          AppMethodBeat.o(15644);
          return;
        }
        TRTCCloudImpl localTRTCCloudImpl = TRTCCloudImpl.this;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = TRTCCloudImpl.VideoSourceType.CUSTOM;
          TRTCCloudImpl.access$1502(localTRTCCloudImpl, (TRTCCloudImpl.VideoSourceType)localObject1);
          if (!paramBoolean) {
            break label299;
          }
          localObject1 = TRTCCloudImpl.this.mConfig;
          ((g)localObject1).R |= 0x2;
          TRTCCloudImpl.access$4802(TRTCCloudImpl.this, 0L);
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(222426);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(222426);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore send custom video,for role audience", null);
                AppMethodBeat.o(222426);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore enableCustomVideoCapture,for role audience");
          }
          label161:
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TRTCCloudImpl.this.apiLog("enableCustomVideoCapture " + paramBoolean);
          Monitor.a(1, String.format("enableCustomVideoCapture:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TRTCCloudImpl.this.enableVideoStream(paramBoolean);
          if (!paramBoolean) {
            break label365;
          }
        }
        label299:
        label365:
        for (int i = 1;; i = 0) {
          for (;;)
          {
            TXCKeyPointReportProxy.a(40046, i, 2);
            AppMethodBeat.o(15644);
            return;
            localObject1 = TRTCCloudImpl.VideoSourceType.NONE;
            break;
            localObject1 = TRTCCloudImpl.this.mConfig;
            ((g)localObject1).R &= 0xFFFFFFFD;
            try
            {
              if (TRTCCloudImpl.this.mCustomVideoUtil != null)
              {
                TRTCCloudImpl.this.mCustomVideoUtil.release();
                TRTCCloudImpl.access$4902(TRTCCloudImpl.this, null);
              }
              break label161;
            }
            finally
            {
              AppMethodBeat.o(15644);
            }
          }
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
        AppMethodBeat.i(15773);
        TRTCCloudImpl.this.apiLog("enableEncSmallVideoStream " + paramBoolean);
        TRTCCloudImpl.access$602(TRTCCloudImpl.this, paramBoolean);
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
        boolean bool = TRTCCloudImpl.this.mConfig.p;
        int i = TRTCCloudImpl.this.mConfig.i;
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          if (TRTCCloudImpl.this.mOverrideFPSFromUser) {
            TRTCCloudImpl.this.mSmallEncParam.videoFps = 10;
          }
          i = 3;
          bool = false;
        }
        for (;;)
        {
          TRTCCloudImpl.this.mRoomInfo.smallEncSize = TRTCCloudImpl.access$3400(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, i);
          if (TRTCCloudImpl.this.mEnableSmallStream)
          {
            TRTCCloudImpl.access$500(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, bool, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
            TRTCCloudImpl.access$1200(TRTCCloudImpl.this, 3);
            AppMethodBeat.o(15773);
            return;
          }
          TRTCCloudImpl.access$800(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
          TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 3);
          AppMethodBeat.o(15773);
          return;
        }
      }
    });
    AppMethodBeat.o(15811);
    return 0;
  }
  
  public void enableNetworkBlackStream(boolean paramBoolean)
  {
    AppMethodBeat.i(222502);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableBlackStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
    AppMethodBeat.o(222502);
  }
  
  public void enableNetworkSmallStream(boolean paramBoolean)
  {
    AppMethodBeat.i(222503);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableSmallStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
    AppMethodBeat.o(222503);
  }
  
  public boolean enableTorch(boolean paramBoolean)
  {
    AppMethodBeat.i(15836);
    apiLog("enableTorch ".concat(String.valueOf(paramBoolean)));
    paramBoolean = this.mCaptureAndEnc.e(paramBoolean);
    AppMethodBeat.o(15836);
    return paramBoolean;
  }
  
  protected void enableVideoStream(boolean paramBoolean)
  {
    AppMethodBeat.i(15961);
    if (paramBoolean)
    {
      if (!this.mRoomInfo.muteLocalVideo)
      {
        addUpStreamType(2);
        if (this.mEnableSmallStream)
        {
          addUpStreamType(3);
          AppMethodBeat.o(15961);
        }
      }
    }
    else
    {
      if (!this.mCaptureAndEnc.i()) {
        removeUpStreamType(2);
      }
      removeUpStreamType(3);
    }
    AppMethodBeat.o(15961);
  }
  
  public void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, final int paramInt)
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
    if (l == 0L)
    {
      apiLog("enter room, room id " + l + " error");
      onEnterRoom(-3318, "room id invalid.");
      AppMethodBeat.o(15785);
      return;
    }
    String str2 = "";
    Object localObject = localTRTCParams.businessInfo;
    final String str1 = str2;
    paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject;
    if (localTRTCParams.roomId == -1)
    {
      str1 = str2;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        try
        {
          localObject = new JSONObject((String)localObject);
          paramTRTCParams = new StringBuilder("");
          extractBizInfo((JSONObject)localObject, "strGroupId", paramTRTCParams);
          str2 = paramTRTCParams.toString();
          paramTRTCParams = "";
          str1 = str2;
          if (((JSONObject)localObject).length() != 0)
          {
            paramTRTCParams = ((JSONObject)localObject).toString();
            str1 = str2;
          }
        }
        catch (Exception paramTRTCParams)
        {
          for (;;)
          {
            apiLog("enter room, room id error, busInfo " + localTRTCParams.businessInfo);
            str1 = "";
            paramTRTCParams = "";
          }
        }
        if (TextUtils.isEmpty(str1))
        {
          onEnterRoom(-3318, "room id invalid.");
          AppMethodBeat.o(15785);
          return;
        }
      }
    }
    TXCKeyPointReportProxy.a(30001);
    final int i = localTRTCParams.role;
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222420);
        Object localObject2 = localTRTCParams.userId;
        int i = localTRTCParams.sdkAppId;
        if (TextUtils.isEmpty(str1)) {}
        for (Object localObject1 = l;; localObject1 = str1)
        {
          Monitor.a((String)localObject2, i, (String)localObject1);
          if (TRTCCloudImpl.this.mRoomState == 0) {
            break label239;
          }
          if (((TextUtils.isEmpty(str1)) || (!str1.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.strRoomId))) && (TRTCCloudImpl.this.mRoomInfo.roomId != l)) {
            break;
          }
          TRTCCloudImpl.this.apiLog(String.format("enter the same room[%d] again!!!", new Object[] { Long.valueOf(l) }));
          TRTCCloudImpl.this.mRoomInfo.enterTime = paramInt;
          TRTCCloudImpl.this.onEnterRoom(0, "enter the same room.");
          AppMethodBeat.o(222420);
          return;
        }
        TRTCCloudImpl.this.apiLog(String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l), Long.valueOf(TRTCCloudImpl.this.mRoomInfo.roomId) }));
        TRTCCloudImpl.this.mIsExitOldRoom = true;
        TRTCCloudImpl.this.exitRoom();
        label239:
        TRTCCloudImpl.this.apiLog("========================================================================================================");
        TRTCCloudImpl.this.apiLog("========================================================================================================");
        TRTCCloudImpl.this.apiLog(String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), com.tencent.liteav.basic.util.f.c(), com.tencent.liteav.basic.util.f.d() }));
        TRTCCloudImpl.this.apiLog("========================================================================================================");
        TRTCCloudImpl.this.apiLog("========================================================================================================");
        TRTCCloudImpl.this.apiLog(String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d, bizinfo:%s", new Object[] { Long.valueOf(l), str1, localTRTCParams.userId, Integer.valueOf(localTRTCParams.sdkAppId), Integer.valueOf(i), jdField_this }));
        String str1 = "enterRoom self:" + TRTCCloudImpl.this.hashCode();
        i = i;
        localObject1 = "VideoCall";
        int j = 2;
        String str2;
        label520:
        int k;
        label644:
        label656:
        int m;
        switch (i)
        {
        default: 
          TXCLog.w("TRTCCloudImpl", "enter room scene:%u error! default to VideoCall! " + i + " self:" + TRTCCloudImpl.this.hashCode());
          i = 0;
          TXCAudioEngine.getInstance().setAudioQuality(j, 1);
          str2 = jdField_this;
          if (this.val$finalRole == 20)
          {
            localObject2 = "Anchor";
            Monitor.a(1, str1, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { str2, localObject1, localObject2, localTRTCParams.streamId }), 0);
            if (TRTCCloudImpl.this.mAudioFrameListener != null) {
              TXCAudioEngine.setPlayoutDataListener(this.val$refThis);
            }
            TXCEventRecorderProxy.a("18446744073709551615", 5001, l, -1L, "", 0);
            TXCStatus.a("18446744073709551615", 10003, com.tencent.liteav.basic.util.f.c());
            TRTCCloudImpl.this.mRoomState = 1;
            if (TRTCCloudImpl.this.mNativeRtcContext == 0L)
            {
              localObject1 = TXCCommonUtil.getSDKVersion();
              if (localObject1.length <= 0) {
                break label1311;
              }
              j = localObject1[0];
              if (localObject1.length < 2) {
                break label1316;
              }
              k = localObject1[1];
              if (localObject1.length < 3) {
                break label1321;
              }
              m = localObject1[2];
              label669:
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
            TRTCCloudImpl.this.mCaptureAndEnc.g(bool);
            TRTCCloudImpl.access$400(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
            TRTCCloudImpl.access$500(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.bigEncSize.a, TRTCCloudImpl.this.mRoomInfo.bigEncSize.b, TRTCCloudImpl.this.mConfig.h, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.e);
            if (!TRTCCloudImpl.this.mEnableSmallStream) {
              break label1327;
            }
            TRTCCloudImpl.access$500(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
            label931:
            TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.i);
            localObject1 = com.tencent.liteav.basic.util.f.d();
            str1 = com.tencent.liteav.basic.util.f.c();
            TRTCCloudImpl.access$900(TRTCCloudImpl.this, str1, (String)localObject1, localTRTCParams.sdkAppId);
            localObject2 = new TXCKeyPointReportProxy.a();
            ((TXCKeyPointReportProxy.a)localObject2).d = i;
            ((TXCKeyPointReportProxy.a)localObject2).e = str1;
            ((TXCKeyPointReportProxy.a)localObject2).f = ((String)localObject1);
            if (TRTCCloudImpl.this.mContext == null) {
              break label1354;
            }
          }
          break;
        }
        label1311:
        label1316:
        label1321:
        label1327:
        label1354:
        for (localObject1 = TRTCCloudImpl.this.mContext.getPackageName();; localObject1 = "")
        {
          ((TXCKeyPointReportProxy.a)localObject2).h = ((String)localObject1);
          ((TXCKeyPointReportProxy.a)localObject2).b = localTRTCParams.sdkAppId;
          ((TXCKeyPointReportProxy.a)localObject2).g = TXCCommonUtil.getSDKVersionStr();
          ((TXCKeyPointReportProxy.a)localObject2).c = TRTCCloudImpl.this.mFramework;
          TXCKeyPointReportProxy.a((TXCKeyPointReportProxy.a)localObject2);
          TRTCCloudImpl.this.nativeSetPriorRemoteVideoStreamType(TRTCCloudImpl.this.mNativeRtcContext, TRTCCloudImpl.this.mPriorStreamType);
          localObject1 = TRTCCloudImpl.this.mRoomInfo.getToken(TRTCCloudImpl.this.mContext);
          TRTCCloudImpl.this.nativeInit(TRTCCloudImpl.this.mNativeRtcContext, localTRTCParams.sdkAppId, localTRTCParams.userId, localTRTCParams.userSig, (byte[])localObject1);
          localObject1 = TRTCCloudImpl.this.mStreamTypes.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            TRTCCloudImpl.access$1200(TRTCCloudImpl.this, ((Integer)localObject2).intValue());
          }
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
          break label520;
          j = 0;
          break label644;
          k = 0;
          break label656;
          m = 0;
          break label669;
          TRTCCloudImpl.access$800(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
          break label931;
        }
        TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
        TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
        if (localTRTCParams.privateMapKey != null)
        {
          localObject1 = localTRTCParams.privateMapKey;
          if (str1 == null) {
            break label1843;
          }
          localObject2 = str1;
          label1424:
          if (jdField_this == null) {
            break label1850;
          }
          str1 = jdField_this;
          label1437:
          if (localTRTCParams.userDefineRecordId == null) {
            break label1857;
          }
          str2 = localTRTCParams.userDefineRecordId;
          label1456:
          if (localTRTCParams.streamId == null) {
            break label1864;
          }
        }
        label1843:
        label1850:
        label1857:
        label1864:
        for (String str3 = localTRTCParams.streamId;; str3 = "")
        {
          TRTCCloudImpl.this.nativeEnterRoom(TRTCCloudImpl.this.mNativeRtcContext, l, str1, (String)localObject1, (String)localObject2, this.val$finalRole, 255, i, i, TRTCCloudImpl.this.mPerformanceMode, com.tencent.liteav.basic.util.f.c(), com.tencent.liteav.basic.util.f.d(), TRTCCloudImpl.this.mRecvMode, str2, str3);
          TRTCCloudImpl.this.mCurrentRole = this.val$finalRole;
          TRTCCloudImpl.this.mTargetRole = this.val$finalRole;
          if ((TRTCCloudImpl.this.mCurrentRole == 21) && ((TRTCCloudImpl.this.mEnableCustomAudioCapture) || (TRTCCloudImpl.this.mIsAudioCapturing) || (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)))
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(222421);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(222421);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore upstream for audience", null);
                AppMethodBeat.o(222421);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore upstream for audience, when enter room!!");
          }
          TRTCCloudImpl.this.mCaptureAndEnc.e();
          TRTCCloudImpl.this.startCollectStatus();
          TRTCCloudImpl.this.mLastStateTimeMs = 0L;
          TRTCCloudImpl.this.mRoomInfo.init(l, localTRTCParams.userId);
          TRTCCloudImpl.this.mRoomInfo.strRoomId = ((String)localObject2);
          TRTCCloudImpl.this.mRoomInfo.sdkAppId = localTRTCParams.sdkAppId;
          TRTCCloudImpl.this.mRoomInfo.userSig = localTRTCParams.userSig;
          TRTCCloudImpl.this.mRoomInfo.privateMapKey = ((String)localObject1);
          TRTCCloudImpl.this.mRoomInfo.enterTime = paramInt;
          TXCEventRecorderProxy.a("18446744073709551615", 4007, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.b, "", 2);
          TXCEventRecorderProxy.a("18446744073709551615", 4008, TRTCCloudImpl.this.mConfig.h, -1L, "", 2);
          TXCEventRecorderProxy.a("18446744073709551615", 4009, TRTCCloudImpl.this.mConfig.c, -1L, "", 2);
          AppMethodBeat.o(222420);
          return;
          localObject1 = "";
          break;
          localObject2 = "";
          break label1424;
          str1 = "";
          break label1437;
          str2 = "";
          break label1456;
        }
      }
    });
    AppMethodBeat.o(15785);
  }
  
  public void exitRoom()
  {
    AppMethodBeat.i(15786);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15775);
        TRTCCloudImpl.this.exitRoomInternal(true, "call from api");
        AppMethodBeat.o(15775);
      }
    });
    AppMethodBeat.o(15786);
  }
  
  protected void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(222455);
    paramString = String.format(Locale.ENGLISH, "exitRoom %s, self: %d, reason: %s", new Object[] { Long.valueOf(this.mRoomInfo.getRoomId()), Integer.valueOf(hashCode()), paramString });
    apiLog(paramString);
    Monitor.a(1, paramString, "", 0);
    if (this.mRoomState == 0)
    {
      Monitor.a();
      apiLog("exitRoom ignore when no in room.");
      AppMethodBeat.o(222455);
      return;
    }
    this.mRoomState = 0;
    this.mCaptureAndEnc.f();
    TXCSoundEffectPlayer.getInstance().stopAllEffect();
    stopCollectStatus();
    startVolumeLevelCal(false);
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(222577);
        TRTCCloudImpl.this.stopRemoteRender(paramAnonymousUserInfo);
        TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramAnonymousUserInfo.tinyID));
        if (paramAnonymousUserInfo.mainRender.render != null) {
          paramAnonymousUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
        }
        if (paramAnonymousUserInfo.subRender.render != null) {
          paramAnonymousUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
        }
        AppMethodBeat.o(222577);
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
    stopLocalAudio();
    stopBGM();
    TXCKeyPointReportProxy.a(31004);
    stopLocalPreview();
    stopScreenCapture();
    TXCKeyPointReportProxy.b(31004, 0);
    this.mConfig.A = null;
    this.mConfig.C = 10;
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    this.mVideoSourceType = VideoSourceType.NONE;
    this.mEnableSmallStream = false;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mCaptureAndEnc.a(false);
    TXCAudioEngine.getInstance().muteLocalAudio(false);
    TXCAudioEngine.getInstance().clean();
    enableCustomAudioCapture(false);
    this.mEnableCustomAudioCapture = false;
    try
    {
      if (this.mCustomVideoUtil != null)
      {
        this.mCustomVideoUtil.release();
        this.mCustomVideoUtil = null;
      }
      this.mCaptureAndEnc.a(null, 0);
      stopAudioRecording();
      TXCSoundEffectPlayer.getInstance().clearCache();
      Monitor.a();
      AppMethodBeat.o(222455);
      return;
    }
    finally
    {
      AppMethodBeat.o(222455);
    }
  }
  
  void extractBizInfo(JSONObject paramJSONObject, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(222453);
    if (paramString.equals("strGroupId"))
    {
      paramStringBuilder.append(paramJSONObject.optString("strGroupId").toString());
      paramJSONObject.remove("strGroupId");
      paramJSONObject.remove("Role");
    }
    apiLog("extractBizInfo: key" + paramString + " value:" + paramStringBuilder.toString());
    AppMethodBeat.o(222453);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(15900);
    super.finalize();
    try
    {
      destroy();
      if (this.mSDKHandler != null) {
        this.mSDKHandler.getLooper().quit();
      }
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
  
  public int getAudioCaptureVolume()
  {
    return this.mAudioCaptureVolume;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(222477);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getAutoCacheHolder();
    AppMethodBeat.o(222477);
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
  
  public long getNetworkContext()
  {
    return this.mNativeRtcContext;
  }
  
  public int getNetworkQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15978);
    if (!com.tencent.liteav.basic.util.f.d(this.mContext))
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
    Object localObject = com.tencent.liteav.basic.util.f.a();
    int i = TXCStatus.c("18446744073709551615", 4003, 2);
    String str = TXCStatus.b("18446744073709551615", 10001);
    localObject = String.format("LOCAL: [%s] RTT:%dms\n", new Object[] { this.mRoomInfo.getUserId(), Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }) + String.format(Locale.CHINA, "SEND:% 5dkbps LOSS:%d-%d-%d-%d|%d-%d-%d-%d|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 12001)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13011, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13012, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13013, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14011)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14012)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14013)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14010)), Integer.valueOf(TXCStatus.c("18446744073709551615", 12003)) }) + String.format(Locale.CHINA, "BIT:%d|%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 3)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14002)), Integer.valueOf(i >> 16), Integer.valueOf(i & 0xFFFF), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 4001, 2)), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 13014, 2)) }) + String.format(Locale.CHINA, "FEC:%d%%|%d%%  ARQ:%d|%dkbps  RPS:%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13004, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14006)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13008, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14008)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13007, 2)) }) + String.format(Locale.CHINA, "CPU:%d%%|%d%%    QOS:%s|%dkbps|%d-%d\n", new Object[] { Integer.valueOf(localObject[0] / 10), Integer.valueOf(localObject[1] / 10), getQosValue(TXCStatus.c("18446744073709551615", 15009, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15005, 2)) }) + String.format(Locale.CHINA, "SVR:%s", new Object[] { str });
    AppMethodBeat.o(15985);
    return localObject;
  }
  
  public boolean isCameraAutoFocusFaceModeSupported()
  {
    AppMethodBeat.i(15839);
    boolean bool = this.mCaptureAndEnc.p();
    AppMethodBeat.o(15839);
    return bool;
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    AppMethodBeat.i(15837);
    boolean bool = this.mCaptureAndEnc.o();
    AppMethodBeat.o(15837);
    return bool;
  }
  
  public boolean isCameraTorchSupported()
  {
    AppMethodBeat.i(15835);
    boolean bool = this.mCaptureAndEnc.n();
    AppMethodBeat.o(15835);
    return bool;
  }
  
  public boolean isCameraZoomSupported()
  {
    AppMethodBeat.i(15833);
    boolean bool = this.mCaptureAndEnc.m();
    AppMethodBeat.o(15833);
    return bool;
  }
  
  public boolean isPublishingInCloud(TRTCCloudImpl paramTRTCCloudImpl, int paramInt)
  {
    AppMethodBeat.i(222505);
    synchronized (this.mCurrentPublishClouds)
    {
      if ((TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt)) == paramTRTCCloudImpl)
      {
        AppMethodBeat.o(222505);
        return true;
      }
      AppMethodBeat.o(222505);
      return false;
    }
  }
  
  public void muteAllRemoteAudio(final boolean paramBoolean)
  {
    AppMethodBeat.i(15821);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15778);
        TRTCCloudImpl.this.apiLog("muteAllRemoteAudio " + paramBoolean);
        Monitor.a(1, String.format("muteAllRemoteAudio mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.this.mRoomInfo.muteRemoteAudio = paramBoolean;
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(222447);
            paramAnonymous2UserInfo.mainRender.muteAudio = TRTCCloudImpl.53.this.val$mute;
            TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCCloudImpl.53.this.val$mute);
            if (TRTCCloudImpl.53.this.val$mute)
            {
              TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 1, true);
              AppMethodBeat.o(222447);
              return;
            }
            TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 1, true);
            AppMethodBeat.o(222447);
          }
        });
        AppMethodBeat.o(15778);
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
        AppMethodBeat.i(15721);
        TRTCCloudImpl.this.apiLog("muteAllRemoteVideoStreams mute " + paramBoolean);
        Monitor.a(1, String.format("muteAllRemoteVideoStreams mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.this.mRoomInfo.muteRemoteVideo = paramBoolean;
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(222416);
            paramAnonymous2UserInfo.mainRender.muteVideo = TRTCCloudImpl.32.this.val$mute;
            TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + paramAnonymous2UserInfo.userID + ", mute " + TRTCCloudImpl.32.this.val$mute);
            if (paramAnonymous2UserInfo.mainRender.render != null) {
              paramAnonymous2UserInfo.mainRender.render.muteVideo(TRTCCloudImpl.32.this.val$mute);
            }
            if (TRTCCloudImpl.32.this.val$mute)
            {
              TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 2, true);
              TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 3, true);
              TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 7, true);
              AppMethodBeat.o(222416);
              return;
            }
            if ((paramAnonymous2UserInfo.mainRender.render != null) && (paramAnonymous2UserInfo.mainRender.render.isRendering())) {
              TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, paramAnonymous2UserInfo.streamType, true);
            }
            if ((paramAnonymous2UserInfo.subRender.render != null) && (paramAnonymous2UserInfo.subRender.render.isRendering())) {
              TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramAnonymous2UserInfo.tinyID, 7, true);
            }
            AppMethodBeat.o(222416);
          }
        });
        AppMethodBeat.o(15721);
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
        AppMethodBeat.i(15724);
        TRTCCloudImpl.this.apiLog("muteLocalAudio " + paramBoolean);
        Monitor.a(1, String.format("muteLocalAudio mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.this.muteLocalAudio(paramBoolean, TRTCCloudImpl.this);
        if (paramBoolean)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 3001, 1L, -1L, "", 0);
          AppMethodBeat.o(15724);
          return;
        }
        TXCEventRecorderProxy.a("18446744073709551615", 3001, 3L, -1L, "", 0);
        AppMethodBeat.o(15724);
      }
    });
    AppMethodBeat.o(15819);
  }
  
  public void muteLocalAudio(final boolean paramBoolean, final TRTCCloudImpl paramTRTCCloudImpl)
  {
    AppMethodBeat.i(222468);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15750);
        ??? = (TRTCCloudImpl)TRTCCloudImpl.this.mCurrentPublishClouds.get(Integer.valueOf(1));
        if (!paramBoolean)
        {
          if (??? != paramTRTCCloudImpl) {
            TRTCCloudImpl.this.enableAudioStream(false);
          }
          synchronized (TRTCCloudImpl.this.mCurrentPublishClouds)
          {
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(1), paramTRTCCloudImpl);
            TRTCCloudImpl.access$4600(TRTCCloudImpl.this);
            TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = paramBoolean;
            TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
            TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 1, paramBoolean);
            TRTCCloudImpl.this.enableAudioStream(true);
            AppMethodBeat.o(15750);
            return;
          }
        }
        if (??? == paramTRTCCloudImpl)
        {
          TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = paramBoolean;
          TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
          TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 1, paramBoolean);
        }
        AppMethodBeat.o(15750);
      }
    });
    AppMethodBeat.o(222468);
  }
  
  public void muteLocalVideo(final boolean paramBoolean)
  {
    AppMethodBeat.i(15800);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15580);
        TRTCCloudImpl.this.apiLog("muteLocalVideo " + paramBoolean + ", " + TRTCCloudImpl.this.mConfig.A);
        Monitor.a(1, String.format("muteLocalVideo mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 4006, l, -1L, "", 2);
          TRTCCloudImpl.this.muteLocalVideo(paramBoolean, TRTCCloudImpl.this);
          AppMethodBeat.o(15580);
          return;
        }
      }
    });
    AppMethodBeat.o(15800);
  }
  
  public void muteLocalVideo(final boolean paramBoolean, final TRTCCloudImpl paramTRTCCloudImpl)
  {
    AppMethodBeat.i(222465);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        boolean bool2 = true;
        boolean bool1 = true;
        AppMethodBeat.i(15627);
        ??? = (TRTCCloudImpl)TRTCCloudImpl.this.mCurrentPublishClouds.get(Integer.valueOf(2));
        if (!paramBoolean)
        {
          if (??? == paramTRTCCloudImpl) {
            break label606;
          }
          TRTCCloudImpl.this.enableVideoStream(false);
        }
        for (;;)
        {
          synchronized (TRTCCloudImpl.this.mCurrentPublishClouds)
          {
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(2), paramTRTCCloudImpl);
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(3), paramTRTCCloudImpl);
            TRTCCloudImpl.this.mCurrentPublishClouds.put(Integer.valueOf(7), paramTRTCCloudImpl);
            TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
            TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
            TRTCCloudImpl.access$400(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
            TRTCCloudImpl.access$500(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.bigEncSize.a, TRTCCloudImpl.this.mRoomInfo.bigEncSize.b, TRTCCloudImpl.this.mConfig.h, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.e);
            if (TRTCCloudImpl.this.mEnableSmallStream)
            {
              TRTCCloudImpl.access$500(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
              i = 1;
              TRTCCloudImpl.this.mCaptureAndEnc.h();
              TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = paramBoolean;
              ??? = TRTCCloudImpl.this;
              if (paramBoolean) {
                break label486;
              }
              ((TRTCCloudImpl)???).enableVideoStream(bool1);
              TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
              TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 2, paramBoolean);
              if (i != 0)
              {
                TRTCCloudImpl.this.mCaptureAndEnc.k(2);
                TRTCCloudImpl.this.mCaptureAndEnc.k(3);
              }
              AppMethodBeat.o(15627);
              return;
            }
          }
          TRTCCloudImpl.access$800(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
          int i = 1;
          continue;
          label486:
          bool1 = false;
          continue;
          if (??? == paramTRTCCloudImpl)
          {
            TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = paramBoolean;
            TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
            if (TRTCCloudImpl.this.mConfig.A != null)
            {
              TRTCCloudImpl.this.mCaptureAndEnc.g();
              AppMethodBeat.o(15627);
              return;
            }
            ??? = TRTCCloudImpl.this;
            if (paramBoolean) {
              break label601;
            }
          }
          label601:
          for (bool1 = bool2;; bool1 = false)
          {
            ((TRTCCloudImpl)???).enableVideoStream(bool1);
            TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 2, paramBoolean);
            AppMethodBeat.o(15627);
            return;
          }
          label606:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(222465);
  }
  
  public void muteRemoteAudio(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(15820);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15568);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("muteRemoteAudio " + paramString + " no exist.");
          localUserInfo = TRTCCloudImpl.access$2200(TRTCCloudImpl.this, paramString);
          localUserInfo.mainRender.muteAudio = paramBoolean;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
          AppMethodBeat.o(15568);
          return;
        }
        localUserInfo.mainRender.muteAudio = paramBoolean;
        TRTCCloudImpl.this.apiLog("muteRemoteAudio " + paramString + ", " + paramBoolean);
        Monitor.a(1, String.format("muteRemoteAudio userId:%s mute:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        if (localUserInfo.tinyID == 0L)
        {
          AppMethodBeat.o(15568);
          return;
        }
        TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(localUserInfo.tinyID), paramBoolean);
        if (paramBoolean)
        {
          TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 1, true);
          AppMethodBeat.o(15568);
          return;
        }
        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 1, true);
        AppMethodBeat.o(15568);
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
        AppMethodBeat.i(16060);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + paramString + " no exist.");
          localUserInfo = TRTCCloudImpl.access$2200(TRTCCloudImpl.this, paramString);
          localUserInfo.mainRender.muteVideo = paramBoolean;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
          AppMethodBeat.o(16060);
          return;
        }
        localUserInfo.mainRender.muteVideo = paramBoolean;
        TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + paramString + ", mute:" + paramBoolean);
        Monitor.a(1, String.format("muteRemoteVideoStream userId:%s mute:%b self:" + TRTCCloudImpl.this.hashCode(), new Object[] { paramString, Boolean.valueOf(paramBoolean) }), "", 0);
        if (localUserInfo.tinyID == 0L)
        {
          AppMethodBeat.o(16060);
          return;
        }
        if (localUserInfo.mainRender.render != null) {
          localUserInfo.mainRender.render.muteVideo(paramBoolean);
        }
        if (paramBoolean)
        {
          TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 2, true);
          TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 3, true);
          TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4014, 1L, -1L, "", 0);
          AppMethodBeat.o(16060);
          return;
        }
        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, localUserInfo.streamType, true);
        TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4014, 0L, -1L, "", 0);
        AppMethodBeat.o(16060);
      }
    });
    AppMethodBeat.o(15801);
  }
  
  public native int nativeAddUpstream(long paramLong, int paramInt);
  
  public native long nativeCreateContext(int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeDestroyContext(long paramLong);
  
  public native int nativeEnterRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, String paramString6, String paramString7);
  
  protected native int nativeExitRoom(long paramLong);
  
  public native void nativeInit(long paramLong, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected native void nativeSetMixTranscodingConfig(long paramLong, TRTCTranscodingConfigInner paramTRTCTranscodingConfigInner);
  
  public native int nativeSetPriorRemoteVideoStreamType(long paramLong, int paramInt);
  
  protected void notifyEvent(final String paramString, final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(15969);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222428);
        TRTCCloudImpl.access$8300(TRTCCloudImpl.this, paramString, paramBundle.getInt("EVT_STREAM_TYPE", 2), paramBundle.getString("EVT_MSG", ""), String.format("event %d, ", new Object[] { Integer.valueOf(paramInt) }));
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
                AppMethodBeat.i(222449);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener != null) {
                  localTRTCCloudListener.onExitRoom(i);
                }
                AppMethodBeat.o(222449);
              }
            });
          }
        }
        for (;;)
        {
          i = TRTCCloudImpl.access$8100(TRTCCloudImpl.this, paramBundle.getInt("EVT_STREAM_TYPE", 2));
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222417);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener == null)
              {
                AppMethodBeat.o(222417);
                return;
              }
              if (TRTCCloudImpl.166.this.val$eventCode == 2003)
              {
                if ((TRTCCloudImpl.166.this.val$userId != null) && (TRTCCloudImpl.166.this.val$userId.equals(TRTCCloudImpl.this.mRoomInfo.getUserId())))
                {
                  TRTCCloudImpl.this.apiLog("onFirstVideoFrame local.");
                  localTRTCCloudListener.onFirstVideoFrame(null, i, TRTCCloudImpl.166.this.val$eventParam.getInt("EVT_PARAM1"), TRTCCloudImpl.166.this.val$eventParam.getInt("EVT_PARAM2"));
                  AppMethodBeat.o(222417);
                  return;
                }
                TRTCCloudImpl.this.apiLog("onFirstVideoFrame " + TRTCCloudImpl.166.this.val$userId);
                localTRTCCloudListener.onFirstVideoFrame(TRTCCloudImpl.166.this.val$userId, i, TRTCCloudImpl.166.this.val$eventParam.getInt("EVT_PARAM1"), TRTCCloudImpl.166.this.val$eventParam.getInt("EVT_PARAM2"));
                AppMethodBeat.o(222417);
                return;
              }
              if (TRTCCloudImpl.166.this.val$eventCode == 2026)
              {
                TRTCCloudImpl.this.apiLog("onFirstAudioFrame " + TRTCCloudImpl.166.this.val$userId);
                localTRTCCloudListener.onFirstAudioFrame(TRTCCloudImpl.166.this.val$userId);
                AppMethodBeat.o(222417);
                return;
              }
              if (TRTCCloudImpl.166.this.val$eventCode == 1003)
              {
                localTRTCCloudListener.onCameraDidReady();
                Monitor.a(1, "onCameraDidReady self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                AppMethodBeat.o(222417);
                return;
              }
              if (TRTCCloudImpl.166.this.val$eventCode == 2027)
              {
                localTRTCCloudListener.onMicDidReady();
                Monitor.a(1, "onMicDidReady self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                AppMethodBeat.o(222417);
                return;
              }
              if (TRTCCloudImpl.166.this.val$eventCode < 0)
              {
                localTRTCCloudListener.onError(TRTCCloudImpl.166.this.val$eventCode, TRTCCloudImpl.166.this.val$eventParam.getString("EVT_MSG", ""), TRTCCloudImpl.166.this.val$eventParam);
                Monitor.a(3, String.format("onError event:%d, msg:%s", new Object[] { Integer.valueOf(TRTCCloudImpl.166.this.val$eventCode), TRTCCloudImpl.166.this.val$eventParam }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXCKeyPointReportProxy.b(TRTCCloudImpl.166.this.val$eventCode);
              }
              for (;;)
              {
                AppMethodBeat.o(222417);
                return;
                if (((TRTCCloudImpl.166.this.val$eventCode > 1100) && (TRTCCloudImpl.166.this.val$eventCode < 1110)) || ((TRTCCloudImpl.166.this.val$eventCode > 1200) && (TRTCCloudImpl.166.this.val$eventCode < 1206)) || ((TRTCCloudImpl.166.this.val$eventCode > 2100) && (TRTCCloudImpl.166.this.val$eventCode < 2110)) || ((TRTCCloudImpl.166.this.val$eventCode > 3001) && (TRTCCloudImpl.166.this.val$eventCode < 3011)) || ((TRTCCloudImpl.166.this.val$eventCode > 5100) && (TRTCCloudImpl.166.this.val$eventCode < 5104)))
                {
                  localTRTCCloudListener.onWarning(TRTCCloudImpl.166.this.val$eventCode, TRTCCloudImpl.166.this.val$eventParam.getString("EVT_MSG", ""), TRTCCloudImpl.166.this.val$eventParam);
                  if (TRTCCloudImpl.166.this.val$eventCode != 2105) {
                    Monitor.a(1, String.format("onWarning event:%d, msg:%s", new Object[] { Integer.valueOf(TRTCCloudImpl.166.this.val$eventCode), TRTCCloudImpl.166.this.val$eventParam }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  }
                  switch (TRTCCloudImpl.166.this.val$eventCode)
                  {
                  }
                }
              }
            }
          });
          AppMethodBeat.o(222428);
          return;
          TRTCCloudImpl.this.mRoomInfo.micStart(false);
          continue;
          if (paramInt == 2027)
          {
            TRTCCloudImpl.this.apiLog(String.format("onMicDidReady~", new Object[0]));
            TRTCCloudImpl.this.mRoomInfo.micStart(true);
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
        AppMethodBeat.i(15640);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberEnter when out room.");
          AppMethodBeat.o(15640);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(15640);
          return;
        }
        Object localObject1 = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localObject1 != null) {
          TRTCCloudImpl.this.apiLog(" user " + paramString + "enter room when user is in room " + paramLong);
        }
        Object localObject2 = String.valueOf(paramLong);
        if (localObject1 == null) {
          localObject1 = TRTCCloudImpl.access$2200(TRTCCloudImpl.this, paramString);
        }
        for (;;)
        {
          TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener((String)localObject2, TRTCCloudImpl.this);
          if (TRTCCloudImpl.this.mAudioFrameListener != null) {
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener((String)localObject2, TRTCCloudImpl.this);
          }
          TXCAudioEngine.getInstance().startRemoteAudio((String)localObject2, true);
          TXCAudioEngine.getInstance().muteRemoteAudio((String)localObject2, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio);
          TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker((String)localObject2, ((TRTCRoomInfo.UserInfo)localObject1).muteAudioInSpeaker);
          if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio) {
            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramLong, 1, true);
          }
          TXCRenderAndDec localTXCRenderAndDec = TRTCCloudImpl.access$7600(TRTCCloudImpl.this, paramLong, TRTCCloudImpl.this.mPriorStreamType);
          TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)TRTCCloudImpl.this.mRenderListenerMap.get(paramString);
          if (localRenderListenerAdapter != null)
          {
            localRenderListenerAdapter.strTinyID = ((String)localObject2);
            if (localRenderListenerAdapter.listener != null) {
              localTXCRenderAndDec.setVideoFrameListener(TRTCCloudImpl.this, TRTCCloudImpl.access$6100(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
            }
          }
          ((TRTCRoomInfo.UserInfo)localObject1).tinyID = paramLong;
          ((TRTCRoomInfo.UserInfo)localObject1).userID = paramString;
          ((TRTCRoomInfo.UserInfo)localObject1).terminalType = paramInt2;
          ((TRTCRoomInfo.UserInfo)localObject1).streamState = this.val$videoState;
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render = localTXCRenderAndDec;
          ((TRTCRoomInfo.UserInfo)localObject1).mainRender.tinyID = paramLong;
          ((TRTCRoomInfo.UserInfo)localObject1).streamType = TRTCCloudImpl.this.mPriorStreamType;
          if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.view != null)
          {
            TRTCCloudImpl.this.setRenderView(paramString, ((TRTCRoomInfo.UserInfo)localObject1).mainRender, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
            TRTCCloudImpl.this.apiLog(String.format("startRemoteView when user enter userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(((TRTCRoomInfo.UserInfo)localObject1).streamType) }));
            TRTCCloudImpl.access$2300(TRTCCloudImpl.this, String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), ((TRTCRoomInfo.UserInfo)localObject1).streamType, 0, "Start watching " + paramString);
            TRTCCloudImpl.access$2400(TRTCCloudImpl.this, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
            TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
            if (!((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo) {
              TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
            }
          }
          else
          {
            localObject2 = TRTCCloudImpl.access$7600(TRTCCloudImpl.this, paramLong, 7);
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.render = ((TXCRenderAndDec)localObject2);
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.tinyID = paramLong;
            ((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo = TRTCCloudImpl.this.mRoomInfo.muteRemoteVideo;
            if (((TRTCRoomInfo.UserInfo)localObject1).subRender.view != null)
            {
              TRTCCloudImpl.this.setRenderView(paramString, ((TRTCRoomInfo.UserInfo)localObject1).subRender, ((TRTCRoomInfo.UserInfo)localObject1).subRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
              TRTCCloudImpl.this.apiLog(String.format("onUserScreenAvailable when user enter userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(7) }));
              Monitor.a(1, String.format("startRemoteSubStreamView userID:%s", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
              TRTCCloudImpl.access$2300(TRTCCloudImpl.this, String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 7, 0, "Start watching " + paramString);
              TRTCCloudImpl.access$2400(TRTCCloudImpl.this, ((TRTCRoomInfo.UserInfo)localObject1).subRender.render, 7);
              TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
              if (!((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo) {
                TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
              }
            }
            TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, (TRTCRoomInfo.UserInfo)localObject1);
            TRTCCloudImpl.this.apiLog("onAVMemberEnter " + paramLong + ", " + paramString + ", " + this.val$videoState);
            localObject1 = TRTCCloudImpl.this.mTRTCListener;
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(222444);
                if (this.val$listener != null) {
                  this.val$listener.onUserEnter(TRTCCloudImpl.134.this.val$userID);
                }
                AppMethodBeat.o(222444);
              }
            });
            if ((!TRTCRoomInfo.hasAudio(this.val$videoState)) || (TRTCRoomInfo.isMuteAudio(this.val$videoState))) {
              break label1262;
            }
            bool = true;
            label954:
            if (bool)
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222415);
                  if (this.val$listener != null) {
                    this.val$listener.onUserAudioAvailable(TRTCCloudImpl.134.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.134.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(222415);
                }
              });
              TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[true]", new Object[] { paramString }));
            }
            if (((!TRTCRoomInfo.hasMainVideo(this.val$videoState)) && (!TRTCRoomInfo.hasSmallVideo(this.val$videoState))) || (TRTCRoomInfo.isMuteMainVideo(this.val$videoState))) {
              break label1267;
            }
            bool = true;
            label1042:
            if ((bool) && (TRTCCloudImpl.this.mRoomInfo.hasRecvFirstIFrame(paramLong)))
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222446);
                  TXCLog.i("TRTCCloudImpl", "notify onUserVideoAvailable:" + TRTCCloudImpl.134.this.val$tinyID + " [" + bool + "] by bit state. self:" + TRTCCloudImpl.this.hashCode());
                  if (this.val$listener != null) {
                    this.val$listener.onUserVideoAvailable(TRTCCloudImpl.134.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.134.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(222446);
                }
              });
              TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[true]", new Object[] { paramString }));
            }
            if ((!TRTCRoomInfo.hasSubVideo(this.val$videoState)) || (TRTCRoomInfo.isMuteSubVideo(this.val$videoState))) {
              break label1272;
            }
          }
          label1262:
          label1267:
          label1272:
          for (final boolean bool = true;; bool = false)
          {
            if (bool)
            {
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222572);
                  if (this.val$listener != null) {
                    this.val$listener.onUserSubStreamAvailable(TRTCCloudImpl.134.this.val$userID, bool);
                  }
                  Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.134.this.val$userID, Boolean.valueOf(bool) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                  AppMethodBeat.o(222572);
                }
              });
              TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subvideo Available[true]", new Object[] { paramString }));
            }
            TRTCCloudImpl.access$7300(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]enter room", new Object[] { paramString }));
            AppMethodBeat.o(15640);
            return;
            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
            break;
            bool = false;
            break label954;
            bool = false;
            break label1042;
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
        AppMethodBeat.i(15769);
        if (TRTCCloudImpl.this.mRoomState == 0)
        {
          TRTCCloudImpl.this.apiLog("ignore onAVMemberExit when out room.");
          AppMethodBeat.o(15769);
          return;
        }
        if ((TRTCCloudImpl)this.val$weakSelf.get() == null)
        {
          AppMethodBeat.o(15769);
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
          TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramLong));
          TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramLong), null);
          TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(String.valueOf(paramLong), null);
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(182393);
              TRTCCloudImpl.this.apiLog("onAVMemberExit " + TRTCCloudImpl.135.this.val$tinyID + ", " + TRTCCloudImpl.135.this.val$userID + ", " + TRTCCloudImpl.135.this.val$videoState);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener != null)
              {
                if ((TRTCRoomInfo.hasAudio(TRTCCloudImpl.135.this.val$videoState)) && (!TRTCRoomInfo.isMuteAudio(TRTCCloudImpl.135.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserAudioAvailable(TRTCCloudImpl.135.this.val$userID, false);
                  TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                if (((TRTCRoomInfo.hasMainVideo(TRTCCloudImpl.135.this.val$videoState)) || (TRTCRoomInfo.hasSmallVideo(TRTCCloudImpl.135.this.val$videoState))) && (!TRTCRoomInfo.isMuteMainVideo(TRTCCloudImpl.135.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserVideoAvailable(TRTCCloudImpl.135.this.val$userID, false);
                  TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                if ((TRTCRoomInfo.hasSubVideo(TRTCCloudImpl.135.this.val$videoState)) && (!TRTCRoomInfo.isMuteSubVideo(TRTCCloudImpl.135.this.val$videoState)))
                {
                  localTRTCCloudListener.onUserSubStreamAvailable(TRTCCloudImpl.135.this.val$userID, false);
                  TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }));
                  Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { TRTCCloudImpl.135.this.val$userID, Boolean.FALSE }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                localTRTCCloudListener.onUserExit(TRTCCloudImpl.135.this.val$userID, 0);
              }
              AppMethodBeat.o(182393);
            }
          });
          AppMethodBeat.o(15769);
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
        AppMethodBeat.i(15628);
        Bundle localBundle = new Bundle();
        localBundle.putLong("EVT_ID", paramInt);
        localBundle.putLong("EVT_TIME", System.currentTimeMillis());
        localBundle.putString("EVT_MSG", paramString2);
        TRTCCloudImpl.access$7100(TRTCCloudImpl.this, paramString1, paramInt, localBundle);
        AppMethodBeat.o(15628);
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
        AppMethodBeat.i(15565);
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
            AppMethodBeat.o(15565);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e("TRTCCloudImpl", "onPlayAudioFrame failed." + localException.getMessage());
          }
        }
        AppMethodBeat.o(15565);
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
    AppMethodBeat.i(222480);
    if (!isPublishingInCloud(paramTRTCCloudImpl, 1))
    {
      AppMethodBeat.o(222480);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15650);
        TXCAudioEngine.getInstance().setAudioEncoderParam(paramInt1, paramInt2);
        TXCAudioEngine.getInstance().setEncoderFECPercent(paramInt3);
        AppMethodBeat.o(15650);
      }
    });
    AppMethodBeat.o(222480);
  }
  
  public void onBackgroudPushStop() {}
  
  protected void onCancelTranscoding(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(15945);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182404);
        Monitor.a(1, String.format("onCancelTranscoding err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSetMixTranscodingConfig(paramInt, paramString);
        }
        AppMethodBeat.o(182404);
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
        AppMethodBeat.i(15758);
        TRTCCloudImpl.this.apiLog("onEffectPlayFinish -> effectId = " + paramInt);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onAudioEffectFinished(paramInt, 0);
        }
        AppMethodBeat.o(15758);
      }
    });
    AppMethodBeat.o(15883);
  }
  
  public void onEffectPlayStart(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(222478);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15567);
        TRTCCloudImpl.this.apiLog("onEffectPlayStart -> effectId = " + paramInt1 + " code = " + paramInt2);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if ((localTRTCCloudListener != null) && (paramInt2 < 0)) {
          localTRTCCloudListener.onAudioEffectFinished(paramInt1, paramInt2);
        }
        AppMethodBeat.o(15567);
      }
    });
    AppMethodBeat.o(222478);
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
    apiLog("onEnterRoom " + paramInt + ", " + paramString);
    Monitor.a(1, String.format("onEnterRoom err:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }) + " self:" + hashCode(), "", 0);
    if (paramInt == 0) {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 1L, -1L, "", 0);
    }
    for (;;)
    {
      runOnSDKThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15647);
          if (paramInt == 0)
          {
            TRTCCloudImpl.this.mRoomState = 2;
            TRTCCloudImpl.this.mRoomInfo.networkStatus = 3;
            if (TRTCCloudImpl.this.mRoomInfo.muteLocalVideo) {
              TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.muteLocalVideo);
            }
            if (TRTCCloudImpl.this.mRoomInfo.muteLocalAudio) {
              TRTCCloudImpl.access$4000(TRTCCloudImpl.this, 1, TRTCCloudImpl.this.mRoomInfo.muteLocalAudio);
            }
            TRTCCloudImpl.access$7300(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "Enter room success");
            AppMethodBeat.o(15647);
            return;
          }
          TRTCCloudImpl.this.exitRoomInternal(false, "enter room failed");
          TRTCCloudImpl.access$7300(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), paramInt, "Enter room fail " + paramString);
          switch (paramInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(15647);
            return;
            TXCKeyPointReportProxy.b(paramInt);
          }
        }
      });
      runOnListenerThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170203);
          TXCKeyPointReportProxy.b(30001, paramInt);
          TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
          long l = TRTCCloudImpl.this.mRoomInfo.getRoomElapsed();
          if (localTRTCCloudListener != null)
          {
            if (paramInt == 0)
            {
              localTRTCCloudListener.onEnterRoom(l);
              AppMethodBeat.o(170203);
              return;
            }
            localTRTCCloudListener.onEnterRoom(paramInt);
          }
          AppMethodBeat.o(170203);
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
    AppMethodBeat.i(222482);
    if (!isPublishingInCloud(paramTRTCCloudImpl, 2))
    {
      AppMethodBeat.o(222482);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15575);
        TRTCCloudImpl.this.mCaptureAndEnc.c(paramInt);
        AppMethodBeat.o(15575);
      }
    });
    AppMethodBeat.o(222482);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(15901);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15620);
        if (paramBundle == null)
        {
          AppMethodBeat.o(15620);
          return;
        }
        String str = paramBundle.getString("EVT_USERID", "");
        if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase("18446744073709551615")) || (str.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.getTinyId())))
        {
          TRTCCloudImpl.this.notifyEvent(TRTCCloudImpl.this.mRoomInfo.getUserId(), paramInt, paramBundle);
          AppMethodBeat.o(15620);
          return;
        }
        TRTCCloudImpl.access$7100(TRTCCloudImpl.this, str, paramInt, paramBundle);
        AppMethodBeat.o(15620);
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
        AppMethodBeat.i(15706);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMComplete(paramInt);
        }
        AppMethodBeat.o(15706);
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
        AppMethodBeat.i(15648);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMProgress(paramLong1, this.val$durationMS);
        }
        AppMethodBeat.o(15648);
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
        AppMethodBeat.i(15767);
        TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.this.mBGMNotify;
        if (localBGMNotify != null) {
          localBGMNotify.onBGMStart(0);
        }
        AppMethodBeat.o(15767);
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
    AppMethodBeat.i(222479);
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
    AppMethodBeat.o(222479);
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
        break label237;
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
        if (localTRTCVideoFrame.bufferType == 1)
        {
          if (paramTXSVideoFrame.buffer == null) {
            paramTXSVideoFrame.loadYUVBufferFromGL();
          }
          localTRTCVideoFrame.buffer = paramTXSVideoFrame.buffer;
        }
        for (;;)
        {
          ((TRTCCloudListener.TRTCVideoRenderListener)localObject).onRenderVideoFrame(paramString, i, localTRTCVideoFrame);
          if ((!this.mRoomInfo.enableCustomPreprocessor) || (paramInt == 0)) {
            break label533;
          }
          if (localTRTCVideoFrame.bufferType != 2) {
            break label512;
          }
          paramTXSVideoFrame.data = localTRTCVideoFrame.data;
          AppMethodBeat.o(15908);
          return;
          paramInt = 0;
          break;
          label237:
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
          if (localTRTCVideoFrame.bufferType == 2)
          {
            localTRTCVideoFrame.data = paramTXSVideoFrame.data;
            if (localTRTCVideoFrame.data == null)
            {
              localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2];
              paramTXSVideoFrame.loadYUVArray(localTRTCVideoFrame.data);
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
        if (localTRTCVideoFrame.bufferType == 3) {
          paramTXSVideoFrame.textureId = localTRTCVideoFrame.texture.textureId;
        }
      }
      label512:
      label533:
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
        AppMethodBeat.i(15611);
        TRTCCloudImpl.access$7200(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, Long.valueOf(paramString).longValue(), paramInt);
        AppMethodBeat.o(15611);
      }
    });
    AppMethodBeat.o(15903);
  }
  
  public void onScreenCapturePaused()
  {
    AppMethodBeat.i(222471);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15687);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCapturePaused();
        }
        AppMethodBeat.o(15687);
      }
    });
    AppMethodBeat.o(222471);
  }
  
  public void onScreenCaptureResumed()
  {
    AppMethodBeat.i(222470);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15661);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureResumed();
        }
        AppMethodBeat.o(15661);
      }
    });
    AppMethodBeat.o(222470);
  }
  
  public void onScreenCaptureStarted()
  {
    AppMethodBeat.i(222469);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15752);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureStarted();
        }
        AppMethodBeat.o(15752);
      }
    });
    AppMethodBeat.o(222469);
  }
  
  public void onScreenCaptureStopped(final int paramInt)
  {
    AppMethodBeat.i(222472);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15652);
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onScreenCaptureStopped(paramInt);
        }
        AppMethodBeat.o(15652);
      }
    });
    AppMethodBeat.o(222472);
  }
  
  protected void onSendFirstLocalAudioFrame()
  {
    AppMethodBeat.i(15948);
    runOnListenerThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222407);
        TRTCCloudImpl.this.apiLog("onSendFirstLocalAudioFrame");
        TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalAudioFrame");
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSendFirstLocalAudioFrame();
        }
        AppMethodBeat.o(222407);
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
        AppMethodBeat.i(222448);
        TRTCCloudImpl.this.apiLog("onSendFirstLocalVideoFrame " + paramInt);
        int i = TRTCCloudImpl.access$8100(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.access$7700(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalVideoFrame:".concat(String.valueOf(i)));
        TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
        if (localTRTCCloudListener != null) {
          localTRTCCloudListener.onSendFirstLocalVideoFrame(i);
        }
        AppMethodBeat.o(222448);
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
    AppMethodBeat.i(222484);
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt))
    {
      AppMethodBeat.o(222484);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182408);
        if (paramInt == 2) {
          TRTCCloudImpl.this.mCaptureAndEnc.g(paramBoolean);
        }
        AppMethodBeat.o(182408);
      }
    });
    AppMethodBeat.o(222484);
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(15929);
    onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    AppMethodBeat.o(15929);
  }
  
  public void onVideoQosChanged(TRTCCloudImpl paramTRTCCloudImpl, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final int paramInt7)
  {
    AppMethodBeat.i(222481);
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt1))
    {
      AppMethodBeat.o(222481);
      return;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15626);
        TRTCCloudImpl.this.mCaptureAndEnc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
        if (paramInt1 == 2) {
          if (paramInt2 <= paramInt3) {
            break label115;
          }
        }
        label115:
        for (int i = 0;; i = 1)
        {
          if ((TRTCCloudImpl.this.mConfig.l != i) && (paramInt2 != paramInt3))
          {
            TRTCCloudImpl.this.mConfig.l = i;
            TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
          }
          AppMethodBeat.o(15626);
          return;
        }
      }
    });
    AppMethodBeat.o(222481);
  }
  
  public void pauseAudioEffect(final int paramInt)
  {
    AppMethodBeat.i(182319);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15708);
        TRTCCloudImpl.this.apiLog("pauseAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().pauseEffectWithId(paramInt);
        AppMethodBeat.o(15708);
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
        AppMethodBeat.i(15669);
        TRTCCloudImpl.this.apiLog("pauseBGM");
        TXCLiveBGMPlayer.getInstance().pause();
        AppMethodBeat.o(15669);
      }
    });
    AppMethodBeat.o(15875);
  }
  
  public void pauseScreenCapture()
  {
    AppMethodBeat.i(222462);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15656);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiLog("pause screen capture");
          Monitor.a(1, "pause screen capture self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TRTCCloudImpl.this.mCaptureAndEnc.g();
        }
        AppMethodBeat.o(15656);
      }
    });
    AppMethodBeat.o(222462);
  }
  
  public void playAudioEffect(final TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam)
  {
    AppMethodBeat.i(15885);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15704);
        TRTCCloudImpl.this.apiLog("playAudioEffect -> effectId = " + paramTRTCAudioEffectParam.effectId + " path = " + paramTRTCAudioEffectParam.path + " publish = " + paramTRTCAudioEffectParam.publish + " loopCount = " + paramTRTCAudioEffectParam.loopCount);
        TXCSoundEffectPlayer.getInstance().playEffectWithId(paramTRTCAudioEffectParam.effectId, paramTRTCAudioEffectParam.path, paramTRTCAudioEffectParam.publish, paramTRTCAudioEffectParam.loopCount);
        AppMethodBeat.o(15704);
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
        AppMethodBeat.i(15684);
        TRTCCloudImpl.this.apiLog("playBGM");
        TRTCCloudImpl.access$6202(TRTCCloudImpl.this, paramBGMNotify);
        if (TRTCCloudImpl.this.mBGMNotify != null) {
          TXCLiveBGMPlayer.getInstance().setOnPlayListener(TRTCCloudImpl.this);
        }
        for (;;)
        {
          TXCLiveBGMPlayer.getInstance().startPlay(paramString);
          AppMethodBeat.o(15684);
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
        AppMethodBeat.i(15610);
        TRTCCloudImpl.this.apiLog("resumeAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().resumeEffectWithId(paramInt);
        AppMethodBeat.o(15610);
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
        AppMethodBeat.i(15614);
        TRTCCloudImpl.this.apiLog("resumeBGM");
        TXCLiveBGMPlayer.getInstance().resume();
        AppMethodBeat.o(15614);
      }
    });
    AppMethodBeat.o(15876);
  }
  
  public void resumeScreenCapture()
  {
    AppMethodBeat.i(222463);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15751);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiLog("resume screen capture");
          Monitor.a(1, "resume screen capture self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TRTCCloudImpl.this.mCaptureAndEnc.h();
        }
        AppMethodBeat.o(15751);
      }
    });
    AppMethodBeat.o(222463);
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
    if (this.mSDKHandler != null)
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper())
      {
        this.mSDKHandler.post(paramRunnable);
        AppMethodBeat.o(15953);
        return;
      }
      paramRunnable.run();
    }
    AppMethodBeat.o(15953);
  }
  
  public void selectMotionTmpl(final String paramString)
  {
    AppMethodBeat.i(15844);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15761);
        TRTCCloudImpl.this.apiLog("selectMotionTmpl " + paramString);
        TRTCCloudImpl.this.getBeautyManager().setMotionTmpl(paramString);
        AppMethodBeat.o(15761);
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
          AppMethodBeat.i(15723);
          if (!TRTCCloudImpl.this.mEnableCustomAudioCapture)
          {
            TRTCCloudImpl.this.apiLog("sendCustomAudioData when mEnableCustomAudioCapture is false");
            AppMethodBeat.o(15723);
            return;
          }
          TXCAudioEngine.getInstance().sendCustomPCMData(locala);
          AppMethodBeat.o(15723);
        }
      });
      AppMethodBeat.o(15872);
      return;
    }
  }
  
  public boolean sendCustomCmdMsg(final int paramInt, final byte[] paramArrayOfByte, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(15897);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(15897);
      return false;
    }
    long l;
    boolean bool;
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      if (this.mCurrentRole == 21)
      {
        apiLog("ignore send custom cmd msg for audience");
        AppMethodBeat.o(15897);
        return false;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        TXCLog.e("TRTCCloudImpl", "invalid message data", paramArrayOfByte);
        paramArrayOfByte = null;
      }
      l = System.currentTimeMillis();
      if (this.mLastSendMsgTimeMs == 0L) {
        this.mLastSendMsgTimeMs = l;
      }
      bool = false;
      if (l - this.mLastSendMsgTimeMs >= 1000L) {
        break label212;
      }
    }
    if ((this.mSendMsgCount < 30) && (this.mSendMsgSize < 8192))
    {
      bool = true;
      this.mSendMsgCount += 1;
      this.mSendMsgSize += paramArrayOfByte.length();
    }
    for (;;)
    {
      if (bool) {
        runOnSDKThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15563);
            TRTCCloudImpl.access$6900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2);
            AppMethodBeat.o(15563);
          }
        });
      }
      AppMethodBeat.o(15897);
      return bool;
      TXCLog.e("TRTCCloudImpl", "send msg too more self:" + hashCode());
      continue;
      label212:
      bool = true;
      this.mLastSendMsgTimeMs = l;
      this.mSendMsgCount = 1;
      this.mSendMsgSize = paramArrayOfByte.length();
    }
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15855);
    if (paramTRTCVideoFrame == null)
    {
      apiLog("sendCustomVideoData parameter is null");
      AppMethodBeat.o(15855);
      return;
    }
    if ((paramTRTCVideoFrame.pixelFormat != 1) && (paramTRTCVideoFrame.pixelFormat != 4) && (paramTRTCVideoFrame.pixelFormat != 2))
    {
      apiLog("sendCustomVideoData parameter error unsupported pixel format " + paramTRTCVideoFrame.pixelFormat);
      AppMethodBeat.o(15855);
      return;
    }
    if ((paramTRTCVideoFrame.bufferType != 2) && (paramTRTCVideoFrame.texture == null))
    {
      apiLog("sendCustomVideoData parameter error unsupported buffer type " + paramTRTCVideoFrame.bufferType);
      AppMethodBeat.o(15855);
      return;
    }
    if ((this.mVideoSourceType != VideoSourceType.CUSTOM) || (this.mRoomState != 2) || (this.mRoomInfo.muteLocalVideo))
    {
      AppMethodBeat.o(15855);
      return;
    }
    try
    {
      if (this.mCustomVideoUtil == null) {
        this.mCustomVideoUtil = new TRTCCustomTextureUtil(this.mCaptureAndEnc);
      }
      if (this.mCustomVideoUtil != null) {
        this.mCustomVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
      }
      if (this.mLastCaptureCalculateTS == 0L)
      {
        this.mLastCaptureCalculateTS = System.currentTimeMillis();
        this.mLastCaptureFrameCount = 0L;
        this.mCaptureFrameCount = 0L;
        AppMethodBeat.o(15855);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(15855);
    }
    this.mCaptureFrameCount += 1L;
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
            AppMethodBeat.i(15774);
            TRTCCloudImpl.access$7000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramArrayOfByte, paramInt);
            AppMethodBeat.o(15774);
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
        AppMethodBeat.i(15633);
        TRTCCloudImpl.this.apiLog("setAllAudioEffectsVolume volume = " + paramInt);
        float f = paramInt / 100.0F;
        TXCSoundEffectPlayer.getInstance().setEffectsVolume(f);
        AppMethodBeat.o(15633);
      }
    });
    AppMethodBeat.o(15889);
  }
  
  public void setAudioCaptureVolume(int paramInt)
  {
    int i = 100;
    AppMethodBeat.i(182311);
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 100) {
        paramInt = i;
      }
      for (;;)
      {
        this.mAudioCaptureVolume = paramInt;
        apiLog("setAudioCaptureVolume:  volume=" + this.mAudioCaptureVolume);
        TXAudioEffectManagerImpl.getInstance().setVoiceCaptureVolume(paramInt);
        AppMethodBeat.o(182311);
        return;
      }
    }
  }
  
  public void setAudioEffectVolume(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(15886);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15577);
        TRTCCloudImpl.this.apiLog("setAudioEffectVolume -> effectId = " + paramInt1 + " volume = " + paramInt2);
        float f = paramInt2 / 100.0F;
        TXCSoundEffectPlayer.getInstance().setVolumeOfEffect(paramInt1, f);
        AppMethodBeat.o(15577);
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
        AppMethodBeat.i(15557);
        TRTCCloudImpl.this.apiLog("setAudioFrameListener " + paramTRTCAudioFrameListener);
        TRTCCloudImpl.this.mAudioFrameListener = paramTRTCAudioFrameListener;
        if (TRTCCloudImpl.this.mAudioFrameListener == null)
        {
          TXCAudioEngine.setPlayoutDataListener(null);
          TXCAudioEngine.getInstance().setAudioCaptureDataListener(null);
          TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(222434);
              TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), null);
              AppMethodBeat.o(222434);
            }
          });
          AppMethodBeat.o(15557);
          return;
        }
        TXCAudioEngine.setPlayoutDataListener(jdField_this);
        TXCAudioEngine.getInstance().setAudioCaptureDataListener(jdField_this);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(222424);
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCCloudImpl.116.this.val$refThis);
            AppMethodBeat.o(222424);
          }
        });
        AppMethodBeat.o(15557);
      }
    });
    AppMethodBeat.o(15899);
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    int i = 100;
    AppMethodBeat.i(182312);
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 100) {
        paramInt = i;
      }
      for (;;)
      {
        this.mAudioPlayoutVolume = paramInt;
        apiLog("setAudioPlayoutVolume:  volume=" + this.mAudioPlayoutVolume);
        TXAudioEffectManagerImpl.getInstance().setAudioPlayoutVolume(paramInt);
        AppMethodBeat.o(182312);
        return;
      }
    }
  }
  
  public void setAudioQuality(final int paramInt)
  {
    AppMethodBeat.i(222467);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15730);
        TRTCCloudImpl.this.apiLog("setAudioQuality " + paramInt);
        TXCAudioEngine.getInstance().setAudioQuality(paramInt, 2);
        AppMethodBeat.o(15730);
      }
    });
    AppMethodBeat.o(222467);
  }
  
  public void setAudioRoute(final int paramInt)
  {
    AppMethodBeat.i(15818);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15697);
        TRTCCloudImpl.this.apiLog("setAudioRoute " + paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt == 0) {}
        for (String str = "Speaker";; str = "Earpiece")
        {
          Monitor.a(1, String.format("setAudioRoute route:%s", new Object[] { str }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TXCAudioEngine.setAudioRoute(paramInt);
          AppMethodBeat.o(15697);
          return;
        }
      }
    });
    AppMethodBeat.o(15818);
  }
  
  public void setBGMPlayoutVolume(final int paramInt)
  {
    AppMethodBeat.i(182317);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15690);
        float f = paramInt / 100.0F;
        TRTCCloudImpl.this.apiLog("setBGMPlayoutVolume:" + paramInt + " fVolume:" + f);
        TXCLiveBGMPlayer.getInstance().setPlayoutVolume(f);
        AppMethodBeat.o(15690);
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
        AppMethodBeat.i(15560);
        TRTCCloudImpl.this.apiLog("setBGMPosition " + paramInt);
        TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt);
        AppMethodBeat.o(15560);
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
        AppMethodBeat.i(16061);
        float f = paramInt / 100.0F;
        TRTCCloudImpl.this.apiLog("setBGMPublishVolume " + paramInt);
        TXCLiveBGMPlayer.getInstance().setPublishVolume(f);
        AppMethodBeat.o(16061);
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
        AppMethodBeat.i(15651);
        TRTCCloudImpl.this.apiLog("setBGMVolume " + paramInt);
        float f = paramInt / 100.0F;
        TXCLiveBGMPlayer.getInstance().setVolume(f);
        AppMethodBeat.o(15651);
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
        AppMethodBeat.i(15747);
        TRTCCloudImpl.this.getBeautyManager().setBeautyStyle(paramInt1);
        TRTCCloudImpl.this.getBeautyManager().setBeautyLevel(paramInt2);
        TRTCCloudImpl.this.getBeautyManager().setWhitenessLevel(paramInt3);
        TRTCCloudImpl.this.getBeautyManager().setRuddyLevel(paramInt4);
        AppMethodBeat.o(15747);
      }
    });
    AppMethodBeat.o(15841);
  }
  
  public void setChinLevel(final int paramInt)
  {
    AppMethodBeat.i(15851);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15678);
        TRTCCloudImpl.this.apiLog("setChinLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setChinLevel(paramInt);
        AppMethodBeat.o(15678);
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
        AppMethodBeat.i(15608);
        TRTCCloudImpl.this.apiLog("setDebugViewMargin");
        final TXCloudVideoView localTXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
        if ((localTXCloudVideoView != null) && (paramString.equalsIgnoreCase(localTXCloudVideoView.getUserId()))) {
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222413);
              localTXCloudVideoView.setLogMarginRatio(TRTCCloudImpl.106.this.val$margin.leftMargin, TRTCCloudImpl.106.this.val$margin.rightMargin, TRTCCloudImpl.106.this.val$margin.topMargin, TRTCCloudImpl.106.this.val$margin.bottomMargin);
              AppMethodBeat.o(222413);
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
                AppMethodBeat.i(222409);
                if (localTXCloudVideoView != null) {
                  localTXCloudVideoView.setLogMarginRatio(TRTCCloudImpl.106.this.val$margin.leftMargin, TRTCCloudImpl.106.this.val$margin.rightMargin, TRTCCloudImpl.106.this.val$margin.topMargin, TRTCCloudImpl.106.this.val$margin.bottomMargin);
                }
                if (this.val$remoteSubView != null) {
                  this.val$remoteSubView.setLogMarginRatio(TRTCCloudImpl.106.this.val$margin.leftMargin, TRTCCloudImpl.106.this.val$margin.rightMargin, TRTCCloudImpl.106.this.val$margin.topMargin, TRTCCloudImpl.106.this.val$margin.bottomMargin);
                }
                AppMethodBeat.o(222409);
              }
            });
          }
        }
        AppMethodBeat.o(15608);
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
        AppMethodBeat.i(15709);
        TRTCCloudImpl.this.mRecvMode = 0;
        if ((paramBoolean1) && (paramBoolean2)) {
          TRTCCloudImpl.this.mRecvMode = 1;
        }
        for (;;)
        {
          String str = String.format("setDefaultStreamRecvMode audio:%b, video:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }) + " self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiLog(str);
          Monitor.a(1, str, "", 0);
          AppMethodBeat.o(15709);
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
  
  public void setEyeScaleLevel(final int paramInt)
  {
    AppMethodBeat.i(15847);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15573);
        TRTCCloudImpl.this.apiLog("setEyeScaleLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setEyeScaleLevel(paramInt);
        AppMethodBeat.o(15573);
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
        AppMethodBeat.i(15756);
        TRTCCloudImpl.this.apiLog("setFaceShortLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceShortLevel(paramInt);
        AppMethodBeat.o(15756);
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
        AppMethodBeat.i(15559);
        TRTCCloudImpl.this.apiLog("setFaceSlimLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceSlimLevel(paramInt);
        AppMethodBeat.o(15559);
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
        AppMethodBeat.i(15685);
        TRTCCloudImpl.this.apiLog("setFaceVLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setFaceVLevel(paramInt);
        AppMethodBeat.o(15685);
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
        AppMethodBeat.i(15770);
        TRTCCloudImpl.this.apiLog("setFilter");
        TRTCCloudImpl.this.getBeautyManager().setFilter(paramBitmap);
        AppMethodBeat.o(15770);
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
        AppMethodBeat.i(15586);
        TRTCCloudImpl.this.apiLog("setFilterStrength: " + paramFloat);
        TRTCCloudImpl.this.getBeautyManager().setFilterStrength(paramFloat);
        AppMethodBeat.o(15586);
      }
    });
    AppMethodBeat.o(15843);
  }
  
  public void setFocusPosition(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(15838);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15695);
        TRTCCloudImpl.this.mCaptureAndEnc.b(paramInt1, paramInt2);
        AppMethodBeat.o(15695);
      }
    });
    AppMethodBeat.o(15838);
  }
  
  public void setGSensorMode(final int paramInt)
  {
    AppMethodBeat.i(15810);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15771);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiLog("setGSensorMode has been ignored for screen capturing");
          AppMethodBeat.o(15771);
          return;
        }
        TRTCCloudImpl.access$3002(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.this.apiLog("vrotation setGSensorMode " + paramInt);
        AppMethodBeat.o(15771);
      }
    });
    AppMethodBeat.o(15810);
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(final String paramString)
  {
    AppMethodBeat.i(15846);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15701);
        TRTCCloudImpl.this.apiLog("setGreenScreenFile " + paramString);
        TRTCCloudImpl.this.getBeautyManager().setGreenScreenFile(paramString);
        AppMethodBeat.o(15701);
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
        AppMethodBeat.i(15634);
        TRTCCloudImpl.this.apiLog("setListener " + paramTRTCCloudListener);
        TRTCCloudImpl.this.mTRTCListener = paramTRTCCloudListener;
        AppMethodBeat.o(15634);
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
          AppMethodBeat.i(15578);
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
          AppMethodBeat.o(15578);
        }
      });
      AppMethodBeat.o(15784);
      return;
    }
  }
  
  public int setLocalVideoRenderListener(final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(15869);
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
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
        AppMethodBeat.i(15777);
        TRTCCloudImpl.this.apiLog(String.format("setLocalVideoRenderListener pixelFormat:%d bufferType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        TRTCCloudImpl.this.mRoomInfo.localPixelFormat = paramInt1;
        TRTCCloudImpl.this.mRoomInfo.localBufferType = paramInt2;
        TRTCCloudImpl.this.mRoomInfo.localListener = paramTRTCVideoRenderListener;
        if (paramTRTCVideoRenderListener == null)
        {
          TRTCCloudImpl.this.mCaptureAndEnc.a(null, paramInt1);
          AppMethodBeat.o(15777);
          return;
        }
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this, paramInt1);
        AppMethodBeat.o(15777);
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
        AppMethodBeat.i(15625);
        TRTCCloudImpl.this.apiLog("setLocalViewFillMode " + paramInt);
        TRTCCloudImpl.this.mCaptureAndEnc.f(paramInt);
        AppMethodBeat.o(15625);
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
        AppMethodBeat.i(170190);
        TRTCCloudImpl.access$4202(TRTCCloudImpl.this, paramInt);
        TRTCCloudImpl.this.apiLog("setLocalViewMirror " + paramInt);
        TRTCCloudImpl.this.mCaptureAndEnc.b(paramInt);
        TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
        AppMethodBeat.o(170190);
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
        AppMethodBeat.i(15663);
        TRTCCloudImpl.this.apiLog("vrotation setLocalViewRotation " + paramInt);
        TRTCCloudImpl.this.mRoomInfo.localRenderRotation = (paramInt * 90);
        TRTCCloudImpl.this.mCaptureAndEnc.g(paramInt * 90);
        TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
        AppMethodBeat.o(15663);
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
        AppMethodBeat.i(15621);
        TRTCCloudImpl.this.apiLog("setMicVolume " + paramInt);
        float f = paramInt / 100.0F;
        TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
        AppMethodBeat.o(15621);
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
        AppMethodBeat.i(15757);
        TRTCCloudImpl.this.apiLog("setMixTranscodingConfig " + paramTRTCTranscodingConfig);
        if (paramTRTCTranscodingConfig == null) {
          Monitor.a(1, "cancelLiveMixTranscoding self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        }
        if (paramTRTCTranscodingConfig != null)
        {
          TRTCTranscodingConfigInner localTRTCTranscodingConfigInner = new TRTCTranscodingConfigInner(paramTRTCTranscodingConfig);
          TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, localTRTCTranscodingConfigInner);
          AppMethodBeat.o(15757);
          return;
        }
        TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, null);
        AppMethodBeat.o(15757);
      }
    });
    AppMethodBeat.o(15896);
  }
  
  public void setMotionMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(15845);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15609);
        TRTCCloudImpl.this.apiLog("setMotionMute " + paramBoolean);
        TRTCCloudImpl.this.getBeautyManager().setMotionMute(paramBoolean);
        AppMethodBeat.o(15609);
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
        AppMethodBeat.i(15753);
        if (paramTRTCNetworkQosParam != null)
        {
          TRTCCloudImpl.this.apiLog("setNetworkQosParam");
          TRTCCloudImpl.access$302(TRTCCloudImpl.this, paramTRTCNetworkQosParam.preference);
          TRTCCloudImpl.access$202(TRTCCloudImpl.this, paramTRTCNetworkQosParam.controlMode);
          TRTCCloudImpl.access$400(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
          AppMethodBeat.o(15753);
          return;
        }
        TRTCCloudImpl.this.apiLog("setNetworkQosParam param is null");
        AppMethodBeat.o(15753);
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
        AppMethodBeat.i(15649);
        TRTCCloudImpl.this.apiLog("setNoseSlimLevel " + paramInt);
        TRTCCloudImpl.this.getBeautyManager().setNoseSlimLevel(paramInt);
        AppMethodBeat.o(15649);
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
    if (paramJSONObject.getInt("mode") == 1)
    {
      this.mPerformanceMode = 1;
      this.mCaptureAndEnc.b().enableSharpnessEnhancement(false);
      AppMethodBeat.o(15865);
      return;
    }
    this.mPerformanceMode = 0;
    AppMethodBeat.o(15865);
  }
  
  public int setPriorRemoteVideoStreamType(final int paramInt)
  {
    AppMethodBeat.i(15812);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15582);
        if ((paramInt != 0) && (paramInt == 1)) {}
        for (TRTCCloudImpl.this.mPriorStreamType = 3;; TRTCCloudImpl.this.mPriorStreamType = 2)
        {
          TRTCCloudImpl.this.apiLog("setPriorRemoteVideoStreamType " + TRTCCloudImpl.this.mPriorStreamType);
          AppMethodBeat.o(15582);
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
        int j = 100;
        AppMethodBeat.i(15670);
        int k = paramInt;
        int i = k;
        if (k < 0) {
          i = 0;
        }
        if (i > 100) {
          i = j;
        }
        for (;;)
        {
          TRTCCloudImpl.this.apiLog("setRemoteAudioVolume: userId = " + paramString + " volume = " + i);
          TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
          if (localUserInfo != null) {
            TXCAudioEngine.getInstance().setRemotePlayoutVolume(String.valueOf(localUserInfo.tinyID), i);
          }
          AppMethodBeat.o(15670);
          return;
        }
      }
    });
    AppMethodBeat.o(15822);
  }
  
  public void setRemoteSubStreamViewFillMode(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15798);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15712);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        TRTCCloudImpl.this.apiLog("setSubStreamRemoteViewFillMode->userId: " + paramString + ", fillMode: " + paramInt);
        if ((localUserInfo != null) && (localUserInfo.subRender.render != null)) {
          localUserInfo.subRender.render.setRenderMode(paramInt);
        }
        AppMethodBeat.o(15712);
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
        AppMethodBeat.i(15617);
        TRTCCloudImpl.this.apiLog("setRemoteSubStreamViewRotation->userId: " + paramString + ", rotation: " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.subRender.render != null)) {
          localUserInfo.subRender.render.setRenderRotation(paramInt * 90);
        }
        AppMethodBeat.o(15617);
      }
    });
    AppMethodBeat.o(182309);
  }
  
  public int setRemoteVideoRenderListener(final String paramString, final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(15870);
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
    {
      apiLog("setLocalVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(15870);
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      apiLog("setLocalVideoRenderListener unsupported bufferType : ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(15870);
      return -1328;
    }
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15579);
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
              AppMethodBeat.i(222432);
              TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter;
              if (paramAnonymous2String.equalsIgnoreCase(TRTCCloudImpl.82.this.val$userId))
              {
                localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)TRTCCloudImpl.this.mRenderListenerMap.get(TRTCCloudImpl.82.this.val$userId);
                if (localRenderListenerAdapter != null) {
                  localRenderListenerAdapter.strTinyID = String.valueOf(paramAnonymous2UserInfo.tinyID);
                }
                if (TRTCCloudImpl.82.this.val$listener == null) {
                  break label152;
                }
              }
              label152:
              for (paramAnonymous2String = TRTCCloudImpl.this;; paramAnonymous2String = null)
              {
                if (paramAnonymous2UserInfo.mainRender.render != null) {
                  paramAnonymous2UserInfo.mainRender.render.setVideoFrameListener(paramAnonymous2String, TRTCCloudImpl.access$6100(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
                }
                if (paramAnonymous2UserInfo.subRender.render != null) {
                  paramAnonymous2UserInfo.subRender.render.setVideoFrameListener(paramAnonymous2String, TRTCCloudImpl.access$6100(TRTCCloudImpl.this, localRenderListenerAdapter.pixelFormat));
                }
                AppMethodBeat.o(222432);
                return;
              }
            }
          });
          AppMethodBeat.o(15579);
          return;
          TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = new TRTCCloudImpl.RenderListenerAdapter();
          localRenderListenerAdapter.bufferType = paramInt2;
          localRenderListenerAdapter.pixelFormat = paramInt1;
          localRenderListenerAdapter.listener = paramTRTCVideoRenderListener;
          TRTCCloudImpl.this.mRenderListenerMap.put(paramString, localRenderListenerAdapter);
          TRTCCloudImpl.access$6002(TRTCCloudImpl.this, true);
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
        AppMethodBeat.i(15624);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          AppMethodBeat.o(15624);
          return;
        }
        int i = 2;
        if (paramInt == 1) {
          i = 3;
        }
        if (localUserInfo.streamType == i)
        {
          AppMethodBeat.o(15624);
          return;
        }
        localUserInfo.streamType = i;
        TRTCCloudImpl.this.apiLog("setRemoteVideoStreamType " + paramString + ", " + i + ", " + localUserInfo.tinyID);
        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, i, false);
        AppMethodBeat.o(15624);
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
        AppMethodBeat.i(15601);
        TRTCCloudImpl.this.apiLog("setRemoteViewFillMode " + paramString + ", " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.mainRender.render != null)) {
          localUserInfo.mainRender.render.setRenderMode(paramInt);
        }
        AppMethodBeat.o(15601);
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
        AppMethodBeat.i(15726);
        TRTCCloudImpl.this.apiLog("vrotation setRemoteViewRotation " + paramString + ", " + paramInt);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if ((localUserInfo != null) && (localUserInfo.mainRender.render != null)) {
          localUserInfo.mainRender.render.setRenderRotation(paramInt * 90);
        }
        AppMethodBeat.o(15726);
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
        AppMethodBeat.i(222418);
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
            locale.c(((SurfaceView)localObject).getWidth(), ((SurfaceView)localObject).getHeight());
            AppMethodBeat.o(222418);
            return;
          }
          TRTCCloudImpl.this.apiLog("startRemoteView with surfaceView add callback " + paramRenderInfo);
          AppMethodBeat.o(222418);
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
        AppMethodBeat.o(222418);
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
        AppMethodBeat.i(15719);
        TRTCCloudImpl.this.apiLog("setLocalViewFillMode");
        TXAudioEffectManagerImpl.getInstance().setVoiceReverbType(TRTCCloudImpl.this.reverbTypes[paramInt]);
        AppMethodBeat.o(15719);
      }
    });
    AppMethodBeat.o(15881);
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
  
  public void setSystemVolumeType(final int paramInt)
  {
    AppMethodBeat.i(15823);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15574);
        Monitor.a(1, String.format("setSystemVolumeType type:%d,  auto(0),media(1),VOIP(2)", new Object[] { Integer.valueOf(paramInt) }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt))
        {
          TXCAudioEngine.getInstance();
          TXCAudioEngine.setSystemVolumeType(paramInt);
        }
        AppMethodBeat.o(15574);
      }
    });
    AppMethodBeat.o(15823);
  }
  
  public void setVideoEncoderMirror(final boolean paramBoolean)
  {
    AppMethodBeat.i(15814);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15682);
        TRTCCloudImpl.this.apiLog("setVideoEncoderMirror " + paramBoolean);
        TRTCCloudImpl.this.mConfig.S = paramBoolean;
        TRTCCloudImpl.this.mCaptureAndEnc.f(paramBoolean);
        TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
        AppMethodBeat.o(15682);
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
        AppMethodBeat.i(15748);
        TRTCCloudImpl.access$3200(TRTCCloudImpl.this, paramTRTCVideoEncParam);
        AppMethodBeat.o(15748);
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
        AppMethodBeat.i(15632);
        TRTCCloudImpl.this.apiLog("vrotation setVideoEncoderRotation " + paramInt + ", g sensor mode " + TRTCCloudImpl.this.mSensorMode);
        if (TRTCCloudImpl.this.mSensorMode == 0) {
          TRTCCloudImpl.this.mCaptureAndEnc.a(paramInt * 90);
        }
        AppMethodBeat.o(15632);
      }
    });
    AppMethodBeat.o(15809);
  }
  
  public void setVideoMuteImage(final Bitmap paramBitmap, final int paramInt)
  {
    AppMethodBeat.i(222464);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        int i = 20;
        AppMethodBeat.i(15583);
        TRTCCloudImpl.this.apiLog("setVideoMuteImage " + paramBitmap + ", " + paramInt);
        int j = paramInt;
        if (j > 20) {}
        for (;;)
        {
          TRTCCloudImpl.this.mConfig.A = paramBitmap;
          TRTCCloudImpl.this.mConfig.C = i;
          TRTCCloudImpl.this.mConfig.B = -1;
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          AppMethodBeat.o(15583);
          return;
          if (j < 5) {
            i = 5;
          } else {
            i = j;
          }
        }
      }
    });
    AppMethodBeat.o(222464);
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
        AppMethodBeat.i(15725);
        TXAudioEffectManagerImpl.getInstance().setVoiceChangerType(TRTCCloudImpl.this.voiceChangerTypes[paramInt]);
        AppMethodBeat.o(15725);
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
        AppMethodBeat.i(15660);
        TRTCCloudImpl.this.apiLog("addWatermark stream:" + paramInt);
        if (paramInt != 2)
        {
          TRTCCloudImpl.this.mConfig.E = paramBitmap;
          TRTCCloudImpl.this.mConfig.H = paramFloat1;
          TRTCCloudImpl.this.mConfig.I = paramFloat2;
          TRTCCloudImpl.this.mConfig.J = paramFloat3;
          TRTCCloudImpl.this.mCaptureAndEnc.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        }
        AppMethodBeat.o(15660);
      }
    });
    AppMethodBeat.o(15853);
  }
  
  public void setZoom(final int paramInt)
  {
    AppMethodBeat.i(15834);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15561);
        TRTCCloudImpl.this.apiLog("setZoom " + paramInt);
        TRTCCloudImpl.this.mCaptureAndEnc.i(paramInt);
        AppMethodBeat.o(15561);
      }
    });
    AppMethodBeat.o(15834);
  }
  
  public void showDebugView(final int paramInt)
  {
    AppMethodBeat.i(15890);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15642);
        TRTCCloudImpl.this.apiLog("showDebugView " + paramInt);
        TRTCCloudImpl.this.mDebugType = paramInt;
        final TXCloudVideoView localTXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
        if (localTXCloudVideoView != null) {
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222411);
              localTXCloudVideoView.showVideoDebugLog(TRTCCloudImpl.105.this.val$showType);
              AppMethodBeat.o(222411);
            }
          });
        }
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(final String paramAnonymous2String, final TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(222440);
            paramAnonymous2String = paramAnonymous2UserInfo.mainRender.view;
            paramAnonymous2UserInfo = paramAnonymous2UserInfo.subRender.view;
            if ((paramAnonymous2String != null) || (paramAnonymous2UserInfo != null)) {
              TRTCCloudImpl.this.runOnMainThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222583);
                  if (paramAnonymous2String != null) {
                    paramAnonymous2String.showVideoDebugLog(TRTCCloudImpl.105.this.val$showType);
                  }
                  if (paramAnonymous2UserInfo != null) {
                    paramAnonymous2UserInfo.showVideoDebugLog(TRTCCloudImpl.105.this.val$showType);
                  }
                  AppMethodBeat.o(222583);
                }
              });
            }
            AppMethodBeat.o(222440);
          }
        });
        AppMethodBeat.o(15642);
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
        AppMethodBeat.i(15556);
        if (paramString == null)
        {
          TRTCCloudImpl.this.apiLog("snapshotLocalView");
          TRTCCloudImpl.this.mCaptureAndEnc.a(new com.tencent.liteav.basic.c.o()
          {
            public void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(222402);
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222445);
                  if (TRTCCloudImpl.23.this.val$listener != null) {
                    TRTCCloudImpl.23.this.val$listener.onSnapshotComplete(paramAnonymous2Bitmap);
                  }
                  AppMethodBeat.o(222445);
                }
              });
              AppMethodBeat.o(222402);
            }
          });
          AppMethodBeat.o(15556);
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
          ((com.tencent.liteav.renderer.e)localObject1).a(new com.tencent.liteav.basic.c.o()
          {
            public void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(222573);
              TRTCCloudImpl.this.runOnListenerThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(222395);
                  if (TRTCCloudImpl.23.this.val$listener != null) {
                    TRTCCloudImpl.23.this.val$listener.onSnapshotComplete(paramAnonymous2Bitmap);
                  }
                  AppMethodBeat.o(222395);
                }
              });
              AppMethodBeat.o(222573);
            }
          });
          AppMethodBeat.o(15556);
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
            AppMethodBeat.i(222585);
            if (TRTCCloudImpl.23.this.val$listener != null) {
              TRTCCloudImpl.23.this.val$listener.onSnapshotComplete(null);
            }
            AppMethodBeat.o(222585);
          }
        });
        AppMethodBeat.o(15556);
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
        AppMethodBeat.i(222406);
        TRTCCloudImpl.this.runOnListenerThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222399);
            TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
            if (localTRTCCloudListener == null)
            {
              AppMethodBeat.o(222399);
              return;
            }
            TRTCCloudImpl.this.apiLog("startLocalAudioRecord onWarning:7001");
            localTRTCCloudListener.onWarning(7001, "write file failed when recording audio.", null);
            AppMethodBeat.o(222399);
          }
        });
        AppMethodBeat.o(222406);
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
        AppMethodBeat.i(15607);
        if (TRTCCloudImpl.this.mEnableCustomAudioCapture)
        {
          TRTCCloudImpl.this.apiLog("startLocalAudio when enable custom audio capturing, ignore!!!");
          AppMethodBeat.o(15607);
          return;
        }
        if (TRTCCloudImpl.this.mIsAudioCapturing)
        {
          TRTCCloudImpl.this.apiLog("startLocalAudio when capturing audio, ignore!!!");
          AppMethodBeat.o(15607);
          return;
        }
        if (TRTCCloudImpl.this.mCurrentRole == 21)
        {
          TRTCCloudImpl.this.runOnListenerThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(182299);
              TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
              if (localTRTCCloudListener == null)
              {
                AppMethodBeat.o(182299);
                return;
              }
              localTRTCCloudListener.onWarning(6001, "ignore start local audio,for role audience", null);
              AppMethodBeat.o(182299);
            }
          });
          TRTCCloudImpl.this.apiLog("ignore startLocalAudio,for role audience");
        }
        TRTCCloudImpl.this.apiLog("startLocalAudio");
        Monitor.a(1, "startLocalAudio self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TXCEventRecorderProxy.a("18446744073709551615", 3001, 0L, -1L, "", 0);
        TRTCCloudImpl.access$1402(TRTCCloudImpl.this, true);
        TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
        TRTCCloudImpl.access$4300(TRTCCloudImpl.this);
        TXCAudioEngine.getInstance().enableCaptureEOSMode(TRTCCloudImpl.this.mEnableEosMode);
        TXCAudioEngine.getInstance().enableSoftAEC(TRTCCloudImpl.this.mEnableSoftAEC, TRTCCloudImpl.this.mSoftAECLevel);
        TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
        TXCAudioEngine.getInstance().startLocalAudio(11, false);
        TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
        TXCAudioEngine.getInstance().muteLocalAudio(TRTCCloudImpl.this.mRoomInfo.muteLocalAudio);
        TXCEventRecorderProxy.a("18446744073709551615", 3003, 11L, -1L, "", 0);
        TRTCCloudImpl.this.enableAudioStream(true);
        TXCKeyPointReportProxy.a(40050, 1, 1);
        AppMethodBeat.o(15607);
      }
    });
    AppMethodBeat.o(15815);
  }
  
  public void startLocalPreview(final boolean paramBoolean, final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(15792);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15702);
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
                AppMethodBeat.i(15646);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(15646);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore start local preview,for role audience", null);
                AppMethodBeat.o(15646);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
          }
          localObject2 = new StringBuilder("startLocalPreview front:").append(paramBoolean).append(", view:");
          if (paramTXCloudVideoView == null) {
            break label426;
          }
          localObject1 = Integer.valueOf(paramTXCloudVideoView.hashCode());
          localObject1 = localObject1 + " " + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiLog((String)localObject1);
          Monitor.a(1, (String)localObject1, "", 0);
          TRTCCloudImpl.this.mRoomInfo.localView = paramTXCloudVideoView;
          TRTCCloudImpl.this.mConfig.m = paramBoolean;
          localObject1 = TRTCCloudImpl.this.mConfig;
          if (TRTCCloudImpl.this.mPerformanceMode != 0) {
            break label432;
          }
          bool = true;
          label200:
          ((g)localObject1).W = bool;
          localObject1 = TRTCCloudImpl.this.mConfig;
          if (TRTCCloudImpl.this.mPerformanceMode != 1) {
            break label437;
          }
          bool = true;
          label226:
          ((g)localObject1).U = bool;
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
          TXCKeyPointReportProxy.a(40046, 1, 2);
          TRTCCloudImpl.this.mOrientationEventListener.enable();
          TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
          TRTCCloudImpl.this.enableVideoStream(true);
          if (paramTXCloudVideoView == null) {
            break label442;
          }
          localObject1 = paramTXCloudVideoView.getSurfaceView();
          label295:
          if (localObject1 == null) {
            break label459;
          }
          if ((i != 0) || (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)) {
            break label447;
          }
          TRTCCloudImpl.access$1502(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.CAMERA);
          TRTCCloudImpl.this.mCaptureAndEnc.a(null);
        }
        for (;;)
        {
          localObject2 = new Surface[1];
          final com.tencent.liteav.basic.util.d locald = new com.tencent.liteav.basic.util.d();
          TRTCCloudImpl.access$2100(TRTCCloudImpl.this, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222571);
              if (this.val$surfaceView != null)
              {
                SurfaceHolder localSurfaceHolder = this.val$surfaceView.getHolder();
                localSurfaceHolder.removeCallback(TRTCCloudImpl.this);
                localSurfaceHolder.addCallback(TRTCCloudImpl.this);
                if (!localSurfaceHolder.getSurface().isValid()) {
                  break label285;
                }
                TRTCCloudImpl.this.apiLog("startLocalPreview with valid surface " + localSurfaceHolder.getSurface() + " width " + this.val$surfaceView.getWidth() + ", height " + this.val$surfaceView.getHeight());
                this.val$surface[0] = localSurfaceHolder.getSurface();
                locald.a = this.val$surfaceView.getWidth();
                locald.b = this.val$surfaceView.getHeight();
              }
              for (;;)
              {
                if (TRTCCloudImpl.14.this.val$view != null)
                {
                  TRTCCloudImpl.14.this.val$view.showVideoDebugLog(TRTCCloudImpl.this.mDebugType);
                  if (TRTCCloudImpl.this.mRoomInfo.debugMargin != null) {
                    TRTCCloudImpl.14.this.val$view.setLogMarginRatio(TRTCCloudImpl.this.mRoomInfo.debugMargin.leftMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.rightMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.topMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.bottomMargin);
                  }
                }
                AppMethodBeat.o(222571);
                return;
                label285:
                TRTCCloudImpl.this.apiLog("startLocalPreview with surfaceView add callback");
              }
            }
          });
          if (localObject2[0] != null)
          {
            TRTCCloudImpl.this.mCaptureAndEnc.a(localObject2[0]);
            TRTCCloudImpl.this.mCaptureAndEnc.a(locald.a, locald.b);
          }
          AppMethodBeat.o(15702);
          return;
          i = 0;
          break;
          label426:
          localObject1 = "";
          break label111;
          label432:
          bool = false;
          break label200;
          label437:
          bool = false;
          break label226;
          label442:
          localObject1 = null;
          break label295;
          label447:
          TRTCCloudImpl.this.apiLog("startLocalPreview with surface view when is started");
          continue;
          label459:
          if ((i == 0) && (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.NONE))
          {
            TRTCCloudImpl.access$1502(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.CAMERA);
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
        AppMethodBeat.i(15705);
        TRTCCloudImpl.this.apiLog("startPublishCDNStream");
        TRTCCloudImpl.access$6500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramTRTCPublishCDNParam);
        AppMethodBeat.o(15705);
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
        AppMethodBeat.i(15655);
        TRTCCloudImpl.this.apiLog("startPublishing streamId:" + paramString + ", streamType:" + paramInt);
        if (paramInt == 2) {
          i = 7;
        }
        TRTCCloudImpl.access$6800(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramString, i);
        AppMethodBeat.o(15655);
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
        AppMethodBeat.i(15585);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user is not exist save view" + paramString);
          localUserInfo = TRTCCloudImpl.access$2200(TRTCCloudImpl.this, paramString);
          localUserInfo.subRender.view = paramTXCloudVideoView;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
          AppMethodBeat.o(15585);
          return;
        }
        if ((paramTXCloudVideoView != null) && (paramTXCloudVideoView.equals(localUserInfo.subRender.view)))
        {
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user view is the same, ignore " + paramString);
          AppMethodBeat.o(15585);
          return;
        }
        if (localUserInfo.subRender.view != null) {}
        for (int i = 1;; i = 0)
        {
          localUserInfo.subRender.view = paramTXCloudVideoView;
          if (localUserInfo.subRender.tinyID != 0L) {
            break;
          }
          TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user tinyID is 0, ignore " + paramString);
          AppMethodBeat.o(15585);
          return;
        }
        TRTCCloudImpl.this.setRenderView(paramString, localUserInfo.subRender, paramTXCloudVideoView, localUserInfo.debugMargin);
        TRTCCloudImpl localTRTCCloudImpl = TRTCCloudImpl.this;
        String str = paramString;
        long l = localUserInfo.tinyID;
        if (paramTXCloudVideoView != null) {}
        for (int j = paramTXCloudVideoView.hashCode();; j = 0)
        {
          localTRTCCloudImpl.apiLog(String.format("startRemoteSubStreamView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { str, Long.valueOf(l), Integer.valueOf(7), Integer.valueOf(j) }));
          Monitor.a(1, String.format("startRemoteSubStreamView userID:%s", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TRTCCloudImpl.access$2300(TRTCCloudImpl.this, String.valueOf(localUserInfo.tinyID), 7, 0, "Start watching " + paramString);
          TXCKeyPointReportProxy.a(String.valueOf(localUserInfo.tinyID), 40021, 0L, 7);
          if ((i == 0) || (!localUserInfo.subRender.render.isRendering())) {
            TRTCCloudImpl.access$2400(TRTCCloudImpl.this, localUserInfo.subRender.render, 7);
          }
          if (!localUserInfo.subRender.muteVideo) {
            TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, 7, true);
          }
          AppMethodBeat.o(15585);
          return;
        }
      }
    });
    AppMethodBeat.o(15796);
  }
  
  public void startRemoteView(final String paramString, final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(15794);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15639);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("startRemoteView user is not exist save view" + paramString);
          localUserInfo = TRTCCloudImpl.access$2200(TRTCCloudImpl.this, paramString);
          localUserInfo.mainRender.view = paramTXCloudVideoView;
          TRTCCloudImpl.this.mRoomInfo.addUserInfo(paramString, localUserInfo);
          Monitor.a(1, String.format("Remote-startRemoteView userID:%s (save view before user enter)", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          AppMethodBeat.o(15639);
          return;
        }
        if ((paramTXCloudVideoView != null) && (paramTXCloudVideoView.equals(localUserInfo.mainRender.view)))
        {
          TRTCCloudImpl.this.apiLog("startRemoteView user view is the same, ignore " + paramString);
          AppMethodBeat.o(15639);
          return;
        }
        if (localUserInfo.mainRender.view != null) {}
        for (int i = 1;; i = 0)
        {
          localUserInfo.mainRender.view = paramTXCloudVideoView;
          if (localUserInfo.mainRender.tinyID != 0L) {
            break;
          }
          TRTCCloudImpl.this.apiLog("startRemoteView user tinyID is 0, ignore " + paramString);
          AppMethodBeat.o(15639);
          return;
        }
        TRTCCloudImpl.this.setRenderView(paramString, localUserInfo.mainRender, paramTXCloudVideoView, localUserInfo.debugMargin);
        Object localObject = new StringBuilder();
        String str = paramString;
        long l = localUserInfo.tinyID;
        int k = localUserInfo.streamType;
        int j;
        if (paramTXCloudVideoView != null)
        {
          j = paramTXCloudVideoView.hashCode();
          localObject = String.format("Remote-startRemoteView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { str, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(j) }) + " self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiLog((String)localObject);
          Monitor.a(1, (String)localObject, "", 0);
          TRTCCloudImpl.access$2300(TRTCCloudImpl.this, String.valueOf(localUserInfo.tinyID), localUserInfo.streamType, 0, "Start watching " + paramString);
          if ((i == 0) || (!localUserInfo.mainRender.render.isRendering())) {
            TRTCCloudImpl.access$2400(TRTCCloudImpl.this, localUserInfo.mainRender.render, localUserInfo.streamType);
          }
          TXCKeyPointReportProxy.a(String.valueOf(localUserInfo.tinyID), 40021, 0L, localUserInfo.streamType);
          if (localUserInfo.mainRender.muteVideo) {
            break label600;
          }
          TRTCCloudImpl.access$2500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, localUserInfo.streamType, true);
        }
        for (;;)
        {
          TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4015, 1L, -1L, "", 0);
          AppMethodBeat.o(15639);
          return;
          j = 0;
          break;
          label600:
          TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, localUserInfo.tinyID, localUserInfo.streamType, true);
        }
      }
    });
    AppMethodBeat.o(15794);
  }
  
  public void startScreenCapture(final TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    AppMethodBeat.i(222458);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15671);
        if (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.NONE)
        {
          TRTCCloudImpl.access$2900(TRTCCloudImpl.this, "Has started capturing, ignore startScreenCapture");
          AppMethodBeat.o(15671);
          return;
        }
        TRTCCloudImpl.access$1502(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.SCREEN);
        TRTCCloudImpl.access$3002(TRTCCloudImpl.this, 0);
        TRTCCloudImpl.this.mOrientationEventListener.disable();
        Object localObject;
        if (paramTRTCVideoEncParam != null)
        {
          TRTCCloudImpl.access$3102(TRTCCloudImpl.this, false);
          TRTCCloudImpl.access$3200(TRTCCloudImpl.this, paramTRTCVideoEncParam);
          if (TRTCCloudImpl.this.mCurrentRole == 21)
          {
            TRTCCloudImpl.this.runOnListenerThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(222582);
                TRTCCloudListener localTRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (localTRTCCloudListener == null)
                {
                  AppMethodBeat.o(222582);
                  return;
                }
                localTRTCCloudListener.onWarning(6001, "ignore start local preview,for role audience", null);
                AppMethodBeat.o(222582);
              }
            });
            TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
          }
          localObject = "start screen capture self:" + TRTCCloudImpl.this.hashCode();
          TRTCCloudImpl.this.apiLog((String)localObject);
          Monitor.a(1, (String)localObject, "", 0);
          TRTCCloudImpl.this.mCaptureAndEnc.a(0);
          if ((TRTCCloudImpl.this.mConfig.l != 1) && (TRTCCloudImpl.this.mConfig.l != 3)) {
            break label422;
          }
          TRTCCloudImpl.access$3300(TRTCCloudImpl.this, true, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.b, TRTCCloudImpl.this.mConfig.h, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.e);
        }
        for (;;)
        {
          localObject = TRTCCloudImpl.access$3400(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
          TRTCCloudImpl.access$3500(TRTCCloudImpl.this, ((g.a)localObject).a, ((g.a)localObject).b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
          TRTCCloudImpl.this.mRoomInfo.localView = null;
          TRTCCloudImpl.this.enableVideoStream(true);
          TXCKeyPointReportProxy.a(40046, 1, 7);
          TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this);
          TRTCCloudImpl.this.runOnMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222408);
              if (TRTCCloudImpl.24.this.val$screenShareParams != null) {
                TRTCCloudImpl.access$3600(TRTCCloudImpl.this, TRTCCloudImpl.24.this.val$screenShareParams.floatingView);
              }
              AppMethodBeat.o(222408);
            }
          });
          AppMethodBeat.o(15671);
          return;
          TRTCCloudImpl.access$3102(TRTCCloudImpl.this, true);
          break;
          label422:
          TRTCCloudImpl.access$3300(TRTCCloudImpl.this, false, TRTCCloudImpl.this.mConfig.b, TRTCCloudImpl.this.mConfig.a, TRTCCloudImpl.this.mConfig.h, TRTCCloudImpl.this.mConfig.c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.e);
        }
      }
    });
    AppMethodBeat.o(222458);
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
        AppMethodBeat.i(15615);
        TRTCCloudImpl.this.apiLog("startSpeedTest");
        TRTCCloudImpl.access$6300(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt, paramString1, paramString2);
        AppMethodBeat.o(15615);
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
      if (this.mVolumeLevelNotifyTask == null)
      {
        this.mVolumeLevelNotifyTask = new VolumeLevelNotifyTask(this);
        this.mSDKHandler.postDelayed(this.mVolumeLevelNotifyTask, this.mAudioVolumeEvalInterval);
        AppMethodBeat.o(15828);
      }
    }
    else
    {
      this.mVolumeLevelNotifyTask = null;
      this.mAudioVolumeEvalInterval = 0;
    }
    AppMethodBeat.o(15828);
  }
  
  public void stopAllAudioEffects()
  {
    AppMethodBeat.i(15888);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15571);
        TRTCCloudImpl.this.apiLog("stopAllAudioEffects");
        TXCSoundEffectPlayer.getInstance().stopAllEffect();
        AppMethodBeat.o(15571);
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
        AppMethodBeat.i(15587);
        TRTCCloudImpl.this.apiLog("stopAllRemoteView");
        Monitor.a(1, "stopAllRemoteView self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(182412);
            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, paramAnonymous2UserInfo, Boolean.TRUE);
            TRTCCloudImpl.access$2800(TRTCCloudImpl.this, paramAnonymous2UserInfo);
            paramAnonymous2UserInfo.mainRender.view = null;
            paramAnonymous2UserInfo.subRender.view = null;
            AppMethodBeat.o(182412);
          }
        });
        AppMethodBeat.o(15587);
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
        AppMethodBeat.i(15699);
        TRTCCloudImpl.this.apiLog("stopAudioEffect -> effectId = " + paramInt);
        TXCSoundEffectPlayer.getInstance().stopEffectWithId(paramInt);
        AppMethodBeat.o(15699);
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
        AppMethodBeat.i(15570);
        TRTCCloudImpl.this.apiLog("stopBGM");
        TXCLiveBGMPlayer.getInstance().stopPlay();
        TRTCCloudImpl.access$6202(TRTCCloudImpl.this, null);
        AppMethodBeat.o(15570);
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
        AppMethodBeat.i(15703);
        if (!TRTCCloudImpl.this.mIsAudioCapturing)
        {
          TRTCCloudImpl.this.apiLog("stopLocalAudio when no capturing audio, ignore!!!");
          AppMethodBeat.o(15703);
          return;
        }
        TRTCCloudImpl.this.apiLog("stopLocalAudio");
        Monitor.a(1, "stopLocalAudio self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TXCEventRecorderProxy.a("18446744073709551615", 3001, 2L, -1L, "", 0);
        TRTCCloudImpl.access$1402(TRTCCloudImpl.this, false);
        TXCAudioEngine.getInstance().stopLocalAudio();
        TRTCCloudImpl.this.enableAudioStream(false);
        TXCKeyPointReportProxy.a(40050, 0, 1);
        AppMethodBeat.o(15703);
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
        AppMethodBeat.i(15766);
        Object localObject = "stopLocalPreview self:" + TRTCCloudImpl.this.hashCode();
        TRTCCloudImpl.this.apiLog((String)localObject);
        Monitor.a(1, (String)localObject, "", 0);
        if (TRTCCloudImpl.this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.CAMERA)
        {
          TRTCCloudImpl.access$1502(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.NONE);
          TRTCCloudImpl.this.mCaptureAndEnc.c(true);
        }
        if (TRTCCloudImpl.this.mRoomInfo.localView != null)
        {
          localObject = TRTCCloudImpl.this.mRoomInfo.localView.getSurfaceView();
          if (localObject != null) {
            TRTCCloudImpl.this.runOnMainThread(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(15689);
                this.val$surfaceView.getHolder().removeCallback(TRTCCloudImpl.this);
                AppMethodBeat.o(15689);
              }
            });
          }
        }
        TRTCCloudImpl.this.mRoomInfo.localView = null;
        TRTCCloudImpl.this.mOrientationEventListener.disable();
        TRTCCloudImpl.this.enableVideoStream(false);
        TXCKeyPointReportProxy.a(40046, 0, 2);
        AppMethodBeat.o(15766);
      }
    });
    AppMethodBeat.o(15793);
  }
  
  public void stopPublishCDNStream()
  {
    AppMethodBeat.i(15895);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15760);
        TRTCCloudImpl.this.apiLog("stopPublishCDNStream");
        TRTCCloudImpl.access$6700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15760);
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
        AppMethodBeat.i(15696);
        TRTCCloudImpl.this.apiLog("stopPublishing");
        TRTCCloudImpl.access$6600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15696);
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
    TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramUserInfo.tinyID));
    final TXCloudVideoView localTXCloudVideoView1 = paramUserInfo.mainRender.view;
    final TXCloudVideoView localTXCloudVideoView2 = paramUserInfo.subRender.view;
    if (paramUserInfo.mainRender.render != null)
    {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
      paramUserInfo.mainRender.render.stop();
      if ((localTXCloudVideoView1 == null) && (paramUserInfo.mainRender.render.getVideoRender() != null)) {
        paramUserInfo.mainRender.render.getVideoRender().e();
      }
    }
    if (paramUserInfo.subRender.render != null)
    {
      paramUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
      paramUserInfo.subRender.render.stop();
      if ((localTXCloudVideoView2 == null) && (paramUserInfo.subRender.render.getVideoRender() != null)) {
        paramUserInfo.subRender.render.getVideoRender().e();
      }
    }
    paramUserInfo.mainRender.stop();
    paramUserInfo.subRender.stop();
    runOnMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222427);
        if (localTXCloudVideoView1 != null) {
          localTXCloudVideoView1.removeVideoView();
        }
        if (localTXCloudVideoView2 != null) {
          localTXCloudVideoView2.removeVideoView();
        }
        AppMethodBeat.o(222427);
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
        AppMethodBeat.i(15683);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("stopRemoteSubStreamView user is not exist " + paramString);
          AppMethodBeat.o(15683);
          return;
        }
        TRTCCloudImpl.this.apiLog(String.format("stopRemoteSubStreamView userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(localUserInfo.tinyID), Integer.valueOf(localUserInfo.streamType) }));
        Monitor.a(1, String.format("stopRemoteSubStreamView userID:%s", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TRTCCloudImpl.access$2800(TRTCCloudImpl.this, localUserInfo);
        final TXCloudVideoView localTXCloudVideoView = localUserInfo.subRender.view;
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222423);
            if (localTXCloudVideoView != null) {
              localTXCloudVideoView.removeVideoView();
            }
            AppMethodBeat.o(222423);
          }
        });
        localUserInfo.subRender.view = null;
        AppMethodBeat.o(15683);
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
        AppMethodBeat.i(15612);
        TRTCRoomInfo.UserInfo localUserInfo = TRTCCloudImpl.this.mRoomInfo.getUser(paramString);
        if (localUserInfo == null)
        {
          TRTCCloudImpl.this.apiLog("stopRemoteRender user is not exist " + paramString);
          AppMethodBeat.o(15612);
          return;
        }
        TRTCCloudImpl.this.apiLog(String.format("stopRemoteView userID:%s tinyID:%d streamType:%d", new Object[] { paramString, Long.valueOf(localUserInfo.tinyID), Integer.valueOf(localUserInfo.streamType) }));
        Monitor.a(1, String.format("stopRemoteView userID:%s", new Object[] { paramString }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
        TXCEventRecorderProxy.a(String.valueOf(localUserInfo.tinyID), 4015, 0L, -1L, "", 0);
        TRTCCloudImpl.access$2700(TRTCCloudImpl.this, localUserInfo, Boolean.FALSE);
        final TXCloudVideoView localTXCloudVideoView = localUserInfo.mainRender.view;
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222405);
            if (localTXCloudVideoView != null) {
              localTXCloudVideoView.removeVideoView();
            }
            AppMethodBeat.o(222405);
          }
        });
        localUserInfo.mainRender.view = null;
        AppMethodBeat.o(15612);
      }
    });
    AppMethodBeat.o(15795);
  }
  
  public void stopScreenCapture()
  {
    AppMethodBeat.i(222460);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15643);
        if (TRTCCloudImpl.this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.SCREEN)
        {
          TRTCCloudImpl.this.apiLog("stopScreenCapture been ignored for Screen capture is not started");
          AppMethodBeat.o(15643);
          return;
        }
        TRTCCloudImpl.access$1502(TRTCCloudImpl.this, TRTCCloudImpl.VideoSourceType.NONE);
        String str = "stopScreenCapture self:" + TRTCCloudImpl.this.hashCode();
        TRTCCloudImpl.this.apiLog(str);
        Monitor.a(1, str, "", 0);
        TRTCCloudImpl.this.runOnMainThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222441);
            TRTCCloudImpl.access$3700(TRTCCloudImpl.this);
            AppMethodBeat.o(222441);
          }
        });
        TRTCCloudImpl.this.mCaptureAndEnc.l();
        TRTCCloudImpl.this.mRoomInfo.localView = null;
        TRTCCloudImpl.this.enableVideoStream(false);
        TXCKeyPointReportProxy.a(40046, 0, 7);
        TRTCCloudImpl.this.mConfig.h = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt("config_fps", TRTCCloudImpl.this.mConfig.h);
        TRTCCloudImpl.this.mConfig.i = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt("config_gop", TRTCCloudImpl.this.mConfig.i);
        TRTCCloudImpl.this.mConfig.p = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getBoolean("config_adjust_resolution", TRTCCloudImpl.this.mConfig.p);
        TRTCCloudImpl.this.mSmallEncParam.videoFps = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getInt("config_fps", TRTCCloudImpl.this.mSmallEncParam.videoFps);
        TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getBoolean("config_adjust_resolution", TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes);
        TXCLog.i("TRTCCloudImpl", String.format(Locale.ENGLISH, "restore big encoder's fps: %d, gop: %d, small encoder's fps: %d", new Object[] { Integer.valueOf(TRTCCloudImpl.this.mConfig.h), Integer.valueOf(TRTCCloudImpl.this.mConfig.i), Integer.valueOf(TRTCCloudImpl.this.mSmallEncParam.videoFps) }));
        AppMethodBeat.o(15643);
      }
    });
    AppMethodBeat.o(222460);
  }
  
  public void stopSpeedTest()
  {
    AppMethodBeat.i(15893);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15581);
        TRTCCloudImpl.this.apiLog("stopSpeedTest");
        TRTCCloudImpl.access$6400(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
        AppMethodBeat.o(15581);
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
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15772);
        g localg = TRTCCloudImpl.this.mConfig;
        if (!TRTCCloudImpl.this.mConfig.m) {}
        for (boolean bool = true;; bool = false)
        {
          localg.m = bool;
          TRTCCloudImpl.this.mCaptureAndEnc.k();
          TRTCCloudImpl.this.apiLog("switchCamera " + TRTCCloudImpl.this.mConfig.m);
          TRTCCloudImpl.access$2000(TRTCCloudImpl.this);
          AppMethodBeat.o(15772);
          return;
        }
      }
    });
    AppMethodBeat.o(15832);
  }
  
  public void switchRole(final int paramInt)
  {
    AppMethodBeat.i(15791);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15691);
        TRTCCloudImpl.this.apiLog("switchRole:" + paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt == 20) {}
        for (String str = "Anchor";; str = "Audience")
        {
          Monitor.a(1, String.format("switchRole:%s", new Object[] { str }) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
          TRTCCloudImpl.this.mTargetRole = paramInt;
          TRTCCloudImpl.access$1800(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, paramInt);
          AppMethodBeat.o(15691);
          return;
        }
      }
    });
    AppMethodBeat.o(15791);
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
    apiLog(String.format("update appScene[%d] for video enc[%d] source scene[%d]", new Object[] { Integer.valueOf(this.mAppScene), Integer.valueOf(this.mConfig.j), Integer.valueOf(paramInt) }));
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
        int i = TRTCCloudImpl.access$9200(localTRTCCloudImpl);
        if (this.mCurrentDisplayRotation != i)
        {
          this.mCurrentDisplayRotation = i;
          TRTCCloudImpl.access$9300(localTRTCCloudImpl, this.mCurOrientation);
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
              this.mCurrentDisplayRotation = TRTCCloudImpl.access$9200((TRTCCloudImpl)localObject);
              TRTCCloudImpl.access$9300((TRTCCloudImpl)localObject, this.mCurOrientation);
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
      int j = com.tencent.liteav.basic.util.f.e(localTRTCCloudImpl.mContext);
      int[] arrayOfInt = com.tencent.liteav.basic.util.f.a();
      int i = com.tencent.liteav.basic.util.f.b();
      TXCStatus.a("18446744073709551615", 11006, Integer.valueOf(j));
      TXCStatus.a("18446744073709551615", 11001, Integer.valueOf(arrayOfInt[0] / 10));
      TXCStatus.a("18446744073709551615", 11002, Integer.valueOf(arrayOfInt[1] / 10));
      TXCStatus.a("18446744073709551615", 11003, Integer.valueOf(i * 1024));
      long l;
      if (com.tencent.liteav.basic.util.f.a(localTRTCCloudImpl.mContext))
      {
        TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(1));
        i = 1;
        if (localTRTCCloudImpl.mNetType != j)
        {
          if ((localTRTCCloudImpl.mNetType >= 0) && (j > 0)) {
            TRTCCloudImpl.access$8500(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, 100);
          }
          if (j != 0) {
            break label420;
          }
          l = 0L;
          label181:
          TXCEventRecorderProxy.a("18446744073709551615", 1003, l, -1L, "", 0);
          Monitor.a(2, String.format("network switch from:%d to %d", new Object[] { Integer.valueOf(localTRTCCloudImpl.mNetType), Integer.valueOf(j) }) + " self:" + localTRTCCloudImpl.hashCode(), "1:wifi/2:4G/3:3G/4:2G/5:Cable", 0);
          TRTCCloudImpl.access$8402(localTRTCCloudImpl, j);
          TXCKeyPointReportProxy.a(40039, j, 0);
        }
        if (localTRTCCloudImpl.mBackground != i)
        {
          TXCEventRecorderProxy.a("18446744073709551615", 2001, i, -1L, "", 0);
          TRTCCloudImpl.access$8602(localTRTCCloudImpl, i);
          if (i != 0) {
            break label426;
          }
          Monitor.a(1, "onAppDidBecomeActive self:" + localTRTCCloudImpl.hashCode(), "", 0);
        }
      }
      for (;;)
      {
        TXCKeyPointReportProxy.c(50001, i);
        TXCKeyPointReportProxy.a(arrayOfInt[0] / 10, arrayOfInt[1] / 10);
        TXCKeyPointReportProxy.a();
        TRTCCloudImpl.access$8700(localTRTCCloudImpl);
        localTRTCCloudImpl.checkDashBoard();
        TRTCCloudImpl.access$8800(localTRTCCloudImpl);
        localTRTCCloudImpl.startCollectStatus();
        if (localTRTCCloudImpl.mSensorMode != 0) {
          localTRTCCloudImpl.mOrientationEventListener.checkOrientation();
        }
        AppMethodBeat.o(15728);
        return;
        TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(0));
        i = 0;
        break;
        label420:
        l = j;
        break label181;
        label426:
        Monitor.a(1, "onAppEnterBackground self:" + localTRTCCloudImpl.hashCode(), "", 0);
      }
    }
  }
  
  static enum VideoSourceType
  {
    static
    {
      AppMethodBeat.i(222431);
      NONE = new VideoSourceType("NONE", 0);
      CAMERA = new VideoSourceType("CAMERA", 1);
      SCREEN = new VideoSourceType("SCREEN", 2);
      CUSTOM = new VideoSourceType("CUSTOM", 3);
      $VALUES = new VideoSourceType[] { NONE, CAMERA, SCREEN, CUSTOM };
      AppMethodBeat.o(222431);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl
 * JD-Core Version:    0.7.0.1
 */