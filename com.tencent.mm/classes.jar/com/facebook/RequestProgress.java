package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

class RequestProgress
{
  private final Handler callbackHandler;
  private long lastReportedProgress;
  private long maxProgress;
  private long progress;
  private final GraphRequest request;
  private final long threshold;
  
  RequestProgress(Handler paramHandler, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17284);
    this.request = paramGraphRequest;
    this.callbackHandler = paramHandler;
    this.threshold = FacebookSdk.getOnProgressThreshold();
    AppMethodBeat.o(17284);
  }
  
  void addProgress(long paramLong)
  {
    AppMethodBeat.i(17285);
    this.progress += paramLong;
    if ((this.progress >= this.lastReportedProgress + this.threshold) || (this.progress >= this.maxProgress)) {
      reportProgress();
    }
    AppMethodBeat.o(17285);
  }
  
  void addToMax(long paramLong)
  {
    this.maxProgress += paramLong;
  }
  
  long getMaxProgress()
  {
    return this.maxProgress;
  }
  
  long getProgress()
  {
    return this.progress;
  }
  
  void reportProgress()
  {
    AppMethodBeat.i(17286);
    Object localObject;
    final long l1;
    long l2;
    if (this.progress > this.lastReportedProgress)
    {
      localObject = this.request.getCallback();
      if ((this.maxProgress > 0L) && ((localObject instanceof GraphRequest.OnProgressCallback)))
      {
        l1 = this.progress;
        l2 = this.maxProgress;
        localObject = (GraphRequest.OnProgressCallback)localObject;
        if (this.callbackHandler != null) {
          break label92;
        }
        ((GraphRequest.OnProgressCallback)localObject).onProgress(l1, l2);
      }
    }
    for (;;)
    {
      this.lastReportedProgress = this.progress;
      AppMethodBeat.o(17286);
      return;
      label92:
      this.callbackHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(17283);
          this.val$callbackCopy.onProgress(l1, this.val$maxProgressCopy);
          AppMethodBeat.o(17283);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.RequestProgress
 * JD-Core Version:    0.7.0.1
 */