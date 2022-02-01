package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eGZ = "updateTime".hashCode();
  private static final int eMy;
  private static final int eXZ;
  private static final int fek = "accountType".hashCode();
  private static final int fel;
  private static final int fem;
  private static final int fen;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eGW = true;
  private boolean eMu = true;
  private boolean eXP = true;
  private boolean feg = true;
  private boolean feh = true;
  private boolean fei = true;
  private boolean fej = true;
  public int field_accountType;
  public String field_avatarURL;
  public l field_jumpInfo;
  public String field_nickname;
  public int field_sex;
  public String field_tag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eMy = "nickname".hashCode();
    fel = "avatarURL".hashCode();
    fem = "sex".hashCode();
    eXZ = "tag".hashCode();
    fen = "jumpInfo".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "accountType";
    locala.IBN.put("accountType", "INTEGER default '0' ");
    localStringBuilder.append(" accountType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.IBN.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "avatarURL";
    locala.IBN.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "sex";
    locala.IBN.put("sex", "INTEGER default '0' ");
    localStringBuilder.append(" sex INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "tag";
    locala.IBN.put("tag", "TEXT default '' ");
    localStringBuilder.append(" tag TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "jumpInfo";
    locala.IBN.put("jumpInfo", "BLOB");
    localStringBuilder.append(" jumpInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fek == k) {
        this.field_accountType = paramCursor.getInt(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fel == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (fem == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (eXZ == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (fen == k) {
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
          ae.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
        }
      } else if (eGZ == k) {
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
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.feg) {
      localContentValues.put("accountType", Integer.valueOf(this.field_accountType));
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.feh) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.fei) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.eXP) {
      localContentValues.put("tag", this.field_tag);
    }
    if ((this.fej) && (this.field_jumpInfo != null)) {}
    try
    {
      localContentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
      if (this.eGW) {
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
        ae.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cu
 * JD-Core Version:    0.7.0.1
 */