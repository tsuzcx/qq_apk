package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVB = "msgState".hashCode();
  private static final int eng = "content".hashCode();
  private static final int fkp = "shareKeyHash".hashCode();
  private static final int fkq = "btnState".hashCode();
  private static final int fkr = "contentColor".hashCode();
  private static final int fks = "updatePeroid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVy = true;
  private boolean emI = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  private boolean fkl = true;
  private boolean fkm = true;
  private boolean fkn = true;
  private boolean fko = true;
  
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
      if (fkp != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.fkl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkq == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (eVB == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fkr == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (fks == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkl) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.fkm) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.eVy) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fkn) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.fko) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hg
 * JD-Core Version:    0.7.0.1
 */