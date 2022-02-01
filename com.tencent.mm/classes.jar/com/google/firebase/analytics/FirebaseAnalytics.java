package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
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
    AppMethodBeat.i(2347);
    Preconditions.checkNotNull(paramzzgl);
    this.zzacw = paramzzgl;
    AppMethodBeat.o(2347);
  }
  
  @Keep
  public static FirebaseAnalytics getInstance(Context paramContext)
  {
    AppMethodBeat.i(2338);
    paramContext = zzgl.zzg(paramContext).zzjs();
    AppMethodBeat.o(2338);
    return paramContext;
  }
  
  public final Task<String> getAppInstanceId()
  {
    AppMethodBeat.i(2346);
    Task localTask = this.zzacw.zzfu().getAppInstanceId();
    AppMethodBeat.o(2346);
    return localTask;
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(2339);
    this.zzacw.zzjr().logEvent(paramString, paramBundle);
    AppMethodBeat.o(2339);
  }
  
  public final void resetAnalyticsData()
  {
    AppMethodBeat.i(2348);
    this.zzacw.zzfu().resetAnalyticsData();
    AppMethodBeat.o(2348);
  }
  
  public final void setAnalyticsCollectionEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(2342);
    this.zzacw.zzjr().setMeasurementEnabled(paramBoolean);
    AppMethodBeat.o(2342);
  }
  
  @Keep
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(2341);
    this.zzacw.zzfy().setCurrentScreen(paramActivity, paramString1, paramString2);
    AppMethodBeat.o(2341);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(2344);
    this.zzacw.zzjr().setMinimumSessionDuration(paramLong);
    AppMethodBeat.o(2344);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(2345);
    this.zzacw.zzjr().setSessionTimeoutDuration(paramLong);
    AppMethodBeat.o(2345);
  }
  
  public final void setUserId(String paramString)
  {
    AppMethodBeat.i(2343);
    this.zzacw.zzjr().setUserPropertyInternal("app", "_id", paramString);
    AppMethodBeat.o(2343);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2340);
    this.zzacw.zzjr().setUserProperty(paramString1, paramString2);
    AppMethodBeat.o(2340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.firebase.analytics.FirebaseAnalytics
 * JD-Core Version:    0.7.0.1
 */