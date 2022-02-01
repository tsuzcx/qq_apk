package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class di
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameResourceDownload");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hZN;
  public static final Column hZO;
  public static final Column hZP;
  public static final Column hZQ;
  public static final Column hZR;
  private static final int hZX;
  private static final int hZY;
  private static final int hZZ = "checkCgiTime".hashCode();
  public static final Column hnz;
  private static final int hoh;
  public static final Column hqs;
  private static final int hrk;
  private static final int iaa = "finishDownloadTime".hashCode();
  private static final int iab = "downloadItemList".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public String field_appId;
  public long field_checkCgiTime;
  public long field_createTime;
  public byte[] field_downloadItemList;
  public int field_expiredSeconds;
  public long field_finishDownloadTime;
  public int field_intervalSeconds;
  public String field_packageName;
  private boolean hZS = true;
  private boolean hZT = true;
  private boolean hZU = true;
  private boolean hZV = true;
  private boolean hZW = true;
  private boolean hnQ = true;
  private boolean hqO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameResourceDownload", "");
    hqs = new Column("packagename", "string", "GameResourceDownload", "");
    hnz = new Column("appid", "string", "GameResourceDownload", "");
    hZN = new Column("intervalseconds", "int", "GameResourceDownload", "");
    hZO = new Column("expiredseconds", "int", "GameResourceDownload", "");
    C_CREATETIME = new Column("createtime", "long", "GameResourceDownload", "");
    hZP = new Column("checkcgitime", "long", "GameResourceDownload", "");
    hZQ = new Column("finishdownloadtime", "long", "GameResourceDownload", "");
    hZR = new Column("downloaditemlist", "byte[]", "GameResourceDownload", "");
    hrk = "packageName".hashCode();
    hoh = "appId".hashCode();
    hZX = "intervalSeconds".hashCode();
    hZY = "expiredSeconds".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packageName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "packageName";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "intervalSeconds";
    localMAutoDBInfo.colsMap.put("intervalSeconds", "INTEGER");
    localStringBuilder.append(" intervalSeconds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "expiredSeconds";
    localMAutoDBInfo.colsMap.put("expiredSeconds", "INTEGER");
    localStringBuilder.append(" expiredSeconds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "checkCgiTime";
    localMAutoDBInfo.colsMap.put("checkCgiTime", "LONG");
    localStringBuilder.append(" checkCgiTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "finishDownloadTime";
    localMAutoDBInfo.colsMap.put("finishDownloadTime", "LONG");
    localStringBuilder.append(" finishDownloadTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadItemList";
    localMAutoDBInfo.colsMap.put("downloadItemList", "BLOB");
    localStringBuilder.append(" downloadItemList BLOB");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hrk != k) {
        break label65;
      }
      this.field_packageName = paramCursor.getString(i);
      this.hqO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hZX == k) {
        this.field_intervalSeconds = paramCursor.getInt(i);
      } else if (hZY == k) {
        this.field_expiredSeconds = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (hZZ == k) {
        this.field_checkCgiTime = paramCursor.getLong(i);
      } else if (iaa == k) {
        this.field_finishDownloadTime = paramCursor.getLong(i);
      } else if (iab == k) {
        this.field_downloadItemList = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hqO) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hZS) {
      localContentValues.put("intervalSeconds", Integer.valueOf(this.field_intervalSeconds));
    }
    if (this.hZT) {
      localContentValues.put("expiredSeconds", Integer.valueOf(this.field_expiredSeconds));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hZU) {
      localContentValues.put("checkCgiTime", Long.valueOf(this.field_checkCgiTime));
    }
    if (this.hZV) {
      localContentValues.put("finishDownloadTime", Long.valueOf(this.field_finishDownloadTime));
    }
    if (this.hZW) {
      localContentValues.put("downloadItemList", this.field_downloadItemList);
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
    return "GameResourceDownload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.di
 * JD-Core Version:    0.7.0.1
 */