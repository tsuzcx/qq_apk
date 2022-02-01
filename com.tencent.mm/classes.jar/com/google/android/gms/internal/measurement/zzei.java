package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzei
  extends zzjq
{
  private static final String[] zzaev = { "last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;" };
  private static final String[] zzaew = { "origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;" };
  private static final String[] zzaex = { "app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;" };
  private static final String[] zzaey = { "realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;" };
  private static final String[] zzaez = { "has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;" };
  private static final String[] zzafa = { "previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;" };
  private final zzel zzafb;
  private final zzjm zzafc;
  
  zzei(zzjr paramzzjr)
  {
    super(paramzzjr);
    AppMethodBeat.i(1161);
    this.zzafc = new zzjm(zzbt());
    this.zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    AppMethodBeat.o(1161);
  }
  
  private final long zza(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(1165);
    Object localObject2 = getWritableDatabase();
    Object localObject1 = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = ((SQLiteDatabase)localObject2).rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject1 = paramArrayOfString;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        AppMethodBeat.o(1165);
        return l;
      }
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      localObject2 = new SQLiteException("Database returned empty set");
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      AppMethodBeat.o(1165);
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      throw ((Throwable)localObject2);
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject1 = arrayOfString;
      zzge().zzim().zze("Database error", paramString, paramArrayOfString);
      localObject1 = arrayOfString;
      AppMethodBeat.o(1165);
      localObject1 = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      AppMethodBeat.o(1165);
    }
  }
  
  private final long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    AppMethodBeat.i(1166);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        paramLong = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        AppMethodBeat.o(1166);
        return paramLong;
      }
      if (paramArrayOfString != null) {
        paramArrayOfString.close();
      }
      AppMethodBeat.o(1166);
      return paramLong;
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzge().zzim().zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      AppMethodBeat.o(1166);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      AppMethodBeat.o(1166);
    }
  }
  
  @VisibleForTesting
  private final Object zza(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(1199);
    int i = paramCursor.getType(paramInt);
    switch (i)
    {
    default: 
      zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
      AppMethodBeat.o(1199);
      return null;
    case 0: 
      zzge().zzim().log("Loaded invalid null value from database");
      AppMethodBeat.o(1199);
      return null;
    case 1: 
      long l = paramCursor.getLong(paramInt);
      AppMethodBeat.o(1199);
      return Long.valueOf(l);
    case 2: 
      double d = paramCursor.getDouble(paramInt);
      AppMethodBeat.o(1199);
      return Double.valueOf(d);
    case 3: 
      paramCursor = paramCursor.getString(paramInt);
      AppMethodBeat.o(1199);
      return paramCursor;
    }
    zzge().zzim().log("Loaded invalid blob type value, ignoring it");
    AppMethodBeat.o(1199);
    return null;
  }
  
  private static void zza(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    AppMethodBeat.i(1198);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      AppMethodBeat.o(1198);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      AppMethodBeat.o(1198);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put(paramString, (Double)paramObject);
      AppMethodBeat.o(1198);
      return;
    }
    paramContentValues = new IllegalArgumentException("Invalid value type");
    AppMethodBeat.o(1198);
    throw paramContentValues;
  }
  
  static void zza(zzfg paramzzfg, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(1216);
    if (paramzzfg == null)
    {
      paramzzfg = new IllegalArgumentException("Monitor must not be null");
      AppMethodBeat.o(1216);
      throw paramzzfg;
    }
    paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
    if (!paramSQLiteDatabase.setReadable(false, false)) {
      paramzzfg.zzip().log("Failed to turn off database read permission");
    }
    if (!paramSQLiteDatabase.setWritable(false, false)) {
      paramzzfg.zzip().log("Failed to turn off database write permission");
    }
    if (!paramSQLiteDatabase.setReadable(true, true)) {
      paramzzfg.zzip().log("Failed to turn on database read permission for owner");
    }
    if (!paramSQLiteDatabase.setWritable(true, true)) {
      paramzzfg.zzip().log("Failed to turn on database write permission for owner");
    }
    AppMethodBeat.o(1216);
  }
  
  static void zza(zzfg paramzzfg, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(1215);
    if (paramzzfg == null)
    {
      paramzzfg = new IllegalArgumentException("Monitor must not be null");
      AppMethodBeat.o(1215);
      throw paramzzfg;
    }
    if (!zza(paramzzfg, paramSQLiteDatabase, paramString1)) {
      paramSQLiteDatabase.execSQL(paramString2);
    }
    if (paramzzfg == null) {
      try
      {
        paramSQLiteDatabase = new IllegalArgumentException("Monitor must not be null");
        AppMethodBeat.o(1215);
        throw paramSQLiteDatabase;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        paramzzfg.zzim().zzg("Failed to verify columns on table that was just created", paramString1);
        AppMethodBeat.o(1215);
        throw paramSQLiteDatabase;
      }
    }
    paramString2 = zzb(paramSQLiteDatabase, paramString1);
    paramString3 = paramString3.split(",");
    int k = paramString3.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramString3[i];
      if (!paramString2.remove(localObject))
      {
        paramSQLiteDatabase = new SQLiteException(String.valueOf(paramString1).length() + 35 + String.valueOf(localObject).length() + "Table " + paramString1 + " is missing required column: " + localObject);
        AppMethodBeat.o(1215);
        throw paramSQLiteDatabase;
      }
    }
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        if (!paramString2.remove(paramArrayOfString[i])) {
          paramSQLiteDatabase.execSQL(paramArrayOfString[(i + 1)]);
        }
      }
      else
      {
        do
        {
          if (!paramString2.isEmpty()) {
            paramzzfg.zzip().zze("Table has extra columns. table, columns", paramString1, TextUtils.join(", ", paramString2));
          }
          AppMethodBeat.o(1215);
          return;
          i += 1;
          break;
        } while (paramArrayOfString == null);
        i = j;
        continue;
      }
      i += 2;
    }
  }
  
  /* Error */
  private static boolean zza(zzfg paramzzfg, SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 1213
    //   6: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +22 -> 32
    //   13: new 312	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc_w 318
    //   20: invokespecial 315	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: sipush 1213
    //   27: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: aload_1
    //   33: ldc_w 405
    //   36: iconst_1
    //   37: anewarray 19	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc_w 407
    //   45: aastore
    //   46: ldc_w 409
    //   49: iconst_1
    //   50: anewarray 19	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_1
    //   64: aload_1
    //   65: astore 4
    //   67: aload 4
    //   69: astore_1
    //   70: aload 4
    //   72: invokeinterface 211 1 0
    //   77: istore_3
    //   78: aload 4
    //   80: ifnull +10 -> 90
    //   83: aload 4
    //   85: invokeinterface 218 1 0
    //   90: sipush 1213
    //   93: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: iload_3
    //   97: ireturn
    //   98: astore 5
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 4
    //   105: astore_1
    //   106: aload_0
    //   107: invokevirtual 332	com/google/android/gms/internal/measurement/zzfg:zzip	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   110: ldc_w 415
    //   113: aload_2
    //   114: aload 5
    //   116: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   119: aload 4
    //   121: ifnull +10 -> 131
    //   124: aload 4
    //   126: invokeinterface 218 1 0
    //   131: sipush 1213
    //   134: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload_1
    //   148: invokeinterface 218 1 0
    //   153: sipush 1213
    //   156: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore 5
    //   167: goto -64 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramzzfg	zzfg
    //   0	170	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	170	2	paramString	String
    //   77	20	3	bool	boolean
    //   1	140	4	localSQLiteDatabase	SQLiteDatabase
    //   98	17	5	localSQLiteException1	SQLiteException
    //   165	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   32	64	98	android/database/sqlite/SQLiteException
    //   32	64	139	finally
    //   70	78	161	finally
    //   106	119	161	finally
    //   70	78	165	android/database/sqlite/SQLiteException
  }
  
  private final boolean zza(String paramString, int paramInt, zzke paramzzke)
  {
    AppMethodBeat.i(1192);
    zzch();
    zzab();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzke);
    if (TextUtils.isEmpty(paramzzke.zzarq))
    {
      zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(paramString), Integer.valueOf(paramInt), String.valueOf(paramzzke.zzarp));
      AppMethodBeat.o(1192);
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzzke.zzvm()];
      Object localObject = zzabw.zzb(arrayOfByte, 0, arrayOfByte.length);
      paramzzke.zza((zzabw)localObject);
      ((zzabw)localObject).zzve();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", paramzzke.zzarp);
      ((ContentValues)localObject).put("event_name", paramzzke.zzarq);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return false;
    }
    catch (IOException paramzzke)
    {
      try
      {
        if (getWritableDatabase().insertWithOnConflict("event_filters", null, (ContentValues)localObject, 5) == -1L) {
          zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(paramString));
        }
        AppMethodBeat.o(1192);
        return true;
      }
      catch (SQLiteException paramzzke)
      {
        zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(paramString), paramzzke);
        AppMethodBeat.o(1192);
      }
      paramzzke = paramzzke;
      zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(paramString), paramzzke);
      AppMethodBeat.o(1192);
      return false;
    }
  }
  
  /* Error */
  private final boolean zza(String paramString, int paramInt, zzkh paramzzkh)
  {
    // Byte code:
    //   0: sipush 1193
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   10: aload_0
    //   11: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   14: aload_1
    //   15: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   18: pop
    //   19: aload_3
    //   20: invokestatic 298	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: aload_3
    //   25: getfield 501	com/google/android/gms/internal/measurement/zzkh:zzasf	Ljava/lang/String;
    //   28: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +39 -> 70
    //   34: aload_0
    //   35: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   38: invokevirtual 332	com/google/android/gms/internal/measurement/zzfg:zzip	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   41: ldc_w 503
    //   44: aload_1
    //   45: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: iload_2
    //   49: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aload_3
    //   53: getfield 504	com/google/android/gms/internal/measurement/zzkh:zzarp	Ljava/lang/Integer;
    //   56: invokestatic 373	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   62: sipush 1193
    //   65: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_3
    //   71: invokevirtual 452	com/google/android/gms/internal/measurement/zzace:zzvm	()I
    //   74: newarray byte
    //   76: astore 4
    //   78: aload 4
    //   80: iconst_0
    //   81: aload 4
    //   83: arraylength
    //   84: invokestatic 457	com/google/android/gms/internal/measurement/zzabw:zzb	([BII)Lcom/google/android/gms/internal/measurement/zzabw;
    //   87: astore 5
    //   89: aload_3
    //   90: aload 5
    //   92: invokevirtual 460	com/google/android/gms/internal/measurement/zzace:zza	(Lcom/google/android/gms/internal/measurement/zzabw;)V
    //   95: aload 5
    //   97: invokevirtual 463	com/google/android/gms/internal/measurement/zzabw:zzve	()V
    //   100: new 300	android/content/ContentValues
    //   103: dup
    //   104: invokespecial 465	android/content/ContentValues:<init>	()V
    //   107: astore 5
    //   109: aload 5
    //   111: ldc_w 467
    //   114: aload_1
    //   115: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 5
    //   120: ldc_w 469
    //   123: iload_2
    //   124: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   130: aload 5
    //   132: ldc_w 474
    //   135: aload_3
    //   136: getfield 504	com/google/android/gms/internal/measurement/zzkh:zzarp	Ljava/lang/Integer;
    //   139: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   142: aload 5
    //   144: ldc_w 506
    //   147: aload_3
    //   148: getfield 501	com/google/android/gms/internal/measurement/zzkh:zzasf	Ljava/lang/String;
    //   151: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 5
    //   156: ldc_w 478
    //   159: aload 4
    //   161: invokevirtual 481	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   164: aload_0
    //   165: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   168: ldc_w 508
    //   171: aconst_null
    //   172: aload 5
    //   174: iconst_5
    //   175: invokevirtual 487	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   178: ldc2_w 488
    //   181: lcmp
    //   182: ifne +82 -> 264
    //   185: aload_0
    //   186: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   189: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   192: ldc_w 510
    //   195: aload_1
    //   196: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   199: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   202: sipush 1193
    //   205: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_3
    //   211: aload_0
    //   212: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   215: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   218: ldc_w 512
    //   221: aload_1
    //   222: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   225: aload_3
    //   226: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   229: sipush 1193
    //   232: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: iconst_0
    //   236: ireturn
    //   237: astore_3
    //   238: aload_0
    //   239: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   242: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   245: ldc_w 514
    //   248: aload_1
    //   249: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   252: aload_3
    //   253: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   256: sipush 1193
    //   259: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iconst_0
    //   263: ireturn
    //   264: sipush 1193
    //   267: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: iconst_1
    //   271: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	zzei
    //   0	272	1	paramString	String
    //   0	272	2	paramInt	int
    //   0	272	3	paramzzkh	zzkh
    //   76	84	4	arrayOfByte	byte[]
    //   87	86	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   70	100	210	java/io/IOException
    //   164	202	237	android/database/sqlite/SQLiteException
  }
  
  private final boolean zza(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(1196);
    Preconditions.checkNotEmpty(paramString);
    zzch();
    zzab();
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    int j;
    try
    {
      long l = zza("select count(1) from audience_filter_values where app_id=?", new String[] { paramString });
      j = Math.max(0, Math.min(2000, zzgg().zzb(paramString, zzew.zzahn)));
      if (l <= j)
      {
        AppMethodBeat.o(1196);
        return false;
      }
    }
    catch (SQLiteException paramList)
    {
      zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(paramString), paramList);
      AppMethodBeat.o(1196);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Integer localInteger = (Integer)paramList.get(i);
      if ((localInteger == null) || (!(localInteger instanceof Integer)))
      {
        AppMethodBeat.o(1196);
        return false;
      }
      localArrayList.add(Integer.toString(localInteger.intValue()));
      i += 1;
    }
    paramList = TextUtils.join(",", localArrayList);
    paramList = String.valueOf(paramList).length() + 2 + "(" + paramList + ")";
    if (localSQLiteDatabase.delete("audience_filter_values", String.valueOf(paramList).length() + 140 + "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + paramList + " order by rowid desc limit -1 offset ?)", new String[] { paramString, Integer.toString(j) }) > 0)
    {
      AppMethodBeat.o(1196);
      return true;
    }
    AppMethodBeat.o(1196);
    return false;
  }
  
  private static Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(1214);
    HashSet localHashSet = new HashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(String.valueOf(paramString).length() + 22 + "SELECT * FROM " + paramString + " LIMIT 0", null);
    try
    {
      Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
      return localHashSet;
    }
    finally
    {
      paramSQLiteDatabase.close();
      AppMethodBeat.o(1214);
    }
  }
  
  private final boolean zzhv()
  {
    AppMethodBeat.i(1212);
    boolean bool = getContext().getDatabasePath("google_app_measurement.db").exists();
    AppMethodBeat.o(1212);
    return bool;
  }
  
  public final void beginTransaction()
  {
    AppMethodBeat.i(1162);
    zzch();
    getWritableDatabase().beginTransaction();
    AppMethodBeat.o(1162);
  }
  
  public final void endTransaction()
  {
    AppMethodBeat.i(1164);
    zzch();
    getWritableDatabase().endTransaction();
    AppMethodBeat.o(1164);
  }
  
  @VisibleForTesting
  final SQLiteDatabase getWritableDatabase()
  {
    AppMethodBeat.i(1167);
    zzab();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzafb.getWritableDatabase();
      AppMethodBeat.o(1167);
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzip().zzg("Error opening database", localSQLiteException);
      AppMethodBeat.o(1167);
      throw localSQLiteException;
    }
  }
  
  public final void setTransactionSuccessful()
  {
    AppMethodBeat.i(1163);
    zzch();
    getWritableDatabase().setTransactionSuccessful();
    AppMethodBeat.o(1163);
  }
  
  /* Error */
  public final long zza(zzkq paramzzkq)
  {
    // Byte code:
    //   0: sipush 1203
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   14: aload_1
    //   15: invokestatic 298	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
    //   19: aload_1
    //   20: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   23: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 452	com/google/android/gms/internal/measurement/zzace:zzvm	()I
    //   31: newarray byte
    //   33: astore 4
    //   35: aload 4
    //   37: iconst_0
    //   38: aload 4
    //   40: arraylength
    //   41: invokestatic 457	com/google/android/gms/internal/measurement/zzabw:zzb	([BII)Lcom/google/android/gms/internal/measurement/zzabw;
    //   44: astore 5
    //   46: aload_1
    //   47: aload 5
    //   49: invokevirtual 460	com/google/android/gms/internal/measurement/zzace:zza	(Lcom/google/android/gms/internal/measurement/zzabw;)V
    //   52: aload 5
    //   54: invokevirtual 463	com/google/android/gms/internal/measurement/zzabw:zzve	()V
    //   57: aload_0
    //   58: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   61: astore 5
    //   63: aload 4
    //   65: invokestatic 298	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: aload 5
    //   71: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   74: ldc_w 639
    //   77: invokestatic 645	com/google/android/gms/internal/measurement/zzka:getMessageDigest	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   80: astore 6
    //   82: aload 6
    //   84: ifnonnull +118 -> 202
    //   87: aload 5
    //   89: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   92: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   95: ldc_w 647
    //   98: invokevirtual 266	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   101: lconst_0
    //   102: lstore_2
    //   103: new 300	android/content/ContentValues
    //   106: dup
    //   107: invokespecial 465	android/content/ContentValues:<init>	()V
    //   110: astore 5
    //   112: aload 5
    //   114: ldc_w 467
    //   117: aload_1
    //   118: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   121: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload 5
    //   126: ldc_w 649
    //   129: lload_2
    //   130: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   136: aload 5
    //   138: ldc_w 651
    //   141: aload 4
    //   143: invokevirtual 481	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   146: aload_0
    //   147: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   150: ldc_w 653
    //   153: aconst_null
    //   154: aload 5
    //   156: iconst_4
    //   157: invokevirtual 487	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   160: pop2
    //   161: sipush 1203
    //   164: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: lload_2
    //   168: lreturn
    //   169: astore 4
    //   171: aload_0
    //   172: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   175: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   178: ldc_w 655
    //   181: aload_1
    //   182: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   185: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   188: aload 4
    //   190: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   193: sipush 1203
    //   196: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: athrow
    //   202: aload 6
    //   204: aload 4
    //   206: invokevirtual 661	java/security/MessageDigest:digest	([B)[B
    //   209: invokestatic 665	com/google/android/gms/internal/measurement/zzka:zzc	([B)J
    //   212: lstore_2
    //   213: goto -110 -> 103
    //   216: astore 4
    //   218: aload_0
    //   219: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   222: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   225: ldc_w 667
    //   228: aload_1
    //   229: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   232: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   235: aload 4
    //   237: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   240: sipush 1203
    //   243: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 4
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	zzei
    //   0	249	1	paramzzkq	zzkq
    //   102	111	2	l	long
    //   33	109	4	arrayOfByte	byte[]
    //   169	36	4	localIOException	IOException
    //   216	31	4	localSQLiteException	SQLiteException
    //   44	111	5	localObject	Object
    //   80	123	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   27	57	169	java/io/IOException
    //   146	161	216	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final android.util.Pair<zzkn, Long> zza(String paramString, Long paramLong)
  {
    // Byte code:
    //   0: sipush 1209
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   14: aload_0
    //   15: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: ldc_w 670
    //   21: iconst_2
    //   22: anewarray 19	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_2
    //   32: invokestatic 373	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   35: aastore
    //   36: invokevirtual 205	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 6
    //   41: aload 6
    //   43: astore 5
    //   45: aload 6
    //   47: invokeinterface 211 1 0
    //   52: ifne +40 -> 92
    //   55: aload 6
    //   57: astore 5
    //   59: aload_0
    //   60: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   63: invokevirtual 673	com/google/android/gms/internal/measurement/zzfg:zzit	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   66: ldc_w 675
    //   69: invokevirtual 266	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   72: aload 6
    //   74: ifnull +10 -> 84
    //   77: aload 6
    //   79: invokeinterface 218 1 0
    //   84: sipush 1209
    //   87: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: aload 6
    //   94: astore 5
    //   96: aload 6
    //   98: iconst_0
    //   99: invokeinterface 679 2 0
    //   104: astore 7
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: iconst_1
    //   113: invokeinterface 215 2 0
    //   118: lstore_3
    //   119: aload 6
    //   121: astore 5
    //   123: aload 7
    //   125: iconst_0
    //   126: aload 7
    //   128: arraylength
    //   129: invokestatic 684	com/google/android/gms/internal/measurement/zzabv:zza	([BII)Lcom/google/android/gms/internal/measurement/zzabv;
    //   132: astore 7
    //   134: aload 6
    //   136: astore 5
    //   138: new 686	com/google/android/gms/internal/measurement/zzkn
    //   141: dup
    //   142: invokespecial 687	com/google/android/gms/internal/measurement/zzkn:<init>	()V
    //   145: astore 8
    //   147: aload 6
    //   149: astore 5
    //   151: aload 8
    //   153: aload 7
    //   155: invokevirtual 690	com/google/android/gms/internal/measurement/zzace:zzb	(Lcom/google/android/gms/internal/measurement/zzabv;)Lcom/google/android/gms/internal/measurement/zzace;
    //   158: pop
    //   159: aload 6
    //   161: astore 5
    //   163: aload 8
    //   165: lload_3
    //   166: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   169: invokestatic 696	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   172: astore_1
    //   173: aload 6
    //   175: ifnull +10 -> 185
    //   178: aload 6
    //   180: invokeinterface 218 1 0
    //   185: sipush 1209
    //   188: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: areturn
    //   193: astore 7
    //   195: aload 6
    //   197: astore 5
    //   199: aload_0
    //   200: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   203: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   206: ldc_w 698
    //   209: aload_1
    //   210: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   213: aload_2
    //   214: aload 7
    //   216: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   219: aload 6
    //   221: ifnull +10 -> 231
    //   224: aload 6
    //   226: invokeinterface 218 1 0
    //   231: sipush 1209
    //   234: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_1
    //   240: aconst_null
    //   241: astore 6
    //   243: aload 6
    //   245: astore 5
    //   247: aload_0
    //   248: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   251: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   254: ldc_w 700
    //   257: aload_1
    //   258: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   261: aload 6
    //   263: ifnull +10 -> 273
    //   266: aload 6
    //   268: invokeinterface 218 1 0
    //   273: sipush 1209
    //   276: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 5
    //   285: aload 5
    //   287: ifnull +10 -> 297
    //   290: aload 5
    //   292: invokeinterface 218 1 0
    //   297: sipush 1209
    //   300: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: goto -21 -> 285
    //   309: astore_1
    //   310: goto -67 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	zzei
    //   0	313	1	paramString	String
    //   0	313	2	paramLong	Long
    //   118	48	3	l	long
    //   43	248	5	localCursor1	Cursor
    //   39	228	6	localCursor2	Cursor
    //   104	50	7	localObject	Object
    //   193	22	7	localIOException	IOException
    //   145	19	8	localzzkn	zzkn
    // Exception table:
    //   from	to	target	type
    //   151	159	193	java/io/IOException
    //   14	41	239	android/database/sqlite/SQLiteException
    //   14	41	281	finally
    //   45	55	305	finally
    //   59	72	305	finally
    //   96	106	305	finally
    //   110	119	305	finally
    //   123	134	305	finally
    //   138	147	305	finally
    //   151	159	305	finally
    //   163	173	305	finally
    //   199	219	305	finally
    //   247	261	305	finally
    //   45	55	309	android/database/sqlite/SQLiteException
    //   59	72	309	android/database/sqlite/SQLiteException
    //   96	106	309	android/database/sqlite/SQLiteException
    //   110	119	309	android/database/sqlite/SQLiteException
    //   123	134	309	android/database/sqlite/SQLiteException
    //   138	147	309	android/database/sqlite/SQLiteException
    //   151	159	309	android/database/sqlite/SQLiteException
    //   163	173	309	android/database/sqlite/SQLiteException
    //   199	219	309	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final zzej zza(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    // Byte code:
    //   0: sipush 1183
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   15: aload_0
    //   16: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   19: new 704	com/google/android/gms/internal/measurement/zzej
    //   22: dup
    //   23: invokespecial 705	com/google/android/gms/internal/measurement/zzej:<init>	()V
    //   26: astore 12
    //   28: aload_0
    //   29: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 11
    //   34: aload 11
    //   36: ldc_w 707
    //   39: bipush 6
    //   41: anewarray 19	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: ldc 69
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc 77
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: ldc 73
    //   58: aastore
    //   59: dup
    //   60: iconst_3
    //   61: ldc 81
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 105
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: ldc 109
    //   73: aastore
    //   74: ldc_w 709
    //   77: iconst_1
    //   78: anewarray 19	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: aload_3
    //   84: aastore
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore 10
    //   93: aload 10
    //   95: astore 9
    //   97: aload 10
    //   99: invokeinterface 211 1 0
    //   104: ifne +45 -> 149
    //   107: aload 10
    //   109: astore 9
    //   111: aload_0
    //   112: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   115: invokevirtual 332	com/google/android/gms/internal/measurement/zzfg:zzip	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   118: ldc_w 711
    //   121: aload_3
    //   122: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   125: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   128: aload 10
    //   130: ifnull +10 -> 140
    //   133: aload 10
    //   135: invokeinterface 218 1 0
    //   140: sipush 1183
    //   143: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 12
    //   148: areturn
    //   149: aload 10
    //   151: astore 9
    //   153: aload 10
    //   155: iconst_0
    //   156: invokeinterface 215 2 0
    //   161: lload_1
    //   162: lcmp
    //   163: ifne +88 -> 251
    //   166: aload 10
    //   168: astore 9
    //   170: aload 12
    //   172: aload 10
    //   174: iconst_1
    //   175: invokeinterface 215 2 0
    //   180: putfield 715	com/google/android/gms/internal/measurement/zzej:zzafe	J
    //   183: aload 10
    //   185: astore 9
    //   187: aload 12
    //   189: aload 10
    //   191: iconst_2
    //   192: invokeinterface 215 2 0
    //   197: putfield 718	com/google/android/gms/internal/measurement/zzej:zzafd	J
    //   200: aload 10
    //   202: astore 9
    //   204: aload 12
    //   206: aload 10
    //   208: iconst_3
    //   209: invokeinterface 215 2 0
    //   214: putfield 721	com/google/android/gms/internal/measurement/zzej:zzaff	J
    //   217: aload 10
    //   219: astore 9
    //   221: aload 12
    //   223: aload 10
    //   225: iconst_4
    //   226: invokeinterface 215 2 0
    //   231: putfield 724	com/google/android/gms/internal/measurement/zzej:zzafg	J
    //   234: aload 10
    //   236: astore 9
    //   238: aload 12
    //   240: aload 10
    //   242: iconst_5
    //   243: invokeinterface 215 2 0
    //   248: putfield 727	com/google/android/gms/internal/measurement/zzej:zzafh	J
    //   251: iload 4
    //   253: ifeq +19 -> 272
    //   256: aload 10
    //   258: astore 9
    //   260: aload 12
    //   262: aload 12
    //   264: getfield 715	com/google/android/gms/internal/measurement/zzej:zzafe	J
    //   267: lconst_1
    //   268: ladd
    //   269: putfield 715	com/google/android/gms/internal/measurement/zzej:zzafe	J
    //   272: iload 5
    //   274: ifeq +19 -> 293
    //   277: aload 10
    //   279: astore 9
    //   281: aload 12
    //   283: aload 12
    //   285: getfield 718	com/google/android/gms/internal/measurement/zzej:zzafd	J
    //   288: lconst_1
    //   289: ladd
    //   290: putfield 718	com/google/android/gms/internal/measurement/zzej:zzafd	J
    //   293: iload 6
    //   295: ifeq +19 -> 314
    //   298: aload 10
    //   300: astore 9
    //   302: aload 12
    //   304: aload 12
    //   306: getfield 721	com/google/android/gms/internal/measurement/zzej:zzaff	J
    //   309: lconst_1
    //   310: ladd
    //   311: putfield 721	com/google/android/gms/internal/measurement/zzej:zzaff	J
    //   314: iload 7
    //   316: ifeq +19 -> 335
    //   319: aload 10
    //   321: astore 9
    //   323: aload 12
    //   325: aload 12
    //   327: getfield 724	com/google/android/gms/internal/measurement/zzej:zzafg	J
    //   330: lconst_1
    //   331: ladd
    //   332: putfield 724	com/google/android/gms/internal/measurement/zzej:zzafg	J
    //   335: iload 8
    //   337: ifeq +19 -> 356
    //   340: aload 10
    //   342: astore 9
    //   344: aload 12
    //   346: aload 12
    //   348: getfield 727	com/google/android/gms/internal/measurement/zzej:zzafh	J
    //   351: lconst_1
    //   352: ladd
    //   353: putfield 727	com/google/android/gms/internal/measurement/zzej:zzafh	J
    //   356: aload 10
    //   358: astore 9
    //   360: new 300	android/content/ContentValues
    //   363: dup
    //   364: invokespecial 465	android/content/ContentValues:<init>	()V
    //   367: astore 13
    //   369: aload 10
    //   371: astore 9
    //   373: aload 13
    //   375: ldc 69
    //   377: lload_1
    //   378: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   381: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   384: aload 10
    //   386: astore 9
    //   388: aload 13
    //   390: ldc 73
    //   392: aload 12
    //   394: getfield 718	com/google/android/gms/internal/measurement/zzej:zzafd	J
    //   397: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   400: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   403: aload 10
    //   405: astore 9
    //   407: aload 13
    //   409: ldc 77
    //   411: aload 12
    //   413: getfield 715	com/google/android/gms/internal/measurement/zzej:zzafe	J
    //   416: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   419: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   422: aload 10
    //   424: astore 9
    //   426: aload 13
    //   428: ldc 81
    //   430: aload 12
    //   432: getfield 721	com/google/android/gms/internal/measurement/zzej:zzaff	J
    //   435: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   441: aload 10
    //   443: astore 9
    //   445: aload 13
    //   447: ldc 105
    //   449: aload 12
    //   451: getfield 724	com/google/android/gms/internal/measurement/zzej:zzafg	J
    //   454: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   457: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   460: aload 10
    //   462: astore 9
    //   464: aload 13
    //   466: ldc 109
    //   468: aload 12
    //   470: getfield 727	com/google/android/gms/internal/measurement/zzej:zzafh	J
    //   473: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   476: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   479: aload 10
    //   481: astore 9
    //   483: aload 11
    //   485: ldc_w 707
    //   488: aload 13
    //   490: ldc_w 709
    //   493: iconst_1
    //   494: anewarray 19	java/lang/String
    //   497: dup
    //   498: iconst_0
    //   499: aload_3
    //   500: aastore
    //   501: invokevirtual 731	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   504: pop
    //   505: aload 10
    //   507: ifnull +10 -> 517
    //   510: aload 10
    //   512: invokeinterface 218 1 0
    //   517: sipush 1183
    //   520: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: aload 12
    //   525: areturn
    //   526: astore 11
    //   528: aconst_null
    //   529: astore 10
    //   531: aload 10
    //   533: astore 9
    //   535: aload_0
    //   536: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   539: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   542: ldc_w 733
    //   545: aload_3
    //   546: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   549: aload 11
    //   551: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   554: aload 10
    //   556: ifnull +10 -> 566
    //   559: aload 10
    //   561: invokeinterface 218 1 0
    //   566: sipush 1183
    //   569: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: aload 12
    //   574: areturn
    //   575: astore_3
    //   576: aconst_null
    //   577: astore 9
    //   579: aload 9
    //   581: ifnull +10 -> 591
    //   584: aload 9
    //   586: invokeinterface 218 1 0
    //   591: sipush 1183
    //   594: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aload_3
    //   598: athrow
    //   599: astore_3
    //   600: goto -21 -> 579
    //   603: astore 11
    //   605: goto -74 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	zzei
    //   0	608	1	paramLong	long
    //   0	608	3	paramString	String
    //   0	608	4	paramBoolean1	boolean
    //   0	608	5	paramBoolean2	boolean
    //   0	608	6	paramBoolean3	boolean
    //   0	608	7	paramBoolean4	boolean
    //   0	608	8	paramBoolean5	boolean
    //   95	490	9	localCursor1	Cursor
    //   91	469	10	localCursor2	Cursor
    //   32	452	11	localSQLiteDatabase	SQLiteDatabase
    //   526	24	11	localSQLiteException1	SQLiteException
    //   603	1	11	localSQLiteException2	SQLiteException
    //   26	547	12	localzzej	zzej
    //   367	122	13	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   28	93	526	android/database/sqlite/SQLiteException
    //   28	93	575	finally
    //   97	107	599	finally
    //   111	128	599	finally
    //   153	166	599	finally
    //   170	183	599	finally
    //   187	200	599	finally
    //   204	217	599	finally
    //   221	234	599	finally
    //   238	251	599	finally
    //   260	272	599	finally
    //   281	293	599	finally
    //   302	314	599	finally
    //   323	335	599	finally
    //   344	356	599	finally
    //   360	369	599	finally
    //   373	384	599	finally
    //   388	403	599	finally
    //   407	422	599	finally
    //   426	441	599	finally
    //   445	460	599	finally
    //   464	479	599	finally
    //   483	505	599	finally
    //   535	554	599	finally
    //   97	107	603	android/database/sqlite/SQLiteException
    //   111	128	603	android/database/sqlite/SQLiteException
    //   153	166	603	android/database/sqlite/SQLiteException
    //   170	183	603	android/database/sqlite/SQLiteException
    //   187	200	603	android/database/sqlite/SQLiteException
    //   204	217	603	android/database/sqlite/SQLiteException
    //   221	234	603	android/database/sqlite/SQLiteException
    //   238	251	603	android/database/sqlite/SQLiteException
    //   260	272	603	android/database/sqlite/SQLiteException
    //   281	293	603	android/database/sqlite/SQLiteException
    //   302	314	603	android/database/sqlite/SQLiteException
    //   323	335	603	android/database/sqlite/SQLiteException
    //   344	356	603	android/database/sqlite/SQLiteException
    //   360	369	603	android/database/sqlite/SQLiteException
    //   373	384	603	android/database/sqlite/SQLiteException
    //   388	403	603	android/database/sqlite/SQLiteException
    //   407	422	603	android/database/sqlite/SQLiteException
    //   426	441	603	android/database/sqlite/SQLiteException
    //   445	460	603	android/database/sqlite/SQLiteException
    //   464	479	603	android/database/sqlite/SQLiteException
    //   483	505	603	android/database/sqlite/SQLiteException
  }
  
  public final void zza(zzdy paramzzdy)
  {
    AppMethodBeat.i(1181);
    Preconditions.checkNotNull(paramzzdy);
    zzab();
    zzch();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzdy.zzah());
    localContentValues.put("app_instance_id", paramzzdy.getAppInstanceId());
    localContentValues.put("gmp_app_id", paramzzdy.getGmpAppId());
    localContentValues.put("resettable_device_id_hash", paramzzdy.zzgi());
    localContentValues.put("last_bundle_index", Long.valueOf(paramzzdy.zzgq()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramzzdy.zzgk()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzzdy.zzgl()));
    localContentValues.put("app_version", paramzzdy.zzag());
    localContentValues.put("app_store", paramzzdy.zzgn());
    localContentValues.put("gmp_version", Long.valueOf(paramzzdy.zzgo()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramzzdy.zzgp()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramzzdy.isMeasurementEnabled()));
    localContentValues.put("day", Long.valueOf(paramzzdy.zzgu()));
    localContentValues.put("daily_public_events_count", Long.valueOf(paramzzdy.zzgv()));
    localContentValues.put("daily_events_count", Long.valueOf(paramzzdy.zzgw()));
    localContentValues.put("daily_conversions_count", Long.valueOf(paramzzdy.zzgx()));
    localContentValues.put("config_fetched_time", Long.valueOf(paramzzdy.zzgr()));
    localContentValues.put("failed_config_fetch_time", Long.valueOf(paramzzdy.zzgs()));
    localContentValues.put("app_version_int", Long.valueOf(paramzzdy.zzgm()));
    localContentValues.put("firebase_instance_id", paramzzdy.zzgj());
    localContentValues.put("daily_error_events_count", Long.valueOf(paramzzdy.zzgz()));
    localContentValues.put("daily_realtime_events_count", Long.valueOf(paramzzdy.zzgy()));
    localContentValues.put("health_monitor_sample", paramzzdy.zzha());
    localContentValues.put("android_id", Long.valueOf(paramzzdy.zzhc()));
    localContentValues.put("adid_reporting_enabled", Boolean.valueOf(paramzzdy.zzhd()));
    localContentValues.put("ssaid_reporting_enabled", Boolean.valueOf(paramzzdy.zzhe()));
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if ((localSQLiteDatabase.update("apps", localContentValues, "app_id = ?", new String[] { paramzzdy.zzah() }) == 0L) && (localSQLiteDatabase.insertWithOnConflict("apps", null, localContentValues, 5) == -1L)) {
        zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(paramzzdy.zzah()));
      }
      AppMethodBeat.o(1181);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(paramzzdy.zzah()), localSQLiteException);
      AppMethodBeat.o(1181);
    }
  }
  
  public final void zza(zzeq paramzzeq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(1169);
    Preconditions.checkNotNull(paramzzeq);
    zzab();
    zzch();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzeq.zzti);
    localContentValues.put("name", paramzzeq.name);
    localContentValues.put("lifetime_count", Long.valueOf(paramzzeq.zzafr));
    localContentValues.put("current_bundle_count", Long.valueOf(paramzzeq.zzafs));
    localContentValues.put("last_fire_timestamp", Long.valueOf(paramzzeq.zzaft));
    localContentValues.put("last_bundled_timestamp", Long.valueOf(paramzzeq.zzafu));
    localContentValues.put("last_sampled_complex_event_id", paramzzeq.zzafv);
    localContentValues.put("last_sampling_rate", paramzzeq.zzafw);
    Object localObject1 = localObject2;
    if (paramzzeq.zzafx != null)
    {
      localObject1 = localObject2;
      if (paramzzeq.zzafx.booleanValue()) {
        localObject1 = Long.valueOf(1L);
      }
    }
    localContentValues.put("last_exempt_from_sampling", (Long)localObject1);
    try
    {
      if (getWritableDatabase().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(paramzzeq.zzti));
      }
      AppMethodBeat.o(1169);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(paramzzeq.zzti), localSQLiteException);
      AppMethodBeat.o(1169);
    }
  }
  
  final void zza(String paramString, zzkd[] paramArrayOfzzkd)
  {
    int n = 0;
    AppMethodBeat.i(1191);
    zzch();
    zzab();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramArrayOfzzkd);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    Object localObject1;
    int j;
    int i2;
    for (;;)
    {
      try
      {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(paramString);
        localObject1 = getWritableDatabase();
        ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=?", new String[] { paramString });
        ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=?", new String[] { paramString });
        int i1 = paramArrayOfzzkd.length;
        j = 0;
        if (j >= i1) {
          break label492;
        }
        localObject1 = paramArrayOfzzkd[j];
        zzch();
        zzab();
        Preconditions.checkNotEmpty(paramString);
        Preconditions.checkNotNull(localObject1);
        Preconditions.checkNotNull(((zzkd)localObject1).zzarn);
        Preconditions.checkNotNull(((zzkd)localObject1).zzarm);
        if (((zzkd)localObject1).zzarl == null)
        {
          zzge().zzip().zzg("Audience with no ID. appId", zzfg.zzbm(paramString));
        }
        else
        {
          i2 = ((zzkd)localObject1).zzarl.intValue();
          localObject2 = ((zzkd)localObject1).zzarn;
          k = localObject2.length;
          i = 0;
          if (i < k) {
            if (localObject2[i].zzarp == null) {
              zzge().zzip().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(paramString), ((zzkd)localObject1).zzarl);
            }
          }
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
        AppMethodBeat.o(1191);
      }
      i += 1;
    }
    Object localObject2 = ((zzkd)localObject1).zzarm;
    int k = localObject2.length;
    int i = 0;
    label282:
    label337:
    label359:
    int m;
    int i3;
    if (i < k)
    {
      if (localObject2[i].zzarp != null) {
        break label574;
      }
      zzge().zzip().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(paramString), ((zzkd)localObject1).zzarl);
    }
    else
    {
      localObject2 = ((zzkd)localObject1).zzarn;
      k = localObject2.length;
      i = 0;
      if (i < k)
      {
        if (zza(paramString, i2, localObject2[i])) {
          break label581;
        }
        i = 0;
        m = i;
        if (i != 0)
        {
          localObject1 = ((zzkd)localObject1).zzarm;
          i3 = localObject1.length;
          k = 0;
        }
      }
    }
    for (;;)
    {
      m = i;
      if (k < i3)
      {
        if (!zza(paramString, i2, localObject1[k])) {
          m = 0;
        }
      }
      else
      {
        if (m == 0)
        {
          zzch();
          zzab();
          Preconditions.checkNotEmpty(paramString);
          localObject1 = getWritableDatabase();
          ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i2) });
          ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i2) });
          break label565;
          label492:
          localObject1 = new ArrayList();
          j = paramArrayOfzzkd.length;
          i = n;
          while (i < j)
          {
            ((List)localObject1).add(paramArrayOfzzkd[i].zzarl);
            i += 1;
          }
          zza(paramString, (List)localObject1);
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          AppMethodBeat.o(1191);
          return;
          i = 1;
          break label359;
        }
        label565:
        j += 1;
        break;
        label574:
        i += 1;
        break label282;
        label581:
        i += 1;
        break label337;
      }
      k += 1;
    }
  }
  
  public final boolean zza(zzed paramzzed)
  {
    AppMethodBeat.i(1175);
    Preconditions.checkNotNull(paramzzed);
    zzab();
    zzch();
    if (zzh(paramzzed.packageName, paramzzed.zzaep.name) == null) {
      if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { paramzzed.packageName }) >= 1000L)
      {
        AppMethodBeat.o(1175);
        return false;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzed.packageName);
    localContentValues.put("origin", paramzzed.origin);
    localContentValues.put("name", paramzzed.zzaep.name);
    zza(localContentValues, "value", paramzzed.zzaep.getValue());
    localContentValues.put("active", Boolean.valueOf(paramzzed.active));
    localContentValues.put("trigger_event_name", paramzzed.triggerEventName);
    localContentValues.put("trigger_timeout", Long.valueOf(paramzzed.triggerTimeout));
    zzgb();
    localContentValues.put("timed_out_event", zzka.zza(paramzzed.zzaeq));
    localContentValues.put("creation_timestamp", Long.valueOf(paramzzed.creationTimestamp));
    zzgb();
    localContentValues.put("triggered_event", zzka.zza(paramzzed.zzaer));
    localContentValues.put("triggered_timestamp", Long.valueOf(paramzzed.zzaep.zzaqz));
    localContentValues.put("time_to_live", Long.valueOf(paramzzed.timeToLive));
    zzgb();
    localContentValues.put("expired_event", zzka.zza(paramzzed.zzaes));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, localContentValues, 5) == -1L) {
        zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(paramzzed.packageName));
      }
      AppMethodBeat.o(1175);
      return true;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(paramzzed.packageName), localSQLiteException);
      }
    }
  }
  
  public final boolean zza(zzep paramzzep, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(1211);
    zzab();
    zzch();
    Preconditions.checkNotNull(paramzzep);
    Preconditions.checkNotEmpty(paramzzep.zzti);
    Object localObject1 = new zzkn();
    ((zzkn)localObject1).zzatc = Long.valueOf(paramzzep.zzafp);
    ((zzkn)localObject1).zzata = new zzko[paramzzep.zzafq.size()];
    Object localObject2 = paramzzep.zzafq.iterator();
    int i = 0;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (String)((Iterator)localObject2).next();
      localObject3 = new zzko();
      ((zzkn)localObject1).zzata[i] = localObject3;
      ((zzko)localObject3).name = ((String)localObject4);
      localObject4 = paramzzep.zzafq.get((String)localObject4);
      zzgb().zza((zzko)localObject3, localObject4);
      i += 1;
    }
    for (;;)
    {
      try
      {
        localObject2 = new byte[((zzace)localObject1).zzvm()];
        localObject3 = zzabw.zzb((byte[])localObject2, 0, localObject2.length);
        ((zzace)localObject1).zza((zzabw)localObject3);
        ((zzabw)localObject3).zzve();
        zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(paramzzep.name), Integer.valueOf(localObject2.length));
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("app_id", paramzzep.zzti);
        ((ContentValues)localObject1).put("name", paramzzep.name);
        ((ContentValues)localObject1).put("timestamp", Long.valueOf(paramzzep.timestamp));
        ((ContentValues)localObject1).put("metadata_fingerprint", Long.valueOf(paramLong));
        ((ContentValues)localObject1).put("data", (byte[])localObject2);
        if (paramBoolean)
        {
          i = 1;
          ((ContentValues)localObject1).put("realtime", Integer.valueOf(i));
        }
        i = 0;
      }
      catch (IOException localIOException)
      {
        try
        {
          if (getWritableDatabase().insert("raw_events", null, (ContentValues)localObject1) != -1L) {
            break;
          }
          zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(paramzzep.zzti));
          AppMethodBeat.o(1211);
          return false;
        }
        catch (SQLiteException localSQLiteException)
        {
          zzge().zzim().zze("Error storing raw event. appId", zzfg.zzbm(paramzzep.zzti), localSQLiteException);
          AppMethodBeat.o(1211);
          return false;
        }
        localIOException = localIOException;
        zzge().zzim().zze("Data loss. Failed to serialize event params/data. appId", zzfg.zzbm(paramzzep.zzti), localIOException);
        AppMethodBeat.o(1211);
        return false;
      }
    }
    AppMethodBeat.o(1211);
    return true;
  }
  
  public final boolean zza(zzjz paramzzjz)
  {
    AppMethodBeat.i(1171);
    Preconditions.checkNotNull(paramzzjz);
    zzab();
    zzch();
    if (zzh(paramzzjz.zzti, paramzzjz.name) == null) {
      if (zzka.zzcc(paramzzjz.name))
      {
        if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { paramzzjz.zzti }) >= 25L)
        {
          AppMethodBeat.o(1171);
          return false;
        }
      }
      else if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { paramzzjz.zzti, paramzzjz.origin }) >= 25L)
      {
        AppMethodBeat.o(1171);
        return false;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzjz.zzti);
    localContentValues.put("origin", paramzzjz.origin);
    localContentValues.put("name", paramzzjz.name);
    localContentValues.put("set_timestamp", Long.valueOf(paramzzjz.zzaqz));
    zza(localContentValues, "value", paramzzjz.value);
    try
    {
      if (getWritableDatabase().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
        zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(paramzzjz.zzti));
      }
      AppMethodBeat.o(1171);
      return true;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(paramzzjz.zzti), localSQLiteException);
      }
    }
  }
  
  /* Error */
  public final boolean zza(zzkq paramzzkq, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 1185
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   14: aload_1
    //   15: invokestatic 298	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
    //   19: aload_1
    //   20: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   23: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   26: pop
    //   27: aload_1
    //   28: getfield 1101	com/google/android/gms/internal/measurement/zzkq:zzatm	Ljava/lang/Long;
    //   31: invokestatic 298	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: aload_0
    //   36: invokevirtual 1104	com/google/android/gms/internal/measurement/zzei:zzhp	()V
    //   39: aload_0
    //   40: invokevirtual 170	com/google/android/gms/internal/measurement/zzhg:zzbt	()Lcom/google/android/gms/common/util/Clock;
    //   43: invokeinterface 1109 1 0
    //   48: lstore 4
    //   50: aload_1
    //   51: getfield 1101	com/google/android/gms/internal/measurement/zzkq:zzatm	Ljava/lang/Long;
    //   54: invokevirtual 1112	java/lang/Long:longValue	()J
    //   57: lload 4
    //   59: invokestatic 1115	com/google/android/gms/internal/measurement/zzef:zzhh	()J
    //   62: lsub
    //   63: lcmp
    //   64: iflt +20 -> 84
    //   67: aload_1
    //   68: getfield 1101	com/google/android/gms/internal/measurement/zzkq:zzatm	Ljava/lang/Long;
    //   71: invokevirtual 1112	java/lang/Long:longValue	()J
    //   74: invokestatic 1115	com/google/android/gms/internal/measurement/zzef:zzhh	()J
    //   77: lload 4
    //   79: ladd
    //   80: lcmp
    //   81: ifle +32 -> 113
    //   84: aload_0
    //   85: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   88: invokevirtual 332	com/google/android/gms/internal/measurement/zzfg:zzip	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   91: ldc_w 1117
    //   94: aload_1
    //   95: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   98: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: lload 4
    //   103: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: aload_1
    //   107: getfield 1101	com/google/android/gms/internal/measurement/zzkq:zzatm	Ljava/lang/Long;
    //   110: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   113: aload_1
    //   114: invokevirtual 452	com/google/android/gms/internal/measurement/zzace:zzvm	()I
    //   117: newarray byte
    //   119: astore 6
    //   121: aload 6
    //   123: iconst_0
    //   124: aload 6
    //   126: arraylength
    //   127: invokestatic 457	com/google/android/gms/internal/measurement/zzabw:zzb	([BII)Lcom/google/android/gms/internal/measurement/zzabw;
    //   130: astore 7
    //   132: aload_1
    //   133: aload 7
    //   135: invokevirtual 460	com/google/android/gms/internal/measurement/zzace:zza	(Lcom/google/android/gms/internal/measurement/zzabw;)V
    //   138: aload 7
    //   140: invokevirtual 463	com/google/android/gms/internal/measurement/zzabw:zzve	()V
    //   143: aload_0
    //   144: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   147: aload 6
    //   149: invokevirtual 1119	com/google/android/gms/internal/measurement/zzka:zza	([B)[B
    //   152: astore 6
    //   154: aload_0
    //   155: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   158: invokevirtual 673	com/google/android/gms/internal/measurement/zzfg:zzit	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   161: ldc_w 1121
    //   164: aload 6
    //   166: arraylength
    //   167: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   173: new 300	android/content/ContentValues
    //   176: dup
    //   177: invokespecial 465	android/content/ContentValues:<init>	()V
    //   180: astore 7
    //   182: aload 7
    //   184: ldc_w 467
    //   187: aload_1
    //   188: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   191: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 7
    //   196: ldc_w 1123
    //   199: aload_1
    //   200: getfield 1101	com/google/android/gms/internal/measurement/zzkq:zzatm	Ljava/lang/Long;
    //   203: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   206: aload 7
    //   208: ldc_w 478
    //   211: aload 6
    //   213: invokevirtual 481	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   216: iload_2
    //   217: ifeq +114 -> 331
    //   220: iconst_1
    //   221: istore_3
    //   222: aload 7
    //   224: ldc 137
    //   226: iload_3
    //   227: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   233: aload_1
    //   234: getfield 1126	com/google/android/gms/internal/measurement/zzkq:zzauj	Ljava/lang/Integer;
    //   237: ifnull +14 -> 251
    //   240: aload 7
    //   242: ldc 141
    //   244: aload_1
    //   245: getfield 1126	com/google/android/gms/internal/measurement/zzkq:zzauj	Ljava/lang/Integer;
    //   248: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   251: aload_0
    //   252: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   255: ldc_w 1128
    //   258: aconst_null
    //   259: aload 7
    //   261: invokevirtual 1063	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   264: ldc2_w 488
    //   267: lcmp
    //   268: ifne +100 -> 368
    //   271: aload_0
    //   272: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   275: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   278: ldc_w 1130
    //   281: aload_1
    //   282: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   285: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   288: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   291: sipush 1185
    //   294: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: iconst_0
    //   298: ireturn
    //   299: astore 6
    //   301: aload_0
    //   302: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   305: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   308: ldc_w 1132
    //   311: aload_1
    //   312: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   315: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   318: aload 6
    //   320: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   323: sipush 1185
    //   326: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: iconst_0
    //   330: ireturn
    //   331: iconst_0
    //   332: istore_3
    //   333: goto -111 -> 222
    //   336: astore 6
    //   338: aload_0
    //   339: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   342: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   345: ldc_w 1134
    //   348: aload_1
    //   349: getfield 633	com/google/android/gms/internal/measurement/zzkq:zzti	Ljava/lang/String;
    //   352: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   355: aload 6
    //   357: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   360: sipush 1185
    //   363: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: iconst_0
    //   367: ireturn
    //   368: sipush 1185
    //   371: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iconst_1
    //   375: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	zzei
    //   0	376	1	paramzzkq	zzkq
    //   0	376	2	paramBoolean	boolean
    //   221	112	3	i	int
    //   48	54	4	l	long
    //   119	93	6	arrayOfByte	byte[]
    //   299	20	6	localIOException	IOException
    //   336	20	6	localSQLiteException	SQLiteException
    //   130	130	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   113	154	299	java/io/IOException
    //   251	291	336	android/database/sqlite/SQLiteException
  }
  
  public final boolean zza(String paramString, Long paramLong, long paramLong1, zzkn paramzzkn)
  {
    AppMethodBeat.i(1210);
    zzab();
    zzch();
    Preconditions.checkNotNull(paramzzkn);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramLong);
    try
    {
      byte[] arrayOfByte = new byte[paramzzkn.zzvm()];
      zzabw localzzabw = zzabw.zzb(arrayOfByte, 0, arrayOfByte.length);
      paramzzkn.zza(localzzabw);
      localzzabw.zzve();
      zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(paramString), Integer.valueOf(arrayOfByte.length));
      paramzzkn = new ContentValues();
      paramzzkn.put("app_id", paramString);
      paramzzkn.put("event_id", paramLong);
      paramzzkn.put("children_to_process", Long.valueOf(paramLong1));
      paramzzkn.put("main_event", arrayOfByte);
      AppMethodBeat.o(1210);
    }
    catch (IOException paramzzkn)
    {
      try
      {
        if (getWritableDatabase().insertWithOnConflict("main_event_params", null, paramzzkn, 5) != -1L) {
          break label241;
        }
        zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(paramString));
        AppMethodBeat.o(1210);
        return false;
      }
      catch (SQLiteException paramLong)
      {
        zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(paramString), paramLong);
        AppMethodBeat.o(1210);
        return false;
      }
      paramzzkn = paramzzkn;
      zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(paramString), paramLong, paramzzkn);
      AppMethodBeat.o(1210);
      return false;
    }
    label241:
    return true;
  }
  
  /* Error */
  public final String zzab(long paramLong)
  {
    // Byte code:
    //   0: sipush 1207
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   14: aload_0
    //   15: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: ldc_w 1154
    //   21: iconst_1
    //   22: anewarray 19	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: lload_1
    //   28: invokestatic 1156	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   31: aastore
    //   32: invokevirtual 205	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 211 1 0
    //   47: ifne +39 -> 86
    //   50: aload 4
    //   52: astore_3
    //   53: aload_0
    //   54: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   57: invokevirtual 673	com/google/android/gms/internal/measurement/zzfg:zzit	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   60: ldc_w 1158
    //   63: invokevirtual 266	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: ifnull +10 -> 78
    //   71: aload 4
    //   73: invokeinterface 218 1 0
    //   78: sipush 1207
    //   81: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: iconst_0
    //   92: invokeinterface 284 2 0
    //   97: astore 5
    //   99: aload 4
    //   101: ifnull +10 -> 111
    //   104: aload 4
    //   106: invokeinterface 218 1 0
    //   111: sipush 1207
    //   114: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 5
    //   119: areturn
    //   120: astore 5
    //   122: aconst_null
    //   123: astore 4
    //   125: aload 4
    //   127: astore_3
    //   128: aload_0
    //   129: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   132: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   135: ldc_w 1160
    //   138: aload 5
    //   140: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   143: aload 4
    //   145: ifnull +10 -> 155
    //   148: aload 4
    //   150: invokeinterface 218 1 0
    //   155: sipush 1207
    //   158: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aconst_null
    //   162: areturn
    //   163: astore 4
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_3
    //   168: ifnull +9 -> 177
    //   171: aload_3
    //   172: invokeinterface 218 1 0
    //   177: sipush 1207
    //   180: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload 4
    //   185: athrow
    //   186: astore 4
    //   188: goto -21 -> 167
    //   191: astore 5
    //   193: goto -68 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	zzei
    //   0	196	1	paramLong	long
    //   39	133	3	localCursor1	Cursor
    //   35	114	4	localCursor2	Cursor
    //   163	21	4	localObject1	Object
    //   186	1	4	localObject2	Object
    //   97	21	5	str	String
    //   120	19	5	localSQLiteException1	SQLiteException
    //   191	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   14	37	120	android/database/sqlite/SQLiteException
    //   14	37	163	finally
    //   40	50	186	finally
    //   53	66	186	finally
    //   89	99	186	finally
    //   128	143	186	finally
    //   40	50	191	android/database/sqlite/SQLiteException
    //   53	66	191	android/database/sqlite/SQLiteException
    //   89	99	191	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final List<android.util.Pair<zzkq, Long>> zzb(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: sipush 1188
    //   6: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   13: aload_0
    //   14: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   17: iload_2
    //   18: ifle +118 -> 136
    //   21: iconst_1
    //   22: istore 4
    //   24: iload 4
    //   26: invokestatic 1165	com/google/android/gms/common/internal/Preconditions:checkArgument	(Z)V
    //   29: iload_3
    //   30: ifle +112 -> 142
    //   33: iload 5
    //   35: istore 4
    //   37: iload 4
    //   39: invokestatic 1165	com/google/android/gms/common/internal/Preconditions:checkArgument	(Z)V
    //   42: aload_1
    //   43: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   46: pop
    //   47: aload_0
    //   48: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   51: ldc_w 1128
    //   54: iconst_3
    //   55: anewarray 19	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 1167
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc_w 478
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 141
    //   74: aastore
    //   75: ldc_w 709
    //   78: iconst_1
    //   79: anewarray 19	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: ldc_w 1167
    //   91: iload_2
    //   92: invokestatic 911	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   95: invokevirtual 1170	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore 8
    //   100: aload 8
    //   102: invokeinterface 211 1 0
    //   107: ifne +41 -> 148
    //   110: invokestatic 1174	java/util/Collections:emptyList	()Ljava/util/List;
    //   113: astore 9
    //   115: aload 8
    //   117: ifnull +10 -> 127
    //   120: aload 8
    //   122: invokeinterface 218 1 0
    //   127: sipush 1188
    //   130: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload 9
    //   135: areturn
    //   136: iconst_0
    //   137: istore 4
    //   139: goto -115 -> 24
    //   142: iconst_0
    //   143: istore 4
    //   145: goto -108 -> 37
    //   148: new 547	java/util/ArrayList
    //   151: dup
    //   152: invokespecial 548	java/util/ArrayList:<init>	()V
    //   155: astore 9
    //   157: iconst_0
    //   158: istore_2
    //   159: aload 8
    //   161: iconst_0
    //   162: invokeinterface 215 2 0
    //   167: lstore 6
    //   169: aload 8
    //   171: iconst_1
    //   172: invokeinterface 679 2 0
    //   177: astore 10
    //   179: aload_0
    //   180: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   183: aload 10
    //   185: invokevirtual 1176	com/google/android/gms/internal/measurement/zzka:zzb	([B)[B
    //   188: astore 10
    //   190: aload 9
    //   192: invokeinterface 1177 1 0
    //   197: ifne +12 -> 209
    //   200: aload 10
    //   202: arraylength
    //   203: iload_2
    //   204: iadd
    //   205: iload_3
    //   206: if_icmpgt +101 -> 307
    //   209: aload 10
    //   211: iconst_0
    //   212: aload 10
    //   214: arraylength
    //   215: invokestatic 684	com/google/android/gms/internal/measurement/zzabv:zza	([BII)Lcom/google/android/gms/internal/measurement/zzabv;
    //   218: astore 11
    //   220: new 630	com/google/android/gms/internal/measurement/zzkq
    //   223: dup
    //   224: invokespecial 1178	com/google/android/gms/internal/measurement/zzkq:<init>	()V
    //   227: astore 12
    //   229: aload 12
    //   231: aload 11
    //   233: invokevirtual 690	com/google/android/gms/internal/measurement/zzace:zzb	(Lcom/google/android/gms/internal/measurement/zzabv;)Lcom/google/android/gms/internal/measurement/zzace;
    //   236: pop
    //   237: aload 8
    //   239: iconst_2
    //   240: invokeinterface 1182 2 0
    //   245: ifne +19 -> 264
    //   248: aload 12
    //   250: aload 8
    //   252: iconst_2
    //   253: invokeinterface 1185 2 0
    //   258: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: putfield 1126	com/google/android/gms/internal/measurement/zzkq:zzauj	Ljava/lang/Integer;
    //   264: aload 10
    //   266: arraylength
    //   267: iload_2
    //   268: iadd
    //   269: istore_2
    //   270: aload 9
    //   272: aload 12
    //   274: lload 6
    //   276: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   279: invokestatic 696	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   282: invokeinterface 565 2 0
    //   287: pop
    //   288: aload 8
    //   290: invokeinterface 1188 1 0
    //   295: istore 4
    //   297: iload 4
    //   299: ifeq +8 -> 307
    //   302: iload_2
    //   303: iload_3
    //   304: if_icmple +157 -> 461
    //   307: aload 8
    //   309: ifnull +10 -> 319
    //   312: aload 8
    //   314: invokeinterface 218 1 0
    //   319: sipush 1188
    //   322: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload 9
    //   327: areturn
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   334: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   337: ldc_w 1190
    //   340: aload_1
    //   341: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   344: aload 10
    //   346: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   349: goto -61 -> 288
    //   352: astore 10
    //   354: aload_0
    //   355: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   358: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   361: ldc_w 1192
    //   364: aload_1
    //   365: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   368: aload 10
    //   370: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   373: goto -85 -> 288
    //   376: astore 9
    //   378: aconst_null
    //   379: astore 8
    //   381: aload_0
    //   382: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   385: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   388: ldc_w 1194
    //   391: aload_1
    //   392: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   395: aload 9
    //   397: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   400: invokestatic 1174	java/util/Collections:emptyList	()Ljava/util/List;
    //   403: astore_1
    //   404: aload 8
    //   406: ifnull +10 -> 416
    //   409: aload 8
    //   411: invokeinterface 218 1 0
    //   416: sipush 1188
    //   419: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   422: aload_1
    //   423: areturn
    //   424: astore_1
    //   425: aconst_null
    //   426: astore 8
    //   428: aload 8
    //   430: ifnull +10 -> 440
    //   433: aload 8
    //   435: invokeinterface 218 1 0
    //   440: sipush 1188
    //   443: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: aload_1
    //   447: athrow
    //   448: astore_1
    //   449: goto -21 -> 428
    //   452: astore_1
    //   453: goto -25 -> 428
    //   456: astore 9
    //   458: goto -77 -> 381
    //   461: goto -302 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	zzei
    //   0	464	1	paramString	String
    //   0	464	2	paramInt1	int
    //   0	464	3	paramInt2	int
    //   22	276	4	bool1	boolean
    //   1	33	5	bool2	boolean
    //   167	108	6	l	long
    //   98	336	8	localCursor	Cursor
    //   113	213	9	localObject	Object
    //   376	20	9	localSQLiteException1	SQLiteException
    //   456	1	9	localSQLiteException2	SQLiteException
    //   177	88	10	arrayOfByte	byte[]
    //   328	17	10	localIOException1	IOException
    //   352	17	10	localIOException2	IOException
    //   218	14	11	localzzabv	zzabv
    //   227	46	12	localzzkq	zzkq
    // Exception table:
    //   from	to	target	type
    //   169	190	328	java/io/IOException
    //   229	237	352	java/io/IOException
    //   47	100	376	android/database/sqlite/SQLiteException
    //   47	100	424	finally
    //   100	115	448	finally
    //   148	157	448	finally
    //   159	169	448	finally
    //   169	190	448	finally
    //   190	209	448	finally
    //   209	229	448	finally
    //   229	237	448	finally
    //   237	264	448	finally
    //   264	288	448	finally
    //   288	297	448	finally
    //   330	349	448	finally
    //   354	373	448	finally
    //   381	404	452	finally
    //   100	115	456	android/database/sqlite/SQLiteException
    //   148	157	456	android/database/sqlite/SQLiteException
    //   159	169	456	android/database/sqlite/SQLiteException
    //   169	190	456	android/database/sqlite/SQLiteException
    //   190	209	456	android/database/sqlite/SQLiteException
    //   209	229	456	android/database/sqlite/SQLiteException
    //   229	237	456	android/database/sqlite/SQLiteException
    //   237	264	456	android/database/sqlite/SQLiteException
    //   264	288	456	android/database/sqlite/SQLiteException
    //   288	297	456	android/database/sqlite/SQLiteException
    //   330	349	456	android/database/sqlite/SQLiteException
    //   354	373	456	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final List<zzjz> zzb(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: sipush 1174
    //   6: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   18: aload_0
    //   19: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   22: new 547	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 548	java/util/ArrayList:<init>	()V
    //   29: astore 9
    //   31: new 547	java/util/ArrayList
    //   34: dup
    //   35: iconst_3
    //   36: invokespecial 1197	java/util/ArrayList:<init>	(I)V
    //   39: astore 10
    //   41: aload 10
    //   43: aload_1
    //   44: invokeinterface 565 2 0
    //   49: pop
    //   50: new 370	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 709
    //   57: invokespecial 1198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: astore 7
    //   62: aload_2
    //   63: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +21 -> 87
    //   69: aload 10
    //   71: aload_2
    //   72: invokeinterface 565 2 0
    //   77: pop
    //   78: aload 7
    //   80: ldc_w 1200
    //   83: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +30 -> 121
    //   94: aload 10
    //   96: aload_3
    //   97: invokestatic 373	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   100: ldc_w 1202
    //   103: invokevirtual 1205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokeinterface 565 2 0
    //   111: pop
    //   112: aload 7
    //   114: ldc_w 1207
    //   117: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 10
    //   123: aload 10
    //   125: invokeinterface 553 1 0
    //   130: anewarray 19	java/lang/String
    //   133: invokeinterface 1211 2 0
    //   138: checkcast 1212	[Ljava/lang/String;
    //   141: astore 10
    //   143: aload_0
    //   144: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   147: astore 11
    //   149: aload 7
    //   151: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 7
    //   156: aload 11
    //   158: ldc_w 1093
    //   161: iconst_4
    //   162: anewarray 19	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: ldc_w 407
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: ldc_w 1087
    //   176: aastore
    //   177: dup
    //   178: iconst_2
    //   179: ldc_w 938
    //   182: aastore
    //   183: dup
    //   184: iconst_3
    //   185: ldc 39
    //   187: aastore
    //   188: aload 7
    //   190: aload 10
    //   192: aconst_null
    //   193: aconst_null
    //   194: ldc_w 1167
    //   197: ldc_w 1214
    //   200: invokevirtual 1170	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   203: astore 7
    //   205: aload_2
    //   206: astore 8
    //   208: aload 7
    //   210: invokeinterface 211 1 0
    //   215: istore 4
    //   217: iload 4
    //   219: ifne +24 -> 243
    //   222: aload 7
    //   224: ifnull +10 -> 234
    //   227: aload 7
    //   229: invokeinterface 218 1 0
    //   234: sipush 1174
    //   237: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload 9
    //   242: areturn
    //   243: aload_2
    //   244: astore 8
    //   246: aload 9
    //   248: invokeinterface 553 1 0
    //   253: sipush 1000
    //   256: if_icmplt +46 -> 302
    //   259: aload_2
    //   260: astore 8
    //   262: aload_0
    //   263: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   266: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   269: ldc_w 1216
    //   272: sipush 1000
    //   275: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   281: aload 7
    //   283: ifnull +10 -> 293
    //   286: aload 7
    //   288: invokeinterface 218 1 0
    //   293: sipush 1174
    //   296: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload 9
    //   301: areturn
    //   302: aload_2
    //   303: astore 8
    //   305: aload 7
    //   307: iconst_0
    //   308: invokeinterface 284 2 0
    //   313: astore 10
    //   315: aload_2
    //   316: astore 8
    //   318: aload 7
    //   320: iconst_1
    //   321: invokeinterface 215 2 0
    //   326: lstore 5
    //   328: aload_2
    //   329: astore 8
    //   331: aload_0
    //   332: aload 7
    //   334: iconst_2
    //   335: invokespecial 1218	com/google/android/gms/internal/measurement/zzei:zza	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   338: astore 11
    //   340: aload_2
    //   341: astore 8
    //   343: aload 7
    //   345: iconst_3
    //   346: invokeinterface 284 2 0
    //   351: astore_2
    //   352: aload 11
    //   354: ifnonnull +35 -> 389
    //   357: aload_0
    //   358: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   361: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   364: ldc_w 1220
    //   367: aload_1
    //   368: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   371: aload_2
    //   372: aload_3
    //   373: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   376: aload 7
    //   378: invokeinterface 1188 1 0
    //   383: ifne -140 -> 243
    //   386: goto -105 -> 281
    //   389: aload 9
    //   391: new 1072	com/google/android/gms/internal/measurement/zzjz
    //   394: dup
    //   395: aload_1
    //   396: aload_2
    //   397: aload 10
    //   399: lload 5
    //   401: aload 11
    //   403: invokespecial 1223	com/google/android/gms/internal/measurement/zzjz:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   406: invokeinterface 565 2 0
    //   411: pop
    //   412: goto -36 -> 376
    //   415: astore 8
    //   417: aload 7
    //   419: astore_3
    //   420: aload 8
    //   422: astore 7
    //   424: aload_0
    //   425: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   428: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   431: ldc_w 1225
    //   434: aload_1
    //   435: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   438: aload_2
    //   439: aload 7
    //   441: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   444: aload_3
    //   445: ifnull +9 -> 454
    //   448: aload_3
    //   449: invokeinterface 218 1 0
    //   454: sipush 1174
    //   457: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: aconst_null
    //   461: areturn
    //   462: astore_1
    //   463: aload 8
    //   465: astore_2
    //   466: aload_2
    //   467: ifnull +9 -> 476
    //   470: aload_2
    //   471: invokeinterface 218 1 0
    //   476: sipush 1174
    //   479: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   482: aload_1
    //   483: athrow
    //   484: astore_1
    //   485: aload 7
    //   487: astore_2
    //   488: goto -22 -> 466
    //   491: astore_1
    //   492: aload_3
    //   493: astore_2
    //   494: goto -28 -> 466
    //   497: astore 7
    //   499: aconst_null
    //   500: astore_3
    //   501: goto -77 -> 424
    //   504: astore_2
    //   505: aload 7
    //   507: astore_3
    //   508: aload_2
    //   509: astore 7
    //   511: aload 8
    //   513: astore_2
    //   514: goto -90 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	zzei
    //   0	517	1	paramString1	String
    //   0	517	2	paramString2	String
    //   0	517	3	paramString3	String
    //   215	3	4	bool	boolean
    //   326	74	5	l	long
    //   60	426	7	localObject1	Object
    //   497	9	7	localSQLiteException1	SQLiteException
    //   509	1	7	str1	String
    //   1	341	8	str2	String
    //   415	97	8	localSQLiteException2	SQLiteException
    //   29	361	9	localArrayList	ArrayList
    //   39	359	10	localObject2	Object
    //   147	255	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   357	376	415	android/database/sqlite/SQLiteException
    //   376	386	415	android/database/sqlite/SQLiteException
    //   389	412	415	android/database/sqlite/SQLiteException
    //   31	87	462	finally
    //   87	121	462	finally
    //   121	205	462	finally
    //   208	217	484	finally
    //   246	259	484	finally
    //   262	281	484	finally
    //   305	315	484	finally
    //   318	328	484	finally
    //   331	340	484	finally
    //   343	352	484	finally
    //   357	376	484	finally
    //   376	386	484	finally
    //   389	412	484	finally
    //   424	444	491	finally
    //   31	87	497	android/database/sqlite/SQLiteException
    //   87	121	497	android/database/sqlite/SQLiteException
    //   121	205	497	android/database/sqlite/SQLiteException
    //   208	217	504	android/database/sqlite/SQLiteException
    //   246	259	504	android/database/sqlite/SQLiteException
    //   262	281	504	android/database/sqlite/SQLiteException
    //   305	315	504	android/database/sqlite/SQLiteException
    //   318	328	504	android/database/sqlite/SQLiteException
    //   331	340	504	android/database/sqlite/SQLiteException
    //   343	352	504	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final List<zzed> zzb(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: sipush 1179
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   14: new 547	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 548	java/util/ArrayList:<init>	()V
    //   21: astore 12
    //   23: aload_0
    //   24: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: ldc_w 995
    //   30: bipush 13
    //   32: anewarray 19	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 467
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc 39
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: ldc_w 407
    //   51: aastore
    //   52: dup
    //   53: iconst_3
    //   54: ldc_w 938
    //   57: aastore
    //   58: dup
    //   59: iconst_4
    //   60: ldc_w 946
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: ldc_w 951
    //   69: aastore
    //   70: dup
    //   71: bipush 6
    //   73: ldc_w 956
    //   76: aastore
    //   77: dup
    //   78: bipush 7
    //   80: ldc_w 961
    //   83: aastore
    //   84: dup
    //   85: bipush 8
    //   87: ldc_w 970
    //   90: aastore
    //   91: dup
    //   92: bipush 9
    //   94: ldc_w 975
    //   97: aastore
    //   98: dup
    //   99: bipush 10
    //   101: ldc_w 980
    //   104: aastore
    //   105: dup
    //   106: bipush 11
    //   108: ldc_w 985
    //   111: aastore
    //   112: dup
    //   113: bipush 12
    //   115: ldc_w 990
    //   118: aastore
    //   119: aload_1
    //   120: aload_2
    //   121: aconst_null
    //   122: aconst_null
    //   123: ldc_w 1167
    //   126: ldc_w 1214
    //   129: invokevirtual 1170	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore_1
    //   133: aload_1
    //   134: invokeinterface 211 1 0
    //   139: istore_3
    //   140: iload_3
    //   141: ifne +22 -> 163
    //   144: aload_1
    //   145: ifnull +9 -> 154
    //   148: aload_1
    //   149: invokeinterface 218 1 0
    //   154: sipush 1179
    //   157: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload 12
    //   162: areturn
    //   163: aload 12
    //   165: invokeinterface 553 1 0
    //   170: sipush 1000
    //   173: if_icmplt +41 -> 214
    //   176: aload_0
    //   177: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   180: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   183: ldc_w 1229
    //   186: sipush 1000
    //   189: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   195: aload_1
    //   196: ifnull +9 -> 205
    //   199: aload_1
    //   200: invokeinterface 218 1 0
    //   205: sipush 1179
    //   208: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload 12
    //   213: areturn
    //   214: aload_1
    //   215: iconst_0
    //   216: invokeinterface 284 2 0
    //   221: astore_2
    //   222: aload_1
    //   223: iconst_1
    //   224: invokeinterface 284 2 0
    //   229: astore 13
    //   231: aload_1
    //   232: iconst_2
    //   233: invokeinterface 284 2 0
    //   238: astore 14
    //   240: aload_0
    //   241: aload_1
    //   242: iconst_3
    //   243: invokespecial 1218	com/google/android/gms/internal/measurement/zzei:zza	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   246: astore 15
    //   248: aload_1
    //   249: iconst_4
    //   250: invokeinterface 1185 2 0
    //   255: ifeq +185 -> 440
    //   258: iconst_1
    //   259: istore_3
    //   260: aload_1
    //   261: iconst_5
    //   262: invokeinterface 284 2 0
    //   267: astore 16
    //   269: aload_1
    //   270: bipush 6
    //   272: invokeinterface 215 2 0
    //   277: lstore 4
    //   279: aload_0
    //   280: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   283: aload_1
    //   284: bipush 7
    //   286: invokeinterface 679 2 0
    //   291: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   294: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   297: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   300: astore 17
    //   302: aload_1
    //   303: bipush 8
    //   305: invokeinterface 215 2 0
    //   310: lstore 6
    //   312: aload_0
    //   313: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   316: aload_1
    //   317: bipush 9
    //   319: invokeinterface 679 2 0
    //   324: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   327: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   330: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   333: astore 18
    //   335: aload_1
    //   336: bipush 10
    //   338: invokeinterface 215 2 0
    //   343: lstore 8
    //   345: aload_1
    //   346: bipush 11
    //   348: invokeinterface 215 2 0
    //   353: lstore 10
    //   355: aload_0
    //   356: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   359: aload_1
    //   360: bipush 12
    //   362: invokeinterface 679 2 0
    //   367: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   370: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   373: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   376: astore 19
    //   378: aload 12
    //   380: new 916	com/google/android/gms/internal/measurement/zzed
    //   383: dup
    //   384: aload_2
    //   385: aload 13
    //   387: new 925	com/google/android/gms/internal/measurement/zzjx
    //   390: dup
    //   391: aload 14
    //   393: lload 8
    //   395: aload 15
    //   397: aload 13
    //   399: invokespecial 1241	com/google/android/gms/internal/measurement/zzjx:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   402: lload 6
    //   404: iload_3
    //   405: aload 16
    //   407: aload 17
    //   409: lload 4
    //   411: aload 18
    //   413: lload 10
    //   415: aload 19
    //   417: invokespecial 1244	com/google/android/gms/internal/measurement/zzed:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzjx;JZLjava/lang/String;Lcom/google/android/gms/internal/measurement/zzeu;JLcom/google/android/gms/internal/measurement/zzeu;JLcom/google/android/gms/internal/measurement/zzeu;)V
    //   420: invokeinterface 565 2 0
    //   425: pop
    //   426: aload_1
    //   427: invokeinterface 1188 1 0
    //   432: istore_3
    //   433: iload_3
    //   434: ifne -271 -> 163
    //   437: goto -242 -> 195
    //   440: iconst_0
    //   441: istore_3
    //   442: goto -182 -> 260
    //   445: astore_2
    //   446: aconst_null
    //   447: astore_1
    //   448: aload_0
    //   449: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   452: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   455: ldc_w 1246
    //   458: aload_2
    //   459: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   462: invokestatic 1174	java/util/Collections:emptyList	()Ljava/util/List;
    //   465: astore_2
    //   466: aload_1
    //   467: ifnull +9 -> 476
    //   470: aload_1
    //   471: invokeinterface 218 1 0
    //   476: sipush 1179
    //   479: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   482: aload_2
    //   483: areturn
    //   484: astore_2
    //   485: aconst_null
    //   486: astore_1
    //   487: aload_1
    //   488: ifnull +9 -> 497
    //   491: aload_1
    //   492: invokeinterface 218 1 0
    //   497: sipush 1179
    //   500: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: aload_2
    //   504: athrow
    //   505: astore_2
    //   506: goto -19 -> 487
    //   509: astore_2
    //   510: goto -23 -> 487
    //   513: astore_2
    //   514: goto -66 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	zzei
    //   0	517	1	paramString	String
    //   0	517	2	paramArrayOfString	String[]
    //   139	303	3	bool	boolean
    //   277	133	4	l1	long
    //   310	93	6	l2	long
    //   343	51	8	l3	long
    //   353	61	10	l4	long
    //   21	358	12	localArrayList	ArrayList
    //   229	169	13	str1	String
    //   238	154	14	str2	String
    //   246	150	15	localObject	Object
    //   267	139	16	str3	String
    //   300	108	17	localzzeu1	zzeu
    //   333	79	18	localzzeu2	zzeu
    //   376	40	19	localzzeu3	zzeu
    // Exception table:
    //   from	to	target	type
    //   23	133	445	android/database/sqlite/SQLiteException
    //   23	133	484	finally
    //   133	140	505	finally
    //   163	195	505	finally
    //   214	258	505	finally
    //   260	433	505	finally
    //   448	466	509	finally
    //   133	140	513	android/database/sqlite/SQLiteException
    //   163	195	513	android/database/sqlite/SQLiteException
    //   214	258	513	android/database/sqlite/SQLiteException
    //   260	433	513	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final List<zzjz> zzbb(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 1173
    //   6: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   18: aload_0
    //   19: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   22: new 547	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 548	java/util/ArrayList:<init>	()V
    //   29: astore 8
    //   31: aload_0
    //   32: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: ldc_w 1093
    //   38: iconst_4
    //   39: anewarray 19	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 407
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc 39
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: ldc_w 1087
    //   58: aastore
    //   59: dup
    //   60: iconst_3
    //   61: ldc_w 938
    //   64: aastore
    //   65: ldc_w 709
    //   68: iconst_1
    //   69: anewarray 19	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: ldc_w 1167
    //   81: ldc_w 1251
    //   84: invokevirtual 1170	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 5
    //   89: aload 5
    //   91: invokeinterface 211 1 0
    //   96: istore_2
    //   97: iload_2
    //   98: ifne +24 -> 122
    //   101: aload 5
    //   103: ifnull +10 -> 113
    //   106: aload 5
    //   108: invokeinterface 218 1 0
    //   113: sipush 1173
    //   116: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload 8
    //   121: areturn
    //   122: aload 5
    //   124: iconst_0
    //   125: invokeinterface 284 2 0
    //   130: astore 9
    //   132: aload 5
    //   134: iconst_1
    //   135: invokeinterface 284 2 0
    //   140: astore 7
    //   142: aload 7
    //   144: astore 6
    //   146: aload 7
    //   148: ifnonnull +8 -> 156
    //   151: ldc_w 1253
    //   154: astore 6
    //   156: aload 5
    //   158: iconst_2
    //   159: invokeinterface 215 2 0
    //   164: lstore_3
    //   165: aload_0
    //   166: aload 5
    //   168: iconst_3
    //   169: invokespecial 1218	com/google/android/gms/internal/measurement/zzei:zza	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   172: astore 7
    //   174: aload 7
    //   176: ifnonnull +53 -> 229
    //   179: aload_0
    //   180: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   183: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   186: ldc_w 1255
    //   189: aload_1
    //   190: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   193: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   196: aload 5
    //   198: invokeinterface 1188 1 0
    //   203: istore_2
    //   204: iload_2
    //   205: ifne -83 -> 122
    //   208: aload 5
    //   210: ifnull +10 -> 220
    //   213: aload 5
    //   215: invokeinterface 218 1 0
    //   220: sipush 1173
    //   223: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 8
    //   228: areturn
    //   229: aload 8
    //   231: new 1072	com/google/android/gms/internal/measurement/zzjz
    //   234: dup
    //   235: aload_1
    //   236: aload 6
    //   238: aload 9
    //   240: lload_3
    //   241: aload 7
    //   243: invokespecial 1223	com/google/android/gms/internal/measurement/zzjz:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   246: invokeinterface 565 2 0
    //   251: pop
    //   252: goto -56 -> 196
    //   255: astore 6
    //   257: aload_0
    //   258: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   261: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   264: ldc_w 1257
    //   267: aload_1
    //   268: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   271: aload 6
    //   273: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   276: aload 5
    //   278: ifnull +10 -> 288
    //   281: aload 5
    //   283: invokeinterface 218 1 0
    //   288: sipush 1173
    //   291: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_1
    //   297: aload 6
    //   299: astore 5
    //   301: aload 5
    //   303: ifnull +10 -> 313
    //   306: aload 5
    //   308: invokeinterface 218 1 0
    //   313: sipush 1173
    //   316: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aload_1
    //   320: athrow
    //   321: astore_1
    //   322: goto -21 -> 301
    //   325: astore_1
    //   326: goto -25 -> 301
    //   329: astore 6
    //   331: aconst_null
    //   332: astore 5
    //   334: goto -77 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	zzei
    //   0	337	1	paramString	String
    //   96	109	2	bool	boolean
    //   164	77	3	l	long
    //   87	246	5	localObject1	Object
    //   1	236	6	localObject2	Object
    //   255	43	6	localSQLiteException1	SQLiteException
    //   329	1	6	localSQLiteException2	SQLiteException
    //   140	102	7	localObject3	Object
    //   29	201	8	localArrayList	ArrayList
    //   130	109	9	str	String
    // Exception table:
    //   from	to	target	type
    //   89	97	255	android/database/sqlite/SQLiteException
    //   122	142	255	android/database/sqlite/SQLiteException
    //   156	174	255	android/database/sqlite/SQLiteException
    //   179	196	255	android/database/sqlite/SQLiteException
    //   196	204	255	android/database/sqlite/SQLiteException
    //   229	252	255	android/database/sqlite/SQLiteException
    //   31	89	296	finally
    //   89	97	321	finally
    //   122	142	321	finally
    //   156	174	321	finally
    //   179	196	321	finally
    //   196	204	321	finally
    //   229	252	321	finally
    //   257	276	325	finally
    //   31	89	329	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final zzdy zzbc(String paramString)
  {
    // Byte code:
    //   0: sipush 1180
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   15: aload_0
    //   16: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   19: aload_0
    //   20: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: ldc_w 707
    //   26: bipush 25
    //   28: anewarray 19	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 741
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc_w 746
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc_w 751
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc_w 756
    //   54: aastore
    //   55: dup
    //   56: iconst_4
    //   57: ldc 65
    //   59: aastore
    //   60: dup
    //   61: iconst_5
    //   62: ldc_w 765
    //   65: aastore
    //   66: dup
    //   67: bipush 6
    //   69: ldc 45
    //   71: aastore
    //   72: dup
    //   73: bipush 7
    //   75: ldc 49
    //   77: aastore
    //   78: dup
    //   79: bipush 8
    //   81: ldc 53
    //   83: aastore
    //   84: dup
    //   85: bipush 9
    //   87: ldc 57
    //   89: aastore
    //   90: dup
    //   91: bipush 10
    //   93: ldc 61
    //   95: aastore
    //   96: dup
    //   97: bipush 11
    //   99: ldc 69
    //   101: aastore
    //   102: dup
    //   103: bipush 12
    //   105: ldc 73
    //   107: aastore
    //   108: dup
    //   109: bipush 13
    //   111: ldc 77
    //   113: aastore
    //   114: dup
    //   115: bipush 14
    //   117: ldc 81
    //   119: aastore
    //   120: dup
    //   121: bipush 15
    //   123: ldc 89
    //   125: aastore
    //   126: dup
    //   127: bipush 16
    //   129: ldc 93
    //   131: aastore
    //   132: dup
    //   133: bipush 17
    //   135: ldc 97
    //   137: aastore
    //   138: dup
    //   139: bipush 18
    //   141: ldc 101
    //   143: aastore
    //   144: dup
    //   145: bipush 19
    //   147: ldc 105
    //   149: aastore
    //   150: dup
    //   151: bipush 20
    //   153: ldc 109
    //   155: aastore
    //   156: dup
    //   157: bipush 21
    //   159: ldc 113
    //   161: aastore
    //   162: dup
    //   163: bipush 22
    //   165: ldc 117
    //   167: aastore
    //   168: dup
    //   169: bipush 23
    //   171: ldc 121
    //   173: aastore
    //   174: dup
    //   175: bipush 24
    //   177: ldc 125
    //   179: aastore
    //   180: ldc_w 709
    //   183: iconst_1
    //   184: anewarray 19	java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: aconst_null
    //   192: aconst_null
    //   193: aconst_null
    //   194: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   197: astore 6
    //   199: aload 6
    //   201: astore 5
    //   203: aload 6
    //   205: invokeinterface 211 1 0
    //   210: istore_2
    //   211: iload_2
    //   212: ifne +23 -> 235
    //   215: aload 6
    //   217: ifnull +10 -> 227
    //   220: aload 6
    //   222: invokeinterface 218 1 0
    //   227: sipush 1180
    //   230: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aconst_null
    //   234: areturn
    //   235: aload 6
    //   237: astore 5
    //   239: new 736	com/google/android/gms/internal/measurement/zzdy
    //   242: dup
    //   243: aload_0
    //   244: getfield 1264	com/google/android/gms/internal/measurement/zzei:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   247: invokevirtual 1270	com/google/android/gms/internal/measurement/zzjr:zzla	()Lcom/google/android/gms/internal/measurement/zzgl;
    //   250: aload_1
    //   251: invokespecial 1273	com/google/android/gms/internal/measurement/zzdy:<init>	(Lcom/google/android/gms/internal/measurement/zzgl;Ljava/lang/String;)V
    //   254: astore 7
    //   256: aload 6
    //   258: astore 5
    //   260: aload 7
    //   262: aload 6
    //   264: iconst_0
    //   265: invokeinterface 284 2 0
    //   270: invokevirtual 1276	com/google/android/gms/internal/measurement/zzdy:zzal	(Ljava/lang/String;)V
    //   273: aload 6
    //   275: astore 5
    //   277: aload 7
    //   279: aload 6
    //   281: iconst_1
    //   282: invokeinterface 284 2 0
    //   287: invokevirtual 1279	com/google/android/gms/internal/measurement/zzdy:zzam	(Ljava/lang/String;)V
    //   290: aload 6
    //   292: astore 5
    //   294: aload 7
    //   296: aload 6
    //   298: iconst_2
    //   299: invokeinterface 284 2 0
    //   304: invokevirtual 1282	com/google/android/gms/internal/measurement/zzdy:zzan	(Ljava/lang/String;)V
    //   307: aload 6
    //   309: astore 5
    //   311: aload 7
    //   313: aload 6
    //   315: iconst_3
    //   316: invokeinterface 215 2 0
    //   321: invokevirtual 1286	com/google/android/gms/internal/measurement/zzdy:zzr	(J)V
    //   324: aload 6
    //   326: astore 5
    //   328: aload 7
    //   330: aload 6
    //   332: iconst_4
    //   333: invokeinterface 215 2 0
    //   338: invokevirtual 1289	com/google/android/gms/internal/measurement/zzdy:zzm	(J)V
    //   341: aload 6
    //   343: astore 5
    //   345: aload 7
    //   347: aload 6
    //   349: iconst_5
    //   350: invokeinterface 215 2 0
    //   355: invokevirtual 1292	com/google/android/gms/internal/measurement/zzdy:zzn	(J)V
    //   358: aload 6
    //   360: astore 5
    //   362: aload 7
    //   364: aload 6
    //   366: bipush 6
    //   368: invokeinterface 284 2 0
    //   373: invokevirtual 1295	com/google/android/gms/internal/measurement/zzdy:setAppVersion	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: astore 5
    //   380: aload 7
    //   382: aload 6
    //   384: bipush 7
    //   386: invokeinterface 284 2 0
    //   391: invokevirtual 1298	com/google/android/gms/internal/measurement/zzdy:zzap	(Ljava/lang/String;)V
    //   394: aload 6
    //   396: astore 5
    //   398: aload 7
    //   400: aload 6
    //   402: bipush 8
    //   404: invokeinterface 215 2 0
    //   409: invokevirtual 1301	com/google/android/gms/internal/measurement/zzdy:zzp	(J)V
    //   412: aload 6
    //   414: astore 5
    //   416: aload 7
    //   418: aload 6
    //   420: bipush 9
    //   422: invokeinterface 215 2 0
    //   427: invokevirtual 1304	com/google/android/gms/internal/measurement/zzdy:zzq	(J)V
    //   430: aload 6
    //   432: astore 5
    //   434: aload 6
    //   436: bipush 10
    //   438: invokeinterface 1182 2 0
    //   443: ifne +556 -> 999
    //   446: aload 6
    //   448: astore 5
    //   450: aload 6
    //   452: bipush 10
    //   454: invokeinterface 1185 2 0
    //   459: ifeq +409 -> 868
    //   462: goto +537 -> 999
    //   465: aload 6
    //   467: astore 5
    //   469: aload 7
    //   471: iload_2
    //   472: invokevirtual 1307	com/google/android/gms/internal/measurement/zzdy:setMeasurementEnabled	(Z)V
    //   475: aload 6
    //   477: astore 5
    //   479: aload 7
    //   481: aload 6
    //   483: bipush 11
    //   485: invokeinterface 215 2 0
    //   490: invokevirtual 1310	com/google/android/gms/internal/measurement/zzdy:zzu	(J)V
    //   493: aload 6
    //   495: astore 5
    //   497: aload 7
    //   499: aload 6
    //   501: bipush 12
    //   503: invokeinterface 215 2 0
    //   508: invokevirtual 1313	com/google/android/gms/internal/measurement/zzdy:zzv	(J)V
    //   511: aload 6
    //   513: astore 5
    //   515: aload 7
    //   517: aload 6
    //   519: bipush 13
    //   521: invokeinterface 215 2 0
    //   526: invokevirtual 1316	com/google/android/gms/internal/measurement/zzdy:zzw	(J)V
    //   529: aload 6
    //   531: astore 5
    //   533: aload 7
    //   535: aload 6
    //   537: bipush 14
    //   539: invokeinterface 215 2 0
    //   544: invokevirtual 1319	com/google/android/gms/internal/measurement/zzdy:zzx	(J)V
    //   547: aload 6
    //   549: astore 5
    //   551: aload 7
    //   553: aload 6
    //   555: bipush 15
    //   557: invokeinterface 215 2 0
    //   562: invokevirtual 1322	com/google/android/gms/internal/measurement/zzdy:zzs	(J)V
    //   565: aload 6
    //   567: astore 5
    //   569: aload 7
    //   571: aload 6
    //   573: bipush 16
    //   575: invokeinterface 215 2 0
    //   580: invokevirtual 1325	com/google/android/gms/internal/measurement/zzdy:zzt	(J)V
    //   583: aload 6
    //   585: astore 5
    //   587: aload 6
    //   589: bipush 17
    //   591: invokeinterface 1182 2 0
    //   596: ifeq +277 -> 873
    //   599: ldc2_w 1326
    //   602: lstore_3
    //   603: aload 6
    //   605: astore 5
    //   607: aload 7
    //   609: lload_3
    //   610: invokevirtual 1330	com/google/android/gms/internal/measurement/zzdy:zzo	(J)V
    //   613: aload 6
    //   615: astore 5
    //   617: aload 7
    //   619: aload 6
    //   621: bipush 18
    //   623: invokeinterface 284 2 0
    //   628: invokevirtual 1333	com/google/android/gms/internal/measurement/zzdy:zzao	(Ljava/lang/String;)V
    //   631: aload 6
    //   633: astore 5
    //   635: aload 7
    //   637: aload 6
    //   639: bipush 19
    //   641: invokeinterface 215 2 0
    //   646: invokevirtual 1336	com/google/android/gms/internal/measurement/zzdy:zzz	(J)V
    //   649: aload 6
    //   651: astore 5
    //   653: aload 7
    //   655: aload 6
    //   657: bipush 20
    //   659: invokeinterface 215 2 0
    //   664: invokevirtual 1339	com/google/android/gms/internal/measurement/zzdy:zzy	(J)V
    //   667: aload 6
    //   669: astore 5
    //   671: aload 7
    //   673: aload 6
    //   675: bipush 21
    //   677: invokeinterface 284 2 0
    //   682: invokevirtual 1342	com/google/android/gms/internal/measurement/zzdy:zzaq	(Ljava/lang/String;)V
    //   685: aload 6
    //   687: astore 5
    //   689: aload 6
    //   691: bipush 22
    //   693: invokeinterface 1182 2 0
    //   698: ifeq +193 -> 891
    //   701: lconst_0
    //   702: lstore_3
    //   703: aload 6
    //   705: astore 5
    //   707: aload 7
    //   709: lload_3
    //   710: invokevirtual 1345	com/google/android/gms/internal/measurement/zzdy:zzaa	(J)V
    //   713: aload 6
    //   715: astore 5
    //   717: aload 6
    //   719: bipush 23
    //   721: invokeinterface 1182 2 0
    //   726: ifne +278 -> 1004
    //   729: aload 6
    //   731: astore 5
    //   733: aload 6
    //   735: bipush 23
    //   737: invokeinterface 1185 2 0
    //   742: ifeq +166 -> 908
    //   745: goto +259 -> 1004
    //   748: aload 6
    //   750: astore 5
    //   752: aload 7
    //   754: iload_2
    //   755: invokevirtual 1347	com/google/android/gms/internal/measurement/zzdy:zzd	(Z)V
    //   758: aload 6
    //   760: astore 5
    //   762: aload 6
    //   764: bipush 24
    //   766: invokeinterface 1182 2 0
    //   771: ifne +238 -> 1009
    //   774: aload 6
    //   776: astore 5
    //   778: aload 6
    //   780: bipush 24
    //   782: invokeinterface 1185 2 0
    //   787: ifeq +126 -> 913
    //   790: goto +219 -> 1009
    //   793: aload 6
    //   795: astore 5
    //   797: aload 7
    //   799: iload_2
    //   800: invokevirtual 1349	com/google/android/gms/internal/measurement/zzdy:zze	(Z)V
    //   803: aload 6
    //   805: astore 5
    //   807: aload 7
    //   809: invokevirtual 1352	com/google/android/gms/internal/measurement/zzdy:zzgh	()V
    //   812: aload 6
    //   814: astore 5
    //   816: aload 6
    //   818: invokeinterface 1188 1 0
    //   823: ifeq +24 -> 847
    //   826: aload 6
    //   828: astore 5
    //   830: aload_0
    //   831: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   834: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   837: ldc_w 1354
    //   840: aload_1
    //   841: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   844: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   847: aload 6
    //   849: ifnull +10 -> 859
    //   852: aload 6
    //   854: invokeinterface 218 1 0
    //   859: sipush 1180
    //   862: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   865: aload 7
    //   867: areturn
    //   868: iconst_0
    //   869: istore_2
    //   870: goto -405 -> 465
    //   873: aload 6
    //   875: astore 5
    //   877: aload 6
    //   879: bipush 17
    //   881: invokeinterface 1185 2 0
    //   886: i2l
    //   887: lstore_3
    //   888: goto -285 -> 603
    //   891: aload 6
    //   893: astore 5
    //   895: aload 6
    //   897: bipush 22
    //   899: invokeinterface 215 2 0
    //   904: lstore_3
    //   905: goto -202 -> 703
    //   908: iconst_0
    //   909: istore_2
    //   910: goto -162 -> 748
    //   913: iconst_0
    //   914: istore_2
    //   915: goto -122 -> 793
    //   918: astore 7
    //   920: aconst_null
    //   921: astore 6
    //   923: aload 6
    //   925: astore 5
    //   927: aload_0
    //   928: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   931: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   934: ldc_w 1356
    //   937: aload_1
    //   938: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   941: aload 7
    //   943: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   946: aload 6
    //   948: ifnull +10 -> 958
    //   951: aload 6
    //   953: invokeinterface 218 1 0
    //   958: sipush 1180
    //   961: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   964: aconst_null
    //   965: areturn
    //   966: astore_1
    //   967: aconst_null
    //   968: astore 5
    //   970: aload 5
    //   972: ifnull +10 -> 982
    //   975: aload 5
    //   977: invokeinterface 218 1 0
    //   982: sipush 1180
    //   985: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   988: aload_1
    //   989: athrow
    //   990: astore_1
    //   991: goto -21 -> 970
    //   994: astore 7
    //   996: goto -73 -> 923
    //   999: iconst_1
    //   1000: istore_2
    //   1001: goto -536 -> 465
    //   1004: iconst_1
    //   1005: istore_2
    //   1006: goto -258 -> 748
    //   1009: iconst_1
    //   1010: istore_2
    //   1011: goto -218 -> 793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	this	zzei
    //   0	1014	1	paramString	String
    //   210	801	2	bool	boolean
    //   602	303	3	l	long
    //   201	775	5	localCursor1	Cursor
    //   197	755	6	localCursor2	Cursor
    //   254	612	7	localzzdy	zzdy
    //   918	24	7	localSQLiteException1	SQLiteException
    //   994	1	7	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   19	199	918	android/database/sqlite/SQLiteException
    //   19	199	966	finally
    //   203	211	990	finally
    //   239	256	990	finally
    //   260	273	990	finally
    //   277	290	990	finally
    //   294	307	990	finally
    //   311	324	990	finally
    //   328	341	990	finally
    //   345	358	990	finally
    //   362	376	990	finally
    //   380	394	990	finally
    //   398	412	990	finally
    //   416	430	990	finally
    //   434	446	990	finally
    //   450	462	990	finally
    //   469	475	990	finally
    //   479	493	990	finally
    //   497	511	990	finally
    //   515	529	990	finally
    //   533	547	990	finally
    //   551	565	990	finally
    //   569	583	990	finally
    //   587	599	990	finally
    //   607	613	990	finally
    //   617	631	990	finally
    //   635	649	990	finally
    //   653	667	990	finally
    //   671	685	990	finally
    //   689	701	990	finally
    //   707	713	990	finally
    //   717	729	990	finally
    //   733	745	990	finally
    //   752	758	990	finally
    //   762	774	990	finally
    //   778	790	990	finally
    //   797	803	990	finally
    //   807	812	990	finally
    //   816	826	990	finally
    //   830	847	990	finally
    //   877	888	990	finally
    //   895	905	990	finally
    //   927	946	990	finally
    //   203	211	994	android/database/sqlite/SQLiteException
    //   239	256	994	android/database/sqlite/SQLiteException
    //   260	273	994	android/database/sqlite/SQLiteException
    //   277	290	994	android/database/sqlite/SQLiteException
    //   294	307	994	android/database/sqlite/SQLiteException
    //   311	324	994	android/database/sqlite/SQLiteException
    //   328	341	994	android/database/sqlite/SQLiteException
    //   345	358	994	android/database/sqlite/SQLiteException
    //   362	376	994	android/database/sqlite/SQLiteException
    //   380	394	994	android/database/sqlite/SQLiteException
    //   398	412	994	android/database/sqlite/SQLiteException
    //   416	430	994	android/database/sqlite/SQLiteException
    //   434	446	994	android/database/sqlite/SQLiteException
    //   450	462	994	android/database/sqlite/SQLiteException
    //   469	475	994	android/database/sqlite/SQLiteException
    //   479	493	994	android/database/sqlite/SQLiteException
    //   497	511	994	android/database/sqlite/SQLiteException
    //   515	529	994	android/database/sqlite/SQLiteException
    //   533	547	994	android/database/sqlite/SQLiteException
    //   551	565	994	android/database/sqlite/SQLiteException
    //   569	583	994	android/database/sqlite/SQLiteException
    //   587	599	994	android/database/sqlite/SQLiteException
    //   607	613	994	android/database/sqlite/SQLiteException
    //   617	631	994	android/database/sqlite/SQLiteException
    //   635	649	994	android/database/sqlite/SQLiteException
    //   653	667	994	android/database/sqlite/SQLiteException
    //   671	685	994	android/database/sqlite/SQLiteException
    //   689	701	994	android/database/sqlite/SQLiteException
    //   707	713	994	android/database/sqlite/SQLiteException
    //   717	729	994	android/database/sqlite/SQLiteException
    //   733	745	994	android/database/sqlite/SQLiteException
    //   752	758	994	android/database/sqlite/SQLiteException
    //   762	774	994	android/database/sqlite/SQLiteException
    //   778	790	994	android/database/sqlite/SQLiteException
    //   797	803	994	android/database/sqlite/SQLiteException
    //   807	812	994	android/database/sqlite/SQLiteException
    //   816	826	994	android/database/sqlite/SQLiteException
    //   830	847	994	android/database/sqlite/SQLiteException
    //   877	888	994	android/database/sqlite/SQLiteException
    //   895	905	994	android/database/sqlite/SQLiteException
  }
  
  public final long zzbd(String paramString)
  {
    AppMethodBeat.i(1182);
    Preconditions.checkNotEmpty(paramString);
    zzab();
    zzch();
    try
    {
      int i = getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { paramString, String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(paramString, zzew.zzagx)))) });
      long l = i;
      AppMethodBeat.o(1182);
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(paramString), localSQLiteException);
      AppMethodBeat.o(1182);
    }
    return 0L;
  }
  
  /* Error */
  public final byte[] zzbe(String paramString)
  {
    // Byte code:
    //   0: sipush 1184
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   15: aload_0
    //   16: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   19: aload_0
    //   20: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: ldc_w 707
    //   26: iconst_1
    //   27: anewarray 19	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 85
    //   34: aastore
    //   35: ldc_w 709
    //   38: iconst_1
    //   39: anewarray 19	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: invokeinterface 211 1 0
    //   64: istore_2
    //   65: iload_2
    //   66: ifne +23 -> 89
    //   69: aload 4
    //   71: ifnull +10 -> 81
    //   74: aload 4
    //   76: invokeinterface 218 1 0
    //   81: sipush 1184
    //   84: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: aload 4
    //   91: astore_3
    //   92: aload 4
    //   94: iconst_0
    //   95: invokeinterface 679 2 0
    //   100: astore 5
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: invokeinterface 1188 1 0
    //   112: ifeq +23 -> 135
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   122: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   125: ldc_w 1370
    //   128: aload_1
    //   129: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   132: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 218 1 0
    //   147: sipush 1184
    //   150: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 5
    //   155: areturn
    //   156: astore 5
    //   158: aconst_null
    //   159: astore 4
    //   161: aload 4
    //   163: astore_3
    //   164: aload_0
    //   165: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   168: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   171: ldc_w 1372
    //   174: aload_1
    //   175: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   178: aload 5
    //   180: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   183: aload 4
    //   185: ifnull +10 -> 195
    //   188: aload 4
    //   190: invokeinterface 218 1 0
    //   195: sipush 1184
    //   198: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: ifnull +9 -> 216
    //   210: aload_3
    //   211: invokeinterface 218 1 0
    //   216: sipush 1184
    //   219: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: goto -19 -> 206
    //   228: astore 5
    //   230: goto -69 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	zzei
    //   0	233	1	paramString	String
    //   64	2	2	bool	boolean
    //   56	155	3	localCursor1	Cursor
    //   52	137	4	localCursor2	Cursor
    //   100	54	5	arrayOfByte	byte[]
    //   156	23	5	localSQLiteException1	SQLiteException
    //   228	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   19	54	156	android/database/sqlite/SQLiteException
    //   19	54	203	finally
    //   57	65	224	finally
    //   92	102	224	finally
    //   105	115	224	finally
    //   118	135	224	finally
    //   164	183	224	finally
    //   57	65	228	android/database/sqlite/SQLiteException
    //   92	102	228	android/database/sqlite/SQLiteException
    //   105	115	228	android/database/sqlite/SQLiteException
    //   118	135	228	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  final java.util.Map<Integer, zzkr> zzbf(String paramString)
  {
    // Byte code:
    //   0: sipush 1197
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   10: aload_0
    //   11: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   14: aload_1
    //   15: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   18: pop
    //   19: aload_0
    //   20: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 4
    //   25: aload 4
    //   27: ldc_w 571
    //   30: iconst_2
    //   31: anewarray 19	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 469
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc_w 1376
    //   45: aastore
    //   46: ldc_w 709
    //   49: iconst_1
    //   50: anewarray 19	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload 5
    //   67: astore 4
    //   69: aload 5
    //   71: invokeinterface 211 1 0
    //   76: istore_3
    //   77: iload_3
    //   78: ifne +23 -> 101
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: invokeinterface 218 1 0
    //   93: sipush 1197
    //   96: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload 5
    //   103: astore 4
    //   105: new 1378	androidx/b/a
    //   108: dup
    //   109: invokespecial 1379	androidx/b/a:<init>	()V
    //   112: astore 6
    //   114: aload 5
    //   116: astore 4
    //   118: aload 5
    //   120: iconst_0
    //   121: invokeinterface 1185 2 0
    //   126: istore_2
    //   127: aload 5
    //   129: astore 4
    //   131: aload 5
    //   133: iconst_1
    //   134: invokeinterface 679 2 0
    //   139: astore 7
    //   141: aload 5
    //   143: astore 4
    //   145: aload 7
    //   147: iconst_0
    //   148: aload 7
    //   150: arraylength
    //   151: invokestatic 684	com/google/android/gms/internal/measurement/zzabv:zza	([BII)Lcom/google/android/gms/internal/measurement/zzabv;
    //   154: astore 7
    //   156: aload 5
    //   158: astore 4
    //   160: new 1381	com/google/android/gms/internal/measurement/zzkr
    //   163: dup
    //   164: invokespecial 1382	com/google/android/gms/internal/measurement/zzkr:<init>	()V
    //   167: astore 8
    //   169: aload 5
    //   171: astore 4
    //   173: aload 8
    //   175: aload 7
    //   177: invokevirtual 690	com/google/android/gms/internal/measurement/zzace:zzb	(Lcom/google/android/gms/internal/measurement/zzabv;)Lcom/google/android/gms/internal/measurement/zzace;
    //   180: pop
    //   181: aload 5
    //   183: astore 4
    //   185: aload 6
    //   187: iload_2
    //   188: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aload 8
    //   193: invokeinterface 1387 3 0
    //   198: pop
    //   199: aload 5
    //   201: astore 4
    //   203: aload 5
    //   205: invokeinterface 1188 1 0
    //   210: istore_3
    //   211: iload_3
    //   212: ifne -98 -> 114
    //   215: aload 5
    //   217: ifnull +10 -> 227
    //   220: aload 5
    //   222: invokeinterface 218 1 0
    //   227: sipush 1197
    //   230: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload 6
    //   235: areturn
    //   236: astore 7
    //   238: aload 5
    //   240: astore 4
    //   242: aload_0
    //   243: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   246: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   249: ldc_w 1389
    //   252: aload_1
    //   253: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   256: iload_2
    //   257: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aload 7
    //   262: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   265: goto -66 -> 199
    //   268: astore 6
    //   270: aload 5
    //   272: astore 4
    //   274: aload_0
    //   275: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   278: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   281: ldc_w 1391
    //   284: aload_1
    //   285: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   288: aload 6
    //   290: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   293: aload 5
    //   295: ifnull +10 -> 305
    //   298: aload 5
    //   300: invokeinterface 218 1 0
    //   305: sipush 1197
    //   308: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aconst_null
    //   312: areturn
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: ifnull +10 -> 329
    //   322: aload 4
    //   324: invokeinterface 218 1 0
    //   329: sipush 1197
    //   332: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: goto -21 -> 317
    //   341: astore 6
    //   343: aconst_null
    //   344: astore 5
    //   346: goto -76 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	zzei
    //   0	349	1	paramString	String
    //   126	131	2	i	int
    //   76	136	3	bool	boolean
    //   23	300	4	localObject1	Object
    //   63	282	5	localCursor	Cursor
    //   112	122	6	locala	androidx.b.a
    //   268	21	6	localSQLiteException1	SQLiteException
    //   341	1	6	localSQLiteException2	SQLiteException
    //   139	37	7	localObject2	Object
    //   236	25	7	localIOException	IOException
    //   167	25	8	localzzkr	zzkr
    // Exception table:
    //   from	to	target	type
    //   173	181	236	java/io/IOException
    //   69	77	268	android/database/sqlite/SQLiteException
    //   105	114	268	android/database/sqlite/SQLiteException
    //   118	127	268	android/database/sqlite/SQLiteException
    //   131	141	268	android/database/sqlite/SQLiteException
    //   145	156	268	android/database/sqlite/SQLiteException
    //   160	169	268	android/database/sqlite/SQLiteException
    //   173	181	268	android/database/sqlite/SQLiteException
    //   185	199	268	android/database/sqlite/SQLiteException
    //   203	211	268	android/database/sqlite/SQLiteException
    //   242	265	268	android/database/sqlite/SQLiteException
    //   25	65	313	finally
    //   69	77	337	finally
    //   105	114	337	finally
    //   118	127	337	finally
    //   131	141	337	finally
    //   145	156	337	finally
    //   160	169	337	finally
    //   173	181	337	finally
    //   185	199	337	finally
    //   203	211	337	finally
    //   242	265	337	finally
    //   274	293	337	finally
    //   25	65	341	android/database/sqlite/SQLiteException
  }
  
  public final long zzbg(String paramString)
  {
    AppMethodBeat.i(1206);
    Preconditions.checkNotEmpty(paramString);
    long l = zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
    AppMethodBeat.o(1206);
    return l;
  }
  
  public final List<zzed> zzc(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1178);
    Preconditions.checkNotEmpty(paramString1);
    zzab();
    zzch();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(paramString1);
    paramString1 = new StringBuilder("app_id=?");
    if (!TextUtils.isEmpty(paramString2))
    {
      localArrayList.add(paramString2);
      paramString1.append(" and origin=?");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localArrayList.add(String.valueOf(paramString3).concat("*"));
      paramString1.append(" and name glob ?");
    }
    paramString2 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    paramString1 = zzb(paramString1.toString(), paramString2);
    AppMethodBeat.o(1178);
    return paramString1;
  }
  
  @VisibleForTesting
  final void zzc(List<Long> paramList)
  {
    AppMethodBeat.i(1190);
    zzab();
    zzch();
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotZero(paramList.size());
    if (!zzhv())
    {
      AppMethodBeat.o(1190);
      return;
    }
    paramList = TextUtils.join(",", paramList);
    paramList = String.valueOf(paramList).length() + 2 + "(" + paramList + ")";
    if (zza(String.valueOf(paramList).length() + 80 + "SELECT COUNT(1) FROM queue WHERE rowid IN " + paramList + " AND retry_count =  2147483647 LIMIT 1", null) > 0L) {
      zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
    }
    try
    {
      getWritableDatabase().execSQL(String.valueOf(paramList).length() + 127 + "UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + paramList + " AND (retry_count IS NULL OR retry_count < 2147483647)");
      AppMethodBeat.o(1190);
      return;
    }
    catch (SQLiteException paramList)
    {
      zzge().zzim().zzg("Error incrementing retry count. error", paramList);
      AppMethodBeat.o(1190);
    }
  }
  
  /* Error */
  public final zzeq zzf(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1168
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   20: aload_0
    //   21: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   24: aload_0
    //   25: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: ldc_w 879
    //   31: bipush 7
    //   33: anewarray 19	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 847
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc_w 852
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc_w 857
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: ldc 21
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc 25
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: ldc 29
    //   68: aastore
    //   69: dup
    //   70: bipush 6
    //   72: ldc 33
    //   74: aastore
    //   75: ldc_w 1423
    //   78: iconst_2
    //   79: anewarray 19	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_2
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 14
    //   98: aload 14
    //   100: invokeinterface 211 1 0
    //   105: istore_3
    //   106: iload_3
    //   107: ifne +23 -> 130
    //   110: aload 14
    //   112: ifnull +10 -> 122
    //   115: aload 14
    //   117: invokeinterface 218 1 0
    //   122: sipush 1168
    //   125: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: aload 14
    //   132: iconst_0
    //   133: invokeinterface 215 2 0
    //   138: lstore 6
    //   140: aload 14
    //   142: iconst_1
    //   143: invokeinterface 215 2 0
    //   148: lstore 8
    //   150: aload 14
    //   152: iconst_2
    //   153: invokeinterface 215 2 0
    //   158: lstore 10
    //   160: aload 14
    //   162: iconst_3
    //   163: invokeinterface 1182 2 0
    //   168: ifeq +144 -> 312
    //   171: lconst_0
    //   172: lstore 4
    //   174: aload 14
    //   176: iconst_4
    //   177: invokeinterface 1182 2 0
    //   182: ifeq +143 -> 325
    //   185: aconst_null
    //   186: astore 15
    //   188: aload 14
    //   190: iconst_5
    //   191: invokeinterface 1182 2 0
    //   196: ifeq +145 -> 341
    //   199: aconst_null
    //   200: astore 16
    //   202: aconst_null
    //   203: astore 17
    //   205: aload 14
    //   207: bipush 6
    //   209: invokeinterface 1182 2 0
    //   214: ifne +25 -> 239
    //   217: aload 14
    //   219: bipush 6
    //   221: invokeinterface 215 2 0
    //   226: lconst_1
    //   227: lcmp
    //   228: ifne +133 -> 361
    //   231: iconst_1
    //   232: istore_3
    //   233: iload_3
    //   234: invokestatic 788	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   237: astore 17
    //   239: new 842	com/google/android/gms/internal/measurement/zzeq
    //   242: dup
    //   243: aload_1
    //   244: aload_2
    //   245: lload 6
    //   247: lload 8
    //   249: lload 10
    //   251: lload 4
    //   253: aload 15
    //   255: aload 16
    //   257: aload 17
    //   259: invokespecial 1426	com/google/android/gms/internal/measurement/zzeq:<init>	(Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V
    //   262: astore 15
    //   264: aload 14
    //   266: invokeinterface 1188 1 0
    //   271: ifeq +20 -> 291
    //   274: aload_0
    //   275: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   278: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   281: ldc_w 1428
    //   284: aload_1
    //   285: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   288: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   291: aload 14
    //   293: ifnull +10 -> 303
    //   296: aload 14
    //   298: invokeinterface 218 1 0
    //   303: sipush 1168
    //   306: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload 15
    //   311: areturn
    //   312: aload 14
    //   314: iconst_3
    //   315: invokeinterface 215 2 0
    //   320: lstore 4
    //   322: goto -148 -> 174
    //   325: aload 14
    //   327: iconst_4
    //   328: invokeinterface 215 2 0
    //   333: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   336: astore 15
    //   338: goto -150 -> 188
    //   341: aload 14
    //   343: iconst_5
    //   344: invokeinterface 215 2 0
    //   349: lstore 12
    //   351: lload 12
    //   353: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: astore 16
    //   358: goto -156 -> 202
    //   361: iconst_0
    //   362: istore_3
    //   363: goto -130 -> 233
    //   366: astore 15
    //   368: aconst_null
    //   369: astore 14
    //   371: aload_0
    //   372: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   375: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   378: ldc_w 1430
    //   381: aload_1
    //   382: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: aload_0
    //   386: invokevirtual 1047	com/google/android/gms/internal/measurement/zzhg:zzga	()Lcom/google/android/gms/internal/measurement/zzfe;
    //   389: aload_2
    //   390: invokevirtual 1053	com/google/android/gms/internal/measurement/zzfe:zzbj	(Ljava/lang/String;)Ljava/lang/String;
    //   393: aload 15
    //   395: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   398: aload 14
    //   400: ifnull +10 -> 410
    //   403: aload 14
    //   405: invokeinterface 218 1 0
    //   410: sipush 1168
    //   413: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aconst_null
    //   417: areturn
    //   418: astore_1
    //   419: aconst_null
    //   420: astore 14
    //   422: aload 14
    //   424: ifnull +10 -> 434
    //   427: aload 14
    //   429: invokeinterface 218 1 0
    //   434: sipush 1168
    //   437: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_1
    //   441: athrow
    //   442: astore_1
    //   443: goto -21 -> 422
    //   446: astore_1
    //   447: goto -25 -> 422
    //   450: astore 15
    //   452: goto -81 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	zzei
    //   0	455	1	paramString1	String
    //   0	455	2	paramString2	String
    //   105	258	3	bool	boolean
    //   172	149	4	l1	long
    //   138	108	6	l2	long
    //   148	100	8	l3	long
    //   158	92	10	l4	long
    //   349	3	12	l5	long
    //   96	332	14	localCursor	Cursor
    //   186	151	15	localObject	Object
    //   366	28	15	localSQLiteException1	SQLiteException
    //   450	1	15	localSQLiteException2	SQLiteException
    //   200	157	16	localLong	Long
    //   203	55	17	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   24	98	366	android/database/sqlite/SQLiteException
    //   24	98	418	finally
    //   98	106	442	finally
    //   130	171	442	finally
    //   174	185	442	finally
    //   188	199	442	finally
    //   205	231	442	finally
    //   233	239	442	finally
    //   239	291	442	finally
    //   312	322	442	finally
    //   325	338	442	finally
    //   341	351	442	finally
    //   371	398	446	finally
    //   98	106	450	android/database/sqlite/SQLiteException
    //   130	171	450	android/database/sqlite/SQLiteException
    //   174	185	450	android/database/sqlite/SQLiteException
    //   188	199	450	android/database/sqlite/SQLiteException
    //   205	231	450	android/database/sqlite/SQLiteException
    //   233	239	450	android/database/sqlite/SQLiteException
    //   239	291	450	android/database/sqlite/SQLiteException
    //   312	322	450	android/database/sqlite/SQLiteException
    //   325	338	450	android/database/sqlite/SQLiteException
    //   341	351	450	android/database/sqlite/SQLiteException
  }
  
  public final void zzg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1170);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzab();
    zzch();
    try
    {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(i));
      AppMethodBeat.o(1170);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(paramString1), zzga().zzbl(paramString2), localSQLiteException);
      AppMethodBeat.o(1170);
    }
  }
  
  /* Error */
  public final zzjz zzh(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: sipush 1172
    //   6: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   13: pop
    //   14: aload_2
    //   15: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   18: pop
    //   19: aload_0
    //   20: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   23: aload_0
    //   24: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   27: aload_0
    //   28: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: ldc_w 1093
    //   34: iconst_3
    //   35: anewarray 19	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc_w 1087
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc_w 938
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 39
    //   54: aastore
    //   55: ldc_w 1423
    //   58: iconst_2
    //   59: anewarray 19	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_2
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore 6
    //   78: aload 6
    //   80: invokeinterface 211 1 0
    //   85: istore_3
    //   86: iload_3
    //   87: ifne +23 -> 110
    //   90: aload 6
    //   92: ifnull +10 -> 102
    //   95: aload 6
    //   97: invokeinterface 218 1 0
    //   102: sipush 1172
    //   105: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: aload 6
    //   112: iconst_0
    //   113: invokeinterface 215 2 0
    //   118: lstore 4
    //   120: aload_0
    //   121: aload 6
    //   123: iconst_1
    //   124: invokespecial 1218	com/google/android/gms/internal/measurement/zzei:zza	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   127: astore 7
    //   129: new 1072	com/google/android/gms/internal/measurement/zzjz
    //   132: dup
    //   133: aload_1
    //   134: aload 6
    //   136: iconst_2
    //   137: invokeinterface 284 2 0
    //   142: aload_2
    //   143: lload 4
    //   145: aload 7
    //   147: invokespecial 1223	com/google/android/gms/internal/measurement/zzjz:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   150: astore 7
    //   152: aload 6
    //   154: invokeinterface 1188 1 0
    //   159: ifeq +20 -> 179
    //   162: aload_0
    //   163: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   166: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   169: ldc_w 1439
    //   172: aload_1
    //   173: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   176: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   179: aload 6
    //   181: ifnull +10 -> 191
    //   184: aload 6
    //   186: invokeinterface 218 1 0
    //   191: sipush 1172
    //   194: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload 7
    //   199: areturn
    //   200: astore 7
    //   202: aconst_null
    //   203: astore 6
    //   205: aload_0
    //   206: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   209: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   212: ldc_w 1441
    //   215: aload_1
    //   216: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   219: aload_0
    //   220: invokevirtual 1047	com/google/android/gms/internal/measurement/zzhg:zzga	()Lcom/google/android/gms/internal/measurement/zzfe;
    //   223: aload_2
    //   224: invokevirtual 1437	com/google/android/gms/internal/measurement/zzfe:zzbl	(Ljava/lang/String;)Ljava/lang/String;
    //   227: aload 7
    //   229: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   232: aload 6
    //   234: ifnull +10 -> 244
    //   237: aload 6
    //   239: invokeinterface 218 1 0
    //   244: sipush 1172
    //   247: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore_1
    //   253: aload 7
    //   255: astore_2
    //   256: aload_2
    //   257: ifnull +9 -> 266
    //   260: aload_2
    //   261: invokeinterface 218 1 0
    //   266: sipush 1172
    //   269: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: aload 6
    //   277: astore_2
    //   278: goto -22 -> 256
    //   281: astore_1
    //   282: aload 6
    //   284: astore_2
    //   285: goto -29 -> 256
    //   288: astore 7
    //   290: goto -85 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	zzei
    //   0	293	1	paramString1	String
    //   0	293	2	paramString2	String
    //   85	2	3	bool	boolean
    //   118	26	4	l	long
    //   76	207	6	localCursor	Cursor
    //   1	197	7	localObject	Object
    //   200	54	7	localSQLiteException1	SQLiteException
    //   288	1	7	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   27	78	200	android/database/sqlite/SQLiteException
    //   27	78	252	finally
    //   78	86	274	finally
    //   110	179	274	finally
    //   205	232	281	finally
    //   78	86	288	android/database/sqlite/SQLiteException
    //   110	179	288	android/database/sqlite/SQLiteException
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  /* Error */
  public final String zzhn()
  {
    // Byte code:
    //   0: sipush 1186
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc_w 1445
    //   15: aconst_null
    //   16: invokevirtual 205	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 211 1 0
    //   28: ifeq +31 -> 59
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: iconst_0
    //   35: invokeinterface 284 2 0
    //   40: astore_3
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokeinterface 218 1 0
    //   51: sipush 1186
    //   54: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_3
    //   58: areturn
    //   59: aload_2
    //   60: ifnull +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 218 1 0
    //   69: sipush 1186
    //   72: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   86: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   89: ldc_w 1447
    //   92: aload_3
    //   93: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   96: aload_2
    //   97: ifnull +9 -> 106
    //   100: aload_2
    //   101: invokeinterface 218 1 0
    //   106: sipush 1186
    //   109: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +9 -> 127
    //   121: aload_1
    //   122: invokeinterface 218 1 0
    //   127: sipush 1186
    //   130: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_2
    //   134: athrow
    //   135: astore_2
    //   136: goto -19 -> 117
    //   139: astore_3
    //   140: goto -60 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	zzei
    //   10	112	1	localObject1	Object
    //   19	82	2	localCursor	Cursor
    //   114	20	2	localObject2	Object
    //   135	1	2	localObject3	Object
    //   40	18	3	str	String
    //   77	16	3	localSQLiteException1	SQLiteException
    //   139	1	3	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   11	20	77	android/database/sqlite/SQLiteException
    //   11	20	114	finally
    //   22	31	135	finally
    //   33	41	135	finally
    //   82	96	135	finally
    //   22	31	139	android/database/sqlite/SQLiteException
    //   33	41	139	android/database/sqlite/SQLiteException
  }
  
  public final boolean zzho()
  {
    AppMethodBeat.i(1187);
    if (zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0L)
    {
      AppMethodBeat.o(1187);
      return true;
    }
    AppMethodBeat.o(1187);
    return false;
  }
  
  final void zzhp()
  {
    AppMethodBeat.i(1189);
    zzab();
    zzch();
    if (!zzhv())
    {
      AppMethodBeat.o(1189);
      return;
    }
    long l1 = zzgf().zzajx.get();
    long l2 = zzbt().elapsedRealtime();
    if (Math.abs(l2 - l1) > ((Long)zzew.zzahg.get()).longValue())
    {
      zzgf().zzajx.set(l2);
      zzab();
      zzch();
      if (zzhv())
      {
        int i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh()) });
        if (i > 0) {
          zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
        }
      }
    }
    AppMethodBeat.o(1189);
  }
  
  public final long zzhq()
  {
    AppMethodBeat.i(1200);
    long l = zza("select max(bundle_end_timestamp) from queue", null, 0L);
    AppMethodBeat.o(1200);
    return l;
  }
  
  public final long zzhr()
  {
    AppMethodBeat.i(1202);
    long l = zza("select max(timestamp) from raw_events", null, 0L);
    AppMethodBeat.o(1202);
    return l;
  }
  
  public final boolean zzhs()
  {
    AppMethodBeat.i(1204);
    if (zza("select count(1) > 0 from raw_events", null) != 0L)
    {
      AppMethodBeat.o(1204);
      return true;
    }
    AppMethodBeat.o(1204);
    return false;
  }
  
  public final boolean zzht()
  {
    AppMethodBeat.i(1205);
    if (zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0L)
    {
      AppMethodBeat.o(1205);
      return true;
    }
    AppMethodBeat.o(1205);
    return false;
  }
  
  public final long zzhu()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(1208);
    try
    {
      Cursor localCursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
      localObject1 = localCursor;
      localObject3 = localCursor;
      boolean bool = localCursor.moveToFirst();
      if (!bool) {
        return -1L;
      }
      localObject1 = localCursor;
      localObject3 = localCursor;
      long l = localCursor.getLong(0);
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject3 = localObject1;
      zzge().zzim().zzg("Error querying raw events", localSQLiteException);
      return -1L;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.close();
      }
      AppMethodBeat.o(1208);
    }
  }
  
  /* Error */
  public final zzed zzi(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1176
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   20: aload_0
    //   21: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   24: aload_0
    //   25: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: ldc_w 995
    //   31: bipush 11
    //   33: anewarray 19	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 39
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc_w 938
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc_w 946
    //   52: aastore
    //   53: dup
    //   54: iconst_3
    //   55: ldc_w 951
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc_w 956
    //   64: aastore
    //   65: dup
    //   66: iconst_5
    //   67: ldc_w 961
    //   70: aastore
    //   71: dup
    //   72: bipush 6
    //   74: ldc_w 970
    //   77: aastore
    //   78: dup
    //   79: bipush 7
    //   81: ldc_w 975
    //   84: aastore
    //   85: dup
    //   86: bipush 8
    //   88: ldc_w 980
    //   91: aastore
    //   92: dup
    //   93: bipush 9
    //   95: ldc_w 985
    //   98: aastore
    //   99: dup
    //   100: bipush 10
    //   102: ldc_w 990
    //   105: aastore
    //   106: ldc_w 1423
    //   109: iconst_2
    //   110: anewarray 19	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload_2
    //   120: aastore
    //   121: aconst_null
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore 12
    //   129: aload 12
    //   131: invokeinterface 211 1 0
    //   136: istore_3
    //   137: iload_3
    //   138: ifne +23 -> 161
    //   141: aload 12
    //   143: ifnull +10 -> 153
    //   146: aload 12
    //   148: invokeinterface 218 1 0
    //   153: sipush 1176
    //   156: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aconst_null
    //   160: areturn
    //   161: aload 12
    //   163: iconst_0
    //   164: invokeinterface 284 2 0
    //   169: astore 13
    //   171: aload_0
    //   172: aload 12
    //   174: iconst_1
    //   175: invokespecial 1218	com/google/android/gms/internal/measurement/zzei:zza	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   178: astore 14
    //   180: aload 12
    //   182: iconst_2
    //   183: invokeinterface 1185 2 0
    //   188: ifeq +226 -> 414
    //   191: iconst_1
    //   192: istore_3
    //   193: aload 12
    //   195: iconst_3
    //   196: invokeinterface 284 2 0
    //   201: astore 15
    //   203: aload 12
    //   205: iconst_4
    //   206: invokeinterface 215 2 0
    //   211: lstore 4
    //   213: aload_0
    //   214: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   217: aload 12
    //   219: iconst_5
    //   220: invokeinterface 679 2 0
    //   225: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   228: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   231: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   234: astore 16
    //   236: aload 12
    //   238: bipush 6
    //   240: invokeinterface 215 2 0
    //   245: lstore 6
    //   247: aload_0
    //   248: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   251: aload 12
    //   253: bipush 7
    //   255: invokeinterface 679 2 0
    //   260: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   263: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   266: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   269: astore 17
    //   271: aload 12
    //   273: bipush 8
    //   275: invokeinterface 215 2 0
    //   280: lstore 8
    //   282: aload 12
    //   284: bipush 9
    //   286: invokeinterface 215 2 0
    //   291: lstore 10
    //   293: aload_0
    //   294: invokevirtual 637	com/google/android/gms/internal/measurement/zzhg:zzgb	()Lcom/google/android/gms/internal/measurement/zzka;
    //   297: aload 12
    //   299: bipush 10
    //   301: invokeinterface 679 2 0
    //   306: getstatic 1235	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   309: invokevirtual 1238	com/google/android/gms/internal/measurement/zzka:zza	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   312: checkcast 1231	com/google/android/gms/internal/measurement/zzeu
    //   315: astore 18
    //   317: new 916	com/google/android/gms/internal/measurement/zzed
    //   320: dup
    //   321: aload_1
    //   322: aload 13
    //   324: new 925	com/google/android/gms/internal/measurement/zzjx
    //   327: dup
    //   328: aload_2
    //   329: lload 8
    //   331: aload 14
    //   333: aload 13
    //   335: invokespecial 1241	com/google/android/gms/internal/measurement/zzjx:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   338: lload 6
    //   340: iload_3
    //   341: aload 15
    //   343: aload 16
    //   345: lload 4
    //   347: aload 17
    //   349: lload 10
    //   351: aload 18
    //   353: invokespecial 1244	com/google/android/gms/internal/measurement/zzed:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzjx;JZLjava/lang/String;Lcom/google/android/gms/internal/measurement/zzeu;JLcom/google/android/gms/internal/measurement/zzeu;JLcom/google/android/gms/internal/measurement/zzeu;)V
    //   356: astore 13
    //   358: aload 12
    //   360: invokeinterface 1188 1 0
    //   365: ifeq +28 -> 393
    //   368: aload_0
    //   369: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   372: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   375: ldc_w 1506
    //   378: aload_1
    //   379: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   382: aload_0
    //   383: invokevirtual 1047	com/google/android/gms/internal/measurement/zzhg:zzga	()Lcom/google/android/gms/internal/measurement/zzfe;
    //   386: aload_2
    //   387: invokevirtual 1437	com/google/android/gms/internal/measurement/zzfe:zzbl	(Ljava/lang/String;)Ljava/lang/String;
    //   390: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   393: aload 12
    //   395: ifnull +10 -> 405
    //   398: aload 12
    //   400: invokeinterface 218 1 0
    //   405: sipush 1176
    //   408: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload 13
    //   413: areturn
    //   414: iconst_0
    //   415: istore_3
    //   416: goto -223 -> 193
    //   419: astore 13
    //   421: aconst_null
    //   422: astore 12
    //   424: aload_0
    //   425: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   428: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   431: ldc_w 1508
    //   434: aload_1
    //   435: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   438: aload_0
    //   439: invokevirtual 1047	com/google/android/gms/internal/measurement/zzhg:zzga	()Lcom/google/android/gms/internal/measurement/zzfe;
    //   442: aload_2
    //   443: invokevirtual 1437	com/google/android/gms/internal/measurement/zzfe:zzbl	(Ljava/lang/String;)Ljava/lang/String;
    //   446: aload 13
    //   448: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   451: aload 12
    //   453: ifnull +10 -> 463
    //   456: aload 12
    //   458: invokeinterface 218 1 0
    //   463: sipush 1176
    //   466: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: aconst_null
    //   470: areturn
    //   471: astore_1
    //   472: aconst_null
    //   473: astore 12
    //   475: aload 12
    //   477: ifnull +10 -> 487
    //   480: aload 12
    //   482: invokeinterface 218 1 0
    //   487: sipush 1176
    //   490: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   493: aload_1
    //   494: athrow
    //   495: astore_1
    //   496: goto -21 -> 475
    //   499: astore_1
    //   500: goto -25 -> 475
    //   503: astore 13
    //   505: goto -81 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	zzei
    //   0	508	1	paramString1	String
    //   0	508	2	paramString2	String
    //   136	280	3	bool	boolean
    //   211	135	4	l1	long
    //   245	94	6	l2	long
    //   280	50	8	l3	long
    //   291	59	10	l4	long
    //   127	354	12	localCursor	Cursor
    //   169	243	13	localObject1	Object
    //   419	28	13	localSQLiteException1	SQLiteException
    //   503	1	13	localSQLiteException2	SQLiteException
    //   178	154	14	localObject2	Object
    //   201	141	15	str	String
    //   234	110	16	localzzeu1	zzeu
    //   269	79	17	localzzeu2	zzeu
    //   315	37	18	localzzeu3	zzeu
    // Exception table:
    //   from	to	target	type
    //   24	129	419	android/database/sqlite/SQLiteException
    //   24	129	471	finally
    //   129	137	495	finally
    //   161	191	495	finally
    //   193	393	495	finally
    //   424	451	499	finally
    //   129	137	503	android/database/sqlite/SQLiteException
    //   161	191	503	android/database/sqlite/SQLiteException
    //   193	393	503	android/database/sqlite/SQLiteException
  }
  
  public final int zzj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1177);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzab();
    zzch();
    try
    {
      int i = getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      AppMethodBeat.o(1177);
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(paramString1), zzga().zzbl(paramString2), localSQLiteException);
      AppMethodBeat.o(1177);
    }
    return 0;
  }
  
  /* Error */
  final java.util.Map<Integer, List<zzke>> zzk(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1194
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   10: aload_0
    //   11: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   14: aload_1
    //   15: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   18: pop
    //   19: aload_2
    //   20: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   23: pop
    //   24: new 1378	androidx/b/a
    //   27: dup
    //   28: invokespecial 1379	androidx/b/a:<init>	()V
    //   31: astore 8
    //   33: aload_0
    //   34: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore 5
    //   39: aload 5
    //   41: ldc_w 483
    //   44: iconst_2
    //   45: anewarray 19	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 469
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc_w 478
    //   59: aastore
    //   60: ldc_w 1516
    //   63: iconst_2
    //   64: anewarray 19	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_2
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 5
    //   83: aload 5
    //   85: astore_2
    //   86: aload 5
    //   88: invokeinterface 211 1 0
    //   93: ifne +32 -> 125
    //   96: aload 5
    //   98: astore_2
    //   99: invokestatic 1520	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   102: astore 6
    //   104: aload 5
    //   106: ifnull +10 -> 116
    //   109: aload 5
    //   111: invokeinterface 218 1 0
    //   116: sipush 1194
    //   119: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 6
    //   124: areturn
    //   125: aload 5
    //   127: astore_2
    //   128: aload 5
    //   130: iconst_1
    //   131: invokeinterface 679 2 0
    //   136: astore 6
    //   138: aload 5
    //   140: astore_2
    //   141: aload 6
    //   143: iconst_0
    //   144: aload 6
    //   146: arraylength
    //   147: invokestatic 684	com/google/android/gms/internal/measurement/zzabv:zza	([BII)Lcom/google/android/gms/internal/measurement/zzabv;
    //   150: astore 6
    //   152: aload 5
    //   154: astore_2
    //   155: new 426	com/google/android/gms/internal/measurement/zzke
    //   158: dup
    //   159: invokespecial 1521	com/google/android/gms/internal/measurement/zzke:<init>	()V
    //   162: astore 9
    //   164: aload 5
    //   166: astore_2
    //   167: aload 9
    //   169: aload 6
    //   171: invokevirtual 690	com/google/android/gms/internal/measurement/zzace:zzb	(Lcom/google/android/gms/internal/measurement/zzabv;)Lcom/google/android/gms/internal/measurement/zzace;
    //   174: pop
    //   175: aload 5
    //   177: astore_2
    //   178: aload 5
    //   180: iconst_0
    //   181: invokeinterface 1185 2 0
    //   186: istore_3
    //   187: aload 5
    //   189: astore_2
    //   190: aload 8
    //   192: iload_3
    //   193: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: invokeinterface 1523 2 0
    //   201: checkcast 550	java/util/List
    //   204: astore 7
    //   206: aload 7
    //   208: astore 6
    //   210: aload 7
    //   212: ifnonnull +32 -> 244
    //   215: aload 5
    //   217: astore_2
    //   218: new 547	java/util/ArrayList
    //   221: dup
    //   222: invokespecial 548	java/util/ArrayList:<init>	()V
    //   225: astore 6
    //   227: aload 5
    //   229: astore_2
    //   230: aload 8
    //   232: iload_3
    //   233: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aload 6
    //   238: invokeinterface 1387 3 0
    //   243: pop
    //   244: aload 5
    //   246: astore_2
    //   247: aload 6
    //   249: aload 9
    //   251: invokeinterface 565 2 0
    //   256: pop
    //   257: aload 5
    //   259: astore_2
    //   260: aload 5
    //   262: invokeinterface 1188 1 0
    //   267: istore 4
    //   269: iload 4
    //   271: ifne -146 -> 125
    //   274: aload 5
    //   276: ifnull +10 -> 286
    //   279: aload 5
    //   281: invokeinterface 218 1 0
    //   286: sipush 1194
    //   289: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload 8
    //   294: areturn
    //   295: astore 6
    //   297: aload 5
    //   299: astore_2
    //   300: aload_0
    //   301: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   304: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   307: ldc_w 1525
    //   310: aload_1
    //   311: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: aload 6
    //   316: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   319: goto -62 -> 257
    //   322: astore 6
    //   324: aload 5
    //   326: astore_2
    //   327: aload_0
    //   328: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   331: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   334: ldc_w 545
    //   337: aload_1
    //   338: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   341: aload 6
    //   343: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   346: aload 5
    //   348: ifnull +10 -> 358
    //   351: aload 5
    //   353: invokeinterface 218 1 0
    //   358: sipush 1194
    //   361: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aconst_null
    //   365: areturn
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: aload_2
    //   370: ifnull +9 -> 379
    //   373: aload_2
    //   374: invokeinterface 218 1 0
    //   379: sipush 1194
    //   382: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: goto -19 -> 369
    //   391: astore 6
    //   393: aconst_null
    //   394: astore 5
    //   396: goto -72 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	zzei
    //   0	399	1	paramString1	String
    //   0	399	2	paramString2	String
    //   186	47	3	i	int
    //   267	3	4	bool	boolean
    //   37	358	5	localObject1	Object
    //   102	146	6	localObject2	Object
    //   295	20	6	localIOException	IOException
    //   322	20	6	localSQLiteException1	SQLiteException
    //   391	1	6	localSQLiteException2	SQLiteException
    //   204	7	7	localList	List
    //   31	262	8	locala	androidx.b.a
    //   162	88	9	localzzke	zzke
    // Exception table:
    //   from	to	target	type
    //   167	175	295	java/io/IOException
    //   86	96	322	android/database/sqlite/SQLiteException
    //   99	104	322	android/database/sqlite/SQLiteException
    //   128	138	322	android/database/sqlite/SQLiteException
    //   141	152	322	android/database/sqlite/SQLiteException
    //   155	164	322	android/database/sqlite/SQLiteException
    //   167	175	322	android/database/sqlite/SQLiteException
    //   178	187	322	android/database/sqlite/SQLiteException
    //   190	206	322	android/database/sqlite/SQLiteException
    //   218	227	322	android/database/sqlite/SQLiteException
    //   230	244	322	android/database/sqlite/SQLiteException
    //   247	257	322	android/database/sqlite/SQLiteException
    //   260	269	322	android/database/sqlite/SQLiteException
    //   300	319	322	android/database/sqlite/SQLiteException
    //   39	83	366	finally
    //   86	96	387	finally
    //   99	104	387	finally
    //   128	138	387	finally
    //   141	152	387	finally
    //   155	164	387	finally
    //   167	175	387	finally
    //   178	187	387	finally
    //   190	206	387	finally
    //   218	227	387	finally
    //   230	244	387	finally
    //   247	257	387	finally
    //   260	269	387	finally
    //   300	319	387	finally
    //   327	346	387	finally
    //   39	83	391	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  final java.util.Map<Integer, List<zzkh>> zzl(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1195
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   10: aload_0
    //   11: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   14: aload_1
    //   15: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   18: pop
    //   19: aload_2
    //   20: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   23: pop
    //   24: new 1378	androidx/b/a
    //   27: dup
    //   28: invokespecial 1379	androidx/b/a:<init>	()V
    //   31: astore 8
    //   33: aload_0
    //   34: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore 5
    //   39: aload 5
    //   41: ldc_w 508
    //   44: iconst_2
    //   45: anewarray 19	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 469
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc_w 478
    //   59: aastore
    //   60: ldc_w 1529
    //   63: iconst_2
    //   64: anewarray 19	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_2
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 5
    //   83: aload 5
    //   85: astore_2
    //   86: aload 5
    //   88: invokeinterface 211 1 0
    //   93: ifne +32 -> 125
    //   96: aload 5
    //   98: astore_2
    //   99: invokestatic 1520	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   102: astore 6
    //   104: aload 5
    //   106: ifnull +10 -> 116
    //   109: aload 5
    //   111: invokeinterface 218 1 0
    //   116: sipush 1195
    //   119: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 6
    //   124: areturn
    //   125: aload 5
    //   127: astore_2
    //   128: aload 5
    //   130: iconst_1
    //   131: invokeinterface 679 2 0
    //   136: astore 6
    //   138: aload 5
    //   140: astore_2
    //   141: aload 6
    //   143: iconst_0
    //   144: aload 6
    //   146: arraylength
    //   147: invokestatic 684	com/google/android/gms/internal/measurement/zzabv:zza	([BII)Lcom/google/android/gms/internal/measurement/zzabv;
    //   150: astore 6
    //   152: aload 5
    //   154: astore_2
    //   155: new 498	com/google/android/gms/internal/measurement/zzkh
    //   158: dup
    //   159: invokespecial 1530	com/google/android/gms/internal/measurement/zzkh:<init>	()V
    //   162: astore 9
    //   164: aload 5
    //   166: astore_2
    //   167: aload 9
    //   169: aload 6
    //   171: invokevirtual 690	com/google/android/gms/internal/measurement/zzace:zzb	(Lcom/google/android/gms/internal/measurement/zzabv;)Lcom/google/android/gms/internal/measurement/zzace;
    //   174: pop
    //   175: aload 5
    //   177: astore_2
    //   178: aload 5
    //   180: iconst_0
    //   181: invokeinterface 1185 2 0
    //   186: istore_3
    //   187: aload 5
    //   189: astore_2
    //   190: aload 8
    //   192: iload_3
    //   193: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: invokeinterface 1523 2 0
    //   201: checkcast 550	java/util/List
    //   204: astore 7
    //   206: aload 7
    //   208: astore 6
    //   210: aload 7
    //   212: ifnonnull +32 -> 244
    //   215: aload 5
    //   217: astore_2
    //   218: new 547	java/util/ArrayList
    //   221: dup
    //   222: invokespecial 548	java/util/ArrayList:<init>	()V
    //   225: astore 6
    //   227: aload 5
    //   229: astore_2
    //   230: aload 8
    //   232: iload_3
    //   233: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aload 6
    //   238: invokeinterface 1387 3 0
    //   243: pop
    //   244: aload 5
    //   246: astore_2
    //   247: aload 6
    //   249: aload 9
    //   251: invokeinterface 565 2 0
    //   256: pop
    //   257: aload 5
    //   259: astore_2
    //   260: aload 5
    //   262: invokeinterface 1188 1 0
    //   267: istore 4
    //   269: iload 4
    //   271: ifne -146 -> 125
    //   274: aload 5
    //   276: ifnull +10 -> 286
    //   279: aload 5
    //   281: invokeinterface 218 1 0
    //   286: sipush 1195
    //   289: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload 8
    //   294: areturn
    //   295: astore 6
    //   297: aload 5
    //   299: astore_2
    //   300: aload_0
    //   301: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   304: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   307: ldc_w 1532
    //   310: aload_1
    //   311: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: aload 6
    //   316: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   319: goto -62 -> 257
    //   322: astore 6
    //   324: aload 5
    //   326: astore_2
    //   327: aload_0
    //   328: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   331: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   334: ldc_w 545
    //   337: aload_1
    //   338: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   341: aload 6
    //   343: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   346: aload 5
    //   348: ifnull +10 -> 358
    //   351: aload 5
    //   353: invokeinterface 218 1 0
    //   358: sipush 1195
    //   361: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aconst_null
    //   365: areturn
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: aload_2
    //   370: ifnull +9 -> 379
    //   373: aload_2
    //   374: invokeinterface 218 1 0
    //   379: sipush 1195
    //   382: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: goto -19 -> 369
    //   391: astore 6
    //   393: aconst_null
    //   394: astore 5
    //   396: goto -72 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	zzei
    //   0	399	1	paramString1	String
    //   0	399	2	paramString2	String
    //   186	47	3	i	int
    //   267	3	4	bool	boolean
    //   37	358	5	localObject1	Object
    //   102	146	6	localObject2	Object
    //   295	20	6	localIOException	IOException
    //   322	20	6	localSQLiteException1	SQLiteException
    //   391	1	6	localSQLiteException2	SQLiteException
    //   204	7	7	localList	List
    //   31	262	8	locala	androidx.b.a
    //   162	88	9	localzzkh	zzkh
    // Exception table:
    //   from	to	target	type
    //   167	175	295	java/io/IOException
    //   86	96	322	android/database/sqlite/SQLiteException
    //   99	104	322	android/database/sqlite/SQLiteException
    //   128	138	322	android/database/sqlite/SQLiteException
    //   141	152	322	android/database/sqlite/SQLiteException
    //   155	164	322	android/database/sqlite/SQLiteException
    //   167	175	322	android/database/sqlite/SQLiteException
    //   178	187	322	android/database/sqlite/SQLiteException
    //   190	206	322	android/database/sqlite/SQLiteException
    //   218	227	322	android/database/sqlite/SQLiteException
    //   230	244	322	android/database/sqlite/SQLiteException
    //   247	257	322	android/database/sqlite/SQLiteException
    //   260	269	322	android/database/sqlite/SQLiteException
    //   300	319	322	android/database/sqlite/SQLiteException
    //   39	83	366	finally
    //   86	96	387	finally
    //   99	104	387	finally
    //   128	138	387	finally
    //   141	152	387	finally
    //   155	164	387	finally
    //   167	175	387	finally
    //   178	187	387	finally
    //   190	206	387	finally
    //   218	227	387	finally
    //   230	244	387	finally
    //   247	257	387	finally
    //   260	269	387	finally
    //   300	319	387	finally
    //   327	346	387	finally
    //   39	83	391	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  @VisibleForTesting
  protected final long zzm(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1201
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 294	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 424	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   20: aload_0
    //   21: invokevirtual 421	com/google/android/gms/internal/measurement/zzjq:zzch	()V
    //   24: aload_0
    //   25: invokevirtual 199	com/google/android/gms/internal/measurement/zzei:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore 8
    //   30: aload 8
    //   32: invokevirtual 618	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   35: aload_0
    //   36: new 370	java/lang/StringBuilder
    //   39: dup
    //   40: aload_2
    //   41: invokestatic 373	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokevirtual 377	java/lang/String:length	()I
    //   47: bipush 32
    //   49: iadd
    //   50: invokespecial 379	java/lang/StringBuilder:<init>	(I)V
    //   53: ldc_w 1536
    //   56: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 1538
    //   66: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: iconst_1
    //   73: anewarray 19	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: ldc2_w 488
    //   83: invokespecial 1397	com/google/android/gms/internal/measurement/zzei:zza	(Ljava/lang/String;[Ljava/lang/String;J)J
    //   86: lstore 5
    //   88: lload 5
    //   90: lstore_3
    //   91: lload 5
    //   93: ldc2_w 488
    //   96: lcmp
    //   97: ifne +98 -> 195
    //   100: new 300	android/content/ContentValues
    //   103: dup
    //   104: invokespecial 465	android/content/ContentValues:<init>	()V
    //   107: astore 7
    //   109: aload 7
    //   111: ldc_w 467
    //   114: aload_1
    //   115: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 7
    //   120: ldc_w 1540
    //   123: iconst_0
    //   124: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   130: aload 7
    //   132: ldc 147
    //   134: iconst_0
    //   135: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokevirtual 472	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   141: aload 8
    //   143: ldc_w 1542
    //   146: aconst_null
    //   147: aload 7
    //   149: iconst_5
    //   150: invokevirtual 487	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   153: ldc2_w 488
    //   156: lcmp
    //   157: ifne +36 -> 193
    //   160: aload_0
    //   161: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   164: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   167: ldc_w 1544
    //   170: aload_1
    //   171: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   174: aload_2
    //   175: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   178: aload 8
    //   180: invokevirtual 621	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   183: sipush 1201
    //   186: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: ldc2_w 488
    //   192: lreturn
    //   193: lconst_0
    //   194: lstore_3
    //   195: new 300	android/content/ContentValues
    //   198: dup
    //   199: invokespecial 465	android/content/ContentValues:<init>	()V
    //   202: astore 7
    //   204: aload 7
    //   206: ldc_w 467
    //   209: aload_1
    //   210: invokevirtual 304	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 7
    //   215: aload_2
    //   216: lconst_1
    //   217: lload_3
    //   218: ladd
    //   219: invokestatic 271	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   222: invokevirtual 307	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   225: aload 8
    //   227: ldc_w 1542
    //   230: aload 7
    //   232: ldc_w 835
    //   235: iconst_1
    //   236: anewarray 19	java/lang/String
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokevirtual 731	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   246: i2l
    //   247: lconst_0
    //   248: lcmp
    //   249: ifne +36 -> 285
    //   252: aload_0
    //   253: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   256: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   259: ldc_w 1546
    //   262: aload_1
    //   263: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   266: aload_2
    //   267: invokevirtual 241	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   270: aload 8
    //   272: invokevirtual 621	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   275: sipush 1201
    //   278: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: ldc2_w 488
    //   284: lreturn
    //   285: aload 8
    //   287: invokevirtual 627	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   290: aload 8
    //   292: invokevirtual 621	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   295: sipush 1201
    //   298: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: lload_3
    //   302: lreturn
    //   303: astore 7
    //   305: lconst_0
    //   306: lstore_3
    //   307: aload_0
    //   308: invokevirtual 227	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   311: invokevirtual 233	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   314: ldc_w 1548
    //   317: aload_1
    //   318: invokestatic 439	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   321: aload_2
    //   322: aload 7
    //   324: invokevirtual 447	com/google/android/gms/internal/measurement/zzfi:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   327: aload 8
    //   329: invokevirtual 621	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   332: goto -37 -> 295
    //   335: astore_1
    //   336: aload 8
    //   338: invokevirtual 621	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   341: sipush 1201
    //   344: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_1
    //   348: athrow
    //   349: astore 7
    //   351: goto -44 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	zzei
    //   0	354	1	paramString1	String
    //   0	354	2	paramString2	String
    //   90	217	3	l1	long
    //   86	6	5	l2	long
    //   107	124	7	localContentValues	ContentValues
    //   303	20	7	localSQLiteException1	SQLiteException
    //   349	1	7	localSQLiteException2	SQLiteException
    //   28	309	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   35	88	303	android/database/sqlite/SQLiteException
    //   100	178	303	android/database/sqlite/SQLiteException
    //   35	88	335	finally
    //   100	178	335	finally
    //   195	270	335	finally
    //   285	290	335	finally
    //   307	327	335	finally
    //   195	270	349	android/database/sqlite/SQLiteException
    //   285	290	349	android/database/sqlite/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzei
 * JD-Core Version:    0.7.0.1
 */