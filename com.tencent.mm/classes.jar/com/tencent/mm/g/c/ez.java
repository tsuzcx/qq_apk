package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ez
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dQG = "contactLabels".hashCode();
  private static final int dQH = "conDescription".hashCode();
  private static final int dQI = "conPhone".hashCode();
  private static final int dqk;
  private static final int dqu = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dQD = true;
  private boolean dQE = true;
  private boolean dQF = true;
  private boolean dpS = true;
  private boolean dqc = true;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  
  static
  {
    dqk = "conRemark".hashCode();
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
      if (dqu != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.dqc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dqk == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (dQG == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (dQH == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (dQI == k) {
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
    if (this.dqc) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.dpS) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.dQD) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.dQE) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.dQF) {
      localContentValues.put("conPhone", this.field_conPhone);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ez
 * JD-Core Version:    0.7.0.1
 */