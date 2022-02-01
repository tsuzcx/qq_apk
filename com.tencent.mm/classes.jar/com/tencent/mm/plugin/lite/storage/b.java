package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class b
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column Kbp;
  public static final Column Kbq;
  public static final Column Kbr;
  private static final int Kbv;
  private static final int Kbw;
  private static final int Kbx;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LiteAppBaselibInfo");
  public static final Column UPDATETIME;
  private static final int jMI;
  public static final Column jMy;
  private static final int jPC;
  public static final Column jPu;
  public static final Column kHV;
  private static final int kIe;
  public static final Column kcO;
  private static final int kdO;
  public static final Column kea;
  private static final int kfD;
  private static final StorageObserverOwner<b> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean Kbs = true;
  private boolean Kbt = true;
  private boolean Kbu = true;
  private boolean __hadSetupdateTime = true;
  public long field_lastUseTime;
  public String field_majorVersion;
  public String field_md5;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  public String field_url;
  private boolean jMD = true;
  private boolean jPy = true;
  private boolean kHZ = true;
  private boolean kdo = true;
  private boolean keP = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    Kbp = new Column("majorVersion", "string", TABLE.getName(), "");
    Kbq = new Column("signatureKey", "string", TABLE.getName(), "");
    jMy = new Column("pkgPath", "string", TABLE.getName(), "");
    kHV = new Column("pkgType", "string", TABLE.getName(), "");
    Kbr = new Column("patchId", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    kcO = new Column("lastUseTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    Kbv = "majorVersion".hashCode();
    Kbw = "signatureKey".hashCode();
    jMI = "pkgPath".hashCode();
    kIe = "pkgType".hashCode();
    Kbx = "patchId".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jPC = "url".hashCode();
    kfD = "md5".hashCode();
    kdO = "lastUseTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "majorVersion";
    localMAutoDBInfo.colsMap.put("majorVersion", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" majorVersion TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "majorVersion";
    localMAutoDBInfo.columns[1] = "signatureKey";
    localMAutoDBInfo.colsMap.put("signatureKey", "TEXT");
    localStringBuilder.append(" signatureKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pkgPath";
    localMAutoDBInfo.colsMap.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pkgType";
    localMAutoDBInfo.colsMap.put("pkgType", "TEXT");
    localStringBuilder.append(" pkgType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "patchId";
    localMAutoDBInfo.colsMap.put("patchId", "TEXT");
    localStringBuilder.append(" patchId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("majorVersion"))
    {
      this.field_majorVersion = paramContentValues.getAsString("majorVersion");
      if (paramBoolean) {
        this.Kbs = true;
      }
    }
    if (paramContentValues.containsKey("signatureKey"))
    {
      this.field_signatureKey = paramContentValues.getAsString("signatureKey");
      if (paramBoolean) {
        this.Kbt = true;
      }
    }
    if (paramContentValues.containsKey("pkgPath"))
    {
      this.field_pkgPath = paramContentValues.getAsString("pkgPath");
      if (paramBoolean) {
        this.jMD = true;
      }
    }
    if (paramContentValues.containsKey("pkgType"))
    {
      this.field_pkgType = paramContentValues.getAsString("pkgType");
      if (paramBoolean) {
        this.kHZ = true;
      }
    }
    if (paramContentValues.containsKey("patchId"))
    {
      this.field_patchId = paramContentValues.getAsString("patchId");
      if (paramBoolean) {
        this.Kbu = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("lastUseTime"))
    {
      this.field_lastUseTime = paramContentValues.getAsLong("lastUseTime").longValue();
      if (paramBoolean) {
        this.kdo = true;
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
      if (Kbv != k) {
        break label65;
      }
      this.field_majorVersion = paramCursor.getString(i);
      this.Kbs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (Kbw == k) {
        this.field_signatureKey = paramCursor.getString(i);
      } else if (jMI == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (kIe == k) {
        this.field_pkgType = paramCursor.getString(i);
      } else if (Kbx == k) {
        this.field_patchId = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jPC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (kdO == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.Kbs) {
      localContentValues.put("majorVersion", this.field_majorVersion);
    }
    if (this.Kbt) {
      localContentValues.put("signatureKey", this.field_signatureKey);
    }
    if (this.jMD) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.kHZ) {
      localContentValues.put("pkgType", this.field_pkgType);
    }
    if (this.Kbu) {
      localContentValues.put("patchId", this.field_patchId);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.kdo) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
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
  
  public StorageObserverOwner<? extends b> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_majorVersion;
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
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.b
 * JD-Core Version:    0.7.0.1
 */