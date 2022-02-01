package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
  private static final int eDc = "status".hashCode();
  private static final int eMP = "code_id".hashCode();
  private static final int eMQ;
  private static final int eMl = "card_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eLS = true;
  private boolean eMN = true;
  private boolean eMO = true;
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  
  static
  {
    eMQ = "code".hashCode();
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
      if (eMP != k) {
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
      if (eMl == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (eMQ == k) {
        this.field_code = paramCursor.getString(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eMN) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.eLS) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eMO) {
      localContentValues.put("code", this.field_code);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ar
 * JD-Core Version:    0.7.0.1
 */