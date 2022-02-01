package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.l;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends ah
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private Map<String, k> iPG;
  private List<String> iPH;
  
  static
  {
    AppMethodBeat.i(116441);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[15];
    localMAutoDBInfo.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bizChatLocalId";
    localMAutoDBInfo.colsMap.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bizChatLocalId";
    localMAutoDBInfo.columns[1] = "bizChatServId";
    localMAutoDBInfo.colsMap.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "chatType";
    localMAutoDBInfo.colsMap.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "headImageUrl";
    localMAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "chatName";
    localMAutoDBInfo.colsMap.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "chatNamePY";
    localMAutoDBInfo.colsMap.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "chatVersion";
    localMAutoDBInfo.colsMap.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "needToUpdate";
    localMAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "maxMemberCnt";
    localMAutoDBInfo.colsMap.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "ownerUserId";
    localMAutoDBInfo.colsMap.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "userList";
    localMAutoDBInfo.colsMap.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "addMemberUrl";
    localMAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "roomflag";
    localMAutoDBInfo.colsMap.put("roomflag", "INTEGER default '0' ");
    localStringBuilder.append(" roomflag INTEGER default '0' ");
    localMAutoDBInfo.columns[15] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(116441);
  }
  
  public c()
  {
    AppMethodBeat.i(116434);
    this.iPG = new HashMap();
    AppMethodBeat.o(116434);
  }
  
  private void ND(String paramString)
  {
    AppMethodBeat.i(116438);
    paramString = ((l)g.af(l.class)).fB(paramString);
    if (paramString != null) {
      this.iPG.put(paramString.field_userId, paramString);
    }
    AppMethodBeat.o(116438);
  }
  
  public final k NC(String paramString)
  {
    AppMethodBeat.i(116437);
    if ((!this.iPG.containsKey(paramString)) || (this.iPG.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      ND(paramString);
      Log.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.iPG.containsKey(paramString))
    {
      paramString = (k)this.iPG.get(paramString);
      AppMethodBeat.o(116437);
      return paramString;
    }
    AppMethodBeat.o(116437);
    return null;
  }
  
  public final List<String> bax()
  {
    AppMethodBeat.i(116435);
    if (this.iPH != null)
    {
      localObject = this.iPH;
      AppMethodBeat.o(116435);
      return localObject;
    }
    Object localObject = this.field_userList;
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(116435);
      return localObject;
    }
    this.iPH = Util.stringsToList(((String)localObject).split(";"));
    localObject = this.iPH;
    AppMethodBeat.o(116435);
    return localObject;
  }
  
  public final boolean bay()
  {
    AppMethodBeat.i(116440);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((isGroup()) && (Util.isNullOrNil(this.field_userList)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((Util.isNullOrNil(this.field_chatNamePY)) && (!Util.isNullOrNil(this.field_chatName)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    AppMethodBeat.o(116440);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(116436);
    paramString = NC(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116436);
      return "";
    }
    paramString = Util.nullAs(paramString.field_userName, "");
    AppMethodBeat.o(116436);
    return paramString;
  }
  
  public final boolean iE(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final boolean isGroup()
  {
    AppMethodBeat.i(116439);
    if (this.field_bizChatServId == null)
    {
      AppMethodBeat.o(116439);
      return false;
    }
    boolean bool = this.field_bizChatServId.endsWith("@qy_g");
    AppMethodBeat.o(116439);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.c
 * JD-Core Version:    0.7.0.1
 */