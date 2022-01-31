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
    AppMethodBeat.i(69786);
    Preconditions.checkNotNull(paramzzgl);
    this.zzacw = paramzzgl;
    AppMethodBeat.o(69786);
  }
  
  @Deprecated
  @Keep
  public static AppMeasurement getInstance(Context paramContext)
  {
    AppMethodBeat.i(69780);
    paramContext = zzgl.zzg(paramContext).zzjr();
    AppMethodBeat.o(69780);
    return paramContext;
  }
  
  @Keep
  public void beginAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(69799);
    this.zzacw.zzft().beginAdUnitExposure(paramString);
    AppMethodBeat.o(69799);
  }
  
  @Keep
  @KeepForSdk
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(69803);
    this.zzacw.zzfu().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(69803);
  }
  
  @Keep
  @VisibleForTesting
  protected void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(69804);
    this.zzacw.zzfu().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
    AppMethodBeat.o(69804);
  }
  
  @Keep
  public void endAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(69800);
    this.zzacw.zzft().endAdUnitExposure(paramString);
    AppMethodBeat.o(69800);
  }
  
  @Keep
  public long generateEventId()
  {
    AppMethodBeat.i(69798);
    long l = this.zzacw.zzgb().zzlb();
    AppMethodBeat.o(69798);
    return l;
  }
  
  @Keep
  public String getAppInstanceId()
  {
    AppMethodBeat.i(69796);
    String str = this.zzacw.zzfu().zzja();
    AppMethodBeat.o(69796);
    return str;
  }
  
  @KeepForSdk
  public Boolean getBoolean()
  {
    AppMethodBeat.i(69810);
    Boolean localBoolean = this.zzacw.zzfu().zzjx();
    AppMethodBeat.o(69810);
    return localBoolean;
  }
  
  @Keep
  @KeepForSdk
  public List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69807);
    paramString1 = this.zzacw.zzfu().getConditionalUserProperties(paramString1, paramString2);
    AppMethodBeat.o(69807);
    return paramString1;
  }
  
  @Keep
  @VisibleForTesting
  protected List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(69808);
    paramString1 = this.zzacw.zzfu().getConditionalUserPropertiesAs(paramString1, paramString2, paramString3);
    AppMethodBeat.o(69808);
    return paramString1;
  }
  
  @Keep
  public String getCurrentScreenClass()
  {
    AppMethodBeat.i(69795);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzaoi;
      AppMethodBeat.o(69795);
      return localObject;
    }
    AppMethodBeat.o(69795);
    return null;
  }
  
  @Keep
  public String getCurrentScreenName()
  {
    AppMethodBeat.i(69794);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzul;
      AppMethodBeat.o(69794);
      return localObject;
    }
    AppMethodBeat.o(69794);
    return null;
  }
  
  @KeepForSdk
  public Double getDouble()
  {
    AppMethodBeat.i(69814);
    Double localDouble = this.zzacw.zzfu().zzka();
    AppMethodBeat.o(69814);
    return localDouble;
  }
  
  @Keep
  public String getGmpAppId()
  {
    AppMethodBeat.i(69797);
    try
    {
      String str = GoogleServices.getGoogleAppId();
      AppMethodBeat.o(69797);
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", localIllegalStateException);
      AppMethodBeat.o(69797);
    }
    return null;
  }
  
  @KeepForSdk
  public Integer getInteger()
  {
    AppMethodBeat.i(69813);
    Integer localInteger = this.zzacw.zzfu().zzjz();
    AppMethodBeat.o(69813);
    return localInteger;
  }
  
  @KeepForSdk
  public Long getLong()
  {
    AppMethodBeat.i(69812);
    Long localLong = this.zzacw.zzfu().zzjy();
    AppMethodBeat.o(69812);
    return localLong;
  }
  
  @Keep
  @KeepForSdk
  public int getMaxUserProperties(String paramString)
  {
    AppMethodBeat.i(69809);
    this.zzacw.zzfu();
    Preconditions.checkNotEmpty(paramString);
    AppMethodBeat.o(69809);
    return 25;
  }
  
  @KeepForSdk
  public String getString()
  {
    AppMethodBeat.i(69811);
    String str = this.zzacw.zzfu().zzhm();
    AppMethodBeat.o(69811);
    return str;
  }
  
  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(69805);
    paramString1 = this.zzacw.zzfu().getUserProperties(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(69805);
    return paramString1;
  }
  
  @KeepForSdk
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    AppMethodBeat.i(69790);
    Object localObject = this.zzacw.zzfu().zzj(paramBoolean);
    a locala = new a(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zzjx localzzjx = (zzjx)((Iterator)localObject).next();
      locala.put(localzzjx.name, localzzjx.getValue());
    }
    AppMethodBeat.o(69790);
    return locala;
  }
  
  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(69806);
    paramString1 = this.zzacw.zzfu().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(69806);
    return paramString1;
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(69781);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().zza("app", paramString, localBundle, true);
    AppMethodBeat.o(69781);
  }
  
  @Keep
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(69787);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().logEvent(paramString1, paramString2, localBundle);
    AppMethodBeat.o(69787);
  }
  
  @KeepForSdk
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    AppMethodBeat.i(69788);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      this.zzacw.zzfu().zza(paramString1, paramString2, paramBundle, paramLong);
      AppMethodBeat.o(69788);
      return;
    }
  }
  
  @KeepForSdk
  public void registerOnMeasurementEventListener(AppMeasurement.OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(69792);
    this.zzacw.zzfu().registerOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(69792);
  }
  
  @Keep
  @KeepForSdk
  public void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(69801);
    this.zzacw.zzfu().setConditionalUserProperty(paramConditionalUserProperty);
    AppMethodBeat.o(69801);
  }
  
  @Keep
  @VisibleForTesting
  protected void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(69802);
    this.zzacw.zzfu().setConditionalUserPropertyAs(paramConditionalUserProperty);
    AppMethodBeat.o(69802);
  }
  
  @KeepForSdk
  public void setEventInterceptor(AppMeasurement.EventInterceptor paramEventInterceptor)
  {
    AppMethodBeat.i(69791);
    this.zzacw.zzfu().setEventInterceptor(paramEventInterceptor);
    AppMethodBeat.o(69791);
  }
  
  @Deprecated
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(69783);
    this.zzacw.zzfu().setMeasurementEnabled(paramBoolean);
    AppMethodBeat.o(69783);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(69784);
    this.zzacw.zzfu().setMinimumSessionDuration(paramLong);
    AppMethodBeat.o(69784);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(69785);
    this.zzacw.zzfu().setSessionTimeoutDuration(paramLong);
    AppMethodBeat.o(69785);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69782);
    int j = this.zzacw.zzgb().zzce(paramString1);
    if (j != 0)
    {
      this.zzacw.zzgb();
      paramString2 = zzka.zza(paramString1, 24, true);
      if (paramString1 != null) {}
      for (int i = paramString1.length();; i = 0)
      {
        this.zzacw.zzgb().zza(j, "_ev", paramString2, i);
        AppMethodBeat.o(69782);
        return;
      }
    }
    setUserPropertyInternal("app", paramString1, paramString2);
    AppMethodBeat.o(69782);
  }
  
  @KeepForSdk
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(69789);
    this.zzacw.zzfu().setUserProperty(paramString1, paramString2, paramObject);
    AppMethodBeat.o(69789);
  }
  
  @KeepForSdk
  public void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(69793);
    this.zzacw.zzfu().unregisterOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(69793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement
 * JD-Core Version:    0.7.0.1
 */