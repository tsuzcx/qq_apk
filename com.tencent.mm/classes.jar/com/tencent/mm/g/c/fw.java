package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJG = "flag".hashCode();
  private static final int eYM;
  private static final int fuA;
  private static final int fuB;
  private static final int fuC;
  private static final int fuD;
  private static final int fux;
  private static final int fuy;
  private static final int fuz;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eJE = true;
  private boolean eYj = true;
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
  private boolean fuq = true;
  private boolean fur = true;
  private boolean fus = true;
  private boolean fut = true;
  private boolean fuu = true;
  private boolean fuv = true;
  private boolean fuw = true;
  
  static
  {
    fux = "cnValue".hashCode();
    fuy = "qqValue".hashCode();
    fuz = "twValue".hashCode();
    fuA = "enValue".hashCode();
    fuB = "thValue".hashCode();
    eYM = "fileName".hashCode();
    fuC = "eggIndex".hashCode();
    fuD = "position".hashCode();
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
      if (fux == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (fuy == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (fuz == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (fuA == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (fuB == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (eYM == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fuC == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (fuD == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (eJG == k) {
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
    if (this.fuq) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.fur) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.fus) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.fut) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.fuu) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.eYj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fuv) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.fuw) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fw
 * JD-Core Version:    0.7.0.1
 */