package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.p;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class y$a
  extends p
{
  static final c.a gLr;
  static final String[] iLd;
  
  static
  {
    AppMethodBeat.i(44607);
    iLd = new String[] { "brandId", "versionType", "scene" };
    c.a locala = new c.a();
    locala.EYt = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.EYv.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "recordId";
    locala.columns[1] = "brandId";
    locala.EYv.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "versionType";
    locala.EYv.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.EYv.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    gLr = locala;
    AppMethodBeat.o(44607);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(44606);
    this.systemRowid = 0L;
    ContentValues localContentValues = super.convertTo();
    int i = y.H(this.field_brandId, this.field_versionType, this.field_scene);
    this.field_recordId = i;
    localContentValues.put("recordId", Integer.valueOf(i));
    AppMethodBeat.o(44606);
    return localContentValues;
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y.a
 * JD-Core Version:    0.7.0.1
 */