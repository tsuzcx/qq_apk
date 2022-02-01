package com.google.android.gms.measurement;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class AppMeasurement$Event
  extends FirebaseAnalytics.a
{
  @KeepForSdk
  public static final String AD_REWARD = "_ar";
  @KeepForSdk
  public static final String APP_EXCEPTION = "_ae";
  public static final String[] zzacx = { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter" };
  public static final String[] zzacy = { "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep" };
  
  public static String zzak(String paramString)
  {
    AppMethodBeat.i(2300);
    paramString = zzka.zza(paramString, zzacx, zzacy);
    AppMethodBeat.o(2300);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement.Event
 * JD-Core Version:    0.7.0.1
 */