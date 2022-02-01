package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderMediaCacheInfoV2");
  public static final Column UPDATETIME;
  public static final Column jKs;
  private static final int jLa;
  private static final int jPC;
  public static final Column jPu;
  public static final Column kee;
  private static final int kfH;
  public static final Column kkI;
  private static final int klQ;
  private static final int ktA;
  private static final int ktB;
  private static final int ktC;
  private static final int ktD;
  private static final int ktE;
  private static final int ktF;
  private static final int ktG;
  private static final int ktH;
  private static final int ktI;
  private static final int ktJ;
  private static final int ktK;
  private static final int ktL;
  public static final Column ktc;
  public static final Column ktd;
  public static final Column kte;
  public static final Column ktf;
  public static final Column ktg;
  public static final Column kth;
  public static final Column kti;
  public static final Column ktj;
  public static final Column ktk;
  public static final Column ktl;
  public static final Column ktm;
  public static final Column ktn;
  private static final StorageObserverOwner<cy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jKJ = true;
  private boolean jPy = true;
  private boolean keT = true;
  private boolean klm = true;
  private boolean kto = true;
  private boolean ktp = true;
  private boolean ktq = true;
  private boolean ktr = true;
  private boolean kts = true;
  private boolean ktt = true;
  private boolean ktu = true;
  private boolean ktv = true;
  private boolean ktw = true;
  private boolean ktx = true;
  private boolean kty = true;
  private boolean ktz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKs = new Column("mediaId", "string", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    kkI = new Column("totalSize", "long", TABLE.getName(), "");
    ktc = new Column("cacheSize", "long", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    ktd = new Column("hasPlayed", "boolean", TABLE.getName(), "");
    kte = new Column("reqFormat", "int", TABLE.getName(), "");
    ktf = new Column("originMediaId", "string", TABLE.getName(), "");
    ktg = new Column("fileFormat", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kth = new Column("moovReady", "boolean", TABLE.getName(), "");
    kti = new Column("videoBitrate", "int", TABLE.getName(), "");
    ktj = new Column("audioBitrate", "int", TABLE.getName(), "");
    ktk = new Column("frameRate", "int", TABLE.getName(), "");
    ktl = new Column("duration", "int", TABLE.getName(), "");
    ktm = new Column("urlToken", "string", TABLE.getName(), "");
    ktn = new Column("decodeKey", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfoV2(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfoV2(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfoV2(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfoV2(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfoV2(updateTime)" };
    jLa = "mediaId".hashCode();
    jPC = "url".hashCode();
    klQ = "totalSize".hashCode();
    ktA = "cacheSize".hashCode();
    kfH = "state".hashCode();
    ktB = "hasPlayed".hashCode();
    ktC = "reqFormat".hashCode();
    ktD = "originMediaId".hashCode();
    ktE = "fileFormat".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    ktF = "moovReady".hashCode();
    ktG = "videoBitrate".hashCode();
    ktH = "audioBitrate".hashCode();
    ktI = "frameRate".hashCode();
    ktJ = "duration".hashCode();
    ktK = "urlToken".hashCode();
    ktL = "decodeKey".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
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
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("mediaId"))
    {
      this.field_mediaId = paramContentValues.getAsString("mediaId");
      if (paramBoolean) {
        this.jKJ = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("totalSize"))
    {
      this.field_totalSize = paramContentValues.getAsLong("totalSize").longValue();
      if (paramBoolean) {
        this.klm = true;
      }
    }
    if (paramContentValues.containsKey("cacheSize"))
    {
      this.field_cacheSize = paramContentValues.getAsLong("cacheSize").longValue();
      if (paramBoolean) {
        this.kto = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("hasPlayed")) {
      if (paramContentValues.getAsInteger("hasPlayed").intValue() == 0) {
        break label550;
      }
    }
    label550:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_hasPlayed = bool1;
      if (paramBoolean) {
        this.ktp = true;
      }
      if (paramContentValues.containsKey("reqFormat"))
      {
        this.field_reqFormat = paramContentValues.getAsInteger("reqFormat").intValue();
        if (paramBoolean) {
          this.ktq = true;
        }
      }
      if (paramContentValues.containsKey("originMediaId"))
      {
        this.field_originMediaId = paramContentValues.getAsString("originMediaId");
        if (paramBoolean) {
          this.ktr = true;
        }
      }
      if (paramContentValues.containsKey("fileFormat"))
      {
        this.field_fileFormat = paramContentValues.getAsString("fileFormat");
        if (paramBoolean) {
          this.kts = true;
        }
      }
      if (paramContentValues.containsKey("updateTime"))
      {
        this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
        if (paramBoolean) {
          this.__hadSetupdateTime = true;
        }
      }
      if (paramContentValues.containsKey("moovReady"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("moovReady").intValue() != 0) {
          bool1 = true;
        }
        this.field_moovReady = bool1;
        if (paramBoolean) {
          this.ktt = true;
        }
      }
      if (paramContentValues.containsKey("videoBitrate"))
      {
        this.field_videoBitrate = paramContentValues.getAsInteger("videoBitrate").intValue();
        if (paramBoolean) {
          this.ktu = true;
        }
      }
      if (paramContentValues.containsKey("audioBitrate"))
      {
        this.field_audioBitrate = paramContentValues.getAsInteger("audioBitrate").intValue();
        if (paramBoolean) {
          this.ktv = true;
        }
      }
      if (paramContentValues.containsKey("frameRate"))
      {
        this.field_frameRate = paramContentValues.getAsInteger("frameRate").intValue();
        if (paramBoolean) {
          this.ktw = true;
        }
      }
      if (paramContentValues.containsKey("duration"))
      {
        this.field_duration = paramContentValues.getAsInteger("duration").intValue();
        if (paramBoolean) {
          this.ktx = true;
        }
      }
      if (paramContentValues.containsKey("urlToken"))
      {
        this.field_urlToken = paramContentValues.getAsString("urlToken");
        if (paramBoolean) {
          this.kty = true;
        }
      }
      if (paramContentValues.containsKey("decodeKey"))
      {
        this.field_decodeKey = paramContentValues.getAsString("decodeKey");
        if (paramBoolean) {
          this.ktz = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
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
      if (jLa != k) {
        break label65;
      }
      this.field_mediaId = paramCursor.getString(i);
      this.jKJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jPC == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (klQ == k)
      {
        this.field_totalSize = paramCursor.getLong(i);
      }
      else if (ktA == k)
      {
        this.field_cacheSize = paramCursor.getLong(i);
      }
      else if (kfH == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (ktB == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hasPlayed = bool;
            break;
          }
        }
        if (ktC == k)
        {
          this.field_reqFormat = paramCursor.getInt(i);
        }
        else if (ktD == k)
        {
          this.field_originMediaId = paramCursor.getString(i);
        }
        else if (ktE == k)
        {
          this.field_fileFormat = paramCursor.getString(i);
        }
        else if (updateTime_HASHCODE == k)
        {
          this.field_updateTime = paramCursor.getLong(i);
        }
        else
        {
          if (ktF == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_moovReady = bool;
              break;
            }
          }
          if (ktG == k) {
            this.field_videoBitrate = paramCursor.getInt(i);
          } else if (ktH == k) {
            this.field_audioBitrate = paramCursor.getInt(i);
          } else if (ktI == k) {
            this.field_frameRate = paramCursor.getInt(i);
          } else if (ktJ == k) {
            this.field_duration = paramCursor.getInt(i);
          } else if (ktK == k) {
            this.field_urlToken = paramCursor.getString(i);
          } else if (ktL == k) {
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
    if (this.jKJ) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.klm) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.kto) {
      localContentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.ktp) {
      localContentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
    }
    if (this.ktq) {
      localContentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
    }
    if (this.ktr) {
      localContentValues.put("originMediaId", this.field_originMediaId);
    }
    if (this.kts) {
      localContentValues.put("fileFormat", this.field_fileFormat);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ktt) {
      localContentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
    }
    if (this.ktu) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.ktv) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.ktw) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.ktx) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.field_urlToken == null) {
      this.field_urlToken = "";
    }
    if (this.kty) {
      localContentValues.put("urlToken", this.field_urlToken);
    }
    if (this.field_decodeKey == null) {
      this.field_decodeKey = "";
    }
    if (this.ktz) {
      localContentValues.put("decodeKey", this.field_decodeKey);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cy> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_mediaId;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cy
 * JD-Core Version:    0.7.0.1
 */