package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int ctt;
  private static final int cwt = "appMsgContextId".hashCode();
  private static final int cwu = "url".hashCode();
  private static final int cwv;
  private static final int cww;
  private static final int cwx;
  private boolean csf = true;
  private boolean ctc = true;
  private boolean cwo = true;
  private boolean cwp = true;
  private boolean cwq = true;
  private boolean cwr = true;
  private boolean cws = true;
  public int field_appMsgContextId;
  public String field_content;
  public String field_forceUrl;
  public long field_invalidTime;
  public int field_lastModifyTime;
  public int field_tmplVersion;
  public String field_url;
  
  static
  {
    csD = "content".hashCode();
    cwv = "invalidTime".hashCode();
    cww = "forceUrl".hashCode();
    ctt = "lastModifyTime".hashCode();
    cwx = "tmplVersion".hashCode();
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
      if (cwt != k) {
        break label65;
      }
      this.field_appMsgContextId = paramCursor.getInt(i);
      this.cwo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cwu == k) {
        this.field_url = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cwv == k) {
        this.field_invalidTime = paramCursor.getLong(i);
      } else if (cww == k) {
        this.field_forceUrl = paramCursor.getString(i);
      } else if (ctt == k) {
        this.field_lastModifyTime = paramCursor.getInt(i);
      } else if (cwx == k) {
        this.field_tmplVersion = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwo) {
      localContentValues.put("appMsgContextId", Integer.valueOf(this.field_appMsgContextId));
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.cwq) {
      localContentValues.put("invalidTime", Long.valueOf(this.field_invalidTime));
    }
    if (this.cwr) {
      localContentValues.put("forceUrl", this.field_forceUrl);
    }
    if (this.ctc) {
      localContentValues.put("lastModifyTime", Integer.valueOf(this.field_lastModifyTime));
    }
    if (this.cws) {
      localContentValues.put("tmplVersion", Integer.valueOf(this.field_tmplVersion));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.x
 * JD-Core Version:    0.7.0.1
 */