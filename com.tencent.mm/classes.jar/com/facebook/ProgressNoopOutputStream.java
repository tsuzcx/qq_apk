package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream
  extends OutputStream
  implements RequestOutputStream
{
  private int batchMax;
  private final Handler callbackHandler;
  private GraphRequest currentRequest;
  private RequestProgress currentRequestProgress;
  private final Map<GraphRequest, RequestProgress> progressMap;
  
  ProgressNoopOutputStream(Handler paramHandler)
  {
    AppMethodBeat.i(71832);
    this.progressMap = new HashMap();
    this.callbackHandler = paramHandler;
    AppMethodBeat.o(71832);
  }
  
  void addProgress(long paramLong)
  {
    AppMethodBeat.i(71834);
    if (this.currentRequestProgress == null)
    {
      this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
      this.progressMap.put(this.currentRequest, this.currentRequestProgress);
    }
    this.currentRequestProgress.addToMax(paramLong);
    this.batchMax = ((int)(this.batchMax + paramLong));
    AppMethodBeat.o(71834);
  }
  
  int getMaxProgress()
  {
    return this.batchMax;
  }
  
  Map<GraphRequest, RequestProgress> getProgressMap()
  {
    return this.progressMap;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71833);
    this.currentRequest = paramGraphRequest;
    if (paramGraphRequest != null) {}
    for (paramGraphRequest = (RequestProgress)this.progressMap.get(paramGraphRequest);; paramGraphRequest = null)
    {
      this.currentRequestProgress = paramGraphRequest;
      AppMethodBeat.o(71833);
      return;
    }
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(71837);
    addProgress(1L);
    AppMethodBeat.o(71837);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71835);
    addProgress(paramArrayOfByte.length);
    AppMethodBeat.o(71835);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71836);
    addProgress(paramInt2);
    AppMethodBeat.o(71836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.ProgressNoopOutputStream
 * JD-Core Version:    0.7.0.1
 */