package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import com.tencent.mm.h.c.ek;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ek
{
  public static c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tmplName";
    locala.ujN.put("tmplName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tmplName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "tmplName";
    locala.columns[1] = "version";
    locala.ujN.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.ujN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "versionLowerBound";
    locala.ujN.put("versionLowerBound", "INTEGER");
    localStringBuilder.append(" versionLowerBound INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "downloadUrl";
    locala.ujN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportId";
    locala.ujN.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "FullVersion";
    locala.ujN.put("FullVersion", "TEXT");
    localStringBuilder.append(" FullVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "downloadTime";
    locala.ujN.put("downloadTime", "LONG");
    localStringBuilder.append(" downloadTime LONG");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
  
  public final String toString()
  {
    return "LocalTmplInfo{field_tmplName='" + this.field_tmplName + '\'' + ", field_version=" + this.field_version + ", field_md5='" + this.field_md5 + '\'' + ", field_filePath='" + this.field_filePath + '\'' + ", field_versionLowerBound=" + this.field_versionLowerBound + ", field_downloadUrl='" + this.field_downloadUrl + '\'' + ", field_reportId=" + this.field_reportId + ", field_FullVersion='" + this.field_FullVersion + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b
 * JD-Core Version:    0.7.0.1
 */