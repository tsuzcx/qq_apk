package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ah
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int czu = "canvasId".hashCode();
  private static final int czv = "canvasXml".hashCode();
  private boolean crX = true;
  private boolean czs = true;
  private boolean czt = true;
  public long field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  
  static
  {
    csv = "createTime".hashCode();
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
      if (czu != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getLong(i);
      this.czs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (czv == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.czs) {
      localContentValues.put("canvasId", Long.valueOf(this.field_canvasId));
    }
    if (this.czt) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.ah
 * JD-Core Version:    0.7.0.1
 */