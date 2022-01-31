package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class MediaSdk$1
  implements MediaSdk.TransCallbacker
{
  MediaSdk$1(MediaSdk paramMediaSdk, MediaSdk.Callbacker paramCallbacker) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(142847);
    FeedbackEvent.FERemuxResult localFERemuxResult = new FeedbackEvent.FERemuxResult();
    localFERemuxResult.unmarshall(paramArrayOfByte2);
    this.val$callbacker.onResult(paramInt, new String(paramArrayOfByte1), localFERemuxResult);
    AppMethodBeat.o(142847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk.1
 * JD-Core Version:    0.7.0.1
 */