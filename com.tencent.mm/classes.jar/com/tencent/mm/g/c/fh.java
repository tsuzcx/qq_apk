package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDj = "fileName".hashCode();
  private static final int eWV;
  private static final int eWW;
  private static final int eWX;
  private static final int eWY;
  private static final int eWZ;
  private static final int eXa = "eggIndex".hashCode();
  private static final int eXb = "position".hashCode();
  private static final int eoK = "flag".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eCG = true;
  private boolean eWO = true;
  private boolean eWP = true;
  private boolean eWQ = true;
  private boolean eWR = true;
  private boolean eWS = true;
  private boolean eWT = true;
  private boolean eWU = true;
  private boolean eoI = true;
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
    eWV = "cnValue".hashCode();
    eWW = "qqValue".hashCode();
    eWX = "twValue".hashCode();
    eWY = "enValue".hashCode();
    eWZ = "thValue".hashCode();
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
      if (eWV == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (eWW == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (eWX == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (eWY == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (eWZ == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (eDj == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (eXa == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (eXb == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (eoK == k) {
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
    if (this.eWO) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.eWP) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.eWQ) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.eWR) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.eWS) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.eCG) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.eWT) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.eWU) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fh
 * JD-Core Version:    0.7.0.1
 */