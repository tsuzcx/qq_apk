package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gz
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("StoryExtItem");
  public static final Column hGW;
  private static final int hIy;
  public static final Column hTM;
  private static final int hUk = "duration".hashCode();
  public static final Column iAA;
  public static final Column iAB;
  public static final Column iAC;
  public static final Column iAD;
  public static final Column iAE;
  public static final Column iAF;
  public static final Column iAG;
  public static final Column iAH;
  public static final Column iAI;
  private static final int iAX;
  private static final int iAY;
  private static final int iAZ;
  public static final Column iAv;
  public static final Column iAw;
  public static final Column iAx;
  public static final Column iAy;
  public static final Column iAz;
  private static final int iBa;
  private static final int iBb;
  private static final int iBc;
  private static final int iBd;
  private static final int iBe;
  private static final int iBf;
  private static final int iBg;
  private static final int iBh;
  private static final int iBi = "userInfo".hashCode();
  private static final int iBj = "favoriteMd5".hashCode();
  private static final int iBk = "interactTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hHK = true;
  private boolean hTY = true;
  private boolean iAJ = true;
  private boolean iAK = true;
  private boolean iAL = true;
  private boolean iAM = true;
  private boolean iAN = true;
  private boolean iAO = true;
  private boolean iAP = true;
  private boolean iAQ = true;
  private boolean iAR = true;
  private boolean iAS = true;
  private boolean iAT = true;
  private boolean iAU = true;
  private boolean iAV = true;
  private boolean iAW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "StoryExtItem", "");
    C_USERNAME = new Column("username", "string", "StoryExtItem", "");
    hGW = new Column("md5", "string", "StoryExtItem", "");
    iAv = new Column("userstoryflag", "int", "StoryExtItem", "");
    iAw = new Column("newthumburl", "string", "StoryExtItem", "");
    iAx = new Column("newvideourl", "string", "StoryExtItem", "");
    C_UPDATETIME = new Column("updatetime", "long", "StoryExtItem", "");
    iAy = new Column("syncid", "long", "StoryExtItem", "");
    iAz = new Column("readid", "long", "StoryExtItem", "");
    iAA = new Column("storyposttime", "int", "StoryExtItem", "");
    iAB = new Column("storyobjoneday", "int", "StoryExtItem", "");
    iAC = new Column("readtime", "long", "StoryExtItem", "");
    iAD = new Column("preloadstoryid", "long", "StoryExtItem", "");
    iAE = new Column("preloadmediaid", "string", "StoryExtItem", "");
    iAF = new Column("preloadresource", "long", "StoryExtItem", "");
    hTM = new Column("duration", "long", "StoryExtItem", "");
    iAG = new Column("userinfo", "byte[]", "StoryExtItem", "");
    iAH = new Column("favoritemd5", "string", "StoryExtItem", "");
    iAI = new Column("interacttime", "long", "StoryExtItem", "");
    userName_HASHCODE = "userName".hashCode();
    hIy = "md5".hashCode();
    iAX = "userStoryFlag".hashCode();
    iAY = "newThumbUrl".hashCode();
    iAZ = "newVideoUrl".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    iBa = "syncId".hashCode();
    iBb = "readId".hashCode();
    iBc = "storyPostTime".hashCode();
    iBd = "storyObjOneDay".hashCode();
    iBe = "readTime".hashCode();
    iBf = "preloadStoryId".hashCode();
    iBg = "preloadMediaId".hashCode();
    iBh = "preLoadResource".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    return localMAutoDBInfo;
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
      if (hIy == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (iAX == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (iAY == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (iAZ == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (iBa == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (iBb == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (iBc == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (iBd == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (iBe == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (iBf == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (iBg == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (iBh == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (hUk == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (iBi == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (iBj == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (iBk == k) {
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
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.iAJ) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.iAK) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.iAL) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.iAM) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.iAN) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.iAO) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.iAP) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.iAQ) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.iAR) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.iAS) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.iAT) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.hTY) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.iAU) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.iAV) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.iAW) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "StoryExtItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.gz
 * JD-Core Version:    0.7.0.1
 */