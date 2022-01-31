package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.h.c.ci;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public final class c
  extends ci
{
  public static c.a buS;
  public ArrayList<String> lsI;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wechatUsername";
    locala.ujN.put("wechatUsername", "TEXT");
    localStringBuilder.append(" wechatUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "systemAddressBookUsername";
    locala.ujN.put("systemAddressBookUsername", "TEXT");
    localStringBuilder.append(" systemAddressBookUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "contactId";
    locala.ujN.put("contactId", "TEXT");
    localStringBuilder.append(" contactId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sortKey";
    locala.ujN.put("sortKey", "TEXT");
    localStringBuilder.append(" sortKey TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public static boolean dA(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 != null)) {}
    while ((paramString1 != null) && (!paramString1.equals(paramString2))) {
      return false;
    }
    return true;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.c
 * JD-Core Version:    0.7.0.1
 */