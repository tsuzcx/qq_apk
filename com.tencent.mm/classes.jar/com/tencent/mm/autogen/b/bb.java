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

public abstract class bb
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ContactLabel");
  private static final int createTime_HASHCODE;
  public static final Column kaC;
  public static final Column kaD;
  public static final Column kaE;
  public static final Column kaF;
  public static final Column kaG;
  private static final int kaM;
  private static final int kaN;
  private static final int kaO;
  private static final int kaP;
  private static final int kaQ;
  private static final StorageObserverOwner<bb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public boolean field_isTemporary;
  public int field_labelID;
  public String field_labelName;
  public String field_labelPYFull;
  public String field_labelPYShort;
  private boolean kaH = true;
  private boolean kaI = true;
  private boolean kaJ = true;
  private boolean kaK = true;
  private boolean kaL = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kaC = new Column("labelID", "int", TABLE.getName(), "");
    kaD = new Column("labelName", "string", TABLE.getName(), "");
    kaE = new Column("labelPYFull", "string", TABLE.getName(), "");
    kaF = new Column("labelPYShort", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    kaG = new Column("isTemporary", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kaM = "labelID".hashCode();
    kaN = "labelName".hashCode();
    kaO = "labelPYFull".hashCode();
    kaP = "labelPYShort".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kaQ = "isTemporary".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "labelID";
    localMAutoDBInfo.colsMap.put("labelID", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" labelID INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "labelID";
    localMAutoDBInfo.columns[1] = "labelName";
    localMAutoDBInfo.colsMap.put("labelName", "TEXT");
    localStringBuilder.append(" labelName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "labelPYFull";
    localMAutoDBInfo.colsMap.put("labelPYFull", "TEXT");
    localStringBuilder.append(" labelPYFull TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "labelPYShort";
    localMAutoDBInfo.colsMap.put("labelPYShort", "TEXT");
    localStringBuilder.append(" labelPYShort TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isTemporary";
    localMAutoDBInfo.colsMap.put("isTemporary", "INTEGER");
    localStringBuilder.append(" isTemporary INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("labelID"))
    {
      this.field_labelID = paramContentValues.getAsInteger("labelID").intValue();
      if (paramBoolean) {
        this.kaH = true;
      }
    }
    if (paramContentValues.containsKey("labelName"))
    {
      this.field_labelName = paramContentValues.getAsString("labelName");
      if (paramBoolean) {
        this.kaI = true;
      }
    }
    if (paramContentValues.containsKey("labelPYFull"))
    {
      this.field_labelPYFull = paramContentValues.getAsString("labelPYFull");
      if (paramBoolean) {
        this.kaJ = true;
      }
    }
    if (paramContentValues.containsKey("labelPYShort"))
    {
      this.field_labelPYShort = paramContentValues.getAsString("labelPYShort");
      if (paramBoolean) {
        this.kaK = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("isTemporary")) {
      if (paramContentValues.getAsInteger("isTemporary").intValue() == 0) {
        break label206;
      }
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      this.field_isTemporary = bool;
      if (paramBoolean) {
        this.kaL = true;
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
      if (kaM != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.kaH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kaN == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (kaO == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (kaP == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (kaQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isTemporary = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kaH) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.kaI) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.kaJ) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.kaK) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.kaL) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
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
  
  public StorageObserverOwner<? extends bb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_labelID);
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
 * Qualified Name:     com.tencent.mm.autogen.b.bb
 * JD-Core Version:    0.7.0.1
 */