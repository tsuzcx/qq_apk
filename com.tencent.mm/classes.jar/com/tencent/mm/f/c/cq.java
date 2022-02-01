package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfoV2(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfoV2(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfoV2(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfoV2(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfoV2(updateTime)" };
  public static final SingleTable TABLE = new SingleTable("FinderMediaCacheInfoV2");
  public static final Column hHa;
  private static final int hIC;
  public static final Column hNE;
  private static final int hOM;
  public static final Column hTD;
  public static final Column hTE;
  public static final Column hTF;
  public static final Column hTG;
  public static final Column hTH;
  public static final Column hTI;
  public static final Column hTJ;
  public static final Column hTK;
  public static final Column hTL;
  public static final Column hTM;
  public static final Column hTN;
  public static final Column hTO;
  private static final int hUb;
  private static final int hUc;
  private static final int hUd;
  private static final int hUe;
  private static final int hUf;
  private static final int hUg = "moovReady".hashCode();
  private static final int hUh = "videoBitrate".hashCode();
  private static final int hUi = "audioBitrate".hashCode();
  private static final int hUj = "frameRate".hashCode();
  private static final int hUk = "duration".hashCode();
  private static final int hUl = "urlToken".hashCode();
  private static final int hUm = "decodeKey".hashCode();
  public static final Column hnC;
  private static final int hok;
  public static final Column hsH;
  private static final int hsP;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
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
  private boolean hHO = true;
  private boolean hOi = true;
  private boolean hTP = true;
  private boolean hTQ = true;
  private boolean hTR = true;
  private boolean hTS = true;
  private boolean hTT = true;
  private boolean hTU = true;
  private boolean hTV = true;
  private boolean hTW = true;
  private boolean hTX = true;
  private boolean hTY = true;
  private boolean hTZ = true;
  private boolean hUa = true;
  private boolean hnT = true;
  private boolean hsL = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderMediaCacheInfoV2", "");
    hnC = new Column("mediaid", "string", "FinderMediaCacheInfoV2", "");
    hsH = new Column("url", "string", "FinderMediaCacheInfoV2", "");
    hNE = new Column("totalsize", "long", "FinderMediaCacheInfoV2", "");
    hTD = new Column("cachesize", "long", "FinderMediaCacheInfoV2", "");
    hHa = new Column("state", "int", "FinderMediaCacheInfoV2", "");
    hTE = new Column("hasplayed", "boolean", "FinderMediaCacheInfoV2", "");
    hTF = new Column("reqformat", "int", "FinderMediaCacheInfoV2", "");
    hTG = new Column("originmediaid", "string", "FinderMediaCacheInfoV2", "");
    hTH = new Column("fileformat", "string", "FinderMediaCacheInfoV2", "");
    C_UPDATETIME = new Column("updatetime", "long", "FinderMediaCacheInfoV2", "");
    hTI = new Column("moovready", "boolean", "FinderMediaCacheInfoV2", "");
    hTJ = new Column("videobitrate", "int", "FinderMediaCacheInfoV2", "");
    hTK = new Column("audiobitrate", "int", "FinderMediaCacheInfoV2", "");
    hTL = new Column("framerate", "int", "FinderMediaCacheInfoV2", "");
    hTM = new Column("duration", "int", "FinderMediaCacheInfoV2", "");
    hTN = new Column("urltoken", "string", "FinderMediaCacheInfoV2", "");
    hTO = new Column("decodekey", "string", "FinderMediaCacheInfoV2", "");
    hok = "mediaId".hashCode();
    hsP = "url".hashCode();
    hOM = "totalSize".hashCode();
    hUb = "cacheSize".hashCode();
    hIC = "state".hashCode();
    hUc = "hasPlayed".hashCode();
    hUd = "reqFormat".hashCode();
    hUe = "originMediaId".hashCode();
    hUf = "fileFormat".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
      if (hok != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.hnT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsP == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (hOM == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (hUb == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (hIC == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (hUc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (hUd == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (hUe == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (hUf == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (updateTime_HASHCODE == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (hUg == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (hUh == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (hUi == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (hUj == k) {
            this.field_frameRate = paramCursor.getInt(i);
          } else if (hUk == k) {
            this.field_duration = paramCursor.getInt(i);
          } else if (hUl == k) {
            this.field_urlToken = paramCursor.getString(i);
          } else if (hUm == k) {
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
    if (this.hnT) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hOi) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.hTP) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.hTQ) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.hTR) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.hTS) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.hTT) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hTU) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.hTV) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.hTW) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.hTX) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.hTY) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.field_urlToken == null) {
      this.field_urlToken = "";
    }
    if (this.hTZ) {
      localContentValues.put("urlToken", this.field_urlToken);
    }
    if (this.field_decodeKey == null) {
      this.field_decodeKey = "";
    }
    if (this.hUa) {
      localContentValues.put("decodeKey", this.field_decodeKey);
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
    return "FinderMediaCacheInfoV2";
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cq
 * JD-Core Version:    0.7.0.1
 */