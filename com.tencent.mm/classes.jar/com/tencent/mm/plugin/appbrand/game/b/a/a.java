package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.he;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends he
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(45095);
    c.a locala = new c.a();
    locala.EYt = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "RecordId";
    locala.EYv.put("RecordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" RecordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "RecordId";
    locala.columns[1] = "AppId";
    locala.EYv.put("AppId", "TEXT");
    localStringBuilder.append(" AppId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "AppName";
    locala.EYv.put("AppName", "TEXT");
    localStringBuilder.append(" AppName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "UserName";
    locala.EYv.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "IconUrl";
    locala.EYv.put("IconUrl", "TEXT");
    localStringBuilder.append(" IconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "BriefIntro";
    locala.EYv.put("BriefIntro", "TEXT");
    localStringBuilder.append(" BriefIntro TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSync";
    locala.EYv.put("isSync", "INTEGER default 'false' ");
    localStringBuilder.append(" isSync INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "debugType";
    locala.EYv.put("debugType", "INTEGER");
    localStringBuilder.append(" debugType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "createTime";
    locala.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(45095);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */