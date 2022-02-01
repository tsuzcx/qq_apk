package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class w
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  public static final SingleTable TABLE = new SingleTable("AppBrandWxaPkgManifestRecord");
  private static final int createTime_HASHCODE;
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmV = "startTime".hashCode();
  private static final int hmW = "endTime".hashCode();
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpG;
  private static final int hpI;
  public static final Column hpJ;
  public static final Column hpK;
  public static final Column hpL;
  public static final Column hpM;
  public static final Column hpN;
  private static final int hpT;
  private static final int hpU;
  private static final int hpV;
  private static final int hpW;
  private static final int hpX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public String field_NewMd5;
  public String field_appId;
  public long field_createTime;
  public int field_debugType;
  public String field_downloadURL;
  public long field_endTime;
  public String field_pkgPath;
  public long field_startTime;
  public int field_version;
  public String field_versionMd5;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hnQ = true;
  private boolean hpH = true;
  private boolean hpO = true;
  private boolean hpP = true;
  private boolean hpQ = true;
  private boolean hpR = true;
  private boolean hpS = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandWxaPkgManifestRecord", "");
    hnz = new Column("appid", "string", "AppBrandWxaPkgManifestRecord", "");
    hpJ = new Column("version", "int", "AppBrandWxaPkgManifestRecord", "");
    hpG = new Column("versionmd5", "string", "AppBrandWxaPkgManifestRecord", "");
    hpK = new Column("newmd5", "string", "AppBrandWxaPkgManifestRecord", "");
    hpL = new Column("pkgpath", "string", "AppBrandWxaPkgManifestRecord", "");
    C_CREATETIME = new Column("createtime", "long", "AppBrandWxaPkgManifestRecord", "");
    hpM = new Column("debugtype", "int", "AppBrandWxaPkgManifestRecord", "");
    hpN = new Column("downloadurl", "string", "AppBrandWxaPkgManifestRecord", "");
    hmH = new Column("starttime", "long", "AppBrandWxaPkgManifestRecord", "");
    hmI = new Column("endtime", "long", "AppBrandWxaPkgManifestRecord", "");
    hoh = "appId".hashCode();
    hpT = "version".hashCode();
    hpI = "versionMd5".hashCode();
    hpU = "NewMd5".hashCode();
    hpV = "pkgPath".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hpW = "debugType".hashCode();
    hpX = "downloadURL".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versionMd5";
    localMAutoDBInfo.colsMap.put("versionMd5", "TEXT");
    localStringBuilder.append(" versionMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "NewMd5";
    localMAutoDBInfo.colsMap.put("NewMd5", "TEXT");
    localStringBuilder.append(" NewMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pkgPath";
    localMAutoDBInfo.colsMap.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "debugType";
    localMAutoDBInfo.colsMap.put("debugType", "INTEGER default '0' ");
    localStringBuilder.append(" debugType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadURL";
    localMAutoDBInfo.colsMap.put("downloadURL", "TEXT");
    localStringBuilder.append(" downloadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localMAutoDBInfo.columns[10] = "rowid";
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hpT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (hpI == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (hpU == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (hpV == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (hpW == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (hpX == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (hmV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (hmW == k) {
        this.field_endTime = paramCursor.getLong(i);
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
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.hpH) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.hpP) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.hpQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hpR) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.hpS) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
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
    return "AppBrandWxaPkgManifestRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.w
 * JD-Core Version:    0.7.0.1
 */