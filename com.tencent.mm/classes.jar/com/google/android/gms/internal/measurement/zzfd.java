package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class zzfd
  extends SQLiteOpenHelper
{
  zzfd(zzfc paramzzfc, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    AppMethodBeat.i(1352);
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = super.getWritableDatabase();
      AppMethodBeat.o(1352);
      return localSQLiteDatabase1;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      AppMethodBeat.o(1352);
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
        AppMethodBeat.o(1352);
        return localSQLiteDatabase2;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zzaii.zzge().zzim().zzg("Failed to open local database. Events will bypass local storage", localSQLiteException2);
        AppMethodBeat.o(1352);
      }
    }
    return null;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(1354);
    zzei.zza(this.zzaii.zzge(), paramSQLiteDatabase);
    AppMethodBeat.o(1354);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 1353
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 94	android/os/Build$VERSION:SDK_INT	I
    //   11: bipush 15
    //   13: if_icmpge +28 -> 41
    //   16: aload_1
    //   17: ldc 96
    //   19: aconst_null
    //   20: invokevirtual 102	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 107 1 0
    //   30: pop
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: invokeinterface 111 1 0
    //   41: aload_0
    //   42: getfield 10	com/google/android/gms/internal/measurement/zzfd:zzaii	Lcom/google/android/gms/internal/measurement/zzfc;
    //   45: invokevirtual 37	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   48: aload_1
    //   49: ldc 113
    //   51: ldc 115
    //   53: ldc 117
    //   55: aconst_null
    //   56: invokestatic 120	com/google/android/gms/internal/measurement/zzei:zza	(Lcom/google/android/gms/internal/measurement/zzfg;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   59: sipush 1353
    //   62: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull +9 -> 77
    //   71: aload_2
    //   72: invokeinterface 111 1 0
    //   77: sipush 1353
    //   80: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_3
    //   87: astore_2
    //   88: goto -21 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	zzfd
    //   0	91	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	87	2	localObject	java.lang.Object
    //   23	64	3	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   16	24	66	finally
    //   24	31	85	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfd
 * JD-Core Version:    0.7.0.1
 */