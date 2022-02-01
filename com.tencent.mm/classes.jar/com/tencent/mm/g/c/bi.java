package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int eEm;
  private static final int eFM;
  private static final int eGw;
  private static final int eRR;
  private static final int eRV;
  private static final int eSP = "md5".hashCode();
  private static final int eSQ = "svrid".hashCode();
  private static final int eSR = "catalog".hashCode();
  private static final int eSS;
  private static final int eST;
  private static final int eSU;
  private static final int eSV;
  private static final int eSW;
  private static final int eSX;
  private static final int eSY;
  private static final int eSZ;
  private static final int eTA = "captureScene".hashCode();
  private static final int eTa;
  private static final int eTb;
  private static final int eTc;
  private static final int eTd;
  private static final int eTe;
  private static final int eTf;
  private static final int eTg;
  private static final int eTh;
  private static final int eTi;
  private static final int eTj;
  private static final int eTk;
  private static final int eTl;
  private static final int eTm;
  private static final int eTn;
  private static final int eTo;
  private static final int eTp;
  private static final int eTq;
  private static final int eTr;
  private static final int eTs;
  private static final int eTt;
  private static final int eTu;
  private static final int eTv;
  private static final int eTw;
  private static final int eTx;
  private static final int eTy;
  private static final int eTz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eDP = true;
  private boolean eFK = true;
  private boolean eGr = true;
  private boolean eRr = true;
  private boolean eRv = true;
  private boolean eSA = true;
  private boolean eSB = true;
  private boolean eSC = true;
  private boolean eSD = true;
  private boolean eSE = true;
  private boolean eSF = true;
  private boolean eSG = true;
  private boolean eSH = true;
  private boolean eSI = true;
  private boolean eSJ = true;
  private boolean eSK = true;
  private boolean eSL = true;
  private boolean eSM = true;
  private boolean eSN = true;
  private boolean eSO = true;
  private boolean eSd = true;
  private boolean eSe = true;
  private boolean eSf = true;
  private boolean eSg = true;
  private boolean eSh = true;
  private boolean eSi = true;
  private boolean eSj = true;
  private boolean eSk = true;
  private boolean eSl = true;
  private boolean eSm = true;
  private boolean eSn = true;
  private boolean eSo = true;
  private boolean eSp = true;
  private boolean eSq = true;
  private boolean eSr = true;
  private boolean eSs = true;
  private boolean eSt = true;
  private boolean eSu = true;
  private boolean eSv = true;
  private boolean eSw = true;
  private boolean eSx = true;
  private boolean eSy = true;
  private boolean eSz = true;
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
    eFM = "size".hashCode();
    eSS = "start".hashCode();
    eST = "state".hashCode();
    eSU = "name".hashCode();
    eEm = "content".hashCode();
    eSV = "reserved1".hashCode();
    eSW = "reserved2".hashCode();
    eSX = "reserved3".hashCode();
    eSY = "reserved4".hashCode();
    eSZ = "app_id".hashCode();
    eTa = "groupId".hashCode();
    eRR = "lastUseTime".hashCode();
    eTb = "framesInfo".hashCode();
    eRV = "idx".hashCode();
    eTc = "temp".hashCode();
    eGw = "source".hashCode();
    eTd = "needupload".hashCode();
    eTe = "designerID".hashCode();
    eTf = "thumbUrl".hashCode();
    eTg = "cdnUrl".hashCode();
    eTh = "encrypturl".hashCode();
    eTi = "aeskey".hashCode();
    eTj = "width".hashCode();
    eTk = "height".hashCode();
    eTl = "externUrl".hashCode();
    eTm = "externMd5".hashCode();
    eTn = "activityid".hashCode();
    eTo = "tpurl".hashCode();
    eTp = "tpauthkey".hashCode();
    eTq = "wxamMd5".hashCode();
    eTr = "attachedText".hashCode();
    eTs = "captureStatus".hashCode();
    eTt = "attachedEmojiMD5".hashCode();
    eTu = "imitateMd5".hashCode();
    eTv = "captureUploadErrCode".hashCode();
    eTw = "captureUploadCounter".hashCode();
    eTx = "captureEnterTime".hashCode();
    eTy = "lensId".hashCode();
    eTz = "attachTextColor".hashCode();
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
      if (eSP != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.eSd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSQ == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (eSR == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eFM == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (eSS == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eSU == k) {
        this.field_name = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eSV == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eSW == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eSX == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (eSY == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (eSZ == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (eTa == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eRR == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eTb == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (eRV == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eTc == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (eGw == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (eTd == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (eTe == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (eTf == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (eTg == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eTh == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (eTi == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (eTj == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (eTk == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eTl == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (eTm == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (eTn == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (eTo == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (eTp == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (eTq == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (eTr == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (eTs == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (eTt == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (eTu == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (eTv == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (eTw == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (eTx == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (eTy == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (eTz == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (eTA == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eSe) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.eSf) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eFK) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.eSg) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eSi) {
      localContentValues.put("name", this.field_name);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eSj) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eSk) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eSl) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.eSm) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.eSn) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eSo) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eRr) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.eSp) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.eRv) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eSq) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.eGr) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.eSr) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.eSs) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.eSt) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eSu) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eSv) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.eSw) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.eSx) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eSy) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eSz) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.eSA) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.eSB) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.eSC) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.eSD) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eSE) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.eSF) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.eSG) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.eSH) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.eSI) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.eSJ) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.eSK) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.eSL) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.eSM) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.eSN) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.eSO) {
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
 * Qualified Name:     com.tencent.mm.g.c.bi
 * JD-Core Version:    0.7.0.1
 */