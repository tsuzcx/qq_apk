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
  static final c.a hEe;
  static final String[] jFa;
  
  static
  {
    AppMethodBeat.i(44607);
    jFa = new String[] { "brandId", "versionType", "scene" };
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.IhC.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "recordId";
    locala.columns[1] = "brandId";
    locala.IhC.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "versionType";
    locala.IhC.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.IhC.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "usedInThirdPartyAppRecently";
    locala.IhC.put("usedInThirdPartyAppRecently", "INTEGER default 'false' ");
    localStringBuilder.append(" usedInThirdPartyAppRecently INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "thirdPartyAppUsingDesc";
    locala.IhC.put("thirdPartyAppUsingDesc", "TEXT");
    localStringBuilder.append(" thirdPartyAppUsingDesc TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(44607);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(44606);
    this.systemRowid = 0L;
    ContentValues localContentValues = super.convertTo();
    int i = y.I(this.field_brandId, this.field_versionType, this.field_scene);
    this.field_recordId = i;
    localContentValues.put("recordId", Integer.valueOf(i));
    AppMethodBeat.o(44606);
    return localContentValues;
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y.a
 * JD-Core Version:    0.7.0.1
 */