package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eZv = "contactLabels".hashCode();
  private static final int eZw = "conDescription".hashCode();
  private static final int eZx = "conPhone".hashCode();
  private static final int euX;
  private static final int evh = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eZs = true;
  private boolean eZt = true;
  private boolean eZu = true;
  private boolean euF = true;
  private boolean euP = true;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  
  static
  {
    euX = "conRemark".hashCode();
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
      if (evh != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.euP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (euX == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (eZv == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (eZw == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (eZx == k) {
        this.field_conPhone = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.euP) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.euF) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.eZs) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.eZt) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.eZu) {
      localContentValues.put("conPhone", this.field_conPhone);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */