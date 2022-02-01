package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hz
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WechatSessionHistory");
  public static final Column hUX;
  public static final Column hUY;
  private static final int hVf = "ds".hashCode();
  private static final int hVg = "hour".hashCode();
  public static final Column iKA;
  public static final Column iKB;
  public static final Column iKC;
  private static final int iKJ = "lastSession".hashCode();
  private static final int iKK = "currSession".hashCode();
  private static final int iKL = "nextSession".hashCode();
  private static final int iKM = "enterMs".hashCode();
  private static final int iKN = "quitMs".hashCode();
  private static final int iKO = "stayMs".hashCode();
  public static final Column iKx;
  public static final Column iKy;
  public static final Column iKz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_currSession;
  public int field_ds;
  public long field_enterMs;
  public int field_hour;
  public String field_lastSession;
  public String field_nextSession;
  public long field_quitMs;
  public long field_stayMs;
  private boolean hVb = true;
  private boolean hVc = true;
  private boolean iKD = true;
  private boolean iKE = true;
  private boolean iKF = true;
  private boolean iKG = true;
  private boolean iKH = true;
  private boolean iKI = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WechatSessionHistory", "");
    hUX = new Column("ds", "int", "WechatSessionHistory", "");
    hUY = new Column("hour", "int", "WechatSessionHistory", "");
    iKx = new Column("lastsession", "string", "WechatSessionHistory", "");
    iKy = new Column("currsession", "string", "WechatSessionHistory", "");
    iKz = new Column("nextsession", "string", "WechatSessionHistory", "");
    iKA = new Column("enterms", "long", "WechatSessionHistory", "");
    iKB = new Column("quitms", "long", "WechatSessionHistory", "");
    iKC = new Column("stayms", "long", "WechatSessionHistory", "");
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (hVf != k) {
        break label60;
      }
      this.field_ds = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hVg == k) {
        this.field_hour = paramCursor.getInt(i);
      } else if (iKJ == k) {
        this.field_lastSession = paramCursor.getString(i);
      } else if (iKK == k) {
        this.field_currSession = paramCursor.getString(i);
      } else if (iKL == k) {
        this.field_nextSession = paramCursor.getString(i);
      } else if (iKM == k) {
        this.field_enterMs = paramCursor.getLong(i);
      } else if (iKN == k) {
        this.field_quitMs = paramCursor.getLong(i);
      } else if (iKO == k) {
        this.field_stayMs = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hVb) {
      localContentValues.put("ds", Integer.valueOf(this.field_ds));
    }
    if (this.hVc) {
      localContentValues.put("hour", Integer.valueOf(this.field_hour));
    }
    if (this.iKD) {
      localContentValues.put("lastSession", this.field_lastSession);
    }
    if (this.iKE) {
      localContentValues.put("currSession", this.field_currSession);
    }
    if (this.iKF) {
      localContentValues.put("nextSession", this.field_nextSession);
    }
    if (this.iKG) {
      localContentValues.put("enterMs", Long.valueOf(this.field_enterMs));
    }
    if (this.iKH) {
      localContentValues.put("quitMs", Long.valueOf(this.field_quitMs));
    }
    if (this.iKI) {
      localContentValues.put("stayMs", Long.valueOf(this.field_stayMs));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WechatSessionHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hz
 * JD-Core Version:    0.7.0.1
 */