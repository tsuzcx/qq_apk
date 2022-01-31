package com.hilive.mediasdk;

import com.hilive.mediasdk.serialize.HPMarshaller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FeedbackEvent$FERemuxResult
  extends HPMarshaller
{
  public int audioBitRate = 0;
  public int audioChannels = 0;
  public boolean audioEnable = false;
  public int audioForamt = 0;
  public int audioSampleRate = 0;
  public int evtType = 1;
  public int spent = 0;
  public int videoBitRate = 0;
  public boolean videoEnable = false;
  public int videoFormat = 0;
  public int videoFps = 0;
  public int videoGopSize = 0;
  public int videoHeight = 0;
  public int videoWidth = 0;
  
  public String toString()
  {
    AppMethodBeat.i(142822);
    String str = "spent:" + this.spent + " audio:[enable:" + this.audioEnable + ",format:" + this.audioForamt + ",sampleRate:" + this.audioSampleRate + ",channels:" + this.audioChannels + ",bitRate:" + this.audioBitRate + "] video:[enable:" + this.videoEnable + ",format:" + this.videoFormat + ",width:" + this.videoWidth + ",height:" + this.videoHeight + ",bitRate:" + this.videoBitRate + ",gop:" + this.videoGopSize + ",fps:" + this.videoFps + "]";
    AppMethodBeat.o(142822);
    return str;
  }
  
  public void unmarshall(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142821);
    try
    {
      super.unmarshall(paramArrayOfByte);
      this.spent = popInt();
      this.videoEnable = popBool().booleanValue();
      this.videoFormat = popInt();
      this.videoWidth = popInt();
      this.videoHeight = popInt();
      this.videoBitRate = popInt();
      this.videoGopSize = popInt();
      this.videoFps = popInt();
      this.audioEnable = popBool().booleanValue();
      this.audioForamt = popInt();
      this.audioSampleRate = popInt();
      this.audioChannels = popInt();
      this.audioBitRate = popInt();
      AppMethodBeat.o(142821);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(142821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.hilive.mediasdk.FeedbackEvent.FERemuxResult
 * JD-Core Version:    0.7.0.1
 */