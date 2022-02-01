package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

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
  
  @Nullable
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5174);
    paramCursor = getIntegerFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5174);
    return paramCursor;
  }
  
  @Nullable
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt, @Nullable Integer paramInteger)
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
  
  @Nullable
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5176);
    paramCursor = getLongFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5176);
    return paramCursor;
  }
  
  @Nullable
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt, @Nullable Long paramLong)
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
  
  @Nullable
  public static String getStringFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(5178);
    paramCursor = getStringFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(5178);
    return paramCursor;
  }
  
  @Nullable
  public static String getStringFromCursor(Cursor paramCursor, int paramInt, @Nullable String paramString)
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
  
  public static void putIntegerIntoContentValues(ContentValues paramContentValues, String paramString, @Nullable Integer paramInteger)
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
  
  public static void putLongIntoContentValues(ContentValues paramContentValues, String paramString, @Nullable Long paramLong)
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
  
  public static void putStringIntoContentValues(ContentValues paramContentValues, String paramString1, @Nullable String paramString2)
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
  
  /* Error */
  private static void zza(SQLiteDatabase paramSQLiteDatabase, String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 5172
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 19
    //   11: aload_1
    //   12: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +21 -> 36
    //   18: ldc 33
    //   20: aload_1
    //   21: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +12 -> 36
    //   27: ldc 31
    //   29: aload_1
    //   30: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +169 -> 202
    //   36: iconst_1
    //   37: istore_3
    //   38: iload_3
    //   39: invokestatic 176	com/google/android/gms/common/internal/Preconditions:checkArgument	(Z)V
    //   42: aload_0
    //   43: ldc 178
    //   45: iconst_1
    //   46: anewarray 21	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc 180
    //   53: aastore
    //   54: ldc 182
    //   56: iconst_1
    //   57: anewarray 21	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 188	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 5
    //   72: aload_2
    //   73: invokestatic 194	com/google/android/gms/common/util/CollectionUtils:setOf	([Ljava/lang/Object;)Ljava/util/Set;
    //   76: astore_2
    //   77: aload 5
    //   79: invokeinterface 198 1 0
    //   84: ifeq +123 -> 207
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 67 2 0
    //   95: astore 6
    //   97: aload_2
    //   98: aload 6
    //   100: invokeinterface 203 2 0
    //   105: ifne -28 -> 77
    //   108: aload_0
    //   109: new 205	java/lang/StringBuilder
    //   112: dup
    //   113: aload_1
    //   114: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 95	java/lang/String:length	()I
    //   120: bipush 8
    //   122: iadd
    //   123: aload 6
    //   125: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokevirtual 95	java/lang/String:length	()I
    //   131: iadd
    //   132: invokespecial 207	java/lang/StringBuilder:<init>	(I)V
    //   135: ldc 209
    //   137: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 215
    //   146: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 217
    //   156: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 224	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   165: goto -88 -> 77
    //   168: astore_1
    //   169: sipush 5172
    //   172: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_1
    //   176: athrow
    //   177: astore_0
    //   178: aload 5
    //   180: ifnull +14 -> 194
    //   183: aload_1
    //   184: ifnull +51 -> 235
    //   187: aload 5
    //   189: invokeinterface 227 1 0
    //   194: sipush 5172
    //   197: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_0
    //   201: athrow
    //   202: iconst_0
    //   203: istore_3
    //   204: goto -166 -> 38
    //   207: aload 5
    //   209: ifnull +36 -> 245
    //   212: aload 5
    //   214: invokeinterface 227 1 0
    //   219: sipush 5172
    //   222: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: return
    //   226: astore_2
    //   227: aload_1
    //   228: aload_2
    //   229: invokestatic 232	com/google/android/gms/internal/stable/zzk:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   232: goto -38 -> 194
    //   235: aload 5
    //   237: invokeinterface 227 1 0
    //   242: goto -48 -> 194
    //   245: sipush 5172
    //   248: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_0
    //   253: aload 4
    //   255: astore_1
    //   256: goto -78 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	259	1	paramString	String
    //   0	259	2	paramVarArgs	String[]
    //   37	167	3	bool	boolean
    //   1	253	4	localObject	Object
    //   70	166	5	localCursor	Cursor
    //   95	55	6	str	String
    // Exception table:
    //   from	to	target	type
    //   72	77	168	java/lang/Throwable
    //   77	165	168	java/lang/Throwable
    //   169	177	177	finally
    //   187	194	226	java/lang/Throwable
    //   72	77	252	finally
    //   77	165	252	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.DbUtils
 * JD-Core Version:    0.7.0.1
 */