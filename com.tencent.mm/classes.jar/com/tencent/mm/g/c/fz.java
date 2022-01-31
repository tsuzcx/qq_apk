package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJG;
  private static final int dXj = "shareKeyHash".hashCode();
  private static final int dXk = "btnState".hashCode();
  private static final int dXl = "contentColor".hashCode();
  private static final int dXm = "updatePeroid".hashCode();
  private static final int dgT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJD = true;
  private boolean dXf = true;
  private boolean dXg = true;
  private boolean dXh = true;
  private boolean dXi = true;
  private boolean dgw = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  
  static
  {
    dJG = "msgState".hashCode();
    dgT = "content".hashCode();
  }
  
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
      if (dXj != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.dXf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dXk == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (dJG == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dXl == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (dXm == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dXf) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.dXg) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.dJD) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dXh) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.dXi) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.fz
 * JD-Core Version:    0.7.0.1
 */