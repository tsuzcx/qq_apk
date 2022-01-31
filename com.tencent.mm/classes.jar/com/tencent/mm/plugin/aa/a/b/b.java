package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] goC;
  private e db;
  
  static
  {
    AppMethodBeat.i(40665);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "AAPayRecord") };
    goC = new String[] { "*", "rowid" };
    AppMethodBeat.o(40665);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "AAPayRecord", null);
    this.db = parame;
  }
  
  public final a wI(String paramString)
  {
    AppMethodBeat.i(40664);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(40664);
      return null;
    }
    paramString = this.db.a("AAPayRecord", goC, "payMsgId=?", new String[] { paramString }, null, null, null, 2);
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
        ab.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(40664);
    }
    AppMethodBeat.o(40664);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.b
 * JD-Core Version:    0.7.0.1
 */