package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public final class FirebaseAnalytics
{
  private final zzgl zzacw;
  
  public FirebaseAnalytics(zzgl paramzzgl)
  {
    AppMethodBeat.i(69824);
    Preconditions.checkNotNull(paramzzgl);
    this.zzacw = paramzzgl;
    AppMethodBeat.o(69824);
  }
  
  @Keep
  public static FirebaseAnalytics getInstance(Context paramContext)
  {
    AppMethodBeat.i(69815);
    paramContext = zzgl.zzg(paramContext).zzjs();
    AppMethodBeat.o(69815);
    return paramContext;
  }
  
  public final Task<String> getAppInstanceId()
  {
    AppMethodBeat.i(69823);
    Task localTask = this.zzacw.zzfu().getAppInstanceId();
    AppMethodBeat.o(69823);
    return localTask;
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(69816);
    this.zzacw.zzjr().logEvent(paramString, paramBundle);
    AppMethodBeat.o(69816);
  }
  
  public final void resetAnalyticsData()
  {
    AppMethodBeat.i(69825);
    this.zzacw.zzfu().resetAnalyticsData();
    AppMethodBeat.o(69825);
  }
  
  public final void setAnalyticsCollectionEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(69819);
    this.zzacw.zzjr().setMeasurementEnabled(paramBoolean);
    AppMethodBeat.o(69819);
  }
  
  @Keep
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69818);
    this.zzacw.zzfy().setCurrentScreen(paramActivity, paramString1, paramString2);
    AppMethodBeat.o(69818);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(69821);
    this.zzacw.zzjr().setMinimumSessionDuration(paramLong);
    AppMethodBeat.o(69821);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(69822);
    this.zzacw.zzjr().setSessionTimeoutDuration(paramLong);
    AppMethodBeat.o(69822);
  }
  
  public final void setUserId(String paramString)
  {
    AppMethodBeat.i(69820);
    this.zzacw.zzjr().setUserPropertyInternal("app", "_id", paramString);
    AppMethodBeat.o(69820);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69817);
    this.zzacw.zzjr().setUserProperty(paramString1, paramString2);
    AppMethodBeat.o(69817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.analytics.FirebaseAnalytics
 * JD-Core Version:    0.7.0.1
 */