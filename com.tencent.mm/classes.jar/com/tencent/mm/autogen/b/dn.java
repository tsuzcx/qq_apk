package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dn
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameLifeContact");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column jTk;
  private static final int jTs;
  public static final Column kjX;
  private static final int kkr;
  public static final Column kna;
  private static final int kwN;
  private static final int kwO;
  private static final int kwP;
  public static final Column kwi;
  public static final Column kwj;
  public static final Column kyd;
  private static final int kyf;
  private static final StorageObserverOwner<dn> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public int field_accountType;
  public String field_avatarURL;
  public l field_jumpInfo;
  public String field_nickname;
  public int field_sex;
  public String field_tag;
  public long field_updateTime;
  public String field_username;
  private boolean jTo = true;
  private boolean kkh = true;
  private boolean kwx = true;
  private boolean kwy = true;
  private boolean kwz = true;
  private boolean kye = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kyd = new Column("accountType", "int", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kna = new Column("avatarURL", "string", TABLE.getName(), "");
    kwi = new Column("sex", "int", TABLE.getName(), "");
    kjX = new Column("tag", "string", TABLE.getName(), "");
    kwj = new Column("jumpInfo", "proto", TABLE.getName(), "com.tencent.mm.plugin.gamelife.autogen.JumpInfo");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    kyf = "accountType".hashCode();
    jTs = "nickname".hashCode();
    kwN = "avatarURL".hashCode();
    kwO = "sex".hashCode();
    kkr = "tag".hashCode();
    kwP = "jumpInfo".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "accountType";
    localMAutoDBInfo.colsMap.put("accountType", "INTEGER default '0' ");
    localStringBuilder.append(" accountType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "avatarURL";
    localMAutoDBInfo.colsMap.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER default '0' ");
    localStringBuilder.append(" sex INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT default '' ");
    localStringBuilder.append(" tag TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "jumpInfo";
    localMAutoDBInfo.colsMap.put("jumpInfo", "BLOB");
    localStringBuilder.append(" jumpInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("accountType"))
    {
      this.field_accountType = paramContentValues.getAsInteger("accountType").intValue();
      if (paramBoolean) {
        this.kye = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("avatarURL"))
    {
      this.field_avatarURL = paramContentValues.getAsString("avatarURL");
      if (paramBoolean) {
        this.kwx = true;
      }
    }
    if (paramContentValues.containsKey("sex"))
    {
      this.field_sex = paramContentValues.getAsInteger("sex").intValue();
      if (paramBoolean) {
        this.kwy = true;
      }
    }
    if (paramContentValues.containsKey("tag"))
    {
      this.field_tag = paramContentValues.getAsString("tag");
      if (paramBoolean) {
        this.kkh = true;
      }
    }
    if (paramContentValues.containsKey("jumpInfo")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("jumpInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_jumpInfo = ((l)new l().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kwz = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kyf == k) {
        this.field_accountType = paramCursor.getInt(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kwN == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (kwO == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (kkr == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (kwP == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_jumpInfo = ((l)new l().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
        }
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
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kye) {
      localContentValues.put("accountType", Integer.valueOf(this.field_accountType));
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.kwx) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.kwy) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.kkh) {
      localContentValues.put("tag", this.field_tag);
    }
    if ((this.kwz) && (this.field_jumpInfo != null)) {}
    try
    {
      localContentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
      if (this.__hadSetupdateTime) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends dn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dn
 * JD-Core Version:    0.7.0.1
 */