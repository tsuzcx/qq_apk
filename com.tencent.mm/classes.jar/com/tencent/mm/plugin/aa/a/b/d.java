package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] goC;
  public static Map<String, c> goD;
  private e db;
  
  static
  {
    AppMethodBeat.i(40674);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "AARecord") };
    goC = new String[] { "*", "rowid" };
    goD = new HashMap();
    AppMethodBeat.o(40674);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "AARecord", null);
    this.db = parame;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(40668);
    if ((paramc != null) && (goD.containsKey(paramc.field_billNo))) {
      goD.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.insert(paramc);
    AppMethodBeat.o(40668);
    return bool;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(40669);
    if ((paramc != null) && (goD.containsKey(paramc.field_billNo))) {
      goD.remove(paramc.field_billNo);
    }
    boolean bool = super.delete(paramc, paramVarArgs);
    AppMethodBeat.o(40669);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(40670);
    if ((paramc != null) && (goD.containsKey(paramc.field_billNo))) {
      goD.put(paramc.field_billNo, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(40670);
    return bool;
  }
  
  public final c wJ(String paramString)
  {
    AppMethodBeat.i(40667);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(40667);
      return null;
    }
    paramString = this.db.a("AARecord", goC, "billNo=?", new String[] { paramString }, null, null, null, 2);
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
        ab.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(40667);
    }
    AppMethodBeat.o(40667);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.d
 * JD-Core Version:    0.7.0.1
 */