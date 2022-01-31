package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.g.c.ab
{
  protected static c.a info;
  private Map<String, j> fxs;
  private List<String> fxt;
  
  static
  {
    AppMethodBeat.i(105495);
    c.a locala = new c.a();
    locala.yrK = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatLocalId";
    locala.yrM.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "bizChatLocalId";
    locala.columns[1] = "bizChatServId";
    locala.yrM.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandUserName";
    locala.yrM.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatType";
    locala.yrM.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "headImageUrl";
    locala.yrM.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "chatName";
    locala.yrM.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "chatNamePY";
    locala.yrM.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatVersion";
    locala.yrM.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "needToUpdate";
    locala.yrM.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "bitFlag";
    locala.yrM.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "maxMemberCnt";
    locala.yrM.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "ownerUserId";
    locala.yrM.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "userList";
    locala.yrM.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "addMemberUrl";
    locala.yrM.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105495);
  }
  
  public c()
  {
    AppMethodBeat.i(105488);
    this.fxs = new HashMap();
    AppMethodBeat.o(105488);
  }
  
  private void sk(String paramString)
  {
    AppMethodBeat.i(105492);
    paramString = ((i)g.E(i.class)).df(paramString);
    if (paramString != null) {
      this.fxs.put(paramString.field_userId, paramString);
    }
    AppMethodBeat.o(105492);
  }
  
  public final List<String> afx()
  {
    AppMethodBeat.i(105489);
    if (this.fxt != null)
    {
      localObject = this.fxt;
      AppMethodBeat.o(105489);
      return localObject;
    }
    Object localObject = this.field_userList;
    if (bo.isNullOrNil((String)localObject))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(105489);
      return localObject;
    }
    this.fxt = bo.P(((String)localObject).split(";"));
    localObject = this.fxt;
    AppMethodBeat.o(105489);
    return localObject;
  }
  
  public final boolean afy()
  {
    AppMethodBeat.i(105494);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(105494);
      return true;
    }
    if ((isGroup()) && (bo.isNullOrNil(this.field_userList)))
    {
      AppMethodBeat.o(105494);
      return true;
    }
    if ((bo.isNullOrNil(this.field_chatNamePY)) && (!bo.isNullOrNil(this.field_chatName)))
    {
      AppMethodBeat.o(105494);
      return true;
    }
    AppMethodBeat.o(105494);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isGroup()
  {
    AppMethodBeat.i(105493);
    if (this.field_bizChatServId == null)
    {
      AppMethodBeat.o(105493);
      return false;
    }
    boolean bool = this.field_bizChatServId.endsWith("@qy_g");
    AppMethodBeat.o(105493);
    return bool;
  }
  
  public final boolean kY(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(105490);
    paramString = sj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105490);
      return "";
    }
    paramString = bo.bf(paramString.field_userName, "");
    AppMethodBeat.o(105490);
    return paramString;
  }
  
  public final j sj(String paramString)
  {
    AppMethodBeat.i(105491);
    if ((!this.fxs.containsKey(paramString)) || (this.fxs.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      sk(paramString);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.fxs.containsKey(paramString))
    {
      paramString = (j)this.fxs.get(paramString);
      AppMethodBeat.o(105491);
      return paramString;
    }
    AppMethodBeat.o(105491);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.a.c
 * JD-Core Version:    0.7.0.1
 */