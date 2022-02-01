package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class az
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fvm = "labelID".hashCode();
  private static final int fvn = "labelName".hashCode();
  private static final int fvo = "labelPYFull".hashCode();
  private static final int fvp = "labelPYShort".hashCode();
  private static final int fvq = "isTemporary".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public boolean field_isTemporary;
  public int field_labelID;
  public String field_labelName;
  public String field_labelPYFull;
  public String field_labelPYShort;
  private boolean fvh = true;
  private boolean fvi = true;
  private boolean fvj = true;
  private boolean fvk = true;
  private boolean fvl = true;
  
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
      if (fvm != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.fvh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fvn == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (fvo == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (fvp == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (fvq == k)
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
    if (this.fvh) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.fvi) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.fvj) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.fvk) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fvl) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.az
 * JD-Core Version:    0.7.0.1
 */