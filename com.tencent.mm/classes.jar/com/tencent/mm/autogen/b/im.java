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

public abstract class im
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletPrefInfo");
  public static final Column jUR;
  public static final Column jUX;
  private static final int jVD;
  private static final int jVJ;
  public static final Column liZ;
  public static final Column lja;
  public static final Column ljb;
  public static final Column ljc;
  public static final Column ljd;
  public static final Column lje;
  public static final Column ljf;
  private static final int ljn;
  private static final int ljo;
  private static final int ljp;
  private static final int ljq;
  private static final int ljr;
  private static final int ljs;
  private static final int ljt;
  private static final StorageObserverOwner<im> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_is_show;
  public int field_jump_type;
  public String field_logo_url;
  public String field_pref_desc;
  public String field_pref_key;
  public String field_pref_title;
  public String field_pref_url;
  public String field_tinyapp_path;
  public String field_tinyapp_username;
  private boolean jVk = true;
  private boolean jVq = true;
  private boolean ljg = true;
  private boolean ljh = true;
  private boolean lji = true;
  private boolean ljj = true;
  private boolean ljk = true;
  private boolean ljl = true;
  private boolean ljm = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    liZ = new Column("pref_key", "string", TABLE.getName(), "");
    lja = new Column("pref_title", "string", TABLE.getName(), "");
    ljb = new Column("pref_url", "string", TABLE.getName(), "");
    ljc = new Column("is_show", "int", TABLE.getName(), "");
    ljd = new Column("pref_desc", "string", TABLE.getName(), "");
    jUR = new Column("logo_url", "string", TABLE.getName(), "");
    jUX = new Column("jump_type", "int", TABLE.getName(), "");
    lje = new Column("tinyapp_username", "string", TABLE.getName(), "");
    ljf = new Column("tinyapp_path", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    ljn = "pref_key".hashCode();
    ljo = "pref_title".hashCode();
    ljp = "pref_url".hashCode();
    ljq = "is_show".hashCode();
    ljr = "pref_desc".hashCode();
    jVD = "logo_url".hashCode();
    jVJ = "jump_type".hashCode();
    ljs = "tinyapp_username".hashCode();
    ljt = "tinyapp_path".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pref_key";
    localMAutoDBInfo.colsMap.put("pref_key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pref_key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "pref_key";
    localMAutoDBInfo.columns[1] = "pref_title";
    localMAutoDBInfo.colsMap.put("pref_title", "TEXT");
    localStringBuilder.append(" pref_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pref_url";
    localMAutoDBInfo.colsMap.put("pref_url", "TEXT");
    localStringBuilder.append(" pref_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "is_show";
    localMAutoDBInfo.colsMap.put("is_show", "INTEGER default '1' ");
    localStringBuilder.append(" is_show INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pref_desc";
    localMAutoDBInfo.colsMap.put("pref_desc", "TEXT");
    localStringBuilder.append(" pref_desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "logo_url";
    localMAutoDBInfo.colsMap.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "jump_type";
    localMAutoDBInfo.colsMap.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "tinyapp_username";
    localMAutoDBInfo.colsMap.put("tinyapp_username", "TEXT");
    localStringBuilder.append(" tinyapp_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "tinyapp_path";
    localMAutoDBInfo.colsMap.put("tinyapp_path", "TEXT");
    localStringBuilder.append(" tinyapp_path TEXT");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("pref_key"))
    {
      this.field_pref_key = paramContentValues.getAsString("pref_key");
      if (paramBoolean) {
        this.ljg = true;
      }
    }
    if (paramContentValues.containsKey("pref_title"))
    {
      this.field_pref_title = paramContentValues.getAsString("pref_title");
      if (paramBoolean) {
        this.ljh = true;
      }
    }
    if (paramContentValues.containsKey("pref_url"))
    {
      this.field_pref_url = paramContentValues.getAsString("pref_url");
      if (paramBoolean) {
        this.lji = true;
      }
    }
    if (paramContentValues.containsKey("is_show"))
    {
      this.field_is_show = paramContentValues.getAsInteger("is_show").intValue();
      if (paramBoolean) {
        this.ljj = true;
      }
    }
    if (paramContentValues.containsKey("pref_desc"))
    {
      this.field_pref_desc = paramContentValues.getAsString("pref_desc");
      if (paramBoolean) {
        this.ljk = true;
      }
    }
    if (paramContentValues.containsKey("logo_url"))
    {
      this.field_logo_url = paramContentValues.getAsString("logo_url");
      if (paramBoolean) {
        this.jVk = true;
      }
    }
    if (paramContentValues.containsKey("jump_type"))
    {
      this.field_jump_type = paramContentValues.getAsInteger("jump_type").intValue();
      if (paramBoolean) {
        this.jVq = true;
      }
    }
    if (paramContentValues.containsKey("tinyapp_username"))
    {
      this.field_tinyapp_username = paramContentValues.getAsString("tinyapp_username");
      if (paramBoolean) {
        this.ljl = true;
      }
    }
    if (paramContentValues.containsKey("tinyapp_path"))
    {
      this.field_tinyapp_path = paramContentValues.getAsString("tinyapp_path");
      if (paramBoolean) {
        this.ljm = true;
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
      if (ljn != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.ljg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ljo == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (ljp == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (ljq == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (ljr == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (jVD == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (jVJ == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (ljs == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (ljt == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ljg) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.ljh) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.lji) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.ljj) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.ljk) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.jVk) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.jVq) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.ljl) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.ljm) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
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
  
  public StorageObserverOwner<? extends im> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_pref_key;
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
 * Qualified Name:     com.tencent.mm.autogen.b.im
 * JD-Core Version:    0.7.0.1
 */