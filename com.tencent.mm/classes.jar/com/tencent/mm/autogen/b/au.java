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

public abstract class au
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("CardQrCodeDataInfo");
  private static final int jIF;
  public static final Column jIz;
  public static final Column jUT;
  private static final int jVF;
  public static final Column jWn;
  public static final Column jWo;
  private static final int jWr;
  private static final int jWs;
  private static final StorageObserverOwner<au> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  private boolean jIC = true;
  private boolean jVm = true;
  private boolean jWp = true;
  private boolean jWq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jWn = new Column("code_id", "string", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    jWo = new Column("code", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
    jWr = "code_id".hashCode();
    jVF = "card_id".hashCode();
    jWs = "code".hashCode();
    jIF = "status".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "code_id";
    localMAutoDBInfo.colsMap.put("code_id", "TEXT");
    localStringBuilder.append(" code_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "code";
    localMAutoDBInfo.colsMap.put("code", "TEXT");
    localStringBuilder.append(" code TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("code_id"))
    {
      this.field_code_id = paramContentValues.getAsString("code_id");
      if (paramBoolean) {
        this.jWp = true;
      }
    }
    if (paramContentValues.containsKey("card_id"))
    {
      this.field_card_id = paramContentValues.getAsString("card_id");
      if (paramBoolean) {
        this.jVm = true;
      }
    }
    if (paramContentValues.containsKey("code"))
    {
      this.field_code = paramContentValues.getAsString("code");
      if (paramBoolean) {
        this.jWq = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
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
      if (jWr != k) {
        break label60;
      }
      this.field_code_id = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jVF == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (jWs == k) {
        this.field_code = paramCursor.getString(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jWp) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.jWq) {
      localContentValues.put("code", this.field_code);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
  
  public StorageObserverOwner<? extends au> getObserverOwner()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.au
 * JD-Core Version:    0.7.0.1
 */