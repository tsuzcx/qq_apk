package com.tencent.mm.bh;

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
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wxGroupId";
    locala.IBN.put("wxGroupId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "wxGroupId";
    locala.columns[1] = "groupId";
    locala.IBN.put("groupId", "TEXT");
    localStringBuilder.append(" groupId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "roomId";
    locala.IBN.put("roomId", "INTEGER");
    localStringBuilder.append(" roomId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "roomKey";
    locala.IBN.put("roomKey", "LONG");
    localStringBuilder.append(" roomKey LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "routeId";
    locala.IBN.put("routeId", "INTEGER");
    localStringBuilder.append(" routeId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "inviteUserName";
    locala.IBN.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "memberCount";
    locala.IBN.put("memberCount", "INTEGER");
    localStringBuilder.append(" memberCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "state";
    locala.IBN.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "ilinkRoomId";
    locala.IBN.put("ilinkRoomId", "LONG");
    localStringBuilder.append(" ilinkRoomId LONG");
    locala.columns[10] = "rowid";
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
 * Qualified Name:     com.tencent.mm.bh.f
 * JD-Core Version:    0.7.0.1
 */