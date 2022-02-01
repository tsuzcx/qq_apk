package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.internal.auth-api-phone.zzi;
import com.google.android.gms.tasks.Task;

public abstract class SmsRetrieverClient
  extends GoogleApi<Api.ApiOptions.NoOptions>
  implements SmsRetrieverApi
{
  private static final Api<Api.ApiOptions.NoOptions> API = new Api("SmsRetriever.API", CLIENT_BUILDER, CLIENT_KEY);
  private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzi> CLIENT_KEY = new Api.ClientKey();
  
  static
  {
    CLIENT_BUILDER = new zza();
  }
  
  public SmsRetrieverClient(Activity paramActivity)
  {
    super(paramActivity, API, null, new ApiExceptionMapper());
  }
  
  public SmsRetrieverClient(Context paramContext)
  {
    super(paramContext, API, null, new ApiExceptionMapper());
  }
  
  public abstract Task<Void> startSmsRetriever();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.phone.SmsRetrieverClient
 * JD-Core Version:    0.7.0.1
 */