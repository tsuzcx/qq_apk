package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ew
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAk = "duration".hashCode();
  private static final int dQg;
  private static final int dQh;
  private static final int dQi;
  private static final int dQj;
  private static final int dQk;
  private static final int dQl;
  private static final int dQm;
  private static final int dQn;
  private static final int dQo;
  private static final int dQp;
  private static final int dQq;
  private static final int dQr = "userInfo".hashCode();
  private static final int dQs = "favoriteMd5".hashCode();
  private static final int dgK = "userName".hashCode();
  private static final int dhV;
  private static final int dtX = "md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAc = true;
  private boolean dPT = true;
  private boolean dPU = true;
  private boolean dPV = true;
  private boolean dPW = true;
  private boolean dPX = true;
  private boolean dPY = true;
  private boolean dPZ = true;
  private boolean dQa = true;
  private boolean dQb = true;
  private boolean dQc = true;
  private boolean dQd = true;
  private boolean dQe = true;
  private boolean dQf = true;
  private boolean dgn = true;
  private boolean dhT = true;
  private boolean dtk = true;
  public long field_duration;
  public String field_favoriteMd5;
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
    dQg = "userStoryFlag".hashCode();
    dQh = "newThumbUrl".hashCode();
    dQi = "newVideoUrl".hashCode();
    dhV = "updateTime".hashCode();
    dQj = "syncId".hashCode();
    dQk = "readId".hashCode();
    dQl = "storyPostTime".hashCode();
    dQm = "storyObjOneDay".hashCode();
    dQn = "readTime".hashCode();
    dQo = "preloadStoryId".hashCode();
    dQp = "preloadMediaId".hashCode();
    dQq = "preLoadResource".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.yrM.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "userName";
    locala.columns[1] = "md5";
    locala.yrM.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userStoryFlag";
    locala.yrM.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newThumbUrl";
    locala.yrM.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "newVideoUrl";
    locala.yrM.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "syncId";
    locala.yrM.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "readId";
    locala.yrM.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "storyPostTime";
    locala.yrM.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "storyObjOneDay";
    locala.yrM.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "readTime";
    locala.yrM.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "preloadStoryId";
    locala.yrM.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "preloadMediaId";
    locala.yrM.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "preLoadResource";
    locala.yrM.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.yrM.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "userInfo";
    locala.yrM.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "favoriteMd5";
    locala.yrM.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    locala.columns[17] = "rowid";
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
      if (dgK != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.dgn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dtX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (dQg == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (dQh == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (dQi == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dQj == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (dQk == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (dQl == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (dQm == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (dQn == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (dQo == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (dQp == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (dQq == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (dAk == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (dQr == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (dQs == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
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
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dPT) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.dPU) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.dPV) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dPW) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.dPX) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.dPY) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.dPZ) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.dQa) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.dQb) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.dQc) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.dQd) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.dAc) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.dQe) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.dQf) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ew
 * JD-Core Version:    0.7.0.1
 */