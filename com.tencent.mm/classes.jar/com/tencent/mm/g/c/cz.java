package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cz
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBC;
  private static final int fID;
  private static final int fIE;
  private static final int fIF;
  private static final int fIG;
  private static final int fqf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  private boolean fBs = true;
  private boolean fIA = true;
  private boolean fIB = true;
  private boolean fIC = true;
  private boolean fIz = true;
  public int field_accountType;
  public String field_avatarURL;
  public l field_jumpInfo;
  public String field_nickname;
  public int field_sex;
  public String field_tag;
  public long field_updateTime;
  public String field_username;
  private boolean fqb = true;
  
  static
  {
    fID = "accountType".hashCode();
    fqf = "nickname".hashCode();
    fIE = "avatarURL".hashCode();
    fIF = "sex".hashCode();
    fBC = "tag".hashCode();
    fIG = "jumpInfo".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fID == k) {
        this.field_accountType = paramCursor.getInt(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fIE == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (fIF == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (fBC == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (fIG == k) {
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
    if (this.fIz) {
      localContentValues.put("accountType", Integer.valueOf(this.field_accountType));
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.fIA) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.fIB) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.fBs) {
      localContentValues.put("tag", this.field_tag);
    }
    if ((this.fIC) && (this.field_jumpInfo != null)) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cz
 * JD-Core Version:    0.7.0.1
 */