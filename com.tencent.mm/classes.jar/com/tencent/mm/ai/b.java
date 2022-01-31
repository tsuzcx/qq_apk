package com.tencent.mm.ai;

import com.tencent.mm.h.c.ad;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ad
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.ujN.put("userName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "userName";
    locala.columns[1] = "qyUin";
    locala.ujN.put("qyUin", "INTEGER");
    localStringBuilder.append(" qyUin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "userUin";
    locala.ujN.put("userUin", "INTEGER");
    localStringBuilder.append(" userUin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "userFlag";
    locala.ujN.put("userFlag", "INTEGER");
    localStringBuilder.append(" userFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "wwExposeTimes";
    locala.ujN.put("wwExposeTimes", "INTEGER");
    localStringBuilder.append(" wwExposeTimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "wwMaxExposeTimes";
    locala.ujN.put("wwMaxExposeTimes", "INTEGER");
    localStringBuilder.append(" wwMaxExposeTimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wwCorpId";
    locala.ujN.put("wwCorpId", "LONG");
    localStringBuilder.append(" wwCorpId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "wwUserVid";
    locala.ujN.put("wwUserVid", "LONG");
    localStringBuilder.append(" wwUserVid LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "userType";
    locala.ujN.put("userType", "INTEGER");
    localStringBuilder.append(" userType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "chatOpen";
    locala.ujN.put("chatOpen", "INTEGER");
    localStringBuilder.append(" chatOpen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "wwUnreadCnt";
    locala.ujN.put("wwUnreadCnt", "INTEGER default '0' ");
    localStringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "show_confirm";
    locala.ujN.put("show_confirm", "INTEGER");
    localStringBuilder.append(" show_confirm INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "use_preset_banner_tips";
    locala.ujN.put("use_preset_banner_tips", "INTEGER");
    localStringBuilder.append(" use_preset_banner_tips INTEGER");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */