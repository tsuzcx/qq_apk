package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;

public final class f
  extends j<e>
{
  public static final String[] SQL_CREATE;
  public static LinkedHashMap<String, Class> toL;
  
  static
  {
    AppMethodBeat.i(24958);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )" };
    toL = new f.1();
    AppMethodBeat.o(24958);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "FreeWifiLog", null);
  }
  
  public final boolean b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(24957);
    ad.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong) });
    if (m.ea(paramString1))
    {
      AppMethodBeat.o(24957);
      return false;
    }
    Cursor localCursor = rawQuery("select * from FreeWifiLog where id = '" + paramString1 + "'", new String[0]);
    try
    {
      e locale = new e();
      locale.field_id = paramString1;
      locale.field_protocolNumber = paramInt;
      locale.field_logContent = paramString2;
      locale.field_createTime = paramLong;
      if (localCursor.getCount() == 0)
      {
        bool = insert(locale);
        ad.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret".concat(String.valueOf(bool)));
        return bool;
      }
      boolean bool = update(locale, new String[0]);
      ad.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret".concat(String.valueOf(bool)));
      return bool;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiLogStorage", m.m(paramString1));
      return false;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(24957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.f
 * JD-Core Version:    0.7.0.1
 */