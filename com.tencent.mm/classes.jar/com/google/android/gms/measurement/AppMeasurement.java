package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.e.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
@Keep
public class AppMeasurement
{
  @KeepForSdk
  public static final String CRASH_ORIGIN = "crash";
  @KeepForSdk
  public static final String FCM_ORIGIN = "fcm";
  private final zzgl zzacw;
  
  public AppMeasurement(zzgl paramzzgl)
  {
    AppMethodBeat.i(2309);
    Preconditions.checkNotNull(paramzzgl);
    this.zzacw = paramzzgl;
    AppMethodBeat.o(2309);
  }
  
  @Deprecated
  @Keep
  public static AppMeasurement getInstance(Context paramContext)
  {
    AppMethodBeat.i(2303);
    paramContext = zzgl.zzg(paramContext).zzjr();
    AppMethodBeat.o(2303);
    return paramContext;
  }
  
  @Keep
  public void beginAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(2322);
    this.zzacw.zzft().beginAdUnitExposure(paramString);
    AppMethodBeat.o(2322);
  }
  
  @Keep
  @KeepForSdk
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2326);
    this.zzacw.zzfu().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(2326);
  }
  
  @Keep
  @VisibleForTesting
  protected void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(2327);
    this.zzacw.zzfu().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
    AppMethodBeat.o(2327);
  }
  
  @Keep
  public void endAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(2323);
    this.zzacw.zzft().endAdUnitExposure(paramString);
    AppMethodBeat.o(2323);
  }
  
  @Keep
  public long generateEventId()
  {
    AppMethodBeat.i(2321);
    long l = this.zzacw.zzgb().zzlb();
    AppMethodBeat.o(2321);
    return l;
  }
  
  @Keep
  public String getAppInstanceId()
  {
    AppMethodBeat.i(2319);
    String str = this.zzacw.zzfu().zzja();
    AppMethodBeat.o(2319);
    return str;
  }
  
  @KeepForSdk
  public Boolean getBoolean()
  {
    AppMethodBeat.i(2333);
    Boolean localBoolean = this.zzacw.zzfu().zzjx();
    AppMethodBeat.o(2333);
    return localBoolean;
  }
  
  @Keep
  @KeepForSdk
  public List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2330);
    paramString1 = this.zzacw.zzfu().getConditionalUserProperties(paramString1, paramString2);
    AppMethodBeat.o(2330);
    return paramString1;
  }
  
  @Keep
  @VisibleForTesting
  protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(2331);
    paramString1 = this.zzacw.zzfu().getConditionalUserPropertiesAs(paramString1, paramString2, paramString3);
    AppMethodBeat.o(2331);
    return paramString1;
  }
  
  @Keep
  public String getCurrentScreenClass()
  {
    AppMethodBeat.i(2318);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzaoi;
      AppMethodBeat.o(2318);
      return localObject;
    }
    AppMethodBeat.o(2318);
    return null;
  }
  
  @Keep
  public String getCurrentScreenName()
  {
    AppMethodBeat.i(2317);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzul;
      AppMethodBeat.o(2317);
      return localObject;
    }
    AppMethodBeat.o(2317);
    return null;
  }
  
  @KeepForSdk
  public Double getDouble()
  {
    AppMethodBeat.i(2337);
    Double localDouble = this.zzacw.zzfu().zzka();
    AppMethodBeat.o(2337);
    return localDouble;
  }
  
  @Keep
  public String getGmpAppId()
  {
    AppMethodBeat.i(2320);
    try
    {
      String str = GoogleServices.getGoogleAppId();
      AppMethodBeat.o(2320);
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", localIllegalStateException);
      AppMethodBeat.o(2320);
    }
    return null;
  }
  
  @KeepForSdk
  public Integer getInteger()
  {
    AppMethodBeat.i(2336);
    Integer localInteger = this.zzacw.zzfu().zzjz();
    AppMethodBeat.o(2336);
    return localInteger;
  }
  
  @KeepForSdk
  public Long getLong()
  {
    AppMethodBeat.i(2335);
    Long localLong = this.zzacw.zzfu().zzjy();
    AppMethodBeat.o(2335);
    return localLong;
  }
  
  @Keep
  @KeepForSdk
  public int getMaxUserProperties(String paramString)
  {
    AppMethodBeat.i(2332);
    this.zzacw.zzfu();
    Preconditions.checkNotEmpty(paramString);
    AppMethodBeat.o(2332);
    return 25;
  }
  
  @KeepForSdk
  public String getString()
  {
    AppMethodBeat.i(2334);
    String str = this.zzacw.zzfu().zzhm();
    AppMethodBeat.o(2334);
    return str;
  }
  
  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(2328);
    paramString1 = this.zzacw.zzfu().getUserProperties(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(2328);
    return paramString1;
  }
  
  @KeepForSdk
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    AppMethodBeat.i(2313);
    Object localObject = this.zzacw.zzfu().zzj(paramBoolean);
    a locala = new a(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zzjx localzzjx = (zzjx)((Iterator)localObject).next();
      locala.put(localzzjx.name, localzzjx.getValue());
    }
    AppMethodBeat.o(2313);
    return locala;
  }
  
  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(2329);
    paramString1 = this.zzacw.zzfu().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(2329);
    return paramString1;
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(2304);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().zza("app", paramString, localBundle, true);
    AppMethodBeat.o(2304);
  }
  
  @Keep
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2310);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().logEvent(paramString1, paramString2, localBundle);
    AppMethodBeat.o(2310);
  }
  
  @KeepForSdk
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    AppMethodBeat.i(2311);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      this.zzacw.zzfu().zza(paramString1, paramString2, paramBundle, paramLong);
      AppMethodBeat.o(2311);
      return;
    }
  }
  
  @KeepForSdk
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(2315);
    this.zzacw.zzfu().registerOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(2315);
  }
  
  @Keep
  @KeepForSdk
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(2324);
    this.zzacw.zzfu().setConditionalUserProperty(paramConditionalUserProperty);
    AppMethodBeat.o(2324);
  }
  
  @Keep
  @VisibleForTesting
  protected void setConditionalUserPropertyAs(ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(2325);
    this.zzacw.zzfu().setConditionalUserPropertyAs(paramConditionalUserProperty);
    AppMethodBeat.o(2325);
  }
  
  @KeepForSdk
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    AppMethodBeat.i(2314);
    this.zzacw.zzfu().setEventInterceptor(paramEventInterceptor);
    AppMethodBeat.o(2314);
  }
  
  @Deprecated
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(2306);
    this.zzacw.zzfu().setMeasurementEnabled(paramBoolean);
    AppMethodBeat.o(2306);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(2307);
    this.zzacw.zzfu().setMinimumSessionDuration(paramLong);
    AppMethodBeat.o(2307);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(2308);
    this.zzacw.zzfu().setSessionTimeoutDuration(paramLong);
    AppMethodBeat.o(2308);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2305);
    int j = this.zzacw.zzgb().zzce(paramString1);
    if (j != 0)
    {
      this.zzacw.zzgb();
      paramString2 = zzka.zza(paramString1, 24, true);
      if (paramString1 != null) {}
      for (int i = paramString1.length();; i = 0)
      {
        this.zzacw.zzgb().zza(j, "_ev", paramString2, i);
        AppMethodBeat.o(2305);
        return;
      }
    }
    setUserPropertyInternal("app", paramString1, paramString2);
    AppMethodBeat.o(2305);
  }
  
  @KeepForSdk
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(2312);
    this.zzacw.zzfu().setUserProperty(paramString1, paramString2, paramObject);
    AppMethodBeat.o(2312);
  }
  
  @KeepForSdk
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(2316);
    this.zzacw.zzfu().unregisterOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(2316);
  }
  
  @KeepForSdk
  public static class ConditionalUserProperty
  {
    @Keep
    @KeepForSdk
    public boolean mActive;
    @Keep
    @KeepForSdk
    public String mAppId;
    @Keep
    @KeepForSdk
    public long mCreationTimestamp;
    @Keep
    public String mExpiredEventName;
    @Keep
    public Bundle mExpiredEventParams;
    @Keep
    @KeepForSdk
    public String mName;
    @Keep
    @KeepForSdk
    public String mOrigin;
    @Keep
    @KeepForSdk
    public long mTimeToLive;
    @Keep
    public String mTimedOutEventName;
    @Keep
    public Bundle mTimedOutEventParams;
    @Keep
    @KeepForSdk
    public String mTriggerEventName;
    @Keep
    @KeepForSdk
    public long mTriggerTimeout;
    @Keep
    public String mTriggeredEventName;
    @Keep
    public Bundle mTriggeredEventParams;
    @Keep
    @KeepForSdk
    public long mTriggeredTimestamp;
    @Keep
    @KeepForSdk
    public Object mValue;
    
    public ConditionalUserProperty() {}
    
    public ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
    {
      AppMethodBeat.i(2299);
      Preconditions.checkNotNull(paramConditionalUserProperty);
      this.mAppId = paramConditionalUserProperty.mAppId;
      this.mOrigin = paramConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
      this.mName = paramConditionalUserProperty.mName;
      if (paramConditionalUserProperty.mValue != null)
      {
        this.mValue = zzka.zzf(paramConditionalUserProperty.mValue);
        if (this.mValue == null) {
          this.mValue = paramConditionalUserProperty.mValue;
        }
      }
      this.mActive = paramConditionalUserProperty.mActive;
      this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
      if (paramConditionalUserProperty.mTimedOutEventParams != null) {
        this.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams);
      }
      this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
      if (paramConditionalUserProperty.mTriggeredEventParams != null) {
        this.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams);
      }
      this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
      if (paramConditionalUserProperty.mExpiredEventParams != null) {
        this.mExpiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams);
      }
      AppMethodBeat.o(2299);
    }
  }
  
  @KeepForSdk
  public static abstract interface EventInterceptor
  {
    @KeepForSdk
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  public static abstract interface OnEventListener
  {
    @KeepForSdk
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  public static final class Param
    extends FirebaseAnalytics.b
  {
    @KeepForSdk
    public static final String FATAL = "fatal";
    @KeepForSdk
    public static final String TIMESTAMP = "timestamp";
    @KeepForSdk
    public static final String TYPE = "type";
    public static final String[] zzacz = { "firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection" };
    public static final String[] zzada = { "_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac" };
    
    public static String zzak(String paramString)
    {
      AppMethodBeat.i(2301);
      paramString = zzka.zza(paramString, zzacz, zzada);
      AppMethodBeat.o(2301);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement
 * JD-Core Version:    0.7.0.1
 */