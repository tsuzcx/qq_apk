package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class u
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandStarAppOrderSequenceIndex ON AppBrandStarApp(orderSequence)" };
  private static final int fkQ;
  private static final int fln = "orderSequence".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public long field_orderSequence;
  public long field_updateTime;
  public String field_username;
  public int field_versionType;
  private boolean fkM = true;
  private boolean flm = true;
  
  static
  {
    fkQ = "versionType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (username_HASHCODE != k) {
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
      if (fkQ == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fln == k) {
        this.field_orderSequence = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fkM) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.flm) {
      localContentValues.put("orderSequence", Long.valueOf(this.field_orderSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.u
 * JD-Core Version:    0.7.0.1
 */