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

public abstract class fe
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("LuckyMoneyEnvelopeResource");
  private static final int jMG;
  public static final Column jMw;
  public static final Column kJX;
  public static final Column kJY;
  public static final Column kJZ;
  public static final Column kKa;
  public static final Column kKb;
  public static final Column kKc;
  private static final int kKj;
  private static final int kKk;
  private static final int kKl;
  private static final int kKm;
  private static final int kKn;
  private static final int kKo;
  private static final int kjT;
  private static final StorageObserverOwner<fe> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_bubbleMd5;
  public String field_bubblewidgetMd5;
  public String field_coverMd5;
  public String field_coverwidgetMd5;
  public String field_detailMd5;
  public String field_minilogoMd5;
  public int field_subtype;
  public int field_version;
  private boolean jMB = true;
  private boolean kKd = true;
  private boolean kKe = true;
  private boolean kKf = true;
  private boolean kKg = true;
  private boolean kKh = true;
  private boolean kKi = true;
  private boolean kjR = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    SUBTYPE = new Column("subtype", "int", TABLE.getName(), "");
    kJX = new Column("bubbleMd5", "string", TABLE.getName(), "");
    kJY = new Column("coverMd5", "string", TABLE.getName(), "");
    kJZ = new Column("minilogoMd5", "string", TABLE.getName(), "");
    kKa = new Column("detailMd5", "string", TABLE.getName(), "");
    jMw = new Column("version", "int", TABLE.getName(), "");
    kKb = new Column("bubblewidgetMd5", "string", TABLE.getName(), "");
    kKc = new Column("coverwidgetMd5", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kjT = "subtype".hashCode();
    kKj = "bubbleMd5".hashCode();
    kKk = "coverMd5".hashCode();
    kKl = "minilogoMd5".hashCode();
    kKm = "detailMd5".hashCode();
    jMG = "version".hashCode();
    kKn = "bubblewidgetMd5".hashCode();
    kKo = "coverwidgetMd5".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "subtype";
    localMAutoDBInfo.colsMap.put("subtype", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" subtype INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "subtype";
    localMAutoDBInfo.columns[1] = "bubbleMd5";
    localMAutoDBInfo.colsMap.put("bubbleMd5", "TEXT");
    localStringBuilder.append(" bubbleMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "coverMd5";
    localMAutoDBInfo.colsMap.put("coverMd5", "TEXT");
    localStringBuilder.append(" coverMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "minilogoMd5";
    localMAutoDBInfo.colsMap.put("minilogoMd5", "TEXT");
    localStringBuilder.append(" minilogoMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "detailMd5";
    localMAutoDBInfo.colsMap.put("detailMd5", "TEXT");
    localStringBuilder.append(" detailMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "bubblewidgetMd5";
    localMAutoDBInfo.colsMap.put("bubblewidgetMd5", "TEXT");
    localStringBuilder.append(" bubblewidgetMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "coverwidgetMd5";
    localMAutoDBInfo.colsMap.put("coverwidgetMd5", "TEXT");
    localStringBuilder.append(" coverwidgetMd5 TEXT");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("subtype"))
    {
      this.field_subtype = paramContentValues.getAsInteger("subtype").intValue();
      if (paramBoolean) {
        this.kjR = true;
      }
    }
    if (paramContentValues.containsKey("bubbleMd5"))
    {
      this.field_bubbleMd5 = paramContentValues.getAsString("bubbleMd5");
      if (paramBoolean) {
        this.kKd = true;
      }
    }
    if (paramContentValues.containsKey("coverMd5"))
    {
      this.field_coverMd5 = paramContentValues.getAsString("coverMd5");
      if (paramBoolean) {
        this.kKe = true;
      }
    }
    if (paramContentValues.containsKey("minilogoMd5"))
    {
      this.field_minilogoMd5 = paramContentValues.getAsString("minilogoMd5");
      if (paramBoolean) {
        this.kKf = true;
      }
    }
    if (paramContentValues.containsKey("detailMd5"))
    {
      this.field_detailMd5 = paramContentValues.getAsString("detailMd5");
      if (paramBoolean) {
        this.kKg = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsInteger("version").intValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("bubblewidgetMd5"))
    {
      this.field_bubblewidgetMd5 = paramContentValues.getAsString("bubblewidgetMd5");
      if (paramBoolean) {
        this.kKh = true;
      }
    }
    if (paramContentValues.containsKey("coverwidgetMd5"))
    {
      this.field_coverwidgetMd5 = paramContentValues.getAsString("coverwidgetMd5");
      if (paramBoolean) {
        this.kKi = true;
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
      if (kjT != k) {
        break label65;
      }
      this.field_subtype = paramCursor.getInt(i);
      this.kjR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kKj == k) {
        this.field_bubbleMd5 = paramCursor.getString(i);
      } else if (kKk == k) {
        this.field_coverMd5 = paramCursor.getString(i);
      } else if (kKl == k) {
        this.field_minilogoMd5 = paramCursor.getString(i);
      } else if (kKm == k) {
        this.field_detailMd5 = paramCursor.getString(i);
      } else if (jMG == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (kKn == k) {
        this.field_bubblewidgetMd5 = paramCursor.getString(i);
      } else if (kKo == k) {
        this.field_coverwidgetMd5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kjR) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.kKd) {
      localContentValues.put("bubbleMd5", this.field_bubbleMd5);
    }
    if (this.kKe) {
      localContentValues.put("coverMd5", this.field_coverMd5);
    }
    if (this.kKf) {
      localContentValues.put("minilogoMd5", this.field_minilogoMd5);
    }
    if (this.kKg) {
      localContentValues.put("detailMd5", this.field_detailMd5);
    }
    if (this.jMB) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.kKh) {
      localContentValues.put("bubblewidgetMd5", this.field_bubblewidgetMd5);
    }
    if (this.kKi) {
      localContentValues.put("coverwidgetMd5", this.field_coverwidgetMd5);
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
  
  public StorageObserverOwner<? extends fe> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_subtype);
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
 * Qualified Name:     com.tencent.mm.autogen.b.fe
 * JD-Core Version:    0.7.0.1
 */