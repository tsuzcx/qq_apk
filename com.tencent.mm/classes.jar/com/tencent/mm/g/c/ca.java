package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ca
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEk;
  private static final int eEl;
  private static final int eEm;
  private static final int eEn = "followTime".hashCode();
  private static final int eEo = "coverImg".hashCode();
  private static final int eEp = "spamStatus".hashCode();
  private static final int eEq = "authInfo".hashCode();
  private static final int elX;
  private static final int emV;
  private static final int eme = "username".hashCode();
  private static final int erC = "nickname".hashCode();
  private static final int erm = "extInfo".hashCode();
  private static final int euZ;
  private static final int qnw = "originalFlag".hashCode();
  private static final int qnx = "originalInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEd = true;
  private boolean eEe = true;
  private boolean eEf = true;
  private boolean eEg = true;
  private boolean eEh = true;
  private boolean eEi = true;
  private boolean eEj = true;
  private boolean elG = true;
  private boolean emQ = true;
  private boolean emb = true;
  private boolean eqY = true;
  private boolean ery = true;
  private boolean euH = true;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public String field_coverImg;
  public ahz field_extInfo;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public String field_nickname;
  public int field_originalFlag;
  public dzn field_originalInfo;
  public String field_pyInitial;
  public String field_signature;
  public int field_spamStatus;
  public String field_username;
  public long field_version;
  private boolean qnu = true;
  private boolean qnv = true;
  
  static
  {
    eEk = "avatarUrl".hashCode();
    emV = "version".hashCode();
    eEl = "firstPageMD5".hashCode();
    elX = "signature".hashCode();
    eEm = "follow_Flag".hashCode();
    euZ = "pyInitial".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.EYv.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "username";
    locala.columns[1] = "nickname";
    locala.EYv.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "avatarUrl";
    locala.EYv.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "version";
    locala.EYv.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "firstPageMD5";
    locala.EYv.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.EYv.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "follow_Flag";
    locala.EYv.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "pyInitial";
    locala.EYv.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "followTime";
    locala.EYv.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "coverImg";
    locala.EYv.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "spamStatus";
    locala.EYv.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "authInfo";
    locala.EYv.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "extInfo";
    locala.EYv.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "originalFlag";
    locala.EYv.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "originalInfo";
    locala.EYv.put("originalInfo", "BLOB");
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eEk == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (emV == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (eEl == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (elX == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (euZ == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (eEn == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (eEo == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (eEp == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (eEq == k) {
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
      } else if (erm == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((ahz)new ahz().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (qnw == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (qnx == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((dzn)new dzn().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
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
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.eEd) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.emQ) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.eEe) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.elG) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eEf) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.euH) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.eEg) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.eEh) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.eEi) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.eEj) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.eqY) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.qnu) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.qnv) || (this.field_originalInfo == null)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ca
 * JD-Core Version:    0.7.0.1
 */