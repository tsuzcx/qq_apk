package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class h
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("appattach");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnA;
  public static final Column hnB;
  public static final Column hnC;
  public static final Column hnD;
  public static final Column hnE;
  public static final Column hnF;
  public static final Column hnG;
  public static final Column hnH;
  public static final Column hnI;
  public static final Column hnJ;
  public static final Column hnK;
  public static final Column hnL;
  public static final Column hnM;
  public static final Column hnN;
  public static final Column hnO;
  public static final Column hnP;
  public static final Column hnz;
  private static final int hoh;
  private static final int hoi;
  private static final int hoj;
  private static final int hok;
  private static final int hol;
  private static final int hom;
  private static final int hon;
  private static final int hoo;
  private static final int hop = "lastModifyTime".hashCode();
  private static final int hoq = "fileFullPath".hashCode();
  private static final int hor = "fullXml".hashCode();
  private static final int hos = "msgInfoId".hashCode();
  private static final int hot = "netTimes".hashCode();
  private static final int hou = "isUseCdn".hashCode();
  private static final int hov = "signature".hashCode();
  private static final int how = "fakeAeskey".hashCode();
  private static final int hox = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_clientAppDataId;
  public long field_createTime;
  public String field_fakeAeskey;
  public String field_fakeSignature;
  public String field_fileFullPath;
  public String field_fullXml;
  public boolean field_isUpload;
  public int field_isUseCdn;
  public long field_lastModifyTime;
  public String field_mediaId;
  public String field_mediaSvrId;
  public long field_msgInfoId;
  public long field_netTimes;
  public long field_offset;
  public long field_sdkVer;
  public String field_signature;
  public long field_status;
  public long field_totalLen;
  public long field_type;
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean hnR = true;
  private boolean hnS = true;
  private boolean hnT = true;
  private boolean hnU = true;
  private boolean hnV = true;
  private boolean hnW = true;
  private boolean hnX = true;
  private boolean hnY = true;
  private boolean hnZ = true;
  private boolean hoa = true;
  private boolean hob = true;
  private boolean hoc = true;
  private boolean hod = true;
  private boolean hoe = true;
  private boolean hof = true;
  private boolean hog = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "appattach", "");
    hnz = new Column("appid", "string", "appattach", "");
    hnA = new Column("sdkver", "long", "appattach", "");
    hnB = new Column("mediasvrid", "string", "appattach", "");
    hnC = new Column("mediaid", "string", "appattach", "");
    hnD = new Column("clientappdataid", "string", "appattach", "");
    C_TYPE = new Column("type", "long", "appattach", "");
    hnE = new Column("totallen", "long", "appattach", "");
    hnF = new Column("offset", "long", "appattach", "");
    hmw = new Column("status", "long", "appattach", "");
    hnG = new Column("isupload", "boolean", "appattach", "");
    C_CREATETIME = new Column("createtime", "long", "appattach", "");
    hnH = new Column("lastmodifytime", "long", "appattach", "");
    hnI = new Column("filefullpath", "string", "appattach", "");
    hnJ = new Column("fullxml", "string", "appattach", "");
    hnK = new Column("msginfoid", "long", "appattach", "");
    hnL = new Column("nettimes", "long", "appattach", "");
    hnM = new Column("isusecdn", "int", "appattach", "");
    hnN = new Column("signature", "string", "appattach", "");
    hnO = new Column("fakeaeskey", "string", "appattach", "");
    hnP = new Column("fakesignature", "string", "appattach", "");
    hoh = "appId".hashCode();
    hoi = "sdkVer".hashCode();
    hoj = "mediaSvrId".hashCode();
    hok = "mediaId".hashCode();
    hol = "clientAppDataId".hashCode();
    type_HASHCODE = "type".hashCode();
    hom = "totalLen".hashCode();
    hon = "offset".hashCode();
    hmC = "status".hashCode();
    hoo = "isUpload".hashCode();
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hoi == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (hoj == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (hok == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (hol == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (hom == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (hon == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (hoo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (createTime_HASHCODE == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (hop == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (hoq == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (hor == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (hos == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (hot == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (hou == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (hov == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (how == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (hox == k) {
          this.field_fakeSignature = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hnR) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.hnS) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.hnT) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.hnU) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.hnV) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.hnW) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.hmz) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.hnX) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hnY) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.hnZ) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.hoa) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.hob) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.hoc) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.hod) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.hoe) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.hof) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.hog) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
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
    return "appattach";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.h
 * JD-Core Version:    0.7.0.1
 */