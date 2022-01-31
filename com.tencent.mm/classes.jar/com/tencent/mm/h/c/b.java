package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int cre;
  private static final int crh = "rowid".hashCode();
  private static final int crl = "billNo".hashCode();
  private static final int crm;
  private static final int crn;
  private boolean cra = true;
  private boolean cri = true;
  private boolean crj = true;
  private boolean crk = true;
  public String field_billNo;
  public boolean field_insertmsg;
  public long field_localMsgId;
  public int field_status;
  
  static
  {
    cre = "insertmsg".hashCode();
    crm = "localMsgId".hashCode();
    crn = "status".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (crl != k) {
        break label65;
      }
      this.field_billNo = paramCursor.getString(i);
      this.cri = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cre == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (crm == k) {
        this.field_localMsgId = paramCursor.getLong(i);
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
    if (this.cri) {
      localContentValues.put("billNo", this.field_billNo);
    }
    if (this.cra) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.crj) {
      localContentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
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
 * Qualified Name:     com.tencent.mm.h.c.b
 * JD-Core Version:    0.7.0.1
 */