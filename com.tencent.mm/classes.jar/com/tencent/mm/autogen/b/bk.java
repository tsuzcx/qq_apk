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

public abstract class bk
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmojiDesignerProduct");
  private static final int kcA;
  public static final Column kcs;
  public static final Column kct;
  public static final Column kcu;
  private static final int kcy;
  private static final int kcz;
  private static final StorageObserverOwner<bk> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_designerUin;
  public String field_productId;
  public int field_syncTime;
  private boolean kcv = true;
  private boolean kcw = true;
  private boolean kcx = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kcs = new Column("designerUin", "int", TABLE.getName(), "");
    kct = new Column("productId", "string", TABLE.getName(), "");
    kcu = new Column("syncTime", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kcy = "designerUin".hashCode();
    kcz = "productId".hashCode();
    kcA = "syncTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "designerUin";
    localMAutoDBInfo.colsMap.put("designerUin", "INTEGER");
    localStringBuilder.append(" designerUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "productId";
    localMAutoDBInfo.colsMap.put("productId", "TEXT");
    localStringBuilder.append(" productId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "syncTime";
    localMAutoDBInfo.colsMap.put("syncTime", "INTEGER");
    localStringBuilder.append(" syncTime INTEGER");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("designerUin"))
    {
      this.field_designerUin = paramContentValues.getAsInteger("designerUin").intValue();
      if (paramBoolean) {
        this.kcv = true;
      }
    }
    if (paramContentValues.containsKey("productId"))
    {
      this.field_productId = paramContentValues.getAsString("productId");
      if (paramBoolean) {
        this.kcw = true;
      }
    }
    if (paramContentValues.containsKey("syncTime"))
    {
      this.field_syncTime = paramContentValues.getAsInteger("syncTime").intValue();
      if (paramBoolean) {
        this.kcx = true;
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
      if (kcy != k) {
        break label60;
      }
      this.field_designerUin = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kcz == k) {
        this.field_productId = paramCursor.getString(i);
      } else if (kcA == k) {
        this.field_syncTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kcv) {
      localContentValues.put("designerUin", Integer.valueOf(this.field_designerUin));
    }
    if (this.kcw) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.kcx) {
      localContentValues.put("syncTime", Integer.valueOf(this.field_syncTime));
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
  
  public StorageObserverOwner<? extends bk> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.bk
 * JD-Core Version:    0.7.0.1
 */