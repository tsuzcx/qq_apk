package com.tencent.mm.platformtools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public final class y
{
  private static final y pBv;
  public static AtomicBoolean pBw;
  public com.tencent.mm.storagebase.f pBx;
  
  static
  {
    AppMethodBeat.i(234059);
    pBv = new y();
    pBw = new AtomicBoolean(true);
    AppMethodBeat.o(234059);
  }
  
  public static int a(com.tencent.mm.storagebase.f paramf)
  {
    AppMethodBeat.i(234052);
    Cursor localCursor = paramf.rawQuery("select count(id) from ImgInfo2", null, 0);
    try
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(234052);
      return i;
    }
    finally
    {
      if (localCursor == null) {}
    }
    try
    {
      localCursor.close();
      AppMethodBeat.o(234052);
      throw paramf;
    }
    finally
    {
      paramf.addSuppressed(localThrowable);
    }
  }
  
  public static boolean a(com.tencent.mm.storagebase.f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234047);
    Object localObject = null;
    try
    {
      paramf.execSQL("DROP INDEX ".concat(String.valueOf(paramString1)));
      paramf = localObject;
    }
    catch (Exception paramf)
    {
      for (;;)
      {
        Log.e("TableIndexFixer", "DROP INDEX, failure! indexName=%s %s", new Object[] { paramString1, paramf });
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1457L, 0L, 1L, true);
        com.tencent.mm.plugin.report.f.Ozc.b(20708, new Object[] { "1", Integer.valueOf(0), paramf.getMessage() + " indexName=" + paramString1 });
      }
      AppMethodBeat.o(234047);
    }
    if (paramf == null) {
      Log.i("TableIndexFixer", "DROP INDEX, successfully! indexName=%s, tblName=%s", new Object[] { paramString1, paramString2 });
    }
    if (paramf == null)
    {
      AppMethodBeat.o(234047);
      return true;
    }
    return false;
  }
  
  public static boolean a(com.tencent.mm.storagebase.f paramf, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(234049);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("TableIndexFixer", "[createIndex] rightTblName is wrong.");
      AppMethodBeat.o(234049);
      return false;
    }
    Object localObject = null;
    paramString1 = paramString3.replaceAll(paramString2, paramString1);
    try
    {
      paramf.execSQL(paramString1);
      paramf = localObject;
    }
    catch (Exception paramf)
    {
      for (;;)
      {
        Log.e("TableIndexFixer", "CREATE INDEX, failure! sql=%s %s", new Object[] { paramString1, paramf });
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1457L, 5L, 1L, true);
        com.tencent.mm.plugin.report.f.Ozc.b(20708, new Object[] { "1", Integer.valueOf(4), paramf.getMessage() + "sql=" + paramString1 });
      }
      AppMethodBeat.o(234049);
    }
    if (paramf == null) {
      Log.i("TableIndexFixer", "CREATE INDEX, successfully! %s => %s", new Object[] { paramString3, paramString1 });
    }
    if (paramf == null)
    {
      AppMethodBeat.o(234049);
      return true;
    }
    return false;
  }
  
  public static boolean a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234044);
    if (paramString1.startsWith("sqlite_"))
    {
      AppMethodBeat.o(234044);
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(234044);
      return false;
    }
    if (paramString1.startsWith(paramString2))
    {
      AppMethodBeat.o(234044);
      return false;
    }
    int i = 0;
    while (i < 2)
    {
      if (paramString2.equalsIgnoreCase(paramArrayOfString[i]))
      {
        AppMethodBeat.o(234044);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(234044);
    return false;
  }
  
  public static int b(com.tencent.mm.storagebase.f paramf)
  {
    AppMethodBeat.i(234056);
    Cursor localCursor = paramf.rawQuery("select count(filename) from videoinfo2", null, 0);
    try
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(234056);
      return i;
    }
    finally
    {
      if (localCursor == null) {}
    }
    try
    {
      localCursor.close();
      AppMethodBeat.o(234056);
      throw paramf;
    }
    finally
    {
      paramf.addSuppressed(localThrowable);
    }
  }
  
  public static y bTN()
  {
    return pBv;
  }
  
  public static String d(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(234041);
    int i = 0;
    while (i < 2)
    {
      if (paramArrayOfString1[i].equalsIgnoreCase(paramString))
      {
        paramString = paramArrayOfString2[i];
        AppMethodBeat.o(234041);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(234041);
    return "";
  }
  
  public final class a
  {
    public String sql;
    public String table;
    
    public a(String paramString1, String paramString2)
    {
      this.table = paramString1;
      this.sql = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.y
 * JD-Core Version:    0.7.0.1
 */