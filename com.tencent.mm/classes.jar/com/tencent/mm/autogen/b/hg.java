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

public abstract class hg
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SmileyInfo");
  public static final Column jOV;
  private static final int jOZ;
  private static final int kYC;
  private static final int kYD;
  private static final int kYE;
  private static final int kYF;
  private static final int kYG;
  private static final int kYH;
  private static final int kYI;
  public static final Column kYo;
  public static final Column kYp;
  public static final Column kYq;
  public static final Column kYr;
  public static final Column kYs;
  public static final Column kYt;
  public static final Column kYu;
  private static final int key_HASHCODE;
  public static final Column kkB;
  private static final int klJ;
  private static final StorageObserverOwner<hg> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetkey = true;
  public String field_cnValue;
  public int field_eggIndex;
  public String field_enValue;
  public String field_fileName;
  public int field_flag;
  public String field_key;
  public int field_position;
  public String field_qqValue;
  public String field_thValue;
  public String field_twValue;
  private boolean jOX = true;
  private boolean kYA = true;
  private boolean kYB = true;
  private boolean kYv = true;
  private boolean kYw = true;
  private boolean kYx = true;
  private boolean kYy = true;
  private boolean kYz = true;
  private boolean klf = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    kYo = new Column("cnValue", "string", TABLE.getName(), "");
    kYp = new Column("qqValue", "string", TABLE.getName(), "");
    kYq = new Column("twValue", "string", TABLE.getName(), "");
    kYr = new Column("enValue", "string", TABLE.getName(), "");
    kYs = new Column("thValue", "string", TABLE.getName(), "");
    kkB = new Column("fileName", "string", TABLE.getName(), "");
    kYt = new Column("eggIndex", "int", TABLE.getName(), "");
    kYu = new Column("position", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    key_HASHCODE = "key".hashCode();
    kYC = "cnValue".hashCode();
    kYD = "qqValue".hashCode();
    kYE = "twValue".hashCode();
    kYF = "enValue".hashCode();
    kYG = "thValue".hashCode();
    klJ = "fileName".hashCode();
    kYH = "eggIndex".hashCode();
    kYI = "position".hashCode();
    jOZ = "flag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "cnValue";
    localMAutoDBInfo.colsMap.put("cnValue", "TEXT");
    localStringBuilder.append(" cnValue TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "qqValue";
    localMAutoDBInfo.colsMap.put("qqValue", "TEXT");
    localStringBuilder.append(" qqValue TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "twValue";
    localMAutoDBInfo.colsMap.put("twValue", "TEXT");
    localStringBuilder.append(" twValue TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "enValue";
    localMAutoDBInfo.colsMap.put("enValue", "TEXT");
    localStringBuilder.append(" enValue TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thValue";
    localMAutoDBInfo.colsMap.put("thValue", "TEXT");
    localStringBuilder.append(" thValue TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "eggIndex";
    localMAutoDBInfo.colsMap.put("eggIndex", "INTEGER default '-1' ");
    localStringBuilder.append(" eggIndex INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "position";
    localMAutoDBInfo.colsMap.put("position", "INTEGER default '-1' ");
    localStringBuilder.append(" position INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("cnValue"))
    {
      this.field_cnValue = paramContentValues.getAsString("cnValue");
      if (paramBoolean) {
        this.kYv = true;
      }
    }
    if (paramContentValues.containsKey("qqValue"))
    {
      this.field_qqValue = paramContentValues.getAsString("qqValue");
      if (paramBoolean) {
        this.kYw = true;
      }
    }
    if (paramContentValues.containsKey("twValue"))
    {
      this.field_twValue = paramContentValues.getAsString("twValue");
      if (paramBoolean) {
        this.kYx = true;
      }
    }
    if (paramContentValues.containsKey("enValue"))
    {
      this.field_enValue = paramContentValues.getAsString("enValue");
      if (paramBoolean) {
        this.kYy = true;
      }
    }
    if (paramContentValues.containsKey("thValue"))
    {
      this.field_thValue = paramContentValues.getAsString("thValue");
      if (paramBoolean) {
        this.kYz = true;
      }
    }
    if (paramContentValues.containsKey("fileName"))
    {
      this.field_fileName = paramContentValues.getAsString("fileName");
      if (paramBoolean) {
        this.klf = true;
      }
    }
    if (paramContentValues.containsKey("eggIndex"))
    {
      this.field_eggIndex = paramContentValues.getAsInteger("eggIndex").intValue();
      if (paramBoolean) {
        this.kYA = true;
      }
    }
    if (paramContentValues.containsKey("position"))
    {
      this.field_position = paramContentValues.getAsInteger("position").intValue();
      if (paramBoolean) {
        this.kYB = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kYC == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (kYD == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (kYE == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (kYF == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (kYG == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (klJ == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (kYH == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (kYI == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.kYv) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.kYw) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.kYx) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.kYy) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.kYz) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.klf) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.kYA) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.kYB) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
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
  
  public StorageObserverOwner<? extends hg> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_key;
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
 * Qualified Name:     com.tencent.mm.autogen.b.hg
 * JD-Core Version:    0.7.0.1
 */