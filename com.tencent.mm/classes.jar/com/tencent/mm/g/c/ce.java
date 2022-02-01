package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ce
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)" };
  private static final int fAt;
  private static final int fDB;
  private static final int fDC;
  private static final int fDD;
  private static final int fDE;
  private static final int fDF;
  private static final int fDG;
  private static final int fDH;
  private static final int fDI;
  private static final int fDJ;
  private static final int fDK = "retryCount".hashCode();
  private static final int fDL = "originalEntranceFlag".hashCode();
  private static final int fDM = "liveCoverImg".hashCode();
  private static final int fDN = "liveStatus".hashCode();
  private static final int fDO = "liveAnchorStatusFlag".hashCode();
  private static final int fDP = "friendFollowCount".hashCode();
  private static final int fDQ = "liveSwitchFlag".hashCode();
  private static final int fkx;
  private static final int flv;
  private static final int fpP;
  private static final int fqf;
  private static final int fuk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  private boolean fAo = true;
  private boolean fDA = true;
  private boolean fDl = true;
  private boolean fDm = true;
  private boolean fDn = true;
  private boolean fDo = true;
  private boolean fDp = true;
  private boolean fDq = true;
  private boolean fDr = true;
  private boolean fDs = true;
  private boolean fDt = true;
  private boolean fDu = true;
  private boolean fDv = true;
  private boolean fDw = true;
  private boolean fDx = true;
  private boolean fDy = true;
  private boolean fDz = true;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public String field_coverImg;
  public int field_extFlag;
  public app field_extInfo;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public int field_friendFollowCount;
  public long field_liveAnchorStatusFlag;
  public String field_liveCoverImg;
  public int field_liveStatus;
  public long field_liveSwitchFlag;
  public String field_nickname;
  public int field_originalEntranceFlag;
  public int field_originalFlag;
  public bac field_originalInfo;
  public String field_pyInitial;
  public int field_retryCount;
  public String field_signature;
  public int field_spamStatus;
  public long field_updateTime;
  public String field_username;
  public long field_version;
  private boolean fkg = true;
  private boolean flq = true;
  private boolean fpB = true;
  private boolean fqb = true;
  private boolean ftS = true;
  
  static
  {
    fqf = "nickname".hashCode();
    fDB = "avatarUrl".hashCode();
    flv = "version".hashCode();
    fDC = "firstPageMD5".hashCode();
    fkx = "signature".hashCode();
    fDD = "follow_Flag".hashCode();
    fuk = "pyInitial".hashCode();
    fDE = "followTime".hashCode();
    fDF = "coverImg".hashCode();
    fDG = "spamStatus".hashCode();
    fDH = "authInfo".hashCode();
    fpP = "extInfo".hashCode();
    fDI = "originalFlag".hashCode();
    fDJ = "originalInfo".hashCode();
    fAt = "extFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[24];
    localMAutoDBInfo.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "avatarUrl";
    localMAutoDBInfo.colsMap.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "version";
    localMAutoDBInfo.colsMap.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "firstPageMD5";
    localMAutoDBInfo.colsMap.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "follow_Flag";
    localMAutoDBInfo.colsMap.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "pyInitial";
    localMAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "followTime";
    localMAutoDBInfo.colsMap.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "coverImg";
    localMAutoDBInfo.colsMap.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "spamStatus";
    localMAutoDBInfo.colsMap.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "authInfo";
    localMAutoDBInfo.colsMap.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "originalFlag";
    localMAutoDBInfo.colsMap.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "originalInfo";
    localMAutoDBInfo.colsMap.put("originalInfo", "BLOB");
    localStringBuilder.append(" originalInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "extFlag";
    localMAutoDBInfo.colsMap.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "originalEntranceFlag";
    localMAutoDBInfo.colsMap.put("originalEntranceFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalEntranceFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "liveCoverImg";
    localMAutoDBInfo.colsMap.put("liveCoverImg", "TEXT default '' ");
    localStringBuilder.append(" liveCoverImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "liveStatus";
    localMAutoDBInfo.colsMap.put("liveStatus", "INTEGER default '0' ");
    localStringBuilder.append(" liveStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "liveAnchorStatusFlag";
    localMAutoDBInfo.colsMap.put("liveAnchorStatusFlag", "LONG default '0' ");
    localStringBuilder.append(" liveAnchorStatusFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "friendFollowCount";
    localMAutoDBInfo.colsMap.put("friendFollowCount", "INTEGER default '0' ");
    localStringBuilder.append(" friendFollowCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "liveSwitchFlag";
    localMAutoDBInfo.colsMap.put("liveSwitchFlag", "LONG default '0' ");
    localStringBuilder.append(" liveSwitchFlag LONG default '0' ");
    localMAutoDBInfo.columns[24] = "rowid";
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
      if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fDB == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (flv == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (fDC == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (fkx == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fDD == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (fuk == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (fDE == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (fDF == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (fDG == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (fDH == k) {
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
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
        }
      } else if (fpP == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((app)new app().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (fDI == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (fDJ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((bac)new bac().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
      } else if (fAt == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fDK == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (fDL == k) {
        this.field_originalEntranceFlag = paramCursor.getInt(i);
      } else if (fDM == k) {
        this.field_liveCoverImg = paramCursor.getString(i);
      } else if (fDN == k) {
        this.field_liveStatus = paramCursor.getInt(i);
      } else if (fDO == k) {
        this.field_liveAnchorStatusFlag = paramCursor.getLong(i);
      } else if (fDP == k) {
        this.field_friendFollowCount = paramCursor.getInt(i);
      } else if (fDQ == k) {
        this.field_liveSwitchFlag = paramCursor.getLong(i);
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
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.fDl) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.flq) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.fDm) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.fkg) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fDn) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.ftS) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.fDo) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.fDp) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.fDq) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.fDr) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.fpB) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.fDs) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.fDt) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
            if (this.fAo) {
              localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
            }
            if (this.__hadSetupdateTime) {
              localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
            }
            if (this.fDu) {
              localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
            }
            if (this.fDv) {
              localContentValues.put("originalEntranceFlag", Integer.valueOf(this.field_originalEntranceFlag));
            }
            if (this.field_liveCoverImg == null) {
              this.field_liveCoverImg = "";
            }
            if (this.fDw) {
              localContentValues.put("liveCoverImg", this.field_liveCoverImg);
            }
            if (this.fDx) {
              localContentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
            }
            if (this.fDy) {
              localContentValues.put("liveAnchorStatusFlag", Long.valueOf(this.field_liveAnchorStatusFlag));
            }
            if (this.fDz) {
              localContentValues.put("friendFollowCount", Integer.valueOf(this.field_friendFollowCount));
            }
            if (this.fDA) {
              localContentValues.put("liveSwitchFlag", Long.valueOf(this.field_liveSwitchFlag));
            }
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            Log.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ce
 * JD-Core Version:    0.7.0.1
 */