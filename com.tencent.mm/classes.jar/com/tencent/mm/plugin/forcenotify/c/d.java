package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bt;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.storage.ad;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bt
{
  public static c.a info;
  public ad contact = null;
  
  static
  {
    AppMethodBeat.i(51017);
    c.a locala = new c.a();
    locala.yrK = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "ForcePushId";
    locala.yrM.put("ForcePushId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ForcePushId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "ForcePushId";
    locala.columns[1] = "CreateTime";
    locala.yrM.put("CreateTime", "LONG");
    localStringBuilder.append(" CreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "ExpiredTime";
    locala.yrM.put("ExpiredTime", "LONG");
    localStringBuilder.append(" ExpiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "Description";
    locala.yrM.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "UserIcon";
    locala.yrM.put("UserIcon", "TEXT");
    localStringBuilder.append(" UserIcon TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "UserName";
    locala.yrM.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "ExtInfo";
    locala.yrM.put("ExtInfo", "TEXT");
    localStringBuilder.append(" ExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "Status";
    locala.yrM.put("Status", "INTEGER default '0' ");
    localStringBuilder.append(" Status INTEGER default '0' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(51017);
  }
  
  public final boolean bzK()
  {
    AppMethodBeat.i(51015);
    if (cb.abp() >= this.field_ExpiredTime)
    {
      AppMethodBeat.o(51015);
      return true;
    }
    AppMethodBeat.o(51015);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isEnable()
  {
    return this.field_Status == 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51016);
    String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
    AppMethodBeat.o(51016);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.d
 * JD-Core Version:    0.7.0.1
 */