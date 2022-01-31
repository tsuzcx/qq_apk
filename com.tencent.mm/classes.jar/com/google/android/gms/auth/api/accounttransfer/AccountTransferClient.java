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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzae;
import com.google.android.gms.internal.auth.zzag;
import com.google.android.gms.internal.auth.zzai;
import com.google.android.gms.internal.auth.zzak;
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
    AppMethodBeat.i(76988);
    zzau = new Api.ClientKey();
    zzav = new zzf();
    zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);
    AppMethodBeat.o(76988);
  }
  
  AccountTransferClient(Activity paramActivity)
  {
    super(paramActivity, zzaw, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    AppMethodBeat.i(76980);
    AppMethodBeat.o(76980);
  }
  
  AccountTransferClient(Context paramContext)
  {
    super(paramContext, zzaw, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    AppMethodBeat.i(76979);
    AppMethodBeat.o(76979);
  }
  
  private static void zzd(TaskCompletionSource paramTaskCompletionSource, Status paramStatus)
  {
    AppMethodBeat.i(76986);
    paramTaskCompletionSource.setException(new AccountTransferException(paramStatus));
    AppMethodBeat.o(76986);
  }
  
  public Task<DeviceMetaData> getDeviceMetaData(String paramString)
  {
    AppMethodBeat.i(76983);
    Preconditions.checkNotNull(paramString);
    paramString = doRead(new zzj(this, new zzy(paramString)));
    AppMethodBeat.o(76983);
    return paramString;
  }
  
  public Task<Void> notifyCompletion(String paramString, int paramInt)
  {
    AppMethodBeat.i(76985);
    Preconditions.checkNotNull(paramString);
    paramString = doWrite(new zzm(this, new zzae(paramString, paramInt)));
    AppMethodBeat.o(76985);
    return paramString;
  }
  
  public Task<byte[]> retrieveData(String paramString)
  {
    AppMethodBeat.i(76982);
    Preconditions.checkNotNull(paramString);
    paramString = doRead(new zzh(this, new zzag(paramString)));
    AppMethodBeat.o(76982);
    return paramString;
  }
  
  public Task<Void> sendData(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76981);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramArrayOfByte);
    paramString = doWrite(new zzg(this, new zzai(paramString, paramArrayOfByte)));
    AppMethodBeat.o(76981);
    return paramString;
  }
  
  public Task<Void> showUserChallenge(String paramString, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(76984);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramPendingIntent);
    paramString = doWrite(new zzl(this, new zzak(paramString, paramPendingIntent)));
    AppMethodBeat.o(76984);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransferClient
 * JD-Core Version:    0.7.0.1
 */