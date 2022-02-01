package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public abstract class fz
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OpenIMWordingInfo");
  public static final Column UPDATETIME;
  public static final Column jKp;
  public static final Column jYX;
  public static final Column kPS;
  private static final int kPY;
  public static final Column kQU;
  public static final Column kQV;
  public static final Column kQW;
  private static final int kQd;
  private static final int kRb;
  private static final int kRc;
  private static final int kRd;
  private static final int kRe;
  private static final StorageObserverOwner<fz> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  private boolean kPV = true;
  private boolean kQX = true;
  private boolean kQY = true;
  private boolean kQZ = true;
  private boolean kQb = true;
  private boolean kRa = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appid", "string", TABLE.getName(), "");
    kQU = new Column("wordingId", "string", TABLE.getName(), "");
    kPS = new Column("language", "string", TABLE.getName(), "");
    kQV = new Column("wording", "string", TABLE.getName(), "");
    kQW = new Column("pinyin", "string", TABLE.getName(), "");
    jYX = new Column("quanpin", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kQd = "appid".hashCode();
    kRb = "wordingId".hashCode();
    kPY = "language".hashCode();
    kRc = "wording".hashCode();
    kRd = "pinyin".hashCode();
    kRe = "quanpin".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appid";
    localMAutoDBInfo.colsMap.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "wordingId";
    localMAutoDBInfo.colsMap.put("wordingId", "TEXT");
    localStringBuilder.append(" wordingId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "language";
    localMAutoDBInfo.colsMap.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "wording";
    localMAutoDBInfo.colsMap.put("wording", "TEXT");
    localStringBuilder.append(" wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pinyin";
    localMAutoDBInfo.colsMap.put("pinyin", "TEXT");
    localStringBuilder.append(" pinyin TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "quanpin";
    localMAutoDBInfo.colsMap.put("quanpin", "TEXT");
    localStringBuilder.append(" quanpin TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  private JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a.b(localJSONObject, "appid", this.field_appid);
      a.b(localJSONObject, "wordingId", this.field_wordingId);
      a.b(localJSONObject, "language", this.field_language);
      a.b(localJSONObject, "wording", this.field_wording);
      a.b(localJSONObject, "pinyin", this.field_pinyin);
      a.b(localJSONObject, "quanpin", this.field_quanpin);
      a.b(localJSONObject, "updateTime", Long.valueOf(this.field_updateTime));
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appid"))
    {
      this.field_appid = paramContentValues.getAsString("appid");
      if (paramBoolean) {
        this.kQb = true;
      }
    }
    if (paramContentValues.containsKey("wordingId"))
    {
      this.field_wordingId = paramContentValues.getAsString("wordingId");
      if (paramBoolean) {
        this.kQX = true;
      }
    }
    if (paramContentValues.containsKey("language"))
    {
      this.field_language = paramContentValues.getAsString("language");
      if (paramBoolean) {
        this.kPV = true;
      }
    }
    if (paramContentValues.containsKey("wording"))
    {
      this.field_wording = paramContentValues.getAsString("wording");
      if (paramBoolean) {
        this.kQY = true;
      }
    }
    if (paramContentValues.containsKey("pinyin"))
    {
      this.field_pinyin = paramContentValues.getAsString("pinyin");
      if (paramBoolean) {
        this.kQZ = true;
      }
    }
    if (paramContentValues.containsKey("quanpin"))
    {
      this.field_quanpin = paramContentValues.getAsString("quanpin");
      if (paramBoolean) {
        this.kRa = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
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
      if (kQd != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kRb == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (kPY == k) {
        this.field_language = paramCursor.getString(i);
      } else if (kRc == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (kRd == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (kRe == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kQb) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.kQX) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.kPV) {
      localContentValues.put("language", this.field_language);
    }
    if (this.kQY) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.kQZ) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.kRa) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
  
  public StorageObserverOwner<? extends fz> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fz
 * JD-Core Version:    0.7.0.1
 */