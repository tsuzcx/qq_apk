package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

@VisibleForTesting
final class zzel
  extends SQLiteOpenHelper
{
  zzel(zzei paramzzei, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    AppMethodBeat.i(1217);
    Object localObject;
    if (!zzei.zza(this.zzafi).zzj(3600000L))
    {
      localObject = new SQLiteException("Database open failed");
      AppMethodBeat.o(1217);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = super.getWritableDatabase();
      AppMethodBeat.o(1217);
      return localObject;
    }
    catch (SQLiteException localSQLiteException1)
    {
      zzei.zza(this.zzafi).start();
      this.zzafi.zzge().zzim().log("Opening the database failed, dropping and recreating it");
      if (!this.zzafi.getContext().getDatabasePath("google_app_measurement.db").delete()) {
        this.zzafi.zzge().zzim().zzg("Failed to delete corrupted db file", "google_app_measurement.db");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        zzei.zza(this.zzafi).clear();
        AppMethodBeat.o(1217);
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zzafi.zzge().zzim().zzg("Failed to open freshly created database", localSQLiteException2);
        AppMethodBeat.o(1217);
        throw localSQLiteException2;
      }
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(1219);
    zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase);
    AppMethodBeat.o(1219);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(1218);
    Cursor localCursor;
    if (Build.VERSION.SDK_INT < 15) {
      localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
    }
    try
    {
      localCursor.moveToFirst();
      localCursor.close();
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzei.zzhw());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzei.zzhx());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzei.zzhy());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzei.zzhz());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzei.zzia());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzei.zzib());
      zzei.zza(this.zzafi.zzge(), paramSQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
      AppMethodBeat.o(1218);
      return;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(1218);
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzel
 * JD-Core Version:    0.7.0.1
 */