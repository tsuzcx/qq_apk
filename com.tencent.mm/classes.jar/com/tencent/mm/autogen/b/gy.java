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

public abstract class gy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ScanTranslationResult");
  public static final Column kWh;
  public static final Column kWi;
  public static final Column kWj;
  public static final Column kWk;
  public static final Column kWl;
  private static final int kWr;
  private static final int kWs;
  private static final int kWt;
  private static final int kWu;
  private static final int kWv;
  private static final StorageObserverOwner<gy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_brand;
  public String field_fromLang;
  public String field_originMD5;
  public String field_resultFile;
  public String field_toLang;
  private boolean kWm = true;
  private boolean kWn = true;
  private boolean kWo = true;
  private boolean kWp = true;
  private boolean kWq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kWh = new Column("originMD5", "string", TABLE.getName(), "");
    kWi = new Column("resultFile", "string", TABLE.getName(), "");
    kWj = new Column("fromLang", "string", TABLE.getName(), "");
    kWk = new Column("toLang", "string", TABLE.getName(), "");
    kWl = new Column("brand", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kWr = "originMD5".hashCode();
    kWs = "resultFile".hashCode();
    kWt = "fromLang".hashCode();
    kWu = "toLang".hashCode();
    kWv = "brand".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "originMD5";
    localMAutoDBInfo.colsMap.put("originMD5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "originMD5";
    localMAutoDBInfo.columns[1] = "resultFile";
    localMAutoDBInfo.colsMap.put("resultFile", "TEXT");
    localStringBuilder.append(" resultFile TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fromLang";
    localMAutoDBInfo.colsMap.put("fromLang", "TEXT");
    localStringBuilder.append(" fromLang TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "toLang";
    localMAutoDBInfo.colsMap.put("toLang", "TEXT");
    localStringBuilder.append(" toLang TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "brand";
    localMAutoDBInfo.colsMap.put("brand", "TEXT");
    localStringBuilder.append(" brand TEXT");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("originMD5"))
    {
      this.field_originMD5 = paramContentValues.getAsString("originMD5");
      if (paramBoolean) {
        this.kWm = true;
      }
    }
    if (paramContentValues.containsKey("resultFile"))
    {
      this.field_resultFile = paramContentValues.getAsString("resultFile");
      if (paramBoolean) {
        this.kWn = true;
      }
    }
    if (paramContentValues.containsKey("fromLang"))
    {
      this.field_fromLang = paramContentValues.getAsString("fromLang");
      if (paramBoolean) {
        this.kWo = true;
      }
    }
    if (paramContentValues.containsKey("toLang"))
    {
      this.field_toLang = paramContentValues.getAsString("toLang");
      if (paramBoolean) {
        this.kWp = true;
      }
    }
    if (paramContentValues.containsKey("brand"))
    {
      this.field_brand = paramContentValues.getAsString("brand");
      if (paramBoolean) {
        this.kWq = true;
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
      if (kWr != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.kWm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kWs == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (kWt == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (kWu == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (kWv == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kWm) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.kWn) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.kWo) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.kWp) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.kWq) {
      localContentValues.put("brand", this.field_brand);
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
  
  public StorageObserverOwner<? extends gy> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_originMD5;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gy
 * JD-Core Version:    0.7.0.1
 */