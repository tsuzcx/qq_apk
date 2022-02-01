package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int eJK = "duration".hashCode();
  private static final int emW = "userName".hashCode();
  private static final int eol;
  private static final int fck;
  private static final int fcl;
  private static final int fcm;
  private static final int fcn;
  private static final int fco;
  private static final int fcp;
  private static final int fcq;
  private static final int fcr;
  private static final int fcs;
  private static final int fct;
  private static final int fcu;
  private static final int fcv = "userInfo".hashCode();
  private static final int fcw = "favoriteMd5".hashCode();
  private static final int fcx = "interactTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eJB = true;
  private boolean emz = true;
  private boolean eoi = true;
  private boolean fbW = true;
  private boolean fbX = true;
  private boolean fbY = true;
  private boolean fbZ = true;
  private boolean fca = true;
  private boolean fcb = true;
  private boolean fcc = true;
  private boolean fcd = true;
  private boolean fce = true;
  private boolean fcf = true;
  private boolean fcg = true;
  private boolean fch = true;
  private boolean fci = true;
  private boolean fcj = true;
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
    eBr = "md5".hashCode();
    fck = "userStoryFlag".hashCode();
    fcl = "newThumbUrl".hashCode();
    fcm = "newVideoUrl".hashCode();
    eol = "updateTime".hashCode();
    fcn = "syncId".hashCode();
    fco = "readId".hashCode();
    fcp = "storyPostTime".hashCode();
    fcq = "storyObjOneDay".hashCode();
    fcr = "readTime".hashCode();
    fcs = "preloadStoryId".hashCode();
    fct = "preloadMediaId".hashCode();
    fcu = "preLoadResource".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.GvH.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "userName";
    locala.columns[1] = "md5";
    locala.GvH.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userStoryFlag";
    locala.GvH.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newThumbUrl";
    locala.GvH.put("newThumbUrl", "TEXT");
    localStringBuilder.append(" newThumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "newVideoUrl";
    locala.GvH.put("newVideoUrl", "TEXT");
    localStringBuilder.append(" newVideoUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "syncId";
    locala.GvH.put("syncId", "LONG");
    localStringBuilder.append(" syncId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "readId";
    locala.GvH.put("readId", "LONG");
    localStringBuilder.append(" readId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "storyPostTime";
    locala.GvH.put("storyPostTime", "INTEGER");
    localStringBuilder.append(" storyPostTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "storyObjOneDay";
    locala.GvH.put("storyObjOneDay", "INTEGER");
    localStringBuilder.append(" storyObjOneDay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "readTime";
    locala.GvH.put("readTime", "LONG");
    localStringBuilder.append(" readTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "preloadStoryId";
    locala.GvH.put("preloadStoryId", "LONG");
    localStringBuilder.append(" preloadStoryId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "preloadMediaId";
    locala.GvH.put("preloadMediaId", "TEXT");
    localStringBuilder.append(" preloadMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "preLoadResource";
    locala.GvH.put("preLoadResource", "LONG");
    localStringBuilder.append(" preLoadResource LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.GvH.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "userInfo";
    locala.GvH.put("userInfo", "BLOB");
    localStringBuilder.append(" userInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "favoriteMd5";
    locala.GvH.put("favoriteMd5", "TEXT");
    localStringBuilder.append(" favoriteMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "interactTime";
    locala.GvH.put("interactTime", "LONG");
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
      if (emW != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.emz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBr == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fck == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (fcl == k) {
        this.field_newThumbUrl = paramCursor.getString(i);
      } else if (fcm == k) {
        this.field_newVideoUrl = paramCursor.getString(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fcn == k) {
        this.field_syncId = paramCursor.getLong(i);
      } else if (fco == k) {
        this.field_readId = paramCursor.getLong(i);
      } else if (fcp == k) {
        this.field_storyPostTime = paramCursor.getInt(i);
      } else if (fcq == k) {
        this.field_storyObjOneDay = paramCursor.getInt(i);
      } else if (fcr == k) {
        this.field_readTime = paramCursor.getLong(i);
      } else if (fcs == k) {
        this.field_preloadStoryId = paramCursor.getLong(i);
      } else if (fct == k) {
        this.field_preloadMediaId = paramCursor.getString(i);
      } else if (fcu == k) {
        this.field_preLoadResource = paramCursor.getLong(i);
      } else if (eJK == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (fcv == k) {
        this.field_userInfo = paramCursor.getBlob(i);
      } else if (fcw == k) {
        this.field_favoriteMd5 = paramCursor.getString(i);
      } else if (fcx == k) {
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
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fbW) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.fbX) {
      localContentValues.put("newThumbUrl", this.field_newThumbUrl);
    }
    if (this.fbY) {
      localContentValues.put("newVideoUrl", this.field_newVideoUrl);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fbZ) {
      localContentValues.put("syncId", Long.valueOf(this.field_syncId));
    }
    if (this.fca) {
      localContentValues.put("readId", Long.valueOf(this.field_readId));
    }
    if (this.fcb) {
      localContentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
    }
    if (this.fcc) {
      localContentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
    }
    if (this.fcd) {
      localContentValues.put("readTime", Long.valueOf(this.field_readTime));
    }
    if (this.fce) {
      localContentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
    }
    if (this.fcf) {
      localContentValues.put("preloadMediaId", this.field_preloadMediaId);
    }
    if (this.fcg) {
      localContentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
    }
    if (this.eJB) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.fch) {
      localContentValues.put("userInfo", this.field_userInfo);
    }
    if (this.fci) {
      localContentValues.put("favoriteMd5", this.field_favoriteMd5);
    }
    if (this.fcj) {
      localContentValues.put("interactTime", Long.valueOf(this.field_interactTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fw
 * JD-Core Version:    0.7.0.1
 */