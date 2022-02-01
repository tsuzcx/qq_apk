package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gf
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCq = "fileName".hashCode();
  private static final int fZg;
  private static final int fZh;
  private static final int fZi;
  private static final int fZj;
  private static final int fZk;
  private static final int fZl = "eggIndex".hashCode();
  private static final int fZm = "position".hashCode();
  private static final int fni = "flag".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean fBM = true;
  private boolean fYZ = true;
  private boolean fZa = true;
  private boolean fZb = true;
  private boolean fZc = true;
  private boolean fZd = true;
  private boolean fZe = true;
  private boolean fZf = true;
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
  private boolean fng = true;
  
  static
  {
    fZg = "cnValue".hashCode();
    fZh = "qqValue".hashCode();
    fZi = "twValue".hashCode();
    fZj = "enValue".hashCode();
    fZk = "thValue".hashCode();
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
      if (fZg == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (fZh == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (fZi == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (fZj == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (fZk == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (fCq == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fZl == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (fZm == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (fni == k) {
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
    if (this.fYZ) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.fZa) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.fZb) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.fZc) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.fZd) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.fBM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fZe) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.fZf) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.gf
 * JD-Core Version:    0.7.0.1
 */