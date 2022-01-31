package com.hilive.mediasdk;

import com.hilive.mediasdk.serialize.HPMarshaller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FeedbackEvent$FEAnalysisResult
  extends HPMarshaller
{
  public long audioBitRate;
  public int audioChannels;
  public boolean audioEnable;
  public int audioFormat;
  public int audioSampleRate;
  public int evtType = 2;
  public long fileBitRate;
  public long fileDuraion;
  public String filePath;
  public long fileSize;
  public long videoBitRate;
  public boolean videoEnable;
  public int videoFormat;
  public int videoFps;
  public int videoGopSize;
  public int videoHeight;
  public int videoWidth;
  
  public String toString()
  {
    AppMethodBeat.i(142820);
    String str = "file:[path:" + this.filePath + ",duration:" + this.fileDuraion + ",bitRate:" + this.fileBitRate + ",size:" + this.fileSize + "],audio:[enable:" + this.audioEnable + ",channels:" + this.audioChannels + ",sampleRate:" + this.audioSampleRate + ",format:" + this.audioFormat + ",bitRate:" + this.audioBitRate + "],video:[enable:" + this.videoEnable + ",width:" + this.videoWidth + ",height:" + this.videoHeight + ",format:" + this.videoFormat + ",bitRate:" + this.videoBitRate + ",gop:" + this.videoGopSize + ",fps:" + this.videoFps + "]";
    AppMethodBeat.o(142820);
    return str;
  }
  
  public void unmarshall(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142819);
    try
    {
      super.unmarshall(paramArrayOfByte);
      this.filePath = popString16();
      this.fileDuraion = popInt64();
      this.fileBitRate = popInt64();
      this.fileSize = popInt64();
      this.audioEnable = popBool().booleanValue();
      this.audioChannels = popInt();
      this.audioSampleRate = popInt();
      this.audioFormat = popInt();
      this.audioBitRate = popInt64();
      this.videoEnable = popBool().booleanValue();
      this.videoWidth = popInt();
      this.videoHeight = popInt();
      this.videoFormat = popInt();
      this.videoBitRate = popInt64();
      this.videoGopSize = popInt();
      this.videoFps = popInt();
      AppMethodBeat.o(142819);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(142819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.hilive.mediasdk.FeedbackEvent.FEAnalysisResult
 * JD-Core Version:    0.7.0.1
 */