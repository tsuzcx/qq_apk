package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.stable.zzk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

public final class DbUtils
{
  public static void clearDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(5171);
    zza(paramSQLiteDatabase, "table", new String[] { "sqlite_sequence", "android_metadata" });
    zza(paramSQLiteDatabase, "trigger", new String[0]);
    zza(paramSQLiteDatabase, "view", new String[0]);
    AppMethodBeat.o(5171);
  }
  
  public static long countCurrentRowBytes(Cursor paramCursor)
  {
    AppMethodBeat.i(5184);
    long l = countCurrentRowBytes(paramCursor, Charset.forName("UTF-8"));
    AppMethodBeat.o(5184);
    return l;
  }
  
  public static long countCurrentRowBytes(Cursor paramCursor, Charset paramCharset)
  {
    AppMethodBeat.i(5183);
    long l = 0L;
    int i = 0;
    if (i < paramCursor.getColumnCount())
    {
      switch (paramCursor.getType(i))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        l += paramCursor.getBlob(i).length;
        continue;
        l += paramCursor.getString(i).getBytes(paramCharset).length;
        continue;
        l += 4L;
      }
    }
    AppMethodBeat.o(5183);
    return l;
  }
  
  public static long getDatabaseSize(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5182);
    try
    {
      paramContext = paramContext.getDatabasePath(paramString);
      if (paramContext == null) {
        break label49;
      }
      long l = paramContext.length();
      AppMethodBeat.o(5182);
      return l;
    }
    catch (SecurityException paramContext)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() == 0) {
        break label57;
      }
    }
    "Failed to get db size for ".concat(paramContext);
    for (;;)
    {
      label49:
      AppMethodBeat.o(5182);
      return 0L;
      label57:
      new String("Failed to get db size for ");
    }
  }
  
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5174);
    paramCursor = getIntegerFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5174);
    return paramCursor;
  }
  
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt, Integer paramInteger)
  {
    AppMethodBeat.i(5173);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(5173);
      return paramInteger;
    }
    paramInt = paramCursor.getInt(paramInt);
    AppMethodBeat.o(5173);
    return Integer.valueOf(paramInt);
  }
  
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5176);
    paramCursor = getLongFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5176);
    return paramCursor;
  }
  
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt, Long paramLong)
  {
    AppMethodBeat.i(5175);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(5175);
      return paramLong;
    }
    long l = paramCursor.getLong(paramInt);
    AppMethodBeat.o(5175);
    return Long.valueOf(l);
  }
  
  public static String getStringFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5178);
    paramCursor = getStringFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5178);
    return paramCursor;
  }
  
  public static String getStringFromCursor(Cursor paramCursor, int paramInt, String paramString)
  {
    AppMethodBeat.i(5177);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(5177);
      return paramString;
    }
    paramCursor = paramCursor.getString(paramInt);
    AppMethodBeat.o(5177);
    return paramCursor;
  }
  
  public static void putIntegerIntoContentValues(ContentValues paramContentValues, String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(5179);
    if (paramInteger != null)
    {
      paramContentValues.put(paramString, paramInteger);
      AppMethodBeat.o(5179);
      return;
    }
    paramContentValues.putNull(paramString);
    AppMethodBeat.o(5179);
  }
  
  public static void putLongIntoContentValues(ContentValues paramContentValues, String paramString, Long paramLong)
  {
    AppMethodBeat.i(5180);
    if (paramLong != null)
    {
      paramContentValues.put(paramString, paramLong);
      AppMethodBeat.o(5180);
      return;
    }
    paramContentValues.putNull(paramString);
    AppMethodBeat.o(5180);
  }
  
  public static void putStringIntoContentValues(ContentValues paramContentValues, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5181);
    if (paramString2 != null)
    {
      paramContentValues.put(paramString1, paramString2);
      AppMethodBeat.o(5181);
      return;
    }
    paramContentValues.putNull(paramString1);
    AppMethodBeat.o(5181);
  }
  
  private static void zza(SQLiteDatabase paramSQLiteDatabase, String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(5172);
    boolean bool;
    Cursor localCursor;
    if (("table".equals(paramString)) || ("view".equals(paramString)) || ("trigger".equals(paramString)))
    {
      bool = true;
      for (;;)
      {
        Preconditions.checkArgument(bool);
        localCursor = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "type == ?", new String[] { paramString }, null, null, null);
        try
        {
          paramVarArgs = CollectionUtils.setOf(paramVarArgs);
          while (localCursor.moveToNext())
          {
            String str = localCursor.getString(0);
            if (!paramVarArgs.contains(str)) {
              paramSQLiteDatabase.execSQL(String.valueOf(paramString).length() + 8 + String.valueOf(str).length() + "DROP " + paramString + " '" + str + "'");
            }
          }
          try
          {
            localCursor.close();
            AppMethodBeat.o(5172);
            throw paramString;
            bool = false;
            continue;
            if (localCursor == null) {
              break label242;
            }
            localCursor.close();
            AppMethodBeat.o(5172);
            return;
          }
          finally
          {
            for (;;)
            {
              zzk.zza(paramSQLiteDatabase, paramVarArgs);
            }
          }
        }
        finally
        {
          try
          {
            AppMethodBeat.o(5172);
            throw paramSQLiteDatabase;
          }
          finally
          {
            if (localCursor == null) {}
          }
        }
      }
    }
    for (;;)
    {
      localCursor.close();
    }
    label242:
    AppMethodBeat.o(5172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.DbUtils
 * JD-Core Version:    0.7.0.1
 */