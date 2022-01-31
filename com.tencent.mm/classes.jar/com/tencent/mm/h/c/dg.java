package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dg
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int ctG;
  private static final int cuv = "version".hashCode();
  private boolean crM = true;
  private boolean csQ = true;
  private boolean ctE = true;
  private boolean cup = true;
  public String field_key;
  public int field_scene;
  public long field_updateTime;
  public int field_version;
  
  static
  {
    csS = "scene".hashCode();
    ctG = "updateTime".hashCode();
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
      if (crQ != k) {
        break label60;
      }
      this.field_key = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cuv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.cup) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.dg
 * JD-Core Version:    0.7.0.1
 */