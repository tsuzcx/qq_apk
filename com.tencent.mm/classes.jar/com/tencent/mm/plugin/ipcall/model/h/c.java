package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dy;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public final class c
  extends dy
{
  public static IAutoDBItem.MAutoDBInfo info;
  public ArrayList<String> DSI;
  
  static
  {
    AppMethodBeat.i(25537);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wechatUsername";
    localMAutoDBInfo.colsMap.put("wechatUsername", "TEXT");
    localStringBuilder.append(" wechatUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "systemAddressBookUsername";
    localMAutoDBInfo.colsMap.put("systemAddressBookUsername", "TEXT");
    localStringBuilder.append(" systemAddressBookUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "contactId";
    localMAutoDBInfo.colsMap.put("contactId", "TEXT");
    localStringBuilder.append(" contactId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sortKey";
    localMAutoDBInfo.colsMap.put("sortKey", "TEXT");
    localStringBuilder.append(" sortKey TEXT");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(25537);
  }
  
  public static boolean ix(String paramString1, String paramString2)
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.c
 * JD-Core Version:    0.7.0.1
 */