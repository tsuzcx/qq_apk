package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;

public final class f
  extends j<e>
{
  public static final String[] SQL_CREATE;
  public static LinkedHashMap<String, Class> mMm;
  
  static
  {
    AppMethodBeat.i(20888);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )" };
    mMm = new f.1();
    AppMethodBeat.o(20888);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "FreeWifiLog", null);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(20887);
    ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong) });
    if (m.isEmpty(paramString1))
    {
      AppMethodBeat.o(20887);
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
        ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret".concat(String.valueOf(bool)));
        return bool;
      }
      boolean bool = update(locale, new String[0]);
      ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret".concat(String.valueOf(bool)));
      return bool;
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiLogStorage", m.f(paramString1));
      return false;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(20887);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.f
 * JD-Core Version:    0.7.0.1
 */