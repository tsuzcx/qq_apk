package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

@KeepForSdk
public class BaseImplementation
{
  @KeepForSdk
  public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient>
    extends BasePendingResult<R>
    implements BaseImplementation.ResultHolder<R>
  {
    @KeepForSdk
    private final Api<?> mApi;
    @KeepForSdk
    private final Api.AnyClientKey<A> mClientKey;
    
    @Deprecated
    @KeepForSdk
    protected ApiMethodImpl(Api.AnyClientKey<A> paramAnyClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.mClientKey = ((Api.AnyClientKey)Preconditions.checkNotNull(paramAnyClientKey));
      this.mApi = null;
    }
    
    @KeepForSdk
    protected ApiMethodImpl(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super();
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.mClientKey = paramApi.getClientKey();
      this.mApi = paramApi;
    }
    
    @KeepForSdk
    protected ApiMethodImpl(BasePendingResult.CallbackHandler<R> paramCallbackHandler)
    {
      super();
      this.mClientKey = null;
      this.mApi = null;
    }
    
    @KeepForSdk
    private void setFailedResult(RemoteException paramRemoteException)
    {
      setFailedResult(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    @KeepForSdk
    protected abstract void doExecute(A paramA);
    
    @KeepForSdk
    public final Api<?> getApi()
    {
      return this.mApi;
    }
    
    @KeepForSdk
    public final Api.AnyClientKey<A> getClientKey()
    {
      return this.mClientKey;
    }
    
    @KeepForSdk
    protected void onSetFailedResult(R paramR) {}
    
    @KeepForSdk
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
    
    @KeepForSdk
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
  
  @KeepForSdk
  public static abstract interface ResultHolder<R>
  {
    @KeepForSdk
    public abstract void setFailedResult(Status paramStatus);
    
    @KeepForSdk
    public abstract void setResult(R paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BaseImplementation
 * JD-Core Version:    0.7.0.1
 */