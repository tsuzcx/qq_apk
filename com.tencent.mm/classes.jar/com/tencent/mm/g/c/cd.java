package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)" };
  private static final int eFi;
  private static final int eFp = "username".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eGk;
  private static final int eKP = "nickname".hashCode();
  private static final int eKz;
  private static final int eOU;
  private static final int eVd;
  private static final int eYf = "avatarUrl".hashCode();
  private static final int eYg;
  private static final int eYh;
  private static final int eYi;
  private static final int eYj;
  private static final int eYk;
  private static final int eYl;
  private static final int eYm;
  private static final int eYn;
  private static final int eYo = "retryCount".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eER = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eGf = true;
  private boolean eKL = true;
  private boolean eKl = true;
  private boolean eOC = true;
  private boolean eUY = true;
  private boolean eXV = true;
  private boolean eXW = true;
  private boolean eXX = true;
  private boolean eXY = true;
  private boolean eXZ = true;
  private boolean eYa = true;
  private boolean eYb = true;
  private boolean eYc = true;
  private boolean eYd = true;
  private boolean eYe = true;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public String field_coverImg;
  public int field_extFlag;
  public alx field_extInfo;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public String field_nickname;
  public int field_originalFlag;
  public aqe field_originalInfo;
  public String field_pyInitial;
  public int field_retryCount;
  public String field_signature;
  public int field_spamStatus;
  public long field_updateTime;
  public String field_username;
  public long field_version;
  
  static
  {
    eGk = "version".hashCode();
    eYg = "firstPageMD5".hashCode();
    eFi = "signature".hashCode();
    eYh = "follow_Flag".hashCode();
    eOU = "pyInitial".hashCode();
    eYi = "followTime".hashCode();
    eYj = "coverImg".hashCode();
    eYk = "spamStatus".hashCode();
    eYl = "authInfo".hashCode();
    eKz = "extInfo".hashCode();
    eYm = "originalFlag".hashCode();
    eYn = "originalInfo".hashCode();
    eVd = "extFlag".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "nickname";
    locala.IhC.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "avatarUrl";
    locala.IhC.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "version";
    locala.IhC.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "firstPageMD5";
    locala.IhC.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.IhC.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "follow_Flag";
    locala.IhC.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "pyInitial";
    locala.IhC.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "followTime";
    locala.IhC.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "coverImg";
    locala.IhC.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "spamStatus";
    locala.IhC.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "authInfo";
    locala.IhC.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "extInfo";
    locala.IhC.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "originalFlag";
    locala.IhC.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "originalInfo";
    locala.IhC.put("originalInfo", "BLOB");
    localStringBuilder.append(" originalInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "extFlag";
    locala.IhC.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.IhC.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    locala.columns[18] = "rowid";
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
      if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eYf == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (eGk == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (eYg == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (eFi == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eYh == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (eOU == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (eYi == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (eYj == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (eYk == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (eYl == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_authInfo = ((FinderAuthInfo)new FinderAuthInfo().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
        }
      } else if (eKz == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((alx)new alx().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (eYm == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (eYn == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((aqe)new aqe().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
      } else if (eVd == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eYo == k) {
        this.field_retryCount = paramCursor.getInt(i);
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
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.eXV) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.eGf) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.eXW) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.eER) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eXX) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.eOC) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.eXY) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.eXZ) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.eYa) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.eYb) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.eKl) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.eYc) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.eYd) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
            if (this.eUY) {
              localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
            }
            if (this.eFn) {
              localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
            }
            if (this.eYe) {
              localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
            }
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            ad.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            ad.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cd
 * JD-Core Version:    0.7.0.1
 */