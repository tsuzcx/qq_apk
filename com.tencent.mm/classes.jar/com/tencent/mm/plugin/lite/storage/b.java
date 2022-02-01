package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class b
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column EgR;
  public static final Column EgS;
  private static final int EgV;
  private static final int EgW;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LiteAppInfo");
  public static final Column hFK;
  private static final int hGK = "lastUseTime".hashCode();
  public static final Column hGW;
  public static final Column hHh;
  private static final int hIJ;
  private static final int hIy;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpJ;
  public static final Column hpL;
  private static final int hpT;
  private static final int hpV;
  public static final Column hsH;
  private static final int hsP;
  private static final int iiG;
  public static final Column iix;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean EgT = true;
  private boolean EgU = true;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public String field_groupId;
  public long field_lastUseTime;
  public String field_md5;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  public String field_url;
  public String field_version;
  private boolean hGk = true;
  private boolean hHK = true;
  private boolean hHV = true;
  private boolean hnQ = true;
  private boolean hpO = true;
  private boolean hpQ = true;
  private boolean hsL = true;
  private boolean iiB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LiteAppInfo", "");
    hnz = new Column("appid", "string", "LiteAppInfo", "");
    hHh = new Column("groupid", "string", "LiteAppInfo", "");
    EgR = new Column("signaturekey", "string", "LiteAppInfo", "");
    hpL = new Column("pkgpath", "string", "LiteAppInfo", "");
    iix = new Column("pkgtype", "string", "LiteAppInfo", "");
    EgS = new Column("patchid", "string", "LiteAppInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "LiteAppInfo", "");
    hpJ = new Column("version", "string", "LiteAppInfo", "");
    hsH = new Column("url", "string", "LiteAppInfo", "");
    hGW = new Column("md5", "string", "LiteAppInfo", "");
    hFK = new Column("lastusetime", "long", "LiteAppInfo", "");
    hoh = "appId".hashCode();
    hIJ = "groupId".hashCode();
    EgV = "signatureKey".hashCode();
    hpV = "pkgPath".hashCode();
    iiG = "pkgType".hashCode();
    EgW = "patchId".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hpT = "version".hashCode();
    hsP = "url".hashCode();
    hIy = "md5".hashCode();
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
      if (hoh != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.hnQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hIJ == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (EgV == k) {
        this.field_signatureKey = paramCursor.getString(i);
      } else if (hpV == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (iiG == k) {
        this.field_pkgType = paramCursor.getString(i);
      } else if (EgW == k) {
        this.field_patchId = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hpT == k) {
        this.field_version = paramCursor.getString(i);
      } else if (hsP == k) {
        this.field_url = paramCursor.getString(i);
      } else if (hIy == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (hGK == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hHV) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.EgT) {
      localContentValues.put("signatureKey", this.field_signatureKey);
    }
    if (this.hpQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.iiB) {
      localContentValues.put("pkgType", this.field_pkgType);
    }
    if (this.EgU) {
      localContentValues.put("patchId", this.field_patchId);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hpO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hGk) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
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
    return "LiteAppInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.b
 * JD-Core Version:    0.7.0.1
 */