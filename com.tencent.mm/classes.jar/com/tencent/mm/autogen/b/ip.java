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

public abstract class ip
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WePkgDiffPackage");
  public static final Column jMA;
  private static final int jMG;
  public static final Column jMw;
  private static final int jWJ;
  public static final Column kea;
  private static final int kfD;
  private static final int llA;
  private static final int llB;
  private static final int llC;
  private static final int llD;
  public static final Column llp;
  public static final Column llq;
  public static final Column llr;
  public static final Column lls;
  public static final Column llt;
  private static final int llz;
  private static final StorageObserverOwner<ip> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_downloadNetType;
  public String field_downloadUrl;
  public String field_md5;
  public String field_oldPath;
  public String field_oldVersion;
  public String field_pkgId;
  public int field_pkgSize;
  public String field_version;
  private boolean jMB = true;
  private boolean jWB = true;
  private boolean keP = true;
  private boolean llu = true;
  private boolean llv = true;
  private boolean llw = true;
  private boolean llx = true;
  private boolean lly = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    llp = new Column("pkgId", "string", TABLE.getName(), "");
    jMw = new Column("version", "string", TABLE.getName(), "");
    llq = new Column("oldVersion", "string", TABLE.getName(), "");
    llr = new Column("oldPath", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    lls = new Column("pkgSize", "int", TABLE.getName(), "");
    llt = new Column("downloadNetType", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    llz = "pkgId".hashCode();
    jMG = "version".hashCode();
    llA = "oldVersion".hashCode();
    llB = "oldPath".hashCode();
    kfD = "md5".hashCode();
    jWJ = "downloadUrl".hashCode();
    llC = "pkgSize".hashCode();
    llD = "downloadNetType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pkgId";
    localMAutoDBInfo.colsMap.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "pkgId";
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "oldVersion";
    localMAutoDBInfo.colsMap.put("oldVersion", "TEXT");
    localStringBuilder.append(" oldVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "oldPath";
    localMAutoDBInfo.colsMap.put("oldPath", "TEXT");
    localStringBuilder.append(" oldPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "pkgSize";
    localMAutoDBInfo.colsMap.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadNetType";
    localMAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("pkgId"))
    {
      this.field_pkgId = paramContentValues.getAsString("pkgId");
      if (paramBoolean) {
        this.llu = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsString("version");
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("oldVersion"))
    {
      this.field_oldVersion = paramContentValues.getAsString("oldVersion");
      if (paramBoolean) {
        this.llv = true;
      }
    }
    if (paramContentValues.containsKey("oldPath"))
    {
      this.field_oldPath = paramContentValues.getAsString("oldPath");
      if (paramBoolean) {
        this.llw = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrl"))
    {
      this.field_downloadUrl = paramContentValues.getAsString("downloadUrl");
      if (paramBoolean) {
        this.jWB = true;
      }
    }
    if (paramContentValues.containsKey("pkgSize"))
    {
      this.field_pkgSize = paramContentValues.getAsInteger("pkgSize").intValue();
      if (paramBoolean) {
        this.llx = true;
      }
    }
    if (paramContentValues.containsKey("downloadNetType"))
    {
      this.field_downloadNetType = paramContentValues.getAsInteger("downloadNetType").intValue();
      if (paramBoolean) {
        this.lly = true;
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
      if (llz != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.llu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jMG == k) {
        this.field_version = paramCursor.getString(i);
      } else if (llA == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (llB == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (jWJ == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (llC == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (llD == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.llu) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.jMB) {
      localContentValues.put("version", this.field_version);
    }
    if (this.llv) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.llw) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.llx) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.lly) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
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
  
  public StorageObserverOwner<? extends ip> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_pkgId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ip
 * JD-Core Version:    0.7.0.1
 */