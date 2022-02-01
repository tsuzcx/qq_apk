package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SdkInfo$MediaInfo
{
  public int audioBitrate = 0;
  public int audioChannel = 0;
  public int audioCodecId = 0;
  public String audioCodecName = "";
  public int audioDuration = 0;
  public boolean audioEnable = false;
  public int audioFormat = -1;
  public int audioFrameBytes = 0;
  public int audioFrameDuration = 0;
  public int audioFrameSize = 0;
  public int audioSampleBytes = 0;
  public int audioSampleDuration = 0;
  public int audioSamplerate = 0;
  public int fileBitrate = 0;
  public int fileDuration = 0;
  public long fileSize = 0L;
  public int videoBitrate = 0;
  public int videoCodecId = 0;
  public String videoCodecName = "";
  public int videoDuration = 0;
  public boolean videoEnable = false;
  public int videoFormat = -1;
  public int videoFps = 0;
  public int videoFrameBytes = 0;
  public int videoFrameDuration = 0;
  public int videoFrameSize = 0;
  public int videoGop = 0;
  public int videoHeight = 0;
  public int videoWidth = 0;
  
  public String toString()
  {
    AppMethodBeat.i(177278);
    Object localObject2 = "{ file: { size: " + this.fileSize + ", bitrate:" + this.fileBitrate + ", duration: " + this.fileDuration + " }";
    Object localObject1 = localObject2;
    if (this.audioEnable) {
      localObject1 = (String)localObject2 + ", audio: { codecName: " + this.audioCodecName + ", codecId: " + this.audioCodecId + ", format: " + this.audioFormat + ", duration: " + this.audioDuration + ", bitrate: " + this.audioBitrate + ", channel: " + this.audioChannel + ", samplerate: " + this.audioSamplerate + ", frameSize: " + this.audioFrameSize + ", frameBytes: " + this.audioFrameBytes + ", frameDuration: " + this.audioFrameDuration + ", sampleBytes: " + this.audioSampleBytes + ", sampleDuration: " + this.audioSampleDuration + " }";
    }
    localObject2 = localObject1;
    if (this.videoEnable) {
      localObject2 = (String)localObject1 + ", video: { codecName: " + this.videoCodecName + ", codecId: " + this.videoCodecId + ", format: " + this.videoFormat + ", duration: " + this.videoDuration + ", bitrate: " + this.videoBitrate + ", width: " + this.videoWidth + ", height: " + this.videoHeight + ", gop: " + this.videoGop + ", fps: " + this.videoFps + ", frameSize: " + this.videoFrameSize + ", frameBytes: " + this.videoFrameBytes + ", frameDuration: " + this.videoFrameDuration + " }";
    }
    localObject1 = (String)localObject2 + " }";
    AppMethodBeat.o(177278);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.hilive.mediasdk.SdkInfo.MediaInfo
 * JD-Core Version:    0.7.0.1
 */