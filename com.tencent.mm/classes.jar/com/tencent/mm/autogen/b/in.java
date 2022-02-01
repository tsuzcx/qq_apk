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

public abstract class in
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletRegionGreyAreaList");
  public static final Column lhU;
  private static final int lig;
  public static final Column lju;
  private static final int ljw;
  private static final StorageObserverOwner<in> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_wallet_grey_item_buf;
  public int field_wallet_region;
  private boolean lia = true;
  private boolean ljv = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lhU = new Column("wallet_region", "int", TABLE.getName(), "");
    lju = new Column("wallet_grey_item_buf", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lig = "wallet_region".hashCode();
    ljw = "wallet_grey_item_buf".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wallet_region";
    localMAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wallet_region";
    localMAutoDBInfo.columns[1] = "wallet_grey_item_buf";
    localMAutoDBInfo.colsMap.put("wallet_grey_item_buf", "BLOB");
    localStringBuilder.append(" wallet_grey_item_buf BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("wallet_region"))
    {
      this.field_wallet_region = paramContentValues.getAsInteger("wallet_region").intValue();
      if (paramBoolean) {
        this.lia = true;
      }
    }
    if (paramContentValues.containsKey("wallet_grey_item_buf"))
    {
      this.field_wallet_grey_item_buf = paramContentValues.getAsByteArray("wallet_grey_item_buf");
      if (paramBoolean) {
        this.ljv = true;
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
      if (lig != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.lia = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ljw == k) {
        this.field_wallet_grey_item_buf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lia) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.ljv) {
      localContentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
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
  
  public StorageObserverOwner<? extends in> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_wallet_region);
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
 * Qualified Name:     com.tencent.mm.autogen.b.in
 * JD-Core Version:    0.7.0.1
 */