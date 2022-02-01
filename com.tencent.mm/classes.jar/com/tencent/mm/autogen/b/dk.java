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

public abstract class dk
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameHaowanMedia");
  public static final Column jKs;
  public static final Column jLQ;
  private static final int jLU;
  private static final int jLa;
  private static final int jWL;
  public static final Column jWv;
  public static final Column keu;
  public static final Column kev;
  private static final int kfX;
  private static final int kfY;
  public static final Column kpG;
  private static final int kqB;
  private static final int ktJ;
  public static final Column ktl;
  public static final Column kxb;
  public static final Column kxc;
  public static final Column kxd;
  public static final Column kxe;
  public static final Column kxf;
  public static final Column kxg;
  public static final Column kxh;
  public static final Column kxi;
  private static final int kxr;
  private static final int kxs;
  private static final int kxt;
  private static final int kxu;
  private static final int kxv;
  private static final int kxw;
  private static final int kxx;
  private static final int kxy;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<dk> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetlocalId = true;
  public String field_compressPath;
  public int field_duration;
  public int field_editFlag;
  public String field_filePath;
  public int field_height;
  public String field_hostTaskId;
  public boolean field_isGif;
  public String field_localId;
  public String field_mediaId;
  public int field_mediaType;
  public String field_mediaUrl;
  public long field_size;
  public String field_thumbPath;
  public String field_thumbPicUrl;
  public int field_uploadState;
  public int field_width;
  private boolean jKJ = true;
  private boolean jLS = true;
  private boolean jWD = true;
  private boolean kfj = true;
  private boolean kfk = true;
  private boolean kqd = true;
  private boolean ktx = true;
  private boolean kxj = true;
  private boolean kxk = true;
  private boolean kxl = true;
  private boolean kxm = true;
  private boolean kxn = true;
  private boolean kxo = true;
  private boolean kxp = true;
  private boolean kxq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "string", TABLE.getName(), "");
    jKs = new Column("mediaId", "string", TABLE.getName(), "");
    kpG = new Column("mediaType", "int", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    kxb = new Column("compressPath", "string", TABLE.getName(), "");
    kxc = new Column("thumbPath", "string", TABLE.getName(), "");
    keu = new Column("width", "int", TABLE.getName(), "");
    kev = new Column("height", "int", TABLE.getName(), "");
    ktl = new Column("duration", "int", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    kxd = new Column("isGif", "boolean", TABLE.getName(), "");
    kxe = new Column("mediaUrl", "string", TABLE.getName(), "");
    kxf = new Column("thumbPicUrl", "string", TABLE.getName(), "");
    kxg = new Column("uploadState", "int", TABLE.getName(), "");
    kxh = new Column("hostTaskId", "string", TABLE.getName(), "");
    kxi = new Column("editFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    localId_HASHCODE = "localId".hashCode();
    jLa = "mediaId".hashCode();
    kqB = "mediaType".hashCode();
    jWL = "filePath".hashCode();
    kxr = "compressPath".hashCode();
    kxs = "thumbPath".hashCode();
    kfX = "width".hashCode();
    kfY = "height".hashCode();
    ktJ = "duration".hashCode();
    jLU = "size".hashCode();
    kxt = "isGif".hashCode();
    kxu = "mediaUrl".hashCode();
    kxv = "thumbPicUrl".hashCode();
    kxw = "uploadState".hashCode();
    kxx = "hostTaskId".hashCode();
    kxy = "editFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" localId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mediaType";
    localMAutoDBInfo.colsMap.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "compressPath";
    localMAutoDBInfo.colsMap.put("compressPath", "TEXT");
    localStringBuilder.append(" compressPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thumbPath";
    localMAutoDBInfo.colsMap.put("thumbPath", "TEXT");
    localStringBuilder.append(" thumbPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "width";
    localMAutoDBInfo.colsMap.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "height";
    localMAutoDBInfo.colsMap.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "duration";
    localMAutoDBInfo.colsMap.put("duration", "INTEGER");
    localStringBuilder.append(" duration INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isGif";
    localMAutoDBInfo.colsMap.put("isGif", "INTEGER");
    localStringBuilder.append(" isGif INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "mediaUrl";
    localMAutoDBInfo.colsMap.put("mediaUrl", "TEXT");
    localStringBuilder.append(" mediaUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "thumbPicUrl";
    localMAutoDBInfo.colsMap.put("thumbPicUrl", "TEXT");
    localStringBuilder.append(" thumbPicUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "uploadState";
    localMAutoDBInfo.colsMap.put("uploadState", "INTEGER default 'false' ");
    localStringBuilder.append(" uploadState INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hostTaskId";
    localMAutoDBInfo.colsMap.put("hostTaskId", "TEXT");
    localStringBuilder.append(" hostTaskId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "editFlag";
    localMAutoDBInfo.colsMap.put("editFlag", "INTEGER default '0' ");
    localStringBuilder.append(" editFlag INTEGER default '0' ");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsString("localId");
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("mediaId"))
    {
      this.field_mediaId = paramContentValues.getAsString("mediaId");
      if (paramBoolean) {
        this.jKJ = true;
      }
    }
    if (paramContentValues.containsKey("mediaType"))
    {
      this.field_mediaType = paramContentValues.getAsInteger("mediaType").intValue();
      if (paramBoolean) {
        this.kqd = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("compressPath"))
    {
      this.field_compressPath = paramContentValues.getAsString("compressPath");
      if (paramBoolean) {
        this.kxj = true;
      }
    }
    if (paramContentValues.containsKey("thumbPath"))
    {
      this.field_thumbPath = paramContentValues.getAsString("thumbPath");
      if (paramBoolean) {
        this.kxk = true;
      }
    }
    if (paramContentValues.containsKey("width"))
    {
      this.field_width = paramContentValues.getAsInteger("width").intValue();
      if (paramBoolean) {
        this.kfj = true;
      }
    }
    if (paramContentValues.containsKey("height"))
    {
      this.field_height = paramContentValues.getAsInteger("height").intValue();
      if (paramBoolean) {
        this.kfk = true;
      }
    }
    if (paramContentValues.containsKey("duration"))
    {
      this.field_duration = paramContentValues.getAsInteger("duration").intValue();
      if (paramBoolean) {
        this.ktx = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("isGif")) {
      if (paramContentValues.getAsInteger("isGif").intValue() == 0) {
        break label501;
      }
    }
    label501:
    for (boolean bool = true;; bool = false)
    {
      this.field_isGif = bool;
      if (paramBoolean) {
        this.kxl = true;
      }
      if (paramContentValues.containsKey("mediaUrl"))
      {
        this.field_mediaUrl = paramContentValues.getAsString("mediaUrl");
        if (paramBoolean) {
          this.kxm = true;
        }
      }
      if (paramContentValues.containsKey("thumbPicUrl"))
      {
        this.field_thumbPicUrl = paramContentValues.getAsString("thumbPicUrl");
        if (paramBoolean) {
          this.kxn = true;
        }
      }
      if (paramContentValues.containsKey("uploadState"))
      {
        this.field_uploadState = paramContentValues.getAsInteger("uploadState").intValue();
        if (paramBoolean) {
          this.kxo = true;
        }
      }
      if (paramContentValues.containsKey("hostTaskId"))
      {
        this.field_hostTaskId = paramContentValues.getAsString("hostTaskId");
        if (paramBoolean) {
          this.kxp = true;
        }
      }
      if (paramContentValues.containsKey("editFlag"))
      {
        this.field_editFlag = paramContentValues.getAsInteger("editFlag").intValue();
        if (paramBoolean) {
          this.kxq = true;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jLa == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (kqB == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (jWL == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (kxr == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (kxs == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (kfX == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (kfY == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (ktJ == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (jLU == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (kxt == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (kxu == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (kxv == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (kxw == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (kxx == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (kxy == k) {
          this.field_editFlag = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.jKJ) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.kqd) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.kxj) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.kxk) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.kfj) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.kfk) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.ktx) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.kxl) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.kxm) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.kxn) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.kxo) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.kxp) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.kxq) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
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
  
  public StorageObserverOwner<? extends dk> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_localId;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.dk
 * JD-Core Version:    0.7.0.1
 */