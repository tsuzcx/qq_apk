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

public abstract class fc
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LocalStoryDetail");
  public static final Column kIY;
  public static final Column kJC;
  public static final Column kJD;
  public static final Column kJE;
  public static final Column kJF;
  public static final Column kJG;
  private static final int kJM;
  private static final int kJN;
  private static final int kJO;
  private static final int kJP;
  private static final int kJQ;
  private static final int kJw;
  public static final Column keu;
  public static final Column kev;
  private static final int kfX;
  private static final int kfY;
  private static final StorageObserverOwner<fc> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  private boolean kJH = true;
  private boolean kJI = true;
  private boolean kJJ = true;
  private boolean kJK = true;
  private boolean kJL = true;
  private boolean kJk = true;
  private boolean kfj = true;
  private boolean kfk = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kJC = new Column("media_type", "int", TABLE.getName(), "");
    kJD = new Column("media_url", "string", TABLE.getName(), "");
    kJE = new Column("media_md5", "string", TABLE.getName(), "");
    kev = new Column("height", "int", TABLE.getName(), "");
    keu = new Column("width", "int", TABLE.getName(), "");
    kIY = new Column("packet_id", "string", TABLE.getName(), "");
    kJF = new Column("media_fuzzy_thumbnail_url", "string", TABLE.getName(), "");
    kJG = new Column("media_fuzzy_thumbnail_md5", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS LocalStoryDetailPacketIdIndex ON LocalStoryDetail(packet_id)" };
    kJM = "media_type".hashCode();
    kJN = "media_url".hashCode();
    kJO = "media_md5".hashCode();
    kfY = "height".hashCode();
    kfX = "width".hashCode();
    kJw = "packet_id".hashCode();
    kJP = "media_fuzzy_thumbnail_url".hashCode();
    kJQ = "media_fuzzy_thumbnail_md5".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "media_type";
    localMAutoDBInfo.colsMap.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "media_url";
    localMAutoDBInfo.colsMap.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "media_md5";
    localMAutoDBInfo.colsMap.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "height";
    localMAutoDBInfo.colsMap.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "width";
    localMAutoDBInfo.colsMap.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "packet_id";
    localMAutoDBInfo.colsMap.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "media_fuzzy_thumbnail_url";
    localMAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "media_fuzzy_thumbnail_md5";
    localMAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("media_type"))
    {
      this.field_media_type = paramContentValues.getAsInteger("media_type").intValue();
      if (paramBoolean) {
        this.kJH = true;
      }
    }
    if (paramContentValues.containsKey("media_url"))
    {
      this.field_media_url = paramContentValues.getAsString("media_url");
      if (paramBoolean) {
        this.kJI = true;
      }
    }
    if (paramContentValues.containsKey("media_md5"))
    {
      this.field_media_md5 = paramContentValues.getAsString("media_md5");
      if (paramBoolean) {
        this.kJJ = true;
      }
    }
    if (paramContentValues.containsKey("height"))
    {
      this.field_height = paramContentValues.getAsInteger("height").intValue();
      if (paramBoolean) {
        this.kfk = true;
      }
    }
    if (paramContentValues.containsKey("width"))
    {
      this.field_width = paramContentValues.getAsInteger("width").intValue();
      if (paramBoolean) {
        this.kfj = true;
      }
    }
    if (paramContentValues.containsKey("packet_id"))
    {
      this.field_packet_id = paramContentValues.getAsString("packet_id");
      if (paramBoolean) {
        this.kJk = true;
      }
    }
    if (paramContentValues.containsKey("media_fuzzy_thumbnail_url"))
    {
      this.field_media_fuzzy_thumbnail_url = paramContentValues.getAsString("media_fuzzy_thumbnail_url");
      if (paramBoolean) {
        this.kJK = true;
      }
    }
    if (paramContentValues.containsKey("media_fuzzy_thumbnail_md5"))
    {
      this.field_media_fuzzy_thumbnail_md5 = paramContentValues.getAsString("media_fuzzy_thumbnail_md5");
      if (paramBoolean) {
        this.kJL = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (kJM != k) {
        break label60;
      }
      this.field_media_type = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kJN == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (kJO == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (kfY == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (kfX == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (kJw == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (kJP == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (kJQ == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kJH) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.kJI) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.kJJ) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.kfk) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.kfj) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.kJk) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.kJK) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.kJL) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
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
  
  public StorageObserverOwner<? extends fc> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
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
 * Qualified Name:     com.tencent.mm.autogen.b.fc
 * JD-Core Version:    0.7.0.1
 */