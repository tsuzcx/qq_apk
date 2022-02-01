package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
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
  private static HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mMusicObserverMap;
  private final int mIdType;
  private List<Long> mPlayingMusicIDList;
  
  static
  {
    AppMethodBeat.i(221832);
    mMusicObserverMap = new HashMap();
    mMainHandler = new Handler(Looper.getMainLooper());
    f.f();
    nativeClassInit();
    AppMethodBeat.o(221832);
  }
  
  private TXAudioEffectManagerImpl(int paramInt)
  {
    AppMethodBeat.i(221799);
    this.mPlayingMusicIDList = new ArrayList();
    this.mIdType = paramInt;
    AppMethodBeat.o(221799);
  }
  
  private static long convertIdToInt64(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  public static TXAudioEffectManagerImpl getAutoCacheHolder()
  {
    AppMethodBeat.i(221798);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerAutoCacheHolder.INSTANCE;
    AppMethodBeat.o(221798);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getCacheInstance()
  {
    AppMethodBeat.i(221797);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerCacheHolder.INSTANCE;
    AppMethodBeat.o(221797);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getInstance()
  {
    AppMethodBeat.i(221796);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerHolder.INSTANCE;
    AppMethodBeat.o(221796);
    return localTXAudioEffectManagerImpl;
  }
  
  private static native void nativeClassInit();
  
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
    AppMethodBeat.i(221828);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222014);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectFinish -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onComplete((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(222014);
      }
    });
    AppMethodBeat.o(221828);
  }
  
  public static void onEffectProgress(long paramLong1, long paramLong2, final long paramLong3)
  {
    AppMethodBeat.i(221830);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222007);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onPlayProgress((int)this.val$id, paramLong3, this.val$durationMS);
        }
        AppMethodBeat.o(222007);
      }
    });
    AppMethodBeat.o(221830);
  }
  
  public static void onEffectStart(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221829);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221868);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectStart -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onStart((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(221868);
      }
    });
    AppMethodBeat.o(221829);
  }
  
  public void enableVoiceEarMonitor(boolean paramBoolean)
  {
    AppMethodBeat.i(221800);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(221800);
  }
  
  public long getMusicCurrentPosInMS(int paramInt)
  {
    AppMethodBeat.i(221823);
    long l = nativeGetCurrentPositionInMs(convertIdToInt64(this.mIdType, paramInt));
    AppMethodBeat.o(221823);
    return l;
  }
  
  public long getMusicDurationInMS(String paramString)
  {
    AppMethodBeat.i(221827);
    long l = nativeGetDurationMSByPath(paramString);
    AppMethodBeat.o(221827);
    return l;
  }
  
  public void interruptAllMusics()
  {
    AppMethodBeat.i(221811);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "interruptAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativePause(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(221811);
  }
  
  public void pausePlayMusic(int paramInt)
  {
    AppMethodBeat.i(221809);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativePause(l);
    AppMethodBeat.o(221809);
  }
  
  public void recoverAllMusics()
  {
    AppMethodBeat.i(221812);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "recoverAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativeResume(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(221812);
  }
  
  public void resumePlayMusic(int paramInt)
  {
    AppMethodBeat.i(221810);
    long l = convertIdToInt64(this.mIdType, paramInt);
    if (!this.mPlayingMusicIDList.contains(Long.valueOf(l))) {
      this.mPlayingMusicIDList.add(Long.valueOf(l));
    }
    nativeResume(l);
    AppMethodBeat.o(221810);
  }
  
  public void seekMusicToPosInBytes(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221824);
    nativeSeekToPosition(convertIdToInt64(this.mIdType, paramInt), paramLong);
    AppMethodBeat.o(221824);
  }
  
  public void seekMusicToPosInMS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221825);
    nativeSeekToTime(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221825);
  }
  
  public void setAllMusicVolume(int paramInt)
  {
    AppMethodBeat.i(221817);
    nativeSetAllVolume(paramInt);
    AppMethodBeat.o(221817);
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(221805);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setMixingPlayoutVolume(f);
    AppMethodBeat.o(221805);
  }
  
  public void setMusicChangerType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221821);
    nativeSetChangerType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221821);
  }
  
  public void setMusicObserver(final int paramInt, final TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver)
  {
    AppMethodBeat.i(221806);
    paramTXMusicPlayObserver = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(221794);
        if (paramTXMusicPlayObserver == null) {
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)));
        }
        for (;;)
        {
          TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", new Object[] { Integer.valueOf(TXAudioEffectManagerImpl.mMusicObserverMap.size()) });
          AppMethodBeat.o(221794);
          return;
          TXAudioEffectManagerImpl.mMusicObserverMap.put(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)), paramTXMusicPlayObserver);
        }
      }
    };
    if (Looper.myLooper() == mMainHandler.getLooper())
    {
      paramTXMusicPlayObserver.run();
      AppMethodBeat.o(221806);
      return;
    }
    mMainHandler.post(paramTXMusicPlayObserver);
    AppMethodBeat.o(221806);
  }
  
  public void setMusicPitch(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221818);
    nativeSetPitch(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(221818);
  }
  
  public void setMusicPlayoutSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221820);
    nativeSetPlayoutSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(221820);
  }
  
  public void setMusicPlayoutVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221816);
    nativeSetPlayoutVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221816);
  }
  
  public void setMusicPublishVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221815);
    nativeSetPublishVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221815);
  }
  
  public void setMusicReverbType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221822);
    nativeSetReverbType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221822);
  }
  
  public void setMusicSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221819);
    nativeSetSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(221819);
  }
  
  public void setMusicVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221814);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicVolume ".concat(String.valueOf(paramInt2)));
    nativeSetVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221814);
  }
  
  public void setMuteDataDurationToPublish(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221826);
    nativeSetMuteDataDurationToPublish(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(221826);
  }
  
  public void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(221804);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
    AppMethodBeat.o(221804);
  }
  
  public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(221803);
    TXCAudioEngine.getInstance().setVoiceChangerType(paramTXVoiceChangerType);
    AppMethodBeat.o(221803);
  }
  
  public void setVoiceEarMonitorVolume(int paramInt)
  {
    AppMethodBeat.i(221801);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(221801);
  }
  
  public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(221802);
    TXCAudioEngine.getInstance().setReverbType(paramTXVoiceReverbType);
    AppMethodBeat.o(221802);
  }
  
  public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam paramAudioMusicParam)
  {
    long l2 = 0L;
    AppMethodBeat.i(221807);
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
      AppMethodBeat.o(221807);
      return bool;
      l2 = l3;
    }
  }
  
  public void stopAllMusics()
  {
    AppMethodBeat.i(221813);
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
          AppMethodBeat.i(221792);
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(l));
          AppMethodBeat.o(221792);
        }
      });
    }
    this.mPlayingMusicIDList.clear();
    AppMethodBeat.o(221813);
  }
  
  public void stopPlayMusic(int paramInt)
  {
    AppMethodBeat.i(221808);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativeStopPlay(l);
    AppMethodBeat.o(221808);
  }
  
  static class AudioEffectManagerAutoCacheHolder
  {
    private static TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(221793);
      INSTANCE = new TXAudioEffectManagerImpl(1, null);
      AppMethodBeat.o(221793);
    }
  }
  
  static class AudioEffectManagerCacheHolder
  {
    private static TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(221853);
      INSTANCE = new TXAudioEffectManagerImpl(2, null);
      AppMethodBeat.o(221853);
    }
  }
  
  static class AudioEffectManagerHolder
  {
    private static TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(221795);
      INSTANCE = new TXAudioEffectManagerImpl(0, null);
      AppMethodBeat.o(221795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl
 * JD-Core Version:    0.7.0.1
 */