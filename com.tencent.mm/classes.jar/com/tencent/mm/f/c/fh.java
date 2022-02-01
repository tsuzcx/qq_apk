package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fh
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OpenIMWordingInfo");
  public static final Column hCb;
  public static final Column hnz;
  public static final Column ipQ;
  private static final int ipW;
  private static final int iqb;
  public static final Column iqj;
  public static final Column iqk;
  public static final Column iql;
  private static final int iqq;
  private static final int iqr;
  private static final int iqs;
  private static final int iqt;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  private boolean ipT = true;
  private boolean ipZ = true;
  private boolean iqm = true;
  private boolean iqn = true;
  private boolean iqo = true;
  private boolean iqp = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OpenIMWordingInfo", "");
    hnz = new Column("appid", "string", "OpenIMWordingInfo", "");
    iqj = new Column("wordingid", "string", "OpenIMWordingInfo", "");
    ipQ = new Column("language", "string", "OpenIMWordingInfo", "");
    iqk = new Column("wording", "string", "OpenIMWordingInfo", "");
    iql = new Column("pinyin", "string", "OpenIMWordingInfo", "");
    hCb = new Column("quanpin", "string", "OpenIMWordingInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "OpenIMWordingInfo", "");
    iqb = "appid".hashCode();
    iqq = "wordingId".hashCode();
    ipW = "language".hashCode();
    iqr = "wording".hashCode();
    iqs = "pinyin".hashCode();
    iqt = "quanpin".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (iqb != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iqq == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (ipW == k) {
        this.field_language = paramCursor.getString(i);
      } else if (iqr == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (iqs == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (iqt == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipZ) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.iqm) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.ipT) {
      localContentValues.put("language", this.field_language);
    }
    if (this.iqn) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.iqo) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.iqp) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
    return "OpenIMWordingInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fh
 * JD-Core Version:    0.7.0.1
 */