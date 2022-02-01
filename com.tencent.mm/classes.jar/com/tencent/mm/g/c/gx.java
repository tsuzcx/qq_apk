package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fAC = "mNativeUrl".hashCode();
  private static final int fAD = "hbType".hashCode();
  private static final int fAE = "receiveAmount".hashCode();
  private static final int fAF = "hbStatus".hashCode();
  private static final int feN = "receiveTime".hashCode();
  private static final int frI = "receiveStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fAA = true;
  private boolean fAB = true;
  private boolean fAy = true;
  private boolean fAz = true;
  private boolean feB = true;
  public int field_hbStatus;
  public int field_hbType;
  public String field_mNativeUrl;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  private boolean frF = true;
  
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
      if (fAC != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.fAy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fAD == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (fAE == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (feN == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (frI == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (fAF == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fAy) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.fAz) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.fAA) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.feB) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.frF) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.fAB) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gx
 * JD-Core Version:    0.7.0.1
 */