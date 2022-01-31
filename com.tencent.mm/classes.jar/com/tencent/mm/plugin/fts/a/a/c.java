package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.h.c.bp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends bp
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[12];
    locala.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "featureId";
    locala.ujN.put("featureId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" featureId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "featureId";
    locala.columns[1] = "title";
    locala.ujN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "titlePY";
    locala.ujN.put("titlePY", "TEXT");
    localStringBuilder.append(" titlePY TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "titleShortPY";
    locala.ujN.put("titleShortPY", "TEXT");
    localStringBuilder.append(" titleShortPY TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tag";
    locala.ujN.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionType";
    locala.ujN.put("actionType", "INTEGER default '0' ");
    localStringBuilder.append(" actionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "helpUrl";
    locala.ujN.put("helpUrl", "TEXT");
    localStringBuilder.append(" helpUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateUrl";
    locala.ujN.put("updateUrl", "TEXT");
    localStringBuilder.append(" updateUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "androidUrl";
    locala.ujN.put("androidUrl", "TEXT");
    localStringBuilder.append(" androidUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "iconPath";
    locala.ujN.put("iconPath", "TEXT");
    localStringBuilder.append(" iconPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "timestamp";
    locala.ujN.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    locala.columns[12] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public c()
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
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    return "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.c
 * JD-Core Version:    0.7.0.1
 */