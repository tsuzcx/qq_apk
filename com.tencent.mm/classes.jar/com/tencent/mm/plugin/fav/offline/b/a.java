package com.tencent.mm.plugin.fav.offline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bz
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public boolean tcL = true;
  
  static
  {
    AppMethodBeat.i(73565);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "imgDirPath";
    localMAutoDBInfo.colsMap.put("imgDirPath", "TEXT");
    localStringBuilder.append(" imgDirPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "imgPaths";
    localMAutoDBInfo.colsMap.put("imgPaths", "TEXT");
    localStringBuilder.append(" imgPaths TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "favTime";
    localMAutoDBInfo.colsMap.put("favTime", "LONG");
    localStringBuilder.append(" favTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "failNum";
    localMAutoDBInfo.colsMap.put("failNum", "INTEGER");
    localStringBuilder.append(" failNum INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isReport";
    localMAutoDBInfo.colsMap.put("isReport", "INTEGER");
    localStringBuilder.append(" isReport INTEGER");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(73565);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73564);
    String str = "FavOffline{isMustWifi=" + this.tcL + ", field_url='" + this.field_url + '\'' + ", field_size=" + this.field_size + ", field_path='" + this.field_path + '\'' + ", field_imgDirPath='" + this.field_imgDirPath + '\'' + ", field_imgPaths='" + this.field_imgPaths + '\'' + ", field_favTime=" + this.field_favTime + ", field_updateTime=" + this.field_updateTime + ", field_status=" + this.field_status + ", field_failNum=" + this.field_failNum + ", field_isReport=" + this.field_isReport + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(73564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.b.a
 * JD-Core Version:    0.7.0.1
 */