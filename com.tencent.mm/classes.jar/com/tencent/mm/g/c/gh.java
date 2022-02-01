package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFM = "userName".hashCode();
  private static final int eGZ;
  private static final int eUA = "md5".hashCode();
  private static final int faZ = "duration".hashCode();
  private static final int fwA;
  private static final int fwB;
  private static final int fwC;
  private static final int fwD;
  private static final int fwE;
  private static final int fwF;
  private static final int fwG;
  private static final int fwH;
  private static final int fwI;
  private static final int fwJ = "userInfo".hashCode();
  private static final int fwK = "favoriteMd5".hashCode();
  private static final int fwL = "interactTime".hashCode();
  private static final int fwy = "userStoryFlag".hashCode();
  private static final int fwz = "newThumbUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFp = true;
  private boolean eGW = true;
  private boolean eTO = true;
  private boolean faN = true;
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
  private boolean fwk = true;
  private boolean fwl = true;
  private boolean fwm = true;
  private boolean fwn = true;
  private boolean fwo = true;
  private boolean fwp = true;
  private boolean fwq = true;
  private boolean fwr = true;
  private boolean fws = true;
  private boolean fwt = true;
  private boolean fwu = true;
  private boolean fwv = true;
  private boolean fww = true;
  private boolean fwx = true;
  
  static
  {
    fwA = "newVideoUrl".hashCode();
    eGZ = "updateTime".hashCode();
    fwB = "syncId".hashCode();
    fwC = "readId".hashCode();
    fwD = "storyPostTime".hashCode();
    fwE = "storyObjOneDay".hashCode();
    fwF = "readTime".hashCode();
    fwG = "preloadStoryId".hashCode();
    fwH = "preloadMediaId".hashCode();
    fwI = "preLoadResource".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.IBN.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "userName";
    locala.columns[1] = "md5";
    locala.IBN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userStoryFlag";
    locala.IBN.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newThumbUrl";
    locala.IBN.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "newVideoUrl";
    locala.IBN.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "syncId";
    locala.IBN.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "readId";
    locala.IBN.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "storyPostTime";
    locala.IBN.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "storyObjOneDay";
    locala.IBN.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "readTime";
    locala.IBN.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "preloadStoryId";
    locala.IBN.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "preloadMediaId";
    locala.IBN.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "preLoadResource";
    locala.IBN.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.IBN.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "userInfo";
    locala.IBN.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "favoriteMd5";
    locala.IBN.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "interactTime";
    locala.IBN.put("interactTime", "LONG");
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
      if (eFM != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eFp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUA == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fwy == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (fwz == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (fwA == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fwB == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (fwC == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (fwD == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (fwE == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (fwF == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (fwG == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (fwH == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (fwI == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (faZ == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (fwJ == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (fwK == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (fwL == k) {
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
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fwk) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.fwl) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.fwm) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fwn) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.fwo) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.fwp) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.fwq) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.fwr) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.fws) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.fwt) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.fwu) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.faN) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.fwv) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.fww) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.fwx) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gh
 * JD-Core Version:    0.7.0.1
 */