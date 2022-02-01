package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFV = "content".hashCode();
  private static final int fEA = "shareKeyHash".hashCode();
  private static final int fEB = "btnState".hashCode();
  private static final int fEC = "contentColor".hashCode();
  private static final int fED = "updatePeroid".hashCode();
  private static final int fpR = "msgState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFy = true;
  private boolean fEw = true;
  private boolean fEx = true;
  private boolean fEy = true;
  private boolean fEz = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  private boolean fpO = true;
  
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
      if (fEA != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.fEw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fEB == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (fpR == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fEC == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (fED == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fEw) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.fEx) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.fpO) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fEy) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.fEz) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hs
 * JD-Core Version:    0.7.0.1
 */