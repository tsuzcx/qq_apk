package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class as
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
  private static final int fjl = "status".hashCode();
  private static final int frD;
  private static final int fsh = "code_id".hashCode();
  private static final int fsi;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  private boolean fji = true;
  private boolean frk = true;
  private boolean fsf = true;
  private boolean fsg = true;
  
  static
  {
    frD = "card_id".hashCode();
    fsi = "code".hashCode();
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
      if (fsh != k) {
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
      if (frD == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (fsi == k) {
        this.field_code = paramCursor.getString(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fsf) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.fsg) {
      localContentValues.put("code", this.field_code);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.as
 * JD-Core Version:    0.7.0.1
 */