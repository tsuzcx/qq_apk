package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fi
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int ctM;
  private static final int ctS;
  private static final int cxe = "msgType".hashCode();
  private static final int dfo = "msgSubType".hashCode();
  private static final int dfp;
  private boolean crc = true;
  private boolean ctD = true;
  private boolean ctI = true;
  private boolean ctQ = true;
  private boolean cwQ = true;
  private boolean dfm = true;
  private boolean dfn = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  
  static
  {
    ctM = "path".hashCode();
    ctS = "size".hashCode();
    dfp = "msgtime".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (crg != k) {
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (cxe == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (dfo == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (ctM == k) {
        this.field_path = paramCursor.getString(i);
      } else if (ctS == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (dfp == k) {
        this.field_msgtime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cwQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.dfm) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.ctI) {
      localContentValues.put("path", this.field_path);
    }
    if (this.ctQ) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.dfn) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.fi
 * JD-Core Version:    0.7.0.1
 */