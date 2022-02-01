package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] pHB;
  public static Map<String, c> pHC;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(63431);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "AARecord") };
    pHB = new String[] { "*", "rowid" };
    pHC = new HashMap();
    AppMethodBeat.o(63431);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "AARecord", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final c SD(String paramString)
  {
    AppMethodBeat.i(63424);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63424);
      return null;
    }
    paramString = this.db.query("AARecord", pHB, "billNo=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(paramString);
        return localc;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(63424);
    }
    AppMethodBeat.o(63424);
    return null;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(63425);
    if ((paramc != null) && (pHC.containsKey(paramc.field_billNo))) {
      pHC.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.insert(paramc);
    AppMethodBeat.o(63425);
    return bool;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(63426);
    if ((paramc != null) && (pHC.containsKey(paramc.field_billNo))) {
      pHC.remove(paramc.field_billNo);
    }
    boolean bool = super.delete(paramc, paramVarArgs);
    AppMethodBeat.o(63426);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(63427);
    if ((paramc != null) && (pHC.containsKey(paramc.field_billNo))) {
      pHC.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(63427);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.d
 * JD-Core Version:    0.7.0.1
 */