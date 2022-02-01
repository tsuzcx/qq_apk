package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bz
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(131673);
    c.a locala = new c.a();
    locala.GvF = new Field[12];
    locala.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "featureId";
    locala.GvH.put("featureId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" featureId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "featureId";
    locala.columns[1] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "titlePY";
    locala.GvH.put("titlePY", "TEXT");
    localStringBuilder.append(" titlePY TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "titleShortPY";
    locala.GvH.put("titleShortPY", "TEXT");
    localStringBuilder.append(" titleShortPY TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tag";
    locala.GvH.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionType";
    locala.GvH.put("actionType", "INTEGER default '0' ");
    localStringBuilder.append(" actionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "url";
    locala.GvH.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "helpUrl";
    locala.GvH.put("helpUrl", "TEXT");
    localStringBuilder.append(" helpUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateUrl";
    locala.GvH.put("updateUrl", "TEXT");
    localStringBuilder.append(" updateUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "androidUrl";
    locala.GvH.put("androidUrl", "TEXT");
    localStringBuilder.append(" androidUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "iconPath";
    locala.GvH.put("iconPath", "TEXT");
    localStringBuilder.append(" iconPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "timestamp";
    locala.GvH.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    locala.columns[12] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
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
  
  public final c.a getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d
 * JD-Core Version:    0.7.0.1
 */