package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)" };
  private static final int eGR;
  private static final int eGY = "username".hashCode();
  private static final int eGZ = "updateTime".hashCode();
  private static final int eHT;
  private static final int eMi;
  private static final int eMy = "nickname".hashCode();
  private static final int eQF;
  private static final int eWO;
  private static final int eZR = "avatarUrl".hashCode();
  private static final int eZS;
  private static final int eZT;
  private static final int eZU;
  private static final int eZV;
  private static final int eZW;
  private static final int eZX;
  private static final int eZY;
  private static final int eZZ;
  private static final int faa = "retryCount".hashCode();
  private static final int fab = "originalEntranceFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGA = true;
  private boolean eGV = true;
  private boolean eGW = true;
  private boolean eHO = true;
  private boolean eLU = true;
  private boolean eMu = true;
  private boolean eQn = true;
  private boolean eWJ = true;
  private boolean eZG = true;
  private boolean eZH = true;
  private boolean eZI = true;
  private boolean eZJ = true;
  private boolean eZK = true;
  private boolean eZL = true;
  private boolean eZM = true;
  private boolean eZN = true;
  private boolean eZO = true;
  private boolean eZP = true;
  private boolean eZQ = true;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public String field_coverImg;
  public int field_extFlag;
  public amj field_extInfo;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public String field_nickname;
  public int field_originalEntranceFlag;
  public int field_originalFlag;
  public aqt field_originalInfo;
  public String field_pyInitial;
  public int field_retryCount;
  public String field_signature;
  public int field_spamStatus;
  public long field_updateTime;
  public String field_username;
  public long field_version;
  
  static
  {
    eHT = "version".hashCode();
    eZS = "firstPageMD5".hashCode();
    eGR = "signature".hashCode();
    eZT = "follow_Flag".hashCode();
    eQF = "pyInitial".hashCode();
    eZU = "followTime".hashCode();
    eZV = "coverImg".hashCode();
    eZW = "spamStatus".hashCode();
    eZX = "authInfo".hashCode();
    eMi = "extInfo".hashCode();
    eZY = "originalFlag".hashCode();
    eZZ = "originalInfo".hashCode();
    eWO = "extFlag".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "nickname";
    locala.IBN.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "avatarUrl";
    locala.IBN.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "version";
    locala.IBN.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "firstPageMD5";
    locala.IBN.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.IBN.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "follow_Flag";
    locala.IBN.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "pyInitial";
    locala.IBN.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "followTime";
    locala.IBN.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "coverImg";
    locala.IBN.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "spamStatus";
    locala.IBN.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "authInfo";
    locala.IBN.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "extInfo";
    locala.IBN.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "originalFlag";
    locala.IBN.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "originalInfo";
    locala.IBN.put("originalInfo", "BLOB");
    localStringBuilder.append(" originalInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "extFlag";
    locala.IBN.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.IBN.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "originalEntranceFlag";
    locala.IBN.put("originalEntranceFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalEntranceFlag INTEGER default '0' ");
    locala.columns[19] = "rowid";
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
      if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eZR == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (eHT == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (eZS == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (eGR == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eZT == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (eQF == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (eZU == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (eZV == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (eZW == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (eZX == k) {
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
          ae.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
        }
      } else if (eMi == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((amj)new amj().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (eZY == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (eZZ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((aqt)new aqt().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
      } else if (eWO == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (faa == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (fab == k) {
        this.field_originalEntranceFlag = paramCursor.getInt(i);
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
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.eZG) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.eHO) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.eZH) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.eGA) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eZI) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.eQn) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.eZJ) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.eZK) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.eZL) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.eZM) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.eLU) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.eZN) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.eZO) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
            if (this.eWJ) {
              localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
            }
            if (this.eGW) {
              localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
            }
            if (this.eZP) {
              localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
            }
            if (this.eZQ) {
              localContentValues.put("originalEntranceFlag", Integer.valueOf(this.field_originalEntranceFlag));
            }
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            ae.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          ae.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            ae.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
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