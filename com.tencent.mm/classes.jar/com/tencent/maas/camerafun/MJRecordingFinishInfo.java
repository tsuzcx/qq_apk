package com.tencent.maas.camerafun;

import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJRecordingFinishInfo
{
  private final String originalImageSeqDirPath;
  private final String outputFilePath;
  private final MJTime recordingDuration;
  
  public MJRecordingFinishInfo(String paramString1, MJTime paramMJTime, String paramString2)
  {
    this.outputFilePath = paramString1;
    this.recordingDuration = paramMJTime;
    this.originalImageSeqDirPath = paramString2;
  }
  
  public String getOriginalImageSeqDirPath()
  {
    return this.originalImageSeqDirPath;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public MJTime getRecordingDuration()
  {
    return this.recordingDuration;
  }
  
  public String toString()
  {
    AppMethodBeat.i(216818);
    String str = "MJRecordingFinishInfo{outputFilePath='" + this.outputFilePath + '\'' + ", recordingDuration=" + this.recordingDuration.toSeconds() + "s, originalImageSeqDirPath='" + this.originalImageSeqDirPath + '\'' + '}';
    AppMethodBeat.o(216818);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJRecordingFinishInfo
 * JD-Core Version:    0.7.0.1
 */