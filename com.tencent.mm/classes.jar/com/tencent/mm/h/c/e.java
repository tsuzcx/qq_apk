package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class e
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crR = "mau".hashCode();
  private static final int crS = "dau".hashCode();
  private static final int crT = "useTime".hashCode();
  private static final int crh = "rowid".hashCode();
  private boolean crM = true;
  private boolean crN = true;
  private boolean crO = true;
  private boolean crP = true;
  public int field_dau;
  public int field_key;
  public int field_mau;
  public long field_useTime;
  
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
      if (crQ != k) {
        break label65;
      }
      this.field_key = paramCursor.getInt(i);
      this.crM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crR == k) {
        this.field_mau = paramCursor.getInt(i);
      } else if (crS == k) {
        this.field_dau = paramCursor.getInt(i);
      } else if (crT == k) {
        this.field_useTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", Integer.valueOf(this.field_key));
    }
    if (this.crN) {
      localContentValues.put("mau", Integer.valueOf(this.field_mau));
    }
    if (this.crO) {
      localContentValues.put("dau", Integer.valueOf(this.field_dau));
    }
    if (this.crP) {
      localContentValues.put("useTime", Long.valueOf(this.field_useTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.e
 * JD-Core Version:    0.7.0.1
 */