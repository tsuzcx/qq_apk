package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ak;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends ak
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(123984);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "qyUin";
    localMAutoDBInfo.colsMap.put("qyUin", "INTEGER");
    localStringBuilder.append(" qyUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userUin";
    localMAutoDBInfo.colsMap.put("userUin", "INTEGER");
    localStringBuilder.append(" userUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "userFlag";
    localMAutoDBInfo.colsMap.put("userFlag", "INTEGER");
    localStringBuilder.append(" userFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "wwExposeTimes";
    localMAutoDBInfo.colsMap.put("wwExposeTimes", "INTEGER");
    localStringBuilder.append(" wwExposeTimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "wwMaxExposeTimes";
    localMAutoDBInfo.colsMap.put("wwMaxExposeTimes", "INTEGER");
    localStringBuilder.append(" wwMaxExposeTimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "wwCorpId";
    localMAutoDBInfo.colsMap.put("wwCorpId", "LONG");
    localStringBuilder.append(" wwCorpId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "wwUserVid";
    localMAutoDBInfo.colsMap.put("wwUserVid", "LONG");
    localStringBuilder.append(" wwUserVid LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "userType";
    localMAutoDBInfo.colsMap.put("userType", "INTEGER");
    localStringBuilder.append(" userType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "chatOpen";
    localMAutoDBInfo.colsMap.put("chatOpen", "INTEGER");
    localStringBuilder.append(" chatOpen INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "wwUnreadCnt";
    localMAutoDBInfo.colsMap.put("wwUnreadCnt", "INTEGER default '0' ");
    localStringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "show_confirm";
    localMAutoDBInfo.colsMap.put("show_confirm", "INTEGER");
    localStringBuilder.append(" show_confirm INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "use_preset_banner_tips";
    localMAutoDBInfo.colsMap.put("use_preset_banner_tips", "INTEGER");
    localStringBuilder.append(" use_preset_banner_tips INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "hide_create_chat";
    localMAutoDBInfo.colsMap.put("hide_create_chat", "INTEGER");
    localStringBuilder.append(" hide_create_chat INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hide_mod_chat_member";
    localMAutoDBInfo.colsMap.put("hide_mod_chat_member", "INTEGER");
    localStringBuilder.append(" hide_mod_chat_member INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "hide_colleage_invite";
    localMAutoDBInfo.colsMap.put("hide_colleage_invite", "INTEGER default 'true' ");
    localStringBuilder.append(" hide_colleage_invite INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "raw_attrs";
    localMAutoDBInfo.colsMap.put("raw_attrs", "BLOB");
    localStringBuilder.append(" raw_attrs BLOB");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(123984);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */