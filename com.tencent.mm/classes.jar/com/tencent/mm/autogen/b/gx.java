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

public abstract class gx
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ScanHistoryItem");
  private static final int jJD;
  public static final Column jJz;
  public static final Column kVV;
  public static final Column kVW;
  public static final Column kVX;
  public static final Column kVY;
  private static final int kWd;
  private static final int kWe;
  private static final int kWf;
  private static final int kWg;
  public static final Column kct;
  private static final int kcz;
  private static final StorageObserverOwner<gx> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  private boolean jJB = true;
  private boolean kVZ = true;
  private boolean kWa = true;
  private boolean kWb = true;
  private boolean kWc = true;
  private boolean kcw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kct = new Column("productId", "string", TABLE.getName(), "");
    kVV = new Column("xmlContent", "string", TABLE.getName(), "");
    kVW = new Column("ScanTime", "long", TABLE.getName(), "");
    kVX = new Column("funcType", "int", TABLE.getName(), "");
    kVY = new Column("qrcodeUrl", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kcz = "productId".hashCode();
    kWd = "xmlContent".hashCode();
    kWe = "ScanTime".hashCode();
    kWf = "funcType".hashCode();
    kWg = "qrcodeUrl".hashCode();
    jJD = "scene".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "productId";
    localMAutoDBInfo.colsMap.put("productId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "productId";
    localMAutoDBInfo.columns[1] = "xmlContent";
    localMAutoDBInfo.colsMap.put("xmlContent", "TEXT");
    localStringBuilder.append(" xmlContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ScanTime";
    localMAutoDBInfo.colsMap.put("ScanTime", "LONG");
    localStringBuilder.append(" ScanTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "funcType";
    localMAutoDBInfo.colsMap.put("funcType", "INTEGER");
    localStringBuilder.append(" funcType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "qrcodeUrl";
    localMAutoDBInfo.colsMap.put("qrcodeUrl", "TEXT");
    localStringBuilder.append(" qrcodeUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("productId"))
    {
      this.field_productId = paramContentValues.getAsString("productId");
      if (paramBoolean) {
        this.kcw = true;
      }
    }
    if (paramContentValues.containsKey("xmlContent"))
    {
      this.field_xmlContent = paramContentValues.getAsString("xmlContent");
      if (paramBoolean) {
        this.kVZ = true;
      }
    }
    if (paramContentValues.containsKey("ScanTime"))
    {
      this.field_ScanTime = paramContentValues.getAsLong("ScanTime").longValue();
      if (paramBoolean) {
        this.kWa = true;
      }
    }
    if (paramContentValues.containsKey("funcType"))
    {
      this.field_funcType = paramContentValues.getAsInteger("funcType").intValue();
      if (paramBoolean) {
        this.kWb = true;
      }
    }
    if (paramContentValues.containsKey("qrcodeUrl"))
    {
      this.field_qrcodeUrl = paramContentValues.getAsString("qrcodeUrl");
      if (paramBoolean) {
        this.kWc = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
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
      if (kcz != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.kcw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kWd == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (kWe == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (kWf == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (kWg == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kcw) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.kVZ) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.kWa) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.kWb) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.kWc) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
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
  
  public StorageObserverOwner<? extends gx> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_productId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gx
 * JD-Core Version:    0.7.0.1
 */