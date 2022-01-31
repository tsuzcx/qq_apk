package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Common
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.AbstractClientBuilder<CommonClient, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  public static final Api.ClientKey<CommonClient> CLIENT_KEY;
  public static final CommonApi CommonApi;
  
  static
  {
    AppMethodBeat.i(61391);
    CLIENT_KEY = new Api.ClientKey();
    CLIENT_BUILDER = new zza();
    API = new Api("Common.API", CLIENT_BUILDER, CLIENT_KEY);
    CommonApi = new CommonApiImpl();
    AppMethodBeat.o(61391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.Common
 * JD-Core Version:    0.7.0.1
 */