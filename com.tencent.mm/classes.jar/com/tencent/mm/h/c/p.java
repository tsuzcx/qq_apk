package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class p
  extends c
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandStarAppOrderSequenceIndex ON AppBrandStarApp(orderSequence)" };
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int ctG;
  private static final int ctY = "versionType".hashCode();
  private static final int cuo;
  private boolean ctD = true;
  private boolean ctE = true;
  private boolean ctV = true;
  private boolean cun = true;
  public long field_orderSequence;
  public long field_updateTime;
  public String field_username;
  public int field_versionType;
  
  static
  {
    ctG = "updateTime".hashCode();
    cuo = "orderSequence".hashCode();
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
      if (ctY == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (cuo == k) {
        this.field_orderSequence = paramCursor.getLong(i);
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
    if (this.ctV) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cun) {
      localContentValues.put("orderSequence", Long.valueOf(this.field_orderSequence));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.p
 * JD-Core Version:    0.7.0.1
 */