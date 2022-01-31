package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au
  extends c
{
  private static final int cDO = "extJson".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctY;
  private static final int ctl = "appId".hashCode();
  private boolean cDN = true;
  private boolean csU = true;
  private boolean ctV = true;
  public String field_appId;
  public String field_extJson;
  public int field_versionType;
  
  static
  {
    ctY = "versionType".hashCode();
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
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ctY == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (cDO == k) {
        this.field_extJson = paramCursor.getString(i);
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
    if (this.ctV) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.cDN) {
      localContentValues.put("extJson", this.field_extJson);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.au
 * JD-Core Version:    0.7.0.1
 */