package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] pHB;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(63422);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "AAPayRecord") };
    pHB = new String[] { "*", "rowid" };
    AppMethodBeat.o(63422);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "AAPayRecord", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final a SC(String paramString)
  {
    AppMethodBeat.i(63421);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63421);
      return null;
    }
    paramString = this.db.query("AAPayRecord", pHB, "payMsgId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        return locala;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label147;
      }
      paramString.close();
      AppMethodBeat.o(63421);
    }
    AppMethodBeat.o(63421);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.b
 * JD-Core Version:    0.7.0.1
 */