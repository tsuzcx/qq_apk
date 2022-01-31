package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends gb
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(130108);
    c.a locala = new c.a();
    locala.yrK = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "RecordId";
    locala.yrM.put("RecordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" RecordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "RecordId";
    locala.columns[1] = "AppId";
    locala.yrM.put("AppId", "TEXT");
    localStringBuilder.append(" AppId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "AppName";
    locala.yrM.put("AppName", "TEXT");
    localStringBuilder.append(" AppName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "UserName";
    locala.yrM.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "IconUrl";
    locala.yrM.put("IconUrl", "TEXT");
    localStringBuilder.append(" IconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "BriefIntro";
    locala.yrM.put("BriefIntro", "TEXT");
    localStringBuilder.append(" BriefIntro TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSync";
    locala.yrM.put("isSync", "INTEGER default 'false' ");
    localStringBuilder.append(" isSync INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "debugType";
    locala.yrM.put("debugType", "INTEGER");
    localStringBuilder.append(" debugType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(130108);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */