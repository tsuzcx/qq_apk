package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TXCAudioEngine
  implements com.tencent.liteav.audio.impl.b, com.tencent.liteav.audio.impl.earmonitor.a
{
  private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
  private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
  private static final long SYSTEM_AUDIO_KIT_RESTART_INTERVAL;
  private static final String TAG = "AudioEngine :TXCAudioEngine_java";
  private static volatile boolean has_init;
  private static boolean has_trae;
  private static WeakReference<f> mAudioCoreDataListener;
  protected static Context mContext;
  protected static final HashMap<String, WeakReference<f>> mJitterDataListenerMap;
  private static final Object mJitterDataListenerMapLock;
  protected static final HashMap<String, WeakReference<d>> mJitterEventListenerMap;
  private static final Object mJitterEventListenerMapLock;
  static TXCAudioEngine sInstance;
  private TXSystemAudioKit mAudioKit;
  private final ArrayList<WeakReference<com.tencent.liteav.basic.c.a>> mCallbackList;
  protected boolean mDeviceIsRecording;
  protected boolean mIsCallComed;
  protected boolean mIsCustomRecord;
  private final Object mStartStopRemoteAudioMutex;
  
  static
  {
    AppMethodBeat.i(246196);
    SYSTEM_AUDIO_KIT_RESTART_INTERVAL = TimeUnit.SECONDS.toMillis(2L);
    sInstance = new TXCAudioEngine();
    mContext = null;
    has_trae = false;
    mAudioCoreDataListener = null;
    mJitterDataListenerMap = new HashMap();
    mJitterDataListenerMapLock = new Object();
    mJitterEventListenerMap = new HashMap();
    mJitterEventListenerMapLock = new Object();
    has_init = false;
    AppMethodBeat.o(246196);
  }
  
  private TXCAudioEngine()
  {
    AppMethodBeat.i(246080);
    this.mCallbackList = new ArrayList();
    this.mDeviceIsRecording = false;
    this.mIsCustomRecord = false;
    this.mStartStopRemoteAudioMutex = new Object();
    this.mIsCallComed = false;
    AppMethodBeat.o(246080);
  }
  
  public static void CreateInstance(Context paramContext, String paramString)
  {
    try
    {
      AppMethodBeat.i(246081);
      CreateInstanceWithoutInitDevice(paramContext, paramString);
      TXCAudioEngineJNI.nativeInitAudioDevice();
      AppMethodBeat.o(246081);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void CreateInstanceWithoutInitDevice(Context paramContext, String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(246085);
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance: ");
        mContext = paramContext.getApplicationContext();
        if (has_init)
        {
          TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance already created~ ");
          AppMethodBeat.o(246085);
          return;
        }
        if (TXCAudioEngineJNI.nativeCheckTraeEngine(paramContext)) {
          has_trae = true;
        }
        if (!has_trae)
        {
          TXCAudioEngineJNI.nativeUseSysAudioDevice(bool);
          if (!has_trae) {
            break label133;
          }
          TXCAudioEngineJNI.InitTraeEngineLibrary(paramContext);
          TXCAudioEngineJNI.nativeSetTRAEConfig(paramString);
          TXCAudioEngineJNI.nativeInitBeforeEngineCreate(paramContext);
          com.tencent.liteav.audio.impl.a.a().a(paramContext.getApplicationContext());
          com.tencent.liteav.audio.impl.a.a().a(sInstance);
          TXCAudioEngineJNI.nativeNewAudioSessionDuplicate(mContext);
          has_init = true;
          AppMethodBeat.o(246085);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label133:
      TXCMultAudioTrackPlayer.getInstance();
      TXCAudioSysRecord.getInstance();
    }
  }
  
  public static String buildTRAEConfig(Context paramContext, Boolean paramBoolean, boolean paramBoolean1, long paramLong)
  {
    AppMethodBeat.i(246184);
    Object localObject = "" + "sharp {\n";
    localObject = (String)localObject + "  os android\n";
    localObject = (String)localObject + "  trae {\n";
    String str = (String)localObject + "    dev {\n";
    localObject = str;
    if (paramBoolean != null)
    {
      localObject = new StringBuilder().append(str).append("  closeOpensl ");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = "n";
        localObject = paramBoolean + "\n";
      }
    }
    else
    {
      long l = b.a().b("timestamp_rollback_to_stable_samplerate", 0L);
      if (System.currentTimeMillis() - l >= paramLong) {
        break label457;
      }
    }
    label457:
    for (boolean bool = true;; bool = false)
    {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "low latency samplerate, enable: %b, isBlocked: %b, blockTime: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Long.valueOf(paramLong) });
      paramBoolean = (Boolean)localObject;
      if (!bool)
      {
        paramBoolean = (Boolean)localObject;
        if (paramBoolean1)
        {
          paramBoolean = (Boolean)localObject;
          if (getLowLatencySampleRate(paramContext) == 48000)
          {
            paramContext = (String)localObject + "  traemodes 1|2\n";
            paramContext = paramContext + "  cap {\n";
            paramContext = paramContext + "    hw_sr 48000\n";
            paramContext = paramContext + "  }\n";
            paramContext = paramContext + "  play {\n";
            paramContext = paramContext + "    hw_sr 48000\n";
            paramBoolean = paramContext + "  }";
          }
        }
      }
      paramContext = paramBoolean + "    }\n";
      paramContext = paramContext + "  }\n";
      paramContext = paramContext + "}";
      AppMethodBeat.o(246184);
      return paramContext;
      paramBoolean = "y";
      break;
    }
  }
  
  private TXSystemAudioKit createManufacturerAudioKit(Context paramContext)
  {
    AppMethodBeat.i(246194);
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
    {
      paramContext = new HuaweiAudioKit();
      AppMethodBeat.o(246194);
      return paramContext;
    }
    AppMethodBeat.o(246194);
    return null;
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean)
  {
    AppMethodBeat.i(246158);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioEarMonitoring: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(246158);
  }
  
  public static boolean enableAudioVolumeEvaluation(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246089);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioVolumeEvaluation : " + paramBoolean + "interval:" + paramInt);
    TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(paramBoolean, paramInt);
    AppMethodBeat.o(246089);
    return true;
  }
  
  public static TXCAudioEngine getInstance()
  {
    return sInstance;
  }
  
  private static int getLowLatencySampleRate(Context paramContext)
  {
    AppMethodBeat.i(246186);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        try
        {
          int i = Integer.parseInt(paramContext.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
          AppMethodBeat.o(246186);
          return i;
        }
        catch (NumberFormatException paramContext)
        {
          TXCLog.e("AudioEngine :TXCAudioEngine_java", "can't parse low latency samplerate", paramContext);
        }
      }
    }
    AppMethodBeat.o(246186);
    return -1;
  }
  
  public static int getMixingPlayoutVolumeLevel()
  {
    AppMethodBeat.i(246154);
    int i = TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
    AppMethodBeat.o(246154);
    return i;
  }
  
  private void handleAudioEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246150);
    if (paramInt == 10055)
    {
      b.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
      AppMethodBeat.o(246150);
      return;
    }
    if (paramInt == 10056)
    {
      b.a().a("timestamp_rollback_to_stable_samplerate", 0L);
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "audio device restart when using stable samplerate");
    }
    AppMethodBeat.o(246150);
  }
  
  public static boolean hasTrae()
  {
    return has_trae;
  }
  
  public static void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(246138);
    d locald = null;
    synchronized (mJitterEventListenerMapLock)
    {
      if (mJitterEventListenerMap.get(paramString1) != null) {
        locald = (d)((WeakReference)mJitterEventListenerMap.get(paramString1)).get();
      }
      if (locald != null)
      {
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "onAudioJitterBufferNotify  cur state ".concat(String.valueOf(paramInt)));
        locald.onAudioJitterBufferNotify(paramString1, paramInt, paramString2);
      }
      AppMethodBeat.o(246138);
      return;
    }
  }
  
  public static void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246136);
    f localf = null;
    synchronized (mJitterDataListenerMapLock)
    {
      if (mJitterDataListenerMap.get(paramString) != null) {
        localf = (f)((WeakReference)mJitterDataListenerMap.get(paramString)).get();
      }
      if (localf != null) {
        localf.onAudioPlayPcmData(paramString, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
      AppMethodBeat.o(246136);
      return;
    }
  }
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246153);
    if (mAudioCoreDataListener != null)
    {
      f localf = (f)mAudioCoreDataListener.get();
      if (localf != null) {
        localf.onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(246153);
  }
  
  public static void setAudioEarMonitoringVolume(int paramInt)
  {
    AppMethodBeat.i(246159);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioEarMonitoringVolume: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(246159);
  }
  
  public static void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(246156);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioRoute: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioRoute(paramInt);
    AppMethodBeat.o(246156);
  }
  
  public static void setPlayoutDataListener(f paramf)
  {
    AppMethodBeat.i(246152);
    mAudioCoreDataListener = new WeakReference(paramf);
    if (paramf == null) {}
    for (boolean bool = false;; bool = true)
    {
      TXCAudioEngineJNI.nativeSetPlayoutDataListener(bool);
      AppMethodBeat.o(246152);
      return;
    }
  }
  
  public static void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(246157);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setSystemVolumeType: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetSystemVolumeType(paramInt);
    AppMethodBeat.o(246157);
  }
  
  private void startSystemAudioKit()
  {
    AppMethodBeat.i(246189);
    if ((this.mAudioKit != null) || (mContext == null))
    {
      AppMethodBeat.o(246189);
      return;
    }
    this.mAudioKit = createManufacturerAudioKit(mContext);
    if (this.mAudioKit != null)
    {
      TXCAudioEngineJNI.nativeNotifySystemEarMonitoringInitializing();
      this.mAudioKit.initialize(mContext, this);
      AppMethodBeat.o(246189);
      return;
    }
    TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    AppMethodBeat.o(246189);
  }
  
  public void EnableMixMode(boolean paramBoolean)
  {
    AppMethodBeat.i(246105);
    TXCAudioEngineJNI.nativeEnableMixMode(paramBoolean);
    AppMethodBeat.o(246105);
  }
  
  public boolean IsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246171);
    boolean bool = TXCAudioEngineJNI.nativeIsDataCallbackFormatInvalid(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246171);
    return bool;
  }
  
  public void SetAudioCacheParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246176);
    TXCAudioEngineJNI.nativeSetAudioCacheParams(paramInt1, paramInt2);
    AppMethodBeat.o(246176);
  }
  
  public void UnInitAudioDevice()
  {
    AppMethodBeat.i(246090);
    TXCAudioEngineJNI.nativeUnInitAudioDevice();
    AppMethodBeat.o(246090);
  }
  
  public void addEventCallback(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference)
  {
    AppMethodBeat.i(246147);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(246147);
      return;
    }
    synchronized (this.mCallbackList)
    {
      this.mCallbackList.add(paramWeakReference);
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
      AppMethodBeat.o(246147);
      return;
    }
  }
  
  public void clean()
  {
    AppMethodBeat.i(246173);
    TXCAudioEngineJNI.nativeClean();
    AppMethodBeat.o(246173);
  }
  
  public void enableAutoRestartDevice(boolean paramBoolean)
  {
    AppMethodBeat.i(246178);
    TXCAudioEngineJNI.nativeEnableAutoRestartDevice(paramBoolean);
    AppMethodBeat.o(246178);
  }
  
  public boolean enableCaptureEOSMode(boolean paramBoolean)
  {
    AppMethodBeat.i(246130);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableEosMode ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableCaptureEOSMode(paramBoolean);
    AppMethodBeat.o(246130);
    return true;
  }
  
  public void enableDeviceAbnormalDetection(boolean paramBoolean)
  {
    AppMethodBeat.i(246182);
    TXCAudioEngineJNI.nativeEnableDeviceAbnormalDetection(paramBoolean);
    AppMethodBeat.o(246182);
  }
  
  public void enableEncodedDataCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(246109);
    TXCAudioEngineJNI.nativeEnableEncodedDataCallback(paramBoolean);
    AppMethodBeat.o(246109);
  }
  
  public void enableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(246107);
    TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(paramBoolean);
    AppMethodBeat.o(246107);
  }
  
  public void enableInbandFEC(boolean paramBoolean)
  {
    AppMethodBeat.i(246179);
    TXCAudioEngineJNI.nativeEnableInbandFEC(paramBoolean);
    AppMethodBeat.o(246179);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246123);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAEC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAEC(paramInt);
    AppMethodBeat.o(246123);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246125);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAGC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAGC(paramInt);
    AppMethodBeat.o(246125);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246124);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftANS: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftANS(paramInt);
    AppMethodBeat.o(246124);
  }
  
  public void forceCallbackMixedPlayAudioFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(246174);
    TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(paramBoolean);
    AppMethodBeat.o(246174);
  }
  
  public int getAECType()
  {
    return 2;
  }
  
  public Context getAppContext()
  {
    return mContext;
  }
  
  public TXCAudioEncoderConfig getAudioEncoderConfig()
  {
    AppMethodBeat.i(246099);
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngineJNI.nativeGetEncoderConfig();
    AppMethodBeat.o(246099);
    return localTXCAudioEncoderConfig;
  }
  
  public int getEncoderChannels()
  {
    AppMethodBeat.i(246098);
    int i = TXCAudioEngineJNI.nativeGetEncoderChannels();
    AppMethodBeat.o(246098);
    return i;
  }
  
  public int getEncoderSampleRate()
  {
    AppMethodBeat.i(246096);
    int i = TXCAudioEngineJNI.nativeGetEncoderSampleRate();
    AppMethodBeat.o(246096);
    return i;
  }
  
  public int getPlayAECType()
  {
    if (has_trae) {
      return 2;
    }
    return 0;
  }
  
  public int getPlayChannels()
  {
    return 2;
  }
  
  public int getPlaySampleRate()
  {
    return 48000;
  }
  
  public int getRemotePlayoutVolumeLevel(String paramString)
  {
    AppMethodBeat.i(246145);
    if (paramString == null)
    {
      AppMethodBeat.o(246145);
      return 0;
    }
    int i = TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(paramString);
    AppMethodBeat.o(246145);
    return i;
  }
  
  public int getSoftwareCaptureVolumeLevel()
  {
    AppMethodBeat.i(246132);
    int i = TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
    AppMethodBeat.o(246132);
    return i;
  }
  
  public StatusBucket getStatus(int paramInt)
  {
    AppMethodBeat.i(246155);
    StatusBucket localStatusBucket = TXCAudioEngineJNI.getStatus(paramInt);
    AppMethodBeat.o(246155);
    return localStatusBucket;
  }
  
  public boolean isAudioDeviceCapturing()
  {
    AppMethodBeat.i(246131);
    boolean bool = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "isRecording: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(246131);
    return bool;
  }
  
  public boolean isRemoteAudioPlaying(String paramString)
  {
    AppMethodBeat.i(246144);
    if (paramString == null)
    {
      AppMethodBeat.o(246144);
      return false;
    }
    boolean bool = TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(paramString);
    AppMethodBeat.o(246144);
    return bool;
  }
  
  public boolean muteLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(246118);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeMuteLocalAudio(paramBoolean);
    AppMethodBeat.o(246118);
    return true;
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246141);
    if (paramString == null)
    {
      AppMethodBeat.o(246141);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(246141);
  }
  
  public void muteRemoteAudioInSpeaker(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246142);
    if (paramString == null)
    {
      AppMethodBeat.o(246142);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(paramString, paramBoolean);
    AppMethodBeat.o(246142);
  }
  
  public void onAudioKitError(TXSystemAudioKit paramTXSystemAudioKit)
  {
    AppMethodBeat.i(246193);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(246193);
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "onAudioKitError");
    if (this.mAudioKit != null)
    {
      this.mAudioKit.stopSystemEarMonitoring();
      this.mAudioKit.uninitialize();
      this.mAudioKit = null;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246268);
        TXCAudioEngine.access$000(TXCAudioEngine.this);
        AppMethodBeat.o(246268);
      }
    }, SYSTEM_AUDIO_KIT_RESTART_INTERVAL);
    AppMethodBeat.o(246193);
  }
  
  public void onAudioKitInitFinished(TXSystemAudioKit paramTXSystemAudioKit, boolean paramBoolean)
  {
    AppMethodBeat.i(246190);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(246190);
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "system audio kit init finished, ret: %b.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    }
    AppMethodBeat.o(246190);
  }
  
  public void onCallStateChanged(int paramInt)
  {
    AppMethodBeat.i(246177);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246177);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_RINGING!");
      AppMethodBeat.o(246177);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_OFFHOOK!");
      TXCAudioEngineJNI.pauseAudioCapture(true);
      TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
      TXAudioEffectManagerImpl.getCacheInstance().interruptAllMusics();
      TXAudioEffectManagerImpl.getAutoCacheHolder().interruptAllMusics();
      this.mIsCallComed = true;
      AppMethodBeat.o(246177);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_IDLE!");
      if (this.mIsCallComed)
      {
        this.mIsCallComed = false;
        TXCAudioEngineJNI.resumeAudioCapture();
        TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
        TXAudioEffectManagerImpl.getCacheInstance().recoverAllMusics();
        TXAudioEffectManagerImpl.getAutoCacheHolder().recoverAllMusics();
      }
    }
  }
  
  public void onEarMonitoringInitialized(TXSystemAudioKit paramTXSystemAudioKit, boolean paramBoolean)
  {
    AppMethodBeat.i(246192);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(246192);
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "onEarMonitoringInitialized result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(this.mAudioKit);
      AppMethodBeat.o(246192);
      return;
    }
    TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    AppMethodBeat.o(246192);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246151);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(246151);
          return;
        }
        localIterator = this.mCallbackList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.liteav.basic.c.a locala = (com.tencent.liteav.basic.c.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localIterator.remove();
    }
    if (this.mCallbackList.size() <= 0) {
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.liteav.basic.c.a)((Iterator)???).next()).onError(paramString1, paramInt, paramString2, paramString3);
    }
    AppMethodBeat.o(246151);
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246148);
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(246148);
          return;
        }
        localIterator = this.mCallbackList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.liteav.basic.c.a locala = (com.tencent.liteav.basic.c.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localIterator.remove();
    }
    if (this.mCallbackList.size() <= 0) {
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.liteav.basic.c.a)((Iterator)???).next()).onEvent(paramString1, paramInt, paramString2, paramString3);
    }
    AppMethodBeat.o(246148);
  }
  
  public void onWarning(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246149);
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(246149);
          return;
        }
        localIterator = this.mCallbackList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.liteav.basic.c.a locala = (com.tencent.liteav.basic.c.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localIterator.remove();
    }
    if (this.mCallbackList.size() <= 0) {
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.liteav.basic.c.a)((Iterator)???).next()).onWarning(paramString1, paramInt, paramString2, paramString3);
    }
    AppMethodBeat.o(246149);
  }
  
  public int pauseAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(246111);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "pauseAudioCapture: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.pauseAudioCapture(paramBoolean);
    AppMethodBeat.o(246111);
    return 0;
  }
  
  public void pauseLocalAudio()
  {
    AppMethodBeat.i(246103);
    TXCAudioEngineJNI.nativePauseLocalAudio();
    AppMethodBeat.o(246103);
  }
  
  public int resumeAudioCapture()
  {
    AppMethodBeat.i(246113);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "resumeRecord");
    TXCAudioEngineJNI.resumeAudioCapture();
    AppMethodBeat.o(246113);
    return 0;
  }
  
  public void resumeLocalAudio()
  {
    AppMethodBeat.i(246104);
    TXCAudioEngineJNI.nativeResumeLocalAudio();
    AppMethodBeat.o(246104);
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(246116);
    TXCAudioEngineJNI.sendCustomPCMData(parama);
    AppMethodBeat.o(246116);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246115);
    TXCAudioEngineJNI.sendCustomPCMData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(246115);
  }
  
  public boolean setAudioCaptureDataListener(g paramg)
  {
    AppMethodBeat.i(246117);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordListener ");
    if (paramg == null) {
      TXCAudioEngineJNI.setAudioCaptureDataListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(246117);
      return true;
      TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference(paramg));
    }
  }
  
  public void setAudioDumpingListener(TXCAudioEngineJNI.a parama)
  {
    AppMethodBeat.i(246165);
    TXCAudioEngineJNI.SetAudioDumpingListener(parama);
    AppMethodBeat.o(246165);
  }
  
  public boolean setAudioEncoderParam(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246129);
    TXCAudioEngineJNI.nativeSetAudioEncoderParam(paramInt1, paramInt2);
    AppMethodBeat.o(246129);
    return true;
  }
  
  public void setAudioQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246093);
    TXCAudioEngineJNI.nativeSetAudioQuality(paramInt1, paramInt2);
    AppMethodBeat.o(246093);
  }
  
  public void setCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246167);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setCaptureDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246167);
  }
  
  public void setEncoderChannels(int paramInt)
  {
    AppMethodBeat.i(246095);
    TXCAudioEngineJNI.nativeSetEncoderChannels(paramInt);
    AppMethodBeat.o(246095);
  }
  
  public boolean setEncoderFECPercent(float paramFloat)
  {
    AppMethodBeat.i(246128);
    TXCAudioEngineJNI.nativeSetEncoderFECPercent(paramFloat);
    AppMethodBeat.o(246128);
    return true;
  }
  
  public void setEncoderSampleRate(int paramInt)
  {
    AppMethodBeat.i(246094);
    TXCAudioEngineJNI.nativeSetEncoderSampleRate(paramInt);
    AppMethodBeat.o(246094);
  }
  
  public void setLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246168);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setLocalProcessedDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetLocalProcessedDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246168);
  }
  
  public void setMaxSelectedPlayStreams(int paramInt)
  {
    AppMethodBeat.i(246180);
    TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(paramInt);
    AppMethodBeat.o(246180);
  }
  
  public void setMixedAllDataListener(e parame)
  {
    AppMethodBeat.i(246181);
    TXCAudioEngineJNI.setMixedAllDataListener(parame);
    AppMethodBeat.o(246181);
  }
  
  public boolean setMixingPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(246122);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(paramFloat);
    AppMethodBeat.o(246122);
    return true;
  }
  
  public void setPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246169);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246169);
  }
  
  public void setRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246140);
    TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(paramString, paramBoolean, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246140);
  }
  
  public void setRemoteAudioStreamEventListener(String paramString, d paramd)
  {
    AppMethodBeat.i(246137);
    if (paramString == null)
    {
      AppMethodBeat.o(246137);
      return;
    }
    synchronized (mJitterEventListenerMapLock)
    {
      mJitterEventListenerMap.put(paramString, new WeakReference(paramd));
      AppMethodBeat.o(246137);
      return;
    }
  }
  
  public void setRemotePlayoutVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(246143);
    if (paramString == null)
    {
      AppMethodBeat.o(246143);
      return;
    }
    TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(paramString, paramInt);
    AppMethodBeat.o(246143);
  }
  
  public void setRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246170);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRemoteStreamDataCallbackFormat: id-" + paramString + " sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(246170);
  }
  
  public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(246120);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setReverbType: " + paramTXVoiceReverbType.getNativeValue());
    TXCAudioEngineJNI.nativeSetRecordReverb(paramTXVoiceReverbType.getNativeValue());
    AppMethodBeat.o(246120);
    return true;
  }
  
  public void setSetAudioEngineRemoteStreamDataListener(String paramString, f paramf)
  {
    AppMethodBeat.i(246135);
    if (paramString == null)
    {
      AppMethodBeat.o(246135);
      return;
    }
    for (;;)
    {
      synchronized (mJitterDataListenerMapLock)
      {
        mJitterDataListenerMap.put(paramString, new WeakReference(paramf));
        if (paramf == null)
        {
          bool = false;
          TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(paramString, bool);
          AppMethodBeat.o(246135);
          return;
        }
      }
      boolean bool = true;
    }
  }
  
  public boolean setSoftwareCaptureVolume(float paramFloat)
  {
    AppMethodBeat.i(246121);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(paramFloat);
    AppMethodBeat.o(246121);
    return true;
  }
  
  public void setSystemAudioKitEnabled()
  {
    AppMethodBeat.i(246187);
    startSystemAudioKit();
    AppMethodBeat.o(246187);
  }
  
  public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(246126);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setVoiceChangerType " + paramTXVoiceChangerType.getNativeValue());
    TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(paramTXVoiceChangerType.getNativeValue());
    AppMethodBeat.o(246126);
    return true;
  }
  
  public int startLocalAudio(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(246101);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "startLocalAudio audioFormat:".concat(String.valueOf(paramInt)));
    if (mContext == null)
    {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "Please call CreateInstance fisrt!!!");
      AppMethodBeat.o(246101);
      return -901;
    }
    TXCAudioEngineJNI.InitTraeEngineLibrary(mContext);
    TXCAudioEngineJNI.nativeStartLocalAudio(paramInt, paramBoolean);
    this.mDeviceIsRecording = true;
    AppMethodBeat.o(246101);
    return 0;
  }
  
  public int startLocalAudioDumping(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(246160);
    paramInt1 = TXCAudioEngineJNI.nativeStartLocalAudioDumping(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(246160);
    return paramInt1;
  }
  
  public void startRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246133);
    synchronized (this.mStartStopRemoteAudioMutex)
    {
      TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, paramBoolean, paramString);
      TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(paramString, c.a().a("Audio", "LIVE_JitterCycle"));
      TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(paramString, c.a().a("Audio", "LoadingThreshold"));
      AppMethodBeat.o(246133);
      return;
    }
  }
  
  public int stopLocalAudio()
  {
    AppMethodBeat.i(246102);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "stopLocalAudio");
    TXCAudioEngineJNI.nativeStopLocalAudio();
    this.mDeviceIsRecording = false;
    AppMethodBeat.o(246102);
    return 0;
  }
  
  public void stopLocalAudioDumping()
  {
    AppMethodBeat.i(246162);
    TXCAudioEngineJNI.nativeStopLocalAudioDumping();
    AppMethodBeat.o(246162);
  }
  
  public void stopRemoteAudio(String paramString)
  {
    AppMethodBeat.i(246134);
    if (paramString == null)
    {
      AppMethodBeat.o(246134);
      return;
    }
    synchronized (this.mStartStopRemoteAudioMutex)
    {
      TXCAudioEngineJNI.nativeStopRemoteAudio(paramString);
      AppMethodBeat.o(246134);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioEngine
 * JD-Core Version:    0.7.0.1
 */