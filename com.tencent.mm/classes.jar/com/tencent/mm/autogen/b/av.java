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

public abstract class av
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("CdnDownloadInfo");
  public static final Column jKs;
  private static final int jLa;
  public static final Column jMA;
  private static final int jWI;
  private static final int jWJ;
  private static final int jWK;
  private static final int jWL;
  private static final int jWM;
  private static final int jWN;
  private static final int jWO;
  private static final int jWP;
  public static final Column jWt;
  public static final Column jWu;
  public static final Column jWv;
  public static final Column jWw;
  public static final Column jWx;
  public static final Column jWy;
  public static final Column jWz;
  private static final StorageObserverOwner<av> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public Boolean field_allowMobileNetDownload;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public String field_filePath;
  public Boolean field_game_package_download;
  public String field_httpsUrl;
  public String field_mediaId;
  public String field_verifyHeaders;
  public Boolean field_wifiAutoDownload;
  private boolean jKJ = true;
  private boolean jWA = true;
  private boolean jWB = true;
  private boolean jWC = true;
  private boolean jWD = true;
  private boolean jWE = true;
  private boolean jWF = true;
  private boolean jWG = true;
  private boolean jWH = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKs = new Column("mediaId", "string", TABLE.getName(), "");
    jWt = new Column("downloadUrlHashCode", "int", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    jWu = new Column("httpsUrl", "string", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    jWw = new Column("verifyHeaders", "string", TABLE.getName(), "");
    jWx = new Column("game_package_download", "boolean", TABLE.getName(), "");
    jWy = new Column("allowMobileNetDownload", "boolean", TABLE.getName(), "");
    jWz = new Column("wifiAutoDownload", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jLa = "mediaId".hashCode();
    jWI = "downloadUrlHashCode".hashCode();
    jWJ = "downloadUrl".hashCode();
    jWK = "httpsUrl".hashCode();
    jWL = "filePath".hashCode();
    jWM = "verifyHeaders".hashCode();
    jWN = "game_package_download".hashCode();
    jWO = "allowMobileNetDownload".hashCode();
    jWP = "wifiAutoDownload".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "downloadUrlHashCode";
    localMAutoDBInfo.colsMap.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "downloadUrlHashCode";
    localMAutoDBInfo.columns[2] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "httpsUrl";
    localMAutoDBInfo.colsMap.put("httpsUrl", "TEXT");
    localStringBuilder.append(" httpsUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "verifyHeaders";
    localMAutoDBInfo.colsMap.put("verifyHeaders", "TEXT");
    localStringBuilder.append(" verifyHeaders TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "game_package_download";
    localMAutoDBInfo.colsMap.put("game_package_download", "INTEGER");
    localStringBuilder.append(" game_package_download INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "allowMobileNetDownload";
    localMAutoDBInfo.colsMap.put("allowMobileNetDownload", "INTEGER");
    localStringBuilder.append(" allowMobileNetDownload INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "wifiAutoDownload";
    localMAutoDBInfo.colsMap.put("wifiAutoDownload", "INTEGER");
    localStringBuilder.append(" wifiAutoDownload INTEGER");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("mediaId"))
    {
      this.field_mediaId = paramContentValues.getAsString("mediaId");
      if (paramBoolean) {
        this.jKJ = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrlHashCode"))
    {
      this.field_downloadUrlHashCode = paramContentValues.getAsInteger("downloadUrlHashCode").intValue();
      if (paramBoolean) {
        this.jWA = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrl"))
    {
      this.field_downloadUrl = paramContentValues.getAsString("downloadUrl");
      if (paramBoolean) {
        this.jWB = true;
      }
    }
    if (paramContentValues.containsKey("httpsUrl"))
    {
      this.field_httpsUrl = paramContentValues.getAsString("httpsUrl");
      if (paramBoolean) {
        this.jWC = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("verifyHeaders"))
    {
      this.field_verifyHeaders = paramContentValues.getAsString("verifyHeaders");
      if (paramBoolean) {
        this.jWE = true;
      }
    }
    if (paramContentValues.containsKey("game_package_download"))
    {
      if (paramContentValues.getAsInteger("game_package_download").intValue() == 0) {
        break label320;
      }
      bool1 = true;
      this.field_game_package_download = Boolean.valueOf(bool1);
      if (paramBoolean) {
        this.jWF = true;
      }
    }
    if (paramContentValues.containsKey("allowMobileNetDownload")) {
      if (paramContentValues.getAsInteger("allowMobileNetDownload").intValue() == 0) {
        break label325;
      }
    }
    label320:
    label325:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_allowMobileNetDownload = Boolean.valueOf(bool1);
      if (paramBoolean) {
        this.jWG = true;
      }
      if (paramContentValues.containsKey("wifiAutoDownload"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("wifiAutoDownload").intValue() != 0) {
          bool1 = true;
        }
        this.field_wifiAutoDownload = Boolean.valueOf(bool1);
        if (paramBoolean) {
          this.jWH = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
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
      if (jLa != k) {
        break label60;
      }
      this.field_mediaId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jWI == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.jWA = true;
      }
      else if (jWJ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (jWK == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (jWL == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (jWM == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (jWN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (jWO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (jWP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_wifiAutoDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKJ) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.jWA) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.jWC) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.jWE) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.jWF) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.jWG) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.jWH) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
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
  
  public StorageObserverOwner<? extends av> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_downloadUrlHashCode);
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
 * Qualified Name:     com.tencent.mm.autogen.b.av
 * JD-Core Version:    0.7.0.1
 */