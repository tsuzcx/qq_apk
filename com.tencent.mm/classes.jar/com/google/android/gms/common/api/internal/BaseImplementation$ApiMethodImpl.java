package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public abstract class BaseImplementation$ApiMethodImpl<R extends Result, A extends Api.AnyClient>
  extends BasePendingResult<R>
  implements BaseImplementation.ResultHolder<R>
{
  private final Api<?> mApi;
  private final Api.AnyClientKey<A> mClientKey;
  
  @Deprecated
  protected BaseImplementation$ApiMethodImpl(Api.AnyClientKey<A> paramAnyClientKey, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient must not be null"));
    this.mClientKey = ((Api.AnyClientKey)Preconditions.checkNotNull(paramAnyClientKey));
    this.mApi = null;
  }
  
  protected BaseImplementation$ApiMethodImpl(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient must not be null"));
    Preconditions.checkNotNull(paramApi, "Api must not be null");
    this.mClientKey = paramApi.getClientKey();
    this.mApi = paramApi;
  }
  
  protected BaseImplementation$ApiMethodImpl(BasePendingResult.CallbackHandler<R> paramCallbackHandler)
  {
    super(paramCallbackHandler);
    this.mClientKey = null;
    this.mApi = null;
  }
  
  private void setFailedResult(RemoteException paramRemoteException)
  {
    setFailedResult(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  protected abstract void doExecute(A paramA);
  
  public final Api<?> getApi()
  {
    return this.mApi;
  }
  
  public final Api.AnyClientKey<A> getClientKey()
  {
    return this.mClientKey;
  }
  
  protected void onSetFailedResult(R paramR) {}
  
  public final void run(A paramA)
  {
    Object localObject = paramA;
    if ((paramA instanceof SimpleClientAdapter)) {
      localObject = ((SimpleClientAdapter)paramA).getClient();
    }
    try
    {
      doExecute((Api.AnyClient)localObject);
      return;
    }
    catch (DeadObjectException paramA)
    {
      setFailedResult(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      setFailedResult(paramA);
    }
  }
  
  public final void setFailedResult(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Failed result must not be success");
      paramStatus = createFailedResult(paramStatus);
      setResult(paramStatus);
      onSetFailedResult(paramStatus);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
 * JD-Core Version:    0.7.0.1
 */