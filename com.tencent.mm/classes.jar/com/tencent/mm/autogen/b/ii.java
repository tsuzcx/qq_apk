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

public abstract class ii
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletBulletin");
  public static final Column TYPE;
  public static final Column kQV;
  private static final int kRc;
  public static final Column lhA;
  public static final Column lhB;
  public static final Column lhC;
  public static final Column lhD;
  public static final Column lhE;
  public static final Column lhF;
  private static final int lhN;
  private static final int lhO;
  private static final int lhP;
  private static final int lhQ;
  private static final int lhR;
  private static final int lhS;
  private static final int lhT;
  public static final Column lhz;
  private static final StorageObserverOwner<ii> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_bulletin_content;
  public String field_bulletin_scene;
  public String field_bulletin_url;
  public int field_is_show_notice;
  public String field_jump_url;
  public String field_left_icon;
  public String field_notice_id;
  public int field_type;
  public String field_wording;
  private boolean kQY = true;
  private boolean lhG = true;
  private boolean lhH = true;
  private boolean lhI = true;
  private boolean lhJ = true;
  private boolean lhK = true;
  private boolean lhL = true;
  private boolean lhM = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lhz = new Column("bulletin_scene", "string", TABLE.getName(), "");
    lhA = new Column("bulletin_content", "string", TABLE.getName(), "");
    lhB = new Column("bulletin_url", "string", TABLE.getName(), "");
    lhC = new Column("is_show_notice", "int", TABLE.getName(), "");
    kQV = new Column("wording", "string", TABLE.getName(), "");
    lhD = new Column("left_icon", "string", TABLE.getName(), "");
    lhE = new Column("jump_url", "string", TABLE.getName(), "");
    lhF = new Column("notice_id", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lhN = "bulletin_scene".hashCode();
    lhO = "bulletin_content".hashCode();
    lhP = "bulletin_url".hashCode();
    lhQ = "is_show_notice".hashCode();
    kRc = "wording".hashCode();
    lhR = "left_icon".hashCode();
    lhS = "jump_url".hashCode();
    lhT = "notice_id".hashCode();
    type_HASHCODE = "type".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bulletin_scene";
    localMAutoDBInfo.colsMap.put("bulletin_scene", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bulletin_scene";
    localMAutoDBInfo.columns[1] = "bulletin_content";
    localMAutoDBInfo.colsMap.put("bulletin_content", "TEXT");
    localStringBuilder.append(" bulletin_content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "bulletin_url";
    localMAutoDBInfo.colsMap.put("bulletin_url", "TEXT");
    localStringBuilder.append(" bulletin_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "is_show_notice";
    localMAutoDBInfo.colsMap.put("is_show_notice", "INTEGER");
    localStringBuilder.append(" is_show_notice INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "wording";
    localMAutoDBInfo.colsMap.put("wording", "TEXT");
    localStringBuilder.append(" wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "left_icon";
    localMAutoDBInfo.colsMap.put("left_icon", "TEXT");
    localStringBuilder.append(" left_icon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "jump_url";
    localMAutoDBInfo.colsMap.put("jump_url", "TEXT");
    localStringBuilder.append(" jump_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "notice_id";
    localMAutoDBInfo.colsMap.put("notice_id", "TEXT");
    localStringBuilder.append(" notice_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '1' ");
    localStringBuilder.append(" type INTEGER default '1' ");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("bulletin_scene"))
    {
      this.field_bulletin_scene = paramContentValues.getAsString("bulletin_scene");
      if (paramBoolean) {
        this.lhG = true;
      }
    }
    if (paramContentValues.containsKey("bulletin_content"))
    {
      this.field_bulletin_content = paramContentValues.getAsString("bulletin_content");
      if (paramBoolean) {
        this.lhH = true;
      }
    }
    if (paramContentValues.containsKey("bulletin_url"))
    {
      this.field_bulletin_url = paramContentValues.getAsString("bulletin_url");
      if (paramBoolean) {
        this.lhI = true;
      }
    }
    if (paramContentValues.containsKey("is_show_notice"))
    {
      this.field_is_show_notice = paramContentValues.getAsInteger("is_show_notice").intValue();
      if (paramBoolean) {
        this.lhJ = true;
      }
    }
    if (paramContentValues.containsKey("wording"))
    {
      this.field_wording = paramContentValues.getAsString("wording");
      if (paramBoolean) {
        this.kQY = true;
      }
    }
    if (paramContentValues.containsKey("left_icon"))
    {
      this.field_left_icon = paramContentValues.getAsString("left_icon");
      if (paramBoolean) {
        this.lhK = true;
      }
    }
    if (paramContentValues.containsKey("jump_url"))
    {
      this.field_jump_url = paramContentValues.getAsString("jump_url");
      if (paramBoolean) {
        this.lhL = true;
      }
    }
    if (paramContentValues.containsKey("notice_id"))
    {
      this.field_notice_id = paramContentValues.getAsString("notice_id");
      if (paramBoolean) {
        this.lhM = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
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
      if (lhN != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.lhG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lhO == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (lhP == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (lhQ == k) {
        this.field_is_show_notice = paramCursor.getInt(i);
      } else if (kRc == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (lhR == k) {
        this.field_left_icon = paramCursor.getString(i);
      } else if (lhS == k) {
        this.field_jump_url = paramCursor.getString(i);
      } else if (lhT == k) {
        this.field_notice_id = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lhG) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.lhH) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.lhI) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
    }
    if (this.lhJ) {
      localContentValues.put("is_show_notice", Integer.valueOf(this.field_is_show_notice));
    }
    if (this.kQY) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.lhK) {
      localContentValues.put("left_icon", this.field_left_icon);
    }
    if (this.lhL) {
      localContentValues.put("jump_url", this.field_jump_url);
    }
    if (this.lhM) {
      localContentValues.put("notice_id", this.field_notice_id);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
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
  
  public StorageObserverOwner<? extends ii> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_bulletin_scene;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ii
 * JD-Core Version:    0.7.0.1
 */