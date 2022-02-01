package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ekU = "createTime".hashCode();
  private static final int ewd = "labelID".hashCode();
  private static final int ewe = "labelName".hashCode();
  private static final int ewf = "labelPYFull".hashCode();
  private static final int ewg = "labelPYShort".hashCode();
  private static final int ewh = "isTemporary".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ekx = true;
  private boolean evY = true;
  private boolean evZ = true;
  private boolean ewa = true;
  private boolean ewb = true;
  private boolean ewc = true;
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
      if (ewd != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.evY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ewe == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (ewf == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (ewg == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (ekU == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (ewh == k)
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
    if (this.evY) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.evZ) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.ewa) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.ewb) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ewc) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aw
 * JD-Core Version:    0.7.0.1
 */