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
    AppMethodBeat.i(71839);
    this.requests = paramGraphRequestBatch;
    this.progressMap = paramMap;
    this.maxProgress = paramLong;
    this.threshold = FacebookSdk.getOnProgressThreshold();
    AppMethodBeat.o(71839);
  }
  
  private void addProgress(long paramLong)
  {
    AppMethodBeat.i(71840);
    if (this.currentRequestProgress != null) {
      this.currentRequestProgress.addProgress(paramLong);
    }
    this.batchProgress += paramLong;
    if ((this.batchProgress >= this.lastReportedProgress + this.threshold) || (this.batchProgress >= this.maxProgress)) {
      reportBatchProgress();
    }
    AppMethodBeat.o(71840);
  }
  
  private void reportBatchProgress()
  {
    AppMethodBeat.i(71841);
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
            localHandler.post(new ProgressOutputStream.1(this, (GraphRequestBatch.OnProgressCallback)localObject));
          }
        }
      }
      this.lastReportedProgress = this.batchProgress;
    }
    AppMethodBeat.o(71841);
  }
  
  public void close()
  {
    AppMethodBeat.i(71846);
    super.close();
    Iterator localIterator = this.progressMap.values().iterator();
    while (localIterator.hasNext()) {
      ((RequestProgress)localIterator.next()).reportProgress();
    }
    reportBatchProgress();
    AppMethodBeat.o(71846);
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
    AppMethodBeat.i(71842);
    if (paramGraphRequest != null) {}
    for (paramGraphRequest = (RequestProgress)this.progressMap.get(paramGraphRequest);; paramGraphRequest = null)
    {
      this.currentRequestProgress = paramGraphRequest;
      AppMethodBeat.o(71842);
      return;
    }
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(71845);
    this.out.write(paramInt);
    addProgress(1L);
    AppMethodBeat.o(71845);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71843);
    this.out.write(paramArrayOfByte);
    addProgress(paramArrayOfByte.length);
    AppMethodBeat.o(71843);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71844);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    addProgress(paramInt2);
    AppMethodBeat.o(71844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.ProgressOutputStream
 * JD-Core Version:    0.7.0.1
 */