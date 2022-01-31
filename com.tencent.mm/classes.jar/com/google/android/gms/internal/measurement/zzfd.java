package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

@VisibleForTesting
final class zzfd
  extends SQLiteOpenHelper
{
  zzfd(zzfc paramzzfc, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    AppMethodBeat.i(68829);
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = super.getWritableDatabase();
      AppMethodBeat.o(68829);
      return localSQLiteDatabase1;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      AppMethodBeat.o(68829);
      throw localSQLiteDatabaseLockedException;
    }
    catch (SQLiteException localSQLiteException1)
    {
      this.zzaii.zzge().zzim().log("Opening the local database failed, dropping and recreating it");
      if (!this.zzaii.getContext().getDatabasePath("google_app_measurement_local.db").delete()) {
        this.zzaii.zzge().zzim().zzg("Failed to delete corrupted local db file", "google_app_measurement_local.db");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        AppMethodBeat.o(68829);
        return localSQLiteDatabase2;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zzaii.zzge().zzim().zzg("Failed to open local database. Events will bypass local storage", localSQLiteException2);
        AppMethodBeat.o(68829);
      }
    }
    return null;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(68831);
    zzei.zza(this.zzaii.zzge(), paramSQLiteDatabase);
    AppMethodBeat.o(68831);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 92
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 98	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 15
    //   12: if_icmpge +28 -> 40
    //   15: aload_1
    //   16: ldc 100
    //   18: aconst_null
    //   19: invokevirtual 106	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 111 1 0
    //   29: pop
    //   30: aload_3
    //   31: ifnull +9 -> 40
    //   34: aload_3
    //   35: invokeinterface 115 1 0
    //   40: aload_0
    //   41: getfield 11	com/google/android/gms/internal/measurement/zzfd:zzaii	Lcom/google/android/gms/internal/measurement/zzfc;
    //   44: invokevirtual 39	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   47: aload_1
    //   48: ldc 117
    //   50: ldc 119
    //   52: ldc 121
    //   54: aconst_null
    //   55: invokestatic 124	com/google/android/gms/internal/measurement/zzei:zza	(Lcom/google/android/gms/internal/measurement/zzfg;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   58: ldc 92
    //   60: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: aload_2
    //   66: ifnull +9 -> 75
    //   69: aload_2
    //   70: invokeinterface 115 1 0
    //   75: ldc 92
    //   77: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_3
    //   84: astore_2
    //   85: goto -20 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	zzfd
    //   0	88	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	84	2	localObject	java.lang.Object
    //   22	62	3	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   15	23	64	finally
    //   23	30	82	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfd
 * JD-Core Version:    0.7.0.1
 */