package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ie
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE = "content".hashCode();
  private static final int fUw;
  private static final int gjK = "shareKeyHash".hashCode();
  private static final int gjL = "btnState".hashCode();
  private static final int gjM = "contentColor".hashCode();
  private static final int gjN = "updatePeroid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  private boolean fUt = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  private boolean gjG = true;
  private boolean gjH = true;
  private boolean gjI = true;
  private boolean gjJ = true;
  
  static
  {
    fUw = "msgState".hashCode();
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
      if (gjK != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.gjG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gjL == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (fUw == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (gjM == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (gjN == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gjG) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.gjH) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.fUt) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.gjI) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.gjJ) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ie
 * JD-Core Version:    0.7.0.1
 */