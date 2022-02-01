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

public abstract class ij
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletFunciontList");
  public static final Column lhU;
  public static final Column lhV;
  public static final Column lhW;
  public static final Column lhX;
  public static final Column lhY;
  public static final Column lhZ;
  private static final int lig;
  private static final int lih;
  private static final int lii;
  private static final int lij;
  private static final int lik;
  private static final int lil;
  private static final StorageObserverOwner<ij> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_banner_list;
  public String field_function_list;
  public int field_isShowSetting;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  private boolean lia = true;
  private boolean lib = true;
  private boolean lic = true;
  private boolean lid = true;
  private boolean lie = true;
  private boolean lif = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lhU = new Column("wallet_region", "int", TABLE.getName(), "");
    lhV = new Column("function_list", "string", TABLE.getName(), "");
    lhW = new Column("new_list", "string", TABLE.getName(), "");
    lhX = new Column("banner_list", "string", TABLE.getName(), "");
    lhY = new Column("type_name_list", "string", TABLE.getName(), "");
    lhZ = new Column("isShowSetting", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lig = "wallet_region".hashCode();
    lih = "function_list".hashCode();
    lii = "new_list".hashCode();
    lij = "banner_list".hashCode();
    lik = "type_name_list".hashCode();
    lil = "isShowSetting".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wallet_region";
    localMAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wallet_region";
    localMAutoDBInfo.columns[1] = "function_list";
    localMAutoDBInfo.colsMap.put("function_list", "TEXT");
    localStringBuilder.append(" function_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "new_list";
    localMAutoDBInfo.colsMap.put("new_list", "TEXT");
    localStringBuilder.append(" new_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "banner_list";
    localMAutoDBInfo.colsMap.put("banner_list", "TEXT");
    localStringBuilder.append(" banner_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "type_name_list";
    localMAutoDBInfo.colsMap.put("type_name_list", "TEXT");
    localStringBuilder.append(" type_name_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isShowSetting";
    localMAutoDBInfo.colsMap.put("isShowSetting", "INTEGER");
    localStringBuilder.append(" isShowSetting INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
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
    if (paramContentValues.containsKey("function_list"))
    {
      this.field_function_list = paramContentValues.getAsString("function_list");
      if (paramBoolean) {
        this.lib = true;
      }
    }
    if (paramContentValues.containsKey("new_list"))
    {
      this.field_new_list = paramContentValues.getAsString("new_list");
      if (paramBoolean) {
        this.lic = true;
      }
    }
    if (paramContentValues.containsKey("banner_list"))
    {
      this.field_banner_list = paramContentValues.getAsString("banner_list");
      if (paramBoolean) {
        this.lid = true;
      }
    }
    if (paramContentValues.containsKey("type_name_list"))
    {
      this.field_type_name_list = paramContentValues.getAsString("type_name_list");
      if (paramBoolean) {
        this.lie = true;
      }
    }
    if (paramContentValues.containsKey("isShowSetting"))
    {
      this.field_isShowSetting = paramContentValues.getAsInteger("isShowSetting").intValue();
      if (paramBoolean) {
        this.lif = true;
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
      if (lih == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (lii == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (lij == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (lik == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (lil == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
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
    if (this.lib) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.lic) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.lid) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.lie) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.lif) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
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
  
  public StorageObserverOwner<? extends ij> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ij
 * JD-Core Version:    0.7.0.1
 */