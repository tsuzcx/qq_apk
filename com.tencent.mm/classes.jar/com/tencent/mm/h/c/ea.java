package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea
  extends c
{
  private static final int cJh;
  private static final int cXQ;
  private static final int cXR;
  private static final int cXS;
  private static final int cXT;
  private static final int cXU;
  private static final int cXV;
  private static final int cXW;
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int cwe;
  private boolean cIM = true;
  private boolean cXJ = true;
  private boolean cXK = true;
  private boolean cXL = true;
  private boolean cXM = true;
  private boolean cXN = true;
  private boolean cXO = true;
  private boolean cXP = true;
  private boolean crM = true;
  private boolean cwc = true;
  public String field_cnValue;
  public int field_eggIndex;
  public String field_enValue;
  public String field_fileName;
  public int field_flag;
  public String field_key;
  public int field_position;
  public String field_qqValue;
  public String field_thValue;
  public String field_twValue;
  
  static
  {
    cXQ = "cnValue".hashCode();
    cXR = "qqValue".hashCode();
    cXS = "twValue".hashCode();
    cXT = "enValue".hashCode();
    cXU = "thValue".hashCode();
    cJh = "fileName".hashCode();
    cXV = "eggIndex".hashCode();
    cXW = "position".hashCode();
    cwe = "flag".hashCode();
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
      if (crQ != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.crM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cXQ == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (cXR == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (cXS == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (cXT == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (cXU == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (cJh == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (cXV == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (cXW == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.cXJ) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.cXK) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.cXL) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.cXM) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.cXN) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.cIM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.cXO) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.cXP) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ea
 * JD-Core Version:    0.7.0.1
 */