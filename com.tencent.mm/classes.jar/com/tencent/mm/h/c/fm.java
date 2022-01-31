package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm
  extends c
{
  private static final int cPR;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl;
  private static final int dfZ;
  private boolean cPL = true;
  private boolean csU = true;
  private boolean dfY = true;
  public String field_appId;
  public int field_appIdHash;
  public boolean field_openDebug;
  
  static
  {
    cPR = "appIdHash".hashCode();
    ctl = "appId".hashCode();
    dfZ = "openDebug".hashCode();
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
      if (cPR != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.cPL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (dfZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_openDebug = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cPL) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dfY) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.fm
 * JD-Core Version:    0.7.0.1
 */