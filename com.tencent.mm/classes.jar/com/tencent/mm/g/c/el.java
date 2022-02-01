package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class el
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBo = "subtype".hashCode();
  private static final int fQA = "minilogoMd5".hashCode();
  private static final int fQy = "bubbleMd5".hashCode();
  private static final int fQz = "coverMd5".hashCode();
  private static final int flv = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBm = true;
  private boolean fQv = true;
  private boolean fQw = true;
  private boolean fQx = true;
  public String field_bubbleMd5;
  public String field_coverMd5;
  public String field_minilogoMd5;
  public int field_subtype;
  public int field_version;
  private boolean flq = true;
  
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
      if (fBo != k) {
        break label65;
      }
      this.field_subtype = paramCursor.getInt(i);
      this.fBm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fQy == k) {
        this.field_bubbleMd5 = paramCursor.getString(i);
      } else if (fQz == k) {
        this.field_coverMd5 = paramCursor.getString(i);
      } else if (fQA == k) {
        this.field_minilogoMd5 = paramCursor.getString(i);
      } else if (flv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fBm) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.fQv) {
      localContentValues.put("bubbleMd5", this.field_bubbleMd5);
    }
    if (this.fQw) {
      localContentValues.put("coverMd5", this.field_coverMd5);
    }
    if (this.fQx) {
      localContentValues.put("minilogoMd5", this.field_minilogoMd5);
    }
    if (this.flq) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.el
 * JD-Core Version:    0.7.0.1
 */