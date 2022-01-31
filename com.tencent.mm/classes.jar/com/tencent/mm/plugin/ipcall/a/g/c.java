package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public final class c
  extends cn
{
  public static c.a info;
  public ArrayList<String> nQc;
  
  static
  {
    AppMethodBeat.i(21922);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wechatUsername";
    locala.yrM.put("wechatUsername", "TEXT");
    localStringBuilder.append(" wechatUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "systemAddressBookUsername";
    locala.yrM.put("systemAddressBookUsername", "TEXT");
    localStringBuilder.append(" systemAddressBookUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "contactId";
    locala.yrM.put("contactId", "TEXT");
    localStringBuilder.append(" contactId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sortKey";
    locala.yrM.put("sortKey", "TEXT");
    localStringBuilder.append(" sortKey TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(21922);
  }
  
  public static boolean eR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21921);
    if ((paramString1 == null) && (paramString2 != null))
    {
      AppMethodBeat.o(21921);
      return false;
    }
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(21921);
      return false;
    }
    AppMethodBeat.o(21921);
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.c
 * JD-Core Version:    0.7.0.1
 */