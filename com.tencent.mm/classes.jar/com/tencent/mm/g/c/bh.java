package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int eAt;
  private static final int eAx;
  private static final int eBA;
  private static final int eBB;
  private static final int eBC;
  private static final int eBD;
  private static final int eBE;
  private static final int eBF = "needupload".hashCode();
  private static final int eBG = "designerID".hashCode();
  private static final int eBH = "thumbUrl".hashCode();
  private static final int eBI = "cdnUrl".hashCode();
  private static final int eBJ = "encrypturl".hashCode();
  private static final int eBK = "aeskey".hashCode();
  private static final int eBL = "width".hashCode();
  private static final int eBM = "height".hashCode();
  private static final int eBN = "externUrl".hashCode();
  private static final int eBO = "externMd5".hashCode();
  private static final int eBP = "activityid".hashCode();
  private static final int eBQ = "tpurl".hashCode();
  private static final int eBR = "tpauthkey".hashCode();
  private static final int eBS = "wxamMd5".hashCode();
  private static final int eBT = "attachedText".hashCode();
  private static final int eBU = "captureStatus".hashCode();
  private static final int eBV = "attachedEmojiMD5".hashCode();
  private static final int eBW = "imitateMd5".hashCode();
  private static final int eBX = "captureUploadErrCode".hashCode();
  private static final int eBY = "captureUploadCounter".hashCode();
  private static final int eBZ = "captureEnterTime".hashCode();
  private static final int eBr = "md5".hashCode();
  private static final int eBs = "svrid".hashCode();
  private static final int eBt = "catalog".hashCode();
  private static final int eBu;
  private static final int eBv;
  private static final int eBw;
  private static final int eBx;
  private static final int eBy;
  private static final int eBz;
  private static final int eCa = "lensId".hashCode();
  private static final int eCb = "attachTextColor".hashCode();
  private static final int eCc = "captureScene".hashCode();
  private static final int eng;
  private static final int eoH;
  private static final int epn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eAF = true;
  private boolean eAG = true;
  private boolean eAH = true;
  private boolean eAI = true;
  private boolean eAJ = true;
  private boolean eAK = true;
  private boolean eAL = true;
  private boolean eAM = true;
  private boolean eAN = true;
  private boolean eAO = true;
  private boolean eAP = true;
  private boolean eAQ = true;
  private boolean eAR = true;
  private boolean eAS = true;
  private boolean eAT = true;
  private boolean eAU = true;
  private boolean eAV = true;
  private boolean eAW = true;
  private boolean eAX = true;
  private boolean eAY = true;
  private boolean eAZ = true;
  private boolean eBa = true;
  private boolean eBb = true;
  private boolean eBc = true;
  private boolean eBd = true;
  private boolean eBe = true;
  private boolean eBf = true;
  private boolean eBg = true;
  private boolean eBh = true;
  private boolean eBi = true;
  private boolean eBj = true;
  private boolean eBk = true;
  private boolean eBl = true;
  private boolean eBm = true;
  private boolean eBn = true;
  private boolean eBo = true;
  private boolean eBp = true;
  private boolean eBq = true;
  private boolean emI = true;
  private boolean eoF = true;
  private boolean epi = true;
  private boolean ezT = true;
  private boolean ezX = true;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public String field_attachTextColor;
  public byte[] field_attachedEmojiMD5;
  public String field_attachedText;
  public long field_captureEnterTime;
  public int field_captureScene;
  public int field_captureStatus;
  public int field_captureUploadCounter;
  public int field_captureUploadErrCode;
  public int field_catalog;
  public String field_cdnUrl;
  public String field_content;
  public String field_designerID;
  public String field_encrypturl;
  public String field_externMd5;
  public String field_externUrl;
  public String field_framesInfo;
  public String field_groupId;
  public int field_height;
  public int field_idx;
  public String field_imitateMd5;
  public long field_lastUseTime;
  public String field_lensId;
  public String field_md5;
  public String field_name;
  public int field_needupload;
  public String field_reserved1;
  public String field_reserved2;
  public int field_reserved3;
  public int field_reserved4;
  public int field_size;
  public int field_source;
  public int field_start;
  public int field_state;
  public String field_svrid;
  public int field_temp;
  public String field_thumbUrl;
  public String field_tpauthkey;
  public String field_tpurl;
  public int field_type;
  public int field_width;
  public String field_wxamMd5;
  
  static
  {
    eoH = "size".hashCode();
    eBu = "start".hashCode();
    eBv = "state".hashCode();
    eBw = "name".hashCode();
    eng = "content".hashCode();
    eBx = "reserved1".hashCode();
    eBy = "reserved2".hashCode();
    eBz = "reserved3".hashCode();
    eBA = "reserved4".hashCode();
    eBB = "app_id".hashCode();
    eBC = "groupId".hashCode();
    eAt = "lastUseTime".hashCode();
    eBD = "framesInfo".hashCode();
    eAx = "idx".hashCode();
    eBE = "temp".hashCode();
    epn = "source".hashCode();
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
      if (eBr != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.eAF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBs == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (eBt == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eoH == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (eBu == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eBw == k) {
        this.field_name = paramCursor.getString(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eBx == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eBy == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eBz == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (eBA == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (eBB == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (eBC == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eAt == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eBD == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (eAx == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eBE == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (epn == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (eBF == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (eBG == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (eBH == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (eBI == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eBJ == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (eBK == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (eBL == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (eBM == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eBN == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (eBO == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (eBP == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (eBQ == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (eBR == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (eBS == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (eBT == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (eBU == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (eBV == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (eBW == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (eBX == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (eBY == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (eBZ == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (eCa == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (eCb == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (eCc == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eAG) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.eAH) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eoF) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.eAI) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eAK) {
      localContentValues.put("name", this.field_name);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eAL) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eAM) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eAN) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.eAO) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.eAP) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eAQ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.ezT) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.eAR) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.ezX) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eAS) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.epi) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.eAT) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.eAU) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.eAV) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eAW) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eAX) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.eAY) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.eAZ) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eBa) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eBb) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.eBc) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.eBd) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.eBe) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.eBf) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eBg) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.eBh) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.eBi) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.eBj) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.eBk) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.eBl) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.eBm) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.eBn) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.eBo) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.eBp) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.eBq) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bh
 * JD-Core Version:    0.7.0.1
 */