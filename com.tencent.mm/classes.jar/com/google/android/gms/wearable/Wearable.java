package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.support.v4.e.l;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.wearable.internal.zzaa;
import com.google.android.gms.wearable.internal.zzaj;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zzbv;
import com.google.android.gms.wearable.internal.zzbw;
import com.google.android.gms.wearable.internal.zzcj;
import com.google.android.gms.wearable.internal.zzeu;
import com.google.android.gms.wearable.internal.zzez;
import com.google.android.gms.wearable.internal.zzfg;
import com.google.android.gms.wearable.internal.zzfl;
import com.google.android.gms.wearable.internal.zzgi;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzhg;
import com.google.android.gms.wearable.internal.zzhq;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wearable
{
  @Deprecated
  public static final Api<Wearable.WearableOptions> API;
  private static final Api.AbstractClientBuilder<zzhg, Wearable.WearableOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzhg> CLIENT_KEY;
  @Deprecated
  public static final CapabilityApi CapabilityApi;
  @Deprecated
  public static final ChannelApi ChannelApi;
  @Deprecated
  public static final DataApi DataApi;
  @Deprecated
  public static final MessageApi MessageApi;
  @Deprecated
  public static final NodeApi NodeApi;
  @Deprecated
  private static final zzi zzaa;
  @Deprecated
  private static final zzu zzab;
  @Deprecated
  private static final zzc zzx;
  @Deprecated
  private static final zza zzy;
  @Deprecated
  private static final zzf zzz;
  
  static
  {
    AppMethodBeat.i(70913);
    DataApi = new zzbw();
    CapabilityApi = new zzo();
    MessageApi = new zzeu();
    NodeApi = new zzfg();
    ChannelApi = new zzaj();
    zzx = new zzk();
    zzy = new zzh();
    zzz = new zzbv();
    zzaa = new zzgi();
    zzab = new zzhq();
    CLIENT_KEY = new Api.ClientKey();
    CLIENT_BUILDER = new zzj();
    API = new Api("Wearable.API", CLIENT_BUILDER, CLIENT_KEY);
    AppMethodBeat.o(70913);
  }
  
  public static CapabilityClient getCapabilityClient(Activity paramActivity)
  {
    AppMethodBeat.i(70903);
    paramActivity = new zzaa(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70903);
    return paramActivity;
  }
  
  public static CapabilityClient getCapabilityClient(Activity paramActivity, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70904);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzaa(paramActivity, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70904);
    return paramActivity;
  }
  
  public static CapabilityClient getCapabilityClient(Context paramContext)
  {
    AppMethodBeat.i(70901);
    paramContext = new zzaa(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70901);
    return paramContext;
  }
  
  public static CapabilityClient getCapabilityClient(Context paramContext, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70902);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzaa(paramContext, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70902);
    return paramContext;
  }
  
  public static ChannelClient getChannelClient(Activity paramActivity)
  {
    AppMethodBeat.i(70911);
    paramActivity = new zzao(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70911);
    return paramActivity;
  }
  
  public static ChannelClient getChannelClient(Activity paramActivity, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70912);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzao(paramActivity, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70912);
    return paramActivity;
  }
  
  public static ChannelClient getChannelClient(Context paramContext)
  {
    AppMethodBeat.i(70909);
    paramContext = new zzao(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70909);
    return paramContext;
  }
  
  public static ChannelClient getChannelClient(Context paramContext, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70910);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzao(paramContext, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70910);
    return paramContext;
  }
  
  public static DataClient getDataClient(Activity paramActivity)
  {
    AppMethodBeat.i(70895);
    paramActivity = new zzcj(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70895);
    return paramActivity;
  }
  
  public static DataClient getDataClient(Activity paramActivity, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70896);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzcj(paramActivity, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70896);
    return paramActivity;
  }
  
  public static DataClient getDataClient(Context paramContext)
  {
    AppMethodBeat.i(70893);
    paramContext = new zzcj(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70893);
    return paramContext;
  }
  
  public static DataClient getDataClient(Context paramContext, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70894);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzcj(paramContext, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70894);
    return paramContext;
  }
  
  public static MessageClient getMessageClient(Activity paramActivity)
  {
    AppMethodBeat.i(70899);
    paramActivity = new zzez(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70899);
    return paramActivity;
  }
  
  public static MessageClient getMessageClient(Activity paramActivity, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70900);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzez(paramActivity, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70900);
    return paramActivity;
  }
  
  public static MessageClient getMessageClient(Context paramContext)
  {
    AppMethodBeat.i(70897);
    paramContext = new zzez(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70897);
    return paramContext;
  }
  
  public static MessageClient getMessageClient(Context paramContext, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70898);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzez(paramContext, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70898);
    return paramContext;
  }
  
  public static NodeClient getNodeClient(Activity paramActivity)
  {
    AppMethodBeat.i(70907);
    paramActivity = new zzfl(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70907);
    return paramActivity;
  }
  
  public static NodeClient getNodeClient(Activity paramActivity, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70908);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzfl(paramActivity, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70908);
    return paramActivity;
  }
  
  public static NodeClient getNodeClient(Context paramContext)
  {
    AppMethodBeat.i(70905);
    paramContext = new zzfl(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(70905);
    return paramContext;
  }
  
  public static NodeClient getNodeClient(Context paramContext, Wearable.WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(70906);
    l.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzfl(paramContext, Wearable.WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(70906);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable
 * JD-Core Version:    0.7.0.1
 */