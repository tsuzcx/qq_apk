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

public abstract class fa
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LoanEntryInfo");
  public static final Column jON;
  private static final int jOT;
  public static final Column kIA;
  public static final Column kIB;
  public static final Column kIC;
  public static final Column kID;
  public static final Column kIE;
  public static final Column kIF;
  private static final int kIM;
  private static final int kIN;
  private static final int kIO;
  private static final int kIP;
  private static final int kIQ;
  private static final int kIR;
  private static final StorageObserverOwner<fa> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  private boolean jOQ = true;
  private boolean kIG = true;
  private boolean kIH = true;
  private boolean kII = true;
  private boolean kIJ = true;
  private boolean kIK = true;
  private boolean kIL = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kIA = new Column("loan_jump_url", "string", TABLE.getName(), "");
    kIB = new Column("red_dot_index", "int", TABLE.getName(), "");
    kIC = new Column("is_show_entry", "int", TABLE.getName(), "");
    kID = new Column("tips", "string", TABLE.getName(), "");
    kIE = new Column("is_overdue", "int", TABLE.getName(), "");
    kIF = new Column("available_otb", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jOT = "title".hashCode();
    kIM = "loan_jump_url".hashCode();
    kIN = "red_dot_index".hashCode();
    kIO = "is_show_entry".hashCode();
    kIP = "tips".hashCode();
    kIQ = "is_overdue".hashCode();
    kIR = "available_otb".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" title TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "title";
    localMAutoDBInfo.columns[1] = "loan_jump_url";
    localMAutoDBInfo.colsMap.put("loan_jump_url", "TEXT");
    localStringBuilder.append(" loan_jump_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "red_dot_index";
    localMAutoDBInfo.colsMap.put("red_dot_index", "INTEGER");
    localStringBuilder.append(" red_dot_index INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "is_show_entry";
    localMAutoDBInfo.colsMap.put("is_show_entry", "INTEGER");
    localStringBuilder.append(" is_show_entry INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tips";
    localMAutoDBInfo.colsMap.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "is_overdue";
    localMAutoDBInfo.colsMap.put("is_overdue", "INTEGER");
    localStringBuilder.append(" is_overdue INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "available_otb";
    localMAutoDBInfo.colsMap.put("available_otb", "TEXT");
    localStringBuilder.append(" available_otb TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("loan_jump_url"))
    {
      this.field_loan_jump_url = paramContentValues.getAsString("loan_jump_url");
      if (paramBoolean) {
        this.kIG = true;
      }
    }
    if (paramContentValues.containsKey("red_dot_index"))
    {
      this.field_red_dot_index = paramContentValues.getAsInteger("red_dot_index").intValue();
      if (paramBoolean) {
        this.kIH = true;
      }
    }
    if (paramContentValues.containsKey("is_show_entry"))
    {
      this.field_is_show_entry = paramContentValues.getAsInteger("is_show_entry").intValue();
      if (paramBoolean) {
        this.kII = true;
      }
    }
    if (paramContentValues.containsKey("tips"))
    {
      this.field_tips = paramContentValues.getAsString("tips");
      if (paramBoolean) {
        this.kIJ = true;
      }
    }
    if (paramContentValues.containsKey("is_overdue"))
    {
      this.field_is_overdue = paramContentValues.getAsInteger("is_overdue").intValue();
      if (paramBoolean) {
        this.kIK = true;
      }
    }
    if (paramContentValues.containsKey("available_otb"))
    {
      this.field_available_otb = paramContentValues.getAsString("available_otb");
      if (paramBoolean) {
        this.kIL = true;
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
      if (jOT != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.jOQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kIM == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (kIN == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (kIO == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (kIP == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (kIQ == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (kIR == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kIG) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.kIH) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.kII) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.kIJ) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.kIK) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.kIL) {
      localContentValues.put("available_otb", this.field_available_otb);
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
  
  public StorageObserverOwner<? extends fa> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_title;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fa
 * JD-Core Version:    0.7.0.1
 */