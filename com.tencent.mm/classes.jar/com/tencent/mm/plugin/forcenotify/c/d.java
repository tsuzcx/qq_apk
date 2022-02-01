package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.storage.af;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends cf
{
  public static c.a info;
  public af contact = null;
  
  static
  {
    AppMethodBeat.i(149136);
    c.a locala = new c.a();
    locala.EYt = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "ForcePushId";
    locala.EYv.put("ForcePushId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ForcePushId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "ForcePushId";
    locala.columns[1] = "CreateTime";
    locala.EYv.put("CreateTime", "LONG");
    localStringBuilder.append(" CreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "ExpiredTime";
    locala.EYv.put("ExpiredTime", "LONG");
    localStringBuilder.append(" ExpiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "Description";
    locala.EYv.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "UserIcon";
    locala.EYv.put("UserIcon", "TEXT");
    localStringBuilder.append(" UserIcon TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "UserName";
    locala.EYv.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "ExtInfo";
    locala.EYv.put("ExtInfo", "TEXT");
    localStringBuilder.append(" ExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "Status";
    locala.EYv.put("Status", "INTEGER default '0' ");
    localStringBuilder.append(" Status INTEGER default '0' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(149136);
  }
  
  public final boolean cva()
  {
    AppMethodBeat.i(149134);
    if (ce.asQ() >= this.field_ExpiredTime)
    {
      AppMethodBeat.o(149134);
      return true;
    }
    AppMethodBeat.o(149134);
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
    AppMethodBeat.i(149135);
    String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
    AppMethodBeat.o(149135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.d
 * JD-Core Version:    0.7.0.1
 */