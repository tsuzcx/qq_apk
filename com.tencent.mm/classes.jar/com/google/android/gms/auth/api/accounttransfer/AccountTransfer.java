package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzw;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransfer
{
  public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
  public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
  public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
  public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
  private static final Api.ClientKey<zzx> zzau;
  private static final Api.AbstractClientBuilder<zzx, zzq> zzav;
  private static final Api<zzq> zzaw;
  @Deprecated
  private static final zze zzax;
  private static final zzt zzay;
  
  static
  {
    AppMethodBeat.i(10636);
    zzau = new Api.ClientKey();
    zzav = new zzd();
    zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);
    zzax = new zzw();
    zzay = new zzw();
    AppMethodBeat.o(10636);
  }
  
  public static AccountTransferClient getAccountTransferClient(Activity paramActivity)
  {
    AppMethodBeat.i(10634);
    paramActivity = new AccountTransferClient(paramActivity);
    AppMethodBeat.o(10634);
    return paramActivity;
  }
  
  public static AccountTransferClient getAccountTransferClient(Context paramContext)
  {
    AppMethodBeat.i(10635);
    paramContext = new AccountTransferClient(paramContext);
    AppMethodBeat.o(10635);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransfer
 * JD-Core Version:    0.7.0.1
 */