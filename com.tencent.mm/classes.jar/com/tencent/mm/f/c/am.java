package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class am
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizKF");
  public static final Column hqA;
  private static final int hrs;
  public static final Column hsT;
  private static final int hwD;
  private static final int hwE;
  private static final int hwF;
  private static final int hwG;
  public static final Column hww;
  public static final Column hwx;
  public static final Column hwy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  private boolean hqW = true;
  private boolean hwA = true;
  private boolean hwB = true;
  private boolean hwC = true;
  private boolean hwz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizKF", "");
    hqA = new Column("openid", "string", "BizKF", "");
    hsT = new Column("brandusername", "string", "BizKF", "");
    hww = new Column("headimgurl", "string", "BizKF", "");
    hwx = new Column("nickname", "string", "BizKF", "");
    hwy = new Column("kftype", "int", "BizKF", "");
    C_UPDATETIME = new Column("updatetime", "long", "BizKF", "");
    hrs = "openId".hashCode();
    hwD = "brandUsername".hashCode();
    hwE = "headImgUrl".hashCode();
    hwF = "nickname".hashCode();
    hwG = "kfType".hashCode();
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
      if (hrs != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.hqW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hwD == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (hwE == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (hwG == k) {
        this.field_kfType = paramCursor.getInt(i);
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
    if (this.hqW) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.hwz) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.hwA) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.hwC) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
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
    return "BizKF";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.am
 * JD-Core Version:    0.7.0.1
 */