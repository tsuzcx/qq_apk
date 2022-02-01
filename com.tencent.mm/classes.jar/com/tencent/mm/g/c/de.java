package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class de
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fJq;
  private static final int fJr;
  private static final int fJs = "checkCgiTime".hashCode();
  private static final int fJt = "finishDownloadTime".hashCode();
  private static final int fJu = "downloadItemList".hashCode();
  private static final int fkj;
  private static final int fml = "packageName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean fJl = true;
  private boolean fJm = true;
  private boolean fJn = true;
  private boolean fJo = true;
  private boolean fJp = true;
  public String field_appId;
  public long field_checkCgiTime;
  public long field_createTime;
  public byte[] field_downloadItemList;
  public int field_expiredSeconds;
  public long field_finishDownloadTime;
  public int field_intervalSeconds;
  public String field_packageName;
  private boolean fjS = true;
  private boolean flP = true;
  
  static
  {
    fkj = "appId".hashCode();
    fJq = "intervalSeconds".hashCode();
    fJr = "expiredSeconds".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fml != k) {
        break label65;
      }
      this.field_packageName = paramCursor.getString(i);
      this.flP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fJq == k) {
        this.field_intervalSeconds = paramCursor.getInt(i);
      } else if (fJr == k) {
        this.field_expiredSeconds = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fJs == k) {
        this.field_checkCgiTime = paramCursor.getLong(i);
      } else if (fJt == k) {
        this.field_finishDownloadTime = paramCursor.getLong(i);
      } else if (fJu == k) {
        this.field_downloadItemList = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flP) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fJl) {
      localContentValues.put("intervalSeconds", Integer.valueOf(this.field_intervalSeconds));
    }
    if (this.fJm) {
      localContentValues.put("expiredSeconds", Integer.valueOf(this.field_expiredSeconds));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fJn) {
      localContentValues.put("checkCgiTime", Long.valueOf(this.field_checkCgiTime));
    }
    if (this.fJo) {
      localContentValues.put("finishDownloadTime", Long.valueOf(this.field_finishDownloadTime));
    }
    if (this.fJp) {
      localContentValues.put("downloadItemList", this.field_downloadItemList);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.de
 * JD-Core Version:    0.7.0.1
 */