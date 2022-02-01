package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKB = "receiveTime".hashCode();
  private static final int eXs = "receiveStatus".hashCode();
  private static final int fgu = "mNativeUrl".hashCode();
  private static final int fgv = "hbType".hashCode();
  private static final int fgw = "receiveAmount".hashCode();
  private static final int fgx = "hbStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKq = true;
  private boolean eXp = true;
  private boolean fgq = true;
  private boolean fgr = true;
  private boolean fgs = true;
  private boolean fgt = true;
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
      if (fgu != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.fgq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fgv == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (fgw == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (eKB == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (eXs == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (fgx == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fgq) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.fgr) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.fgs) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.eKq) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.eXp) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.fgt) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gm
 * JD-Core Version:    0.7.0.1
 */