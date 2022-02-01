package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends cb
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(131673);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[12];
    localMAutoDBInfo.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "featureId";
    localMAutoDBInfo.colsMap.put("featureId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" featureId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "featureId";
    localMAutoDBInfo.columns[1] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "titlePY";
    localMAutoDBInfo.colsMap.put("titlePY", "TEXT");
    localStringBuilder.append(" titlePY TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "titleShortPY";
    localMAutoDBInfo.colsMap.put("titleShortPY", "TEXT");
    localStringBuilder.append(" titleShortPY TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionType";
    localMAutoDBInfo.colsMap.put("actionType", "INTEGER default '0' ");
    localStringBuilder.append(" actionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "helpUrl";
    localMAutoDBInfo.colsMap.put("helpUrl", "TEXT");
    localStringBuilder.append(" helpUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "updateUrl";
    localMAutoDBInfo.colsMap.put("updateUrl", "TEXT");
    localStringBuilder.append(" updateUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "androidUrl";
    localMAutoDBInfo.colsMap.put("androidUrl", "TEXT");
    localStringBuilder.append(" androidUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "iconPath";
    localMAutoDBInfo.colsMap.put("iconPath", "TEXT");
    localStringBuilder.append(" iconPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    localMAutoDBInfo.columns[12] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(131673);
  }
  
  public d()
  {
    this.field_featureId = 0;
    this.field_title = "";
    this.field_titlePY = "";
    this.field_titleShortPY = "";
    this.field_tag = "";
    this.field_actionType = 0;
    this.field_url = "";
    this.field_helpUrl = "";
    this.field_updateUrl = "";
    this.field_androidUrl = "";
    this.field_iconPath = "";
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131672);
    String str = "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
    AppMethodBeat.o(131672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d
 * JD-Core Version:    0.7.0.1
 */