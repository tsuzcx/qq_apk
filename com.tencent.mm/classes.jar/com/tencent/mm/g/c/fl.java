package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFD;
  private static final int eqO = "flag".hashCode();
  private static final int faj;
  private static final int fak;
  private static final int fal;
  private static final int fam;
  private static final int fan;
  private static final int fao;
  private static final int fap;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eFa = true;
  private boolean eqM = true;
  private boolean fac = true;
  private boolean fad = true;
  private boolean fae = true;
  private boolean faf = true;
  private boolean fag = true;
  private boolean fah = true;
  private boolean fai = true;
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
    faj = "cnValue".hashCode();
    fak = "qqValue".hashCode();
    fal = "twValue".hashCode();
    fam = "enValue".hashCode();
    fan = "thValue".hashCode();
    eFD = "fileName".hashCode();
    fao = "eggIndex".hashCode();
    fap = "position".hashCode();
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
      if (faj == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (fak == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (fal == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (fam == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (fan == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (eFD == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fao == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (fap == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (eqO == k) {
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
    if (this.fac) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.fad) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.fae) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.faf) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.fag) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.eFa) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fah) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.fai) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */