package com.tencent.mm.plugin.appbrand.game.a.a;

import com.tencent.mm.h.c.fn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends fn
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "RecordId";
    locala.ujN.put("RecordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" RecordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "RecordId";
    locala.columns[1] = "AppId";
    locala.ujN.put("AppId", "TEXT");
    localStringBuilder.append(" AppId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "AppName";
    locala.ujN.put("AppName", "TEXT");
    localStringBuilder.append(" AppName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "UserName";
    locala.ujN.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "IconUrl";
    locala.ujN.put("IconUrl", "TEXT");
    localStringBuilder.append(" IconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "BriefIntro";
    locala.ujN.put("BriefIntro", "TEXT");
    localStringBuilder.append(" BriefIntro TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSync";
    locala.ujN.put("isSync", "INTEGER default 'false' ");
    localStringBuilder.append(" isSync INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "debugType";
    locala.ujN.put("debugType", "INTEGER");
    localStringBuilder.append(" debugType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "createTime";
    locala.ujN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.a.b
 * JD-Core Version:    0.7.0.1
 */