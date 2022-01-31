package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctl = "appId".hashCode();
  private static final int cvf;
  private boolean crk = true;
  private boolean csU = true;
  private boolean cuI = true;
  public String field_appId;
  public long field_modifyTime;
  public int field_status;
  
  static
  {
    crn = "status".hashCode();
    cvf = "modifyTime".hashCode();
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
      if (ctl != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.csU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cvf == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cuI) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.av
 * JD-Core Version:    0.7.0.1
 */