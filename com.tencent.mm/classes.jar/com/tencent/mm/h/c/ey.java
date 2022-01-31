package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ey
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl = "appId".hashCode();
  private static final int ddH = "occupation".hashCode();
  private boolean csU = true;
  private boolean ddG = true;
  public String field_appId;
  public long field_occupation;
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.ujN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appId";
    locala.columns[1] = "occupation";
    locala.ujN.put("occupation", "LONG");
    localStringBuilder.append(" occupation LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ctl != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.csU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ddH == k) {
        this.field_occupation = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ddG) {
      localContentValues.put("occupation", Long.valueOf(this.field_occupation));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.ey
 * JD-Core Version:    0.7.0.1
 */