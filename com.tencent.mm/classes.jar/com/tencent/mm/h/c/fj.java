package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fj
  extends c
{
  private static final int cTS = "reportId".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)" };
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int cvc = "appVersion".hashCode();
  private boolean cTP = true;
  private boolean ctD = true;
  private boolean cuF = true;
  public int field_appVersion;
  public int field_reportId;
  public String field_username;
  
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cvc == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (cTS == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cuF) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.cTP) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.fj
 * JD-Core Version:    0.7.0.1
 */