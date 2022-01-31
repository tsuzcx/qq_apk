package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.internal.auth.zzu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccount
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.AbstractClientBuilder<zzu, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzu> CLIENT_KEY;
  @Deprecated
  public static final WorkAccountApi WorkAccountApi;
  
  static
  {
    AppMethodBeat.i(76964);
    CLIENT_KEY = new Api.ClientKey();
    CLIENT_BUILDER = new zzi();
    API = new Api("WorkAccount.API", CLIENT_BUILDER, CLIENT_KEY);
    WorkAccountApi = new zzk();
    AppMethodBeat.o(76964);
  }
  
  public static WorkAccountClient getClient(Activity paramActivity)
  {
    AppMethodBeat.i(76962);
    paramActivity = new WorkAccountClient(paramActivity);
    AppMethodBeat.o(76962);
    return paramActivity;
  }
  
  public static WorkAccountClient getClient(Context paramContext)
  {
    AppMethodBeat.i(76963);
    paramContext = new WorkAccountClient(paramContext);
    AppMethodBeat.o(76963);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccount
 * JD-Core Version:    0.7.0.1
 */