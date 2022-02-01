package com.tencent.liteav.audio.impl.earmonitor;

import android.content.Context;

public abstract interface TXSystemAudioKit
{
  public abstract void initialize(Context paramContext, a parama);
  
  public abstract void setSystemEarMonitoringVolume(int paramInt);
  
  public abstract void startSystemEarMonitoring();
  
  public abstract void stopSystemEarMonitoring();
  
  public abstract void uninitialize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit
 * JD-Core Version:    0.7.0.1
 */