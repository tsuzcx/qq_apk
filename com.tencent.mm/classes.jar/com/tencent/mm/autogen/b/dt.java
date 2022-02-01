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

public abstract class dt
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameSilentDownload");
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLQ;
  private static final int jLU;
  public static final Column jMA;
  private static final int jNX;
  public static final Column jNf;
  private static final int jWJ;
  public static final Column kea;
  private static final int kfD;
  public static final Column kkZ;
  public static final Column kkz;
  private static final int kmh;
  private static final int kyM;
  public static final Column kyq;
  private static final int kzH;
  private static final int kzI;
  private static final int kzJ;
  private static final int kzK;
  private static final int kzL;
  private static final int kzM;
  private static final int kzN;
  private static final int kzO;
  private static final int kzP;
  private static final int kzQ;
  private static final int kzR;
  private static final int kzS;
  public static final Column kzk;
  public static final Column kzl;
  public static final Column kzm;
  public static final Column kzn;
  public static final Column kzo;
  public static final Column kzp;
  public static final Column kzq;
  public static final Column kzr;
  public static final Column kzs;
  public static final Column kzt;
  public static final Column kzu;
  private static final StorageObserverOwner<dt> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_SecondaryUrl;
  public String field_appId;
  public boolean field_continueDelay;
  public boolean field_downloadInWidget;
  public String field_downloadUrl;
  public long field_expireTime;
  public int field_forceUpdateFlag;
  public boolean field_isFirst;
  public boolean field_isRunning;
  public boolean field_lowBattery;
  public String field_md5;
  public long field_nextCheckTime;
  public boolean field_noEnoughSpace;
  public boolean field_noSdcard;
  public boolean field_noWifi;
  public String field_packageName;
  public long field_randomTime;
  public byte[] field_sectionMd5Byte;
  public long field_size;
  private boolean jKG = true;
  private boolean jLS = true;
  private boolean jNB = true;
  private boolean jWB = true;
  private boolean keP = true;
  private boolean klD = true;
  private boolean kyB = true;
  private boolean kzA = true;
  private boolean kzB = true;
  private boolean kzC = true;
  private boolean kzD = true;
  private boolean kzE = true;
  private boolean kzF = true;
  private boolean kzG = true;
  private boolean kzv = true;
  private boolean kzw = true;
  private boolean kzx = true;
  private boolean kzy = true;
  private boolean kzz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    jNf = new Column("packageName", "string", TABLE.getName(), "");
    kyq = new Column("expireTime", "long", TABLE.getName(), "");
    kzk = new Column("randomTime", "long", TABLE.getName(), "");
    kzl = new Column("isFirst", "boolean", TABLE.getName(), "");
    kzm = new Column("nextCheckTime", "long", TABLE.getName(), "");
    kzn = new Column("isRunning", "boolean", TABLE.getName(), "");
    kzo = new Column("noWifi", "boolean", TABLE.getName(), "");
    kzp = new Column("noSdcard", "boolean", TABLE.getName(), "");
    kzq = new Column("noEnoughSpace", "boolean", TABLE.getName(), "");
    kzr = new Column("lowBattery", "boolean", TABLE.getName(), "");
    kzs = new Column("continueDelay", "boolean", TABLE.getName(), "");
    kkz = new Column("SecondaryUrl", "string", TABLE.getName(), "");
    kzt = new Column("downloadInWidget", "boolean", TABLE.getName(), "");
    kkZ = new Column("sectionMd5Byte", "byte[]", TABLE.getName(), "");
    kzu = new Column("forceUpdateFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jWJ = "downloadUrl".hashCode();
    jLU = "size".hashCode();
    kfD = "md5".hashCode();
    jNX = "packageName".hashCode();
    kyM = "expireTime".hashCode();
    kzH = "randomTime".hashCode();
    kzI = "isFirst".hashCode();
    kzJ = "nextCheckTime".hashCode();
    kzK = "isRunning".hashCode();
    kzL = "noWifi".hashCode();
    kzM = "noSdcard".hashCode();
    kzN = "noEnoughSpace".hashCode();
    kzO = "lowBattery".hashCode();
    kzP = "continueDelay".hashCode();
    kzQ = "SecondaryUrl".hashCode();
    kzR = "downloadInWidget".hashCode();
    kmh = "sectionMd5Byte".hashCode();
    kzS = "forceUpdateFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "randomTime";
    localMAutoDBInfo.colsMap.put("randomTime", "LONG default '0' ");
    localStringBuilder.append(" randomTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "isFirst";
    localMAutoDBInfo.colsMap.put("isFirst", "INTEGER default 'true' ");
    localStringBuilder.append(" isFirst INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "nextCheckTime";
    localMAutoDBInfo.colsMap.put("nextCheckTime", "LONG default '0' ");
    localStringBuilder.append(" nextCheckTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isRunning";
    localMAutoDBInfo.colsMap.put("isRunning", "INTEGER default 'false' ");
    localStringBuilder.append(" isRunning INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "noWifi";
    localMAutoDBInfo.colsMap.put("noWifi", "INTEGER default 'true' ");
    localStringBuilder.append(" noWifi INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "noSdcard";
    localMAutoDBInfo.colsMap.put("noSdcard", "INTEGER default 'true' ");
    localStringBuilder.append(" noSdcard INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "noEnoughSpace";
    localMAutoDBInfo.colsMap.put("noEnoughSpace", "INTEGER default 'true' ");
    localStringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lowBattery";
    localMAutoDBInfo.colsMap.put("lowBattery", "INTEGER default 'true' ");
    localStringBuilder.append(" lowBattery INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "continueDelay";
    localMAutoDBInfo.colsMap.put("continueDelay", "INTEGER default 'true' ");
    localStringBuilder.append(" continueDelay INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "SecondaryUrl";
    localMAutoDBInfo.colsMap.put("SecondaryUrl", "TEXT");
    localStringBuilder.append(" SecondaryUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "downloadInWidget";
    localMAutoDBInfo.colsMap.put("downloadInWidget", "INTEGER");
    localStringBuilder.append(" downloadInWidget INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "sectionMd5Byte";
    localMAutoDBInfo.colsMap.put("sectionMd5Byte", "BLOB");
    localStringBuilder.append(" sectionMd5Byte BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "forceUpdateFlag";
    localMAutoDBInfo.colsMap.put("forceUpdateFlag", "INTEGER default '0' ");
    localStringBuilder.append(" forceUpdateFlag INTEGER default '0' ");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
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
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("packageName"))
    {
      this.field_packageName = paramContentValues.getAsString("packageName");
      if (paramBoolean) {
        this.jNB = true;
      }
    }
    if (paramContentValues.containsKey("expireTime"))
    {
      this.field_expireTime = paramContentValues.getAsLong("expireTime").longValue();
      if (paramBoolean) {
        this.kyB = true;
      }
    }
    if (paramContentValues.containsKey("randomTime"))
    {
      this.field_randomTime = paramContentValues.getAsLong("randomTime").longValue();
      if (paramBoolean) {
        this.kzv = true;
      }
    }
    if (paramContentValues.containsKey("isFirst"))
    {
      if (paramContentValues.getAsInteger("isFirst").intValue() == 0) {
        break label648;
      }
      bool1 = true;
      this.field_isFirst = bool1;
      if (paramBoolean) {
        this.kzw = true;
      }
    }
    if (paramContentValues.containsKey("nextCheckTime"))
    {
      this.field_nextCheckTime = paramContentValues.getAsLong("nextCheckTime").longValue();
      if (paramBoolean) {
        this.kzx = true;
      }
    }
    if (paramContentValues.containsKey("isRunning"))
    {
      if (paramContentValues.getAsInteger("isRunning").intValue() == 0) {
        break label653;
      }
      bool1 = true;
      label299:
      this.field_isRunning = bool1;
      if (paramBoolean) {
        this.kzy = true;
      }
    }
    if (paramContentValues.containsKey("noWifi"))
    {
      if (paramContentValues.getAsInteger("noWifi").intValue() == 0) {
        break label658;
      }
      bool1 = true;
      label336:
      this.field_noWifi = bool1;
      if (paramBoolean) {
        this.kzz = true;
      }
    }
    if (paramContentValues.containsKey("noSdcard"))
    {
      if (paramContentValues.getAsInteger("noSdcard").intValue() == 0) {
        break label663;
      }
      bool1 = true;
      label373:
      this.field_noSdcard = bool1;
      if (paramBoolean) {
        this.kzA = true;
      }
    }
    if (paramContentValues.containsKey("noEnoughSpace"))
    {
      if (paramContentValues.getAsInteger("noEnoughSpace").intValue() == 0) {
        break label668;
      }
      bool1 = true;
      label410:
      this.field_noEnoughSpace = bool1;
      if (paramBoolean) {
        this.kzB = true;
      }
    }
    if (paramContentValues.containsKey("lowBattery"))
    {
      if (paramContentValues.getAsInteger("lowBattery").intValue() == 0) {
        break label673;
      }
      bool1 = true;
      label447:
      this.field_lowBattery = bool1;
      if (paramBoolean) {
        this.kzC = true;
      }
    }
    if (paramContentValues.containsKey("continueDelay")) {
      if (paramContentValues.getAsInteger("continueDelay").intValue() == 0) {
        break label678;
      }
    }
    label648:
    label653:
    label658:
    label663:
    label668:
    label673:
    label678:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_continueDelay = bool1;
      if (paramBoolean) {
        this.kzD = true;
      }
      if (paramContentValues.containsKey("SecondaryUrl"))
      {
        this.field_SecondaryUrl = paramContentValues.getAsString("SecondaryUrl");
        if (paramBoolean) {
          this.kzE = true;
        }
      }
      if (paramContentValues.containsKey("downloadInWidget"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("downloadInWidget").intValue() != 0) {
          bool1 = true;
        }
        this.field_downloadInWidget = bool1;
        if (paramBoolean) {
          this.kzF = true;
        }
      }
      if (paramContentValues.containsKey("sectionMd5Byte"))
      {
        this.field_sectionMd5Byte = paramContentValues.getAsByteArray("sectionMd5Byte");
        if (paramBoolean) {
          this.klD = true;
        }
      }
      if (paramContentValues.containsKey("forceUpdateFlag"))
      {
        this.field_forceUpdateFlag = paramContentValues.getAsInteger("forceUpdateFlag").intValue();
        if (paramBoolean) {
          this.kzG = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label299;
      bool1 = false;
      break label336;
      bool1 = false;
      break label373;
      bool1 = false;
      break label410;
      bool1 = false;
      break label447;
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
      if (jKX != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.jKG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jWJ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (jLU == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (kfD == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (jNX == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (kyM == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (kzH == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (kzI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (kzJ == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (kzK == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (kzL == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (kzM == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (kzN == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (kzO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (kzP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (kzQ == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (kzR == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (kmh == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (kzS == k) {
              this.field_forceUpdateFlag = paramCursor.getInt(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.jNB) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.kyB) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.kzv) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.kzw) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.kzx) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.kzy) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.kzz) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.kzA) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.kzB) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.kzC) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.kzD) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.kzE) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.kzF) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.klD) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.kzG) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
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
  
  public StorageObserverOwner<? extends dt> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_appId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dt
 * JD-Core Version:    0.7.0.1
 */