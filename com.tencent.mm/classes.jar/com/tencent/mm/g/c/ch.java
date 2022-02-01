package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ch
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfo(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfo(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfo(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfo(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfo(updateTime)" };
  private static final int eEX = "mediaId".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eIm = "url".hashCode();
  private static final int eNc = "filePath".hashCode();
  private static final int eST;
  private static final int eXi = "totalSize".hashCode();
  private static final int eZd = "cacheSize".hashCode();
  private static final int eZe;
  private static final int eZf;
  private static final int eZg;
  private static final int eZh;
  private static final int eZi = "moovReady".hashCode();
  private static final int eZj = "videoBitrate".hashCode();
  private static final int eZk = "audioBitrate".hashCode();
  private static final int eZl = "frameRate".hashCode();
  private static final int eZm = "duration".hashCode();
  private static final int eZn = "urlToken".hashCode();
  private static final int eZo = "decodeKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEG = true;
  private boolean eFn = true;
  private boolean eIi = true;
  private boolean eMU = true;
  private boolean eSh = true;
  private boolean eWF = true;
  private boolean eYR = true;
  private boolean eYS = true;
  private boolean eYT = true;
  private boolean eYU = true;
  private boolean eYV = true;
  private boolean eYW = true;
  private boolean eYX = true;
  private boolean eYY = true;
  private boolean eYZ = true;
  private boolean eZa = true;
  private boolean eZb = true;
  private boolean eZc = true;
  public int field_audioBitrate;
  public long field_cacheSize;
  public String field_decodeKey;
  public int field_duration;
  public String field_fileFormat;
  public String field_filePath;
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
  
  static
  {
    eST = "state".hashCode();
    eZe = "hasPlayed".hashCode();
    eZf = "reqFormat".hashCode();
    eZg = "originMediaId".hashCode();
    eZh = "fileFormat".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.IhC.put("mediaId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mediaId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "mediaId";
    locala.columns[1] = "url";
    locala.IhC.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.IhC.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.IhC.put("totalSize", "LONG");
    localStringBuilder.append(" totalSize LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.IhC.put("cacheSize", "LONG");
    localStringBuilder.append(" cacheSize LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "state";
    locala.IhC.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "hasPlayed";
    locala.IhC.put("hasPlayed", "INTEGER");
    localStringBuilder.append(" hasPlayed INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "reqFormat";
    locala.IhC.put("reqFormat", "INTEGER default '-1' ");
    localStringBuilder.append(" reqFormat INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "originMediaId";
    locala.IhC.put("originMediaId", "TEXT");
    localStringBuilder.append(" originMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "fileFormat";
    locala.IhC.put("fileFormat", "TEXT");
    localStringBuilder.append(" fileFormat TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "moovReady";
    locala.IhC.put("moovReady", "INTEGER default 'false' ");
    localStringBuilder.append(" moovReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "videoBitrate";
    locala.IhC.put("videoBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" videoBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "audioBitrate";
    locala.IhC.put("audioBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" audioBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "frameRate";
    locala.IhC.put("frameRate", "INTEGER default '0' ");
    localStringBuilder.append(" frameRate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "duration";
    locala.IhC.put("duration", "INTEGER default '0' ");
    localStringBuilder.append(" duration INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "urlToken";
    locala.IhC.put("urlToken", "TEXT default '' ");
    localStringBuilder.append(" urlToken TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "decodeKey";
    locala.IhC.put("decodeKey", "TEXT default '' ");
    localStringBuilder.append(" decodeKey TEXT default '' ");
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eEX != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.eEG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIm == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eXi == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (eZd == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (eST == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eZe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (eZf == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (eZg == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (eZh == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (eFq == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (eZi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (eZj == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (eZk == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (eZl == k) {
            this.field_frameRate = paramCursor.getInt(i);
          } else if (eZm == k) {
            this.field_duration = paramCursor.getInt(i);
          } else if (eZn == k) {
            this.field_urlToken = paramCursor.getString(i);
          } else if (eZo == k) {
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
    if (this.eEG) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eWF) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eYR) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eYS) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.eYT) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.eYU) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.eYV) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eYW) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.eYX) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.eYY) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.eYZ) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.eZa) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.field_urlToken == null) {
      this.field_urlToken = "";
    }
    if (this.eZb) {
      localContentValues.put("urlToken", this.field_urlToken);
    }
    if (this.field_decodeKey == null) {
      this.field_decodeKey = "";
    }
    if (this.eZc) {
      localContentValues.put("decodeKey", this.field_decodeKey);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ch
 * JD-Core Version:    0.7.0.1
 */