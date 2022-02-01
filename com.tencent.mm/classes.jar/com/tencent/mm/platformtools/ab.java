package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ab
{
  private static final ab jNL;
  public static AtomicBoolean jNM;
  public f jNN;
  
  static
  {
    AppMethodBeat.i(197123);
    jNL = new ab();
    jNM = new AtomicBoolean(true);
    AppMethodBeat.o(197123);
  }
  
  /* Error */
  public static int a(f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 43
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 45
    //   10: aconst_null
    //   11: iconst_0
    //   12: invokevirtual 51	com/tencent/mm/storagebase/f:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 57 1 0
    //   22: pop
    //   23: aload_3
    //   24: iconst_0
    //   25: invokeinterface 61 2 0
    //   30: istore_1
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: invokeinterface 64 1 0
    //   41: ldc 43
    //   43: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iload_1
    //   47: ireturn
    //   48: astore_2
    //   49: ldc 43
    //   51: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_2
    //   55: athrow
    //   56: astore_0
    //   57: aload_3
    //   58: ifnull +13 -> 71
    //   61: aload_2
    //   62: ifnull +25 -> 87
    //   65: aload_3
    //   66: invokeinterface 64 1 0
    //   71: ldc 43
    //   73: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_3
    //   79: aload_2
    //   80: aload_3
    //   81: invokevirtual 68	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   84: goto -13 -> 71
    //   87: aload_3
    //   88: invokeinterface 64 1 0
    //   93: goto -22 -> 71
    //   96: astore_0
    //   97: goto -40 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramf	f
    //   30	17	1	i	int
    //   1	1	2	localObject	Object
    //   48	32	2	localThrowable1	java.lang.Throwable
    //   15	51	3	localCursor	android.database.Cursor
    //   78	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   16	31	48	java/lang/Throwable
    //   49	56	56	finally
    //   65	71	78	java/lang/Throwable
    //   16	31	96	finally
  }
  
  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(197117);
    int i = 0;
    while (i < 2)
    {
      if (paramArrayOfString1[i].equalsIgnoreCase(paramString))
      {
        paramString = paramArrayOfString2[i];
        AppMethodBeat.o(197117);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(197117);
    return "";
  }
  
  public static boolean a(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197119);
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
        e.Cxv.idkeyStat(1457L, 0L, 1L, true);
        e.Cxv.a(20708, new Object[] { "1", Integer.valueOf(0), paramf.getMessage() + " indexName=" + paramString1 });
      }
      AppMethodBeat.o(197119);
    }
    if (paramf == null) {
      Log.i("TableIndexFixer", "DROP INDEX, successfully! indexName=%s, tblName=%s", new Object[] { paramString1, paramString2 });
    }
    if (paramf == null)
    {
      AppMethodBeat.o(197119);
      return true;
    }
    return false;
  }
  
  public static boolean a(f paramf, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197120);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("TableIndexFixer", "[createIndex] rightTblName is wrong.");
      AppMethodBeat.o(197120);
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
        e.Cxv.idkeyStat(1457L, 5L, 1L, true);
        e.Cxv.a(20708, new Object[] { "1", Integer.valueOf(4), paramf.getMessage() + "sql=" + paramString1 });
      }
      AppMethodBeat.o(197120);
    }
    if (paramf == null) {
      Log.i("TableIndexFixer", "CREATE INDEX, successfully! %s => %s", new Object[] { paramString3, paramString1 });
    }
    if (paramf == null)
    {
      AppMethodBeat.o(197120);
      return true;
    }
    return false;
  }
  
  public static boolean a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197118);
    if (paramString1.startsWith("sqlite_"))
    {
      AppMethodBeat.o(197118);
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(197118);
      return false;
    }
    if (paramString1.startsWith(paramString2))
    {
      AppMethodBeat.o(197118);
      return false;
    }
    int i = 0;
    while (i < 2)
    {
      if (paramString2.equalsIgnoreCase(paramArrayOfString[i]))
      {
        AppMethodBeat.o(197118);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(197118);
    return false;
  }
  
  /* Error */
  public static int b(f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 185
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 187
    //   10: aconst_null
    //   11: iconst_0
    //   12: invokevirtual 51	com/tencent/mm/storagebase/f:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 57 1 0
    //   22: pop
    //   23: aload_3
    //   24: iconst_0
    //   25: invokeinterface 61 2 0
    //   30: istore_1
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: invokeinterface 64 1 0
    //   41: ldc 185
    //   43: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iload_1
    //   47: ireturn
    //   48: astore_2
    //   49: ldc 185
    //   51: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_2
    //   55: athrow
    //   56: astore_0
    //   57: aload_3
    //   58: ifnull +13 -> 71
    //   61: aload_2
    //   62: ifnull +25 -> 87
    //   65: aload_3
    //   66: invokeinterface 64 1 0
    //   71: ldc 185
    //   73: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_3
    //   79: aload_2
    //   80: aload_3
    //   81: invokevirtual 68	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   84: goto -13 -> 71
    //   87: aload_3
    //   88: invokeinterface 64 1 0
    //   93: goto -22 -> 71
    //   96: astore_0
    //   97: goto -40 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramf	f
    //   30	17	1	i	int
    //   1	1	2	localObject	Object
    //   48	32	2	localThrowable1	java.lang.Throwable
    //   15	51	3	localCursor	android.database.Cursor
    //   78	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   16	31	48	java/lang/Throwable
    //   49	56	56	finally
    //   65	71	78	java/lang/Throwable
    //   16	31	96	finally
  }
  
  public static ab blL()
  {
    return jNL;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ab
 * JD-Core Version:    0.7.0.1
 */