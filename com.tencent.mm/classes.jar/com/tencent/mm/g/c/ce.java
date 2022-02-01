package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ce
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfo(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfo(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfo(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfo(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfo(updateTime)" };
  private static final int eBv;
  private static final int eFK;
  private static final int eHj;
  private static final int eHk;
  private static final int eHl;
  private static final int eHm;
  private static final int eHn;
  private static final int eHo = "moovReady".hashCode();
  private static final int enR = "mediaId".hashCode();
  private static final int eol;
  private static final int erd = "url".hashCode();
  private static final int evF = "filePath".hashCode();
  private static final int fdu = "videoBitrate".hashCode();
  private static final int fdv = "audioBitrate".hashCode();
  private static final int fdy = "frameRate".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eFh = true;
  private boolean eHd = true;
  private boolean eHe = true;
  private boolean eHf = true;
  private boolean eHg = true;
  private boolean eHh = true;
  private boolean eHi = true;
  private boolean enA = true;
  private boolean eoi = true;
  private boolean eqZ = true;
  private boolean evx = true;
  private boolean fdg = true;
  private boolean fdh = true;
  private boolean fdk = true;
  public int field_audioBitrate;
  public long field_cacheSize;
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
  public int field_videoBitrate;
  
  static
  {
    eFK = "totalSize".hashCode();
    eHj = "cacheSize".hashCode();
    eBv = "state".hashCode();
    eHk = "hasPlayed".hashCode();
    eHl = "reqFormat".hashCode();
    eHm = "originMediaId".hashCode();
    eHn = "fileFormat".hashCode();
    eol = "updateTime".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.GvH.put("mediaId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mediaId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "mediaId";
    locala.columns[1] = "url";
    locala.GvH.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.GvH.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.GvH.put("totalSize", "LONG");
    localStringBuilder.append(" totalSize LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.GvH.put("cacheSize", "LONG");
    localStringBuilder.append(" cacheSize LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "state";
    locala.GvH.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "hasPlayed";
    locala.GvH.put("hasPlayed", "INTEGER");
    localStringBuilder.append(" hasPlayed INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "reqFormat";
    locala.GvH.put("reqFormat", "INTEGER default '-1' ");
    localStringBuilder.append(" reqFormat INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "originMediaId";
    locala.GvH.put("originMediaId", "TEXT");
    localStringBuilder.append(" originMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "fileFormat";
    locala.GvH.put("fileFormat", "TEXT");
    localStringBuilder.append(" fileFormat TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "moovReady";
    locala.GvH.put("moovReady", "INTEGER default 'false' ");
    localStringBuilder.append(" moovReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "videoBitrate";
    locala.GvH.put("videoBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" videoBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "audioBitrate";
    locala.GvH.put("audioBitrate", "INTEGER default '0' ");
    localStringBuilder.append(" audioBitrate INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "frameRate";
    locala.GvH.put("frameRate", "INTEGER default '0' ");
    localStringBuilder.append(" frameRate INTEGER default '0' ");
    locala.columns[15] = "rowid";
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
      if (enR != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.enA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erd == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eFK == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (eHj == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (eBv == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eHk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (eHl == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (eHm == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (eHn == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (eol == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (eHo == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (fdu == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (fdv == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (fdy == k) {
            this.field_frameRate = paramCursor.getInt(i);
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
    if (this.enA) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eFh) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eHd) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eHe) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.eHf) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.eHg) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.eHh) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eHi) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.fdg) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.fdh) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.fdk) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ce
 * JD-Core Version:    0.7.0.1
 */