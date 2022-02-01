package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hl
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsExt");
  public static final Column USERNAME;
  private static final int kZA;
  public static final Column kZN;
  public static final Column kZO;
  public static final Column kZP;
  public static final Column kZQ;
  public static final Column kZR;
  public static final Column kZS;
  public static final Column kZT;
  public static final Column kZU;
  public static final Column kZV;
  public static final Column kZW;
  public static final Column kZX;
  public static final Column kZY;
  public static final Column kZZ;
  public static final Column kZg;
  public static final Column kea;
  private static final int kfD;
  private static final int laB;
  private static final int laC;
  private static final int laD;
  private static final int laE;
  private static final int laF;
  private static final int laG;
  private static final int laH;
  private static final int laI;
  private static final int laJ;
  private static final int laK;
  private static final int laL;
  private static final int laM;
  private static final int laN;
  private static final int laO;
  private static final int laP;
  private static final int laQ;
  private static final int laR;
  private static final int laS;
  private static final int laT;
  public static final Column laa;
  public static final Column lab;
  public static final Column lad;
  public static final Column lae;
  public static final Column laf;
  public static final Column lag;
  private static final StorageObserverOwner<hl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public byte[] field_adsession;
  public String field_albumMd5;
  public String field_bgId;
  public String field_bgUrl;
  public byte[] field_faultS;
  public int field_iFlag;
  public int field_icount;
  public String field_imBGaeskey;
  public String field_imBGauthkey;
  public String field_imBGfileid;
  public String field_imBGmd5sum;
  public int field_istyle;
  public int field_lastFirstPageRequestErrCode;
  public int field_lastFirstPageRequestErrType;
  public int field_local_flag;
  public String field_md5;
  public String field_newerIds;
  public String field_older_bgId;
  public long field_snsBgId;
  public byte[] field_snsYearMonthInfo;
  public byte[] field_snsuser;
  public String field_userName;
  private boolean kZq = true;
  private boolean keP = true;
  private boolean laA = true;
  private boolean lah = true;
  private boolean lai = true;
  private boolean laj = true;
  private boolean lak = true;
  private boolean lal = true;
  private boolean lam = true;
  private boolean lan = true;
  private boolean lao = true;
  private boolean lap = true;
  private boolean laq = true;
  private boolean lar = true;
  private boolean las = true;
  private boolean lau = true;
  private boolean lav = true;
  private boolean law = true;
  private boolean lax = true;
  private boolean lay = true;
  private boolean laz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    kZN = new Column("newerIds", "string", TABLE.getName(), "");
    kZO = new Column("bgId", "string", TABLE.getName(), "");
    kZP = new Column("bgUrl", "string", TABLE.getName(), "");
    kZQ = new Column("older_bgId", "string", TABLE.getName(), "");
    kZR = new Column("local_flag", "int", TABLE.getName(), "");
    kZS = new Column("istyle", "int", TABLE.getName(), "");
    kZT = new Column("iFlag", "int", TABLE.getName(), "");
    kZU = new Column("icount", "int", TABLE.getName(), "");
    kZV = new Column("faultS", "byte[]", TABLE.getName(), "");
    kZg = new Column("snsBgId", "long", TABLE.getName(), "");
    kZW = new Column("snsuser", "byte[]", TABLE.getName(), "");
    kZX = new Column("adsession", "byte[]", TABLE.getName(), "");
    kZY = new Column("lastFirstPageRequestErrCode", "int", TABLE.getName(), "");
    kZZ = new Column("lastFirstPageRequestErrType", "int", TABLE.getName(), "");
    laa = new Column("snsYearMonthInfo", "byte[]", TABLE.getName(), "");
    lab = new Column("albumMd5", "string", TABLE.getName(), "");
    lad = new Column("imBGaeskey", "string", TABLE.getName(), "");
    lae = new Column("imBGauthkey", "string", TABLE.getName(), "");
    laf = new Column("imBGmd5sum", "string", TABLE.getName(), "");
    lag = new Column("imBGfileid", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    kfD = "md5".hashCode();
    laB = "newerIds".hashCode();
    laC = "bgId".hashCode();
    laD = "bgUrl".hashCode();
    laE = "older_bgId".hashCode();
    laF = "local_flag".hashCode();
    laG = "istyle".hashCode();
    laH = "iFlag".hashCode();
    laI = "icount".hashCode();
    laJ = "faultS".hashCode();
    kZA = "snsBgId".hashCode();
    laK = "snsuser".hashCode();
    laL = "adsession".hashCode();
    laM = "lastFirstPageRequestErrCode".hashCode();
    laN = "lastFirstPageRequestErrType".hashCode();
    laO = "snsYearMonthInfo".hashCode();
    laP = "albumMd5".hashCode();
    laQ = "imBGaeskey".hashCode();
    laR = "imBGauthkey".hashCode();
    laS = "imBGmd5sum".hashCode();
    laT = "imBGfileid".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "newerIds";
    localMAutoDBInfo.colsMap.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "bgId";
    localMAutoDBInfo.colsMap.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "bgUrl";
    localMAutoDBInfo.colsMap.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "older_bgId";
    localMAutoDBInfo.colsMap.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "local_flag";
    localMAutoDBInfo.colsMap.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "istyle";
    localMAutoDBInfo.colsMap.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "iFlag";
    localMAutoDBInfo.colsMap.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "icount";
    localMAutoDBInfo.colsMap.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "faultS";
    localMAutoDBInfo.colsMap.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "snsBgId";
    localMAutoDBInfo.colsMap.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "snsuser";
    localMAutoDBInfo.colsMap.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "adsession";
    localMAutoDBInfo.colsMap.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "lastFirstPageRequestErrCode";
    localMAutoDBInfo.colsMap.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lastFirstPageRequestErrType";
    localMAutoDBInfo.colsMap.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "snsYearMonthInfo";
    localMAutoDBInfo.colsMap.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "albumMd5";
    localMAutoDBInfo.colsMap.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "imBGaeskey";
    localMAutoDBInfo.colsMap.put("imBGaeskey", "TEXT");
    localStringBuilder.append(" imBGaeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "imBGauthkey";
    localMAutoDBInfo.colsMap.put("imBGauthkey", "TEXT");
    localStringBuilder.append(" imBGauthkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "imBGmd5sum";
    localMAutoDBInfo.colsMap.put("imBGmd5sum", "TEXT");
    localStringBuilder.append(" imBGmd5sum TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "imBGfileid";
    localMAutoDBInfo.colsMap.put("imBGfileid", "TEXT");
    localStringBuilder.append(" imBGfileid TEXT");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("newerIds"))
    {
      this.field_newerIds = paramContentValues.getAsString("newerIds");
      if (paramBoolean) {
        this.lah = true;
      }
    }
    if (paramContentValues.containsKey("bgId"))
    {
      this.field_bgId = paramContentValues.getAsString("bgId");
      if (paramBoolean) {
        this.lai = true;
      }
    }
    if (paramContentValues.containsKey("bgUrl"))
    {
      this.field_bgUrl = paramContentValues.getAsString("bgUrl");
      if (paramBoolean) {
        this.laj = true;
      }
    }
    if (paramContentValues.containsKey("older_bgId"))
    {
      this.field_older_bgId = paramContentValues.getAsString("older_bgId");
      if (paramBoolean) {
        this.lak = true;
      }
    }
    if (paramContentValues.containsKey("local_flag"))
    {
      this.field_local_flag = paramContentValues.getAsInteger("local_flag").intValue();
      if (paramBoolean) {
        this.lal = true;
      }
    }
    if (paramContentValues.containsKey("istyle"))
    {
      this.field_istyle = paramContentValues.getAsInteger("istyle").intValue();
      if (paramBoolean) {
        this.lam = true;
      }
    }
    if (paramContentValues.containsKey("iFlag"))
    {
      this.field_iFlag = paramContentValues.getAsInteger("iFlag").intValue();
      if (paramBoolean) {
        this.lan = true;
      }
    }
    if (paramContentValues.containsKey("icount"))
    {
      this.field_icount = paramContentValues.getAsInteger("icount").intValue();
      if (paramBoolean) {
        this.lao = true;
      }
    }
    if (paramContentValues.containsKey("faultS"))
    {
      this.field_faultS = paramContentValues.getAsByteArray("faultS");
      if (paramBoolean) {
        this.lap = true;
      }
    }
    if (paramContentValues.containsKey("snsBgId"))
    {
      this.field_snsBgId = paramContentValues.getAsLong("snsBgId").longValue();
      if (paramBoolean) {
        this.kZq = true;
      }
    }
    if (paramContentValues.containsKey("snsuser"))
    {
      this.field_snsuser = paramContentValues.getAsByteArray("snsuser");
      if (paramBoolean) {
        this.laq = true;
      }
    }
    if (paramContentValues.containsKey("adsession"))
    {
      this.field_adsession = paramContentValues.getAsByteArray("adsession");
      if (paramBoolean) {
        this.lar = true;
      }
    }
    if (paramContentValues.containsKey("lastFirstPageRequestErrCode"))
    {
      this.field_lastFirstPageRequestErrCode = paramContentValues.getAsInteger("lastFirstPageRequestErrCode").intValue();
      if (paramBoolean) {
        this.las = true;
      }
    }
    if (paramContentValues.containsKey("lastFirstPageRequestErrType"))
    {
      this.field_lastFirstPageRequestErrType = paramContentValues.getAsInteger("lastFirstPageRequestErrType").intValue();
      if (paramBoolean) {
        this.lau = true;
      }
    }
    if (paramContentValues.containsKey("snsYearMonthInfo"))
    {
      this.field_snsYearMonthInfo = paramContentValues.getAsByteArray("snsYearMonthInfo");
      if (paramBoolean) {
        this.lav = true;
      }
    }
    if (paramContentValues.containsKey("albumMd5"))
    {
      this.field_albumMd5 = paramContentValues.getAsString("albumMd5");
      if (paramBoolean) {
        this.law = true;
      }
    }
    if (paramContentValues.containsKey("imBGaeskey"))
    {
      this.field_imBGaeskey = paramContentValues.getAsString("imBGaeskey");
      if (paramBoolean) {
        this.lax = true;
      }
    }
    if (paramContentValues.containsKey("imBGauthkey"))
    {
      this.field_imBGauthkey = paramContentValues.getAsString("imBGauthkey");
      if (paramBoolean) {
        this.lay = true;
      }
    }
    if (paramContentValues.containsKey("imBGmd5sum"))
    {
      this.field_imBGmd5sum = paramContentValues.getAsString("imBGmd5sum");
      if (paramBoolean) {
        this.laz = true;
      }
    }
    if (paramContentValues.containsKey("imBGfileid"))
    {
      this.field_imBGfileid = paramContentValues.getAsString("imBGfileid");
      if (paramBoolean) {
        this.laA = true;
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
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (userName_HASHCODE != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.__hadSetuserName = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (laB == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (laC == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (laD == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (laE == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (laF == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (laG == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (laH == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (laI == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (laJ == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (kZA == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (laK == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (laL == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (laM == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (laN == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (laO == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (laP == k) {
        this.field_albumMd5 = paramCursor.getString(i);
      } else if (laQ == k) {
        this.field_imBGaeskey = paramCursor.getString(i);
      } else if (laR == k) {
        this.field_imBGauthkey = paramCursor.getString(i);
      } else if (laS == k) {
        this.field_imBGmd5sum = paramCursor.getString(i);
      } else if (laT == k) {
        this.field_imBGfileid = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.lah) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.lai) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.laj) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.lak) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.lal) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.lam) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.lan) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.lao) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.lap) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.kZq) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.laq) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.lar) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.las) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.lau) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.lav) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.law) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.lax) {
      localContentValues.put("imBGaeskey", this.field_imBGaeskey);
    }
    if (this.lay) {
      localContentValues.put("imBGauthkey", this.field_imBGauthkey);
    }
    if (this.laz) {
      localContentValues.put("imBGmd5sum", this.field_imBGmd5sum);
    }
    if (this.laA) {
      localContentValues.put("imBGfileid", this.field_imBGfileid);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends hl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_userName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.hl
 * JD-Core Version:    0.7.0.1
 */