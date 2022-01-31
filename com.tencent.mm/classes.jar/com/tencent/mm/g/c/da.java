package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dGq = "bubbleMd5".hashCode();
  private static final int dGr = "coverMd5".hashCode();
  private static final int dGs = "minilogoMd5".hashCode();
  private static final int diB = "version".hashCode();
  private static final int dwY = "subtype".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dGn = true;
  private boolean dGo = true;
  private boolean dGp = true;
  private boolean div = true;
  private boolean dwW = true;
  public String field_bubbleMd5;
  public String field_coverMd5;
  public String field_minilogoMd5;
  public int field_subtype;
  public int field_version;
  
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
      if (dwY != k) {
        break label65;
      }
      this.field_subtype = paramCursor.getInt(i);
      this.dwW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dGq == k) {
        this.field_bubbleMd5 = paramCursor.getString(i);
      } else if (dGr == k) {
        this.field_coverMd5 = paramCursor.getString(i);
      } else if (dGs == k) {
        this.field_minilogoMd5 = paramCursor.getString(i);
      } else if (diB == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwW) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.dGn) {
      localContentValues.put("bubbleMd5", this.field_bubbleMd5);
    }
    if (this.dGo) {
      localContentValues.put("coverMd5", this.field_coverMd5);
    }
    if (this.dGp) {
      localContentValues.put("minilogoMd5", this.field_minilogoMd5);
    }
    if (this.div) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.da
 * JD-Core Version:    0.7.0.1
 */