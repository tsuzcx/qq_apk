package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gs
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fFe = "duration".hashCode();
  private static final int fyf;
  private static final int gbA;
  private static final int gbB = "userInfo".hashCode();
  private static final int gbC = "favoriteMd5".hashCode();
  private static final int gbD = "interactTime".hashCode();
  private static final int gbq;
  private static final int gbr;
  private static final int gbs;
  private static final int gbt;
  private static final int gbu;
  private static final int gbv;
  private static final int gbw;
  private static final int gbx;
  private static final int gby;
  private static final int gbz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetuserName = true;
  private boolean fES = true;
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
  private boolean fxt = true;
  private boolean gbc = true;
  private boolean gbd = true;
  private boolean gbe = true;
  private boolean gbf = true;
  private boolean gbg = true;
  private boolean gbh = true;
  private boolean gbi = true;
  private boolean gbj = true;
  private boolean gbk = true;
  private boolean gbl = true;
  private boolean gbm = true;
  private boolean gbn = true;
  private boolean gbo = true;
  private boolean gbp = true;
  
  static
  {
    fyf = "md5".hashCode();
    gbq = "userStoryFlag".hashCode();
    gbr = "newThumbUrl".hashCode();
    gbs = "newVideoUrl".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    gbt = "syncId".hashCode();
    gbu = "readId".hashCode();
    gbv = "storyPostTime".hashCode();
    gbw = "storyObjOneDay".hashCode();
    gbx = "readTime".hashCode();
    gby = "preloadStoryId".hashCode();
    gbz = "preloadMediaId".hashCode();
    gbA = "preLoadResource".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fyf == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (gbq == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (gbr == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (gbs == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (gbt == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (gbu == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (gbv == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (gbw == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (gbx == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (gby == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (gbz == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (gbA == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (fFe == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (gbB == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (gbC == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (gbD == k) {
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
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.gbc) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.gbd) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.gbe) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.gbf) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.gbg) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.gbh) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.gbi) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.gbj) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.gbk) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.gbl) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.gbm) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.fES) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.gbn) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.gbo) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.gbp) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gs
 * JD-Core Version:    0.7.0.1
 */