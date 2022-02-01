package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
  private static final int eEL = "status".hashCode();
  private static final int eNW;
  private static final int eOA = "code_id".hashCode();
  private static final int eOB;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eND = true;
  private boolean eOy = true;
  private boolean eOz = true;
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  
  static
  {
    eNW = "card_id".hashCode();
    eOB = "code".hashCode();
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
      if (eOA != k) {
        break label60;
      }
      this.field_code_id = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eNW == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (eOB == k) {
        this.field_code = paramCursor.getString(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOy) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.eND) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eOz) {
      localContentValues.put("code", this.field_code);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ar
 * JD-Core Version:    0.7.0.1
 */