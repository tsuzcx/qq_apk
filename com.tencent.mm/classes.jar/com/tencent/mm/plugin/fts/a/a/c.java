package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.br;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends br
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(114237);
    c.a locala = new c.a();
    locala.yrK = new Field[12];
    locala.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "featureId";
    locala.yrM.put("featureId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" featureId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "featureId";
    locala.columns[1] = "title";
    locala.yrM.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "titlePY";
    locala.yrM.put("titlePY", "TEXT");
    localStringBuilder.append(" titlePY TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "titleShortPY";
    locala.yrM.put("titleShortPY", "TEXT");
    localStringBuilder.append(" titleShortPY TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tag";
    locala.yrM.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionType";
    locala.yrM.put("actionType", "INTEGER default '0' ");
    localStringBuilder.append(" actionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "helpUrl";
    locala.yrM.put("helpUrl", "TEXT");
    localStringBuilder.append(" helpUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateUrl";
    locala.yrM.put("updateUrl", "TEXT");
    localStringBuilder.append(" updateUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "androidUrl";
    locala.yrM.put("androidUrl", "TEXT");
    localStringBuilder.append(" androidUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "iconPath";
    locala.yrM.put("iconPath", "TEXT");
    localStringBuilder.append(" iconPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "timestamp";
    locala.yrM.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    locala.columns[12] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(114237);
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
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114236);
    String str = "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
    AppMethodBeat.o(114236);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.c
 * JD-Core Version:    0.7.0.1
 */