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

public abstract class iu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WechatAppHistory");
  public static final Column llW;
  public static final Column llX;
  public static final Column llY;
  public static final Column llZ;
  public static final Column lma;
  public static final Column lmb;
  private static final int lmi;
  private static final int lmj;
  private static final int lmk;
  private static final int lml;
  private static final int lmm;
  private static final int lmn;
  private static final StorageObserverOwner<iu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_appDs;
  public int field_appHour;
  public long field_appIn;
  public long field_appInbg;
  public long field_appTbe;
  public long field_appTen;
  private boolean lmc = true;
  private boolean lmd = true;
  private boolean lme = true;
  private boolean lmf = true;
  private boolean lmg = true;
  private boolean lmh = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    llW = new Column("appDs", "int", TABLE.getName(), "");
    llX = new Column("appHour", "int", TABLE.getName(), "");
    llY = new Column("appTbe", "long", TABLE.getName(), "");
    llZ = new Column("appTen", "long", TABLE.getName(), "");
    lma = new Column("appIn", "long", TABLE.getName(), "");
    lmb = new Column("appInbg", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lmi = "appDs".hashCode();
    lmj = "appHour".hashCode();
    lmk = "appTbe".hashCode();
    lml = "appTen".hashCode();
    lmm = "appIn".hashCode();
    lmn = "appInbg".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appDs";
    localMAutoDBInfo.colsMap.put("appDs", "INTEGER");
    localStringBuilder.append(" appDs INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appHour";
    localMAutoDBInfo.colsMap.put("appHour", "INTEGER");
    localStringBuilder.append(" appHour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appTbe";
    localMAutoDBInfo.colsMap.put("appTbe", "LONG");
    localStringBuilder.append(" appTbe LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "appTen";
    localMAutoDBInfo.colsMap.put("appTen", "LONG");
    localStringBuilder.append(" appTen LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "appIn";
    localMAutoDBInfo.colsMap.put("appIn", "LONG");
    localStringBuilder.append(" appIn LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "appInbg";
    localMAutoDBInfo.colsMap.put("appInbg", "LONG");
    localStringBuilder.append(" appInbg LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appDs"))
    {
      this.field_appDs = paramContentValues.getAsInteger("appDs").intValue();
      if (paramBoolean) {
        this.lmc = true;
      }
    }
    if (paramContentValues.containsKey("appHour"))
    {
      this.field_appHour = paramContentValues.getAsInteger("appHour").intValue();
      if (paramBoolean) {
        this.lmd = true;
      }
    }
    if (paramContentValues.containsKey("appTbe"))
    {
      this.field_appTbe = paramContentValues.getAsLong("appTbe").longValue();
      if (paramBoolean) {
        this.lme = true;
      }
    }
    if (paramContentValues.containsKey("appTen"))
    {
      this.field_appTen = paramContentValues.getAsLong("appTen").longValue();
      if (paramBoolean) {
        this.lmf = true;
      }
    }
    if (paramContentValues.containsKey("appIn"))
    {
      this.field_appIn = paramContentValues.getAsLong("appIn").longValue();
      if (paramBoolean) {
        this.lmg = true;
      }
    }
    if (paramContentValues.containsKey("appInbg"))
    {
      this.field_appInbg = paramContentValues.getAsLong("appInbg").longValue();
      if (paramBoolean) {
        this.lmh = true;
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
      if (lmi != k) {
        break label60;
      }
      this.field_appDs = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (lmj == k) {
        this.field_appHour = paramCursor.getInt(i);
      } else if (lmk == k) {
        this.field_appTbe = paramCursor.getLong(i);
      } else if (lml == k) {
        this.field_appTen = paramCursor.getLong(i);
      } else if (lmm == k) {
        this.field_appIn = paramCursor.getLong(i);
      } else if (lmn == k) {
        this.field_appInbg = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lmc) {
      localContentValues.put("appDs", Integer.valueOf(this.field_appDs));
    }
    if (this.lmd) {
      localContentValues.put("appHour", Integer.valueOf(this.field_appHour));
    }
    if (this.lme) {
      localContentValues.put("appTbe", Long.valueOf(this.field_appTbe));
    }
    if (this.lmf) {
      localContentValues.put("appTen", Long.valueOf(this.field_appTen));
    }
    if (this.lmg) {
      localContentValues.put("appIn", Long.valueOf(this.field_appIn));
    }
    if (this.lmh) {
      localContentValues.put("appInbg", Long.valueOf(this.field_appInbg));
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
  
  public StorageObserverOwner<? extends iu> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.iu
 * JD-Core Version:    0.7.0.1
 */