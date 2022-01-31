package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class em
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dOk;
  private static final int dOl;
  private static final int dOm;
  private static final int dOn;
  private static final int dOo;
  private static final int dOp = "eggIndex".hashCode();
  private static final int dOq = "position".hashCode();
  private static final int dkn = "flag".hashCode();
  private static final int dxX;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean dOd = true;
  private boolean dOe = true;
  private boolean dOf = true;
  private boolean dOg = true;
  private boolean dOh = true;
  private boolean dOi = true;
  private boolean dOj = true;
  private boolean dkl = true;
  private boolean dxw = true;
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
    dOk = "cnValue".hashCode();
    dOl = "qqValue".hashCode();
    dOm = "twValue".hashCode();
    dOn = "enValue".hashCode();
    dOo = "thValue".hashCode();
    dxX = "fileName".hashCode();
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
      if (dOk == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (dOl == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (dOm == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (dOn == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (dOo == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (dxX == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (dOp == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (dOq == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (dkn == k) {
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
    if (this.dOd) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.dOe) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.dOf) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.dOg) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.dOh) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.dxw) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.dOi) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.dOj) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.dkl) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.em
 * JD-Core Version:    0.7.0.1
 */