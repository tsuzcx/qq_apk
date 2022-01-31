package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int ctF = "username".hashCode();
  private static final int ctG;
  private static final int ctL = "fetchType".hashCode();
  private static final int ctM;
  private static final int ctN;
  private static final int ctO;
  private boolean csQ = true;
  private boolean ctD = true;
  private boolean ctE = true;
  private boolean ctH = true;
  private boolean ctI = true;
  private boolean ctJ = true;
  private boolean ctK = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    ctG = "updateTime".hashCode();
    ctM = "path".hashCode();
    ctN = "query".hashCode();
    csS = "scene".hashCode();
    ctO = "data".hashCode();
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
      if (ctF != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ctL == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ctM == k) {
        this.field_path = paramCursor.getString(i);
      } else if (ctN == k) {
        this.field_query = paramCursor.getString(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (ctO == k) {
        this.field_data = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ctH) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ctI) {
      localContentValues.put("path", this.field_path);
    }
    if (this.ctJ) {
      localContentValues.put("query", this.field_query);
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.ctK) {
      localContentValues.put("data", this.field_data);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.j
 * JD-Core Version:    0.7.0.1
 */