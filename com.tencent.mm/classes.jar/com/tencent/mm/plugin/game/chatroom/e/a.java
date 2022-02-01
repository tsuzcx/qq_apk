package com.tencent.mm.plugin.game.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.c.cz;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends cz
  implements c
{
  public static final IAutoDBItem.MAutoDBInfo lqK;
  
  static
  {
    AppMethodBeat.i(211028);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "roomName";
    localMAutoDBInfo.colsMap.put("roomName", "TEXT default '' ");
    localStringBuilder.append(" roomName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickName";
    localMAutoDBInfo.colsMap.put("nickName", "TEXT default '' ");
    localStringBuilder.append(" nickName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "avatarURL";
    localMAutoDBInfo.colsMap.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER default '0' ");
    localStringBuilder.append(" sex INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "jumpInfo";
    localMAutoDBInfo.colsMap.put("jumpInfo", "BLOB");
    localStringBuilder.append(" jumpInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isAuthorized";
    localMAutoDBInfo.colsMap.put("isAuthorized", "INTEGER default 'true' ");
    localStringBuilder.append(" isAuthorized INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "tagInfo";
    localMAutoDBInfo.colsMap.put("tagInfo", "BLOB");
    localStringBuilder.append(" tagInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lbsInfo";
    localMAutoDBInfo.colsMap.put("lbsInfo", "BLOB");
    localStringBuilder.append(" lbsInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "role";
    localMAutoDBInfo.colsMap.put("role", "INTEGER default '0' ");
    localStringBuilder.append(" role INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "canBeAt";
    localMAutoDBInfo.colsMap.put("canBeAt", "INTEGER default 'true' ");
    localStringBuilder.append(" canBeAt INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "isRobot";
    localMAutoDBInfo.colsMap.put("isRobot", "INTEGER default 'false' ");
    localStringBuilder.append(" isRobot INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "canKickMember";
    localMAutoDBInfo.colsMap.put("canKickMember", "INTEGER default 'false' ");
    localStringBuilder.append(" canKickMember INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "userRole";
    localMAutoDBInfo.colsMap.put("userRole", "BLOB");
    localStringBuilder.append(" userRole BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "canBeKicked";
    localMAutoDBInfo.colsMap.put("canBeKicked", "INTEGER default 'true' ");
    localStringBuilder.append(" canBeKicked INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "canAtAll";
    localMAutoDBInfo.colsMap.put("canAtAll", "INTEGER default 'false' ");
    localStringBuilder.append(" canAtAll INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "rawPbData";
    localMAutoDBInfo.colsMap.put("rawPbData", "BLOB");
    localStringBuilder.append(" rawPbData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    lqK = localMAutoDBInfo;
    AppMethodBeat.o(211028);
  }
  
  private ChatroomUserData evD()
  {
    AppMethodBeat.i(211026);
    if (this.field_rawPbData != null) {}
    for (;;)
    {
      try
      {
        ChatroomUserData localChatroomUserData = new ChatroomUserData();
        Object localObject = null;
      }
      catch (IOException localIOException1)
      {
        try
        {
          localChatroomUserData.parseFrom(this.field_rawPbData);
          AppMethodBeat.o(211026);
          return localChatroomUserData;
          localIOException1 = localIOException1;
          localObject = null;
        }
        catch (IOException localIOException2) {}
      }
    }
  }
  
  public final String Mm()
  {
    return this.field_avatarURL;
  }
  
  public final long dnn()
  {
    return this.field_updateTime;
  }
  
  public final boolean evA()
  {
    return this.field_canAtAll;
  }
  
  public final JumpInfo evB()
  {
    return this.field_jumpInfo;
  }
  
  public final String evC()
  {
    AppMethodBeat.i(211027);
    Object localObject = evD();
    if (localObject != null)
    {
      localObject = g.bN(localObject).toString();
      AppMethodBeat.o(211027);
      return localObject;
    }
    AppMethodBeat.o(211027);
    return "";
  }
  
  public final TagInfo evv()
  {
    return this.field_tagInfo;
  }
  
  public final UserRole evw()
  {
    return this.field_userRole;
  }
  
  public final boolean evx()
  {
    return this.field_canBeAt;
  }
  
  public final boolean evy()
  {
    return this.field_canKickMember;
  }
  
  public final boolean evz()
  {
    return this.field_canBeKicked;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
  
  public final String getNickName()
  {
    return this.field_nickName;
  }
  
  public final String getUserName()
  {
    return this.field_userName;
  }
  
  public final String print()
  {
    AppMethodBeat.i(211021);
    String str = "userName: " + this.field_userName + "; roomName: " + this.field_roomName;
    AppMethodBeat.o(211021);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */