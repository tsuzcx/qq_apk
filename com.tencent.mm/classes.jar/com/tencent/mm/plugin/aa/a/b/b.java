package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "AAPayRecord") };
  private static final String[] eWE = { "*", "rowid" };
  private e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "AAPayRecord", null);
    this.dXw = parame;
  }
  
  public final a pu(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      paramString = this.dXw.a("AAPayRecord", eWE, "payMsgId=?", new String[] { paramString }, null, null, null, 2);
      try
      {
        if (paramString.moveToFirst())
        {
          a locala = new a();
          locala.d(paramString);
          return locala;
        }
        return null;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", new Object[] { localException.getMessage() });
        return null;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.b
 * JD-Core Version:    0.7.0.1
 */