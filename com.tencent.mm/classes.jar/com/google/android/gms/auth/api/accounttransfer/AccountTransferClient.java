package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.google.android.gms.internal.auth.zzag;
import com.google.android.gms.internal.auth.zzai;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountTransferClient
  extends GoogleApi<zzq>
{
  private static final Api.ClientKey<zzx> zzau;
  private static final Api.AbstractClientBuilder<zzx, zzq> zzav;
  private static final Api<zzq> zzaw;
  
  static
  {
    AppMethodBeat.i(10647);
    zzau = new Api.ClientKey();
    zzav = new zzf();
    zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);
    AppMethodBeat.o(10647);
  }
  
  AccountTransferClient(Activity paramActivity)
  {
    super(paramActivity, zzaw, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    AppMethodBeat.i(10639);
    AppMethodBeat.o(10639);
  }
  
  AccountTransferClient(Context paramContext)
  {
    super(paramContext, zzaw, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    AppMethodBeat.i(10638);
    AppMethodBeat.o(10638);
  }
  
  private static void zzd(TaskCompletionSource paramTaskCompletionSource, Status paramStatus)
  {
    AppMethodBeat.i(10645);
    paramTaskCompletionSource.setException(new AccountTransferException(paramStatus));
    AppMethodBeat.o(10645);
  }
  
  public Task<DeviceMetaData> getDeviceMetaData(String paramString)
  {
    AppMethodBeat.i(10642);
    Preconditions.checkNotNull(paramString);
    paramString = doRead(new zzj(this, new zzy(paramString)));
    AppMethodBeat.o(10642);
    return paramString;
  }
  
  public Task<Void> notifyCompletion(String paramString, int paramInt)
  {
    AppMethodBeat.i(10644);
    Preconditions.checkNotNull(paramString);
    paramString = doWrite(new zzm(this, new zzae(paramString, paramInt)));
    AppMethodBeat.o(10644);
    return paramString;
  }
  
  public Task<byte[]> retrieveData(String paramString)
  {
    AppMethodBeat.i(10641);
    Preconditions.checkNotNull(paramString);
    paramString = doRead(new zzh(this, new zzag(paramString)));
    AppMethodBeat.o(10641);
    return paramString;
  }
  
  public Task<Void> sendData(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10640);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramArrayOfByte);
    paramString = doWrite(new zzg(this, new zzai(paramString, paramArrayOfByte)));
    AppMethodBeat.o(10640);
    return paramString;
  }
  
  public Task<Void> showUserChallenge(String paramString, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(10643);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramPendingIntent);
    paramString = doWrite(new zzl(this, new zzak(paramString, paramPendingIntent)));
    AppMethodBeat.o(10643);
    return paramString;
  }
  
  static class zzd<T>
    extends zzv
  {
    private AccountTransferClient.zze<T> zzbg;
    
    public zzd(AccountTransferClient.zze<T> paramzze)
    {
      this.zzbg = paramzze;
    }
    
    public final void onFailure(Status paramStatus)
    {
      AppMethodBeat.i(10637);
      this.zzbg.zzd(paramStatus);
      AppMethodBeat.o(10637);
    }
  }
  
  static abstract class zze<T>
    extends TaskApiCall<zzx, T>
  {
    private TaskCompletionSource<T> zzbh;
    
    protected final void setResult(T paramT)
    {
      this.zzbh.setResult(paramT);
    }
    
    protected final void zzd(Status paramStatus)
    {
      AccountTransferClient.zze(this.zzbh, paramStatus);
    }
    
    protected abstract void zzd(zzac paramzzac);
  }
  
  static abstract class zzf
    extends AccountTransferClient.zze<Void>
  {
    zzab zzbi = new zzn(this);
    
    private zzf()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransferClient
 * JD-Core Version:    0.7.0.1
 */