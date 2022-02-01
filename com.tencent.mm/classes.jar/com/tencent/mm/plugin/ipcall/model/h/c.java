package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.do;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public final class c
  extends do
{
  public static c.a info;
  public ArrayList<String> vae;
  
  static
  {
    AppMethodBeat.i(25537);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wechatUsername";
    locala.IBN.put("wechatUsername", "TEXT");
    localStringBuilder.append(" wechatUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "systemAddressBookUsername";
    locala.IBN.put("systemAddressBookUsername", "TEXT");
    localStringBuilder.append(" systemAddressBookUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "contactId";
    locala.IBN.put("contactId", "TEXT");
    localStringBuilder.append(" contactId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sortKey";
    locala.IBN.put("sortKey", "TEXT");
    localStringBuilder.append(" sortKey TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(25537);
  }
  
  public static boolean hC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25536);
    if ((paramString1 == null) && (paramString2 != null))
    {
      AppMethodBeat.o(25536);
      return false;
    }
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(25536);
      return false;
    }
    AppMethodBeat.o(25536);
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.c
 * JD-Core Version:    0.7.0.1
 */