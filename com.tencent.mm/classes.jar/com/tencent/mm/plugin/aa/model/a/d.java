package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] iAI;
  public static Map<String, c> iAJ;
  private e db;
  
  static
  {
    AppMethodBeat.i(63431);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "AARecord") };
    iAI = new String[] { "*", "rowid" };
    iAJ = new HashMap();
    AppMethodBeat.o(63431);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "AARecord", null);
    this.db = parame;
  }
  
  public final c FR(String paramString)
  {
    AppMethodBeat.i(63424);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63424);
      return null;
    }
    paramString = this.db.a("AARecord", iAI, "billNo=?", new String[] { paramString }, null, null, null, 2);
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
        ac.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", new Object[] { localException.getMessage() });
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
    if ((paramc != null) && (iAJ.containsKey(paramc.field_billNo))) {
      iAJ.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.insert(paramc);
    AppMethodBeat.o(63425);
    return bool;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(63426);
    if ((paramc != null) && (iAJ.containsKey(paramc.field_billNo))) {
      iAJ.remove(paramc.field_billNo);
    }
    boolean bool = super.delete(paramc, paramVarArgs);
    AppMethodBeat.o(63426);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(63427);
    if ((paramc != null) && (iAJ.containsKey(paramc.field_billNo))) {
      iAJ.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(63427);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.d
 * JD-Core Version:    0.7.0.1
 */