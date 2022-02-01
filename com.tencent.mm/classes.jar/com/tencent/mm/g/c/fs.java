package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGS = "duration".hashCode();
  private static final int eYY;
  private static final int eYZ;
  private static final int eZa;
  private static final int eZb;
  private static final int eZc;
  private static final int eZd;
  private static final int eZe;
  private static final int eZf;
  private static final int eZg;
  private static final int eZh;
  private static final int eZi;
  private static final int eZj = "userInfo".hashCode();
  private static final int eZk = "favoriteMd5".hashCode();
  private static final int eZl = "interactTime".hashCode();
  private static final int ekS = "userName".hashCode();
  private static final int emf;
  private static final int eyX = "md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGJ = true;
  private boolean eYK = true;
  private boolean eYL = true;
  private boolean eYM = true;
  private boolean eYN = true;
  private boolean eYO = true;
  private boolean eYP = true;
  private boolean eYQ = true;
  private boolean eYR = true;
  private boolean eYS = true;
  private boolean eYT = true;
  private boolean eYU = true;
  private boolean eYV = true;
  private boolean eYW = true;
  private boolean eYX = true;
  private boolean ekv = true;
  private boolean emc = true;
  private boolean eyl = true;
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
  
  static
  {
    eYY = "userStoryFlag".hashCode();
    eYZ = "newThumbUrl".hashCode();
    eZa = "newVideoUrl".hashCode();
    emf = "updateTime".hashCode();
    eZb = "syncId".hashCode();
    eZc = "readId".hashCode();
    eZd = "storyPostTime".hashCode();
    eZe = "storyObjOneDay".hashCode();
    eZf = "readTime".hashCode();
    eZg = "preloadStoryId".hashCode();
    eZh = "preloadMediaId".hashCode();
    eZi = "preLoadResource".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.EYv.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "userName";
    locala.columns[1] = "md5";
    locala.EYv.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userStoryFlag";
    locala.EYv.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newThumbUrl";
    locala.EYv.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "newVideoUrl";
    locala.EYv.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "syncId";
    locala.EYv.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "readId";
    locala.EYv.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "storyPostTime";
    locala.EYv.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "storyObjOneDay";
    locala.EYv.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "readTime";
    locala.EYv.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "preloadStoryId";
    locala.EYv.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "preloadMediaId";
    locala.EYv.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "preLoadResource";
    locala.EYv.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.EYv.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "userInfo";
    locala.EYv.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "favoriteMd5";
    locala.EYv.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "interactTime";
    locala.EYv.put("interactTime", "LONG");
    localStringBuilder.append(" interactTime LONG");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (ekS != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.ekv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eyX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eYY == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (eYZ == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (eZa == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eZb == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (eZc == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (eZd == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (eZe == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (eZf == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (eZg == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (eZh == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (eZi == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (eGS == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (eZj == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (eZk == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (eZl == k) {
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
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eYK) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.eYL) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.eYM) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eYN) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.eYO) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.eYP) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.eYQ) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.eYR) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.eYS) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.eYT) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.eYU) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.eGJ) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.eYV) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.eYW) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.eYX) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fs
 * JD-Core Version:    0.7.0.1
 */