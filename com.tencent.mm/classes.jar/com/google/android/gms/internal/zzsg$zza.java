package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class zzsg$zza
  extends SQLiteOpenHelper
{
  zzsg$zza(zzsg paramzzsg, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  private void zza(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 1;
    Set localSet = zzb(paramSQLiteDatabase, "hits2");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "hit_id", "hit_string", "hit_time", "hit_url" }[i];
      if (!localSet.remove(str))
      {
        paramSQLiteDatabase = String.valueOf(str);
        if (paramSQLiteDatabase.length() != 0) {}
        for (paramSQLiteDatabase = "Database hits2 is missing required column: ".concat(paramSQLiteDatabase);; paramSQLiteDatabase = new String("Database hits2 is missing required column: ")) {
          throw new SQLiteException(paramSQLiteDatabase);
        }
      }
      i += 1;
    }
    if (!localSet.remove("hit_app_id")) {}
    for (i = j; !localSet.isEmpty(); i = 0) {
      throw new SQLiteException("Database hits2 has extra columns");
    }
    if (i != 0) {
      paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
    }
  }
  
  /* Error */
  private boolean zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ldc 78
    //   6: iconst_1
    //   7: anewarray 26	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 80
    //   14: aastore
    //   15: ldc 82
    //   17: iconst_1
    //   18: anewarray 26	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_2
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 86	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: astore 4
    //   35: aload 4
    //   37: astore_1
    //   38: aload 4
    //   40: invokeinterface 91 1 0
    //   45: istore_3
    //   46: aload 4
    //   48: ifnull +10 -> 58
    //   51: aload 4
    //   53: invokeinterface 95 1 0
    //   58: iload_3
    //   59: ireturn
    //   60: astore 5
    //   62: aconst_null
    //   63: astore 4
    //   65: aload 4
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 13	com/google/android/gms/internal/zzsg$zza:zzaez	Lcom/google/android/gms/internal/zzsg;
    //   72: ldc 97
    //   74: aload_2
    //   75: aload 5
    //   77: invokevirtual 101	com/google/android/gms/internal/zzsg:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   80: aload 4
    //   82: ifnull +10 -> 92
    //   85: aload 4
    //   87: invokeinterface 95 1 0
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aload 4
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +9 -> 108
    //   102: aload_2
    //   103: invokeinterface 95 1 0
    //   108: aload_1
    //   109: athrow
    //   110: astore 4
    //   112: aload_1
    //   113: astore_2
    //   114: aload 4
    //   116: astore_1
    //   117: goto -19 -> 98
    //   120: astore 5
    //   122: goto -57 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	zza
    //   0	125	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	125	2	paramString	String
    //   45	14	3	bool	boolean
    //   1	95	4	localSQLiteDatabase	SQLiteDatabase
    //   110	5	4	localObject	Object
    //   60	16	5	localSQLiteException1	SQLiteException
    //   120	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   3	32	60	android/database/sqlite/SQLiteException
    //   3	32	94	finally
    //   38	46	110	finally
    //   68	80	110	finally
    //   38	46	120	android/database/sqlite/SQLiteException
  }
  
  private Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = new HashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(String.valueOf(paramString).length() + 22 + "SELECT * FROM " + paramString + " LIMIT 0", null);
    try
    {
      paramString = paramSQLiteDatabase.getColumnNames();
      int i = 0;
      while (i < paramString.length)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
      return localHashSet;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  private void zzb(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    paramSQLiteDatabase = zzb(paramSQLiteDatabase, "properties");
    while (i < 6)
    {
      String str = new String[] { "app_uid", "cid", "tid", "params", "adid", "hits_count" }[i];
      if (!paramSQLiteDatabase.remove(str))
      {
        paramSQLiteDatabase = String.valueOf(str);
        if (paramSQLiteDatabase.length() != 0) {}
        for (paramSQLiteDatabase = "Database properties is missing required column: ".concat(paramSQLiteDatabase);; paramSQLiteDatabase = new String("Database properties is missing required column: ")) {
          throw new SQLiteException(paramSQLiteDatabase);
        }
      }
      i += 1;
    }
    if (!paramSQLiteDatabase.isEmpty()) {
      throw new SQLiteException("Database properties table has extra columns");
    }
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    if (!zzsg.zza(this.zzaez).zzA(3600000L)) {
      throw new SQLiteException("Database open failed");
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException1)
    {
      zzsg.zza(this.zzaez).start();
      this.zzaez.zzbT("Opening the database failed, dropping the table and recreating it");
      Object localObject = zzsg.zzb(this.zzaez);
      this.zzaez.getContext().getDatabasePath((String)localObject).delete();
      try
      {
        localObject = super.getWritableDatabase();
        zzsg.zza(this.zzaez).clear();
        return localObject;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zzaez.zze("Failed to open freshly created database", localSQLiteException2);
        throw localSQLiteException2;
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzsv.zzca(paramSQLiteDatabase.getPath());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor;
    if (Build.VERSION.SDK_INT < 15) {
      localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
    }
    for (;;)
    {
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!zza(paramSQLiteDatabase, "hits2"))
        {
          paramSQLiteDatabase.execSQL(zzsg.zzox());
          if (zza(paramSQLiteDatabase, "properties")) {
            break;
          }
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      zza(paramSQLiteDatabase);
    }
    zzb(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzsg.zza
 * JD-Core Version:    0.7.0.1
 */