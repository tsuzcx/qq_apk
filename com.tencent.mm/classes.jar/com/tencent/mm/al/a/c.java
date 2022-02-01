package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends ag
{
  protected static c.a info;
  private Map<String, k> hzg;
  private List<String> hzh;
  
  static
  {
    AppMethodBeat.i(116441);
    c.a locala = new c.a();
    locala.GvF = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatLocalId";
    locala.GvH.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "bizChatLocalId";
    locala.columns[1] = "bizChatServId";
    locala.GvH.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandUserName";
    locala.GvH.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatType";
    locala.GvH.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "headImageUrl";
    locala.GvH.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "chatName";
    locala.GvH.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "chatNamePY";
    locala.GvH.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatVersion";
    locala.GvH.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "needToUpdate";
    locala.GvH.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "bitFlag";
    locala.GvH.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "maxMemberCnt";
    locala.GvH.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "ownerUserId";
    locala.GvH.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "userList";
    locala.GvH.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "addMemberUrl";
    locala.GvH.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "roomflag";
    locala.GvH.put("roomflag", "INTEGER default '0' ");
    localStringBuilder.append(" roomflag INTEGER default '0' ");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116441);
  }
  
  public c()
  {
    AppMethodBeat.i(116434);
    this.hzg = new HashMap();
    AppMethodBeat.o(116434);
  }
  
  private void Bo(String paramString)
  {
    AppMethodBeat.i(116438);
    paramString = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).dP(paramString);
    if (paramString != null) {
      this.hzg.put(paramString.field_userId, paramString);
    }
    AppMethodBeat.o(116438);
  }
  
  public final k Bn(String paramString)
  {
    AppMethodBeat.i(116437);
    if ((!this.hzg.containsKey(paramString)) || (this.hzg.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      Bo(paramString);
      ac.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.hzg.containsKey(paramString))
    {
      paramString = (k)this.hzg.get(paramString);
      AppMethodBeat.o(116437);
      return paramString;
    }
    AppMethodBeat.o(116437);
    return null;
  }
  
  public final List<String> aDl()
  {
    AppMethodBeat.i(116435);
    if (this.hzh != null)
    {
      localObject = this.hzh;
      AppMethodBeat.o(116435);
      return localObject;
    }
    Object localObject = this.field_userList;
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(116435);
      return localObject;
    }
    this.hzh = bs.S(((String)localObject).split(";"));
    localObject = this.hzh;
    AppMethodBeat.o(116435);
    return localObject;
  }
  
  public final boolean aDm()
  {
    AppMethodBeat.i(116440);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((isGroup()) && (bs.isNullOrNil(this.field_userList)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((bs.isNullOrNil(this.field_chatNamePY)) && (!bs.isNullOrNil(this.field_chatName)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    AppMethodBeat.o(116440);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean hc(int paramInt)
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
  
  public final String wk(String paramString)
  {
    AppMethodBeat.i(116436);
    paramString = Bn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116436);
      return "";
    }
    paramString = bs.bG(paramString.field_userName, "");
    AppMethodBeat.o(116436);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.c
 * JD-Core Version:    0.7.0.1
 */