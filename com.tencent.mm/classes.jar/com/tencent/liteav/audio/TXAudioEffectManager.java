package com.tencent.liteav.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface TXAudioEffectManager
{
  public abstract void enableVoiceEarMonitor(boolean paramBoolean);
  
  public abstract long getMusicCurrentPosInMS(int paramInt);
  
  public abstract long getMusicDurationInMS(String paramString);
  
  public abstract void pausePlayMusic(int paramInt);
  
  public abstract void resumePlayMusic(int paramInt);
  
  public abstract void seekMusicToPosInMS(int paramInt1, int paramInt2);
  
  public abstract void setAllMusicVolume(int paramInt);
  
  public abstract void setMusicObserver(int paramInt, TXMusicPlayObserver paramTXMusicPlayObserver);
  
  public abstract void setMusicPitch(int paramInt, float paramFloat);
  
  public abstract void setMusicPlayoutVolume(int paramInt1, int paramInt2);
  
  public abstract void setMusicPublishVolume(int paramInt1, int paramInt2);
  
  public abstract void setMusicSpeedRate(int paramInt, float paramFloat);
  
  public abstract void setVoiceCaptureVolume(int paramInt);
  
  public abstract void setVoiceChangerType(TXVoiceChangerType paramTXVoiceChangerType);
  
  public abstract void setVoiceEarMonitorVolume(int paramInt);
  
  public abstract void setVoiceReverbType(TXVoiceReverbType paramTXVoiceReverbType);
  
  public abstract boolean startPlayMusic(AudioMusicParam paramAudioMusicParam);
  
  public abstract void stopPlayMusic(int paramInt);
  
  public static class AudioMusicParam
  {
    public long endTimeMS;
    public int id;
    public boolean isShortFile;
    public int loopCount;
    public String path;
    public boolean publish;
    public long startTimeMS;
    
    public AudioMusicParam(int paramInt, String paramString)
    {
      this.path = paramString;
      this.id = paramInt;
      this.loopCount = 0;
      this.publish = false;
      this.isShortFile = false;
      this.startTimeMS = 0L;
      this.endTimeMS = -1L;
    }
  }
  
  public static abstract interface TXMusicPlayObserver
  {
    public abstract void onComplete(int paramInt1, int paramInt2);
    
    public abstract void onPlayProgress(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void onStart(int paramInt1, int paramInt2);
  }
  
  public static enum TXVoiceChangerType
  {
    private int nativeValue;
    
    static
    {
      AppMethodBeat.i(230420);
      TXLiveVoiceChangerType_0 = new TXVoiceChangerType("TXLiveVoiceChangerType_0", 0, 0);
      TXLiveVoiceChangerType_1 = new TXVoiceChangerType("TXLiveVoiceChangerType_1", 1, 1);
      TXLiveVoiceChangerType_2 = new TXVoiceChangerType("TXLiveVoiceChangerType_2", 2, 2);
      TXLiveVoiceChangerType_3 = new TXVoiceChangerType("TXLiveVoiceChangerType_3", 3, 3);
      TXLiveVoiceChangerType_4 = new TXVoiceChangerType("TXLiveVoiceChangerType_4", 4, 4);
      TXLiveVoiceChangerType_5 = new TXVoiceChangerType("TXLiveVoiceChangerType_5", 5, 5);
      TXLiveVoiceChangerType_6 = new TXVoiceChangerType("TXLiveVoiceChangerType_6", 6, 6);
      TXLiveVoiceChangerType_7 = new TXVoiceChangerType("TXLiveVoiceChangerType_7", 7, 7);
      TXLiveVoiceChangerType_8 = new TXVoiceChangerType("TXLiveVoiceChangerType_8", 8, 8);
      TXLiveVoiceChangerType_9 = new TXVoiceChangerType("TXLiveVoiceChangerType_9", 9, 9);
      TXLiveVoiceChangerType_10 = new TXVoiceChangerType("TXLiveVoiceChangerType_10", 10, 10);
      TXLiveVoiceChangerType_11 = new TXVoiceChangerType("TXLiveVoiceChangerType_11", 11, 11);
      $VALUES = new TXVoiceChangerType[] { TXLiveVoiceChangerType_0, TXLiveVoiceChangerType_1, TXLiveVoiceChangerType_2, TXLiveVoiceChangerType_3, TXLiveVoiceChangerType_4, TXLiveVoiceChangerType_5, TXLiveVoiceChangerType_6, TXLiveVoiceChangerType_7, TXLiveVoiceChangerType_8, TXLiveVoiceChangerType_9, TXLiveVoiceChangerType_10, TXLiveVoiceChangerType_11 };
      AppMethodBeat.o(230420);
    }
    
    private TXVoiceChangerType(int paramInt)
    {
      this.nativeValue = paramInt;
    }
    
    public final int getNativeValue()
    {
      return this.nativeValue;
    }
  }
  
  public static enum TXVoiceReverbType
  {
    private int nativeValue;
    
    static
    {
      AppMethodBeat.i(230531);
      TXLiveVoiceReverbType_0 = new TXVoiceReverbType("TXLiveVoiceReverbType_0", 0, 0);
      TXLiveVoiceReverbType_1 = new TXVoiceReverbType("TXLiveVoiceReverbType_1", 1, 1);
      TXLiveVoiceReverbType_2 = new TXVoiceReverbType("TXLiveVoiceReverbType_2", 2, 2);
      TXLiveVoiceReverbType_3 = new TXVoiceReverbType("TXLiveVoiceReverbType_3", 3, 3);
      TXLiveVoiceReverbType_4 = new TXVoiceReverbType("TXLiveVoiceReverbType_4", 4, 4);
      TXLiveVoiceReverbType_5 = new TXVoiceReverbType("TXLiveVoiceReverbType_5", 5, 5);
      TXLiveVoiceReverbType_6 = new TXVoiceReverbType("TXLiveVoiceReverbType_6", 6, 6);
      TXLiveVoiceReverbType_7 = new TXVoiceReverbType("TXLiveVoiceReverbType_7", 7, 7);
      $VALUES = new TXVoiceReverbType[] { TXLiveVoiceReverbType_0, TXLiveVoiceReverbType_1, TXLiveVoiceReverbType_2, TXLiveVoiceReverbType_3, TXLiveVoiceReverbType_4, TXLiveVoiceReverbType_5, TXLiveVoiceReverbType_6, TXLiveVoiceReverbType_7 };
      AppMethodBeat.o(230531);
    }
    
    private TXVoiceReverbType(int paramInt)
    {
      this.nativeValue = paramInt;
    }
    
    public final int getNativeValue()
    {
      return this.nativeValue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManager
 * JD-Core Version:    0.7.0.1
 */