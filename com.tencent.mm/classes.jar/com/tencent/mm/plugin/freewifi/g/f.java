package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f
  extends i<e>
{
  public static final String[] dXp = { i.a(e.buS, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )" };
  public static LinkedHashMap<String, Class> kqA = new f.1();
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.buS, "FreeWifiLog", null);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong) });
    if (m.isEmpty(paramString1)) {
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
        bool = b(locale);
        y.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + bool);
        return bool;
      }
      boolean bool = c(locale, new String[0]);
      y.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + bool);
      return bool;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiLogStorage", m.g(paramString1));
      return false;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final LinkedList<zk> aUM()
  {
    Cursor localCursor = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    while ((localCursor != null) && (localCursor.moveToNext()))
    {
      zk localzk = new zk();
      localzk.id = localCursor.getString(0);
      localzk.kpu = localCursor.getInt(1);
      localzk.sYJ = localCursor.getString(2);
      localzk.sYK = localCursor.getLong(3);
      localLinkedList.add(localzk);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.f
 * JD-Core Version:    0.7.0.1
 */