package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bi
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjl;
  private static final int fni = "flag".hashCode();
  private static final int fwT = "productID".hashCode();
  private static final int fwU = "packIconUrl".hashCode();
  private static final int fwV = "packGrayIconUrl".hashCode();
  private static final int fwW = "packCoverUrl".hashCode();
  private static final int fwX = "packName".hashCode();
  private static final int fwY = "packDesc".hashCode();
  private static final int fwZ = "packAuthInfo".hashCode();
  private static final int fxa = "packPrice".hashCode();
  private static final int fxb = "packType".hashCode();
  private static final int fxc = "packFlag".hashCode();
  private static final int fxd = "packExpire".hashCode();
  private static final int fxe = "packTimeStamp".hashCode();
  private static final int fxf = "packCopyright".hashCode();
  private static final int fxg;
  private static final int fxh;
  private static final int fxi;
  private static final int fxj = "recommand".hashCode();
  private static final int fxk = "sync".hashCode();
  private static final int fxl = "idx".hashCode();
  private static final int fxm = "BigIconUrl".hashCode();
  private static final int fxn = "MutiLanName".hashCode();
  private static final int fxo = "recommandType".hashCode();
  private static final int fxp = "lang".hashCode();
  private static final int fxq = "recommandWord".hashCode();
  private static final int fxr = "buttonType".hashCode();
  private static final int fxs = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
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
  private boolean fji = true;
  private boolean fng = true;
  private boolean fwA = true;
  private boolean fwB = true;
  private boolean fwC = true;
  private boolean fwD = true;
  private boolean fwE = true;
  private boolean fwF = true;
  private boolean fwG = true;
  private boolean fwH = true;
  private boolean fwI = true;
  private boolean fwJ = true;
  private boolean fwK = true;
  private boolean fwL = true;
  private boolean fwM = true;
  private boolean fwN = true;
  private boolean fwO = true;
  private boolean fwP = true;
  private boolean fwQ = true;
  private boolean fwR = true;
  private boolean fwS = true;
  private boolean fwt = true;
  private boolean fwu = true;
  private boolean fwv = true;
  private boolean fww = true;
  private boolean fwx = true;
  private boolean fwy = true;
  private boolean fwz = true;
  
  static
  {
    fjl = "status".hashCode();
    fxg = "sort".hashCode();
    fxh = "lastUseTime".hashCode();
    fxi = "packStatus".hashCode();
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
      if (fwT != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.fwt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fwU == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (fwV == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (fwW == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (fwX == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (fwY == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (fwZ == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (fxa == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (fxb == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (fxc == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (fxd == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (fxe == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (fxf == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fxg == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (fxh == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (fxi == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fxj == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (fxk == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (fxl == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (fxm == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (fxn == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (fxo == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (fxp == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (fxq == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (fxr == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (fxs == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fwt) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.fwu) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.fwv) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.fww) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.fwx) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.fwy) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.fwz) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.fwA) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.fwB) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.fwC) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.fwD) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.fwE) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.fwF) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fwG) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.fwH) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.fwI) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fwJ) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.fwK) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.fwL) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.fwM) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.fwN) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.fwO) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.fwP) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.fwQ) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.fwR) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.fwS) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.bi
 * JD-Core Version:    0.7.0.1
 */