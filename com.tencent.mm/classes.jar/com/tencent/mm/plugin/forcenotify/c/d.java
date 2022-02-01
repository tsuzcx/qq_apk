package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.as;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends cq
{
  public static IAutoDBItem.MAutoDBInfo info;
  public as contact = null;
  
  static
  {
    AppMethodBeat.i(149136);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ForcePushId";
    localMAutoDBInfo.colsMap.put("ForcePushId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ForcePushId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "ForcePushId";
    localMAutoDBInfo.columns[1] = "CreateTime";
    localMAutoDBInfo.colsMap.put("CreateTime", "LONG");
    localStringBuilder.append(" CreateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ExpiredTime";
    localMAutoDBInfo.colsMap.put("ExpiredTime", "LONG");
    localStringBuilder.append(" ExpiredTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "Description";
    localMAutoDBInfo.colsMap.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "UserIcon";
    localMAutoDBInfo.colsMap.put("UserIcon", "TEXT");
    localStringBuilder.append(" UserIcon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "ExtInfo";
    localMAutoDBInfo.colsMap.put("ExtInfo", "TEXT");
    localStringBuilder.append(" ExtInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "Status";
    localMAutoDBInfo.colsMap.put("Status", "INTEGER default '0' ");
    localStringBuilder.append(" Status INTEGER default '0' ");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(149136);
  }
  
  public final boolean dMp()
  {
    AppMethodBeat.i(149134);
    if (cl.aWy() >= this.field_ExpiredTime)
    {
      AppMethodBeat.o(149134);
      return true;
    }
    AppMethodBeat.o(149134);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean isEnable()
  {
    return this.field_Status == 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149135);
    String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
    AppMethodBeat.o(149135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.d
 * JD-Core Version:    0.7.0.1
 */