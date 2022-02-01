package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp = "username".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eKP;
  private static final int eWo;
  private static final int fcv = "accountType".hashCode();
  private static final int fcw;
  private static final int fcx;
  private static final int fcy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eKL = true;
  private boolean eWe = true;
  private boolean fcr = true;
  private boolean fcs = true;
  private boolean fct = true;
  private boolean fcu = true;
  public int field_accountType;
  public String field_avatarURL;
  public k field_jumpInfo;
  public String field_nickname;
  public int field_sex;
  public String field_tag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eKP = "nickname".hashCode();
    fcw = "avatarURL".hashCode();
    fcx = "sex".hashCode();
    eWo = "tag".hashCode();
    fcy = "jumpInfo".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "accountType";
    locala.IhC.put("accountType", "INTEGER default '0' ");
    localStringBuilder.append(" accountType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.IhC.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "avatarURL";
    locala.IhC.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "sex";
    locala.IhC.put("sex", "INTEGER default '0' ");
    localStringBuilder.append(" sex INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "tag";
    locala.IhC.put("tag", "TEXT default '' ");
    localStringBuilder.append(" tag TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "jumpInfo";
    locala.IhC.put("jumpInfo", "BLOB");
    localStringBuilder.append(" jumpInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fcv == k) {
        this.field_accountType = paramCursor.getInt(i);
      } else if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fcw == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (fcx == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (eWo == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (fcy == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_jumpInfo = ((k)new k().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
        }
      } else if (eFq == k) {
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
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fcr) {
      localContentValues.put("accountType", Integer.valueOf(this.field_accountType));
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.fcs) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.fct) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.eWe) {
      localContentValues.put("tag", this.field_tag);
    }
    if ((this.fcu) && (this.field_jumpInfo != null)) {}
    try
    {
      localContentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
      if (this.eFn) {
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
        ad.e("MicroMsg.SDK.BaseGameLifeContact", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cu
 * JD-Core Version:    0.7.0.1
 */