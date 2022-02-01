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

public abstract class gg
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("PieceMusicInfo");
  public static final Column kMh;
  private static final int kND;
  private static final int kRE;
  private static final int kRF;
  private static final int kRG;
  private static final int kRH;
  private static final int kRI;
  public static final Column kRu;
  public static final Column kRv;
  public static final Column kRw;
  public static final Column kRx;
  public static final Column kRy;
  public static final Column kkB;
  private static final int klJ;
  private static final StorageObserverOwner<gg> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  private boolean kMS = true;
  private boolean kRA = true;
  private boolean kRB = true;
  private boolean kRC = true;
  private boolean kRD = true;
  private boolean kRz = true;
  private boolean klf = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kMh = new Column("musicId", "string", TABLE.getName(), "");
    kRu = new Column("musicUrl", "string", TABLE.getName(), "");
    kkB = new Column("fileName", "string", TABLE.getName(), "");
    kRv = new Column("indexBitData", "byte[]", TABLE.getName(), "");
    kRw = new Column("fileCacheComplete", "int", TABLE.getName(), "");
    kRx = new Column("pieceFileMIMEType", "string", TABLE.getName(), "");
    kRy = new Column("removeDirtyBit", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kND = "musicId".hashCode();
    kRE = "musicUrl".hashCode();
    klJ = "fileName".hashCode();
    kRF = "indexBitData".hashCode();
    kRG = "fileCacheComplete".hashCode();
    kRH = "pieceFileMIMEType".hashCode();
    kRI = "removeDirtyBit".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "musicId";
    localMAutoDBInfo.colsMap.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "musicId";
    localMAutoDBInfo.columns[1] = "musicUrl";
    localMAutoDBInfo.colsMap.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "indexBitData";
    localMAutoDBInfo.colsMap.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "fileCacheComplete";
    localMAutoDBInfo.colsMap.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "pieceFileMIMEType";
    localMAutoDBInfo.colsMap.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "removeDirtyBit";
    localMAutoDBInfo.colsMap.put("removeDirtyBit", "INTEGER");
    localStringBuilder.append(" removeDirtyBit INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("musicId"))
    {
      this.field_musicId = paramContentValues.getAsString("musicId");
      if (paramBoolean) {
        this.kMS = true;
      }
    }
    if (paramContentValues.containsKey("musicUrl"))
    {
      this.field_musicUrl = paramContentValues.getAsString("musicUrl");
      if (paramBoolean) {
        this.kRz = true;
      }
    }
    if (paramContentValues.containsKey("fileName"))
    {
      this.field_fileName = paramContentValues.getAsString("fileName");
      if (paramBoolean) {
        this.klf = true;
      }
    }
    if (paramContentValues.containsKey("indexBitData"))
    {
      this.field_indexBitData = paramContentValues.getAsByteArray("indexBitData");
      if (paramBoolean) {
        this.kRA = true;
      }
    }
    if (paramContentValues.containsKey("fileCacheComplete"))
    {
      this.field_fileCacheComplete = paramContentValues.getAsInteger("fileCacheComplete").intValue();
      if (paramBoolean) {
        this.kRB = true;
      }
    }
    if (paramContentValues.containsKey("pieceFileMIMEType"))
    {
      this.field_pieceFileMIMEType = paramContentValues.getAsString("pieceFileMIMEType");
      if (paramBoolean) {
        this.kRC = true;
      }
    }
    if (paramContentValues.containsKey("removeDirtyBit"))
    {
      this.field_removeDirtyBit = paramContentValues.getAsInteger("removeDirtyBit").intValue();
      if (paramBoolean) {
        this.kRD = true;
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
      if (kND != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.kMS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kRE == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (klJ == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (kRF == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (kRG == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (kRH == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (kRI == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kMS) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.kRz) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.klf) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.kRA) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.kRB) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.kRC) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.kRD) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
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
  
  public StorageObserverOwner<? extends gg> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_musicId;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.gg
 * JD-Core Version:    0.7.0.1
 */