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

public abstract class ik
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletKindInfo");
  private static final int liA;
  private static final int liB;
  private static final int liC;
  private static final int liD;
  public static final Column lim;
  public static final Column lin;
  public static final Column lio;
  public static final Column lip;
  public static final Column liq;
  public static final Column lir;
  private static final int liy;
  private static final int liz;
  private static final StorageObserverOwner<ik> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  private boolean lis = true;
  private boolean lit = true;
  private boolean liu = true;
  private boolean liv = true;
  private boolean liw = true;
  private boolean lix = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lim = new Column("wallet_tpa_country", "string", TABLE.getName(), "");
    lin = new Column("wallet_type", "int", TABLE.getName(), "");
    lio = new Column("wallet_name", "string", TABLE.getName(), "");
    lip = new Column("wallet_selected", "int", TABLE.getName(), "");
    liq = new Column("wallet_balance", "int", TABLE.getName(), "");
    lir = new Column("wallet_tpa_country_mask", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    liy = "wallet_tpa_country".hashCode();
    liz = "wallet_type".hashCode();
    liA = "wallet_name".hashCode();
    liB = "wallet_selected".hashCode();
    liC = "wallet_balance".hashCode();
    liD = "wallet_tpa_country_mask".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wallet_tpa_country";
    localMAutoDBInfo.colsMap.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wallet_tpa_country";
    localMAutoDBInfo.columns[1] = "wallet_type";
    localMAutoDBInfo.colsMap.put("wallet_type", "INTEGER");
    localStringBuilder.append(" wallet_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "wallet_name";
    localMAutoDBInfo.colsMap.put("wallet_name", "TEXT");
    localStringBuilder.append(" wallet_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "wallet_selected";
    localMAutoDBInfo.colsMap.put("wallet_selected", "INTEGER");
    localStringBuilder.append(" wallet_selected INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "wallet_balance";
    localMAutoDBInfo.colsMap.put("wallet_balance", "INTEGER");
    localStringBuilder.append(" wallet_balance INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "wallet_tpa_country_mask";
    localMAutoDBInfo.colsMap.put("wallet_tpa_country_mask", "INTEGER");
    localStringBuilder.append(" wallet_tpa_country_mask INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("wallet_tpa_country"))
    {
      this.field_wallet_tpa_country = paramContentValues.getAsString("wallet_tpa_country");
      if (paramBoolean) {
        this.lis = true;
      }
    }
    if (paramContentValues.containsKey("wallet_type"))
    {
      this.field_wallet_type = paramContentValues.getAsInteger("wallet_type").intValue();
      if (paramBoolean) {
        this.lit = true;
      }
    }
    if (paramContentValues.containsKey("wallet_name"))
    {
      this.field_wallet_name = paramContentValues.getAsString("wallet_name");
      if (paramBoolean) {
        this.liu = true;
      }
    }
    if (paramContentValues.containsKey("wallet_selected"))
    {
      this.field_wallet_selected = paramContentValues.getAsInteger("wallet_selected").intValue();
      if (paramBoolean) {
        this.liv = true;
      }
    }
    if (paramContentValues.containsKey("wallet_balance"))
    {
      this.field_wallet_balance = paramContentValues.getAsInteger("wallet_balance").intValue();
      if (paramBoolean) {
        this.liw = true;
      }
    }
    if (paramContentValues.containsKey("wallet_tpa_country_mask"))
    {
      this.field_wallet_tpa_country_mask = paramContentValues.getAsInteger("wallet_tpa_country_mask").intValue();
      if (paramBoolean) {
        this.lix = true;
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
      if (liy != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.lis = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (liz == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (liA == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (liB == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (liC == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (liD == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lis) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.lit) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.liu) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.liv) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.liw) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.lix) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
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
  
  public StorageObserverOwner<? extends ik> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_wallet_tpa_country;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ik
 * JD-Core Version:    0.7.0.1
 */