package com.google.android.gms.measurement;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class AppMeasurement$UserProperty
  extends FirebaseAnalytics.c
{
  @KeepForSdk
  public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
  public static final String[] zzadb = { "firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement" };
  public static final String[] zzadc = { "_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte" };
  
  public static String zzak(String paramString)
  {
    AppMethodBeat.i(69779);
    paramString = zzka.zza(paramString, zzadb, zzadc);
    AppMethodBeat.o(69779);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement.UserProperty
 * JD-Core Version:    0.7.0.1
 */