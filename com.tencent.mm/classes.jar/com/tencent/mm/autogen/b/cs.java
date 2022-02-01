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

public abstract class cs
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveGiftInfo");
  public static final Column jOV;
  private static final int jOZ;
  public static final Column kee;
  public static final Column kef;
  private static final int kfH;
  private static final int kfI;
  public static final Column krC;
  public static final Column krD;
  public static final Column krE;
  public static final Column krF;
  public static final Column krG;
  public static final Column krH;
  public static final Column krI;
  public static final Column krJ;
  public static final Column krK;
  public static final Column krL;
  public static final Column krM;
  public static final Column krN;
  private static final int ksa;
  private static final int ksb;
  private static final int ksc;
  private static final int ksd;
  private static final int kse;
  private static final int ksf;
  private static final int ksg;
  private static final int ksh;
  private static final int ksi;
  private static final int ksj;
  private static final int ksk;
  private static final int ksl;
  private static final StorageObserverOwner<cs> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_animationPagMd5;
  public String field_animationPagUrl;
  public int field_businessType;
  public int field_flag;
  public int field_giftIndex;
  public int field_giftType;
  public String field_name;
  public String field_previewPagMd5;
  public String field_previewPagUrl;
  public float field_price;
  public String field_rewardProductId;
  public int field_state;
  public String field_thumbnailFileUrl;
  public String field_thumbnailMd5;
  public int field_unlockIntimacyLevel;
  private boolean jOX = true;
  private boolean keT = true;
  private boolean keU = true;
  private boolean krO = true;
  private boolean krP = true;
  private boolean krQ = true;
  private boolean krR = true;
  private boolean krS = true;
  private boolean krT = true;
  private boolean krU = true;
  private boolean krV = true;
  private boolean krW = true;
  private boolean krX = true;
  private boolean krY = true;
  private boolean krZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krC = new Column("rewardProductId", "string", TABLE.getName(), "");
    krD = new Column("businessType", "int", TABLE.getName(), "");
    krE = new Column("thumbnailFileUrl", "string", TABLE.getName(), "");
    krF = new Column("previewPagUrl", "string", TABLE.getName(), "");
    krG = new Column("animationPagUrl", "string", TABLE.getName(), "");
    krH = new Column("thumbnailMd5", "string", TABLE.getName(), "");
    krI = new Column("previewPagMd5", "string", TABLE.getName(), "");
    krJ = new Column("animationPagMd5", "string", TABLE.getName(), "");
    krK = new Column("giftType", "int", TABLE.getName(), "");
    kef = new Column("name", "string", TABLE.getName(), "");
    krL = new Column("price", "float", TABLE.getName(), "");
    krM = new Column("unlockIntimacyLevel", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    krN = new Column("giftIndex", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    ksa = "rewardProductId".hashCode();
    ksb = "businessType".hashCode();
    ksc = "thumbnailFileUrl".hashCode();
    ksd = "previewPagUrl".hashCode();
    kse = "animationPagUrl".hashCode();
    ksf = "thumbnailMd5".hashCode();
    ksg = "previewPagMd5".hashCode();
    ksh = "animationPagMd5".hashCode();
    ksi = "giftType".hashCode();
    kfI = "name".hashCode();
    ksj = "price".hashCode();
    ksk = "unlockIntimacyLevel".hashCode();
    jOZ = "flag".hashCode();
    kfH = "state".hashCode();
    ksl = "giftIndex".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[15];
    localMAutoDBInfo.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "rewardProductId";
    localMAutoDBInfo.colsMap.put("rewardProductId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" rewardProductId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "rewardProductId";
    localMAutoDBInfo.columns[1] = "businessType";
    localMAutoDBInfo.colsMap.put("businessType", "INTEGER default '' ");
    localStringBuilder.append(" businessType INTEGER default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "thumbnailFileUrl";
    localMAutoDBInfo.colsMap.put("thumbnailFileUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbnailFileUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "previewPagUrl";
    localMAutoDBInfo.colsMap.put("previewPagUrl", "TEXT default '' ");
    localStringBuilder.append(" previewPagUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "animationPagUrl";
    localMAutoDBInfo.colsMap.put("animationPagUrl", "TEXT default '' ");
    localStringBuilder.append(" animationPagUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thumbnailMd5";
    localMAutoDBInfo.colsMap.put("thumbnailMd5", "TEXT default '' ");
    localStringBuilder.append(" thumbnailMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "previewPagMd5";
    localMAutoDBInfo.colsMap.put("previewPagMd5", "TEXT default '' ");
    localStringBuilder.append(" previewPagMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "animationPagMd5";
    localMAutoDBInfo.colsMap.put("animationPagMd5", "TEXT default '' ");
    localStringBuilder.append(" animationPagMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "giftType";
    localMAutoDBInfo.colsMap.put("giftType", "INTEGER default '' ");
    localStringBuilder.append(" giftType INTEGER default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "price";
    localMAutoDBInfo.colsMap.put("price", "FLOAT");
    localStringBuilder.append(" price FLOAT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "unlockIntimacyLevel";
    localMAutoDBInfo.colsMap.put("unlockIntimacyLevel", "INTEGER");
    localStringBuilder.append(" unlockIntimacyLevel INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "giftIndex";
    localMAutoDBInfo.colsMap.put("giftIndex", "INTEGER");
    localStringBuilder.append(" giftIndex INTEGER");
    localMAutoDBInfo.columns[15] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("rewardProductId"))
    {
      this.field_rewardProductId = paramContentValues.getAsString("rewardProductId");
      if (paramBoolean) {
        this.krO = true;
      }
    }
    if (paramContentValues.containsKey("businessType"))
    {
      this.field_businessType = paramContentValues.getAsInteger("businessType").intValue();
      if (paramBoolean) {
        this.krP = true;
      }
    }
    if (paramContentValues.containsKey("thumbnailFileUrl"))
    {
      this.field_thumbnailFileUrl = paramContentValues.getAsString("thumbnailFileUrl");
      if (paramBoolean) {
        this.krQ = true;
      }
    }
    if (paramContentValues.containsKey("previewPagUrl"))
    {
      this.field_previewPagUrl = paramContentValues.getAsString("previewPagUrl");
      if (paramBoolean) {
        this.krR = true;
      }
    }
    if (paramContentValues.containsKey("animationPagUrl"))
    {
      this.field_animationPagUrl = paramContentValues.getAsString("animationPagUrl");
      if (paramBoolean) {
        this.krS = true;
      }
    }
    if (paramContentValues.containsKey("thumbnailMd5"))
    {
      this.field_thumbnailMd5 = paramContentValues.getAsString("thumbnailMd5");
      if (paramBoolean) {
        this.krT = true;
      }
    }
    if (paramContentValues.containsKey("previewPagMd5"))
    {
      this.field_previewPagMd5 = paramContentValues.getAsString("previewPagMd5");
      if (paramBoolean) {
        this.krU = true;
      }
    }
    if (paramContentValues.containsKey("animationPagMd5"))
    {
      this.field_animationPagMd5 = paramContentValues.getAsString("animationPagMd5");
      if (paramBoolean) {
        this.krV = true;
      }
    }
    if (paramContentValues.containsKey("giftType"))
    {
      this.field_giftType = paramContentValues.getAsInteger("giftType").intValue();
      if (paramBoolean) {
        this.krW = true;
      }
    }
    if (paramContentValues.containsKey("name"))
    {
      this.field_name = paramContentValues.getAsString("name");
      if (paramBoolean) {
        this.keU = true;
      }
    }
    if (paramContentValues.containsKey("price"))
    {
      this.field_price = paramContentValues.getAsFloat("price").floatValue();
      if (paramBoolean) {
        this.krX = true;
      }
    }
    if (paramContentValues.containsKey("unlockIntimacyLevel"))
    {
      this.field_unlockIntimacyLevel = paramContentValues.getAsInteger("unlockIntimacyLevel").intValue();
      if (paramBoolean) {
        this.krY = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("giftIndex"))
    {
      this.field_giftIndex = paramContentValues.getAsInteger("giftIndex").intValue();
      if (paramBoolean) {
        this.krZ = true;
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
      if (ksa != k) {
        break label65;
      }
      this.field_rewardProductId = paramCursor.getString(i);
      this.krO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ksb == k) {
        this.field_businessType = paramCursor.getInt(i);
      } else if (ksc == k) {
        this.field_thumbnailFileUrl = paramCursor.getString(i);
      } else if (ksd == k) {
        this.field_previewPagUrl = paramCursor.getString(i);
      } else if (kse == k) {
        this.field_animationPagUrl = paramCursor.getString(i);
      } else if (ksf == k) {
        this.field_thumbnailMd5 = paramCursor.getString(i);
      } else if (ksg == k) {
        this.field_previewPagMd5 = paramCursor.getString(i);
      } else if (ksh == k) {
        this.field_animationPagMd5 = paramCursor.getString(i);
      } else if (ksi == k) {
        this.field_giftType = paramCursor.getInt(i);
      } else if (kfI == k) {
        this.field_name = paramCursor.getString(i);
      } else if (ksj == k) {
        this.field_price = paramCursor.getFloat(i);
      } else if (ksk == k) {
        this.field_unlockIntimacyLevel = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (ksl == k) {
        this.field_giftIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krO) {
      localContentValues.put("rewardProductId", this.field_rewardProductId);
    }
    if (this.krP) {
      localContentValues.put("businessType", Integer.valueOf(this.field_businessType));
    }
    if (this.field_thumbnailFileUrl == null) {
      this.field_thumbnailFileUrl = "";
    }
    if (this.krQ) {
      localContentValues.put("thumbnailFileUrl", this.field_thumbnailFileUrl);
    }
    if (this.field_previewPagUrl == null) {
      this.field_previewPagUrl = "";
    }
    if (this.krR) {
      localContentValues.put("previewPagUrl", this.field_previewPagUrl);
    }
    if (this.field_animationPagUrl == null) {
      this.field_animationPagUrl = "";
    }
    if (this.krS) {
      localContentValues.put("animationPagUrl", this.field_animationPagUrl);
    }
    if (this.field_thumbnailMd5 == null) {
      this.field_thumbnailMd5 = "";
    }
    if (this.krT) {
      localContentValues.put("thumbnailMd5", this.field_thumbnailMd5);
    }
    if (this.field_previewPagMd5 == null) {
      this.field_previewPagMd5 = "";
    }
    if (this.krU) {
      localContentValues.put("previewPagMd5", this.field_previewPagMd5);
    }
    if (this.field_animationPagMd5 == null) {
      this.field_animationPagMd5 = "";
    }
    if (this.krV) {
      localContentValues.put("animationPagMd5", this.field_animationPagMd5);
    }
    if (this.krW) {
      localContentValues.put("giftType", Integer.valueOf(this.field_giftType));
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.keU) {
      localContentValues.put("name", this.field_name);
    }
    if (this.krX) {
      localContentValues.put("price", Float.valueOf(this.field_price));
    }
    if (this.krY) {
      localContentValues.put("unlockIntimacyLevel", Integer.valueOf(this.field_unlockIntimacyLevel));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.krZ) {
      localContentValues.put("giftIndex", Integer.valueOf(this.field_giftIndex));
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
  
  public StorageObserverOwner<? extends cs> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_rewardProductId;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cs
 * JD-Core Version:    0.7.0.1
 */