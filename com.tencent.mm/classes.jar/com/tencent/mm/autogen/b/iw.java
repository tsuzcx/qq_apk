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

public abstract class iw
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WepkgPreloadFiles");
  private static final int createTime_HASHCODE;
  public static final Column jLQ;
  private static final int jLU;
  public static final Column jMA;
  private static final int jMG;
  public static final Column jMw;
  private static final int jWJ;
  private static final int jWL;
  public static final Column jWv;
  public static final Column kMK;
  public static final Column kea;
  private static final int key_HASHCODE;
  private static final int kfD;
  private static final int llD;
  public static final Column llp;
  public static final Column llt;
  private static final int llz;
  public static final Column lmG;
  public static final Column lmH;
  public static final Column lmI;
  public static final Column lmJ;
  private static final int lmP;
  private static final int lmQ;
  private static final int lmR;
  private static final int lmS;
  private static final int lmT;
  private static final StorageObserverOwner<iw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetkey = true;
  public int field_autoDownloadCount;
  public boolean field_completeDownload;
  public long field_createTime;
  public int field_downloadNetType;
  public String field_downloadUrl;
  public int field_fileDownloadCount;
  public String field_filePath;
  public String field_key;
  public String field_md5;
  public String field_mimeType;
  public String field_pkgId;
  public String field_rid;
  public int field_size;
  public String field_version;
  private boolean jLS = true;
  private boolean jMB = true;
  private boolean jWB = true;
  private boolean jWD = true;
  private boolean keP = true;
  private boolean llu = true;
  private boolean lly = true;
  private boolean lmK = true;
  private boolean lmL = true;
  private boolean lmM = true;
  private boolean lmN = true;
  private boolean lmO = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    llp = new Column("pkgId", "string", TABLE.getName(), "");
    jMw = new Column("version", "string", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    lmG = new Column("rid", "string", TABLE.getName(), "");
    kMK = new Column("mimeType", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    jLQ = new Column("size", "int", TABLE.getName(), "");
    llt = new Column("downloadNetType", "int", TABLE.getName(), "");
    lmH = new Column("completeDownload", "boolean", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    lmI = new Column("autoDownloadCount", "int", TABLE.getName(), "");
    lmJ = new Column("fileDownloadCount", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    key_HASHCODE = "key".hashCode();
    llz = "pkgId".hashCode();
    jMG = "version".hashCode();
    jWL = "filePath".hashCode();
    lmP = "rid".hashCode();
    lmQ = "mimeType".hashCode();
    kfD = "md5".hashCode();
    jWJ = "downloadUrl".hashCode();
    jLU = "size".hashCode();
    llD = "downloadNetType".hashCode();
    lmR = "completeDownload".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    lmS = "autoDownloadCount".hashCode();
    lmT = "fileDownloadCount".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "pkgId";
    localMAutoDBInfo.colsMap.put("pkgId", "TEXT");
    localStringBuilder.append(" pkgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "version";
    localMAutoDBInfo.colsMap.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "rid";
    localMAutoDBInfo.colsMap.put("rid", "TEXT");
    localStringBuilder.append(" rid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "mimeType";
    localMAutoDBInfo.colsMap.put("mimeType", "TEXT");
    localStringBuilder.append(" mimeType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "downloadNetType";
    localMAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "completeDownload";
    localMAutoDBInfo.colsMap.put("completeDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" completeDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "autoDownloadCount";
    localMAutoDBInfo.colsMap.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "fileDownloadCount";
    localMAutoDBInfo.colsMap.put("fileDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" fileDownloadCount INTEGER default '0' ");
    localMAutoDBInfo.columns[14] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
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
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("rid"))
    {
      this.field_rid = paramContentValues.getAsString("rid");
      if (paramBoolean) {
        this.lmK = true;
      }
    }
    if (paramContentValues.containsKey("mimeType"))
    {
      this.field_mimeType = paramContentValues.getAsString("mimeType");
      if (paramBoolean) {
        this.lmL = true;
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
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsInteger("size").intValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("downloadNetType"))
    {
      this.field_downloadNetType = paramContentValues.getAsInteger("downloadNetType").intValue();
      if (paramBoolean) {
        this.lly = true;
      }
    }
    if (paramContentValues.containsKey("completeDownload")) {
      if (paramContentValues.getAsInteger("completeDownload").intValue() == 0) {
        break label439;
      }
    }
    label439:
    for (boolean bool = true;; bool = false)
    {
      this.field_completeDownload = bool;
      if (paramBoolean) {
        this.lmM = true;
      }
      if (paramContentValues.containsKey("createTime"))
      {
        this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
        if (paramBoolean) {
          this.__hadSetcreateTime = true;
        }
      }
      if (paramContentValues.containsKey("autoDownloadCount"))
      {
        this.field_autoDownloadCount = paramContentValues.getAsInteger("autoDownloadCount").intValue();
        if (paramBoolean) {
          this.lmN = true;
        }
      }
      if (paramContentValues.containsKey("fileDownloadCount"))
      {
        this.field_fileDownloadCount = paramContentValues.getAsInteger("fileDownloadCount").intValue();
        if (paramBoolean) {
          this.lmO = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (llz == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (jMG == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (jWL == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (lmP == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (lmQ == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (kfD == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (jWJ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (jLU == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (llD == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (lmR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (createTime_HASHCODE == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (lmS == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (lmT == k) {
          this.field_fileDownloadCount = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.llu) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.jMB) {
      localContentValues.put("version", this.field_version);
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.lmK) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.lmL) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.jLS) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.lly) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.lmM) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.lmN) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.lmO) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
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
  
  public StorageObserverOwner<? extends iw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_key;
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
 * Qualified Name:     com.tencent.mm.autogen.b.iw
 * JD-Core Version:    0.7.0.1
 */