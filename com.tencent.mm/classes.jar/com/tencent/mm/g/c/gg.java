package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEd = "userName".hashCode();
  private static final int eFq;
  private static final int eSP = "md5".hashCode();
  private static final int eZm = "duration".hashCode();
  private static final int fuA;
  private static final int fuB;
  private static final int fuC;
  private static final int fuD;
  private static final int fuE;
  private static final int fuF;
  private static final int fuG;
  private static final int fuH;
  private static final int fuI;
  private static final int fuJ = "userInfo".hashCode();
  private static final int fuK = "favoriteMd5".hashCode();
  private static final int fuL = "interactTime".hashCode();
  private static final int fuy = "userStoryFlag".hashCode();
  private static final int fuz = "newThumbUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDG = true;
  private boolean eFn = true;
  private boolean eSd = true;
  private boolean eZa = true;
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
  private boolean fuk = true;
  private boolean ful = true;
  private boolean fum = true;
  private boolean fun = true;
  private boolean fuo = true;
  private boolean fup = true;
  private boolean fuq = true;
  private boolean fur = true;
  private boolean fus = true;
  private boolean fut = true;
  private boolean fuu = true;
  private boolean fuv = true;
  private boolean fuw = true;
  private boolean fux = true;
  
  static
  {
    fuA = "newVideoUrl".hashCode();
    eFq = "updateTime".hashCode();
    fuB = "syncId".hashCode();
    fuC = "readId".hashCode();
    fuD = "storyPostTime".hashCode();
    fuE = "storyObjOneDay".hashCode();
    fuF = "readTime".hashCode();
    fuG = "preloadStoryId".hashCode();
    fuH = "preloadMediaId".hashCode();
    fuI = "preLoadResource".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.IhC.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "userName";
    locala.columns[1] = "md5";
    locala.IhC.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userStoryFlag";
    locala.IhC.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newThumbUrl";
    locala.IhC.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "newVideoUrl";
    locala.IhC.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "syncId";
    locala.IhC.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "readId";
    locala.IhC.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "storyPostTime";
    locala.IhC.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "storyObjOneDay";
    locala.IhC.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "readTime";
    locala.IhC.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "preloadStoryId";
    locala.IhC.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "preloadMediaId";
    locala.IhC.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "preLoadResource";
    locala.IhC.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.IhC.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "userInfo";
    locala.IhC.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "favoriteMd5";
    locala.IhC.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "interactTime";
    locala.IhC.put("interactTime", "LONG");
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
      if (eEd != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eDG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSP == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fuy == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (fuz == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (fuA == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fuB == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (fuC == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (fuD == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (fuE == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (fuF == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (fuG == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (fuH == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (fuI == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (eZm == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (fuJ == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (fuK == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (fuL == k) {
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
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fuk) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.ful) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.fum) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fun) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.fuo) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.fup) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.fuq) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.fur) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.fus) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.fut) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.fuu) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.eZa) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.fuv) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.fuw) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.fux) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gg
 * JD-Core Version:    0.7.0.1
 */