package com.tencent.mm.plugin.fav.offline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends by
{
  protected static c.a info;
  public boolean rDg = true;
  
  static
  {
    AppMethodBeat.i(73565);
    c.a locala = new c.a();
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "url";
    locala.IBN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "size";
    locala.IBN.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "path";
    locala.IBN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "imgDirPath";
    locala.IBN.put("imgDirPath", "TEXT");
    localStringBuilder.append(" imgDirPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "imgPaths";
    locala.IBN.put("imgPaths", "TEXT");
    localStringBuilder.append(" imgPaths TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "favTime";
    locala.IBN.put("favTime", "LONG");
    localStringBuilder.append(" favTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failNum";
    locala.IBN.put("failNum", "INTEGER");
    localStringBuilder.append(" failNum INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "isReport";
    locala.IBN.put("isReport", "INTEGER");
    localStringBuilder.append(" isReport INTEGER");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(73565);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73564);
    String str = "FavOffline{isMustWifi=" + this.rDg + ", field_url='" + this.field_url + '\'' + ", field_size=" + this.field_size + ", field_path='" + this.field_path + '\'' + ", field_imgDirPath='" + this.field_imgDirPath + '\'' + ", field_imgPaths='" + this.field_imgPaths + '\'' + ", field_favTime=" + this.field_favTime + ", field_updateTime=" + this.field_updateTime + ", field_status=" + this.field_status + ", field_failNum=" + this.field_failNum + ", field_isReport=" + this.field_isReport + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(73564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.b.a
 * JD-Core Version:    0.7.0.1
 */