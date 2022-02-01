package com.tencent.liteav.audio;

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
  
  public abstract void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType);
  
  public abstract void setVoiceEarMonitorVolume(int paramInt);
  
  public abstract void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType);
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManager
 * JD-Core Version:    0.7.0.1
 */