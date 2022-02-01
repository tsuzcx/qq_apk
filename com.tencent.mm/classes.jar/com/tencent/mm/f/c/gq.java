package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SnsExt");
  public static final Column hGW;
  private static final int hIy = "md5".hashCode();
  public static final Column iyA;
  public static final Column iyB;
  public static final Column iyC;
  public static final Column iyD;
  public static final Column iyE;
  public static final Column iyF;
  public static final Column iyG;
  public static final Column iyH;
  public static final Column iyI;
  public static final Column iyJ;
  public static final Column iyK;
  public static final Column iyL;
  public static final Column iyw;
  public static final Column iyx;
  public static final Column iyy;
  public static final Column iyz;
  private static final int izc = "newerIds".hashCode();
  private static final int izd = "bgId".hashCode();
  private static final int ize = "bgUrl".hashCode();
  private static final int izf = "older_bgId".hashCode();
  private static final int izg = "local_flag".hashCode();
  private static final int izh = "istyle".hashCode();
  private static final int izi = "iFlag".hashCode();
  private static final int izj = "icount".hashCode();
  private static final int izk = "faultS".hashCode();
  private static final int izl = "snsBgId".hashCode();
  private static final int izm = "snsuser".hashCode();
  private static final int izn = "adsession".hashCode();
  private static final int izo = "lastFirstPageRequestErrCode".hashCode();
  private static final int izp = "lastFirstPageRequestErrType".hashCode();
  private static final int izq = "snsYearMonthInfo".hashCode();
  private static final int izr = "albumMd5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public byte[] field_adsession;
  public String field_albumMd5;
  public String field_bgId;
  public String field_bgUrl;
  public byte[] field_faultS;
  public int field_iFlag;
  public int field_icount;
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
  private boolean hHK = true;
  private boolean iyM = true;
  private boolean iyN = true;
  private boolean iyO = true;
  private boolean iyP = true;
  private boolean iyQ = true;
  private boolean iyR = true;
  private boolean iyS = true;
  private boolean iyT = true;
  private boolean iyU = true;
  private boolean iyV = true;
  private boolean iyW = true;
  private boolean iyX = true;
  private boolean iyY = true;
  private boolean iyZ = true;
  private boolean iza = true;
  private boolean izb = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsExt", "");
    C_USERNAME = new Column("username", "string", "SnsExt", "");
    hGW = new Column("md5", "string", "SnsExt", "");
    iyw = new Column("newerids", "string", "SnsExt", "");
    iyx = new Column("bgid", "string", "SnsExt", "");
    iyy = new Column("bgurl", "string", "SnsExt", "");
    iyz = new Column("older_bgid", "string", "SnsExt", "");
    iyA = new Column("local_flag", "int", "SnsExt", "");
    iyB = new Column("istyle", "int", "SnsExt", "");
    iyC = new Column("iflag", "int", "SnsExt", "");
    iyD = new Column("icount", "int", "SnsExt", "");
    iyE = new Column("faults", "byte[]", "SnsExt", "");
    iyF = new Column("snsbgid", "long", "SnsExt", "");
    iyG = new Column("snsuser", "byte[]", "SnsExt", "");
    iyH = new Column("adsession", "byte[]", "SnsExt", "");
    iyI = new Column("lastfirstpagerequesterrcode", "int", "SnsExt", "");
    iyJ = new Column("lastfirstpagerequesterrtype", "int", "SnsExt", "");
    iyK = new Column("snsyearmonthinfo", "byte[]", "SnsExt", "");
    iyL = new Column("albummd5", "string", "SnsExt", "");
    userName_HASHCODE = "userName".hashCode();
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
      if (hIy == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (izc == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (izd == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (ize == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (izf == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (izg == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (izh == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (izi == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (izj == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (izk == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (izl == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (izm == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (izn == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (izo == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (izp == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (izq == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (izr == k) {
        this.field_albumMd5 = paramCursor.getString(i);
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
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.iyM) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.iyN) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.iyO) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.iyP) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.iyQ) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.iyR) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.iyS) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.iyT) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.iyU) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.iyV) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.iyW) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.iyX) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.iyY) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.iyZ) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.iza) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.izb) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "SnsExt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.gq
 * JD-Core Version:    0.7.0.1
 */