package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
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
import com.tencent.liteav.basic.util.TXCBuild;
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
    AppMethodBeat.i(230642);
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
    AppMethodBeat.o(230642);
  }
  
  private TXCAudioEngine()
  {
    AppMethodBeat.i(230440);
    this.mCallbackList = new ArrayList();
    this.mDeviceIsRecording = false;
    this.mIsCustomRecord = false;
    this.mStartStopRemoteAudioMutex = new Object();
    this.mIsCallComed = false;
    AppMethodBeat.o(230440);
  }
  
  public static void CreateInstance(Context paramContext, String paramString)
  {
    try
    {
      AppMethodBeat.i(230446);
      CreateInstanceWithoutInitDevice(paramContext, paramString);
      TXCAudioEngineJNI.nativeInitAudioDevice();
      AppMethodBeat.o(230446);
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
        AppMethodBeat.i(230459);
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance: ");
        mContext = paramContext.getApplicationContext();
        if (has_init)
        {
          TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance already created~ ");
          AppMethodBeat.o(230459);
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
          AppMethodBeat.o(230459);
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
    AppMethodBeat.i(230598);
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
      AppMethodBeat.o(230598);
      return paramContext;
      paramBoolean = "y";
      break;
    }
  }
  
  private TXSystemAudioKit createManufacturerAudioKit(Context paramContext)
  {
    AppMethodBeat.i(230628);
    if (TXCBuild.Manufacturer().equalsIgnoreCase("huawei"))
    {
      paramContext = new HuaweiAudioKit();
      AppMethodBeat.o(230628);
      return paramContext;
    }
    AppMethodBeat.o(230628);
    return null;
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean)
  {
    AppMethodBeat.i(230577);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioEarMonitoring: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(230577);
  }
  
  public static boolean enableAudioVolumeEvaluation(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(230481);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioVolumeEvaluation : " + paramBoolean + "interval:" + paramInt);
    TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(paramBoolean, paramInt);
    AppMethodBeat.o(230481);
    return true;
  }
  
  public static TXCAudioEngine getInstance()
  {
    return sInstance;
  }
  
  private static int getLowLatencySampleRate(Context paramContext)
  {
    AppMethodBeat.i(230612);
    if (TXCBuild.VersionInt() >= 17)
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        try
        {
          int i = Integer.parseInt(paramContext.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
          AppMethodBeat.o(230612);
          return i;
        }
        catch (NumberFormatException paramContext)
        {
          TXCLog.e("AudioEngine :TXCAudioEngine_java", "can't parse low latency samplerate", paramContext);
        }
      }
    }
    AppMethodBeat.o(230612);
    return -1;
  }
  
  public static int getMixingPlayoutVolumeLevel()
  {
    AppMethodBeat.i(230544);
    int i = TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
    AppMethodBeat.o(230544);
    return i;
  }
  
  private void handleAudioEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(230516);
    if (paramInt == 10055)
    {
      b.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
      AppMethodBeat.o(230516);
      return;
    }
    if (paramInt == 10056)
    {
      b.a().a("timestamp_rollback_to_stable_samplerate", 0L);
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "audio device restart when using stable samplerate");
    }
    AppMethodBeat.o(230516);
  }
  
  public static boolean hasTrae()
  {
    return has_trae;
  }
  
  public static void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(230507);
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
      AppMethodBeat.o(230507);
      return;
    }
  }
  
  public static void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230492);
    f localf = null;
    synchronized (mJitterDataListenerMapLock)
    {
      if (mJitterDataListenerMap.get(paramString) != null) {
        localf = (f)((WeakReference)mJitterDataListenerMap.get(paramString)).get();
      }
      if (localf != null) {
        localf.onAudioPlayPcmData(paramString, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
      AppMethodBeat.o(230492);
      return;
    }
  }
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230535);
    if (mAudioCoreDataListener != null)
    {
      f localf = (f)mAudioCoreDataListener.get();
      if (localf != null) {
        localf.onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(230535);
  }
  
  public static void setAudioEarMonitoringVolume(int paramInt)
  {
    AppMethodBeat.i(230583);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioEarMonitoringVolume: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(230583);
  }
  
  public static void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(230553);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioRoute: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioRoute(paramInt);
    AppMethodBeat.o(230553);
  }
  
  public static void setPlayoutDataListener(f paramf)
  {
    AppMethodBeat.i(230525);
    mAudioCoreDataListener = new WeakReference(paramf);
    if (paramf == null) {}
    for (boolean bool = false;; bool = true)
    {
      TXCAudioEngineJNI.nativeSetPlayoutDataListener(bool);
      AppMethodBeat.o(230525);
      return;
    }
  }
  
  public static void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(230568);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setSystemVolumeType: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetSystemVolumeType(paramInt);
    AppMethodBeat.o(230568);
  }
  
  private void startSystemAudioKit()
  {
    AppMethodBeat.i(230619);
    if ((this.mAudioKit != null) || (mContext == null))
    {
      AppMethodBeat.o(230619);
      return;
    }
    this.mAudioKit = createManufacturerAudioKit(mContext);
    if (this.mAudioKit != null)
    {
      TXCAudioEngineJNI.nativeNotifySystemEarMonitoringInitializing();
      this.mAudioKit.initialize(mContext, this);
      AppMethodBeat.o(230619);
      return;
    }
    TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    AppMethodBeat.o(230619);
  }
  
  public void EnableMixMode(boolean paramBoolean)
  {
    AppMethodBeat.i(230704);
    TXCAudioEngineJNI.nativeEnableMixMode(paramBoolean);
    AppMethodBeat.o(230704);
  }
  
  public boolean IsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230888);
    boolean bool = TXCAudioEngineJNI.nativeIsDataCallbackFormatInvalid(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230888);
    return bool;
  }
  
  public void SetAudioCacheParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230893);
    TXCAudioEngineJNI.nativeSetAudioCacheParams(paramInt1, paramInt2);
    AppMethodBeat.o(230893);
  }
  
  public void UnInitAudioDevice()
  {
    AppMethodBeat.i(230647);
    TXCAudioEngineJNI.nativeUnInitAudioDevice();
    AppMethodBeat.o(230647);
  }
  
  public void addEventCallback(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference)
  {
    AppMethodBeat.i(230837);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(230837);
      return;
    }
    synchronized (this.mCallbackList)
    {
      this.mCallbackList.add(paramWeakReference);
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
      AppMethodBeat.o(230837);
      return;
    }
  }
  
  public void clean()
  {
    AppMethodBeat.i(230889);
    TXCAudioEngineJNI.nativeClean();
    AppMethodBeat.o(230889);
  }
  
  public void enableAutoRestartDevice(boolean paramBoolean)
  {
    AppMethodBeat.i(230896);
    TXCAudioEngineJNI.nativeEnableAutoRestartDevice(paramBoolean);
    AppMethodBeat.o(230896);
  }
  
  public boolean enableCaptureEOSMode(boolean paramBoolean)
  {
    AppMethodBeat.i(230765);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableEosMode ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableCaptureEOSMode(paramBoolean);
    AppMethodBeat.o(230765);
    return true;
  }
  
  public void enableDeviceAbnormalDetection(boolean paramBoolean)
  {
    AppMethodBeat.i(230903);
    TXCAudioEngineJNI.nativeEnableDeviceAbnormalDetection(paramBoolean);
    AppMethodBeat.o(230903);
  }
  
  public void enableEncodedDataCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(230709);
    TXCAudioEngineJNI.nativeEnableEncodedDataCallback(paramBoolean);
    AppMethodBeat.o(230709);
  }
  
  public void enableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(230706);
    TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(paramBoolean);
    AppMethodBeat.o(230706);
  }
  
  public void enableInbandFEC(boolean paramBoolean)
  {
    AppMethodBeat.i(230897);
    TXCAudioEngineJNI.nativeEnableInbandFEC(paramBoolean);
    AppMethodBeat.o(230897);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(230733);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAEC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAEC(paramInt);
    AppMethodBeat.o(230733);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(230747);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAGC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAGC(paramInt);
    AppMethodBeat.o(230747);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(230740);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftANS: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftANS(paramInt);
    AppMethodBeat.o(230740);
  }
  
  public void forceCallbackMixedPlayAudioFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(230891);
    TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(paramBoolean);
    AppMethodBeat.o(230891);
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
    AppMethodBeat.i(230690);
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngineJNI.nativeGetEncoderConfig();
    AppMethodBeat.o(230690);
    return localTXCAudioEncoderConfig;
  }
  
  public int getEncoderChannels()
  {
    AppMethodBeat.i(230685);
    int i = TXCAudioEngineJNI.nativeGetEncoderChannels();
    AppMethodBeat.o(230685);
    return i;
  }
  
  public int getEncoderSampleRate()
  {
    AppMethodBeat.i(230680);
    int i = TXCAudioEngineJNI.nativeGetEncoderSampleRate();
    AppMethodBeat.o(230680);
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
    AppMethodBeat.i(230822);
    if (paramString == null)
    {
      AppMethodBeat.o(230822);
      return 0;
    }
    int i = TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(paramString);
    AppMethodBeat.o(230822);
    return i;
  }
  
  public int getSoftwareCaptureVolumeLevel()
  {
    AppMethodBeat.i(230769);
    int i = TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
    AppMethodBeat.o(230769);
    return i;
  }
  
  public StatusBucket getStatus(int paramInt)
  {
    AppMethodBeat.i(230861);
    StatusBucket localStatusBucket = TXCAudioEngineJNI.getStatus(paramInt);
    AppMethodBeat.o(230861);
    return localStatusBucket;
  }
  
  public boolean isAudioDeviceCapturing()
  {
    AppMethodBeat.i(230767);
    boolean bool = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "isRecording: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(230767);
    return bool;
  }
  
  public boolean isRemoteAudioPlaying(String paramString)
  {
    AppMethodBeat.i(230818);
    if (paramString == null)
    {
      AppMethodBeat.o(230818);
      return false;
    }
    boolean bool = TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(paramString);
    AppMethodBeat.o(230818);
    return bool;
  }
  
  public boolean muteLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(230719);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeMuteLocalAudio(paramBoolean);
    AppMethodBeat.o(230719);
    return true;
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230804);
    if (paramString == null)
    {
      AppMethodBeat.o(230804);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(230804);
  }
  
  public void muteRemoteAudioInSpeaker(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230808);
    if (paramString == null)
    {
      AppMethodBeat.o(230808);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(paramString, paramBoolean);
    AppMethodBeat.o(230808);
  }
  
  public void onAudioKitError(TXSystemAudioKit paramTXSystemAudioKit)
  {
    AppMethodBeat.i(230909);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(230909);
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
        AppMethodBeat.i(230358);
        TXCAudioEngine.access$000(TXCAudioEngine.this);
        AppMethodBeat.o(230358);
      }
    }, SYSTEM_AUDIO_KIT_RESTART_INTERVAL);
    AppMethodBeat.o(230909);
  }
  
  public void onAudioKitInitFinished(TXSystemAudioKit paramTXSystemAudioKit, boolean paramBoolean)
  {
    AppMethodBeat.i(230906);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(230906);
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "system audio kit init finished, ret: %b.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    }
    AppMethodBeat.o(230906);
  }
  
  public void onCallStateChanged(int paramInt)
  {
    AppMethodBeat.i(230895);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(230895);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_RINGING!");
      AppMethodBeat.o(230895);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_OFFHOOK!");
      TXCAudioEngineJNI.pauseAudioCapture(true);
      TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
      TXAudioEffectManagerImpl.getCacheInstance().interruptAllMusics();
      TXAudioEffectManagerImpl.getAutoCacheHolder().interruptAllMusics();
      this.mIsCallComed = true;
      AppMethodBeat.o(230895);
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
    AppMethodBeat.i(230908);
    if (this.mAudioKit != paramTXSystemAudioKit)
    {
      AppMethodBeat.o(230908);
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "onEarMonitoringInitialized result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(this.mAudioKit);
      AppMethodBeat.o(230908);
      return;
    }
    TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    AppMethodBeat.o(230908);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(230855);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(230855);
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
    AppMethodBeat.o(230855);
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(230844);
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(230844);
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
    AppMethodBeat.o(230844);
  }
  
  public void onWarning(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(230848);
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(230848);
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
    AppMethodBeat.o(230848);
  }
  
  public int pauseAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(230711);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "pauseAudioCapture: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.pauseAudioCapture(paramBoolean);
    AppMethodBeat.o(230711);
    return 0;
  }
  
  public void pauseLocalAudio()
  {
    AppMethodBeat.i(230699);
    TXCAudioEngineJNI.nativePauseLocalAudio();
    AppMethodBeat.o(230699);
  }
  
  public int resumeAudioCapture()
  {
    AppMethodBeat.i(230713);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "resumeRecord");
    TXCAudioEngineJNI.resumeAudioCapture();
    AppMethodBeat.o(230713);
    return 0;
  }
  
  public void resumeLocalAudio()
  {
    AppMethodBeat.i(230701);
    TXCAudioEngineJNI.nativeResumeLocalAudio();
    AppMethodBeat.o(230701);
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(230715);
    TXCAudioEngineJNI.sendCustomPCMData(parama);
    AppMethodBeat.o(230715);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230714);
    TXCAudioEngineJNI.sendCustomPCMData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(230714);
  }
  
  public boolean setAudioCaptureDataListener(g paramg)
  {
    AppMethodBeat.i(230717);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordListener ");
    if (paramg == null) {
      TXCAudioEngineJNI.setAudioCaptureDataListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(230717);
      return true;
      TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference(paramg));
    }
  }
  
  public void setAudioDumpingListener(TXCAudioEngineJNI.a parama)
  {
    AppMethodBeat.i(230880);
    TXCAudioEngineJNI.SetAudioDumpingListener(parama);
    AppMethodBeat.o(230880);
  }
  
  public boolean setAudioEncoderParam(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230760);
    TXCAudioEngineJNI.nativeSetAudioEncoderParam(paramInt1, paramInt2);
    AppMethodBeat.o(230760);
    return true;
  }
  
  public void setAudioQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230658);
    TXCAudioEngineJNI.nativeSetAudioQuality(paramInt1, paramInt2);
    AppMethodBeat.o(230658);
  }
  
  public void setCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230884);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setCaptureDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230884);
  }
  
  public void setEncoderChannels(int paramInt)
  {
    AppMethodBeat.i(230671);
    TXCAudioEngineJNI.nativeSetEncoderChannels(paramInt);
    AppMethodBeat.o(230671);
  }
  
  public boolean setEncoderFECPercent(float paramFloat)
  {
    AppMethodBeat.i(230755);
    TXCAudioEngineJNI.nativeSetEncoderFECPercent(paramFloat);
    AppMethodBeat.o(230755);
    return true;
  }
  
  public void setEncoderSampleRate(int paramInt)
  {
    AppMethodBeat.i(230663);
    TXCAudioEngineJNI.nativeSetEncoderSampleRate(paramInt);
    AppMethodBeat.o(230663);
  }
  
  public void setLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230885);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setLocalProcessedDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetLocalProcessedDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230885);
  }
  
  public void setMaxSelectedPlayStreams(int paramInt)
  {
    AppMethodBeat.i(230900);
    TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(paramInt);
    AppMethodBeat.o(230900);
  }
  
  public void setMixedAllDataListener(e parame)
  {
    AppMethodBeat.i(230901);
    TXCAudioEngineJNI.setMixedAllDataListener(parame);
    AppMethodBeat.o(230901);
  }
  
  public boolean setMixingPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(230730);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(paramFloat);
    AppMethodBeat.o(230730);
    return true;
  }
  
  public void setPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230886);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230886);
  }
  
  public void setRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230798);
    TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(paramString, paramBoolean, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230798);
  }
  
  public void setRemoteAudioStreamEventListener(String paramString, d paramd)
  {
    AppMethodBeat.i(230792);
    if (paramString == null)
    {
      AppMethodBeat.o(230792);
      return;
    }
    synchronized (mJitterEventListenerMapLock)
    {
      mJitterEventListenerMap.put(paramString, new WeakReference(paramd));
      AppMethodBeat.o(230792);
      return;
    }
  }
  
  public void setRemotePlayoutVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(230817);
    if (paramString == null)
    {
      AppMethodBeat.o(230817);
      return;
    }
    TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(paramString, paramInt);
    AppMethodBeat.o(230817);
  }
  
  public void setRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230887);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRemoteStreamDataCallbackFormat: id-" + paramString + " sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230887);
  }
  
  public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(230723);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setReverbType: " + paramTXVoiceReverbType.getNativeValue());
    TXCAudioEngineJNI.nativeSetRecordReverb(paramTXVoiceReverbType.getNativeValue());
    AppMethodBeat.o(230723);
    return true;
  }
  
  public void setSetAudioEngineRemoteStreamDataListener(String paramString, f paramf)
  {
    AppMethodBeat.i(230787);
    if (paramString == null)
    {
      AppMethodBeat.o(230787);
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
          AppMethodBeat.o(230787);
          return;
        }
      }
      boolean bool = true;
    }
  }
  
  public boolean setSoftwareCaptureVolume(float paramFloat)
  {
    AppMethodBeat.i(230727);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(paramFloat);
    AppMethodBeat.o(230727);
    return true;
  }
  
  public void setSystemAudioKitEnabled()
  {
    AppMethodBeat.i(230904);
    startSystemAudioKit();
    AppMethodBeat.o(230904);
  }
  
  public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(230752);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setVoiceChangerType " + paramTXVoiceChangerType.getNativeValue());
    TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(paramTXVoiceChangerType.getNativeValue());
    AppMethodBeat.o(230752);
    return true;
  }
  
  public int startLocalAudio(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230693);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "startLocalAudio audioFormat:".concat(String.valueOf(paramInt)));
    if (mContext == null)
    {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "Please call CreateInstance fisrt!!!");
      AppMethodBeat.o(230693);
      return -901;
    }
    TXCAudioEngineJNI.InitTraeEngineLibrary(mContext);
    TXCAudioEngineJNI.nativeStartLocalAudio(paramInt, paramBoolean);
    this.mDeviceIsRecording = true;
    AppMethodBeat.o(230693);
    return 0;
  }
  
  public int startLocalAudioDumping(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(230870);
    paramInt1 = TXCAudioEngineJNI.nativeStartLocalAudioDumping(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(230870);
    return paramInt1;
  }
  
  public void startRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230774);
    synchronized (this.mStartStopRemoteAudioMutex)
    {
      TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, paramBoolean, paramString);
      TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(paramString, c.a().a("Audio", "LIVE_JitterCycle"));
      TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(paramString, c.a().a("Audio", "LoadingThreshold"));
      AppMethodBeat.o(230774);
      return;
    }
  }
  
  public int stopLocalAudio()
  {
    AppMethodBeat.i(230696);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "stopLocalAudio");
    TXCAudioEngineJNI.nativeStopLocalAudio();
    this.mDeviceIsRecording = false;
    AppMethodBeat.o(230696);
    return 0;
  }
  
  public void stopLocalAudioDumping()
  {
    AppMethodBeat.i(230874);
    TXCAudioEngineJNI.nativeStopLocalAudioDumping();
    AppMethodBeat.o(230874);
  }
  
  public void stopRemoteAudio(String paramString)
  {
    AppMethodBeat.i(230780);
    if (paramString == null)
    {
      AppMethodBeat.o(230780);
      return;
    }
    synchronized (this.mStartStopRemoteAudioMutex)
    {
      TXCAudioEngineJNI.nativeStopRemoteAudio(paramString);
      AppMethodBeat.o(230780);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioEngine
 * JD-Core Version:    0.7.0.1
 */