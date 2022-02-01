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

public abstract class je
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaAttributesTable");
  public static final Column USERNAME;
  public static final Column jKD;
  private static final int jKX;
  public static final Column jKp;
  private static final int jLl;
  public static final Column jLo;
  private static final int jLq;
  public static final Column jSz;
  private static final int jTb;
  public static final Column jTk;
  private static final int jTs;
  private static final int jUD;
  public static final Column jUv;
  public static final Column kHX;
  private static final int kIh;
  public static final Column loA;
  public static final Column loB;
  public static final Column loC;
  public static final Column loD;
  public static final Column loE;
  public static final Column loF;
  public static final Column loG;
  public static final Column loH;
  public static final Column loI;
  public static final Column loJ;
  private static final int loX;
  private static final int loY;
  private static final int loZ;
  public static final Column lox;
  public static final Column loy;
  public static final Column loz;
  private static final int lpa;
  private static final int lpb;
  private static final int lpc;
  private static final int lpd;
  private static final int lpe;
  private static final int lpf;
  private static final int lpg;
  private static final int lph;
  private static final int lpi;
  private static final int lpj;
  private static final StorageObserverOwner<je> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_appInfo;
  public int field_appOpt;
  public String field_bigHeadURL;
  public String field_bindWxaInfo;
  public String field_bizMenu;
  public String field_brandIconURL;
  public String field_dynamicInfo;
  public String field_nickname;
  public String field_passThroughInfo;
  public String field_registerSource;
  public String field_reserved;
  public String field_roundedSquareIconURL;
  public String field_shortNickname;
  public String field_signature;
  public String field_smallHeadURL;
  public long field_syncTimeSecond;
  public String field_syncVersion;
  public String field_username;
  public int field_usernameHash;
  public String field_versionInfo;
  private boolean jKG = true;
  private boolean jKU = true;
  private boolean jLp = true;
  private boolean jSN = true;
  private boolean jTo = true;
  private boolean kIc = true;
  private boolean kKW = true;
  private boolean loK = true;
  private boolean loL = true;
  private boolean loM = true;
  private boolean loN = true;
  private boolean loO = true;
  private boolean loP = true;
  private boolean loQ = true;
  private boolean loR = true;
  private boolean loS = true;
  private boolean loT = true;
  private boolean loU = true;
  private boolean loV = true;
  private boolean loW = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jLo = new Column("usernameHash", "int", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    lox = new Column("shortNickname", "string", TABLE.getName(), "");
    jSz = new Column("brandIconURL", "string", TABLE.getName(), "");
    loy = new Column("roundedSquareIconURL", "string", TABLE.getName(), "");
    loz = new Column("bigHeadURL", "string", TABLE.getName(), "");
    loA = new Column("smallHeadURL", "string", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    loB = new Column("appOpt", "int", TABLE.getName(), "");
    loC = new Column("registerSource", "string", TABLE.getName(), "");
    loD = new Column("appInfo", "string", TABLE.getName(), "");
    kHX = new Column("versionInfo", "string", TABLE.getName(), "");
    loE = new Column("passThroughInfo", "string", TABLE.getName(), "");
    loF = new Column("bindWxaInfo", "string", TABLE.getName(), "");
    loG = new Column("dynamicInfo", "string", TABLE.getName(), "");
    jUv = new Column("reserved", "string", TABLE.getName(), "");
    loH = new Column("syncTimeSecond", "long", TABLE.getName(), "");
    loI = new Column("syncVersion", "string", TABLE.getName(), "");
    loJ = new Column("bizMenu", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
    jLq = "usernameHash".hashCode();
    username_HASHCODE = "username".hashCode();
    jKX = "appId".hashCode();
    jTs = "nickname".hashCode();
    loX = "shortNickname".hashCode();
    jTb = "brandIconURL".hashCode();
    loY = "roundedSquareIconURL".hashCode();
    loZ = "bigHeadURL".hashCode();
    lpa = "smallHeadURL".hashCode();
    jLl = "signature".hashCode();
    lpb = "appOpt".hashCode();
    lpc = "registerSource".hashCode();
    lpd = "appInfo".hashCode();
    kIh = "versionInfo".hashCode();
    lpe = "passThroughInfo".hashCode();
    lpf = "bindWxaInfo".hashCode();
    lpg = "dynamicInfo".hashCode();
    jUD = "reserved".hashCode();
    lph = "syncTimeSecond".hashCode();
    lpi = "syncVersion".hashCode();
    lpj = "bizMenu".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[21];
    localMAutoDBInfo.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "usernameHash";
    localMAutoDBInfo.colsMap.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "usernameHash";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "shortNickname";
    localMAutoDBInfo.colsMap.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "brandIconURL";
    localMAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "roundedSquareIconURL";
    localMAutoDBInfo.colsMap.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bigHeadURL";
    localMAutoDBInfo.colsMap.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "smallHeadURL";
    localMAutoDBInfo.colsMap.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "appOpt";
    localMAutoDBInfo.colsMap.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "registerSource";
    localMAutoDBInfo.colsMap.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "appInfo";
    localMAutoDBInfo.colsMap.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "versionInfo";
    localMAutoDBInfo.colsMap.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "passThroughInfo";
    localMAutoDBInfo.colsMap.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bindWxaInfo";
    localMAutoDBInfo.colsMap.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "dynamicInfo";
    localMAutoDBInfo.colsMap.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "reserved";
    localMAutoDBInfo.colsMap.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "syncTimeSecond";
    localMAutoDBInfo.colsMap.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "syncVersion";
    localMAutoDBInfo.colsMap.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "bizMenu";
    localMAutoDBInfo.colsMap.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    localMAutoDBInfo.columns[21] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("usernameHash"))
    {
      this.field_usernameHash = paramContentValues.getAsInteger("usernameHash").intValue();
      if (paramBoolean) {
        this.jLp = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("shortNickname"))
    {
      this.field_shortNickname = paramContentValues.getAsString("shortNickname");
      if (paramBoolean) {
        this.loK = true;
      }
    }
    if (paramContentValues.containsKey("brandIconURL"))
    {
      this.field_brandIconURL = paramContentValues.getAsString("brandIconURL");
      if (paramBoolean) {
        this.jSN = true;
      }
    }
    if (paramContentValues.containsKey("roundedSquareIconURL"))
    {
      this.field_roundedSquareIconURL = paramContentValues.getAsString("roundedSquareIconURL");
      if (paramBoolean) {
        this.loL = true;
      }
    }
    if (paramContentValues.containsKey("bigHeadURL"))
    {
      this.field_bigHeadURL = paramContentValues.getAsString("bigHeadURL");
      if (paramBoolean) {
        this.loM = true;
      }
    }
    if (paramContentValues.containsKey("smallHeadURL"))
    {
      this.field_smallHeadURL = paramContentValues.getAsString("smallHeadURL");
      if (paramBoolean) {
        this.loN = true;
      }
    }
    if (paramContentValues.containsKey("signature"))
    {
      this.field_signature = paramContentValues.getAsString("signature");
      if (paramBoolean) {
        this.jKU = true;
      }
    }
    if (paramContentValues.containsKey("appOpt"))
    {
      this.field_appOpt = paramContentValues.getAsInteger("appOpt").intValue();
      if (paramBoolean) {
        this.loO = true;
      }
    }
    if (paramContentValues.containsKey("registerSource"))
    {
      this.field_registerSource = paramContentValues.getAsString("registerSource");
      if (paramBoolean) {
        this.loP = true;
      }
    }
    if (paramContentValues.containsKey("appInfo"))
    {
      this.field_appInfo = paramContentValues.getAsString("appInfo");
      if (paramBoolean) {
        this.loQ = true;
      }
    }
    if (paramContentValues.containsKey("versionInfo"))
    {
      this.field_versionInfo = paramContentValues.getAsString("versionInfo");
      if (paramBoolean) {
        this.kIc = true;
      }
    }
    if (paramContentValues.containsKey("passThroughInfo"))
    {
      this.field_passThroughInfo = paramContentValues.getAsString("passThroughInfo");
      if (paramBoolean) {
        this.loR = true;
      }
    }
    if (paramContentValues.containsKey("bindWxaInfo"))
    {
      this.field_bindWxaInfo = paramContentValues.getAsString("bindWxaInfo");
      if (paramBoolean) {
        this.loS = true;
      }
    }
    if (paramContentValues.containsKey("dynamicInfo"))
    {
      this.field_dynamicInfo = paramContentValues.getAsString("dynamicInfo");
      if (paramBoolean) {
        this.loT = true;
      }
    }
    if (paramContentValues.containsKey("reserved"))
    {
      this.field_reserved = paramContentValues.getAsString("reserved");
      if (paramBoolean) {
        this.kKW = true;
      }
    }
    if (paramContentValues.containsKey("syncTimeSecond"))
    {
      this.field_syncTimeSecond = paramContentValues.getAsLong("syncTimeSecond").longValue();
      if (paramBoolean) {
        this.loU = true;
      }
    }
    if (paramContentValues.containsKey("syncVersion"))
    {
      this.field_syncVersion = paramContentValues.getAsString("syncVersion");
      if (paramBoolean) {
        this.loV = true;
      }
    }
    if (paramContentValues.containsKey("bizMenu"))
    {
      this.field_bizMenu = paramContentValues.getAsString("bizMenu");
      if (paramBoolean) {
        this.loW = true;
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
      if (jLq != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.jLp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (loX == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (jTb == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (loY == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (loZ == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (lpa == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (jLl == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (lpb == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (lpc == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (lpd == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (kIh == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (lpe == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (lpf == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (lpg == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (jUD == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (lph == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (lpi == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (lpj == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jLp) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.loK) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.jSN) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.loL) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.loM) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.loN) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.jKU) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.loO) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.loP) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.loQ) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.kIc) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.loR) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.loS) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.loT) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.kKW) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.loU) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.loV) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.loW) {
      localContentValues.put("bizMenu", this.field_bizMenu);
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
  
  public StorageObserverOwner<? extends je> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_usernameHash);
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
 * Qualified Name:     com.tencent.mm.autogen.b.je
 * JD-Core Version:    0.7.0.1
 */