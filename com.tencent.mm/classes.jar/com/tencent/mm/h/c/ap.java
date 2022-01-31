package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ap
  extends c
{
  private static final int cCW = "cmdbuf".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private boolean cCV = true;
  private boolean ctD = true;
  public byte[] field_cmdbuf;
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
      if (cCW == k) {
        this.field_cmdbuf = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cCV) {
      localContentValues.put("cmdbuf", this.field_cmdbuf);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.ap
 * JD-Core Version:    0.7.0.1
 */