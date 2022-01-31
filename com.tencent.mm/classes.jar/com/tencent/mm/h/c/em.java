package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class em
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF;
  private static final int ctl;
  private static final int cvm = "openId".hashCode();
  private boolean csU = true;
  private boolean ctD = true;
  private boolean cuP = true;
  public String field_appId;
  public String field_openId;
  public String field_username;
  
  static
  {
    ctl = "appId".hashCode();
    ctF = "username".hashCode();
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
      if (cvm != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.cuP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cuP) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.em
 * JD-Core Version:    0.7.0.1
 */