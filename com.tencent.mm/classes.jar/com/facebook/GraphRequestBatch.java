package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch
  extends AbstractList<GraphRequest>
{
  private static AtomicInteger idGenerator;
  private String batchApplicationId;
  private Handler callbackHandler;
  private List<Callback> callbacks;
  private final String id;
  private List<GraphRequest> requests;
  private int timeoutInMilliseconds;
  
  static
  {
    AppMethodBeat.i(17194);
    idGenerator = new AtomicInteger();
    AppMethodBeat.o(17194);
  }
  
  public GraphRequestBatch()
  {
    AppMethodBeat.i(17171);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList();
    AppMethodBeat.o(17171);
  }
  
  public GraphRequestBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17174);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList(paramGraphRequestBatch);
    this.callbackHandler = paramGraphRequestBatch.callbackHandler;
    this.timeoutInMilliseconds = paramGraphRequestBatch.timeoutInMilliseconds;
    this.callbacks = new ArrayList(paramGraphRequestBatch.callbacks);
    AppMethodBeat.o(17174);
  }
  
  public GraphRequestBatch(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(17172);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList(paramCollection);
    AppMethodBeat.o(17172);
  }
  
  public GraphRequestBatch(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(17173);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = Arrays.asList(paramVarArgs);
    AppMethodBeat.o(17173);
  }
  
  public final void add(int paramInt, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17179);
    this.requests.add(paramInt, paramGraphRequest);
    AppMethodBeat.o(17179);
  }
  
  public final boolean add(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17178);
    boolean bool = this.requests.add(paramGraphRequest);
    AppMethodBeat.o(17178);
    return bool;
  }
  
  public void addCallback(Callback paramCallback)
  {
    AppMethodBeat.i(17176);
    if (!this.callbacks.contains(paramCallback)) {
      this.callbacks.add(paramCallback);
    }
    AppMethodBeat.o(17176);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(17180);
    this.requests.clear();
    AppMethodBeat.o(17180);
  }
  
  public final List<GraphResponse> executeAndWait()
  {
    AppMethodBeat.i(17185);
    List localList = executeAndWaitImpl();
    AppMethodBeat.o(17185);
    return localList;
  }
  
  List<GraphResponse> executeAndWaitImpl()
  {
    AppMethodBeat.i(17187);
    List localList = GraphRequest.executeBatchAndWait(this);
    AppMethodBeat.o(17187);
    return localList;
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    AppMethodBeat.i(17186);
    GraphRequestAsyncTask localGraphRequestAsyncTask = executeAsyncImpl();
    AppMethodBeat.o(17186);
    return localGraphRequestAsyncTask;
  }
  
  GraphRequestAsyncTask executeAsyncImpl()
  {
    AppMethodBeat.i(17188);
    GraphRequestAsyncTask localGraphRequestAsyncTask = GraphRequest.executeBatchAsync(this);
    AppMethodBeat.o(17188);
    return localGraphRequestAsyncTask;
  }
  
  public final GraphRequest get(int paramInt)
  {
    AppMethodBeat.i(17181);
    GraphRequest localGraphRequest = (GraphRequest)this.requests.get(paramInt);
    AppMethodBeat.o(17181);
    return localGraphRequest;
  }
  
  public final String getBatchApplicationId()
  {
    return this.batchApplicationId;
  }
  
  final Handler getCallbackHandler()
  {
    return this.callbackHandler;
  }
  
  final List<Callback> getCallbacks()
  {
    return this.callbacks;
  }
  
  final String getId()
  {
    return this.id;
  }
  
  final List<GraphRequest> getRequests()
  {
    return this.requests;
  }
  
  public int getTimeout()
  {
    return this.timeoutInMilliseconds;
  }
  
  public final GraphRequest remove(int paramInt)
  {
    AppMethodBeat.i(17182);
    GraphRequest localGraphRequest = (GraphRequest)this.requests.remove(paramInt);
    AppMethodBeat.o(17182);
    return localGraphRequest;
  }
  
  public void removeCallback(Callback paramCallback)
  {
    AppMethodBeat.i(17177);
    this.callbacks.remove(paramCallback);
    AppMethodBeat.o(17177);
  }
  
  public final GraphRequest set(int paramInt, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17183);
    paramGraphRequest = (GraphRequest)this.requests.set(paramInt, paramGraphRequest);
    AppMethodBeat.o(17183);
    return paramGraphRequest;
  }
  
  public final void setBatchApplicationId(String paramString)
  {
    this.batchApplicationId = paramString;
  }
  
  final void setCallbackHandler(Handler paramHandler)
  {
    this.callbackHandler = paramHandler;
  }
  
  public void setTimeout(int paramInt)
  {
    AppMethodBeat.i(17175);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
      AppMethodBeat.o(17175);
      throw localIllegalArgumentException;
    }
    this.timeoutInMilliseconds = paramInt;
    AppMethodBeat.o(17175);
  }
  
  public final int size()
  {
    AppMethodBeat.i(17184);
    int i = this.requests.size();
    AppMethodBeat.o(17184);
    return i;
  }
  
  public static abstract interface Callback
  {
    public abstract void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch);
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequestBatch.Callback
  {
    public abstract void onBatchProgress(GraphRequestBatch paramGraphRequestBatch, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.GraphRequestBatch
 * JD-Core Version:    0.7.0.1
 */