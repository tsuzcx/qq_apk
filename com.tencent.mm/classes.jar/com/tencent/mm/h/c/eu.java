package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eu
  extends c
{
  private static final int cLe;
  private static final int cVc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dcq = "mNativeUrl".hashCode();
  private static final int dcr = "hbType".hashCode();
  private static final int dcs = "receiveAmount".hashCode();
  private static final int dct;
  private boolean cKW = true;
  private boolean cVa = true;
  private boolean dcm = true;
  private boolean dcn = true;
  private boolean dco = true;
  private boolean dcp = true;
  public int field_hbStatus;
  public int field_hbType;
  public String field_mNativeUrl;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  
  static
  {
    cLe = "receiveTime".hashCode();
    cVc = "receiveStatus".hashCode();
    dct = "hbStatus".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (dcq != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.dcm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dcr == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (dcs == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (cLe == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (cVc == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (dct == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dcm) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.dcn) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.dco) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.cKW) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.cVa) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.dcp) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.eu
 * JD-Core Version:    0.7.0.1
 */