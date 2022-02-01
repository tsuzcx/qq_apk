package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends ag
{
  protected static c.a info;
  private Map<String, k> gYH;
  private List<String> gYI;
  
  static
  {
    AppMethodBeat.i(116441);
    c.a locala = new c.a();
    locala.EYt = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatLocalId";
    locala.EYv.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "bizChatLocalId";
    locala.columns[1] = "bizChatServId";
    locala.EYv.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandUserName";
    locala.EYv.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatType";
    locala.EYv.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "headImageUrl";
    locala.EYv.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "chatName";
    locala.EYv.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "chatNamePY";
    locala.EYv.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatVersion";
    locala.EYv.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "needToUpdate";
    locala.EYv.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "bitFlag";
    locala.EYv.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "maxMemberCnt";
    locala.EYv.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "ownerUserId";
    locala.EYv.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "userList";
    locala.EYv.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "addMemberUrl";
    locala.EYv.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "roomflag";
    locala.EYv.put("roomflag", "INTEGER default '0' ");
    localStringBuilder.append(" roomflag INTEGER default '0' ");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116441);
  }
  
  public c()
  {
    AppMethodBeat.i(116434);
    this.gYH = new HashMap();
    AppMethodBeat.o(116434);
  }
  
  private void xi(String paramString)
  {
    AppMethodBeat.i(116438);
    paramString = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).ea(paramString);
    if (paramString != null) {
      this.gYH.put(paramString.field_userId, paramString);
    }
    AppMethodBeat.o(116438);
  }
  
  public final List<String> awt()
  {
    AppMethodBeat.i(116435);
    if (this.gYI != null)
    {
      localObject = this.gYI;
      AppMethodBeat.o(116435);
      return localObject;
    }
    Object localObject = this.field_userList;
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(116435);
      return localObject;
    }
    this.gYI = bt.S(((String)localObject).split(";"));
    localObject = this.gYI;
    AppMethodBeat.o(116435);
    return localObject;
  }
  
  public final boolean awu()
  {
    AppMethodBeat.i(116440);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((isGroup()) && (bt.isNullOrNil(this.field_userList)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((bt.isNullOrNil(this.field_chatNamePY)) && (!bt.isNullOrNil(this.field_chatName)))
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
  
  public final boolean ht(int paramInt)
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
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(116436);
    paramString = xh(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116436);
      return "";
    }
    paramString = bt.by(paramString.field_userName, "");
    AppMethodBeat.o(116436);
    return paramString;
  }
  
  public final k xh(String paramString)
  {
    AppMethodBeat.i(116437);
    if ((!this.gYH.containsKey(paramString)) || (this.gYH.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      xi(paramString);
      ad.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.gYH.containsKey(paramString))
    {
      paramString = (k)this.gYH.get(paramString);
      AppMethodBeat.o(116437);
      return paramString;
    }
    AppMethodBeat.o(116437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.c
 * JD-Core Version:    0.7.0.1
 */