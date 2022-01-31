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
    AppMethodBeat.i(90149);
    zza(paramSQLiteDatabase, "table", new String[] { "sqlite_sequence", "android_metadata" });
    zza(paramSQLiteDatabase, "trigger", new String[0]);
    zza(paramSQLiteDatabase, "view", new String[0]);
    AppMethodBeat.o(90149);
  }
  
  public static long countCurrentRowBytes(Cursor paramCursor)
  {
    AppMethodBeat.i(90162);
    long l = countCurrentRowBytes(paramCursor, Charset.forName("UTF-8"));
    AppMethodBeat.o(90162);
    return l;
  }
  
  public static long countCurrentRowBytes(Cursor paramCursor, Charset paramCharset)
  {
    AppMethodBeat.i(90161);
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
    AppMethodBeat.o(90161);
    return l;
  }
  
  public static long getDatabaseSize(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90160);
    try
    {
      paramContext = paramContext.getDatabasePath(paramString);
      if (paramContext == null) {
        break label47;
      }
      long l = paramContext.length();
      AppMethodBeat.o(90160);
      return l;
    }
    catch (SecurityException paramContext)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() == 0) {
        break label54;
      }
    }
    "Failed to get db size for ".concat(paramContext);
    for (;;)
    {
      label47:
      AppMethodBeat.o(90160);
      return 0L;
      label54:
      new String("Failed to get db size for ");
    }
  }
  
  @Nullable
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(90152);
    paramCursor = getIntegerFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(90152);
    return paramCursor;
  }
  
  @Nullable
  public static Integer getIntegerFromCursor(Cursor paramCursor, int paramInt, @Nullable Integer paramInteger)
  {
    AppMethodBeat.i(90151);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(90151);
      return paramInteger;
    }
    paramInt = paramCursor.getInt(paramInt);
    AppMethodBeat.o(90151);
    return Integer.valueOf(paramInt);
  }
  
  @Nullable
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(90154);
    paramCursor = getLongFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(90154);
    return paramCursor;
  }
  
  @Nullable
  public static Long getLongFromCursor(Cursor paramCursor, int paramInt, @Nullable Long paramLong)
  {
    AppMethodBeat.i(90153);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(90153);
      return paramLong;
    }
    long l = paramCursor.getLong(paramInt);
    AppMethodBeat.o(90153);
    return Long.valueOf(l);
  }
  
  @Nullable
  public static String getStringFromCursor(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(90156);
    paramCursor = getStringFromCursor(paramCursor, paramInt, null);
    AppMethodBeat.o(90156);
    return paramCursor;
  }
  
  @Nullable
  public static String getStringFromCursor(Cursor paramCursor, int paramInt, @Nullable String paramString)
  {
    AppMethodBeat.i(90155);
    if ((paramInt < 0) || (paramCursor.isNull(paramInt)))
    {
      AppMethodBeat.o(90155);
      return paramString;
    }
    paramCursor = paramCursor.getString(paramInt);
    AppMethodBeat.o(90155);
    return paramCursor;
  }
  
  public static void putIntegerIntoContentValues(ContentValues paramContentValues, String paramString, @Nullable Integer paramInteger)
  {
    AppMethodBeat.i(90157);
    if (paramInteger != null)
    {
      paramContentValues.put(paramString, paramInteger);
      AppMethodBeat.o(90157);
      return;
    }
    paramContentValues.putNull(paramString);
    AppMethodBeat.o(90157);
  }
  
  public static void putLongIntoContentValues(ContentValues paramContentValues, String paramString, @Nullable Long paramLong)
  {
    AppMethodBeat.i(90158);
    if (paramLong != null)
    {
      paramContentValues.put(paramString, paramLong);
      AppMethodBeat.o(90158);
      return;
    }
    paramContentValues.putNull(paramString);
    AppMethodBeat.o(90158);
  }
  
  public static void putStringIntoContentValues(ContentValues paramContentValues, String paramString1, @Nullable String paramString2)
  {
    AppMethodBeat.i(90159);
    if (paramString2 != null)
    {
      paramContentValues.put(paramString1, paramString2);
      AppMethodBeat.o(90159);
      return;
    }
    paramContentValues.putNull(paramString1);
    AppMethodBeat.o(90159);
  }
  
  /* Error */
  private static void zza(SQLiteDatabase paramSQLiteDatabase, String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 180
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 20
    //   10: aload_1
    //   11: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +21 -> 35
    //   17: ldc 34
    //   19: aload_1
    //   20: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +12 -> 35
    //   26: ldc 32
    //   28: aload_1
    //   29: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +167 -> 199
    //   35: iconst_1
    //   36: istore_3
    //   37: iload_3
    //   38: invokestatic 190	com/google/android/gms/common/internal/Preconditions:checkArgument	(Z)V
    //   41: aload_0
    //   42: ldc 192
    //   44: iconst_1
    //   45: anewarray 22	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc 194
    //   52: aastore
    //   53: ldc 196
    //   55: iconst_1
    //   56: anewarray 22	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: invokevirtual 202	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore 5
    //   71: aload_2
    //   72: invokestatic 208	com/google/android/gms/common/util/CollectionUtils:setOf	([Ljava/lang/Object;)Ljava/util/Set;
    //   75: astore_2
    //   76: aload 5
    //   78: invokeinterface 212 1 0
    //   83: ifeq +121 -> 204
    //   86: aload 5
    //   88: iconst_0
    //   89: invokeinterface 70 2 0
    //   94: astore 6
    //   96: aload_2
    //   97: aload 6
    //   99: invokeinterface 217 2 0
    //   104: ifne -28 -> 76
    //   107: aload_0
    //   108: new 219	java/lang/StringBuilder
    //   111: dup
    //   112: aload_1
    //   113: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 99	java/lang/String:length	()I
    //   119: bipush 8
    //   121: iadd
    //   122: aload 6
    //   124: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokevirtual 99	java/lang/String:length	()I
    //   130: iadd
    //   131: invokespecial 221	java/lang/StringBuilder:<init>	(I)V
    //   134: ldc 223
    //   136: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 229
    //   145: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 231
    //   155: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 238	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   164: goto -88 -> 76
    //   167: astore_1
    //   168: ldc 180
    //   170: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: aload 5
    //   178: ifnull +14 -> 192
    //   181: aload_1
    //   182: ifnull +49 -> 231
    //   185: aload 5
    //   187: invokeinterface 241 1 0
    //   192: ldc 180
    //   194: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_0
    //   198: athrow
    //   199: iconst_0
    //   200: istore_3
    //   201: goto -164 -> 37
    //   204: aload 5
    //   206: ifnull +35 -> 241
    //   209: aload 5
    //   211: invokeinterface 241 1 0
    //   216: ldc 180
    //   218: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: astore_2
    //   223: aload_1
    //   224: aload_2
    //   225: invokestatic 246	com/google/android/gms/internal/stable/zzk:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   228: goto -36 -> 192
    //   231: aload 5
    //   233: invokeinterface 241 1 0
    //   238: goto -46 -> 192
    //   241: ldc 180
    //   243: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: return
    //   247: astore_0
    //   248: aload 4
    //   250: astore_1
    //   251: goto -75 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	254	1	paramString	String
    //   0	254	2	paramVarArgs	String[]
    //   36	165	3	bool	boolean
    //   1	248	4	localObject	Object
    //   69	163	5	localCursor	Cursor
    //   94	55	6	str	String
    // Exception table:
    //   from	to	target	type
    //   71	76	167	java/lang/Throwable
    //   76	164	167	java/lang/Throwable
    //   168	175	175	finally
    //   185	192	222	java/lang/Throwable
    //   71	76	247	finally
    //   76	164	247	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.util.DbUtils
 * JD-Core Version:    0.7.0.1
 */