package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAS = "receiveTime".hashCode();
  private static final int dLo = "receiveStatus".hashCode();
  private static final int dTJ = "mNativeUrl".hashCode();
  private static final int dTK = "hbType".hashCode();
  private static final int dTL = "receiveAmount".hashCode();
  private static final int dTM = "hbStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAK = true;
  private boolean dLm = true;
  private boolean dTF = true;
  private boolean dTG = true;
  private boolean dTH = true;
  private boolean dTI = true;
  public int field_hbStatus;
  public int field_hbType;
  public String field_mNativeUrl;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  
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
      if (dTJ != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.dTF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dTK == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (dTL == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (dAS == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (dLo == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (dTM == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTF) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.dTG) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.dTH) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.dAK) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.dLm) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.dTI) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fk
 * JD-Core Version:    0.7.0.1
 */