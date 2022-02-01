package com.tencent.maas.camerafun;

import com.tencent.maas.model.time.MJTime;

public class MJCaptureOptions
{
  private final boolean isAudioEnabled;
  private final boolean isUseFrontCamera;
  private final MJTime maxRecordingDuration;
  
  public MJCaptureOptions(boolean paramBoolean1, boolean paramBoolean2, MJTime paramMJTime)
  {
    this.isUseFrontCamera = paramBoolean1;
    this.isAudioEnabled = paramBoolean2;
    this.maxRecordingDuration = paramMJTime;
  }
  
  public MJTime getMaxRecordingDuration()
  {
    return this.maxRecordingDuration;
  }
  
  public boolean isAudioEnabled()
  {
    return this.isAudioEnabled;
  }
  
  public boolean isUseFrontCamera()
  {
    return this.isUseFrontCamera;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCaptureOptions
 * JD-Core Version:    0.7.0.1
 */