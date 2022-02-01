package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int fCl = "permissionProtoBlob".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean fCk = true;
  public String field_appId;
  public byte[] field_permissionProtoBlob;
  
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
      if (eEU != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fCl == k) {
        this.field_permissionProtoBlob = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fCk) {
      localContentValues.put("permissionProtoBlob", this.field_permissionProtoBlob);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hn
 * JD-Core Version:    0.7.0.1
 */