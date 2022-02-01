package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] iTS;
  private e db;
  
  static
  {
    AppMethodBeat.i(63422);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "AAPayRecord") };
    iTS = new String[] { "*", "rowid" };
    AppMethodBeat.o(63422);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "AAPayRecord", null);
    this.db = parame;
  }
  
  public final a Jf(String paramString)
  {
    AppMethodBeat.i(63421);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63421);
      return null;
    }
    paramString = this.db.a("AAPayRecord", iTS, "payMsgId=?", new String[] { paramString }, null, null, null, 2);
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
        ad.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", new Object[] { localException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.b
 * JD-Core Version:    0.7.0.1
 */