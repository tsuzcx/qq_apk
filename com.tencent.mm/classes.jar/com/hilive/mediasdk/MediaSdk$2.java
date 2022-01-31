package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class MediaSdk$2
  implements MediaSdk.TransCallbacker
{
  MediaSdk$2(MediaSdk paramMediaSdk, MediaSdk.Callbacker paramCallbacker) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(142848);
    FeedbackEvent.FEAnalysisResult localFEAnalysisResult = new FeedbackEvent.FEAnalysisResult();
    localFEAnalysisResult.unmarshall(paramArrayOfByte2);
    this.val$callbacker.onResult(paramInt, new String(paramArrayOfByte1), localFEAnalysisResult);
    AppMethodBeat.o(142848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk.2
 * JD-Core Version:    0.7.0.1
 */