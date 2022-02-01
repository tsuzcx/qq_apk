package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bi
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmojiGroupInfo");
  public static final Column hFA;
  public static final Column hFB;
  public static final Column hFC;
  public static final Column hFD;
  public static final Column hFE;
  public static final Column hFF;
  public static final Column hFG;
  public static final Column hFH;
  public static final Column hFI;
  public static final Column hFJ;
  public static final Column hFK;
  public static final Column hFL;
  public static final Column hFM;
  public static final Column hFN;
  public static final Column hFO;
  public static final Column hFP;
  public static final Column hFQ;
  public static final Column hFR;
  public static final Column hFS;
  public static final Column hFT;
  public static final Column hFU;
  public static final Column hFV;
  public static final Column hFp;
  public static final Column hFx;
  public static final Column hFy;
  public static final Column hFz;
  private static final int hGA;
  private static final int hGB;
  private static final int hGC;
  private static final int hGD;
  private static final int hGE;
  private static final int hGF;
  private static final int hGG;
  private static final int hGH;
  private static final int hGI;
  private static final int hGJ;
  private static final int hGK;
  private static final int hGL;
  private static final int hGM = "recommand".hashCode();
  private static final int hGN = "sync".hashCode();
  private static final int hGO = "idx".hashCode();
  private static final int hGP = "BigIconUrl".hashCode();
  private static final int hGQ = "MutiLanName".hashCode();
  private static final int hGR = "recommandType".hashCode();
  private static final int hGS = "lang".hashCode();
  private static final int hGT = "recommandWord".hashCode();
  private static final int hGU = "buttonType".hashCode();
  private static final int hGV = "count".hashCode();
  private static final int hGw;
  private static final int hGx;
  private static final int hGy;
  private static final int hGz;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hsi;
  private static final int hsm;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_BigIconUrl;
  public String field_MutiLanName;
  public int field_buttonType;
  public int field_count;
  public int field_flag;
  public int field_idx;
  public String field_lang;
  public long field_lastUseTime;
  public String field_packAuthInfo;
  public String field_packCopyright;
  public String field_packCoverUrl;
  public String field_packDesc;
  public long field_packExpire;
  public int field_packFlag;
  public String field_packGrayIconUrl;
  public String field_packIconUrl;
  public String field_packName;
  public String field_packPrice;
  public int field_packStatus;
  public long field_packTimeStamp;
  public int field_packType;
  public String field_productID;
  public int field_recommand;
  public int field_recommandType;
  public String field_recommandWord;
  public int field_sort;
  public int field_status;
  public int field_sync;
  public int field_type;
  private boolean hFW = true;
  private boolean hFX = true;
  private boolean hFY = true;
  private boolean hFZ = true;
  private boolean hGa = true;
  private boolean hGb = true;
  private boolean hGc = true;
  private boolean hGd = true;
  private boolean hGe = true;
  private boolean hGf = true;
  private boolean hGg = true;
  private boolean hGh = true;
  private boolean hGi = true;
  private boolean hGj = true;
  private boolean hGk = true;
  private boolean hGl = true;
  private boolean hGm = true;
  private boolean hGn = true;
  private boolean hGo = true;
  private boolean hGp = true;
  private boolean hGq = true;
  private boolean hGr = true;
  private boolean hGs = true;
  private boolean hGt = true;
  private boolean hGu = true;
  private boolean hGv = true;
  private boolean hmz = true;
  private boolean hsk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmojiGroupInfo", "");
    hFp = new Column("productid", "string", "EmojiGroupInfo", "");
    hFx = new Column("packiconurl", "string", "EmojiGroupInfo", "");
    hFy = new Column("packgrayiconurl", "string", "EmojiGroupInfo", "");
    hFz = new Column("packcoverurl", "string", "EmojiGroupInfo", "");
    hFA = new Column("packname", "string", "EmojiGroupInfo", "");
    hFB = new Column("packdesc", "string", "EmojiGroupInfo", "");
    hFC = new Column("packauthinfo", "string", "EmojiGroupInfo", "");
    hFD = new Column("packprice", "string", "EmojiGroupInfo", "");
    hFE = new Column("packtype", "int", "EmojiGroupInfo", "");
    hFF = new Column("packflag", "int", "EmojiGroupInfo", "");
    hFG = new Column("packexpire", "long", "EmojiGroupInfo", "");
    hFH = new Column("packtimestamp", "long", "EmojiGroupInfo", "");
    hFI = new Column("packcopyright", "string", "EmojiGroupInfo", "");
    C_TYPE = new Column("type", "int", "EmojiGroupInfo", "");
    hmw = new Column("status", "int", "EmojiGroupInfo", "");
    hFJ = new Column("sort", "int", "EmojiGroupInfo", "");
    hFK = new Column("lastusetime", "long", "EmojiGroupInfo", "");
    hFL = new Column("packstatus", "int", "EmojiGroupInfo", "");
    hsi = new Column("flag", "int", "EmojiGroupInfo", "");
    hFM = new Column("recommand", "int", "EmojiGroupInfo", "");
    hFN = new Column("sync", "int", "EmojiGroupInfo", "");
    hFO = new Column("idx", "int", "EmojiGroupInfo", "");
    hFP = new Column("bigiconurl", "string", "EmojiGroupInfo", "");
    hFQ = new Column("mutilanname", "string", "EmojiGroupInfo", "");
    hFR = new Column("recommandtype", "int", "EmojiGroupInfo", "");
    hFS = new Column("lang", "string", "EmojiGroupInfo", "");
    hFT = new Column("recommandword", "string", "EmojiGroupInfo", "");
    hFU = new Column("buttontype", "int", "EmojiGroupInfo", "");
    hFV = new Column("count", "int", "EmojiGroupInfo", "");
    hGw = "productID".hashCode();
    hGx = "packIconUrl".hashCode();
    hGy = "packGrayIconUrl".hashCode();
    hGz = "packCoverUrl".hashCode();
    hGA = "packName".hashCode();
    hGB = "packDesc".hashCode();
    hGC = "packAuthInfo".hashCode();
    hGD = "packPrice".hashCode();
    hGE = "packType".hashCode();
    hGF = "packFlag".hashCode();
    hGG = "packExpire".hashCode();
    hGH = "packTimeStamp".hashCode();
    hGI = "packCopyright".hashCode();
    type_HASHCODE = "type".hashCode();
    hmC = "status".hashCode();
    hGJ = "sort".hashCode();
    hGK = "lastUseTime".hashCode();
    hGL = "packStatus".hashCode();
    hsm = "flag".hashCode();
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
      if (hGw != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.hFW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hGx == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (hGy == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (hGz == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (hGA == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (hGB == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (hGC == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (hGD == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (hGE == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (hGF == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (hGG == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (hGH == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (hGI == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (hGJ == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (hGK == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (hGL == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (hGM == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (hGN == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (hGO == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (hGP == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (hGQ == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (hGR == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (hGS == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (hGT == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (hGU == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (hGV == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hFW) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.hFX) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.hFY) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.hFZ) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.hGa) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.hGb) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.hGc) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.hGd) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.hGe) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.hGf) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.hGg) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.hGh) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.hGi) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hGj) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.hGk) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.hGl) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.hGm) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.hGn) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.hGo) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.hGp) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.hGq) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.hGr) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.hGs) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.hGt) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.hGu) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.hGv) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
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
    return "EmojiGroupInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.bi
 * JD-Core Version:    0.7.0.1
 */