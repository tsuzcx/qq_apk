package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bz
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FavOffline");
  public static final Column hMA;
  private static final int hMG;
  private static final int hMH;
  private static final int hMI;
  private static final int hMJ = "failNum".hashCode();
  private static final int hMK = "isReport".hashCode();
  public static final Column hMw;
  public static final Column hMx;
  public static final Column hMy;
  public static final Column hMz;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hoC;
  private static final int hoK;
  public static final Column hpd;
  private static final int hph;
  public static final Column hsH;
  private static final int hsP;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public int field_failNum;
  public long field_favTime;
  public String field_imgDirPath;
  public String field_imgPaths;
  public int field_isReport;
  public String field_path;
  public long field_size;
  public int field_status;
  public long field_updateTime;
  public String field_url;
  private boolean hMB = true;
  private boolean hMC = true;
  private boolean hMD = true;
  private boolean hME = true;
  private boolean hMF = true;
  private boolean hmz = true;
  private boolean hoG = true;
  private boolean hpf = true;
  private boolean hsL = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FavOffline", "");
    hsH = new Column("url", "string", "FavOffline", "");
    hpd = new Column("size", "long", "FavOffline", "");
    hoC = new Column("path", "string", "FavOffline", "");
    hMw = new Column("imgdirpath", "string", "FavOffline", "");
    hMx = new Column("imgpaths", "string", "FavOffline", "");
    hMy = new Column("favtime", "long", "FavOffline", "");
    C_UPDATETIME = new Column("updatetime", "long", "FavOffline", "");
    hmw = new Column("status", "int", "FavOffline", "");
    hMz = new Column("failnum", "int", "FavOffline", "");
    hMA = new Column("isreport", "int", "FavOffline", "");
    hsP = "url".hashCode();
    hph = "size".hashCode();
    hoK = "path".hashCode();
    hMG = "imgDirPath".hashCode();
    hMH = "imgPaths".hashCode();
    hMI = "favTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hmC = "status".hashCode();
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
      if (hsP != k) {
        break label60;
      }
      this.field_url = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hph == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (hoK == k) {
        this.field_path = paramCursor.getString(i);
      } else if (hMG == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (hMH == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (hMI == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (hMJ == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (hMK == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.hMB) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.hMC) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.hMD) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hME) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.hMF) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
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
    return "FavOffline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bz
 * JD-Core Version:    0.7.0.1
 */