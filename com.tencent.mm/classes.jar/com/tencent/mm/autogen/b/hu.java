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

public abstract class hu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("StoryExtItem");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column kea;
  private static final int kfD;
  private static final int ktJ;
  public static final Column ktl;
  public static final Column lbY;
  public static final Column lbZ;
  private static final int lcA;
  private static final int lcB;
  private static final int lcC;
  private static final int lcD;
  private static final int lcE;
  private static final int lcF;
  private static final int lcG;
  private static final int lcH;
  private static final int lcI;
  private static final int lcJ;
  private static final int lcK;
  private static final int lcL;
  private static final int lcM;
  private static final int lcN;
  public static final Column lca;
  public static final Column lcb;
  public static final Column lcc;
  public static final Column lcd;
  public static final Column lce;
  public static final Column lcf;
  public static final Column lcg;
  public static final Column lch;
  public static final Column lci;
  public static final Column lcj;
  public static final Column lck;
  public static final Column lcl;
  private static final StorageObserverOwner<hu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetuserName = true;
  public long field_duration;
  public String field_favoriteMd5;
  public long field_interactTime;
  public String field_md5;
  public String field_newThumbUrl;
  public String field_newVideoUrl;
  public long field_preLoadResource;
  public String field_preloadMediaId;
  public long field_preloadStoryId;
  public long field_readId;
  public long field_readTime;
  public int field_storyObjOneDay;
  public int field_storyPostTime;
  public long field_syncId;
  public long field_updateTime;
  public byte[] field_userInfo;
  public String field_userName;
  public int field_userStoryFlag;
  private boolean keP = true;
  private boolean ktx = true;
  private boolean lcm = true;
  private boolean lcn = true;
  private boolean lco = true;
  private boolean lcp = true;
  private boolean lcq = true;
  private boolean lcr = true;
  private boolean lcs = true;
  private boolean lct = true;
  private boolean lcu = true;
  private boolean lcv = true;
  private boolean lcw = true;
  private boolean lcx = true;
  private boolean lcy = true;
  private boolean lcz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    lbY = new Column("userStoryFlag", "int", TABLE.getName(), "");
    lbZ = new Column("newThumbUrl", "string", TABLE.getName(), "");
    lca = new Column("newVideoUrl", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    lcb = new Column("syncId", "long", TABLE.getName(), "");
    lcc = new Column("readId", "long", TABLE.getName(), "");
    lcd = new Column("storyPostTime", "int", TABLE.getName(), "");
    lce = new Column("storyObjOneDay", "int", TABLE.getName(), "");
    lcf = new Column("readTime", "long", TABLE.getName(), "");
    lcg = new Column("preloadStoryId", "long", TABLE.getName(), "");
    lch = new Column("preloadMediaId", "string", TABLE.getName(), "");
    lci = new Column("preLoadResource", "long", TABLE.getName(), "");
    ktl = new Column("duration", "long", TABLE.getName(), "");
    lcj = new Column("userInfo", "byte[]", TABLE.getName(), "");
    lck = new Column("favoriteMd5", "string", TABLE.getName(), "");
    lcl = new Column("interactTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    kfD = "md5".hashCode();
    lcA = "userStoryFlag".hashCode();
    lcB = "newThumbUrl".hashCode();
    lcC = "newVideoUrl".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    lcD = "syncId".hashCode();
    lcE = "readId".hashCode();
    lcF = "storyPostTime".hashCode();
    lcG = "storyObjOneDay".hashCode();
    lcH = "readTime".hashCode();
    lcI = "preloadStoryId".hashCode();
    lcJ = "preloadMediaId".hashCode();
    lcK = "preLoadResource".hashCode();
    ktJ = "duration".hashCode();
    lcL = "userInfo".hashCode();
    lcM = "favoriteMd5".hashCode();
    lcN = "interactTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userStoryFlag";
    localMAutoDBInfo.colsMap.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "newThumbUrl";
    localMAutoDBInfo.colsMap.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "newVideoUrl";
    localMAutoDBInfo.colsMap.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "syncId";
    localMAutoDBInfo.colsMap.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "readId";
    localMAutoDBInfo.colsMap.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "storyPostTime";
    localMAutoDBInfo.colsMap.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "storyObjOneDay";
    localMAutoDBInfo.colsMap.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "readTime";
    localMAutoDBInfo.colsMap.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "preloadStoryId";
    localMAutoDBInfo.colsMap.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "preloadMediaId";
    localMAutoDBInfo.colsMap.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "preLoadResource";
    localMAutoDBInfo.colsMap.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "duration";
    localMAutoDBInfo.colsMap.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "userInfo";
    localMAutoDBInfo.colsMap.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "favoriteMd5";
    localMAutoDBInfo.colsMap.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "interactTime";
    localMAutoDBInfo.colsMap.put("interactTime", "LONG");
    localStringBuilder.append(" interactTime LONG");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("userStoryFlag"))
    {
      this.field_userStoryFlag = paramContentValues.getAsInteger("userStoryFlag").intValue();
      if (paramBoolean) {
        this.lcm = true;
      }
    }
    if (paramContentValues.containsKey("newThumbUrl"))
    {
      this.field_newThumbUrl = paramContentValues.getAsString("newThumbUrl");
      if (paramBoolean) {
        this.lcn = true;
      }
    }
    if (paramContentValues.containsKey("newVideoUrl"))
    {
      this.field_newVideoUrl = paramContentValues.getAsString("newVideoUrl");
      if (paramBoolean) {
        this.lco = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("syncId"))
    {
      this.field_syncId = paramContentValues.getAsLong("syncId").longValue();
      if (paramBoolean) {
        this.lcp = true;
      }
    }
    if (paramContentValues.containsKey("readId"))
    {
      this.field_readId = paramContentValues.getAsLong("readId").longValue();
      if (paramBoolean) {
        this.lcq = true;
      }
    }
    if (paramContentValues.containsKey("storyPostTime"))
    {
      this.field_storyPostTime = paramContentValues.getAsInteger("storyPostTime").intValue();
      if (paramBoolean) {
        this.lcr = true;
      }
    }
    if (paramContentValues.containsKey("storyObjOneDay"))
    {
      this.field_storyObjOneDay = paramContentValues.getAsInteger("storyObjOneDay").intValue();
      if (paramBoolean) {
        this.lcs = true;
      }
    }
    if (paramContentValues.containsKey("readTime"))
    {
      this.field_readTime = paramContentValues.getAsLong("readTime").longValue();
      if (paramBoolean) {
        this.lct = true;
      }
    }
    if (paramContentValues.containsKey("preloadStoryId"))
    {
      this.field_preloadStoryId = paramContentValues.getAsLong("preloadStoryId").longValue();
      if (paramBoolean) {
        this.lcu = true;
      }
    }
    if (paramContentValues.containsKey("preloadMediaId"))
    {
      this.field_preloadMediaId = paramContentValues.getAsString("preloadMediaId");
      if (paramBoolean) {
        this.lcv = true;
      }
    }
    if (paramContentValues.containsKey("preLoadResource"))
    {
      this.field_preLoadResource = paramContentValues.getAsLong("preLoadResource").longValue();
      if (paramBoolean) {
        this.lcw = true;
      }
    }
    if (paramContentValues.containsKey("duration"))
    {
      this.field_duration = paramContentValues.getAsLong("duration").longValue();
      if (paramBoolean) {
        this.ktx = true;
      }
    }
    if (paramContentValues.containsKey("userInfo"))
    {
      this.field_userInfo = paramContentValues.getAsByteArray("userInfo");
      if (paramBoolean) {
        this.lcx = true;
      }
    }
    if (paramContentValues.containsKey("favoriteMd5"))
    {
      this.field_favoriteMd5 = paramContentValues.getAsString("favoriteMd5");
      if (paramBoolean) {
        this.lcy = true;
      }
    }
    if (paramContentValues.containsKey("interactTime"))
    {
      this.field_interactTime = paramContentValues.getAsLong("interactTime").longValue();
      if (paramBoolean) {
        this.lcz = true;
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
      if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (lcA == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (lcB == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (lcC == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (lcD == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (lcE == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (lcF == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (lcG == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (lcH == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (lcI == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (lcJ == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (lcK == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (ktJ == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (lcL == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (lcM == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (lcN == k) {
        this.field_interactTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
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
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.lcm) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.lcn) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.lco) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.lcp) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.lcq) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.lcr) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.lcs) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.lct) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.lcu) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.lcv) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.lcw) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.ktx) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.lcx) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.lcy) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.lcz) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
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
  
  public StorageObserverOwner<? extends hu> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.hu
 * JD-Core Version:    0.7.0.1
 */