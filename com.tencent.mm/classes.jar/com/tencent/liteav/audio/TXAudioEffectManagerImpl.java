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
    AppMethodBeat.i(230575);
    mMusicObserverMap = new HashMap();
    mMainHandler = new Handler(Looper.getMainLooper());
    h.d();
    nativeClassInit();
    AppMethodBeat.o(230575);
  }
  
  private TXAudioEffectManagerImpl(int paramInt)
  {
    AppMethodBeat.i(230431);
    this.mPlayingMusicIDList = new ArrayList();
    this.mIdType = paramInt;
    AppMethodBeat.o(230431);
  }
  
  private static long convertIdToInt64(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  public static TXAudioEffectManagerImpl getAutoCacheHolder()
  {
    AppMethodBeat.i(230425);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerAutoCacheHolder.INSTANCE;
    AppMethodBeat.o(230425);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getCacheInstance()
  {
    AppMethodBeat.i(230421);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerCacheHolder.INSTANCE;
    AppMethodBeat.o(230421);
    return localTXAudioEffectManagerImpl;
  }
  
  public static TXAudioEffectManagerImpl getInstance()
  {
    AppMethodBeat.i(230415);
    TXAudioEffectManagerImpl localTXAudioEffectManagerImpl = AudioEffectManagerHolder.INSTANCE;
    AppMethodBeat.o(230415);
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
    AppMethodBeat.i(230436);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230426);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectFinish -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onComplete((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(230426);
      }
    });
    AppMethodBeat.o(230436);
  }
  
  public static void onEffectProgress(long paramLong1, long paramLong2, final long paramLong3)
  {
    AppMethodBeat.i(230443);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230434);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onPlayProgress((int)this.val$id, paramLong3, this.val$durationMS);
        }
        AppMethodBeat.o(230434);
      }
    });
    AppMethodBeat.o(230443);
  }
  
  public static void onEffectStart(long paramLong, int paramInt)
  {
    AppMethodBeat.i(230441);
    mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230427);
        TXCLog.i("AudioCenter:TXAudioEffectManager", "onEffectStart -> effect id = " + this.val$id + ", errCode = " + this.val$errCode);
        if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id)) != null) {
          ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(this.val$id))).onStart((int)this.val$id, this.val$errCode);
        }
        AppMethodBeat.o(230427);
      }
    });
    AppMethodBeat.o(230441);
  }
  
  public void enableVoiceEarMonitor(boolean paramBoolean)
  {
    AppMethodBeat.i(230582);
    if (this.mAudioEffectManagerListener != null) {
      this.mAudioEffectManagerListener.onSwitchVoiceEarMonitor(paramBoolean);
    }
    TXCAudioEngine.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(230582);
  }
  
  public long getAvailableBGMBytes(int paramInt)
  {
    AppMethodBeat.i(230681);
    long l = nativeGetAvailableBGMBytes(convertIdToInt64(this.mIdType, paramInt));
    AppMethodBeat.o(230681);
    return l;
  }
  
  public long getMusicCurrentPosInMS(int paramInt)
  {
    AppMethodBeat.i(230678);
    long l = nativeGetCurrentPositionInMs(convertIdToInt64(this.mIdType, paramInt));
    AppMethodBeat.o(230678);
    return l;
  }
  
  public long getMusicDurationInMS(String paramString)
  {
    AppMethodBeat.i(230692);
    long l = nativeGetDurationMSByPath(paramString);
    AppMethodBeat.o(230692);
    return l;
  }
  
  public void interruptAllMusics()
  {
    AppMethodBeat.i(230636);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "interruptAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativePause(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(230636);
  }
  
  public void pausePlayMusic(int paramInt)
  {
    AppMethodBeat.i(230630);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativePause(l);
    AppMethodBeat.o(230630);
  }
  
  public void recoverAllMusics()
  {
    AppMethodBeat.i(230640);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "recoverAllMusics");
    Iterator localIterator = this.mPlayingMusicIDList.iterator();
    while (localIterator.hasNext()) {
      nativeResume(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(230640);
  }
  
  public void resumePlayMusic(int paramInt)
  {
    AppMethodBeat.i(230632);
    long l = convertIdToInt64(this.mIdType, paramInt);
    if (!this.mPlayingMusicIDList.contains(Long.valueOf(l))) {
      this.mPlayingMusicIDList.add(Long.valueOf(l));
    }
    nativeResume(l);
    AppMethodBeat.o(230632);
  }
  
  public void seekMusicToPosInBytes(int paramInt, long paramLong)
  {
    AppMethodBeat.i(230683);
    nativeSeekToPosition(convertIdToInt64(this.mIdType, paramInt), paramLong);
    AppMethodBeat.o(230683);
  }
  
  public void seekMusicToPosInMS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230689);
    nativeSeekToTime(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230689);
  }
  
  public void setAllMusicVolume(int paramInt)
  {
    AppMethodBeat.i(230655);
    nativeSetAllVolume(paramInt);
    AppMethodBeat.o(230655);
  }
  
  public void setAudioEffectManagerListener(TXAudioEffectManagerListener paramTXAudioEffectManagerListener)
  {
    this.mAudioEffectManagerListener = paramTXAudioEffectManagerListener;
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(230608);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setMixingPlayoutVolume(f);
    AppMethodBeat.o(230608);
  }
  
  public void setMusicChangerType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230669);
    nativeSetChangerType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230669);
  }
  
  public void setMusicObserver(final int paramInt, final TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver)
  {
    AppMethodBeat.i(230615);
    paramTXMusicPlayObserver = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230429);
        if (paramTXMusicPlayObserver == null) {
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)));
        }
        for (;;)
        {
          TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", new Object[] { Integer.valueOf(TXAudioEffectManagerImpl.mMusicObserverMap.size()) });
          AppMethodBeat.o(230429);
          return;
          TXAudioEffectManagerImpl.mMusicObserverMap.put(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, paramInt)), paramTXMusicPlayObserver);
        }
      }
    };
    if (Looper.myLooper() == mMainHandler.getLooper())
    {
      paramTXMusicPlayObserver.run();
      AppMethodBeat.o(230615);
      return;
    }
    mMainHandler.post(paramTXMusicPlayObserver);
    AppMethodBeat.o(230615);
  }
  
  public void setMusicPitch(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(230659);
    nativeSetPitch(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(230659);
  }
  
  public void setMusicPlayoutSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(230666);
    nativeSetPlayoutSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(230666);
  }
  
  public void setMusicPlayoutVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230653);
    nativeSetPlayoutVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230653);
  }
  
  public void setMusicPublishVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230652);
    nativeSetPublishVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230652);
  }
  
  public void setMusicReverbType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230673);
    nativeSetReverbType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230673);
  }
  
  public void setMusicSpeedRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(230662);
    nativeSetSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
    AppMethodBeat.o(230662);
  }
  
  public void setMusicVolume(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230648);
    TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicVolume ".concat(String.valueOf(paramInt2)));
    nativeSetVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230648);
  }
  
  public void setMuteDataDurationToPublish(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230691);
    nativeSetMuteDataDurationToPublish(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
    AppMethodBeat.o(230691);
  }
  
  public void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(230602);
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
    AppMethodBeat.o(230602);
  }
  
  public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    AppMethodBeat.i(230597);
    TXCAudioEngine.getInstance().setVoiceChangerType(paramTXVoiceChangerType);
    AppMethodBeat.o(230597);
  }
  
  public void setVoiceEarMonitorVolume(int paramInt)
  {
    AppMethodBeat.i(230587);
    TXCAudioEngine.setAudioEarMonitoringVolume(paramInt);
    AppMethodBeat.o(230587);
  }
  
  public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    AppMethodBeat.i(230593);
    TXCAudioEngine.getInstance().setReverbType(paramTXVoiceReverbType);
    AppMethodBeat.o(230593);
  }
  
  public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam paramAudioMusicParam)
  {
    long l2 = 0L;
    AppMethodBeat.i(230620);
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
      AppMethodBeat.o(230620);
      return bool;
      l2 = l3;
    }
  }
  
  public void stopAllMusics()
  {
    AppMethodBeat.i(230643);
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
          AppMethodBeat.i(230408);
          TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(l));
          AppMethodBeat.o(230408);
        }
      });
    }
    this.mPlayingMusicIDList.clear();
    AppMethodBeat.o(230643);
  }
  
  public void stopPlayMusic(int paramInt)
  {
    AppMethodBeat.i(230626);
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativeStopPlay(l);
    AppMethodBeat.o(230626);
  }
  
  static class AudioEffectManagerAutoCacheHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(230371);
      INSTANCE = new TXAudioEffectManagerImpl(1, null);
      AppMethodBeat.o(230371);
    }
  }
  
  static class AudioEffectManagerCacheHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(230370);
      INSTANCE = new TXAudioEffectManagerImpl(2, null);
      AppMethodBeat.o(230370);
    }
  }
  
  static class AudioEffectManagerHolder
  {
    private static final TXAudioEffectManagerImpl INSTANCE;
    
    static
    {
      AppMethodBeat.i(230365);
      INSTANCE = new TXAudioEffectManagerImpl(0, null);
      AppMethodBeat.o(230365);
    }
  }
  
  public static abstract interface TXAudioEffectManagerListener
  {
    public abstract void onSwitchVoiceEarMonitor(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl
 * JD-Core Version:    0.7.0.1
 */