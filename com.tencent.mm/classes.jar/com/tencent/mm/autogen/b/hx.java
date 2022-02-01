package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.kernel.mvvm.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hx
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("Stranger");
  public static final Column jYU;
  private static final int jZG;
  private static final int jZQ;
  public static final Column jZe;
  public static final b kMg = new b();
  public static final Column lcX;
  public static final Column lcY;
  public static final Column lcZ;
  private static final int ldd;
  private static final int lde;
  private static final int ldf;
  private static final StorageObserverOwner<hx> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  private boolean jZn = true;
  private boolean jZx = true;
  private boolean lda = true;
  private boolean ldb = true;
  private boolean ldc = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jZe = new Column("encryptUsername", "string", TABLE.getName(), "");
    jYU = new Column("conRemark", "string", TABLE.getName(), "");
    lcX = new Column("contactLabels", "string", TABLE.getName(), "");
    lcY = new Column("conDescription", "string", TABLE.getName(), "");
    lcZ = new Column("conPhone", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jZQ = "encryptUsername".hashCode();
    jZG = "conRemark".hashCode();
    ldd = "contactLabels".hashCode();
    lde = "conDescription".hashCode();
    ldf = "conPhone".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "encryptUsername";
    localMAutoDBInfo.columns[1] = "conRemark";
    localMAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "contactLabels";
    localMAutoDBInfo.colsMap.put("contactLabels", "TEXT default '' ");
    localStringBuilder.append(" contactLabels TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "conDescription";
    localMAutoDBInfo.colsMap.put("conDescription", "TEXT default '' ");
    localStringBuilder.append(" conDescription TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "conPhone";
    localMAutoDBInfo.colsMap.put("conPhone", "TEXT default '' ");
    localStringBuilder.append(" conPhone TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("encryptUsername"))
    {
      this.field_encryptUsername = paramContentValues.getAsString("encryptUsername");
      if (paramBoolean) {
        this.jZx = true;
      }
    }
    if (paramContentValues.containsKey("conRemark"))
    {
      this.field_conRemark = paramContentValues.getAsString("conRemark");
      if (paramBoolean) {
        this.jZn = true;
      }
    }
    if (paramContentValues.containsKey("contactLabels"))
    {
      this.field_contactLabels = paramContentValues.getAsString("contactLabels");
      if (paramBoolean) {
        this.lda = true;
      }
    }
    if (paramContentValues.containsKey("conDescription"))
    {
      this.field_conDescription = paramContentValues.getAsString("conDescription");
      if (paramBoolean) {
        this.ldb = true;
      }
    }
    if (paramContentValues.containsKey("conPhone"))
    {
      this.field_conPhone = paramContentValues.getAsString("conPhone");
      if (paramBoolean) {
        this.ldc = true;
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
      if (jZQ != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.jZx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jZG == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (ldd == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (lde == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (ldf == k) {
        this.field_conPhone = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.jZx) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.jZn) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.lda) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.ldb) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.ldc) {
      localContentValues.put("conPhone", this.field_conPhone);
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
  
  public StorageObserverOwner<? extends hx> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_encryptUsername;
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
 * Qualified Name:     com.tencent.mm.autogen.b.hx
 * JD-Core Version:    0.7.0.1
 */