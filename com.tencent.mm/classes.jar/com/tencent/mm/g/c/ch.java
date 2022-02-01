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
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfoV2(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfoV2(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfoV2(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfoV2(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfoV2(updateTime)" };
  private static final int eGG = "mediaId".hashCode();
  private static final int eGZ = "updateTime".hashCode();
  private static final int eJV = "url".hashCode();
  private static final int eUE;
  private static final int eYT = "totalSize".hashCode();
  private static final int faQ = "cacheSize".hashCode();
  private static final int faR;
  private static final int faS;
  private static final int faT;
  private static final int faU;
  private static final int faV = "moovReady".hashCode();
  private static final int faW = "videoBitrate".hashCode();
  private static final int faX = "audioBitrate".hashCode();
  private static final int faY = "frameRate".hashCode();
  private static final int faZ = "duration".hashCode();
  private static final int fba = "urlToken".hashCode();
  private static final int fbb = "decodeKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eGp = true;
  private boolean eJR = true;
  private boolean eTS = true;
  private boolean eYq = true;
  private boolean faE = true;
  private boolean faF = true;
  private boolean faG = true;
  private boolean faH = true;
  private boolean faI = true;
  private boolean faJ = true;
  private boolean faK = true;
  private boolean faL = true;
  private boolean faM = true;
  private boolean faN = true;
  private boolean faO = true;
  private boolean faP = true;
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
  
  static
  {
    eUE = "state".hashCode();
    faR = "hasPlayed".hashCode();
    faS = "reqFormat".hashCode();
    faT = "originMediaId".hashCode();
    faU = "fileFormat".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.IBN.put("mediaId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mediaId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "mediaId";
    locala.columns[1] = "url";
    locala.IBN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "totalSize";
    locala.IBN.put("totalSize", "LONG");
    localStringBuilder.append(" totalSize LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "cacheSize";
    locala.IBN.put("cacheSize", "LONG");
    localStringBuilder.append(" cacheSize LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "state";
    locala.IBN.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "hasPlayed";
    locala.IBN.put("hasPlayed", "INTEGER");
    localStringBuilder.append(" hasPlayed INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reqFormat";
    locala.IBN.put("reqFormat", "INTEGER default '-1' ");
    localStringBuilder.append(" reqFormat INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "originMediaId";
    locala.IBN.put("originMediaId", "TEXT");
    localStringBuilder.append(" originMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "fileFormat";
    locala.IBN.put("fileFormat", "TEXT");
    localStringBuilder.append(" fileFormat TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "moovReady";
    locala.IBN.put("moovReady", "INTEGER default 'false' ");
    localStringBuilder.append(" moovReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "videoBitrate";
    locala.IBN.put("videoBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" videoBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "audioBitrate";
    locala.IBN.put("audioBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" audioBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "frameRate";
    locala.IBN.put("frameRate", "INTEGER default '0' ");
    localStringBuilder.append(" frameRate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "duration";
    locala.IBN.put("duration", "INTEGER default '0' ");
    localStringBuilder.append(" duration INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "urlToken";
    locala.IBN.put("urlToken", "TEXT default '' ");
    localStringBuilder.append(" urlToken TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "decodeKey";
    locala.IBN.put("decodeKey", "TEXT default '' ");
    localStringBuilder.append(" decodeKey TEXT default '' ");
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eGG != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.eGp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJV == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eYT == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (faQ == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (eUE == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (faR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (faS == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (faT == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (faU == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (eGZ == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (faV == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (faW == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (faX == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (faY == k) {
            this.field_frameRate = paramCursor.getInt(i);
          } else if (faZ == k) {
            this.field_duration = paramCursor.getInt(i);
          } else if (fba == k) {
            this.field_urlToken = paramCursor.getString(i);
          } else if (fbb == k) {
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
    if (this.eGp) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eYq) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.faE) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.faF) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.faG) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.faH) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.faI) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.faJ) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.faK) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.faL) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.faM) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.faN) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.field_urlToken == null) {
      this.field_urlToken = "";
    }
    if (this.faO) {
      localContentValues.put("urlToken", this.field_urlToken);
    }
    if (this.field_decodeKey == null) {
      this.field_decodeKey = "";
    }
    if (this.faP) {
      localContentValues.put("decodeKey", this.field_decodeKey);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ch
 * JD-Core Version:    0.7.0.1
 */