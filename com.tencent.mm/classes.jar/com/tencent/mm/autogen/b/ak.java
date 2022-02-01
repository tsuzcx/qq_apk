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

public abstract class ak
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizChatUserInfo");
  public static final Column USERNAME;
  public static final Column jPG;
  public static final Column jQA;
  public static final Column jQE;
  public static final Column jQF;
  public static final Column jQJ;
  private static final int jQk;
  private static final int jRa;
  private static final int jRe;
  private static final int jRf;
  private static final int jRj;
  public static final Column jRl;
  private static final int jRn;
  public static final Column jRo;
  public static final Column jRp;
  public static final Column jRq;
  private static final int jRu;
  private static final int jRv;
  private static final int jRw;
  private static final StorageObserverOwner<ak> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public int field_UserVersion;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public String field_brandUserName;
  public String field_headImageUrl;
  public boolean field_needToUpdate;
  public String field_profileUrl;
  public String field_userId;
  public String field_userName;
  public String field_userNamePY;
  private boolean jPV = true;
  private boolean jQN = true;
  private boolean jQR = true;
  private boolean jQS = true;
  private boolean jQW = true;
  private boolean jRm = true;
  private boolean jRr = true;
  private boolean jRs = true;
  private boolean jRt = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jRl = new Column("userId", "string", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    jRo = new Column("userNamePY", "string", TABLE.getName(), "");
    jPG = new Column("brandUserName", "string", TABLE.getName(), "");
    jRp = new Column("UserVersion", "int", TABLE.getName(), "");
    jQE = new Column("needToUpdate", "boolean", TABLE.getName(), "");
    jQA = new Column("headImageUrl", "string", TABLE.getName(), "");
    jRq = new Column("profileUrl", "string", TABLE.getName(), "");
    jQF = new Column("bitFlag", "int", TABLE.getName(), "");
    jQJ = new Column("addMemberUrl", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jRn = "userId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    jRu = "userNamePY".hashCode();
    jQk = "brandUserName".hashCode();
    jRv = "UserVersion".hashCode();
    jRe = "needToUpdate".hashCode();
    jRa = "headImageUrl".hashCode();
    jRw = "profileUrl".hashCode();
    jRf = "bitFlag".hashCode();
    jRj = "addMemberUrl".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userId";
    localMAutoDBInfo.colsMap.put("userId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userId";
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userNamePY";
    localMAutoDBInfo.colsMap.put("userNamePY", "TEXT default '' ");
    localStringBuilder.append(" userNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "UserVersion";
    localMAutoDBInfo.colsMap.put("UserVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" UserVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "needToUpdate";
    localMAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "headImageUrl";
    localMAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "profileUrl";
    localMAutoDBInfo.colsMap.put("profileUrl", "TEXT");
    localStringBuilder.append(" profileUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "addMemberUrl";
    localMAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("userId"))
    {
      this.field_userId = paramContentValues.getAsString("userId");
      if (paramBoolean) {
        this.jRm = true;
      }
    }
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("userNamePY"))
    {
      this.field_userNamePY = paramContentValues.getAsString("userNamePY");
      if (paramBoolean) {
        this.jRr = true;
      }
    }
    if (paramContentValues.containsKey("brandUserName"))
    {
      this.field_brandUserName = paramContentValues.getAsString("brandUserName");
      if (paramBoolean) {
        this.jPV = true;
      }
    }
    if (paramContentValues.containsKey("UserVersion"))
    {
      this.field_UserVersion = paramContentValues.getAsInteger("UserVersion").intValue();
      if (paramBoolean) {
        this.jRs = true;
      }
    }
    if (paramContentValues.containsKey("needToUpdate")) {
      if (paramContentValues.getAsInteger("needToUpdate").intValue() == 0) {
        break label318;
      }
    }
    label318:
    for (boolean bool = true;; bool = false)
    {
      this.field_needToUpdate = bool;
      if (paramBoolean) {
        this.jQR = true;
      }
      if (paramContentValues.containsKey("headImageUrl"))
      {
        this.field_headImageUrl = paramContentValues.getAsString("headImageUrl");
        if (paramBoolean) {
          this.jQN = true;
        }
      }
      if (paramContentValues.containsKey("profileUrl"))
      {
        this.field_profileUrl = paramContentValues.getAsString("profileUrl");
        if (paramBoolean) {
          this.jRt = true;
        }
      }
      if (paramContentValues.containsKey("bitFlag"))
      {
        this.field_bitFlag = paramContentValues.getAsInteger("bitFlag").intValue();
        if (paramBoolean) {
          this.jQS = true;
        }
      }
      if (paramContentValues.containsKey("addMemberUrl"))
      {
        this.field_addMemberUrl = paramContentValues.getAsString("addMemberUrl");
        if (paramBoolean) {
          this.jQW = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (jRn != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.jRm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (userName_HASHCODE == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (jRu == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (jQk == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (jRv == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (jRe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (jRa == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (jRw == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (jRf == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (jRj == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jRm) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.jRr) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.jPV) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.jRs) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.jQR) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.jQN) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.jRt) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.jQS) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.jQW) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
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
  
  public StorageObserverOwner<? extends ak> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_userId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ak
 * JD-Core Version:    0.7.0.1
 */