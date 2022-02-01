package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zzew
{
  private static final zzxc zzagc;
  private static zzex<Boolean> zzagd;
  private static zzex<Boolean> zzage;
  private static zzex<Boolean> zzagf;
  private static zzex<Boolean> zzagg;
  public static zzex<Boolean> zzagh;
  public static zzex<String> zzagi;
  public static zzex<Long> zzagj;
  public static zzex<Long> zzagk;
  public static zzex<Long> zzagl;
  public static zzex<String> zzagm;
  public static zzex<String> zzagn;
  public static zzex<Integer> zzago;
  public static zzex<Integer> zzagp;
  public static zzex<Integer> zzagq;
  public static zzex<Integer> zzagr;
  public static zzex<Integer> zzags;
  public static zzex<Integer> zzagt;
  public static zzex<Integer> zzagu;
  public static zzex<Integer> zzagv;
  public static zzex<Integer> zzagw;
  public static zzex<Integer> zzagx;
  public static zzex<String> zzagy;
  public static zzex<Long> zzagz;
  public static zzex<Long> zzaha;
  public static zzex<Long> zzahb;
  public static zzex<Long> zzahc;
  public static zzex<Long> zzahd;
  public static zzex<Long> zzahe;
  public static zzex<Long> zzahf;
  public static zzex<Long> zzahg;
  public static zzex<Long> zzahh;
  public static zzex<Long> zzahi;
  public static zzex<Long> zzahj;
  public static zzex<Integer> zzahk;
  public static zzex<Long> zzahl;
  public static zzex<Integer> zzahm;
  public static zzex<Integer> zzahn;
  public static zzex<Long> zzaho;
  public static zzex<Boolean> zzahp;
  public static zzex<String> zzahq;
  public static zzex<Long> zzahr;
  public static zzex<Integer> zzahs;
  public static zzex<Double> zzaht;
  public static zzex<Boolean> zzahu;
  public static zzex<Boolean> zzahv;
  public static zzex<Boolean> zzahw;
  public static zzex<Boolean> zzahx;
  public static zzex<Boolean> zzahy;
  public static zzex<Boolean> zzahz;
  public static zzex<Boolean> zzaia;
  private static zzex<Boolean> zzaib;
  public static zzex<Boolean> zzaic;
  
  static
  {
    AppMethodBeat.i(1273);
    String str = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
    if (str.length() != 0) {}
    for (str = "content://com.google.android.gms.phenotype/".concat(str);; str = new String("content://com.google.android.gms.phenotype/"))
    {
      zzagc = new zzxc(Uri.parse(str));
      zzagd = zzex.zzb("measurement.log_third_party_store_events_enabled", false, false);
      zzage = zzex.zzb("measurement.log_installs_enabled", false, false);
      zzagf = zzex.zzb("measurement.log_upgrades_enabled", false, false);
      zzagg = zzex.zzb("measurement.log_androidId_enabled", false, false);
      zzagh = zzex.zzb("measurement.upload_dsid_enabled", false, false);
      zzagi = zzex.zzd("measurement.log_tag", "FA", "FA-SVC");
      zzagj = zzex.zzb("measurement.ad_id_cache_time", 10000L, 10000L);
      zzagk = zzex.zzb("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);
      zzagl = zzex.zzb("measurement.config.cache_time", 86400000L, 3600000L);
      zzagm = zzex.zzd("measurement.config.url_scheme", "https", "https");
      zzagn = zzex.zzd("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
      zzago = zzex.zzc("measurement.upload.max_bundles", 100, 100);
      zzagp = zzex.zzc("measurement.upload.max_batch_size", 65536, 65536);
      zzagq = zzex.zzc("measurement.upload.max_bundle_size", 65536, 65536);
      zzagr = zzex.zzc("measurement.upload.max_events_per_bundle", 1000, 1000);
      zzags = zzex.zzc("measurement.upload.max_events_per_day", 100000, 100000);
      zzagt = zzex.zzc("measurement.upload.max_error_events_per_day", 1000, 1000);
      zzagu = zzex.zzc("measurement.upload.max_public_events_per_day", 50000, 50000);
      zzagv = zzex.zzc("measurement.upload.max_conversions_per_day", 500, 500);
      zzagw = zzex.zzc("measurement.upload.max_realtime_events_per_day", 10, 10);
      zzagx = zzex.zzc("measurement.store.max_stored_events_per_app", 100000, 100000);
      zzagy = zzex.zzd("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
      zzagz = zzex.zzb("measurement.upload.backoff_period", 43200000L, 43200000L);
      zzaha = zzex.zzb("measurement.upload.window_interval", 3600000L, 3600000L);
      zzahb = zzex.zzb("measurement.upload.interval", 3600000L, 3600000L);
      zzahc = zzex.zzb("measurement.upload.realtime_upload_interval", 10000L, 10000L);
      zzahd = zzex.zzb("measurement.upload.debug_upload_interval", 1000L, 1000L);
      zzahe = zzex.zzb("measurement.upload.minimum_delay", 500L, 500L);
      zzahf = zzex.zzb("measurement.alarm_manager.minimum_interval", 60000L, 60000L);
      zzahg = zzex.zzb("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);
      zzahh = zzex.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
      zzahi = zzex.zzb("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
      zzahj = zzex.zzb("measurement.upload.retry_time", 1800000L, 1800000L);
      zzahk = zzex.zzc("measurement.upload.retry_count", 6, 6);
      zzahl = zzex.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
      zzahm = zzex.zzc("measurement.lifetimevalue.max_currency_tracked", 4, 4);
      zzahn = zzex.zzc("measurement.audience.filter_result_max_count", 200, 200);
      zzaho = zzex.zzb("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
      zzahp = zzex.zzb("measurement.test.boolean_flag", false, false);
      zzahq = zzex.zzd("measurement.test.string_flag", "---", "---");
      zzahr = zzex.zzb("measurement.test.long_flag", -1L, -1L);
      zzahs = zzex.zzc("measurement.test.int_flag", -2, -2);
      zzaht = zzex.zza("measurement.test.double_flag", -3.0D, -3.0D);
      zzahu = zzex.zzb("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
      zzahv = zzex.zzb("measurement.audience.complex_param_evaluation", false, false);
      zzahw = zzex.zzb("measurement.validation.internal_limits_internal_event_params", false, false);
      zzahx = zzex.zzb("measurement.quality.unsuccessful_update_retry_counter", false, false);
      zzahy = zzex.zzb("measurement.iid.disable_on_collection_disabled", true, true);
      zzahz = zzex.zzb("measurement.app_launch.call_only_when_enabled", true, true);
      zzaia = zzex.zzb("measurement.run_on_worker_inline", true, false);
      zzaib = zzex.zzb("measurement.audience.dynamic_filters", false, false);
      zzaic = zzex.zzb("measurement.reset_analytics.persist_time", false, false);
      AppMethodBeat.o(1273);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzew
 * JD-Core Version:    0.7.0.1
 */