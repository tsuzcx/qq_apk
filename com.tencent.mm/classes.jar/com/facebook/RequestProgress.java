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
    AppMethodBeat.i(71848);
    this.request = paramGraphRequest;
    this.callbackHandler = paramHandler;
    this.threshold = FacebookSdk.getOnProgressThreshold();
    AppMethodBeat.o(71848);
  }
  
  void addProgress(long paramLong)
  {
    AppMethodBeat.i(71849);
    this.progress += paramLong;
    if ((this.progress >= this.lastReportedProgress + this.threshold) || (this.progress >= this.maxProgress)) {
      reportProgress();
    }
    AppMethodBeat.o(71849);
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
    AppMethodBeat.i(71850);
    Object localObject;
    long l1;
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
          break label90;
        }
        ((GraphRequest.OnProgressCallback)localObject).onProgress(l1, l2);
      }
    }
    for (;;)
    {
      this.lastReportedProgress = this.progress;
      AppMethodBeat.o(71850);
      return;
      label90:
      this.callbackHandler.post(new RequestProgress.1(this, (GraphRequest.OnProgressCallback)localObject, l1, l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.RequestProgress
 * JD-Core Version:    0.7.0.1
 */