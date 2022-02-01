package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ek;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends ek
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(151162);
    c.a locala = new c.a();
    locala.IhA = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wxGroupId";
    locala.IhC.put("wxGroupId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "wxGroupId";
    locala.columns[1] = "groupId";
    locala.IhC.put("groupId", "TEXT");
    localStringBuilder.append(" groupId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "roomId";
    locala.IhC.put("roomId", "INTEGER");
    localStringBuilder.append(" roomId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "roomKey";
    locala.IhC.put("roomKey", "LONG");
    localStringBuilder.append(" roomKey LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "routeId";
    locala.IhC.put("routeId", "INTEGER");
    localStringBuilder.append(" routeId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "inviteUserName";
    locala.IhC.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "memberCount";
    locala.IhC.put("memberCount", "INTEGER");
    localStringBuilder.append(" memberCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "state";
    locala.IhC.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151162);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bi.f
 * JD-Core Version:    0.7.0.1
 */