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

public abstract class fs
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OldAccountFriend");
  public static final Column USERNAME;
  public static final Column jJA;
  private static final int jJE;
  public static final Column jTk;
  private static final int jTs;
  public static final Column jYY;
  private static final int jZK;
  private static final int jZQ;
  public static final Column jZe;
  public static final Column kPF;
  public static final Column kPG;
  public static final Column kPH;
  public static final Column kPI;
  private static final int kPN;
  private static final int kPO;
  private static final int kPP;
  private static final int kPQ;
  private static final StorageObserverOwner<fs> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  private boolean jJC = true;
  private boolean jTo = true;
  private boolean jZr = true;
  private boolean jZx = true;
  private boolean kPJ = true;
  private boolean kPK = true;
  private boolean kPL = true;
  private boolean kPM = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jZe = new Column("encryptUsername", "string", TABLE.getName(), "");
    kPF = new Column("oldUsername", "string", TABLE.getName(), "");
    jJA = new Column("ticket", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kPG = new Column("addState", "int", TABLE.getName(), "");
    jYY = new Column("showHead", "int", TABLE.getName(), "");
    kPH = new Column("pinyinName", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kPI = new Column("seq", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jZQ = "encryptUsername".hashCode();
    kPN = "oldUsername".hashCode();
    jJE = "ticket".hashCode();
    jTs = "nickname".hashCode();
    kPO = "addState".hashCode();
    jZK = "showHead".hashCode();
    kPP = "pinyinName".hashCode();
    username_HASHCODE = "username".hashCode();
    kPQ = "seq".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT");
    localStringBuilder.append(" encryptUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "oldUsername";
    localMAutoDBInfo.colsMap.put("oldUsername", "TEXT");
    localStringBuilder.append(" oldUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "addState";
    localMAutoDBInfo.colsMap.put("addState", "INTEGER");
    localStringBuilder.append(" addState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "showHead";
    localMAutoDBInfo.colsMap.put("showHead", "INTEGER");
    localStringBuilder.append(" showHead INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "pinyinName";
    localMAutoDBInfo.colsMap.put("pinyinName", "TEXT");
    localStringBuilder.append(" pinyinName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "seq";
    localMAutoDBInfo.colsMap.put("seq", "INTEGER");
    localStringBuilder.append(" seq INTEGER");
    localMAutoDBInfo.columns[9] = "rowid";
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
    if (paramContentValues.containsKey("oldUsername"))
    {
      this.field_oldUsername = paramContentValues.getAsString("oldUsername");
      if (paramBoolean) {
        this.kPJ = true;
      }
    }
    if (paramContentValues.containsKey("ticket"))
    {
      this.field_ticket = paramContentValues.getAsString("ticket");
      if (paramBoolean) {
        this.jJC = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("addState"))
    {
      this.field_addState = paramContentValues.getAsInteger("addState").intValue();
      if (paramBoolean) {
        this.kPK = true;
      }
    }
    if (paramContentValues.containsKey("showHead"))
    {
      this.field_showHead = paramContentValues.getAsInteger("showHead").intValue();
      if (paramBoolean) {
        this.jZr = true;
      }
    }
    if (paramContentValues.containsKey("pinyinName"))
    {
      this.field_pinyinName = paramContentValues.getAsString("pinyinName");
      if (paramBoolean) {
        this.kPL = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("seq"))
    {
      this.field_seq = paramContentValues.getAsInteger("seq").intValue();
      if (paramBoolean) {
        this.kPM = true;
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
        break label60;
      }
      this.field_encryptUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kPN == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (jJE == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kPO == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (jZK == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (kPP == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (kPQ == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jZx) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.kPJ) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.jJC) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.kPK) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.jZr) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.kPL) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kPM) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
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
  
  public StorageObserverOwner<? extends fs> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fs
 * JD-Core Version:    0.7.0.1
 */