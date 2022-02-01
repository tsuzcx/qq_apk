package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQD = "conRemark".hashCode();
  private static final int eQN = "encryptUsername".hashCode();
  private static final int fwV = "contactLabels".hashCode();
  private static final int fwW = "conDescription".hashCode();
  private static final int fwX = "conPhone".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQl = true;
  private boolean eQv = true;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  private boolean fwS = true;
  private boolean fwT = true;
  private boolean fwU = true;
  
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
      if (eQN != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.eQv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQD == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (fwV == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (fwW == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (fwX == k) {
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
    if (this.eQv) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.eQl) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.fwS) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.fwT) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.fwU) {
      localContentValues.put("conPhone", this.field_conPhone);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gk
 * JD-Core Version:    0.7.0.1
 */