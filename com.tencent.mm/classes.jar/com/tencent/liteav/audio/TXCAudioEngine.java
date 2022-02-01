package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TXCAudioEngine
  implements b
{
  private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
  private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
  private static final String TAG = "AudioEngine :TXCAudioEngine_java";
  private static volatile boolean has_init;
  private static boolean has_trae;
  private static WeakReference<d> mAudioCoreDataListener;
  protected static Context mContext;
  protected static final HashMap<String, WeakReference<d>> mJitterDataListenerMap;
  private static final Object mJitterDataListenerMapLock;
  protected static final HashMap<String, WeakReference<c>> mJitterEventListenerMap;
  private static final Object mJitterEventListenerMapLock;
  static TXCAudioEngine sInstance;
  private final ArrayList<WeakReference<com.tencent.liteav.basic.b.a>> mCallbackList;
  protected boolean mDeviceIsRecording;
  protected boolean mIsCallComed;
  protected boolean mIsCustomRecord;
  
  static
  {
    AppMethodBeat.i(222005);
    sInstance = new TXCAudioEngine();
    mContext = null;
    has_trae = false;
    mAudioCoreDataListener = null;
    mJitterDataListenerMap = new HashMap();
    mJitterDataListenerMapLock = new Object();
    mJitterEventListenerMap = new HashMap();
    mJitterEventListenerMapLock = new Object();
    has_init = false;
    AppMethodBeat.o(222005);
  }
  
  private TXCAudioEngine()
  {
    AppMethodBeat.i(221933);
    this.mCallbackList = new ArrayList();
    this.mDeviceIsRecording = false;
    this.mIsCustomRecord = false;
    this.mIsCallComed = false;
    AppMethodBeat.o(221933);
  }
  
  public static void CreateInstance(Context paramContext, String paramString)
  {
    try
    {
      AppMethodBeat.i(221934);
      CreateInstanceWithoutInitDevice(paramContext, paramString);
      TXCAudioEngineJNI.nativeInitAudioDevice();
      AppMethodBeat.o(221934);
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
        AppMethodBeat.i(221935);
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance: ");
        mContext = paramContext.getApplicationContext();
        if (has_init)
        {
          TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance already created~ ");
          AppMethodBeat.o(221935);
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
          AppMethodBeat.o(221935);
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
    AppMethodBeat.i(222003);
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
      long l = a.a().b("timestamp_rollback_to_stable_samplerate", 0L);
      if (System.currentTimeMillis() - l >= paramLong) {
        break label445;
      }
    }
    label445:
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
            paramContext = (String)localObject + "  component 1\n";
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
      AppMethodBeat.o(222003);
      return paramContext;
      paramBoolean = "y";
      break;
    }
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean)
  {
    AppMethodBeat.i(221990);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioEarMonitoring: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(221990);
  }
  
  public static boolean enableAudioVolumeEvaluation(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(221936);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableAudioVolumeEvaluation : " + paramBoolean + "interval:" + paramInt);
    TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(paramBoolean, paramInt);
    AppMethodBeat.o(221936);
    return true;
  }
  
  public static TXCAudioEngine getInstance()
  {
    return sInstance;
  }
  
  private static int getLowLatencySampleRate(Context paramContext)
  {
    AppMethodBeat.i(222004);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        try
        {
          int i = Integer.parseInt(paramContext.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
          AppMethodBeat.o(222004);
          return i;
        }
        catch (NumberFormatException paramContext)
        {
          TXCLog.e("AudioEngine :TXCAudioEngine_java", "can't parse low latency samplerate", paramContext);
        }
      }
    }
    AppMethodBeat.o(222004);
    return -1;
  }
  
  public static int getMixingPlayoutVolumeLevel()
  {
    AppMethodBeat.i(221986);
    int i = TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
    AppMethodBeat.o(221986);
    return i;
  }
  
  private void handleAudioEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221982);
    if (paramInt == 10055)
    {
      a.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
      AppMethodBeat.o(221982);
      return;
    }
    if (paramInt == 10056)
    {
      a.a().a("timestamp_rollback_to_stable_samplerate", 0L);
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "audio device restart when using stable samplerate");
    }
    AppMethodBeat.o(221982);
  }
  
  public static boolean hasTrae()
  {
    return has_trae;
  }
  
  public static void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(221973);
    c localc = null;
    synchronized (mJitterEventListenerMapLock)
    {
      if (mJitterEventListenerMap.get(paramString1) != null) {
        localc = (c)((WeakReference)mJitterEventListenerMap.get(paramString1)).get();
      }
      if (localc != null)
      {
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "onAudioJitterBufferNotify  cur state ".concat(String.valueOf(paramInt)));
        localc.onAudioJitterBufferNotify(paramString1, paramInt, paramString2);
      }
      AppMethodBeat.o(221973);
      return;
    }
  }
  
  public static void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221971);
    d locald = null;
    synchronized (mJitterDataListenerMapLock)
    {
      if (mJitterDataListenerMap.get(paramString) != null) {
        locald = (d)((WeakReference)mJitterDataListenerMap.get(paramString)).get();
      }
      if (locald != null) {
        locald.onAudioPlayPcmData(paramString, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
      AppMethodBeat.o(221971);
      return;
    }
  }
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221985);
    if (mAudioCoreDataListener != null)
    {
      d locald = (d)mAudioCoreDataListener.get();
      if (locald != null) {
        locald.onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(221985);
  }
  
  public static void setAudioEarMonitoringVolume(int paramInt)
  {
    AppMethodBeat.i(221991);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioEarMonitoringVolume: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(221991);
  }
  
  public static void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(221988);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setAudioRoute: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetAudioRoute(paramInt);
    AppMethodBeat.o(221988);
  }
  
  public static void setPlayoutDataListener(d paramd)
  {
    AppMethodBeat.i(221984);
    mAudioCoreDataListener = new WeakReference(paramd);
    if (paramd == null) {}
    for (boolean bool = false;; bool = true)
    {
      TXCAudioEngineJNI.nativeSetPlayoutDataListener(bool);
      AppMethodBeat.o(221984);
      return;
    }
  }
  
  public static void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(221989);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setSystemVolumeType: ".concat(String.valueOf(paramInt)));
    TXCAudioEngineJNI.nativeSetSystemVolumeType(paramInt);
    AppMethodBeat.o(221989);
  }
  
  public void EnableMixMode(boolean paramBoolean)
  {
    AppMethodBeat.i(221947);
    TXCAudioEngineJNI.nativeEnableMixMode(paramBoolean);
    AppMethodBeat.o(221947);
  }
  
  public void addEventCallback(WeakReference<com.tencent.liteav.basic.b.a> paramWeakReference)
  {
    AppMethodBeat.i(221980);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(221980);
      return;
    }
    synchronized (this.mCallbackList)
    {
      this.mCallbackList.add(paramWeakReference);
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
      AppMethodBeat.o(221980);
      return;
    }
  }
  
  public void clean()
  {
    AppMethodBeat.i(221998);
    TXCAudioEngineJNI.nativeClean();
    AppMethodBeat.o(221998);
  }
  
  public void enableAutoRestartDevice(boolean paramBoolean)
  {
    AppMethodBeat.i(222001);
    TXCAudioEngineJNI.nativeEnableAutoRestartDevice(paramBoolean);
    AppMethodBeat.o(222001);
  }
  
  public boolean enableCaptureEOSMode(boolean paramBoolean)
  {
    AppMethodBeat.i(221965);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableEosMode ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeEnableCaptureEOSMode(paramBoolean);
    AppMethodBeat.o(221965);
    return true;
  }
  
  public void enableEncodedDataCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(221949);
    TXCAudioEngineJNI.nativeEnableEncodedDataCallback(paramBoolean);
    AppMethodBeat.o(221949);
  }
  
  public void enableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(221948);
    TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(paramBoolean);
    AppMethodBeat.o(221948);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(221959);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAEC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAEC(paramInt);
    AppMethodBeat.o(221959);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(221961);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftAGC: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAGC(paramInt);
    AppMethodBeat.o(221961);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(221960);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "enableSoftANS: enable = " + paramBoolean + " level = " + paramInt);
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftANS(paramInt);
    AppMethodBeat.o(221960);
  }
  
  public void forceCallbackMixedPlayAudioFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(221999);
    TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(paramBoolean);
    AppMethodBeat.o(221999);
  }
  
  public int getAECType()
  {
    return 2;
  }
  
  public TXCAudioEncoderConfig getAudioEncoderConfig()
  {
    AppMethodBeat.i(221942);
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngineJNI.nativeGetEncoderConfig();
    AppMethodBeat.o(221942);
    return localTXCAudioEncoderConfig;
  }
  
  public int getEncoderChannels()
  {
    AppMethodBeat.i(221941);
    int i = TXCAudioEngineJNI.nativeGetEncoderChannels();
    AppMethodBeat.o(221941);
    return i;
  }
  
  public int getEncoderSampleRate()
  {
    AppMethodBeat.i(221940);
    int i = TXCAudioEngineJNI.nativeGetEncoderSampleRate();
    AppMethodBeat.o(221940);
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
    AppMethodBeat.i(221979);
    if (paramString == null)
    {
      AppMethodBeat.o(221979);
      return 0;
    }
    int i = TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(paramString);
    AppMethodBeat.o(221979);
    return i;
  }
  
  public int getSoftwareCaptureVolumeLevel()
  {
    AppMethodBeat.i(221967);
    int i = TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
    AppMethodBeat.o(221967);
    return i;
  }
  
  public StatusBucket getStatus(int paramInt)
  {
    AppMethodBeat.i(221987);
    StatusBucket localStatusBucket = TXCAudioEngineJNI.getStatus(paramInt);
    AppMethodBeat.o(221987);
    return localStatusBucket;
  }
  
  public boolean isAudioDeviceCapturing()
  {
    AppMethodBeat.i(221966);
    boolean bool = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "isRecording: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(221966);
    return bool;
  }
  
  public boolean isRemoteAudioPlaying(String paramString)
  {
    AppMethodBeat.i(221978);
    if (paramString == null)
    {
      AppMethodBeat.o(221978);
      return false;
    }
    boolean bool = TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(paramString);
    AppMethodBeat.o(221978);
    return bool;
  }
  
  public boolean muteLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(221955);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.nativeMuteLocalAudio(paramBoolean);
    AppMethodBeat.o(221955);
    return true;
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(221975);
    if (paramString == null)
    {
      AppMethodBeat.o(221975);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(221975);
  }
  
  public void muteRemoteAudioInSpeaker(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(221976);
    if (paramString == null)
    {
      AppMethodBeat.o(221976);
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(paramString, paramBoolean);
    AppMethodBeat.o(221976);
  }
  
  public void onCallStateChanged(int paramInt)
  {
    AppMethodBeat.i(222000);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(222000);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_RINGING!");
      AppMethodBeat.o(222000);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_OFFHOOK!");
      TXCAudioEngineJNI.pauseAudioCapture(true);
      TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
      this.mIsCallComed = true;
      AppMethodBeat.o(222000);
      return;
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_IDLE!");
      if (this.mIsCallComed)
      {
        this.mIsCallComed = false;
        TXCAudioEngineJNI.resumeAudioCapture();
        TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
      }
    }
  }
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221983);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(221983);
          return;
        }
        localIterator = this.mCallbackList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.liteav.basic.b.a locala = (com.tencent.liteav.basic.b.a)((WeakReference)localIterator.next()).get();
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
      ((com.tencent.liteav.basic.b.a)((Iterator)???).next()).onError(paramString1, paramInt, paramString2, paramString3);
    }
    AppMethodBeat.o(221983);
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221981);
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCallbackList)
      {
        if (this.mCallbackList.size() <= 0)
        {
          AppMethodBeat.o(221981);
          return;
        }
        localIterator = this.mCallbackList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.liteav.basic.b.a locala = (com.tencent.liteav.basic.b.a)((WeakReference)localIterator.next()).get();
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
      ((com.tencent.liteav.basic.b.a)((Iterator)???).next()).onEvent(paramString1, paramInt, paramString2, paramString3);
    }
    AppMethodBeat.o(221981);
  }
  
  public int pauseAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(221950);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "pauseAudioCapture: ".concat(String.valueOf(paramBoolean)));
    TXCAudioEngineJNI.pauseAudioCapture(paramBoolean);
    AppMethodBeat.o(221950);
    return 0;
  }
  
  public void pauseLocalAudio()
  {
    AppMethodBeat.i(221945);
    TXCAudioEngineJNI.nativePauseLocalAudio();
    AppMethodBeat.o(221945);
  }
  
  public int resumeAudioCapture()
  {
    AppMethodBeat.i(221951);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "resumeRecord");
    TXCAudioEngineJNI.resumeAudioCapture();
    AppMethodBeat.o(221951);
    return 0;
  }
  
  public void resumeLocalAudio()
  {
    AppMethodBeat.i(221946);
    TXCAudioEngineJNI.nativeResumeLocalAudio();
    AppMethodBeat.o(221946);
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(221953);
    TXCAudioEngineJNI.sendCustomPCMData(parama);
    AppMethodBeat.o(221953);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221952);
    TXCAudioEngineJNI.sendCustomPCMData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(221952);
  }
  
  public boolean setAudioCaptureDataListener(e parame)
  {
    AppMethodBeat.i(221954);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordListener ");
    if (parame == null) {
      TXCAudioEngineJNI.setAudioCaptureDataListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(221954);
      return true;
      TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference(parame));
    }
  }
  
  public void setAudioDumpingListener(TXCAudioEngineJNI.a parama)
  {
    AppMethodBeat.i(221994);
    TXCAudioEngineJNI.SetAudioDumpingListener(parama);
    AppMethodBeat.o(221994);
  }
  
  public boolean setAudioEncoderParam(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221964);
    TXCAudioEngineJNI.nativeSetAudioEncoderParam(paramInt1, paramInt2);
    AppMethodBeat.o(221964);
    return true;
  }
  
  public void setAudioQuality(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221937);
    TXCAudioEngineJNI.nativeSetAudioQuality(paramInt1, paramInt2);
    AppMethodBeat.o(221937);
  }
  
  public void setCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221995);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setCaptureDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221995);
  }
  
  public void setEncoderChannels(int paramInt)
  {
    AppMethodBeat.i(221939);
    TXCAudioEngineJNI.nativeSetEncoderChannels(paramInt);
    AppMethodBeat.o(221939);
  }
  
  public boolean setEncoderFECPercent(float paramFloat)
  {
    AppMethodBeat.i(221963);
    TXCAudioEngineJNI.nativeSetEncoderFECPercent(paramFloat);
    AppMethodBeat.o(221963);
    return true;
  }
  
  public void setEncoderSampleRate(int paramInt)
  {
    AppMethodBeat.i(221938);
    TXCAudioEngineJNI.nativeSetEncoderSampleRate(paramInt);
    AppMethodBeat.o(221938);
  }
  
  public void setMaxSelectedPlayStreams(int paramInt)
  {
    AppMethodBeat.i(222002);
    TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(paramInt);
    AppMethodBeat.o(222002);
  }
  
  public boolean setMixingPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(221958);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(paramFloat);
    AppMethodBeat.o(221958);
    return true;
  }
  
  public void setPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221996);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setPlayoutDataCallbackFormat: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221996);
  }
  
  public void setRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221974);
    TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(paramString, paramBoolean, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221974);
  }
  
  public void setRemoteAudioStreamEventListener(String paramString, c paramc)
  {
    AppMethodBeat.i(221972);
    if (paramString == null)
    {
      AppMethodBeat.o(221972);
      return;
    }
    synchronized (mJitterEventListenerMapLock)
    {
      mJitterEventListenerMap.put(paramString, new WeakReference(paramc));
      AppMethodBeat.o(221972);
      return;
    }
  }
  
  public void setRemotePlayoutVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(221977);
    if (paramString == null)
    {
      AppMethodBeat.o(221977);
      return;
    }
    TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(paramString, paramInt);
    AppMethodBeat.o(221977);
  }
  
  public void setRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221997);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRemoteStreamDataCallbackFormat: id-" + paramString + " sampleRate-" + paramInt1 + " channels-" + paramInt2 + " length-" + paramInt3);
    TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221997);
  }
  
  public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(221956);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setReverbType: " + paramTXVoiceReverbType.getNativeValue());
    TXCAudioEngineJNI.nativeSetRecordReverb(paramTXVoiceReverbType.getNativeValue());
    AppMethodBeat.o(221956);
    return true;
  }
  
  public void setSetAudioEngineRemoteStreamDataListener(String paramString, d paramd)
  {
    AppMethodBeat.i(221970);
    if (paramString == null)
    {
      AppMethodBeat.o(221970);
      return;
    }
    for (;;)
    {
      synchronized (mJitterDataListenerMapLock)
      {
        mJitterDataListenerMap.put(paramString, new WeakReference(paramd));
        if (paramd == null)
        {
          bool = false;
          TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(paramString, bool);
          AppMethodBeat.o(221970);
          return;
        }
      }
      boolean bool = true;
    }
  }
  
  public boolean setSoftwareCaptureVolume(float paramFloat)
  {
    AppMethodBeat.i(221957);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordVolume: ".concat(String.valueOf(paramFloat)));
    TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(paramFloat);
    AppMethodBeat.o(221957);
    return true;
  }
  
  public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(221962);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setVoiceChangerType " + paramTXVoiceChangerType.getNativeValue());
    TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(paramTXVoiceChangerType.getNativeValue());
    AppMethodBeat.o(221962);
    return true;
  }
  
  public int startLocalAudio(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221943);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "startLocalAudio audioFormat:".concat(String.valueOf(paramInt)));
    if (mContext == null)
    {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "Please call CreateInstance fisrt!!!");
      AppMethodBeat.o(221943);
      return -901;
    }
    TXCAudioEngineJNI.InitTraeEngineLibrary(mContext);
    TXCAudioEngineJNI.nativeStartLocalAudio(paramInt, paramBoolean);
    this.mDeviceIsRecording = true;
    AppMethodBeat.o(221943);
    return 0;
  }
  
  public int startLocalAudioDumping(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(221992);
    paramInt1 = TXCAudioEngineJNI.nativeStartLocalAudioDumping(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(221992);
    return paramInt1;
  }
  
  public void startRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(221968);
    TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, paramBoolean, paramString);
    TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(paramString, com.tencent.liteav.basic.d.c.a().a("Audio", "LIVE_JitterCycle"));
    TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(paramString, com.tencent.liteav.basic.d.c.a().a("Audio", "LoadingThreshold"));
    AppMethodBeat.o(221968);
  }
  
  public int stopLocalAudio()
  {
    AppMethodBeat.i(221944);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "stopLocalAudio");
    TXCAudioEngineJNI.nativeStopLocalAudio();
    this.mDeviceIsRecording = false;
    AppMethodBeat.o(221944);
    return 0;
  }
  
  public void stopLocalAudioDumping()
  {
    AppMethodBeat.i(221993);
    TXCAudioEngineJNI.nativeStopLocalAudioDumping();
    AppMethodBeat.o(221993);
  }
  
  public void stopRemoteAudio(String paramString)
  {
    AppMethodBeat.i(221969);
    if (paramString == null)
    {
      AppMethodBeat.o(221969);
      return;
    }
    TXCAudioEngineJNI.nativeStopRemoteAudio(paramString);
    AppMethodBeat.o(221969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioEngine
 * JD-Core Version:    0.7.0.1
 */