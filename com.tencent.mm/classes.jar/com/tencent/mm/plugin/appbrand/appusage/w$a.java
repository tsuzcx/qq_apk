package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.mm.h.c.m;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

final class w$a
  extends m
{
  static final c.a dUa;
  static final String[] fCT = { "brandId", "versionType", "scene" };
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.ujN.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "recordId";
    locala.columns[1] = "brandId";
    locala.ujN.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "versionType";
    locala.ujN.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.ujN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
  
  public final ContentValues vf()
  {
    this.ujK = 0L;
    ContentValues localContentValues = super.vf();
    int i = w.y(this.field_brandId, this.field_versionType, this.field_scene);
    this.field_recordId = i;
    localContentValues.put("recordId", Integer.valueOf(i));
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w.a
 * JD-Core Version:    0.7.0.1
 */