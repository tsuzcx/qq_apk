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

public abstract class bn
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmojiInfoDesc");
  public static final Column kcW;
  private static final int kdW;
  public static final Column kea;
  public static final Column kel;
  private static final int kfD;
  private static final int kfO;
  private static final int kgA;
  private static final int kgB;
  private static final int kgC;
  public static final Column kgr;
  public static final Column kgs;
  public static final Column kgt;
  public static final Column kgu;
  private static final int kgz;
  private static final StorageObserverOwner<bn> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  private boolean kdw = true;
  private boolean keP = true;
  private boolean kfa = true;
  private boolean kgv = true;
  private boolean kgw = true;
  private boolean kgx = true;
  private boolean kgy = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kgr = new Column("md5_lang", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    kcW = new Column("lang", "string", TABLE.getName(), "");
    kgs = new Column("desc", "string", TABLE.getName(), "");
    kel = new Column("groupId", "string", TABLE.getName(), "");
    kgt = new Column("click_flag", "int", TABLE.getName(), "");
    kgu = new Column("download_flag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kgz = "md5_lang".hashCode();
    kfD = "md5".hashCode();
    kdW = "lang".hashCode();
    kgA = "desc".hashCode();
    kfO = "groupId".hashCode();
    kgB = "click_flag".hashCode();
    kgC = "download_flag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "md5_lang";
    localMAutoDBInfo.colsMap.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "md5_lang";
    localMAutoDBInfo.columns[1] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lang";
    localMAutoDBInfo.colsMap.put("lang", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" lang TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "click_flag";
    localMAutoDBInfo.colsMap.put("click_flag", "INTEGER");
    localStringBuilder.append(" click_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "download_flag";
    localMAutoDBInfo.colsMap.put("download_flag", "INTEGER");
    localStringBuilder.append(" download_flag INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("md5_lang"))
    {
      this.field_md5_lang = paramContentValues.getAsString("md5_lang");
      if (paramBoolean) {
        this.kgv = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("lang"))
    {
      this.field_lang = paramContentValues.getAsString("lang");
      if (paramBoolean) {
        this.kdw = true;
      }
    }
    if (paramContentValues.containsKey("desc"))
    {
      this.field_desc = paramContentValues.getAsString("desc");
      if (paramBoolean) {
        this.kgw = true;
      }
    }
    if (paramContentValues.containsKey("groupId"))
    {
      this.field_groupId = paramContentValues.getAsString("groupId");
      if (paramBoolean) {
        this.kfa = true;
      }
    }
    if (paramContentValues.containsKey("click_flag"))
    {
      this.field_click_flag = paramContentValues.getAsInteger("click_flag").intValue();
      if (paramBoolean) {
        this.kgx = true;
      }
    }
    if (paramContentValues.containsKey("download_flag"))
    {
      this.field_download_flag = paramContentValues.getAsInteger("download_flag").intValue();
      if (paramBoolean) {
        this.kgy = true;
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
      if (kgz != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.kgv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (kdW == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (kgA == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (kfO == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (kgB == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (kgC == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kgv) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.kdw) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.kgw) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.kfa) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.kgx) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.kgy) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
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
  
  public StorageObserverOwner<? extends bn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_md5_lang;
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
 * Qualified Name:     com.tencent.mm.autogen.b.bn
 * JD-Core Version:    0.7.0.1
 */