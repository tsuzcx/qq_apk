package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dd
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameLifeContact");
  public static final Column hMT;
  private static final int hNn;
  public static final Column hPQ;
  public static final Column hWW;
  public static final Column hWX;
  private static final int hXB;
  private static final int hXC;
  private static final int hXD;
  public static final Column hYS;
  private static final int hYU;
  private static final int hwF;
  public static final Column hwx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hNd = true;
  private boolean hXl = true;
  private boolean hXm = true;
  private boolean hXn = true;
  private boolean hYT = true;
  private boolean hwB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameLifeContact", "");
    C_USERNAME = new Column("username", "string", "GameLifeContact", "");
    hYS = new Column("accounttype", "int", "GameLifeContact", "");
    hwx = new Column("nickname", "string", "GameLifeContact", "");
    hPQ = new Column("avatarurl", "string", "GameLifeContact", "");
    hWW = new Column("sex", "int", "GameLifeContact", "");
    hMT = new Column("tag", "string", "GameLifeContact", "");
    hWX = new Column("jumpinfo", "proto", "GameLifeContact", "com.tencent.mm.plugin.gamelife.autogen.JumpInfo");
    C_UPDATETIME = new Column("updatetime", "long", "GameLifeContact", "");
    username_HASHCODE = "username".hashCode();
    hYU = "accountType".hashCode();
    hwF = "nickname".hashCode();
    hXB = "avatarURL".hashCode();
    hXC = "sex".hashCode();
    hNn = "tag".hashCode();
    hXD = "jumpInfo".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    return localMAutoDBInfo;
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
      if (hYU == k) {
        this.field_accountType = paramCursor.getInt(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (hXB == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (hXC == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (hNn == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (hXD == k) {
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
    if (this.hYT) {
      localContentValues.put("accountType", Integer.valueOf(this.field_accountType));
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.hXl) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.hXm) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.hNd) {
      localContentValues.put("tag", this.field_tag);
    }
    if ((this.hXn) && (this.field_jumpInfo != null)) {}
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GameLifeContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dd
 * JD-Core Version:    0.7.0.1
 */