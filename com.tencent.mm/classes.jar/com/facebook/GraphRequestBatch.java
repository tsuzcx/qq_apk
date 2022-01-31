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
  private List<GraphRequestBatch.Callback> callbacks;
  private final String id;
  private List<GraphRequest> requests;
  private int timeoutInMilliseconds;
  
  static
  {
    AppMethodBeat.i(71758);
    idGenerator = new AtomicInteger();
    AppMethodBeat.o(71758);
  }
  
  public GraphRequestBatch()
  {
    AppMethodBeat.i(71735);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList();
    AppMethodBeat.o(71735);
  }
  
  public GraphRequestBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71738);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList(paramGraphRequestBatch);
    this.callbackHandler = paramGraphRequestBatch.callbackHandler;
    this.timeoutInMilliseconds = paramGraphRequestBatch.timeoutInMilliseconds;
    this.callbacks = new ArrayList(paramGraphRequestBatch.callbacks);
    AppMethodBeat.o(71738);
  }
  
  public GraphRequestBatch(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(71736);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = new ArrayList(paramCollection);
    AppMethodBeat.o(71736);
  }
  
  public GraphRequestBatch(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(71737);
    this.requests = new ArrayList();
    this.timeoutInMilliseconds = 0;
    this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
    this.callbacks = new ArrayList();
    this.requests = Arrays.asList(paramVarArgs);
    AppMethodBeat.o(71737);
  }
  
  public final void add(int paramInt, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71743);
    this.requests.add(paramInt, paramGraphRequest);
    AppMethodBeat.o(71743);
  }
  
  public final boolean add(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71742);
    boolean bool = this.requests.add(paramGraphRequest);
    AppMethodBeat.o(71742);
    return bool;
  }
  
  public void addCallback(GraphRequestBatch.Callback paramCallback)
  {
    AppMethodBeat.i(71740);
    if (!this.callbacks.contains(paramCallback)) {
      this.callbacks.add(paramCallback);
    }
    AppMethodBeat.o(71740);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(71744);
    this.requests.clear();
    AppMethodBeat.o(71744);
  }
  
  public final List<GraphResponse> executeAndWait()
  {
    AppMethodBeat.i(71749);
    List localList = executeAndWaitImpl();
    AppMethodBeat.o(71749);
    return localList;
  }
  
  List<GraphResponse> executeAndWaitImpl()
  {
    AppMethodBeat.i(71751);
    List localList = GraphRequest.executeBatchAndWait(this);
    AppMethodBeat.o(71751);
    return localList;
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    AppMethodBeat.i(71750);
    GraphRequestAsyncTask localGraphRequestAsyncTask = executeAsyncImpl();
    AppMethodBeat.o(71750);
    return localGraphRequestAsyncTask;
  }
  
  GraphRequestAsyncTask executeAsyncImpl()
  {
    AppMethodBeat.i(71752);
    GraphRequestAsyncTask localGraphRequestAsyncTask = GraphRequest.executeBatchAsync(this);
    AppMethodBeat.o(71752);
    return localGraphRequestAsyncTask;
  }
  
  public final GraphRequest get(int paramInt)
  {
    AppMethodBeat.i(71745);
    GraphRequest localGraphRequest = (GraphRequest)this.requests.get(paramInt);
    AppMethodBeat.o(71745);
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
  
  final List<GraphRequestBatch.Callback> getCallbacks()
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
    AppMethodBeat.i(71746);
    GraphRequest localGraphRequest = (GraphRequest)this.requests.remove(paramInt);
    AppMethodBeat.o(71746);
    return localGraphRequest;
  }
  
  public void removeCallback(GraphRequestBatch.Callback paramCallback)
  {
    AppMethodBeat.i(71741);
    this.callbacks.remove(paramCallback);
    AppMethodBeat.o(71741);
  }
  
  public final GraphRequest set(int paramInt, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71747);
    paramGraphRequest = (GraphRequest)this.requests.set(paramInt, paramGraphRequest);
    AppMethodBeat.o(71747);
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
    AppMethodBeat.i(71739);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
      AppMethodBeat.o(71739);
      throw localIllegalArgumentException;
    }
    this.timeoutInMilliseconds = paramInt;
    AppMethodBeat.o(71739);
  }
  
  public final int size()
  {
    AppMethodBeat.i(71748);
    int i = this.requests.size();
    AppMethodBeat.o(71748);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.GraphRequestBatch
 * JD-Core Version:    0.7.0.1
 */