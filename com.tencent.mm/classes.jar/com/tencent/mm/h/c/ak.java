package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  private static final int cAu;
  private static final int cAv;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int czR;
  private boolean cAs = true;
  private boolean cAt = true;
  private boolean crk = true;
  private boolean czz = true;
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  
  static
  {
    cAu = "code_id".hashCode();
    czR = "card_id".hashCode();
    cAv = "code".hashCode();
    crn = "status".hashCode();
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
      if (cAu != k) {
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
      if (czR == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (cAv == k) {
        this.field_code = paramCursor.getString(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cAs) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.czz) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.cAt) {
      localContentValues.put("code", this.field_code);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.ak
 * JD-Core Version:    0.7.0.1
 */