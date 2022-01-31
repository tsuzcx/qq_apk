package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

class RequestProgress$1
  implements Runnable
{
  RequestProgress$1(RequestProgress paramRequestProgress, GraphRequest.OnProgressCallback paramOnProgressCallback, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    AppMethodBeat.i(71847);
    this.val$callbackCopy.onProgress(this.val$currentCopy, this.val$maxProgressCopy);
    AppMethodBeat.o(71847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.RequestProgress.1
 * JD-Core Version:    0.7.0.1
 */