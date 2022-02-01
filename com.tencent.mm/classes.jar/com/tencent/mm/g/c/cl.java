package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cl
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfoV2(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfoV2(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfoV2(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfoV2(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfoV2(updateTime)" };
  private static final int fCx;
  private static final int fEV;
  private static final int fEW;
  private static final int fEX;
  private static final int fEY;
  private static final int fEZ;
  private static final int fFa = "moovReady".hashCode();
  private static final int fFb = "videoBitrate".hashCode();
  private static final int fFc = "audioBitrate".hashCode();
  private static final int fFd = "frameRate".hashCode();
  private static final int fFe = "duration".hashCode();
  private static final int fFf = "urlToken".hashCode();
  private static final int fFg = "decodeKey".hashCode();
  private static final int fkm = "mediaId".hashCode();
  private static final int fnB = "url".hashCode();
  private static final int fyj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fBT = true;
  private boolean fEJ = true;
  private boolean fEK = true;
  private boolean fEL = true;
  private boolean fEM = true;
  private boolean fEN = true;
  private boolean fEO = true;
  private boolean fEP = true;
  private boolean fEQ = true;
  private boolean fER = true;
  private boolean fES = true;
  private boolean fET = true;
  private boolean fEU = true;
  public int field_audioBitrate;
  public long field_cacheSize;
  public String field_decodeKey;
  public int field_duration;
  public String field_fileFormat;
  public int field_frameRate;
  public boolean field_hasPlayed;
  public String field_mediaId;
  public boolean field_moovReady;
  public String field_originMediaId;
  public int field_reqFormat;
  public int field_state;
  public long field_totalSize;
  public long field_updateTime;
  public String field_url;
  public String field_urlToken;
  public int field_videoBitrate;
  private boolean fjV = true;
  private boolean fnx = true;
  private boolean fxx = true;
  
  static
  {
    fCx = "totalSize".hashCode();
    fEV = "cacheSize".hashCode();
    fyj = "state".hashCode();
    fEW = "hasPlayed".hashCode();
    fEX = "reqFormat".hashCode();
    fEY = "originMediaId".hashCode();
    fEZ = "fileFormat".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mediaId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "mediaId";
    localMAutoDBInfo.columns[1] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "totalSize";
    localMAutoDBInfo.colsMap.put("totalSize", "LONG");
    localStringBuilder.append(" totalSize LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "cacheSize";
    localMAutoDBInfo.colsMap.put("cacheSize", "LONG");
    localStringBuilder.append(" cacheSize LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hasPlayed";
    localMAutoDBInfo.colsMap.put("hasPlayed", "INTEGER");
    localStringBuilder.append(" hasPlayed INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reqFormat";
    localMAutoDBInfo.colsMap.put("reqFormat", "INTEGER default '-1' ");
    localStringBuilder.append(" reqFormat INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "originMediaId";
    localMAutoDBInfo.colsMap.put("originMediaId", "TEXT");
    localStringBuilder.append(" originMediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "fileFormat";
    localMAutoDBInfo.colsMap.put("fileFormat", "TEXT");
    localStringBuilder.append(" fileFormat TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "moovReady";
    localMAutoDBInfo.colsMap.put("moovReady", "INTEGER default 'false' ");
    localStringBuilder.append(" moovReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "videoBitrate";
    localMAutoDBInfo.colsMap.put("videoBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" videoBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "audioBitrate";
    localMAutoDBInfo.colsMap.put("audioBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" audioBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "frameRate";
    localMAutoDBInfo.colsMap.put("frameRate", "INTEGER default '0' ");
    localStringBuilder.append(" frameRate INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "duration";
    localMAutoDBInfo.colsMap.put("duration", "INTEGER default '0' ");
    localStringBuilder.append(" duration INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "urlToken";
    localMAutoDBInfo.colsMap.put("urlToken", "TEXT default '' ");
    localStringBuilder.append(" urlToken TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "decodeKey";
    localMAutoDBInfo.colsMap.put("decodeKey", "TEXT default '' ");
    localStringBuilder.append(" decodeKey TEXT default '' ");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (fkm != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.fjV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnB == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (fCx == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (fEV == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (fyj == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fEW == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (fEX == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (fEY == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (fEZ == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (updateTime_HASHCODE == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (fFa == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (fFb == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (fFc == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (fFd == k) {
            this.field_frameRate = paramCursor.getInt(i);
          } else if (fFe == k) {
            this.field_duration = paramCursor.getInt(i);
          } else if (fFf == k) {
            this.field_urlToken = paramCursor.getString(i);
          } else if (fFg == k) {
            this.field_decodeKey = paramCursor.getString(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjV) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fBT) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.fEJ) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fEK) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.fEL) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.fEM) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.fEN) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fEO) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.fEP) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.fEQ) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.fER) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.fES) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.field_urlToken == null) {
      this.field_urlToken = "";
    }
    if (this.fET) {
      localContentValues.put("urlToken", this.field_urlToken);
    }
    if (this.field_decodeKey == null) {
      this.field_decodeKey = "";
    }
    if (this.fEU) {
      localContentValues.put("decodeKey", this.field_decodeKey);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */