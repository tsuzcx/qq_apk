package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends aj
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(123984);
    c.a locala = new c.a();
    locala.GvF = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.GvH.put("userName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "userName";
    locala.columns[1] = "qyUin";
    locala.GvH.put("qyUin", "INTEGER");
    localStringBuilder.append(" qyUin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "userUin";
    locala.GvH.put("userUin", "INTEGER");
    localStringBuilder.append(" userUin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "userFlag";
    locala.GvH.put("userFlag", "INTEGER");
    localStringBuilder.append(" userFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "wwExposeTimes";
    locala.GvH.put("wwExposeTimes", "INTEGER");
    localStringBuilder.append(" wwExposeTimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "wwMaxExposeTimes";
    locala.GvH.put("wwMaxExposeTimes", "INTEGER");
    localStringBuilder.append(" wwMaxExposeTimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wwCorpId";
    locala.GvH.put("wwCorpId", "LONG");
    localStringBuilder.append(" wwCorpId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "wwUserVid";
    locala.GvH.put("wwUserVid", "LONG");
    localStringBuilder.append(" wwUserVid LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "userType";
    locala.GvH.put("userType", "INTEGER");
    localStringBuilder.append(" userType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "chatOpen";
    locala.GvH.put("chatOpen", "INTEGER");
    localStringBuilder.append(" chatOpen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "wwUnreadCnt";
    locala.GvH.put("wwUnreadCnt", "INTEGER default '0' ");
    localStringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "show_confirm";
    locala.GvH.put("show_confirm", "INTEGER");
    localStringBuilder.append(" show_confirm INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "use_preset_banner_tips";
    locala.GvH.put("use_preset_banner_tips", "INTEGER");
    localStringBuilder.append(" use_preset_banner_tips INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "hide_create_chat";
    locala.GvH.put("hide_create_chat", "INTEGER");
    localStringBuilder.append(" hide_create_chat INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "hide_mod_chat_member";
    locala.GvH.put("hide_mod_chat_member", "INTEGER");
    localStringBuilder.append(" hide_mod_chat_member INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "hide_colleage_invite";
    locala.GvH.put("hide_colleage_invite", "INTEGER default 'true' ");
    localStringBuilder.append(" hide_colleage_invite INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "raw_attrs";
    locala.GvH.put("raw_attrs", "BLOB");
    localStringBuilder.append(" raw_attrs BLOB");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(123984);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */