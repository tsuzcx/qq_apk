package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkU = "brandUserName".hashCode();
  private static final int dlG = "userId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkG = true;
  private boolean dlF = true;
  public String field_brandUserName;
  public String field_userId;
  
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
      if (dkU != k) {
        break label65;
      }
      this.field_brandUserName = paramCursor.getString(i);
      this.dkG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dlG == k) {
        this.field_userId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dkG) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.dlF) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ac
 * JD-Core Version:    0.7.0.1
 */