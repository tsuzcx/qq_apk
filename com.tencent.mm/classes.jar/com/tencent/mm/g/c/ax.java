package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ax
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emY = "createTime".hashCode();
  private static final int eyA = "labelID".hashCode();
  private static final int eyB = "labelName".hashCode();
  private static final int eyC = "labelPYFull".hashCode();
  private static final int eyD = "labelPYShort".hashCode();
  private static final int eyE = "isTemporary".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emB = true;
  private boolean eyv = true;
  private boolean eyw = true;
  private boolean eyx = true;
  private boolean eyy = true;
  private boolean eyz = true;
  public long field_createTime;
  public boolean field_isTemporary;
  public int field_labelID;
  public String field_labelName;
  public String field_labelPYFull;
  public String field_labelPYShort;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eyA != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.eyv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eyB == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (eyC == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (eyD == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (emY == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (eyE == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isTemporary = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eyv) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.eyw) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.eyx) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.eyy) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eyz) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ax
 * JD-Core Version:    0.7.0.1
 */