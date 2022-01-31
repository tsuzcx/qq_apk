package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "AARecord") };
  private static final String[] eWE = { "*", "rowid" };
  public static Map<String, c> eWF = new HashMap();
  private e dXw;
  
  public d(e parame)
  {
    super(parame, c.buS, "AARecord", null);
    this.dXw = parame;
  }
  
  public final boolean a(c paramc)
  {
    if ((paramc != null) && (eWF.containsKey(paramc.field_billNo))) {
      eWF.put(paramc.field_billNo, paramc);
    }
    return super.b(paramc);
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    if ((paramc != null) && (eWF.containsKey(paramc.field_billNo))) {
      eWF.remove(paramc.field_billNo);
    }
    return super.a(paramc, paramVarArgs);
  }
  
  public final boolean b(c paramc)
  {
    if ((paramc != null) && (eWF.containsKey(paramc.field_billNo))) {
      eWF.put(paramc.field_billNo, paramc);
    }
    return super.a(paramc);
  }
  
  public final c pv(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      paramString = this.dXw.a("AARecord", eWE, "billNo=?", new String[] { paramString }, null, null, null, 2);
      try
      {
        if (paramString.moveToFirst())
        {
          c localc = new c();
          localc.d(paramString);
          return localc;
        }
        return null;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", new Object[] { localException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.d
 * JD-Core Version:    0.7.0.1
 */