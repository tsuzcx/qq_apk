package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfo(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfo(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfo(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfo(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfo(updateTime)" };
  private static final int eDq;
  private static final int eEG;
  private static final int eEH;
  private static final int eEI;
  private static final int elM = "mediaId".hashCode();
  private static final int emf = "updateTime".hashCode();
  private static final int eoZ = "url".hashCode();
  private static final int etB = "filePath".hashCode();
  private static final int ezb;
  private static final int qnD;
  private static final int qnO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCN = true;
  private boolean eED = true;
  private boolean eEE = true;
  private boolean eEF = true;
  private boolean elv = true;
  private boolean emc = true;
  private boolean eoV = true;
  private boolean ett = true;
  private boolean eyp = true;
  public long field_cacheSize;
  public String field_fileFormat;
  public String field_filePath;
  public boolean field_hasPlayed;
  public String field_mediaId;
  public String field_originMediaId;
  public int field_reqFormat;
  public int field_state;
  public long field_totalSize;
  public long field_updateTime;
  public String field_url;
  private boolean qnB = true;
  private boolean qnC = true;
  
  static
  {
    eDq = "totalSize".hashCode();
    eEG = "cacheSize".hashCode();
    ezb = "state".hashCode();
    eEH = "hasPlayed".hashCode();
    eEI = "reqFormat".hashCode();
    qnD = "originMediaId".hashCode();
    qnO = "fileFormat".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.EYv.put("mediaId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mediaId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "mediaId";
    locala.columns[1] = "url";
    locala.EYv.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.EYv.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.EYv.put("totalSize", "LONG");
    localStringBuilder.append(" totalSize LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.EYv.put("cacheSize", "LONG");
    localStringBuilder.append(" cacheSize LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "state";
    locala.EYv.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "hasPlayed";
    locala.EYv.put("hasPlayed", "INTEGER");
    localStringBuilder.append(" hasPlayed INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "reqFormat";
    locala.EYv.put("reqFormat", "INTEGER default '-1' ");
    localStringBuilder.append(" reqFormat INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "originMediaId";
    locala.EYv.put("originMediaId", "TEXT");
    localStringBuilder.append(" originMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "fileFormat";
    locala.EYv.put("fileFormat", "TEXT");
    localStringBuilder.append(" fileFormat TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[11] = "rowid";
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
      if (elM != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.elv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoZ == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eDq == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (eEG == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (ezb == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        if (eEH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (eEI == k) {
          this.field_reqFormat = paramCursor.getInt(i);
        } else if (qnD == k) {
          this.field_originMediaId = paramCursor.getString(i);
        } else if (qnO == k) {
          this.field_fileFormat = paramCursor.getString(i);
        } else if (emf == k) {
          this.field_updateTime = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elv) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eCN) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eED) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eEE) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.eEF) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.qnB) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.qnC) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */