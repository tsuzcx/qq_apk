package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ProgressOutputStream
  extends FilterOutputStream
  implements RequestOutputStream
{
  private long batchProgress;
  private RequestProgress currentRequestProgress;
  private long lastReportedProgress;
  private long maxProgress;
  private final Map<GraphRequest, RequestProgress> progressMap;
  private final GraphRequestBatch requests;
  private final long threshold;
  
  ProgressOutputStream(OutputStream paramOutputStream, GraphRequestBatch paramGraphRequestBatch, Map<GraphRequest, RequestProgress> paramMap, long paramLong)
  {
    super(paramOutputStream);
    AppMethodBeat.i(17275);
    this.requests = paramGraphRequestBatch;
    this.progressMap = paramMap;
    this.maxProgress = paramLong;
    this.threshold = FacebookSdk.getOnProgressThreshold();
    AppMethodBeat.o(17275);
  }
  
  private void addProgress(long paramLong)
  {
    AppMethodBeat.i(17276);
    if (this.currentRequestProgress != null) {
      this.currentRequestProgress.addProgress(paramLong);
    }
    this.batchProgress += paramLong;
    if ((this.batchProgress >= this.lastReportedProgress + this.threshold) || (this.batchProgress >= this.maxProgress)) {
      reportBatchProgress();
    }
    AppMethodBeat.o(17276);
  }
  
  private void reportBatchProgress()
  {
    AppMethodBeat.i(17277);
    if (this.batchProgress > this.lastReportedProgress)
    {
      Iterator localIterator = this.requests.getCallbacks().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (GraphRequestBatch.Callback)localIterator.next();
        if ((localObject instanceof GraphRequestBatch.OnProgressCallback))
        {
          Handler localHandler = this.requests.getCallbackHandler();
          localObject = (GraphRequestBatch.OnProgressCallback)localObject;
          if (localHandler == null) {
            ((GraphRequestBatch.OnProgressCallback)localObject).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
          } else {
            localHandler.post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(17274);
                this.val$progressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                AppMethodBeat.o(17274);
              }
            });
          }
        }
      }
      this.lastReportedProgress = this.batchProgress;
    }
    AppMethodBeat.o(17277);
  }
  
  public void close()
  {
    AppMethodBeat.i(17282);
    super.close();
    Iterator localIterator = this.progressMap.values().iterator();
    while (localIterator.hasNext()) {
      ((RequestProgress)localIterator.next()).reportProgress();
    }
    reportBatchProgress();
    AppMethodBeat.o(17282);
  }
  
  long getBatchProgress()
  {
    return this.batchProgress;
  }
  
  long getMaxProgress()
  {
    return this.maxProgress;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17278);
    if (paramGraphRequest != null) {}
    for (paramGraphRequest = (RequestProgress)this.progressMap.get(paramGraphRequest);; paramGraphRequest = null)
    {
      this.currentRequestProgress = paramGraphRequest;
      AppMethodBeat.o(17278);
      return;
    }
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(17281);
    this.out.write(paramInt);
    addProgress(1L);
    AppMethodBeat.o(17281);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17279);
    this.out.write(paramArrayOfByte);
    addProgress(paramArrayOfByte.length);
    AppMethodBeat.o(17279);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17280);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    addProgress(paramInt2);
    AppMethodBeat.o(17280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.ProgressOutputStream
 * JD-Core Version:    0.7.0.1
 */