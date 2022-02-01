package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHX = "flag".hashCode();
  private static final int eXb;
  private static final int fsA;
  private static final int fsB;
  private static final int fsC;
  private static final int fsD;
  private static final int fsx;
  private static final int fsy;
  private static final int fsz;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eHV = true;
  private boolean eWy = true;
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
  private boolean fsq = true;
  private boolean fsr = true;
  private boolean fss = true;
  private boolean fst = true;
  private boolean fsu = true;
  private boolean fsv = true;
  private boolean fsw = true;
  
  static
  {
    fsx = "cnValue".hashCode();
    fsy = "qqValue".hashCode();
    fsz = "twValue".hashCode();
    fsA = "enValue".hashCode();
    fsB = "thValue".hashCode();
    eXb = "fileName".hashCode();
    fsC = "eggIndex".hashCode();
    fsD = "position".hashCode();
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fsx == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (fsy == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (fsz == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (fsA == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (fsB == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (eXb == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fsC == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (fsD == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.fsq) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.fsr) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.fss) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.fst) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.fsu) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.eWy) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fsv) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.fsw) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */