package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgM = "createTime".hashCode();
  private static final int drm = "labelID".hashCode();
  private static final int drn = "labelName".hashCode();
  private static final int dro = "labelPYFull".hashCode();
  private static final int drp = "labelPYShort".hashCode();
  private static final int drq = "isTemporary".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgp = true;
  private boolean drh = true;
  private boolean dri = true;
  private boolean drj = true;
  private boolean drk = true;
  private boolean drl = true;
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
      if (drm != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.drh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (drn == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (dro == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (drp == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (dgM == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (drq == k)
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
    if (this.drh) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.dri) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.drj) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.drk) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.drl) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.as
 * JD-Core Version:    0.7.0.1
 */