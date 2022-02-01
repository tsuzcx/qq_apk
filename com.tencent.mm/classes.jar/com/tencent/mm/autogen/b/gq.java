package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gq
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("PushWxaPkgDecryptKeyTable");
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLE;
  private static final int jLM;
  public static final Column jMP;
  private static final int jMZ;
  public static final Column kSe;
  private static final int kSw;
  public static final Column kTx;
  private static final int kTz;
  private static final StorageObserverOwner<gq> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_appVersion;
  public String field_decryptKey;
  public String field_pkgMd5;
  public int field_reportId;
  private boolean jKG = true;
  private boolean jLI = true;
  private boolean jMU = true;
  private boolean kSn = true;
  private boolean kTy = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jLE = new Column("appVersion", "int", TABLE.getName(), "");
    kTx = new Column("decryptKey", "string", TABLE.getName(), "");
    kSe = new Column("pkgMd5", "string", TABLE.getName(), "");
    jMP = new Column("reportId", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jLM = "appVersion".hashCode();
    kTz = "decryptKey".hashCode();
    kSw = "pkgMd5".hashCode();
    jMZ = "reportId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "decryptKey";
    localMAutoDBInfo.colsMap.put("decryptKey", "TEXT");
    localStringBuilder.append(" decryptKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pkgMd5";
    localMAutoDBInfo.colsMap.put("pkgMd5", "TEXT");
    localStringBuilder.append(" pkgMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("appVersion"))
    {
      this.field_appVersion = paramContentValues.getAsInteger("appVersion").intValue();
      if (paramBoolean) {
        this.jLI = true;
      }
    }
    if (paramContentValues.containsKey("decryptKey"))
    {
      this.field_decryptKey = paramContentValues.getAsString("decryptKey");
      if (paramBoolean) {
        this.kTy = true;
      }
    }
    if (paramContentValues.containsKey("pkgMd5"))
    {
      this.field_pkgMd5 = paramContentValues.getAsString("pkgMd5");
      if (paramBoolean) {
        this.kSn = true;
      }
    }
    if (paramContentValues.containsKey("reportId"))
    {
      this.field_reportId = paramContentValues.getAsInteger("reportId").intValue();
      if (paramBoolean) {
        this.jMU = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (jKX != k) {
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
      if (jLM == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (kTz == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (kSw == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (jMZ == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jLI) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.kTy) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.kSn) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.jMU) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends gq> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.gq
 * JD-Core Version:    0.7.0.1
 */