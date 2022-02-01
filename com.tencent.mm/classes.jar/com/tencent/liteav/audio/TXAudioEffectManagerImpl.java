package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TXAudioEffectManagerImpl
  implements TXAudioEffectManager
{
  private static final int EFFECT_PLAYER_ID_TYPE = 2;
  private static final int NEW_BGM_PLAYER_ID_TYPE = 1;
  private static final int OLD_BGM_PLAYER_ID_TYPE = 0;
  private static final String TAG = "AudioCenter:TXAudioEffectManager";
  private static final Handler mMainHandler;
  private static final HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mMusicObserverMap;
  private TXAudioEffectManagerListener mAudioEffectManagerListener;
  private final int mIdType;
  private final List<Long> mPlayingMusicIDList;
  
  static
  {
    AppMethodBeat.i(248332);
    mMusicObserverMap = new HashMap();
    mMainHandler = new Handler(Looper.getMainLooper());
    h.f();
    nativeClassInit();
    AppMethodBeat.o(248332);
  }
  
  private TXAudioEffectManagerImpl(int paramInt)
  {
    AppMethodBeat.i(248244);
    this.mPlayingMusicIDList = new ArrayList();
    this.mIdType = paramInt;
    AppMethodBeat.o(248244);
  }
  
  private static long convertIdToInt64(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  public static TXAudioEffectManagerImpl getAutoCacheHolder()
  {
    AppMethodBeat.i(248242);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerAutoCacheHolder.INSTANCE;
    AppMethodBeat.o(248242);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getCacheInstance()
  {
    AppMethodBeat.i(248239);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerCacheHolder.INSTANCE;
    AppMethodBeat.o(248239);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getInstance()
  {
    AppMethodBeat.i(248237);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerHolder.INSTANCE;
    AppMethodBeat.o(248237);
    return localTXAudioEffectManagerImpl;
  }
  
  private static native void nativeClassInit();
  
  private native long nativeGetAvailableBGMBytes(long paramLong);
  
  private native long nativeGetCurrentPositionInMs(long paramLong);
  
  private static native long nativeGetDurationMSByPath(String paramString);
  
  private native void nativePause(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeSeekToPosition(long paramLong1, long paramLong2);
  
  private native void nativeSeekToTime(long paramLong, int paramInt);
  
  private native void nativeSetAllVolume(int paramInt);
  
  private native void nativeSetChangerType(long paramLong, int paramInt);
  
  private native void nativeSetMuteDataDurationToPublish(long paramLong, int paramInt);
  
  private native void nativeSetPitch(long paramLong, float paramFloat);
  
  private native void nativeSetPlayoutSpeedRate(long paramLong, float paramFloat);
  
  private native void nativeSetPlayoutVolume(long paramLong, int paramInt);
  
  private native void nativeSetPublishVolume(long paramLong, int paramInt);
  
  private native void nativeSetReverbType(long paramLong, int paramInt);
  
  private native void nativeSetSpeedRate(long paramLong, float paramFloat);
  
  private native void nativeSetVolume(long paramLong, int paramInt);
  
  private native boolean nativeStartPlay(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeStartPlayRange(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeStopPlay(long paramLong);
  
  public static void onEffectFinish(long paramLong, int paramInt)
  {
    AppMethodBeat.i(248297);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247817);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectFinish -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onComplete((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(247817);
      }
    });
    AppMethodBeat.o(248297);
  }
  
  public static void onEffectProgress(long paramLong1, long paramLong2, final long paramLong3)
  {
    AppMethodBeat.i(248304);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(246966);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onPlayProgress((int)this.val$id, paramLong3, this.val$durationMS);
        }
        AppMethodBeat.o(246966);
      }
    });
    AppMethodBeat.o(248304);
  }
  
  public static void onEffectStart(long paramLong, int paramInt)
  {
    AppMethodBeat.i(248300);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247597);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectStart -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onStart((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(247597);
      }
    });
    AppMethodBeat.o(248300);
  }
  
  public void enableVoiceEarMonitor(boolean paramBoolean)
  {
    AppMethodBeat.i(248245);
    if (this.mAudioEffectManagerListener != null) {
      this.mAudioEffectManagerListener.onSwitchVoiceEarMonitor(paramBoolean);
    }
    TXCAudioEngine.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(248245);
  }
  
  public long getAvailableBGMBytes(int paramInt)
  {
    AppMethodBeat.i(248288);
    long l = nativeGetAvailableBGMBytes(convertIdToInt64(this.mIdType, paramInt));
    AppMethodBeat.o(248288);
    return l;
  }
  
  public long getMusicCurrentPosInMS(int paramInt)
  {
    AppMethodBeat.i(248286);
    long l = nativeGetCurrentPositionInMs(convertIdToInt64(this.mIdType, paramInt));
    AppMethodBeat.o(248286);
    return l;
  }
  
  public long getMusicDurationInMS(String paramString)
  {
    AppMethodBeat.i(248295);
    long l = nativeGetDurationMSByPath(paramString);
    AppMethodBeat.o(248295);
    return l;
  }
  
  public void interruptAllMusics()
  {
    AppMethodBeat.i(248269);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "interruptAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativePause(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(248269);
  }
  
  public void pausePlayMusic(int paramInt)
  {
    AppMethodBeat.i(248265);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativePause(l);
    AppMethodBeat.o(248265);
  }
  
  public void recoverAllMusics()
  {
    AppMethodBeat.i(248270);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "recoverAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativeResume(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(248270);
  }
  
  public void resumePlayMusic(int paramInt)
  {
    AppMethodBeat.i(248267);
    long l = convertIdToInt64(this.mIdType, paramInt);
    if (!this.mPlayingMusicIDList.contains(Long.valueOf(l))) {
      this.mPlayingMusicIDList.add(Long.valueOf(l));
    }
    nativeResume(l);
    AppMethodBeat.o(248267);
  }
  
  public void seekMusicToPosInBytes(int paramInt, long paramLong)
  {
    AppMethodBeat.i(248289);
    nativeSeekToPosition(convertIdToInt64(this.mIdType, paramInt), paramLong);
    AppMethodBeat.o(248289);
  }
  
  public void seekMusicToPosInMS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248291);
    nativeSeekToTime(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248291);
  }
  
  public void setAllMusicVolume(int paramInt)
  {
    AppMethodBeat.i(248277);
    nativeSetAllVolume(paramInt);
    AppMethodBeat.o(248277);
  }
  
  public void setAudioEffectManagerListener(TXAudioEffectManagerListener paramTXAudioEffectManagerListener)
  {
    this.mAudioEffectManagerListener = paramTXAudioEffectManagerListener;
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(248258);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setMixingPlayoutVolume(f);
    AppMethodBeat.o(248258);
  }
  
  public void setMusicChangerType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248283);
    nativeSetChangerType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248283);
  }
  
  public void setMusicObserver(final int paramInt, final TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver)
  {
    AppMethodBeat.i(248260);
    paramTXMusicPlayObserver = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(247575);
        if (paramTXMusicPlayObserver == null) {
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)));
        }
        for (;;)
        {
          TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", new Object[] { Integer.valueOf(TXAudioEffectManagerImpl.mMusicObserverMap.size()) });
          AppMethodBeat.o(247575);
          return;
          TXAudioEffectManagerImpl.mMusicObserverMap.put(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)), paramTXMusicPlayObserver);
        }
      }
    };
    if (Looper.myLooper() == mMainHandler.getLooper())
    {
      paramTXMusicPlayObserver.run();
      AppMethodBeat.o(248260);
      return;
    }
    mMainHandler.post(paramTXMusicPlayObserver);
    AppMethodBeat.o(248260);
  }
  
  public void setMusicPitch(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(248278);
    nativeSetPitch(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(248278);
  }
  
  public void setMusicPlayoutSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(248281);
    nativeSetPlayoutSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(248281);
  }
  
  public void setMusicPlayoutVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248275);
    nativeSetPlayoutVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248275);
  }
  
  public void setMusicPublishVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248273);
    nativeSetPublishVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248273);
  }
  
  public void setMusicReverbType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248285);
    nativeSetReverbType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248285);
  }
  
  public void setMusicSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(248279);
    nativeSetSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(248279);
  }
  
  public void setMusicVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248272);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicVolume ".concat(String.valueOf(paramInt2)));
    nativeSetVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248272);
  }
  
  public void setMuteDataDurationToPublish(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248293);
    nativeSetMuteDataDurationToPublish(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(248293);
  }
  
  public void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(248255);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
    AppMethodBeat.o(248255);
  }
  
  public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(248253);
    TXCAudioEngine.getInstance().setVoiceChangerType(paramTXVoiceChangerType);
    AppMethodBeat.o(248253);
  }
  
  public void setVoiceEarMonitorVolume(int paramInt)
  {
    AppMethodBeat.i(248248);
    TXCAudioEngine.setAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(248248);
  }
  
  public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(248250);
    TXCAudioEngine.getInstance().setReverbType(paramTXVoiceReverbType);
    AppMethodBeat.o(248250);
  }
  
  public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam paramAudioMusicParam)
  {
    long l2 = 0L;
    AppMethodBeat.i(248262);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "startPlay");
    long l4 = paramAudioMusicParam.startTimeMS;
    long l3 = paramAudioMusicParam.endTimeMS;
    long l1 = l4;
    if (l4 < 0L) {
      l1 = 0L;
    }
    if (l3 < 0L) {}
    for (;;)
    {
      l3 = convertIdToInt64(this.mIdType, paramAudioMusicParam.id);
      if (!this.mPlayingMusicIDList.contains(Long.valueOf(l3))) {
        this.mPlayingMusicIDList.add(Long.valueOf(l3));
      }
      nativeStartPlayRange(l3, l1, l2);
      boolean bool = nativeStartPlay(l3, paramAudioMusicParam.path, paramAudioMusicParam.loopCount, paramAudioMusicParam.publish, paramAudioMusicParam.isShortFile);
      AppMethodBeat.o(248262);
      return bool;
      l2 = l3;
    }
  }
  
  public void stopAllMusics()
  {
    AppMethodBeat.i(248271);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "stopAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext())
    {
      final long l = ((Long)localIterator.next()).longValue();
      nativeStopPlay(l);
      mMainHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(247729);
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(l));
          AppMethodBeat.o(247729);
        }
      });
    }
    this.mPlayingMusicIDList.clear();
    AppMethodBeat.o(248271);
  }
  
  public void stopPlayMusic(int paramInt)
  {
    AppMethodBeat.i(248263);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativeStopPlay(l);
    AppMethodBeat.o(248263);
  }
  
  static class AudioEffectManagerAutoCacheHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(245995);
      INSTANCE = new TXAudioEffectManagerImpl(1, null);
      AppMethodBeat.o(245995);
    }
  }
  
  static class AudioEffectManagerCacheHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(247505);
      INSTANCE = new TXAudioEffectManagerImpl(2, null);
      AppMethodBeat.o(247505);
    }
  }
  
  static class AudioEffectManagerHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(248056);
      INSTANCE = new TXAudioEffectManagerImpl(0, null);
      AppMethodBeat.o(248056);
    }
  }
  
  public static abstract interface TXAudioEffectManagerListener
  {
    public abstract void onSwitchVoiceEarMonitor(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl
 * JD-Core Version:    0.7.0.1
 */