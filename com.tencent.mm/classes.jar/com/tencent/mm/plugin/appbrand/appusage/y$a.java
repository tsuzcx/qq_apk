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
  static final c.a hGW;
  static final String[] jHZ;
  
  static
  {
    AppMethodBeat.i(44607);
    jHZ = new String[] { "brandId", "versionType", "scene" };
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.IBN.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "recordId";
    locala.columns[1] = "brandId";
    locala.IBN.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "versionType";
    locala.IBN.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "usedInThirdPartyAppRecently";
    locala.IBN.put("usedInThirdPartyAppRecently", "INTEGER default 'false' ");
    localStringBuilder.append(" usedInThirdPartyAppRecently INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "thirdPartyAppUsingDesc";
    locala.IBN.put("thirdPartyAppUsingDesc", "TEXT");
    localStringBuilder.append(" thirdPartyAppUsingDesc TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    hGW = locala;
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
    return hGW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y.a
 * JD-Core Version:    0.7.0.1
 */