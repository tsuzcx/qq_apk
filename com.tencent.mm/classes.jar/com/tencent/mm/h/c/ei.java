package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ei
  extends c
{
  private static final int cCa = "conRemark".hashCode();
  private static final int cCk;
  private static final int cZg = "contactLabels".hashCode();
  private static final int cZh = "conDescription".hashCode();
  private static final int cZi = "conPhone".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cBJ = true;
  private boolean cBT = true;
  private boolean cZd = true;
  private boolean cZe = true;
  private boolean cZf = true;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  
  static
  {
    cCk = "encryptUsername".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cCk != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.cBT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cCa == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (cZg == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (cZh == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (cZi == k) {
        this.field_conPhone = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.cBT) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.cBJ) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.cZd) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.cZe) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.cZf) {
      localContentValues.put("conPhone", this.field_conPhone);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.ei
 * JD-Core Version:    0.7.0.1
 */