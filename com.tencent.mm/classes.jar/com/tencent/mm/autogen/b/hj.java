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

public abstract class hj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column FINDEROBJECT;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsCover");
  public static final Column TYPE;
  public static final Column USERNAME;
  private static final int finderObject_HASHCODE;
  private static final int kZA;
  private static final int kZB;
  private static final int kZC;
  private static final int kZD;
  private static final int kZE;
  private static final int kZF;
  private static final int kZG;
  private static final int kZH;
  private static final int kZI;
  private static final int kZJ;
  public static final Column kZg;
  public static final Column kZh;
  public static final Column kZi;
  public static final Column kZj;
  public static final Column kZk;
  public static final Column kZl;
  public static final Column kZm;
  public static final Column kZn;
  public static final Column kZo;
  public static final Column kZp;
  public static final Column keq;
  private static final int kfT;
  private static final StorageObserverOwner<hj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetfinderObject = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  public String field_cacheVideo;
  public long field_finderCheckTime;
  public byte[] field_finderObject;
  public String field_imageBgUrl;
  public boolean field_isLike;
  public String field_localImage;
  public String field_localThumb;
  public String field_localVideo;
  public long field_snsBgId;
  public boolean field_success;
  public String field_thumbUrl;
  public int field_type;
  public String field_userName;
  public String field_videoBgUrl;
  private boolean kZq = true;
  private boolean kZr = true;
  private boolean kZs = true;
  private boolean kZt = true;
  private boolean kZu = true;
  private boolean kZv = true;
  private boolean kZw = true;
  private boolean kZx = true;
  private boolean kZy = true;
  private boolean kZz = true;
  private boolean kff = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kZg = new Column("snsBgId", "long", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    kZh = new Column("imageBgUrl", "string", TABLE.getName(), "");
    kZi = new Column("videoBgUrl", "string", TABLE.getName(), "");
    kZj = new Column("localThumb", "string", TABLE.getName(), "");
    kZk = new Column("localImage", "string", TABLE.getName(), "");
    kZl = new Column("localVideo", "string", TABLE.getName(), "");
    kZm = new Column("cacheVideo", "string", TABLE.getName(), "");
    FINDEROBJECT = new Column("finderObject", "byte[]", TABLE.getName(), "");
    kZn = new Column("finderCheckTime", "long", TABLE.getName(), "");
    kZo = new Column("success", "boolean", TABLE.getName(), "");
    kZp = new Column("isLike", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    type_HASHCODE = "type".hashCode();
    kZA = "snsBgId".hashCode();
    kfT = "thumbUrl".hashCode();
    kZB = "imageBgUrl".hashCode();
    kZC = "videoBgUrl".hashCode();
    kZD = "localThumb".hashCode();
    kZE = "localImage".hashCode();
    kZF = "localVideo".hashCode();
    kZG = "cacheVideo".hashCode();
    finderObject_HASHCODE = "finderObject".hashCode();
    kZH = "finderCheckTime".hashCode();
    kZI = "success".hashCode();
    kZJ = "isLike".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "snsBgId";
    localMAutoDBInfo.colsMap.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "imageBgUrl";
    localMAutoDBInfo.colsMap.put("imageBgUrl", "TEXT");
    localStringBuilder.append(" imageBgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "videoBgUrl";
    localMAutoDBInfo.colsMap.put("videoBgUrl", "TEXT");
    localStringBuilder.append(" videoBgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "localThumb";
    localMAutoDBInfo.colsMap.put("localThumb", "TEXT");
    localStringBuilder.append(" localThumb TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "localImage";
    localMAutoDBInfo.colsMap.put("localImage", "TEXT");
    localStringBuilder.append(" localImage TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "localVideo";
    localMAutoDBInfo.colsMap.put("localVideo", "TEXT");
    localStringBuilder.append(" localVideo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "cacheVideo";
    localMAutoDBInfo.colsMap.put("cacheVideo", "TEXT");
    localStringBuilder.append(" cacheVideo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "finderObject";
    localMAutoDBInfo.colsMap.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "finderCheckTime";
    localMAutoDBInfo.colsMap.put("finderCheckTime", "LONG");
    localStringBuilder.append(" finderCheckTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "success";
    localMAutoDBInfo.colsMap.put("success", "INTEGER default 'false' ");
    localStringBuilder.append(" success INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "isLike";
    localMAutoDBInfo.colsMap.put("isLike", "INTEGER default 'false' ");
    localStringBuilder.append(" isLike INTEGER default 'false' ");
    localMAutoDBInfo.columns[14] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("snsBgId"))
    {
      this.field_snsBgId = paramContentValues.getAsLong("snsBgId").longValue();
      if (paramBoolean) {
        this.kZq = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("imageBgUrl"))
    {
      this.field_imageBgUrl = paramContentValues.getAsString("imageBgUrl");
      if (paramBoolean) {
        this.kZr = true;
      }
    }
    if (paramContentValues.containsKey("videoBgUrl"))
    {
      this.field_videoBgUrl = paramContentValues.getAsString("videoBgUrl");
      if (paramBoolean) {
        this.kZs = true;
      }
    }
    if (paramContentValues.containsKey("localThumb"))
    {
      this.field_localThumb = paramContentValues.getAsString("localThumb");
      if (paramBoolean) {
        this.kZt = true;
      }
    }
    if (paramContentValues.containsKey("localImage"))
    {
      this.field_localImage = paramContentValues.getAsString("localImage");
      if (paramBoolean) {
        this.kZu = true;
      }
    }
    if (paramContentValues.containsKey("localVideo"))
    {
      this.field_localVideo = paramContentValues.getAsString("localVideo");
      if (paramBoolean) {
        this.kZv = true;
      }
    }
    if (paramContentValues.containsKey("cacheVideo"))
    {
      this.field_cacheVideo = paramContentValues.getAsString("cacheVideo");
      if (paramBoolean) {
        this.kZw = true;
      }
    }
    if (paramContentValues.containsKey("finderObject"))
    {
      this.field_finderObject = paramContentValues.getAsByteArray("finderObject");
      if (paramBoolean) {
        this.__hadSetfinderObject = true;
      }
    }
    if (paramContentValues.containsKey("finderCheckTime"))
    {
      this.field_finderCheckTime = paramContentValues.getAsLong("finderCheckTime").longValue();
      if (paramBoolean) {
        this.kZx = true;
      }
    }
    if (paramContentValues.containsKey("success")) {
      if (paramContentValues.getAsInteger("success").intValue() == 0) {
        break label448;
      }
    }
    label448:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_success = bool1;
      if (paramBoolean) {
        this.kZy = true;
      }
      if (paramContentValues.containsKey("isLike"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("isLike").intValue() != 0) {
          bool1 = true;
        }
        this.field_isLike = bool1;
        if (paramBoolean) {
          this.kZz = true;
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
      if (userName_HASHCODE != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.__hadSetuserName = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (kZA == k)
      {
        this.field_snsBgId = paramCursor.getLong(i);
      }
      else if (kfT == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (kZB == k)
      {
        this.field_imageBgUrl = paramCursor.getString(i);
      }
      else if (kZC == k)
      {
        this.field_videoBgUrl = paramCursor.getString(i);
      }
      else if (kZD == k)
      {
        this.field_localThumb = paramCursor.getString(i);
      }
      else if (kZE == k)
      {
        this.field_localImage = paramCursor.getString(i);
      }
      else if (kZF == k)
      {
        this.field_localVideo = paramCursor.getString(i);
      }
      else if (kZG == k)
      {
        this.field_cacheVideo = paramCursor.getString(i);
      }
      else if (finderObject_HASHCODE == k)
      {
        this.field_finderObject = paramCursor.getBlob(i);
      }
      else if (kZH == k)
      {
        this.field_finderCheckTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (kZI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_success = bool;
            break;
          }
        }
        if (kZJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isLike = bool;
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
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kZq) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.kZr) {
      localContentValues.put("imageBgUrl", this.field_imageBgUrl);
    }
    if (this.kZs) {
      localContentValues.put("videoBgUrl", this.field_videoBgUrl);
    }
    if (this.kZt) {
      localContentValues.put("localThumb", this.field_localThumb);
    }
    if (this.kZu) {
      localContentValues.put("localImage", this.field_localImage);
    }
    if (this.kZv) {
      localContentValues.put("localVideo", this.field_localVideo);
    }
    if (this.kZw) {
      localContentValues.put("cacheVideo", this.field_cacheVideo);
    }
    if (this.__hadSetfinderObject) {
      localContentValues.put("finderObject", this.field_finderObject);
    }
    if (this.kZx) {
      localContentValues.put("finderCheckTime", Long.valueOf(this.field_finderCheckTime));
    }
    if (this.kZy) {
      localContentValues.put("success", Boolean.valueOf(this.field_success));
    }
    if (this.kZz) {
      localContentValues.put("isLike", Boolean.valueOf(this.field_isLike));
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
  
  public StorageObserverOwner<? extends hj> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_userName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.hj
 * JD-Core Version:    0.7.0.1
 */