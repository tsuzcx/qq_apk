package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGG;
  private static final int eGH;
  private static final int eGI;
  private static final int eGJ;
  private static final int eGK;
  private static final int eGL;
  private static final int eGM;
  private static final int eGN = "originalFlag".hashCode();
  private static final int eGO = "originalInfo".hashCode();
  private static final int eoc;
  private static final int eok = "username".hashCode();
  private static final int epb;
  private static final int etG = "nickname".hashCode();
  private static final int etq;
  private static final int exv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGA = true;
  private boolean eGB = true;
  private boolean eGC = true;
  private boolean eGD = true;
  private boolean eGE = true;
  private boolean eGF = true;
  private boolean eGx = true;
  private boolean eGy = true;
  private boolean eGz = true;
  private boolean enL = true;
  private boolean eoW = true;
  private boolean eoh = true;
  private boolean etC = true;
  private boolean etc = true;
  private boolean exd = true;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public String field_coverImg;
  public aje field_extInfo;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public String field_nickname;
  public int field_originalFlag;
  public amt field_originalInfo;
  public String field_pyInitial;
  public String field_signature;
  public int field_spamStatus;
  public String field_username;
  public long field_version;
  
  static
  {
    eGG = "avatarUrl".hashCode();
    epb = "version".hashCode();
    eGH = "firstPageMD5".hashCode();
    eoc = "signature".hashCode();
    eGI = "follow_Flag".hashCode();
    exv = "pyInitial".hashCode();
    eGJ = "followTime".hashCode();
    eGK = "coverImg".hashCode();
    eGL = "spamStatus".hashCode();
    eGM = "authInfo".hashCode();
    etq = "extInfo".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "username";
    locala.columns[1] = "nickname";
    locala.GvH.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "avatarUrl";
    locala.GvH.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "version";
    locala.GvH.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "firstPageMD5";
    locala.GvH.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.GvH.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "follow_Flag";
    locala.GvH.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "pyInitial";
    locala.GvH.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "followTime";
    locala.GvH.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "coverImg";
    locala.GvH.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "spamStatus";
    locala.GvH.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "authInfo";
    locala.GvH.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "extInfo";
    locala.GvH.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "originalFlag";
    locala.GvH.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "originalInfo";
    locala.GvH.put("originalInfo", "BLOB");
    localStringBuilder.append(" originalInfo BLOB");
    locala.columns[15] = "rowid";
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
      if (eok != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eoh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eGG == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (epb == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (eGH == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (eoc == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eGI == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (exv == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (eGJ == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (eGK == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (eGL == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (eGM == k) {
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
          ac.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
        }
      } else if (etq == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((aje)new aje().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (eGN == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (eGO == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((amt)new amt().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ac.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
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
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.eGx) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.eoW) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.eGy) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.enL) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eGz) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.exd) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.eGA) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.eGB) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.eGC) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.eGD) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.etc) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.eGE) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.eGF) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            ac.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          ac.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            ac.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */