package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.n;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

final class w$a
  extends n
{
  static final c.a fkk;
  static final String[] gUa;
  
  static
  {
    AppMethodBeat.i(129673);
    gUa = new String[] { "brandId", "versionType", "scene" };
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.yrM.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "recordId";
    locala.columns[1] = "brandId";
    locala.yrM.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "versionType";
    locala.yrM.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.yrM.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(129673);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(129672);
    this.systemRowid = 0L;
    ContentValues localContentValues = super.convertTo();
    int i = w.K(this.field_brandId, this.field_versionType, this.field_scene);
    this.field_recordId = i;
    localContentValues.put("recordId", Integer.valueOf(i));
    AppMethodBeat.o(129672);
    return localContentValues;
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w.a
 * JD-Core Version:    0.7.0.1
 */