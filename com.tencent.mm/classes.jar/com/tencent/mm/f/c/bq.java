package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmotionRewardTipInfo");
  public static final Column hJG;
  public static final Column hJH;
  public static final Column hJI;
  public static final Column hJJ;
  public static final Column hJK;
  private static final int hJQ;
  private static final int hJR;
  private static final int hJS;
  private static final int hJT = "showTipsTime".hashCode();
  private static final int hJU = "setFlagTime".hashCode();
  public static final Column hqt;
  private static final int hrl;
  public static final Column hsi;
  private static final int hsm;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  private boolean hJL = true;
  private boolean hJM = true;
  private boolean hJN = true;
  private boolean hJO = true;
  private boolean hJP = true;
  private boolean hqP = true;
  private boolean hsk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmotionRewardTipInfo", "");
    hJG = new Column("prodcutid", "string", "EmotionRewardTipInfo", "");
    hJH = new Column("totalcount", "int", "EmotionRewardTipInfo", "");
    hJI = new Column("continucount", "int", "EmotionRewardTipInfo", "");
    hsi = new Column("flag", "int", "EmotionRewardTipInfo", "");
    hqt = new Column("modifytime", "long", "EmotionRewardTipInfo", "");
    hJJ = new Column("showtipstime", "long", "EmotionRewardTipInfo", "");
    hJK = new Column("setflagtime", "long", "EmotionRewardTipInfo", "");
    hJQ = "prodcutID".hashCode();
    hJR = "totalCount".hashCode();
    hJS = "continuCount".hashCode();
    hsm = "flag".hashCode();
    hrl = "modifyTime".hashCode();
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
      if (hJQ != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.hJL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hJR == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (hJS == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (hrl == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (hJT == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (hJU == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hJL) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.hJM) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.hJN) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.hqP) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.hJO) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.hJP) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
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
    return "EmotionRewardTipInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bq
 * JD-Core Version:    0.7.0.1
 */