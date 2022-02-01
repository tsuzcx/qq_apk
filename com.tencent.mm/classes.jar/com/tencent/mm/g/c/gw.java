package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fcV = "receiveTime".hashCode();
  private static final int fpI = "receiveStatus".hashCode();
  private static final int fyC = "mNativeUrl".hashCode();
  private static final int fyD = "hbType".hashCode();
  private static final int fyE = "receiveAmount".hashCode();
  private static final int fyF = "hbStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fcK = true;
  public int field_hbStatus;
  public int field_hbType;
  public String field_mNativeUrl;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  private boolean fpF = true;
  private boolean fyA = true;
  private boolean fyB = true;
  private boolean fyy = true;
  private boolean fyz = true;
  
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
      if (fyC != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.fyy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyD == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (fyE == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (fcV == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (fpI == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (fyF == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fyy) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.fyz) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.fyA) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.fcK) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.fpF) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.fyB) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gw
 * JD-Core Version:    0.7.0.1
 */