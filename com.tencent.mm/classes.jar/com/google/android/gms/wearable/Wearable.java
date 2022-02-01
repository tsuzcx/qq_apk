package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import androidx.core.f.f;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
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
  public static final Api<WearableOptions> API;
  private static final Api.AbstractClientBuilder<zzhg, WearableOptions> CLIENT_BUILDER;
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
    AppMethodBeat.i(100896);
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
    AppMethodBeat.o(100896);
  }
  
  public static CapabilityClient getCapabilityClient(Activity paramActivity)
  {
    AppMethodBeat.i(100886);
    paramActivity = new zzaa(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100886);
    return paramActivity;
  }
  
  public static CapabilityClient getCapabilityClient(Activity paramActivity, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100887);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzaa(paramActivity, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100887);
    return paramActivity;
  }
  
  public static CapabilityClient getCapabilityClient(Context paramContext)
  {
    AppMethodBeat.i(100884);
    paramContext = new zzaa(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100884);
    return paramContext;
  }
  
  public static CapabilityClient getCapabilityClient(Context paramContext, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100885);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzaa(paramContext, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100885);
    return paramContext;
  }
  
  public static ChannelClient getChannelClient(Activity paramActivity)
  {
    AppMethodBeat.i(100894);
    paramActivity = new zzao(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100894);
    return paramActivity;
  }
  
  public static ChannelClient getChannelClient(Activity paramActivity, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100895);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzao(paramActivity, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100895);
    return paramActivity;
  }
  
  public static ChannelClient getChannelClient(Context paramContext)
  {
    AppMethodBeat.i(100892);
    paramContext = new zzao(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100892);
    return paramContext;
  }
  
  public static ChannelClient getChannelClient(Context paramContext, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100893);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzao(paramContext, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100893);
    return paramContext;
  }
  
  public static DataClient getDataClient(Activity paramActivity)
  {
    AppMethodBeat.i(100878);
    paramActivity = new zzcj(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100878);
    return paramActivity;
  }
  
  public static DataClient getDataClient(Activity paramActivity, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100879);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzcj(paramActivity, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100879);
    return paramActivity;
  }
  
  public static DataClient getDataClient(Context paramContext)
  {
    AppMethodBeat.i(100876);
    paramContext = new zzcj(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100876);
    return paramContext;
  }
  
  public static DataClient getDataClient(Context paramContext, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100877);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzcj(paramContext, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100877);
    return paramContext;
  }
  
  public static MessageClient getMessageClient(Activity paramActivity)
  {
    AppMethodBeat.i(100882);
    paramActivity = new zzez(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100882);
    return paramActivity;
  }
  
  public static MessageClient getMessageClient(Activity paramActivity, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100883);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzez(paramActivity, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100883);
    return paramActivity;
  }
  
  public static MessageClient getMessageClient(Context paramContext)
  {
    AppMethodBeat.i(100880);
    paramContext = new zzez(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100880);
    return paramContext;
  }
  
  public static MessageClient getMessageClient(Context paramContext, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100881);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzez(paramContext, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100881);
    return paramContext;
  }
  
  public static NodeClient getNodeClient(Activity paramActivity)
  {
    AppMethodBeat.i(100890);
    paramActivity = new zzfl(paramActivity, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100890);
    return paramActivity;
  }
  
  public static NodeClient getNodeClient(Activity paramActivity, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100891);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramActivity = new zzfl(paramActivity, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100891);
    return paramActivity;
  }
  
  public static NodeClient getNodeClient(Context paramContext)
  {
    AppMethodBeat.i(100888);
    paramContext = new zzfl(paramContext, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.o(100888);
    return paramContext;
  }
  
  public static NodeClient getNodeClient(Context paramContext, WearableOptions paramWearableOptions)
  {
    AppMethodBeat.i(100889);
    f.checkNotNull(paramWearableOptions, "options must not be null");
    paramContext = new zzfl(paramContext, WearableOptions.zza(paramWearableOptions));
    AppMethodBeat.o(100889);
    return paramContext;
  }
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private final Looper zzac;
    
    private WearableOptions(Builder paramBuilder)
    {
      AppMethodBeat.i(100873);
      this.zzac = Builder.zza(paramBuilder);
      AppMethodBeat.o(100873);
    }
    
    private final GoogleApi.Settings zza()
    {
      AppMethodBeat.i(100874);
      if (this.zzac != null)
      {
        localSettings = new GoogleApi.Settings.Builder().setLooper(this.zzac).build();
        AppMethodBeat.o(100874);
        return localSettings;
      }
      GoogleApi.Settings localSettings = GoogleApi.Settings.DEFAULT_SETTINGS;
      AppMethodBeat.o(100874);
      return localSettings;
    }
    
    public static class Builder
    {
      private Looper zzac;
      
      public Wearable.WearableOptions build()
      {
        AppMethodBeat.i(100872);
        Wearable.WearableOptions localWearableOptions = new Wearable.WearableOptions(this, null);
        AppMethodBeat.o(100872);
        return localWearableOptions;
      }
      
      public Builder setLooper(Looper paramLooper)
      {
        this.zzac = paramLooper;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable
 * JD-Core Version:    0.7.0.1
 */