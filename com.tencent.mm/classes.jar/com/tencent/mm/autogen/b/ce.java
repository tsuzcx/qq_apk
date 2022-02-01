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

public abstract class ce
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("Feature");
  public static final Column jON;
  private static final int jOT;
  private static final int jPC;
  public static final Column jPu;
  public static final Column kjU;
  public static final Column kjV;
  public static final Column kjW;
  public static final Column kjX;
  public static final Column kjY;
  public static final Column kjZ;
  public static final Column kka;
  public static final Column kkb;
  public static final Column kkc;
  public static final Column kkd;
  private static final int kko;
  private static final int kkp;
  private static final int kkq;
  private static final int kkr;
  private static final int kks;
  private static final int kkt;
  private static final int kku;
  private static final int kkv;
  private static final int kkw;
  private static final int kkx;
  private static final StorageObserverOwner<ce> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_actionType;
  public String field_androidUrl;
  public int field_featureId;
  public String field_helpUrl;
  public String field_iconPath;
  public String field_tag;
  public long field_timestamp;
  public String field_title;
  public String field_titlePY;
  public String field_titleShortPY;
  public String field_updateUrl;
  public String field_url;
  private boolean jOQ = true;
  private boolean jPy = true;
  private boolean kke = true;
  private boolean kkf = true;
  private boolean kkg = true;
  private boolean kkh = true;
  private boolean kki = true;
  private boolean kkj = true;
  private boolean kkk = true;
  private boolean kkl = true;
  private boolean kkm = true;
  private boolean kkn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kjU = new Column("featureId", "int", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kjV = new Column("titlePY", "string", TABLE.getName(), "");
    kjW = new Column("titleShortPY", "string", TABLE.getName(), "");
    kjX = new Column("tag", "string", TABLE.getName(), "");
    kjY = new Column("actionType", "int", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    kjZ = new Column("helpUrl", "string", TABLE.getName(), "");
    kka = new Column("updateUrl", "string", TABLE.getName(), "");
    kkb = new Column("androidUrl", "string", TABLE.getName(), "");
    kkc = new Column("iconPath", "string", TABLE.getName(), "");
    kkd = new Column("timestamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kko = "featureId".hashCode();
    jOT = "title".hashCode();
    kkp = "titlePY".hashCode();
    kkq = "titleShortPY".hashCode();
    kkr = "tag".hashCode();
    kks = "actionType".hashCode();
    jPC = "url".hashCode();
    kkt = "helpUrl".hashCode();
    kku = "updateUrl".hashCode();
    kkv = "androidUrl".hashCode();
    kkw = "iconPath".hashCode();
    kkx = "timestamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[12];
    localMAutoDBInfo.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "featureId";
    localMAutoDBInfo.colsMap.put("featureId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" featureId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "featureId";
    localMAutoDBInfo.columns[1] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "titlePY";
    localMAutoDBInfo.colsMap.put("titlePY", "TEXT");
    localStringBuilder.append(" titlePY TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "titleShortPY";
    localMAutoDBInfo.colsMap.put("titleShortPY", "TEXT");
    localStringBuilder.append(" titleShortPY TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionType";
    localMAutoDBInfo.colsMap.put("actionType", "INTEGER default '0' ");
    localStringBuilder.append(" actionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "helpUrl";
    localMAutoDBInfo.colsMap.put("helpUrl", "TEXT");
    localStringBuilder.append(" helpUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "updateUrl";
    localMAutoDBInfo.colsMap.put("updateUrl", "TEXT");
    localStringBuilder.append(" updateUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "androidUrl";
    localMAutoDBInfo.colsMap.put("androidUrl", "TEXT");
    localStringBuilder.append(" androidUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "iconPath";
    localMAutoDBInfo.colsMap.put("iconPath", "TEXT");
    localStringBuilder.append(" iconPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    localMAutoDBInfo.columns[12] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("featureId"))
    {
      this.field_featureId = paramContentValues.getAsInteger("featureId").intValue();
      if (paramBoolean) {
        this.kke = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("titlePY"))
    {
      this.field_titlePY = paramContentValues.getAsString("titlePY");
      if (paramBoolean) {
        this.kkf = true;
      }
    }
    if (paramContentValues.containsKey("titleShortPY"))
    {
      this.field_titleShortPY = paramContentValues.getAsString("titleShortPY");
      if (paramBoolean) {
        this.kkg = true;
      }
    }
    if (paramContentValues.containsKey("tag"))
    {
      this.field_tag = paramContentValues.getAsString("tag");
      if (paramBoolean) {
        this.kkh = true;
      }
    }
    if (paramContentValues.containsKey("actionType"))
    {
      this.field_actionType = paramContentValues.getAsInteger("actionType").intValue();
      if (paramBoolean) {
        this.kki = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("helpUrl"))
    {
      this.field_helpUrl = paramContentValues.getAsString("helpUrl");
      if (paramBoolean) {
        this.kkj = true;
      }
    }
    if (paramContentValues.containsKey("updateUrl"))
    {
      this.field_updateUrl = paramContentValues.getAsString("updateUrl");
      if (paramBoolean) {
        this.kkk = true;
      }
    }
    if (paramContentValues.containsKey("androidUrl"))
    {
      this.field_androidUrl = paramContentValues.getAsString("androidUrl");
      if (paramBoolean) {
        this.kkl = true;
      }
    }
    if (paramContentValues.containsKey("iconPath"))
    {
      this.field_iconPath = paramContentValues.getAsString("iconPath");
      if (paramBoolean) {
        this.kkm = true;
      }
    }
    if (paramContentValues.containsKey("timestamp"))
    {
      this.field_timestamp = paramContentValues.getAsLong("timestamp").longValue();
      if (paramBoolean) {
        this.kkn = true;
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
      if (kko != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.kke = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (kkp == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (kkq == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (kkr == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (kks == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (jPC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (kkt == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (kku == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (kkv == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (kkw == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (kkx == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kke) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kkf) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.kkg) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.kkh) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.kki) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.kkj) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.kkk) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.kkl) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.kkm) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.kkn) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
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
  
  public StorageObserverOwner<? extends ce> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_featureId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ce
 * JD-Core Version:    0.7.0.1
 */