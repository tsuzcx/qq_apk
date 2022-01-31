package com.tencent.mm.ai.a;

import com.tencent.mm.api.h;
import com.tencent.mm.h.c.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends aa
{
  protected static c.a buS;
  private Map<String, j> eho = new HashMap();
  private List<String> ehp;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatLocalId";
    locala.ujN.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "bizChatLocalId";
    locala.columns[1] = "bizChatServId";
    locala.ujN.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandUserName";
    locala.ujN.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatType";
    locala.ujN.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "headImageUrl";
    locala.ujN.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "chatName";
    locala.ujN.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "chatNamePY";
    locala.ujN.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatVersion";
    locala.ujN.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "needToUpdate";
    locala.ujN.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "bitFlag";
    locala.ujN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "maxMemberCnt";
    locala.ujN.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "ownerUserId";
    locala.ujN.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "userList";
    locala.ujN.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "addMemberUrl";
    locala.ujN.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final List<String> MN()
  {
    if (this.ehp != null) {
      return this.ehp;
    }
    String str = this.field_userList;
    if (bk.bl(str)) {
      return new LinkedList();
    }
    this.ehp = bk.G(str.split(";"));
    return this.ehp;
  }
  
  public final boolean MO()
  {
    if (this.field_needToUpdate) {}
    while (((isGroup()) && (bk.bl(this.field_userList))) || ((bk.bl(this.field_chatNamePY)) && (!bk.bl(this.field_chatName)))) {
      return true;
    }
    return false;
  }
  
  public final String gV(String paramString)
  {
    paramString = lo(paramString);
    if (paramString == null) {
      return "";
    }
    return bk.aM(paramString.field_userName, "");
  }
  
  public final boolean il(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final boolean isGroup()
  {
    if (this.field_bizChatServId == null) {
      return false;
    }
    return this.field_bizChatServId.endsWith("@qy_g");
  }
  
  public final j lo(String paramString)
  {
    if ((!this.eho.containsKey(paramString)) || (this.eho.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      j localj = ((h)g.r(h.class)).bY(paramString);
      if (localj != null) {
        this.eho.put(localj.field_userId, localj);
      }
      y.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.eho.containsKey(paramString)) {
      return (j)this.eho.get(paramString);
    }
    return null;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.c
 * JD-Core Version:    0.7.0.1
 */